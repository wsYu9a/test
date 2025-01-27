package com.tencent.a.model;

import android.support.v4.view.C0008;
import java.io.ByteArrayOutputStream;

/* renamed from: com.tencent.a.model.۟۠۠۟ۥ */
/* loaded from: classes7.dex */
public class C0519 {

    /* renamed from: ۠ۢ۠ */
    public static boolean f122;

    /* renamed from: ۟ۥۦۡۨ */
    public static String m63(String str) {
        Integer num = new Integer(8207479);
        String str2 = "";
        String str3 = "";
        int i2 = 0;
        while (i2 < 15) {
            str2 = new StringBuffer().append(str2).append(Integer.toHexString(i2)).toString();
            String stringBuffer = new StringBuffer().append(str3).append(((int) (Math.random() * 10)) ^ i2).toString();
            i2++;
            str3 = stringBuffer;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / (((Integer) new Object[]{num}[0]).intValue() ^ 8207477));
        for (int i3 = 0; i3 < str.length(); i3 += 2) {
            byteArrayOutputStream.write((str2.indexOf(str.charAt(i3)) << 4) | str2.indexOf(str.charAt(i3 + 1)));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        int length2 = str3.length();
        for (int i4 = 0; i4 < length; i4++) {
            byteArray[i4] = (byte) (byteArray[i4] ^ str3.charAt(i4 % length2));
        }
        for (int i5 = 0; i5 < byteArray.length; i5 = "".length() + 1) {
        }
        return new String(byteArray);
    }

    /* renamed from: ۟ۦۣ۟ۢ */
    public static int m64() {
        return 1749635 ^ C0008.m27((Object) "ۢۡۧ");
    }

    /* renamed from: ۣۢۡۨ */
    public static String m65(short[] sArr, int i2, int i3, int i4) {
        char[] cArr = new char[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            cArr[i5] = (char) (sArr[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }
}
