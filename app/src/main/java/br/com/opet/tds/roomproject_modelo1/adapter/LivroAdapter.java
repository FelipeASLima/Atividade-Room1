package br.com.opet.tds.roomproject_modelo1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.opet.tds.roomproject_modelo1.R;
import br.com.opet.tds.roomproject_modelo1.model.Livro;


public class LivroAdapter extends ArrayAdapter<Livro> {
    private int rId;

    public LivroAdapter(@NonNull Context context, int resource, @NonNull List<Livro> objects) {
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent){
        View mView = currentView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId,null);
        }

        Livro livro = getItem(position);

        TextView textTitulo = mView.findViewById(R.id.textNomeLivro);
        TextView textGenero = mView.findViewById(R.id.textGeneroLivro);
        TextView textStatus = mView.findViewById(R.id.textStatusLivro);


        textTitulo.setText(livro.getTitulo().toUpperCase());
        textGenero.setText(livro.getGenero());
        textStatus.setText("Status: " + String.valueOf(livro.getStatus()));

        return mView;
    }
}
