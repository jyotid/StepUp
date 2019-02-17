package com.womandroid.stepup.data;

import java.util.ArrayList;
import java.util.List;

public class CategoryListDataModel {

    public List<CategoryDataModel> categoryData = new ArrayList<>();

    public static class CategoryDataModel{
        public final String name;
        public final String id;
        public final int image;

        public CategoryDataModel(String name, String id, int image) {
            this.name = name;
            this.id=id;
            this.image = image;
        }
    }



}
