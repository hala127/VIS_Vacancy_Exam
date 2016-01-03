package com.ntg.androidadministration.androidquiz_halafathymohamed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hfathi on 12/19/2015.
 */
public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder> {

    ArrayList<Photo> items;

    public PhotosAdapter(Context context, ArrayList<Photo> items) {
        this.items = items;
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);

        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        holder.tv_photo_name.setText(items.get(0).getPhotoName());
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_photo;
        TextView tv_photo_name;
        ImageView btn_show_more;

        public PhotoViewHolder(View itemView) {
            super(itemView);

            iv_photo = (ImageView) itemView.findViewById(R.id.iv_photo);
            tv_photo_name = (TextView) itemView.findViewById(R.id.tv_photo_name);
            btn_show_more = (ImageView) itemView.findViewById(R.id.btn_show_more);
        }
    }
}
