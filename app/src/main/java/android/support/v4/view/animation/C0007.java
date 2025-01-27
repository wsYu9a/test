package android.support.v4.view.animation;

import android.support.v4.view.C0008;
import java.io.ByteArrayOutputStream;

/* renamed from: android.support.v4.view.animation.ۨۨ۟ۤ */
/* loaded from: classes7.dex */
public class C0007 {

    /* renamed from: ۟۠ۦۥ۠ */
    public static int f51 = -33;

    /* renamed from: ۣ۟ۡۨ۟ */
    public static String m21(String str) {
        Object[] objArr = {new Integer(-503729), new Integer(2792753)};
        String str2 = "";
        String str3 = "";
        int i2 = 0;
        while (i2 < 15) {
            str2 = new StringBuffer().append(str2).append(Integer.toHexString(i2)).toString();
            String stringBuffer = new StringBuffer().append(str3).append(((int) (Math.random() * 10)) ^ i2).toString();
            i2++;
            str3 = stringBuffer;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / (((Integer) objArr[1]).intValue() ^ 2792755));
        for (int i3 = 0; i3 < str.length(); i3 += 2) {
            byteArrayOutputStream.write((str2.indexOf(str.charAt(i3)) << 4) | str2.indexOf(str.charAt(i3 + 1)));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        int length2 = str3.length();
        while (length > 0) {
            byteArray[((Integer) objArr[0]).intValue() ^ 503728] = (byte) (byteArray[r0] ^ str3.charAt(r0 % length2));
        }
        for (int i4 = 0; i4 < byteArray.length; i4 = "".length() + 1) {
        }
        return new String(byteArray);
    }

    /* renamed from: ۢۡ۟۠ */
    public static int m22() {
        return (-1755432) ^ C0008.m27((Object) "ۨۤۤ");
    }

    /* renamed from: ۥۦۥۤ */
    public static String m23(short[] sArr, int i2, int i3, int i4) {
        char[] cArr = new char[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            cArr[i5] = (char) (sArr[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }
}
