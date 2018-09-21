package com.example.echivambo.livroregistoec.config;

import android.content.Context;
import android.content.Intent;

import com.example.echivambo.livroregistoec.LoginActivity;
import com.example.echivambo.livroregistoec.MainActivity;
import com.google.firebase.auth.FirebaseUser;

public class Config {
    public static final String DB_NAME = "psi_livro_registo";
    public static final String DB_HOST = "192.168.56.1";
    //public static final String DB_HOST = "http://elerning.psi.evidevi.com";
    public static final int SYNCED_WITH_SERVER = 2;
    public static final int NOT_SYNCED_WITH_SERVER = 1;

    public static final int DB_VERSION = 1;

    private static FirebaseUser firebaseUser;

    public static void updateUI(FirebaseUser user, Context context) {
        if (firebaseUser != null) {
            firebaseUser = user;
        } else{
            firebaseUser = user;
            Intent myIntent = new Intent(context, LoginActivity.class);
            context.startActivity(myIntent);
        }
    }

    public static FirebaseUser getUI() {
        return firebaseUser;
    }
}