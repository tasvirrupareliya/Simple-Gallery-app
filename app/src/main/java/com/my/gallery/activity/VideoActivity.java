package com.my.gallery.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.my.gallery.R;
import com.my.gallery.adapter.PhotosAdapter;
import com.my.gallery.adapter.VideoAdapter;
import com.my.gallery.model.Modellist;
import com.my.gallery.model.VideoList;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends Fragment {

    RecyclerView recyclerView;
    List<VideoList> videolists;
    VideoAdapter videoAdapter;
    Cursor cursor;
    Uri uri;
    int column_index_data;
    String PathOfImage = null;

    public VideoActivity() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_video, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.videos_recyclerview);
        videolists = new ArrayList<>();

        uri = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Video.VideoColumns.DATA};
        cursor = getContext().getApplicationContext().getContentResolver().query(uri, projection, null,
                null, null);

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);

        while (cursor.moveToNext()) {
            PathOfImage = cursor.getString(column_index_data);

            videolists.add(new VideoList(PathOfImage));
        }

        videoAdapter = new VideoAdapter(getContext(), videolists);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(videoAdapter);

    }
}