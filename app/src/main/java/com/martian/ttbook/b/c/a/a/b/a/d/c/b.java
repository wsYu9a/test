package com.martian.ttbook.b.c.a.a.b.a.d.c;

import android.app.Activity;
import android.content.Context;
import com.martian.ttbook.b.c.a.a.b.a.d.m;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.e.i;
import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.unified.IBidding;
import com.vivo.mobilead.unified.base.AdParams;
import java.util.Map;

/* loaded from: classes4.dex */
public class b extends m {

    /* renamed from: a */
    private static b f15353a;

    private b() {
    }

    public static int b(com.martian.ttbook.b.c.a.a.c.q.b bVar) {
        if (bVar == null) {
            return 0;
        }
        int a2 = bVar.a();
        int i2 = 1;
        if (a2 != 1) {
            i2 = 2;
            if (a2 != 2) {
                return 0;
            }
        }
        return i2;
    }

    public static int c(IBidding iBidding) {
        if (iBidding != null) {
            return iBidding.getPrice();
        }
        return -1;
    }

    public static Activity d(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public static synchronized b e() {
        b bVar;
        synchronized (b.class) {
            if (f15353a == null) {
                synchronized (b.class) {
                    if (f15353a == null) {
                        f15353a = new b();
                    }
                }
            }
            bVar = f15353a;
        }
        return bVar;
    }

    public static AdParams.Builder f(e eVar) {
        if (eVar != null) {
            return g(eVar.f15701c.l(e.c.Q));
        }
        return null;
    }

    public static AdParams.Builder g(String str) {
        AdParams.Builder builder = new AdParams.Builder(str);
        builder.setBackUrlInfo(new BackUrlInfo("vivobrowser://browser.vivo.com", "Test btnName"));
        return builder;
    }

    public static void h(Object obj, int i2) {
        com.martian.ttbook.b.c.a.a.e.d.a("ks send failed end");
        if (obj instanceof IBidding) {
            ((IBidding) obj).sendLossNotification(1, i2);
        }
    }

    public static boolean i(e eVar, int i2) {
        if (i2 <= 0) {
            return false;
        }
        return i.h(eVar, i2);
    }

    public static void j(Object obj, int i2) {
        com.martian.ttbook.b.c.a.a.e.d.a("ks send success end");
        if (obj instanceof IBidding) {
            ((IBidding) obj).sendWinNotification(0);
        }
    }

    public static void k(Map<String, Object> map, int i2, e eVar) {
        e().a(map, i2, eVar);
    }
}
