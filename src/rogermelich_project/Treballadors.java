/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rogermelich_project;

/**
 *
 * @author roger
 */
public class Treballadors {

    private String Nom_Cognoms = null;  //Nom i Cognoms del Treballador
    private String DNI = null;  //Dni del treballador
    private String Adreca = null;   //Adreça del treballador
    private int Codi_Postal = 0;    //Codi Postal del treballador
    private double Nomina = 0.0;    //Sou del Treballador
    private boolean practiques = false; // Ens Indica si el treballador esta en contracte de Pràctiues o no

    private char tipusTreballador;   //Serveix per determinar si està en pràctiques o no

    private boolean introduit = false;  //Per indicar si s'ha introduït

    // Setters & Getters
    public String getNom_Cognoms() {
        return Nom_Cognoms;
    }

    public void setNom_Cognoms(String Nom_Cognoms) {
        this.Nom_Cognoms = Nom_Cognoms;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getAdreca() {
        return Adreca;
    }

    public void setAdreca(String Adreca) {
        this.Adreca = Adreca;
    }

    public int getCodi_Postal() {
        return Codi_Postal;
    }

    public void setCodi_Postal(int Codi_Postal) {
        this.Codi_Postal = Codi_Postal;
    }

    public double getNomina() {
        return Nomina;
    }

    public void setNomina(double Nomina) {
        this.Nomina = Nomina;
    }

    public boolean isPractiques() {
        return practiques;
    }

    public void setPractiques(boolean practiques) {
        this.practiques = practiques;
    }

    public char getTipusTreballador() {
        return tipusTreballador;
    }

    public void setTipusTreballador(char tipusTreballador) {
        this.tipusTreballador = tipusTreballador;
    }

    public boolean isIntroduit() {
        return introduit;
    }

    public void setIntroduit(boolean introduit) {
        this.introduit = introduit;
    }

    /* Per tal de pinta la array en un println (System.out.println(array[0])) 
     * fem to string per a ques ens ho mostre, sinò mostrarà el lloc de la memòria 
     * on està guardada l'array
     */
    @Override
    public String toString() {
        return "Treballadors{" + "Nom_Cognoms=" + Nom_Cognoms + ", DNI=" + DNI + ", Adreca=" + Adreca + ", Codi_Postal=" + Codi_Postal + ", Nomina=" + Nomina + ", practiques=" + practiques + ", tipusTreballador=" + tipusTreballador + ", introduit=" + introduit + '}';
    }
}