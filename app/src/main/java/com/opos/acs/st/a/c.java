package com.opos.acs.st.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.opos.acs.st.STManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    private static ReentrantReadWriteLock f16281a = new ReentrantReadWriteLock();

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
    
        if (r1.isClosed() == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0029, code lost:
    
        if (r1.isClosed() == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
    
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r4) {
        /*
            r0 = 0
            r1 = 0
            android.database.sqlite.SQLiteDatabase r4 = com.opos.acs.st.a.a.a(r4)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = com.opos.acs.st.a.c.f16281a     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r2.readLock()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r2.lock()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            java.lang.String r2 = "select count(*) from t_biz_entity"
            android.database.Cursor r1 = r4.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            java.util.concurrent.locks.ReentrantReadWriteLock r4 = com.opos.acs.st.a.c.f16281a
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = r4.readLock()
            r4.unlock()
            boolean r4 = r1.isClosed()
            if (r4 != 0) goto L4b
        L2b:
            r1.close()
            goto L4b
        L2f:
            r4 = move-exception
            goto L4c
        L31:
            r4 = move-exception
            java.lang.String r2 = "StBizUtils"
            java.lang.String r3 = "queryCount"
            com.opos.cmn.an.f.a.d(r2, r3, r4)     // Catch: java.lang.Throwable -> L2f
            java.util.concurrent.locks.ReentrantReadWriteLock r4 = com.opos.acs.st.a.c.f16281a
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = r4.readLock()
            r4.unlock()
            if (r1 == 0) goto L4b
            boolean r4 = r1.isClosed()
            if (r4 != 0) goto L4b
            goto L2b
        L4b:
            return r0
        L4c:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = com.opos.acs.st.a.c.f16281a
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            if (r1 == 0) goto L60
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L60
            r1.close()
        L60:
            goto L62
        L61:
            throw r4
        L62:
            goto L61
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.a.c.a(android.content.Context):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v23, types: [java.util.List<com.opos.acs.st.b.a>] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static List<com.opos.acs.st.b.a> a(Context context, long j2, int i2) {
        ArrayList arrayList;
        ?? r0 = 0;
        r0 = null;
        r0 = null;
        ArrayList arrayList2 = null;
        Cursor cursor = null;
        r0 = 0;
        try {
            if (context != null) {
                try {
                    SQLiteDatabase a2 = a.a(context);
                    f16281a.readLock().lock();
                    Cursor query = a2.query("t_biz_entity", null, "EVENT_TIME>?", new String[]{String.valueOf(j2)}, null, null, "UPDATE_TIME", String.valueOf(i2));
                    if (query != null) {
                        try {
                            try {
                                if (query.getCount() > 0 && query.moveToFirst()) {
                                    arrayList = new ArrayList();
                                    do {
                                        try {
                                            com.opos.acs.st.b.a aVar = new com.opos.acs.st.b.a();
                                            aVar.f16282a = query.getInt(query.getColumnIndex(STManager.REGION_OF_ID));
                                            aVar.f16283b = com.opos.acs.st.b.a.b(context, query.getString(query.getColumnIndex("BIZ_DATA")));
                                            aVar.f16284c = query.getLong(query.getColumnIndex("EVENT_TIME"));
                                            aVar.f16285d = query.getLong(query.getColumnIndex("UPDATE_TIME"));
                                            arrayList.add(aVar);
                                        } catch (Exception e2) {
                                            e = e2;
                                            cursor = query;
                                            com.opos.cmn.an.f.a.d("StBizUtils", "query all StBizEntity", e);
                                            f16281a.readLock().unlock();
                                            if (cursor != null && !cursor.isClosed()) {
                                                cursor.close();
                                            }
                                            r0 = arrayList;
                                            return r0;
                                        }
                                    } while (query.moveToNext());
                                    arrayList2 = arrayList;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                arrayList = null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            r0 = query;
                            f16281a.readLock().unlock();
                            if (r0 != 0 && !r0.isClosed()) {
                                r0.close();
                            }
                            throw th;
                        }
                    }
                    f16281a.readLock().unlock();
                    r0 = arrayList2;
                    if (query != null) {
                        r0 = arrayList2;
                        if (!query.isClosed()) {
                            query.close();
                            r0 = arrayList2;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    arrayList = null;
                }
            }
            return r0;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(Context context, long j2) {
        if (context != null || j2 > 0) {
            try {
                try {
                    SQLiteDatabase a2 = a.a(context);
                    String concat = "EVENT_TIME < ".concat(String.valueOf(j2));
                    f16281a.writeLock().lock();
                    a2.delete("t_biz_entity", concat, null);
                    com.opos.cmn.an.f.a.b("StBizUtils", "delete expired data from db!");
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.d("StBizUtils", "delete expired failed", e2);
                }
            } finally {
                f16281a.writeLock().unlock();
            }
        }
    }

    public static void a(Context context, com.opos.acs.st.b.a aVar) {
        try {
            if (context == null) {
                return;
            }
            try {
                ContentValues d2 = d(context, aVar);
                SQLiteDatabase a2 = a.a(context);
                f16281a.writeLock().lock();
                a2.insert("t_biz_entity", null, d2);
                com.opos.cmn.an.f.a.b("StBizUtils", "saved business data to db!");
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.d("StBizUtils", "insert StBizEntity failed", e2);
            }
        } finally {
            f16281a.writeLock().unlock();
        }
    }

    public static void b(Context context, com.opos.acs.st.b.a aVar) {
        if (context != null) {
            try {
                if (aVar == null) {
                    return;
                }
                try {
                    aVar.f16285d = System.currentTimeMillis();
                    int i2 = aVar.f16282a;
                    ContentValues d2 = d(context, aVar);
                    SQLiteDatabase a2 = a.a(context);
                    f16281a.writeLock().lock();
                    a2.update("t_biz_entity", d2, "ID = ? ", new String[]{String.valueOf(i2)});
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.d("StBizUtils", "update StBizEntity failed", e2);
                }
            } finally {
                f16281a.writeLock().unlock();
            }
        }
    }

    public static void c(Context context, com.opos.acs.st.b.a aVar) {
        if (context == null) {
            return;
        }
        try {
            try {
                SQLiteDatabase a2 = a.a(context);
                int i2 = aVar.f16282a;
                f16281a.writeLock().lock();
                a2.delete("t_biz_entity", "ID = ? ", new String[]{String.valueOf(i2)});
                com.opos.cmn.an.f.a.b("StBizUtils", "delete business data from db!");
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.d("StBizUtils", "delete business failed", e2);
            }
        } finally {
            f16281a.writeLock().unlock();
        }
    }

    private static ContentValues d(Context context, com.opos.acs.st.b.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("BIZ_DATA", com.opos.acs.st.b.a.a(context, aVar.f16283b));
        contentValues.put("EVENT_TIME", Long.valueOf(aVar.f16284c));
        contentValues.put("UPDATE_TIME", Long.valueOf(aVar.f16285d));
        return contentValues;
    }
}
