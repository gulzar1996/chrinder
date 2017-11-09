package com.github.gulzar1996.tinderdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by gulza on 11/9/2017.
 */

public class TinderAdapter extends ArrayAdapter<User> {
    public TinderAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        ViewHolder holder;

        if (contentView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            contentView = inflater.inflate(R.layout.fragment_pic, parent, false);
            holder = new ViewHolder(contentView);
            contentView.setTag(holder);
        } else {
            holder = (ViewHolder) contentView.getTag();
        }

        User user = getItem(position);

        holder.name_age.setText(user.name+", "+user.age);
        holder.hobby.setText(user.hobby);
        Glide.with(getContext()).load(user.url).into(holder.dp);

        return contentView;
    }
    private static class ViewHolder {
        public TextView name_age;
        public TextView hobby;
        public ImageView dp;

        public ViewHolder(View view) {
            this.dp =  view.findViewById(R.id.userImage);
            this.name_age =  view.findViewById(R.id.nameage);
            this.hobby =  view.findViewById(R.id.hobby);
        }
    }

}
