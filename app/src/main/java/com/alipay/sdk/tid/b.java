package com.alipay.sdk.tid;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.util.c;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    private static b f5437a;

    /* renamed from: b */
    public String f5438b;

    /* renamed from: c */
    public String f5439c;

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f5437a == null) {
                f5437a = new b();
                Context context = b.b.a.f.a.a().f4274b;
                a aVar = new a(context);
                String b2 = c.a(context).b();
                String e2 = c.a(context).e();
                f5437a.f5438b = aVar.h(b2, e2);
                f5437a.f5439c = aVar.j(b2, e2);
                if (TextUtils.isEmpty(f5437a.f5439c)) {
                    b bVar2 = f5437a;
                    String hexString = Long.toHexString(System.currentTimeMillis());
                    if (hexString.length() > 10) {
                        hexString = hexString.substring(hexString.length() - 10);
                    }
                    bVar2.f5439c = hexString;
                }
                b bVar3 = f5437a;
                aVar.f(b2, e2, bVar3.f5438b, bVar3.f5439c);
            }
            bVar = f5437a;
        }
        return bVar;
    }

    private void b(Context context) {
        a aVar = new a(context);
        try {
            aVar.f(c.a(context).b(), c.a(context).e(), this.f5438b, this.f5439c);
        } catch (Exception unused) {
        } finally {
            aVar.close();
        }
    }

    private void c(String str) {
        this.f5438b = str;
    }

    private String d() {
        return this.f5438b;
    }

    private void e(String str) {
        this.f5439c = str;
    }

    private String f() {
        return this.f5439c;
    }

    private boolean g() {
        return TextUtils.isEmpty(this.f5438b);
    }

    private static void h() {
        Context context = b.b.a.f.a.a().f4274b;
        String b2 = c.a(context).b();
        String e2 = c.a(context).e();
        a aVar = new a(context);
        aVar.e(b2, e2);
        aVar.close();
    }

    private static String i() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }
}
