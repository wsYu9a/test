package com.zk_oaction.adengine.lk_sdkwrapper;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.SoundPool;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import com.zk_oaction.adengine.bitmap.g;
import java.util.HashMap;
import java.util.Map;

@TargetApi(16)
/* loaded from: classes5.dex */
public class d implements com.zk_oaction.adengine.lk_interfaces.a {

    /* renamed from: a */
    protected g f34937a;

    /* renamed from: b */
    public int f34938b;

    /* renamed from: c */
    public int f34939c;

    /* renamed from: d */
    private Context f34940d;

    /* renamed from: e */
    private com.zk_oaction.adengine.lk_sdk.b f34941e;

    /* renamed from: f */
    private SoundPool f34942f;

    /* renamed from: g */
    private HashMap<String, Integer> f34943g;

    /* renamed from: h */
    private int f34944h;

    /* renamed from: i */
    private View f34945i;

    /* renamed from: j */
    private com.zk_oaction.adengine.lk_interfaces.c f34946j;
    private com.zk_oaction.adengine.lk_sensor.b k;
    private boolean l;

    public d(Context context, int i2, int i3, int i4) {
        this.f34940d = context;
        com.zk_oaction.adengine.lk_sdk.b bVar = new com.zk_oaction.adengine.lk_sdk.b(context, this);
        this.f34941e = bVar;
        bVar.d(i2);
        this.f34937a = new g();
        if (i3 == 0 || i4 == 0) {
            z();
            i3 = this.f34938b;
            i4 = this.f34939c;
        }
        this.f34937a.l(i3, i4);
        this.f34937a.k(0);
        this.f34937a.D(this);
    }

    private void x() {
        com.zk_oaction.adengine.lk_sensor.b bVar;
        if (!this.l || (bVar = this.k) == null) {
            return;
        }
        bVar.d();
    }

