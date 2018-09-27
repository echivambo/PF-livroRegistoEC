package com.example.echivambo.livroregistoec;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.echivambo.livroregistoec.adapter.MeusRegistosAdapter;
import com.example.echivambo.livroregistoec.adapter.MyAdapter;
import com.example.echivambo.livroregistoec.config.Config;
import com.example.echivambo.livroregistoec.model.ConsultaPF;
import com.example.echivambo.livroregistoec.util.Util;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;


public class MeuRelatorioActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private WebView web;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_relatorio);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        WebView myWebView = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);


        //myWebView.loadUrl("https://www.evidencias.psi.org.mz/livro/public/meu-relatorio");
        //myWebView.loadUrl("http://127.0.0.1:8000/meu-relatorio1/"+LoginActivity.user_id.toLowerCase());
        myWebView.loadUrl("http://192.168.1.5/livro/public/meu-relatorio1/"+LoginActivity.user_id.toLowerCase());

        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.relatorio_menu, menu);

        return true;


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle app bar item clicks here. The app bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {

            //  case android.R.id.home:
            //    finish();
            //   return true;

            case R.id.action_about: {
                Util.showMessage(this, "About", "Aqui virá uma breve descrição do aplicativo");
                return true;
            }
            case R.id.action_legal: {
                Util.showMessage(this, "Legal", "Direitos autorais\n \n \t\t\t\t\t\t\t\t\tSobre autores...");
                return true;
            }
            case R.id.action_sair: {
                Util.logout(MeuRelatorioActivity.this, this);
                return true;
            }
            case R.id.action_novoregisto:
                //         Intent intent = new Intent(this, SettingsAtivity.class);
                //     startActivity(intent);
                //      return true;
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                return true;


            case android.R.id.home:
                // app icon in action bar clicked; go home


                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
                //  onBackPressed();

                return true;
            default:
                return super.onOptionsItemSelected(item);

            // Do nothing
        }

    }

    public class ToolbarConfigurer implements View.OnClickListener {
        private Activity activity;

        public ToolbarConfigurer(Activity activity, Toolbar toolbar, boolean displayHomeAsUpEnabled) {
            toolbar.setTitle((this.activity = activity).getTitle());
            if (!displayHomeAsUpEnabled) return;

            toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_ios_white_18);
            toolbar.setNavigationOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            NavUtils.navigateUpFromSameTask(activity);
        }

    }


}