package com.GowthamAssignment.core.listeners;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = EventHandler.class, property = {
        "event.topics=org/apache/sling/api/resource/Resource/ADDED",
        "event.topics=org/apache/sling/api/resource/Resource/CHANGED",
        "event.topics=org/apache/sling/api/resource/Resource/REMOVED"
})
public class CustomEventHandler implements EventHandler {
    private static final Logger LOG = LoggerFactory.getLogger(CustomEventHandler.class);

    @Override
    public void handleEvent(Event event) {
        LOG.info("Resource changed: {}", event.getProperty("path"));
    }
}
