package mz.com.peach.inforgest.model.clients;

/**
 * Created by peach on 3/24/15.
 */
public class Client {
    private String cod_cli, nome;
//    private int activo, id_cidade, id_pc, id_pf, ctr_credito,
//            ctr_docvalidade, limite_valor, desc_come, id_vend,
//            id_moeda, saldo_global, tipo_preco, externo;
//    private Calendar data_reg, data_mod;
//    private double id_tipocli;

    public Client() {}

    public Client(String cod_cli, String nome) {
        this.cod_cli = cod_cli;
        this.nome = nome;
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
}
