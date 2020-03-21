package reece.com.coldcount;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Date currentTime;
    Date[] startTimes;
    int primaryTimeIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentTime = Calendar.getInstance().getTime();
        // Change to database
        int startTimeLength = 10;
        primaryTimeIndex = 0;
        startTimes = new Date[startTimeLength];
        populateSampleTimes();
        populatePrimaryCounter();
    }

    //Sample Times for debugging
    void populateSampleTimes (){
        startTimes[0] = new Date(99, 5 , 13, 7,0);
        for(int  i = 1; i<10; i++){
            startTimes[i] = new Date(120, 2, i );
        }
    }

    //Populates the primary day counter
    void populatePrimaryCounter(){
        TextView primaryTextView = findViewById(R.id.PrimaryTime_TextView);
        int daysDiff = daysBetween(startTimes[primaryTimeIndex], currentTime);
        primaryTextView.setText( String.format("%s" , daysDiff ));

    }

    //Calcualtes the amount of days between 2 Date.Type
    int daysBetween (Date dateStart, Date dateEnd){
        if(dateStart.getTime()>dateEnd.getTime()){
            Date temp = dateStart;
            dateStart = dateEnd;
            dateEnd = temp;
        }
        long difference = dateEnd.getTime() - dateStart.getTime();
        long daysBetween = (difference / (1000*60*60*24));
        int dayDiff = (int) daysBetween;
        return dayDiff;
    }

    //BIND To Add Button
    //Creates a dialog to create a new counter
    public void createDialog(View view){
        DialogFragment dialog = new DialogCreate();
        dialog.show(getSupportFragmentManager(), "Test3");
    }

    void createCount(Date startDate, String name, String  description, boolean notify, int goal){
        Count newCount = new Count(startDate, name ,description,notify, goal);
    }
}
