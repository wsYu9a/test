package org.repackage.com.vivo.identifier;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

/* loaded from: classes4.dex */
public class DataBaseOperation {

    /* renamed from: a */
    private static final String f29405a = "VMS_SDK_DB";

    /* renamed from: b */
    private static final String f29406b = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* renamed from: c */
    private static final String f29407c = "content://com.vivo.abe.exidentifier/guid";

    /* renamed from: d */
    private static final String f29408d = "value";

    /* renamed from: e */
    private static final String f29409e = "OAID";

    /* renamed from: f */
    private static final String f29410f = "AAID";

    /* renamed from: g */
    private static final String f29411g = "VAID";

    /* renamed from: h */
    private static final String f29412h = "OAIDBLACK";

    /* renamed from: i */
    private static final String f29413i = "OAIDSTATUS";

    /* renamed from: j */
    private static final String f29414j = "STATISTICS";

    /* renamed from: k */
    private static final int f29415k = 0;

    /* renamed from: l */
    private static final int f29416l = 1;

    /* renamed from: m */
    private static final int f29417m = 2;

    /* renamed from: n */
    private static final int f29418n = 3;

    /* renamed from: o */
    private static final int f29419o = 4;

    /* renamed from: p */
    private static final int f29420p = 5;

    /* renamed from: q */
    private static final int f29421q = 6;

    /* renamed from: r */
    private static final int f29422r = 7;

    /* renamed from: s */
    private static final String f29423s = "UDID";

    /* renamed from: t */
    private Context f29424t;

    public DataBaseOperation(Context context) {
        this.f29424t = context;
    }

    public boolean a(int i10, String str, ContentValues[] contentValuesArr) {
        Uri parse;
        int bulkInsert;
        if (i10 == 6) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        } else if (i10 != 7) {
            parse = null;
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_" + str);
        }
        if (parse == null) {
            return false;
        }
        try {
            bulkInsert = this.f29424t.getContentResolver().bulkInsert(parse, contentValuesArr);
            Log.d(f29405a, "insert:" + bulkInsert);
        } catch (Exception unused) {
            Log.e(f29405a, "return insert is error");
        }
        return bulkInsert != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x009a, code lost:
    
        if (r9 != null) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009c, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ab, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a8, code lost:
    
        if (r9 == null) goto L140;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(int r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "VMS_SDK_DB"
            r1 = 0
            if (r9 == 0) goto L67
            r2 = 1
            if (r9 == r2) goto L51
            r2 = 2
            if (r9 == r2) goto L3b
            r2 = 3
            if (r9 == r2) goto L34
            r2 = 4
            if (r9 == r2) goto L1e
            r10 = 5
            if (r9 == r10) goto L16
            r3 = r1
            goto L6e
        L16:
            java.lang.String r9 = "content://com.vivo.abe.exidentifier/guid"
            android.net.Uri r9 = android.net.Uri.parse(r9)
        L1c:
            r3 = r9
            goto L6e
        L1e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_"
            r9.append(r2)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L1c
        L34:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/UDID"
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L1c
        L3b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r9.append(r2)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L1c
        L51:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r9.append(r2)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L1c
        L67:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L1c
        L6e:
            if (r3 != 0) goto L71
            return r1
        L71:
            android.content.Context r9 = r8.f29424t     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r9 == 0) goto L95
            boolean r10 = r9.moveToNext()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> La3
            if (r10 == 0) goto L9a
            java.lang.String r10 = "value"
            int r10 = r9.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> La3
            java.lang.String r1 = r9.getString(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> La3
            goto L9a
        L92:
            r10 = move-exception
            r1 = r9
            goto Lac
        L95:
            java.lang.String r10 = "return cursor is null,return"
            android.util.Log.d(r0, r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> La3
        L9a:
            if (r9 == 0) goto Lab
        L9c:
            r9.close()
            goto Lab
        La0:
            r10 = move-exception
            goto Lac
        La2:
            r9 = r1
        La3:
            java.lang.String r10 = "return cursor is error"
            android.util.Log.e(r0, r10)     // Catch: java.lang.Throwable -> L92
            if (r9 == 0) goto Lab
            goto L9c
        Lab:
            return r1
        Lac:
            if (r1 == 0) goto Lb1
            r1.close()
        Lb1:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.vivo.identifier.DataBaseOperation.a(int, java.lang.String):java.lang.String");
    }

    public boolean a(int i10, String str, String str2, String str3) {
        Uri parse;
        int delete;
        if (i10 != 6) {
            parse = null;
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        }
        if (parse == null) {
            return false;
        }
        try {
            delete = this.f29424t.getContentResolver().delete(parse, "packageName=? and uid=?", new String[]{str2, str3});
            Log.d(f29405a, "delete:" + delete);
        } catch (Exception unused) {
            Log.e(f29405a, "return delete is error");
        }
        return delete != 0;
    }
}
