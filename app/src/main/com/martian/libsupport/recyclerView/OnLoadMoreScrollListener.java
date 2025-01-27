package com.martian.libsupport.recyclerView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public abstract class OnLoadMoreScrollListener extends RecyclerView.OnScrollListener {
    public boolean a(RecyclerView recyclerView) {
        int childLayoutPosition = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(recyclerView.getChildCount() - 1));
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        return layoutManager != null && layoutManager.getItemCount() - 1 == childLayoutPosition;
    }

    public abstract void b(RecyclerView recyclerView);

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null && layoutManager.getChildCount() > 0 && i10 == 0 && a(recyclerView)) {
            b(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NonNull RecyclerView recyclerView, int i10, int i11) {
    }
}
