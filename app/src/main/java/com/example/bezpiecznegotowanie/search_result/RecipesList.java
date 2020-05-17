package com.example.bezpiecznegotowanie.search_result;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.chef.R;
import com.example.bezpiecznegotowanie.Recipe;
import com.example.bezpiecznegotowanie.search.FindRecepieRequest;

import java.util.List;

public class RecipesList extends AppCompatActivity {

    private List<Recipe> mRecipesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecipesList = getIntent().getParcelableArrayListExtra(FindRecepieRequest.RECIPES_LIST);
        com.example.bezpiecznegotowanie.search_result.FindRecepieRequest findRecepieRequest = new com.example.bezpiecznegotowanie.search_result.FindRecepieRequest(this, mRecipesList);
        RecyclerView recipesListView = findViewById(R.id.recipes_list);
        recipesListView.setLayoutManager(new LinearLayoutManager(this));
        recipesListView.setAdapter(findRecepieRequest);

    }

}
