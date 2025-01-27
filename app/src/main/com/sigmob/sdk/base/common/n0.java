package com.sigmob.sdk.base.common;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.sigmob.sdk.base.models.BaseAdUnit;

/* loaded from: classes4.dex */
public class n0 extends GestureDetector {

    /* renamed from: a */
    public final View f17999a;

    /* renamed from: b */
    public b f18000b;

    public n0(Context context, View view, b bVar) {
        super(context, bVar);
        this.f18000b = bVar;
        this.f17999a = view;
        setIsLongpressEnabled(false);
    }

    public boolean a() {
        return this.f18000b.c();
    }

    public void b() {
        this.f18000b.d();
    }

    public void c() {
        this.f18000b.e();
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            this.f18000b.a();
        } else if (action == 2 && !a(motionEvent, this.f17999a)) {
            c();
        }
        return onTouchEvent;
    }

    public n0(Context context, View view, BaseAdUnit baseAdUnit) {
        this(context, view, new b(view, baseAdUnit));
    }

    public final boolean a(MotionEvent motionEvent, View view) {
        if (motionEvent == null || view == null) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        return x10 >= 0.0f && x10 <= ((float) view.getWidth()) && y10 >= 0.0f && y10 <= ((float) view.getHeight());
    }
}
