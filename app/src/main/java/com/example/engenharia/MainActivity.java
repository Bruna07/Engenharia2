package com.example.engenharia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editMatricula,editNome,editTelefone,editEmail;
    Button salvar,limpar,excluir;

    BancoDados db  =new BancoDados(this);/*REFERENCIAR BANCO E CONTEXTO*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editMatricula= (EditText) findViewById(R.id.editMatricula);
        editNome= (EditText) findViewById(R.id.editNome);
        editTelefone=(EditText) findViewById(R.id.editTelefone);
        editEmail=(EditText)findViewById(R.id.editEmail);


/**=*=*=*=*=*=*=*=*=*=*==*=*= TESTE *=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*/
       Aluno AlunoTeste= new Aluno();
     /*   db.addAlunos(new Aluno(" Mateus ","555665","Mateus@GMAIL.COM"));
        db.addAlunos(new Aluno("Juliana","02525250","Juliana@GMAIL.COM"));
        db.addAlunos(new Aluno("Pedro","228584","Pedro@GMAIL.COM"));
        db.addAlunos(new Aluno("Sofia","1515115","Sofia@GMAIL.COM"));*/
     //  Log.i("Bruna","Salvo com sucesso");
       //  AlunoTeste.setMatricula(2);
    //    db.deleteAluno(AlunoTeste);
     //   Log.i("Bruna"," Aluno deletado:"+ Aluno.getMatricula()+","+Aluno.getNome()+","+Aluno.getTelefone()+","+Aluno.getEmail());
/*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=***=*=*=*=*=*=*=*=*=*=*=*=*=*=*/
    }

    /* O ONCLICK TÁ NO XML*/
    public void proximaTela(View view){

        Intent intent = new Intent(this, Eletrica.class);
        startActivity(intent);

    }

}






