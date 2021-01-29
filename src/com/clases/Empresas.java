package com.clases;

import java.util.List;

import javax.swing.*;

public class Empresas extends Producto {
    private String tipDoc;
    private String documento;
    private String representante;
    private List<Producto> productos;

    public String getTipDoc() {
        return tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }
    
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

	@Override
	public double ofertaValor() {
		return getValor();
	}
}
