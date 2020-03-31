package com.example.engenharia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Eletrica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_eletrica);

        final Button conf =(Button) findViewById(R.id.btconfirmacao);
        final RadioButton sim1= (RadioButton)findViewById(R.id.sim1);
        final RadioButton sim2= (RadioButton)findViewById(R.id.sim2);
        final RadioButton sim3= (RadioButton)findViewById(R.id.sim3);
        final RadioButton sim4= (RadioButton)findViewById(R.id.sim4);
        final RadioButton nao1= (RadioButton)findViewById(R.id.nao1);
        final RadioButton nao2= (RadioButton)findViewById(R.id.nao2);
        final RadioButton nao3= (RadioButton)findViewById(R.id.nao3);
        final RadioButton nao4= (RadioButton)findViewById(R.id.nao4);

    conf.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        Intent intent2= new Intent(Eletrica.this, Main3Activity.class);
        startActivity(intent2);

        float pontos= 0;
        for (int i=0; i<1;i++){
            Log.i("tag:", "1:"+pontos);

  if (sim1.isChecked()){
      pontos= 2.5f +pontos;
  }
    if (nao2.isChecked()){
       pontos= 2.5f+ pontos;

  }
  if (sim3.isChecked()){
      pontos= 2.5f+ pontos;

  }
   if (nao4.isChecked()){
      pontos= 2.5f+ pontos;

  }
        }

        Toast.makeText(getApplicationContext(), "pontuação:"+ pontos,Toast.LENGTH_SHORT).show();
    }

}); }



}
