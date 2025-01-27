package com.opos.acs.st.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.opos.acs.st.STManager;
import com.opos.acs.st.utils.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    private static final ReentrantReadWriteLock f16279a = new ReentrantReadWriteLock();

    /* renamed from: b */
    private static final ReentrantReadWriteLock f16280b = new ReentrantReadWriteLock();

    public static int a(Context context, String str, long j2) {
        ReentrantReadWriteLock.WriteLock writeLock;
        int i2 = -1;
        if (context != null || j2 > 0 || !h.a(str)) {
            String str2 = "EVENT_ID in (" + str + ") AND EVENT_TIME < " + j2;
            try {
                SQLiteDatabase a2 = a.a(context);
                try {
                    ReentrantReadWriteLock reentrantReadWriteLock = f16279a;
                    reentrantReadWriteLock.writeLock().lock();
                    i2 = a2.delete("t_acs_st_db_cache", str2, null);
                    writeLock = reentrantReadWriteLock.writeLock();
                } catch (Exception unused) {
                    writeLock = f16279a.writeLock();
                } catch (Throwable th) {
                    f16279a.writeLock().unlock();
                    throw th;
                }
                writeLock.unlock();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.d("STDBUtils", "DeleteStatItemEntityByEventTime", e2);
            }
        }
        return i2;
    }

    private static ContentValues a(com.opos.acs.st.b.b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("BATCH_ID", bVar.f16287b);
        contentValues.put("ACS_POS_IDS", bVar.f16288c);
        contentValues.put("EFFECTIVE_TAG", Integer.valueOf(bVar.f16289d));
        return contentValues;
    }

    private static com.opos.acs.st.b.c a(Context context, Cursor cursor) {
        com.opos.acs.st.b.c cVar = new com.opos.acs.st.b.c();
        cVar.f16290a = cursor.getInt(cursor.getColumnIndex(STManager.REGION_OF_ID));
        cVar.f16291b = cursor.getString(cursor.getColumnIndex("EVENT_ID"));
        cVar.f16292c = cursor.getString(cursor.getColumnIndex("ACS_ID"));
        cVar.f16293d = cursor.getString(cursor.getColumnIndex("URL"));
        cVar.f16297h = cursor.getString(cursor.getColumnIndex("BATCH_ID"));
        cVar.f16298i = cursor.getLong(cursor.getColumnIndex("EVENT_TIME"));
        cVar.f16294e = com.opos.acs.st.b.a.b(context, cursor.getString(cursor.getColumnIndex("HEAD_JSON_STRING")));
        cVar.f16295f = com.opos.acs.st.b.a.b(context, cursor.getString(cursor.getColumnIndex("BODY_JSON_STRING")));
        cVar.f16296g = com.opos.acs.st.b.a.b(context, cursor.getString(cursor.getColumnIndex("EVENT_JSON_STRING")));
        int i2 = cursor.getInt(cursor.getColumnIndex("UPLOAD_TYPE"));
        cVar.f16299j = i2;
        if (i2 == 1) {
            try {
                cVar.k = new JSONObject(cVar.f16294e);
                cVar.l = new JSONObject(cVar.f16295f);
            } catch (JSONException unused) {
                com.opos.cmn.an.f.a.d("STDBUtils", "getStatItemEntityFromCursor error!");
            }
        }
        return cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
    
        if (r7 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        a(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        if (r7 == null) goto L80;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.opos.acs.st.b.c a(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r6 == 0) goto L6b
            if (r7 == 0) goto L6b
            if (r8 == 0) goto L6b
            if (r9 == 0) goto L6b
            android.database.sqlite.SQLiteDatabase r1 = com.opos.acs.st.a.a.a(r6)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = com.opos.acs.st.a.b.f16279a     // Catch: java.lang.Throwable -> L4a
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r3 = r2.readLock()     // Catch: java.lang.Throwable -> L4a
            r3.lock()     // Catch: java.lang.Throwable -> L4a
            java.lang.String r3 = "select * from t_acs_st_db_cache where EVENT_ID = ? and URL = ? and ACS_ID = ? "
            r4 = 3
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L4a
            r5 = 0
            r4[r5] = r7     // Catch: java.lang.Throwable -> L4a
            r7 = 1
            r4[r7] = r9     // Catch: java.lang.Throwable -> L4a
            r7 = 2
            r4[r7] = r8     // Catch: java.lang.Throwable -> L4a
            android.database.Cursor r7 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L4a
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r8 = r2.readLock()     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L63
            r8.unlock()     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L63
            if (r7 == 0) goto L42
            int r8 = r7.getCount()     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L63
            if (r8 <= 0) goto L42
            boolean r8 = r7.moveToFirst()     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L63
            if (r8 == 0) goto L42
            com.opos.acs.st.b.c r6 = a(r6, r7)     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L63
            r0 = r6
        L42:
            if (r7 == 0) goto L6b
        L44:
            a(r7)
            goto L6b
        L48:
            r6 = move-exception
            goto L59
        L4a:
            r6 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r7 = com.opos.acs.st.a.b.f16279a     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r7 = r7.readLock()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r7.unlock()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            throw r6     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
        L55:
            r6 = move-exception
            goto L65
        L57:
            r6 = move-exception
            r7 = r0
        L59:
            java.lang.String r8 = "STDBUtils"
            java.lang.String r9 = "queryStatItemEntity"
            com.opos.cmn.an.f.a.d(r8, r9, r6)     // Catch: java.lang.Throwable -> L63
            if (r7 == 0) goto L6b
            goto L44
        L63:
            r6 = move-exception
            r0 = r7
        L65:
            if (r0 == 0) goto L6a
            a(r0)
        L6a:
            throw r6
        L6b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.a.b.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):com.opos.acs.st.b.c");
    }

    public static Integer a(Context context, String str) {
        String str2 = "select count(*) from t_acs_st_db_cache where EVENT_ID = '" + str + "'";
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase a2 = a.a(context);
                ReentrantReadWriteLock reentrantReadWriteLock = f16279a;
                reentrantReadWriteLock.writeLock().lock();
                cursor = a2.rawQuery(str2, null);
                cursor.moveToFirst();
                Integer valueOf = Integer.valueOf(cursor.getInt(0));
                reentrantReadWriteLock.writeLock().unlock();
                a(cursor);
                return valueOf;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.d("STDBUtils", "queryAllStatItemEntityCount", e2);
                f16279a.writeLock().unlock();
                a(cursor);
                return 0;
            }
        } catch (Throwable th) {
            f16279a.writeLock().unlock();
            a(cursor);
            throw th;
        }
    }

    private static String a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("(");
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(list.get(i2));
                if (i2 != list.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    private static String a(Integer[] numArr) {
        StringBuilder sb = new StringBuilder();
        if (numArr != null) {
            sb.append("(");
            for (int i2 = 0; i2 < numArr.length; i2++) {
                sb.append(numArr[i2]);
                if (i2 != numArr.length - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> a(android.content.Context r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L82
            android.database.sqlite.SQLiteDatabase r5 = com.opos.acs.st.a.a.a(r5)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = com.opos.acs.st.a.b.f16279a     // Catch: java.lang.Throwable -> L58
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r1.readLock()     // Catch: java.lang.Throwable -> L58
            r2.lock()     // Catch: java.lang.Throwable -> L58
            java.lang.String r2 = "select distinct URL from t_acs_st_db_cache"
            android.database.Cursor r5 = r5.rawQuery(r2, r0)     // Catch: java.lang.Throwable -> L58
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            r1.unlock()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            if (r5 == 0) goto L4a
            int r1 = r5.getCount()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            if (r1 <= 0) goto L4a
            boolean r1 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            if (r1 == 0) goto L4a
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            r1.<init>()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
        L30:
            java.lang.String r0 = "URL"
            int r0 = r5.getColumnIndex(r0)     // Catch: java.lang.Exception -> L45 java.lang.Throwable -> L50
            java.lang.String r0 = r5.getString(r0)     // Catch: java.lang.Exception -> L45 java.lang.Throwable -> L50
            r1.add(r0)     // Catch: java.lang.Exception -> L45 java.lang.Throwable -> L50
            boolean r0 = r5.moveToNext()     // Catch: java.lang.Exception -> L45 java.lang.Throwable -> L50
            if (r0 != 0) goto L30
            r0 = r1
            goto L4a
        L45:
            r0 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L67
        L4a:
            if (r5 == 0) goto L82
            a(r5)
            goto L82
        L50:
            r0 = move-exception
            goto L79
        L52:
            r1 = move-exception
            r4 = r0
            r0 = r5
            r5 = r1
            r1 = r4
            goto L67
        L58:
            r5 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = com.opos.acs.st.a.b.f16279a     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            r1.unlock()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            throw r5     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
        L63:
            r5 = move-exception
            goto L7c
        L65:
            r5 = move-exception
            r1 = r0
        L67:
            java.lang.String r2 = "STDBUtils"
            java.lang.String r3 = "queryAllStatItemEntity"
            com.opos.cmn.an.f.a.d(r2, r3, r5)     // Catch: java.lang.Throwable -> L75
            if (r0 == 0) goto L73
            a(r0)
        L73:
            r0 = r1
            goto L82
        L75:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
        L79:
            r4 = r0
            r0 = r5
            r5 = r4
        L7c:
            if (r0 == 0) goto L81
            a(r0)
        L81:
            throw r5
        L82:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.a.b.a(android.content.Context):java.util.List");
    }

    public static List<com.opos.acs.st.b.c> a(Context context, String str, String str2) {
        ArrayList arrayList;
        ReentrantReadWriteLock reentrantReadWriteLock;
        Cursor rawQuery;
        Cursor cursor = null;
        r0 = null;
        r0 = null;
        ArrayList arrayList2 = null;
        Cursor cursor2 = null;
        if (context == null || str == null || str2 == null) {
            return null;
        }
        try {
            try {
                SQLiteDatabase a2 = a.a(context);
                try {
                    reentrantReadWriteLock = f16279a;
                    reentrantReadWriteLock.readLock().lock();
                    rawQuery = a2.rawQuery("select * from t_acs_st_db_cache where EVENT_ID = ? AND URL = ? ", new String[]{str, str2});
                } catch (Throwable th) {
                    f16279a.readLock().unlock();
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                arrayList = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            try {
                reentrantReadWriteLock.readLock().unlock();
                if (rawQuery != null && rawQuery.getCount() > 0 && rawQuery.moveToFirst()) {
                    arrayList = new ArrayList();
                    do {
                        try {
                            arrayList.add(a(context, rawQuery));
                        } catch (Exception e3) {
                            e = e3;
                            cursor = rawQuery;
                            com.opos.cmn.an.f.a.d("STDBUtils", "queryAllStatItemEntity", e);
                            if (cursor != null) {
                                a(cursor);
                            }
                            return arrayList;
                        }
                    } while (rawQuery.moveToNext());
                    arrayList2 = arrayList;
                }
                if (rawQuery == null) {
                    return arrayList2;
                }
                a(rawQuery);
                return arrayList2;
            } catch (Exception e4) {
                e = e4;
                arrayList = null;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor2 = rawQuery;
            if (cursor2 != null) {
                a(cursor2);
            }
            throw th;
        }
    }

    private static void a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    public static boolean a(Context context, com.opos.acs.st.b.b bVar) {
        if (context != null) {
            ContentValues a2 = a(bVar);
            try {
                SQLiteDatabase a3 = a.a(context);
                try {
                    ReentrantReadWriteLock reentrantReadWriteLock = f16280b;
                    reentrantReadWriteLock.writeLock().lock();
                    r0 = -1 != a3.insert("t_stat_batch_entity", null, a2);
                    reentrantReadWriteLock.writeLock().unlock();
                } catch (Throwable th) {
                    f16280b.writeLock().unlock();
                    throw th;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.d("STDBUtils", "insertStatBatchEntity", e2);
            }
        }
        return r0;
    }

    public static boolean a(Context context, com.opos.acs.st.b.c cVar) {
        if (context != null && cVar != null) {
            ContentValues c2 = c(context, cVar);
            try {
                SQLiteDatabase a2 = a.a(context);
                try {
                    ReentrantReadWriteLock reentrantReadWriteLock = f16279a;
                    reentrantReadWriteLock.writeLock().lock();
                    r0 = -1 != a2.insert("t_acs_st_db_cache", null, c2);
                    reentrantReadWriteLock.writeLock().unlock();
                } catch (Throwable th) {
                    f16279a.writeLock().unlock();
                    throw th;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.d("STDBUtils", "insertStatItemEntity", e2);
            }
        }
        return r0;
    }

    public static boolean a(Context context, List<String> list) {
        String str;
        ReentrantReadWriteLock reentrantReadWriteLock;
        boolean z = true;
        if (context != null) {
            if (list == null || list.size() == 0) {
                str = "delete from t_stat_batch_entity";
            } else {
                str = "delete from t_stat_batch_entity where BATCH_ID in " + a(list);
            }
            try {
                SQLiteDatabase a2 = a.a(context);
                try {
                    reentrantReadWriteLock = f16280b;
                    reentrantReadWriteLock.writeLock().lock();
                    a2.execSQL(str);
                } catch (Exception unused) {
                    f16280b.writeLock().unlock();
                } catch (Throwable th) {
                    f16280b.writeLock().unlock();
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                z = false;
            }
            try {
                reentrantReadWriteLock.writeLock().unlock();
                return true;
            } catch (Exception e3) {
                e = e3;
                com.opos.cmn.an.f.a.d("STDBUtils", "deleteStatBatchEntitysByBatchIds", e);
                return z;
            }
        }
        return false;
    }

    public static boolean a(Context context, Integer[] numArr) {
        String str;
        boolean z = true;
        if (context != null) {
            if (numArr == null || numArr.length == 0) {
                str = "delete from t_acs_st_db_cache";
            } else {
                str = "delete from t_acs_st_db_cache where ID in " + a(numArr);
            }
            try {
                SQLiteDatabase a2 = a.a(context);
                try {
                    try {
                        ReentrantReadWriteLock reentrantReadWriteLock = f16279a;
                        reentrantReadWriteLock.writeLock().lock();
                        a2.execSQL(str);
                        try {
                            reentrantReadWriteLock.writeLock().unlock();
                            return true;
                        } catch (Exception e2) {
                            e = e2;
                            com.opos.cmn.an.f.a.d("STDBUtils", "deleteStatItemEntityByIds", e);
                            return z;
                        }
                    } catch (Exception unused) {
                    }
                } finally {
                    f16279a.writeLock().unlock();
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0069, code lost:
    
        if (r5 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
    
        a(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0088, code lost:
    
        if (r5 == null) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.opos.acs.st.b.b b(android.content.Context r5, java.lang.String r6) {
        /*
            r0 = 0
            if (r5 == 0) goto L94
            if (r6 == 0) goto L94
            android.database.sqlite.SQLiteDatabase r5 = com.opos.acs.st.a.a.a(r5)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = com.opos.acs.st.a.b.f16280b     // Catch: java.lang.Throwable -> L71
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r1.readLock()     // Catch: java.lang.Throwable -> L71
            r2.lock()     // Catch: java.lang.Throwable -> L71
            java.lang.String r2 = "select * from t_stat_batch_entity where BATCH_ID = ? "
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L71
            r4 = 0
            r3[r4] = r6     // Catch: java.lang.Throwable -> L71
            android.database.Cursor r5 = r5.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L71
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r6 = r1.readLock()     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            r6.unlock()     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            if (r5 == 0) goto L69
            int r6 = r5.getCount()     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            if (r6 <= 0) goto L69
            boolean r6 = r5.moveToFirst()     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            if (r6 == 0) goto L69
            com.opos.acs.st.b.b r6 = new com.opos.acs.st.b.b     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            r6.<init>()     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            java.lang.String r1 = "ID"
            int r1 = r5.getColumnIndex(r1)     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            int r1 = r5.getInt(r1)     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            r6.f16286a = r1     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            java.lang.String r1 = "BATCH_ID"
            int r1 = r5.getColumnIndex(r1)     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            java.lang.String r1 = r5.getString(r1)     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            r6.f16287b = r1     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            java.lang.String r1 = "ACS_POS_IDS"
            int r1 = r5.getColumnIndex(r1)     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            java.lang.String r1 = r5.getString(r1)     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            r6.f16288c = r1     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            java.lang.String r1 = "EFFECTIVE_TAG"
            int r1 = r5.getColumnIndex(r1)     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            int r1 = r5.getInt(r1)     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            r6.f16289d = r1     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L8b
            r0 = r6
        L69:
            if (r5 == 0) goto L94
        L6b:
            a(r5)
            goto L94
        L6f:
            r6 = move-exception
            goto L81
        L71:
            r5 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r6 = com.opos.acs.st.a.b.f16280b     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r6 = r6.readLock()     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            r6.unlock()     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            throw r5     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
        L7c:
            r5 = move-exception
            goto L8e
        L7e:
            r5 = move-exception
            r6 = r5
            r5 = r0
        L81:
            java.lang.String r1 = "STDBUtils"
            java.lang.String r2 = "queryStatBatchEntity"
            com.opos.cmn.an.f.a.d(r1, r2, r6)     // Catch: java.lang.Throwable -> L8b
            if (r5 == 0) goto L94
            goto L6b
        L8b:
            r6 = move-exception
            r0 = r5
            r5 = r6
        L8e:
            if (r0 == 0) goto L93
            a(r0)
        L93:
            throw r5
        L94:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.a.b.b(android.content.Context, java.lang.String):com.opos.acs.st.b.b");
    }

    public static boolean b(Context context, com.opos.acs.st.b.b bVar) {
        boolean z = false;
        if (context == null || bVar == null) {
            return false;
        }
        int i2 = bVar.f16286a;
        ContentValues a2 = a(bVar);
        try {
            SQLiteDatabase a3 = a.a(context);
            try {
                ReentrantReadWriteLock reentrantReadWriteLock = f16280b;
                reentrantReadWriteLock.writeLock().lock();
                a3.update("t_stat_batch_entity", a2, "ID = ? ", new String[]{String.valueOf(i2)});
                try {
                    reentrantReadWriteLock.writeLock().unlock();
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    z = true;
                    com.opos.cmn.an.f.a.d("STDBUtils", "updateStatBatchEntity", e);
                    return z;
                }
            } catch (Throwable th) {
                f16280b.writeLock().unlock();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static boolean b(Context context, com.opos.acs.st.b.c cVar) {
        boolean z = false;
        if (context == null || cVar == null) {
            return false;
        }
        int i2 = cVar.f16290a;
        ContentValues c2 = c(context, cVar);
        try {
            SQLiteDatabase a2 = a.a(context);
            try {
                ReentrantReadWriteLock reentrantReadWriteLock = f16279a;
                reentrantReadWriteLock.writeLock().lock();
                a2.update("t_acs_st_db_cache", c2, "ID = ? ", new String[]{String.valueOf(i2)});
                try {
                    reentrantReadWriteLock.writeLock().unlock();
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    z = true;
                    com.opos.cmn.an.f.a.d("STDBUtils", "updateStatItemEntity", e);
                    return z;
                }
            } catch (Throwable th) {
                f16279a.writeLock().unlock();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static ContentValues c(Context context, com.opos.acs.st.b.c cVar) {
        if (cVar.f16299j == 1) {
            JSONObject jSONObject = cVar.k;
            if (jSONObject != null) {
                cVar.f16294e = jSONObject.toString();
            }
            JSONObject jSONObject2 = cVar.l;
            if (jSONObject2 != null) {
                cVar.f16295f = jSONObject2.toString();
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("EVENT_ID", cVar.f16291b);
        contentValues.put("ACS_ID", cVar.f16292c);
        contentValues.put("URL", cVar.f16293d);
        contentValues.put("BATCH_ID", cVar.f16297h);
        contentValues.put("EVENT_TIME", Long.valueOf(cVar.f16298i));
        contentValues.put("HEAD_JSON_STRING", com.opos.acs.st.b.a.a(context, cVar.f16294e));
        contentValues.put("BODY_JSON_STRING", com.opos.acs.st.b.a.a(context, cVar.f16295f));
        contentValues.put("EVENT_JSON_STRING", com.opos.acs.st.b.a.a(context, cVar.f16296g));
        contentValues.put("UPLOAD_TYPE", Integer.valueOf(cVar.f16299j));
        return contentValues;
    }
}
