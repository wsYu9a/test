package com.martian.mibook.mvvm.widget;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.mibook.mvvm.widget.SmartScrollLayoutManager;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0011\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\u0010\u001a\b\u0018\u00010\u000fR\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/martian/mibook/mvvm/widget/SmartScrollLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/content/Context;", f.X, "", "orientation", "", "reverseLayout", "<init>", "(Landroid/content/Context;IZ)V", "Landroidx/recyclerview/widget/RecyclerView;", "view", "", "onAttachedToWindow", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "recycler", "onDetachedFromWindow", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$Recycler;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "targetPosition", "smoothScrollToPosition", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;I)V", "m", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "b", "I", "scrollStep", "c", "Landroidx/recyclerview/widget/RecyclerView;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class SmartScrollLayoutManager extends LinearLayoutManager {

    /* renamed from: b, reason: from kotlin metadata */
    public final int scrollStep;

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public RecyclerView recyclerView;

    public /* synthetic */ SmartScrollLayoutManager(Context context, int i10, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? 1 : i10, (i11 & 4) != 0 ? false : z10);
    }

    public static final void l(SmartScrollLayoutManager this$0, RecyclerView recyclerView, int i10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
        this$0.m(recyclerView, i10);
    }

    public final void m(RecyclerView recyclerView, int targetPosition) {
        SmartScrollLayoutManager$startSmoothScrollToTop$smoothScroller$1 smartScrollLayoutManager$startSmoothScrollToTop$smoothScroller$1 = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.martian.mibook.mvvm.widget.SmartScrollLayoutManager$startSmoothScrollToTop$smoothScroller$1
            public SmartScrollLayoutManager$startSmoothScrollToTop$smoothScroller$1(Context context) {
                super(context);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int getVerticalSnapPreference() {
                return -1;
            }
        };
        smartScrollLayoutManager$startSmoothScrollToTop$smoothScroller$1.setTargetPosition(targetPosition);
        startSmoothScroll(smartScrollLayoutManager$startSmoothScrollToTop$smoothScroller$1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(@l RecyclerView view) {
        super.onAttachedToWindow(view);
        this.recyclerView = view;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(@l RecyclerView view, @l RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(view, recycler);
        this.recyclerView = null;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(@k RecyclerView recyclerView, @l RecyclerView.State state, int targetPosition) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int abs = Math.abs(targetPosition - findFirstVisibleItemPosition);
        int i10 = this.scrollStep;
        if (abs <= i10) {
            m(recyclerView, targetPosition);
        } else {
            recyclerView.scrollToPosition(targetPosition > findFirstVisibleItemPosition ? RangesKt.coerceAtLeast(targetPosition - i10, findFirstVisibleItemPosition) : RangesKt.coerceAtMost(i10 + targetPosition, findFirstVisibleItemPosition));
            recyclerView.post(new Runnable() { // from class: rd.e

                /* renamed from: c */
                public final /* synthetic */ RecyclerView f30404c;

                /* renamed from: d */
                public final /* synthetic */ int f30405d;

                public /* synthetic */ e(RecyclerView recyclerView2, int targetPosition2) {
                    recyclerView = recyclerView2;
                    targetPosition = targetPosition2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    SmartScrollLayoutManager.l(SmartScrollLayoutManager.this, recyclerView, targetPosition);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartScrollLayoutManager(@k Context context, int i10, boolean z10) {
        super(context, i10, z10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.scrollStep = 20;
    }
}
