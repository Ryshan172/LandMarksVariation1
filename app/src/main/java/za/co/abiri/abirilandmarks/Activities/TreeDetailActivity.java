package za.co.abiri.abirilandmarks.Activities;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import za.co.abiri.abirilandmarks.R;

public class TreeDetailActivity extends AppCompatActivity {

    ImageView treeIconView, treeDetailUserImg;
    TextView txtTreeName, txtTreeUser,txtTreeOrigin, txtTreeTotem, txtTreeCulture, txtTreeMembers, txtTreeby;

    String TreePostKey;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_detail);

        //Status bar transparent

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getSupportActionBar().hide();


        treeIconView = findViewById(R.id.tree_detail_view);
        treeDetailUserImg = findViewById(R.id.tree_detail_userimg);

        txtTreeby = findViewById(R.id.tree_by_txt);
        txtTreeName = findViewById(R.id.tree_detail_name);
        txtTreeOrigin = findViewById(R.id.tree_detail_origin);
        txtTreeUser = findViewById(R.id.tree_detail_user);
        txtTreeTotem = findViewById(R.id.tree_detail_totem);
        txtTreeCulture = findViewById(R.id.tree_detail_culture);
        txtTreeMembers = findViewById(R.id.tree_detail_members);


        //firebase
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();

        //Binding all data
        //Need to send post data to this activity from TreeAdapter
        String treeUserName = getIntent().getExtras().getString("uName");
        txtTreeUser.setText(treeUserName);

        String treeName = getIntent().getExtras().getString("familyName");
        txtTreeName.setText(treeName);

        String treeOrigin = getIntent().getExtras().getString("familyOrigin");
        txtTreeOrigin.setText(treeOrigin);

        String treeTotem = getIntent().getExtras().getString("familyTotem");
        txtTreeTotem.setText(treeTotem);

        String treeCulture = getIntent().getExtras().getString("familyCulture");
        txtTreeCulture.setText(treeCulture);

        String treeMembers = getIntent().getExtras().getString("familyMembers");
        txtTreeMembers.setText(treeMembers);

        TreePostKey = getIntent().getExtras().getString("treePostKey");






    }
}