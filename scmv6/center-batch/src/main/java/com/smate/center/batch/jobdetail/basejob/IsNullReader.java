package com.smate.center.batch.jobdetail.basejob;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.smate.core.base.utils.exception.BatchTaskException;

/**
 * Reader，提示任务的Strategy coder傳入值爲null
 * 
 * @author hzr
 * @version 6.0.1
 */
public class IsNullReader implements ItemReader<String> {
  private List<String> listNull = new ArrayList<String>();

  @Override
  public String read()
      throws BatchTaskException, UnexpectedInputException, ParseException, NonTransientResourceException {

    if (CollectionUtils.isEmpty(listNull)) {
      return null;
    }
    return listNull.remove(0);

  }

  public IsNullReader() {
    listNull.add("empty");
  }

}
