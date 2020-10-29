package reece.com.coldcount;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

/**
 * TODO: document your custom view class.
 */
public class DialogCreate extends DialogFragment {

    String dialogType;

    public DialogCreate (String dialogType){
        this.dialogType = dialogType;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int layoutResourceID = R.layout.dialog_create;
        if(dialogType == "Create"){
            layoutResourceID = R.layout.dialog_create;
        } else if(dialogType == "Goal"){
            layoutResourceID = R.layout.dialog_goal;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(layoutResourceID, null))
                // Add action buttons
                .setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Take info and create an account, push to database.

                        String Name;
                        int goal;
                        Boolean notfiy;

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DialogCreate.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

}