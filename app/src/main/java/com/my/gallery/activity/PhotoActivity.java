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
import com.my.gallery.model.Modellist;

import java.util.ArrayList;
import java.util.List;

public class PhotoActivity extends Fragment {

    RecyclerView recyclerView;
    List<Modellist> list;
    Cursor cursor;
    Uri uri;
    PhotosAdapter recyclerAdapter;
    int column_index_data;
    String PathOfImage = null;

    public PhotoActivity() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_photo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.photos_recyclerview);
        list = new ArrayList<>();

        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.MediaColumns.DATA};
        cursor = getContext().getApplicationContext().getContentResolver().query(uri, projection, null,
                null, null);

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);

        while (cursor.moveToNext()) {
            PathOfImage = cursor.getString(column_index_data);

            list.add(new Modellist(PathOfImage));
        }

        recyclerAdapter = new PhotosAdapter(list, getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(recyclerAdapter);
    }
}