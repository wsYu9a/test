package com.czhj.sdk.common.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: classes2.dex */
public class SQLiteMTAHelper extends SQLiteOpenHelper {
    public static final long DB_ERROR_BAD_INPUT = -2;
    public static final long DB_WRITE_ERROR = -1;
    public static final String TABLE_POINT = "point";

    /* renamed from: a */
    public static String f8439a = "sigmob_mta.db";

    /* renamed from: b */
    public static final int f8440b = 10;

    /* renamed from: c */
    public static String f8441c = "CREATE TABLE point ( point_id integer  primary key  ,item text , encryption int);\n";

    /* renamed from: d */
    public static final long f8442d = -6;

    /* renamed from: e */
    public static final long f8443e = -5;

    /* renamed from: f */
    public static final long f8444f = -4;

    /* renamed from: g */
    public static final long f8445g = 0;

    /* renamed from: h */
    public static SQLiteMTAHelper f8446h;

    /* renamed from: i */
    public static SQLiteDatabase f8447i;

    public interface ExecCallBack {
        void onFailed(Throwable th2);

        void onSuccess();
    }

    public SQLiteMTAHelper(Context context) {
        super(context, f8439a, (SQLiteDatabase.CursorFactory) null, 10);
    }

    public static SQLiteMTAHelper getInstance() {
        return f8446h;
    }

