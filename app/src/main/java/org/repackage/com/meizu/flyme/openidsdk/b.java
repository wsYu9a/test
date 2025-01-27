package org.repackage.com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.shu.priory.config.AdKeys;

/* loaded from: classes4.dex */
class b {

    /* renamed from: e */
    private static volatile b f29378e = null;

    /* renamed from: f */
    private static boolean f29379f = false;

    /* renamed from: h */
    private BroadcastReceiver f29385h;

    /* renamed from: a */
    OpenId f29380a = new OpenId("udid");

    /* renamed from: b */
    OpenId f29381b = new OpenId(AdKeys.OAID);

    /* renamed from: d */
    OpenId f29383d = new OpenId("vaid");

    /* renamed from: c */
    OpenId f29382c = new OpenId("aaid");

    /* renamed from: g */
    private SupportInfo f29384g = new SupportInfo();

    private b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009c  */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(android.content.Context r8, org.repackage.com.meizu.flyme.openidsdk.OpenId r9) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "queryId : "
            r0.<init>(r1)
            java.lang.String r1 = r9.f29369c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            a(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.String r3 = r9.f29369c     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.String[] r5 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            r6 = 0
            r3 = 0
            r4 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L85
            org.repackage.com.meizu.flyme.openidsdk.ValueData r4 = a(r1)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.String r0 = r4.f29375a     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r9.a(r0)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            long r5 = r4.f29377c     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r9.a(r5)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            int r5 = r4.f29376b     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r9.a(r5)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r5.<init>()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.String r6 = r9.f29369c     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r5.append(r6)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.String r6 = " errorCode : "
            r5.append(r6)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            int r9 = r9.f29370d     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r5.append(r9)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.String r9 = r5.toString()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            a(r9)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            int r9 = r4.f29376b     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r9 == r4) goto L9a
            r7.b(r8)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            boolean r9 = r7.a(r8, r3)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            if (r9 != 0) goto L9a
            boolean r8 = r7.a(r8, r2)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.String r9 = "not support, forceQuery isSupported: "
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.String r8 = r9.concat(r8)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
        L7a:
            a(r8)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            goto L9a
        L7e:
            r8 = move-exception
            r0 = r1
            goto Lc0
        L81:
            r8 = move-exception
            r9 = r0
            r0 = r1
            goto La4
        L85:
            boolean r9 = r7.a(r8, r3)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            if (r9 == 0) goto L9a
            boolean r8 = r7.a(r8, r2)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.String r9 = "forceQuery isSupported : "
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.String r8 = r9.concat(r8)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            goto L7a
        L9a:
            if (r1 == 0) goto Lbf
            r1.close()
            goto Lbf
        La0:
            r8 = move-exception
            goto Lc0
        La2:
            r8 = move-exception
            r9 = r0
        La4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0
            java.lang.String r2 = "queryId, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> La0
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> La0
            r1.append(r8)     // Catch: java.lang.Throwable -> La0
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> La0
            a(r8)     // Catch: java.lang.Throwable -> La0
            if (r0 == 0) goto Lbe
            r0.close()
        Lbe:
            r0 = r9
        Lbf:
            return r0
        Lc0:
            if (r0 == 0) goto Lc5
            r0.close()
        Lc5:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.meizu.flyme.openidsdk.b.b(android.content.Context, org.repackage.com.meizu.flyme.openidsdk.OpenId):java.lang.String");
    }

    public final String a(Context context, OpenId openId) {
        String str;
        if (openId == null) {
            str = "getId, openId = null.";
        } else {
            if (openId.a()) {
                return openId.f29368b;
            }
            if (a(context, true)) {
                return b(context, openId);
            }
            str = "getId, isSupported = false.";
        }
        a(str);
        return null;
    }

    private static String a(PackageManager packageManager, String str) {
        ProviderInfo resolveContentProvider;
        if (packageManager == null || (resolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (resolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return resolveContentProvider.packageName;
    }

    private static String b(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            a("getAppVersion, Exception : " + e10.getMessage());
            return null;
        }
    }

    private static ValueData a(Cursor cursor) {
        String str;
        ValueData valueData = new ValueData(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    valueData.f29375a = cursor.getString(columnIndex);
                } else {
                    a("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    valueData.f29376b = cursor.getInt(columnIndex2);
                } else {
                    a("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    valueData.f29377c = cursor.getLong(columnIndex3);
                } else {
                    a("parseExpired fail, index < 0.");
                }
                return valueData;
            }
            str = "parseValue fail, cursor is closed.";
        }
        a(str);
        return valueData;
    }

    private synchronized void b(Context context) {
        if (this.f29385h != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        a aVar = new a();
        this.f29385h = aVar;
        context.registerReceiver(aVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    public static final b a() {
        if (f29378e == null) {
            synchronized (b.class) {
                try {
                    if (f29378e == null) {
                        f29378e = new b();
                    }
                } finally {
                }
            }
        }
        return f29378e;
    }

    public static void a(String str) {
        if (f29379f) {
            Log.d("OpenIdManager", str);
        }
    }

    public static void a(boolean z10) {
        f29379f = z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005c, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
    
        if (r7 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0032, code lost:
    
        if ("0".equals(r8.f29375a) != false) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.content.Context r8) {
        /*
            java.lang.String r0 = "querySupport version : 1.0.8"
            a(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            java.lang.String r8 = "supported"
            java.lang.String[] r5 = new java.lang.String[]{r8}     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            r6 = 0
            r3 = 0
            r4 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            if (r7 == 0) goto L3e
            org.repackage.com.meizu.flyme.openidsdk.ValueData r8 = a(r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            int r1 = r8.f29376b     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r2 != r1) goto L39
            java.lang.String r1 = "0"
            java.lang.String r8 = r8.f29375a     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            boolean r8 = r1.equals(r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            if (r8 == 0) goto L3a
            goto L39
        L35:
            r8 = move-exception
            goto L5d
        L37:
            r8 = move-exception
            goto L44
        L39:
            r0 = 1
        L3a:
            r7.close()
            return r0
        L3e:
            if (r7 == 0) goto L5c
        L40:
            r7.close()
            goto L5c
        L44:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            java.lang.String r2 = "querySupport, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L35
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L35
            r1.append(r8)     // Catch: java.lang.Throwable -> L35
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> L35
            a(r8)     // Catch: java.lang.Throwable -> L35
            if (r7 == 0) goto L5c
            goto L40
        L5c:
            return r0
        L5d:
            if (r7 == 0) goto L62
            r7.close()
        L62:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.meizu.flyme.openidsdk.b.a(android.content.Context):boolean");
    }

    public final boolean a(Context context, boolean z10) {
        if (this.f29384g.a() && !z10) {
            return this.f29384g.b();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String a10 = a(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(a10)) {
            return false;
        }
        String b10 = b(packageManager, a10);
        if (this.f29384g.a() && this.f29384g.a(b10)) {
            a("use same version cache, safeVersion : ".concat(String.valueOf(b10)));
            return this.f29384g.b();
        }
        this.f29384g.b(b10);
        boolean a11 = a(context);
        a("query support, result : ".concat(String.valueOf(a11)));
        this.f29384g.a(a11);
        return a11;
    }
}
