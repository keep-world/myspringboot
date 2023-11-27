package com.test.compare;

import com.test.compare.vo.PersistenceDataTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest
@Slf4j
public class MyTest_compare {

    private Map<String, TreeSet<PersistenceDataTask>> cache = new ConcurrentHashMap(1024);;

    @Test
    public void test01(){
        PersistenceDataTask persistenceDataTask_1 = new PersistenceDataTask();
        persistenceDataTask_1.setSliceIndex(2);
        persistenceDataTask_1.setMessageId("test_00001");
        TreeSet<PersistenceDataTask> taskTreeSet = new TreeSet(new Comparator<PersistenceDataTask>() {
            public int compare(PersistenceDataTask o1, PersistenceDataTask o2) {
                if (o1.getSliceIndex() > o2.getSliceIndex()) {
                    return 1;
                } else {
                    return o1.getSliceIndex() < o2.getSliceIndex() ? -1 : 0;
                }
            }
        });
        taskTreeSet.add(persistenceDataTask_1);
        cache.put("test_00001",taskTreeSet);


        PersistenceDataTask persistenceDataTask = new PersistenceDataTask();
        persistenceDataTask.setSliceIndex(2);
        persistenceDataTask.setMessageId("test_00001");
        String var4 = persistenceDataTask.getMessageId();
        TreeSet var5 = (TreeSet) this.cache.getOrDefault(var4, new TreeSet(new Comparator<PersistenceDataTask>() {
            public int compare(PersistenceDataTask o1, PersistenceDataTask o2) {
                if (o1.getSliceIndex() > o2.getSliceIndex()) {
                    return 1;
                } else {
                    return o1.getSliceIndex() < o2.getSliceIndex() ? -1 : 0;
                }
            }
        }));
        int var6 = var5.size();
        var5.add(persistenceDataTask);
        int var7 = var5.size();
        if (var7 == var6) {
            log.info("过滤重复数据missionId->{}, messageId->{}, sliceIndex->{}", var4, persistenceDataTask.getSliceIndex());
            return;
        }

        if (!this.cache.containsKey(var4)) {
            this.cache.put(var4, var5);
        }

        if (var5.size() == persistenceDataTask.getSliceSize()) {
            LinkedList var8 = new LinkedList();
//            var5.forEach((slice) -> {
//                var8.addAll(Arrays.asList(slice.getData()));
//            });
//            PersistenceDataTask var9 = new PersistenceDataTask(persistenceDataTask.getResultList(), (String[][])var8.toArray(new String[var8.size()][]), persistenceDataTask.getNotifyTopic(), 1, 1, persistenceDataTask.getMessageId(), persistenceDataTask.getBasicTask());
//            threadPoolExecutor.execute(new PersistenceDataTaskRunner(var9, this.dbId, this));
        }
    }


}
