package com.jlsites.how2gwt.gwtwithdb.shared.action;

import java.util.HashMap;
import java.util.Map;

import net.customware.gwt.dispatch.shared.Result;

public class GetEnvResult implements Result {
  private Map<String, String> mapEnv = new HashMap<String, String>();

  public GetEnvResult() {
  }

  public void putEnv(String key, String value) {
    mapEnv.put(key, value);
  }

  public Map<String, String> getMapEnv() {
    return mapEnv;
  }
}
