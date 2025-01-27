package u2;

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

/* loaded from: classes.dex */
public class e {

    /* renamed from: g */
    public static volatile e f30931g = null;

    /* renamed from: h */
    public static boolean f30932h = false;

    /* renamed from: f */
    public BroadcastReceiver f30938f;

    /* renamed from: a */
    public a f30933a = new a("udid");

    /* renamed from: b */
    public a f30934b = new a(AdKeys.OAID);

    /* renamed from: d */
    public a f30936d = new a("vaid");

    /* renamed from: c */
    public a f30935c = new a("aaid");

    /* renamed from: e */
    public c f30937e = new c();

    public static String b(PackageManager packageManager, String str) {
        ProviderInfo resolveContentProvider;
        if (packageManager == null || (resolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (resolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return resolveContentProvider.packageName;
    }

    public static d c(Cursor cursor) {
        String str;
        d dVar = new d(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    dVar.f30928a = cursor.getString(columnIndex);
                } else {
                    e("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    dVar.f30929b = cursor.getInt(columnIndex2);
                } else {
                    e("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    dVar.f30930c = cursor.getLong(columnIndex3);
                } else {
                    e("parseExpired fail, index < 0.");
                }
                return dVar;
            }
            str = "parseValue fail, cursor is closed.";
        }
        e(str);
        return dVar;
    }

    public static final e d() {
        if (f30931g == null) {
            synchronized (e.class) {
                try {
                    if (f30931g == null) {
                        f30931g = new e();
                    }
                } finally {
                }
            }
        }
        return f30931g;
    }

    public static void e(String str) {
        if (f30932h) {
            Log.d("OpenIdManager", str);
        }
    }

    public static void f(boolean z10) {
        f30932h = z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
    
        if ("0".equals(r8.f30928a) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        if (r7 != null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
    
        if (r7 == null) goto L84;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean g(android.content.Context r8) {
        /*
            java.lang.String r0 = "querySupport version : 1.0.8"
            e(r0)
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
            u2.d r8 = c(r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            int r1 = r8.f30929b     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r2 != r1) goto L39
            java.lang.String r1 = "0"
            java.lang.String r8 = r8.f30928a     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            boolean r8 = r1.equals(r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            if (r8 == 0) goto L3a
            goto L39
        L35:
            r8 = move-exception
            goto L5c
        L37:
            r8 = move-exception
            goto L41
        L39:
            r0 = 1
        L3a:
            r7.close()
            return r0
        L3e:
            if (r7 == 0) goto L5b
            goto L58
        L41:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            java.lang.String r2 = "querySupport, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L35
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L35
            r1.append(r8)     // Catch: java.lang.Throwable -> L35
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> L35
            e(r8)     // Catch: java.lang.Throwable -> L35
            if (r7 == 0) goto L5b
        L58:
            r7.close()
        L5b:
            return r0
        L5c:
            if (r7 == 0) goto L61
            r7.close()
        L61:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.e.g(android.content.Context):boolean");
    }

    public static String j(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            e("getAppVersion, Exception : " + e10.getMessage());
            return null;
        }
    }

    public final String a(Context context, a aVar) {
        String str;
        if (aVar == null) {
            str = "getId, openId = null.";
        } else {
            if (aVar.d()) {
                return aVar.f30921b;
            }
            if (h(context, true)) {
                return i(context, aVar);
            }
            str = "getId, isSupported = false.";
        }
        e(str);
        return null;
    }

    public final boolean h(Context context, boolean z10) {
        if (this.f30937e.b() && !z10) {
            return this.f30937e.e();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String b10 = b(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(b10)) {
            return false;
        }
        String j10 = j(packageManager, b10);
        if (this.f30937e.b() && this.f30937e.c(j10)) {
            e("use same version cache, safeVersion : ".concat(String.valueOf(j10)));
            return this.f30937e.e();
        }
        this.f30937e.d(j10);
        boolean g10 = g(context);
        e("query support, result : ".concat(String.valueOf(g10)));
        this.f30937e.a(g10);
        return g10;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String i(android.content.Context r8, u2.a r9) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "queryId : "
            r0.<init>(r1)
            java.lang.String r1 = r9.f30922c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            e(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r3 = r9.f30922c     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String[] r5 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            r6 = 0
            r3 = 0
            r4 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L82
            u2.d r4 = c(r1)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            java.lang.String r0 = r4.f30928a     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            r9.c(r0)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            long r5 = r4.f30930c     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            r9.b(r5)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            int r5 = r4.f30929b     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            r9.a(r5)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            r5.<init>()     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            java.lang.String r6 = r9.f30922c     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            r5.append(r6)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            java.lang.String r6 = " errorCode : "
            r5.append(r6)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            int r9 = r9.f30923d     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            r5.append(r9)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            java.lang.String r9 = r5.toString()     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            e(r9)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            int r9 = r4.f30929b     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r9 == r4) goto L96
            r7.k(r8)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            boolean r9 = r7.h(r8, r3)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            if (r9 != 0) goto L96
            boolean r8 = r7.h(r8, r2)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            java.lang.String r9 = "not support, forceQuery isSupported: "
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
        L76:
            java.lang.String r8 = r9.concat(r8)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            goto L93
        L7b:
            r8 = move-exception
            r0 = r1
            goto Lbc
        L7e:
            r8 = move-exception
            r9 = r0
            r0 = r1
            goto L9d
        L82:
            boolean r9 = r7.h(r8, r3)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            if (r9 == 0) goto L96
            boolean r8 = r7.h(r8, r2)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            java.lang.String r9 = "forceQuery isSupported : "
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            goto L76
        L93:
            e(r8)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
        L96:
            if (r1 == 0) goto Lbb
            goto Lb6
        L99:
            r8 = move-exception
            goto Lbc
        L9b:
            r8 = move-exception
            r9 = r0
        L9d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = "queryId, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L99
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L99
            r1.append(r8)     // Catch: java.lang.Throwable -> L99
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> L99
            e(r8)     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto Lba
            r1 = r0
            r0 = r9
        Lb6:
            r1.close()
            goto Lbb
        Lba:
            r0 = r9
        Lbb:
            return r0
        Lbc:
            if (r0 == 0) goto Lc1
            r0.close()
        Lc1:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.e.i(android.content.Context, u2.a):java.lang.String");
    }

    public final synchronized void k(Context context) {
        if (this.f30938f != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        com.alipay.sdk.m.i0.e eVar = new com.alipay.sdk.m.i0.e();
        this.f30938f = eVar;
        context.registerReceiver(eVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }
}
