package com.martian.libmars.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/* loaded from: classes2.dex */
public class ScrollTabWidget extends HorizontalScrollView {

    /* renamed from: a, reason: collision with root package name */
    private b f10375a;

    /* renamed from: b, reason: collision with root package name */
    private final c f10376b;

    public interface b {
        void a(int tabIndex, boolean clicked);
    }

    private class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private final int f10379a;

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            ScrollTabWidget.this.f10375a.a(this.f10379a, true);
        }

        private d(int tabIndex) {
            this.f10379a = tabIndex;
        }
    }

    public ScrollTabWidget(Context context) {
        super(context);
        c cVar = new c(context);
        this.f10376b = cVar;
        super.addView(cVar);
        d();
    }

    private void d() {
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setSaveEnabled(false);
    }

    public void b(View child) {
        this.f10376b.addView(child);
    }

    public View c(int index) {
        return this.f10376b.getChildAt(index);
    }

    public int getTabCount() {
        return this.f10376b.getChildCount();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        this.f10376b.removeAllViews();
        super.removeAllViews();
    }

    public void setCurrentTab(int index) {
        int a2 = this.f10376b.a();
        if (index < 0 || index >= getTabCount() || index == a2) {
            return;
        }
        if (a2 != -1) {
            c(a2).setSelected(false);
        }
        c(index).setSelected(true);
        if (isShown()) {
            sendAccessibilityEvent(4);
        }
    }

    public void setTabSelectionListener(b listener) {
        this.f10375a = listener;
    }

    private class c extends LinearLayout implements View.OnFocusChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private int f10377a;

        public c(Context context) {
            super(context);
            this.f10377a = -1;
            b();
        }

        private void b() {
            setSaveEnabled(false);
            setChildrenDrawingOrderEnabled(true);
            setFocusable(true);
            setOnFocusChangeListener(this);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        }

        public int a() {
            return this.f10377a;
        }

        @Override // android.view.ViewGroup
        public void addView(View child) {
            child.setFocusable(true);
            child.setClickable(true);
            super.addView(child);
            ScrollTabWidget scrollTabWidget = ScrollTabWidget.this;
            child.setOnClickListener(new d(scrollTabWidget.getTabCount() - 1));
            child.setOnFocusChangeListener(this);
        }

        @Override // android.view.ViewGroup
        protected int getChildDrawingOrder(int childCount, int i2) {
            int i3 = this.f10377a;
            return i3 == -1 ? i2 : i2 == childCount + (-1) ? i3 : i2 >= i3 ? i2 + 1 : i2;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View v, boolean hasFocus) {
            if (v == this && hasFocus && ScrollTabWidget.this.getTabCount() > 0) {
                ScrollTabWidget.this.c(this.f10377a).requestFocus();
                return;
            }
            if (hasFocus) {
                int tabCount = ScrollTabWidget.this.getTabCount();
                for (int i2 = 0; i2 < tabCount; i2++) {
                    if (ScrollTabWidget.this.c(i2) == v) {
                        ScrollTabWidget.this.setCurrentTab(i2);
                        ScrollTabWidget.this.f10375a.a(i2, false);
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
            this.f10377a = -1;
        }

        public c(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.f10377a = -1;
            b();
        }

        @TargetApi(11)
        public c(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            this.f10377a = -1;
            b();
        }
    }

    public ScrollTabWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        c cVar = new c(context, attrs);
        this.f10376b = cVar;
        super.addView(cVar);
        d();
    }

    @TargetApi(11)
    public ScrollTabWidget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        c cVar = new c(context, attrs, defStyle);
        this.f10376b = cVar;
        addView(cVar);
        d();
    }
}
