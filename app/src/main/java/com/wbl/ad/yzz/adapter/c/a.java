package com.wbl.ad.yzz.adapter.c;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import f.b.a.e;

/* loaded from: classes5.dex */
public abstract class a extends RecyclerView.OnScrollListener {
    public abstract void a(int i2, int i3);

    public abstract void a(@e int[] iArr);

    public final int[] a(LinearLayoutManager linearLayoutManager) {
        return (int[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16029, this, linearLayoutManager);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16032, this, recyclerView, Integer.valueOf(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16031, this, recyclerView, Integer.valueOf(i2), Integer.valueOf(i3));
    }
}
