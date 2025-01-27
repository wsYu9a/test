package com.ta.utdid2.a;

import android.content.Context;
import android.util.Log;
import b.i.a.a.a.f;
import b.i.a.a.a.i;
import b.i.a.a.a.j;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static a f24531a = null;

    /* renamed from: b */
    private static final String f24532b = "com.ta.utdid2.a.a";

    /* renamed from: c */
    private Context f24533c;

    private a(Context context) {
        this.f24533c = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f24531a == null) {
                f24531a = new a(context);
            }
            aVar = f24531a;
        }
        return aVar;
    }

    private synchronized String d(String str, String str2, String str3) {
        Context context = this.f24533c;
        if (context == null) {
            Log.e(f24532b, "no context!");
            return "";
        }
        String f2 = f.b(context) ? b.b(this.f24533c).f(str, str2, str3, c.b(this.f24533c, str, str2)) : "";
        c.c(this.f24533c, str, f2, str2);
        return f2;
    }

    public String b(String str, String str2, String str3) {
        if (this.f24533c != null && !i.b(str) && !i.b(str2)) {
            String b2 = c.b(this.f24533c, str, str2);
            return ((i.b(b2) || !j.a(c.a(this.f24533c, str, str2), 1)) && f.b(this.f24533c)) ? d(str, str2, str3) : b2;
        }
        String str4 = f24532b;
        StringBuilder sb = new StringBuilder("mContext:");
        sb.append(this.f24533c);
        sb.append("; has appName:");
        sb.append(!i.b(str));
        sb.append("; has token:");
        sb.append(!i.b(str2));
        Log.e(str4, sb.toString());
        return "";
    }

    public void c(String str, String str2, String str3, b.j.a.b bVar) {
        if (bVar == null) {
            Log.e(f24532b, "callback is null!");
            return;
        }
        if (this.f24533c != null && !i.b(str) && !i.b(str2)) {
            String b2 = c.b(this.f24533c, str, str2);
            if (!i.b(b2) && j.a(c.a(this.f24533c, str, str2), 1)) {
                bVar.a(1001, b2);
                return;
            } else if (f.b(this.f24533c)) {
                b.b(this.f24533c).g(str, str2, str3, b2, bVar);
                return;
            } else {
                bVar.a(1003, b2);
                return;
            }
        }
        String str4 = f24532b;
        StringBuilder sb = new StringBuilder("mContext:");
        sb.append(this.f24533c);
        sb.append("; callback:");
        sb.append(bVar);
        sb.append("; has appName:");
        sb.append(!i.b(str));
        sb.append("; has token:");
        sb.append(!i.b(str2));
        Log.e(str4, sb.toString());
        bVar.a(1002, "");
    }
}
