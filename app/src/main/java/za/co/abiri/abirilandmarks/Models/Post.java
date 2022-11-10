package za.co.abiri.abirilandmarks.Models;

import com.google.firebase.database.ServerValue;

public class Post {

    //Class for post functionality
    private String PostKey;
    private String title;
    private String description;
    private String coordinates;
    private String picture;
    private String userId;
    //private String userPhoto;
    private Object timeStamp;
    private String userName;

    // Additional fields
    private String lifeDate;
    private String burialDate;
    private String personDetails;


    //Constructors
    public Post(String title, String description, String coordinates, String picture, String userId, String userName,
                String lifeDate, String burialDate, String personDetails) {

        this.title = title;
        this.description = description;
        this.coordinates = coordinates;
        this.picture = picture;
        this.userId = userId;
        //this.userPhoto = userPhoto;
        this.timeStamp = ServerValue.TIMESTAMP;
        this.userName = userName;

        // Additional fields
        this.lifeDate = lifeDate;
        this.burialDate = burialDate;
        this.personDetails = personDetails;

    }

    public Post() {

    }

    //PostKey Getter and Setter
    public String getPostKey() {
        return PostKey;
    }

    public void setPostKey(String postKey) {
        PostKey = postKey;
    }
    //PostKey

    //Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getPicture() {
        return picture;
    }

    public String getUserId() {
        return userId;
    }

    /*
    public String getUserPhoto() {
        return userPhoto;
    }

     */

    public Object getTimeStamp() {
        return timeStamp;
    }

    public String getUserName() {
        return userName;
    }

    //SETTERS
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /*
    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    */

    // Additional field getters and setters
    public void setTimeStamp(Object timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLifeDate() {
        return lifeDate;
    }

    public void setLifeDate(String lifeDate) {
        this.lifeDate = lifeDate;
    }

    public String getBurialDate() {
        return burialDate;
    }

    public void setBurialDate(String burialDate) {
        this.burialDate = burialDate;
    }

    public String getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(String personDetails) {
        this.personDetails = personDetails;
    }
}
