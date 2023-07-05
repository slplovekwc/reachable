package com.slp.reachable.service;

import com.slp.reachable.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@SpringBootTest
public class InsertUsersTest {

    @Resource
    private UserService userService;
    //corePoolSize： 线程池的基本大小，即在没有任务需要执行的时候线程池的大小，并且只有在工作队列满了的情况下才会创建超出这个数量的线程。
    //maximumPoolSize：线程池中能容纳的最大线程数。
    //keepAliveTime：当线程池中超过 corePoolSize 的线程空闲时间达到 keepAliveTime 时，
    // 这些线程会被销毁，直到只剩下 corePoolSize 个线程为止。
    //unit：keepAliveTime 的时间单位。
    //workQueue：用于存放等待执行的任务的阻塞队列。
    private ExecutorService executorService = new ThreadPoolExecutor(40, 1000, 10000, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10000));

    /**
     * 并发批量插入用户
     */
    @Test
    public void doConcurrencyInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int batchSize = 5000;
        int j = 0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            List<User> userList = new ArrayList<>();
            //插入5000条数据
            while(true) {
                j++;
                User user = new User();
                user.setUsername("塑料瓶");
                user.setUserAccount("塑料瓶");
                user.setAvatarUrl("https://636f-codenav-8grj8px727565176-1256524210.tcb.qcloud.la/img/logo.png");
                user.setGender(0);
                user.setUserPassword("12345678");
                user.setPhone("123");
                user.setEmail("123@qq.com");
                user.setTags("[]");
                user.setUserStatus(0);
                user.setUserRole(0);
                user.setStudentCode("11111111");
                userList.add(user);
                if (j % batchSize == 0) {
                    break;
                }
            }
            // 异步执行
            // public static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor)
            // 是 CompletableFuture 类的一个静态方法，
            // 用于在指定的执行器（Executor）中异步运行一个指定的 Runnable 对象，
            // 并返回一个 CompletableFuture<Void> 对象，表示任务的异步执行结果。
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("threadName: " +Thread.currentThread().getName());
                userService.saveBatch(userList, batchSize);
            }, executorService);
            futureList.add(future);
        }
        //new CompletableFuture[]{} 是一个创建空的 CompletableFuture 数组的方式。
        //
        //在 Java 中，使用 new 关键字和数组初始化器 {} 可以创建一个数组。
        //这个语法中，new CompletableFuture[] 表示要创建一个 CompletableFuture 类型的数组，
        //而 {} 则表示该数组没有任何元素。
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join(); //用于等待一组 CompletableFuture 对象都完成执行。
        // 20 秒 10 万条
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}
