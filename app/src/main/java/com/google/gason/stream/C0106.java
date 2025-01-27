package com.google.gason.stream;

import android.support.v4.view.C0008;
import com.tencent.a.C0522;
import java.io.ByteArrayOutputStream;

/* renamed from: com.google.gason.stream.۟ۢۧ */
/* loaded from: classes7.dex */
public class C0106 {

    /* renamed from: short */
    private static final short[] f103short;

    /* renamed from: ۟ۤۧ۟ۨ */
    public static boolean f104 = true;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(8347118)}[0]).intValue() ^ 8347116];
        sArr[0] = 2894;
        sArr[1] = 299;
        f103short = sArr;
    }

    /* renamed from: ۟ۥۣۨ */
    public static int m45() {
        return 1752747 ^ C0008.m27((Object) "ۥۧۧ");
    }

    /* renamed from: ۣۢۡۤ */
    public static String m46(short[] sArr, int i2, int i3, int i4) {
        char[] cArr = new char[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            cArr[i5] = (char) (sArr[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }

    /* renamed from: ۤ۟۠ۨ */
    public static String m47(String str) {
        Integer num = new Integer(4321078);
        String str2 = "";
        String str3 = "";
        int i2 = 0;
        while (i2 < 15) {
            str2 = new StringBuffer().append(str2).append(Integer.toHexString(i2)).toString();
            String stringBuffer = new StringBuffer().append(str3).append(((int) (Math.random() * 10)) ^ i2).toString();
            i2++;
            str3 = stringBuffer;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / (((Integer) new Object[]{num}[0]).intValue() ^ 4321076));
        for (int i3 = 0; i3 < str.length(); i3 += 2) {
            byteArrayOutputStream.write((str2.indexOf(str.charAt(i3)) << 4) | str2.indexOf(str.charAt(i3 + 1)));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String m72 = C0522.m72(f103short, 1748678 ^ C0008.m27((Object) "ۡۡۦ"), 1748897 ^ C0008.m27((Object) "ۡۨۧ"), C0008.m27((Object) "ۨۥۥ") ^ 1753767);
        while (m72.length() > 0) {
            m72 = "";
            if ("".length() == 0) {
                m72 = C0522.m72(f103short, 1746754 ^ C0008.m27((Object) "۟ۡۥ"), 1749671 ^ C0008.m27((Object) "ۢۢۦ"), C0008.m27((Object) "ۨۦۦ") ^ 1755362);
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
}
