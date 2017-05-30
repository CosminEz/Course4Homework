package com.example.cosmin.course3homework.Model;

import android.provider.ContactsContract;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cosmin on 21.05.2017.
 */

public class Student {
    private int id;
    private String nume;
    private String prenume;
    private String universitate;
    private String telefon;
    private String mail;
    private StringBuilder cunostinte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getuniversitate() {
        return universitate;
    }

    public void setuniversitate(String universitate) {
        this.universitate = universitate;
    }

    public String getTelefon() {
        return telefon;
    }


    public StringBuilder getCunostinte() {
        return cunostinte;
    }

    public void setCunostinte(StringBuilder cunostinte) {
        this.cunostinte = cunostinte;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Student(){
        id=0;
        nume=null;
        prenume=null;
        universitate=null;
        telefon=null;
        cunostinte=null;
        mail=null;
    }

    public Student(int id,String nume, String prenume, String universitate, String mail,String telefon, StringBuilder cunostinte) {
        this.id=id;
        this.nume=nume;
        this.prenume=prenume;
        this.universitate=universitate;
        this.telefon=telefon;
        this.cunostinte=cunostinte;
        this.mail=mail;
    }
}
