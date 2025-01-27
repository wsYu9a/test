package com.yxcorp.kuaishou.addfp.android.a;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: d */
    private static boolean f34689d = true;

    /* renamed from: a */
    private String f34690a;

    /* renamed from: b */
    private String f34691b;

    /* renamed from: c */
    private ReentrantLock f34692c;

    /* JADX INFO: Access modifiers changed from: private */
    c() {
        this.f34691b = "";
        this.f34692c = new ReentrantLock();
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0018 A[Catch: all -> 0x00a7, TryCatch #2 {all -> 0x00a7, blocks: (B:2:0x0000, B:13:0x0018, B:16:0x0023, B:18:0x0029, B:20:0x0031, B:22:0x003d, B:26:0x004e, B:28:0x005c, B:31:0x0065, B:43:0x0087, B:45:0x0091, B:48:0x0098, B:50:0x00a0, B:63:0x0012, B:8:0x0009), top: B:1:0x0000, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0029 A[Catch: all -> 0x00a7, TryCatch #2 {all -> 0x00a7, blocks: (B:2:0x0000, B:13:0x0018, B:16:0x0023, B:18:0x0029, B:20:0x0031, B:22:0x003d, B:26:0x004e, B:28:0x005c, B:31:0x0065, B:43:0x0087, B:45:0x0091, B:48:0x0098, B:50:0x00a0, B:63:0x0012, B:8:0x0009), top: B:1:0x0000, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e A[Catch: all -> 0x00a7, TryCatch #2 {all -> 0x00a7, blocks: (B:2:0x0000, B:13:0x0018, B:16:0x0023, B:18:0x0029, B:20:0x0031, B:22:0x003d, B:26:0x004e, B:28:0x005c, B:31:0x0065, B:43:0x0087, B:45:0x0091, B:48:0x0098, B:50:0x00a0, B:63:0x0012, B:8:0x0009), top: B:1:0x0000, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0087 A[Catch: all -> 0x00a7, TRY_ENTER, TryCatch #2 {all -> 0x00a7, blocks: (B:2:0x0000, B:13:0x0018, B:16:0x0023, B:18:0x0029, B:20:0x0031, B:22:0x003d, B:26:0x004e, B:28:0x005c, B:31:0x0065, B:43:0x0087, B:45:0x0091, B:48:0x0098, B:50:0x00a0, B:63:0x0012, B:8:0x0009), top: B:1:0x0000, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a0 A[Catch: all -> 0x00a7, TRY_LEAVE, TryCatch #2 {all -> 0x00a7, blocks: (B:2:0x0000, B:13:0x0018, B:16:0x0023, B:18:0x0029, B:20:0x0031, B:22:0x003d, B:26:0x004e, B:28:0x005c, B:31:0x0065, B:43:0x0087, B:45:0x0091, B:48:0x0098, B:50:0x00a0, B:63:0x0012, B:8:0x0009), top: B:1:0x0000, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r7) {
        /*
            boolean r0 = com.yxcorp.kuaishou.addfp.android.a.c.f34689d     // Catch: java.lang.Throwable -> La7
            if (r0 != 0) goto L7
            java.lang.String r7 = "KWE_NPN"
            return r7
        L7:
            r0 = 1
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L11
            r3 = 26
            if (r2 < r3) goto L15
            r2 = 1
            goto L16
        L11:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> La7
        L15:
            r2 = 0
        L16:
            if (r2 != 0) goto L23
            java.lang.String r2 = b()     // Catch: java.lang.Throwable -> La7
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> La7
            if (r3 != 0) goto L23
            return r2
        L23:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> La7
            r3 = 29
            if (r2 < r3) goto L4b
            java.lang.String r2 = android.os.Build.MODEL     // Catch: java.lang.Throwable -> La7
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> La7
            if (r3 != 0) goto L4b
            java.lang.String r3 = r2.toLowerCase()     // Catch: java.lang.Throwable -> La7
            java.lang.String r4 = "redmi"
            boolean r3 = r3.contains(r4)     // Catch: java.lang.Throwable -> La7
            if (r3 == 0) goto L4b
            java.lang.String r2 = r2.toLowerCase()     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = "note 7"
            boolean r2 = r2.contains(r3)     // Catch: java.lang.Throwable -> La7
            if (r2 == 0) goto L4b
            r2 = 1
            goto L4c
        L4b:
            r2 = 0
        L4c:
            if (r2 != 0) goto L65
            com.yxcorp.kuaishou.addfp.android.Orange r2 = com.yxcorp.kuaishou.addfp.android.Orange.getInstance()     // Catch: java.lang.Throwable -> La7
            java.lang.String r2 = r2.gSer()     // Catch: java.lang.Throwable -> La7
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> La7
            if (r3 != 0) goto L65
            java.lang.String r3 = "KWE"
            boolean r3 = r2.startsWith(r3)     // Catch: java.lang.Throwable -> La7
            if (r3 != 0) goto L65
            return r2
        L65:
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            r2[r1] = r3     // Catch: java.lang.Throwable -> La7
            r3 = 0
        L6c:
            if (r3 > 0) goto L83
            r4 = r2[r1]     // Catch: java.lang.Throwable -> L82
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L82
            int r6 = android.os.Process.myUid()     // Catch: java.lang.Throwable -> L82
            int r4 = r7.checkPermission(r4, r5, r6)     // Catch: java.lang.Throwable -> L82
            r5 = -1
            if (r4 == r5) goto L82
            int r3 = r3 + 1
            goto L6c
        L82:
            r0 = 0
        L83:
            java.lang.String r7 = "unknown"
            if (r0 == 0) goto L98
            java.lang.String r0 = android.os.Build.getSerial()     // Catch: java.lang.Throwable -> La7
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> La7
            if (r1 != 0) goto L98
            boolean r1 = r0.equals(r7)     // Catch: java.lang.Throwable -> La7
            if (r1 != 0) goto L98
            return r0
        L98:
            java.lang.String r0 = android.os.Build.SERIAL     // Catch: java.lang.Throwable -> La7
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> La7
            if (r1 != 0) goto Lab
            boolean r7 = r0.equals(r7)     // Catch: java.lang.Throwable -> La7
            if (r7 != 0) goto Lab
            return r0
        La7:
            r7 = move-exception
            r7.printStackTrace()
        Lab:
            java.lang.String r7 = "KWE_N"
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.a(android.content.Context):java.lang.String");
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
                    f34689d = false;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
    
        if (r2 != null) goto L82;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b() {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L35
            java.lang.String r2 = "/sys/class/android_usb/android0/iSerial"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L35
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L35
            if (r2 == 0) goto L31
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L35
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L35
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L35
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L35
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L2f
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L2f
            if (r3 != 0) goto L32
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L2f
            r2.close()     // Catch: java.lang.Throwable -> L2a
            goto L2e
        L2a:
            r1 = move-exception
            r1.printStackTrace()
        L2e:
            return r0
        L2f:
            r1 = move-exception
            goto L37
        L31:
            r2 = r0
        L32:
            if (r2 == 0) goto L44
            goto L3c
        L35:
            r1 = move-exception
            r2 = r0
        L37:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L45
            if (r2 == 0) goto L44
        L3c:
            r2.close()     // Catch: java.lang.Throwable -> L40
            goto L44
        L40:
            r1 = move-exception
            r1.printStackTrace()
        L44:
            return r0
        L45:
            r0 = move-exception
            if (r2 == 0) goto L50
            r2.close()     // Catch: java.lang.Throwable -> L4c
            goto L50
        L4c:
            r1 = move-exception
            r1.printStackTrace()
        L50:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.b():java.lang.String");
    }

    public static c c() {
        return b.f34688a;
    }

    public String a() {
        try {
            return !TextUtils.isEmpty(this.f34690a) ? this.f34690a : "KWE_N";
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_N";
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(81:9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|(1:47)|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|(6:66|67|68|69|70|71)|(4:72|73|74|75)|76|77|78|79|80|81|82|83|84|85|(1:125)(3:91|(4:93|94|95|96)(1:124)|97)|98|99|100|101|(4:104|(2:106|107)(1:109)|108|102)|110|111|112|113|(1:115)|116|117) */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02e4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02e5, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x029e A[Catch: all -> 0x02e4, TryCatch #2 {all -> 0x02e4, blocks: (B:101:0x0294, B:104:0x029e, B:106:0x02b2, B:108:0x02bd, B:111:0x02c0), top: B:100:0x0294, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x025c A[Catch: all -> 0x0342, TryCatch #1 {all -> 0x0342, blocks: (B:67:0x01cc, B:75:0x01fd, B:77:0x020d, B:79:0x021a, B:81:0x022b, B:83:0x0240, B:85:0x024e, B:87:0x025c, B:89:0x0262, B:91:0x026a, B:93:0x0270, B:96:0x0278, B:97:0x0284, B:99:0x028d, B:112:0x02e8, B:120:0x02e5, B:123:0x027f, B:133:0x020a, B:139:0x033e, B:140:0x0341, B:101:0x0294, B:104:0x029e, B:106:0x02b2, B:108:0x02bd, B:111:0x02c0, B:131:0x0205), top: B:66:0x01cc, inners: #2, #12, #13 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(android.content.Context r23, com.yxcorp.kuaishou.addfp.ResponseDfpCallback r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 881
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.a(android.content.Context, com.yxcorp.kuaishou.addfp.ResponseDfpCallback, boolean):java.lang.String");
    }

    public void b(String str) {
        this.f34690a = str;
    }
}
