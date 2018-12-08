package com.db;

import com.config.Configuration;
import com.proto.ConfigStore.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

/**
 * @author zhanghaijun
 */
public class LiquibaseInit {

    private static Connection getConnection() throws Exception {
        DB dbConfig = Configuration.getInstance().getConfig().getDb();
        Connection connection = null;
        if (dbConfig != null) {
            Class.forName(dbConfig.getDriver());
            connection = DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUser(), dbConfig.getPassword());
//            Properties properties = new Properties();
//            properties.setProperty("driver", dbConfig.getDriver());
//            connection = DriverManager.getConnection(dbConfig.getUrl(), properties);
        }
        return connection;
    }

    public static void init() {
        try {
            String dbFile = "server-db.xml";
            Database db = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(getConnection()));
            Liquibase liquibase = new Liquibase(dbFile, new ClassLoaderResourceAccessor(), db);
            liquibase.update("");
        } catch (Exception ex) {
            Logger.getLogger(LiquibaseInit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
