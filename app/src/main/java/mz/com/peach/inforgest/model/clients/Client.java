package mz.com.peach.inforgest.model.clients;

import java.util.Calendar;

/**
 * Created by peach on 3/24/15.
 */
public class Client {
    private String cod_cli, nome, nuit, endereco, cpostal,
            telefone, fax, cell, email, bi, contacto_nome,
            telefone1, cell1, mail1, id_user, iva_clausula;
    private int activo, id_cidade, id_pc, id_pf, ctr_credito,
            ctr_docvalidade, limite_valor, desc_come, id_vend,
            id_moeda, saldo_global, tipo_preco, externo;
    private Calendar data_reg, data_mod;
    private double id_tipocli;

    public Client() {}

    public Client(String cod_cli, String nome) {
        this.cod_cli = cod_cli;
        this.nome = nome;
    }

    public Client(String cod_cli, String nome, String nuit, String endereco, String cpostal, String telefone, String fax, String cell, String email, String bi, String contacto_nome, String telefone1, String cell1, String mail1, String id_user, String iva_clausula, int activo, int id_cidade, int id_pc, int id_pf, int ctr_credito, int ctr_docvalidade, int limite_valor, int desc_come, int id_vend, int id_moeda, int saldo_global, int tipo_preco, int externo, Calendar data_reg, Calendar data_mod, double id_tipocli) {
        this.cod_cli = cod_cli;
        this.nome = nome;
        this.nuit = nuit;
        this.endereco = endereco;
        this.cpostal = cpostal;
        this.telefone = telefone;
        this.fax = fax;
        this.cell = cell;
        this.email = email;
        this.bi = bi;
        this.contacto_nome = contacto_nome;
        this.telefone1 = telefone1;
        this.cell1 = cell1;
        this.mail1 = mail1;
        this.id_user = id_user;
        this.iva_clausula = iva_clausula;
        this.activo = activo;
        this.id_cidade = id_cidade;
        this.id_pc = id_pc;
        this.id_pf = id_pf;
        this.ctr_credito = ctr_credito;
        this.ctr_docvalidade = ctr_docvalidade;
        this.limite_valor = limite_valor;
        this.desc_come = desc_come;
        this.id_vend = id_vend;
        this.id_moeda = id_moeda;
        this.saldo_global = saldo_global;
        this.tipo_preco = tipo_preco;
        this.externo = externo;
        this.data_reg = data_reg;
        this.data_mod = data_mod;
        this.id_tipocli = id_tipocli;
    }

    public String getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(String cod_cli) {
        this.cod_cli = cod_cli;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNuit() {
        return nuit;
    }

    public void setNuit(String nuit) {
        this.nuit = nuit;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpostal() {
        return cpostal;
    }

    public void setCpostal(String cpostal) {
        this.cpostal = cpostal;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getContacto_nome() {
        return contacto_nome;
    }

    public void setContacto_nome(String contacto_nome) {
        this.contacto_nome = contacto_nome;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getCell1() {
        return cell1;
    }

    public void setCell1(String cell1) {
        this.cell1 = cell1;
    }

    public String getMail1() {
        return mail1;
    }

    public void setMail1(String mail1) {
        this.mail1 = mail1;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getIva_clausula() {
        return iva_clausula;
    }

    public void setIva_clausula(String iva_clausula) {
        this.iva_clausula = iva_clausula;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public int getId_pc() {
        return id_pc;
    }

    public void setId_pc(int id_pc) {
        this.id_pc = id_pc;
    }

    public int getId_pf() {
        return id_pf;
    }

    public void setId_pf(int id_pf) {
        this.id_pf = id_pf;
    }

    public int getCtr_credito() {
        return ctr_credito;
    }

    public void setCtr_credito(int ctr_credito) {
        this.ctr_credito = ctr_credito;
    }

    public int getCtr_docvalidade() {
        return ctr_docvalidade;
    }

    public void setCtr_docvalidade(int ctr_docvalidade) {
        this.ctr_docvalidade = ctr_docvalidade;
    }

    public int getLimite_valor() {
        return limite_valor;
    }

    public void setLimite_valor(int limite_valor) {
        this.limite_valor = limite_valor;
    }

    public int getDesc_come() {
        return desc_come;
    }

    public void setDesc_come(int desc_come) {
        this.desc_come = desc_come;
    }

    public int getId_vend() {
        return id_vend;
    }

    public void setId_vend(int id_vend) {
        this.id_vend = id_vend;
    }

    public int getId_moeda() {
        return id_moeda;
    }

    public void setId_moeda(int id_moeda) {
        this.id_moeda = id_moeda;
    }

    public int getSaldo_global() {
        return saldo_global;
    }

    public void setSaldo_global(int saldo_global) {
        this.saldo_global = saldo_global;
    }

    public int getTipo_preco() {
        return tipo_preco;
    }

    public void setTipo_preco(int tipo_preco) {
        this.tipo_preco = tipo_preco;
    }

    public int getExterno() {
        return externo;
    }

    public void setExterno(int externo) {
        this.externo = externo;
    }

    public Calendar getData_reg() {
        return data_reg;
    }

    public void setData_reg(Calendar data_reg) {
        this.data_reg = data_reg;
    }

    public Calendar getData_mod() {
        return data_mod;
    }

    public void setData_mod(Calendar data_mod) {
        this.data_mod = data_mod;
    }

    public double getId_tipocli() {
        return id_tipocli;
    }

    public void setId_tipocli(double id_tipocli) {
        this.id_tipocli = id_tipocli;
    }
}
