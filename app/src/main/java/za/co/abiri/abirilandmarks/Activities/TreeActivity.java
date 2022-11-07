package za.co.abiri.abirilandmarks.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import za.co.abiri.abirilandmarks.Models.Tree;
import za.co.abiri.abirilandmarks.R;

public class TreeActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser currentUser;

    Button backTreeBtn;
    ImageView treeIconView,treeAddView;
    TextView treeNameTxt, treeOriginTxt, treeTotemTxt, treeCultureTxt, treeMembersTxt;
    ProgressBar treeProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);

        //Init
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        //Return to home page
        backTreeBtn = findViewById(R.id.treeBackBtn);
        backTreeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Home.class);
                startActivity(i);
            }
        });

        // Referencing items
        treeIconView = findViewById(R.id.treeIcon);
        treeAddView = findViewById(R.id.treeAddPost);
        treeNameTxt = findViewById(R.id.treeName);
        treeOriginTxt = findViewById(R.id.treeOrigin);
        treeTotemTxt = findViewById(R.id.treeTotem);
        treeCultureTxt = findViewById(R.id.treeCulture);
        treeMembersTxt = findViewById(R.id.treeMembers);
        treeProgress = findViewById(R.id.tree_progressBar);

        treeAddView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                treeAddView.setVisibility(View.INVISIBLE);
                treeProgress.setVisibility(View.VISIBLE);

                // Input fields check
                if(!treeNameTxt.getText().toString().isEmpty()
                && !treeOriginTxt.getText().toString().isEmpty()
                && !treeTotemTxt.getText().toString().isEmpty()
                && !treeCultureTxt.getText().toString().isEmpty()
                && !treeMembersTxt.getText().toString().isEmpty()){

                    // Create Post Object

                    Tree tree = new Tree(treeNameTxt.getText().toString(),
                            treeOriginTxt.getText().toString(),
                            treeTotemTxt.getText().toString(),
                            treeCultureTxt.getText().toString(),
                            treeMembersTxt.getText().toString(),
                            currentUser.getUid(),
                            currentUser.getDisplayName());

                    addTree(tree);



                }
                else {
                    showMessage("Please complete all fields and add an image");
                    treeAddView.setVisibility(View.VISIBLE);
                    treeProgress.setVisibility(View.INVISIBLE);
                }



            }
        });


    }

    private void addTree(Tree tree) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myAppRefb = database.getReference("Trees").push();

        //Obtain Post ID and Update Post Key
        String key = myAppRefb.getKey();
        tree.setTreePostKey(key);

        //Add Family Tree Post to Firebase Database
        myAppRefb.setValue(tree).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

                showMessage("Family Tree Added Successfully");
                treeProgress.setVisibility(View.INVISIBLE);
                treeAddView.setVisibility(View.VISIBLE);

                Intent Home = new Intent(getApplicationContext(),Home.class);
                startActivity(Home);


            }
        });

    }

    private void showMessage(String message) {

        Toast.makeText(TreeActivity.this,message,Toast.LENGTH_LONG).show();

    }
}