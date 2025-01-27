package e3;

import a3.f;
import android.content.Context;
import java.util.zip.Adler32;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    public static b f25602a;

    /* renamed from: b */
    public static final Object f25603b = new Object();

    public static long a(b bVar) {
        if (bVar == null) {
            return 0L;
        }
        String format = String.format("%s%s%s%s%s", bVar.g(), bVar.i(), Long.valueOf(bVar.a()), bVar.k(), bVar.d());
        if (f.b(format)) {
            return 0L;
        }
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(format.getBytes());
        return adler32.getValue();
    }

    public static b b(Context context) {
        if (context == null) {
            return null;
        }
        synchronized (f25603b) {
            try {
                String e10 = com.alipay.sdk.m.n0.d.a(context).e();
                if (f.b(e10)) {
                    return null;
                }
                if (e10.endsWith("\n")) {
                    e10 = e10.substring(0, e10.length() - 1);
                }
                b bVar = new b();
                long currentTimeMillis = System.currentTimeMillis();
                String b10 = a3.d.b(context);
                String d10 = a3.d.d(context);
                bVar.h(b10);
                bVar.c(b10);
                bVar.e(currentTimeMillis);
                bVar.f(d10);
                bVar.j(e10);
                bVar.b(a(bVar));
                return bVar;
            } finally {
            }
        }
    }

    public static synchronized b c(Context context) {
        synchronized (c.class) {
            b bVar = f25602a;
            if (bVar != null) {
                return bVar;
            }
            if (context == null) {
                return null;
            }
            b b10 = b(context);
            f25602a = b10;
            return b10;
        }
    }
}
