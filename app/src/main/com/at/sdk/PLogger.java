package com.at.sdk;

import android.util.Log;
import androidx.annotation.Keep;
import bh.b;

@Keep
/* loaded from: classes.dex */
public class PLogger {
    @Keep
    public void d(String str, String str2) {
        b.a.f1609b.f(str, str2);
    }

    @Keep
    public void e(String str, String str2) {
        b.a.f1609b.d(str, str2);
    }

    @Keep
    public void i(String str, String str2) {
        b.a.f1609b.k(str, str2);
    }

    @Keep
    public void w(String str, String str2) {
        b.a.f1609b.j(str, str2);
    }

    @Keep
    public void d(String str, String str2, Object... objArr) {
        b.a.f1609b.h(str, str2, objArr);
    }

    @Keep
    public void e(String str, String str2, Object... objArr) {
        b.a.f1609b.m(str, str2, objArr);
    }

    @Keep
    public void i(String str, String str2, Object... objArr) {
        b.a.f1609b.i(str, str2, objArr);
    }

    @Keep
    public void w(String str, String str2, Object... objArr) {
        b bVar = b.a.f1609b.f1630a;
        if (bVar != null) {
            bVar.p(str, str2, objArr);
        } else {
            Log.w(str, String.format(str2, objArr));
        }
    }

    @Keep
    public void d(String str, Throwable th2, String str2) {
        b.a.f1609b.a(str, th2, str2);
    }

    @Keep
    public void e(String str, Throwable th2, String str2) {
        b.a.f1609b.c(str, th2, str2);
    }

    @Keep
    public void i(String str, Throwable th2, String str2, Object... objArr) {
        b.a.f1609b.n(str, th2, str2, objArr);
    }

    @Keep
    public void w(String str, Throwable th2, String str2) {
        b bVar = b.a.f1609b.f1630a;
        if (bVar != null) {
            bVar.g(str, th2, str2);
        } else {
            Log.w(str, str2, th2);
        }
    }

    @Keep
    public void d(String str, Throwable th2, String str2, Object... objArr) {
        b bVar = b.a.f1609b.f1630a;
        if (bVar != null) {
            bVar.e(str, th2, str2, objArr);
        } else {
            Log.d(str, String.format(str2, objArr), th2);
        }
    }

    @Keep
    public void e(String str, Throwable th2, String str2, Object... objArr) {
        b.a.f1609b.o(str, th2, str2, objArr);
    }

    @Keep
    public void i(String str, Throwable th2, String str2) {
        b bVar = b.a.f1609b.f1630a;
        if (bVar != null) {
            bVar.b(str, th2, str2);
        } else {
            Log.i(str, str2, th2);
        }
    }

    @Keep
    public void w(String str, Throwable th2, String str2, Object... objArr) {
        b bVar = b.a.f1609b.f1630a;
        if (bVar != null) {
            bVar.l(str, th2, str2, objArr);
        } else {
            Log.w(str, String.format(str2, objArr), th2);
        }
    }
}
