package com.example.berdugomail;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListAdapter.OnItemClickListener {

    List<ListaElementos> elementos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init(){
        elementos = new ArrayList<>();
        elementos.add(new ListaElementos("#7B1FA2","Pedro","Ciudad de México","Recibido", "<b>Hola ! Como estas?</b><br>Saludos desde Mexico"));
        elementos.add(new ListaElementos("#7b1fcc","Julian","Medellín","Recibido", "<i>Que mas parcero como anda?</i><br>espero que bien, Pronto le enviare Comida tipica de mi ciudad."));
        elementos.add(new ListaElementos("#3F51B5","Magnus","Noruega","Recibido", "<u>Hola que tal?</u><br>te comento que proximamente voy a realizar un torneo de ajedrez en colombia y me gustaria contar con tu apoyo, Viajarias conmigo?"));
        elementos.add(new ListaElementos("#009688","Paulina","Chile","Recibido", "<font color='#FF5722'>Hola, te hablo debido a que ayer ocurrio un desastre natural en mi ciudad y me dejo sin casa , me podrias prestar dinero ? lo necesito de momento, te aviso cuando te pago.</font>"));
        elementos.add(new ListaElementos("#FF5722","Tenshi lida","Japón","Recibido", "こんにちは、すでに新しいアニメ シリーズを開始したことをお知らせします。ぜひ先行販売でご覧ください。"));

        ListAdapter listAdapter = new ListAdapter(elementos,this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

        listAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(int position) {

        String emailContent = elementos.get(position).getEmailContent();


        elementos.get(position).setEstado("Leído");


        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.getAdapter().notifyItemChanged(position);


        Class pantallaClass = null;
        switch (position) {
            case 0:
                pantallaClass = Pantalla_Pedro.class;
                break;
            case 1:
                pantallaClass = Pantalla_Julian.class;
                break;
            case 2:
                pantallaClass = Pantalla_Magnus.class;
                break;
            case 3:
                pantallaClass = Pantalla_Paulina.class;
                break;
            case 4:
                pantallaClass = Pantalla_Tenshi.class;
                break;
        }
        Intent intent = new Intent(this, pantallaClass);


        intent.putExtra("email_content", emailContent);


        startActivity(intent);
    }
}
