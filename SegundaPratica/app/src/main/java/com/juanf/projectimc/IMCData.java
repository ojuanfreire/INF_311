package com.juanf.projectimc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class IMCData extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);

        // Recebendo dados da primeira tela
        // E os adicionando em suas respectivas views
        Intent it = getIntent();
        Bundle params = it.getExtras();

        TextView setName = (TextView) findViewById(R.id.setName);
        setName.setText(params.getString("name"));

        TextView setAge = (TextView) findViewById(R.id.setAge);
        setAge.setText(params.getString("age"));

        TextView setWeight = (TextView) findViewById(R.id.setWeight);
        setWeight.setText(String.valueOf(params.getDouble("weight")));

        TextView setHeight = (TextView) findViewById(R.id.setHeight);
        setHeight.setText(String.valueOf(params.getDouble("height")));

        TextView setIMC = (TextView) findViewById(R.id.setIMC);
        setIMC.setText(String.valueOf(params.getDouble("imc")));

        TextView setClassification = (TextView) findViewById(R.id.setClassification);
        setClassification.setText(params.getString("classification"));
    }

    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de Vida da Tela Secundária", ".onStart() foi chamado em: " + getClass().getName());
    }

    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida da Tela Secundária", ".onRestart() foi chamado em: " + getClass().getName());
    }

    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de Vida da Tela Secundária", ".onResume() foi chamado em: " + getClass().getName());
    }

    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida da Tela Secundária", ".onPause() foi chamado em: " + getClass().getName());
    }

    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida da Tela Secundária", ".onStop() foi chamado em: " + getClass().getName());
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida da Tela Secundária", ".onDestroy() foi chamado em: " + getClass().getName());
    }

    public void back(View v) {
        finish();
        Log.i("Ciclo de Vida da Tela Secundária","O método .back() foi chamado!");
    }
}
