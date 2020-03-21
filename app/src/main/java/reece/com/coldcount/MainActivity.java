package reece.com.coldcount;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    long[] startTimes;
    long currentTime;
    int primaryTimeIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentTime = Calendar.getInstance().getTimeInMillis();
        // Change to database
        int startTimeLength = 10;
        primaryTimeIndex = 0;
        startTimes = new long[startTimeLength];
        populateSampleTimes();
        populatePrimaryCounter();
    }

    //Sample Times for debugging
    void populateSampleTimes (){
        startTimes[0] = 1583069551000L;
        for(int  i = 1; i<10; i++){
            startTimes[i] = 1583069551000L;
        }
    }

    //Populates the primary day counter
    void populatePrimaryCounter(){
        TextView primaryTextView = findViewById(R.id.PrimaryTime_TextView);
        int daysDiff = daysBetween(startTimes[primaryTimeIndex], currentTime);
        primaryTextView.setText( String.format("%s" , daysDiff ));

    }

    //Calcualtes the amount of days between 2 Date.Type
    int daysBetween (Long dateStart, Long dateEnd){
        long msDiff = dateEnd-dateStart;
        int daysDiff = (int) TimeUnit.MILLISECONDS.toDays(msDiff);
        return daysDiff;
    }

    //BIND To Add Button
    //Creates a dialog to create a new counter
    public void createDialog(View view){
        DialogFragment dialog = new DialogCreate();
        dialog.show(getSupportFragmentManager(), "Test3");
    }

}
