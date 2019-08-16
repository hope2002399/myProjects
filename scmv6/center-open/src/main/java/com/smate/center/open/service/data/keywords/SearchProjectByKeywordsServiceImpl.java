package com.smate.center.open.service.data.keywords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;

import com.smate.center.open.consts.OpenConsts;
import com.smate.center.open.consts.OpenMsgCodeConsts;
import com.smate.center.open.service.data.ThirdDataTypeBase;
import com.smate.core.base.solr.model.QueryFields;
import com.smate.core.base.solr.service.SolrIndexSerivceImpl;
import com.smate.core.base.solr.service.SolrIndexService;
import com.smate.core.base.utils.constant.KeywordConstants;
import com.smate.core.base.utils.json.JacksonUtils;

public class SearchProjectByKeywordsServiceImpl extends ThirdDataTypeBase {
  @Autowired
  private SolrIndexService solrIndexService;

  @Override
  public Map<String, Object> doVerify(Map<String, Object> parameter) {
    Map<String, Object> temp = new HashMap<String, Object>();

    Object data = parameter.get(OpenConsts.MAP_DATA);
    if (data != null && data.toString().length() > 0) {
      Map<String, Object> dataMap = JacksonUtils.jsonToMap(data.toString());
      if (dataMap != null) {
        parameter.putAll(dataMap);
      }
    }
    if (parameter.get(KeywordConstants.KEYWORDS) == null) {
      logger.error("根据关键词检索项目，关键词列表 keywordList 不能为空 ");
      temp = super.errorMap(OpenMsgCodeConsts.SCM_799, parameter, "SCM_799  根据关键词检索项目，关键词列表 keywordList 不能为空 ");
      return temp;
    } else if (StringUtils.isBlank(parameter.get(KeywordConstants.KEYWORDS).toString())) {
      logger.error("根据关键词检索项目，关键词列表 keywordList 不能为空 ");
      temp = super.errorMap(OpenMsgCodeConsts.SCM_799, parameter, "SCM_799  根据关键词检索项目，关键词列表 keywordList 不能为空 ");
      return temp;
    }
    if (parameter.get(KeywordConstants.START_YEAR) == null) {
      logger.error("根据关键词检索项目，分析周期开始年份 startYear 不能为空 ");
      temp =
          super.errorMap(OpenMsgCodeConsts.SCM_797, parameter, "SCM_797  根据关键词检索项目，服务参数     分析周期开始年份 startYear不能为空 ");
      return temp;
    } else if (StringUtils.isBlank(parameter.get(KeywordConstants.START_YEAR).toString())) {
      logger.error("根据关键词检索项目 ，分析周期开始年份 startYear 不能为空 ");
      temp =
          super.errorMap(OpenMsgCodeConsts.SCM_797, parameter, "SCM_797  根据关键词检索项目 ，服务参数     分析周期开始年份 startYear不能为空 ");
      return temp;
    } else if (!NumberUtils.isNumber(parameter.get(KeywordConstants.START_YEAR).toString())) {
      logger.error("根据关键词检索项目 ，分析周期开始年份 startYear格式不对 ");
      temp =
          super.errorMap(OpenMsgCodeConsts.SCM_800, parameter, "SCM_800  根据关键词检索项目 ，服务参数     分析周期开始年份 startYear格式不对");
      return temp;
    }
    if (parameter.get(KeywordConstants.END_YEAR) == null) {
      logger.error("根据关键词检索项目 ，分析周期结束年份 endyear 不能为空 ");
      temp = super.errorMap(OpenMsgCodeConsts.SCM_798, parameter, "SCM_798 根据关键词检索项目 ，服务参数    分析周期结束年份 endyear不能为空 ");
      return temp;
    } else if (StringUtils.isBlank(parameter.get(KeywordConstants.END_YEAR).toString())) {
      logger.error("根据关键词检索项目 ，分析周期结束年份 endyear 不能为空 ");
      temp = super.errorMap(OpenMsgCodeConsts.SCM_798, parameter, "SCM_798 根据关键词检索项目 ，服务参数    分析周期结束年份 endyear不能为空 ");
      return temp;
    } else if (!NumberUtils.isNumber(parameter.get(KeywordConstants.END_YEAR).toString())) {
      logger.error("根据关键词检索项目 ，分析周期结束年份 endyear格式不对 ");
      temp = super.errorMap(OpenMsgCodeConsts.SCM_801, parameter, "SCM_801  根据关键词检索项目 ，服务参数     分析周期结束年份 endyear格式不对");
      return temp;
    }
    Integer startYear = Integer.parseInt(parameter.get(KeywordConstants.START_YEAR).toString());
    Integer endYear = Integer.parseInt(parameter.get(KeywordConstants.END_YEAR).toString());
    if (startYear < 1900) {
      logger.error("根据关键词检索项目 ，分析周期开始年份不在有效范围内，最小1900年");
      temp = super.errorMap(OpenMsgCodeConsts.SCM_803, parameter, "SCM_803  根据关键词检索项目 ，分析周期开始年份不在有效范围内，最小1900年");
      return temp;
    }
    if (startYear > endYear) {
      logger.error("根据关键词检索项目 ，分析周期结束年份必须大于开始年份 ");
      temp = super.errorMap(OpenMsgCodeConsts.SCM_802, parameter, "SCM_802  根据关键词检索项目 ，服务参数    分析周期结束年份必须大于开始年份");
      return temp;
    }
    temp.put(OpenConsts.RESULT_STATUS, OpenConsts.RESULT_STATUS_SUCCESS);
    return temp;
  }

