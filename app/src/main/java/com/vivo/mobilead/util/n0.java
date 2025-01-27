package com.vivo.mobilead.util;

import android.net.Uri;
import android.os.Bundle;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
public class n0 {

    /* renamed from: f */
    private static String f30742f = "SdCardUtils";

    /* renamed from: a */
    private int f30743a;

    /* renamed from: b */
    private int f30744b;

    /* renamed from: c */
    private int f30745c;

    /* renamed from: d */
    private int f30746d;

    /* renamed from: e */
    private int f30747e;

    class a implements Callable<String> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            return n0.this.a();
        }
    }

    private static class b {

        /* renamed from: a */
        private static final n0 f30749a = new n0(null);
    }

    /* synthetic */ n0(m0 m0Var) {
        this();
    }

    public static n0 b() {
        return b.f30749a;
    }

    public void c(int i2) {
        if (i2 == -1) {
            return;
        }
        this.f30747e = i2;
    }

    public void d(int i2) {
        if (i2 == -1) {
            return;
        }
        this.f30745c = i2;
    }

    public void e(int i2) {
        if (i2 == -1) {
            return;
        }
        this.f30746d = i2;
    }

    public void f(int i2) {
        if (i2 == -1) {
            return;
        }
        this.f30744b = i2;
    }

    public void g(int i2) {
    }

    private n0() {
        this.f30743a = 50;
        this.f30744b = 10;
        this.f30745c = 20;
        this.f30746d = 20;
        this.f30747e = 20;
    }

    public String a(int i2) {
        try {
            Future a2 = a1.a(new a());
            return i2 != 9 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? (String) a2.get(this.f30744b, TimeUnit.MILLISECONDS) : (String) a2.get(this.f30746d, TimeUnit.MILLISECONDS) : (String) a2.get(this.f30745c, TimeUnit.MILLISECONDS) : (String) a2.get(this.f30743a, TimeUnit.MILLISECONDS) : (String) a2.get(this.f30744b, TimeUnit.MILLISECONDS) : (String) a2.get(this.f30747e, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            x0.b(f30742f, "readAppInstallStatusInMain failed: " + e2.getMessage());
            return "";
        } catch (ExecutionException e3) {
            x0.b(f30742f, "readAppInstallStatusInMain failed: " + e3.getMessage());
            return "";
        } catch (TimeoutException e4) {
            x0.b(f30742f, "readAppInstallStatusInMain failed: " + e4.getMessage());
            return "";
        }
    }

    public void b(int i2) {
        if (i2 == -1) {
            return;
        }
        this.f30743a = i2;
    }

    public String a() {
        if (com.vivo.mobilead.manager.f.j().c() == null) {
            return "";
        }
        try {
            Bundle call = com.vivo.mobilead.manager.f.j().c().getContentResolver().call(Uri.parse("content://com.bbk.appstore.provider.appstatus"), "requestAppInfo", (String) null, (Bundle) null);
            return call != null ? call.getString("appInfoValue") : "";
        } catch (Exception unused) {
            x0.b(f30742f, "get app install status failed!");
            return "";
        }
    }
}
