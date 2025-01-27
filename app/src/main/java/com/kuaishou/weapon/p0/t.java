package com.kuaishou.weapon.p0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class t {
    private static t E = null;

    /* renamed from: a */
    public static final String f11201a = "k";

    /* renamed from: b */
    public static final String f11202b = "p";

    /* renamed from: c */
    public static final String f11203c = "v";

    /* renamed from: d */
    public static final String f11204d = "l";

    /* renamed from: e */
    public static final String f11205e = "i";

    /* renamed from: f */
    public static final String f11206f = "a";

    /* renamed from: g */
    public static final String f11207g = "s";

    /* renamed from: h */
    public static final String f11208h = "n";

    /* renamed from: i */
    public static final String f11209i = "u";

    /* renamed from: j */
    public static final String f11210j = "c";

    /* renamed from: k */
    public static final String f11211k = "r";

    /* renamed from: l */
    public static final String f11212l = "b";

    /* renamed from: m */
    public static final String f11213m = "m";

    /* renamed from: n */
    public static final String f11214n = "el";

    /* renamed from: o */
    public static final String f11215o = "ail";

    /* renamed from: p */
    public static final String f11216p = "aps";

    /* renamed from: q */
    public static final String f11217q = "dp";

    /* renamed from: r */
    public static final String f11218r = "pcn";

    /* renamed from: s */
    public static final String f11219s = "pst";

    /* renamed from: t */
    public static final String f11220t = "d";

    /* renamed from: u */
    public static final String f11221u = "at";

    /* renamed from: v */
    public static final String f11222v = "dm";

    /* renamed from: w */
    public static final String f11223w = "rm";

    /* renamed from: x */
    public static final String f11224x = "pc";

    /* renamed from: y */
    public static final String f11225y = "cbl";
    private a B;
    private SQLiteDatabase C;
    private Context D;

    /* renamed from: z */
    private int f11226z = 1;
    private String A = "create table wp(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,el INTEGER,c INTEGER,r INTEGER,aps INTEGER,dp TEXT,pcn TEXT,b TEXT,m TEXT,ail BLOB,pst INTEGER,d INTEGER,at INTEGER,dm TEXT,rm INTEGER,l TEXT,pc INTEGER DEFAULT -1,a TEXT,cbl INTEGER)";

    public class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, bi.f10820p, (SQLiteDatabase.CursorFactory) null, t.this.f11226z);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(t.this.A);
            } catch (Throwable unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            if (i10 >= 3 || i11 < 3) {
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

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
    
        if (r11.isClosed() == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003a, code lost:
    
        if (r11.isClosed() == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003c, code lost:
    
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
            android.database.sqlite.SQLiteDatabase r2 = r10.C     // Catch: java.lang.Throwable -> L40
            java.lang.String r3 = "wp"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L40
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L40
            r5.append(r11)     // Catch: java.lang.Throwable -> L40
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L40
            r8 = 0
            r9 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L40
            if (r11 == 0) goto L34
            boolean r2 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L34
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L32
            int r1 = r11.getInt(r0)     // Catch: java.lang.Throwable -> L32
            goto L34
        L32:
            goto L41
        L34:
            if (r11 == 0) goto L4a
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L4a
        L3c:
            r11.close()
            goto L4a
        L40:
            r11 = 0
        L41:
            if (r11 == 0) goto L4a
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L4a
            goto L3c
        L4a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.c(int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (r11.isClosed() == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003e, code lost:
    
        if (r11.isClosed() == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        r11.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "s"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.C     // Catch: java.lang.Throwable -> L44
            java.lang.String r3 = "wp"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L44
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L44
            r5.append(r11)     // Catch: java.lang.Throwable -> L44
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L44
            r8 = 0
            r9 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L44
            if (r11 == 0) goto L38
            boolean r2 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L36
            if (r2 == 0) goto L38
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L36
            int r0 = r11.getInt(r0)     // Catch: java.lang.Throwable -> L36
            r2 = 1
            if (r0 != r2) goto L38
            r1 = 1
            goto L38
        L36:
            goto L45
        L38:
            if (r11 == 0) goto L4e
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L4e
        L40:
            r11.close()
            goto L4e
        L44:
            r11 = 0
        L45:
            if (r11 == 0) goto L4e
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L4e
            goto L40
        L4e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.d(int):boolean");
    }

    public static synchronized t a(Context context) {
        t tVar;
        synchronized (t.class) {
            try {
                if (E == null) {
                    E = new t(context);
                }
                tVar = E;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return tVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
    
        if (r10.isClosed() == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0033, code lost:
    
        if (r10.isClosed() == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
    
        r10.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(int r10) {
        /*
            r9 = this;
            java.lang.String r1 = "wp"
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r9.C     // Catch: java.lang.Throwable -> L39
            java.lang.String r2 = "p"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L39
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L39
            java.lang.String r4 = "k="
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L39
            r3.append(r10)     // Catch: java.lang.Throwable -> L39
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L39
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r10 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L39
            if (r10 == 0) goto L2d
            int r0 = r10.getCount()     // Catch: java.lang.Throwable -> L2b
            if (r0 <= 0) goto L2d
            r8 = 1
            goto L2d
        L2b:
            goto L3a
        L2d:
            if (r10 == 0) goto L43
            boolean r0 = r10.isClosed()
            if (r0 != 0) goto L43
        L35:
            r10.close()
            goto L43
        L39:
            r10 = 0
        L3a:
            if (r10 == 0) goto L43
            boolean r0 = r10.isClosed()
            if (r0 != 0) goto L43
            goto L35
        L43:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.b(int):boolean");
    }

    public long a(s sVar) {
        long j10 = 0;
        if (sVar == null) {
            return 0L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", Integer.valueOf(sVar.f11177b));
        contentValues.put(f11216p, Integer.valueOf(sVar.f11191p));
        contentValues.put("p", sVar.f11178c);
        contentValues.put("a", sVar.f11180e);
        contentValues.put(f11204d, sVar.f11183h);
        contentValues.put("v", sVar.f11179d);
        contentValues.put(f11217q, sVar.f11189n);
        contentValues.put("a", sVar.f11180e);
        contentValues.put(f11218r, sVar.f11190o);
        contentValues.put(f11219s, Long.valueOf(sVar.f11194s));
        contentValues.put(f11223w, Integer.valueOf(sVar.f11198w));
        contentValues.put("at", Integer.valueOf(sVar.f11192q));
        contentValues.put(f11224x, Integer.valueOf(sVar.f11199x));
        contentValues.put(f11225y, Integer.valueOf(sVar.f11200y ? 1 : 0));
        if (!TextUtils.isEmpty(sVar.f11185j)) {
            contentValues.put(f11222v, sVar.f11185j);
        }
        try {
            if (b(sVar.f11176a)) {
                j10 = this.C.update(bi.f10821q, contentValues, "k=" + sVar.f11176a, null);
            } else {
                contentValues.put("k", Integer.valueOf(sVar.f11176a));
                j10 = this.C.insert(bi.f10821q, null, contentValues);
            }
        } catch (Throwable unused) {
        }
        return j10;
    }

    public void b() {
        ArrayList<s> arrayList = new ArrayList();
        for (s sVar : a()) {
            if (!dn.a(sVar.f11180e)) {
                arrayList.add(sVar);
            }
        }
        try {
            r a10 = r.a();
            for (s sVar2 : arrayList) {
                if (a10 != null) {
                    a10.a(sVar2.f11180e);
                }
                this.C.delete(bi.f10821q, "k=" + sVar2.f11176a, null);
                List<Integer> list = r.f11168b;
                if (list != null && !list.contains(Integer.valueOf(sVar2.f11176a))) {
                    dn.c(this.D.getFilesDir().getCanonicalPath() + bi.f10814j + sVar2.f11176a);
                }
                if (a10.b() != null && a10.b().get(sVar2.f11178c) != null) {
                    dn.c(this.D.getFileStreamPath(sVar2.f11178c).getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", (Integer) 0);
        try {
            this.C.update(bi.f10821q, contentValues, "n=-1", null);
        } catch (Throwable unused) {
        }
    }

    public void d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("u", (Integer) 0);
        try {
            this.C.update(bi.f10821q, contentValues, "u=1", null);
        } catch (Throwable unused) {
        }
    }

    public void c(int i10, int i11) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(f11224x, Integer.valueOf(i11));
            this.C.update(bi.f10821q, contentValues, "k=" + i10, null);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b7, code lost:
    
        if (r1.isClosed() == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x00aa, code lost:
    
        if (r1.isClosed() == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x00ac, code lost:
    
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
            android.database.sqlite.SQLiteDatabase r1 = r9.C     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r2 = "wp"
            r7 = 0
            r8 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lb0
            if (r1 == 0) goto La4
        L15:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> La2
            if (r2 == 0) goto La4
            com.kuaishou.weapon.p0.s r2 = new com.kuaishou.weapon.p0.s     // Catch: java.lang.Throwable -> La2
            r2.<init>()     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "k"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.f11176a = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "p"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f11178c = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "a"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f11180e = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "l"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f11183h = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "v"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f11179d = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "pst"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            long r3 = r1.getLong(r3)     // Catch: java.lang.Throwable -> La2
            r2.f11194s = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "d"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.f11195t = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "rm"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.f11198w = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "pc"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.f11199x = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "cbl"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r4 = 1
            if (r3 != r4) goto L9a
            goto L9b
        L9a:
            r4 = 0
        L9b:
            r2.f11200y = r4     // Catch: java.lang.Throwable -> La2
            r0.add(r2)     // Catch: java.lang.Throwable -> La2
            goto L15
        La2:
            goto Lb1
        La4:
            if (r1 == 0) goto Lba
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto Lba
        Lac:
            r1.close()
            goto Lba
        Lb0:
            r1 = 0
        Lb1:
            if (r1 == 0) goto Lba
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto Lba
            goto Lac
        Lba:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.a():java.util.List");
    }

    public void b(int i10, int i11) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(i11));
            this.C.update(bi.f10821q, contentValues, "k=" + i10, null);
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
            Cursor query = this.C.query(bi.f10821q, null, "p=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.f11176a = query.getInt(query.getColumnIndex("k"));
                            sVar.f11177b = query.getInt(query.getColumnIndex("n"));
                            sVar.f11178c = query.getString(query.getColumnIndex("p"));
                            sVar.f11180e = query.getString(query.getColumnIndex("a"));
                            sVar.f11183h = query.getString(query.getColumnIndex(f11204d));
                            sVar.f11179d = query.getString(query.getColumnIndex("v"));
                            sVar.f11189n = query.getString(query.getColumnIndex(f11217q));
                            sVar.f11191p = query.getInt(query.getColumnIndex(f11216p));
                            sVar.f11190o = query.getString(query.getColumnIndex(f11218r));
                            sVar.f11192q = query.getInt(query.getColumnIndex("at"));
                            sVar.f11194s = query.getLong(query.getColumnIndex(f11219s));
                            sVar.f11195t = query.getInt(query.getColumnIndex("d"));
                            sVar.f11198w = query.getInt(query.getColumnIndex(f11223w));
                            sVar.f11185j = query.getString(query.getColumnIndex(f11222v));
                            sVar.f11199x = query.getInt(query.getColumnIndex(f11224x));
                            boolean z10 = true;
                            if (query.getInt(query.getColumnIndex(f11225y)) != 1) {
                                z10 = false;
                            }
                            sVar.f11200y = z10;
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

    public s a(int i10) {
        s sVar;
        Cursor cursor = null;
        r0 = null;
        s sVar2 = null;
        try {
            Cursor query = this.C.query(bi.f10821q, null, "k=" + i10, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.f11176a = i10;
                            sVar.f11177b = query.getInt(query.getColumnIndex("n"));
                            sVar.f11178c = query.getString(query.getColumnIndex("p"));
                            sVar.f11180e = query.getString(query.getColumnIndex("a"));
                            sVar.f11183h = query.getString(query.getColumnIndex(f11204d));
                            sVar.f11179d = query.getString(query.getColumnIndex("v"));
                            sVar.f11189n = query.getString(query.getColumnIndex(f11217q));
                            sVar.f11191p = query.getInt(query.getColumnIndex(f11216p));
                            sVar.f11190o = query.getString(query.getColumnIndex(f11218r));
                            sVar.f11192q = query.getInt(query.getColumnIndex("at"));
                            sVar.f11194s = query.getLong(query.getColumnIndex(f11219s));
                            sVar.f11195t = query.getInt(query.getColumnIndex("d"));
                            sVar.f11198w = query.getInt(query.getColumnIndex(f11223w));
                            sVar.f11185j = query.getString(query.getColumnIndex(f11222v));
                            sVar.f11199x = query.getInt(query.getColumnIndex(f11224x));
                            boolean z10 = true;
                            if (query.getInt(query.getColumnIndex(f11225y)) != 1) {
                                z10 = false;
                            }
                            sVar.f11200y = z10;
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

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.C.delete(bi.f10821q, "p=?", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    public int a(int i10, int i11) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", Integer.valueOf(i11));
            return this.C.update(bi.f10821q, contentValues, "k=" + i10, null);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
