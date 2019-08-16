package com.smate.center.batch.dao.pdwh.pub.ei;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.smate.center.batch.model.pdwh.pub.ei.EiPubAddr;
import com.smate.center.batch.model.pdwh.pub.ei.EiPubMaddr;
import com.smate.core.base.utils.data.PdwhHibernateDao;

/**
 * isi成果地址匹配结果.
 * 
 * @author liqinghua
 * 
 */
@Repository
public class EiPubMaddrDao extends PdwhHibernateDao<EiPubMaddr, Long> {

  /**
   * 获取匹配加粗的成果地址.
   * 
   * @param pubId
   * @param insId
   * @return
   */
  public List<EiPubMaddr> getRemarkOrgs(Long pubId, Long insId) {
    String hql = "from EiPubMaddr where pubId = ? and insId = ?  and matched <> 4 ";
    return super.find(hql, pubId, insId);
  }

  /**
   * 获取匹配成果地址结果.
   * 
   * @param pubId
   * @param insId
   * @return
   */
  public List<EiPubMaddr> getEiPubMaddrs(Long pubId, Long insId) {
    String hql = "from EiPubMaddr where pubId = ? and insId = ?";
    return super.find(hql, pubId, insId);
  }

  /**
   * 获取匹配成果地址结果.
   * 
   * @param pubId
   * @param insId
   * @return
   */
  public EiPubMaddr getEiPubMaddr(Long insId, Long addrId) {
    String hql = "from EiPubMaddr where insId = ? and addrId = ? ";
    return super.findUnique(hql, insId, addrId);
  }

  /**
   * 加载指定pubIds，匹配状态的成果地址列表.
   * 
   * @param matched
   * @param xmlIds
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<EiPubMaddr> loadOrgs(List<Integer> matched, Set<Long> pubIds, Long insId) {
    String hql =
        "select new EiPubMaddr( t.maddrId, t.addrId,  t.insId,  t.pubId,  t.addr,  t.matched,  t1.addr) from EiPubMaddr t,EiPubAddr t1 where t.addrId = t1.addrId and t.matched in(:matched) and  t.pubId in(:pubIds) and t.insId = :insId  ";
    return super.createQuery(hql).setParameterList("matched", matched).setParameterList("pubIds", pubIds)
        .setParameter("insId", insId).list();
  }

  /**
   * 加载指定XMLID，匹配状态的成果地址列表.
   * 
   * @param matched
   * @param pubIds
   * @param insId
   * @return
   */
  public List<EiPubMaddr> loadOrgs(Integer matched, Set<Long> pubIds, Long insId) {

    List<Integer> matcheds = new ArrayList<Integer>();
    // 所有状态
    if (matched == -1) {
      matcheds.add(0);
      matcheds.add(1);
      matcheds.add(2);
      matcheds.add(3);
      matcheds.add(4);
    } else {
      matcheds.add(matched);
    }
    return this.loadOrgs(matcheds, pubIds, insId);
  }

  /**
   * 更新地址匹配状态.
   * 
   * @param maddrId
   * @param matched
   */
  public void updateOrgsMatched(Long maddrId, int matched) {
    String hql = "update EiPubMaddr set matched = ? where maddrId = ? ";
    super.createQuery(hql, matched, maddrId).executeUpdate();
  }

  /**
   * 获取地址匹配信息.
   * 
   * @param maddrId
   * @return
   */
  public EiPubMaddr getEiPubMaddr(Long maddrId) {

    String hql = "from EiPubMaddr where maddrId = ? ";
    EiPubMaddr maddr = super.findUnique(hql, maddrId);
    if (maddr == null) {
      return null;
    }
    hql = "from EiPubAddr where addrId = ? ";
    EiPubAddr addr = super.findUnique(hql, maddr.getAddrId());
    maddr.setProtoAddr(addr.getAddr());
    return maddr;
  }

  /**
   * bpo重新设置匹配结果.
   * 
   * @param maddr
   */
  public void saveResetEiPubMaddr(EiPubMaddr maddr) {
    if (maddr.getMaddrId() != null) {
      String hql = "from EiPubMaddr where maddrId = ? ";
      EiPubMaddr pmaddr = super.findUnique(hql, maddr.getMaddrId());
      if (pmaddr == null) {
        super.save(maddr);
        return;
      }
      pmaddr.setMinsId(maddr.getMinsId());
      pmaddr.setAddr(maddr.getAddr());
      pmaddr.setEiNameId(maddr.getEiNameId());
      pmaddr.setMatched(maddr.getMatched());
      super.save(pmaddr);
    } else {
      super.save(maddr);
    }

  }
}
