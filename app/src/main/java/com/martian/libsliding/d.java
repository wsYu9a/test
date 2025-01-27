package com.martian.libsliding;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.Stack;

/* loaded from: classes3.dex */
public abstract class d<T> extends PagerAdapter {

    /* renamed from: a */
    private final Stack<View> f10516a = new Stack<>();

    private View c(int position) {
        return this.f10516a.isEmpty() ? b(null, position) : b(this.f10516a.pop(), position);
    }

    public abstract T a(int position);

    protected abstract View b(View contentView, int position);

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
        this.f10516a.push(view);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup container, int position) {
        View c2 = c(position);
        container.addView(c2);
        return c2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
