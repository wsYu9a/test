package yb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import ba.k;
import com.martian.libmars.common.ConfigSingleton;
import java.io.File;
import java.util.Collection;

/* loaded from: classes3.dex */
public class m<E> {

    /* renamed from: e */
    public static final String f33449e;

    /* renamed from: a */
    public final String f33450a;

    /* renamed from: b */
    public final int f33451b;

    /* renamed from: c */
    public final Class<E> f33452c;

    /* renamed from: d */
    public final Context f33453d = ConfigSingleton.D().getApplicationContext();

    public class a<E> extends ba.k<E> {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(java.lang.String r4, int r5, java.lang.Class<E> r6) {
            /*
                r2 = this;
                yb.m.this = r3
                com.martian.libmars.common.ConfigSingleton r3 = com.martian.libmars.common.ConfigSingleton.D()
                android.content.Context r3 = r3.getApplicationContext()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = yb.m.f33449e
                r0.append(r1)
                r0.append(r4)
                java.lang.String r0 = r0.toString()
                r2.<init>(r3, r0, r5, r6)
                java.io.File r3 = new java.io.File     // Catch: java.lang.Exception -> L44
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L44
                r5.<init>()     // Catch: java.lang.Exception -> L44
                r5.append(r1)     // Catch: java.lang.Exception -> L44
                r5.append(r4)     // Catch: java.lang.Exception -> L44
                java.lang.String r4 = r5.toString()     // Catch: java.lang.Exception -> L44
                r3.<init>(r4)     // Catch: java.lang.Exception -> L44
                boolean r3 = ba.g.j(r3)     // Catch: java.lang.Exception -> L44
                if (r3 == 0) goto L44
                java.lang.String r3 = r2.k()     // Catch: java.lang.Exception -> L44
                r4 = 0
                android.database.sqlite.SQLiteDatabase r3 = android.database.sqlite.SQLiteDatabase.openOrCreateDatabase(r3, r4)     // Catch: java.lang.Exception -> L44
                r3.close()     // Catch: java.lang.Exception -> L44
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: yb.m.a.<init>(yb.m, java.lang.String, int, java.lang.Class):void");
        }
    }

    public class b<E> extends ba.k<E> {
        public b(String str, int i10, Class<E> cls) {
            super(ConfigSingleton.D().getApplicationContext(), str, i10, cls);
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
        sb2.append("databases");
        sb2.append(str);
        f33449e = sb2.toString();
    }

    public m(String str, int i10, Class<E> cls) {
        this.f33450a = str;
        this.f33451b = i10;
        this.f33452c = cls;
    }

    public void a() {
        if (ea.c.f(getContext())) {
            try {
                new a(this, this.f33450a, this.f33451b, this.f33452c).x();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        if (this.f33453d.getDatabasePath(this.f33450a).exists()) {
            new b(this.f33450a, this.f33451b, this.f33452c).x();
        }
    }

    public void b() {
        if (ea.c.f(getContext())) {
            try {
                new a(this, this.f33450a, this.f33451b, this.f33452c).i();
            } catch (Exception unused) {
            }
        }
        if (this.f33453d.getDatabasePath(this.f33450a).exists()) {
            new b(this.f33450a, this.f33451b, this.f33452c).i();
        }
    }

    public boolean c(E e10) {
        if (ea.c.e(getContext())) {
            a aVar = new a(this, this.f33450a, this.f33451b, this.f33452c);
            try {
                try {
                    if (aVar.j(e10)) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                aVar.onCreate(writableDatabase);
                writableDatabase.close();
            }
        }
        if (this.f33453d.getDatabasePath(this.f33450a).exists()) {
            return new b(this.f33450a, this.f33451b, this.f33452c).j(e10);
        }
        return false;
    }

    public long d() {
        if (ea.c.e(getContext())) {
            try {
                return new a(this, this.f33450a, this.f33451b, this.f33452c).m();
            } catch (Exception unused) {
            }
        }
        if (this.f33453d.getDatabasePath(this.f33450a).exists()) {
            return new b(this.f33450a, this.f33451b, this.f33452c).m();
        }
        return 0L;
    }

    public boolean delete(E e10) {
        if (ea.c.f(getContext())) {
            a aVar = new a(this, this.f33450a, this.f33451b, this.f33452c);
            try {
                try {
                    if (aVar.delete(e10)) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                aVar.onCreate(writableDatabase);
                writableDatabase.close();
            }
        }
        if (this.f33453d.getDatabasePath(this.f33450a).exists()) {
            return new b(this.f33450a, this.f33451b, this.f33452c).delete(e10);
        }
        return false;
    }

    public long e(E e10) {
        if (ea.c.f(getContext())) {
            a aVar = new a(this, this.f33450a, this.f33451b, this.f33452c);
            try {
                try {
                    return aVar.q(e10);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                aVar.onCreate(writableDatabase);
                writableDatabase.close();
            }
        }
        return new b(this.f33450a, this.f33451b, this.f33452c).q(e10);
    }

    public long f(Collection<E> collection) {
        if (ea.c.f(getContext())) {
            a aVar = new a(this, this.f33450a, this.f33451b, this.f33452c);
            try {
                try {
                    return aVar.r(collection);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                aVar.onCreate(writableDatabase);
                writableDatabase.close();
            }
        }
        return new b(this.f33450a, this.f33451b, this.f33452c).r(collection);
    }

    public long g(Collection<E> collection, k.j<E> jVar) {
        if (ea.c.f(getContext())) {
            a aVar = new a(this, this.f33450a, this.f33451b, this.f33452c);
            try {
                try {
                    return aVar.s(collection, jVar);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                aVar.onCreate(writableDatabase);
                writableDatabase.close();
            }
        }
        return new b(this.f33450a, this.f33451b, this.f33452c).s(collection, jVar);
    }

    public Context getContext() {
        return this.f33453d;
    }

    public boolean h(E e10) {
        if (ea.c.e(getContext())) {
            a aVar = new a(this, this.f33450a, this.f33451b, this.f33452c);
            try {
                try {
                    if (aVar.w(e10)) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                aVar.onCreate(writableDatabase);
                writableDatabase.close();
            }
        }
        if (this.f33453d.getDatabasePath(this.f33450a).exists()) {
            return new b(this.f33450a, this.f33451b, this.f33452c).w(e10);
        }
        return false;
    }

    public void i() {
        if (ea.c.f(getContext())) {
            a aVar = new a(this, this.f33450a, this.f33451b, this.f33452c);
            try {
                try {
                    aVar.x();
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                aVar.onCreate(writableDatabase);
                writableDatabase.close();
            }
        }
        if (this.f33453d.getDatabasePath(this.f33450a).exists()) {
            new b(this.f33450a, this.f33451b, this.f33452c).x();
        }
    }

    public long insert(E e10) {
        if (ea.c.f(getContext())) {
            a aVar = new a(this, this.f33450a, this.f33451b, this.f33452c);
            try {
                try {
                    return aVar.insert((a) e10);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                aVar.onCreate(writableDatabase);
                writableDatabase.close();
            }
        }
        return new b(this.f33450a, this.f33451b, this.f33452c).insert((b) e10);
    }

    public boolean j(Collection<E> collection) {
        if (ea.c.e(getContext())) {
            a aVar = new a(this, this.f33450a, this.f33451b, this.f33452c);
            try {
                try {
                    aVar.z(collection);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                aVar.onCreate(writableDatabase);
                writableDatabase.close();
            }
        }
        if (this.f33453d.getDatabasePath(this.f33450a).exists()) {
            return new b(this.f33450a, this.f33451b, this.f33452c).z(collection);
        }
        return false;
    }

    public boolean k(Collection<E> collection, int i10, int i11) {
        if (ea.c.e(getContext())) {
            a aVar = new a(this, this.f33450a, this.f33451b, this.f33452c);
            try {
                try {
                    aVar.A(collection, i10, i11);
                    if (collection.size() == i11) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                aVar.onCreate(writableDatabase);
                writableDatabase.close();
            }
        }
        if (this.f33453d.getDatabasePath(this.f33450a).exists()) {
            return new b(this.f33450a, this.f33451b, this.f33452c).A(collection, i10, i11 - collection.size());
        }
        return false;
    }

    public synchronized boolean l(Collection<E> collection, int i10, int i11, String str, String[] strArr, String str2) {
        if (ea.c.e(getContext())) {
            a aVar = new a(this, this.f33450a, this.f33451b, this.f33452c);
            try {
                try {
                    if (aVar.D(collection, i10, i11, str, strArr, str2)) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                aVar.onCreate(writableDatabase);
                writableDatabase.close();
            }
        }
        if (!this.f33453d.getDatabasePath(this.f33450a).exists()) {
            return false;
        }
        return new b(this.f33450a, this.f33451b, this.f33452c).D(collection, i10, i11, str, strArr, str2);
    }

    public Cursor query() {
        if (ea.c.e(getContext())) {
            try {
                Cursor query = new a(this, this.f33450a, this.f33451b, this.f33452c).query();
                File databasePath = this.f33453d.getDatabasePath(this.f33450a);
                if (query.getCount() <= 0 && databasePath.exists()) {
                    query.close();
                }
                return query;
            } catch (Exception unused) {
            }
        }
        return new b(this.f33450a, this.f33451b, this.f33452c).query();
    }

    public boolean update(E e10) {
        if (ea.c.f(getContext())) {
            a aVar = new a(this, this.f33450a, this.f33451b, this.f33452c);
            try {
                try {
                    return aVar.update(e10);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                aVar.onCreate(writableDatabase);
                writableDatabase.close();
            }
        }
        return new b(this.f33450a, this.f33451b, this.f33452c).update(e10);
    }

    public long insert(Collection<E> collection) {
        if (ea.c.f(getContext())) {
            a aVar = new a(this, this.f33450a, this.f33451b, this.f33452c);
            try {
                try {
                    return aVar.insert((Collection) collection);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                aVar.onCreate(writableDatabase);
                writableDatabase.close();
            }
        }
        return new b(this.f33450a, this.f33451b, this.f33452c).insert((Collection) collection);
    }
}
