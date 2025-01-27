package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.umeng.analytics.pro.aq;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class J {

    /* renamed from: a */
    private static J f24962a = null;

    /* renamed from: b */
    private static K f24963b = null;

    /* renamed from: c */
    public static boolean f24964c = false;

    private J(Context context, List<com.tencent.bugly.a> list) {
        f24963b = new K(context, list);
    }

    private synchronized boolean d(L l) {
        ContentValues b2;
        if (l == null) {
            return false;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = f24963b.getWritableDatabase();
            if (sQLiteDatabase == null || (b2 = b(l)) == null) {
                return false;
            }
            long replace = sQLiteDatabase.replace("t_pf", "_id", b2);
            if (replace < 0) {
                if (f24964c) {
                    sQLiteDatabase.close();
                }
                return false;
            }
            Object[] objArr = new Object[1];
            objArr[0] = "t_pf";
            X.a("[Database] insert %s success.", objArr);
            l.f24979a = replace;
            if (f24964c) {
                sQLiteDatabase.close();
            }
            return true;
        } catch (Throwable th) {
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                if (f24964c && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return false;
            } finally {
                if (f24964c && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        if (com.tencent.bugly.proguard.J.f24964c != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
    
        if (com.tencent.bugly.proguard.J.f24964c == false) goto L82;
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
            com.tencent.bugly.proguard.K r0 = com.tencent.bugly.proguard.J.f24963b     // Catch: java.lang.Throwable -> L5c
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> L5c
            if (r0 == 0) goto L5a
            r1 = 0
            if (r6 < 0) goto L20
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1e
            r2.<init>()     // Catch: java.lang.Throwable -> L1e
            java.lang.String r3 = "_tp = "
            r2.append(r3)     // Catch: java.lang.Throwable -> L1e
            r2.append(r6)     // Catch: java.lang.Throwable -> L1e
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L1e
            goto L21
        L1e:
            r6 = move-exception
            goto L40
        L20:
            r6 = r1
        L21:
            java.lang.String r2 = "t_lr"
            int r6 = r0.delete(r2, r6, r1)     // Catch: java.lang.Throwable -> L1e
            java.lang.String r1 = "[Database] deleted %s data %d"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L1e
            r3 = 0
            java.lang.String r4 = "t_lr"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L1e
            r3 = 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L1e
            r2[r3] = r6     // Catch: java.lang.Throwable -> L1e
            com.tencent.bugly.proguard.X.a(r1, r2)     // Catch: java.lang.Throwable -> L1e
            boolean r6 = com.tencent.bugly.proguard.J.f24964c     // Catch: java.lang.Throwable -> L5c
            if (r6 == 0) goto L5a
            goto L4d
        L40:
            boolean r1 = com.tencent.bugly.proguard.X.b(r6)     // Catch: java.lang.Throwable -> L51
            if (r1 != 0) goto L49
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L51
        L49:
            boolean r6 = com.tencent.bugly.proguard.J.f24964c     // Catch: java.lang.Throwable -> L5c
            if (r6 == 0) goto L5a
        L4d:
            r0.close()     // Catch: java.lang.Throwable -> L5c
            goto L5a
        L51:
            r6 = move-exception
            boolean r1 = com.tencent.bugly.proguard.J.f24964c     // Catch: java.lang.Throwable -> L5c
            if (r1 == 0) goto L59
            r0.close()     // Catch: java.lang.Throwable -> L5c
        L59:
            throw r6     // Catch: java.lang.Throwable -> L5c
        L5a:
            monitor-exit(r5)
            return
        L5c:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.J.b(int):void");
    }

    public synchronized boolean c(L l) {
        ContentValues a2;
        if (l == null) {
            return false;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = f24963b.getWritableDatabase();
            if (sQLiteDatabase == null || (a2 = a(l)) == null) {
                return false;
            }
            long replace = sQLiteDatabase.replace("t_lr", "_id", a2);
            if (replace < 0) {
                if (f24964c) {
                    sQLiteDatabase.close();
                }
                return false;
            }
            Object[] objArr = new Object[1];
            objArr[0] = "t_lr";
            X.a("[Database] insert %s success.", objArr);
            l.f24979a = replace;
            if (f24964c) {
                sQLiteDatabase.close();
            }
            return true;
        } catch (Throwable th) {
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                if (f24964c && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return false;
            } finally {
                if (f24964c && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
    }

    class a extends Thread {

        /* renamed from: a */
        private int f24965a;

        /* renamed from: b */
        private I f24966b;

        /* renamed from: c */
        private String f24967c;

        /* renamed from: d */
        private ContentValues f24968d;

        /* renamed from: e */
        private boolean f24969e;

        /* renamed from: f */
        private String[] f24970f;

        /* renamed from: g */
        private String f24971g;

        /* renamed from: h */
        private String[] f24972h;

        /* renamed from: i */
        private String f24973i;

        /* renamed from: j */
        private String f24974j;
        private String k;
        private String l;
        private String m;
        private String[] n;
        private int o;
        private String p;
        private byte[] q;

        public a(int i2, I i3) {
            this.f24965a = i2;
            this.f24966b = i3;
        }

        public void a(String str, ContentValues contentValues) {
            this.f24967c = str;
            this.f24968d = contentValues;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            switch (this.f24965a) {
                case 1:
                    J.this.a(this.f24967c, this.f24968d, this.f24966b);
                    break;
                case 2:
                    J.this.a(this.f24967c, this.m, this.n, this.f24966b);
                    break;
                case 3:
                    Cursor a2 = J.this.a(this.f24969e, this.f24967c, this.f24970f, this.f24971g, this.f24972h, this.f24973i, this.f24974j, this.k, this.l, this.f24966b);
                    if (a2 != null) {
                        a2.close();
                        break;
                    }
                    break;
                case 4:
                    J.this.a(this.o, this.p, this.q, this.f24966b);
                    break;
                case 5:
                    J.this.a(this.o, this.f24966b);
                    break;
                case 6:
                    J.this.a(this.o, this.p, this.f24966b);
                    break;
            }
        }

        public void a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f24969e = z;
            this.f24967c = str;
            this.f24970f = strArr;
            this.f24971g = str2;
            this.f24972h = strArr2;
            this.f24973i = str3;
            this.f24974j = str4;
            this.k = str5;
            this.l = str6;
        }

        public void a(String str, String str2, String[] strArr) {
            this.f24967c = str;
            this.m = str2;
            this.n = strArr;
        }

        public void a(int i2, String str, byte[] bArr) {
            this.o = i2;
            this.p = str;
            this.q = bArr;
        }

        public void a(int i2) {
            this.o = i2;
        }
    }

    public static synchronized J a(Context context, List<com.tencent.bugly.a> list) {
        J j2;
        synchronized (J.class) {
            if (f24962a == null) {
                f24962a = new J(context, list);
            }
            j2 = f24962a;
        }
        return j2;
    }

    public static synchronized J a() {
        J j2;
        synchronized (J.class) {
            j2 = f24962a;
        }
        return j2;
    }

    public long a(String str, ContentValues contentValues, I i2, boolean z) {
        if (!z) {
            a aVar = new a(1, i2);
            aVar.a(str, contentValues);
            W.c().a(aVar);
            return 0L;
        }
        return a(str, contentValues, i2);
    }

    protected ContentValues b(L l) {
        if (l != null && !ca.b(l.f24984f)) {
            try {
                ContentValues contentValues = new ContentValues();
                long j2 = l.f24979a;
                if (j2 > 0) {
                    contentValues.put("_id", Long.valueOf(j2));
                }
                contentValues.put(aq.f25697e, l.f24984f);
                contentValues.put("_tm", Long.valueOf(l.f24983e));
                byte[] bArr = l.f24985g;
                if (bArr != null) {
                    contentValues.put("_dt", bArr);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, I i2, boolean z) {
        return a(false, str, strArr, str2, strArr2, (String) null, (String) null, (String) null, (String) null, i2, z);
    }

    public Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, I i2, boolean z2) {
        if (!z2) {
            a aVar = new a(3, i2);
            aVar.a(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            W.c().a(aVar);
            return null;
        }
        return a(z, str, strArr, str2, strArr2, str3, str4, str5, str6, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x00c3, code lost:
    
        if (r1 != null) goto L189;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized java.util.List<com.tencent.bugly.proguard.L> c(int r12) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.J.c(int):java.util.List");
    }

    public int a(String str, String str2, String[] strArr, I i2, boolean z) {
        if (!z) {
            a aVar = new a(2, i2);
            aVar.a(str, str2, strArr);
            W.c().a(aVar);
            return 0;
        }
        return a(str, str2, strArr, i2);
    }

    protected L b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            L l = new L();
            l.f24979a = cursor.getLong(cursor.getColumnIndex("_id"));
            l.f24983e = cursor.getLong(cursor.getColumnIndex("_tm"));
            l.f24984f = cursor.getString(cursor.getColumnIndex(aq.f25697e));
            l.f24985g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return l;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public synchronized long a(String str, ContentValues contentValues, I i2) {
        long j2;
        j2 = 0;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = f24963b.getWritableDatabase();
            if (writableDatabase != null && contentValues != null) {
                long replace = writableDatabase.replace(str, "_id", contentValues);
                if (replace >= 0) {
                    X.a("[Database] insert %s success.", str);
                } else {
                    X.e("[Database] replace %s error.", str);
                }
                j2 = replace;
            }
            if (i2 != null) {
                i2.a(Long.valueOf(j2));
            }
            if (f24964c && writableDatabase != null) {
                writableDatabase.close();
            }
        } catch (Throwable th) {
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
            } finally {
                if (i2 != null) {
                    i2.a(0L);
                }
                if (f24964c && 0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        return j2;
    }

    public synchronized Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, I i2) {
        Cursor cursor;
        try {
            SQLiteDatabase writableDatabase = f24963b.getWritableDatabase();
            cursor = writableDatabase != null ? writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6) : null;
        } catch (Throwable th) {
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                if (i2 != null) {
                    i2.a(null);
                }
            } finally {
                if (i2 != null) {
                    i2.a(null);
                }
            }
        }
        return cursor;
    }

    public synchronized int a(String str, String str2, String[] strArr, I i2) {
        int i3;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = f24963b.getWritableDatabase();
            i3 = sQLiteDatabase != null ? sQLiteDatabase.delete(str, str2, strArr) : 0;
            if (i2 != null) {
                i2.a(Integer.valueOf(i3));
            }
            if (f24964c && sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th) {
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
            } finally {
                if (i2 != null) {
                    i2.a(0);
                }
                if (f24964c && sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
        return i3;
    }

    public boolean a(int i2, String str, byte[] bArr, I i3, boolean z) {
        if (!z) {
            a aVar = new a(4, i3);
            aVar.a(i2, str, bArr);
            W.c().a(aVar);
            return true;
        }
        return a(i2, str, bArr, i3);
    }

    public Map<String, byte[]> a(int i2, I i3, boolean z) {
        if (!z) {
            a aVar = new a(5, i3);
            aVar.a(i2);
            W.c().a(aVar);
            return null;
        }
        return a(i2, i3);
    }

    public boolean a(int i2, String str, byte[] bArr, I i3) {
        Boolean bool = Boolean.FALSE;
        try {
            L l = new L();
            l.f24979a = i2;
            l.f24984f = str;
            l.f24983e = System.currentTimeMillis();
            l.f24985g = bArr;
            boolean d2 = d(l);
            if (i3 == null) {
                return d2;
            }
            i3.a(Boolean.valueOf(d2));
            return d2;
        } catch (Throwable th) {
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
                if (i3 != null) {
                    i3.a(bool);
                }
            }
        }
    }

    public Map<String, byte[]> a(int i2, I i3) {
        HashMap hashMap = null;
        try {
            List<L> c2 = c(i2);
            if (c2 != null) {
                HashMap hashMap2 = new HashMap();
                try {
                    for (L l : c2) {
                        byte[] bArr = l.f24985g;
                        if (bArr != null) {
                            hashMap2.put(l.f24984f, bArr);
                        }
                    }
                    hashMap = hashMap2;
                } catch (Throwable th) {
                    th = th;
                    hashMap = hashMap2;
                    try {
                        if (!X.b(th)) {
                            th.printStackTrace();
                        }
                        return hashMap;
                    } finally {
                        if (i3 != null) {
                            i3.a(hashMap);
                        }
                    }
                }
            }
            if (i3 != null) {
                i3.a(hashMap);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00bd A[Catch: all -> 0x00cd, TRY_LEAVE, TryCatch #2 {all -> 0x00cd, blocks: (B:65:0x00b7, B:67:0x00bd), top: B:64:0x00b7, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2 A[Catch: all -> 0x00dd, TRY_ENTER, TryCatch #3 {, blocks: (B:3:0x0001, B:13:0x0033, B:14:0x0036, B:16:0x003a, B:58:0x00a7, B:60:0x00ae, B:70:0x00c2, B:71:0x00c5, B:73:0x00c9, B:76:0x00d0, B:77:0x00d3, B:79:0x00d7, B:80:0x00da, B:65:0x00b7, B:67:0x00bd), top: B:2:0x0001, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c9 A[Catch: all -> 0x00dd, TryCatch #3 {, blocks: (B:3:0x0001, B:13:0x0033, B:14:0x0036, B:16:0x003a, B:58:0x00a7, B:60:0x00ae, B:70:0x00c2, B:71:0x00c5, B:73:0x00c9, B:76:0x00d0, B:77:0x00d3, B:79:0x00d7, B:80:0x00da, B:65:0x00b7, B:67:0x00bd), top: B:2:0x0001, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<com.tencent.bugly.proguard.L> a(int r11) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.J.a(int):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x006c, code lost:
    
        if (com.tencent.bugly.proguard.J.f24964c != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007b, code lost:
    
        if (com.tencent.bugly.proguard.J.f24964c == false) goto L91;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(java.util.List<com.tencent.bugly.proguard.L> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r6 == 0) goto L8f
            int r0 = r6.size()     // Catch: java.lang.Throwable -> L8c
            if (r0 != 0) goto Lb
            goto L8f
        Lb:
            com.tencent.bugly.proguard.K r0 = com.tencent.bugly.proguard.J.f24963b     // Catch: java.lang.Throwable -> L8c
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> L8c
            if (r0 == 0) goto L8a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c
            r1.<init>()     // Catch: java.lang.Throwable -> L8c
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> L8c
        L1c:
            boolean r2 = r6.hasNext()     // Catch: java.lang.Throwable -> L8c
            if (r2 == 0) goto L3d
            java.lang.Object r2 = r6.next()     // Catch: java.lang.Throwable -> L8c
            com.tencent.bugly.proguard.L r2 = (com.tencent.bugly.proguard.L) r2     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = " or "
            r1.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = "_id"
            r1.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = " = "
            r1.append(r3)     // Catch: java.lang.Throwable -> L8c
            long r2 = r2.f24979a     // Catch: java.lang.Throwable -> L8c
            r1.append(r2)     // Catch: java.lang.Throwable -> L8c
            goto L1c
        L3d:
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Throwable -> L8c
            int r2 = r6.length()     // Catch: java.lang.Throwable -> L8c
            if (r2 <= 0) goto L4c
            r2 = 4
            java.lang.String r6 = r6.substring(r2)     // Catch: java.lang.Throwable -> L8c
        L4c:
            r2 = 0
            r1.setLength(r2)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r1 = "t_lr"
            r3 = 0
            int r6 = r0.delete(r1, r6, r3)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = "[Database] deleted %s data %d"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L6f
            java.lang.String r4 = "t_lr"
            r3[r2] = r4     // Catch: java.lang.Throwable -> L6f
            r2 = 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L6f
            r3[r2] = r6     // Catch: java.lang.Throwable -> L6f
            com.tencent.bugly.proguard.X.a(r1, r3)     // Catch: java.lang.Throwable -> L6f
            boolean r6 = com.tencent.bugly.proguard.J.f24964c     // Catch: java.lang.Throwable -> L8c
            if (r6 == 0) goto L8a
            goto L7d
        L6f:
            r6 = move-exception
            boolean r1 = com.tencent.bugly.proguard.X.b(r6)     // Catch: java.lang.Throwable -> L81
            if (r1 != 0) goto L79
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L81
        L79:
            boolean r6 = com.tencent.bugly.proguard.J.f24964c     // Catch: java.lang.Throwable -> L8c
            if (r6 == 0) goto L8a
        L7d:
            r0.close()     // Catch: java.lang.Throwable -> L8c
            goto L8a
        L81:
            r6 = move-exception
            boolean r1 = com.tencent.bugly.proguard.J.f24964c     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L89
            r0.close()     // Catch: java.lang.Throwable -> L8c
        L89:
            throw r6     // Catch: java.lang.Throwable -> L8c
        L8a:
            monitor-exit(r5)
            return
        L8c:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        L8f:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.J.a(java.util.List):void");
    }

    protected ContentValues a(L l) {
        if (l == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j2 = l.f24979a;
            if (j2 > 0) {
                contentValues.put("_id", Long.valueOf(j2));
            }
            contentValues.put(aq.f25697e, Integer.valueOf(l.f24980b));
            contentValues.put("_pc", l.f24981c);
            contentValues.put("_th", l.f24982d);
            contentValues.put("_tm", Long.valueOf(l.f24983e));
            byte[] bArr = l.f24985g;
            if (bArr != null) {
                contentValues.put("_dt", bArr);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    protected L a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            L l = new L();
            l.f24979a = cursor.getLong(cursor.getColumnIndex("_id"));
            l.f24980b = cursor.getInt(cursor.getColumnIndex(aq.f25697e));
            l.f24981c = cursor.getString(cursor.getColumnIndex("_pc"));
            l.f24982d = cursor.getString(cursor.getColumnIndex("_th"));
            l.f24983e = cursor.getLong(cursor.getColumnIndex("_tm"));
            l.f24985g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return l;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x007a, code lost:
    
        if (r3 != null) goto L123;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean a(int r8, java.lang.String r9, com.tencent.bugly.proguard.I r10) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> La8
            r1 = 0
            r2 = 0
            com.tencent.bugly.proguard.K r3 = com.tencent.bugly.proguard.J.f24963b     // Catch: java.lang.Throwable -> L7d
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> L7d
            r4 = 1
            if (r3 == 0) goto L6d
            boolean r5 = com.tencent.bugly.proguard.ca.b(r9)     // Catch: java.lang.Throwable -> L6a
            if (r5 == 0) goto L26
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a
            r9.<init>()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r5 = "_id = "
            r9.append(r5)     // Catch: java.lang.Throwable -> L6a
            r9.append(r8)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r8 = r9.toString()     // Catch: java.lang.Throwable -> L6a
            goto L4e
        L26:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a
            r5.<init>()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r6 = "_id = "
            r5.append(r6)     // Catch: java.lang.Throwable -> L6a
            r5.append(r8)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r8 = " and "
            r5.append(r8)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r8 = "_tp"
            r5.append(r8)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r8 = " = \""
            r5.append(r8)     // Catch: java.lang.Throwable -> L6a
            r5.append(r9)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r8 = "\""
            r5.append(r8)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r8 = r5.toString()     // Catch: java.lang.Throwable -> L6a
        L4e:
            java.lang.String r9 = "t_pf"
            int r8 = r3.delete(r9, r8, r1)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r9 = "[Database] deleted %s data %d"
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L6a
            java.lang.String r5 = "t_pf"
            r1[r2] = r5     // Catch: java.lang.Throwable -> L6a
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L6a
            r1[r4] = r5     // Catch: java.lang.Throwable -> L6a
            com.tencent.bugly.proguard.X.a(r9, r1)     // Catch: java.lang.Throwable -> L6a
            if (r8 <= 0) goto L6d
            r2 = 1
            goto L6d
        L6a:
            r8 = move-exception
            r1 = r3
            goto L7e
        L6d:
            if (r10 == 0) goto L76
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> La8
            r10.a(r8)     // Catch: java.lang.Throwable -> La8
        L76:
            boolean r8 = com.tencent.bugly.proguard.J.f24964c     // Catch: java.lang.Throwable -> La8
            if (r8 == 0) goto L96
            if (r3 == 0) goto L96
            goto L93
        L7d:
            r8 = move-exception
        L7e:
            boolean r9 = com.tencent.bugly.proguard.X.b(r8)     // Catch: java.lang.Throwable -> L98
            if (r9 != 0) goto L87
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L98
        L87:
            if (r10 == 0) goto L8c
            r10.a(r0)     // Catch: java.lang.Throwable -> La8
        L8c:
            boolean r8 = com.tencent.bugly.proguard.J.f24964c     // Catch: java.lang.Throwable -> La8
            if (r8 == 0) goto L96
            if (r1 == 0) goto L96
            r3 = r1
        L93:
            r3.close()     // Catch: java.lang.Throwable -> La8
        L96:
            monitor-exit(r7)
            return r2
        L98:
            r8 = move-exception
            if (r10 == 0) goto L9e
            r10.a(r0)     // Catch: java.lang.Throwable -> La8
        L9e:
            boolean r9 = com.tencent.bugly.proguard.J.f24964c     // Catch: java.lang.Throwable -> La8
            if (r9 == 0) goto La7
            if (r1 == 0) goto La7
            r1.close()     // Catch: java.lang.Throwable -> La8
        La7:
            throw r8     // Catch: java.lang.Throwable -> La8
        La8:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.J.a(int, java.lang.String, com.tencent.bugly.proguard.I):boolean");
    }
}
