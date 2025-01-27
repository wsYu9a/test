package cn.vlion.ad.inland.base;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.VlionAESUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.sigmob.sdk.base.mta.PointType;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: b */
    public static volatile o0 f3239b;

    /* renamed from: a */
    public p0 f3240a;

    public static synchronized o0 a() {
        o0 o0Var;
        synchronized (o0.class) {
            try {
                if (f3239b == null) {
                    synchronized (o0.class) {
                        try {
                            if (f3239b == null) {
                                f3239b = new o0();
                            }
                        } finally {
                        }
                    }
                }
                o0Var = f3239b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return o0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0067, code lost:
    
        if (r0 == null) goto L117;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void b(cn.vlion.ad.inland.base.l0 r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "VlionAdxDatabaseHelper deleteAdEvent "
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L18
            cn.vlion.ad.inland.base.p0 r0 = r4.f3240a     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto Lc
            monitor-exit(r4)
            return
        Lc:
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> L5e
            if (r0 != 0) goto L1c
            if (r0 == 0) goto L1a
            r0.close()     // Catch: java.lang.Throwable -> L18
            goto L1a
        L18:
            r5 = move-exception
            goto L73
        L1a:
            monitor-exit(r4)
            return
        L1c:
            java.lang.String r5 = r5.f3057a     // Catch: java.lang.Throwable -> L23
            if (r5 != 0) goto L25
            java.lang.String r5 = ""
            goto L25
        L23:
            r5 = move-exception
            goto L60
        L25:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L23
            r1.<init>()     // Catch: java.lang.Throwable -> L23
            java.lang.String r2 = "VlionAdxDatabaseHelper deleteAdEvent id:"
            r1.append(r2)     // Catch: java.lang.Throwable -> L23
            r1.append(r5)     // Catch: java.lang.Throwable -> L23
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L23
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r1)     // Catch: java.lang.Throwable -> L23
            java.lang.String r1 = "vlion_ad_adx"
            java.lang.String r2 = "KeyId=?"
            java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch: java.lang.Throwable -> L23
            int r5 = r0.delete(r1, r2, r5)     // Catch: java.lang.Throwable -> L23
            long r1 = (long) r5     // Catch: java.lang.Throwable -> L23
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L23
            r5.<init>()     // Catch: java.lang.Throwable -> L23
            java.lang.String r3 = "VlionAdxDatabaseHelper deleteAdEvent i=:"
            r5.append(r3)     // Catch: java.lang.Throwable -> L23
            r5.append(r1)     // Catch: java.lang.Throwable -> L23
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L23
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r5)     // Catch: java.lang.Throwable -> L23
        L5a:
            r0.close()     // Catch: java.lang.Throwable -> L18
            goto L6a
        L5e:
            r5 = move-exception
            r0 = 0
        L60:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r1 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> L6c
            r1.upLoadCatchException(r5)     // Catch: java.lang.Throwable -> L6c
            if (r0 == 0) goto L6a
            goto L5a
        L6a:
            monitor-exit(r4)
            return
        L6c:
            r5 = move-exception
            if (r0 == 0) goto L72
            r0.close()     // Catch: java.lang.Throwable -> L18
        L72:
            throw r5     // Catch: java.lang.Throwable -> L18
        L73:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L18
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.o0.b(cn.vlion.ad.inland.base.l0):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c5, code lost:
    
        if (r0 == null) goto L142;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void a(cn.vlion.ad.inland.base.l0 r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            if (r9 == 0) goto Ld3
            java.lang.String r0 = r9.f3058b     // Catch: java.lang.Throwable -> L32
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L32
            if (r0 == 0) goto Ld
            goto Ld3
        Ld:
            java.lang.String r0 = "VlionAdxDatabaseHelper addAdEvent "
            java.lang.StringBuilder r0 = cn.vlion.ad.inland.base.l1.a(r0)     // Catch: java.lang.Throwable -> L32
            java.lang.String r1 = r9.f3058b     // Catch: java.lang.Throwable -> L32
            r0.append(r1)     // Catch: java.lang.Throwable -> L32
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L32
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L32
            cn.vlion.ad.inland.base.p0 r0 = r8.f3240a     // Catch: java.lang.Throwable -> L32
            if (r0 != 0) goto L25
            monitor-exit(r8)
            return
        L25:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> Lb7
            if (r0 != 0) goto L37
            if (r0 == 0) goto L35
            r0.close()     // Catch: java.lang.Throwable -> L32
            goto L35
        L32:
            r9 = move-exception
            goto Ld1
        L35:
            monitor-exit(r8)
            return
        L37:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r2.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = "VlionAdxDatabaseHelper addAdEvent url=:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = r9.f3058b     // Catch: java.lang.Throwable -> L80
            r2.append(r3)     // Catch: java.lang.Throwable -> L80
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L80
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r2)     // Catch: java.lang.Throwable -> L80
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L80
            r2.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = "KeyId"
            java.lang.String r4 = r9.f3057a     // Catch: java.lang.Throwable -> L80
            r2.put(r3, r4)     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = "EventUrl"
            java.lang.String r4 = r9.f3058b     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = "00190b14bb360d960f731cb0409bfcc2"
            java.lang.String r6 = "0123abcdef456789"
            java.lang.String r4 = cn.vlion.ad.inland.base.util.VlionAESUtils.encrypt(r4, r5, r6)     // Catch: java.lang.Throwable -> L80
            r2.put(r3, r4)     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = r9.f3060d     // Catch: java.lang.Throwable -> L80
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L80
            if (r3 != 0) goto L82
            java.lang.String r3 = "EventUrlHeader"
            java.lang.String r4 = r9.f3060d     // Catch: java.lang.Throwable -> L80
            java.lang.String r5 = "00190b14bb360d960f731cb0409bfcc2"
            java.lang.String r6 = "0123abcdef456789"
            java.lang.String r4 = cn.vlion.ad.inland.base.util.VlionAESUtils.encrypt(r4, r5, r6)     // Catch: java.lang.Throwable -> L80
        L7c:
            r2.put(r3, r4)     // Catch: java.lang.Throwable -> L80
            goto L87
        L80:
            r1 = move-exception
            goto Lbb
        L82:
            java.lang.String r3 = "EventUrlHeader"
            java.lang.String r4 = ""
            goto L7c
        L87:
            java.lang.String r3 = "ApiType"
            java.lang.String r4 = r9.f3059c     // Catch: java.lang.Throwable -> L80
            r2.put(r3, r4)     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = "EventTime"
            long r4 = r9.f3061e     // Catch: java.lang.Throwable -> L80
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> L80
            r2.put(r3, r4)     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = "vlion_ad_adx"
            long r1 = r0.insert(r3, r1, r2)     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r3.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "VlionAdxDatabaseHelper addAdEvent i=:"
            r3.append(r4)     // Catch: java.lang.Throwable -> L80
            r3.append(r1)     // Catch: java.lang.Throwable -> L80
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L80
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r1)     // Catch: java.lang.Throwable -> L80
        Lb3:
            r0.close()     // Catch: java.lang.Throwable -> L32
            goto Lc8
        Lb7:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        Lbb:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r2 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> Lca
            r2.upLoadCatchException(r1)     // Catch: java.lang.Throwable -> Lca
            cn.vlion.ad.inland.base.network.ok.HttpRequestUtil.submitBehaviorRetryAsyn(r9)     // Catch: java.lang.Throwable -> Lca
            if (r0 == 0) goto Lc8
            goto Lb3
        Lc8:
            monitor-exit(r8)
            return
        Lca:
            r9 = move-exception
            if (r0 == 0) goto Ld0
            r0.close()     // Catch: java.lang.Throwable -> L32
        Ld0:
            throw r9     // Catch: java.lang.Throwable -> L32
        Ld1:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L32
            throw r9
        Ld3:
            monitor-exit(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.o0.a(cn.vlion.ad.inland.base.l0):void");
    }

    public final synchronized ArrayList b() {
        SQLiteDatabase sQLiteDatabase;
        Cursor query;
        LogVlion.e("VlionAdxDatabaseHelper queryAdEvent ");
        ArrayList arrayList = new ArrayList();
        p0 p0Var = this.f3240a;
        if (p0Var == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            sQLiteDatabase = p0Var.getWritableDatabase();
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            return arrayList;
        }
        try {
            String str = PointType.DOWNLOAD_TRACKING;
            if (VlionServiceConfigParse.getInstance().getSampleRadio() > 0) {
                str = String.valueOf(VlionServiceConfigParse.getInstance().getSampleRadio());
            }
            String str2 = str;
            LogVlion.e("VlionAdxDatabaseHelper queryAdEvent limit=:" + str2);
            query = sQLiteDatabase.query("vlion_ad_adx", null, null, null, null, null, null, str2);
        } catch (Throwable th3) {
            th = th3;
            try {
                VlionSDkManager.getInstance().upLoadCatchException(th);
                if (0 != 0) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                StringBuilder a10 = l1.a("VlionAdxDatabaseHelper queryAdEvent list=:");
                a10.append(arrayList.size());
                LogVlion.e(a10.toString());
                return arrayList;
            } catch (Throwable th4) {
                if (0 != 0) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th4;
            }
        }
        if (query == null) {
            LogVlion.e("VlionAdxDatabaseHelper queryAdEvent null == cursor=:");
            if (query != null) {
                query.close();
            }
            sQLiteDatabase.close();
            return arrayList;
        }
        LogVlion.e("VlionAdxDatabaseHelper queryAdEvent cursor.getCount()=:" + query.getCount());
        if (query.moveToFirst()) {
            do {
                String string = query.getString(query.getColumnIndexOrThrow("KeyId"));
                String string2 = query.getString(query.getColumnIndexOrThrow("EventUrl"));
                String string3 = query.getString(query.getColumnIndexOrThrow("EventUrlHeader"));
                LogVlion.e("VlionAdxDatabaseHelper 需要:" + string2);
                if (string2 != null && string2.length() > 0 && !string2.startsWith("http")) {
                    string2 = VlionAESUtils.decrypt(string2, HttpRequestUtil.KEY, HttpRequestUtil.IV);
                    LogVlion.e("VlionAdxDatabaseHelper 需要解密 urlString:" + string2);
                    if (TextUtils.isEmpty(string3)) {
                        string3 = "";
                    } else {
                        string3 = VlionAESUtils.decrypt(string3, HttpRequestUtil.KEY, HttpRequestUtil.IV);
                        LogVlion.e("VlionAdxDatabaseHelper 需要解密 urlHeader :" + string3);
                    }
                }
                arrayList.add(new l0(string, string2, query.getString(query.getColumnIndexOrThrow("ApiType")), string3, query.getLong(query.getColumnIndexOrThrow("EventTime"))));
            } while (query.moveToNext());
            query.close();
            sQLiteDatabase.close();
        }
        query.close();
        sQLiteDatabase.close();
        StringBuilder a102 = l1.a("VlionAdxDatabaseHelper queryAdEvent list=:");
        a102.append(arrayList.size());
        LogVlion.e(a102.toString());
        return arrayList;
    }
}
