package com.jd.ad.sdk.jad_kt;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: classes2.dex */
public final class jad_jt {
    @NonNull
    public static <T> T jad_an(@Nullable T t10) {
        t10.getClass();
        return t10;
    }

    public static String jad_an(Throwable th2) {
        for (Throwable th3 = th2; th3 != null; th3 = th3.getCause()) {
            if (th3 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th2.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static boolean jad_an(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
