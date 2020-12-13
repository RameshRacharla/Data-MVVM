package com.rameshracharla.data_mvvm.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.rameshracharla.data_mvvm.R;
import com.squareup.picasso.Picasso;

public class DataList {
    private String id, email, first_name, last_name, avatar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    @BindingAdapter("android:src")
    public static void setImageResource(ImageView imageView, String avatar) {
        Picasso.get()
                .load(avatar)
                .placeholder(R.drawable.ic_image)
                .into(imageView);
    }
}
