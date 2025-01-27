package com.opos.mobad.provider.strategy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import com.martian.mibook.application.MiConfigSingleton;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes4.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: a */
    private ReadWriteLock f23169a;

    public a(Context context) {
        super(context, "opos_mobad_app", (SQLiteDatabase.CursorFactory) null, 1);
        this.f23169a = new ReentrantReadWriteLock();
    }

    private void a(String str, long j2) {
        try {
            com.opos.cmn.an.f.a.b("MobConfig", "remove " + getWritableDatabase().delete("pos", "appId=? and stgVer!=?", new String[]{str, String.valueOf(j2)}));
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("MobConfig", "remove pos fail", e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.opos.mobad.provider.strategy.AppInfo a() {
        /*
            r14 = this;
            java.lang.String r0 = "close err"
            java.lang.String r1 = "MobConfig"
            java.util.concurrent.locks.ReadWriteLock r2 = r14.f23169a
            java.util.concurrent.locks.Lock r2 = r2.readLock()
            r3 = 0
            r2.lock()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            android.database.sqlite.SQLiteDatabase r4 = r14.getWritableDatabase()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            java.lang.String r5 = "app"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            java.lang.String r11 = "lmTime desc"
            java.lang.String r12 = "1"
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            if (r4 == 0) goto L52
            boolean r5 = r4.moveToFirst()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L72
            if (r5 != 0) goto L2a
            goto L52
        L2a:
            java.lang.String r5 = "data"
            int r5 = r4.getColumnIndex(r5)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L72
            byte[] r5 = r4.getBlob(r5)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L72
            java.lang.String r6 = "expTime"
            int r6 = r4.getColumnIndex(r6)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L72
            long r6 = r4.getLong(r6)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L72
            com.opos.mobad.provider.strategy.AppInfo r8 = new com.opos.mobad.provider.strategy.AppInfo     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L72
            r8.<init>(r6, r5)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L72
            r4.close()     // Catch: java.lang.Exception -> L47
            goto L4b
        L47:
            r3 = move-exception
            com.opos.cmn.an.f.a.b(r1, r0, r3)
        L4b:
            r2.unlock()
            r3 = r8
            goto L71
        L50:
            r5 = move-exception
            goto L5f
        L52:
            if (r4 == 0) goto L6e
            r4.close()     // Catch: java.lang.Exception -> L58
            goto L6e
        L58:
            r4 = move-exception
            goto L6b
        L5a:
            r4 = move-exception
            goto L76
        L5c:
            r4 = move-exception
            r5 = r4
            r4 = r3
        L5f:
            java.lang.String r6 = "get app fail"
            com.opos.cmn.an.f.a.b(r1, r6, r5)     // Catch: java.lang.Throwable -> L72
            if (r4 == 0) goto L6e
            r4.close()     // Catch: java.lang.Exception -> L6a
            goto L6e
        L6a:
            r4 = move-exception
        L6b:
            com.opos.cmn.an.f.a.b(r1, r0, r4)
        L6e:
            r2.unlock()
        L71:
            return r3
        L72:
            r3 = move-exception
            r13 = r4
            r4 = r3
            r3 = r13
        L76:
            if (r3 == 0) goto L80
            r3.close()     // Catch: java.lang.Exception -> L7c
            goto L80
        L7c:
            r3 = move-exception
            com.opos.cmn.an.f.a.b(r1, r0, r3)
        L80:
            r2.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.provider.strategy.a.a():com.opos.mobad.provider.strategy.AppInfo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.opos.mobad.provider.strategy.AppInfo a(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = "close err"
            java.lang.String r1 = "MobConfig"
            java.util.concurrent.locks.ReadWriteLock r2 = r13.f23169a
            java.util.concurrent.locks.Lock r2 = r2.readLock()
            r3 = 0
            r2.lock()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            android.database.sqlite.SQLiteDatabase r4 = r13.getWritableDatabase()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            java.lang.String r5 = "app"
            r6 = 0
            java.lang.String r7 = "appId=?"
            r8 = 1
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            r9 = 0
            r8[r9] = r14     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r14 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            if (r14 == 0) goto L55
            boolean r4 = r14.moveToFirst()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L75
            if (r4 != 0) goto L2d
            goto L55
        L2d:
            java.lang.String r4 = "data"
            int r4 = r14.getColumnIndex(r4)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L75
            byte[] r4 = r14.getBlob(r4)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L75
            java.lang.String r5 = "expTime"
            int r5 = r14.getColumnIndex(r5)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L75
            long r5 = r14.getLong(r5)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L75
            com.opos.mobad.provider.strategy.AppInfo r7 = new com.opos.mobad.provider.strategy.AppInfo     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L75
            r7.<init>(r5, r4)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L75
            r14.close()     // Catch: java.lang.Exception -> L4a
            goto L4e
        L4a:
            r14 = move-exception
            com.opos.cmn.an.f.a.b(r1, r0, r14)
        L4e:
            r2.unlock()
            r3 = r7
            goto L74
        L53:
            r4 = move-exception
            goto L62
        L55:
            if (r14 == 0) goto L71
            r14.close()     // Catch: java.lang.Exception -> L5b
            goto L71
        L5b:
            r14 = move-exception
            goto L6e
        L5d:
            r14 = move-exception
            goto L79
        L5f:
            r14 = move-exception
            r4 = r14
            r14 = r3
        L62:
            java.lang.String r5 = "get app fail"
            com.opos.cmn.an.f.a.b(r1, r5, r4)     // Catch: java.lang.Throwable -> L75
            if (r14 == 0) goto L71
            r14.close()     // Catch: java.lang.Exception -> L6d
            goto L71
        L6d:
            r14 = move-exception
        L6e:
            com.opos.cmn.an.f.a.b(r1, r0, r14)
        L71:
            r2.unlock()
        L74:
            return r3
        L75:
            r3 = move-exception
            r12 = r3
            r3 = r14
            r14 = r12
        L79:
            if (r3 == 0) goto L83
            r3.close()     // Catch: java.lang.Exception -> L7f
            goto L83
        L7f:
            r3 = move-exception
            com.opos.cmn.an.f.a.b(r1, r0, r3)
        L83:
            r2.unlock()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.provider.strategy.a.a(java.lang.String):com.opos.mobad.provider.strategy.AppInfo");
    }

    public void a(String str, Bundle bundle, long j2) {
        try {
            try {
                this.f23169a.writeLock().lock();
                getWritableDatabase().beginTransaction();
                for (String str2 : bundle.keySet()) {
                    byte[] byteArray = bundle.getByteArray(str2);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appId", str);
                    contentValues.put("posId", str2);
                    contentValues.put(MiConfigSingleton.t0, byteArray);
                    contentValues.put("stgVer", Long.valueOf(j2));
                    getWritableDatabase().replace("pos", null, contentValues);
                }
                getWritableDatabase().setTransactionSuccessful();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("MobConfig", "add pos fail", e2);
                try {
                    try {
                        getWritableDatabase().endTransaction();
                        a(str, j2);
                    } catch (Exception e3) {
                        com.opos.cmn.an.f.a.b("MobConfig", "end err", e3);
                    }
                } finally {
                }
            }
            try {
                try {
                    getWritableDatabase().endTransaction();
                    a(str, j2);
                } catch (Exception e4) {
                    com.opos.cmn.an.f.a.b("MobConfig", "end err", e4);
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                try {
                    getWritableDatabase().endTransaction();
                    a(str, j2);
                } catch (Exception e5) {
                    com.opos.cmn.an.f.a.b("MobConfig", "end err", e5);
                }
                throw th;
            } finally {
            }
        }
    }

    public void a(String str, byte[] bArr, long j2) {
        Lock writeLock = this.f23169a.writeLock();
        try {
            try {
                writeLock.lock();
                ContentValues contentValues = new ContentValues();
                contentValues.put("appId", str);
                contentValues.put(MiConfigSingleton.t0, bArr);
                contentValues.put("expTime", Long.valueOf(j2));
                contentValues.put("lmTime", Long.valueOf(System.currentTimeMillis()));
                getWritableDatabase().replace("app", null, contentValues);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("MobConfig", "add fail", e2);
            }
        } finally {
            writeLock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        r15 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0063, code lost:
    
        com.opos.cmn.an.f.a.b("MobConfig", "close err", r15);
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.os.Bundle b(java.lang.String r15) {
        /*
            r14 = this;
            java.lang.String r0 = "close err"
            java.lang.String r1 = "MobConfig"
            java.util.concurrent.locks.ReadWriteLock r2 = r14.f23169a
            java.util.concurrent.locks.Lock r2 = r2.readLock()
            r3 = 0
            r2.lock()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            android.database.sqlite.SQLiteDatabase r4 = r14.getWritableDatabase()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r5 = "pos"
            r6 = 0
            java.lang.String r7 = "appId=?"
            r8 = 1
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r9 = 0
            r8[r9] = r15     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r15 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            if (r15 == 0) goto L6d
            boolean r4 = r15.moveToFirst()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8d
            if (r4 != 0) goto L2d
            goto L6d
        L2d:
            java.lang.String r4 = "posId"
            int r4 = r15.getColumnIndex(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8d
            java.lang.String r5 = "stgVer"
            int r5 = r15.getColumnIndex(r5)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8d
            java.lang.String r6 = "data"
            int r6 = r15.getColumnIndex(r6)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8d
            android.os.Bundle r7 = new android.os.Bundle     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8d
            r7.<init>()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8d
        L44:
            java.lang.String r8 = r15.getString(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8d
            long r9 = r15.getLong(r5)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8d
            byte[] r11 = r15.getBlob(r6)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8d
            com.opos.mobad.provider.strategy.PosInfo r12 = new com.opos.mobad.provider.strategy.PosInfo     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8d
            r12.<init>(r11, r9)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8d
            r7.putParcelable(r8, r12)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8d
            boolean r8 = r15.moveToNext()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8d
            if (r8 != 0) goto L44
            r15.close()     // Catch: java.lang.Exception -> L62
            goto L66
        L62:
            r15 = move-exception
            com.opos.cmn.an.f.a.b(r1, r0, r15)
        L66:
            r2.unlock()
            r3 = r7
            goto L8c
        L6b:
            r4 = move-exception
            goto L7a
        L6d:
            if (r15 == 0) goto L89
            r15.close()     // Catch: java.lang.Exception -> L73
            goto L89
        L73:
            r15 = move-exception
            goto L86
        L75:
            r15 = move-exception
            goto L91
        L77:
            r15 = move-exception
            r4 = r15
            r15 = r3
        L7a:
            java.lang.String r5 = "get pos fail"
            com.opos.cmn.an.f.a.b(r1, r5, r4)     // Catch: java.lang.Throwable -> L8d
            if (r15 == 0) goto L89
            r15.close()     // Catch: java.lang.Exception -> L85
            goto L89
        L85:
            r15 = move-exception
        L86:
            com.opos.cmn.an.f.a.b(r1, r0, r15)
        L89:
            r2.unlock()
        L8c:
            return r3
        L8d:
            r3 = move-exception
            r13 = r3
            r3 = r15
            r15 = r13
        L91:
            if (r3 == 0) goto L9b
            r3.close()     // Catch: java.lang.Exception -> L97
            goto L9b
        L97:
            r3 = move-exception
            com.opos.cmn.an.f.a.b(r1, r0, r3)
        L9b:
            r2.unlock()
            goto La0
        L9f:
            throw r15
        La0:
            goto L9f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.provider.strategy.a.b(java.lang.String):android.os.Bundle");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table app(appId varchar primary key,data blob,expTime interger,lmTime interger);");
        sQLiteDatabase.execSQL("create table pos(posId varchar primary key,appId varchar,data blob,stgVer interger)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
