package cn.vlion.ad.inland.base;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.VlionAESUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.sigmob.sdk.base.mta.PointType;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class u4 {

    /* renamed from: b */
    public static volatile u4 f3396b;

    /* renamed from: a */
    public b6 f3397a;

    public static synchronized u4 a() {
        u4 u4Var;
        synchronized (u4.class) {
            try {
                if (f3396b == null) {
                    synchronized (u4.class) {
                        try {
                            if (f3396b == null) {
                                f3396b = new u4();
                            }
                        } finally {
                        }
                    }
                }
                u4Var = f3396b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return u4Var;
    }

    public final synchronized void a(n0 n0Var) {
        Throwable th2;
        SQLiteDatabase sQLiteDatabase;
        if (n0Var == null) {
            return;
        }
        b6 b6Var = this.f3397a;
        if (b6Var == null) {
            return;
        }
        try {
            sQLiteDatabase = b6Var.getWritableDatabase();
        } catch (Throwable th3) {
            th2 = th3;
            sQLiteDatabase = null;
        }
        try {
            LogVlion.e("VlionDatabaseHelper addAdEvent getDatabaseVersion=:" + sQLiteDatabase.getVersion());
            LogVlion.e("VlionDatabaseHelper addAdEvent KEY_ID=:" + n0Var.f3107a + " EVENT_TYPE=" + n0Var.f3108b + " EVENT_STRING=" + n0Var.f3109c);
            ContentValues contentValues = new ContentValues();
            contentValues.put("KeyId", n0Var.f3107a);
            contentValues.put("EventType", n0Var.f3108b);
            contentValues.put("EventString", VlionAESUtils.encrypt(n0Var.f3109c, HttpRequestUtil.KEY, HttpRequestUtil.IV));
            LogVlion.e("VlionDatabaseHelper addAdEvent i=:" + sQLiteDatabase.insert("vlion_ad_event", null, contentValues));
            sQLiteDatabase.close();
        } catch (Throwable th4) {
            th2 = th4;
            try {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                ArrayList arrayList = new ArrayList();
                arrayList.add(n0Var);
                e6 e6Var = f6.f2802a;
                JSONArray jSONArray = new JSONArray();
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    try {
                        n0 n0Var2 = (n0) arrayList.get(i10);
                        if (n0Var2 != null) {
                            jSONArray.put(f6.a(n0Var2.f3109c));
                        }
                    } catch (Throwable th5) {
                        VlionSDkManager.getInstance().upLoadCatchException(th5);
                    }
                }
                String jSONArray2 = jSONArray.toString();
                String str = "";
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(h3.e.f26408m, VlionAESUtils.encrypt(jSONArray2, HttpRequestUtil.KEY, HttpRequestUtil.IV));
                    str = jSONObject.toString();
                } catch (Throwable th6) {
                    VlionSDkManager.getInstance().upLoadCatchException(th6);
                    LogVlion.e("SendJsonAESData == 请求参数=====Exception=" + th6);
                }
                LogVlion.e("SendJsonAESData === 请求参数=====" + str);
                LogVlion.e("VlionSendMessageThread 准备发送数据，加密数据 sendData:" + str);
                HttpRequestUtil.uploadAdEventAsyn(VlionServiceConfigParse.getInstance().getReportUrl(), str);
            } finally {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c4, code lost:
    
        if (0 == 0) goto L145;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void a(java.util.ArrayList r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            cn.vlion.ad.inland.base.b6 r0 = r7.f3397a     // Catch: java.lang.Throwable -> L1e
            if (r0 != 0) goto L7
            monitor-exit(r7)
            return
        L7:
            int r0 = r8.size()     // Catch: java.lang.Throwable -> L1e
            if (r0 != 0) goto Lf
            monitor-exit(r7)
            return
        Lf:
            r0 = 0
            cn.vlion.ad.inland.base.b6 r1 = r7.f3397a     // Catch: java.lang.Throwable -> L6d
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L6d
            if (r0 != 0) goto L23
            if (r0 == 0) goto L21
            r0.close()     // Catch: java.lang.Throwable -> L1e
            goto L21
        L1e:
            r8 = move-exception
            goto Ld0
        L21:
            monitor-exit(r7)
            return
        L23:
            int r1 = r8.size()     // Catch: java.lang.Throwable -> L6d
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L6d
            r3 = 0
        L2a:
            if (r3 >= r1) goto L72
            java.lang.Object r4 = r8.get(r3)     // Catch: java.lang.Throwable -> L6d
            cn.vlion.ad.inland.base.n0 r4 = (cn.vlion.ad.inland.base.n0) r4     // Catch: java.lang.Throwable -> L6d
            if (r4 == 0) goto L6f
            java.lang.String r5 = r4.f3107a     // Catch: java.lang.Throwable -> L6d
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L6d
            if (r5 != 0) goto L6f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d
            r5.<init>()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r6 = "\""
            r5.append(r6)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r6 = r4.f3107a     // Catch: java.lang.Throwable -> L6d
            r5.append(r6)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r6 = "\""
            r5.append(r6)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L6d
            r2[r3] = r5     // Catch: java.lang.Throwable -> L6d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d
            r5.<init>()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r6 = "VlionDatabaseHelper deleteAdEvent vlionAdEvent.getKeyId()=:"
            r5.append(r6)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r4 = r4.f3107a     // Catch: java.lang.Throwable -> L6d
            r5.append(r4)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L6d
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r4)     // Catch: java.lang.Throwable -> L6d
            goto L6f
        L6d:
            r8 = move-exception
            goto Lbd
        L6f:
            int r3 = r3 + 1
            goto L2a
        L72:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d
            r8.<init>()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r3 = "DELETE FROM vlion_ad_event WHERE KeyId IN ("
            r8.append(r3)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r3 = ", "
            java.lang.String r2 = android.text.TextUtils.join(r3, r2)     // Catch: java.lang.Throwable -> L6d
            r8.append(r2)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r2 = ")"
            r8.append(r2)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L6d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d
            r2.<init>()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r3 = "VlionDatabaseHelper deleteAdEvent deleteQuery=:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L6d
            r2.append(r8)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L6d
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r2)     // Catch: java.lang.Throwable -> L6d
            r0.execSQL(r8)     // Catch: java.lang.Throwable -> L6d
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d
            r8.<init>()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r2 = "VlionDatabaseHelper deleteAdEvent i=:"
            r8.append(r2)     // Catch: java.lang.Throwable -> L6d
            r8.append(r1)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L6d
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r8)     // Catch: java.lang.Throwable -> L6d
        Lb9:
            r0.close()     // Catch: java.lang.Throwable -> L1e
            goto Lc7
        Lbd:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r1 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> Lc9
            r1.upLoadCatchException(r8)     // Catch: java.lang.Throwable -> Lc9
            if (r0 == 0) goto Lc7
            goto Lb9
        Lc7:
            monitor-exit(r7)
            return
        Lc9:
            r8 = move-exception
            if (r0 == 0) goto Lcf
            r0.close()     // Catch: java.lang.Throwable -> L1e
        Lcf:
            throw r8     // Catch: java.lang.Throwable -> L1e
        Ld0:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L1e
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.u4.a(java.util.ArrayList):void");
    }

    public final synchronized ArrayList a(String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor query;
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        b6 b6Var = this.f3397a;
        if (b6Var == null) {
            return arrayList;
        }
        Cursor cursor2 = null;
        try {
            sQLiteDatabase = b6Var.getWritableDatabase();
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
            String str2 = PointType.DOWNLOAD_TRACKING;
            if (VlionServiceConfigParse.getInstance().getSampleRadio() > 0) {
                str2 = String.valueOf(VlionServiceConfigParse.getInstance().getSampleRadio());
            }
            String str3 = str2;
            LogVlion.e("VlionDatabaseHelper queryAdEvent limit=:" + str3 + " eventType = " + str);
            if ("100".equals(str)) {
                LogVlion.e("VlionDatabaseHelper queryAdEvent Real_time=:");
                query = sQLiteDatabase.query("vlion_ad_event", null, "EventType=?", new String[]{str}, null, null, null, str3);
            } else {
                LogVlion.e("VlionDatabaseHelper queryAdEvent all=:");
                query = sQLiteDatabase.query("vlion_ad_event", null, null, null, null, null, null, str3);
            }
            cursor = query;
        } catch (Throwable th3) {
            th = th3;
            try {
                VlionSDkManager.getInstance().upLoadCatchException(th);
            } finally {
                if (0 != 0) {
                    cursor2.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
        if (cursor == null) {
            LogVlion.e("VlionDatabaseHelper queryAdEvent null == cursor=:");
            if (cursor != null) {
                cursor.close();
            }
            sQLiteDatabase.close();
            return arrayList;
        }
        LogVlion.e("VlionDatabaseHelper queryAdEvent cursor.getCount()=:" + cursor.getCount());
        if (cursor.moveToFirst()) {
            LogVlion.e("VlionDatabaseHelper i =:0");
            int i10 = 1;
            while (true) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionDatabaseHelper i =:");
                int i11 = i10 + 1;
                sb2.append(i10);
                LogVlion.e(sb2.toString());
                String string = cursor.getString(cursor.getColumnIndexOrThrow("KeyId"));
                String string2 = cursor.getString(cursor.getColumnIndexOrThrow("EventType"));
                String string3 = cursor.getString(cursor.getColumnIndexOrThrow("EventString"));
                LogVlion.e("VlionDatabaseHelper eventString:" + string3);
                if (string3 != null && string3.length() > 0 && !string3.startsWith("{")) {
                    string3 = VlionAESUtils.decrypt(string3, HttpRequestUtil.KEY, HttpRequestUtil.IV);
                    LogVlion.e("VlionDatabaseHelper 需要解密:" + string3);
                }
                arrayList.add(new n0(string, string2, string3));
                if (!cursor.moveToNext()) {
                    break;
                }
                i10 = i11;
            }
            cursor.close();
            sQLiteDatabase.close();
        }
        cursor.close();
        StringBuilder a10 = l1.a("VlionDatabaseHelper queryAdEvent list=:");
        a10.append(arrayList.size());
        LogVlion.e(a10.toString());
        return arrayList;
    }
}
