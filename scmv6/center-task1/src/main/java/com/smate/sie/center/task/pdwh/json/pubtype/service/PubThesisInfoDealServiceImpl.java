package com.smate.sie.center.task.pdwh.json.pubtype.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.LocaleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.smate.center.task.single.enums.pub.PublicationEnterFormEnum;
import com.smate.core.base.pub.enums.PublicationTypeEnum;
import com.smate.core.base.utils.dao.consts.Sie6ConstDictionaryDao;
import com.smate.core.base.utils.exception.SysServiceException;
import com.smate.core.base.utils.json.JacksonUtils;
import com.smate.core.base.utils.string.StringUtils;
import com.smate.sie.center.task.pdwh.brief.BriefDriverFactory;
import com.smate.sie.center.task.pdwh.brief.IBriefDriver;
import com.smate.sie.center.task.pdwh.json.service.process.PubHandlerProcessService;
import com.smate.sie.core.base.utils.date.DateUtils;
import com.smate.sie.core.base.utils.json.pub.BriefFormatter;
import com.smate.sie.core.base.utils.pub.dom.PubTypeInfoBean;
import com.smate.sie.core.base.utils.pub.dom.ThesisInfoBean;
import com.smate.sie.core.base.utils.pub.exception.PubHandlerProcessException;
import com.smate.sie.core.base.utils.pub.service.PubJsonDTO;

/**
 * 学位论文 构建成果详情的类别对象
 * 
 * @author ZSJ
 *
 * @date 2019年1月31日
 */
@Transactional(rollbackFor = Exception.class)
public class PubThesisInfoDealServiceImpl implements PubHandlerProcessService {

  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private BriefDriverFactory briefDriverFactory;
  @Autowired
  private Sie6ConstDictionaryDao sie6ConstDictionaryDao;

  private Map<String, String> buildData(PubJsonDTO pub) {
    ThesisInfoBean a = (ThesisInfoBean) pub.pubTypeInfoBean;
    Map<String, String> map = new HashMap<String, String>();
    if (a != null) {
      map.put("department".toUpperCase(), a.getDepartment());
      map.put("programme_name".toUpperCase(), a.getDegreeName());
      map.put("issue_org".toUpperCase(), a.getIssuingAuthority());
      if (StringUtils.isNotEmpty(pub.publishDate)) {
        String[] dates = DateUtils.splitToYearMothDayByStrUseToSie(pub.publishDate);
        map.put("publish_date".toUpperCase(), DateUtils.parseDate(dates[0], dates[1], dates[2], "-"));
      }
    }
    return map;
  }

  @Override
  public void checkSourcesParameter(PubJsonDTO pub) throws PubHandlerProcessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void checkRebuildParameter(PubJsonDTO pub) throws PubHandlerProcessException {
    // TODO Auto-generated method stub

  }

  @Override
  public Map<String, Object> excute(PubJsonDTO pub) throws PubHandlerProcessException {
    Map<String, Object> resultMap = new HashMap<String, Object>();
    if (pub.pubTypeCode.intValue() == PublicationTypeEnum.THESIS) {
      try {
        pub.pubTypeInfoBean = constructParams(pub);
        pub.pubTypeName = "学位论文";
      } catch (Exception e) {
        logger.error("构建会学位论文类别对象失败，pubTypeInfo={}", pub.pubTypeInfo, e);
        throw new PubHandlerProcessException(this.getClass().getSimpleName() + "构建学位论文类别对象失败！", e);
      }
      // 文件导入，在预览页面就已经构造好来源，故这里做个判断，避免重复工作，
      if (!pub.isImport) {
        try {
          Map<String, String> result = buildData(pub);
          IBriefDriver briefDriver = briefDriverFactory.getDriver(PublicationEnterFormEnum.SCHOLAR, pub.pubTypeCode);
          String pattern = briefDriver.getPattern();
          BriefFormatter formatter = new BriefFormatter(LocaleUtils.toLocale("zh_CN"), result);
          String briefDesc = formatter.format(pattern);
          pub.briefDesc = briefDesc;
        } catch (Exception e) {
          logger.error("学位论文构建briefDesc参数失败，pubTypeInfo={}", pub.pubTypeInfo, e);
          throw new PubHandlerProcessException(this.getClass().getSimpleName() + "学位论文构建briefDesc参数失败！", e);
        }
      }
    }
    return resultMap;
  }

  private PubTypeInfoBean constructParams(PubJsonDTO pub) throws SysServiceException {
    ThesisInfoBean a = JacksonUtils.jsonObject(pub.pubTypeInfo.toJSONString(), ThesisInfoBean.class);
    if (a != null) {
      a.setDepartment(StringUtils.substring(a.getDepartment(), 0, 20));
      a.setIssuingAuthority(StringUtils.substring(a.getIssuingAuthority(), 0, 200));
      if (StringUtils.isNotBlank(a.getDegreeCode())) {
        String degreeName =
            sie6ConstDictionaryDao.findZhNameByCategoryAndCode("pub_thesis_programme", a.getDegreeCode());
        a.setDegreeName(degreeName);
        a.setDefenseDate(pub.publishDate);
      }
    }
    return a;
  }

  @Override
  public Integer getPubType() {
    return PublicationTypeEnum.THESIS;
  }

}
