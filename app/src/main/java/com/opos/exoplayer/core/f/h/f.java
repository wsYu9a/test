package com.opos.exoplayer.core.f.h;

import com.opos.exoplayer.core.i.m;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a */
    private static final Pattern f18801a = Pattern.compile("^NOTE(( |\t).*)?$");

    /* renamed from: b */
    private static final Pattern f18802b = Pattern.compile("^\ufeff?WEBVTT(( |\t).*)?$");

    public static long a(String str) {
        String[] split = str.split("\\.", 2);
        long j2 = 0;
        for (String str2 : split[0].split(":")) {
            j2 = (j2 * 60) + Long.parseLong(str2);
        }
        long j3 = j2 * 1000;
        if (split.length == 2) {
            j3 += Long.parseLong(split[1]);
        }
        return j3 * 1000;
    }

    public static void a(m mVar) {
        String z = mVar.z();
        if (z == null || !f18802b.matcher(z).matches()) {
            throw new com.opos.exoplayer.core.f.f("Expected WEBVTT. Got " + z);
        }
    }

    public static float b(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }
}
