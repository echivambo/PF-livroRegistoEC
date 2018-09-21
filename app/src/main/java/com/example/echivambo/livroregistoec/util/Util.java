package com.example.echivambo.livroregistoec.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.EditText;

import com.example.echivambo.livroregistoec.LoginActivity;
import com.example.echivambo.livroregistoec.config.Config;
import com.example.echivambo.livroregistoec.model.ConsultaPF;
import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
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
/*
    public static void checkIfIsLogedIn(Activity activity){
        if (LoginActivity.user == null){
            Intent intencion = new Intent(activity, LoginActivity.class);
            activity.startActivity(intencion);
        }

    }
    */

    public static void logout(final Activity activity, final Context context){
        new AlertDialog.Builder(context)
                .setTitle("Sair do aplicativo?")
                .setMessage("Deseja sair do aplicativo?")
                .setNegativeButton("Não", null)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        FirebaseAuth.getInstance().signOut();
                        Config.updateUI(null, context);
                        Intent intencion = new Intent(context, LoginActivity.class);
                        activity.startActivity(intencion);
                    }

                }).create().show();
    }


    public static ArrayList<ConsultaPF> removDuplicate(ArrayList<ConsultaPF> list){
        for (int i=0; i<list.size(); i++)
            for (int j=0; j<list.size(); j++){
                if (list.get(i).getNome().equalsIgnoreCase(list.get(j).getNome())){
                    if(list.get(i).getNumero_consulta() < list.get(j).getNumero_consulta())
                        list.remove(list.get(i));
                    else
                        list.remove(list.get(j));
                }
            }
        return list;
    }

}
