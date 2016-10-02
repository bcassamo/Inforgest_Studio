package mz.com.peach.inforgest.model.documents;

/**
 * Created by peach on 6/5/16.
 */
public class Clidoc {
    private String ndoc, cod_cli, nome_cli, data, orig_doc;
    private double totaldoc, valor_pago, valor_a_pagar, debito, credito;



    public Clidoc() {
    }

    public Clidoc(String data, String cod_cli, String ndoc, String orig_doc, double debito, double credito) {
        this.data = data;
        this.cod_cli = cod_cli;
        this.ndoc = ndoc;
        this.orig_doc = orig_doc;
        this.debito = debito;
        this.credito = credito;
    }

    public String getNdoc() {
        return ndoc;
    }

    public void setNdoc(String ndoc) {
        this.ndoc = ndoc;
    }

    public String getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(String cod_cli) {
        this.cod_cli = cod_cli;
    }

    public String getNome_cli() {
        return nome_cli;
    }

    public void setNome_cli(String nome_cli) {
        this.nome_cli = nome_cli;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getTotaldoc() {
        return totaldoc;
    }

    public void setTotaldoc(double totaldoc) {
        this.totaldoc = totaldoc;
    }

    public double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public double getValor_a_pagar() {
        return valor_a_pagar;
    }

    public void setValor_a_pagar(double valor_a_pagar) {
        this.valor_a_pagar = valor_a_pagar;
    }

    public String getOrig_doc() {
        return orig_doc;
    }

    public void setOrig_doc(String orig_doc) {
        this.orig_doc = orig_doc;
    }

    public double getDebito() {
        return debito;
    }

    public void setDebito(double debito) {
        this.debito = debito;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }
}
