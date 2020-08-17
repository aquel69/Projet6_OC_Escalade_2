package fr.alardon.escalade.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDao {

    @Inject
    @Named("dataSourceEscalade")
    private DataSource dataSource;

    protected DataSource getDataSource() {
        return dataSource;
    }
}
