package com.tencent.a.utils;

import android.support.v4.graphics.C0001;
import android.support.v4.view.C0008;
import java.io.ByteArrayOutputStream;

/* renamed from: com.tencent.a.utils.ۤۥۢۢ */
/* loaded from: classes7.dex */
public class C0520 {

    /* renamed from: short */
    private static final short[] f127short;

    /* renamed from: ۟ۡۨ۟ۧ */
    public static int f128 = 17;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(8104941)}[0]).intValue() ^ 8104943];
        sArr[0] = 2838;
        sArr[1] = 628;
        f127short = sArr;
    }

    /* renamed from: ۟۟ۢۤۥ */
    public static String m66(short[] sArr, int i2, int i3, int i4) {
        char[] cArr = new char[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            cArr[i5] = (char) (sArr[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }

    /* renamed from: ۣۡۨۧ */
    public static String m67(String str) {
        Integer num = new Integer(8962976);
        String str2 = "";
        String str3 = "";
        int i2 = 0;
        while (i2 < 15) {
            str2 = new StringBuffer().append(str2).append(Integer.toHexString(i2)).toString();
            String stringBuffer = new StringBuffer().append(str3).append(((int) (Math.random() * 10)) ^ i2).toString();
            i2++;
            str3 = stringBuffer;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / (((Integer) new Object[]{num}[0]).intValue() ^ 8962978));
        for (int i3 = 0; i3 < str.length(); i3 += 2) {
            byteArrayOutputStream.write((str2.indexOf(str.charAt(i3)) << 4) | str2.indexOf(str.charAt(i3 + 1)));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String m3 = C0001.m3(f127short, 1754500 ^ C0008.m27((Object) "ۣۧ۠"), 1747838 ^ C0008.m27((Object) "۠ۥۤ"), C0008.m27((Object) "ۣ۟ۡ") ^ 1752434);
        while (m3.length() > 0) {
            m3 = "";
            if ("".length() == 0) {
                m3 = C0008.m24(f127short, 1751563 ^ C0008.m27((Object) "ۤۡۧ"), 1747928 ^ C0008.m27((Object) "۠ۨۡ"), C0008.m27((Object) "ۡۧۢ") ^ 1748329);
            }
        }
        int length = m3.length();
        int length2 = str3.length();
        for (int i4 = 0; i4 < length; i4++) {
            byteArray[i4] = (byte) (byteArray[i4] ^ str3.charAt(i4 % length2));
        }
        for (int i5 = 0; i5 < byteArray.length; i5 = "".length() + 1) {
        }
        return new String(byteArray);
    }

    /* renamed from: ۤۤۡ۠ */
    public static int m68() {
        return 1748729 ^ C0008.m27((Object) "ۡۢۧ");
    }
}
