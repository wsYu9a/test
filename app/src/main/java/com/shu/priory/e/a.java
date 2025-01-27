package com.shu.priory.e;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.shu.priory.config.AdError;
import com.shu.priory.config.AdKeys;
import com.shu.priory.config.ErrorCode;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.conn.NativeDataRef;
import com.shu.priory.listener.IFLYBaseAdListener;
import com.shu.priory.utils.c;
import com.shu.priory.utils.e;
import com.shu.priory.utils.h;

/* loaded from: classes3.dex */
public class a extends com.shu.priory.b.b<NativeDataRef> {

    /* renamed from: f */
    private IFLYBaseAdListener<NativeDataRef> f17029f;

    /* renamed from: g */
    private boolean f17030g;

    /* renamed from: h */
    private volatile boolean f17031h;

    /* renamed from: i */
    private volatile boolean f17032i;

    /* renamed from: j */
    private int f17033j;

    /* renamed from: com.shu.priory.e.a$1 */
    public class AnonymousClass1 extends Thread {
        public AnonymousClass1() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(a.this.f17033j);
            if (a.this.f17032i) {
                return;
            }
            a.this.c();
        }
    }

    public a(Context context, String str, IFLYBaseAdListener<NativeDataRef> iFLYBaseAdListener) {
        super(context, str);
        this.f17033j = 800;
        this.f17029f = iFLYBaseAdListener;
        this.f16823e.a(iFLYBaseAdListener);
        int a10 = e.a(context, "KEY_FUSE_TIME");
        if (a10 > 0) {
            this.f17033j = a10;
        }
    }

    public void c() {
        String c10 = c.a(this.f16820b).c(this.f16822d);
        if (TextUtils.isEmpty(c10)) {
            return;
        }
        try {
            this.f16821c.a(c10, true);
            this.f16823e.a(0, new b(this.f16820b, this.f16821c, this.f16819a, this.f17029f));
            this.f17031h = true;
            h.a(SDKConstants.TAG, "use default cache");
        } catch (Exception e10) {
            h.a(SDKConstants.TAG, "read default cache error " + e10);
        }
    }

    @Override // com.shu.priory.b.b
    public synchronized void b() {
        this.f17031h = false;
        this.f17032i = false;
        String b10 = c.a(this.f16820b).b(this.f16822d);
        h.a(SDKConstants.TAG, "read cache: " + b10);
        if (TextUtils.isEmpty(b10)) {
            new Thread() { // from class: com.shu.priory.e.a.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    SystemClock.sleep(a.this.f17033j);
                    if (a.this.f17032i) {
                        return;
                    }
                    a.this.c();
                }
            }.start();
        } else {
            try {
                this.f16821c.a(b10, false);
                this.f16823e.a(0, new b(this.f16820b, this.f16821c, this.f16819a, this.f17029f));
                this.f17031h = true;
            } catch (Exception e10) {
                h.a(SDKConstants.TAG, "read cache error " + e10);
            }
        }
        this.f17030g = this.f16819a.getBooleanParam(AdKeys.DEBUG_MODE);
        super.b();
    }

    @Override // com.shu.priory.b.b
    public void a() {
        this.f17032i = true;
        try {
            Context context = this.f16820b;
            if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                this.f16823e.a(1, new AdError(ErrorCode.ERROR_ACTIVITY_FINISH));
                if (this.f17030g) {
                    h.a(SDKConstants.TAG, "activity is finishing");
                    return;
                }
                return;
            }
            com.shu.priory.g.b bVar = this.f16821c;
            if (70200 != bVar.f17100a || bVar.f17105f == null) {
                if (!this.f17031h) {
                    c();
                }
                if (!this.f17031h) {
                    this.f16823e.a(1, new AdError(this.f16821c.f17100a));
                }
            } else {
                this.f17032i = true;
                if (!this.f17031h) {
                    this.f16823e.a(0, new b(this.f16820b, this.f16821c, this.f16819a, this.f17029f));
                }
                h.a(SDKConstants.TAG, "cache time " + this.f16821c.f17105f.P);
                if (this.f16821c.f17105f.P > 0) {
                    c a10 = c.a(this.f16820b);
                    String str = this.f16822d;
                    String b10 = this.f16821c.b();
                    com.shu.priory.g.b bVar2 = this.f16821c;
                    a10.a(str, b10, bVar2.f17102c, bVar2.f17105f.P, false);
                }
                if (!TextUtils.isEmpty(this.f16821c.f17113n)) {
                    h.a(SDKConstants.TAG, "update default ad");
                    c.a(this.f16820b).a(this.f16822d, this.f16821c.f17113n, "", Integer.MAX_VALUE, true);
                    e.a(this.f16820b, this.f16822d + "update_ts", System.currentTimeMillis());
                }
            }
            com.shu.priory.d.h.a(this.f16820b).c();
        } catch (Throwable th2) {
            this.f16823e.a(1, new AdError(ErrorCode.ERROR_NETWORK));
            h.d(SDKConstants.TAG, th2.getMessage());
        }
    }
}
