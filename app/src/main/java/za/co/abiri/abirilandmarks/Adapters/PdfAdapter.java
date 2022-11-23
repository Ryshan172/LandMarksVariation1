package za.co.abiri.abirilandmarks.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import za.co.abiri.abirilandmarks.Models.Pdfmod;
import za.co.abiri.abirilandmarks.R;

public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.MyViewHolderC>{

    Context mContext;
    List<Pdfmod> mData;

    public PdfAdapter(Context mContext, List<Pdfmod> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolderC onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(mContext).inflate(R.layout.row_pdf_item,parent,false);
        return new MyViewHolderC(row);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderC holder, int position) {

        holder.txtFileName.setText(mData.get(position).getFilePickedName());
        holder.txtFileType.setText(mData.get(position).getFilePickedType());
        holder.txtFileUrl.setText(mData.get(position).getFilepicked());




    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolderC extends RecyclerView.ViewHolder {

        TextView txtFileName, txtFileType, txtFileUrl;
        ImageView imgPdfLogo;

        public MyViewHolderC(@NonNull View itemView) {
            super(itemView);

            txtFileName = itemView.findViewById(R.id.pdf_name);
            txtFileType = itemView.findViewById(R.id.pdf_type);
            txtFileUrl = itemView.findViewById(R.id.pdf_url);
            imgPdfLogo = itemView.findViewById(R.id.row_pdf_icon);

            // Open PDF url
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = txtFileUrl.getText().toString();
                    Intent urlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    mContext.startActivity(urlIntent);

                }
            });





        }
    }


}
