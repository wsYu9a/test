package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class bv {

    /* renamed from: d */
    private static final byte[] f9143d = new byte[0];

    /* renamed from: a */
    private Context f9144a;

    /* renamed from: b */
    private boolean f9145b;

    /* renamed from: c */
    private int f9146c;

    public bv(Context context, int i2, boolean z) {
        this.f9144a = context;
        this.f9145b = z;
        this.f9146c = i2;
    }

    public String a(String str) {
        try {
            synchronized (f9143d) {
                JSONObject a2 = new cl(str, cj.f9197j).a(this.f9144a);
                if (a2 == null) {
                    return null;
                }
                JSONObject a3 = a();
                if (a3 == null) {
                    return null;
                }
                a2.put("module_section", a3);
                return a2.toString();
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x04f9 A[Catch: all -> 0x055c, TRY_ENTER, TryCatch #4 {all -> 0x055c, blocks: (B:86:0x039e, B:88:0x03a6, B:89:0x03ab, B:92:0x03c3, B:94:0x03d0, B:95:0x03d9, B:97:0x03e2, B:98:0x03eb, B:100:0x03f4, B:101:0x03fd, B:103:0x0406, B:104:0x040f, B:106:0x0418, B:107:0x0421, B:109:0x042a, B:110:0x0433, B:112:0x043c, B:113:0x0445, B:115:0x044e, B:116:0x0457, B:118:0x0460, B:119:0x0469, B:121:0x0472, B:122:0x047b, B:123:0x04bf, B:126:0x04f9, B:128:0x0506, B:129:0x050c, B:131:0x0515, B:132:0x051b, B:134:0x0524, B:135:0x052a, B:137:0x0533, B:138:0x0537, B:143:0x053b, B:146:0x0477, B:147:0x0465, B:148:0x0453, B:149:0x0441, B:150:0x042f, B:151:0x041d, B:152:0x040b, B:153:0x03f9, B:154:0x03e7, B:155:0x03d5, B:156:0x047f), top: B:85:0x039e }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x053b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject a() {
        /*
            Method dump skipped, instructions count: 1412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.bv.a():org.json.JSONObject");
    }
}
