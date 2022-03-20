package com.example.recyclerviewtextimage;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DataItem> localDataSet;
    private TextView topTextview;

    public CustomAdapter(Context contextparent, ArrayList<DataItem> items) {
        context = contextparent;
        localDataSet = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_custom_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "you clicked item ..." + viewHolder.getAdapterPosition();


                Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
                topTextview = ((Activity) context).findViewById(R.id.txtMsg);
                topTextview.setText(s);

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.getTextView().setText(localDataSet.get(position).getItemDescription());
        viewHolder.getImgView().setImageResource(localDataSet.get(position).getThumbnailImage());


    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView textView;
        private final ImageView imgView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtLable);
            imgView = itemView.findViewById(R.id.imgIcon);

        }


        public TextView getTextView() {


            return textView;
        }

        public ImageView getImgView() {
            return imgView;
        }
    }
}
