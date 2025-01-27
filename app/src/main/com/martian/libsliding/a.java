package com.martian.libsliding;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Point f12933a = null;

    /* renamed from: b, reason: collision with root package name */
    public Long f12934b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12935c = false;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0522a f12936d;

    /* renamed from: e, reason: collision with root package name */
    public final float f12937e;

    /* renamed from: com.martian.libsliding.a$a, reason: collision with other inner class name */
    public interface InterfaceC0522a {
        void g0(Point point);
    }

    public a(Context context, InterfaceC0522a interfaceC0522a) {
        context.getApplicationContext();
        this.f12936d = interfaceC0522a;
        this.f12937e = context.getResources().getDisplayMetrics().density;
    }

    public void a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f12933a = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            this.f12934b = Long.valueOf(System.currentTimeMillis());
            this.f12935c = false;
        } else {
            if (this.f12935c) {
                return;
            }
            b(motionEvent);
        }
    }

    public void b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.f12933a == null) {
                this.f12933a = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
                this.f12934b = Long.valueOf(System.currentTimeMillis());
            }
            this.f12935c = true;
            return;
        }
        if (motionEvent.getAction() != 1 || this.f12933a == null || this.f12934b == null) {
            return;
        }
        if (System.currentTimeMillis() - this.f12934b.longValue() < 500 && Math.abs(motionEvent.getX() - this.f12933a.x) < this.f12937e * 20.0f && Math.abs(motionEvent.getY() - this.f12933a.y) < this.f12937e * 20.0f) {
            this.f12936d.g0(this.f12933a);
        }
        this.f12933a = null;
        this.f12934b = null;
        this.f12935c = false;
    }
}
