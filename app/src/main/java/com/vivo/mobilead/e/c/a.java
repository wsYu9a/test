package com.vivo.mobilead.e.c;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private Context f28807a;

    a(Context context) {
        this.f28807a = context;
    }

    boolean a(int i2, String str, ContentValues[] contentValuesArr) {
        Uri parse;
        int bulkInsert;
        if (i2 == 6) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        } else if (i2 != 7) {
            parse = null;
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_" + str);
        }
        if (parse == null) {
            return false;
        }
        try {
            bulkInsert = this.f28807a.getContentResolver().bulkInsert(parse, contentValuesArr);
            c.a("VMS_SDK_DB", "insert:" + bulkInsert);
        } catch (Exception unused) {
            c.b("VMS_SDK_DB", "return insert is error");
        }
        return bulkInsert != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0097, code lost:
    
        if (r9 != 0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a7, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a4, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a2, code lost:
    
        if (r9 == 0) goto L89;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v10, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String a(int r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "VMS_SDK_DB"
            r1 = 0
            if (r9 == 0) goto L66
            r2 = 1
            if (r9 == r2) goto L50
            r2 = 2
            if (r9 == r2) goto L3a
            r2 = 3
            if (r9 == r2) goto L33
            r2 = 4
            if (r9 == r2) goto L1d
            r10 = 5
            if (r9 == r10) goto L16
            r3 = r1
            goto L6d
        L16:
            java.lang.String r9 = "content://com.vivo.abe.exidentifier/guid"
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L6c
        L1d:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_"
            r9.append(r2)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L6c
        L33:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/UDID"
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L6c
        L3a:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r9.append(r2)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L6c
        L50:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r9.append(r2)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L6c
        L66:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r9 = android.net.Uri.parse(r9)
        L6c:
            r3 = r9
        L6d:
            if (r3 != 0) goto L70
            return r1
        L70:
            android.content.Context r9 = r8.f28807a     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            if (r9 == 0) goto L92
            boolean r10 = r9.moveToNext()     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> La8
            if (r10 == 0) goto L97
            java.lang.String r10 = "value"
            int r10 = r9.getColumnIndex(r10)     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> La8
            java.lang.String r10 = r9.getString(r10)     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> La8
            r1 = r10
            goto L97
        L92:
            java.lang.String r10 = "return cursor is null,return"
            com.vivo.mobilead.e.c.c.a(r0, r10)     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> La8
        L97:
            if (r9 == 0) goto La7
            goto La4
        L9a:
            r10 = move-exception
            goto Laa
        L9c:
            r9 = r1
        L9d:
            java.lang.String r10 = "return cursor is error"
            com.vivo.mobilead.e.c.c.b(r0, r10)     // Catch: java.lang.Throwable -> La8
            if (r9 == 0) goto La7
        La4:
            r9.close()
        La7:
            return r1
        La8:
            r10 = move-exception
            r1 = r9
        Laa:
            if (r1 == 0) goto Laf
            r1.close()
        Laf:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.e.c.a.a(int, java.lang.String):java.lang.String");
    }
}
