package com.womandroid.stepup.categories;

import com.womandroid.stepup.data.CategoryListDataModel;
import com.womandroid.stepup.data.CategoryListDataModel.CategoryDataModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyotidubey on 16/02/19.
 */

public class CategoryPresenter {

  public CategoryActivity view;

  public void onViewAttached(CategoryActivity view){
    this.view = view;
  }

  public void getCategoryData(){
    List<CategoryDataModel> data =  new ArrayList<>();
    data.add(new CategoryListDataModel.CategoryDataModel("Cater","1"));
    data.add(new CategoryListDataModel.CategoryDataModel("Cater","1"));
    data.add(new CategoryListDataModel.CategoryDataModel("Cater","1"));
    data.add(new CategoryListDataModel.CategoryDataModel("Cater","1"));

    view.onCategoryDataReceived(data);
  }

}
