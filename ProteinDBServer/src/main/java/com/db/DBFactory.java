package com.db;

import com.config.Configuration;
import com.proto.ConfigStore.DB;
import java.io.IOException;
import org.javalite.activejdbc.Base;

/**
 * @author zhanghaijun
 */
public class DBFactory {

    public static void DBOpen() throws IOException {
        DB db = Configuration.getInstance().getConfig().getDb();
        if (db != null) {
            Base.open(db.getDriver(), db.getUrl(), db.getUser(), db.getPassword());
        }
    }

    public static void DBClose() {
        Base.close();
    }
}
