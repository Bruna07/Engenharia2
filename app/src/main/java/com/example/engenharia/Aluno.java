package com.example.engenharia;

import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Aluno  {


    private static String nome,telefone,email,matricula;
   static int indice;
   public Aluno(){

    }

   public Aluno(int indice1,String matricula1,String nome1,String tefone1,String email1){
       this.indice=indice1;
       this.matricula=matricula1;
       this.nome=nome1;
       this.email=email1;
       this.telefone=tefone1;
      
    }
    public Aluno(String matricula1,String nome1,String tefone1,String email1){
        this.matricula=matricula1;
        this.nome=nome1;
        this.email=email1;
        this.telefone=tefone1;

    }

 public static void setIndice(int indice0){
       indice= indice0;
}
    public static void setNome(String nome0) {
        nome = nome0;
    }
    public static void setTelefone(String telefone0) {
        telefone = telefone0;
    }

    public static void setEmail(String email0) {
        email = email0;
    }
    public static void setMatricula(String matricula0) {
        matricula = matricula0;
    }

    public static String getNome() {
        return nome;
    }

    public static int getIndice() {
        return indice;
    }

    public static String getTelefone() {
        return telefone;
    }

    public static String getEmail() {
        return email;
    }

    public static String getMatricula() {
        return matricula;
    }


}
