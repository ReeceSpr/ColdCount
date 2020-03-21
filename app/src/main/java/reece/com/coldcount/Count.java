package reece.com.coldcount;

import java.util.Date;

public class Count {

    Date startDate;
    String name;
    String description;
    boolean notify;
    int goal;

    public Count(Date startDate, String name, String description, boolean notify, int goal) {
        this.startDate = startDate;
        this.name = name;
        this.description = description;
        this.notify = notify;
        this.goal = goal;
    }

}
