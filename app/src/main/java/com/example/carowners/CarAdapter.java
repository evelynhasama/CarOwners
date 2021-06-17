package com.example.carowners;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    private ArrayList<Owner> owners;

    ItemClicked activity;

    public interface ItemClicked {
        void ItemClicked(int index);
    }

    public CarAdapter(Context context, ArrayList<Owner> list) {
        owners = list;
        activity = (ItemClicked) context;

    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivMake;
        TextView tvModel, tvOwner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivMake = itemView.findViewById(R.id.ivMake);
            tvModel = itemView.findViewById(R.id.tvModel);
            tvOwner = itemView.findViewById(R.id.tvOwner);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    activity.ItemClicked(owners.indexOf((Owner) v.getTag()));

                }
            });
        }
    }
    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {

        holder.itemView.setTag(owners.get(position));

        holder.tvOwner.setText(owners.get(position).getOwner());
        holder.tvModel.setText(owners.get(position).getModel());

        if (owners.get(position).getMake().equals("Volkswagen")){
            holder.ivMake.setImageResource(R.drawable.volkswagen);
        } else if (owners.get(position).getMake().equals("Mercedes")){
            holder.ivMake.setImageResource(R.drawable.mercedes);
        } else {
            holder.ivMake.setImageResource(R.drawable.nissan);
        }
    }

    @Override
    public int getItemCount() {
        return owners.size();
    }
}
