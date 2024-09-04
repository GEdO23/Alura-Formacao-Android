package br.com.alura.aluraviagens.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourceUtil;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder")
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(position);

        mostraLocal(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);

        return viewCriada;
    }

    private static void mostraLocal(View parent, Pacote pacote) {
        TextView local = parent.findViewById(R.id.item_pacote_tv_local);
        local.setText(pacote.getLocal());
    }

    private static void mostraDias(View parent, Pacote pacote) {
        TextView dias = parent.findViewById(R.id.item_pacote_tv_dias);
        dias.setText(DiasUtil.format(pacote.getDias()));
    }

    private static void mostraPreco(View parent, Pacote pacote) {
        TextView preco = parent.findViewById(R.id.item_pacote_tv_preco);
        preco.setText(MoedaUtil.format(pacote.getPreco()));
    }

    private void mostraImagem(View parent, Pacote pacote) {
        ImageView imagem = parent.findViewById(R.id.item_pacote_imagem);
        imagem.setImageDrawable(ResourceUtil.getDrawable(context, pacote.getImagem()));
    }
}
