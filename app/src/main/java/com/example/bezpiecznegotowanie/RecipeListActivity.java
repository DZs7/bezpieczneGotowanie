package com.example.bezpiecznegotowanie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.bezpiecznegotowanie.R;
import com.example.bezpiecznegotowanie.Recipe;
import com.example.bezpiecznegotowanie.utilites_search.FindRecepieRequest;

import java.util.List;

public class RecipeListActivity extends AppCompatActivity {

    private List<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recipeList = getIntent().getParcelableArrayListExtra(FindRecepieRequest.RECIPES_LIST);
        RecipeConnector recipeConnector = new RecipeConnector(this, recipeList);
        RecyclerView recipesListView = findViewById(R.id.recipes_list);
        recipesListView.setLayoutManager(new LinearLayoutManager(this));
        recipesListView.setAdapter(recipeConnector);

    }

}
