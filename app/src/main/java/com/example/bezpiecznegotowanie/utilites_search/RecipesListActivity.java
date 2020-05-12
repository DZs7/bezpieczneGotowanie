package com.example.bezpiecznegotowanie.utilites_search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.chef.R;
import com.example.bezpiecznegotowanie.Recipe;
import com.example.bezpiecznegotowanie.utilites_result.FindRecepieRequest;

import java.util.List;

public class RecipesListActivity extends AppCompatActivity {

    private List<Recipe> mRecipesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecipesList = getIntent().getParcelableArrayListExtra(FindRecepieRequest.RECIPES_LIST);
        com.example.bezpiecznegotowanie.utilites_search.FindRecepieRequest findRecepieRequest = new com.example.bezpiecznegotowanie.utilites_search.FindRecepieRequest(this, mRecipesList);
        RecyclerView recipesListView = findViewById(R.id.recipes_list);
        recipesListView.setLayoutManager(new LinearLayoutManager(this));
        recipesListView.setAdapter(findRecepieRequest);

    }

}
