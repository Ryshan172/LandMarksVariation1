package za.co.abiri.abirilandmarks.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import za.co.abiri.abirilandmarks.Models.Pdfmod;
import za.co.abiri.abirilandmarks.R;

public class PdfActivity extends AppCompatActivity {

    private final static int PReqCode = 2;
    private final static int REQUESCODE = 2;
    private Uri pickedImageUri = null;

    Button chooseBtn, fileUploadBtn;
    TextView txtFileName, txtFileType;
    ProgressBar pdfProgress;

    FirebaseAuth mAuth;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        txtFileName = findViewById(R.id.edit_file_name);
        chooseBtn = findViewById(R.id.btn_choose_pdf);
        fileUploadBtn = findViewById(R.id.btn_file_upload);

        txtFileType = findViewById(R.id.file_type_select);
        pdfProgress = findViewById(R.id.pdf_progressBar);

        // Where the name of the file should appear when chosen


        // Click to upload
        fileUploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fileUploadBtn.setVisibility(View.INVISIBLE);
                pdfProgress.setVisibility(View.VISIBLE);

                // Checking required inputs:
                if (!txtFileName.getText().toString().isEmpty()
                && !txtFileType.getText().toString().isEmpty()
                && pickedImageUri != null) {

                    // Firebase Storage
                    StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("landmark_files");
                    StorageReference imageFilePath = storageReference.child(pickedImageUri.getLastPathSegment());

                    imageFilePath.putFile(pickedImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            imageFilePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String fileDownloadLink = uri.toString();


                                    // Pdf Upload Object
                                    Pdfmod pdfmod = new Pdfmod(fileDownloadLink,
                                            txtFileName.getText().toString(),
                                            currentUser.getUid(),txtFileType.getText().toString());

                                    addpdfmod(pdfmod);


                                }

                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    //ERROR WHEN UPLOADING file
                                    showMessage(e.getMessage());

                                }
                            });



                        }
                    });
                    
                }
                else {
                    showMessage("Please complete add name and choose file");
                    fileUploadBtn.setVisibility(View.VISIBLE);
                    pdfProgress.setVisibility(View.INVISIBLE);

                }


            }
        });


        // Choose a file to upload
        chooseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkForPermission();


            }
        });

    }

    private void addpdfmod(Pdfmod pdfmod) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myAppRefC = database.getReference("Pdfs").push();

        //Obtain post ID and update Post Key
        String key = myAppRefC.getKey();
        pdfmod.setPdfPostKey(key);

        myAppRefC.setValue(pdfmod).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

                showMessage("Post added successfully");
                Intent Home = new Intent(getApplicationContext(),Home.class);
                startActivity(Home);

            }
        });

    }

    private void showMessage(String message) {

        Toast.makeText(PdfActivity.this,message,Toast.LENGTH_LONG).show();
    }

    private void checkForPermission() {

        //Cases
        if (ContextCompat.checkSelfPermission(PdfActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(PdfActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

                //Toast
                Toast.makeText(PdfActivity.this, "Please accept required permissions",Toast.LENGTH_SHORT).show();
            }
            else
            {
                ActivityCompat.requestPermissions(PdfActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PReqCode);
                //static int PReqCode
            }
        }
        else
            openFiles();

    }

    private void openFiles() {

        //open File intent and wait for user to pick image
        //code to open and access gallery on phone
        Intent filesIntent = new Intent(Intent.ACTION_GET_CONTENT);
        filesIntent.setType("application/pdf");
        startActivityForResult(filesIntent, REQUESCODE);
        //Check if deprecated API causes any issues

    }


    //Override method
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUESCODE && data != null) {

            //Image from gallery successfully picked by user
            //Reference needs to be saved to a Uri Variable
            pickedImageUri = data.getData();

            //Makes button invisible when file is chosen
            chooseBtn.setVisibility(View.INVISIBLE);



        }
    }



}