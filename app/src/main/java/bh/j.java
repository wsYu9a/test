package bh;

import android.util.Log;

/* loaded from: classes4.dex */
public class j implements b {

    /* renamed from: a */
    public b f1630a = null;

    @Override // bh.b
    public void a(String str, Throwable th2, String str2) {
        b bVar = this.f1630a;
        if (bVar != null) {
            bVar.a(str, th2, str2);
        } else {
            Log.d(str, str2, th2);
        }
    }

    @Override // bh.b
    public void b(String str, Throwable th2, String str2) {
        b bVar = this.f1630a;
        if (bVar != null) {
            bVar.b(str, th2, str2);
        } else {
            Log.i(str, str2, th2);
        }
    }

    @Override // bh.b
    public void c(String str, Throwable th2, String str2) {
        b bVar = this.f1630a;
        if (bVar != null) {
            bVar.c(str, th2, str2);
        } else {
            Log.e(str, str2, th2);
        }
    }

    @Override // bh.b
    public void d(String str, String str2) {
        b bVar = this.f1630a;
        if (bVar != null) {
            bVar.d(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    @Override // bh.b
    public void e(String str, Throwable th2, String str2, Object... objArr) {
        b bVar = this.f1630a;
        if (bVar != null) {
            bVar.e(str, th2, str2, objArr);
        } else {
            Log.d(str, String.format(str2, objArr), th2);
        }
    }

    @Override // bh.b
    public void f(String str, String str2) {
        b bVar = this.f1630a;
        if (bVar != null) {
            bVar.f(str, str2);
        } else {
            Log.d(str, str2);
        }
    }

    @Override // bh.b
    public void g(String str, Throwable th2, String str2) {
        b bVar = this.f1630a;
        if (bVar != null) {
            bVar.g(str, th2, str2);
        } else {
            Log.w(str, str2, th2);
        }
    }

    @Override // bh.b
    public void h(String str, String str2, Object... objArr) {
        b bVar = this.f1630a;
        if (bVar != null) {
            bVar.h(str, str2, objArr);
        } else {
            Log.d(str, String.format(str2, objArr));
        }
    }

    @Override // bh.b
    public void i(String str, String str2, Object... objArr) {
        b bVar = this.f1630a;
        if (bVar != null) {
            bVar.i(str, str2, objArr);
        } else {
            Log.i(str, String.format(str2, objArr));
        }
    }

    @Override // bh.b
    public void j(String str, String str2) {
        b bVar = this.f1630a;
        if (bVar != null) {
            bVar.j(str, str2);
        } else {
            Log.w(str, str2);
        }
    }

    @Override // bh.b
    public void k(String str, String str2) {
        b bVar = this.f1630a;
        if (bVar != null) {
            bVar.k(str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    @Override // bh.b
    public void l(String str, Throwable th2, String str2, Object... objArr) {
        b bVar = this.f1630a;
        if (bVar != null) {
            bVar.l(str, th2, str2, objArr);
        } else {
            Log.w(str, String.format(str2, objArr), th2);
        }
    }

    @Override // bh.b
    public void m(String str, String str2, Object... objArr) {
        b bVar = this.f1630a;
        if (bVar != null) {
            bVar.m(str, str2, objArr);
        } else {
            Log.e(str, String.format(str2, objArr));
        }
    }

    @Override // bh.b
    public void n(String str, Throwable th2, String str2, Object... objArr) {
        b bVar = this.f1630a;
        if (bVar != null) {
            bVar.n(str, th2, str2, objArr);
        } else {
            Log.i(str, String.format(str2, objArr), th2);
        }
    }

    @Override // bh.b
    public void o(String str, Throwable th2, String str2, Object... objArr) {
        b bVar = this.f1630a;
        if (bVar != null) {
            bVar.o(str, th2, str2, objArr);
        } else {
            Log.e(str, String.format(str2, objArr), th2);
        }
    }

    @Override // bh.b
    public void p(String str, String str2, Object... objArr) {
        b bVar = this.f1630a;
        if (bVar != null) {
            bVar.p(str, str2, objArr);
        } else {
            Log.w(str, String.format(str2, objArr));
        }
    }
}
