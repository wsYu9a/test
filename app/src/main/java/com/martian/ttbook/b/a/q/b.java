package com.martian.ttbook.b.a.q;

import android.content.Context;
import android.graphics.Canvas;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes4.dex */
public class b extends FrameLayout {

    /* renamed from: a */
    private GestureDetector f15146a;

    /* renamed from: b */
    public b.d.e.c.a.f.c f15147b;

    /* renamed from: c */
    private InterfaceC0288b f15148c;

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            b.d.e.c.a.d.k("ApiViewStatusLayout", "onSingleTapUp enter , viewStatusLis = " + b.this.f15148c);
            if (b.this.f15148c != null) {
                b.this.f15148c.onClick(b.this);
                b.this.f15148c = null;
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    /* renamed from: com.martian.ttbook.b.a.q.b$b */
    public interface InterfaceC0288b {
        void a();

        void onClick(View view);
    }

    public b(Context context) {
        super(context);
        this.f15147b = new b.d.e.c.a.f.c();
        e(context);
    }

    private GestureDetector a(Context context) {
        if (this.f15146a == null) {
            this.f15146a = new GestureDetector(context, new a());
        }
        return this.f15146a;
    }

    private void e(Context context) {
        setFocusable(true);
        setClickable(true);
    }

    public void d(InterfaceC0288b interfaceC0288b) {
        this.f15148c = interfaceC0288b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        InterfaceC0288b interfaceC0288b = this.f15148c;
        if (interfaceC0288b != null) {
            interfaceC0288b.a();
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        StringBuilder sb;
        int i2;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.f15147b.f4587c = (int) motionEvent.getX();
                this.f15147b.f4588d = (int) motionEvent.getY();
                this.f15147b.f4592h = System.currentTimeMillis();
                this.f15147b.f4589e = getWidth();
                this.f15147b.f4590f = getHeight();
                sb = new StringBuilder();
                sb.append("touch ux = ");
                sb.append(this.f15147b.f4587c);
                sb.append(" , uy = ");
                i2 = this.f15147b.f4588d;
            }
            a(getContext()).onTouchEvent(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        b.d.e.c.a.f.c cVar = this.f15147b;
        cVar.f4585a = x;
        cVar.f4586b = y;
        cVar.f4591g = System.currentTimeMillis();
        sb = new StringBuilder();
        sb.append("touch dx = ");
        sb.append(this.f15147b.f4585a);
        sb.append(" , dy = ");
        i2 = this.f15147b.f4586b;
        sb.append(i2);
        b.d.e.c.a.d.k("ApiViewStatusLayout", sb.toString());
        a(getContext()).onTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }
}
