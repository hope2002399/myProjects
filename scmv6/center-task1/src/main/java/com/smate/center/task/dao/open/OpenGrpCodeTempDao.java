package com.smate.center.task.dao.open;

import org.springframework.stereotype.Repository;

import com.smate.center.task.model.group.OpenGrpCodeTemp;
import com.smate.core.base.utils.data.SnsHibernateDao;

/**
 * 群组groupcode Dao
 * 
 * @author JunLi
 *
 *         2017年11月1日
 */
@Repository
public class OpenGrpCodeTempDao extends SnsHibernateDao<OpenGrpCodeTemp, Long> {
  /**
   * 通过grpId 更新createOpenId，groupCode
   * 
   * @param groupId
   * @param createOpenId
   * @param groupCode
   */
  public void updateGrpCodebyGrpId(Long groupId, Long createOpenId, String groupCode) {
    String sql = "update OpenGrpCodeTemp set groupCode=:groupCode ,createOpenId=:createOpenId where groupId=:groupId";
    this.createQuery(sql).setParameter("groupId", groupId).setParameter("createOpenId", createOpenId)
        .setParameter("groupCode", groupCode).executeUpdate();

  }

}
