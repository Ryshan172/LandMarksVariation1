package za.co.abiri.abirilandmarks.Activities.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import za.co.abiri.abirilandmarks.Adapters.TreeAdapter;
import za.co.abiri.abirilandmarks.Models.Tree;
import za.co.abiri.abirilandmarks.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileBFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileBFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Views and referencing adapter and recyclerview
    RecyclerView treeRecyclerView;
    TreeAdapter treeAdapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    List<Tree> treeList;

    public ProfileBFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileBFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileBFragment newInstance(String param1, String param2) {
        ProfileBFragment fragment = new ProfileBFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_profile_b, container, false);

        treeRecyclerView = fragmentView.findViewById(R.id.treeRecView);
        treeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        treeRecyclerView.setHasFixedSize(true);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Trees");

        return fragmentView;
    }

    //OnStart added in
    @Override
    public void onStart() {
        super.onStart();

        // Retrieve Tree data from firebase
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                treeList = new ArrayList<>();
                for (DataSnapshot treesnap: dataSnapshot.getChildren()) {

                    Tree tree = treesnap.getValue(Tree.class);
                    treeList.add(tree);

                }

                treeAdapter = new TreeAdapter(getActivity(),treeList);
                treeRecyclerView.setAdapter(treeAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}