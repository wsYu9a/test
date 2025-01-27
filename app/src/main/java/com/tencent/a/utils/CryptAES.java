package com.tencent.a.utils;

import android.support.v4.graphics.C0003;
import android.support.v4.view.C0008;
import android.util.Base64;
import com.google.gason.C0107;
import com.google.gason.reflect.C0105;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes7.dex */
public class CryptAES {
    private static final String AESTYPE;

    /* renamed from: short */
    private static final short[] f124short;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(5834578)}[0]).intValue() ^ 5834605];
        sArr[0] = 2548;
        sArr[1] = 2544;
        sArr[2] = 2534;
        sArr[3] = 2458;
        sArr[4] = 2544;
        sArr[5] = 2550;
        sArr[6] = 2551;
        sArr[7] = 2458;
        sArr[8] = 2533;
        sArr[9] = 2558;
        sArr[10] = 2550;
        sArr[11] = 2534;
        sArr[12] = 2432;
        sArr[13] = 2533;
        sArr[14] = 2516;
        sArr[15] = 2513;
        sArr[16] = 2513;
        sArr[17] = 2524;
        sArr[18] = 2523;
        sArr[19] = 2514;
        sArr[20] = 995;
        sArr[21] = 999;
        sArr[22] = 1009;
        sArr[23] = 909;
        sArr[24] = 999;
        sArr[25] = 993;
        sArr[26] = 992;
        sArr[27] = 909;
        sArr[28] = 1010;
        sArr[29] = 1001;
        sArr[30] = 993;
        sArr[31] = 1009;
        sArr[32] = 919;
        sArr[33] = 1010;
        sArr[34] = 963;
        sArr[35] = 966;
        sArr[36] = 966;
        sArr[37] = 971;
        sArr[38] = 972;
        sArr[39] = 965;
        sArr[40] = 2170;
        sArr[41] = 2174;
        sArr[42] = 2152;
        sArr[43] = 2068;
        sArr[44] = 2174;
        sArr[45] = 2168;
        sArr[46] = 2169;
        sArr[47] = 2068;
        sArr[48] = 2155;
        sArr[49] = 2160;
        sArr[50] = 2168;
        sArr[51] = 2152;
        sArr[52] = 2062;
        sArr[53] = 2155;
        sArr[54] = 2138;
        sArr[55] = 2143;
        sArr[56] = 2143;
        sArr[57] = 2130;
        sArr[58] = 2133;
        sArr[59] = 2140;
        sArr[60] = 3142;
        sArr[61] = 3138;
        sArr[62] = 3156;
        f124short = sArr;
        AESTYPE = C0105.m44(f124short, 1752706 ^ C0008.m27((Object) "ۥۧۤ"), 1747721 ^ C0008.m27((Object) "۠ۢ۟"), C0008.m27((Object) "ۥۢ") ^ 54568);
    }

    public static String AES_Decrypt(String str, String str2) {
        byte[] bArr;
        Integer num = new Integer(8511158);
        try {
            Key generateKey = generateKey(str);
            Cipher cipher = Cipher.getInstance(C0107.m50(f124short, 1749807 ^ C0008.m27((Object) "ۢۧ۠"), 1755481 ^ C0008.m27((Object) "ۣۨۨ"), C0008.m27((Object) "ۣۡۨ") ^ 1750504));
            cipher.init(((Integer) new Object[]{num}[0]).intValue() ^ 8511156, generateKey);
            bArr = cipher.doFinal(Base64.decode(str2, 0));
        } catch (Exception e2) {
            e2.printStackTrace();
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return new String(bArr).trim();
    }

    public static String AES_Encrypt(String str, String str2) {
        byte[] bArr;
        Integer num = new Integer(5806009);
        try {
            Key generateKey = generateKey(str);
            Cipher cipher = Cipher.getInstance(C0107.m50(f124short, 1754678 ^ C0008.m27((Object) "ۧۨ۟"), 1755422 ^ C0008.m27((Object) "ۣۨۡ"), C0008.m27((Object) "ۣۥۢ") ^ 1752827));
            cipher.init(((Integer) new Object[]{num}[0]).intValue() ^ 5806008, generateKey);
            bArr = cipher.doFinal(str2.getBytes());
        } catch (Exception e2) {
            e2.printStackTrace();
            bArr = null;
        }
        return new String(Base64.encode(bArr, 0));
    }

    private static Key generateKey(String str) throws Exception {
        try {
            return new SecretKeySpec(str.getBytes(), C0003.m11(f124short, 1754658 ^ C0008.m27((Object) "ۧۨ۟"), 1747897 ^ C0008.m27((Object) "۠ۧۡ"), C0008.m27((Object) "ۥۥۦ") ^ 1749569));
        } catch (Exception e2) {
            e2.printStackTrace();
            throw e2;
        }
    }
}
