package yb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import com.martian.libmars.common.ConfigSingleton;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes3.dex */
public class n<E> {

    /* renamed from: g */
    public static final String f33456g;

    /* renamed from: a */
    public final String f33457a;

    /* renamed from: b */
    public final int f33458b;

    /* renamed from: c */
    public final Class<E> f33459c;

    /* renamed from: d */
    public final Context f33460d = ConfigSingleton.D().getApplicationContext();

    /* renamed from: e */
    public final n<E>.b<E> f33461e;

    /* renamed from: f */
    public n<E>.a<E> f33462f;

    public class a<E> extends ba.k<E> {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(java.lang.String r4, int r5, java.lang.Class<E> r6) {
            /*
                r2 = this;
                yb.n.this = r3
                com.martian.libmars.common.ConfigSingleton r3 = com.martian.libmars.common.ConfigSingleton.D()
                android.content.Context r3 = r3.getApplicationContext()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = yb.n.f33456g
                r0.append(r1)
                r0.append(r4)
                java.lang.String r0 = r0.toString()
                r2.<init>(r3, r0, r5, r6)
                boolean r3 = ba.g.i(r1)     // Catch: java.lang.Exception -> L3b
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
            throw new UnsupportedOperationException("Method not decompiled: yb.n.a.<init>(yb.n, java.lang.String, int, java.lang.Class):void");
        }

        @Override // ba.k, android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            n.this.k(sQLiteDatabase, i10, i11);
        }
    }

    public class b<E> extends ba.k<E> {
        public b(String str, int i10, Class<E> cls) {
            super(ConfigSingleton.D().getApplicationContext(), str, i10, cls);
        }

        @Override // ba.k, android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            n.this.k(sQLiteDatabase, i10, i11);
        }
    }

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ConfigSingleton.D().z());
        String str = File.separator;
        sb2.append(str);
        sb2.append("martian");
        sb2.append(str);
        sb2.append("mibook");
        sb2.append(str);
        sb2.append("store");
        sb2.append(str);
        f33456g = sb2.toString();
    }

    public n(String str, int i10, Class<E> cls) {
        this.f33457a = str;
        this.f33458b = i10;
        this.f33459c = cls;
        this.f33461e = new b<>(str, i10, cls);
    }

    public void a() {
        try {
            if (ea.c.f(getContext())) {
                c().x();
            }
        } catch (Exception unused) {
        }
        if (this.f33460d.getDatabasePath(this.f33457a).exists()) {
            this.f33461e.x();
        }
    }

    public void b() {
        try {
            if (ea.c.f(getContext())) {
                c().i();
            }
        } catch (Exception unused) {
        }
        this.f33461e.i();
    }

    public n<E>.a<E> c() {
        if (ea.c.f(getContext()) && this.f33462f == null) {
            this.f33462f = new a<>(this, this.f33457a, this.f33458b, this.f33459c);
        }
        return this.f33462f;
    }

    public String d() {
        return this.f33461e.l();
    }

    public boolean delete(E e10) {
        boolean delete = this.f33461e.delete(e10);
        try {
            return ea.c.f(getContext()) ? delete | c().delete(e10) : delete;
        } catch (Exception unused) {
            o();
            return delete;
        }
    }

    public String e() {
        return this.f33461e.n();
    }

    public long f(E e10) {
        long j10;
        try {
            j10 = this.f33461e.q(e10);
        } catch (Exception e11) {
            e = e11;
            j10 = -1;
        }
        try {
            return ea.c.f(getContext()) ? Math.max(c().q(e10), j10) : j10;
        } catch (Exception e12) {
            e = e12;
            o();
            if ((e instanceof SQLiteFullException) && j10 == -1) {
                return -2L;
            }
            return j10;
        }
    }

    public long g(Collection<E> collection) {
        long j10;
        try {
            j10 = this.f33461e.r(collection);
        } catch (Exception e10) {
            e = e10;
            j10 = -1;
        }
        try {
            return ea.c.f(getContext()) ? Math.max(c().r(collection), j10) : j10;
        } catch (Exception e11) {
            e = e11;
            o();
            if ((e instanceof SQLiteFullException) && j10 == -1) {
                return -2L;
            }
            return j10;
        }
    }

    public Context getContext() {
        return this.f33460d;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Set<E> h(java.lang.String r4, java.util.List<java.lang.Object> r5) {
        /*
            r3 = this;
            r0 = 0
            yb.n<E>$b<E> r1 = r3.f33461e     // Catch: java.lang.Exception -> L18
            java.util.List r1 = r1.v(r4, r5)     // Catch: java.lang.Exception -> L18
            android.content.Context r2 = r3.f33460d     // Catch: java.lang.Exception -> L19
            boolean r2 = ea.c.f(r2)     // Catch: java.lang.Exception -> L19
            if (r2 == 0) goto L1c
            yb.n$a r2 = r3.c()     // Catch: java.lang.Exception -> L19
            java.util.List r0 = r2.v(r4, r5)     // Catch: java.lang.Exception -> L19
            goto L1c
        L18:
            r1 = r0
        L19:
            r3.o()
        L1c:
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            if (r1 == 0) goto L29
            if (r0 != 0) goto L29
            r4.addAll(r1)
            goto L4a
        L29:
            if (r1 != 0) goto L31
            if (r0 == 0) goto L31
            r4.addAll(r0)
            goto L4a
        L31:
            if (r1 == 0) goto L4a
            int r5 = r1.size()
            int r2 = r0.size()
            if (r5 < r2) goto L44
            r4.addAll(r1)
            r4.addAll(r0)
            goto L4a
        L44:
            r4.addAll(r0)
            r4.addAll(r1)
        L4a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: yb.n.h(java.lang.String, java.util.List):java.util.Set");
    }

    public boolean i(E e10) {
        try {
            try {
                if (this.f33461e.w(e10)) {
                    return true;
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            SQLiteDatabase writableDatabase = this.f33461e.getWritableDatabase();
            this.f33461e.onCreate(writableDatabase);
            writableDatabase.close();
        }
        try {
            if (ea.c.f(getContext())) {
                return c().w(e10);
            }
            return false;
        } catch (Exception unused3) {
            o();
            return false;
        }
    }

    public long insert(E e10) {
        long j10;
        try {
            j10 = this.f33461e.insert((n<E>.b<E>) e10) != -1 ? 1L : -1L;
            try {
                if (ea.c.f(getContext())) {
                    if (c().insert((n<E>.a<E>) e10) != -1) {
                        return 1L;
                    }
                }
            } catch (Exception e11) {
                e = e11;
                o();
                if ((e instanceof SQLiteFullException) && j10 == -1) {
                    return -2L;
                }
                return j10;
            }
        } catch (Exception e12) {
            e = e12;
            j10 = -1;
        }
        return j10;
    }

    public void j(SQLiteDatabase sQLiteDatabase) {
        this.f33461e.onCreate(sQLiteDatabase);
    }

    public void k(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 < i11) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + e());
        }
        j(sQLiteDatabase);
    }

    public void l() {
        this.f33461e.x();
        try {
            if (ea.c.f(getContext())) {
                c().x();
            }
        } catch (Exception unused) {
            o();
        }
    }

    public boolean m(Collection<E> collection) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z10 = false;
        try {
            z10 = this.f33461e.z(arrayList);
            if (ea.c.f(getContext())) {
                z10 |= c().z(arrayList2);
            }
        } catch (Exception unused) {
            o();
        }
        if (arrayList.size() > arrayList2.size()) {
            collection.addAll(arrayList);
        } else {
            collection.addAll(arrayList2);
        }
        return z10;
    }

    public boolean n(Collection<E> collection, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean A = this.f33461e.A(arrayList, i10, i11);
        try {
            if (ea.c.f(getContext())) {
                A |= c().A(arrayList2, i10, i11);
            }
        } catch (Exception unused) {
            o();
        }
        if (arrayList.size() > arrayList2.size()) {
            collection.addAll(arrayList);
        } else {
            collection.addAll(arrayList2);
        }
        return A;
    }

    public final void o() {
        try {
            if (ea.c.f(getContext())) {
                SQLiteDatabase writableDatabase = c().getWritableDatabase();
                c().onCreate(writableDatabase);
                writableDatabase.close();
            }
        } catch (Exception unused) {
        }
    }

    public Cursor query(String str, String[] strArr, String str2) {
        Cursor query = this.f33461e.query(str, strArr, str2);
        try {
            if (ea.c.f(getContext())) {
                Cursor query2 = c().query(str, strArr, str2);
                if (query.getCount() > query2.getCount()) {
                    query2.close();
                    return query;
                }
                query.close();
                return query2;
            }
        } catch (Exception unused) {
            o();
        }
        return query;
    }

    public boolean update(E e10) {
        try {
            boolean update = this.f33461e.update(e10);
            return ea.c.f(getContext()) ? update | c().update(e10) : update;
        } catch (Exception unused) {
            o();
            return false;
        }
    }
}
