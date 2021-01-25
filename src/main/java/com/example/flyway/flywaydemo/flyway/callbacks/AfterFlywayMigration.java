package com.example.flyway.flywaydemo.flyway.callbacks;

import org.flywaydb.core.api.callback.Callback;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;
import org.springframework.stereotype.Component;

@Component
public class AfterFlywayMigration implements Callback {
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(AfterFlywayMigration.class.getName());
    @Override
    public boolean supports(Event event, Context context) {
        return event.equals(Event.AFTER_MIGRATE) || event.equals(Event.AFTER_MIGRATE_ERROR);
    }

    @Override
    public boolean canHandleInTransaction(Event event, Context context) {
        return false;
    }

    @Override
    public void handle(Event event, Context context) {
        switch (event) {
            case AFTER_MIGRATE:
                log.info("==================================================");
                log.info("**** Migration completed successfully ****");
                log.info("==================================================");
                break;
            case AFTER_MIGRATE_ERROR:
                log.warning("==================================================");
                log.warning("**** Migration completed with some error. Please check!!! ****");
                log.warning("==================================================");
                break;
        }
    }

    @Override
    public String getCallbackName() {
        return "After Migration Callback";
    }
}
