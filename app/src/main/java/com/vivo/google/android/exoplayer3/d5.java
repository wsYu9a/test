package com.vivo.google.android.exoplayer3;

import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class d5 {

    /* renamed from: a */
    public static final Pattern f27295a;

    static {
        Pattern.compile("^NOTE(( |\t).*)?$");
        f27295a = Pattern.compile("^\ufeff?WEBVTT(( |\t).*)?$");
    }

    public static float a(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static void a(n6 n6Var) {
        String d2 = n6Var.d();
        if (d2 == null || !f27295a.matcher(d2).matches()) {
            throw new a4("Expected WEBVTT. Got " + d2);
        }
    }

    public static long b(String str) {
        String[] split = str.split("\\.", 2);
        long j2 = 0;
        for (String str2 : split[0].split(":")) {
            j2 = (j2 * 60) + Long.parseLong(str2);
        }
        return ((j2 * 1000) + Long.parseLong(split[1])) * 1000;
    }
}
