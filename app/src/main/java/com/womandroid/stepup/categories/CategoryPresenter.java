package com.womandroid.stepup.categories;

import com.womandroid.stepup.R;
import com.womandroid.stepup.data.CategoryListDataModel;
import com.womandroid.stepup.data.CategoryListDataModel.CategoryDataModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyotidubey on 16/02/19.
 */

public class CategoryPresenter {

  public CategoriesActivity view;

  public void onViewAttached(CategoriesActivity view){
    this.view = view;
  }

  public void getCategoryData(){

    String jsonString = "{\n" +
        "\t\"categories\": [\n" +
        "\t\t{ \n" +
        "\t\t\t\"id\" : \"c0001\",\n" +
        "\t\t\t\"name\" : \"Education\"\n" +
        "\t\t},\n" +
        "\t\t{\n" +
        "\t\t\t\"id\" : \"c0002\",\n" +
        "\t\t\t\"name\" : \"Technology\"\n" +
        "\n" +
        "\t\t},\n" +
        "\t\t{\n" +
        "\t\t\t\"id\" : \"c0003\",\n" +
        "\t\t\t\"name\" : \"Sciences\"\n" +
        "\t\t},\n" +
        "\t\t{\n" +
        "\t\t\t\"id\" : \"c0004\",\n" +
        "\t\t\t\"name\" : \"Fashion\"\n" +
        "\t\t},\n" +
        "\t\t{\n" +
        "\t\t\t\"id\" : \"c0005\",\n" +
        "\t\t\t\"name\" : \"Healthcare\"\n" +
        "\t\t},\n" +
        "\t\t{\n" +
        "\t\t\t\"id\" : \"c0006\",\n" +
        "\t\t\t\"name\" : \"Entrepreneurship\"\n" +
        "\n" +
        "\t\t}\n" +
        "\t]\n" +
        "}";
    int imageArray[] = {R.drawable.ic_education, R.drawable.ic_technology, R.drawable.ic_sciences, R.drawable.ic_fashion, R.drawable.ic_healthcare, R.drawable.ic_entrepreneurship};
    List<CategoryDataModel> data =  new ArrayList<>();

    JSONObject jsonResult = null;
    try {
      jsonResult = new JSONObject(jsonString);
      JSONArray jsonArray = jsonResult.getJSONArray("categories");
      if(jsonArray != null) {
        for(int i = 0 ; i < jsonArray.length() ; i++) {
          JSONObject jsonObject = jsonArray.getJSONObject(i);
          data.add(new CategoryListDataModel.CategoryDataModel(jsonObject.getString("name"),(jsonObject.getString("id")), (imageArray[i])));
        }
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
    view.onCategoryDataReceived(data);
  }

}