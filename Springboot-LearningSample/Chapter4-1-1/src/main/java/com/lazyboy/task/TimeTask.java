package com.lazyboy.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class TimeTask {
    /**
     * initialDelay:项目启动初始延迟
     * fixedDelay:在上次执行结束到下次执行开始的间隔
     * fixedRate:从上一次方法执行开始的时间算起，如果上一次方法阻塞住了，下一次也是不会执行，
     *           但是在阻塞这段时间内累计应该执行的次数，当不再阻塞时，一下子把这些全部执行掉，而后再按照固定速率继续执行。
     */
    @Scheduled(initialDelay = 10000, fixedDelay = 20000)
    public void printNow() {
        log.info("THE TIME IS " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    /**
     * cron表达式
     */
    @Scheduled(cron = "*/5 * * * * *")
    public void per5secs() {
        log.info("Spring Scheduled Task");
    }
}
