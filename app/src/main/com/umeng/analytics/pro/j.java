package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public class j {
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        if (r1 == null) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r12, android.database.sqlite.SQLiteDatabase r13) {
        /*
            r0 = 0
            if (r12 != 0) goto L4
            return r0
        L4:
            r1 = 0
            java.lang.String r2 = "count(*)"
            java.lang.String[] r5 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.String r2 = "table"
            java.lang.String r12 = r12.trim()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.String[] r7 = new java.lang.String[]{r2, r12}     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.String r4 = "sqlite_master"
            java.lang.String r6 = "type=? and name=?"
            r10 = 0
            r11 = 0
            r8 = 0
            r9 = 0
            r3 = r13
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            boolean r12 = r1.moveToNext()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            if (r12 == 0) goto L34
            int r12 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            if (r12 <= 0) goto L34
            r0 = 1
            goto L34
        L30:
            r12 = move-exception
            goto L38
        L32:
            goto L3e
        L34:
            r1.close()
            goto L41
        L38:
            if (r1 == 0) goto L3d
            r1.close()
        L3d:
            throw r12
        L3e:
            if (r1 == 0) goto L41
            goto L34
        L41:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.j.a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    public static String b(Context context) {
        return context.getDatabasePath(g.f23920b).getParent() + File.separator;
    }

    public static String c(Context context) {
        return b(context) + g.f23919a;
    }

    public static List<String> b(List<String> list) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : list) {
                if (Collections.frequency(arrayList, str) < 1) {
                    arrayList.add(str);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return arrayList;
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            File databasePath = context.getDatabasePath(g.f23920b);
            if (databasePath != null && databasePath.exists()) {
                databasePath.delete();
            }
            h.a(context).a();
        } catch (Throwable unused) {
        }
    }

    public static String a(List<String> list) {
        return TextUtils.join("!", list);
    }

    public static List<String> a(String str) {
        return new ArrayList(Arrays.asList(str.split("!")));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
    
        if (r1.isClosed() == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        if (r1.isClosed() == false) goto L71;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.database.sqlite.SQLiteDatabase r10, java.lang.String r11, java.lang.String r12) {
        /*
            r0 = 0
            r1 = 0
            java.lang.String r9 = "LIMIT 0"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r2 = r10
            r3 = r11
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r1 == 0) goto L1e
            int r10 = r1.getColumnIndex(r12)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            r11 = -1
            if (r10 == r11) goto L1e
            r0 = 1
            goto L1e
        L1a:
            r10 = move-exception
            goto L2a
        L1c:
            goto L36
        L1e:
            if (r1 == 0) goto L3f
            boolean r10 = r1.isClosed()
            if (r10 != 0) goto L3f
        L26:
            r1.close()
            goto L3f
        L2a:
            if (r1 == 0) goto L35
            boolean r11 = r1.isClosed()
            if (r11 != 0) goto L35
            r1.close()
        L35:
            throw r10
        L36:
            if (r1 == 0) goto L3f
            boolean r10 = r1.isClosed()
            if (r10 != 0) goto L3f
            goto L26
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.j.a(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String):boolean");
    }

    public static void a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.execSQL("alter table " + str + " add " + str2 + " " + str3);
    }
}
