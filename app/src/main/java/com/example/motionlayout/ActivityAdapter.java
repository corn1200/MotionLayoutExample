package com.example.motionlayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<ActivityItem> mActivityData;

    public ActivityAdapter(MainActivity context, ArrayList<ActivityItem> mActivityList) {
        this.mContext = context;
        this.mActivityData = mActivityList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.activity_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ActivityItem currentActivityItem = mActivityData.get(position);
        holder.bindTo(currentActivityItem);
    }

    @Override
    public int getItemCount() {
        return mActivityData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNameText;
        private TextView mDescriptionText;
        private ImageView mThumbnailImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mNameText = itemView.findViewById(R.id.name);
            mDescriptionText = itemView.findViewById(R.id.description);
            mThumbnailImage = itemView.findViewById(R.id.motionThumbnail);

            itemView.setOnClickListener(this);
        }

        public void bindTo(ActivityItem currentActivityItem) {
            mNameText.setText(currentActivityItem.getName());
            mDescriptionText.setText(currentActivityItem.getDescription());
            Glide.with(mContext).load(
                    currentActivityItem.getThumbnail()).into(mThumbnailImage);
        }

        @Override
        public void onClick(View v) {
            ActivityItem currentActivityItem = mActivityData.get(getAdapterPosition());
            Intent detailIntent = new Intent(currentActivityItem.getContext(),
                    DetailMotionActivity.class);
            detailIntent.putExtra("name", currentActivityItem.getName());
            mContext.startActivity(detailIntent);
        }
    }

}
