package za.co.abiri.abirilandmarks.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import za.co.abiri.abirilandmarks.Activities.TreeDetailActivity;
import za.co.abiri.abirilandmarks.Models.Tree;
import za.co.abiri.abirilandmarks.R;

public class TreeAdapter extends RecyclerView.Adapter<TreeAdapter.MyViewHolderb> {

    Context mContext;
    List<Tree> mData;

    // Constructors
    public TreeAdapter(Context mContext, List<Tree> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public TreeAdapter.MyViewHolderb onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Layout Inflater
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_tree_item,parent,false);
        return new MyViewHolderb(row);
    }

    @Override
    public void onBindViewHolder(@NonNull TreeAdapter.MyViewHolderb holder, int position) {
        //Retrieve Data Family Name
        holder.txtvTitle.setText(mData.get(position).getFamilyName());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolderb extends RecyclerView.ViewHolder{

        TextView txtvTitle;
        ImageView imgTreeLogo;

        public MyViewHolderb(@NonNull View itemView) {
            super(itemView);

            // Items from row_tree_item
            txtvTitle = itemView.findViewById(R.id.row_tree_title);
            imgTreeLogo = itemView.findViewById(R.id.row_tree_image);

            // Click for Family Tree details
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent treeDetails = new Intent(mContext, TreeDetailActivity.class);
                    int position = getAdapterPosition();

                    // Retrieving data
                    treeDetails.putExtra("familyName",mData.get(position).getFamilyName());
                    treeDetails.putExtra("familyOrigin",mData.get(position).getFamilyOrigin());
                    treeDetails.putExtra("familyTotem",mData.get(position).getFamilyTotem());
                    treeDetails.putExtra("familyCulture",mData.get(position).getFamilyCulture());
                    treeDetails.putExtra("familyMembers",mData.get(position).getFamilyMembers());
                    treeDetails.putExtra("treePostKey",mData.get(position).getTreePostKey());
                    treeDetails.putExtra("uName",mData.get(position).getuName());

                    long timestamp = (long) mData.get(position).gettStamp();
                    treeDetails.putExtra("tStamp",timestamp);
                    mContext.startActivity(treeDetails);



                }
            });


        }
    }
}
