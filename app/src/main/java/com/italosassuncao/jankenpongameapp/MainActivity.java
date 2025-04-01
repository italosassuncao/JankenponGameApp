package com.italosassuncao.jankenpongameapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecionarPedra(View view){
        verificarGanhador("pedra");
    }

    public void selecionarPapel(View view){
        verificarGanhador("papel");
    }

    public void selecionarTesoura(View view){
        verificarGanhador("tesoura");
    }

    private String gerarEscolhaApp() {

        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numeroAleatorio = new Random().nextInt(3);

        ImageView imageViewApp = findViewById(R.id.image_app);
        String escolhaApp = opcoes[numeroAleatorio];
        switch (escolhaApp){
            case "pedra":
                imageViewApp.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                imageViewApp.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imageViewApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaApp;

        /*String[] opcoes = {"pedra", "papel", "tesoura"};
        int indice = (int) (Math.random() * opcoes.length);
        return opcoes[indice];*/
    }

    private void verificarGanhador(String escolhaUsuario){

        String escolhaApp = gerarEscolhaApp();

        //System.out.println("Escolha do usuário: " + escolhaUsuario);
    }

}