package com.server.handler;

import org.apache.commons.lang.StringUtils;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;

/**
 * @author zhanghaijun
 */
public class ResourceHander {

    public final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ResourceHander.class);

    public boolean handle(Request request, Response response) {
        if (!request.getMethod().equalsIgnoreCase("GET")) {
            return false;
        }
        String file = request.getPath().getPath().substring(1);
        String target = request.getTarget();
        if (StringUtils.isNotEmpty(file) && StringUtils.startsWith(file, "static")) {
            return true;
        }
        return false;
    }

}
