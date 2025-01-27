package com.umeng.umzid;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.am;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ZIDManager {

    /* renamed from: d */
    public static ZIDManager f26520d;

    /* renamed from: a */
    public boolean f26521a = false;

    /* renamed from: b */
    public boolean f26522b = false;

    /* renamed from: c */
    public boolean f26523c;

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f26524a;

        /* renamed from: b */
        public final /* synthetic */ IZIDCompletionCallback f26525b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.f26524a = context;
            this.f26525b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a2 = ZIDManager.a(ZIDManager.this, this.f26524a);
            if (TextUtils.isEmpty(a2)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.f26525b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1002", "获取zid失败");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.f26525b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(a2);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f26527a;

        public b(Context context) {
            this.f26527a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.this.a(this.f26527a);
        }
    }

    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f26529a;

        public c(Context context) {
            this.f26529a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.f26529a);
        }
    }

    public static /* synthetic */ String a(ZIDManager zIDManager, Context context) {
        String str = null;
        if (!zIDManager.f26521a) {
            zIDManager.f26521a = true;
            JSONObject jSONObject = new JSONObject();
            try {
                String id = Spy.getID();
                jSONObject.put(am.aD, id);
                String b2 = d.b(context);
                jSONObject.put(am.A, b2);
                String c2 = d.c(context);
                jSONObject.put("o", c2);
                zIDManager.a(context, jSONObject);
                String a2 = com.umeng.umzid.a.a("https://utoken.umeng.com/api/postZdata/v4", jSONObject.toString());
                if (!TextUtils.isEmpty(a2)) {
                    JSONObject jSONObject2 = new JSONObject(a2);
                    if (Boolean.valueOf(jSONObject2.optBoolean("suc")).booleanValue()) {
                        d.f(context, id);
                        d.a(context, b2);
                        d.b(context, c2);
                        str = jSONObject2.optString("aaid");
                        if (!TextUtils.isEmpty(str)) {
                            d.e(context, str);
                        }
                        String string = jSONObject2.getString("uabc");
                        if (!TextUtils.isEmpty(string)) {
                            d.d(context, string);
                        }
                        String string2 = jSONObject2.getString("resetToken");
                        if (!TextUtils.isEmpty(string2)) {
                            d.c(context, string2);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            zIDManager.f26521a = false;
        }
        return str;
    }

    public static synchronized ZIDManager getInstance() {
        ZIDManager zIDManager;
        synchronized (ZIDManager.class) {
            if (f26520d == null) {
                f26520d = new ZIDManager();
            }
            zIDManager = f26520d;
        }
        return zIDManager;
    }

    public static String getSDKVersion() {
        return "1.6.3";
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        String a2 = d.a(applicationContext);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        com.umeng.umzid.c.a(new c(applicationContext));
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0077 A[Catch: all -> 0x00a6, TryCatch #1 {, blocks: (B:3:0x0001, B:10:0x000f, B:13:0x0018, B:16:0x0020, B:19:0x0029, B:22:0x0031, B:24:0x0037, B:26:0x003d, B:28:0x0043, B:29:0x004c, B:31:0x0052, B:34:0x0059, B:36:0x0063, B:37:0x006f, B:39:0x0077, B:40:0x007f, B:42:0x0085, B:46:0x0097, B:51:0x0067), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085 A[Catch: all -> 0x00a6, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:10:0x000f, B:13:0x0018, B:16:0x0020, B:19:0x0029, B:22:0x0031, B:24:0x0037, B:26:0x003d, B:28:0x0043, B:29:0x004c, B:31:0x0052, B:34:0x0059, B:36:0x0063, B:37:0x006f, B:39:0x0077, B:40:0x007f, B:42:0x0085, B:46:0x0097, B:51:0x0067), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void init(android.content.Context r4, java.lang.String r5, com.umeng.umzid.IZIDCompletionCallback r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = com.umeng.umzid.d.d(r4)     // Catch: java.lang.Throwable -> La6
            r3.f26523c = r0     // Catch: java.lang.Throwable -> La6
            if (r0 != 0) goto Lb
            monitor-exit(r3)
            return
        Lb:
            if (r4 != 0) goto L18
            if (r6 == 0) goto L16
            java.lang.String r4 = "1001"
            java.lang.String r5 = "传入参数Context为null"
            r6.onFailure(r4, r5)     // Catch: java.lang.Throwable -> La6
        L16:
            monitor-exit(r3)
            return
        L18:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> La6
            if (r0 == 0) goto L29
            if (r6 == 0) goto L27
            java.lang.String r4 = "1003"
            java.lang.String r5 = "传入参数appkey为空"
            r6.onFailure(r4, r5)     // Catch: java.lang.Throwable -> La6
        L27:
            monitor-exit(r3)
            return
        L29:
            android.content.Context r0 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> La6
            if (r0 == 0) goto L4c
            if (r5 == 0) goto L4c
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> La6
            if (r1 != 0) goto L4c
            android.content.SharedPreferences r1 = com.umeng.umzid.a.a(r0)     // Catch: java.lang.Throwable -> La6
            if (r1 == 0) goto L4c
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch: java.lang.Throwable -> La6
            if (r1 == 0) goto L4c
            java.lang.String r2 = "appkey"
            android.content.SharedPreferences$Editor r5 = r1.putString(r2, r5)     // Catch: java.lang.Throwable -> La6
            r5.commit()     // Catch: java.lang.Throwable -> La6
        L4c:
            java.lang.String r5 = com.umeng.umzid.d.a(r0)     // Catch: java.lang.Throwable -> La6
            if (r5 == 0) goto L67
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> La6
            if (r1 == 0) goto L59
            goto L67
        L59:
            com.umeng.umzid.ZIDManager$b r1 = new com.umeng.umzid.ZIDManager$b     // Catch: java.lang.Throwable -> La6
            r1.<init>(r0)     // Catch: java.lang.Throwable -> La6
            com.umeng.umzid.c.a(r1)     // Catch: java.lang.Throwable -> La6
            if (r6 == 0) goto L6f
            r6.onSuccess(r5)     // Catch: java.lang.Throwable -> La6
            goto L6f
        L67:
            com.umeng.umzid.ZIDManager$a r5 = new com.umeng.umzid.ZIDManager$a     // Catch: java.lang.Throwable -> La6
            r5.<init>(r0, r6)     // Catch: java.lang.Throwable -> La6
            com.umeng.umzid.c.a(r5)     // Catch: java.lang.Throwable -> La6
        L6f:
            java.lang.String r5 = ""
            android.content.SharedPreferences r6 = com.umeng.umzid.a.a(r4)     // Catch: java.lang.Throwable -> La6
            if (r6 == 0) goto L7f
            java.lang.String r5 = "uuid"
            java.lang.String r0 = ""
            java.lang.String r5 = r6.getString(r5, r0)     // Catch: java.lang.Throwable -> La6
        L7f:
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> La6
            if (r5 == 0) goto La4
            java.lang.String r5 = ""
            android.content.SharedPreferences r4 = com.umeng.umzid.a.a(r4)     // Catch: java.lang.Throwable -> La6
            java.util.UUID r6 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> La6
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L94
            goto L95
        L94:
        L95:
            if (r4 == 0) goto La4
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch: java.lang.Throwable -> La6
            java.lang.String r6 = "uuid"
            android.content.SharedPreferences$Editor r4 = r4.putString(r6, r5)     // Catch: java.lang.Throwable -> La6
            r4.commit()     // Catch: java.lang.Throwable -> La6
        La4:
            monitor-exit(r3)
            return
        La6:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.init(android.content.Context, java.lang.String, com.umeng.umzid.IZIDCompletionCallback):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(44:0|1|(4:2|3|4|5)|(2:7|(40:11|12|(5:99|100|(2:107|108)|102|(37:104|15|16|17|18|19|(2:21|(30:25|26|27|28|29|30|(3:80|81|(5:83|84|(2:87|85)|88|89))|32|(1:34)(1:79)|35|(1:37)(1:78)|38|39|40|41|42|43|44|45|46|47|(1:51)|52|53|54|55|56|(2:58|(2:62|63))|65|66))|97|26|27|28|29|30|(0)|32|(0)(0)|35|(0)(0)|38|39|40|41|42|43|44|45|46|47|(2:49|51)|52|53|54|55|56|(0)|65|66))|14|15|16|17|18|19|(0)|97|26|27|28|29|30|(0)|32|(0)(0)|35|(0)(0)|38|39|40|41|42|43|44|45|46|47|(0)|52|53|54|55|56|(0)|65|66))|112|12|(0)|14|15|16|17|18|19|(0)|97|26|27|28|29|30|(0)|32|(0)(0)|35|(0)(0)|38|39|40|41|42|43|44|45|46|47|(0)|52|53|54|55|56|(0)|65|66) */
    /* JADX WARN: Can't wrap try/catch for region: R(47:0|1|2|3|4|5|(2:7|(40:11|12|(5:99|100|(2:107|108)|102|(37:104|15|16|17|18|19|(2:21|(30:25|26|27|28|29|30|(3:80|81|(5:83|84|(2:87|85)|88|89))|32|(1:34)(1:79)|35|(1:37)(1:78)|38|39|40|41|42|43|44|45|46|47|(1:51)|52|53|54|55|56|(2:58|(2:62|63))|65|66))|97|26|27|28|29|30|(0)|32|(0)(0)|35|(0)(0)|38|39|40|41|42|43|44|45|46|47|(2:49|51)|52|53|54|55|56|(0)|65|66))|14|15|16|17|18|19|(0)|97|26|27|28|29|30|(0)|32|(0)(0)|35|(0)(0)|38|39|40|41|42|43|44|45|46|47|(0)|52|53|54|55|56|(0)|65|66))|112|12|(0)|14|15|16|17|18|19|(0)|97|26|27|28|29|30|(0)|32|(0)(0)|35|(0)(0)|38|39|40|41|42|43|44|45|46|47|(0)|52|53|54|55|56|(0)|65|66) */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x018e, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x018f, code lost:
    
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0175, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0176, code lost:
    
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0152, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0153, code lost:
    
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0108, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0096 A[Catch: all -> 0x00aa, TryCatch #8 {all -> 0x00aa, blocks: (B:17:0x0084, B:19:0x008a, B:21:0x0096, B:23:0x00a3, B:25:0x00a7), top: B:16:0x0084 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01bd A[Catch: all -> 0x01d1, TryCatch #0 {all -> 0x01d1, blocks: (B:54:0x01ab, B:56:0x01b1, B:58:0x01bd, B:60:0x01ca, B:62:0x01ce), top: B:53:0x01ab }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject a(android.content.Context r10, org.json.JSONObject r11) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061 A[Catch: all -> 0x0138, TryCatch #1 {all -> 0x0138, blocks: (B:68:0x0043, B:70:0x0049, B:18:0x0051, B:20:0x0061, B:22:0x0067, B:24:0x0073, B:25:0x0079, B:27:0x0089, B:29:0x008f, B:31:0x009b, B:32:0x00a1, B:34:0x00bb, B:36:0x00c1, B:37:0x00c7, B:40:0x00ce, B:42:0x00d4, B:43:0x00d8, B:45:0x00de, B:47:0x00e5, B:49:0x00f3, B:51:0x0108, B:53:0x011b, B:54:0x011e, B:56:0x0128, B:57:0x012b, B:59:0x0135), top: B:67:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0089 A[Catch: all -> 0x0138, TryCatch #1 {all -> 0x0138, blocks: (B:68:0x0043, B:70:0x0049, B:18:0x0051, B:20:0x0061, B:22:0x0067, B:24:0x0073, B:25:0x0079, B:27:0x0089, B:29:0x008f, B:31:0x009b, B:32:0x00a1, B:34:0x00bb, B:36:0x00c1, B:37:0x00c7, B:40:0x00ce, B:42:0x00d4, B:43:0x00d8, B:45:0x00de, B:47:0x00e5, B:49:0x00f3, B:51:0x0108, B:53:0x011b, B:54:0x011e, B:56:0x0128, B:57:0x012b, B:59:0x0135), top: B:67:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bb A[Catch: all -> 0x0138, TryCatch #1 {all -> 0x0138, blocks: (B:68:0x0043, B:70:0x0049, B:18:0x0051, B:20:0x0061, B:22:0x0067, B:24:0x0073, B:25:0x0079, B:27:0x0089, B:29:0x008f, B:31:0x009b, B:32:0x00a1, B:34:0x00bb, B:36:0x00c1, B:37:0x00c7, B:40:0x00ce, B:42:0x00d4, B:43:0x00d8, B:45:0x00de, B:47:0x00e5, B:49:0x00f3, B:51:0x0108, B:53:0x011b, B:54:0x011e, B:56:0x0128, B:57:0x012b, B:59:0x0135), top: B:67:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce A[Catch: all -> 0x0138, TRY_ENTER, TryCatch #1 {all -> 0x0138, blocks: (B:68:0x0043, B:70:0x0049, B:18:0x0051, B:20:0x0061, B:22:0x0067, B:24:0x0073, B:25:0x0079, B:27:0x0089, B:29:0x008f, B:31:0x009b, B:32:0x00a1, B:34:0x00bb, B:36:0x00c1, B:37:0x00c7, B:40:0x00ce, B:42:0x00d4, B:43:0x00d8, B:45:0x00de, B:47:0x00e5, B:49:0x00f3, B:51:0x0108, B:53:0x011b, B:54:0x011e, B:56:0x0128, B:57:0x012b, B:59:0x0135), top: B:67:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00de A[Catch: all -> 0x0138, TRY_LEAVE, TryCatch #1 {all -> 0x0138, blocks: (B:68:0x0043, B:70:0x0049, B:18:0x0051, B:20:0x0061, B:22:0x0067, B:24:0x0073, B:25:0x0079, B:27:0x0089, B:29:0x008f, B:31:0x009b, B:32:0x00a1, B:34:0x00bb, B:36:0x00c1, B:37:0x00c7, B:40:0x00ce, B:42:0x00d4, B:43:0x00d8, B:45:0x00de, B:47:0x00e5, B:49:0x00f3, B:51:0x0108, B:53:0x011b, B:54:0x011e, B:56:0x0128, B:57:0x012b, B:59:0x0135), top: B:67:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f3 A[Catch: all -> 0x0138, TryCatch #1 {all -> 0x0138, blocks: (B:68:0x0043, B:70:0x0049, B:18:0x0051, B:20:0x0061, B:22:0x0067, B:24:0x0073, B:25:0x0079, B:27:0x0089, B:29:0x008f, B:31:0x009b, B:32:0x00a1, B:34:0x00bb, B:36:0x00c1, B:37:0x00c7, B:40:0x00ce, B:42:0x00d4, B:43:0x00d8, B:45:0x00de, B:47:0x00e5, B:49:0x00f3, B:51:0x0108, B:53:0x011b, B:54:0x011e, B:56:0x0128, B:57:0x012b, B:59:0x0135), top: B:67:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(android.content.Context r13) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context):java.lang.String");
    }
}
