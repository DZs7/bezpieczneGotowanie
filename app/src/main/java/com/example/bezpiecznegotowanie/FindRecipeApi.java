package com.example.bezpiecznegotowanie;

import android.net.Uri;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class FindRecipeApi {

    //https://api.edamam.com/search

    private String mQueryIngredients = "";
    private String mQueryRecipeCount;
    private String mQueryPreparationTime;
    private String mErrorMessage = "";
    private String mBuiltURL;

    private final static String BASE_URI = "https://api.edamam.com/search?";
    private final static String PARAM_Q = "q";
    private final static String PARAM_TO = "to";
    private final static String PARAM_TIME = "time";
    private final static String PARAM_APP_ID = "app_id";
    private final static String PARAM_APP_KEY = "app_key";
    private final static String APP_ID = "d5494739";
    private final static String APP_KEY = "9c1fb9f937e7decb9d096753ea325235";


    FindRecipeApi(List<String> ingredients, int recipeCount, int preparationTime) {
        for (String ingredient : ingredients)
            mQueryIngredients += ingredient + ",";
        mQueryRecipeCount = String.valueOf(recipeCount);
        mQueryPreparationTime = String.valueOf(preparationTime);
    }

    private String buildSearchURL() {
        Uri searchURL = Uri.parse(BASE_URI).buildUpon()
                .appendQueryParameter(PARAM_Q, mQueryIngredients)
                .appendQueryParameter(PARAM_TO, mQueryRecipeCount)
                .appendQueryParameter(PARAM_TIME, mQueryPreparationTime)
                .appendQueryParameter(PARAM_APP_ID, APP_ID)
                .appendQueryParameter(PARAM_APP_KEY, APP_KEY)
                .build();
        mBuiltURL = searchURL.toString();
        return searchURL.toString();
    }

}