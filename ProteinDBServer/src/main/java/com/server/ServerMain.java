package com.server;

import com.config.Configuration;
import com.db.LiquibaseInit;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.simple.SimpleContainerFactory;
import org.glassfish.jersey.simple.SimpleServer;

/**
 * @author zhanghaijun
 */
public class ServerMain {

    public static void main(String[] args) throws Exception {
        ServerMain.serverInit();

        URI baseUri = UriBuilder.fromUri("http://0.0.0.0/").port(8888).build();
        ResourceConfig config = new ResourceConfig().packages("com.server");
        SimpleServer server = SimpleContainerFactory.create(baseUri, config);

    }

    private static void serverInit() throws Exception {
        Configuration.getInstance().loadConfig();
        LiquibaseInit.init();
    }
}
