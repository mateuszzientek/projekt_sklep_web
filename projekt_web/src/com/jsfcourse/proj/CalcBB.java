package com.jsfcourse.proj;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class CalcBB {
	private String kwota;
	private String lata;
	private String oprocentowanie;
	private Double wynik;
	private Double procenty;

	@Inject
	FacesContext ctx;

	

	public String getKwota() {
		return kwota;
	}

	public void setKwota(String kwota) {
		this.kwota = kwota;
	}

	public String getLata() {
		return lata;
	}

	public void setLata(String lata) {
		this.lata = lata;
	}

	public String getOprocentowanie() {
		return oprocentowanie;
	}

	public void setOprocentowanie(String oprocentowanie) {
		this.oprocentowanie = oprocentowanie;
	}

	public Double getWynik() {
		return wynik;
	}


	public String calc() {
		try {
			double kwota = Double.parseDouble(this.kwota);
			double lata = Double.parseDouble(this.lata);
			double oprocentowanie = Double.parseDouble(this.lata);
			
			procenty= kwota*(oprocentowanie/100);

			wynik = (kwota/(lata*12))+procenty;

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return "showresult";
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return null;
		}
	}

}
