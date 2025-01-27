package com.google.gason.reflect;

import android.support.v4.view.C0008;
import java.io.ByteArrayOutputStream;

/* renamed from: com.google.gason.reflect.۟ۡ۠۟ۨ */
/* loaded from: classes7.dex */
public class C0105 {

    /* renamed from: ۟ۤۦۤۦ */
    public static int f98 = -11;

    /* renamed from: ۟ۢ۟ۧۨ */
    public static String m42(String str) {
        Object[] objArr = {new Integer(-7724600), new Integer(979567), new Integer(-4490688)};
        String str2 = "";
        String str3 = "";
        int i2 = 0;
        while (i2 < 15) {
            str2 = new StringBuffer().append(str2).append(Integer.toHexString(i2)).toString();
            String stringBuffer = new StringBuffer().append(str3).append(((int) (Math.random() * 10)) ^ i2).toString();
            i2++;
            str3 = stringBuffer;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / (((Integer) objArr[1]).intValue() ^ 979565));
        while (str.length() > 0) {
            byteArrayOutputStream.write(str2.indexOf(str.charAt(((Integer) objArr[2]).intValue() ^ 4490687)) | (str2.indexOf(str.charAt(((Integer) objArr[0]).intValue() ^ 7724598)) << 4));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        int length2 = str3.length();
        for (int i3 = 0; i3 < length; i3++) {
            byteArray[i3] = (byte) (byteArray[i3] ^ str3.charAt(i3 % length2));
        }
        return new String(byteArray);
    }

    /* renamed from: ۠ۨ۟ۧ */
    public static int m43() {
        return (-1750624) ^ C0008.m27((Object) "ۣۣۡ");
    }

    /* renamed from: ۢۨۨۡ */
    public static String m44(short[] sArr, int i2, int i3, int i4) {
        char[] cArr = new char[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            cArr[i5] = (char) (sArr[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }
}
