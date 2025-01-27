package com.alipay.sdk.util;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class a {
    public static String[] a(String str) {
        int indexOf = str.indexOf(40) + 1;
        int lastIndexOf = str.lastIndexOf(41);
        if (indexOf == 0 || lastIndexOf == -1) {
            return null;
        }
        String[] split = str.substring(indexOf, lastIndexOf).split(",");
        if (split != null) {
            for (int i2 = 0; i2 < split.length; i2++) {
                if (!TextUtils.isEmpty(split[i2])) {
                    split[i2] = split[i2].trim();
                    split[i2] = split[i2].replaceAll("'", "").replaceAll("\"", "");
                }
            }
        }
        return split;
    }

    private static void b(String str) {
        String[] a2 = a(str);
        if (a2.length == 3 && TextUtils.equals(b.b.a.b.b.f4200c, a2[0])) {
            Context context = b.b.a.f.a.a().f4274b;
            com.alipay.sdk.tid.b a3 = com.alipay.sdk.tid.b.a();
            if (TextUtils.isEmpty(a2[1]) || TextUtils.isEmpty(a2[2])) {
                return;
            }
            a3.f5438b = a2[1];
            a3.f5439c = a2[2];
            com.alipay.sdk.tid.a aVar = new com.alipay.sdk.tid.a(context);
            try {
                aVar.f(c.a(context).b(), c.a(context).e(), a3.f5438b, a3.f5439c);
            } catch (Exception unused) {
            } finally {
                aVar.close();
            }
        }
    }
}
