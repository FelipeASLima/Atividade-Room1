package br.com.opet.tds.roomproject_modelo1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import br.com.opet.tds.roomproject_modelo1.R;
import br.com.opet.tds.roomproject_modelo1.model.Livro;
import br.com.opet.tds.roomproject_modelo1.repository.LivroRepository;

public class NovoLivroActivity extends Activity {

    private EditText editTitulo, editAutor, editQuantPag;
    private Spinner spinnerGenero,spinnerStatus;
    private LivroRepository repository;
    private CheckBox favorito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_livro);

        editTitulo = findViewById(R.id.editTitulo);
        editAutor = findViewById(R.id.editAutor);
        editQuantPag = findViewById(R.id.editQuantPag);
        spinnerStatus = findViewById(R.id.spinnerStatus);
        spinnerGenero = findViewById(R.id.spinnerGenero);
        favorito = findViewById(R.id.favorito);
        repository = new LivroRepository(getApplicationContext());
    }

    public void salvarLivro(View view){
        Livro livro = new Livro();
        livro.setTitulo(editTitulo.getText().toString());
        livro.setGenero(spinnerGenero.getSelectedItem().toString());
        livro.setAutor(editAutor.getText().toString());
        livro.setQuantPaginas(Integer.parseInt(editQuantPag.getText().toString()));
        livro.setStatus(spinnerStatus.getSelectedItem().toString());
        livro.setFavorito(favorito.isChecked());

        repository.insert(livro);
        callMainActivity();
    }

    private void callMainActivity() {
        Intent mainActivity = new Intent(NovoLivroActivity.this,MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
