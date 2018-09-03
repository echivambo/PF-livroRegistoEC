package com.example.echivambo.livroregistoec;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.echivambo.livroregistoec.adapter.MyAdapter;
import com.example.echivambo.livroregistoec.model.Cabecalho;
import com.example.echivambo.livroregistoec.model.ConsultaPF;
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
    private Toolbar toolbar;
    @BindView(R.id.fbNewSession)
    FloatingActionButton _newSessionButton;

    @BindView(R.id.btnSearsh)
    Button _searchButton;

    @BindView(R.id.acNome)
    AutoCompleteTextView _acNomeUtente;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference mDatabase;
    private ArrayList<ConsultaPF> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguimento);
        ButterKnife.bind(this);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle("Livro de Registo");
        setSupportActionBar(toolbar);


        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        mDatabase = firebaseDatabase.getReference();

        lista = new ArrayList<>();

        ceateAdapter();

       // mAdapter.setOnC

        _newSessionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        _searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String nome = _acNomeUtente.getText().toString().toLowerCase();
                    if(!nome.isEmpty()) {
                        Query query = FirebaseDatabase.getInstance().getReference("consulta")
                                .orderByChild("nome")
                                .startAt(nome)
                                .endAt(nome + "\uf8ff");
                        query.addListenerForSingleValueEvent(valueEventListener);
                    }
                }catch (NullPointerException e){
                    Toast.makeText(getApplicationContext(),"Por favor preencha o campo!", Toast.LENGTH_LONG).show();
                }
            }
        });



    }

    public void ceateAdapter(){
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(this, lista);
        mRecyclerView.setAdapter(mAdapter);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

       // mAdapter
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


    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            final View view = getCurrentFocus();

            if (view != null) {
                final boolean consumed = super.dispatchTouchEvent(ev);

                final View viewTmp = getCurrentFocus();
                final View viewNew = viewTmp != null ? viewTmp : view;

                if (viewNew.equals(view)) {
                    final Rect rect = new Rect();
                    final int[] coordinates = new int[2];

                    view.getLocationOnScreen(coordinates);

                    rect.set(coordinates[0], coordinates[1], coordinates[0] + view.getWidth(), coordinates[1] + view.getHeight());

                    final int x = (int) ev.getX();
                    final int y = (int) ev.getY();

                    if (rect.contains(x, y)) {
                        return consumed;
                    }
                } else if (viewNew instanceof EditText || viewNew instanceof EditText) {
                    return consumed;
                }

                final InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

                inputMethodManager.hideSoftInputFromWindow(viewNew.getWindowToken(), 0);

                viewNew.clearFocus();

                return consumed;

            }
        }

        return super.dispatchTouchEvent(ev);
    }
}


