package mz.com.peach.inforgest.model;

import java.util.Calendar;

/**
 * Created by peach on 12/27/14.
 */
public class Product {
    private String cod_prod, desig, espe, id_user, id_uom;
    private Calendar data_reg, data_mod;
    private int activo, cstock, vnegativo, id_prodtipo, id_prodgrp,
    id_prodfam, iva_icl, id_moeda, n1, n2, frac_qty, uni_cx, onlybarcode,
    composto, exist;
    private double nstk_min, iva_compra, iva_venda, pvp_uni, margem_uni,
    renta_uni, pvp_cx, margem_cx, renta_cx, pvp_n1, margem_n1, renta_n1,
    pvp_n2, margem_n2, renta_n2, upc, pmc, pmv, p2, m2, p3, m3, p4, m4;

    public Product() {
    }

    public int getExist() {
        return exist;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }

    public Product(String cod_prod, String desig) {
        this.cod_prod = cod_prod;
        this.desig = desig;

    }

    public String getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(String cod_prod) {
        this.cod_prod = cod_prod;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public String getEspe() {
        return espe;
    }

    public void setEspe(String espe) {
        this.espe = espe;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getId_uom() {
        return id_uom;
    }

    public void setId_uom(String id_uom) {
        this.id_uom = id_uom;
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

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getCstock() {
        return cstock;
    }

    public void setCstock(int cstock) {
        this.cstock = cstock;
    }

    public int getVnegativo() {
        return vnegativo;
    }

    public void setVnegativo(int vnegativo) {
        this.vnegativo = vnegativo;
    }

    public int getId_prodtipo() {
        return id_prodtipo;
    }

    public void setId_prodtipo(int id_prodtipo) {
        this.id_prodtipo = id_prodtipo;
    }

    public int getId_prodgrp() {
        return id_prodgrp;
    }

    public void setId_prodgrp(int id_prodgrp) {
        this.id_prodgrp = id_prodgrp;
    }

    public int getId_prodfam() {
        return id_prodfam;
    }

    public void setId_prodfam(int id_prodfam) {
        this.id_prodfam = id_prodfam;
    }

    public int getIva_icl() {
        return iva_icl;
    }

    public void setIva_icl(int iva_icl) {
        this.iva_icl = iva_icl;
    }

    public int getId_moeda() {
        return id_moeda;
    }

    public void setId_moeda(int id_moeda) {
        this.id_moeda = id_moeda;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getFrac_qty() {
        return frac_qty;
    }

    public void setFrac_qty(int frac_qty) {
        this.frac_qty = frac_qty;
    }

    public int getUni_cx() {
        return uni_cx;
    }

    public void setUni_cx(int uni_cx) {
        this.uni_cx = uni_cx;
    }

    public int getOnlybarcode() {
        return onlybarcode;
    }

    public void setOnlybarcode(int onlybarcode) {
        this.onlybarcode = onlybarcode;
    }

    public int getComposto() {
        return composto;
    }

    public void setComposto(int composto) {
        this.composto = composto;
    }

    public double getNstk_min() {
        return nstk_min;
    }

    public void setNstk_min(double nstk_min) {
        this.nstk_min = nstk_min;
    }

    public double getIva_compra() {
        return iva_compra;
    }

    public void setIva_compra(double iva_compra) {
        this.iva_compra = iva_compra;
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

    public double getMargem_uni() {
        return margem_uni;
    }

    public void setMargem_uni(double margem_uni) {
        this.margem_uni = margem_uni;
    }

    public double getRenta_uni() {
        return renta_uni;
    }

    public void setRenta_uni(double renta_uni) {
        this.renta_uni = renta_uni;
    }

    public double getPvp_cx() {
        return pvp_cx;
    }

    public void setPvp_cx(double pvp_cx) {
        this.pvp_cx = pvp_cx;
    }

    public double getMargem_cx() {
        return margem_cx;
    }

    public void setMargem_cx(double margem_cx) {
        this.margem_cx = margem_cx;
    }

    public double getRenta_cx() {
        return renta_cx;
    }

    public void setRenta_cx(double renta_cx) {
        this.renta_cx = renta_cx;
    }

    public double getPvp_n1() {
        return pvp_n1;
    }

    public void setPvp_n1(double pvp_n1) {
        this.pvp_n1 = pvp_n1;
    }

    public double getMargem_n1() {
        return margem_n1;
    }

    public void setMargem_n1(double margem_n1) {
        this.margem_n1 = margem_n1;
    }

    public double getRenta_n1() {
        return renta_n1;
    }

    public void setRenta_n1(double renta_n1) {
        this.renta_n1 = renta_n1;
    }

    public double getPvp_n2() {
        return pvp_n2;
    }

    public void setPvp_n2(double pvp_n2) {
        this.pvp_n2 = pvp_n2;
    }

    public double getMargem_n2() {
        return margem_n2;
    }

    public void setMargem_n2(double margem_n2) {
        this.margem_n2 = margem_n2;
    }

    public double getRenta_n2() {
        return renta_n2;
    }

    public void setRenta_n2(double renta_n2) {
        this.renta_n2 = renta_n2;
    }

    public double getUpc() {
        return upc;
    }

    public void setUpc(double upc) {
        this.upc = upc;
    }

    public double getPmc() {
        return pmc;
    }

    public void setPmc(double pmc) {
        this.pmc = pmc;
    }

    public double getPmv() {
        return pmv;
    }

    public void setPmv(double pmv) {
        this.pmv = pmv;
    }

    public double getP2() {
        return p2;
    }

    public void setP2(double p2) {
        this.p2 = p2;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public double getP3() {
        return p3;
    }

    public void setP3(double p3) {
        this.p3 = p3;
    }

    public double getM3() {
        return m3;
    }

    public void setM3(double m3) {
        this.m3 = m3;
    }

    public double getP4() {
        return p4;
    }

    public void setP4(double p4) {
        this.p4 = p4;
    }

    public double getM4() {
        return m4;
    }

    public void setM4(double m4) {
        this.m4 = m4;
    }

    /*private Long _id, _familyId, _groupId, _typeId;
    private String _description;

    public Product() {}

    public Product(Long _id, String _description) {
        this._id = _id;
        this._description = _description;
    }

    public Product(Long _id, Long _familyId, Long _groupId, Long _typeId,
                   String _description) {
        super();
        this._id = _id;
        this._familyId = _familyId;
        this._groupId = _groupId;
        this._typeId = _typeId;
        this._description = _description;
    }



    public Long getId() {
        return _id;
    }
    public void setId(Long id) {
        this._id = id;
    }
    public Long getFamilyId() {
        return _familyId;
    }
    public void setFamilyId(Long familyId) {
        this._familyId = familyId;
    }
    public Long getGroupId() {
        return _groupId;
    }
    public void setGroupId(Long groupId) {
        this._groupId = groupId;
    }
    public Long getTypeId() {
        return _typeId;
    }
    public void setTypeId(Long typeId) {
        this._typeId = typeId;
    }
    public String getDescription() {
        return _description;
    }
    public void setDescription(String description) {
        _description = description;
    }*/
}
