package com.example.motionlayout;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Activity> mActivityData;

    public ActivityAdapter(MainActivity context, ArrayList<Activity> mActivityList) {
        this.mContext = context;
        this.mActivityData = mActivityList;
    }

    @NonNull
    @Override
    public ActivityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.activity_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityAdapter.ViewHolder holder, int position) {
        Activity currentActivity = mActivityData.get(position);

        holder.bindTo(currentActivity);
    }

    @Override
    public int getItemCount() {
        return mActivityData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleText;
        private TextView mDescriptionText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitleText = itemView.findViewById(R.id.title);
            mDescriptionText = itemView.findViewById(R.id.description);

            itemView.setOnClickListener(this);
        }

        public void bindTo(Activity currentActivity) {
            mTitleText.setText(currentActivity.getTitle());
        }

        @Override
        public void onClick(View v) {

        }
    }
}
