package com.example.weterynarz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText imieWlasciciela;
    ListView zwierzeta;
    TextView wiekText;
    SeekBar wiekSeekBar;
    EditText wizytaEditText;
    EditText czasEditText;
    Button buttonZatwierdz;
    TextView textPoWykonaniu;

    String gatunek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imieWlasciciela = findViewById(R.id.imieWlasciciela);
        zwierzeta = findViewById(R.id.zwierzeta);
        wiekText = findViewById(R.id.wiekText);
        wiekSeekBar = findViewById(R.id.wiekSeekBar);
        wizytaEditText = findViewById(R.id.wizytaEditText);
        czasEditText = findViewById(R.id.czasEditText);
        buttonZatwierdz = findViewById(R.id.buttonZatwierdz);
        textPoWykonaniu = findViewById(R.id.textPoWykonaniu);


        ArrayList<String> animals= new ArrayList<>();
        animals.add("Pies");
        animals.add("Kot");
        animals.add("Świnka morska");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, animals);
        zwierzeta.setAdapter(adapter);


        zwierzeta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    wiekSeekBar.setMax(18);
                    gatunek = "Pies";
                }
                if(i==1){
                    wiekSeekBar.setMax(15);
                    gatunek = "Kot";
                }
                if(i==2) {
                    wiekSeekBar.setMax(9);
                    gatunek = "Świnka morska";
                }
            }
        });

        wiekSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                wiekText.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        buttonZatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wlasciciel = imieWlasciciela.getText().toString();
                String wiek = wiekText.getText().toString();
                String wizyta = wizytaEditText.getText().toString();
                String czas = czasEditText.getText().toString();

                textPoWykonaniu.setVisibility(View.VISIBLE);
                textPoWykonaniu.setText(wlasciciel+ " " + gatunek +  " " + wiek + " " + wizyta + " " + czas + " ");
            }
        });
    }
}