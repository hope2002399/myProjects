package com.smate.center.batch.service.pub;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smate.center.batch.dao.sns.pub.PublicationListDao;
import com.smate.center.batch.exception.pub.ServiceException;
import com.smate.center.batch.model.sns.pub.PublicationList;
import com.smate.center.batch.oldXml.pub.PubXmlDocument;
import com.smate.core.base.utils.constant.PubXmlConstants;

/**
 * 成果收录情况.
 * 
 * @author LY
 * 
 */
@Service("publicationListService")
@Transactional(rollbackFor = Exception.class)
public class PublicationListServiceImpl implements PublicationListService {

  @Autowired
  private PublicationListDao publicationListDao;

  @Override
  public PublicationList getPublicationList(Long pubId) throws ServiceException {

    return this.publicationListDao.get(pubId);
  }

  @Override
  public void savePublictionList(PublicationList pubList) throws ServiceException {
    this.publicationListDao.save(pubList);
  }

  @Override
  public PublicationList elementConvertPubList(Element node) throws ServiceException {
    if (node == null) {
      return null;
    }
    String listEi = node.attributeValue("list_ei");
    String listSci = node.attributeValue("list_sci");
    String listIstp = node.attributeValue("list_istp");
    String listSsci = node.attributeValue("list_ssci");
    PublicationList pubList = new PublicationList();
    pubList.setListEi(NumberUtils.toInt(listEi));
    pubList.setListIstp(NumberUtils.toInt(listIstp));
    pubList.setListSci(NumberUtils.toInt(listSci));
    pubList.setListSsci(NumberUtils.toInt(listSsci));
    return pubList;
  }

  @Override
  public void saveOrUpdatePublictionList(PublicationList argsPubList) throws ServiceException {
    if (argsPubList.getId() == null) {
      throw new ServiceException("成果ID不能为空");
    }
    PublicationList pubList = this.getPublicationList(argsPubList.getId());
    if (pubList == null) {
      this.publicationListDao.save(argsPubList);
    } else {
      pubList.setListEi(argsPubList.getListEi());
      pubList.setListSci(argsPubList.getListSci());
      pubList.setListIstp(argsPubList.getListIstp());
      pubList.setListSsci(argsPubList.getListSsci());
      this.publicationListDao.save(pubList);
    }
  }

  @Override
  public PublicationList wrapPublicationList(String[] pubLists, String[] pubListsSource) {
    if (pubLists == null || pubLists.length < 1) {
      return null;
    }
    PublicationList publicationList = new PublicationList();

    for (String pubList : pubLists) {
      if ("SCI".equalsIgnoreCase(pubList)) {
        publicationList.setListSci(1);
      }
      if ("ISTP".equalsIgnoreCase(pubList)) {
        publicationList.setListIstp(1);
      }
      if ("SSCI".equalsIgnoreCase(pubList)) {
        publicationList.setListSsci(1);
      }
      if ("EI".equalsIgnoreCase(pubList)) {
        publicationList.setListEi(1);
      }
    }
    if (pubListsSource == null || pubListsSource.length < 1) {
      return publicationList;
    }
    for (String pubList : pubListsSource) {
      if ("SCI".equalsIgnoreCase(pubList)) {
        publicationList.setListSciSource(1);
      }
      if ("ISTP".equalsIgnoreCase(pubList)) {
        publicationList.setListIstpSource(1);
      }
      if ("SSCI".equalsIgnoreCase(pubList)) {
        publicationList.setListSsciSource(1);
      }
      if ("EI".equalsIgnoreCase(pubList)) {
        publicationList.setListEiSource(1);
      }
    }
    return publicationList;
  }

  @Override
  public String convertPubListToString(PublicationList pubList) {
    if (pubList == null) {
      return null;
    }
    StringBuilder retStr = new StringBuilder();
    if (pubList.getListEi() != null && pubList.getListEi() == 1) {
      retStr.append(",EI");
    }
    if (pubList.getListSci() != null && pubList.getListSci() == 1) {
      retStr.append(",SCI");
    }
    if (pubList.getListIstp() != null && pubList.getListIstp() == 1) {
      retStr.append(",ISTP");
    }
    if (pubList.getListSsci() != null && pubList.getListSsci() == 1) {
      retStr.append(",SSCI");
    }
    return retStr.length() > 0 ? retStr.substring(1) : retStr.toString();
  }

  @Override
  public String convertPubListSourceToString(PublicationList pubList) {
    if (pubList == null) {
      return null;
    }
    StringBuilder retStr = new StringBuilder();
    if (pubList.getListEiSource() != null && pubList.getListEiSource() == 1) {
      retStr.append(",EI");
    }
    if (pubList.getListSciSource() != null && pubList.getListSciSource() == 1) {
      retStr.append(",SCI");
    }
    if (pubList.getListIstpSource() != null && pubList.getListIstpSource() == 1) {
      retStr.append(",ISTP");
    }
    if (pubList.getListSsciSource() != null && pubList.getListSsciSource() == 1) {
      retStr.append(",SSCI");
    }
    return retStr.length() > 0 ? retStr.substring(1) : retStr.toString();
  }

