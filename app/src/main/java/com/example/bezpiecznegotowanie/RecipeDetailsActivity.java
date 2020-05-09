package com.example.bezpiecznegotowanie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bezpiecznegotowanie.R;
import com.example.bezpiecznegotowanie.Recipe;

public class RecipeDetailsActivity extends AppCompatActivity {


    //zmieniono nazwy zmiennych
    private ImageView recipeDetailsImage;
    private TextView recipeDetailsLabel;
    private TextView recipeDetailsIngredients;
    private TextView recipeDetailsPreparation ;
    private Recipe recipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recipeDetailsImage = findViewById(R.id.recipe_details_image);
        recipeDetailsLabel = findViewById(R.id.recipe_details_label);
        recipeDetailsIngredients = findViewById(R.id.recipe_details_ingredients);
        recipeDetailsPreparation = findViewById(R.id.recipe_details_preparation);

        recipe = getIntent().getParcelableExtra(RecipeConnector.RECIPE_DETAILS);

        recipeDetailsImage.setImageBitmap(recipe.getImageBitmap());
        recipeDetailsLabel.setText(recipe.getLabel());
        recipeDetailsIngredients.setText(recipe.ingredientsListToString());
        recipeDetailsPreparation.setText(getString(R.string.preparation_details_disclaimer) + recipe.getSourceURL());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
