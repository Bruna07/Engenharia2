package com.example.engenharia;

public class Aluno {


    private static String nome,telefone,email;
   static int matricula;
   public Aluno(){

    }

   public Aluno(int matricula1,String nome1,String tefone1,String email1){
       this.matricula=matricula1;
       this.nome=nome1;
       this.email=email1;
       this.telefone=tefone1;

    }
    public Aluno(String nome1,String tefone1,String email1){
        this.nome=nome1;
        this.email=email1;
        this.telefone=tefone1;

    }



    public static String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
