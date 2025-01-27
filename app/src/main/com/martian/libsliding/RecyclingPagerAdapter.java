package com.martian.libsliding;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.Stack;

/* loaded from: classes3.dex */
public abstract class RecyclingPagerAdapter<T> extends PagerAdapter {

    /* renamed from: a */
    public final Stack<View> f12914a = new Stack<>();

    public abstract T a(int i10);

    public abstract View b(View view, int i10);

    public final View c(int i10) {
        return this.f12914a.isEmpty() ? b(null, i10) : b(this.f12914a.pop(), i10);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i10, @NonNull Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        this.f12914a.push(view);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        View c10 = c(i10);
        viewGroup.addView(c10);
        return c10;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }
}
