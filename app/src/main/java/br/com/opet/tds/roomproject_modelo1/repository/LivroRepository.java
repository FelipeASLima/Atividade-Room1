package br.com.opet.tds.roomproject_modelo1.repository;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import br.com.opet.tds.roomproject_modelo1.DAO.LivroDAO;
import br.com.opet.tds.roomproject_modelo1.database.LivroRoomDatabase;
import br.com.opet.tds.roomproject_modelo1.model.Livro;

/**
 * Created by Diego on 24/09/2018.
 */

public class LivroRepository {
    private LivroDAO mLivroDAO;
    private List<Livro> mLivros;

    public LivroRepository(Context context){
        LivroRoomDatabase db = LivroRoomDatabase.getDatabase(context);
        mLivroDAO = db.livroDAO();
        mLivros = mLivroDAO.loadLivros();
    }

    public List<Livro> getAllLivros(){
        return mLivros;
    }

    public void insert(Livro livro){
        new insertAsyncTask(mLivroDAO).execute(livro);
    }

    private static class insertAsyncTask extends AsyncTask<Livro,Void,Void>{

        private LivroDAO mAsyncTaskDAO;

        insertAsyncTask(LivroDAO dao){
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final Livro... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
