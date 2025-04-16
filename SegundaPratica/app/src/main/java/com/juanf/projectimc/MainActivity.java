package com.juanf.projectimc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Console;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de Vida da Tela Principal", ".onStart() foi chamado em: " + getClass().getName());
    }

    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida da Tela Principal", ".onRestart() foi chamado em: " + getClass().getName());
    }

    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de Vida da Tela Principal", ".onResume() foi chamado em: " + getClass().getName());
    }

    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida da Tela Principal", ".onPause() foi chamado em: " + getClass().getName());
    }

    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida da Tela Principal", ".onStop() foi chamado em: " + getClass().getName());
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida da Tela Principal", ".onDestroy() foi chamado em: " + getClass().getName());
    }

    public void getData(View v) {
        // Iniciando dados
        String name = "";
        String age = "";
        Double weight = 0.0;
        Double height = 0.0;
        Double imc = 0.0;
        String classification = "";

        // Recolhendo os dados
        EditText getName = (EditText) findViewById(R.id.editName);
        name = getName.getText().toString();

        EditText getAge = (EditText) findViewById(R.id.editAge);
        age = getAge.getText().toString();

        EditText getWeight = (EditText) findViewById(R.id.editWeight);
        weight = Double.parseDouble(getWeight.getText().toString());

        EditText getHeight = (EditText) findViewById(R.id.editHeight);
        height = Double.parseDouble(getHeight.getText().toString());

        imc = weight/(height*height);

        //Limitando a duas casas decimais
        imc = Math.round(imc * 100.0) / 100.0;

        if (imc < 18.5) {
            classification = "Abaixo do peso";
        } else if (imc >= 18.5 && imc <= 24.9) {
            classification =  "Saudável";
        } else if (imc >= 25 && imc <= 29.9) {
            classification = "Sobrepeso";
        } else if (imc >= 30.0 && imc <= 34.9) {
            classification = "Obesidade Grau I";
        } else if (imc >= 35 && imc <= 39.9) {
            classification = "Obesidade Grau II (severa)";
        } else if (imc >= 40) {
            classification = "Obesidade Grau III (mórbida)";
        }

        // Armazenando os dados em um bundle e enviando para a outra tela
        Intent it = new Intent(getBaseContext(), IMCData.class);
        it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        Bundle params = new Bundle();

        params.putString("name", name);
        params.putString("age", age);
        params.putDouble("weight", weight);
        params.putDouble("height", height);
        params.putDouble("imc", imc);
        params.putString("classification", classification);

        it.putExtras(params);

        // Inicia a outra tela
        startActivity(it);
        Log.i("Ciclo de Vida da Tela Principal", "Cliquei para ir para a tela secundária!");
    }
}