package com.lusia.room;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    /* https://developer.android.com/jetpack/androidx/releases/room?hl=pl#groovy */
    PrzepisyDatabase przepisyDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        przepisyDatabase = PrzepisyDatabase.zwrocInstancjeBazyDanych(MainActivity.this);
        /*przepisyDatabase.zwrocWypiekiDao().wstawWypiekDoBazy(new Wypiek(170, 120, "Sernik", "ser, ziemniaki, cukier, jajka"));
        przepisyDatabase.zwrocWypiekiDao().wstawWypiekDoBazy(new Wypiek(170, 15, "drożdzówki", "ser, drożdże, mąka, cukier, jajka"));
        przepisyDatabase.zwrocWypiekiDao().wstawWypiekDoBazy(new Wypiek(170, 60, "Chleb", "mąka, drożdże"));
        przepisyDatabase.zwrocWypiekiDao().zwrocWszystkieWypiekiZBazy();*/
        ListView listView = findViewById(R.id.listview);
        List<Wypiek> wszystkieWypiekiListy = przepisyDatabase.zwrocWypiekiDao().zwrocWszystkieWypiekiZBazy();
        ArrayAdapter<Wypiek> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, wszystkieWypiekiListy);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                przepisyDatabase.zwrocWypiekiDao().usunWypiekZBazy(wszystkieWypiekiListy.get(i));
                wszystkieWypiekiListy.remove(i);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
        EditText nazwaWypieku = findViewById(R.id.nazwa_wypieku);
        EditText skladniki = findViewById(R.id.skladniki);
        EditText czasWypieku = findViewById(R.id.czas_pieczenia);
        EditText temperaturaPieczenia = findViewById(R.id.temperatura_pieczenia);
        Button przyciskDodaj = findViewById(R.id.przycisk_dodaj);
        Button przyciskEdytuj = findViewById(R.id.przycisk_edytuj);
        przyciskDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                przepisyDatabase.zwrocWypiekiDao().wstawWypiekDoBazy(new Wypiek(Integer.parseInt(temperaturaPieczenia.getText().toString()), Integer.parseInt(czasWypieku.getText().toString()), nazwaWypieku.getText().toString(), skladniki.getText().toString()));
                wszystkieWypiekiListy.add(new Wypiek(Integer.parseInt(temperaturaPieczenia.getText().toString()), Integer.parseInt(czasWypieku.getText().toString()), nazwaWypieku.getText().toString(), skladniki.getText().toString()));
                arrayAdapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Wypiek wypiek = wszystkieWypiekiListy.get(i);
                nazwaWypieku.setText(wypiek.getNazwaWypieku().toString());
                skladniki.setText(wypiek.getSkladniki().toString());
                temperaturaPieczenia.setText(Integer.toString(wypiek.getTemperaturaPieczenia()));
                czasWypieku.setText(Integer.toString(wypiek.getCzasPieczenia()));
            }
        });
    }
}