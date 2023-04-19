package com.example.Endecryptmessanger;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdminAdapter  extends RecyclerView.Adapter<AdminAdapter.ExampleViewHolder>  {

    private ArrayList<AdminItem> mExampleList;
    private OnItemClickListener mListener;
    

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView mItemName;
        public TextView mItemStatus;
         public TextView mItemGender;
        public TextView mItemAdmin;



        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            mItemName=itemView.findViewById(R.id.item_name);
            mItemStatus =itemView.findViewById(R.id.item_status);
            mItemGender=itemView.findViewById(R.id.item_gender);
            mItemAdmin=itemView.findViewById(R.id.item_admin);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public AdminAdapter(ArrayList<AdminItem> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public AdminAdapter.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        AdminAdapter.ExampleViewHolder evh = new AdminAdapter.ExampleViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        AdminItem currentItem = mExampleList.get(position);
        holder.mItemName.setText("Name: "+currentItem.getItemName());
        holder.mItemStatus.setText("Age: "+currentItem.getItemAge());
        holder.mItemGender.setText("Gender: "+currentItem.getItemGender());
        holder.mItemAdmin.setText("Admin: "+currentItem.getItemAdmin());
    }


    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

}
