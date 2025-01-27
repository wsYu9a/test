package com.jd.ad.sdk.jad_mz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.jad_ly.jad_cp;
import com.jd.ad.sdk.jad_xk.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class jad_an extends com.jd.ad.sdk.jad_sf.jad_an {
    public static jad_an jad_dq;
    public int jad_bo;
    public com.jd.ad.sdk.jad_pc.jad_an jad_cp;

    /* renamed from: com.jd.ad.sdk.jad_mz.jad_an$jad_an */
    public class RunnableC0337jad_an implements Runnable {
        public final /* synthetic */ List jad_an;
        public final /* synthetic */ List jad_bo;

        public RunnableC0337jad_an(List list, List list2) {
            this.jad_an = list;
            this.jad_bo = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            jad_an.jad_an(jad_an.this, this.jad_an);
            jad_an.jad_bo(jad_an.this, this.jad_bo);
        }
    }

    public class jad_bo implements Runnable {
        public final /* synthetic */ List jad_an;
        public final /* synthetic */ List jad_bo;

        public jad_bo(List list, List list2) {
            this.jad_an = list;
            this.jad_bo = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            jad_an.jad_an(jad_an.this, this.jad_an);
            jad_an.jad_bo(jad_an.this, this.jad_bo);
        }
    }

    public jad_an(Context context, String str, int i10) {
        super(context, str, i10);
        this.jad_bo = 40;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        if (r5.inTransaction() != false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0079, code lost:
    
        r5 = r4.jad_an;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0077, code lost:
    
        if (r5.inTransaction() != false) goto L140;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void jad_an(com.jd.ad.sdk.jad_mz.jad_an r4, java.util.List r5) {
        /*
            monitor-enter(r4)
            if (r5 == 0) goto L92
            int r0 = r5.size()     // Catch: java.lang.Throwable -> L21
            if (r0 != 0) goto Lb
            goto L92
        Lb:
            r4.getWritableDatabase()     // Catch: java.lang.Throwable -> L4e
            boolean r0 = r4.jad_bo()     // Catch: java.lang.Throwable -> L4e
            if (r0 != 0) goto L23
            android.database.sqlite.SQLiteDatabase r5 = r4.jad_an     // Catch: java.lang.Throwable -> L21
            if (r5 == 0) goto L92
            boolean r5 = r5.inTransaction()     // Catch: java.lang.Throwable -> L21
            if (r5 == 0) goto L92
            android.database.sqlite.SQLiteDatabase r5 = r4.jad_an     // Catch: java.lang.Throwable -> L21
            goto L7b
        L21:
            r5 = move-exception
            goto L90
        L23:
            android.database.sqlite.SQLiteDatabase r0 = r4.jad_an     // Catch: java.lang.Throwable -> L4e
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L4e
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L4e
        L2c:
            boolean r0 = r5.hasNext()     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto L50
            java.lang.Object r0 = r5.next()     // Catch: java.lang.Throwable -> L4e
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L4e
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L4e
            android.database.sqlite.SQLiteDatabase r1 = r4.jad_an     // Catch: java.lang.Throwable -> L4e
            java.lang.String r2 = "splashVideo"
            java.lang.String r3 = "_id=?"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L4e
            java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L4e
            r1.delete(r2, r3, r0)     // Catch: java.lang.Throwable -> L4e
            goto L2c
        L4e:
            r5 = move-exception
            goto L60
        L50:
            android.database.sqlite.SQLiteDatabase r5 = r4.jad_an     // Catch: java.lang.Throwable -> L4e
            r5.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4e
            android.database.sqlite.SQLiteDatabase r5 = r4.jad_an     // Catch: java.lang.Throwable -> L21
            if (r5 == 0) goto L92
            boolean r5 = r5.inTransaction()     // Catch: java.lang.Throwable -> L21
            if (r5 == 0) goto L92
            goto L79
        L60:
            java.lang.String r0 = "Exception while clearing video:"
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L7f
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L7f
            r2 = 0
            r1[r2] = r5     // Catch: java.lang.Throwable -> L7f
            com.jd.ad.sdk.logger.Logger.w(r0, r1)     // Catch: java.lang.Throwable -> L7f
            android.database.sqlite.SQLiteDatabase r5 = r4.jad_an     // Catch: java.lang.Throwable -> L21
            if (r5 == 0) goto L92
            boolean r5 = r5.inTransaction()     // Catch: java.lang.Throwable -> L21
            if (r5 == 0) goto L92
        L79:
            android.database.sqlite.SQLiteDatabase r5 = r4.jad_an     // Catch: java.lang.Throwable -> L21
        L7b:
            r5.endTransaction()     // Catch: java.lang.Throwable -> L21
            goto L92
        L7f:
            r5 = move-exception
            android.database.sqlite.SQLiteDatabase r0 = r4.jad_an     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto L8f
            boolean r0 = r0.inTransaction()     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto L8f
            android.database.sqlite.SQLiteDatabase r0 = r4.jad_an     // Catch: java.lang.Throwable -> L21
            r0.endTransaction()     // Catch: java.lang.Throwable -> L21
        L8f:
            throw r5     // Catch: java.lang.Throwable -> L21
        L90:
            monitor-exit(r4)
            throw r5
        L92:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_mz.jad_an.jad_an(com.jd.ad.sdk.jad_mz.jad_an, java.util.List):void");
    }

    public static void jad_bo(jad_an jad_anVar, List list) {
        jad_anVar.getClass();
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    File file = new File((String) it.next());
                    if (!file.exists()) {
                        Logger.d("File does not exist");
                    } else if (file.delete()) {
                        Logger.d("File deleted successfully");
                    } else {
                        Logger.d("Failed to delete the file");
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                Logger.w("Exception while delete video:", e10.getMessage());
            }
        }
    }

    public void jad_cp() {
        try {
            getWritableDatabase();
            if (jad_bo()) {
                this.jad_an.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT,  %s TEXT, %s TEXT, %s TEXT, %s TEXT)", "splashVideo", "appIdPid", "videoUrl", "videoLocalPath", "timeStampInterval"));
            }
        } catch (Exception e10) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("video render video sql create error:");
            jad_an.append(Log.getStackTraceString(e10));
            Logger.d(jad_an.toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_DYNAMIC_RENDER_CREATE_TEMPLATE_DB_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT,  %s TEXT, %s TEXT, %s TEXT)", "splashVideo", "appIdPid", "videoUrl", "videoLocalPath", "timeStampInterval"));
        } catch (Exception e10) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("video render template sql create error:");
            jad_an.append(Log.getStackTraceString(e10));
            Logger.d(jad_an.toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_DYNAMIC_RENDER_CREATE_TEMPLATE_DB_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
        }
        this.jad_an = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS splashVideo");
        onCreate(sQLiteDatabase);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d8, code lost:
    
        if (r4.isClosed() == false) goto L170;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<com.jd.ad.sdk.jad_ly.jad_cp> jad_bo(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_mz.jad_an.jad_bo(java.lang.String):java.util.List");
    }

    public static synchronized jad_an jad_an(Context context, String str, int i10) {
        jad_an jad_anVar;
        synchronized (jad_an.class) {
            try {
                if (jad_dq == null) {
                    jad_dq = new jad_an(context, str, i10);
                }
                jad_anVar = jad_dq;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return jad_anVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a0, code lost:
    
        if (r10.isClosed() == false) goto L175;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void jad_an(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_mz.jad_an.jad_an(java.lang.String):void");
    }

    public final ContentValues jad_an(jad_cp jad_cpVar) {
        ContentValues contentValues;
        try {
            contentValues = new ContentValues();
            try {
                contentValues.put("appIdPid", jad_cpVar.jad_bo);
                String ja2 = ANEProxy.ja(jad_cpVar.jad_cp);
                String ja3 = ANEProxy.ja(jad_cpVar.jad_dq);
                contentValues.put("videoUrl", ja2);
                contentValues.put("videoLocalPath", ja3);
                contentValues.put("timeStampInterval", jad_cpVar.jad_er);
            } catch (Exception e10) {
                e = e10;
                Logger.w("Exception while add video:", e.getMessage());
                return contentValues;
            }
        } catch (Exception e11) {
            e = e11;
            contentValues = null;
        }
        return contentValues;
    }
}