    private void y() {
        com.zk_oaction.adengine.lk_sensor.b bVar = this.k;
        if (bVar != null) {
            bVar.g();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z() {
        /*
            r11 = this;
            android.content.Context r0 = r11.f34940d
            if (r0 != 0) goto L6
            goto L92
        L6:
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.util.DisplayMetrics r1 = new android.util.DisplayMetrics
            r1.<init>()
            r0.getMetrics(r1)
            int r2 = r1.widthPixels
            int r1 = r1.heightPixels
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 15
            r5 = 17
            r6 = 0
            if (r3 < r4) goto L5a
            if (r3 >= r5) goto L5a
            java.lang.Class<android.view.Display> r3 = android.view.Display.class
            java.lang.String r4 = "getRawWidth"
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L56
            java.lang.reflect.Method r3 = r3.getMethod(r4, r7)     // Catch: java.lang.Exception -> L56
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch: java.lang.Exception -> L56
            java.lang.Object r3 = r3.invoke(r0, r4)     // Catch: java.lang.Exception -> L56
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Exception -> L56
            int r2 = r3.intValue()     // Catch: java.lang.Exception -> L56
            java.lang.Class<android.view.Display> r3 = android.view.Display.class
            java.lang.String r4 = "getRawHeight"
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L56
            java.lang.reflect.Method r3 = r3.getMethod(r4, r7)     // Catch: java.lang.Exception -> L56
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch: java.lang.Exception -> L56
            java.lang.Object r3 = r3.invoke(r0, r4)     // Catch: java.lang.Exception -> L56
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Exception -> L56
            int r1 = r3.intValue()     // Catch: java.lang.Exception -> L56
            goto L5a
        L56:
            r3 = move-exception
            r3.printStackTrace()
        L5a:
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r5) goto L88
            android.graphics.Point r3 = new android.graphics.Point     // Catch: java.lang.Exception -> L80
            r3.<init>()     // Catch: java.lang.Exception -> L80
            java.lang.Class<android.view.Display> r4 = android.view.Display.class
            java.lang.String r5 = "getRealSize"
            r7 = 1
            java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch: java.lang.Exception -> L80
            java.lang.Class<android.graphics.Point> r9 = android.graphics.Point.class
            r8[r6] = r9     // Catch: java.lang.Exception -> L80
            java.lang.reflect.Method r4 = r4.getMethod(r5, r8)     // Catch: java.lang.Exception -> L80
            java.lang.Object[] r5 = new java.lang.Object[r7]     // Catch: java.lang.Exception -> L80
            r5[r6] = r3     // Catch: java.lang.Exception -> L80
            r4.invoke(r0, r5)     // Catch: java.lang.Exception -> L80
            int r0 = r3.x     // Catch: java.lang.Exception -> L80
            int r1 = r3.y     // Catch: java.lang.Exception -> L7e
            goto L89
        L7e:
            r2 = move-exception
            goto L84
        L80:
            r0 = move-exception
            r10 = r2
            r2 = r0
            r0 = r10
        L84:
            r2.printStackTrace()
            r2 = r0
        L88:
            r0 = r2
        L89:
            if (r0 <= r1) goto L8e
            r10 = r1
            r1 = r0
            r0 = r10
        L8e:
            r11.f34938b = r0
            r11.f34939c = r1
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_sdkwrapper.d.z():void");
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public com.zk_oaction.adengine.lk_interfaces.b a(String str, float f2, int i2) {
        g gVar = this.f34937a;
        if (gVar != null) {
            return gVar.E(str, f2, i2);
        }
        return null;
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void a() {
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void a(long j2) {
        try {
            ((Vibrator) this.f34940d.getSystemService("vibrator")).vibrate(j2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void a(String str) {
        try {
            if (this.f34943g == null) {
                this.f34943g = new HashMap<>();
            }
            if (this.f34942f == null) {
                this.f34942f = new SoundPool(10, 3, 0);
            }
            this.f34943g.put(str, Integer.valueOf(this.f34942f.load(str, 1)));
        } catch (Throwable unused) {
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void b() {
        this.f34937a.m(300L);
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void b(View view, Map map) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.f34946j;
        if (cVar != null) {
            cVar.b(view, map);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void c() {
        g gVar = this.f34937a;
        if (gVar == null) {
            return;
        }
        gVar.x();
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void c(String str, int i2, String str2, Map map) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.f34946j;
        if (cVar != null) {
            cVar.c(str, i2, str2, map);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void d() {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.f34946j;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void d(String str, int i2, int i3, int i4, Map map) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.f34946j;
        if (cVar != null) {
            cVar.d(str, i2, i3, i4, map);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void e(String str, int i2, int i3, int i4, Map map) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.f34946j;
        if (cVar != null) {
            cVar.e(str, i2, i3, i4, map);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void f(String str, int i2, int i3, int i4, Map map) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.f34946j;
        if (cVar != null) {
            cVar.f(str, i2, i3, i4, map);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void g(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.f34946j;
        if (cVar != null) {
            cVar.g(motionEvent, motionEvent2, f2, f3);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void h(MotionEvent motionEvent, int i2, int i3) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.f34946j;
        if (cVar != null) {
            cVar.h(motionEvent, i2, i3);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void i(MotionEvent motionEvent, int i2, int i3) {
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void j(String str, int i2, String str2) {
        if (str == null) {
            return;
        }
        try {
            com.zk_oaction.adengine.lk_interfaces.c cVar = this.f34946j;
            if (cVar != null) {
                cVar.j(str, i2, str2);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void k(String str, int i2, int i3, Map map) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.f34946j;
        if (cVar != null) {
            cVar.k(str, i2, i3, map);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void l(String str, String[] strArr) {
        try {
            if (this.k == null) {
                this.k = new com.zk_oaction.adengine.lk_sensor.b(this.f34940d, this.f34941e);
            }
            this.k.e(str, strArr, this.l);
        } catch (Throwable unused) {
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public com.zk_oaction.adengine.lk_interfaces.b m(int i2, int i3, Bitmap.Config config) {
        g gVar = this.f34937a;
        if (gVar != null) {
            return gVar.C(i2, i3, config);
        }
        return null;
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void n(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String[] strArr3, String[] strArr4) {
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void o(MotionEvent motionEvent, int i2, int i3) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.f34946j;
        if (cVar != null) {
            cVar.i(motionEvent, i2, i3);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void p(Intent intent) {
        try {
            this.f34940d.startActivity(intent);
        } catch (Throwable unused) {
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void q(String str, float f2, boolean z, boolean z2) {
        if (!z2) {
            try {
                int i2 = this.f34944h;
                if (i2 != 0) {
                    this.f34942f.stop(i2);
                    this.f34944h = 0;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        int i3 = z ? -1 : 0;
        Integer num = this.f34943g.get(str);
        if (num == null) {
            a(str);
            num = this.f34943g.get(str);
        }
        this.f34944h = this.f34942f.play(num.intValue(), f2, f2, 0, i3, 1.0f);
    }

    public View r(String str, com.zk_oaction.adengine.lk_interfaces.c cVar) {
        View view;
        synchronized (this) {
            this.f34946j = cVar;
            if (this.f34945i == null) {
                this.f34945i = this.f34941e.b(str, cVar);
            }
            view = this.f34945i;
        }
        return view;
    }

    public void s(boolean z) {
        try {
            com.zk_oaction.adengine.lk_sdk.b bVar = this.f34941e;
            if (bVar != null) {
                bVar.i(z);
            }
        } catch (Throwable unused) {
        }
    }

    public com.zk_oaction.adengine.lk_sdk.b t() {
        return this.f34941e;
    }

    public void u() {
        try {
            this.l = true;
            this.f34941e.c();
            x();
        } catch (Throwable unused) {
        }
    }

    public void v() {
        try {
            this.l = false;
            this.f34941e.k();
            SoundPool soundPool = this.f34942f;
            if (soundPool != null) {
                soundPool.autoPause();
            }
            y();
        } catch (Throwable unused) {
        }
    }

    public void w() {
        try {
            this.f34941e.n();
            g gVar = this.f34937a;
            if (gVar != null) {
                gVar.w();
                this.f34937a = null;
            }
            SoundPool soundPool = this.f34942f;
            if (soundPool != null) {
                soundPool.release();
                this.f34942f = null;
            }
            HashMap<String, Integer> hashMap = this.f34943g;
            if (hashMap != null) {
                hashMap.clear();
                this.f34943g = null;
            }
            y();
            com.zk_oaction.adengine.lk_sensor.b bVar = this.k;
            if (bVar != null) {
                bVar.h();
            }
            this.f34945i = null;
        } catch (Throwable unused) {
        }
    }
}
