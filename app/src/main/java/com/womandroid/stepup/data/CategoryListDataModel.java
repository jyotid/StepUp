package com.womandroid.stepup.data;

import java.util.ArrayList;
import java.util.List;

public class CategoryListDataModel {

    public List<CategoryDataModel> categoryData = new ArrayList<>();

    public static class CategoryDataModel{
        public final String name;
        public final String id;

        public CategoryDataModel(String name, String id) {
            this.name = name;
            this.id=id;
        }
    }



}
