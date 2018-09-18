package com.example.echivambo.livroregistoec;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.example.echivambo.livroregistoec.adapter.MeusRegistosAdapter;
import com.example.echivambo.livroregistoec.adapter.MyAdapter;
import com.example.echivambo.livroregistoec.model.ConsultaPF;
import com.example.echivambo.livroregistoec.util.Util;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference mDatabase;
    private ArrayList<ConsultaPF> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        //Util.checkIfIsLogedIn(ListaActivity.this);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        new ToolbarConfigurer(this, (Toolbar) findViewById(R.id.toolBar), true);

        toolbar.setTitle("Livro de Registo");
        setSupportActionBar(toolbar);
        lista = new ArrayList<>();

        firebaseDatabase = FirebaseDatabase.getInstance();

        ceateAdapter();

        try {
           // mDatabase = FirebaseDatabase.getInstance().getReference("consulta");
           // mDatabase.addListenerForSingleValueEvent(valueEventListener);

            Query query = FirebaseDatabase.getInstance().getReference("consulta")
                    .orderByChild("user_id")
                    //.orderByChild("codigo_consulta")
                    .equalTo(LoginActivity.user_id.toLowerCase())
                    .limitToLast(25);
            query.addListenerForSingleValueEvent(valueEventListener);

        }catch (Exception e){
            Toast.makeText(this, "Erro ao ler registo \n"+e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void ceateAdapter(){
        mRecyclerView = (RecyclerView) this.findViewById(R.id.my_list_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // specify an adapter (see also next example)
        mAdapter = new MeusRegistosAdapter(this, lista);
        mRecyclerView.setAdapter(mAdapter);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            lista.clear();
            if(dataSnapshot.exists()) {
                for (DataSnapshot obj : dataSnapshot.getChildren()) {
                    ConsultaPF consultaPF = obj.getValue(ConsultaPF.class);
                    lista.add(consultaPF);
                    System.out.println(consultaPF.toString());
                }
            }
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    private ArrayList<ConsultaPF> getConsultaPF() {
        final ArrayList<ConsultaPF> lista = new ArrayList<>();

        mDatabase.child("consulta").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lista.clear();
                for (DataSnapshot obj: dataSnapshot.getChildren()){
                    ConsultaPF consultaPF = obj.getValue(ConsultaPF.class);
                    lista.add(consultaPF);
                    System.out.println(consultaPF.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return lista;
    }


    /*public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;

    }*/


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lista_menu, menu);

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
                Util.logout(ListaActivity.this, this);
                return true;
            }
            case R.id.action_relatio:
                //         Intent intent = new Intent(this, SettingsActivity.class);
                //     startActivity(intent);
                //      return true;


            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
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

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
