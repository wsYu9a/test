package android.support.v4.view.animation;

import android.support.v4.view.C0008;
import com.tencent.a.model.C0519;
import java.io.ByteArrayOutputStream;

/* renamed from: android.support.v4.view.animation.۟ۢ۟ۧۦ */
/* loaded from: classes7.dex */
public class C0005 {

    /* renamed from: short */
    private static final short[] f48short;

    /* renamed from: ۡۥۧۨ */
    public static int f49 = 38;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(8735954)}[0]).intValue() ^ 8735952];
        sArr[0] = 639;
        sArr[1] = 1559;
        f48short = sArr;
    }

    /* renamed from: ۣ۟ۢۦ */
    public static String m15(String str) {
        Integer num = new Integer(6536504);
        String str2 = "";
        String str3 = "";
        int i2 = 0;
        while (i2 < 15) {
            str2 = new StringBuffer().append(str2).append(Integer.toHexString(i2)).toString();
            String stringBuffer = new StringBuffer().append(str3).append(((int) (Math.random() * 10)) ^ i2).toString();
            i2++;
            str3 = stringBuffer;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / (((Integer) new Object[]{num}[0]).intValue() ^ 6536506));
        for (int i3 = 0; i3 < str.length(); i3 += 2) {
            byteArrayOutputStream.write((str2.indexOf(str.charAt(i3)) << 4) | str2.indexOf(str.charAt(i3 + 1)));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String m23 = C0007.m23(f48short, 1754627 ^ C0008.m27((Object) "ۣۧۧ"), 1746787 ^ C0008.m27((Object) "۟ۢۥ"), C0008.m27((Object) "ۢۤ") ^ 56924);
        while (m23.length() > 0) {
            m23 = "";
            if ("".length() == 0) {
                m23 = C0519.m65(f48short, 1752734 ^ C0008.m27((Object) "ۥۨۢ"), 1755404 ^ C0008.m27((Object) "ۨۡۦ"), C0008.m27((Object) "ۧۧ۟") ^ 1753993);
            }
        }
        int length = m23.length();
        int length2 = str3.length();
        for (int i4 = 0; i4 < length; i4++) {
            byteArray[i4] = (byte) (byteArray[i4] ^ str3.charAt(i4 % length2));
        }
        for (int i5 = 0; i5 < byteArray.length; i5 = "".length() + 1) {
        }
        return new String(byteArray);
    }

    /* renamed from: ۢۢۥۨ */
    public static int m16() {
        return (-1751586) ^ C0008.m27((Object) "ۣۤۢ");
    }

    /* renamed from: ۥۦۦۧ */
    public static String m17(short[] sArr, int i2, int i3, int i4) {
        char[] cArr = new char[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            cArr[i5] = (char) (sArr[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }
}
