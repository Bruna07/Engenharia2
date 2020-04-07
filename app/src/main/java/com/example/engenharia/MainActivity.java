package com.example.engenharia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edit_Matricula,edit_Nome,edit_Telefone,edit_Email;
    Button bt_salvar,bt_limpar,bt_excluir;
    ListView listViewAlunos;

    Banco2 db2=new Banco2(this);/**REFERENCIAR BANCO E CONTEXTO*/
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_Matricula= (EditText) findViewById(R.id.editMatricula);
        edit_Nome= (EditText) findViewById(R.id.editNome);
        edit_Telefone=(EditText) findViewById(R.id.editTelefone);
        edit_Email=(EditText)findViewById(R.id.editEmail);
        listViewAlunos=(ListView) findViewById(R.id.editLista);
        bt_salvar=(Button) findViewById(R.id.btSalvar);



    /**=*=*=*=*=*=*=*=*=*=*==*=*= TESTE ADICIONAR ALUNO *=*=*=*=*=*=*=*=*=*=*=*=*=*=*/
       /* Aluno a1 =new Aluno("20172eeps0381"," Mateus ","555665","Mateus@GMAIL.COM");
        db2.addAlunos(a1);
        Aluno a2 =new Aluno("20172eeps0382","Pedro","228584","Pedro@GMAIL.COM");
        db2.addAlunos(a2);*/
        //Aluno a3 =new Aluno("20172eeps0383","Sofia","1515115","Sofia@GMAIL.COM");
       // db2.addAlunos(a3);
     /**=*=*=*=*=*=*=*=*=*=*==*=*= TESTE DELETE ALUNO *=*=*=*=*=*=*=*=*=*=*=*=*=*=*/
        /*Aluno a4= new Aluno();
         a4.setIndice(3);
        db2.deleteAluno(a4);*/

      /**=*=*=*=*=*=*=*=*=*=*==*=*= TESTE ATUALIZAR ALUNO *=*=*=*=*=*=*=*=*=**=*=*=*/
        /* Aluno aluno = new Aluno();
         aluno.setIndice(1);
         Aluno.setNome("Bruna Raquel");
         Aluno.setMatricula("20172eeps03389");
         Aluno.setEmail("Brunahouse9@@gmail.com");
         Aluno.setTelefone("87991068166");
         db2.atualizarAluno(aluno);*/
        /**=*=*=*=*=*=*=*=*=*=*==*=*= TESTE SELECIONAR ALUNO *=*=*=*=*=**=*=*=*=*=*=*=*/
       // Aluno a5= db2.selecionarAluno(1);
       // Log.i("Bruna"," Aluno Selecionado: " + Aluno.getIndice()+ Aluno.getMatricula()+","+Aluno.getNome()+","+Aluno.getTelefone()+","+Aluno.getEmail());

        /**=*=*=*=*=*=*=*=*=*=*==*=*= TESTE LISTAR ALUNO *=*=*=*=*=*=*=*=*=**=*=*=*/
       /// Log.i("Bruna", "Entrou: AddAlunos();"+db2.getDatabaseName());
        listarAlunos();
        /**=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=***=*=*=*=*=*=*=*=*=*=*=*=*=*=*/

/*bt_salvar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
Log.i("Bruna","Botão salvar acionado ");
        String nome= edit_Nome.getText().toString();
        String matricula= edit_Matricula.getText().toString();
        String telefone= edit_Telefone.getText().toString();
        String email= edit_Email.getText().toString();
        if(nome.isEmpty()){
            db2.addAlunos(new Aluno(matricula,nome,telefone,email));
            Toast.makeText(MainActivity.this, "Aluno Salvo com sucesso.", Toast.LENGTH_SHORT).show();
            listarAlunos();
        }
    }
});*/


    }
    /** O ONCLICK TÁ NO XML*/
    public void telaQuestionario(View view){
   /**ESSE METODO ABRI UMA SEGUNDA ACTIVITY AO CLICAR NO BOTÃO INICIO*/
        Intent intent = new Intent(this, Eletrica.class);
        startActivity(intent);
    }
    /** O ONCLICK TÁ NO XML*/


public void listarAlunos() {
        Log.i("Bruna","Entrou: listarAlunos(); " );

    List<Aluno> alunos = db2.listaTodosAlunos();

    arrayList= new ArrayList<String>();

    adapter= new ArrayAdapter< String >(MainActivity.this,android.R.layout.simple_list_item_1, arrayList);

    listViewAlunos.setAdapter(adapter);


    for (Aluno c : alunos) {

       // Log.d("Bruna", "\nID " + c.getIndice() + " Nome: " + c.getMatricula());
     //arrayList.add(c.getIndice()+  "-" + c.getMatricula());
     adapter.notifyDataSetChanged();

    }

}
}






