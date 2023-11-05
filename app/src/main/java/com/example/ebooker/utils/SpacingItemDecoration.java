package com.example.ebooker.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpacingItemDecoration extends RecyclerView.ItemDecoration {
    int verticalSpaceHeight;
    int horizontalSpaceHeight;

    public SpacingItemDecoration(int verticalSpaceHeight, int horizontalSpaceHeight) {
        this.verticalSpaceHeight = verticalSpaceHeight;
        this.horizontalSpaceHeight = horizontalSpaceHeight;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.bottom = verticalSpaceHeight;
        outRect.right = horizontalSpaceHeight;
    }
}
