package com.example.bezpiecznegotowanie;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import com.example.chef.utilites_result.RecipeListActivity;

import java.util.ArrayList;
import java.util.List;

public class FindRecepieRequest extends AsyncTask<FindRecipeApi, Integer, List<Recipe>> {

    //zmieniiono nazwy zmiennych
    //zmieniono nazwy metod
    private Context context;

    //prawdopodobnie niepoprwna sciezka
    public static final String RECIPES_LIST = "com.example.chef.search.RecipesSearchTask.lRecipesList";

    FindRecepieRequest(Context context){
        super();
        this.context = context;
    }

    //Only one arg allowed in current implementation
    @Override
    protected List<Recipe> doInBackground(FindRecipeApi... findRecipeApis) {
        return findRecipeApis[0].getResult();
    }

    @Override
    protected void onPostExecute(List<Recipe> result){
        super.onPostExecute(result);
        Intent launchRecipesList = new Intent(context, RecipeListActivity.class);
        launchRecipesList.putParcelableArrayListExtra(RECIPES_LIST, (ArrayList<? extends Parcelable>) result)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(launchRecipesList);
    }

}
