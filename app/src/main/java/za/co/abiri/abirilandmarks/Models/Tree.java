package za.co.abiri.abirilandmarks.Models;

import com.google.firebase.database.ServerValue;

public class Tree {

    //Class for Family tree functionality
    private String TreePostKey;
    private String familyName;
    private String familyOrigin;
    private String familyTotem;
    private String familyCulture;
    private String familyMembers;
    private String userIds;
    private String uName;
    private Object tStamp;

    public Tree(String familyName, String familyOrigin, String familyTotem, String familyCulture, String familyMembers, String userIds, String uName) {
        //TreePostKey = treePostKey;
        this.familyName = familyName;
        this.familyOrigin = familyOrigin;
        this.familyTotem = familyTotem;
        this.familyCulture = familyCulture;
        this.familyMembers = familyMembers;
        this.userIds = userIds;
        this.uName = uName;
        this.tStamp = ServerValue.TIMESTAMP;
    }


    public Tree() {

    }



    //Getters and Setters


    public String getTreePostKey() {
        return TreePostKey;
    }

    public void setTreePostKey(String treePostKey) {
        TreePostKey = treePostKey;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFamilyOrigin() {
        return familyOrigin;
    }

    public void setFamilyOrigin(String familyOrigin) {
        this.familyOrigin = familyOrigin;
    }

    public String getFamilyTotem() {
        return familyTotem;
    }

    public void setFamilyTotem(String familyTotem) {
        this.familyTotem = familyTotem;
    }

    public String getFamilyCulture() {
        return familyCulture;
    }

    public void setFamilyCulture(String familyCulture) {
        this.familyCulture = familyCulture;
    }

    public String getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(String familyMembers) {
        this.familyMembers = familyMembers;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Object gettStamp() {
        return tStamp;
    }

    public void settStamp(Object tStamp) {
        this.tStamp = tStamp;
    }
    
}