  @Override
  public Map<String, Object> doHandler(Map<String, Object> parameter) {
    Map<String, Object> temp = new HashMap<String, Object>();
    List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
    QueryFields queryFields = new QueryFields();
    String keywords = "\"" + parameter.get(KeywordConstants.KEYWORDS).toString().replaceAll("^;+", "")
        .replaceAll(";+$", "").replaceAll(";", "\"\"") + "\"";
    Integer startYear = Integer.parseInt(parameter.get(KeywordConstants.START_YEAR).toString());
    Integer endYear = Integer.parseInt(parameter.get(KeywordConstants.END_YEAR).toString());
    String years = DealYearUtils.dealYears(startYear, endYear);
    queryFields.setYears(years);
    queryFields.setSearchString(keywords);
    try {
      Map<String, Object> solrMap = solrIndexService.queryProject(1, 3, queryFields);
      fillProjectData(solrMap, dataList);
    } catch (SolrServerException e) {
      logger.error("根据关键词检索项目数据出错", e);
      return errorMap("根据关键词检索项目数据出错", parameter, e.toString());

    }
    return successMap("根据关键词检索项目数据成功", dataList);
  }

  private void fillProjectData(Map<String, Object> solrMap, List<Map<String, Object>> dataList) {
    String items = (String) solrMap.get(SolrIndexSerivceImpl.RESULT_ITEMS);
    boolean flag = JacksonUtils.isJsonString(items);
    if (flag) {
      List<Map<String, Object>> itemsList = JacksonUtils.jsonToList(items);
      if (itemsList != null && itemsList.size() > 0) {
        for (Map<String, Object> map : itemsList) {
          Map<String, Object> dataMap = new HashMap<String, Object>();
          if (map.get("jxPrpCode") != null && NumberUtils.isNumber(map.get("jxPrpCode").toString())) {
            dataMap.put("jxPrpCode", NumberUtils.toLong(map.get("jxPrpCode").toString()));
          }
          if (map.get("jxZhTitle") != null) {
            dataMap.put("jxZhTitle", map.get("jxZhTitle").toString());
          } else {
            dataMap.put("jxZhTitle", "");
          }
          if (map.get("jxPrpNo") != null) {
            dataMap.put("jxPrpNo", map.get("jxPrpNo").toString());
          } else {
            dataMap.put("jxPrpNo", "");
          }
          if (map.get("jxPsnName") != null) {
            dataMap.put("jxPsnName", map.get("jxPsnName").toString());
          } else {
            dataMap.put("jxPsnName", "");
          }
          if (map.get("jxOrgName") != null) {
            dataMap.put("jxOrgName", map.get("jxOrgName").toString());
          } else {
            dataMap.put("jxOrgName", "");
          }
          if (map.get("grantName") != null) {
            dataMap.put("grantName", map.get("grantName").toString());
          } else {
            dataMap.put("grantName", "");
          }
          if (map.get("jxStatYear") != null) {
            dataMap.put("jxStatYear", map.get("jxStatYear").toString());
          } else {
            dataMap.put("jxStatYear", "");
          }
          if (map.get("jxReqAmt") != null) {
            dataMap.put("jxReqAmt", map.get("jxReqAmt").toString());
          } else {
            dataMap.put("jxReqAmt", "");
          }
          if (map.get("jxProvinceId") != null) {
            dataMap.put("jxProvinceId", map.get("jxProvinceId").toString());
          } else {
            dataMap.put("jxProvinceId", "");
          }
          dataList.add(dataMap);
        }
      }
    }

  }

}
