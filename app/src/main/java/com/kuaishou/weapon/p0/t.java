package com.kuaishou.weapon.p0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class t {
    private static t E = null;

    /* renamed from: a */
    public static final String f9401a = "k";

    /* renamed from: b */
    public static final String f9402b = "p";

    /* renamed from: c */
    public static final String f9403c = "v";

    /* renamed from: d */
    public static final String f9404d = "l";

    /* renamed from: e */
    public static final String f9405e = "i";

    /* renamed from: f */
    public static final String f9406f = "a";

    /* renamed from: g */
    public static final String f9407g = "s";

    /* renamed from: h */
    public static final String f9408h = "n";

    /* renamed from: i */
    public static final String f9409i = "u";

    /* renamed from: j */
    public static final String f9410j = "c";
    public static final String k = "r";
    public static final String l = "b";
    public static final String m = "m";
    public static final String n = "el";
    public static final String o = "ail";
    public static final String p = "aps";
    public static final String q = "dp";
    public static final String r = "pcn";
    public static final String s = "pst";
    public static final String t = "d";
    public static final String u = "at";
    public static final String v = "dm";
    public static final String w = "rm";
    public static final String x = "pc";
    public static final String y = "cbl";
    private a B;
    private SQLiteDatabase C;
    private Context D;
    private int z = 1;
    private String A = "create table wp(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,el INTEGER,c INTEGER,r INTEGER,aps INTEGER,dp TEXT,pcn TEXT,b TEXT,m TEXT,ail BLOB,pst INTEGER,d INTEGER,at INTEGER,dm TEXT,rm INTEGER,l TEXT,pc INTEGER DEFAULT -1,a TEXT,cbl INTEGER)";

    class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, bh.p, (SQLiteDatabase.CursorFactory) null, t.this.z);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(t.this.A);
            } catch (Throwable unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            if (i2 >= 3 || i3 < 3) {
                return;
            }
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE wp ADD COLUMN pc INTEGER  DEFAULT -1");
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Throwable unused) {
                }
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused2) {
            }
        }
    }

    private t(Context context) {
        this.D = context.getApplicationContext();
        this.B = new a(context.getApplicationContext());
        try {
            if (context.getFilesDir().getParentFile().exists()) {
                this.C = this.B.getWritableDatabase();
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized t a(Context context) {
        t tVar;
        synchronized (t.class) {
            if (E == null) {
                E = new t(context);
            }
            tVar = E;
        }
        return tVar;
    }

    public int a(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", Integer.valueOf(i3));
            return this.C.update(bh.q, contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public long a(s sVar) {
        long j2 = 0;
        if (sVar == null) {
            return 0L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", Integer.valueOf(sVar.f9392b));
        contentValues.put(p, Integer.valueOf(sVar.p));
        contentValues.put("p", sVar.f9393c);
        contentValues.put("a", sVar.f9395e);
        contentValues.put(f9404d, sVar.f9398h);
        contentValues.put("v", sVar.f9394d);
        contentValues.put(q, sVar.n);
        contentValues.put("a", sVar.f9395e);
        contentValues.put(r, sVar.o);
        contentValues.put(s, Long.valueOf(sVar.s));
        contentValues.put(w, Integer.valueOf(sVar.w));
        contentValues.put("at", Integer.valueOf(sVar.q));
        contentValues.put(x, Integer.valueOf(sVar.x));
        contentValues.put(y, Integer.valueOf(sVar.y ? 1 : 0));
        if (!TextUtils.isEmpty(sVar.f9400j)) {
            contentValues.put(v, sVar.f9400j);
        }
        try {
            if (b(sVar.f9391a)) {
                j2 = this.C.update(bh.q, contentValues, "k=" + sVar.f9391a, null);
            } else {
                contentValues.put("k", Integer.valueOf(sVar.f9391a));
                j2 = this.C.insert(bh.q, null, contentValues);
            }
        } catch (Throwable unused) {
        }
        return j2;
    }

    public s a(int i2) {
        s sVar;
        Cursor cursor = null;
        r0 = null;
        s sVar2 = null;
        try {
            Cursor query = this.C.query(bh.q, null, "k=" + i2, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.f9391a = i2;
                            sVar.f9392b = query.getInt(query.getColumnIndex("n"));
                            sVar.f9393c = query.getString(query.getColumnIndex("p"));
                            sVar.f9395e = query.getString(query.getColumnIndex("a"));
                            sVar.f9398h = query.getString(query.getColumnIndex(f9404d));
                            sVar.f9394d = query.getString(query.getColumnIndex("v"));
                            sVar.n = query.getString(query.getColumnIndex(q));
                            sVar.p = query.getInt(query.getColumnIndex(p));
                            sVar.o = query.getString(query.getColumnIndex(r));
                            sVar.q = query.getInt(query.getColumnIndex("at"));
                            sVar.s = query.getLong(query.getColumnIndex(s));
                            sVar.t = query.getInt(query.getColumnIndex("d"));
                            sVar.w = query.getInt(query.getColumnIndex(w));
                            sVar.f9400j = query.getString(query.getColumnIndex(v));
                            sVar.x = query.getInt(query.getColumnIndex(x));
                            boolean z = true;
                            if (query.getInt(query.getColumnIndex(y)) != 1) {
                                z = false;
                            }
                            sVar.y = z;
                            sVar2 = sVar;
                        } catch (Throwable unused) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return sVar;
                        }
                    }
                } catch (Throwable unused2) {
                    sVar = null;
                }
            }
            if (query == null || query.isClosed()) {
                return sVar2;
            }
            query.close();
            return sVar2;
        } catch (Throwable unused3) {
            sVar = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b4, code lost:
    
        if (r1.isClosed() == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x00aa, code lost:
    
        if (r1.isClosed() == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x00b6, code lost:
    
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.kuaishou.weapon.p0.s> a() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r9.C     // Catch: java.lang.Throwable -> Lad
            java.lang.String r2 = "wp"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lad
            if (r1 == 0) goto La4
        L15:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> La2
            if (r2 == 0) goto La4
            com.kuaishou.weapon.p0.s r2 = new com.kuaishou.weapon.p0.s     // Catch: java.lang.Throwable -> La2
            r2.<init>()     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "k"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.f9391a = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "p"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f9393c = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "a"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f9395e = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "l"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f9398h = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "v"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f9394d = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "pst"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            long r3 = r1.getLong(r3)     // Catch: java.lang.Throwable -> La2
            r2.s = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "d"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.t = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "rm"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.w = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "pc"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.x = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "cbl"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r4 = 1
            if (r3 != r4) goto L9a
            goto L9b
        L9a:
            r4 = 0
        L9b:
            r2.y = r4     // Catch: java.lang.Throwable -> La2
            r0.add(r2)     // Catch: java.lang.Throwable -> La2
            goto L15
        La2:
            goto Lae
        La4:
            if (r1 == 0) goto Lb9
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto Lb9
            goto Lb6
        Lad:
            r1 = 0
        Lae:
            if (r1 == 0) goto Lb9
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto Lb9
        Lb6:
            r1.close()
        Lb9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.a():java.util.List");
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.C.delete(bh.q, "p=?", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    public s b(String str) {
        s sVar;
        Cursor cursor = null;
        r1 = null;
        s sVar2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            boolean z = true;
            Cursor query = this.C.query(bh.q, null, "p=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.f9391a = query.getInt(query.getColumnIndex("k"));
                            sVar.f9392b = query.getInt(query.getColumnIndex("n"));
                            sVar.f9393c = query.getString(query.getColumnIndex("p"));
                            sVar.f9395e = query.getString(query.getColumnIndex("a"));
                            sVar.f9398h = query.getString(query.getColumnIndex(f9404d));
                            sVar.f9394d = query.getString(query.getColumnIndex("v"));
                            sVar.n = query.getString(query.getColumnIndex(q));
                            sVar.p = query.getInt(query.getColumnIndex(p));
                            sVar.o = query.getString(query.getColumnIndex(r));
                            sVar.q = query.getInt(query.getColumnIndex("at"));
                            sVar.s = query.getLong(query.getColumnIndex(s));
                            sVar.t = query.getInt(query.getColumnIndex("d"));
                            sVar.w = query.getInt(query.getColumnIndex(w));
                            sVar.f9400j = query.getString(query.getColumnIndex(v));
                            sVar.x = query.getInt(query.getColumnIndex(x));
                            if (query.getInt(query.getColumnIndex(y)) != 1) {
                                z = false;
                            }
                            sVar.y = z;
                            sVar2 = sVar;
                        } catch (Throwable unused) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return sVar;
                        }
                    }
                } catch (Throwable unused2) {
                    sVar = null;
                }
            }
            if (query == null || query.isClosed()) {
                return sVar2;
            }
            query.close();
            return sVar2;
        } catch (Throwable unused3) {
            sVar = null;
        }
    }

    public void b() {
        ArrayList<s> arrayList = new ArrayList();
        for (s sVar : a()) {
            if (!dm.a(sVar.f9395e)) {
                arrayList.add(sVar);
            }
        }
        try {
            r a2 = r.a();
            for (s sVar2 : arrayList) {
                if (a2 != null) {
                    a2.a(sVar2.f9395e);
                }
                this.C.delete(bh.q, "k=" + sVar2.f9391a, null);
                List<Integer> list = r.f9380b;
                if (list != null && !list.contains(Integer.valueOf(sVar2.f9391a))) {
                    dm.c(this.D.getFilesDir().getCanonicalPath() + bh.f9116j + sVar2.f9391a);
                }
                if (a2.b() != null && a2.b().get(sVar2.f9393c) != null) {
                    dm.c(this.D.getFileStreamPath(sVar2.f9393c).getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(i3));
            this.C.update(bh.q, contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if (r11.isClosed() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0034, code lost:
    
        if (r11.isClosed() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0036, code lost:
    
        r11.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(int r11) {
        /*
            r10 = this;
            java.lang.String r1 = "wp"
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r10.C     // Catch: java.lang.Throwable -> L3a
            r9 = 1
            java.lang.String[] r2 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = "p"
            r2[r8] = r3     // Catch: java.lang.Throwable -> L3a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a
            java.lang.String r4 = "k="
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3a
            r3.append(r11)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L3a
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L3a
            if (r11 == 0) goto L2e
            int r0 = r11.getCount()     // Catch: java.lang.Throwable -> L2c
            if (r0 <= 0) goto L2e
            r8 = 1
            goto L2e
        L2c:
            goto L3b
        L2e:
            if (r11 == 0) goto L44
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L44
        L36:
            r11.close()
            goto L44
        L3a:
            r11 = 0
        L3b:
            if (r11 == 0) goto L44
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L44
            goto L36
        L44:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.b(int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        if (r11.isClosed() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003c, code lost:
    
        if (r11.isClosed() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003e, code lost:
    
        r11.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int c(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "n"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.C     // Catch: java.lang.Throwable -> L42
            java.lang.String r3 = "wp"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L42
            r4[r1] = r0     // Catch: java.lang.Throwable -> L42
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L42
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L42
            r5.append(r11)     // Catch: java.lang.Throwable -> L42
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L42
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L42
            if (r11 == 0) goto L36
            boolean r2 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L34
            if (r2 == 0) goto L36
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L34
            int r0 = r11.getInt(r0)     // Catch: java.lang.Throwable -> L34
            r1 = r0
            goto L36
        L34:
            goto L43
        L36:
            if (r11 == 0) goto L4c
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L4c
        L3e:
            r11.close()
            goto L4c
        L42:
            r11 = 0
        L43:
            if (r11 == 0) goto L4c
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L4c
            goto L3e
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.c(int):int");
    }

    public void c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", (Integer) 0);
        try {
            this.C.update(bh.q, contentValues, "n=-1", null);
        } catch (Throwable unused) {
        }
    }

    public void c(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(x, Integer.valueOf(i3));
            this.C.update(bh.q, contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
        }
    }

    public void d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("u", (Integer) 0);
        try {
            this.C.update(bh.q, contentValues, "u=1", null);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
    
        if (r12.isClosed() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003e, code lost:
    
        if (r12.isClosed() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        r12.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(int r12) {
        /*
            r11 = this;
            java.lang.String r0 = "s"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.C     // Catch: java.lang.Throwable -> L44
            java.lang.String r3 = "wp"
            r10 = 1
            java.lang.String[] r4 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L44
            r4[r1] = r0     // Catch: java.lang.Throwable -> L44
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L44
            r5.append(r12)     // Catch: java.lang.Throwable -> L44
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L44
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L44
            if (r12 == 0) goto L38
            boolean r2 = r12.moveToFirst()     // Catch: java.lang.Throwable -> L36
            if (r2 == 0) goto L38
            int r0 = r12.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L36
            int r0 = r12.getInt(r0)     // Catch: java.lang.Throwable -> L36
            if (r0 != r10) goto L38
            r1 = 1
            goto L38
        L36:
            goto L45
        L38:
            if (r12 == 0) goto L4e
            boolean r0 = r12.isClosed()
            if (r0 != 0) goto L4e
        L40:
            r12.close()
            goto L4e
        L44:
            r12 = 0
        L45:
            if (r12 == 0) goto L4e
            boolean r0 = r12.isClosed()
            if (r0 != 0) goto L4e
            goto L40
        L4e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.d(int):boolean");
    }
}
