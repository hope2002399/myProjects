package com.smate.center.batch.chain.pubassign.process;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.smate.center.batch.chain.pubassign.task.IPubAssignXmlTask;
import com.smate.center.batch.exception.pub.XmlProcessStopExecuteException;
import com.smate.center.batch.model.sns.pub.PubXmlProcessContext;
import com.smate.center.batch.oldXml.pub.PubXmlDocument;
import com.smate.center.batch.service.rol.pubassign.PubAssignPubMedXmlService;

/**
 * pubmed成果指派XML展开.
 * 
 * @author liqinghua
 * 
 */
public class PubMedPubAssignXmlProcess implements IPubAssignXmlProcess {

  /**
   * 
   */
  private static final long serialVersionUID = 6209164074005478285L;
  // logger.
  private Logger logger = LoggerFactory.getLogger(getClass());
  /**
   * 
   */
  private List<IPubAssignXmlTask> tasks = null;
  @Autowired
  private PubAssignPubMedXmlService pubAssignPubMedXmlService;

  @Override
  public void setTasks(List<IPubAssignXmlTask> tasks) {
    Assert.notNull(tasks);
    Assert.notEmpty(tasks);

    this.tasks = tasks;

    logger.info("初始化PubMedPubAssignXmlProcess Tasks成功");
  }

  @Override
  public void start(PubXmlDocument xmlDocument, PubXmlProcessContext context) throws Exception {

    if (context.isImport() && context.isPubMedImport()) {

      // 如果已经展开过成果XML，则没必要再次展开
      if (pubAssignPubMedXmlService.isExtractAssignData(context.getCurrentPubId())) {
        return;
      }
      for (int index = 0; index < this.tasks.size(); index++) {
        IPubAssignXmlTask task = this.tasks.get(index);
        boolean flag = task.can(xmlDocument, context);
        if (flag) {
          try {
            boolean result = task.run(xmlDocument, context);
            if (!result) {
              break;
            }
          } catch (XmlProcessStopExecuteException e) {
            logger.error("PubMedPubAssignXmlProcess终止处理该XML: task=" + task.getName(), e);
            throw e;
          } catch (Exception e) {
            logger.error("PubMedPubAssignXmlProcess终止处理该XML: task=" + task.getName(), e);
            throw e;
          }
        }
      }
    }
  }

}
