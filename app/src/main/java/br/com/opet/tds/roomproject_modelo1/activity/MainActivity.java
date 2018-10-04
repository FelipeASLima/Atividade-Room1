package br.com.opet.tds.roomproject_modelo1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.com.opet.tds.roomproject_modelo1.R;
import br.com.opet.tds.roomproject_modelo1.adapter.LivroAdapter;
import br.com.opet.tds.roomproject_modelo1.model.Livro;
import br.com.opet.tds.roomproject_modelo1.repository.LivroRepository;


public class MainActivity extends Activity {

    private ListView listaLivros;
    private LivroRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaLivros = findViewById(R.id.listaLivros);
        repository = new LivroRepository(getApplicationContext());
        ArrayAdapter<Livro> adapter = new LivroAdapter(this,R.layout.livro_item,repository.getAllLivros());
        listaLivros.setAdapter(adapter);
    }

    public void novoLivro(View view){
        Intent novoLivro = new Intent(MainActivity.this,NovoLivroActivity.class);
        startActivity(novoLivro);
    }
}
