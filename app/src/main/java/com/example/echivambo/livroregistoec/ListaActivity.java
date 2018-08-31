package com.example.echivambo.livroregistoec;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DatabaseReference mDatabase;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<ConsultaPF> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
/*
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle("Livro de Registo");
        setSupportActionBar(toolbar);
        toolbar.getMenu().getItem(R.id.action_save).setVisible(false);
*/
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle("Livro de Registo");
        setSupportActionBar(toolbar);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_list_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MeusRegistosAdapter(getConsultaPF());
        mRecyclerView.setAdapter(mAdapter);

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






    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle app bar item clicks here. The app bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            case R.id.action_clearRegisto:
                displayToast("Limpar Campos");
                return true;

         //   case R.id.action_sync:
            //    displayToast("Sincronizar");
                /*
                Intent intent = new Intent(getApplicationContext(), ListaActivity.class);
                startActivity(intent);*/
         //       return true;

            case R.id.action_save: {
                displayToast("Salvar");

              return true;
            }

            case R.id.action_about: {
                Util.showMessage(this, "About", "Aqui virá uma breve descrição do aplicativo");
                return true;
            }
            case R.id.action_legal: {
                Util.showMessage(this, "Legal", "Direitos autorais\n \n \t\t\t\t\t\t\t\t\tSobre autores...");
                return true;
            }
            case R.id.action_sair: {
                Intent intencion = new Intent(this, LoginActivity.class);
                startActivity(intencion);
                return true;
            }
            case R.id.action_relatio:
                //         Intent intent = new Intent(this, SettingsActivity.class);
                //     startActivity(intent);
                //      return true;
            default:
                // Do nothing
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
