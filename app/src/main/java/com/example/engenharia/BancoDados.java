package com.example.engenharia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import static com.example.engenharia.Aluno.*;

public class BancoDados extends SQLiteOpenHelper {

    public static final String Banco_Alunos ="bd_alunos";
    public static final int versao=1;
    public static final String  tabela_Alunos="tb_alunos";

/**=*=*=*=*=*=*==*= COLUNAS DA TABELA *=*=*=*=*=*=*==*=*==*=*/
    public static final String coluna_Matricula="matricula";
    public static final String coluna_nome="nome";
    public static final String coluna_telefone="telefone";
    public static final String coluna_email="email";
/* *=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=**/

    public BancoDados(@Nullable Context context) {
        super(context, Banco_Alunos, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("Bruna","Criando Tabela.");
        //(tipoS)(integer primary key) usando no primeiro o incremento é automático
        //OBS ESTRUTURA
       String tabelaAlunos= "create table "+ tabela_Alunos +"(" + coluna_Matricula +" integer primary key, " + coluna_nome+" text, " +coluna_telefone+ " text, "+coluna_email+"text)";
       //db.execSQL( "CREATE TABLE " + NOME_TABELA + " (" + ID_USUARIO + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NOME + " TEXT NOT NULL, " + EMAIL + " TEXT NOT NULL, " + SENHA + " TEXT NOT NULL );" ); } –

        db.execSQL(tabelaAlunos);/*PARA EXECUTAR*/
        Log.i("Bruna","Tabela Criada com sucesso.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //CASO MUDE A VERSÃO PODE EXECUTAR SQLITE
    }

    /*MÉTODO RESPONSÁVEL POR ADICIONAR UM ALUNO A TABELA*/
    public void addAlunos(Aluno aluno1){

        Log.i("Bruna","Entrou no AddAlunos");

        SQLiteDatabase db = this.getWritableDatabase(); //Crie e / ou abrir banco de dados que será usado para leitura e gravação.
        ContentValues values= new ContentValues(); /*ARMAZENAR O CONJUNTO DE VALORES*/
        /*CHAVE VALOR*/
        values.put(coluna_nome, Aluno.getNome());
        values.put(coluna_telefone, Aluno.getTelefone());
        values.put(coluna_email, Aluno.getEmail());

        db.insert(tabela_Alunos,null,values);/* INSERIR TABELA*/
        db.close(); /* FECHAR O BANCO DE DADOS*/
    }

    /* MÉTODO RESPONSÁVEL POR EXCLUIR ALUNO DA TABELA*/
 public void deleteAluno(Aluno aluno1){
Log.i("Bruna","Entrou no deleteAluno");
     SQLiteDatabase db= this.getWritableDatabase(); /* GRAVAÇÃO NO BANCO*/
   db.delete(tabela_Alunos, coluna_Matricula + " =? ", new String[]{String.valueOf(Aluno.getMatricula())}); /*OBS: POSSIVEL PROBLEMA*/
     /* "COLUNA_MATRICULA" A BASE DE REFERÊNCIA PARA APAGAR*/
/* "?" ->  PARAMÊTRO VEM DE OUTRO LUGAR E É ENCAIXADO*/
    db.close();
 }

 /*METODO PAR LEITURA SELECIONAR ALUNO DO BANCO */
    public void selecionarAluno(Aluno aluno1){
        SQLiteDatabase db= this.getReadableDatabase();/*LEITURA DO BANCO*/


    }
}
