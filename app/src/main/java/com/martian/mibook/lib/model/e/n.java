package com.martian.mibook.lib.model.e;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.martian.libsupport.j;
import java.io.File;
import java.util.Collection;

/* loaded from: classes3.dex */
public class n<E> {

    /* renamed from: a */
    public static final String f13980a;

    /* renamed from: b */
    private final String f13981b;

    /* renamed from: c */
    private final int f13982c;

    /* renamed from: d */
    private final Class<E> f13983d;

    /* renamed from: e */
    private final Context f13984e = com.martian.libmars.d.h.F().getApplicationContext();

    class a<E> extends com.martian.libsupport.j<E> {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(java.lang.String r4, int r5, java.lang.Class<E> r6) {
            /*
                r2 = this;
                com.martian.mibook.lib.model.e.n.this = r3
                com.martian.libmars.d.h r3 = com.martian.libmars.d.h.F()
                android.content.Context r3 = r3.getApplicationContext()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = com.martian.mibook.lib.model.e.n.f13980a
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
                boolean r3 = com.martian.libsupport.e.j(r3)     // Catch: java.lang.Exception -> L44
                if (r3 == 0) goto L44
                java.lang.String r3 = r2.getDBName()     // Catch: java.lang.Exception -> L44
                r4 = 0
                android.database.sqlite.SQLiteDatabase r3 = android.database.sqlite.SQLiteDatabase.openOrCreateDatabase(r3, r4)     // Catch: java.lang.Exception -> L44
                r3.close()     // Catch: java.lang.Exception -> L44
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.lib.model.e.n.a.<init>(com.martian.mibook.lib.model.e.n, java.lang.String, int, java.lang.Class):void");
        }
    }

    class b<E> extends com.martian.libsupport.j<E> {
        public b(String dbname, int version, Class<E> elemType) {
            super(com.martian.libmars.d.h.F().getApplicationContext(), dbname, version, elemType);
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
        sb.append("databases");
        sb.append(str);
        f13980a = sb.toString();
    }

    public n(String dbname, int version, Class<E> elemType) {
        this.f13981b = dbname;
        this.f13982c = version;
        this.f13983d = elemType;
    }

    private boolean e() {
        return com.martian.libsupport.permission.g.d(getContext(), com.kuaishou.weapon.p0.g.f9324i);
    }

    private boolean f() {
        return com.martian.libsupport.permission.g.d(getContext(), com.kuaishou.weapon.p0.g.f9325j);
    }

    public void a() {
        if (f()) {
            try {
                new a(this, this.f13981b, this.f13982c, this.f13983d).reset();
            } catch (Exception unused) {
            }
        }
        if (this.f13984e.getDatabasePath(this.f13981b).exists()) {
            new b(this.f13981b, this.f13982c, this.f13983d).reset();
        }
    }

    public void b() {
        if (f()) {
            try {
                new a(this, this.f13981b, this.f13982c, this.f13983d).deleteDatabase();
            } catch (Exception unused) {
            }
        }
        if (this.f13984e.getDatabasePath(this.f13981b).exists()) {
            new b(this.f13981b, this.f13982c, this.f13983d).deleteDatabase();
        }
    }

    public boolean c(E data) {
        if (e()) {
            a aVar = new a(this, this.f13981b, this.f13982c, this.f13983d);
            try {
                try {
                    if (aVar.exists(data)) {
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
        if (this.f13984e.getDatabasePath(this.f13981b).exists()) {
            return new b(this.f13981b, this.f13982c, this.f13983d).exists(data);
        }
        return false;
    }

    public long d() {
        if (e()) {
            try {
                return new a(this, this.f13981b, this.f13982c, this.f13983d).getRowCount();
            } catch (Exception unused) {
            }
        }
        if (this.f13984e.getDatabasePath(this.f13981b).exists()) {
            return new b(this.f13981b, this.f13982c, this.f13983d).getRowCount();
        }
        return 0L;
    }

    public boolean delete(E data) {
        if (f()) {
            a aVar = new a(this, this.f13981b, this.f13982c, this.f13983d);
            try {
                try {
                    if (aVar.delete(data)) {
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
        if (this.f13984e.getDatabasePath(this.f13981b).exists()) {
            return new b(this.f13981b, this.f13982c, this.f13983d).delete(data);
        }
        return false;
    }

    public int g(E data) {
        if (f()) {
            a aVar = new a(this, this.f13981b, this.f13982c, this.f13983d);
            try {
                try {
                    return aVar.insertOrUpdate((a) data);
                } catch (Exception unused) {
                    SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                    aVar.onCreate(writableDatabase);
                    writableDatabase.close();
                }
            } catch (Exception unused2) {
            }
        }
        return new b(this.f13981b, this.f13982c, this.f13983d).insertOrUpdate((b) data);
    }

    public Context getContext() {
        return this.f13984e;
    }

    public long h(Collection<E> ces) {
        if (f()) {
            a aVar = new a(this, this.f13981b, this.f13982c, this.f13983d);
            try {
                try {
                    return aVar.insertOrUpdate((Collection) ces);
                } catch (Exception unused) {
                    SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                    aVar.onCreate(writableDatabase);
                    writableDatabase.close();
                }
            } catch (Exception unused2) {
            }
        }
        return new b(this.f13981b, this.f13982c, this.f13983d).insertOrUpdate((Collection) ces);
    }

    public long i(Collection<E> ces, j.i<E> validator) {
        if (f()) {
            a aVar = new a(this, this.f13981b, this.f13982c, this.f13983d);
            try {
                try {
                    return aVar.insertOrUpdate(ces, validator);
                } catch (Exception unused) {
                    SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                    aVar.onCreate(writableDatabase);
                    writableDatabase.close();
                }
            } catch (Exception unused2) {
            }
        }
        return new b(this.f13981b, this.f13982c, this.f13983d).insertOrUpdate(ces, validator);
    }

    public boolean insert(E data) {
        if (f()) {
            a aVar = new a(this, this.f13981b, this.f13982c, this.f13983d);
            try {
                try {
                    return aVar.insert((a) data);
                } catch (Exception unused) {
                    SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                    aVar.onCreate(writableDatabase);
                    writableDatabase.close();
                }
            } catch (Exception unused2) {
            }
        }
        return new b(this.f13981b, this.f13982c, this.f13983d).insert((b) data);
    }

    public boolean j(E data) {
        if (e()) {
            a aVar = new a(this, this.f13981b, this.f13982c, this.f13983d);
            try {
                try {
                    if (aVar.load((a) data)) {
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
        if (this.f13984e.getDatabasePath(this.f13981b).exists()) {
            return new b(this.f13981b, this.f13982c, this.f13983d).load((b) data);
        }
        return false;
    }

    public boolean k(Collection<E> ces) {
        if (e()) {
            a aVar = new a(this, this.f13981b, this.f13982c, this.f13983d);
            try {
                try {
                    aVar.load((Collection) ces);
                } catch (Exception unused) {
                    SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                    aVar.onCreate(writableDatabase);
                    writableDatabase.close();
                }
            } catch (Exception unused2) {
            }
        }
        if (this.f13984e.getDatabasePath(this.f13981b).exists()) {
            return new b(this.f13981b, this.f13982c, this.f13983d).load((Collection) ces);
        }
        return false;
    }

    public boolean l(Collection<E> ces, int offset, int size) {
        if (e()) {
            a aVar = new a(this, this.f13981b, this.f13982c, this.f13983d);
            try {
                try {
                    aVar.load(ces, offset, size);
                    if (ces.size() == size) {
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
        if (this.f13984e.getDatabasePath(this.f13981b).exists()) {
            return new b(this.f13981b, this.f13982c, this.f13983d).load(ces, offset, size - ces.size());
        }
        return false;
    }

    public synchronized boolean m(Collection<E> ces, int offset, int size, String selection, String[] selectionArgs, String orderBy) {
        if (e()) {
            a aVar = new a(this, this.f13981b, this.f13982c, this.f13983d);
            try {
                try {
                    if (aVar.load(ces, offset, size, selection, selectionArgs, orderBy)) {
                        return true;
                    }
                } catch (Exception unused) {
                    SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                    aVar.onCreate(writableDatabase);
                    writableDatabase.close();
                }
            } catch (Exception unused2) {
            }
        }
        if (!this.f13984e.getDatabasePath(this.f13981b).exists()) {
            return false;
        }
        return new b(this.f13981b, this.f13982c, this.f13983d).load(ces, offset, size, selection, selectionArgs, orderBy);
    }

    public void n() {
        if (f()) {
            a aVar = new a(this, this.f13981b, this.f13982c, this.f13983d);
            try {
                try {
                    aVar.reset();
                } catch (Exception unused) {
                    SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                    aVar.onCreate(writableDatabase);
                    writableDatabase.close();
                }
            } catch (Exception unused2) {
            }
        }
        if (this.f13984e.getDatabasePath(this.f13981b).exists()) {
            new b(this.f13981b, this.f13982c, this.f13983d).reset();
        }
    }

    public Cursor query() {
        if (e()) {
            try {
                Cursor query = new a(this, this.f13981b, this.f13982c, this.f13983d).query();
                File databasePath = this.f13984e.getDatabasePath(this.f13981b);
                if (query.getCount() <= 0 && databasePath.exists()) {
                    query.close();
                }
                return query;
            } catch (Exception unused) {
            }
        }
        return new b(this.f13981b, this.f13982c, this.f13983d).query();
    }

    public boolean update(E data) {
        if (f()) {
            a aVar = new a(this, this.f13981b, this.f13982c, this.f13983d);
            try {
                try {
                    return aVar.update(data);
                } catch (Exception unused) {
                    SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                    aVar.onCreate(writableDatabase);
                    writableDatabase.close();
                }
            } catch (Exception unused2) {
            }
        }
        return new b(this.f13981b, this.f13982c, this.f13983d).update(data);
    }

    public long insert(Collection<E> ces) {
        if (f()) {
            a aVar = new a(this, this.f13981b, this.f13982c, this.f13983d);
            try {
                try {
                    return aVar.insert((Collection) ces);
                } catch (Exception unused) {
                    SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                    aVar.onCreate(writableDatabase);
                    writableDatabase.close();
                }
            } catch (Exception unused2) {
            }
        }
        return new b(this.f13981b, this.f13982c, this.f13983d).insert((Collection) ces);
    }
}
