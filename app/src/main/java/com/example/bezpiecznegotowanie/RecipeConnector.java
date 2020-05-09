package com.example.bezpiecznegotowanie;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bezpiecznegotowanie.R;
import com.example.bezpiecznegotowanie.Recipe;

import java.lang.ref.WeakReference;
import java.util.List;

public class RecipeConnector extends RecyclerView.Adapter<RecipeConnector.ViewHolder> {

    //skrocono tylko nazwy zmiennych np mRecepies na recepies

    private List<Recipe> recipes;
    private Context context;

    // prawdopodobnie zla sciezka trzeba bedzie zmienic
    public static final String RECIPE_DETAILS = "com.example.chef.search_resutl.RecipesAdapter.lRecipe";



    RecipeConnector(Context context, List<Recipe> recipes){
        this.recipes = recipes;
        this.context = context;
    }


    //metody dziedziczone po innych klasach nie zmieniać
    @NonNull
    @Override
    public RecipeConnector.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecipeConnector.ViewHolder(LayoutInflater.from(context).inflate(R.layout.recipes_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeConnector.ViewHolder viewHolder, int i) {
        viewHolder.bind(recipes.get(i));
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView recipeImage;
        private TextView recipeLabel;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeImage = itemView.findViewById(R.id.recipe_image);
            recipeLabel = itemView.findViewById(R.id.recipe_label);
            itemView.setOnClickListener(this);
        }

        void bind(Recipe currentRecipe){
            recipeLabel.setText(currentRecipe.getLabel());
            new ImageDownloadTask(recipeImage).execute(currentRecipe);
        }


        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, RecipeDetailsActivity.class);
            Log.d("App-com.example.chef", recipes.get(getAdapterPosition()).getImageBitmap().toString());
            intent.putExtra(RECIPE_DETAILS, recipes.get(getAdapterPosition()));
            context.startActivity(intent);
        }
    }

    static class ImageDownloadTask extends AsyncTask<Recipe, Void, Bitmap>{

        private WeakReference<ImageView> mImageView;

        ImageDownloadTask(ImageView imageView){
            this.mImageView = new WeakReference<>(imageView);
        }

        @Override
        protected Bitmap doInBackground(Recipe... recipes) {
            return new ImageDownloadRecipe(recipes[0]).download();
        }

        @Override
        protected void onPostExecute(Bitmap recipeImage) {
            super.onPostExecute(recipeImage);
            mImageView.get().setImageBitmap(recipeImage);
        }
    }


}
