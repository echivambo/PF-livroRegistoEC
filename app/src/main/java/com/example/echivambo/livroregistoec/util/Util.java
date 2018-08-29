package com.example.echivambo.livroregistoec.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Util {
    /**
     * Formatar a data
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        String myFormat = "dd-MM-yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        return sdf.format(date.getTime());
    }

    public static void showMessage(Context context, String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // Add the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        builder.setMessage(message)
                .setTitle(title);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public static void setDataPiker(Calendar myCalendar, EditText edittext) {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalendar.getTime()));
    }

}
