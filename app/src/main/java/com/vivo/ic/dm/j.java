package com.vivo.ic.dm;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Downloads;

/* loaded from: classes4.dex */
public class j extends SQLiteOpenHelper {

    /* renamed from: a */
    public static final String f28479a = "downloads";

    /* renamed from: b */
    private static final String f28480b = Constants.PRE_TAG + "DownloadDatabaseHelper";

    /* renamed from: c */
    private static final String f28481c = "downloads.db";

    /* renamed from: d */
    private static final int f28482d = 54;

    /* renamed from: e */
    private static final int f28483e = 50;

    /* renamed from: f */
    private int f28484f;

    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ SQLiteDatabase f28485a;

        a(SQLiteDatabase sQLiteDatabase) {
            this.f28485a = sQLiteDatabase;
        }

        @Override // java.lang.Runnable
        public void run() {
            new com.vivo.ic.dm.database.b().a(this.f28485a, j.f28479a);
            VLog.i(j.f28480b, "migrateOldChildFiles() complete");
        }
    }

    public j(Context context) {
        super(context, f28481c, (SQLiteDatabase.CursorFactory) null, 54);
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS request_headers");
        sQLiteDatabase.execSQL("CREATE TABLE request_headers(id INTEGER PRIMARY KEY AUTOINCREMENT,download_id INTEGER NOT NULL,header TEXT NOT NULL,value TEXT NOT NULL);");
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        String str = f28480b;
        VLog.i(str, "migrateOldChildFiles() mOldVersion: " + this.f28484f);
        if (this.f28484f == 50) {
            com.vivo.ic.dm.q.e.b(new a(sQLiteDatabase));
        } else {
            VLog.i(str, "migrateOldChildFiles() not need");
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        VLog.i(f28480b, "mark single thread download");
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Downloads.Column.DOWNLOAD_TYPE, (Integer) 1);
            sQLiteDatabase.update(f28479a, contentValues, "status!=?", new String[]{String.valueOf(200)});
        } catch (Exception unused) {
            VLog.i(f28480b, "reset Download Progress failed");
        }
    }

    public String b() {
        return f28479a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        VLog.i(f28480b, "populating new database");
        onUpgrade(sQLiteDatabase, 0, 54);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x007c, code lost:
    
        if (r13 != null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008e, code lost:
    
        onCreate(r11);
        r11.setTransactionSuccessful();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008b, code lost:
    
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
    
        if (r13 == null) goto L67;
     */
    @Override // android.database.sqlite.SQLiteOpenHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDowngrade(android.database.sqlite.SQLiteDatabase r11, int r12, int r13) {
        /*
            r10 = this;
            java.lang.String r0 = com.vivo.ic.dm.j.f28480b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onDowngrade(): oldVersion="
            r1.append(r2)
            r1.append(r12)
            java.lang.String r12 = ", newVersion="
            r1.append(r12)
            r1.append(r13)
            java.lang.String r12 = r1.toString()
            com.vivo.ic.VLog.i(r0, r12)
            r11.beginTransaction()
            java.lang.String r2 = "sqlite_master"
            r12 = 1
            r13 = 0
            java.lang.String[] r3 = new java.lang.String[r12]     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String r0 = "name"
            r9 = 0
            r3[r9] = r0     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String r4 = "type=?"
            java.lang.String[] r5 = new java.lang.String[r12]     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String r12 = "table"
            r5[r9] = r12     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r11
            android.database.Cursor r13 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
        L3c:
            if (r13 == 0) goto L7c
            boolean r12 = r13.moveToNext()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            if (r12 == 0) goto L7c
            java.lang.String r12 = r13.getString(r9)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String r0 = "android_metadata"
            boolean r0 = r0.equals(r12)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            if (r0 == 0) goto L51
            goto L3c
        L51:
            java.lang.String r0 = com.vivo.ic.dm.j.f28480b     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            r1.<init>()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String r2 = "drop table "
            r1.append(r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            r1.append(r12)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            com.vivo.ic.VLog.i(r0, r1)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            r0.<init>()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String r1 = "DROP TABLE IF EXISTS "
            r0.append(r1)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            r0.append(r12)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String r12 = r0.toString()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            r11.execSQL(r12)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            goto L3c
        L7c:
            if (r13 == 0) goto L8e
            goto L8b
        L7f:
            r12 = move-exception
            goto L95
        L81:
            r12 = move-exception
            java.lang.String r0 = com.vivo.ic.dm.j.f28480b     // Catch: java.lang.Throwable -> L7f
            java.lang.String r1 = "onDowngrade error"
            com.vivo.ic.VLog.w(r0, r1, r12)     // Catch: java.lang.Throwable -> L7f
            if (r13 == 0) goto L8e
        L8b:
            r13.close()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
        L8e:
            r10.onCreate(r11)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r11.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            goto Lb4
        L95:
            if (r13 == 0) goto L9a
            r13.close()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
        L9a:
            throw r12     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
        L9b:
            r12 = move-exception
            goto Lb8
        L9d:
            java.lang.String r12 = com.vivo.ic.dm.j.f28480b     // Catch: java.lang.Throwable -> L9b
            java.lang.String r13 = "drop all table from master failed, drop manually."
            com.vivo.ic.VLog.e(r12, r13)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r12 = "DROP TABLE IF EXISTS downloads"
            r11.execSQL(r12)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r12 = "DROP TABLE IF EXISTS request_headers"
            r11.execSQL(r12)     // Catch: java.lang.Throwable -> L9b
            r10.onCreate(r11)     // Catch: java.lang.Throwable -> L9b
            r11.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L9b
        Lb4:
            r11.endTransaction()
            return
        Lb8:
            r11.endTransaction()
            goto Lbd
        Lbc:
            throw r12
        Lbd:
            goto Lbc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.dm.j.onDowngrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        VLog.i(f28480b, "onUpgrade oldVersion:" + i2 + ",newVersion:" + i3);
        this.f28484f = i2;
        while (true) {
            i2++;
            if (i2 > i3) {
                return;
            } else {
                a(sQLiteDatabase, i2);
            }
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i2) {
        if (i2 == 1) {
            a(sQLiteDatabase);
            b(sQLiteDatabase);
        }
        if (i2 == 2) {
            a(sQLiteDatabase, f28479a, "package_name", "TEXT");
            return;
        }
        if (i2 == 3) {
            a(sQLiteDatabase, f28479a, Downloads.Column.COLUMN_ALLOWED_NETWORK_TYPES, "INTEGER NOT NULL DEFAULT 0");
            a(sQLiteDatabase, f28479a, Downloads.Column.IGNORE_HTTPS_VERIFY, "INTEGER NOT NULL DEFAULT 0");
            VLog.i(f28480b, "upgradeTo: version=" + i2);
            return;
        }
        switch (i2) {
            case 50:
                a(sQLiteDatabase, f28479a, Downloads.Column.DOWNLOAD_TYPE, "INTEGER NOT NULL DEFAULT 0");
                a(sQLiteDatabase, f28479a, Downloads.Column.COMPLETE_THREADS, "INTEGER NOT NULL DEFAULT 0");
                a(sQLiteDatabase, f28479a, Downloads.Column.CURRENT_SPEED, "INTEGER NOT NULL DEFAULT 0");
                d(sQLiteDatabase);
                break;
            case 51:
                if (this.f28484f == 50) {
                    a(sQLiteDatabase, f28479a, Downloads.Column.COLUMN_ALLOWED_NETWORK_TYPES, "INTEGER NOT NULL DEFAULT 0");
                    a(sQLiteDatabase, f28479a, Downloads.Column.IGNORE_HTTPS_VERIFY, "INTEGER NOT NULL DEFAULT 0");
                }
                a(sQLiteDatabase, f28479a, Downloads.Column.COMPLETE_NOTIFICATION_SHOWN, "INTEGER NOT NULL DEFAULT 0");
                a(sQLiteDatabase, f28479a, Downloads.Column.LAST_NETWORK, "INTEGER NOT NULL DEFAULT 0");
                VLog.i(f28480b, "upgradeTo: version=" + i2);
                c(sQLiteDatabase);
                break;
            case 52:
                a(sQLiteDatabase, f28479a, Downloads.Column.CHECK_SUM, "TEXT");
                break;
            case 53:
                a(sQLiteDatabase, f28479a, Downloads.Column.ACTUAL_PATH, "TEXT");
                break;
            case 54:
                a(sQLiteDatabase, f28479a, Downloads.Column.REDIRECT_URL, "TEXT");
                break;
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
            sQLiteDatabase.execSQL("CREATE TABLE downloads(_id INTEGER PRIMARY KEY AUTOINCREMENT,uri TEXT, hint TEXT, _data TEXT, mimetype TEXT, visibility INTEGER, control INTEGER, status INTEGER, total_bytes INTEGER, current_bytes INTEGER, title TEXT, description TEXT, error_msg TEXT, num_failed INTEGER, lastmod BIGINT, notificationextras TEXT, useragent TEXT, cookiedata TEXT, referer TEXT, etag TEXT, scanned BOOLEAN, retry_x INTEGER, network_changed INTEGER, extra_one TEXT, extra_two TEXT, extra_three TEXT, extra_four TEXT, extra_five TEXT);");
        } catch (SQLException e2) {
            VLog.e(f28480b, "couldn't create table in downloads database");
            throw e2;
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        if (a(sQLiteDatabase, str, str2)) {
            return;
        }
        sQLiteDatabase.execSQL("ALTER TABLE " + str + " ADD COLUMN " + str2 + " " + str3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
    
        if (r0.isClosed() == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0055, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
    
        if (r0.isClosed() == false) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(android.database.sqlite.SQLiteDatabase r5, java.lang.String r6, java.lang.String r7) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.String r3 = "SELECT * FROM "
            r2.append(r3)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r2.append(r6)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.String r6 = " LIMIT 0"
            r2.append(r6)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            android.database.Cursor r0 = r5.rawQuery(r6, r0)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            if (r0 == 0) goto L27
            int r5 = r0.getColumnIndex(r7)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r6 = -1
            if (r5 == r6) goto L27
            r5 = 1
            r1 = 1
        L27:
            if (r0 == 0) goto L58
            boolean r5 = r0.isClosed()
            if (r5 != 0) goto L58
            goto L55
        L30:
            r5 = move-exception
            goto L59
        L32:
            r5 = move-exception
            java.lang.String r6 = com.vivo.ic.dm.j.f28480b     // Catch: java.lang.Throwable -> L30
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30
            r7.<init>()     // Catch: java.lang.Throwable -> L30
            java.lang.String r2 = "checkColumnExist error "
            r7.append(r2)     // Catch: java.lang.Throwable -> L30
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L30
            r7.append(r5)     // Catch: java.lang.Throwable -> L30
            java.lang.String r5 = r7.toString()     // Catch: java.lang.Throwable -> L30
            com.vivo.ic.VLog.e(r6, r5)     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L58
            boolean r5 = r0.isClosed()
            if (r5 != 0) goto L58
        L55:
            r0.close()
        L58:
            return r1
        L59:
            if (r0 == 0) goto L64
            boolean r6 = r0.isClosed()
            if (r6 != 0) goto L64
            r0.close()
        L64:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.dm.j.a(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String):boolean");
    }
}
