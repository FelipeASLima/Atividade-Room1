package br.com.opet.tds.roomproject_modelo1.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.opet.tds.roomproject_modelo1.model.Livro;


@Dao
public interface LivroDAO {

    @Insert
    void insert(Livro livro);

    @Query("DELETE FROM Livro where Livro.ID == :id")
    void delete(long id);

    @Query("SELECT * from Livro")
    List<Livro> loadLivros();
}
