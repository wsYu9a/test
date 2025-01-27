package com.martian.mibook.lib.model.e;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes3.dex */
public class o<E> {

    /* renamed from: a */
    public static final String f13987a;

    /* renamed from: b */
    private final String f13988b;

    /* renamed from: c */
    private final int f13989c;

    /* renamed from: d */
    private final Class<E> f13990d;

    /* renamed from: e */
    private final Context f13991e = com.martian.libmars.d.h.F().getApplicationContext();

    /* renamed from: f */
    private final o<E>.b<E> f13992f;

    /* renamed from: g */
    private o<E>.a<E> f13993g;

    class a<E> extends com.martian.libsupport.j<E> {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(java.lang.String r4, int r5, java.lang.Class<E> r6) {
            /*
                r2 = this;
                com.martian.mibook.lib.model.e.o.this = r3
                com.martian.libmars.d.h r3 = com.martian.libmars.d.h.F()
                android.content.Context r3 = r3.getApplicationContext()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = com.martian.mibook.lib.model.e.o.f13987a
                r0.append(r1)
                r0.append(r4)
                java.lang.String r0 = r0.toString()
                r2.<init>(r3, r0, r5, r6)
                boolean r3 = com.martian.libsupport.e.i(r1)     // Catch: java.lang.Exception -> L3b
                if (r3 == 0) goto L3b
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3b
                r3.<init>()     // Catch: java.lang.Exception -> L3b
                r3.append(r1)     // Catch: java.lang.Exception -> L3b
                r3.append(r4)     // Catch: java.lang.Exception -> L3b
                java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L3b
                r4 = 0
                android.database.sqlite.SQLiteDatabase r3 = android.database.sqlite.SQLiteDatabase.openOrCreateDatabase(r3, r4)     // Catch: java.lang.Exception -> L3b
                r3.close()     // Catch: java.lang.Exception -> L3b
            L3b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.lib.model.e.o.a.<init>(com.martian.mibook.lib.model.e.o, java.lang.String, int, java.lang.Class):void");
        }

        @Override // com.martian.libsupport.j, android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            o.this.l(db, oldVersion, newVersion);
        }
    }

    class b<E> extends com.martian.libsupport.j<E> {
        public b(String dbname, int version, Class<E> elemType) {
            super(com.martian.libmars.d.h.F().getApplicationContext(), dbname, version, elemType);
        }

        @Override // com.martian.libsupport.j, android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            o.this.l(db, oldVersion, newVersion);
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(com.martian.libmars.d.h.F().y());
        String str = File.separator;
        sb.append(str);
        sb.append("martian");
        sb.append(str);
        sb.append("mibook");
        sb.append(str);
        sb.append("store");
        sb.append(str);
        f13987a = sb.toString();
    }

    public o(String dbname, int version, Class<E> elemType) {
        this.f13988b = dbname;
        this.f13989c = version;
        this.f13990d = elemType;
        this.f13992f = new b<>(dbname, version, elemType);
    }

    private boolean e() {
        return com.martian.libsupport.permission.g.d(getContext(), com.kuaishou.weapon.p0.g.f9325j);
    }

    private void n() {
        if (e()) {
            try {
                SQLiteDatabase writableDatabase = c().getWritableDatabase();
                c().onCreate(writableDatabase);
                writableDatabase.close();
            } catch (Exception unused) {
            }
        }
    }

    public void a() {
        try {
            if (e()) {
                c().reset();
            }
        } catch (Exception unused) {
        }
        if (this.f13991e.getDatabasePath(this.f13988b).exists()) {
            this.f13992f.reset();
        }
    }

    public void b() {
        try {
            if (e()) {
                c().deleteDatabase();
            }
        } catch (Exception unused) {
        }
        this.f13992f.deleteDatabase();
    }

    public o<E>.a<E> c() {
        if (e() && this.f13993g == null) {
            this.f13993g = new a<>(this, this.f13988b, this.f13989c, this.f13990d);
        }
        return this.f13993g;
    }

    public String d() {
        return this.f13992f.getTableName();
    }

    public boolean delete(E data) {
        boolean delete = this.f13992f.delete(data);
        try {
            return e() ? c().delete(data) | delete : delete;
        } catch (Exception unused) {
            n();
            return delete;
        }
    }

    public int f(E data) {
        int i2;
        try {
            i2 = this.f13992f.insertOrUpdate((o<E>.b<E>) data);
            try {
                return e() ? Math.max(c().insertOrUpdate((o<E>.a<E>) data), i2) : i2;
            } catch (Exception e2) {
                e = e2;
                n();
                if ((e instanceof SQLiteFullException) && i2 == -1) {
                    return -2;
                }
                return i2;
            }
        } catch (Exception e3) {
            e = e3;
            i2 = -1;
        }
    }

    public long g(Collection<E> ces) {
        long j2;
        try {
            j2 = this.f13992f.insertOrUpdate((Collection) ces);
            try {
                return e() ? Math.max(c().insertOrUpdate((Collection) ces), j2) : j2;
            } catch (Exception e2) {
                e = e2;
                n();
                if ((e instanceof SQLiteFullException) && j2 == -1) {
                    return -2L;
                }
                return j2;
            }
        } catch (Exception e3) {
            e = e3;
            j2 = -1;
        }
    }

    public Context getContext() {
        return this.f13991e;
    }

    public boolean h(E data) {
        try {
            try {
                if (this.f13992f.load((o<E>.b<E>) data)) {
                    return true;
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            SQLiteDatabase writableDatabase = this.f13992f.getWritableDatabase();
            this.f13992f.onCreate(writableDatabase);
            writableDatabase.close();
        }
        try {
            if (e()) {
                return c().load((o<E>.a<E>) data);
            }
            return false;
        } catch (Exception unused3) {
            n();
            return false;
        }
    }

    public boolean i(Collection<E> ces) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean load = this.f13992f.load((Collection) arrayList);
        try {
            if (e()) {
                load |= c().load((Collection) arrayList2);
            }
        } catch (Exception unused) {
            n();
        }
        if (arrayList.size() > arrayList2.size()) {
            ces.addAll(arrayList);
        } else {
            ces.addAll(arrayList2);
        }
        return load;
    }

    public long insert(E data) {
        long j2;
        try {
            j2 = this.f13992f.insert((o<E>.b<E>) data) ? 1L : -1L;
        } catch (Exception e2) {
            e = e2;
            j2 = -1;
        }
        try {
            if (e()) {
                if (c().insert((o<E>.a<E>) data)) {
                    return 1L;
                }
            }
        } catch (Exception e3) {
            e = e3;
            n();
            if ((e instanceof SQLiteFullException) && j2 == -1) {
                return -2L;
            }
            return j2;
        }
        return j2;
    }

    public boolean j(Collection<E> ces, int offset, int size) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean load = this.f13992f.load(arrayList, offset, size);
        try {
            if (e()) {
                load |= c().load(arrayList2, offset, size);
            }
        } catch (Exception unused) {
            n();
        }
        if (arrayList.size() > arrayList2.size()) {
            ces.addAll(arrayList);
        } else {
            ces.addAll(arrayList2);
        }
        return load;
    }

    public void k(SQLiteDatabase db) {
        this.f13992f.onCreate(db);
    }

    public void l(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + d());
        }
        k(db);
    }

    public void m() {
        this.f13992f.reset();
        try {
            if (e()) {
                c().reset();
            }
        } catch (Exception unused) {
            n();
        }
    }

    public Cursor query(String selections, String[] selectArgs, String orderBy) {
        Cursor query = this.f13992f.query(selections, selectArgs, orderBy);
        try {
            if (e()) {
                Cursor query2 = c().query(selections, selectArgs, orderBy);
                if (query.getCount() > query2.getCount()) {
                    query2.close();
                    return query;
                }
                query.close();
                return query2;
            }
        } catch (Exception unused) {
            n();
        }
        return query;
    }

    public boolean update(E data) {
        try {
            boolean update = this.f13992f.update(data);
            return e() ? update | c().update(data) : update;
        } catch (Exception unused) {
            n();
            return false;
        }
    }
}
