package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.debug.UMRTLog;

/* loaded from: classes4.dex */
public class ao extends SQLiteOpenHelper {

    /* renamed from: b */
    private static final Object f25681b = new Object();

    /* renamed from: c */
    private static ao f25682c = null;

    /* renamed from: d */
    private static final String f25683d = "CREATE TABLE IF NOT EXISTS stf(_id INTEGER PRIMARY KEY AUTOINCREMENT, _tp TEXT, _hd TEXT, _bd TEXT, _ts TEXT, _uuid TEXT, _re1 TEXT, _re2 TEXT)";

    /* renamed from: e */
    private static final String f25684e = "DROP TABLE IF EXISTS stf";

    /* renamed from: f */
    private static final String f25685f = "DELETE FROM stf WHERE _id IN( SELECT _id FROM stf ORDER BY _id LIMIT 1)";

    /* renamed from: a */
    private final Context f25686a;

    private ao(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
        this.f25686a = context;
    }

    public static final int a() {
        return 1;
    }

    public static ao a(Context context) {
        ao aoVar;
        synchronized (f25681b) {
            if (f25682c == null) {
                f25682c = new ao(context, aq.f25694b, null, 1);
            }
            aoVar = f25682c;
        }
        return aoVar;
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f25683d);
        } catch (SQLiteDatabaseCorruptException unused) {
            a(sQLiteDatabase);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]创建二级缓存数据库失败: " + th.getMessage());
        }
    }

    private void d() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.execSQL(f25685f);
            } catch (Throwable unused) {
            }
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public boolean c() {
        return !b(aq.f25695c);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    public void b() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            writableDatabase.close();
        } catch (Throwable unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f25684e);
            sQLiteDatabase.execSQL(f25683d);
        } catch (SQLException unused) {
        }
    }

    public boolean b(String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            if (sQLiteDatabase != null) {
                try {
                    if (sQLiteDatabase.isOpen()) {
                        cursor = sQLiteDatabase.query(str, null, null, null, null, null, null, null);
                    }
                } catch (Throwable unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase == null) {
                        return false;
                    }
                    sQLiteDatabase.close();
                    return false;
                }
            }
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    cursor.close();
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return true;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase == null) {
                return false;
            }
        } catch (Throwable unused2) {
            sQLiteDatabase = null;
        }
        sQLiteDatabase.close();
        return false;
    }

    public void a(String str, ContentValues contentValues) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.insert(str, null, contentValues);
                writableDatabase.setTransactionSuccessful();
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]插入二级缓存数据记录 成功。");
            } catch (Throwable unused) {
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public void a(String str, String str2, String[] strArr) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.delete(str, str2, strArr);
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable unused) {
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.umeng.analytics.pro.ap a(java.lang.String r19) {
        /*
            r18 = this;
            r10 = r18
            r0 = 6
            java.lang.String[] r3 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L8b
            java.lang.String r0 = "_uuid"
            r12 = 0
            r3[r12] = r0     // Catch: java.lang.Throwable -> L8b
            java.lang.String r0 = "_tp"
            r13 = 1
            r3[r13] = r0     // Catch: java.lang.Throwable -> L8b
            java.lang.String r0 = "_hd"
            r14 = 2
            r3[r14] = r0     // Catch: java.lang.Throwable -> L8b
            java.lang.String r0 = "_bd"
            r15 = 3
            r3[r15] = r0     // Catch: java.lang.Throwable -> L8b
            java.lang.String r0 = "_re1"
            r9 = 4
            r3[r9] = r0     // Catch: java.lang.Throwable -> L8b
            java.lang.String r0 = "_re2"
            r8 = 5
            r3[r8] = r0     // Catch: java.lang.Throwable -> L8b
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = 0
            java.lang.String r16 = "1"
            r1 = r18
            r2 = r19
            r11 = 5
            r8 = r0
            r0 = 4
            r9 = r16
            android.database.Cursor r1 = r1.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L8b
            if (r1 == 0) goto L84
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L82
            if (r2 == 0) goto L84
            com.umeng.analytics.pro.ap r2 = new com.umeng.analytics.pro.ap     // Catch: java.lang.Throwable -> L82
            r2.<init>()     // Catch: java.lang.Throwable -> L82
            java.lang.String r3 = r1.getString(r12)     // Catch: java.lang.Throwable -> L7e
            r2.f25687a = r3     // Catch: java.lang.Throwable -> L7e
            java.lang.String r3 = r1.getString(r13)     // Catch: java.lang.Throwable -> L7e
            r2.f25688b = r3     // Catch: java.lang.Throwable -> L7e
            java.lang.String r3 = r1.getString(r14)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r4 = r1.getString(r15)     // Catch: java.lang.Throwable -> L7e
            android.content.Context r5 = r10.f25686a     // Catch: java.lang.Throwable -> L7e
            com.umeng.analytics.pro.i r5 = com.umeng.analytics.pro.i.a(r5)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r3 = r5.d(r3)     // Catch: java.lang.Throwable -> L7e
            r2.f25689c = r3     // Catch: java.lang.Throwable -> L7e
            android.content.Context r3 = r10.f25686a     // Catch: java.lang.Throwable -> L7e
            com.umeng.analytics.pro.i r3 = com.umeng.analytics.pro.i.a(r3)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r3 = r3.d(r4)     // Catch: java.lang.Throwable -> L7e
            r2.f25690d = r3     // Catch: java.lang.Throwable -> L7e
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L7e
            r2.f25691e = r0     // Catch: java.lang.Throwable -> L7e
            java.lang.String r0 = r1.getString(r11)     // Catch: java.lang.Throwable -> L7e
            r2.f25692f = r0     // Catch: java.lang.Throwable -> L7e
            r11 = r2
            goto L85
        L7e:
            r11 = r1
            r17 = r2
            goto L8e
        L82:
            r11 = r1
            goto L8c
        L84:
            r11 = 0
        L85:
            if (r1 == 0) goto L98
            r1.close()
            goto L98
        L8b:
            r11 = 0
        L8c:
            r17 = 0
        L8e:
            r18.d()     // Catch: java.lang.Throwable -> L99
            if (r11 == 0) goto L96
            r11.close()
        L96:
            r11 = r17
        L98:
            return r11
        L99:
            r0 = move-exception
            r1 = r0
            if (r11 == 0) goto La0
            r11.close()
        La0:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.ao.a(java.lang.String):com.umeng.analytics.pro.ap");
    }

    public void a(String str, String str2) {
        a(str, "_uuid=?", new String[]{str2});
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return null;
            }
            return writableDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        } catch (Throwable unused) {
            return null;
        }
    }
}
