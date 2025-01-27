package com.martian.libmars.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: classes2.dex */
public class RLScrollView extends ScrollView {

    /* renamed from: a */
    private l f10360a;

    /* renamed from: b */
    private a f10361b;

    public interface a {
        void a();
    }

    public RLScrollView(Context context) {
        super(context);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        a aVar;
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        if (scrollY <= 0 || !clampedY || (aVar = this.f10361b) == null) {
            return;
        }
        aVar.a();
    }

    @Override // android.view.View
    protected void onScrollChanged(int x, int y, int oldX, int oldY) {
        super.onScrollChanged(x, y, oldX, oldY);
        l lVar = this.f10360a;
        if (lVar != null) {
            lVar.onScrollChanged(x, y, oldX, oldY);
        }
    }

    public void setOnOverScrollListener(a onOverScrollListener) {
        this.f10361b = onOverScrollListener;
    }

    public void setOnScrollListener(l onScrollChangedListener) {
        this.f10360a = onScrollChangedListener;
    }

    public RLScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RLScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
