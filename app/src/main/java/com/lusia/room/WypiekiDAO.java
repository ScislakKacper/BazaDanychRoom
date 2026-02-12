package com.lusia.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WypiekiDAO {
    @Insert
    public void wstawWypiekDoBazy(Wypiek wypiek);
    @Insert
    public void wstawKilkaWybiekow(Wypiek ...wypieks);
    @Delete
    public void usunWypiekZBazy(Wypiek wypiek);
    @Update
    public void zaktualizujWypiek(Wypiek wypiek);
    @Query ("Select * from wypieki_tabela")
    List<Wypiek> zwrocWszystkieWypiekiZBazy();
    @Query("Select nazwaWypieku from wypieki_tabela Where `czas pieczenia`< :czas")
    List<String> zwrocNazwyWypiekow(int czas);
}
