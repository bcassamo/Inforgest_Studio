package mz.com.peach.inforgest.model.clients;

/**
 * Created by peach on 3/24/15.
 */
public class Client {
    private String cod_cli, nome;
    private double saldo;

    public Client() {}

    public Client(String cod_cli, String nome) {
        this.cod_cli = cod_cli;
        this.nome = nome;
    }

    public Client(String cod_cli, String nome, double saldo){
        this.cod_cli = cod_cli;
        this.nome = nome;
        this.saldo = saldo;
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
