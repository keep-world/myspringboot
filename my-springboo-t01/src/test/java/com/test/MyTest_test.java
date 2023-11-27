package com.test;

import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
public class MyTest_test {

    @Test
    public void test01(){
        String a = "hello";
        String b = "he" + new String("llo");
        System.out.println(a == b);

        String c = "aaaaaa";
        c.intern();
        String d = new String("aaaaaa");

        System.out.println(c == d);


        String e = "bbb";
        c.intern();
        String f = "bbb";
        System.out.println(e == f);

        String g = "ccc";
        String k = "cc" + "c";
        System.out.println(g == k);

        String g1 = "ddd";
        String k1 = "ddd" ;
        System.out.println(g1 == k1);

    }

    @Test
    public void test02(){
        String g1 = "bbb";
        String k1 = new String("bbb") ;
        System.out.println(g1 == k1);


        String k2 = new String("ccc") ;
        String g2 = "ccc";
        System.out.println(g2 == k2);

        String k3 = new String("ddd") ;
        k3.intern();
        String g3 = "ddd";
        System.out.println(g3 == k3);
    }

    @Test
    public void test03(){
        String a = new String("aaa");
        String b = new String ("aaa");
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

    @Test
    public void test04(){
        Integer a = new Integer("123");
        Integer b = new Integer ("123");
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

    @Test
    public void test05(){
        A a = new A("123");
        A b = new A ("123");
        System.out.println(a == b);
        System.out.println(a.equals(b));

    }
    @Test
    public void test06(){
//        ThreadPoolExecutor threadPoolExecutor= new ThreadPoolExecutor();
//        threadPoolExecutor.allowCoreThreadTimeOut();
//        threadPoolExecutor.execute();
//        threadPoolExecutor.submit()
    }

    @Test
    public void test07() {

        Double[] ds = {777.77, 777.77, 3333.77, 333.77, 333.77};
        Double count = 0.0;
        for (Double d : ds) {
            count = count + d;
        }
        log.info("count={} ds.length={} avg={}",count, ds.length , count/ds.length);
        ;
    }


    class A{
        private String a;
        public A(String a){
            this.a = a;
            new String();
            
        }


        @Override
        public boolean equals(Object obj) {
            ThreadPoolExecutor tpe = new ThreadPoolExecutor(10,20,3000L, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
            return this.a.equals(((A)obj).a);
//            return super.equals(obj);
        }

    }
}

