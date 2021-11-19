package com.example.motionlayout;

import android.content.Context;

public class ActivityItem {
    private String name;
    private String description;
    private final int thumbnail;
    private Context context;

    ActivityItem(String name, String description, int thumbnail, Context context) {
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.context = context;
    }

    String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }

    int getThumbnail() {
        return thumbnail;
    }

    Context getContext() {
        return context;
    }
}
