package com.example.demo.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.session.data.redis.RedisIndexedSessionRepository;
import org.springframework.session.events.SessionCreatedEvent;
import org.springframework.stereotype.Component;

/**
 * {@link RedisIndexedSessionRepository} publish SessionCreatedEvent and SessionDeletedEvent.
 *
 * spring:session:index:org.springframework.session.FindByIndexNameSessionRepository.PRINCIPAL_NAME_INDEX_NAME:user
 */
@Component
public class SessionEventHandler {

    private static final Logger logger = LoggerFactory.getLogger(SessionEventHandler.class);

    @EventListener
    public void handleSessionCreated(SessionCreatedEvent sessionCreatedEvent) {
        logger.info("Created sessionId : {}", sessionCreatedEvent.getSessionId());
    }
}
