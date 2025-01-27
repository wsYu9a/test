package cn.vlion.ad.inland.base;

import android.content.Context;
import android.view.TextureView;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class d1 extends TextureView {

    /* renamed from: a */
    public int f2696a;

    /* renamed from: b */
    public int f2697b;

    /* renamed from: c */
    public int f2698c;

    /* renamed from: d */
    public int f2699d;

    /* renamed from: e */
    public int f2700e;

    /* renamed from: f */
    public a f2701f;

    public interface a {
    }

    public d1(Context context) {
        super(context);
        this.f2696a = 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0064, code lost:
    
        if (r2 == false) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.f2697b     // Catch: java.lang.Throwable -> L7a
            int r6 = android.view.View.getDefaultSize(r0, r6)     // Catch: java.lang.Throwable -> L7a
            int r0 = r5.f2698c     // Catch: java.lang.Throwable -> L7a
            int r7 = android.view.View.getDefaultSize(r0, r7)     // Catch: java.lang.Throwable -> L7a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7a
            r0.<init>()     // Catch: java.lang.Throwable -> L7a
            java.lang.String r1 = "VlionBaseVideoSurfaceView doMeasure layoutScaleMode = "
            r0.append(r1)     // Catch: java.lang.Throwable -> L7a
            int r1 = r5.f2696a     // Catch: java.lang.Throwable -> L7a
            r0.append(r1)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r1 = "  width= "
            r0.append(r1)     // Catch: java.lang.Throwable -> L7a
            r0.append(r6)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r1 = "  height= "
            r0.append(r1)     // Catch: java.lang.Throwable -> L7a
            r0.append(r7)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r1 = " + widthSpecSize == + mVideoWidth =="
            r0.append(r1)     // Catch: java.lang.Throwable -> L7a
            int r1 = r5.f2697b     // Catch: java.lang.Throwable -> L7a
            r0.append(r1)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r1 = "  mVideoHeight=="
            r0.append(r1)     // Catch: java.lang.Throwable -> L7a
            int r1 = r5.f2698c     // Catch: java.lang.Throwable -> L7a
            r0.append(r1)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L7a
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L7a
            int r0 = r5.f2697b     // Catch: java.lang.Throwable -> L7a
            if (r0 <= 0) goto L7e
            int r1 = r5.f2698c     // Catch: java.lang.Throwable -> L7a
            if (r1 <= 0) goto L7e
            if (r7 <= 0) goto L54
            float r2 = (float) r6     // Catch: java.lang.Throwable -> L7a
            float r3 = (float) r7     // Catch: java.lang.Throwable -> L7a
            float r2 = r2 / r3
            goto L55
        L54:
            r2 = 0
        L55:
            float r3 = (float) r0     // Catch: java.lang.Throwable -> L7a
            float r4 = (float) r1     // Catch: java.lang.Throwable -> L7a
            float r3 = r3 / r4
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 <= 0) goto L5e
            r2 = 1
            goto L5f
        L5e:
            r2 = 0
        L5f:
            int r3 = r5.f2696a     // Catch: java.lang.Throwable -> L7a
            r4 = 2
            if (r3 != r4) goto L6c
            if (r2 != 0) goto L69
        L66:
            int r1 = r1 * r6
            goto L77
        L69:
            int r0 = r0 * r7
            goto L7c
        L6c:
            r4 = 5
            if (r3 != r4) goto L70
            goto L66
        L70:
            r4 = 3
            if (r3 != r4) goto L74
            goto L7e
        L74:
            if (r2 == 0) goto L69
            goto L66
        L77:
            int r7 = r1 / r0
            goto L7e
        L7a:
            r6 = move-exception
            goto L83
        L7c:
            int r6 = r0 / r1
        L7e:
            r5.f2699d = r6     // Catch: java.lang.Throwable -> L7a
            r5.f2700e = r7     // Catch: java.lang.Throwable -> L7a
            goto L8a
        L83:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r7 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r7.upLoadCatchException(r6)
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.d1.a(int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        try {
            a(i10, i11);
            LogVlion.e("VlionBaseVideoSurfaceView  onMeasure mMeasuredWidth= " + this.f2699d + "  mMeasuredHeight " + this.f2700e);
            if (this.f2699d == 0) {
                this.f2699d = 600;
            }
            if (this.f2700e == 0) {
                this.f2700e = 600;
            }
            setMeasuredDimension(this.f2699d, this.f2700e);
            a aVar = this.f2701f;
            if (aVar != null) {
                ((f1) aVar).a(this.f2699d, this.f2700e);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setMeasuredDimensionListener(a aVar) {
        this.f2701f = aVar;
    }

    public void setVideoScaleMode(int i10) {
        this.f2696a = i10;
    }
}
