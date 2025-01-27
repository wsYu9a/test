package com.martian.libsupport.bannerView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
public class CustomViewPager extends ViewPager {

    /* renamed from: a */
    private final ArrayList<Integer> f10549a;

    /* renamed from: b */
    private final SparseArray<Integer> f10550b;

    public CustomViewPager(Context context) {
        super(context);
        this.f10549a = new ArrayList<>();
        this.f10550b = new SparseArray<>();
        b();
    }

    private int a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[0] + (view.getWidth() / 2);
    }

    private void b() {
        setClipToPadding(false);
        setOverScrollMode(2);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    protected int getChildDrawingOrder(int childCount, int n) {
        if (n == 0 || this.f10550b.size() != childCount) {
            this.f10549a.clear();
            this.f10550b.clear();
            int a2 = a(this);
            for (int i2 = 0; i2 < childCount; i2++) {
                int abs = Math.abs(a2 - a(getChildAt(i2)));
                if (this.f10550b.get(abs) != null) {
                    abs++;
                }
                this.f10549a.add(Integer.valueOf(abs));
                this.f10550b.append(abs, Integer.valueOf(i2));
            }
            Collections.sort(this.f10549a);
        }
        return this.f10550b.get(this.f10549a.get((childCount - 1) - n).intValue()).intValue();
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f10549a = new ArrayList<>();
        this.f10550b = new SparseArray<>();
        b();
    }
}
