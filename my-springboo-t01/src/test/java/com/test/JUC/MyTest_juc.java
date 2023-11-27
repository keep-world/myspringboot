package com.test.JUC;

import io.netty.util.concurrent.CompleteFuture;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.plaf.TableHeaderUI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@SpringBootTest
@Slf4j
public class MyTest_juc {

    public class ServerTask implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(2000);
            return 3;
        }
    }

    @Test
    public void test01() throws Exception {

        Long begin = System.currentTimeMillis();
        // 线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // 批量任务
        List<ServerTask> serverTasks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            serverTasks.add(new ServerTask());
        }
        List<Future<Integer>> taskResList = executor.invokeAll(serverTasks);
        // 结果输出
        for (Future<Integer> intFuture : taskResList) {
            System.out.println(intFuture.get());
        }
        // 耗时统计
        Long end = System.currentTimeMillis();
        log.info("end cost={}ms", (end - begin));
    }

    @Test
    public void test02() throws Exception {
        // 线程池执行任务
        ExecutorService executor = Executors.newFixedThreadPool(3);
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "task...OK";
            }
        });

//        executor.execute(futureTask);
        Future<?> aaaa = executor.submit(futureTask, "111111");
        // 任务信息获取
        System.out.println(">>>>>>>： " + aaaa.get());
        System.out.println("是否完成：" + futureTask.isDone());
        System.out.println("是否取消：" + futureTask.isCancelled());
        System.out.println("获取结果：" + futureTask.get());
        System.out.println("尝试取消：" + futureTask.cancel(Boolean.TRUE));
    }


    @Test
    public void test03() throws Exception {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 1000L, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());

        try {
            CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1000L * 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "11111111";
            }, threadPoolExecutor).whenComplete((x, e) -> {
                        if (e == null) {
                            log.info("x={}", x);
                        }
                    }
            ).exceptionally((e) -> {
                e.printStackTrace();
                log.error("{}", e.toString());
                return e.toString();
            });
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.toString());
        } finally {
            threadPoolExecutor.shutdown();
        }

        log.info("主线程1。。。。。。");
        Thread.sleep(1000L * 10);
        log.info("主线程2.。。。。。。。");
    }


    //interupt相关
    //interupt      实例方法
    //interupted        静态方法
    //isinterrupted   实例方法
    @Test
    public void test04() throws Exception {

        Thread.currentThread().interrupt();  //设置当前线程的【中断标识】为true

        Thread.currentThread().isInterrupted();  //获取当前线程的【中断标识】true代表中断，false代表不中断

        Thread.interrupted(); //返回线程的【中断标识】并清除当前的中断状态，中断标识强制置为false。


    }


    //    thread的join方法
    @Test
    public void test05() {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 1000L, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());

        Thread t1 = new Thread(() ->
        {
            for (int i = 1; i < 200; i++) {
                System.out.println(Thread.currentThread().getName() + "_" + i);
            }

        }, "t1");

        Thread t2 = new Thread(() ->
        {
            for (int i = 1; i < 50; i++) {
                if (i == 20) {
                    try {
                        t1.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "_" + i);
            }
        }, "t2");
//        t2.start();
//        t1.start();
        threadPoolExecutor.execute(t1);
        threadPoolExecutor.execute(t2);
    }

    @Test
    public void test06() {
        ToneTest t1 = new ToneTest();
        Thread t2 = new Thread(t1);
        //设置线程名
        t2.setName("T");
        t2.start();

    }

    class ToneTest extends Thread {
        public void run() {
            System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
            System.out.println("Thread.currentThread().isAlive()=" + Thread.currentThread().isAlive());
            System.out.println("this.getName()=" + this.getName());
            System.out.println("this.isAlive()=" + this.isAlive());
        }
    }

    @Test
    public void test07() {

        Thread t1 = new Thread(() ->
        {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "_线程主动中断！");
                    break;
                }
                try {
                    TimeUnit.SECONDS.sleep(200L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "_线程持续打印。。。。。。");
            }

        }, "t1");

        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1L);
            t1.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }


        new Thread(() -> {
            t1.interrupt();
            System.out.println("t2将t1标记为中断");
        }, "t2").start();

    }
}
