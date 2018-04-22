package model;



public class CategoryDetail {

    private String categoryDetailName;
    private int categoryDetailImageResourceId;
    private String categoryDetailAddress;

    public CategoryDetail(String categoryDetailName, int categoryDetailImageResourceId, String categoryDetailAddress) {
        this.categoryDetailName = categoryDetailName;
        this.categoryDetailImageResourceId = categoryDetailImageResourceId;
        this.categoryDetailAddress = categoryDetailAddress;
    }

    public CategoryDetail() {
    }

    public String getCategoryDetailName() {
        return categoryDetailName;
    }

    public void setCategoryDetailName(String categoryDetailName) {
        this.categoryDetailName = categoryDetailName;
    }

    public int getCategoryDetailImageResourceId() {
        return categoryDetailImageResourceId;
    }

    public void setCategoryDetailImageResourceId(int categoryDetailImageResourceId) {
        this.categoryDetailImageResourceId = categoryDetailImageResourceId;
    }

    public String getCategoryDetailAddress() {
        return categoryDetailAddress;
    }

    public void setCategoryDetailAddress(String categoryDetailAddress) {
        this.categoryDetailAddress = categoryDetailAddress;
    }
}
