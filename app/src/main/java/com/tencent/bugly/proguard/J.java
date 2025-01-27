package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.umeng.analytics.pro.bx;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class J {

    /* renamed from: a */
    private static J f22603a = null;

    /* renamed from: b */
    private static K f22604b = null;

    /* renamed from: c */
    public static boolean f22605c = false;

    private J(Context context, List<com.tencent.bugly.a> list) {
        f22604b = new K(context, list);
    }

    private synchronized boolean d(L l10) {
        SQLiteDatabase sQLiteDatabase;
        if (l10 == null) {
            return false;
        }
        try {
            sQLiteDatabase = f22604b.getWritableDatabase();
            if (sQLiteDatabase != null) {
                try {
                    ContentValues b10 = b(l10);
                    if (b10 != null) {
                        long replace = sQLiteDatabase.replace("t_pf", "_id", b10);
                        if (replace < 0) {
                            if (f22605c) {
                                sQLiteDatabase.close();
                            }
                            return false;
                        }
                        X.a("[Database] insert %s success.", "t_pf");
                        l10.f22628a = replace;
                        if (f22605c) {
                            sQLiteDatabase.close();
                        }
                        return true;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!X.b(th)) {
                            th.printStackTrace();
                        }
                        if (f22605c && sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return false;
                    } finally {
                        if (f22605c && sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        if (com.tencent.bugly.proguard.J.f22605c != false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0052, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        if (com.tencent.bugly.proguard.J.f22605c == false) goto L126;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void b(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.tencent.bugly.proguard.K r0 = com.tencent.bugly.proguard.J.f22604b     // Catch: java.lang.Throwable -> L20
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L5e
            r1 = 0
            if (r6 < 0) goto L22
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1e
            r2.<init>()     // Catch: java.lang.Throwable -> L1e
            java.lang.String r3 = "_tp = "
            r2.append(r3)     // Catch: java.lang.Throwable -> L1e
            r2.append(r6)     // Catch: java.lang.Throwable -> L1e
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L1e
            goto L23
        L1e:
            r6 = move-exception
            goto L42
        L20:
            r6 = move-exception
            goto L60
        L22:
            r6 = r1
        L23:
            java.lang.String r2 = "t_lr"
            int r6 = r0.delete(r2, r6, r1)     // Catch: java.lang.Throwable -> L1e
            java.lang.String r1 = "[Database] deleted %s data %d"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L1e
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L1e
            java.lang.String r3 = "t_lr"
            r4 = 0
            r2[r4] = r3     // Catch: java.lang.Throwable -> L1e
            r3 = 1
            r2[r3] = r6     // Catch: java.lang.Throwable -> L1e
            com.tencent.bugly.proguard.X.a(r1, r2)     // Catch: java.lang.Throwable -> L1e
            boolean r6 = com.tencent.bugly.proguard.J.f22605c     // Catch: java.lang.Throwable -> L20
            if (r6 == 0) goto L5e
            goto L52
        L42:
            boolean r1 = com.tencent.bugly.proguard.X.b(r6)     // Catch: java.lang.Throwable -> L4c
            if (r1 != 0) goto L4e
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L4c
            goto L4e
        L4c:
            r6 = move-exception
            goto L56
        L4e:
            boolean r6 = com.tencent.bugly.proguard.J.f22605c     // Catch: java.lang.Throwable -> L20
            if (r6 == 0) goto L5e
        L52:
            r0.close()     // Catch: java.lang.Throwable -> L20
            goto L5e
        L56:
            boolean r1 = com.tencent.bugly.proguard.J.f22605c     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L5d
            r0.close()     // Catch: java.lang.Throwable -> L20
        L5d:
            throw r6     // Catch: java.lang.Throwable -> L20
        L5e:
            monitor-exit(r5)
            return
        L60:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L20
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.J.b(int):void");
    }

    public synchronized boolean c(L l10) {
        SQLiteDatabase sQLiteDatabase;
        if (l10 == null) {
            return false;
        }
        try {
            sQLiteDatabase = f22604b.getWritableDatabase();
            if (sQLiteDatabase != null) {
                try {
                    ContentValues a10 = a(l10);
                    if (a10 != null) {
                        long replace = sQLiteDatabase.replace("t_lr", "_id", a10);
                        if (replace < 0) {
                            if (f22605c) {
                                sQLiteDatabase.close();
                            }
                            return false;
                        }
                        X.a("[Database] insert %s success.", "t_lr");
                        l10.f22628a = replace;
                        if (f22605c) {
                            sQLiteDatabase.close();
                        }
                        return true;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!X.b(th)) {
                            th.printStackTrace();
                        }
                        if (f22605c && sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return false;
                    } finally {
                        if (f22605c && sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
    }

    public class a extends Thread {

        /* renamed from: a */
        private int f22606a;

        /* renamed from: b */
        private I f22607b;

        /* renamed from: c */
        private String f22608c;

        /* renamed from: d */
        private ContentValues f22609d;

        /* renamed from: e */
        private boolean f22610e;

        /* renamed from: f */
        private String[] f22611f;

        /* renamed from: g */
        private String f22612g;

        /* renamed from: h */
        private String[] f22613h;

        /* renamed from: i */
        private String f22614i;

        /* renamed from: j */
        private String f22615j;

        /* renamed from: k */
        private String f22616k;

        /* renamed from: l */
        private String f22617l;

        /* renamed from: m */
        private String f22618m;

        /* renamed from: n */
        private String[] f22619n;

        /* renamed from: o */
        private int f22620o;

        /* renamed from: p */
        private String f22621p;

        /* renamed from: q */
        private byte[] f22622q;

        public a(int i10, I i11) {
            this.f22606a = i10;
            this.f22607b = i11;
        }

        public void a(String str, ContentValues contentValues) {
            this.f22608c = str;
            this.f22609d = contentValues;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            switch (this.f22606a) {
                case 1:
                    J.this.a(this.f22608c, this.f22609d, this.f22607b);
                    break;
                case 2:
                    J.this.a(this.f22608c, this.f22618m, this.f22619n, this.f22607b);
                    break;
                case 3:
                    Cursor a10 = J.this.a(this.f22610e, this.f22608c, this.f22611f, this.f22612g, this.f22613h, this.f22614i, this.f22615j, this.f22616k, this.f22617l, this.f22607b);
                    if (a10 != null) {
                        a10.close();
                        break;
                    }
                    break;
                case 4:
                    J.this.a(this.f22620o, this.f22621p, this.f22622q, this.f22607b);
                    break;
                case 5:
                    J.this.a(this.f22620o, this.f22607b);
                    break;
                case 6:
                    J.this.a(this.f22620o, this.f22621p, this.f22607b);
                    break;
            }
        }

        public void a(boolean z10, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f22610e = z10;
            this.f22608c = str;
            this.f22611f = strArr;
            this.f22612g = str2;
            this.f22613h = strArr2;
            this.f22614i = str3;
            this.f22615j = str4;
            this.f22616k = str5;
            this.f22617l = str6;
        }

        public void a(String str, String str2, String[] strArr) {
            this.f22608c = str;
            this.f22618m = str2;
            this.f22619n = strArr;
        }

        public void a(int i10, String str, byte[] bArr) {
            this.f22620o = i10;
            this.f22621p = str;
            this.f22622q = bArr;
        }

        public void a(int i10) {
            this.f22620o = i10;
        }
    }

    public static synchronized J a(Context context, List<com.tencent.bugly.a> list) {
        J j10;
        synchronized (J.class) {
            try {
                if (f22603a == null) {
                    f22603a = new J(context, list);
                }
                j10 = f22603a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return j10;
    }

    public static synchronized J a() {
        J j10;
        synchronized (J.class) {
            j10 = f22603a;
        }
        return j10;
    }

    public long a(String str, ContentValues contentValues, I i10, boolean z10) {
        if (!z10) {
            a aVar = new a(1, i10);
            aVar.a(str, contentValues);
            W.c().a(aVar);
            return 0L;
        }
        return a(str, contentValues, i10);
    }

    public ContentValues b(L l10) {
        if (l10 != null && !ca.b(l10.f22633f)) {
            try {
                ContentValues contentValues = new ContentValues();
                long j10 = l10.f22628a;
                if (j10 > 0) {
                    contentValues.put("_id", Long.valueOf(j10));
                }
                contentValues.put(bx.f23687e, l10.f22633f);
                contentValues.put("_tm", Long.valueOf(l10.f22632e));
                byte[] bArr = l10.f22634g;
                if (bArr != null) {
                    contentValues.put("_dt", bArr);
                }
                return contentValues;
            } catch (Throwable th2) {
                if (!X.b(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, I i10, boolean z10) {
        return a(false, str, strArr, str2, strArr2, (String) null, (String) null, (String) null, (String) null, i10, z10);
    }

    public Cursor a(boolean z10, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, I i10, boolean z11) {
        if (!z11) {
            a aVar = new a(3, i10);
            aVar.a(z10, str, strArr, str2, strArr2, str3, str4, str5, str6);
            W.c().a(aVar);
            return null;
        }
        return a(z10, str, strArr, str2, strArr2, str3, str4, str5, str6, i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x00e5, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00e3, code lost:
    
        if (r2 != null) goto L300;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00c8, code lost:
    
        if (r2 != null) goto L300;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized java.util.List<com.tencent.bugly.proguard.L> c(int r13) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.J.c(int):java.util.List");
    }

    public int a(String str, String str2, String[] strArr, I i10, boolean z10) {
        if (!z10) {
            a aVar = new a(2, i10);
            aVar.a(str, str2, strArr);
            W.c().a(aVar);
            return 0;
        }
        return a(str, str2, strArr, i10);
    }

    public L b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            L l10 = new L();
            l10.f22628a = cursor.getLong(cursor.getColumnIndex("_id"));
            l10.f22632e = cursor.getLong(cursor.getColumnIndex("_tm"));
            l10.f22633f = cursor.getString(cursor.getColumnIndex(bx.f23687e));
            l10.f22634g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return l10;
        } catch (Throwable th2) {
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
            return null;
        }
    }

    public synchronized long a(String str, ContentValues contentValues, I i10) {
        long j10;
        SQLiteDatabase sQLiteDatabase;
        j10 = 0;
        try {
            sQLiteDatabase = f22604b.getWritableDatabase();
            if (sQLiteDatabase != null && contentValues != null) {
                try {
                    long replace = sQLiteDatabase.replace(str, "_id", contentValues);
                    if (replace >= 0) {
                        X.a("[Database] insert %s success.", str);
                    } else {
                        X.e("[Database] replace %s error.", str);
                    }
                    j10 = replace;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!X.b(th)) {
                            th.printStackTrace();
                        }
                        return j10;
                    } finally {
                        if (i10 != null) {
                            i10.a(0L);
                        }
                        if (f22605c && sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                    }
                }
            }
            if (i10 != null) {
                i10.a(Long.valueOf(j10));
            }
            if (f22605c && sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
        return j10;
    }

    public synchronized Cursor a(boolean z10, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, I i10) {
        Cursor cursor;
        try {
            SQLiteDatabase writableDatabase = f22604b.getWritableDatabase();
            cursor = writableDatabase != null ? writableDatabase.query(z10, str, strArr, str2, strArr2, str3, str4, str5, str6) : null;
        } catch (Throwable th2) {
            try {
                if (!X.b(th2)) {
                    th2.printStackTrace();
                }
                if (i10 != null) {
                    i10.a(null);
                }
            } finally {
                if (i10 != null) {
                    i10.a(null);
                }
            }
        }
        return cursor;
    }

    public synchronized int a(String str, String str2, String[] strArr, I i10) {
        int i11;
        SQLiteDatabase sQLiteDatabase;
        i11 = 0;
        try {
            try {
                sQLiteDatabase = f22604b.getWritableDatabase();
                if (sQLiteDatabase != null) {
                    try {
                        i11 = sQLiteDatabase.delete(str, str2, strArr);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            if (!X.b(th)) {
                                th.printStackTrace();
                            }
                            return i11;
                        } finally {
                            if (i10 != null) {
                                i10.a(0);
                            }
                            if (f22605c && sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                        }
                    }
                }
                if (i10 != null) {
                    i10.a(Integer.valueOf(i11));
                }
                if (f22605c && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabase = null;
            }
        } catch (Throwable th4) {
            throw th4;
        }
        return i11;
    }

    public boolean a(int i10, String str, byte[] bArr, I i11, boolean z10) {
        if (!z10) {
            a aVar = new a(4, i11);
            aVar.a(i10, str, bArr);
            W.c().a(aVar);
            return true;
        }
        return a(i10, str, bArr, i11);
    }

    public Map<String, byte[]> a(int i10, I i11, boolean z10) {
        if (!z10) {
            a aVar = new a(5, i11);
            aVar.a(i10);
            W.c().a(aVar);
            return null;
        }
        return a(i10, i11);
    }

    public boolean a(int i10, String str, byte[] bArr, I i11) {
        Boolean bool = Boolean.FALSE;
        try {
            L l10 = new L();
            l10.f22628a = i10;
            l10.f22633f = str;
            l10.f22632e = System.currentTimeMillis();
            l10.f22634g = bArr;
            boolean d10 = d(l10);
            if (i11 == null) {
                return d10;
            }
            i11.a(Boolean.valueOf(d10));
            return d10;
        } catch (Throwable th2) {
            try {
                if (!X.b(th2)) {
                    th2.printStackTrace();
                }
                return false;
            } finally {
                if (i11 != null) {
                    i11.a(bool);
                }
            }
        }
    }

    public Map<String, byte[]> a(int i10, I i11) {
        HashMap hashMap = null;
        try {
            List<L> c10 = c(i10);
            if (c10 != null) {
                HashMap hashMap2 = new HashMap();
                try {
                    for (L l10 : c10) {
                        byte[] bArr = l10.f22634g;
                        if (bArr != null) {
                            hashMap2.put(l10.f22633f, bArr);
                        }
                    }
                    hashMap = hashMap2;
                } catch (Throwable th2) {
                    th = th2;
                    hashMap = hashMap2;
                    try {
                        if (!X.b(th)) {
                            th.printStackTrace();
                        }
                        return hashMap;
                    } finally {
                        if (i11 != null) {
                            i11.a(hashMap);
                        }
                    }
                }
            }
            if (i11 != null) {
                i11.a(hashMap);
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00c1 A[Catch: all -> 0x00c5, TRY_LEAVE, TryCatch #2 {all -> 0x00c5, blocks: (B:63:0x00bb, B:65:0x00c1), top: B:62:0x00bb, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c9 A[Catch: all -> 0x0023, TRY_ENTER, TryCatch #1 {, blocks: (B:4:0x0002, B:14:0x0037, B:15:0x003a, B:17:0x003e, B:56:0x00ad, B:58:0x00b4, B:68:0x00c9, B:69:0x00cc, B:71:0x00d0, B:74:0x00d6, B:75:0x00d9, B:77:0x00dd, B:78:0x00e0, B:63:0x00bb, B:65:0x00c1), top: B:3:0x0002, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d0 A[Catch: all -> 0x0023, TryCatch #1 {, blocks: (B:4:0x0002, B:14:0x0037, B:15:0x003a, B:17:0x003e, B:56:0x00ad, B:58:0x00b4, B:68:0x00c9, B:69:0x00cc, B:71:0x00d0, B:74:0x00d6, B:75:0x00d9, B:77:0x00dd, B:78:0x00e0, B:63:0x00bb, B:65:0x00c1), top: B:3:0x0002, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<com.tencent.bugly.proguard.L> a(int r12) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.J.a(int):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:
    
        if (com.tencent.bugly.proguard.J.f22605c != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0082, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0080, code lost:
    
        if (com.tencent.bugly.proguard.J.f22605c == false) goto L147;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(java.util.List<com.tencent.bugly.proguard.L> r6) {
        /*
            r5 = this;
            r0 = 0
            monitor-enter(r5)
            if (r6 == 0) goto L92
            int r1 = r6.size()     // Catch: java.lang.Throwable -> L3e
            if (r1 != 0) goto Lc
            goto L92
        Lc:
            com.tencent.bugly.proguard.K r1 = com.tencent.bugly.proguard.J.f22604b     // Catch: java.lang.Throwable -> L3e
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L8e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3e
            r2.<init>()     // Catch: java.lang.Throwable -> L3e
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> L3e
        L1d:
            boolean r3 = r6.hasNext()     // Catch: java.lang.Throwable -> L3e
            if (r3 == 0) goto L40
            java.lang.Object r3 = r6.next()     // Catch: java.lang.Throwable -> L3e
            com.tencent.bugly.proguard.L r3 = (com.tencent.bugly.proguard.L) r3     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = " or "
            r2.append(r4)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = "_id"
            r2.append(r4)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = " = "
            r2.append(r4)     // Catch: java.lang.Throwable -> L3e
            long r3 = r3.f22628a     // Catch: java.lang.Throwable -> L3e
            r2.append(r3)     // Catch: java.lang.Throwable -> L3e
            goto L1d
        L3e:
            r6 = move-exception
            goto L90
        L40:
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L3e
            int r3 = r6.length()     // Catch: java.lang.Throwable -> L3e
            if (r3 <= 0) goto L4f
            r3 = 4
            java.lang.String r6 = r6.substring(r3)     // Catch: java.lang.Throwable -> L3e
        L4f:
            r2.setLength(r0)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r2 = "t_lr"
            r3 = 0
            int r6 = r1.delete(r2, r6, r3)     // Catch: java.lang.Throwable -> L71
            java.lang.String r2 = "[Database] deleted %s data %d"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L71
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L71
            java.lang.String r4 = "t_lr"
            r3[r0] = r4     // Catch: java.lang.Throwable -> L71
            r0 = 1
            r3[r0] = r6     // Catch: java.lang.Throwable -> L71
            com.tencent.bugly.proguard.X.a(r2, r3)     // Catch: java.lang.Throwable -> L71
            boolean r6 = com.tencent.bugly.proguard.J.f22605c     // Catch: java.lang.Throwable -> L3e
            if (r6 == 0) goto L8e
            goto L82
        L71:
            r6 = move-exception
            boolean r0 = com.tencent.bugly.proguard.X.b(r6)     // Catch: java.lang.Throwable -> L7c
            if (r0 != 0) goto L7e
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L7c
            goto L7e
        L7c:
            r6 = move-exception
            goto L86
        L7e:
            boolean r6 = com.tencent.bugly.proguard.J.f22605c     // Catch: java.lang.Throwable -> L3e
            if (r6 == 0) goto L8e
        L82:
            r1.close()     // Catch: java.lang.Throwable -> L3e
            goto L8e
        L86:
            boolean r0 = com.tencent.bugly.proguard.J.f22605c     // Catch: java.lang.Throwable -> L3e
            if (r0 == 0) goto L8d
            r1.close()     // Catch: java.lang.Throwable -> L3e
        L8d:
            throw r6     // Catch: java.lang.Throwable -> L3e
        L8e:
            monitor-exit(r5)
            return
        L90:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L3e
            throw r6
        L92:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.J.a(java.util.List):void");
    }

    public ContentValues a(L l10) {
        if (l10 == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j10 = l10.f22628a;
            if (j10 > 0) {
                contentValues.put("_id", Long.valueOf(j10));
            }
            contentValues.put(bx.f23687e, Integer.valueOf(l10.f22629b));
            contentValues.put("_pc", l10.f22630c);
            contentValues.put("_th", l10.f22631d);
            contentValues.put("_tm", Long.valueOf(l10.f22632e));
            byte[] bArr = l10.f22634g;
            if (bArr != null) {
                contentValues.put("_dt", bArr);
            }
            return contentValues;
        } catch (Throwable th2) {
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
            return null;
        }
    }

    public L a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            L l10 = new L();
            l10.f22628a = cursor.getLong(cursor.getColumnIndex("_id"));
            l10.f22629b = cursor.getInt(cursor.getColumnIndex(bx.f23687e));
            l10.f22630c = cursor.getString(cursor.getColumnIndex("_pc"));
            l10.f22631d = cursor.getString(cursor.getColumnIndex("_th"));
            l10.f22632e = cursor.getLong(cursor.getColumnIndex("_tm"));
            l10.f22634g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return l10;
        } catch (Throwable th2) {
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006b, code lost:
    
        if (r8 > 0) goto L186;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean a(int r8, java.lang.String r9, com.tencent.bugly.proguard.I r10) {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            monitor-enter(r7)
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L28
            r3 = 0
            com.tencent.bugly.proguard.K r4 = com.tencent.bugly.proguard.J.f22604b     // Catch: java.lang.Throwable -> L85
            android.database.sqlite.SQLiteDatabase r4 = r4.getWritableDatabase()     // Catch: java.lang.Throwable -> L85
            if (r4 == 0) goto L6e
            boolean r5 = com.tencent.bugly.proguard.ca.b(r9)     // Catch: java.lang.Throwable -> L26
            if (r5 == 0) goto L2b
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L26
            r9.<init>()     // Catch: java.lang.Throwable -> L26
            java.lang.String r5 = "_id = "
            r9.append(r5)     // Catch: java.lang.Throwable -> L26
            r9.append(r8)     // Catch: java.lang.Throwable -> L26
            java.lang.String r8 = r9.toString()     // Catch: java.lang.Throwable -> L26
            goto L53
        L26:
            r8 = move-exception
            goto L70
        L28:
            r8 = move-exception
            goto Lb2
        L2b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L26
            r5.<init>()     // Catch: java.lang.Throwable -> L26
            java.lang.String r6 = "_id = "
            r5.append(r6)     // Catch: java.lang.Throwable -> L26
            r5.append(r8)     // Catch: java.lang.Throwable -> L26
            java.lang.String r8 = " and "
            r5.append(r8)     // Catch: java.lang.Throwable -> L26
            java.lang.String r8 = "_tp"
            r5.append(r8)     // Catch: java.lang.Throwable -> L26
            java.lang.String r8 = " = \""
            r5.append(r8)     // Catch: java.lang.Throwable -> L26
            r5.append(r9)     // Catch: java.lang.Throwable -> L26
            java.lang.String r8 = "\""
            r5.append(r8)     // Catch: java.lang.Throwable -> L26
            java.lang.String r8 = r5.toString()     // Catch: java.lang.Throwable -> L26
        L53:
            java.lang.String r9 = "t_pf"
            int r8 = r4.delete(r9, r8, r3)     // Catch: java.lang.Throwable -> L26
            java.lang.String r9 = "[Database] deleted %s data %d"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L26
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L26
            java.lang.String r6 = "t_pf"
            r5[r1] = r6     // Catch: java.lang.Throwable -> L26
            r5[r0] = r3     // Catch: java.lang.Throwable -> L26
            com.tencent.bugly.proguard.X.a(r9, r5)     // Catch: java.lang.Throwable -> L26
            if (r8 <= 0) goto L6e
            goto L72
        L6e:
            r0 = 0
            goto L72
        L70:
            r3 = r4
            goto L86
        L72:
            if (r10 == 0) goto L7b
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> L28
            r10.a(r8)     // Catch: java.lang.Throwable -> L28
        L7b:
            boolean r8 = com.tencent.bugly.proguard.J.f22605c     // Catch: java.lang.Throwable -> L28
            if (r8 == 0) goto L83
            if (r4 == 0) goto L83
            r1 = r0
            goto L9e
        L83:
            r1 = r0
            goto La1
        L85:
            r8 = move-exception
        L86:
            boolean r9 = com.tencent.bugly.proguard.X.b(r8)     // Catch: java.lang.Throwable -> L90
            if (r9 != 0) goto L92
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L90
            goto L92
        L90:
            r8 = move-exception
            goto La3
        L92:
            if (r10 == 0) goto L97
            r10.a(r2)     // Catch: java.lang.Throwable -> L28
        L97:
            boolean r8 = com.tencent.bugly.proguard.J.f22605c     // Catch: java.lang.Throwable -> L28
            if (r8 == 0) goto La1
            if (r3 == 0) goto La1
            r4 = r3
        L9e:
            r4.close()     // Catch: java.lang.Throwable -> L28
        La1:
            monitor-exit(r7)
            return r1
        La3:
            if (r10 == 0) goto La8
            r10.a(r2)     // Catch: java.lang.Throwable -> L28
        La8:
            boolean r9 = com.tencent.bugly.proguard.J.f22605c     // Catch: java.lang.Throwable -> L28
            if (r9 == 0) goto Lb1
            if (r3 == 0) goto Lb1
            r3.close()     // Catch: java.lang.Throwable -> L28
        Lb1:
            throw r8     // Catch: java.lang.Throwable -> L28
        Lb2:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L28
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.J.a(int, java.lang.String, com.tencent.bugly.proguard.I):boolean");
    }
}
