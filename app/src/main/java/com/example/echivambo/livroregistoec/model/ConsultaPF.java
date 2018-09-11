package com.example.echivambo.livroregistoec.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class ConsultaPF implements Parcelable{
     // public class Cabecalho {
     private String data_consulta;
     private String codigo_consulta;
     private int numero_consulta;
     private String nid_csr_pf;
     private String nid_tarv;
     private String parceiro_presente_na_csr_pf;

     // public class DadosPessoais {
     private String nome;
     private String sexo;
     private String faixa_etaria;
     private String residencia;
     private String contacto;

     //public class ExameClinico {
     private String rastreio_e_tratamento_de_its;
     private String outras_patologias;
     private String fez_exame_clinico_da_mama;
     private String exame_clinico_da_mama;
     private String tratado;
     private String transferida_ec;

     //  public class RHIVSeguimento {
     private String seroestado_a_entrada_1a_csr_pf;
     private String teste_de_hiv_na_consulta_de_csr;
     private String tarv;
     private String testagem_do_parceiro;

     //   public class RTCancroColoUterino {
     private String fez_exameme_de_via;
     private String resultado;
     private String crioterapia;
     private String transferida_ccu;

     //    public class RTSiflis {
     private String estado_a_entrada_na_csr_pf;
     private String resultado_do_teste_feito_na_csr_pf;
     private String tratamento_do_utente_dose_recebida;
     private String parceiro_recebeu_tratamento_na_csr_pf;

     //  public class TransferidaPorPara {
     private String transferida_por_para;
     private String observacao;

     private String user_id;

     public ConsultaPF() {
     }

     public ConsultaPF(String data_consulta, String codigo_consulta, int numero_consulta, String nid_csr_pf, String nid_tarv, String parceiro_presente_na_csr_pf, String nome, String sexo, String faixa_etaria, String residencia, String contacto, String rastreio_e_tratamento_de_its, String outras_patologias, String fez_exame_clinico_da_mama, String exame_clinico_da_mama, String tratado, String transferida_ec, String seroestado_a_entrada_1a_csr_pf, String teste_de_hiv_na_consulta_de_csr, String tarv, String testagem_do_parceiro, String fez_exameme_de_via, String resultado, String crioterapia, String transferida_ccu, String estado_a_entrada_na_csr_pf, String resultado_do_teste_feito_na_csr_pf, String tratamento_do_utente_dose_recebida, String parceiro_recebeu_tratamento_na_csr_pf, String transferida_por_para, String observacao, String user_id) {
          this.data_consulta = data_consulta;
          this.codigo_consulta = codigo_consulta;
          this.numero_consulta = numero_consulta;
          this.nid_csr_pf = nid_csr_pf;
          this.nid_tarv = nid_tarv;
          this.parceiro_presente_na_csr_pf = parceiro_presente_na_csr_pf;
          this.nome = nome;
          this.sexo = sexo;
          this.faixa_etaria = faixa_etaria;
          this.residencia = residencia;
          this.contacto = contacto;
          this.rastreio_e_tratamento_de_its = rastreio_e_tratamento_de_its;
          this.outras_patologias = outras_patologias;
          this.fez_exame_clinico_da_mama = fez_exame_clinico_da_mama;
          this.exame_clinico_da_mama = exame_clinico_da_mama;
          this.tratado = tratado;
          this.transferida_ec = transferida_ec;
          this.seroestado_a_entrada_1a_csr_pf = seroestado_a_entrada_1a_csr_pf;
          this.teste_de_hiv_na_consulta_de_csr = teste_de_hiv_na_consulta_de_csr;
          this.tarv = tarv;
          this.testagem_do_parceiro = testagem_do_parceiro;
          this.fez_exameme_de_via = fez_exameme_de_via;
          this.resultado = resultado;
          this.crioterapia = crioterapia;
          this.transferida_ccu = transferida_ccu;
          this.estado_a_entrada_na_csr_pf = estado_a_entrada_na_csr_pf;
          this.resultado_do_teste_feito_na_csr_pf = resultado_do_teste_feito_na_csr_pf;
          this.tratamento_do_utente_dose_recebida = tratamento_do_utente_dose_recebida;
          this.parceiro_recebeu_tratamento_na_csr_pf = parceiro_recebeu_tratamento_na_csr_pf;
          this.transferida_por_para = transferida_por_para;
          this.observacao = observacao;
          this.user_id = user_id;
     }

     protected ConsultaPF(Parcel in) {
          data_consulta = in.readString();
          codigo_consulta = in.readString();
          numero_consulta = in.readInt();
          nid_csr_pf = in.readString();
          nid_tarv = in.readString();
          parceiro_presente_na_csr_pf = in.readString();
          nome = in.readString();
          sexo = in.readString();
          faixa_etaria = in.readString();
          residencia = in.readString();
          contacto = in.readString();
          rastreio_e_tratamento_de_its = in.readString();
          outras_patologias = in.readString();
          fez_exame_clinico_da_mama = in.readString();
          exame_clinico_da_mama = in.readString();
          tratado = in.readString();
          transferida_ec = in.readString();
          seroestado_a_entrada_1a_csr_pf = in.readString();
          teste_de_hiv_na_consulta_de_csr = in.readString();
          tarv = in.readString();
          testagem_do_parceiro = in.readString();
          fez_exameme_de_via = in.readString();
          resultado = in.readString();
          crioterapia = in.readString();
          transferida_ccu = in.readString();
          estado_a_entrada_na_csr_pf = in.readString();
          resultado_do_teste_feito_na_csr_pf = in.readString();
          tratamento_do_utente_dose_recebida = in.readString();
          parceiro_recebeu_tratamento_na_csr_pf = in.readString();
          transferida_por_para = in.readString();
          observacao = in.readString();
          user_id = in.readString();
     }

     public static final Creator<ConsultaPF> CREATOR = new Creator<ConsultaPF>() {
          @Override
          public ConsultaPF createFromParcel(Parcel in) {
               return new ConsultaPF(in);
          }

          @Override
          public ConsultaPF[] newArray(int size) {
               return new ConsultaPF[size];
          }
     };

     public String getData_consulta() {
          return data_consulta;
     }

     public void setData_consulta(String data_consulta) {
          this.data_consulta = data_consulta;
     }

     public String getCodigo_consulta() {
          return codigo_consulta;
     }

     public void setCodigo_consulta(String codigo_consulta) {
          this.codigo_consulta = codigo_consulta;
     }

     public int getNumero_consulta() {
          return numero_consulta;
     }

     public void setNumero_consulta(int numero_consulta) {
          this.numero_consulta = numero_consulta;
     }

     public String getNid_csr_pf() {
          return nid_csr_pf;
     }

     public void setNid_csr_pf(String nid_csr_pf) {
          this.nid_csr_pf = nid_csr_pf;
     }

     public String getNid_tarv() {
          return nid_tarv;
     }

     public void setNid_tarv(String nid_tarv) {
          this.nid_tarv = nid_tarv;
     }

     public String getParceiro_presente_na_csr_pf() {
          return parceiro_presente_na_csr_pf;
     }

     public void setParceiro_presente_na_csr_pf(String parceiro_presente_na_csr_pf) {
          this.parceiro_presente_na_csr_pf = parceiro_presente_na_csr_pf;
     }

     public String getNome() {
          return nome;
     }

     public void setNome(String nome) {
          this.nome = nome;
     }

     public String getSexo() {
          return sexo;
     }

     public void setSexo(String sexo) {
          this.sexo = sexo;
     }

     public String getFaixa_etaria() {
          return faixa_etaria;
     }

     public void setFaixa_etaria(String faixa_etaria) {
          this.faixa_etaria = faixa_etaria;
     }

     public String getResidencia() {
          return residencia;
     }

     public void setResidencia(String residencia) {
          this.residencia = residencia;
     }

     public String getContacto() {
          return contacto;
     }

     public void setContacto(String contacto) {
          this.contacto = contacto;
     }

     public String getRastreio_e_tratamento_de_its() {
          return rastreio_e_tratamento_de_its;
     }

     public void setRastreio_e_tratamento_de_its(String rastreio_e_tratamento_de_its) {
          this.rastreio_e_tratamento_de_its = rastreio_e_tratamento_de_its;
     }

     public String getOutras_patologias() {
          return outras_patologias;
     }

     public void setOutras_patologias(String outras_patologias) {
          this.outras_patologias = outras_patologias;
     }

     public String getFez_exame_clinico_da_mama() {
          return fez_exame_clinico_da_mama;
     }

     public void setFez_exame_clinico_da_mama(String fez_exame_clinico_da_mama) {
          this.fez_exame_clinico_da_mama = fez_exame_clinico_da_mama;
     }

     public String getExame_clinico_da_mama() {
          return exame_clinico_da_mama;
     }

     public void setExame_clinico_da_mama(String exame_clinico_da_mama) {
          this.exame_clinico_da_mama = exame_clinico_da_mama;
     }

     public String getTratado() {
          return tratado;
     }

     public void setTratado(String tratado) {
          this.tratado = tratado;
     }

     public String getTransferida_ec() {
          return transferida_ec;
     }

     public void setTransferida_ec(String transferida_ec) {
          this.transferida_ec = transferida_ec;
     }

     public String getSeroestado_a_entrada_1a_csr_pf() {
          return seroestado_a_entrada_1a_csr_pf;
     }

     public void setSeroestado_a_entrada_1a_csr_pf(String seroestado_a_entrada_1a_csr_pf) {
          this.seroestado_a_entrada_1a_csr_pf = seroestado_a_entrada_1a_csr_pf;
     }

     public String getTeste_de_hiv_na_consulta_de_csr() {
          return teste_de_hiv_na_consulta_de_csr;
     }

     public void setTeste_de_hiv_na_consulta_de_csr(String teste_de_hiv_na_consulta_de_csr) {
          this.teste_de_hiv_na_consulta_de_csr = teste_de_hiv_na_consulta_de_csr;
     }

     public String getTarv() {
          return tarv;
     }

     public void setTarv(String tarv) {
          this.tarv = tarv;
     }

     public String getTestagem_do_parceiro() {
          return testagem_do_parceiro;
     }

     public void setTestagem_do_parceiro(String testagem_do_parceiro) {
          this.testagem_do_parceiro = testagem_do_parceiro;
     }

     public String getFez_exameme_de_via() {
          return fez_exameme_de_via;
     }

     public void setFez_exameme_de_via(String fez_exameme_de_via) {
          this.fez_exameme_de_via = fez_exameme_de_via;
     }

     public String getResultado() {
          return resultado;
     }

     public void setResultado(String resultado) {
          this.resultado = resultado;
     }

     public String getCrioterapia() {
          return crioterapia;
     }

     public void setCrioterapia(String crioterapia) {
          this.crioterapia = crioterapia;
     }

     public String getTransferida_ccu() {
          return transferida_ccu;
     }

     public void setTransferida_ccu(String transferida_ccu) {
          this.transferida_ccu = transferida_ccu;
     }

     public String getEstado_a_entrada_na_csr_pf() {
          return estado_a_entrada_na_csr_pf;
     }

     public void setEstado_a_entrada_na_csr_pf(String estado_a_entrada_na_csr_pf) {
          this.estado_a_entrada_na_csr_pf = estado_a_entrada_na_csr_pf;
     }

     public String getResultado_do_teste_feito_na_csr_pf() {
          return resultado_do_teste_feito_na_csr_pf;
     }

     public void setResultado_do_teste_feito_na_csr_pf(String resultado_do_teste_feito_na_csr_pf) {
          this.resultado_do_teste_feito_na_csr_pf = resultado_do_teste_feito_na_csr_pf;
     }

     public String getTratamento_do_utente_dose_recebida() {
          return tratamento_do_utente_dose_recebida;
     }

     public void setTratamento_do_utente_dose_recebida(String tratamento_do_utente_dose_recebida) {
          this.tratamento_do_utente_dose_recebida = tratamento_do_utente_dose_recebida;
     }

     public String getParceiro_recebeu_tratamento_na_csr_pf() {
          return parceiro_recebeu_tratamento_na_csr_pf;
     }

     public void setParceiro_recebeu_tratamento_na_csr_pf(String parceiro_recebeu_tratamento_na_csr_pf) {
          this.parceiro_recebeu_tratamento_na_csr_pf = parceiro_recebeu_tratamento_na_csr_pf;
     }

     public String getTransferida_por_para() {
          return transferida_por_para;
     }

     public void setTransferida_por_para(String transferida_por_para) {
          this.transferida_por_para = transferida_por_para;
     }

     public String getObservacao() {
          return observacao;
     }

     public void setObservacao(String observacao) {
          this.observacao = observacao;
     }

     public String getUser_id() {
          return user_id;
     }

     public void setUser_id(String user_id) {
          this.user_id = user_id;
     }

     @Exclude
     public Map<String, Object> toMap() {
          HashMap<String, Object> result = new HashMap<>();
          result.put("data_consulta", data_consulta);
          result.put("codigo_consulta", codigo_consulta);
          result.put("numero_consulta", numero_consulta);
          result.put("nid_csr_pf", nid_csr_pf);
          result.put("nid_tarv", nid_tarv);
          result.put("parceiro_presente_na_csr_pf", parceiro_presente_na_csr_pf);
          result.put("nome", nome);
          result.put("sexo", sexo);
          result.put("faixa_etaria", faixa_etaria);
          result.put("residencia", residencia);
          result.put("contacto", contacto);
          result.put("rastreio_e_tratamento_de_its", rastreio_e_tratamento_de_its);
          result.put("outras_patologias", outras_patologias);
          result.put("fez_exame_clinico_da_mama", fez_exame_clinico_da_mama);
          result.put("exame_clinico_da_mama", exame_clinico_da_mama);
          result.put("tratado", tratado);
          result.put("transferida_ec", transferida_ec);
          result.put("seroestado_a_entrada_1a_csr_pf", seroestado_a_entrada_1a_csr_pf);
          result.put("teste_de_hiv_na_consulta_de_csr", teste_de_hiv_na_consulta_de_csr);
          result.put("tarv", tarv);
          result.put("testagem_do_parceiro", testagem_do_parceiro);
          result.put("fez_exameme_de_via", fez_exameme_de_via);
          result.put("resultado", resultado);
          result.put("crioterapia", crioterapia);
          result.put("transferida_ccu", transferida_ccu);
          result.put("estado_a_entrada_na_csr_pf", estado_a_entrada_na_csr_pf);
          result.put("resultado_do_teste_feito_na_csr_pf", resultado_do_teste_feito_na_csr_pf);
          result.put("tratamento_do_utente_dose_recebida", tratamento_do_utente_dose_recebida);
          result.put("parceiro_recebeu_tratamento_na_csr_pf", parceiro_recebeu_tratamento_na_csr_pf);
          result.put("transferida_por", transferida_por_para);
          result.put("observacao", observacao);
          result.put("user_id", user_id);

          return result;
     }

    @Override
    public String toString() {
        return "ConsultaPF{" +
                "data_consulta='" + data_consulta + '\'' +
                ", codigo_consulta='" + codigo_consulta + '\'' +
                ", numero_consulta=" + numero_consulta +
                ", nid_csr_pf='" + nid_csr_pf + '\'' +
                ", nid_tarv='" + nid_tarv + '\'' +
                ", parceiro_presente_na_csr_pf='" + parceiro_presente_na_csr_pf + '\'' +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", faixa_etaria='" + faixa_etaria + '\'' +
                ", residencia='" + residencia + '\'' +
                ", contacto='" + contacto + '\'' +
                ", rastreio_e_tratamento_de_its='" + rastreio_e_tratamento_de_its + '\'' +
                ", outras_patologias='" + outras_patologias + '\'' +
                ", fez_exame_clinico_da_mama='" + fez_exame_clinico_da_mama + '\'' +
                ", exame_clinico_da_mama='" + exame_clinico_da_mama + '\'' +
                ", tratado='" + tratado + '\'' +
                ", transferida_ec='" + transferida_ec + '\'' +
                ", seroestado_a_entrada_1a_csr_pf='" + seroestado_a_entrada_1a_csr_pf + '\'' +
                ", teste_de_hiv_na_consulta_de_csr='" + teste_de_hiv_na_consulta_de_csr + '\'' +
                ", tarv='" + tarv + '\'' +
                ", testagem_do_parceiro='" + testagem_do_parceiro + '\'' +
                ", fez_exameme_de_via='" + fez_exameme_de_via + '\'' +
                ", resultado='" + resultado + '\'' +
                ", crioterapia='" + crioterapia + '\'' +
                ", transferida_ccu='" + transferida_ccu + '\'' +
                ", estado_a_entrada_na_csr_pf='" + estado_a_entrada_na_csr_pf + '\'' +
                ", resultado_do_teste_feito_na_csr_pf='" + resultado_do_teste_feito_na_csr_pf + '\'' +
                ", tratamento_do_utente_dose_recebida='" + tratamento_do_utente_dose_recebida + '\'' +
                ", parceiro_recebeu_tratamento_na_csr_pf='" + parceiro_recebeu_tratamento_na_csr_pf + '\'' +
                ", transferida_por_para='" + transferida_por_para + '\'' +
                ", observacao='" + observacao + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }

     @Override
     public int describeContents() {
          return 0;
     }

     @Override
     public void writeToParcel(Parcel parcel, int i) {
          parcel.writeString(data_consulta);
          parcel.writeString(codigo_consulta);
          parcel.writeInt(numero_consulta);
          parcel.writeString(nid_csr_pf);
          parcel.writeString(nid_tarv);
          parcel.writeString(parceiro_presente_na_csr_pf);
          parcel.writeString(nome);
          parcel.writeString(sexo);
          parcel.writeString(faixa_etaria);
          parcel.writeString(residencia);
          parcel.writeString(contacto);
          parcel.writeString(rastreio_e_tratamento_de_its);
          parcel.writeString(outras_patologias);
          parcel.writeString(fez_exame_clinico_da_mama);
          parcel.writeString(exame_clinico_da_mama);
          parcel.writeString(tratado);
          parcel.writeString(transferida_ec);
          parcel.writeString(seroestado_a_entrada_1a_csr_pf);
          parcel.writeString(teste_de_hiv_na_consulta_de_csr);
          parcel.writeString(tarv);
          parcel.writeString(testagem_do_parceiro);
          parcel.writeString(fez_exameme_de_via);
          parcel.writeString(resultado);
          parcel.writeString(crioterapia);
          parcel.writeString(transferida_ccu);
          parcel.writeString(estado_a_entrada_na_csr_pf);
          parcel.writeString(resultado_do_teste_feito_na_csr_pf);
          parcel.writeString(tratamento_do_utente_dose_recebida);
          parcel.writeString(parceiro_recebeu_tratamento_na_csr_pf);
          parcel.writeString(transferida_por_para);
          parcel.writeString(observacao);
          parcel.writeString(user_id);
     }

     public Boolean isRequiredFilled() {
          if (
                  this.numero_consulta == 0 ||
                      //    this.data_consulta.isEmpty() ||
                          this.nid_csr_pf.isEmpty()||
                          this.sexo.isEmpty() ||
                          this.faixa_etaria.isEmpty() ||
                          this.nome.isEmpty()

                  )return false; else return true;
     }

     public String getMSGRequired() {
          String msg = "Os campos a baixo são obrigatórios!\n";
         // if(this.data_consulta.isEmpty())
              // msg+="Data da consulta;\n";

          if(this.numero_consulta == 0)
               msg+="Número da consulta;\n";

          if(this.nid_csr_pf != "" || this.nid_csr_pf != null)
               msg+="NID CSR/PF;\n";

          if(this.nome != "" || this.nome != null)
               msg+="Nome;\n";

          if(this.sexo != "" || this.sexo != null)
               msg+="Sexo;\n";

          if(this.faixa_etaria != "" || this.faixa_etaria != null)
               msg+="Faixa etária;\n";

         return msg;
     }
}
