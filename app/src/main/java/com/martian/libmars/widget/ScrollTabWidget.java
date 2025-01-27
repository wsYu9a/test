package com.martian.libmars.widget;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import n9.q;

/* loaded from: classes3.dex */
public class ScrollTabWidget extends HorizontalScrollView {

    /* renamed from: b */
    public a f12691b;

    /* renamed from: c */
    public final b f12692c;

    public interface a {
        void a(int i10, boolean z10);
    }

    public class c implements View.OnClickListener {

        /* renamed from: b */
        public final int f12695b;

        public /* synthetic */ c(ScrollTabWidget scrollTabWidget, int i10, q qVar) {
            this(i10);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ScrollTabWidget.this.f12691b.a(this.f12695b, true);
        }

        public c(int i10) {
            this.f12695b = i10;
        }
    }

    public ScrollTabWidget(Context context) {
        super(context);
        b bVar = new b(context);
        this.f12692c = bVar;
        super.addView(bVar);
        d();
    }

    public void b(View view) {
        this.f12692c.addView(view);
    }

    public View c(int i10) {
        return this.f12692c.getChildAt(i10);
    }

    public final void d() {
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setSaveEnabled(false);
    }

    public int getTabCount() {
        return this.f12692c.getChildCount();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        this.f12692c.removeAllViews();
        super.removeAllViews();
    }

    public void setCurrentTab(int i10) {
        View c10;
        int a10 = this.f12692c.a();
        if (i10 < 0 || i10 >= getTabCount() || i10 == a10) {
            return;
        }
        if (a10 != -1 && (c10 = c(a10)) != null) {
            c10.setSelected(false);
        }
        View c11 = c(i10);
        if (c11 != null) {
            c11.setSelected(true);
        }
        if (isShown()) {
            sendAccessibilityEvent(4);
        }
    }

    public void setTabSelectionListener(a aVar) {
        this.f12691b = aVar;
    }

    public class b extends LinearLayout implements View.OnFocusChangeListener {

        /* renamed from: b */
        public int f12693b;

        public b(Context context) {
            super(context);
            this.f12693b = -1;
            b();
        }

        public int a() {
            return this.f12693b;
        }

        @Override // android.view.ViewGroup
        public void addView(View view) {
            view.setFocusable(true);
            view.setClickable(true);
            super.addView(view);
            ScrollTabWidget scrollTabWidget = ScrollTabWidget.this;
            view.setOnClickListener(new c(scrollTabWidget.getTabCount() - 1));
            view.setOnFocusChangeListener(this);
        }

        public final void b() {
            setSaveEnabled(false);
            setChildrenDrawingOrderEnabled(true);
            setFocusable(true);
            setOnFocusChangeListener(this);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        }

        @Override // android.view.ViewGroup
        public int getChildDrawingOrder(int i10, int i11) {
            int i12 = this.f12693b;
            return i12 == -1 ? i11 : i11 == i10 + (-1) ? i12 : i11 >= i12 ? i11 + 1 : i11;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            if (view == this && z10 && ScrollTabWidget.this.getTabCount() > 0) {
                View c10 = ScrollTabWidget.this.c(this.f12693b);
                if (c10 != null) {
                    c10.requestFocus();
                    return;
                }
                return;
            }
            if (z10) {
                int tabCount = ScrollTabWidget.this.getTabCount();
                for (int i10 = 0; i10 < tabCount; i10++) {
                    if (ScrollTabWidget.this.c(i10) == view) {
                        ScrollTabWidget.this.setCurrentTab(i10);
                        ScrollTabWidget.this.f12691b.a(i10, false);
                        if (isShown()) {
                            sendAccessibilityEvent(8);
                            return;
                        }
                        return;
                    }
                }
            }
        }

        @Override // android.view.ViewGroup
        public void removeAllViews() {
            super.removeAllViews();
            this.f12693b = -1;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12693b = -1;
            b();
        }

        public b(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.f12693b = -1;
            b();
        }
    }

    public ScrollTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b bVar = new b(context, attributeSet);
        this.f12692c = bVar;
        super.addView(bVar);
        d();
    }

    public ScrollTabWidget(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b bVar = new b(context, attributeSet, i10);
        this.f12692c = bVar;
        addView(bVar);
        d();
    }
}
