package za.co.abiri.abirilandmarks.Models;

import com.google.firebase.database.ServerValue;

public class Comment {

    private String content,uid,uimg,uname;
    private Object timestamp;

    //Generated Constructors
    public Comment() {

    }

    public Comment(String content, String uid, String uname) {
        this.content = content;
        this.uid = uid;
        //this.uimg = uimg;
        this.uname = uname;
        this.timestamp = ServerValue.TIMESTAMP;

    }


    public Comment(String content, String uid, String uname, Object timestamp) {
        this.content = content;
        this.uid = uid;
        //this.uimg = uimg;
        this.uname = uname;
        this.timestamp = timestamp;
    }

    //Getters and Setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    /*
    public String getUimg() {
        return uimg;
    }

    public void setUimg(String uimg) {
        this.uimg = uimg;
    }

     */

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Object getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Object timestamp) {
        this.timestamp = timestamp;
    }


}
