package com.derahh.myvolleyjsonparsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Model> listData;

    public Adapter(Context context, ArrayList<Model> listData) {
        this.mContext = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model = listData.get(position);

        String imageUrl = model.getImageUrl();
        String creatorName = model.getCreator();
        int likeCount = model.getLikes();

        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.imageView);
        holder.tvCreator.setText(creatorName);
        holder.tvLikes.setText("Likes: "+likeCount);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvCreator;
        TextView tvLikes;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            tvCreator = itemView.findViewById(R.id.tv_creator);
            tvLikes = itemView.findViewById(R.id.tv_downloads);
        }
    }
}
