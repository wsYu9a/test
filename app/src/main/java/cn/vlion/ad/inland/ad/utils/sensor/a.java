package cn.vlion.ad.inland.ad.utils.sensor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import cn.vlion.ad.inland.base.g6;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.util.ArrayList;
import java.util.List;
import l5.c;

/* loaded from: classes.dex */
public final class a extends g6 {
    public a(Context context) {
        super(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005c A[Catch: all -> 0x000e, TRY_LEAVE, TryCatch #4 {all -> 0x000e, blocks: (B:2:0x0000, B:6:0x0005, B:9:0x000b, B:15:0x0021, B:17:0x0029, B:20:0x0032, B:22:0x0036, B:25:0x003b, B:30:0x0058, B:32:0x005c, B:40:0x007d, B:42:0x0083, B:44:0x0089, B:46:0x008d, B:47:0x0093, B:48:0x009c, B:50:0x00a0, B:52:0x00a4), top: B:1:0x0000, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007d A[Catch: all -> 0x000e, Exception -> 0x00a4, TRY_ENTER, TryCatch #2 {Exception -> 0x00a4, blocks: (B:40:0x007d, B:42:0x0083, B:44:0x0089, B:46:0x008d, B:47:0x0093, B:48:0x009c, B:50:0x00a0), top: B:38:0x007b, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a0 A[Catch: all -> 0x000e, Exception -> 0x00a4, TRY_LEAVE, TryCatch #2 {Exception -> 0x00a4, blocks: (B:40:0x007d, B:42:0x0083, B:44:0x0089, B:46:0x008d, B:47:0x0093, B:48:0x009c, B:50:0x00a0), top: B:38:0x007b, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0051  */
    @Override // cn.vlion.ad.inland.base.g6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r15 = this;
            cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean r0 = r15.f2823e     // Catch: java.lang.Throwable -> Le
            if (r0 != 0) goto L5
            return
        L5:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Le
            r2 = 0
            long r4 = r15.f2829k     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L11
            goto L13
        Le:
            r0 = move-exception
            goto La8
        L11:
            r4 = r2
        L13:
            long r4 = r0 - r4
            double r4 = (double) r4
            r6 = 4656510908468559872(0x409f400000000000, double:2000.0)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 > 0) goto L20
            return
        L20:
            r4 = 0
            java.util.ArrayList r5 = r15.f2827i     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L28
            boolean r5 = r15.a(r5)     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L28
            goto L29
        L28:
            r5 = 0
        L29:
            java.util.ArrayList r6 = r15.f2828j     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L30
            boolean r6 = r15.a(r6)     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L30
            goto L31
        L30:
            r6 = 0
        L31:
            r7 = 0
            cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean r8 = r15.f2823e     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L43
            if (r8 == 0) goto L44
            cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean r8 = r15.f2823e     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L43
            int r8 = r8.f2393a     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L43
            float r8 = (float) r8
            cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean r9 = r15.f2823e     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L41
            int r9 = r9.f2394b     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L41
            float r9 = (float) r9
            goto L46
        L41:
            goto L45
        L43:
        L44:
            r8 = 0
        L45:
            r9 = 0
        L46:
            float r9 = r9 - r7
            double r9 = (double) r9
            r11 = 1
            r12 = 0
            int r14 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r14 != 0) goto L51
            r9 = 0
            goto L58
        L51:
            int r14 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r14 >= 0) goto L57
            r9 = -1
            goto L58
        L57:
            r9 = 1
        L58:
            cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean r10 = r15.f2823e     // Catch: java.lang.Throwable -> Le
            if (r10 == 0) goto L62
            cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean r10 = r15.f2823e     // Catch: java.lang.Throwable -> Le
            float r10 = r10.f2395c     // Catch: java.lang.Throwable -> Le
            long r12 = (long) r10
            goto L64
        L62:
            r12 = -1
        L64:
            if (r9 <= 0) goto L76
            int r9 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r9 != 0) goto L6c
            r4 = r6
            goto L7b
        L6c:
            int r2 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r2 <= 0) goto L7b
            if (r5 == 0) goto L7b
            if (r6 == 0) goto L7b
            r4 = 1
            goto L7b
        L76:
            int r2 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r2 <= 0) goto L7b
            r4 = r5
        L7b:
            if (r4 == 0) goto La0
            r15.f2829k = r0     // Catch: java.lang.Throwable -> Le java.lang.Exception -> La4
            cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean r2 = r15.f2823e     // Catch: java.lang.Throwable -> Le java.lang.Exception -> La4
            if (r2 == 0) goto L9c
            cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean r2 = r15.f2823e     // Catch: java.lang.Throwable -> Le java.lang.Exception -> La4
            cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager$OnShakeListener r2 = r2.f2396d     // Catch: java.lang.Throwable -> Le java.lang.Exception -> La4
            if (r2 == 0) goto L9c
            cn.vlion.ad.inland.ad.utils.sensor.VlionSensorPara r2 = r15.f2830l     // Catch: java.lang.Throwable -> Le java.lang.Exception -> La4
            if (r2 == 0) goto L93
            long r3 = r15.f2826h     // Catch: java.lang.Throwable -> Le java.lang.Exception -> La4
            long r0 = r0 - r3
            r2.setRotateTime(r0)     // Catch: java.lang.Throwable -> Le java.lang.Exception -> La4
        L93:
            cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean r0 = r15.f2823e     // Catch: java.lang.Throwable -> Le java.lang.Exception -> La4
            cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager$OnShakeListener r0 = r0.f2396d     // Catch: java.lang.Throwable -> Le java.lang.Exception -> La4
            cn.vlion.ad.inland.ad.utils.sensor.VlionSensorPara r1 = r15.f2830l     // Catch: java.lang.Throwable -> Le java.lang.Exception -> La4
            r0.onShake(r5, r1)     // Catch: java.lang.Throwable -> Le java.lang.Exception -> La4
        L9c:
            r15.d()     // Catch: java.lang.Throwable -> Le java.lang.Exception -> La4
            return
        La0:
            r15.d()     // Catch: java.lang.Throwable -> Le java.lang.Exception -> La4
            return
        La4:
            r15.d()     // Catch: java.lang.Throwable -> Le
            goto Laf
        La8:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r1 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r1.upLoadCatchException(r0)
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.ad.utils.sensor.a.a():void");
    }

    @Override // cn.vlion.ad.inland.base.g6
    public final void b() {
        try {
            if (this.f2823e == null) {
                return;
            }
            float f10 = this.f2823e.f2395c;
            long j10 = this.f2825g;
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = this.f2827i;
            if (f10 > 0.0f) {
                if (currentTimeMillis - j10 > qe.a.f30009d) {
                    this.f2827i = new ArrayList();
                    this.f2828j = new ArrayList();
                    d();
                }
                if (this.f2824f == null) {
                    this.f2824f = new Handler(Looper.getMainLooper(), this);
                }
                this.f2824f.sendEmptyMessageDelayed(100003, (long) f10);
            }
            this.f2825g = currentTimeMillis;
            if (arrayList == null) {
                this.f2827i = new ArrayList();
            }
            this.f2827i.add(Long.valueOf(currentTimeMillis));
            if (f10 == 0.0f) {
                a();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.g6
    public final void c() {
        try {
            if (this.f2823e == null) {
                return;
            }
            float f10 = this.f2823e.f2395c;
            long j10 = this.f2826h;
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = this.f2828j;
            if (f10 > 0.0f) {
                if (currentTimeMillis - j10 > qe.a.f30009d) {
                    this.f2827i = new ArrayList();
                    this.f2828j = new ArrayList();
                    d();
                }
                if (this.f2824f == null) {
                    this.f2824f = new Handler(Looper.getMainLooper(), this);
                }
                this.f2824f.sendEmptyMessageDelayed(100003, (long) f10);
            }
            this.f2826h = currentTimeMillis;
            if (arrayList == null) {
                this.f2828j = new ArrayList();
            }
            this.f2828j.add(Long.valueOf(currentTimeMillis));
            if (f10 == 0.0f) {
                a();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final boolean a(List<Long> list) {
        if (list != null) {
            try {
                if (list.size() == 0 || this.f2823e == null) {
                    return false;
                }
                if (this.f2823e.f2395c == 0.0f) {
                    return true;
                }
                if (list.size() < 2) {
                    return false;
                }
                int size = list.size();
                double longValue = list.get(0).longValue();
                int i10 = size - 1;
                double longValue2 = list.get(i10).longValue();
                if (longValue2 - longValue <= c.f27899e) {
                    return false;
                }
                double d10 = 0.0d;
                for (int i11 = 1; i11 < size; i11++) {
                    double longValue3 = list.get(i11).longValue() - list.get(i11 - 1).longValue();
                    if (longValue3 < c.f27899e) {
                        return false;
                    }
                    d10 += longValue3;
                }
                if (this.f2823e == null) {
                    return false;
                }
                long j10 = (long) this.f2823e.f2395c;
                if (this.f2823e == null) {
                    return false;
                }
                double d11 = i10;
                if (d10 / d11 > (j10 * 1000.0d) / d11) {
                    return false;
                }
                return ((double) System.currentTimeMillis()) - longValue2 < 1500.0d;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
        return false;
    }
}
