package reece.com.coldcount;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    Count count;
    int primaryTimeIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = new Count("test", true, 31);

        primaryTimeIndex = 0;
        populatePrimaryCounter();
    }


    //Populates the primary day counter
    void populatePrimaryCounter(){
        TextView primaryTextView = findViewById(R.id.PrimaryTime_TextView);
        primaryTextView.setText(String.format("%s Days", count.daysSince()));

    }


    //BIND To Add Button
    //Creates a dialog to create a new counter
    public void createDialog(View view){
        DialogFragment dialog = new DialogCreate("Create");
        dialog.show(getSupportFragmentManager(), "Create");
    }

    //BIND To Goal Button
    //Creates a dialog to create a new counter
    public void goalDialog(View view){
        DialogFragment dialog = new DialogCreate("Goal");
        dialog.show(getSupportFragmentManager(), "Goal");
    }


}
