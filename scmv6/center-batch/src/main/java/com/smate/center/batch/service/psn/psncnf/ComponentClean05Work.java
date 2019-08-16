package com.smate.center.batch.service.psn.psncnf;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smate.core.base.psn.enums.PsnCnfEnum;
import com.smate.core.base.psn.model.psncnf.PsnConfigWork;
import com.smate.core.base.psn.service.psncnf.PsnCnfService;
import com.smate.core.base.psn.utils.PsnCnfUtils;

@Service("clean05Work")
@Transactional(rollbackFor = Exception.class)
public class ComponentClean05Work implements ComponentClean {
  @Autowired
  private PsnCnfService psnCnfService;

  @Resource(name = "clean06Edu")
  private ComponentClean next;

  @Override
  public void clean(Long runs, Long cnfId) throws Exception {
    try {
      if (PsnCnfUtils.canRun(runs, PsnCnfEnum.CLEAN, PsnCnfEnum.WORK)) {
        // 删除工作经历配置
        PsnConfigWork psnConfigWork = new PsnConfigWork(cnfId);
        psnCnfService.del(psnConfigWork);
      }
    } catch (Exception e) {
      throw new Exception("个人配置：clean05Work失败", e);
    }
    // 下个清理操作
    next.clean(runs, cnfId);
  }

}
