package com.my.gallery.model;

import android.graphics.Bitmap;

import java.io.File;

public class Modellist {

    String Photos;

    public Modellist(String photos) {
        Photos = photos;
    }

    public String getPhotos() {
        return Photos;
    }

    public void setPhotos(String photos) {
        Photos = photos;
    }
}
