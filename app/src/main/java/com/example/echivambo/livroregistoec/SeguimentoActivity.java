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
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.echivambo.livroregistoec.adapter.MyAdapter;
import com.example.echivambo.livroregistoec.model.Cabecalho;
import com.example.echivambo.livroregistoec.model.ConsultaPF;
import com.example.echivambo.livroregistoec.model.auxiliar.UtentePF;
import com.example.echivambo.livroregistoec.util.Util;
import com.google.firebase.auth.FirebaseUser;
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

    @BindView(R.id.rbFezConsulta)
    RadioButton _rbFezConsulta;

    @BindView(R.id.rbNaoFezConsulta)
    RadioButton _rbNaoFezConsulta;

    @BindView(R.id.tvNome)
    TextView _tvNome;

    @BindView(R.id.rlNomeSearsh)
    RelativeLayout _rlNomeSearsh;

    @BindView(R.id.rlFloatButton)
    RelativeLayout _rlFloatButton;

    @BindView(R.id.my_recycler_view)
    RecyclerView _my_recycler_view;

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

        //Util.checkIfIsLogedIn(SeguimentoActivity.this);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle("Livro de Registo");
        setSupportActionBar(toolbar);

        mDatabase = FirebaseDatabase.getInstance().getReference();

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

        _rbFezConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _tvNome.setVisibility(TextView.VISIBLE);
                _rlNomeSearsh.setVisibility(RelativeLayout.VISIBLE);
                _rlFloatButton.setVisibility(FloatingActionButton.GONE);
                _my_recycler_view.setVisibility(RecyclerView.VISIBLE);
            }
        });

        _rbNaoFezConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _tvNome.setVisibility(TextView.GONE);
                _rlNomeSearsh.setVisibility(RelativeLayout.GONE);
                _rlFloatButton.setVisibility(FloatingActionButton.VISIBLE);
                _my_recycler_view.setVisibility(RecyclerView.GONE);
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


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.seguimento_menu, menu);

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
                Util.logout(SeguimentoActivity.this, this);
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


