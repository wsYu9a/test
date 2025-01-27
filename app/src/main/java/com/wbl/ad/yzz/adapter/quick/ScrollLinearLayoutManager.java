package com.wbl.ad.yzz.adapter.quick;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import f.b.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0018\u00010\tR\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/wbl/ad/yzz/adapter/quick/ScrollLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "canScrollVertically", "()Z", "b", "", "a", "(Z)V", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "onLayoutChildren", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Z", "mCanVerticalScroll", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class ScrollLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: a, reason: from kotlin metadata */
    public boolean mCanVerticalScroll;

    public ScrollLinearLayoutManager(@e Context context) {
        super(context);
        this.mCanVerticalScroll = true;
    }

    public final void a(boolean b2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15545, this, Boolean.valueOf(b2));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15548, this, null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15547, this, recycler, state);
    }
}
