package bh;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes4.dex */
public final class c extends j {

    /* renamed from: b */
    public final String f1610b;

    /* renamed from: c */
    public final boolean f1611c;

    public c(String str, boolean z10) {
        this.f1610b = str;
        this.f1611c = z10;
    }

    public static String q(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
        }
        sb2.append("[\"" + str2 + "\"]");
        return sb2.toString();
    }

    @Override // bh.j, bh.b
    public final void a(String str, Throwable th2, String str2) {
        if (this.f1611c) {
            Log.d(this.f1610b, q(str, str2), th2);
        }
    }

    @Override // bh.j, bh.b
    public final void b(String str, Throwable th2, String str2) {
        Log.i(this.f1610b, q(str, str2), th2);
    }

    @Override // bh.j, bh.b
    public final void c(String str, Throwable th2, String str2) {
        Log.e(this.f1610b, q(str, str2), th2);
    }

    @Override // bh.j, bh.b
    public final void d(String str, String str2) {
        Log.e(this.f1610b, q(str, str2));
    }

    @Override // bh.j, bh.b
    public final void e(String str, Throwable th2, String str2, Object... objArr) {
        if (this.f1611c) {
            Log.d(this.f1610b, q(str, String.format(str2, objArr)), th2);
        }
    }

    @Override // bh.j, bh.b
    public final void f(String str, String str2) {
        if (this.f1611c) {
            Log.d(this.f1610b, q(str, str2));
        }
    }

    @Override // bh.j, bh.b
    public final void g(String str, Throwable th2, String str2) {
        Log.w(this.f1610b, q(str, str2), th2);
    }

    @Override // bh.j, bh.b
    public final void h(String str, String str2, Object... objArr) {
        if (this.f1611c) {
            Log.d(this.f1610b, q(str, String.format(str2, objArr)));
        }
    }

    @Override // bh.j, bh.b
    public final void i(String str, String str2, Object... objArr) {
        Log.i(this.f1610b, q(str, String.format(str2, objArr)));
    }

    @Override // bh.j, bh.b
    public final void j(String str, String str2) {
        Log.w(this.f1610b, q(str, str2));
    }

    @Override // bh.j, bh.b
    public final void k(String str, String str2) {
        Log.i(this.f1610b, q(str, str2));
    }

    @Override // bh.j, bh.b
    public final void l(String str, Throwable th2, String str2, Object... objArr) {
        Log.w(this.f1610b, q(str, String.format(str2, objArr)), th2);
    }

    @Override // bh.j, bh.b
    public final void m(String str, String str2, Object... objArr) {
        Log.e(this.f1610b, q(str, String.format(str2, objArr)));
    }

    @Override // bh.j, bh.b
    public final void n(String str, Throwable th2, String str2, Object... objArr) {
        Log.i(this.f1610b, q(str, String.format(str2, objArr)), th2);
    }

    @Override // bh.j, bh.b
    public final void o(String str, Throwable th2, String str2, Object... objArr) {
        Log.e(this.f1610b, q(str, String.format(str2, objArr)), th2);
    }

    @Override // bh.j, bh.b
    public final void p(String str, String str2, Object... objArr) {
        Log.w(this.f1610b, q(str, String.format(str2, objArr)));
    }
}
