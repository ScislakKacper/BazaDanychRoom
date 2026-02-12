package com.lusia.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Dodajemy informację, że klasa jest encją (tabelą) bazy danych i podajemy jej nazwę
@Entity (tableName = "wypieki_tabela")
public class Wypiek {
    @PrimaryKey (autoGenerate = true) // samo sie bedzie generowac
    private int id;
    @ColumnInfo (name = "temperatura pieczenia") // nazwa kolumny
    private int temperaturaPieczenia;
    @ColumnInfo (name = "czas pieczenia")
    private int czasPieczenia;
    private String nazwaWypieku;
    private String skladniki;

    public Wypiek(int temperaturaPieczenia, int czasPieczenia, String nazwaWypieku, String skladniki) {
        id = 0; // musi być
        this.temperaturaPieczenia = temperaturaPieczenia;
        this.czasPieczenia = czasPieczenia;
        this.nazwaWypieku = nazwaWypieku;
        this.skladniki = skladniki;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemperaturaPieczenia() {
        return temperaturaPieczenia;
    }

    public void setTemperaturaPieczenia(int temperaturaPieczenia) {
        this.temperaturaPieczenia = temperaturaPieczenia;
    }

    public int getCzasPieczenia() {
        return czasPieczenia;
    }

    public void setCzasPieczenia(int czasPieczenia) {
        this.czasPieczenia = czasPieczenia;
    }

    public String getNazwaWypieku() {
        return nazwaWypieku;
    }

    public void setNazwaWypieku(String nazwaWypieku) {
        this.nazwaWypieku = nazwaWypieku;
    }

    public String getSkladniki() {
        return skladniki;
    }

    public void setSkladniki(String skladniki) {
        this.skladniki = skladniki;
    }

    @Override
    public String toString() {
        return "Wypiek{" +
                "id=" + id +
                ", temperaturaPieczenia=" + temperaturaPieczenia +
                ", czasPieczenia=" + czasPieczenia +
                ", nazwaWypieku='" + nazwaWypieku + '\'' +
                ", skladniki='" + skladniki + '\'' +
                '}';
    }
}
