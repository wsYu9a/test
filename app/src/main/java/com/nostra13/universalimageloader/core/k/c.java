package com.nostra13.universalimageloader.core.k;

import android.widget.AbsListView;

/* loaded from: classes4.dex */
public class c implements AbsListView.OnScrollListener {

    /* renamed from: a */
    private com.nostra13.universalimageloader.core.d f16046a;

    /* renamed from: b */
    private final boolean f16047b;

    /* renamed from: c */
    private final boolean f16048c;

    /* renamed from: d */
    private final AbsListView.OnScrollListener f16049d;

    public c(com.nostra13.universalimageloader.core.d dVar, boolean z, boolean z2) {
        this(dVar, z, z2, null);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AbsListView.OnScrollListener onScrollListener = this.f16049d;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 == 0) {
            this.f16046a.M();
        } else if (i2 != 1) {
            if (i2 == 2 && this.f16048c) {
                this.f16046a.L();
            }
        } else if (this.f16047b) {
            this.f16046a.L();
        }
        AbsListView.OnScrollListener onScrollListener = this.f16049d;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i2);
        }
    }

    public c(com.nostra13.universalimageloader.core.d dVar, boolean z, boolean z2, AbsListView.OnScrollListener onScrollListener) {
        this.f16046a = dVar;
        this.f16047b = z;
        this.f16048c = z2;
        this.f16049d = onScrollListener;
    }
}
