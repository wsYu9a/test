package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.g;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a */
    public static final int f23994a = 2049;

    /* renamed from: b */
    public static final int f23995b = 2050;

    /* renamed from: c */
    private static final int f23996c = 1000;

    /* renamed from: d */
    private static Context f23997d = null;

    /* renamed from: e */
    private static String f23998e = null;

    /* renamed from: f */
    private static final String f23999f = "umeng+";

    /* renamed from: g */
    private static final String f24000g = "ek__id";

    /* renamed from: h */
    private static final String f24001h = "ek_key";

    /* renamed from: i */
    private List<String> f24002i;

    /* renamed from: j */
    private List<Integer> f24003j;

    /* renamed from: k */
    private String f24004k;

    /* renamed from: l */
    private List<String> f24005l;

    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    public static class b {

        /* renamed from: a */
        private static final k f24013a = new k();

        private b() {
        }
    }

    public /* synthetic */ k(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static k a(Context context) {
        k kVar = b.f24013a;
        if (f23997d == null && context != null) {
            f23997d = context.getApplicationContext();
            kVar.k();
        }
        return kVar;
    }

    private void k() {
        synchronized (this) {
            l();
            this.f24002i.clear();
            this.f24005l.clear();
            this.f24003j.clear();
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(f23998e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(f23997d, f24000g);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(f23997d).getString(f24000g, null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = UMUtils.genId();
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(f23997d, f24000g, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String substring = multiProcessSP.substring(1, 9);
                    StringBuilder sb2 = new StringBuilder();
                    for (int i10 = 0; i10 < substring.length(); i10++) {
                        char charAt = substring.charAt(i10);
                        if (!Character.isDigit(charAt)) {
                            sb2.append(charAt);
                        } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                            sb2.append(0);
                        } else {
                            sb2.append(10 - Integer.parseInt(Character.toString(charAt)));
                        }
                    }
                    f23998e = sb2.toString();
                }
                if (TextUtils.isEmpty(f23998e)) {
                    return;
                }
                f23998e += new StringBuilder(f23998e).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(f23997d, f24001h);
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(f23997d, f24001h, c(f23999f));
                } else {
                    if (f23999f.equals(d(multiProcessSP2))) {
                        return;
                    }
                    b(true, false);
                    a(true, false);
                    h();
                    i();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        this.f24005l.clear();
    }

    public boolean c() {
        return this.f24005l.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x007f, code lost:
    
        if (r0 == null) goto L95;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            r6 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            com.umeng.analytics.pro.w r1 = com.umeng.analytics.pro.w.a()     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r1 = r1.c()     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            if (r2 == 0) goto L29
            r0.endTransaction()     // Catch: java.lang.Throwable -> L1f
        L1f:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            return
        L29:
            java.lang.String r2 = ""
            java.lang.String r3 = "-1"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r3 = 0
        L32:
            r4 = 2
            if (r3 >= r4) goto L67
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r4.<init>()     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r5 = "update __et set __i=\""
            r4.append(r5)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r4.append(r1)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r5 = "\" where "
            r4.append(r5)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r5 = "__i"
            r4.append(r5)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r5 = "=\""
            r4.append(r5)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r5 = r2[r3]     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r4.append(r5)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r5 = "\""
            r4.append(r5)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            int r3 = r3 + 1
            goto L32
        L65:
            goto L77
        L67:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L65 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
        L6a:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L6d
        L6d:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L82
        L77:
            if (r0 == 0) goto L6d
            goto L6a
        L7a:
            android.content.Context r1 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L83
            com.umeng.analytics.pro.j.a(r1)     // Catch: java.lang.Throwable -> L83
            if (r0 == 0) goto L6d
            goto L6a
        L82:
            return
        L83:
            r1 = move-exception
            if (r0 == 0) goto L89
            r0.endTransaction()     // Catch: java.lang.Throwable -> L89
        L89:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.d():void");
    }

    public boolean e() {
        return this.f24002i.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a6, code lost:
    
        if (r2 != null) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008e, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008c, code lost:
    
        if (r2 != null) goto L183;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject f() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.f24005l
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L84
            com.umeng.analytics.pro.i r2 = com.umeng.analytics.pro.i.a(r2)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L84
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L84
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7e
            java.util.List<java.lang.String> r4 = r14.f24005l     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7e
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7e
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7e
            java.lang.String r5 = "__is"
            java.lang.String r8 = "__ii=? "
            java.lang.String[] r9 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7e
            r12 = 0
            r13 = 0
            r7 = 0
            r10 = 0
            r11 = 0
            r4 = r14
            r6 = r2
            android.database.Cursor r4 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7e
            if (r4 == 0) goto L66
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            if (r5 == 0) goto L66
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r5.<init>()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r3 = r5
            goto L66
        L5c:
        L5d:
            r3 = r4
            goto L87
        L5f:
            r3 = r4
            goto L9c
        L61:
            r5 = r3
            goto L5d
        L64:
            r5 = r3
            goto L5f
        L66:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            if (r4 == 0) goto L6e
            r4.close()
        L6e:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L71
        L71:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto La9
        L7b:
            r5 = r3
            goto L87
        L7e:
            r5 = r3
            goto L9c
        L80:
            r2 = r3
            r5 = r2
            goto L87
        L84:
            r2 = r3
            r5 = r2
            goto L9c
        L87:
            if (r3 == 0) goto L8c
            r3.close()
        L8c:
            if (r2 == 0) goto L91
        L8e:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L91
        L91:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            r3 = r5
            goto La9
        L9c:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> Laa
            com.umeng.analytics.pro.j.a(r0)     // Catch: java.lang.Throwable -> Laa
            if (r3 == 0) goto La6
            r3.close()
        La6:
            if (r2 == 0) goto L91
            goto L8e
        La9:
            return r3
        Laa:
            r0 = move-exception
            if (r3 == 0) goto Lb0
            r3.close()
        Lb0:
            if (r2 == 0) goto Lb5
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb5
        Lb5:
            android.content.Context r1 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)
            r1.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.f():org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a6, code lost:
    
        if (r2 != null) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008e, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008c, code lost:
    
        if (r2 != null) goto L183;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject g() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.f24002i
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L84
            com.umeng.analytics.pro.i r2 = com.umeng.analytics.pro.i.a(r2)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L84
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L84
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7e
            java.util.List<java.lang.String> r4 = r14.f24002i     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7e
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7e
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7e
            java.lang.String r5 = "__sd"
            java.lang.String r8 = "__ii=? "
            java.lang.String[] r9 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7e
            r12 = 0
            r13 = 0
            r7 = 0
            r10 = 0
            r11 = 0
            r4 = r14
            r6 = r2
            android.database.Cursor r4 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7e
            if (r4 == 0) goto L66
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            if (r5 == 0) goto L66
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r5.<init>()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r3 = r5
            goto L66
        L5c:
        L5d:
            r3 = r4
            goto L87
        L5f:
            r3 = r4
            goto L9c
        L61:
            r5 = r3
            goto L5d
        L64:
            r5 = r3
            goto L5f
        L66:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            if (r4 == 0) goto L6e
            r4.close()
        L6e:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L71
        L71:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto La9
        L7b:
            r5 = r3
            goto L87
        L7e:
            r5 = r3
            goto L9c
        L80:
            r2 = r3
            r5 = r2
            goto L87
        L84:
            r2 = r3
            r5 = r2
            goto L9c
        L87:
            if (r3 == 0) goto L8c
            r3.close()
        L8c:
            if (r2 == 0) goto L91
        L8e:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L91
        L91:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            r3 = r5
            goto La9
        L9c:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> Laa
            com.umeng.analytics.pro.j.a(r0)     // Catch: java.lang.Throwable -> Laa
            if (r3 == 0) goto La6
            r3.close()
        La6:
            if (r2 == 0) goto L91
            goto L8e
        La9:
            return r3
        Laa:
            r0 = move-exception
            if (r3 == 0) goto Lb0
            r3.close()
        Lb0:
            if (r2 == 0) goto Lb5
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb5
        Lb5:
            android.content.Context r1 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)
            r1.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.g():org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        if (r0 == null) goto L80;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.util.List<java.lang.Integer> r1 = r4.f24003j     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            if (r1 <= 0) goto L3e
            r1 = 0
        L17:
            java.util.List<java.lang.Integer> r2 = r4.f24003j     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            if (r1 >= r2) goto L3e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r2.<init>()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.lang.String r3 = "delete from __et where rowid="
            r2.append(r3)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.util.List<java.lang.Integer> r3 = r4.f24003j     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r2.append(r3)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            int r1 = r1 + 1
            goto L17
        L3c:
            goto L53
        L3e:
            java.util.List<java.lang.Integer> r1 = r4.f24003j     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r1.clear()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteDatabaseCorruptException -> L56
        L46:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L49
        L49:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L5e
        L53:
            if (r0 == 0) goto L49
            goto L46
        L56:
            android.content.Context r1 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L5f
            com.umeng.analytics.pro.j.a(r1)     // Catch: java.lang.Throwable -> L5f
            if (r0 == 0) goto L49
            goto L46
        L5e:
            return
        L5f:
            r1 = move-exception
            if (r0 == 0) goto L65
            r0.endTransaction()     // Catch: java.lang.Throwable -> L65
        L65:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.h():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        if (r0 == null) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i() {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L27
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L27
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L27
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L27
            java.lang.String r1 = "delete from __er"
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L27
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L27
        L16:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L19
        L19:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L2f
        L23:
            if (r0 == 0) goto L19
            goto L16
        L27:
            android.content.Context r1 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L30
            com.umeng.analytics.pro.j.a(r1)     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L19
            goto L16
        L2f:
            return
        L30:
            r1 = move-exception
            if (r0 == 0) goto L36
            r0.endTransaction()     // Catch: java.lang.Throwable -> L36
        L36:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.i():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
    
        if (r1 == null) goto L79;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j() {
        /*
            r5 = this;
            java.lang.String r0 = "\""
            java.lang.String r1 = r5.f24004k
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            if (r1 != 0) goto L7c
            android.content.Context r1 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r3.<init>()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r4 = "delete from __er where __i=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r4 = r5.f24004k     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r3.append(r4)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r3.append(r0)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r1.execSQL(r3)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r3.<init>()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r4 = "delete from __et where __i=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r4 = r5.f24004k     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r3.append(r4)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r3.append(r0)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r1.execSQL(r0)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteDatabaseCorruptException -> L64
        L4d:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L50
        L50:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L7c
        L5a:
            goto L61
        L5c:
            r1 = r2
            goto L61
        L5f:
            r1 = r2
            goto L64
        L61:
            if (r1 == 0) goto L50
            goto L4d
        L64:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L6c
            com.umeng.analytics.pro.j.a(r0)     // Catch: java.lang.Throwable -> L6c
            if (r1 == 0) goto L50
            goto L4d
        L6c:
            r0 = move-exception
            if (r1 == 0) goto L72
            r1.endTransaction()     // Catch: java.lang.Throwable -> L72
        L72:
            android.content.Context r1 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)
            r1.b()
            throw r0
        L7c:
            r5.f24004k = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.j():void");
    }

    private k() {
        this.f24002i = new ArrayList();
        this.f24003j = new ArrayList();
        this.f24004k = null;
        this.f24005l = new ArrayList();
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String c10 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(longValue));
            contentValues.put("__sp", c10);
            contentValues.put("__pp", str2);
            contentValues.put("__av", UMGlobalContext.getInstance(f23997d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(f23997d));
            sQLiteDatabase.insert(g.c.f23948a, null, contentValues);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(java.lang.String r20, org.json.JSONObject r21, android.database.sqlite.SQLiteDatabase r22) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.c(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase):void");
    }

    private Cursor a(String str, SQLiteDatabase sQLiteDatabase, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            if (sQLiteDatabase.isOpen()) {
                return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a() {
        this.f24002i.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a4, code lost:
    
        if (r2 == null) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a6, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00af, code lost:
    
        if (r2 == null) goto L129;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(org.json.JSONArray r11) {
        /*
            r10 = this;
            java.lang.String r0 = "__t"
            java.lang.String r1 = "__i"
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> La3 android.database.sqlite.SQLiteDatabaseCorruptException -> Laa
            com.umeng.analytics.pro.i r3 = com.umeng.analytics.pro.i.a(r3)     // Catch: java.lang.Throwable -> La3 android.database.sqlite.SQLiteDatabaseCorruptException -> Laa
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> La3 android.database.sqlite.SQLiteDatabaseCorruptException -> Laa
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            r4 = 0
        L13:
            int r5 = r11.length()     // Catch: java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            if (r4 >= r5) goto L91
            org.json.JSONObject r5 = r11.getJSONObject(r4)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            r6.<init>()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r7 = r5.optString(r1)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r9 = "-1"
            if (r8 != 0) goto L38
            boolean r8 = r9.equals(r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            if (r8 == 0) goto L47
            goto L38
        L35:
            r2 = r3
            goto La4
        L38:
            com.umeng.analytics.pro.w r7 = com.umeng.analytics.pro.w.a()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r7 = r7.b()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            if (r8 == 0) goto L47
            r7 = r9
        L47:
            r6.put(r1, r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r7 = "__e"
            java.lang.String r8 = "id"
            java.lang.String r8 = r5.optString(r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            r6.put(r7, r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            int r7 = r5.optInt(r0)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            r6.put(r0, r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            r6.put(r7, r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            r6.put(r7, r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            r5.remove(r1)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            r5.remove(r0)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r7 = "__s"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r5 = r10.c(r5)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            r6.put(r7, r5)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
            java.lang.String r5 = "__et"
            r3.insert(r5, r2, r6)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8e
        L8e:
            int r4 = r4 + 1
            goto L13
        L91:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            r3.endTransaction()     // Catch: java.lang.Throwable -> L97
        L97:
            android.content.Context r11 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r11 = com.umeng.analytics.pro.i.a(r11)
            r11.b()
            goto Lb2
        La1:
            r2 = r3
            goto Laa
        La3:
        La4:
            if (r2 == 0) goto L97
        La6:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L97
            goto L97
        Laa:
            android.content.Context r11 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> Lb3
            com.umeng.analytics.pro.j.a(r11)     // Catch: java.lang.Throwable -> Lb3
            if (r2 == 0) goto L97
            goto La6
        Lb2:
            return
        Lb3:
            r11 = move-exception
            if (r2 == 0) goto Lb9
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb9
        Lb9:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(org.json.JSONArray):void");
    }

    public JSONObject b(boolean z10) {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z10);
        return jSONObject;
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(f23998e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f23998e.getBytes()));
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                    return str;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a0, code lost:
    
        if (r1 != null) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0091, code lost:
    
        if (r1 != null) goto L174;
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00a9: IF  (r1 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:51:0x00ae, block:B:50:0x00a9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(org.json.JSONObject r13, java.lang.String r14) {
        /*
            r12 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            boolean r2 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            if (r2 != 0) goto L29
            java.lang.String r3 = "__er"
            java.lang.String r6 = "__i=? "
            java.lang.String[] r7 = new java.lang.String[]{r14}     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            r10 = 0
            r11 = 0
            r5 = 0
            r8 = 0
            r9 = 0
            r2 = r12
            r4 = r1
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
        L27:
            r0 = r14
            goto L39
        L29:
            java.lang.String r3 = "__er"
            r10 = 0
            r11 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r12
            r4 = r1
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            goto L27
        L39:
            if (r0 == 0) goto L6e
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            r14.<init>()     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
        L40:
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            if (r2 == 0) goto L63
            java.lang.String r2 = "__a"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            if (r3 != 0) goto L40
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            java.lang.String r2 = r12.d(r2)     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            r14.put(r3)     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            goto L40
        L63:
            int r2 = r14.length()     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            if (r2 <= 0) goto L6e
            java.lang.String r2 = "error"
            r13.put(r2, r14)     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
        L6e:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            if (r0 == 0) goto L76
            r0.close()
        L76:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L79
        L79:
            android.content.Context r13 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r13 = com.umeng.analytics.pro.i.a(r13)
            r13.b()
            goto La3
        L83:
            r1 = r0
            goto L87
        L85:
            r1 = r0
            goto L96
        L87:
            android.content.Context r13 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L94
            com.umeng.analytics.pro.j.a(r13)     // Catch: java.lang.Throwable -> L94
            if (r0 == 0) goto L91
            r0.close()
        L91:
            if (r1 == 0) goto L79
            goto L76
        L94:
            r13 = move-exception
            goto La4
        L96:
            android.content.Context r13 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L94
            com.umeng.analytics.pro.j.a(r13)     // Catch: java.lang.Throwable -> L94
            if (r0 == 0) goto La0
            r0.close()
        La0:
            if (r1 == 0) goto L79
            goto L76
        La3:
            return
        La4:
            if (r0 == 0) goto La9
            r0.close()
        La9:
            if (r1 == 0) goto Lae
            r1.endTransaction()     // Catch: java.lang.Throwable -> Lae
        Lae:
            android.content.Context r14 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r14 = com.umeng.analytics.pro.i.a(r14)
            r14.b()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.b(org.json.JSONObject, java.lang.String):void");
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(f23998e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f23998e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        if (r0 == null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0064, code lost:
    
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
    
        if (r0 == null) goto L89;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L68
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L68
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L68
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            r2.<init>()     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            java.lang.String r3 = "__i"
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            java.lang.String r5 = r4.c(r6)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            if (r6 != 0) goto L51
            java.lang.String r6 = "__a"
            r2.put(r6, r5)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            java.lang.String r5 = "__t"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            java.lang.String r5 = "__av"
            android.content.Context r6 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r6)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            java.lang.String r5 = "__vc"
            android.content.Context r6 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r6)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            java.lang.String r5 = "__er"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            goto L51
        L4c:
            r0 = r1
            goto L62
        L4f:
            r0 = r1
            goto L68
        L51:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4f
            r1.endTransaction()     // Catch: java.lang.Throwable -> L57
        L57:
            android.content.Context r5 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r5 = com.umeng.analytics.pro.i.a(r5)
            r5.b()
            goto L70
        L61:
        L62:
            if (r0 == 0) goto L57
        L64:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L57
            goto L57
        L68:
            android.content.Context r5 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L72
            com.umeng.analytics.pro.j.a(r5)     // Catch: java.lang.Throwable -> L72
            if (r0 == 0) goto L57
            goto L64
        L70:
            r5 = 0
            return r5
        L72:
            r5 = move-exception
            if (r0 == 0) goto L78
            r0.endTransaction()     // Catch: java.lang.Throwable -> L78
        L78:
            android.content.Context r6 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r6 = com.umeng.analytics.pro.i.a(r6)
            r6.b()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(java.lang.String, java.lang.String, int):boolean");
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            if (optJSONObject != null && optJSONObject.optLong("duration") > 0) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00f8, code lost:
    
        if (r1 != null) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00de, code lost:
    
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00dc, code lost:
    
        if (r1 != null) goto L214;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(org.json.JSONObject r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.b(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x009b, code lost:
    
        if (r2 == null) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0092, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0090, code lost:
    
        if (r2 == null) goto L141;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r7, org.json.JSONObject r8, com.umeng.analytics.pro.k.a r9) {
        /*
            r6 = this;
            java.lang.String r0 = "__e"
            r1 = 0
            if (r8 != 0) goto L6
            return r1
        L6:
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L8f android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            com.umeng.analytics.pro.i r3 = com.umeng.analytics.pro.i.a(r3)     // Catch: java.lang.Throwable -> L8f android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L8f android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            com.umeng.analytics.pro.k$a r4 = com.umeng.analytics.pro.k.a.BEGIN     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            if (r9 != r4) goto L54
            java.lang.Object r8 = r8.opt(r0)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.Long r8 = (java.lang.Long) r8     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            long r8 = r8.longValue()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            r4.<init>()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.String r5 = "__ii"
            r4.put(r5, r7)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.String r7 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            r4.put(r0, r7)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.String r7 = "__sd"
            r3.insert(r7, r2, r4)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            goto L7f
        L4f:
            r2 = r3
            goto L90
        L52:
            r2 = r3
            goto L96
        L54:
            com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.INSTANTSESSIONBEGIN     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            if (r9 != r0) goto L5c
            r6.b(r7, r8, r3)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            goto L7f
        L5c:
            com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.END     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            if (r9 != r0) goto L64
            r6.a(r7, r8, r3)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            goto L7f
        L64:
            com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.PAGE     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            if (r9 != r0) goto L6e
            java.lang.String r9 = "__a"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            goto L7f
        L6e:
            com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.AUTOPAGE     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            if (r9 != r0) goto L78
            java.lang.String r9 = "__b"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            goto L7f
        L78:
            com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.NEWSESSION     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            if (r9 != r0) goto L7f
            r6.c(r7, r8, r3)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
        L7f:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            r3.endTransaction()     // Catch: java.lang.Throwable -> L85
        L85:
            android.content.Context r7 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r7 = com.umeng.analytics.pro.i.a(r7)
            r7.b()
            goto L9e
        L8f:
        L90:
            if (r2 == 0) goto L85
        L92:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L85
            goto L85
        L96:
            android.content.Context r7 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L9f
            com.umeng.analytics.pro.j.a(r7)     // Catch: java.lang.Throwable -> L9f
            if (r2 == 0) goto L85
            goto L92
        L9e:
            return r1
        L9f:
            r7 = move-exception
            if (r2 == 0) goto La5
            r2.endTransaction()     // Catch: java.lang.Throwable -> La5
        La5:
            android.content.Context r8 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r8 = com.umeng.analytics.pro.i.a(r8)
            r8.b()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(java.lang.String, org.json.JSONObject, com.umeng.analytics.pro.k$a):boolean");
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        String str2;
        try {
            long longValue = ((Long) jSONObject.opt(g.d.a.f23968g)).longValue();
            Object opt = jSONObject.opt(g.d.a.f23969h);
            long longValue2 = (opt == null || !(opt instanceof Long)) ? 0L : ((Long) opt).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str3 = "";
            if (optJSONObject == null || optJSONObject.length() <= 0) {
                str2 = "";
            } else {
                str2 = c(optJSONObject.toString());
            }
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str3 = c(optJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + longValue + "\", " + g.d.a.f23969h + "=\"" + longValue2 + "\", __sp=\"" + str2 + "\", __pp=\"" + str3 + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        if (r0 == null) goto L92;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(boolean r3, boolean r4) {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            if (r4 == 0) goto L1a
            if (r3 == 0) goto L4f
            java.lang.String r3 = "delete from __sd"
            r0.execSQL(r3)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            goto L4f
        L18:
            goto L5f
        L1a:
            java.util.List<java.lang.String> r3 = r2.f24002i     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            if (r3 <= 0) goto L4f
            r3 = 0
        L23:
            java.util.List<java.lang.String> r4 = r2.f24002i     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            if (r3 >= r4) goto L4f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            r4.<init>()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r1 = "delete from __sd where __ii=\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.util.List<java.lang.String> r1 = r2.f24002i     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            r4.append(r1)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r1 = "\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            int r3 = r3 + 1
            goto L23
        L4f:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
        L52:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L55
        L55:
            android.content.Context r3 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r3 = com.umeng.analytics.pro.i.a(r3)
            r3.b()
            goto L6a
        L5f:
            if (r0 == 0) goto L55
            goto L52
        L62:
            android.content.Context r3 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L6b
            com.umeng.analytics.pro.j.a(r3)     // Catch: java.lang.Throwable -> L6b
            if (r0 == 0) goto L55
            goto L52
        L6a:
            return
        L6b:
            r3 = move-exception
            if (r0 == 0) goto L71
            r0.endTransaction()     // Catch: java.lang.Throwable -> L71
        L71:
            android.content.Context r4 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r4 = com.umeng.analytics.pro.i.a(r4)
            r4.b()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.b(boolean, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
    
        if (r4 != null) goto L89;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(java.lang.String r16) {
        /*
            r15 = this;
            java.lang.String r0 = "__f"
            r1 = 0
            r2 = 0
            android.content.Context r4 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            com.umeng.analytics.pro.i r4 = com.umeng.analytics.pro.i.a(r4)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            android.database.sqlite.SQLiteDatabase r4 = r4.a()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            r4.beginTransaction()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            java.lang.String[] r8 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            java.lang.String r6 = "__sd"
            java.lang.String r9 = "__ii=? "
            java.lang.String[] r10 = new java.lang.String[]{r16}     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            r13 = 0
            r14 = 0
            r11 = 0
            r12 = 0
            r5 = r15
            r7 = r4
            android.database.Cursor r1 = r5.a(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            if (r1 == 0) goto L3a
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            long r2 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            goto L3a
        L36:
            r0 = move-exception
            goto L52
        L38:
            goto L66
        L3a:
            if (r1 == 0) goto L3f
            r1.close()     // Catch: java.lang.Exception -> L42
        L3f:
            r4.endTransaction()     // Catch: java.lang.Exception -> L42
        L42:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L6e
        L4c:
            r0 = move-exception
            r4 = r1
            goto L52
        L4f:
            r4 = r1
            goto L66
        L52:
            if (r1 == 0) goto L57
            r1.close()     // Catch: java.lang.Exception -> L5c
        L57:
            if (r4 == 0) goto L5c
            r4.endTransaction()     // Catch: java.lang.Exception -> L5c
        L5c:
            android.content.Context r1 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)
            r1.b()
            throw r0
        L66:
            if (r1 == 0) goto L6b
            r1.close()     // Catch: java.lang.Exception -> L42
        L6b:
            if (r4 == 0) goto L42
            goto L3f
        L6e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(java.lang.String):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
    
        if (r0 == null) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            if (r1 != 0) goto L30
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            r1.<init>()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            java.lang.String r2 = "delete from __is where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            r1.append(r4)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            java.lang.String r4 = "\""
            r1.append(r4)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
            goto L30
        L2e:
            goto L40
        L30:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteDatabaseCorruptException -> L43
        L33:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L36
        L36:
            android.content.Context r4 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r4 = com.umeng.analytics.pro.i.a(r4)
            r4.b()
            goto L4b
        L40:
            if (r0 == 0) goto L36
            goto L33
        L43:
            android.content.Context r4 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L4c
            com.umeng.analytics.pro.j.a(r4)     // Catch: java.lang.Throwable -> L4c
            if (r0 == 0) goto L36
            goto L33
        L4b:
            return
        L4c:
            r4 = move-exception
            if (r0 == 0) goto L52
            r0.endTransaction()     // Catch: java.lang.Throwable -> L52
        L52:
            android.content.Context r0 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.b(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0074 A[Catch: all -> 0x0065, TryCatch #1 {all -> 0x0065, blocks: (B:52:0x0052, B:54:0x0058, B:15:0x0069, B:17:0x0074, B:18:0x0079, B:26:0x0088, B:29:0x008e, B:31:0x0094, B:38:0x009a, B:40:0x00a8, B:33:0x0097), top: B:51:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0052 A[EXC_TOP_SPLITTER, LOOP:1: B:51:0x0052->B:54:0x0058, LOOP_START, PHI: r13
  0x0052: PHI (r13v2 java.lang.String) = (r13v7 java.lang.String), (r13v3 java.lang.String) binds: [B:14:0x0050, B:54:0x0058] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @android.annotation.SuppressLint({"Range"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r16, org.json.JSONObject r17, android.database.sqlite.SQLiteDatabase r18, java.lang.String r19) throws org.json.JSONException {
        /*
            r15 = this;
            r10 = r15
            r0 = r17
            r11 = r19
            java.lang.String r12 = "=\""
            java.lang.String r1 = "__b"
            java.lang.String r2 = "__a"
            r13 = 0
            boolean r3 = r2.equals(r11)     // Catch: java.lang.Throwable -> L21
            if (r3 == 0) goto L25
            org.json.JSONArray r0 = r0.optJSONArray(r2)     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto L24
            int r1 = r0.length()     // Catch: java.lang.Throwable -> L21
            if (r1 > 0) goto L1f
            goto L24
        L1f:
            r14 = r0
            goto L39
        L21:
            goto Le1
        L24:
            return
        L25:
            boolean r2 = r1.equals(r11)     // Catch: java.lang.Throwable -> L21
            if (r2 == 0) goto L38
            org.json.JSONArray r0 = r0.optJSONArray(r1)     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto L37
            int r1 = r0.length()     // Catch: java.lang.Throwable -> L21
            if (r1 > 0) goto L1f
        L37:
            return
        L38:
            r14 = r13
        L39:
            java.lang.String[] r3 = new java.lang.String[]{r19}     // Catch: java.lang.Throwable -> L21
            java.lang.String r1 = "__sd"
            java.lang.String r4 = "__ii=? "
            java.lang.String[] r5 = new java.lang.String[]{r16}     // Catch: java.lang.Throwable -> L21
            r8 = 0
            r9 = 0
            r6 = 0
            r7 = 0
            r0 = r15
            r2 = r18
            android.database.Cursor r0 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto L69
        L52:
            boolean r1 = r0.moveToNext()     // Catch: java.lang.Throwable -> L65
            if (r1 == 0) goto L69
            int r1 = r0.getColumnIndex(r11)     // Catch: java.lang.Throwable -> L65
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Throwable -> L65
            java.lang.String r13 = r15.d(r1)     // Catch: java.lang.Throwable -> L65
            goto L52
        L65:
            r13 = r0
            goto Le1
        L69:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L65
            r1.<init>()     // Catch: java.lang.Throwable -> L65
            boolean r2 = android.text.TextUtils.isEmpty(r13)     // Catch: java.lang.Throwable -> L65
            if (r2 != 0) goto L79
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L65
            r1.<init>(r13)     // Catch: java.lang.Throwable -> L65
        L79:
            int r2 = r1.length()     // Catch: java.lang.Throwable -> L65
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 <= r3) goto L87
            if (r0 == 0) goto L86
            r0.close()
        L86:
            return
        L87:
            r2 = 0
        L88:
            int r3 = r14.length()     // Catch: java.lang.Throwable -> L65
            if (r2 >= r3) goto L9a
            org.json.JSONObject r3 = r14.getJSONObject(r2)     // Catch: java.lang.Throwable -> L65 org.json.JSONException -> L97
            if (r3 == 0) goto L97
            r1.put(r3)     // Catch: java.lang.Throwable -> L65
        L97:
            int r2 = r2 + 1
            goto L88
        L9a:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L65
            java.lang.String r1 = r15.c(r1)     // Catch: java.lang.Throwable -> L65
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L65
            if (r2 != 0) goto Ldb
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65
            r2.<init>()     // Catch: java.lang.Throwable -> L65
            java.lang.String r3 = "update __sd set "
            r2.append(r3)     // Catch: java.lang.Throwable -> L65
            r2.append(r11)     // Catch: java.lang.Throwable -> L65
            r2.append(r12)     // Catch: java.lang.Throwable -> L65
            r2.append(r1)     // Catch: java.lang.Throwable -> L65
            java.lang.String r1 = "\" where "
            r2.append(r1)     // Catch: java.lang.Throwable -> L65
            java.lang.String r1 = "__ii"
            r2.append(r1)     // Catch: java.lang.Throwable -> L65
            r2.append(r12)     // Catch: java.lang.Throwable -> L65
            r1 = r16
            r2.append(r1)     // Catch: java.lang.Throwable -> L65
            java.lang.String r1 = "\""
            r2.append(r1)     // Catch: java.lang.Throwable -> L65
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L65
            r2 = r18
            r2.execSQL(r1)     // Catch: java.lang.Throwable -> L65
        Ldb:
            if (r0 == 0) goto Le6
            r0.close()
            goto Le6
        Le1:
            if (r13 == 0) goto Le6
            r13.close()
        Le6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase, java.lang.String):void");
    }

    public JSONObject a(boolean z10) {
        a();
        this.f24003j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z10) {
            a(jSONObject, z10);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
        } else {
            String a10 = a(jSONObject, z10);
            if (!TextUtils.isEmpty(a10)) {
                b(jSONObject, a10);
                a(jSONObject, a10);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x019e, code lost:
    
        if (r1 != null) goto L342;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x018f, code lost:
    
        if (r1 != null) goto L342;
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x01a7: IF  (r1 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:114:0x01ac, block:B:113:0x01a7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(org.json.JSONObject r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(org.json.JSONObject, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x023e, code lost:
    
        if (r12 == null) goto L372;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x022f, code lost:
    
        if (r12 == null) goto L372;
     */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0247: IF  (r12 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:131:0x024c, block:B:130:0x0247 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0242: IF  (r14 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:130:0x0247, block:B:128:0x0242 */
    /* JADX WARN: Removed duplicated region for block: B:22:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x022c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(org.json.JSONObject r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 598
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0072, code lost:
    
        if (r0 == null) goto L110;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r6, boolean r7) {
        /*
            r5 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            if (r7 == 0) goto L18
            if (r6 == 0) goto L53
            java.lang.String r6 = "delete from __is"
            r0.execSQL(r6)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            goto L53
        L18:
            java.util.List<java.lang.String> r6 = r5.f24005l     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            r7 = 0
            if (r6 <= 0) goto L4c
            r1 = 0
        L22:
            if (r7 >= r6) goto L4b
            java.util.List<java.lang.String> r2 = r5.f24005l     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            java.lang.Object r2 = r2.get(r7)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            if (r2 != 0) goto L2f
            r1 = 1
        L2f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            r3.<init>()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            java.lang.String r4 = "delete from __is where __ii=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            r3.append(r2)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            java.lang.String r2 = "\""
            r3.append(r2)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
            int r7 = r7 + 1
            goto L22
        L4b:
            r7 = r1
        L4c:
            if (r7 == 0) goto L53
            java.lang.String r6 = "delete from __is where __ii is null"
            r0.execSQL(r6)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
        L53:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteDatabaseCorruptException -> L6d
        L56:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L59
        L59:
            android.content.Context r6 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r6 = com.umeng.analytics.pro.i.a(r6)
            r6.b()
            goto L75
        L63:
            android.content.Context r6 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L6b
            com.umeng.analytics.pro.j.a(r6)     // Catch: java.lang.Throwable -> L6b
            if (r0 == 0) goto L59
            goto L56
        L6b:
            r6 = move-exception
            goto L76
        L6d:
            android.content.Context r6 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L6b
            com.umeng.analytics.pro.j.a(r6)     // Catch: java.lang.Throwable -> L6b
            if (r0 == 0) goto L59
            goto L56
        L75:
            return
        L76:
            if (r0 == 0) goto L7b
            r0.endTransaction()     // Catch: java.lang.Throwable -> L7b
        L7b:
            android.content.Context r7 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r7 = com.umeng.analytics.pro.i.a(r7)
            r7.b()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(boolean, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x007b, code lost:
    
        if (r0 == null) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r4 = "\""
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            if (r1 != 0) goto L63
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.<init>()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r2 = "delete from __er where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.append(r5)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.append(r4)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.<init>()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r2 = "delete from __et where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.append(r5)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.append(r4)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.util.List<java.lang.Integer> r1 = r3.f24003j     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.clear()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.<init>()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r2 = "delete from __sd where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.append(r5)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r1.append(r4)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            goto L63
        L61:
            goto L73
        L63:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
        L66:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L69
        L69:
            android.content.Context r4 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r4 = com.umeng.analytics.pro.i.a(r4)
            r4.b()
            goto L7e
        L73:
            if (r0 == 0) goto L69
            goto L66
        L76:
            android.content.Context r4 = com.umeng.analytics.pro.k.f23997d     // Catch: java.lang.Throwable -> L7f
            com.umeng.analytics.pro.j.a(r4)     // Catch: java.lang.Throwable -> L7f
            if (r0 == 0) goto L69
            goto L66
        L7e:
            return
        L7f:
            r4 = move-exception
            if (r0 == 0) goto L85
            r0.endTransaction()     // Catch: java.lang.Throwable -> L85
        L85:
            android.content.Context r5 = com.umeng.analytics.pro.k.f23997d
            com.umeng.analytics.pro.i r5 = com.umeng.analytics.pro.i.a(r5)
            r5.b()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(boolean, java.lang.String):void");
    }
}
