package com.wbl.ad.yzz.gson.t.k.o;

import java.util.TimeZone;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a */
    public static final TimeZone f32377a = TimeZone.getTimeZone("UTC");

    /* JADX WARN: Removed duplicated region for block: B:44:0x00cc A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01b9, NumberFormatException -> 0x01bb, IndexOutOfBoundsException -> 0x01bd, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01b9, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:18:0x0050, B:20:0x0060, B:21:0x0062, B:23:0x006e, B:24:0x0070, B:26:0x0076, B:30:0x0080, B:35:0x0090, B:37:0x0098, B:42:0x00c6, B:44:0x00cc, B:46:0x00d3, B:47:0x0180, B:52:0x00dd, B:53:0x00f8, B:54:0x00f9, B:57:0x0115, B:59:0x0122, B:62:0x012b, B:64:0x014a, B:67:0x0159, B:68:0x017b, B:70:0x017e, B:71:0x0104, B:72:0x01b1, B:73:0x01b8, B:74:0x00af, B:75:0x00b2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b1 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01b9, NumberFormatException -> 0x01bb, IndexOutOfBoundsException -> 0x01bd, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01b9, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:18:0x0050, B:20:0x0060, B:21:0x0062, B:23:0x006e, B:24:0x0070, B:26:0x0076, B:30:0x0080, B:35:0x0090, B:37:0x0098, B:42:0x00c6, B:44:0x00cc, B:46:0x00d3, B:47:0x0180, B:52:0x00dd, B:53:0x00f8, B:54:0x00f9, B:57:0x0115, B:59:0x0122, B:62:0x012b, B:64:0x014a, B:67:0x0159, B:68:0x017b, B:70:0x017e, B:71:0x0104, B:72:0x01b1, B:73:0x01b8, B:74:0x00af, B:75:0x00b2), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Date a(java.lang.String r17, java.text.ParsePosition r18) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 550
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wbl.ad.yzz.gson.t.k.o.a.a(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static boolean a(String str, int i2, char c2) {
        return i2 < str.length() && str.charAt(i2) == c2;
    }

    public static int a(String str, int i2, int i3) throws NumberFormatException {
        int i4;
        int i5;
        if (i2 < 0 || i3 > str.length() || i2 > i3) {
            throw new NumberFormatException(str);
        }
        if (i2 < i3) {
            i4 = i2 + 1;
            int digit = Character.digit(str.charAt(i2), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i5 = -digit;
        } else {
            i4 = i2;
            i5 = 0;
        }
        while (i4 < i3) {
            int i6 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i5 = (i5 * 10) - digit2;
            i4 = i6;
        }
        return -i5;
    }

    public static int a(String str, int i2) {
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt < '0' || charAt > '9') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }
}