  @Override
  public PublicationList prasePubList(PubXmlDocument doc) {
    // 保存期刊文章的收录情况
    if (doc.existsNode(PubXmlConstants.PUB_LIST_XPATH)) {
      PublicationList pubList = publicationListDao.get(doc.getPubId());
      if (pubList == null) {
        pubList = new PublicationList();
        pubList.setId(doc.getPubId());
      }
      String listEI = doc.getXmlNodeAttribute(PubXmlConstants.PUB_LIST_XPATH, "list_ei");
      if (StringUtils.isNotBlank(listEI)) {
        listEI = resetPubList(listEI);
        pubList.setListEi(NumberUtils.toInt(listEI));
      } else {
        pubList.setListEi(0);
      }
      String listSCI = doc.getXmlNodeAttribute(PubXmlConstants.PUB_LIST_XPATH, "list_sci");
      if (StringUtils.isNotBlank(listSCI)) {
        listSCI = resetPubList(listSCI);
        pubList.setListSci(NumberUtils.toInt(listSCI));
      } else {
        pubList.setListSci(0);
      }
      String listISTP = doc.getXmlNodeAttribute(PubXmlConstants.PUB_LIST_XPATH, "list_istp");
      if (StringUtils.isNotBlank(listISTP)) {
        listISTP = resetPubList(listISTP);
        pubList.setListIstp(NumberUtils.toInt(listISTP));
      } else {
        pubList.setListIstp(0);
      }
      String listSSCI = doc.getXmlNodeAttribute(PubXmlConstants.PUB_LIST_XPATH, "list_ssci");
      if (StringUtils.isNotBlank(listSSCI)) {
        listSSCI = resetPubList(listSSCI);
        pubList.setListSsci(NumberUtils.toInt(listSSCI));
      } else {
        pubList.setListSsci(0);
      }
      publicationListDao.save(pubList);
      return pubList;
    } else {
      this.publicationListDao.deletePubList(doc.getPubId());
    }
    return null;
  }

  @Override
  public PublicationList praseSourcePubList(PubXmlDocument doc) {
    // 保存期刊文章的收录情况
    if (doc.existsNode(PubXmlConstants.PUB_LIST_XPATH)) {
      PublicationList pubList = publicationListDao.get(doc.getPubId());
      if (pubList == null) {
        pubList = new PublicationList();
        pubList.setId(doc.getPubId());
      }
      String listEI = doc.getXmlNodeAttribute(PubXmlConstants.PUB_LIST_XPATH, "list_ei");
      if (StringUtils.isNotBlank(listEI)) {
        listEI = resetPubList(listEI);
        pubList.setListEi(NumberUtils.toInt(listEI));
      } else {
        pubList.setListEi(0);
      }
      String listEISource = doc.getXmlNodeAttribute(PubXmlConstants.PUB_LIST_XPATH, "list_ei_source");
      if (StringUtils.isNotBlank(listEISource)) {
        listEISource = resetPubList(listEISource);
        pubList.setListEiSource(NumberUtils.toInt(listEISource));
      } else {
        pubList.setListEiSource(0);
      }
      String listSCI = doc.getXmlNodeAttribute(PubXmlConstants.PUB_LIST_XPATH, "list_sci");
      if (StringUtils.isNotBlank(listSCI)) {
        listSCI = resetPubList(listSCI);
        pubList.setListSci(NumberUtils.toInt(listSCI));
      } else {
        pubList.setListSci(0);
      }
      String listSCISource = doc.getXmlNodeAttribute(PubXmlConstants.PUB_LIST_XPATH, "list_sci_source");
      if (StringUtils.isNotBlank(listSCISource)) {
        listSCISource = resetPubList(listSCISource);
        pubList.setListSciSource(NumberUtils.toInt(listSCISource));
      } else {
        pubList.setListSciSource(0);
      }
      String listISTP = doc.getXmlNodeAttribute(PubXmlConstants.PUB_LIST_XPATH, "list_istp");
      if (StringUtils.isNotBlank(listISTP)) {
        listISTP = resetPubList(listISTP);
        pubList.setListIstp(NumberUtils.toInt(listISTP));
      } else {
        pubList.setListIstp(0);
      }
      String listISTPSource = doc.getXmlNodeAttribute(PubXmlConstants.PUB_LIST_XPATH, "list_istp_source");
      if (StringUtils.isNotBlank(listISTPSource)) {
        listISTPSource = resetPubList(listISTPSource);
        pubList.setListIstpSource(NumberUtils.toInt(listISTPSource));
      } else {
        pubList.setListIstpSource(0);
      }
      String listSSCI = doc.getXmlNodeAttribute(PubXmlConstants.PUB_LIST_XPATH, "list_ssci");
      if (StringUtils.isNotBlank(listSSCI)) {
        listSSCI = resetPubList(listSSCI);
        pubList.setListSsci(NumberUtils.toInt(listSSCI));
      } else {
        pubList.setListSsci(0);
      }
      String listSSCISource = doc.getXmlNodeAttribute(PubXmlConstants.PUB_LIST_XPATH, "list_ssci_source");
      if (StringUtils.isNotBlank(listSSCISource)) {
        listSSCISource = resetPubList(listSSCISource);
        pubList.setListSsciSource(NumberUtils.toInt(listSSCISource));
      } else {
        pubList.setListSsciSource(0);
      }
      publicationListDao.save(pubList);

      return pubList;
    }
    return null;
  }

  private String resetPubList(String pubList) {
    String result = "0";
    if (StringUtils.isNotBlank(pubList) && !NumberUtils.isNumber(pubList)) {
      if ("是".equals(pubList))
        result = "1";
      if ("否".equals(pubList))
        result = "0";
    } else if (StringUtils.isNotBlank(pubList) && NumberUtils.isNumber(pubList)) {
      return pubList;
    }
    return result;
  }

}
