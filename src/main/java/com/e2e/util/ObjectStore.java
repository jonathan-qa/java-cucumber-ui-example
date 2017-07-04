package com.e2e.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ObjectStore {

  private Map<Class<?>, Object> store = new HashMap();

  public <T> T get(Class<T> clazz) {
    return store.containsKey(clazz) ? (T) store.get(clazz) : null;
  }

  public <T> void put(T value) {
    store.put(value.getClass(), value);
  }

  public void clear() {
    store = new HashMap();
  }

}
