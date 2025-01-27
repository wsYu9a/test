package com.aggmoread.sdk.z.b.u;

import android.content.Context;
import android.graphics.Canvas;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class d extends FrameLayout {

    /* renamed from: a */
    private GestureDetector f5044a;

    /* renamed from: b */
    private ViewTreeObserver.OnScrollChangedListener f5045b;

    /* renamed from: c */
    public com.aggmoread.sdk.z.b.g.c f5046c;

    /* renamed from: d */
    private c f5047d;

    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            if (d.this.f5047d != null) {
                d.this.f5047d.onScrollChanged();
            }
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            com.aggmoread.sdk.z.b.d.c("ApiViewStatusLayout", "onSingleTapUp enter , viewStatusLis = " + d.this.f5047d);
            if (d.this.f5047d != null) {
                d.this.f5047d.onClick(d.this);
                if (com.aggmoread.sdk.z.b.h.a.d().g()) {
                    d.this.f5047d = null;
                }
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    public interface c {
        void a(int i10);

        void c();

        void onClick(View view);

        void onScrollChanged();
    }

    public d(Context context) {
        super(context);
        this.f5045b = new a();
        this.f5046c = new com.aggmoread.sdk.z.b.g.c();
        b(context);
    }

    private GestureDetector a(Context context) {
        if (this.f5044a == null) {
            this.f5044a = new GestureDetector(context, new b());
        }
        return this.f5044a;
    }

    private void b(Context context) {
        setFocusable(true);
        setClickable(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        c cVar = this.f5047d;
        if (cVar != null) {
            cVar.c();
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        StringBuilder sb2;
        int i10;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.f5046c.f4471c = (int) motionEvent.getX();
                this.f5046c.f4472d = (int) motionEvent.getY();
                this.f5046c.f4476h = System.currentTimeMillis();
                this.f5046c.f4473e = getWidth();
                this.f5046c.f4474f = getHeight();
                sb2 = new StringBuilder();
                sb2.append("touch ux = ");
                sb2.append(this.f5046c.f4471c);
                sb2.append(" , uy = ");
                i10 = this.f5046c.f4472d;
            }
            a(getContext()).onTouchEvent(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        com.aggmoread.sdk.z.b.g.c cVar = this.f5046c;
        cVar.f4469a = x10;
        cVar.f4470b = y10;
        cVar.f4475g = System.currentTimeMillis();
        sb2 = new StringBuilder();
        sb2.append("touch dx = ");
        sb2.append(this.f5046c.f4469a);
        sb2.append(" , dy = ");
        i10 = this.f5046c.f4470b;
        sb2.append(i10);
        com.aggmoread.sdk.z.b.d.c("ApiViewStatusLayout", sb2.toString());
        a(getContext()).onTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        c cVar = this.f5047d;
        if (cVar != null) {
            cVar.a(i10);
        }
        super.onWindowVisibilityChanged(i10);
    }

    public void a() {
        if (this.f5045b != null) {
            getViewTreeObserver().removeOnScrollChangedListener(this.f5045b);
        }
    }

    public void a(c cVar) {
        this.f5047d = cVar;
        getViewTreeObserver().addOnScrollChangedListener(this.f5045b);
    }
}
