package mz.com.peach.inforgest.model;

/**
 * Created by peach on 12/27/14.
 */
public class Product {
    private String cod_prod, designation, specification;
    private double pvp_uni, upc, iva_venda, iva, pvp_iva;
    private int stk_prev, uni_cx;

    public Product() {
    }

    public Product(String cod_prod, String desig) {
        this.cod_prod = cod_prod;
        this.designation = desig;
    }

    public String getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(String cod_prod) {
        this.cod_prod = cod_prod;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getUni_cx() {
        return uni_cx;
    }

    public void setUni_cx(int uni_cx) {
        this.uni_cx = uni_cx;
    }

    public double getIva_venda() {
        return iva_venda;
    }

    public void setIva_venda(double iva_venda) {
        this.iva_venda = iva_venda;
    }

    public double getPvp_uni() {
        return pvp_uni;
    }

    public void setPvp_uni(double pvp_uni) {
        this.pvp_uni = pvp_uni;
    }

    public double getPvp_iva() {
        return pvp_iva;
    }

    public void setPvp_iva(double pvp_iva) {
        this.pvp_iva = pvp_iva;
    }

    public int getStk_prev() {
        return stk_prev;
    }

    public void setStk_prev(int stk_prev) {
        this.stk_prev = stk_prev;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getUpc() {
        return upc;
    }

    public void setUpc(double upc) {
        this.upc = upc;
    }
}
