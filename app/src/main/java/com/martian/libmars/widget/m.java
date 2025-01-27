package com.martian.libmars.widget;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes2.dex */
public class m implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    static final int f10403a = 0;

    /* renamed from: b, reason: collision with root package name */
    static final int f10404b = 1;

    /* renamed from: c, reason: collision with root package name */
    static final int f10405c = 2;

    /* renamed from: d, reason: collision with root package name */
    Matrix f10406d = new Matrix();

    /* renamed from: e, reason: collision with root package name */
    Matrix f10407e = new Matrix();

    /* renamed from: f, reason: collision with root package name */
    int f10408f = 0;

    /* renamed from: g, reason: collision with root package name */
    PointF f10409g = new PointF();

    /* renamed from: h, reason: collision with root package name */
    PointF f10410h = new PointF();

    /* renamed from: i, reason: collision with root package name */
    float f10411i = 1.0f;

    private void a(PointF point, MotionEvent event) {
        point.set((event.getX(0) + event.getX(1)) / 2.0f, (event.getY(0) + event.getY(1)) / 2.0f);
    }

    private float b(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        if (r0 != 6) goto L27;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof android.widget.ImageView
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            int r0 = r8.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r2 = 1
            if (r0 == 0) goto L7f
            if (r0 == r2) goto L7c
            r3 = 1092616192(0x41200000, float:10.0)
            r4 = 2
            if (r0 == r4) goto L39
            r5 = 5
            if (r0 == r5) goto L20
            r8 = 6
            if (r0 == r8) goto L7c
            goto L9e
        L20:
            float r0 = r6.b(r8)
            r6.f10411i = r0
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L9e
            android.graphics.Matrix r0 = r6.f10407e
            android.graphics.Matrix r1 = r6.f10406d
            r0.set(r1)
            android.graphics.PointF r0 = r6.f10410h
            r6.a(r0, r8)
            r6.f10408f = r4
            goto L9e
        L39:
            int r0 = r6.f10408f
            if (r0 != r2) goto L5c
            android.graphics.Matrix r0 = r6.f10406d
            android.graphics.Matrix r1 = r6.f10407e
            r0.set(r1)
            android.graphics.Matrix r0 = r6.f10406d
            float r1 = r8.getX()
            android.graphics.PointF r3 = r6.f10409g
            float r3 = r3.x
            float r1 = r1 - r3
            float r8 = r8.getY()
            android.graphics.PointF r3 = r6.f10409g
            float r3 = r3.y
            float r8 = r8 - r3
            r0.postTranslate(r1, r8)
            goto L9e
        L5c:
            if (r0 != r4) goto L9e
            float r8 = r6.b(r8)
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 <= 0) goto L9e
            android.graphics.Matrix r0 = r6.f10406d
            android.graphics.Matrix r1 = r6.f10407e
            r0.set(r1)
            float r0 = r6.f10411i
            float r8 = r8 / r0
            android.graphics.Matrix r0 = r6.f10406d
            android.graphics.PointF r1 = r6.f10410h
            float r3 = r1.x
            float r1 = r1.y
            r0.postScale(r8, r8, r3, r1)
            goto L9e
        L7c:
            r6.f10408f = r1
            goto L9e
        L7f:
            android.graphics.Matrix r0 = r6.f10406d
            android.graphics.Matrix r1 = r7.getImageMatrix()
            r0.set(r1)
            android.graphics.Matrix r0 = r6.f10407e
            android.graphics.Matrix r1 = r6.f10406d
            r0.set(r1)
            android.graphics.PointF r0 = r6.f10409g
            float r1 = r8.getX()
            float r8 = r8.getY()
            r0.set(r1, r8)
            r6.f10408f = r2
        L9e:
            android.graphics.Matrix r8 = r6.f10406d
            r7.setImageMatrix(r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libmars.widget.m.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
