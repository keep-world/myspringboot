package com.test.service;


import java.util.List;
import java.util.Map;
import java.lang.String;

public interface MyRedisService {

    public Map<String, String> setKV(String key, String value);

    public Map<String, String> getKV(String key);

    public List<String> getAllKeys();
}
