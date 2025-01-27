package cn.vlion.ad.inland.base;

import android.content.Context;
import android.view.SurfaceView;

/* loaded from: classes.dex */
public final class f0 extends SurfaceView {

    /* renamed from: a */
    public int f2774a;

    /* renamed from: b */
    public int f2775b;

    /* renamed from: c */
    public int f2776c;

    /* renamed from: d */
    public int f2777d;

    /* renamed from: e */
    public int f2778e;

    public f0(Context context) {
        super(context);
        this.f2774a = 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
    
        if (r6 != false) goto L67;
     */
    @Override // android.view.SurfaceView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.f2775b     // Catch: java.lang.Throwable -> L3c
            int r0 = android.view.View.getDefaultSize(r0, r6)     // Catch: java.lang.Throwable -> L3c
            int r1 = r5.f2776c     // Catch: java.lang.Throwable -> L3c
            int r1 = android.view.View.getDefaultSize(r1, r7)     // Catch: java.lang.Throwable -> L3c
            int r2 = r5.f2775b     // Catch: java.lang.Throwable -> L3c
            if (r2 <= 0) goto L42
            int r2 = r5.f2776c     // Catch: java.lang.Throwable -> L3c
            if (r2 <= 0) goto L42
            int r6 = android.view.View.MeasureSpec.getSize(r6)     // Catch: java.lang.Throwable -> L3c
            int r7 = android.view.View.MeasureSpec.getSize(r7)     // Catch: java.lang.Throwable -> L3c
            float r6 = (float) r6     // Catch: java.lang.Throwable -> L3c
            float r7 = (float) r7     // Catch: java.lang.Throwable -> L3c
            float r6 = r6 / r7
            int r7 = r5.f2775b     // Catch: java.lang.Throwable -> L3c
            float r2 = (float) r7     // Catch: java.lang.Throwable -> L3c
            int r3 = r5.f2776c     // Catch: java.lang.Throwable -> L3c
            float r4 = (float) r3     // Catch: java.lang.Throwable -> L3c
            float r2 = r2 / r4
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 <= 0) goto L2c
            r6 = 1
            goto L2d
        L2c:
            r6 = 0
        L2d:
            int r2 = r5.f2774a     // Catch: java.lang.Throwable -> L3c
            r4 = 2
            if (r2 != r4) goto L35
            if (r6 != 0) goto L3e
            goto L37
        L35:
            if (r6 == 0) goto L3e
        L37:
            int r3 = r3 * r0
            int r1 = r3 / r7
            goto L42
        L3c:
            r6 = move-exception
            goto L47
        L3e:
            int r7 = r7 * r1
            int r0 = r7 / r3
        L42:
            r5.f2777d = r0     // Catch: java.lang.Throwable -> L3c
            r5.f2778e = r1     // Catch: java.lang.Throwable -> L3c
            goto L4e
        L47:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r7 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r7.upLoadCatchException(r6)
        L4e:
            int r6 = r5.f2777d
            int r7 = r5.f2778e
            r5.setMeasuredDimension(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.f0.onMeasure(int, int):void");
    }

    public void setVideoScaleMode(int i10) {
        this.f2774a = i10;
    }
}
