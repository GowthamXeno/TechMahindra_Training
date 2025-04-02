package com.GowthamAssignment.core.schedulers;


import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Runnable.class, immediate = true, property = {
        "scheduler.expression=0 */5 * * * ?" // Runs every 5 minutes
})
public class HellowWorldScheduler implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(HellowWorldScheduler.class);

    @Override
    public void run() {
        LOG.info("Hellow World");
    }
}
