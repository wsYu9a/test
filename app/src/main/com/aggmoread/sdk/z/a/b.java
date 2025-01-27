package com.aggmoread.sdk.z.a;

import android.text.TextUtils;
import com.aggmoread.sdk.z.b.d;
import com.aggmoread.sdk.z.b.g.c;
import com.aggmoread.sdk.z.b.j.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    static int f4143a = 1;

    private static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String a10 = g.a(g.a("6213FC1A2C51C632", str));
                d.c("ReportNoticeUtilTAG", "encodeWinPrice " + a10);
                return a10;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return str;
    }

    public static String a(String str, c cVar, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String a10 = a(a(str, "__width__", String.valueOf(cVar.f4473e)), "__height__", String.valueOf(cVar.f4474f));
        int i10 = cVar.f4471c;
        if (i10 < 0) {
            i10 = -999;
        }
        String a11 = a(a10, "__up_x__", String.valueOf(i10));
        int i11 = cVar.f4471c;
        int i12 = cVar.f4473e;
        if (i11 > i12) {
            cVar.f4471c = i12 - 1;
        } else if (i11 < 0) {
            cVar.f4471c = 1;
        }
        int i13 = cVar.f4472d;
        if (i13 < 0) {
            i13 = -999;
        }
        String a12 = a(a11, "__up_y__", String.valueOf(i13));
        int i14 = cVar.f4472d;
        int i15 = cVar.f4474f;
        if (i14 > i15) {
            cVar.f4472d = i15 - 1;
        } else if (i14 < 0) {
            cVar.f4472d = 1;
        }
        String a13 = a(a(a12, "__clickid__", String.valueOf(cVar.f4477i)), "__utc_end_tms__", String.valueOf(cVar.f4476h));
        if (Math.abs(cVar.f4469a - cVar.f4471c) > f4143a) {
            cVar.f4469a = cVar.f4471c;
        }
        if (Math.abs(cVar.f4470b - cVar.f4472d) > f4143a) {
            cVar.f4470b = cVar.f4472d;
        }
        int i16 = cVar.f4469a;
        if (i16 < 0) {
            i16 = -999;
        }
        String a14 = a(a13, "__down_x__", String.valueOf(i16));
        int i17 = cVar.f4470b;
        return a(a(a(a(a14, "__down_y__", String.valueOf(i17 >= 0 ? i17 : -999)), "__utc_tms__", String.valueOf(cVar.f4475g)), "__sld__", String.valueOf(0)), "__win_price__", str2);
    }

    public static String a(String str, String str2, String str3) {
        return str.contains(str2) ? str.replace(str2, str3) : str;
    }

    public static List<String> a(List<String> list, c cVar, String str) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            for (String str2 : list) {
                String a10 = a(str);
                d.c("ReportNoticeUtilTAG", "price = " + str + ",  encryPriceStr = " + a10);
                arrayList.add(a(str2, cVar, a10));
            }
        }
        return arrayList;
    }
}
