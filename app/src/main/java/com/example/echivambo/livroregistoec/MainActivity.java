package com.example.echivambo.livroregistoec;
/**
 * @Auth Edson Chivambo
 * @Email edsonchivambo@gmail.com
 */

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.echivambo.livroregistoec.adapter.MyAdapter;
import com.example.echivambo.livroregistoec.config.Config;
import com.example.echivambo.livroregistoec.model.Cabecalho;
import com.example.echivambo.livroregistoec.model.ConsultaPF;
import com.example.echivambo.livroregistoec.model.DadosPessoais;
import com.example.echivambo.livroregistoec.model.ExameClinico;
import com.example.echivambo.livroregistoec.model.PlaneamentoFamiliar;
import com.example.echivambo.livroregistoec.model.RHIVSeguimento;
import com.example.echivambo.livroregistoec.model.RTCancroColoUterino;
import com.example.echivambo.livroregistoec.model.RTSiflis;
import com.example.echivambo.livroregistoec.model.TransferidaPorPara;
import com.example.echivambo.livroregistoec.model.auxiliar.ExameDaMama;
import com.example.echivambo.livroregistoec.model.auxiliar.MetodoSelecionado;
import com.example.echivambo.livroregistoec.util.Util;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ExpandableRelativeLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5, expandableLayout6, expandableLayout7, expandableLayout8;
    Toolbar toolbar;

    private RadioButton rPipula, rInjetavel, rDiu, rImplante;

    private RadioButton rExameDaMamaSim;

    private RadioButton rExameDeViaSim;

    private RadioButton rOutroMetodo;

    private List<String> metodos;

    private EditText etDataConsulta;
    private EditText etNumeroConsulta;
    private EditText etNidCSRF;
    private EditText etNidTarv;
    private EditText etEtNumeroConsulta;
    private RadioGroup rgParceiro_presente_na_csr_pf;
    private RadioButton rbParceiro_presente_na_csr_pf;
    private Button bSalvarCabecalho;
    private Cabecalho cabecalho;

    /*
       DADOS PESSOAIS
    */
    private EditText etNome;
    private EditText etResidencia;
    private EditText etContacto;
    private RadioGroup rgSexo;
    private RadioGroup rgFaixaEtaria;
    private RadioButton rbSexo;
    private RadioButton rbFaixaEtaria;
    private Button bSalvarDadosPessoais;

    //EXAME CLINICO
    private RadioGroup rgRastreio_e_tratamento_de_its;
    private RadioButton rbRastreio_e_tratamento_de_its;
    private EditText etOutras_patologias;
    private RadioGroup rgTransferida;
    private RadioButton rbTransferida;
    private ExameDaMama exameDaMama;
    private Button bSalvarExameClinico;
    private RadioGroup rgFez_exame_clinico_da_mama;

    //RASTREAMENTO E TRATAMENTO DE CANCRO DO COLO UTERINO
    private RadioGroup rgFez_exameme_de_via;
    private RadioGroup rgCrioterapia;
    private RadioGroup rgTransferidaRTCCU;
    private RadioButton rbFez_exameme_de_via;
    private RadioButton rbCrioterapia;
    private RadioButton rbTransferidaRTCCU;
    private String resultadoRastreioTratamentoCancroColoUterino = "";
    private Button bRTCancroColoUterino;

    //RASTREAMENTO E TRATAMENTO DE SIFLES
    private RadioGroup rgEstado_a_entrada_na_csr_pf;
    private RadioGroup rgResultado_do_teste_feito_na_csr_pf;
    private RadioGroup rgTratamento_do_utente_dose_recebida;
    private RadioGroup rgParceiro_recebeu_tratamento_na_csr_pf;
    private RadioButton rbEstado_a_entrada_na_csr_pf;
    private RadioButton rbResultado_do_teste_feito_na_csr_pf;
    private RadioButton rbTratamento_do_utente_dose_recebida;
    private RadioButton rbParceiro_recebeu_tratamento_na_csr_pf;
    private Button bRTSiflis;

    //RASTREAMENTO E DE HIV E SEGUIMENTO
    private RadioGroup rgSeroestado_a_entrada_1a_csr_pf;
    private RadioGroup rgTeste_de_hiv_na_consulta_de_csr;
    private RadioGroup rgTarv;
    private RadioGroup rgTestagem_do_parceiro;
    private RadioButton rbSeroestado_a_entrada_1a_csr_pf;
    private RadioButton rbTeste_de_hiv_na_consulta_de_csr;
    private RadioButton rbTarv;
    private RadioButton rbTestagem_do_parceiro;
    private Button brHIVSeguimento;

    //TRANSFERIDA PLANEAMENTO FAMILIAR
    private RadioGroup rgUtentePF;
    private RadioGroup rgMetodoPF;
    private RadioButton rbUtentePF;
    private RadioButton rbMetodoPF;
    private CheckBox cbPreservativo;
    private Spinner sMetodoAnterior;
    private Button bPlanamentoFamiliar;
    private ArrayList<MetodoSelecionado> listMetodoSelecionado;

    //TRANSFERIDA POR/PARA
    private RadioGroup rgTranferidoPorPara;
    private RadioButton rbTranferidoPorPara;
    private EditText etObservacao;
    private Button bTransferidaPorPara;
    @BindView(R.id.ettransferidaOutro)
    EditText _ettransferidaOutro;

    private DatabaseReference mDatabase;

    private String consultaPF_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Util.checkIfIsLogedIn(MainActivity.this);

        mDatabase = FirebaseDatabase.getInstance().getReference();




        toolbar = (Toolbar) findViewById(R.id.toolBar);
        new ToolbarConfigurer(this, (Toolbar) findViewById(R.id.toolBar), true);

        toolbar.setTitle("Livro de Registo");
        setSupportActionBar(toolbar);


        metodos = new ArrayList<>();
        metodos.add("Deixou de fazer...");
        metodos.add("Pilula");
        metodos.add("Injetavel");
        metodos.add("Implante");
        metodos.add("DIU");


        //CABECALHO
        etDataConsulta = (EditText) findViewById(R.id.dataDaConsulta);
        etNumeroConsulta = (EditText) findViewById(R.id.etNumeroConsulta);
        etNumeroConsulta.setText(1+"");
        etNidCSRF = (EditText) findViewById(R.id.etNid_csr_pf);
        etNidTarv = (EditText) findViewById(R.id.etNid_tarv);
        rgParceiro_presente_na_csr_pf = (RadioGroup) findViewById(R.id.rgParceiro_presente_na_csr_pf);


        //DADOS PESSOAIS
        etNome = (EditText) findViewById(R.id.nome);
        etResidencia = (EditText) findViewById(R.id.residencia);
        etContacto = (EditText) findViewById(R.id.contacto);
        rgSexo = (RadioGroup) findViewById(R.id.rgSexo);
        rgFaixaEtaria = (RadioGroup) findViewById(R.id.rgFaixaEtaria);

        //EXAME CLINICO
        rgRastreio_e_tratamento_de_its = (RadioGroup) findViewById(R.id.rgRastreio_tratamento_its);
        etOutras_patologias = (EditText) findViewById(R.id.etOutrasPatologias);
        rgTransferida = (RadioGroup) findViewById(R.id.rgTransferida);
        rgFez_exame_clinico_da_mama = (RadioGroup) findViewById(R.id.rgFez_exame_clinico_da_mama);
        exameDaMama = new ExameDaMama("", "");

        //RASTREAMENTO E TRATAMENTO DE CANCRO DO COLO UTERINO
        rgFez_exameme_de_via = (RadioGroup) findViewById(R.id.rgFezExameVia);
        rgCrioterapia = (RadioGroup) findViewById(R.id.rgCrioterapia);
        rgTransferidaRTCCU = (RadioGroup) findViewById(R.id.rgTransferidaRTCU);

        //RASTREAMENTO E TRATAMENTO DE SIFLIS
        rgEstado_a_entrada_na_csr_pf = (RadioGroup) findViewById(R.id.rgEstado_a_entrada_na_csr_pf);
        rgResultado_do_teste_feito_na_csr_pf = (RadioGroup) findViewById(R.id.rgResultado_do_teste_feito_na_csr_pf);
        rgTratamento_do_utente_dose_recebida = (RadioGroup) findViewById(R.id.rgTratamento_do_utente_dose_recebida);
        rgParceiro_recebeu_tratamento_na_csr_pf = (RadioGroup) findViewById(R.id.rgParceiro_recebeu_tratamento_na_csr_pf);

        //RASTREAMENTO DE HIV E SEGUIMENTO
        rgSeroestado_a_entrada_1a_csr_pf = (RadioGroup) findViewById(R.id.rgSeroestado_a_entrada_1a_csr_pf);
        rgTeste_de_hiv_na_consulta_de_csr = (RadioGroup) findViewById(R.id.rgTeste_de_hiv_na_consulta_de_csr);
        rgTarv = (RadioGroup) findViewById(R.id.rgTarv);
        rgTestagem_do_parceiro = (RadioGroup) findViewById(R.id.rgTestagem_do_parceiro);

        //PLANEAMENTO FAMILIAR
        rgUtentePF = (RadioGroup) findViewById(R.id.rgUtentePF);
        rgMetodoPF = (RadioGroup) findViewById(R.id.rgMetodoPF);
        cbPreservativo = (CheckBox) findViewById(R.id.cbPreservativo);
        sMetodoAnterior = (Spinner) findViewById(R.id.sMetodoAnterior);
        fillSpinner(sMetodoAnterior, metodos);
        listMetodoSelecionado = new ArrayList<>();

        //TRANFERIDA POR PARA
        etObservacao = (EditText) findViewById(R.id.etObservacoes);
        rgTranferidoPorPara = (RadioGroup) findViewById(R.id.rgTransferidaPorPara);

        etDataConsulta.setText(Util.formatDate(new Date()));

        final Calendar myCalendar = Calendar.getInstance();
        etDataConsulta.setOnClickListener(new View.OnClickListener() {
            final Calendar myCalendar = Calendar.getInstance();
            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, month);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                    Util.setDataPiker(myCalendar, etDataConsulta);
/*
                    ActionBar actionBar = getActionBar();
                    actionBar.setDisplayHomeAsUpEnabled(true);
                    */

                }
            };

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        rPipula = (RadioButton) findViewById(R.id.rPilula);
        rInjetavel = (RadioButton) findViewById(R.id.rInjetavela);
        rDiu = (RadioButton) findViewById(R.id.rDiu);
        rImplante = (RadioButton) findViewById(R.id.rImplante);
        rExameDaMamaSim = (RadioButton) findViewById(R.id.rExameDaMamaSim);
        rExameDeViaSim = (RadioButton) findViewById(R.id.rExameDeViaSim);
        rOutroMetodo = (RadioButton) findViewById(R.id.rOutroMetodo);

        rPipula.setOnClickListener(this);
        rInjetavel.setOnClickListener(this);
        rDiu.setOnClickListener(this);
        rImplante.setOnClickListener(this);
        rExameDaMamaSim.setOnClickListener(this);
        rExameDeViaSim.setOnClickListener(this);
        rOutroMetodo.setOnClickListener(this);
        cbPreservativo.setOnClickListener(this);

        Intent intent = getIntent();
        ConsultaPF consultaPF = intent.getParcelableExtra("consulta");
        //Toast.makeText(this,"consulta "+consultaPF.getNumero_consulta(), Toast.LENGTH_LONG).show();
        if (consultaPF!=null) {
            etNumeroConsulta.setText((consultaPF.getNumero_consulta() + 1) + "");
            etDataConsulta.setText(consultaPF.getData_consulta() + "");
            etNidCSRF.setText(consultaPF.getNid_csr_pf());
            etNidTarv.setText(consultaPF.getNid_tarv());
            rgParceiro_presente_na_csr_pf.check(checkRB(rgParceiro_presente_na_csr_pf, consultaPF.getParceiro_presente_na_csr_pf()));

            //DADOS PESSOAIS
            etNome.setText(consultaPF.getNome());
            etResidencia.setText(consultaPF.getResidencia());
            etContacto.setText(consultaPF.getContacto());
            rgSexo.check(checkRB(rgSexo, consultaPF.getSexo()));
            rgFaixaEtaria.check(checkRB(rgFaixaEtaria, consultaPF.getFaixa_etaria()));

            //EXAME CLINICO
            rgRastreio_e_tratamento_de_its.check(checkRB(rgRastreio_e_tratamento_de_its, consultaPF.getRastreio_e_tratamento_de_its()));
            etOutras_patologias.setText(consultaPF.getOutras_patologias());
            rgTransferida.check(checkRB(rgTransferida, consultaPF.getTransferida_ec()));
            rgFez_exame_clinico_da_mama.check(checkRB(rgFez_exame_clinico_da_mama, consultaPF.getFez_exame_clinico_da_mama()));

            //RASTREAMENTO E TRATAMENTO DE CANCRO DO COLO UTERINO
            rgFez_exameme_de_via.check(checkRB(rgFez_exameme_de_via, consultaPF.getFez_exameme_de_via()));
            rgCrioterapia.check(checkRB(rgCrioterapia, consultaPF.getCrioterapia()));
            rgTransferidaRTCCU.check(checkRB(rgTransferidaRTCCU, consultaPF.getTransferida_ccu()));

            //RASTREAMENTO E TRATAMENTO DE SIFLIS
            rgEstado_a_entrada_na_csr_pf.check(checkRB(rgEstado_a_entrada_na_csr_pf, consultaPF.getEstado_a_entrada_na_csr_pf()));
            rgResultado_do_teste_feito_na_csr_pf.check(checkRB(rgResultado_do_teste_feito_na_csr_pf, consultaPF.getResultado_do_teste_feito_na_csr_pf()));
            rgTratamento_do_utente_dose_recebida.check(checkRB(rgTratamento_do_utente_dose_recebida, consultaPF.getTratamento_do_utente_dose_recebida()));
            rgParceiro_recebeu_tratamento_na_csr_pf.check(checkRB(rgParceiro_recebeu_tratamento_na_csr_pf, consultaPF.getParceiro_recebeu_tratamento_na_csr_pf()));

            //RASTREAMENTO DE HIV E SEGUIMENTO
            rgSeroestado_a_entrada_1a_csr_pf.check(checkRB(rgSeroestado_a_entrada_1a_csr_pf, consultaPF.getSeroestado_a_entrada_1a_csr_pf()));
            rgTeste_de_hiv_na_consulta_de_csr.check(checkRB(rgTeste_de_hiv_na_consulta_de_csr, consultaPF.getTeste_de_hiv_na_consulta_de_csr()));
            rgTarv.check(checkRB(rgTarv, consultaPF.getTarv()));
            rgTestagem_do_parceiro.check(checkRB(rgTestagem_do_parceiro, consultaPF.getTestagem_do_parceiro()));

            //TRANFERIDA POR PARA
            etObservacao.setText(consultaPF.getObservacao());
            rgTranferidoPorPara.check(checkRB(rgTranferidoPorPara, consultaPF.getTransferida_por_para()));
            // Toast.makeText(this,"nr filhos "+checkRB(consultaPF.getParceiro_presente_na_csr_pf()),Toast.LENGTH_LONG).show();

            //PLANEAMENTO FAMILIAR
            rgUtentePF.check(rgUtentePF.getChildAt(1).getId());
            /*rgMetodoPF = (RadioGroup) findViewById(R.id.rgMetodoPF);
            cbPreservativo = (CheckBox) findViewById(R.id.cbPreservativo);
            sMetodoAnterior = (Spinner) findViewById(R.id.sMetodoAnterior);*/
        }

        rgTranferidoPorPara.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.transferidaOutro: {
                        _ettransferidaOutro.setVisibility(EditText.VISIBLE);
                    }
                    break;
                    default:{
                        _ettransferidaOutro.setVisibility(EditText.GONE);
                    }
                }
            }
        });
    }

    private int checkRB(RadioGroup radioGroup, String texto){
       int nrRB = radioGroup.getChildCount();
       RadioButton radioButton;
       for (int i=0; i<nrRB; i++){
           int rbID = radioGroup.getChildAt(i).getId();
           radioButton = (RadioButton) findViewById(rbID);
           if (radioButton.getText().toString().equalsIgnoreCase(texto)){
                return rbID;
           }
       }
       return -1;
    }

    private String validarCampos(EditText editText){
        if(TextUtils.isEmpty(editText.getText().toString()))
            return "";
        else
            return editText.getText().toString().toLowerCase();
    }

    private String gerarCodigoConsulta(){
        Date date = new Date();
        String myFormat = "ddMMyyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        //data_nidCsrPF@numero_consulta.userID
        return sdf.format(date.getTime())+"_"+etNidCSRF.getText().toString()+"@"+etNumeroConsulta.getText().toString()+"."+ LoginActivity.user_id.toLowerCase();
    }

    //PLANEAMENTO FAMILIAR
    private ArrayList<PlaneamentoFamiliar> criarPlaneamentoFamiliar() {
        ArrayList<PlaneamentoFamiliar> list = new ArrayList<>();
        // get selected radio button from radioGroup
        int selectedMetodoPF = rgMetodoPF.getCheckedRadioButtonId();
        int selectedUtentePF = rgUtentePF.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        rbMetodoPF = (RadioButton) findViewById(selectedMetodoPF);
        rbUtentePF = (RadioButton) findViewById(selectedUtentePF);

        String utente_pf = getRBSelectedFromGroup(rgUtentePF);
        String metodo_anterior = sMetodoAnterior.getSelectedItem().toString();
        if (metodo_anterior.equalsIgnoreCase("Deixou de fazer...")) {
            metodo_anterior = "";
        }

        String metodo_do_pf = "";
        if (selectedMetodoPF > 0 && !cbPreservativo.isChecked())
            metodo_do_pf = getRBSelectedFromGroup(rgMetodoPF);
        else
            metodo_do_pf = "Preservativos".toLowerCase();

        String codigo_consulta = gerarCodigoConsulta().toLowerCase();
        int status = Config.NOT_SYNCED_WITH_SERVER;
        String user_id = LoginActivity.user_id.toLowerCase();

        if (metodo_do_pf.equalsIgnoreCase("diu") || metodo_do_pf.equalsIgnoreCase("implante") || metodo_do_pf.equalsIgnoreCase("pílula") || metodo_do_pf.equalsIgnoreCase("injectável") || metodo_do_pf.equalsIgnoreCase("outro") || cbPreservativo.getText().toString().equalsIgnoreCase("Preservativos")) {
            for (MetodoSelecionado m : listMetodoSelecionado) {
                String tipo_do_metodo_do_pf = m.getTipoMetodo().toLowerCase();
                String estado_da_utente_no_metodo = m.getEstadoUsuario().toLowerCase();
                int total_distribuido = m.getQuantidadeDistribuida();

                list.add(new PlaneamentoFamiliar(utente_pf, m.getMetodo(), tipo_do_metodo_do_pf, estado_da_utente_no_metodo, total_distribuido, metodo_anterior, codigo_consulta, status, user_id));
            }
        } else {
            list.add(new PlaneamentoFamiliar(utente_pf, metodo_do_pf, " ", " ", 0, " ", codigo_consulta, status, user_id));
        }
        return list;
    }

    private void savePF(){
        for (PlaneamentoFamiliar p : criarPlaneamentoFamiliar()) {
            String key = mDatabase.child("planiamento-familiar").push().getKey();
            Map<String, Object> postValues = p.toMap();

            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("/planiamento_familiar/" + key, postValues);
            childUpdates.put("/consulta-vs-planiamento_familiar/" + consultaPF_id + "/" + key, postValues);

            mDatabase.updateChildren(childUpdates);
        }
        listMetodoSelecionado.clear();
    }

    //dispatchTouichEvent with coordinate to hide keyboard when when we click out of EditText
    @Override

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

    public void expandableButton1(View view) {
        expandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1);
        expandableLayout1.toggle(); // toggle expand and collapse
    }

    public void expandableButton2(View view) {
        expandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout2);
        expandableLayout2.toggle(); // toggle expand and collapse
    }

    public void expandableButton3(View view) {
        expandableLayout3 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout3);
        expandableLayout3.toggle(); // toggle expand and collapse
    }

    public void expandableButton4(View view) {
        expandableLayout4 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout4);
        expandableLayout4.toggle(); // toggle expand and collapse
    }

    public void expandableButton5(View view) {
        expandableLayout5 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout5);
        expandableLayout5.toggle(); // toggle expand and collapse
    }

    public void expandableButton6(View view) {
        expandableLayout6 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout6);
        expandableLayout6.toggle(); // toggle expand and collapse
    }

    public void expandableButton7(View view) {
        expandableLayout7 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout7);
        expandableLayout7.toggle(); // toggle expand and collapse
    }

    public void expandableButton8(View view) {
        expandableLayout8 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout8);
        expandableLayout8.toggle(); // toggle expand and collapse
    }

    private void alertBox() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        LayoutInflater inflater = MainActivity.this.getLayoutInflater();
        final View mView = inflater.inflate(R.layout.select_methoddiu, null);
        //final TextView tvMetodo = (TextView) mView.findViewById(R.id.tvMetodoINJ);
        final RadioGroup rgEstadoUtente = (RadioGroup) mView.findViewById(R.id.novaContinuadora);


        int selectedMetodo = rgMetodoPF.getCheckedRadioButtonId();
        rbMetodoPF = (RadioButton) findViewById(selectedMetodo);
        //tvMetodo.setText(rbMetodoPF.getText().toString());


        builder.setView(mView)
                //.setTitle("")
                // Add action buttons
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                int selectedEstadoUtente = rgEstadoUtente.getCheckedRadioButtonId();
                                if (selectedEstadoUtente == -1) {
                                    Toast.makeText(getApplicationContext(), "Selecione uma opção", Toast.LENGTH_LONG).show();
                                    rgMetodoPF.clearCheck();
                                } else{
                                    RadioButton rbEstadoUtente = mView.findViewById(selectedEstadoUtente);
                                    String estadoUsuario = rbEstadoUtente.getText().toString();
                                String metodo = rbMetodoPF.getText().toString();
                                String tipoMetodo = rbMetodoPF.getText().toString();
                                int quantidadeDistribuida = 1;

                                MetodoSelecionado metodoSelecionado = new MetodoSelecionado(estadoUsuario, metodo, tipoMetodo, quantidadeDistribuida);
                                listMetodoSelecionado.add(metodoSelecionado);
                              }
                            }
                        })
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private void alertBoxPreservativo() {
        if (cbPreservativo.isChecked()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            LayoutInflater inflater = MainActivity.this.getLayoutInflater();
            final View mView = inflater.inflate(R.layout.select_method_preservativo, null);
            final RadioGroup rgEstafoMetotodoPreservativo = (RadioGroup) mView.findViewById(R.id.rgEstafoMetotodoPreservativo);
            final RadioGroup rgTipoPreservativos = (RadioGroup) mView.findViewById(R.id.rgTipoPreservativos);
            final EditText etNumeroPDistribuido = (EditText) mView.findViewById(R.id.etNumeroPDistribuido);

            builder.setView(mView)
                    //.setTitle("")
                    // Add action buttons
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    if (cbPreservativo.isChecked()) {
                                        int selectedEstadoUtente = rgEstafoMetotodoPreservativo.getCheckedRadioButtonId();
                                        int selectedTipoPreservativo = rgTipoPreservativos.getCheckedRadioButtonId();
                                        if (selectedEstadoUtente == -1 || selectedTipoPreservativo == -1) {
                                            Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_LONG).show();
                                            cbPreservativo.setChecked(false);
                                        } else {
                                            RadioButton rbEstafoMetotodoPreservativo = (RadioButton) mView.findViewById(selectedEstadoUtente);
                                            RadioButton rbTipoPreservativos = (RadioButton) mView.findViewById(selectedTipoPreservativo);

                                            String estadoUsuario = rbEstafoMetotodoPreservativo.getText().toString();
                                            String metodo = cbPreservativo.getText().toString();
                                            String tipoMetodo = rbTipoPreservativos.getText().toString();
                                            int quantidadeDistribuida = Integer.parseInt(etNumeroPDistribuido.getText().toString());

                                            MetodoSelecionado metodoSelecionado = new MetodoSelecionado(estadoUsuario, metodo, tipoMetodo, quantidadeDistribuida);
                                            listMetodoSelecionado.add(metodoSelecionado);
                                        }
                                    }

                                }
                            })
                    .setNegativeButton("Cancelar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    cbPreservativo.setChecked(false);
                                    dialog.cancel();
                                }
                            });


            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

    }

    private void fillTipoMetodo(String metodo, View mView) {
        RadioButton rbMetodo1 = (RadioButton) mView.findViewById(R.id.rbMetodo1);
        RadioButton rbMetodo2 = (RadioButton) mView.findViewById(R.id.rbMetodo2);
        RadioButton rbZarin = (RadioButton) mView.findViewById(R.id.rbZarin);
        EditText etCiclosDistribuidos = (EditText) mView.findViewById(R.id.etCiclosDistribuidos);

        if (metodo.equalsIgnoreCase("pílula")) {
            rbMetodo1.setText("Microlut");
            rbMetodo2.setText("Microgynon");
            rbZarin.setVisibility(View.GONE);
        } else if (metodo.equalsIgnoreCase("Injectável")) {
            rbMetodo1.setText("Depo");
            rbMetodo2.setText("Sayana Press");
            etCiclosDistribuidos.setText("1");
            etCiclosDistribuidos.setVisibility(View.INVISIBLE);
            rbZarin.setVisibility(View.GONE);
        } else if (metodo.equalsIgnoreCase("Implante")) {
            rbMetodo1.setText("Jadelle");
            rbMetodo2.setText("Implanon");
            etCiclosDistribuidos.setText("1");
            etCiclosDistribuidos.setVisibility(View.INVISIBLE);
        }
    }

    private void alertBoxPill() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        LayoutInflater inflater = MainActivity.this.getLayoutInflater();
        final View mView = inflater.inflate(R.layout.select_methodpilula, null);
        final RadioGroup rgEstadoUtente = (RadioGroup) mView.findViewById(R.id.rgEstadoUtentePilula);
        final RadioGroup rgTipoPilula = (RadioGroup) mView.findViewById(R.id.rgTipoPilula);
        final EditText etOutraPilulaNome = (EditText) mView.findViewById(R.id.etOutraPilulaNome);
        final EditText etCiclosDistribuidos = (EditText) mView.findViewById(R.id.etCiclosDistribuidos);

        final TextView tvMetodo = (TextView) mView.findViewById(R.id.tvNomeMetodo);
        final TextView tvTipoMetodo = (TextView) mView.findViewById(R.id.tvTipoMetodo);

        int selectedMetodo = rgMetodoPF.getCheckedRadioButtonId();
        rbMetodoPF = (RadioButton) findViewById(selectedMetodo);
        tvMetodo.setText(rbMetodoPF.getText().toString());
        tvTipoMetodo.setText(tvTipoMetodo.getText().toString() + rbMetodoPF.getText().toString());

        fillTipoMetodo(rbMetodoPF.getText().toString(), mView);

        builder.setView(mView)
                //.setTitle("")
                // Add action buttons
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                int selectedEstadoUtente = rgEstadoUtente.getCheckedRadioButtonId();
                                int selectedTipoMetos = rgTipoPilula.getCheckedRadioButtonId();

                                int selectedMetodo = rgMetodoPF.getCheckedRadioButtonId();

                                if (selectedEstadoUtente == -1 || selectedTipoMetos == -1 || selectedMetodo == -1 || etCiclosDistribuidos.getText().toString().isEmpty()) {
                                    Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_LONG).show();
                                    rgMetodoPF.clearCheck();
                                }else {
                                rbMetodoPF = (RadioButton) findViewById(selectedMetodo);

                                RadioButton rbEstadoUtente = (RadioButton) mView.findViewById(selectedEstadoUtente);
                                RadioButton rbTipoPilula = (RadioButton) mView.findViewById(selectedTipoMetos);

                                String estadoUsuario = rbEstadoUtente.getText().toString();
                                String metodo = rbMetodoPF.getText().toString();
                                String tipoMetodo = rbTipoPilula.getText().toString();
                                int quantidadeDistribuida = Integer.parseInt(etCiclosDistribuidos.getText().toString());

                                MetodoSelecionado metodoSelecionado = new MetodoSelecionado(estadoUsuario, metodo, tipoMetodo, quantidadeDistribuida);
                                listMetodoSelecionado.add(metodoSelecionado);

                                }
                            }
                        })
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private int checkRBInAlertBox(View view, int id, String texto){
        RadioGroup radioGroup = (RadioGroup) view.findViewById(id);
        int nrRB = radioGroup.getChildCount();
        RadioButton radioButton;
        for (int i=0; i<nrRB; i++){
            int rbID = radioGroup.getChildAt(i).getId();
            radioButton = (RadioButton) view.findViewById(rbID);
            if (radioButton.getText().toString().equalsIgnoreCase(texto)){
                return rbID;
            }
        }
        return -1;
    }

    private void alertBoxExameClinico() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        LayoutInflater inflater = MainActivity.this.getLayoutInflater();
        final View mView = inflater.inflate(R.layout.select_exame_clinico, null);
        final RadioGroup rgTipo_exame_da_mama = (RadioGroup) mView.findViewById(R.id.rgTipoExameMama);
        final RadioGroup rgTratado = (RadioGroup) mView.findViewById(R.id.rgTratado);

        if(!exameDaMama.getTipo_exame_da_mama().isEmpty() && !exameDaMama.getTratado().isEmpty()){
            rgTipo_exame_da_mama.check(checkRBInAlertBox(mView, R.id.rgTipoExameMama, exameDaMama.getTipo_exame_da_mama()));
            rgTratado.check(checkRBInAlertBox(mView, R.id.rgTratado, exameDaMama.getTratado()));
        }

        builder.setView(mView)
                //.setTitle("")
                // Add action buttons
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                int selectedTipoExameMAma = rgTipo_exame_da_mama.getCheckedRadioButtonId();
                                int selectedTransferida = rgTratado.getCheckedRadioButtonId();

                                RadioButton rbTipo_exame_da_mama = (RadioButton) mView.findViewById(selectedTipoExameMAma);
                                RadioButton rbTratado = (RadioButton) mView.findViewById(selectedTransferida);

                                exameDaMama.setTipo_exame_da_mama(rbTipo_exame_da_mama.getText().toString());
                                exameDaMama.setTratado(rbTratado.getText().toString());
                            }
                        })
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                RadioButton radioButton = (RadioButton) findViewById(R.id.exameDaMamaNao);
                                radioButton.setChecked(true);
                                exameDaMama = new ExameDaMama("","");
                                dialog.cancel();
                            }
                        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

    private void alertBoxTratamentoCancro() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        LayoutInflater inflater = MainActivity.this.getLayoutInflater();
        final View mView = inflater.inflate(R.layout.tratamento_de_cancro, null);
        final RadioGroup rgResultado = (RadioGroup) mView.findViewById(R.id.rgResultado);

        if(!resultadoRastreioTratamentoCancroColoUterino.isEmpty()){
            rgResultado.check(checkRBInAlertBox(mView, R.id.rgResultado, resultadoRastreioTratamentoCancroColoUterino));
        }

        builder.setView(mView)
                //.setTitle("")
                // Add action buttons
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                int selectedRBID= rgResultado.getCheckedRadioButtonId();

                                RadioButton rbResultado = (RadioButton) mView.findViewById(selectedRBID);

                                resultadoRastreioTratamentoCancroColoUterino = rbResultado.getText().toString();
                                //resultadoRastreioTratamentoCancroColoUterino = getRBSelectedFromGroup(rgResultado);
                            }
                        })
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                RadioButton radioButton = (RadioButton) findViewById(R.id.exameDeViaNao);
                                radioButton.setChecked(true);
                                resultadoRastreioTratamentoCancroColoUterino = "";
                                dialog.cancel();
                            }
                        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

    private void alertBoxOutroMetodo() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        LayoutInflater inflater = MainActivity.this.getLayoutInflater();
        final View mView = inflater.inflate(R.layout.select_methodoutrometodo, null);
        final RadioGroup rgEstadoUtente = (RadioGroup) mView.findViewById(R.id.rgEstadoOutroMetodo);
        final EditText etNomedoMetodo = (EditText) mView.findViewById(R.id.etNomedoMetodo);
        final EditText etdosesDistribuidas = (EditText) mView.findViewById(R.id.etdosesDistribuidas);


        builder.setView(mView)
                //.setTitle("")
                // Add action buttons
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                int selectedEstadoUtente = rgEstadoUtente.getCheckedRadioButtonId();

                                if (selectedEstadoUtente == -1) {
                                    Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_LONG).show();
                                    rgMetodoPF.clearCheck();
                                } else {
                                    RadioButton rbEstadoUtente = (RadioButton) mView.findViewById(selectedEstadoUtente);

                                    String estadoUsuario = rbEstadoUtente.getText().toString();
                                    String metodo = etNomedoMetodo.getText().toString();
                                    String tipoMetodo = "";
                                    int quantidadeDistribuida = Integer.parseInt(etdosesDistribuidas.getText().toString());

                                    MetodoSelecionado metodoSelecionado = new MetodoSelecionado(estadoUsuario, metodo, tipoMetodo, quantidadeDistribuida);
                                    listMetodoSelecionado.add(metodoSelecionado);
                                }
                            }
                        })
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

    private void fillSpinner(Spinner spinner, List<String> list) {
        //Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomes
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);

        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.rPilula: {
                alertBoxPill();
            }
            break;

            case R.id.rImplante: {
                //alertBox();
                alertBoxPill();
            }
            break;

            case R.id.rInjetavela: {
                //alertBox();
                alertBoxPill();
            }
            break;

            case R.id.rDiu: {
                alertBox();
            }
            break;

            case R.id.rExameDaMamaSim: {
                alertBoxExameClinico();
            }
            break;

            case R.id.rExameDeViaSim: {
                alertBoxTratamentoCancro();
            }
            break;

            case R.id.rOutroMetodo: {
                alertBoxOutroMetodo();
            }
            break;

            case R.id.cbPreservativo: {
                alertBoxPreservativo();
            }
            break;

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle app bar item clicks here. The app bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {


            case R.id.action_sync:
                //displayToast("Sincronizar");

                Intent intent = new Intent(this, ListaActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_save: {
                //displayToast("Salvar");

                try {
                    criarConsultaPF();
                    //Toast.makeText(this, "Dados salvos com sucesso!", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Erro!\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
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
                Util.logout(MainActivity.this, this);
                return true;
            }
            case R.id.action_relatio:
                //         Intent intent = new Intent(this, SettingsActivity.class);
                //     startActivity(intent);

                Util.showMessage(this, "Meu Relatório", "Brevimente\n \n \t\t\t\t\t\t\t\t\tMeu relatório...");
                return true;

            case android.R.id.home:
                // app icon in action bar clicked; go home
                new AlertDialog.Builder(this)
                        .setTitle("Voltar?")
                        .setMessage("Deseja voltar para tela anterior?")
                        .setNegativeButton("Não", null)
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent myIntent = new Intent(getApplicationContext(), SeguimentoActivity.class);
                                startActivityForResult(myIntent, 0);
                            }

                        }).create().show();

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

    ////////////////////////////////////////////////////////
    private String getRBSelectedFromGroup(RadioGroup radioGroup){
        int rBSelectedId = radioGroup.getCheckedRadioButtonId();
        String valor = "";
        try {
            if (rBSelectedId != -1) {
                RadioButton rBSelected = (RadioButton) findViewById(rBSelectedId);
                return rBSelected.getText().toString().toLowerCase();
            }
        }catch (Exception e){
            System.out.println("Erro ao pegar Valor "+e.getMessage());
        }
        return valor;
    }

    private ConsultaPF getConsultaPF(){
        ConsultaPF consultaPF = new ConsultaPF();
        try {
            String codigo_consulta = gerarCodigoConsulta();
            String user_id = LoginActivity.user_id+"";

            /*</CABECALHP>*/
            String parceiro_presente_na_csr_pf = getRBSelectedFromGroup(rgParceiro_presente_na_csr_pf);
            String data_consulta = validarCampos(etDataConsulta);
            int numero_consulta = Integer.parseInt(validarCampos(etNumeroConsulta));
            String nid_csr_pf = validarCampos(etNidCSRF);
            String nid_tarv = validarCampos(etNidTarv);

            /*</CABECALHP>*/

            /*<DADOS PESSOAIS>*/
            String sexo = getRBSelectedFromGroup(rgSexo);
            String faixa_etaria = getRBSelectedFromGroup(rgFaixaEtaria);
            String nome =  validarCampos(etNome);
            String residencia = validarCampos(etResidencia);
            String contacto = validarCampos(etContacto);
            /*</DADOS PESSOAIS>*/

            /*<EXAME CLINICO>*/

            String rastreio_e_tratamento_de_its = getRBSelectedFromGroup(rgRastreio_e_tratamento_de_its);

            String transferida_ec = getRBSelectedFromGroup(rgTransferida);

            String fez_exame_clinico_da_mama = getRBSelectedFromGroup(rgFez_exame_clinico_da_mama);

            if (!fez_exame_clinico_da_mama.equalsIgnoreCase("sim"))
                exameDaMama = null;

            String outras_patologias = validarCampos(etOutras_patologias);

            String exame_clinico_da_mama = "";
            String tratado = "";
            if (exameDaMama != null) {
                 exame_clinico_da_mama = exameDaMama.getTipo_exame_da_mama();
                 tratado = exameDaMama.getTratado();
            }
            /*</EXAME CLINICO>*/


            /*<RASTREIO E TRATAMENTO DE CANCRO DO COLO UTERINO>*/

            String fez_exameme_de_via = getRBSelectedFromGroup(rgFez_exameme_de_via);

            if (fez_exameme_de_via.equalsIgnoreCase("Não")) {
                resultadoRastreioTratamentoCancroColoUterino = "";
            }

            String resultado = resultadoRastreioTratamentoCancroColoUterino;
            String crioterapia = getRBSelectedFromGroup(rgCrioterapia);
            String transferida_ccu = getRBSelectedFromGroup(rgTransferidaRTCCU);
            /*</RASTREIO E TRATAMENTO DE CANCRO DO COLO UTERINO>*/

            String estado_a_entrada_na_csr_pf = getRBSelectedFromGroup(rgEstado_a_entrada_na_csr_pf);
            String resultado_do_teste_feito_na_csr_pf = getRBSelectedFromGroup(rgResultado_do_teste_feito_na_csr_pf);
            String tratamento_do_utente_dose_recebida = getRBSelectedFromGroup(rgTratamento_do_utente_dose_recebida);
            String parceiro_recebeu_tratamento_na_csr_pf = getRBSelectedFromGroup(rgParceiro_recebeu_tratamento_na_csr_pf);
            /*</RASTREIO E TRATAMENTO DA SÍFLIS>*/

            /*<RASTREIO DE HIV E SEGUIMENTO>*/

            String seroestado_a_entrada_1a_csr_pf = getRBSelectedFromGroup(rgSeroestado_a_entrada_1a_csr_pf);
            String teste_de_hiv_na_consulta_de_csr = getRBSelectedFromGroup(rgTeste_de_hiv_na_consulta_de_csr);
            String tarv = getRBSelectedFromGroup(rgTarv);
            String testagem_do_parceiro = getRBSelectedFromGroup(rgTestagem_do_parceiro);
            /*</RASTREIO DE HIV E SEGUIMENTO>*/


            String transferidoPorPara = getRBSelectedFromGroup(rgTranferidoPorPara);
            if(transferidoPorPara.equalsIgnoreCase("Outro")) {
                transferidoPorPara = _ettransferidaOutro.getText().toString();
            }
            String observacao =  validarCampos(etObservacao);
            /*<TRANSFERIDO POR PARA>*/

            consultaPF = new ConsultaPF(
                    data_consulta,
                    codigo_consulta,
                    numero_consulta,
                    nid_csr_pf,
                    nid_tarv,
                    parceiro_presente_na_csr_pf,
                    nome,
                    sexo,
                    faixa_etaria,
                    residencia,
                    contacto,
                    rastreio_e_tratamento_de_its,
                    outras_patologias,
                    fez_exame_clinico_da_mama,
                    exame_clinico_da_mama,
                    tratado,
                    transferida_ec,
                    seroestado_a_entrada_1a_csr_pf,
                    teste_de_hiv_na_consulta_de_csr,
                    tarv,
                    testagem_do_parceiro,
                    fez_exameme_de_via,
                    resultado,
                    crioterapia,
                    transferida_ccu,
                    estado_a_entrada_na_csr_pf,
                    resultado_do_teste_feito_na_csr_pf,
                    tratamento_do_utente_dose_recebida,
                    parceiro_recebeu_tratamento_na_csr_pf,
                    transferidoPorPara,
                    observacao,
                    user_id
            );
            return consultaPF;
        }catch (Exception e){
            //Util.showMessage(this, "Erro", e.getMessage());
            return consultaPF;
        }
    }

    //CONSULTA PF
    private void criarConsultaPF() throws Exception {
       // Util.showMessage(this, "Consulta", getConsultaPF().toString());

        //String key = mDatabase.child("consulta-de-pf").push().getKey();
        if (getConsultaPF().isRequiredFilledF()) {
            consultaPF_id = mDatabase.child("consulta").push().getKey();
            Map<String, Object> postValues = getConsultaPF().toMap();

            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("/consulta/" + consultaPF_id, postValues);
            mDatabase.updateChildren(childUpdates);

            //  if(mDatabase.updateChildren(childUpdates).isSuccessful()) {
            // savePF();

            for (PlaneamentoFamiliar p : criarPlaneamentoFamiliar()) {
                String key = mDatabase.child("planiamento-familiar").push().getKey();
                Map<String, Object> pfValues = p.toMap();

                Map<String, Object> childUpdates1 = new HashMap<>();
                childUpdates.put("/planiamento_familiar/" + key, pfValues);
                childUpdates.put("/consulta-vs-planiamento_familiar/" + consultaPF_id + "/" + key, postValues);

                mDatabase.updateChildren(childUpdates);
            }
            listMetodoSelecionado.clear();
            Util.showMessage(this, "Status de Registo", "Sessão registada com sucesso!");
            Intent intent = new Intent(this, ListaActivity.class);
            startActivity(intent);
        }else
            Util.showMessage(this, "Status de Registo", getConsultaPF().getMSGRequired());

       // }else{
         //   Util.showMessage(this, "Status de Registo", "Erro ao salvar!!");
            /*
            Intent intent = new Intent(this, ListaActivity.class);
            startActivity(intent);
            */
       // }
    }

}


