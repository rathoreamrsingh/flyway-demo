package com.example.flyway.flywaydemo.flyway.callbacks;

import org.flywaydb.core.api.callback.Callback;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;
import org.springframework.stereotype.Component;

@Component
public class BeforeFlywayMigration implements Callback {
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(BeforeFlywayMigration.class.getName());
    @Override
    public boolean supports(Event event, Context context) {
        return event.equals(Event.BEFORE_MIGRATE);
    }

    @Override
    public boolean canHandleInTransaction(Event event, Context context) {
        return false;
    }

    @Override
    public void handle(Event event, Context context) {
        log.info("==================================================");
        log.info("**** Starting flyway migration ****");
        log.info("==================================================");
    }

    @Override
    public String getCallbackName() {
        return "Before Migration Callback";
    }
}
