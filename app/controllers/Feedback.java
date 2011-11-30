package controllers;

import play.*;
import play.mvc.*;

public class Feedback extends Controller {
    public static void submit(String message, String url) {
        if (message == null || message.length() == 0) {
            return;
        }
        
        models.Feedback feedback = new models.Feedback();
        
        feedback.userId = getUser();
        feedback.ipAddress = getUserIp();
        feedback.url = url;
        feedback.message = message;
        feedback.save();
    }
    
    static String getUser() {
        Object id = Play.configuration.get("feedback.authenticatedUserSessionKey");
        
        if (id == null) {
            id = "username";
        }
        
        String user = session.get(id.toString());
        
        return user != null ? user : "anonymous";
    }
    
    static String getUserIp() {
        return request.remoteAddress;
    }
}