package models;

import play.db.jpa.*;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Feedback extends Model {
    public String userId;
    public String ipAddress;
    @Lob
    public String url;
    @Lob
    public String message;
    public Date submitted = new Date();
    public boolean answered = false;
}