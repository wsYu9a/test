package com.tencent.open.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.martian.libmars.activity.PermissionActivity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
public class f extends SQLiteOpenHelper {

    /* renamed from: a */
    protected static final String[] f23185a = {PermissionActivity.f12046p};

    /* renamed from: b */
    protected static f f23186b;

    public f(Context context) {
        super(context, "sdk_report.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            try {
                if (f23186b == null) {
                    f23186b = new f(com.tencent.open.utils.d.a());
                }
                fVar = f23186b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fVar;
    }

    public synchronized void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            if (writableDatabase == null) {
                return;
            }
            try {
                writableDatabase.delete("via_cgi_report", "type = ?", new String[]{str});
            } catch (Exception e10) {
                com.tencent.open.a.f.b("openSDK_LOG.ReportDatabaseHelper", "clearReportItem has exception.", e10);
            }
        } finally {
            writableDatabase.close();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
        onCreate(sQLiteDatabase);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0081 A[Catch: all -> 0x0055, Exception -> 0x0058, TRY_ENTER, TryCatch #13 {Exception -> 0x0058, all -> 0x0055, blocks: (B:22:0x002e, B:24:0x0034, B:25:0x0037, B:31:0x0051, B:33:0x005b, B:35:0x0081, B:36:0x0084, B:67:0x006d, B:60:0x0070, B:61:0x0073, B:48:0x0076, B:52:0x0079), top: B:21:0x002e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<java.io.Serializable> a(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L90
            r0.<init>()     // Catch: java.lang.Throwable -> L90
            java.util.List r0 = java.util.Collections.synchronizedList(r0)     // Catch: java.lang.Throwable -> L90
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L12
            monitor-exit(r11)
            return r0
        L12:
            android.database.sqlite.SQLiteDatabase r1 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L90
            if (r1 != 0) goto L1a
            monitor-exit(r11)
            return r0
        L1a:
            r10 = 0
            java.lang.String r3 = "via_cgi_report"
            java.lang.String r5 = "type = ?"
            java.lang.String[] r6 = new java.lang.String[]{r12}     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            r8 = 0
            r9 = 0
            r4 = 0
            r7 = 0
            r2 = r1
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            if (r12 == 0) goto L8a
            int r2 = r12.getCount()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            if (r2 <= 0) goto L8a
            r12.moveToFirst()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
        L37:
            java.lang.String r2 = "blob"
            int r2 = r12.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            byte[] r2 = r12.getBlob(r2)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            java.lang.Object r4 = r2.readObject()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L64
            java.io.Serializable r4 = (java.io.Serializable) r4     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L64
            r2.close()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58 java.io.IOException -> L5b
            goto L5b
        L55:
            r0 = move-exception
            r10 = r12
            goto La8
        L58:
            r2 = move-exception
            r10 = r12
            goto L99
        L5b:
            r3.close()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58 java.io.IOException -> L5f
            goto L7f
        L5f:
            goto L7f
        L61:
            r4 = move-exception
            r10 = r2
            goto L6b
        L64:
            goto L74
        L66:
            r4 = move-exception
            goto L6b
        L68:
            r2 = r10
            goto L74
        L6b:
            if (r10 == 0) goto L70
            r10.close()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58 java.io.IOException -> L70
        L70:
            r3.close()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58 java.io.IOException -> L73
        L73:
            throw r4     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
        L74:
            if (r2 == 0) goto L79
            r2.close()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58 java.io.IOException -> L79
        L79:
            r3.close()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58 java.io.IOException -> L7d
            goto L7e
        L7d:
        L7e:
            r4 = r10
        L7f:
            if (r4 == 0) goto L84
            r0.add(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
        L84:
            boolean r2 = r12.moveToNext()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            if (r2 != 0) goto L37
        L8a:
            if (r12 == 0) goto L92
            r12.close()     // Catch: java.lang.Throwable -> L90
            goto L92
        L90:
            r12 = move-exception
            goto Lb1
        L92:
            r1.close()     // Catch: java.lang.Throwable -> L90
            goto La6
        L96:
            r0 = move-exception
            goto La8
        L98:
            r2 = move-exception
        L99:
            java.lang.String r12 = "openSDK_LOG.ReportDatabaseHelper"
            java.lang.String r3 = "getReportItemFromDB has exception."
            com.tencent.open.a.f.b(r12, r3, r2)     // Catch: java.lang.Throwable -> L96
            if (r10 == 0) goto L92
            r10.close()     // Catch: java.lang.Throwable -> L90
            goto L92
        La6:
            monitor-exit(r11)
            return r0
        La8:
            if (r10 == 0) goto Lad
            r10.close()     // Catch: java.lang.Throwable -> L90
        Lad:
            r1.close()     // Catch: java.lang.Throwable -> L90
            throw r0     // Catch: java.lang.Throwable -> L90
        Lb1:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L90
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.f.a(java.lang.String):java.util.List");
    }

    public synchronized void a(String str, List<Serializable> list) {
        ObjectOutputStream objectOutputStream;
        int size = list.size();
        if (size == 0) {
            return;
        }
        if (size > 20) {
            size = 20;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b(str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        try {
            writableDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                for (int i10 = 0; i10 < size; i10++) {
                    Serializable serializable = list.get(i10);
                    if (serializable != null) {
                        contentValues.put("type", str);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
                        ObjectOutputStream objectOutputStream2 = null;
                        try {
                            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        } catch (IOException unused) {
                            objectOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            objectOutputStream.writeObject(serializable);
                            try {
                                objectOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        } catch (IOException unused3) {
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            byteArrayOutputStream.close();
                            contentValues.put("blob", byteArrayOutputStream.toByteArray());
                            writableDatabase.insert("via_cgi_report", null, contentValues);
                            contentValues.clear();
                        } catch (Throwable th3) {
                            th = th3;
                            objectOutputStream2 = objectOutputStream;
                            if (objectOutputStream2 != null) {
                                try {
                                    objectOutputStream2.close();
                                } catch (IOException unused4) {
                                }
                            }
                            try {
                                byteArrayOutputStream.close();
                                throw th;
                            } catch (IOException unused5) {
                                throw th;
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused6) {
                        }
                        contentValues.put("blob", byteArrayOutputStream.toByteArray());
                        writableDatabase.insert("via_cgi_report", null, contentValues);
                    }
                    contentValues.clear();
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Exception unused7) {
                com.tencent.open.a.f.e("openSDK_LOG.ReportDatabaseHelper", "saveReportItemToDB has exception.");
                writableDatabase.endTransaction();
            }
            writableDatabase.close();
        } catch (Throwable th4) {
            writableDatabase.endTransaction();
            writableDatabase.close();
            throw th4;
        }
    }
}
