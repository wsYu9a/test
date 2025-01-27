package com.yxcorp.kuaishou.addfp.android.a;

import android.os.Build;
import android.text.TextUtils;
import com.yxcorp.kuaishou.addfp.android.Orange;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: d */
    private static boolean f25168d = true;

    /* renamed from: e */
    private static int f25169e;

    /* renamed from: a */
    private String f25170a;

    /* renamed from: b */
    private String f25171b;

    /* renamed from: c */
    private ReentrantLock f25172c;

    c() {
        this.f25171b = "";
        this.f25172c = new ReentrantLock();
    }

    public static c c() {
        return b.f25167a;
    }

    public String a() {
        try {
            return !TextUtils.isEmpty(this.f25170a) ? this.f25170a : "KWE_N";
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "KWE_N";
        }
    }

    public void b(String str) {
        this.f25170a = str;
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static String b() {
        try {
            if (!f25168d) {
                return "KWE_NPN";
            }
            if (f25169e == 0) {
                int i10 = Build.VERSION.SDK_INT;
                boolean z10 = true;
                if (i10 < 33) {
                    boolean z11 = false;
                    if (i10 >= 29) {
                        String str = Build.MODEL;
                        if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("redmi") && str.toLowerCase().contains("note 7")) {
                            z11 = true;
                        }
                        if (!Build.BRAND.equalsIgnoreCase(ke.e.f27805c)) {
                            z10 = z11;
                        }
                    } else {
                        z10 = false;
                    }
                }
                if (!z10) {
                    String gSer = Orange.getInstance().gSer();
                    if (!TextUtils.isEmpty(gSer) && !gSer.startsWith("KWE")) {
                        return gSer;
                    }
                }
            }
            return !TextUtils.isEmpty("") ? "" : "KWE_N";
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "KWE_N";
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(84:9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|(1:47)|48|49|50|51|(2:52|53)|54|55|56|57|58|59|60|61|62|63|64|(2:65|66)|(5:67|68|69|70|71)|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|(1:127)(4:92|(3:94|95|96)(1:126)|97|98)|99|100|101|102|(4:105|(2:107|108)(1:110)|109|103)|111|112|113|114|(1:116)|117|118) */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02ca, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02f3, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0209, code lost:
    
        r5 = "KWE_PE";
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02aa A[Catch: all -> 0x02ca, TryCatch #7 {all -> 0x02ca, blocks: (B:102:0x02a0, B:105:0x02aa, B:107:0x02be, B:109:0x02cc, B:112:0x02cf), top: B:101:0x02a0, outer: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0348  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(android.content.Context r22, com.yxcorp.kuaishou.addfp.ResponseDfpCallback r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 852
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.a(android.content.Context, com.yxcorp.kuaishou.addfp.ResponseDfpCallback, boolean):java.lang.String");
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "KWE_N" : str.replace("=", "").replace("&", "");
    }

    public static void a(JSONObject jSONObject) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if ("64".equals(next) && jSONObject.optInt(next, 1) == 0) {
                    f25168d = false;
                }
                if ("64_level".equals(next)) {
                    f25169e = jSONObject.optInt(next, 0);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
