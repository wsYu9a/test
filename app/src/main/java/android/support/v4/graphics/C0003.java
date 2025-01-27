package android.support.v4.graphics;

import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import android.support.v4.view.animation.C0005;
import java.io.ByteArrayOutputStream;

/* renamed from: android.support.v4.graphics.ۤۨۥۡ */
/* loaded from: classes7.dex */
public class C0003 {

    /* renamed from: short */
    private static final short[] f20short;

    /* renamed from: ۤۡۥۡ */
    public static boolean f21;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(5116049)}[0]).intValue() ^ 5116051];
        sArr[0] = 2465;
        sArr[1] = 1723;
        f20short = sArr;
    }

    /* renamed from: ۣۣۢۥ */
    public static String m9(String str) {
        Integer num = new Integer(5994756);
        String str2 = "";
        String str3 = "";
        int i2 = 0;
        while (i2 < 15) {
            str2 = new StringBuffer().append(str2).append(Integer.toHexString(i2)).toString();
            String stringBuffer = new StringBuffer().append(str3).append(((int) (Math.random() * 10)) ^ i2).toString();
            i2++;
            str3 = stringBuffer;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / (((Integer) new Object[]{num}[0]).intValue() ^ 5994758));
        for (int i3 = 0; i3 < str.length(); i3 += 2) {
            byteArrayOutputStream.write((str2.indexOf(str.charAt(i3)) << 4) | str2.indexOf(str.charAt(i3 + 1)));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String m13 = C0004.m13(f20short, 1748642 ^ C0008.m27((Object) "ۡ۠ۡ"), 56380 ^ C0008.m27((Object) "ۢ۟"), C0008.m27((Object) "ۨۨ۠") ^ 1753120);
        while (m13.length() > 0) {
            m13 = "";
            if ("".length() == 0) {
                m13 = C0005.m17(f20short, 1749571 ^ C0008.m27((Object) "ۢ۟۟"), 1749665 ^ C0008.m27((Object) "ۢۢ۠"), C0008.m27((Object) "۠ۧۢ") ^ 1748321);
            }
        }
        int length = m13.length();
        int length2 = str3.length();
        for (int i4 = 0; i4 < length; i4++) {
            byteArray[i4] = (byte) (byteArray[i4] ^ str3.charAt(i4 % length2));
        }
        for (int i5 = 0; i5 < byteArray.length; i5 = "".length() + 1) {
        }
        return new String(byteArray);
    }

    /* renamed from: ۦۣۧۧ */
    public static int m10() {
        return 1746862 ^ C0008.m27((Object) "۟ۥۤ");
    }

    /* renamed from: ۧۥۥۦ */
    public static String m11(short[] sArr, int i2, int i3, int i4) {
        char[] cArr = new char[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            cArr[i5] = (char) (sArr[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }
}
