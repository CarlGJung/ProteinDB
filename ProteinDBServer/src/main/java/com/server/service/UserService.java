package com.server.service;

import com.db.DBFactory;
import com.db.User;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author zhanghaijun
 */
@Path("/user")
public class UserService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser() {
        try {
            DBFactory.DBOpen();
            User user = User.first(User.USER_NAME +"= ? ", "zhansan");
            if (user == null) {
                user = User.create(User.USER_NAME, "zhansan");
            }

            user.setPassword("123456");
            user.saveIt();
            List<User> users = User.findAll();
            System.out.println(Arrays.toString(users.toArray()));
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBFactory.DBClose();
        }
        return "hello word!!!";
    }
}
