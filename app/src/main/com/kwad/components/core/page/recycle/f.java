package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.utils.au;

/* loaded from: classes3.dex */
public final class f {
    final RecyclerView Sd;
    final RecyclerView.LayoutManager Se;

    private f(RecyclerView recyclerView) {
        this.Sd = recyclerView;
        this.Se = recyclerView.getLayoutManager();
    }

    private View a(int i10, int i11, boolean z10, boolean z11) {
        OrientationHelper createVerticalHelper = this.Se.canScrollVertically() ? OrientationHelper.createVerticalHelper(this.Se) : OrientationHelper.createHorizontalHelper(this.Se);
        int startAfterPadding = createVerticalHelper.getStartAfterPadding();
        int endAfterPadding = createVerticalHelper.getEndAfterPadding();
        int i12 = i11 > i10 ? 1 : -1;
        while (i10 != i11) {
            View childAt = this.Se.getChildAt(i10);
            int decoratedStart = createVerticalHelper.getDecoratedStart(childAt);
            int decoratedEnd = createVerticalHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                return childAt;
            }
            i10 += i12;
        }
        return null;
    }

    public static f b(RecyclerView recyclerView) {
        au.checkNotNull(recyclerView);
        return new f(recyclerView);
    }

    public final int findFirstVisibleItemPosition() {
        View a10 = a(0, this.Se.getChildCount(), false, true);
        if (a10 == null) {
            return -1;
        }
        return this.Sd.getChildAdapterPosition(a10);
    }

    public final int findLastVisibleItemPosition() {
        View a10 = a(this.Se.getChildCount() - 1, -1, false, true);
        if (a10 == null) {
            return -1;
        }
        return this.Sd.getChildAdapterPosition(a10);
    }
}
