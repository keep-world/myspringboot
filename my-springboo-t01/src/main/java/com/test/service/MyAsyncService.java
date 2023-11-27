package com.test.service;

import java.util.concurrent.Future;

public interface MyAsyncService {

    public void doNoReturn();


    public Future<String> doReturn(int i);
}
