package com.example.echivambo.livroregistoec.model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class ConsultaPF {
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

     // public class PlaneamentoFamiliar {
     private String utente_pf;
     private String metodo_do_pf;
     private String tipo_do_metodo_do_pf;
     private String estado_da_utente_no_metodo;
     private int total_distribuido;
     private String metodo_anterior;

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
     private String transferida_por;
     private String transferida_para;
     private String observacao;

     private String user_id;

     public ConsultaPF() {
     }

     public ConsultaPF(String data_consulta, String codigo_consulta, int numero_consulta, String nid_csr_pf, String nid_tarv, String parceiro_presente_na_csr_pf, String nome, String sexo, String faixa_etaria, String residencia, String contacto, String rastreio_e_tratamento_de_its, String outras_patologias, String fez_exame_clinico_da_mama, String exame_clinico_da_mama, String tratado, String transferida_ec, String utente_pf, String metodo_do_pf, String tipo_do_metodo_do_pf, String estado_da_utente_no_metodo, int total_distribuido, String metodo_anterior, String seroestado_a_entrada_1a_csr_pf, String teste_de_hiv_na_consulta_de_csr, String tarv, String testagem_do_parceiro, String fez_exameme_de_via, String resultado, String crioterapia, String transferida_ccu, String estado_a_entrada_na_csr_pf, String resultado_do_teste_feito_na_csr_pf, String tratamento_do_utente_dose_recebida, String parceiro_recebeu_tratamento_na_csr_pf, String transferida_por, String transferida_para, String observacao, String user_id) {
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
          this.utente_pf = utente_pf;
          this.metodo_do_pf = metodo_do_pf;
          this.tipo_do_metodo_do_pf = tipo_do_metodo_do_pf;
          this.estado_da_utente_no_metodo = estado_da_utente_no_metodo;
          this.total_distribuido = total_distribuido;
          this.metodo_anterior = metodo_anterior;
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
          this.transferida_por = transferida_por;
          this.transferida_para = transferida_para;
          this.observacao = observacao;
          this.user_id = user_id;
     }

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

     public String getUtente_pf() {
          return utente_pf;
     }

     public void setUtente_pf(String utente_pf) {
          this.utente_pf = utente_pf;
     }

     public String getMetodo_do_pf() {
          return metodo_do_pf;
     }

     public void setMetodo_do_pf(String metodo_do_pf) {
          this.metodo_do_pf = metodo_do_pf;
     }

     public String getTipo_do_metodo_do_pf() {
          return tipo_do_metodo_do_pf;
     }

     public void setTipo_do_metodo_do_pf(String tipo_do_metodo_do_pf) {
          this.tipo_do_metodo_do_pf = tipo_do_metodo_do_pf;
     }

     public String getEstado_da_utente_no_metodo() {
          return estado_da_utente_no_metodo;
     }

     public void setEstado_da_utente_no_metodo(String estado_da_utente_no_metodo) {
          this.estado_da_utente_no_metodo = estado_da_utente_no_metodo;
     }

     public int getTotal_distribuido() {
          return total_distribuido;
     }

     public void setTotal_distribuido(int total_distribuido) {
          this.total_distribuido = total_distribuido;
     }

     public String getMetodo_anterior() {
          return metodo_anterior;
     }

     public void setMetodo_anterior(String metodo_anterior) {
          this.metodo_anterior = metodo_anterior;
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

     public String getTransferida_por() {
          return transferida_por;
     }

     public void setTransferida_por(String transferida_por) {
          this.transferida_por = transferida_por;
     }

     public String getTransferida_para() {
          return transferida_para;
     }

     public void setTransferida_para(String transferida_para) {
          this.transferida_para = transferida_para;
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
          result.put("utente_pf", utente_pf);
          result.put("metodo_do_pf", metodo_do_pf);
          result.put("tipo_do_metodo_do_pf", tipo_do_metodo_do_pf);
          result.put("estado_da_utente_no_metodo", estado_da_utente_no_metodo);
          result.put("total_distribuido", total_distribuido);
          result.put("metodo_anterior", metodo_anterior);
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
          result.put("transferida_por", transferida_por);
          result.put("transferida_para", transferida_para);
          result.put("observacao", observacao);
          result.put("user_id", user_id);

          return result;
     }
}
