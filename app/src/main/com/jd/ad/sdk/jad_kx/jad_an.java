package com.jd.ad.sdk.jad_kx;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class jad_an extends com.jd.ad.sdk.jad_sf.jad_an {
    public static jad_an jad_cp;
    public static final List<String> jad_dq = new ArrayList();
    public final List<String> jad_bo;

    /* renamed from: com.jd.ad.sdk.jad_kx.jad_an$jad_an */
    public class RunnableC0331jad_an implements Runnable {
        public RunnableC0331jad_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            jad_an jad_anVar = jad_an.this;
            List<String> list = jad_an.jad_dq;
            synchronized (jad_anVar) {
                jad_anVar.jad_an(list);
            }
        }
    }

    public jad_an(Context context, String str, int i10) {
        super(context, str, i10);
        this.jad_bo = new ArrayList();
    }

    public static synchronized jad_an jad_dq() {
        jad_an jad_anVar;
        synchronized (jad_an.class) {
            try {
                if (jad_cp == null) {
                    jad_cp = new jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an(), "jaddb.db", 2);
                }
                jad_anVar = jad_cp;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return jad_anVar;
    }

    public synchronized void jad_an(jad_cp jad_cpVar) {
        try {
            getWritableDatabase();
        } finally {
        }
        if (jad_bo()) {
            ContentValues jad_bo = jad_bo(jad_cpVar);
            int i10 = jad_cpVar.jad_an;
            if (i10 > 0) {
                this.jad_an.update("preloadAd", jad_bo, "_id=?", new String[]{String.valueOf(i10)});
            } else {
                this.jad_an.insert("preloadAd", null, jad_bo);
            }
        }
    }

    public final ContentValues jad_bo(jad_cp jad_cpVar) {
        ContentValues contentValues;
        try {
            contentValues = new ContentValues();
            try {
                contentValues.put("appIdSlotId", jad_cpVar.jad_cp);
                contentValues.put("rId", jad_cpVar.jad_bo);
                contentValues.put("preloadAdJson", ANEProxy.ja(jad_cpVar.jad_dq));
                contentValues.put("preloadAdCacheTimeStamp", jad_cpVar.jad_er);
            } catch (Exception e10) {
                e = e10;
                Logger.w("Exception while add preload ad data: ", e.getMessage());
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
                this.jad_an.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", "preloadAd", "appIdSlotId", "rId", "preloadAdJson", "preloadAdCacheTimeStamp"));
            }
        } catch (Exception e10) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_CREATE_DB_TABLE_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
        }
    }

    public synchronized Cursor jad_er() {
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return null;
            }
            return this.jad_an.query("preloadAd", null, null, null, null, null, "preloadAdCacheTimeStamp ASC");
        } catch (Throwable th2) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th2.getMessage()));
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.jad_an = sQLiteDatabase;
        try {
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT,%s TEXT, %s TEXT)", "preloadAd", "appIdSlotId", "rId", "preloadAdJson", "preloadAdCacheTimeStamp"));
        } catch (Exception e10) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_CREATE_DB_TABLE_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
        }
        this.jad_an = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preloadAd");
        onCreate(sQLiteDatabase);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00aa, code lost:
    
        if (r1.isClosed() == false) goto L140;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<com.jd.ad.sdk.jad_kx.jad_cp> jad_an(java.lang.String r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lad
            r0.<init>()     // Catch: java.lang.Throwable -> Lad
            r1 = 0
            r12.getReadableDatabase()     // Catch: java.lang.Throwable -> L8e
            boolean r2 = r12.jad_bo()     // Catch: java.lang.Throwable -> L8e
            if (r2 != 0) goto L12
            monitor-exit(r12)
            return r0
        L12:
            java.lang.String r6 = "appIdSlotId =?"
            java.lang.String r2 = java.lang.String.valueOf(r13)     // Catch: java.lang.Throwable -> L8e
            java.lang.String[] r7 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L8e
            java.lang.String r10 = "preloadAdCacheTimeStamp ASC"
            android.database.sqlite.SQLiteDatabase r3 = r12.jad_an     // Catch: java.lang.Throwable -> L8e
            java.lang.String r4 = "preloadAd"
            r8 = 0
            r9 = 0
            r5 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L8e
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L8e
            if (r2 <= 0) goto La6
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L8e
            com.jd.ad.sdk.jad_kx.jad_er r2 = com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an     // Catch: java.lang.Throwable -> L8e
            int r2 = r2.jad_bo()     // Catch: java.lang.Throwable -> L8e
            long r2 = (long) r2     // Catch: java.lang.Throwable -> L8e
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r4
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8e
            long r4 = r4 - r2
        L42:
            boolean r2 = r1.isAfterLast()     // Catch: java.lang.Throwable -> L8e
            if (r2 != 0) goto L9b
            java.lang.String r2 = "_id"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L8e
            int r7 = r1.getInt(r2)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r2 = "preloadAdCacheTimeStamp"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r11 = r1.getString(r2)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r2 = "rId"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r9 = r1.getString(r2)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r2 = "preloadAdJson"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r10 = com.jd.ad.sdk.fdt.utils.ANEProxy.jb(r2)     // Catch: java.lang.Throwable -> L8e
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L8e
            if (r2 != 0) goto L90
            long r2 = java.lang.Long.parseLong(r11)     // Catch: java.lang.Throwable -> L8e
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L83
            goto L90
        L83:
            com.jd.ad.sdk.jad_kx.jad_cp r2 = new com.jd.ad.sdk.jad_kx.jad_cp     // Catch: java.lang.Throwable -> L8e
            r6 = r2
            r8 = r13
            r6.<init>(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L8e
            r0.add(r2)     // Catch: java.lang.Throwable -> L8e
            goto L97
        L8e:
            r13 = move-exception
            goto Laf
        L90:
            java.util.List<java.lang.String> r2 = com.jd.ad.sdk.jad_kx.jad_an.jad_dq     // Catch: java.lang.Throwable -> L8e
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch: java.lang.Throwable -> L8e
            r2.add(r9)     // Catch: java.lang.Throwable -> L8e
        L97:
            r1.moveToNext()     // Catch: java.lang.Throwable -> L8e
            goto L42
        L9b:
            r1.close()     // Catch: java.lang.Throwable -> L8e
            com.jd.ad.sdk.jad_kx.jad_an$jad_an r13 = new com.jd.ad.sdk.jad_kx.jad_an$jad_an     // Catch: java.lang.Throwable -> L8e
            r13.<init>()     // Catch: java.lang.Throwable -> L8e
            com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(r13)     // Catch: java.lang.Throwable -> L8e
        La6:
            boolean r13 = r1.isClosed()     // Catch: java.lang.Throwable -> Lad
            if (r13 != 0) goto Lcf
            goto Lcc
        Lad:
            r13 = move-exception
            goto Lde
        Laf:
            java.lang.String r2 = ""
            com.jd.ad.sdk.jad_wj.jad_an r3 = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR     // Catch: java.lang.Throwable -> Ld1
            int r4 = r3.jad_an     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r13 = r13.getMessage()     // Catch: java.lang.Throwable -> Ld1
            java.lang.String[] r13 = new java.lang.String[]{r13}     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r13 = r3.jad_an(r13)     // Catch: java.lang.Throwable -> Ld1
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an(r2, r4, r13)     // Catch: java.lang.Throwable -> Ld1
            if (r1 == 0) goto Lcf
            boolean r13 = r1.isClosed()     // Catch: java.lang.Throwable -> Lad
            if (r13 != 0) goto Lcf
        Lcc:
            r1.close()     // Catch: java.lang.Throwable -> Lad
        Lcf:
            monitor-exit(r12)
            return r0
        Ld1:
            r13 = move-exception
            if (r1 == 0) goto Ldd
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> Lad
            if (r0 != 0) goto Ldd
            r1.close()     // Catch: java.lang.Throwable -> Lad
        Ldd:
            throw r13     // Catch: java.lang.Throwable -> Lad
        Lde:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> Lad
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_kx.jad_an.jad_an(java.lang.String):java.util.List");
    }

    public synchronized Cursor jad_bo(String str) {
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return null;
            }
            return this.jad_an.query("preloadAd", null, "appIdSlotId =?", new String[]{String.valueOf(str)}, null, null, "preloadAdCacheTimeStamp ASC");
        } catch (Throwable th2) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th2.getMessage()));
            return null;
        }
    }

    public synchronized void jad_an(List<String> list) {
        SQLiteDatabase sQLiteDatabase;
        if (list != null) {
            try {
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (list.size() != 0) {
                try {
                    getWritableDatabase();
                } catch (Throwable th2) {
                    try {
                        Logger.w("Exception while clearing preload ad data:", th2.getMessage());
                        SQLiteDatabase sQLiteDatabase2 = this.jad_an;
                        if (sQLiteDatabase2 != null && sQLiteDatabase2.inTransaction()) {
                            sQLiteDatabase = this.jad_an;
                        }
                    } finally {
                        SQLiteDatabase sQLiteDatabase3 = this.jad_an;
                        if (sQLiteDatabase3 != null && sQLiteDatabase3.inTransaction()) {
                            this.jad_an.endTransaction();
                        }
                    }
                }
                if (jad_bo()) {
                    this.jad_an.beginTransaction();
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        this.jad_an.delete("preloadAd", "rId=?", new String[]{it.next()});
                    }
                    this.jad_an.setTransactionSuccessful();
                    SQLiteDatabase sQLiteDatabase4 = this.jad_an;
                    if (sQLiteDatabase4 != null && sQLiteDatabase4.inTransaction()) {
                        sQLiteDatabase = this.jad_an;
                        sQLiteDatabase.endTransaction();
                    }
                }
            }
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
            java.lang.String r1 = "preloadAd"
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
            java.lang.String r4 = "Exception while clearing events: "
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
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_kx.jad_an.jad_an(java.lang.String, java.lang.String[]):void");
    }
}
