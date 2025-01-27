package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;

/* loaded from: classes.dex */
public class bm {

    /* renamed from: a */
    private Context f9121a;

    public bm(Context context) {
        this.f9121a = context;
    }

    public static String b(String str) {
        try {
            String str2 = new String(c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2));
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.length() < 16) {
                int length = str2.length();
                StringBuilder sb = new StringBuilder(str2);
                for (int i2 = 0; i2 < 16 - length; i2++) {
                    sb.append("0");
                }
                str2 = sb.toString();
            } else if (str2.length() > 16) {
                str2 = str2.substring(0, 16);
            }
            return new String(d.b(i.a(b.b(str2.substring(0, 16), str2.substring(0, 16), c.a(str.getBytes(), 2)), str2.substring(0, 16))));
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a(String str) {
        try {
            return b(str, new String(c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2)));
        } catch (Exception unused) {
            return null;
        }
    }

    public String a(String str, String str2) {
        try {
            return c(str, new String(c.a(str2.getBytes(), 2)));
        } catch (Exception unused) {
            return null;
        }
    }

    public String b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.length() < 16) {
                int length = str2.length();
                StringBuilder sb = new StringBuilder(str2);
                for (int i2 = 0; i2 < 16 - length; i2++) {
                    sb.append("0");
                }
                str2 = sb.toString();
            } else if (str2.length() > 16) {
                str2 = str2.substring(0, 16);
            }
            byte[] a2 = c.a(str.getBytes(), 2);
            return new String(d.b(Engine.loadSuccess ? Engine.getInstance(this.f9121a).dr(Engine.getInstance(this.f9121a).dc(a2, str2.substring(0, 16).getBytes()), str2.getBytes()) : i.a(b.b(str2.substring(0, 16), str2.substring(0, 16), a2), str2.substring(0, 16))));
        } catch (Exception unused) {
            return null;
        }
    }

    public String c(String str) {
        try {
            return c(str, new String(c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2)));
        } catch (Exception unused) {
            return null;
        }
    }

    public String c(String str, String str2) {
        byte[] bArr;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str2.length() < 16) {
            int length = str2.length();
            StringBuilder sb = new StringBuilder(str2);
            for (int i2 = 0; i2 < 16 - length; i2++) {
                sb.append("0");
            }
            str2 = sb.toString();
        } else if (str2.length() > 16) {
            str2 = str2.substring(0, 16);
        }
        byte[] a2 = d.a(str.getBytes());
        if (Engine.loadSuccess) {
            bArr = Engine.getInstance(this.f9121a).ac(Engine.getInstance(this.f9121a).ar(a2, str2.getBytes()), str2.substring(0, 16).getBytes());
        } else {
            try {
                bArr = b.a(str2.substring(0, 16), str2.substring(0, 16), i.b(a2, str2));
            } catch (Throwable unused) {
                bArr = null;
            }
        }
        if (bArr != null && bArr.length > 0) {
            return c.b(bArr, 2);
        }
        return null;
    }
}
