package com.martian.ttbook.b.c.a.a.b.a.d.a;

import android.content.Context;
import com.martian.ttbook.b.c.a.a.b.a.d.m;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.e.d;
import com.martian.ttbook.b.c.a.a.e.i;
import com.qumeng.advlib.api.AiClkAdManager;
import com.qumeng.advlib.core.IMultiAdObject;
import com.qumeng.advlib.core.IMultiAdRequest;
import java.util.Map;

/* loaded from: classes4.dex */
public class b extends m {

    /* renamed from: a */
    private static b f15227a;

    private b() {
    }

    public static int b(int i2) {
        if (i2 == 1 || i2 == 2) {
            return 5;
        }
        return (i2 == 4 || i2 == 9) ? 2 : 0;
    }

    public static int c(IMultiAdObject iMultiAdObject) {
        Exception e2;
        int i2;
        try {
            i2 = iMultiAdObject.getECPM();
            if (i2 <= 0) {
                try {
                    d.a("c -1 ");
                    return -1;
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    d.a("qm ecpm err " + e2.getMessage());
                    return i2;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            i2 = -1;
        }
        return i2;
    }

    private static synchronized b d() {
        b bVar;
        synchronized (b.class) {
            if (f15227a == null) {
                synchronized (b.class) {
                    if (f15227a == null) {
                        f15227a = new b();
                    }
                }
            }
            bVar = f15227a;
        }
        return bVar;
    }

    public static IMultiAdRequest e(Context context, String str) {
        n.k(context, str);
        return AiClkAdManager.getInstance().createAdRequest();
    }

    public static boolean f(e eVar, int i2) {
        if (i2 < 0) {
            return false;
        }
        return i.h(eVar, i2);
    }

    public static void g(Map<String, Object> map, int i2, e eVar) {
        d().a(map, i2, eVar);
    }
}
