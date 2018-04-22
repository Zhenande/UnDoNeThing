package model;



public class Category {

    private String CategoryName;
    private int CategoryImageResourceId;

    public Category(String categoryName, int categoryImageResourceId) {
        CategoryName = categoryName;
        CategoryImageResourceId = categoryImageResourceId;
    }

    public Category() {
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public int getCategoryImageResourceId() {
        return CategoryImageResourceId;
    }

    public void setCategoryImageResourceId(int categoryImageResourceId) {
        CategoryImageResourceId = categoryImageResourceId;
    }


}
