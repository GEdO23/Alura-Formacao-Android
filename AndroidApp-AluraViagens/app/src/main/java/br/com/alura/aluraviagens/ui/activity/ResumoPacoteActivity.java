package br.com.alura.aluraviagens.ui.activity;

import static br.com.alura.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {
    private static final String TITULO_APPBAR = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_APPBAR);

        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            inicializaCampos(pacote);
            configuraBotao(pacote);
        }
    }

    private void inicializaCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraData(pacote);
    }

    private void configuraBotao(Pacote pacote) {
        Button botaoRealizaPagamento = findViewById(R.id.resumo_pacote_botao);
        botaoRealizaPagamento.setOnClickListener(v -> vaiParaPagamento(pacote));
    }

    private void vaiParaPagamento(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this,
                PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraLocal(Pacote pacote) {
        TextView localView = findViewById(R.id.resumo_pacote_local);
        localView.setText(pacote.getLocal());
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imageView = findViewById(R.id.resumo_pacote_imagem);
        Drawable imagem = ResourceUtil.getDrawable(this, pacote.getImagem());
        imageView.setImageDrawable(imagem);
    }

    private void mostraDias(Pacote pacote) {
        TextView diasView = findViewById(R.id.resumo_pacote_dias);
        String dias = DiasUtil.format(pacote.getDias());
        diasView.setText(dias);
    }

    private void mostraPreco(Pacote pacote) {
        TextView precoView = findViewById(R.id.resumo_pacote_preco);
        String preco = MoedaUtil.format(pacote.getPreco());
        precoView.setText(preco);
    }

    private void mostraData(Pacote pacote) {
        TextView dataView = findViewById(R.id.resumo_pacote_data);
        String data = DataUtil.format(pacote.getDias());
        dataView.setText(data);
    }
}