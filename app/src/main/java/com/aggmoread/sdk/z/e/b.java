package com.aggmoread.sdk.z.e;

import android.text.TextUtils;
import com.aggmoread.sdk.z.b.d;
import com.aggmoread.sdk.z.e.a;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    public static final byte[] f6148a;

    /* renamed from: b */
    public static final byte[] f6149b;

    /* renamed from: c */
    public static final BigDecimal f6150c;

    /* renamed from: d */
    public static a.b f6151d;

    static {
        byte[] bytes = "b8459ad37b619125b7125026d8005f5a".getBytes();
        f6148a = bytes;
        byte[] bytes2 = "77c589c81cd026c8170bbf7c1a16c857".getBytes();
        f6149b = bytes2;
        f6150c = new BigDecimal(0);
        f6151d = null;
        try {
            f6151d = new a.b(new a.C0190a(new SecretKeySpec(bytes, "HmacSHA1"), new SecretKeySpec(bytes2, "HmacSHA1")));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        d.c("DCC_TAG", "replacePrice url = " + str);
        d.c("DCC_TAG", "replacePrice price = " + str2);
        String a10 = a(str, "${AUCTION_PRICE}", str2);
        d.c("DCC_TAG", "replacePrice final url = " + a10);
        return a10;
    }

    public static final String a(String str, String str2, String str3) {
        return str.contains(str2) ? str.replace(str2, str3) : str;
    }

    public static String a(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            bigDecimal = f6150c;
        }
        return f6151d.a(bigDecimal.longValue(), (byte[]) null);
    }

    public static List<String> a(List<String> list, BigDecimal bigDecimal) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            for (String str : list) {
                String a10 = a(bigDecimal);
                d.c("DCC_TAG", "price = " + bigDecimal + ",  encryPriceStr = " + a10);
                arrayList.add(a(str, a10));
            }
        }
        return arrayList;
    }
}
