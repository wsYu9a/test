package com.wbl.ad.yzz.wigdet;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class g extends RecyclerView.ItemDecoration {

    /* renamed from: e */
    public static final int[] f34426e = {R.attr.listDivider};

    /* renamed from: b */
    public Drawable f34428b;

    /* renamed from: c */
    public int f34429c;

    /* renamed from: a */
    public boolean f34427a = true;

    /* renamed from: d */
    public final Rect f34430d = new Rect();

    public g(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f34426e);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.f34428b = drawable;
        if (drawable == null) {
            Log.w("TopDividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        a(i2);
    }

    public void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8472, this, Integer.valueOf(i2));
    }

    public final void a(Canvas canvas, RecyclerView recyclerView) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8471, this, canvas, recyclerView);
    }

    public void a(Drawable drawable) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8466, this, drawable);
    }

    public final void b(Canvas canvas, RecyclerView recyclerView) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8465, this, canvas, recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8468, this, rect, view, recyclerView, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8467, this, canvas, recyclerView, state);
    }
}
