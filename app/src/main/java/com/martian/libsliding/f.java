package com.martian.libsliding;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;

/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private Point f10520a = null;

    /* renamed from: b, reason: collision with root package name */
    private Long f10521b = null;

    /* renamed from: c, reason: collision with root package name */
    private final a f10522c;

    /* renamed from: d, reason: collision with root package name */
    private final float f10523d;

    /* loaded from: classes.dex */
    public interface a {
        void r(Point point);
    }

    public f(Context context, a listener) {
        context.getApplicationContext();
        this.f10522c = listener;
        this.f10523d = context.getResources().getDisplayMetrics().density;
    }

    public void a(MotionEvent event) {
        if (event.getAction() == 0) {
            this.f10520a = new Point((int) event.getX(), (int) event.getY());
            this.f10521b = Long.valueOf(System.currentTimeMillis());
        } else {
            if (event.getAction() != 1 || this.f10520a == null || this.f10521b == null) {
                return;
            }
            if (System.currentTimeMillis() - this.f10521b.longValue() < 500 && Math.abs(event.getX() - this.f10520a.x) < this.f10523d * 20.0f && Math.abs(event.getY() - this.f10520a.y) < this.f10523d * 20.0f) {
                this.f10522c.r(this.f10520a);
            }
            this.f10520a = null;
            this.f10521b = null;
        }
    }
}
