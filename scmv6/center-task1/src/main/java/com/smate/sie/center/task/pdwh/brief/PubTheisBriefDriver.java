package com.smate.sie.center.task.pdwh.brief;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.smate.center.task.single.enums.pub.PublicationEnterFormEnum;
import com.smate.core.base.pub.enums.PublicationTypeEnum;
import com.smate.sie.center.task.pdwh.task.PubXmlDocument;
import com.smate.sie.center.task.pdwh.task.PubXmlProcessContext;
import com.smate.sie.center.task.pdwh.utils.BriefUtilis;

/** @author yamingd 学位论文Brief生成驱动. */
public class PubTheisBriefDriver implements IBriefDriver {

  /** 字段. */
  private static final List<String> FIELDS = new ArrayList<String>();
  static {
    FIELDS.add("/pub_thesis/@department");
    FIELDS.add("/pub_thesis/@programme_name");
    FIELDS.add("/pub_thesis/@issue_org");
    FIELDS.add("/publication/@publish_year");
    FIELDS.add("/publication/@publish_month");
    FIELDS.add("/publication/@publish_day");
  }

  /** 格式化Pattern. */
  private final String pattern =
      "<out>${department}</out><out>, ${programme_name}</out><out>, ${issue_org}</out><date>, ${publish_date}</date><out></out>";

  @Override
  public Map<String, String> getData(Locale locale, PubXmlDocument xmlDocument, PubXmlProcessContext context)
      throws Exception {

    Map<String, String> datas = BriefUtilis.getFieldsData(FIELDS, xmlDocument);

    String year = datas.get(FIELDS.get(3));
    String month = datas.get(FIELDS.get(4));
    String day = datas.get(FIELDS.get(5));
    String publishDate = BriefUtilis.getStandardDateString(year, month, day);
    datas.put("publish_date", publishDate);

    datas = BriefUtilis.normalizeData(datas);

    return datas;
  }

  @Override
  public String getForTmplForm() {

    return PublicationEnterFormEnum.SCHOLAR;
  }

  @Override
  public int getForType() {
    return PublicationTypeEnum.THESIS;
  }

  @Override
  public String getPattern() {

    return this.pattern;
  }

}