    public static void initialize(Context context) {
        if (f8446h == null) {
            synchronized (SQLiteMTAHelper.class) {
                try {
                    if (f8446h == null) {
                        f8446h = new SQLiteMTAHelper(context);
                    }
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0070, code lost:
    
        if (r7 == null) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0091, code lost:
    
        r7.onFailed(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x008f, code lost:
    
        if (r7 == null) goto L193;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void insert(android.database.sqlite.SQLiteDatabase r5, com.czhj.sdk.common.Database.SQLiteBuider.Insert r6, com.czhj.sdk.common.Database.SQLiteMTAHelper.ExecCallBack r7) {
        /*
            r5.beginTransaction()
            java.lang.String r0 = r6.f8427b     // Catch: java.lang.Throwable -> L30
            android.database.sqlite.SQLiteStatement r0 = r5.compileStatement(r0)     // Catch: java.lang.Throwable -> L30
            r1 = 1
            r2 = 1
        Lb:
            java.util.List<java.lang.Object> r3 = r6.f8429d     // Catch: java.lang.Throwable -> L30
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L30
            if (r2 > r3) goto L5e
            java.util.List<java.lang.Object> r3 = r6.f8429d     // Catch: java.lang.Throwable -> L30
            int r4 = r2 + (-1)
            java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L30
            java.util.Map<java.lang.String, java.lang.Object> r4 = r6.f8428c     // Catch: java.lang.Throwable -> L30
            java.lang.Object r3 = r4.get(r3)     // Catch: java.lang.Throwable -> L30
            if (r3 != 0) goto L26
            goto L58
        L26:
            boolean r4 = r3 instanceof java.lang.String     // Catch: java.lang.Throwable -> L30
            if (r4 == 0) goto L32
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L30
            r0.bindString(r2, r3)     // Catch: java.lang.Throwable -> L30
            goto L5b
        L30:
            r6 = move-exception
            goto L73
        L32:
            boolean r4 = r3 instanceof java.lang.Double     // Catch: java.lang.Throwable -> L30
            if (r4 == 0) goto L40
            java.lang.Double r3 = (java.lang.Double) r3     // Catch: java.lang.Throwable -> L30
            double r3 = r3.doubleValue()     // Catch: java.lang.Throwable -> L30
            r0.bindDouble(r2, r3)     // Catch: java.lang.Throwable -> L30
            goto L5b
        L40:
            boolean r4 = r3 instanceof java.lang.Number     // Catch: java.lang.Throwable -> L30
            if (r4 == 0) goto L4e
            java.lang.Number r3 = (java.lang.Number) r3     // Catch: java.lang.Throwable -> L30
            long r3 = r3.longValue()     // Catch: java.lang.Throwable -> L30
            r0.bindLong(r2, r3)     // Catch: java.lang.Throwable -> L30
            goto L5b
        L4e:
            boolean r4 = r3 instanceof byte[]     // Catch: java.lang.Throwable -> L30
            if (r4 == 0) goto L58
            byte[] r3 = (byte[]) r3     // Catch: java.lang.Throwable -> L30
            r0.bindBlob(r2, r3)     // Catch: java.lang.Throwable -> L30
            goto L5b
        L58:
            r0.bindNull(r2)     // Catch: java.lang.Throwable -> L30
        L5b:
            int r2 = r2 + 1
            goto Lb
        L5e:
            r0.execute()     // Catch: java.lang.Throwable -> L30
            r5.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L30
            r5.endTransaction()     // Catch: java.lang.Throwable -> L68
            goto L94
        L68:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            com.czhj.sdk.logger.SigmobLog.e(r6)
            if (r7 == 0) goto L94
            goto L91
        L73:
            java.lang.String r0 = r6.getMessage()     // Catch: java.lang.Throwable -> L80
            com.czhj.sdk.logger.SigmobLog.e(r0)     // Catch: java.lang.Throwable -> L80
            if (r7 == 0) goto L82
            r7.onFailed(r6)     // Catch: java.lang.Throwable -> L80
            goto L82
        L80:
            r6 = move-exception
            goto L9c
        L82:
            r1 = 0
            r5.endTransaction()     // Catch: java.lang.Throwable -> L87
            goto L94
        L87:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            com.czhj.sdk.logger.SigmobLog.e(r6)
            if (r7 == 0) goto L94
        L91:
            r7.onFailed(r5)
        L94:
            if (r1 == 0) goto L9b
            if (r7 == 0) goto L9b
            r7.onSuccess()
        L9b:
            return
        L9c:
            r5.endTransaction()     // Catch: java.lang.Throwable -> La0
            goto Lad
        La0:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.czhj.sdk.logger.SigmobLog.e(r0)
            if (r7 == 0) goto Lad
            r7.onFailed(r5)
        Lad:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.sdk.common.Database.SQLiteMTAHelper.insert(android.database.sqlite.SQLiteDatabase, com.czhj.sdk.common.Database.SQLiteBuider$Insert, com.czhj.sdk.common.Database.SQLiteMTAHelper$ExecCallBack):void");
    }

    public final void a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.execSQL("alter table " + str3 + " add " + str + " " + str2);
    }

    public final void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS point");
        onCreate(sQLiteDatabase);
    }

    public void clearDb() {
        b(getWritableDatabase());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f8441c);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        Log.w(SQLiteMTAHelper.class.getName(), "Downgrading database from version " + i10 + " to " + i11 + ", which will destroy all old data");
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        setWriteAheadLoggingEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        Log.w(SQLiteMTAHelper.class.getName(), "Upgrading database from version " + i10 + " to " + i11 + ", which will destroy all old data");
        if (i10 == 9) {
            b(sQLiteDatabase);
        } else if (i11 > 8) {
            sQLiteDatabase.execSQL("ALTER TABLE point ADD COLUMN 'encryption' int ");
        }
    }

    public void transactionWriteExecSQL(SQLiteDatabase sQLiteDatabase, String str, ExecCallBack execCallBack) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(str, new Object[0]);
            sQLiteDatabase.setTransactionSuccessful();
            if (execCallBack != null) {
                execCallBack.onSuccess();
            }
        } catch (Throwable th2) {
            try {
                SigmobLog.e(th2.getMessage());
                if (execCallBack != null) {
                    execCallBack.onFailed(th2);
                }
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    public final void a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        sQLiteDatabase.execSQL("alter table " + str2 + " drop column " + str);
    }

    public static long a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return -6L;
        }
        if (sQLiteDatabase.isOpen()) {
            return sQLiteDatabase.isReadOnly() ? -4L : 0L;
        }
        return -5L;
    }
}
