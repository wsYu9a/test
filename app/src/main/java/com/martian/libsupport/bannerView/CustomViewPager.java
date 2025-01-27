package com.martian.libsupport.bannerView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
public class CustomViewPager extends ViewPager {

    /* renamed from: b */
    public final ArrayList<Integer> f12969b;

    /* renamed from: c */
    public final SparseIntArray f12970c;

    public CustomViewPager(Context context) {
        super(context);
        this.f12969b = new ArrayList<>();
        this.f12970c = new SparseIntArray();
        b();
    }

    public final int a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[0] + (view.getWidth() / 2);
    }

    public final void b() {
        setClipToPadding(false);
        setOverScrollMode(2);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        if (i11 == 0 || this.f12970c.size() != i10) {
            this.f12969b.clear();
            this.f12970c.clear();
            int a10 = a(this);
            for (int i12 = 0; i12 < i10; i12++) {
                int abs = Math.abs(a10 - a(getChildAt(i12))) + 1;
                this.f12969b.add(Integer.valueOf(abs));
                this.f12970c.append(abs, i12);
            }
            Collections.sort(this.f12969b);
        }
        return this.f12970c.get(this.f12969b.get((i10 - 1) - i11).intValue());
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12969b = new ArrayList<>();
        this.f12970c = new SparseIntArray();
        b();
    }
}
