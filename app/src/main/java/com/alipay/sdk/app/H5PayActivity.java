package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import h3.e;
import java.lang.ref.WeakReference;
import n3.a;
import p3.d;
import p3.k;
import r3.c;
import v2.b;

/* loaded from: classes.dex */
public class H5PayActivity extends Activity {

    /* renamed from: b */
    public c f6493b;

    /* renamed from: c */
    public String f6494c;

    /* renamed from: d */
    public String f6495d;

    /* renamed from: e */
    public String f6496e;

    /* renamed from: f */
    public String f6497f;

    /* renamed from: g */
    public boolean f6498g;

    /* renamed from: h */
    public String f6499h;

    /* renamed from: i */
    public WeakReference<a> f6500i;

    public void a() {
        Object obj = PayTask.f6529h;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
    }

    public final void b() {
        try {
            super.requestWindowFeature(1);
            getWindow().addFlags(8192);
        } catch (Throwable th2) {
            d.e(th2);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        a();
        super.finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1010) {
            v2.c.a((a) k.f(this.f6500i), i10, i11, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        c cVar = this.f6493b;
        if (cVar == null) {
            finish();
            return;
        }
        if (cVar.m()) {
            cVar.n();
            return;
        }
        if (!cVar.n()) {
            super.onBackPressed();
        }
        b.c(b.a());
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        b();
        super.onCreate(bundle);
        try {
            a a10 = a.C0746a.a(getIntent());
            if (a10 == null) {
                finish();
                return;
            }
            this.f6500i = new WeakReference<>(a10);
            if (b3.a.J().F()) {
                setRequestedOrientation(3);
            } else {
                setRequestedOrientation(1);
            }
            try {
                Bundle extras = getIntent().getExtras();
                String string = extras.getString("url", null);
                this.f6494c = string;
                if (!k.Y(string)) {
                    finish();
                    return;
                }
                this.f6496e = extras.getString("cookie", null);
                this.f6495d = extras.getString(e.f26414s, null);
                this.f6497f = extras.getString("title", null);
                this.f6499h = extras.getString("version", c.f30241d);
                this.f6498g = extras.getBoolean("backisexit", false);
                try {
                    r3.d dVar = new r3.d(this, a10, this.f6499h);
                    setContentView(dVar);
                    dVar.r(this.f6497f, this.f6495d, this.f6498g);
                    dVar.l(this.f6494c, this.f6496e);
                    dVar.k(this.f6494c);
                    this.f6493b = dVar;
                } catch (Throwable th2) {
                    x2.a.e(a10, x2.b.f31789l, "GetInstalledAppEx", th2);
                    finish();
                }
            } catch (Exception unused) {
                finish();
            }
        } catch (Exception unused2) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.f6493b;
        if (cVar != null) {
            cVar.o();
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i10) {
        try {
            super.setRequestedOrientation(i10);
        } catch (Throwable th2) {
            try {
                x2.a.e((a) k.f(this.f6500i), x2.b.f31789l, x2.b.B, th2);
            } catch (Throwable unused) {
            }
        }
    }
}
