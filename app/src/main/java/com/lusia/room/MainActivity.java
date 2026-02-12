package com.lusia.room;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                przepisyDatabase.zwrocWypiekiDao().usunWypiekZBazy(wszystkieWypiekiListy.get(i));
                wszystkieWypiekiListy.remove(i);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}