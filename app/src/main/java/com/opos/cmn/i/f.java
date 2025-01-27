package com.opos.cmn.i;

import android.content.Context;
import android.text.TextUtils;
import java.util.UUID;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private static String f17430a = "getCryptByKey";

    /* renamed from: b */
    private static String f17431b;

    public static final String a() {
        return UUID.randomUUID().toString();
    }

    public static final String a(Context context) {
        if (!TextUtils.isEmpty(f17431b)) {
            return f17431b;
        }
        try {
            String c2 = c();
            if (TextUtils.isEmpty(c2)) {
                c2 = d();
            }
            if (TextUtils.isEmpty(c2)) {
                c2 = b();
            }
            if (TextUtils.isEmpty(c2)) {
                return "";
            }
            f17431b = c2;
            return c2;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("", "", e2);
            return "";
        }
    }

    private static final String b() {
        String a2 = l.a("sys.serialnumber");
        return TextUtils.isEmpty(a2) ? l.a("ril.serialnumber") : a2;
    }

    private static final String c() {
        return l.a("gsm.serial");
    }

    private static final String d() {
        return l.a("vendor.gsm.serial");
    }
}
