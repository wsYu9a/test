package com.jd.ad.sdk.jad_xk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.logger.Logger;
import com.umeng.analytics.pro.f;
import java.nio.charset.StandardCharsets;

/* loaded from: classes2.dex */
public class jad_cp extends com.jd.ad.sdk.jad_sf.jad_an {
    public static jad_cp jad_bo;

    public jad_cp(Context context, String str, int i10) {
        super(context, str, i10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:6:0x0048). Please report as a decompilation issue!!! */
    public synchronized void jad_an(jad_dq jad_dqVar, String str) {
        if (jad_dqVar != null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    getWritableDatabase();
                    if (!jad_bo()) {
                        return;
                    }
                    ContentValues jad_bo2 = jad_bo(jad_dqVar, str);
                    int i10 = jad_dqVar.jad_an;
                    if (i10 > 0) {
                        this.jad_an.update(f.ax, jad_bo2, "_id=?", new String[]{String.valueOf(i10)});
                    } else {
                        this.jad_an.insert(f.ax, null, jad_bo2);
                    }
                } catch (Throwable th2) {
                    Logger.w("Exception while saving events: ", th2);
                }
            }
        }
    }

    public final ContentValues jad_bo(jad_dq jad_dqVar, String str) {
        ContentValues contentValues;
        try {
            contentValues = new ContentValues(4);
            try {
                String jSONObject = jad_dqVar.jad_an().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    String ja2 = ANEProxy.ja(jSONObject);
                    if (TextUtils.isEmpty(ja2)) {
                        return contentValues;
                    }
                    byte[] bytes = ja2.getBytes(StandardCharsets.UTF_8);
                    if (bytes != null && bytes.length > 0) {
                        contentValues.put(NotificationCompat.CATEGORY_EVENT, new String(bytes));
                        if (!TextUtils.isEmpty(str)) {
                            contentValues.put(ContentProviderManager.PLUGIN_PROCESS_NAME, str);
                        }
                    }
                    return contentValues;
                }
            } catch (Exception e10) {
                e = e10;
                Logger.w("Exception while add event: ", e.getMessage());
                return contentValues;
            }
        } catch (Exception e11) {
            e = e11;
            contentValues = null;
        }
        return contentValues;
    }

    public void jad_cp() {
        try {
            getWritableDatabase();
            if (jad_bo()) {
                this.jad_an.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT,%s ,%s)", f.ax, NotificationCompat.CATEGORY_EVENT, ContentProviderManager.PLUGIN_PROCESS_NAME));
            }
        } catch (Exception e10) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_CREATE_DB_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT,%s,%s)", f.ax, NotificationCompat.CATEGORY_EVENT, ContentProviderManager.PLUGIN_PROCESS_NAME));
        } catch (Exception e10) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_CREATE_DB_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
        }
        this.jad_an = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        onCreate(sQLiteDatabase);
    }

    public synchronized Cursor jad_an(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return null;
            }
            return this.jad_an.query(f.ax, null, "process_name =?", new String[]{str}, null, null, null);
        } catch (Throwable th2) {
            Logger.w("Exception while loading events: ", th2.getMessage());
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r3.inTransaction() != false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
    
        r2.jad_an.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
    
        if (r3.inTransaction() != false) goto L123;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void jad_an(java.lang.String r3, java.lang.String[] r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L3c
            boolean r0 = r2.jad_bo()     // Catch: java.lang.Throwable -> L3c
            if (r0 != 0) goto L20
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r3 == 0) goto L1e
            boolean r3 = r3.inTransaction()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r3 == 0) goto L1e
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            r3.endTransaction()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            goto L1e
        L1a:
            r3 = move-exception
            goto L72
        L1c:
            r3 = move-exception
            goto L6d
        L1e:
            monitor-exit(r2)
            return
        L20:
            android.database.sqlite.SQLiteDatabase r0 = r2.jad_an     // Catch: java.lang.Throwable -> L3c
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L3c
            android.database.sqlite.SQLiteDatabase r0 = r2.jad_an     // Catch: java.lang.Throwable -> L3c
            java.lang.String r1 = "events"
            r0.delete(r1, r3, r4)     // Catch: java.lang.Throwable -> L3c
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L3c
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L3c
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r3 == 0) goto L70
            boolean r3 = r3.inTransaction()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r3 == 0) goto L70
            goto L56
        L3c:
            r3 = move-exception
            java.lang.String r4 = "Exception while clearing event: "
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L5c
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L5c
            r1 = 0
            r0[r1] = r3     // Catch: java.lang.Throwable -> L5c
            com.jd.ad.sdk.logger.Logger.w(r4, r0)     // Catch: java.lang.Throwable -> L5c
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r3 == 0) goto L70
            boolean r3 = r3.inTransaction()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r3 == 0) goto L70
        L56:
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            r3.endTransaction()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            goto L70
        L5c:
            r3 = move-exception
            android.database.sqlite.SQLiteDatabase r4 = r2.jad_an     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r4 == 0) goto L6c
            boolean r4 = r4.inTransaction()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r4 == 0) goto L6c
            android.database.sqlite.SQLiteDatabase r4 = r2.jad_an     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            r4.endTransaction()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
        L6c:
            throw r3     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
        L6d:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L1a
        L70:
            monitor-exit(r2)
            return
        L72:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1a
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_xk.jad_cp.jad_an(java.lang.String, java.lang.String[]):void");
    }
}
