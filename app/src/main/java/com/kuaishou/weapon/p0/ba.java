package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ba {

    /* renamed from: a */
    private JSONObject f9098a;

    /* renamed from: b */
    private int f9099b;

    public ba(Context context, int i2, String str, boolean z) {
        if (Engine.loadSuccess && z) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.f9193f).intValue(), 0, i2, str);
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f9098a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                return g.a(context, g.f9324i) != -1;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public int a() {
        return this.f9099b;
    }

    public String a(String str) {
        JSONObject jSONObject = this.f9098a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject b() {
        return this.f9098a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c2, code lost:
    
        if (r7 == null) goto L105;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject c() {
        /*
            r15 = this;
            java.lang.String r0 = "init.svc."
            java.lang.String r1 = "]:"
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 0
            r15.f9099b = r4
            r5 = 10
            r6 = 0
            java.lang.String r7 = "2afcabd3eda8ae"
            java.lang.String r8 = "077f"
            java.lang.String r7 = com.kuaishou.weapon.p0.i.a(r7, r8)     // Catch: java.lang.Throwable -> Lb9
            java.lang.Runtime r8 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> Lb9
            java.lang.Process r7 = r8.exec(r7)     // Catch: java.lang.Throwable -> Lb9
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> Lb9
            java.io.InputStream r7 = r7.getInputStream()     // Catch: java.lang.Throwable -> Lb9
            r8.<init>(r7)     // Catch: java.lang.Throwable -> Lb9
            java.io.LineNumberReader r7 = new java.io.LineNumberReader     // Catch: java.lang.Throwable -> Lb7
            r7.<init>(r8)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r9 = r7.readLine()     // Catch: java.lang.Throwable -> Lb5
            r10 = 0
        L37:
            boolean r11 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> Lb5
            if (r11 != 0) goto L9d
            boolean r11 = r9.contains(r1)     // Catch: java.lang.Throwable -> Lb5
            r12 = 1
            if (r11 == 0) goto L93
            java.lang.String[] r9 = r9.split(r1)     // Catch: java.lang.Throwable -> Lb5
            int r11 = r9.length     // Catch: java.lang.Throwable -> Lb5
            r13 = 2
            if (r11 != r13) goto L93
            r11 = r9[r4]     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r11 = r11.trim()     // Catch: java.lang.Throwable -> Lb5
            r9 = r9[r12]     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r9 = r9.trim()     // Catch: java.lang.Throwable -> Lb5
            int r14 = r11.length()     // Catch: java.lang.Throwable -> Lb5
            if (r14 <= r13) goto L93
            int r14 = r9.length()     // Catch: java.lang.Throwable -> Lb5
            if (r14 <= r13) goto L93
            java.lang.String r11 = r11.substring(r12)     // Catch: java.lang.Throwable -> Lb5
            int r13 = r9.length()     // Catch: java.lang.Throwable -> Lb5
            int r13 = r13 - r12
            java.lang.String r9 = r9.substring(r12, r13)     // Catch: java.lang.Throwable -> Lb5
            boolean r13 = r11.startsWith(r0)     // Catch: java.lang.Throwable -> Lb5
            if (r13 == 0) goto L90
            java.lang.String r13 = "stopped"
            boolean r13 = r9.equals(r13)     // Catch: java.lang.Throwable -> Lb5
            if (r13 != 0) goto L87
            java.lang.String r13 = "running"
            boolean r13 = r9.equals(r13)     // Catch: java.lang.Throwable -> Lb5
            if (r13 == 0) goto L90
        L87:
            java.lang.String r13 = ""
            java.lang.String r13 = r11.replace(r0, r13)     // Catch: java.lang.Throwable -> Lb5
            r3.append(r13)     // Catch: java.lang.Throwable -> Lb5
        L90:
            r2.put(r11, r9)     // Catch: java.lang.Throwable -> Lb5
        L93:
            int r10 = r10 + r12
            r9 = 1300(0x514, float:1.822E-42)
            if (r10 > r9) goto L9d
            java.lang.String r9 = r7.readLine()     // Catch: java.lang.Throwable -> Lb5
            goto L37
        L9d:
            int r0 = r2.length()     // Catch: java.lang.Throwable -> Lb5
            if (r0 <= r5) goto Lac
            java.lang.String r0 = "n"
            int r1 = r2.length()     // Catch: java.lang.Throwable -> Lb5
            r2.put(r0, r1)     // Catch: java.lang.Throwable -> Lb5
        Lac:
            r8.close()     // Catch: java.lang.Throwable -> Laf
        Laf:
            r7.close()     // Catch: java.io.IOException -> Lb3
            goto Lc5
        Lb3:
            goto Lc5
        Lb5:
            goto Lbb
        Lb7:
            r7 = r6
            goto Lbb
        Lb9:
            r7 = r6
            r8 = r7
        Lbb:
            if (r8 == 0) goto Lc2
            r8.close()     // Catch: java.lang.Throwable -> Lc1
            goto Lc2
        Lc1:
        Lc2:
            if (r7 == 0) goto Lc5
            goto Laf
        Lc5:
            int r0 = r2.length()
            if (r0 <= r5) goto Lcc
            return r2
        Lcc:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.ba.c():org.json.JSONObject");
    }
}
