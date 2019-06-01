package com.prado.walletshares.Helper;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prado.walletshares.Presentation.PresentationModel.CardModel;
import com.prado.walletshares.R;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.stockViewHolder>{
    List<CardModel> cards;
    GetCard getCard;

    public RVAdapter(List<CardModel> cards, GetCard getCard){
        this.getCard = getCard;
        this.cards = cards;
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    @Override
    public stockViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item, viewGroup, false);
        stockViewHolder pvh = new stockViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(stockViewHolder stockViewHolder, final int i) {
        stockViewHolder.txtTitulo.setText(cards.get(i).getTitle());
        stockViewHolder.txtSubtitulo.setText(cards.get(i).getSubtitle());

        stockViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCard.get(cards.get(i));
            }
        });
    }

    public static class stockViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView txtTitulo;
        TextView txtSubtitulo;
        TextView txtValue;

        stockViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            txtTitulo = (TextView)itemView.findViewById(R.id.text_title);
            txtSubtitulo = (TextView)itemView.findViewById(R.id.text_subtitle);
            txtValue = (TextView)itemView.findViewById(R.id.text_value);
        }
    }
}
