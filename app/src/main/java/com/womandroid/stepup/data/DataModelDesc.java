package com.womandroid.stepup.data;

public class DataModelDesc {

    public String name, professionalTitle, location, categories;
    public int image;

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
        return professionalTitle;
    }

    public String getLocation() {
        return location;
    }

    public String getCategories() {
        return categories;
    }
}
