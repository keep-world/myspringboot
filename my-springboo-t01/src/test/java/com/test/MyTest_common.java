package com.test;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
//@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest_common {

    @Test
    public void test() {

//        TreeSet a = new TreeSet();
//        a.comparator()
//        Map<String, TreeSet<String>> cache = new ConcurrentHashMap(1024);
//        if (persistenceDataTask.getSliceSize() == 1) {
//            threadPoolExecutor.execute(new PersistenceDataTaskRunner(persistenceDataTask, this.dbId, this));
//        } else {
//            String var4 = "123";
//            TreeSet var5 = cache.getOrDefault(var4, new TreeSet(new Comparator<String>() {
//                public int compare(String o1, String o2) {
//                    if (Integer.valueOf(o1) >Integer.valueOf(o2)) {
//                        return 1;
//                    } else {
//                        return Integer.valueOf(o1) < Integer.valueOf(o2) ? -1 : 0;
//                    }
//                }
//            }));
//            int var6 = var5.size();
//            var5.add(persistenceDataTask);
//            int var7 = var5.size();
//            if (var7 == var6) {
//                logger.debug("过滤重复数据missionId->{}, messageId->{}, sliceIndex->{}", new Object[]{persistenceDataTask.getBasicTask().getMissionId(), var4, persistenceDataTask.getSliceIndex()});
//                return;
//            }
//
//            if (!this.cache.containsKey(var4)) {
//                this.cache.put(var4, var5);
//            }
//
//            if (var5.size() == persistenceDataTask.getSliceSize()) {
//                LinkedList var8 = new LinkedList();
//                var5.forEach((slice) -> {
//                    var8.addAll(Arrays.asList(slice.getData()));
//                });
//                PersistenceDataTask var9 = new PersistenceDataTask(persistenceDataTask.getResultList(), (String[][])var8.toArray(new String[var8.size()][]), persistenceDataTask.getNotifyTopic(), 1, 1, persistenceDataTask.getMessageId(), persistenceDataTask.getBasicTask());
//                threadPoolExecutor.execute(new PersistenceDataTaskRunner(var9, this.dbId, this));
//            }
//        }
    }

    @Test
    public void test02() {
        String persistenceDataTask = "test00001";
        Map<String, TreeSet<String>> cache = new ConcurrentHashMap(1024);
        TreeSet<String> test_treeSet = new TreeSet<String>();
        test_treeSet.add("10");
        cache.put("test00001", test_treeSet);
        String var4 = "9";
        TreeSet var5 = cache.getOrDefault(var4, new TreeSet(new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (Integer.valueOf(o1) > Integer.valueOf(o2)) {
                    return 1;
                } else {
                    return Integer.valueOf(o1) < Integer.valueOf(o2) ? -1 : 0;
                }
            }
        }));

        int var6 = var5.size();
        var5.add(persistenceDataTask);
        int var7 = var5.size();
        if (var7 == var6) {
            log.debug("var6={}var5={} var7={}", var6, var5, var7);
            return;
        }

    }

    @Test
    public void test03() {
        int id = 8888;
        ConcurrentHashMap<Integer, String> conmap = initialize();
        System.out.println(" Id is:" + id + "  "
                + conmap.getOrDefault(id, "JavaTpoint"));

    }

    private static ConcurrentHashMap<Integer, String> initialize() {
        ConcurrentHashMap<Integer, String> Objmap = new ConcurrentHashMap<>();
        Objmap.put(85, "Java");
        Objmap.put(80, "php");
        return Objmap;
    }

}
