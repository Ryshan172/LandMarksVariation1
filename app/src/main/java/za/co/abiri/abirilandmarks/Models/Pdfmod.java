package za.co.abiri.abirilandmarks.Models;

public class Pdfmod {

    private String filepicked;
    private String filePickedName;
    private String userIdMain;
    private String PdfPostKey;
    private String filePickedType;

    public Pdfmod(String filepicked, String filePickedName, String userIdMain, String filePickedType) {
        this.filepicked = filepicked;
        this.filePickedName = filePickedName;
        this.userIdMain = userIdMain;
        this.filePickedType = filePickedType;
    }

    // No argument constructor
    public Pdfmod() {

    }

    public String getFilepicked() {
        return filepicked;
    }

    public void setFilepicked(String filepicked) {
        this.filepicked = filepicked;
    }

    public String getFilePickedName() {
        return filePickedName;
    }

    public void setFilePickedName(String filePickedName) {
        this.filePickedName = filePickedName;
    }

    public String getUserIdMain() {
        return userIdMain;
    }

    public void setUserIdMain(String userIdMain) {
        this.userIdMain = userIdMain;
    }


    // Post Key
    public String getPdfPostKey() {
        return PdfPostKey;
    }

    public void setPdfPostKey(String pdfPostKey) {
        PdfPostKey = pdfPostKey;
    }

    public String getFilePickedType() {
        return filePickedType;
    }

    public void setFilePickedType(String filePickedType) {
        this.filePickedType = filePickedType;
    }
}
