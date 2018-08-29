package com.example.echivambo.livroregistoec;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.echivambo.livroregistoec.adapter.MyAdapter;
import com.example.echivambo.livroregistoec.model.Cabecalho;
import com.example.echivambo.livroregistoec.model.auxiliar.UtentePF;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeguimentoActivity extends AppCompatActivity {
    @BindView(R.id.fbSeguimento)
    FloatingActionButton _searchButton;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference mDatabase;
    private List<UtentePF> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguimento);
        ButterKnife.bind(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        mDatabase = firebaseDatabase.getReference();

        lista = new ArrayList<>();

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(getUtentes());
        mRecyclerView.setAdapter(mAdapter);

        _searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        eventDatabase();
    }

    private void eventDatabase() {
        mDatabase.child("cabecalho").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lista.clear();
                for (DataSnapshot obj: dataSnapshot.getChildren()){
                    Cabecalho cabecalho = obj.getValue(Cabecalho.class);
                    System.out.println(cabecalho.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private ArrayList<UtentePF> getUtentes(){
        final ArrayList<UtentePF> lista = new ArrayList<>();
        /*
        lista.add(new UtentePF("Edna Manuel", "sssv", "kkks","cod1"));
        lista.add(new UtentePF("Joana Zaida", "5555", "ffff","cod21"));
        lista.add(new UtentePF("M Zaida", "44", "5","cod2"));
        */

        String usuarioPf = "LKr2u8zkIsTeeH2YKkb";
        Query myTopPostsQuery = mDatabase.child("cabecalho").child(usuarioPf)
                .orderByChild("starCount");
        myTopPostsQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Cabecalho cabecalho = dataSnapshot.getValue(Cabecalho.class);
                System.out.println("Leitura de dados (onChildAdded): "+cabecalho.getNid_csr_pf());
                lista.add(new UtentePF("Edsna", cabecalho.getNid_csr_pf(), cabecalho.getNid_tarv(), cabecalho.getCodigo_consulta()));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Cabecalho cabecalho = dataSnapshot.getValue(Cabecalho.class);
                System.out.println("Leitura de dados (onChildChanged): "+cabecalho.getNid_csr_pf());
                lista.add(new UtentePF("Edsna", cabecalho.getNid_csr_pf(), cabecalho.getNid_tarv(), cabecalho.getCodigo_consulta()));
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
            // TODO: implement the ChildEventListener methods as documented above
            // ...
        });

        return lista;
    }
}
