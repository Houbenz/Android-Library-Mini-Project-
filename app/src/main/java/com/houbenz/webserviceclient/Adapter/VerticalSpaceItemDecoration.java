package com.houbenz.webserviceclient.Adapter;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {


    private  int verticalSpaceHeight;

    public VerticalSpaceItemDecoration(int verticalSpaceHeight){
        this.verticalSpaceHeight=verticalSpaceHeight;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.bottom=verticalSpaceHeight;
    }
}
