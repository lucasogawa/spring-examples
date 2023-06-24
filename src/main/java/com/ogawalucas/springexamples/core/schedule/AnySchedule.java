package com.ogawalucas.springexamples.core.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AnySchedule {

    @Scheduled(cron = "0/30 * * * * *")
    public void anySchedule() {
        log.info("Schedule");
    }
}
