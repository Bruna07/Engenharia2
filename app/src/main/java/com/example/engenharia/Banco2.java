package com.example.engenharia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.example.engenharia.Aluno.*;

public class Banco2 extends SQLiteOpenHelper{

   // public static final String Banco_Aluno ="bd2_aluno";//NOME DO BANCO
    public static final String Banco_Aluno ="bd2_aluno";//NOME DO BANCO
    public static final int versaoBD=1;

    public static final String  tabela_Alunos="tb_alunos";
    public static final String coluna_indice="indice";
    public static final String coluna_Matricula="matricula";
    public static final String coluna_nome="nome";
    public static final String coluna_telefone="telefone";
    public static final String coluna_email="email";
    /* *=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=**/
    /*private static final String TAB2 = "CREATE TABLE " + tabela_Alunos + "(" +
            coluna_indice + " INTEGER PRIMARY KEY," + coluna_Matricula  + " TEXT," + coluna_nome + " TEXT," + coluna_telefone+ " TEXT," +
            coluna_email + " TEXT)";*/
   // private static final String SQL_CREATE_ENTRIES =
    private static final String    SQL_CREATE_ENTRIES =  "CREATE TABLE " + tabela_Alunos + " (" +
                    coluna_indice + " INTEGER PRIMARY KEY," +
                    coluna_nome+ " TEXT," + coluna_Matricula+ " TEXT," + coluna_telefone+ " TEXT,"+
                    coluna_email + " TEXT)";


    public static final String SCRIPT_DELETE_TABELA =  "DROP TABLE IF EXISTS " + tabela_Alunos;/*CASO MUDE A VERSÃO*/


    public Banco2(@Nullable Context context) {
        super(context, Banco_Aluno, null, versaoBD);
    }

    @Override
    public void onCreate(SQLiteDatabase db2) {
        Log.i("Bruna", "Criou tabela);");
        db2.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db2, int oldVersion, int newVersion) {

        db2.execSQL(SCRIPT_DELETE_TABELA);
        onCreate(db2);
    }
    public void addAlunos(Aluno aluno1) {

        Log.i("Bruna", "Entrou: AddAlunos();");

        SQLiteDatabase db2 = getWritableDatabase(); //Cria ou abri o banco de dados


        ContentValues valores = new ContentValues(); /*ARMAZENAR O CONJUNTO DE VALORES*/
        valores.put(coluna_Matricula, Aluno.getMatricula());
        valores.put(coluna_nome, Aluno.getNome());
        valores.put(coluna_telefone, Aluno.getTelefone());
        valores.put(coluna_email, Aluno.getEmail());
         db2.insert(tabela_Alunos,null,valores);/* INSERIR TABELA*/
         db2.close(); /* FECHAR O BANCO DE DADOS*/

        Log.i("Bruna"," Aluno Adicionado: "+ Aluno.getMatricula()+","+Aluno.getNome()+","+Aluno.getTelefone()+","+Aluno.getEmail());
    }

    public void deleteAluno(Aluno aluno1){
        Log.i("Bruna","Entrou: deleteAluno();");

        SQLiteDatabase db2= this.getWritableDatabase(); /* GRAVAÇÃO NO BANCO*/
        Log.i("Bruna"," Aluno Deletado: "+ aluno1.getMatricula()+","+aluno1.getNome()+","+aluno1.getTelefone()+","+aluno1.getEmail());
        db2.delete(tabela_Alunos,coluna_indice + " = ?", new String[]{String.valueOf(aluno1.getIndice())});

        db2.close();
    }



public Aluno selecionarAluno(int indice0 ){
    Log.i("Bruna","Entrou: SelecionarAluno();");
        SQLiteDatabase db2= this.getReadableDatabase();
        Cursor cursor= db2.query(tabela_Alunos,new String[]{coluna_indice,coluna_Matricula,coluna_nome,coluna_telefone,coluna_email},coluna_indice + " = ?",
                new String[]{String.valueOf(indice0)},null,null,null,null);
      if(cursor != null){

    cursor.moveToFirst();/*MOVE PARA PRIMEIRA LINHA*/
}
    Aluno aluno0= new Aluno(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),
            cursor.getString(3),cursor.getString(4) );
            return aluno0;
    }


public void atualizarAluno(Aluno aluno0){
    Log.i("Bruna","Entrou: AtualaAluno();");
  SQLiteDatabase db2= this.getWritableDatabase();

    ContentValues valores = new ContentValues();
    valores.put(coluna_Matricula, Aluno.getMatricula());
    valores.put(coluna_nome, Aluno.getNome());
    valores.put(coluna_telefone, Aluno.getTelefone());
    valores.put(coluna_email, Aluno.getEmail());
    db2.update(tabela_Alunos,valores,coluna_indice + " = ?",
            new String[]{String.valueOf(Aluno.getIndice())});
    Log.i("Bruna","Atualizado com sucesso: ");
}

public List<Aluno> listaTodosAlunos(){
    Log.i("Bruna","Entrou: ListaTodosAlunos();");
   List< Aluno> listaAlunos  = new ArrayList< Aluno >();


   String query = "select * from " + tabela_Alunos ;

    SQLiteDatabase db2= this.getWritableDatabase();
    Cursor cursor2 = db2.rawQuery(query,null);
    if (cursor2.moveToFirst()){
        do{
            Aluno aluno = new Aluno();
            aluno.setIndice(Integer.parseInt(cursor2.getString(0)));
            aluno.setMatricula(cursor2.getString(1));
            aluno.setNome(cursor2.getString(2));
            aluno.setTelefone(cursor2.getString(3));
            aluno.setEmail(cursor2.getString(4));

            listaAlunos.add(aluno);
        }while (cursor2.moveToNext());
    }
return listaAlunos;
}

}

