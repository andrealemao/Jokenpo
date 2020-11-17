package com.cursoandroid.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectedOption(String selectedOption){
        ImageView resultImage = findViewById(R.id.resultImage);
        TextView resultText = findViewById(R.id.resultText);

        int option = new Random().nextInt(3);
        String[] options = {"pedra", "papel", "tesoura"};
        String appOption = options[option];

        switch (appOption){
            case "pedra":
                resultImage.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                resultImage.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                resultImage.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (appOption == "tesoura" && selectedOption == "papel") ||
                (appOption == "papel"   && selectedOption == "pedra") ||
                (appOption == "pedra"   && selectedOption == "tesoura")
        ){//app ganhador
            resultText.setText("Você perdeu!!");
        }else if (
                (selectedOption == "tesoura" && appOption == "papel") ||
                (selectedOption == "papel"   && appOption == "pedra") ||
                (selectedOption == "pedra"   && appOption == "tesoura")
        ){ // usuario ganhador
            resultText.setText("Você ganhou!!");
        }else{ // empate
            resultText.setText("Empate!!");
        }
    }

    public void rockSelected(View view){
        this.selectedOption("pedra");
    }

    public void paperSelected(View view){
        this.selectedOption("papel");
    }

    public void scissorsSelected(View view){
        this.selectedOption("tesoura");
    }
}