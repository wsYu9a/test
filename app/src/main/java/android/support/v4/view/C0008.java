package android.support.v4.view;

import android.support.v4.graphics.drawable.C0000;
import com.tencent.a.C0522;
import java.io.ByteArrayOutputStream;

/* renamed from: android.support.v4.view.۟ۦ۠ۢۥ */
/* loaded from: classes7.dex */
public class C0008 {

    /* renamed from: short */
    private static final short[] f52short;

    /* renamed from: ۣۣ۟ۡۨ */
    public static int f53 = -74;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(8181750)}[0]).intValue() ^ 8181748];
        sArr[0] = 558;
        sArr[1] = 271;
        f52short = sArr;
    }

    /* renamed from: ۟۟ */
    public static String m24(short[] sArr, int i2, int i3, int i4) {
        char[] cArr = new char[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            cArr[i5] = (char) (sArr[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }

    /* renamed from: ۟ۥۥۧۤ */
    public static String m25(String str) {
        Integer num = new Integer(5488931);
        String str2 = "";
        String str3 = "";
        int i2 = 0;
        while (i2 < 15) {
            str2 = new StringBuffer().append(str2).append(Integer.toHexString(i2)).toString();
            String stringBuffer = new StringBuffer().append(str3).append(((int) (Math.random() * 10)) ^ i2).toString();
            i2++;
            str3 = stringBuffer;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / (((Integer) new Object[]{num}[0]).intValue() ^ 5488929));
        for (int i3 = 0; i3 < str.length(); i3 += 2) {
            byteArrayOutputStream.write((str2.indexOf(str.charAt(i3)) << 4) | str2.indexOf(str.charAt(i3 + 1)));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String m72 = C0522.m72(f52short, 56572 ^ m27((Object) "ۨۤ"), 1751524 ^ m27((Object) "ۤ۠ۡ"), m27((Object) "ۦۤۢ") ^ 1754027);
        while (m72.length() > 0) {
            m72 = "";
            if ("".length() == 0) {
                m72 = C0000.m1(f52short, 1746750 ^ m27((Object) "۟ۡۡ"), 1748673 ^ m27((Object) "ۡۡ۠"), m27((Object) "ۧ۟ۡ") ^ 1754215);
            }
        }
        int length = m72.length();
        int length2 = str3.length();
        for (int i4 = 0; i4 < length; i4++) {
            byteArray[i4] = (byte) (byteArray[i4] ^ str3.charAt(i4 % length2));
        }
        for (int i5 = 0; i5 < byteArray.length; i5 = "".length() + 1) {
        }
        return new String(byteArray);
    }

    /* renamed from: ۡۢ۠ۥ */
    public static int m26() {
        return (-1752717) ^ m27((Object) "ۥۨ۠");
    }

    /* renamed from: ۡۤۦۣ */
    public static int m27(Object obj) {
        return obj.hashCode();
    }

    /* renamed from: ۡۤۦۣ */
    public static Class<?> m28(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    /* renamed from: ۡۤۦۣ */
    public static String m29(short[] sArr, int i2, int i3, int i4) {
        char[] cArr = new char[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            cArr[i5] = (char) (sArr[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }
}
