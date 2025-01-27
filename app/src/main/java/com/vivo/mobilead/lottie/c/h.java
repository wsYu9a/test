package com.vivo.mobilead.lottie.c;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: c */
    private static String f29398c = "\r";

    /* renamed from: a */
    public final float f29399a;

    /* renamed from: b */
    public final float f29400b;

    /* renamed from: d */
    private final String f29401d;

    public h(String str, float f2, float f3) {
        this.f29401d = str;
        this.f29400b = f3;
        this.f29399a = f2;
    }

    public boolean a(String str) {
        if (this.f29401d.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f29401d.endsWith(f29398c)) {
            String str2 = this.f29401d;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
