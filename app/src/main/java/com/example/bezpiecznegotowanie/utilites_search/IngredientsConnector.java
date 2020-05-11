package com.example.bezpiecznegotowanie.utilites_search;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.chef.R;

import java.util.List;

class IngredientsConnector extends RecyclerView.Adapter<IngredientsConnector.ViewHolder> {



    private List<String> ingredients;
    private Context context;

    IngredientsConnector(Context context, List<String> ingredients){
        this.ingredients = ingredients;
        this.context = context;
    }

    @NonNull
    @Override
    public IngredientsConnector.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.ingredients_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsConnector.ViewHolder viewHolder, int i) {
        viewHolder.bind(ingredients.get(i));
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mIngredient;
        private ImageButton mRemoveButton;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mIngredient = itemView.findViewById(R.id.ingredient);
            mRemoveButton = itemView.findViewById(R.id.removeButton);
            mRemoveButton.setOnClickListener(this);
        }

        void bind(String currentIngredient){
            mIngredient.setText(currentIngredient);
        }

        @Override
        public void onClick(View v) {
            ingredients.remove(getAdapterPosition());
            notifyItemRemoved(getAdapterPosition());
        }
    }
}
