package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointCategory;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class ZIDManager {

    /* renamed from: d */
    public static ZIDManager f24886d;

    /* renamed from: a */
    public boolean f24887a = false;

    /* renamed from: b */
    public boolean f24888b = false;

    /* renamed from: c */
    public boolean f24889c;

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f24890a;

        /* renamed from: b */
        public final /* synthetic */ IZIDCompletionCallback f24891b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.f24890a = context;
            this.f24891b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a10 = ZIDManager.a(ZIDManager.this, this.f24890a);
            if (TextUtils.isEmpty(a10)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.f24891b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1002", "获取zid失败");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.f24891b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(a10);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f24893a;

        public b(Context context) {
            this.f24893a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.this.b(this.f24893a);
        }
    }

    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f24895a;

        public c(Context context) {
            this.f24895a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.f24895a);
        }
    }

    public static void configureDomain(Context context, String str) {
        SharedPreferences a10;
        SharedPreferences.Editor edit;
        String b10 = d.b(str);
        if (context == null || b10 == null || TextUtils.isEmpty(b10) || (a10 = com.umeng.umzid.a.a(context)) == null || (edit = a10.edit()) == null) {
            return;
        }
        edit.putString("inputDomain", b10).commit();
    }

    public static synchronized ZIDManager getInstance() {
        ZIDManager zIDManager;
        synchronized (ZIDManager.class) {
            try {
                if (f24886d == null) {
                    f24886d = new ZIDManager();
                }
                zIDManager = f24886d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zIDManager;
    }

    public static String getSDKVersion() {
        return "1.8.5";
    }

    public final void a(Context context) {
        Object invoke;
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.uyumao.sdk.UYMManager");
            Method declaredMethod2 = cls.getDeclaredMethod("getInstance", null);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(cls, null)) == null || (declaredMethod = cls.getDeclaredMethod(PointCategory.INIT, Context.class)) == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(invoke, context);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(31:11|(3:77|78|(27:80|14|(1:76)(2:18|(1:20))|21|(1:75)(2:25|(1:27))|28|29|(1:33)|34|(1:36)|37|38|39|40|41|42|43|44|45|(1:47)|48|(1:50)|51|(2:53|(6:55|(1:57)|58|(1:60)|61|(1:63)))|64|65|66))|13|14|(1:16)|76|21|(1:23)|75|28|29|(2:31|33)|34|(0)|37|38|39|40|41|42|43|44|45|(0)|48|(0)|51|(0)|64|65|66) */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ea, code lost:
    
        r11 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ef, code lost:
    
        r11.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ec, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ed, code lost:
    
        r11 = r6;
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c4 A[Catch: all -> 0x0165, TRY_LEAVE, TryCatch #0 {all -> 0x0165, blocks: (B:78:0x0033, B:80:0x0039, B:14:0x0041, B:16:0x0051, B:18:0x0057, B:20:0x0063, B:21:0x0069, B:23:0x0079, B:25:0x007f, B:27:0x008b, B:28:0x0091, B:31:0x00b4, B:33:0x00ba, B:34:0x00be, B:36:0x00c4, B:47:0x00f4, B:48:0x00f9, B:51:0x0106, B:53:0x0125, B:55:0x0132, B:57:0x0145, B:58:0x0148, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:71:0x00ef), top: B:77:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f4 A[Catch: all -> 0x0165, TryCatch #0 {all -> 0x0165, blocks: (B:78:0x0033, B:80:0x0039, B:14:0x0041, B:16:0x0051, B:18:0x0057, B:20:0x0063, B:21:0x0069, B:23:0x0079, B:25:0x007f, B:27:0x008b, B:28:0x0091, B:31:0x00b4, B:33:0x00ba, B:34:0x00be, B:36:0x00c4, B:47:0x00f4, B:48:0x00f9, B:51:0x0106, B:53:0x0125, B:55:0x0132, B:57:0x0145, B:58:0x0148, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:71:0x00ef), top: B:77:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0125 A[Catch: all -> 0x0165, TryCatch #0 {all -> 0x0165, blocks: (B:78:0x0033, B:80:0x0039, B:14:0x0041, B:16:0x0051, B:18:0x0057, B:20:0x0063, B:21:0x0069, B:23:0x0079, B:25:0x007f, B:27:0x008b, B:28:0x0091, B:31:0x00b4, B:33:0x00ba, B:34:0x00be, B:36:0x00c4, B:47:0x00f4, B:48:0x00f9, B:51:0x0106, B:53:0x0125, B:55:0x0132, B:57:0x0145, B:58:0x0148, B:60:0x0152, B:61:0x0155, B:63:0x015f, B:64:0x0162, B:71:0x00ef), top: B:77:0x0033 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String b(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.b(android.content.Context):java.lang.String");
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        String d10 = d.d(applicationContext);
        if (!TextUtils.isEmpty(d10)) {
            return d10;
        }
        com.umeng.umzid.c.a(new c(applicationContext));
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007b A[Catch: all -> 0x0017, TryCatch #0 {, blocks: (B:3:0x0001, B:10:0x000f, B:13:0x001c, B:16:0x0024, B:19:0x002d, B:22:0x0035, B:24:0x003b, B:26:0x0041, B:28:0x0047, B:29:0x0050, B:31:0x0056, B:34:0x005d, B:36:0x0067, B:37:0x0073, B:39:0x007b, B:40:0x0083, B:42:0x0089, B:46:0x009b, B:51:0x006b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0089 A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:10:0x000f, B:13:0x001c, B:16:0x0024, B:19:0x002d, B:22:0x0035, B:24:0x003b, B:26:0x0041, B:28:0x0047, B:29:0x0050, B:31:0x0056, B:34:0x005d, B:36:0x0067, B:37:0x0073, B:39:0x007b, B:40:0x0083, B:42:0x0089, B:46:0x009b, B:51:0x006b), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void init(android.content.Context r4, java.lang.String r5, com.umeng.umzid.IZIDCompletionCallback r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = com.umeng.umzid.d.h(r4)     // Catch: java.lang.Throwable -> L17
            r3.f24889c = r0     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto Lb
            monitor-exit(r3)
            return
        Lb:
            if (r4 != 0) goto L1c
            if (r6 == 0) goto L1a
            java.lang.String r4 = "1001"
            java.lang.String r5 = "传入参数Context为null"
            r6.onFailure(r4, r5)     // Catch: java.lang.Throwable -> L17
            goto L1a
        L17:
            r4 = move-exception
            goto Laa
        L1a:
            monitor-exit(r3)
            return
        L1c:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L2d
            if (r6 == 0) goto L2b
            java.lang.String r4 = "1003"
            java.lang.String r5 = "传入参数appkey为空"
            r6.onFailure(r4, r5)     // Catch: java.lang.Throwable -> L17
        L2b:
            monitor-exit(r3)
            return
        L2d:
            android.content.Context r0 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L50
            if (r5 == 0) goto L50
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L17
            if (r1 != 0) goto L50
            android.content.SharedPreferences r1 = com.umeng.umzid.a.a(r0)     // Catch: java.lang.Throwable -> L17
            if (r1 == 0) goto L50
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch: java.lang.Throwable -> L17
            if (r1 == 0) goto L50
            java.lang.String r2 = "appkey"
            android.content.SharedPreferences$Editor r5 = r1.putString(r2, r5)     // Catch: java.lang.Throwable -> L17
            r5.commit()     // Catch: java.lang.Throwable -> L17
        L50:
            java.lang.String r5 = com.umeng.umzid.d.d(r0)     // Catch: java.lang.Throwable -> L17
            if (r5 == 0) goto L6b
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L17
            if (r1 == 0) goto L5d
            goto L6b
        L5d:
            com.umeng.umzid.ZIDManager$b r1 = new com.umeng.umzid.ZIDManager$b     // Catch: java.lang.Throwable -> L17
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L17
            com.umeng.umzid.c.a(r1)     // Catch: java.lang.Throwable -> L17
            if (r6 == 0) goto L73
            r6.onSuccess(r5)     // Catch: java.lang.Throwable -> L17
            goto L73
        L6b:
            com.umeng.umzid.ZIDManager$a r5 = new com.umeng.umzid.ZIDManager$a     // Catch: java.lang.Throwable -> L17
            r5.<init>(r0, r6)     // Catch: java.lang.Throwable -> L17
            com.umeng.umzid.c.a(r5)     // Catch: java.lang.Throwable -> L17
        L73:
            java.lang.String r5 = ""
            android.content.SharedPreferences r6 = com.umeng.umzid.a.a(r4)     // Catch: java.lang.Throwable -> L17
            if (r6 == 0) goto L83
            java.lang.String r5 = "uuid"
            java.lang.String r0 = ""
            java.lang.String r5 = r6.getString(r5, r0)     // Catch: java.lang.Throwable -> L17
        L83:
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L17
            if (r5 == 0) goto La8
            java.lang.String r5 = ""
            android.content.SharedPreferences r4 = com.umeng.umzid.a.a(r4)     // Catch: java.lang.Throwable -> L17
            java.util.UUID r6 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> L17
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L98
            goto L99
        L98:
        L99:
            if (r4 == 0) goto La8
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch: java.lang.Throwable -> L17
            java.lang.String r6 = "uuid"
            android.content.SharedPreferences$Editor r4 = r4.putString(r6, r5)     // Catch: java.lang.Throwable -> L17
            r4.commit()     // Catch: java.lang.Throwable -> L17
        La8:
            monitor-exit(r3)
            return
        Laa:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L17
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.init(android.content.Context, java.lang.String, com.umeng.umzid.IZIDCompletionCallback):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056 A[Catch: all -> 0x005c, TryCatch #2 {all -> 0x005c, blocks: (B:5:0x0010, B:16:0x0056, B:17:0x005f, B:20:0x006f, B:22:0x008e, B:24:0x009b, B:26:0x00b0, B:27:0x00b3, B:29:0x00bf, B:30:0x00c2, B:32:0x00ce, B:33:0x00d1, B:38:0x0051), top: B:4:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008e A[Catch: all -> 0x005c, TryCatch #2 {all -> 0x005c, blocks: (B:5:0x0010, B:16:0x0056, B:17:0x005f, B:20:0x006f, B:22:0x008e, B:24:0x009b, B:26:0x00b0, B:27:0x00b3, B:29:0x00bf, B:30:0x00c2, B:32:0x00ce, B:33:0x00d1, B:38:0x0051), top: B:4:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.String a(com.umeng.umzid.ZIDManager r10, android.content.Context r11) {
        /*
            boolean r0 = r10.f24887a
            r1 = 0
            if (r0 == 0) goto L7
            goto Lda
        L7:
            r0 = 1
            r10.f24887a = r0
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r3 = 0
            java.lang.String r4 = com.umeng.umzid.Spy.getID()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r5 = "z"
            r2.put(r5, r4)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r5 = com.umeng.umzid.d.e(r11)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r6 = "mc"
            r2.put(r6, r5)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r6 = com.umeng.umzid.d.f(r11)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r7 = "o"
            r2.put(r7, r6)     // Catch: java.lang.Throwable -> L5c
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4e
            r7.<init>()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r8 = "vpn_pxy"
            boolean r9 = com.umeng.umzid.d.i(r11)     // Catch: java.lang.Throwable -> L4c
            r7.put(r8, r9)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r8 = "wifi_pxy"
            boolean r9 = com.umeng.umzid.d.j(r11)     // Catch: java.lang.Throwable -> L4c
            r7.put(r8, r9)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r8 = "double"
            boolean r9 = com.umeng.umzid.d.g(r11)     // Catch: java.lang.Throwable -> L4c
            r7.put(r8, r9)     // Catch: java.lang.Throwable -> L4c
            goto L54
        L4c:
            r8 = move-exception
            goto L51
        L4e:
            r7 = move-exception
            r8 = r7
            r7 = r1
        L51:
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L5c
        L54:
            if (r7 == 0) goto L5f
            java.lang.String r8 = "anti"
            r2.put(r8, r7)     // Catch: java.lang.Throwable -> L5c
            goto L5f
        L5c:
            r11 = move-exception
            goto Ld5
        L5f:
            r10.a(r11, r2)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r7 = com.umeng.umzid.d.b(r11)     // Catch: java.lang.Throwable -> L5c
            int r8 = r7.length()     // Catch: java.lang.Throwable -> L5c
            if (r8 <= 0) goto L6d
            goto L6f
        L6d:
            java.lang.String r7 = "https://utoken.umeng.com"
        L6f:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
            r8.<init>()     // Catch: java.lang.Throwable -> L5c
            r8.append(r7)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r7 = "/anti/postZdata"
            r8.append(r7)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r7 = r8.toString()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r2 = com.umeng.umzid.a.a(r7, r2)     // Catch: java.lang.Throwable -> L5c
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L5c
            if (r7 != 0) goto Ld1
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L5c
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r2 = "suc"
            boolean r2 = r7.optBoolean(r2)     // Catch: java.lang.Throwable -> L5c
            if (r2 != r0) goto Ld1
            com.umeng.umzid.d.f(r11, r4)     // Catch: java.lang.Throwable -> L5c
            com.umeng.umzid.d.a(r11, r5)     // Catch: java.lang.Throwable -> L5c
            com.umeng.umzid.d.b(r11, r6)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r0 = "aaid"
            java.lang.String r1 = r7.optString(r0)     // Catch: java.lang.Throwable -> L5c
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L5c
            if (r0 != 0) goto Lb3
            com.umeng.umzid.d.e(r11, r1)     // Catch: java.lang.Throwable -> L5c
        Lb3:
            java.lang.String r0 = "uabc"
            java.lang.String r0 = r7.optString(r0)     // Catch: java.lang.Throwable -> L5c
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L5c
            if (r2 != 0) goto Lc2
            com.umeng.umzid.d.d(r11, r0)     // Catch: java.lang.Throwable -> L5c
        Lc2:
            java.lang.String r0 = "resetToken"
            java.lang.String r0 = r7.optString(r0)     // Catch: java.lang.Throwable -> L5c
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L5c
            if (r2 != 0) goto Ld1
            com.umeng.umzid.d.c(r11, r0)     // Catch: java.lang.Throwable -> L5c
        Ld1:
            r10.a(r11)     // Catch: java.lang.Throwable -> L5c
            goto Ld8
        Ld5:
            r11.printStackTrace()     // Catch: java.lang.Throwable -> Ldb
        Ld8:
            r10.f24887a = r3
        Lda:
            return r1
        Ldb:
            r11 = move-exception
            r10.f24887a = r3
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(com.umeng.umzid.ZIDManager, android.content.Context):java.lang.String");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(40:0|1|(5:89|90|(2:97|98)|92|(37:94|4|5|6|7|8|(2:10|(30:14|15|16|17|18|19|(3:69|70|(5:72|73|(2:76|74)|77|78))|21|(1:23)(1:68)|24|(1:26)(1:67)|27|28|29|30|31|32|33|34|35|36|(1:40)|41|42|43|44|45|(2:47|(2:51|52))|54|55))|87|15|16|17|18|19|(0)|21|(0)(0)|24|(0)(0)|27|28|29|30|31|32|33|34|35|36|(2:38|40)|41|42|43|44|45|(0)|54|55))|3|4|5|6|7|8|(0)|87|15|16|17|18|19|(0)|21|(0)(0)|24|(0)(0)|27|28|29|30|31|32|33|34|35|36|(0)|41|42|43|44|45|(0)|54|55) */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0166, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0167, code lost:
    
        r6.printStackTrace();
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x014d, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x014e, code lost:
    
        r6.printStackTrace();
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0132, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0133, code lost:
    
        r6.printStackTrace();
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00e7, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0074 A[Catch: all -> 0x0088, TryCatch #4 {all -> 0x0088, blocks: (B:6:0x0064, B:8:0x006a, B:10:0x0074, B:12:0x0081, B:14:0x0085), top: B:5:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0193 A[Catch: all -> 0x01a7, TryCatch #2 {all -> 0x01a7, blocks: (B:43:0x0183, B:45:0x0189, B:47:0x0193, B:49:0x01a0, B:51:0x01a4), top: B:42:0x0183 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject a(android.content.Context r11, org.json.JSONObject r12) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }
}
