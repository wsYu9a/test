package com.opos.mobad.cmn.a.b;

import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes4.dex */
public class e {
    public static final String a(long j2) {
        if (j2 <= 0 || j2 >= 86400000) {
            return "00:00";
        }
        long j3 = j2 / 1000;
        int i2 = (int) (j3 % 60);
        int i3 = (int) ((j3 / 60) % 60);
        int i4 = (int) (j3 / 3600);
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        try {
            return (i4 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)) : formatter.format("%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2))).toString();
        } catch (Throwable th) {
            try {
                throw th;
            } finally {
                try {
                    formatter.close();
                } catch (Throwable unused) {
                }
            }
        }
    }
}
