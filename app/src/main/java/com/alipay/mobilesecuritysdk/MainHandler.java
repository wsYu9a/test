package com.alipay.mobilesecuritysdk;

import android.content.Context;
import android.util.Log;
import com.alipay.mobilesecuritysdk.a.a;
import com.alipay.mobilesecuritysdk.a.c;
import com.alipay.mobilesecuritysdk.a.d;
import com.alipay.mobilesecuritysdk.a.e;
import com.alipay.mobilesecuritysdk.model.Upload;
import com.alipay.mobilesecuritysdk.model.b;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
public class MainHandler {
    public int a(Context context, List<String> list, boolean z) {
        b bVar;
        List<a> e2;
        List<c> d2;
        com.alipay.mobilesecuritysdk.a.b a2;
        if (!z) {
            return 1;
        }
        b bVar2 = new b();
        Upload upload = new Upload(context);
        e eVar = new e();
        com.alipay.mobilesecuritysdk.model.a aVar = new com.alipay.mobilesecuritysdk.model.a();
        try {
            if (com.alipay.mobilesecuritysdk.c.a.j(list)) {
                if (com.alipay.mobilesecuritysdk.b.a.c()) {
                    Log.i(com.alipay.mobilesecuritysdk.constant.a.t, "tid is empty, quit!");
                }
                return 1;
            }
            long currentTimeMillis = System.currentTimeMillis();
            d i2 = bVar2.i(context.getFilesDir().getPath());
            if (i2 == null) {
                if (com.alipay.mobilesecuritysdk.b.a.c()) {
                    Log.i(com.alipay.mobilesecuritysdk.constant.a.t, "loadConfig is null");
                }
                return 1;
            }
            if (Thread.currentThread().isInterrupted()) {
                return 1;
            }
            if (com.alipay.mobilesecuritysdk.c.a.l(i2.h(), 86400000L, i2.g()) && (a2 = upload.a()) != null && a2.f()) {
                if (!com.alipay.mobilesecuritysdk.c.a.i(a2.e())) {
                    if (com.alipay.mobilesecuritysdk.b.a.c()) {
                        Log.i(com.alipay.mobilesecuritysdk.constant.a.t, "main switch updated.");
                    }
                    if (com.alipay.mobilesecuritysdk.c.a.h(a2.e(), com.alipay.mobilesecuritysdk.constant.a.f5218i)) {
                        i2.q(com.alipay.mobilesecuritysdk.constant.a.f5218i);
                    } else {
                        i2.q(com.alipay.mobilesecuritysdk.constant.a.f5219j);
                    }
                }
                i2.p(currentTimeMillis);
                bVar2.k(i2, String.valueOf(context.getFilesDir().getPath()) + File.separator + com.alipay.mobilesecuritysdk.constant.a.l);
            }
            if (Thread.currentThread().isInterrupted()) {
                return 1;
            }
            if (!com.alipay.mobilesecuritysdk.c.a.h(com.alipay.mobilesecuritysdk.constant.a.f5218i, i2.i())) {
                if (com.alipay.mobilesecuritysdk.b.a.c()) {
                    Log.i(com.alipay.mobilesecuritysdk.constant.a.t, "main switch is off, quit!");
                }
                return 0;
            }
            if (com.alipay.mobilesecuritysdk.c.a.l(i2.e(), 60000L, i2.d()) && (d2 = aVar.d(context)) != null && d2.size() > 0) {
                if (com.alipay.mobilesecuritysdk.b.a.c()) {
                    Log.i(com.alipay.mobilesecuritysdk.constant.a.t, "location collected.");
                }
                eVar.e(d2);
                i2.m(currentTimeMillis);
            }
            if (Thread.currentThread().isInterrupted()) {
                return 1;
            }
            if (com.alipay.mobilesecuritysdk.c.a.l(i2.b(), 86400000L, i2.a()) && (e2 = aVar.e(context)) != null && e2.size() > 0) {
                if (com.alipay.mobilesecuritysdk.b.a.c()) {
                    Log.i(com.alipay.mobilesecuritysdk.constant.a.t, "app info collected.");
                }
                eVar.d(e2);
                i2.k(currentTimeMillis);
            }
            if (Thread.currentThread().isInterrupted()) {
                return 1;
            }
            upload.c(eVar);
            com.alipay.mobilesecuritysdk.a.b e3 = upload.e(list, i2);
            if (e3 == null || !e3.f()) {
                bVar = bVar2;
            } else {
                if (com.alipay.mobilesecuritysdk.b.a.c()) {
                    Log.i(com.alipay.mobilesecuritysdk.constant.a.t, "data have been upload.");
                }
                if (e3.d() > 0) {
                    i2.o(e3.d());
                }
                if (e3.b() > 0) {
                    i2.l(e3.b());
                }
                if (e3.a() > 0) {
                    i2.j(e3.a());
                }
                if (e3.c() > 0) {
                    i2.n(e3.c());
                }
                bVar = bVar2;
                bVar.h(context.getFilesDir().getPath());
            }
            bVar.k(i2, String.valueOf(context.getFilesDir().getPath()) + File.separator + com.alipay.mobilesecuritysdk.constant.a.l);
            return 0;
        } catch (Exception unused) {
            return 1;
        }
    }
}
