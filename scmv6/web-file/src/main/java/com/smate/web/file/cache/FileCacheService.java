package com.smate.web.file.cache;

import java.io.Serializable;

import com.smate.core.base.utils.cache.CacheService;

public interface FileCacheService extends CacheService {

  /**
   * 获取缓存对象.
   * 
   * @param cacheName
   * @param key
   * @return
   */
  public Serializable get(String cacheName, String key);


  /**
   * 删除缓存.
   * 
   * @param cacheName
   * @param key
   */
  public boolean remove(String cacheName, String key);
}
