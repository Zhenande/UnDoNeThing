package model;

/**
 * Created by ABC on 3/6/2018.
 */

public class CardModel {

    private String ResName;
    private int ResImageResourceId;
    private String Address;

    public CardModel(String resName, int resImageResourceId, String address) {
        ResName = resName;
        ResImageResourceId = resImageResourceId;
        Address = address;
    }

    public CardModel() {
    }

    public String getResName() {
        return ResName;
    }

    public void setResName(String resName) {
        ResName = resName;
    }

    public int getResImageResourceId() {
        return ResImageResourceId;
    }

    public void setResImageResourceId(int resImageResourceId) {
        ResImageResourceId = resImageResourceId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
    

}
