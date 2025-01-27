package com.martian.ttbook.b.c.a.a.d.b.m;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public class a extends FrameLayout {

    /* renamed from: a */
    public float f15796a;

    /* renamed from: b */
    public float f15797b;

    /* renamed from: c */
    public long f15798c;

    /* renamed from: d */
    public int f15799d;

    public a(@NonNull Context context) {
        super(context);
        this.f15799d = com.martian.ttbook.b.c.a.a.e.b.y();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000a, code lost:
    
        if (r0 != 2) goto L34;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getAction()
            if (r0 == 0) goto L35
            r1 = 1
            if (r0 == r1) goto Ld
            r2 = 2
            if (r0 == r2) goto L1b
            goto L47
        Ld:
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r6.f15798c
            long r2 = r2 - r4
            r4 = 2
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L1b
            return r1
        L1b:
            float r0 = r7.getX()
            float r2 = r6.f15796a
            float r0 = r0 - r2
            int r0 = (int) r0
            float r2 = r7.getY()
            float r3 = r6.f15797b
            float r2 = r2 - r3
            int r2 = (int) r2
            int r0 = r0 * r0
            int r2 = r2 * r2
            int r0 = r0 + r2
            int r2 = r6.f15799d
            if (r0 < r2) goto L47
            return r1
        L35:
            float r0 = r7.getX()
            r6.f15796a = r0
            float r0 = r7.getY()
            r6.f15797b = r0
            long r0 = java.lang.System.currentTimeMillis()
            r6.f15798c = r0
        L47:
            boolean r7 = super.onInterceptTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.ttbook.b.c.a.a.d.b.m.a.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }
}
