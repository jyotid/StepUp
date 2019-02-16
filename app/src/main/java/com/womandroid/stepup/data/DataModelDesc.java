package com.womandroid.stepup.data;

public class DataModelDesc {

    String name, professionalTitle, location, categories;
    int image;

    public DataModelDesc(String name, int image, String professionalTitle, String location, String categories) {
        this.name = name;
        this.image=image;
        this.professionalTitle = professionalTitle;
        this.location = location;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getProfessionalTitle() {
        return name;
    }

    public String getLocation() {
        return name;
    }

    public String getCategories() {
        return name;
    }
}
