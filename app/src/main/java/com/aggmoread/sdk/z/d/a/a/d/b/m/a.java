package com.aggmoread.sdk.z.d.a.a.d.b.m;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class a extends FrameLayout {

    /* renamed from: a */
    public float f6060a;

    /* renamed from: b */
    public float f6061b;

    /* renamed from: c */
    public long f6062c;

    /* renamed from: d */
    public int f6063d;

    /* renamed from: e */
    public boolean f6064e;

    public a(@NonNull Context context) {
        super(context);
        this.f6063d = com.aggmoread.sdk.z.d.a.a.e.c.u();
        this.f6064e = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        if (r2 != 2) goto L61;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            boolean r0 = r6.f6064e
            r1 = 1
            if (r0 != 0) goto L7
            r0 = 1
            goto L10
        L7:
            java.lang.String r0 = "xxxx"
            java.lang.String r2 = "onInterceptTouchEvent return false "
            com.aggmoread.sdk.z.d.a.a.e.e.b(r0, r2)
            r0 = 0
        L10:
            int r2 = r7.getAction()
            if (r2 == 0) goto L44
            if (r2 == r1) goto L1c
            r1 = 2
            if (r2 == r1) goto L2a
            goto L56
        L1c:
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r6.f6062c
            long r1 = r1 - r3
            r3 = 2
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L2a
            return r0
        L2a:
            float r1 = r7.getX()
            float r2 = r6.f6060a
            float r1 = r1 - r2
            int r1 = (int) r1
            float r2 = r7.getY()
            float r3 = r6.f6061b
            float r2 = r2 - r3
            int r2 = (int) r2
            int r1 = r1 * r1
            int r2 = r2 * r2
            int r1 = r1 + r2
            int r2 = r6.f6063d
            if (r1 < r2) goto L56
            return r0
        L44:
            float r0 = r7.getX()
            r6.f6060a = r0
            float r0 = r7.getY()
            r6.f6061b = r0
            long r0 = java.lang.System.currentTimeMillis()
            r6.f6062c = r0
        L56:
            boolean r7 = super.onInterceptTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aggmoread.sdk.z.d.a.a.d.b.m.a.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }
}
