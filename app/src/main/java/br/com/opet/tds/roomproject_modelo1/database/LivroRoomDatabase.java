package br.com.opet.tds.roomproject_modelo1.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import br.com.opet.tds.roomproject_modelo1.DAO.LivroDAO;
import br.com.opet.tds.roomproject_modelo1.model.Livro;

/**
 * Created by Diego on 24/09/2018.
 */
@Database(entities = {Livro.class},version = 1)
public abstract class LivroRoomDatabase extends RoomDatabase {
    private static volatile LivroRoomDatabase INSTANCE;
    public abstract LivroDAO livroDAO();

    public static LivroRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (LivroRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),LivroRoomDatabase.class,"livro_database").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
