package com.ta.utdid2.device;

import android.content.Context;
import b.i.a.a.a.g;
import b.i.a.a.a.i;
import java.util.zip.Adler32;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static b f24564a = null;

    /* renamed from: b */
    static String f24565b = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";

    /* renamed from: c */
    static final Object f24566c = new Object();

    static long a(b bVar) {
        if (bVar == null) {
            return 0L;
        }
        String format = String.format("%s%s%s%s%s", bVar.j(), bVar.k(), Long.valueOf(bVar.a()), bVar.h(), bVar.f());
        if (i.b(format)) {
            return 0L;
        }
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(format.getBytes());
        return adler32.getValue();
    }

    private static b b(Context context) {
        if (context == null) {
            return null;
        }
        new b();
        synchronized (f24566c) {
            String i2 = c.a(context).i();
            if (i.b(i2)) {
                return null;
            }
            if (i2.endsWith("\n")) {
                i2 = i2.substring(0, i2.length() - 1);
            }
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            String a2 = g.a(context);
            String b2 = g.b(context);
            bVar.g(a2);
            bVar.d(a2);
            bVar.c(currentTimeMillis);
            bVar.e(b2);
            bVar.i(i2);
            bVar.b(a(bVar));
            return bVar;
        }
    }

    public static synchronized b c(Context context) {
        synchronized (d.class) {
            b bVar = f24564a;
            if (bVar != null) {
                return bVar;
            }
            if (context == null) {
                return null;
            }
            b b2 = b(context);
            f24564a = b2;
            return b2;
        }
    }
}
