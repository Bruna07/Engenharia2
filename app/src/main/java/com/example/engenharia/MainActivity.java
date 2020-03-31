package com.example.engenharia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BancoDados db=new BancoDados(this);/*REFERENCIAR BANCO E CONTEXTO*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // TextView editNome= (TextView) (R.id.editNome)

/**=*=*=*=*=*=*=*=*=*=*==*=*= TESTE *=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*/
         Aluno AlunoTeste= new Aluno();
       db.addAlunos(new Aluno("BRUNA","08000000","BRUNAHOUSE9@GMAIL.COM"));
       Log.i("Bruna","Salvo com sucesso");
        AlunoTeste.setMatricula(2017);
        db.deleteAluno(AlunoTeste);
        Log.i("Bruna","Apagou aluno");
/*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=***=*=*=*=*=*=*=*=*=*=*=*=*=*=*/
    }

    /* O ONCLICK TÁ NO XML*/
    public void proximaTela(View view){

        Intent intent = new Intent(this, Eletrica.class);
        startActivity(intent);

    }

}






