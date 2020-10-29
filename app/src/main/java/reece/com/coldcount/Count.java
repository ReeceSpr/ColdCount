package reece.com.coldcount;


import android.os.Build;

import androidx.annotation.RequiresApi;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Period;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Count {

    LocalDate startDate;
    String name;
    boolean notify;
    int goal;

    public Count(String name , boolean notify, int goal) {
        this.startDate = LocalDate.now().minusDays(20);
        this.name = name;
        this.notify = notify;
        this.goal = goal;
    }

    public int daysSince(){
        LocalDate now = LocalDate.now();
        Period period = new Period(now, startDate);
        long diffLong = Math.abs(period.getDays());
        int diff = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            diff = Math.toIntExact(diffLong);
        } else {
            diff = (int) diffLong;
        }
        return diff;
    }
}
