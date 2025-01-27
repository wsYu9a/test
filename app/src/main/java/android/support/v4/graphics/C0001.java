package android.support.v4.graphics;

import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.C0008;
import com.tencent.as.C0523;
import java.io.ByteArrayOutputStream;

/* renamed from: android.support.v4.graphics.۟ۡۢۧۥ */
/* loaded from: classes7.dex */
public class C0001 {

    /* renamed from: short */
    private static final short[] f17short;

    /* renamed from: ۨۨۦ */
    public static int f18 = 71;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(4202200)}[0]).intValue() ^ 4202202];
        sArr[0] = 2360;
        sArr[1] = 2718;
        f17short = sArr;
    }

    /* renamed from: ۟ۤۥۡ۠ */
    public static String m3(short[] sArr, int i2, int i3, int i4) {
        char[] cArr = new char[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            cArr[i5] = (char) (sArr[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }

    /* renamed from: ۟ۥۥۣۨ */
    public static String m4(String str) {
        Integer num = new Integer(8193868);
        String str2 = "";
        String str3 = "";
        int i2 = 0;
        while (i2 < 15) {
            str2 = new StringBuffer().append(str2).append(Integer.toHexString(i2)).toString();
            String stringBuffer = new StringBuffer().append(str3).append(((int) (Math.random() * 10)) ^ i2).toString();
            i2++;
            str3 = stringBuffer;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / (((Integer) new Object[]{num}[0]).intValue() ^ 8193870));
        for (int i3 = 0; i3 < str.length(); i3 += 2) {
            byteArrayOutputStream.write((str2.indexOf(str.charAt(i3)) << 4) | str2.indexOf(str.charAt(i3 + 1)));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String m77 = C0523.m77(f17short, 1747656 ^ C0008.m27((Object) "۠۟ۧ"), 1748800 ^ C0008.m27((Object) "ۡۥۥ"), C0008.m27((Object) "ۦۦۦ") ^ 1756031);
        while (m77.length() > 0) {
            m77 = "";
            if ("".length() == 0) {
                m77 = C0000.m1(f17short, 1746881 ^ C0008.m27((Object) "۟ۥۦ"), 56504 ^ C0008.m27((Object) "ۦ۟"), C0008.m27((Object) "ۣۧ۠") ^ 1757051);
            }
        }
        int length = m77.length();
        int length2 = str3.length();
        for (int i4 = 0; i4 < length; i4++) {
            byteArray[i4] = (byte) (byteArray[i4] ^ str3.charAt(i4 % length2));
        }
        for (int i5 = 0; i5 < byteArray.length; i5 = "".length() + 1) {
        }
        return new String(byteArray);
    }

    /* renamed from: ۠ۢۡۡ */
    public static int m5() {
        return 1751691 ^ C0008.m27((Object) "ۤۧۤ");
    }
}
