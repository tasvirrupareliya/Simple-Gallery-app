package com.my.gallery.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.my.gallery.R;
import com.my.gallery.activity.FullscreenVideoActivity;
import com.my.gallery.activity.FullscreenphotoActivity;
import com.my.gallery.model.VideoList;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<VideoList> videoLists;

    public VideoAdapter(Context context, List<VideoList> videoLists) {
        this.context = context;
        this.videoLists = videoLists;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.videomodel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Glide.with(context).load(videoLists.get(position).getVideos()).error(R.drawable.ic_launcher_background).into(((VideoAdapter.ViewHolder) holder).thumbnail);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullscreenVideoActivity.class);

                intent.putExtra("videolist", videoLists.get(position).getVideos());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoLists.size();
    }
}
