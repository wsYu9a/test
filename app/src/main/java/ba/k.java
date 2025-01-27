package ba;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class k<E> extends SQLiteOpenHelper implements Iterable<E> {

    /* renamed from: h */
    public static final String f1476h = "k";

    /* renamed from: i */
    public static final long f1477i = 1;

    /* renamed from: j */
    public static final long f1478j = 2;

    /* renamed from: k */
    public static final long f1479k = -1;

    /* renamed from: l */
    public static final long f1480l = -2;

    /* renamed from: b */
    public final Class<E> f1481b;

    /* renamed from: c */
    public final String f1482c;

    /* renamed from: d */
    public String f1483d;

    /* renamed from: e */
    public Map<String, Field> f1484e;

    /* renamed from: f */
    public final Context f1485f;

    /* renamed from: g */
    public final String f1486g;

    @Target({ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
    }

    @Target({ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        String name() default "";
    }

    public class c implements Iterator<E> {

        /* renamed from: b */
        public boolean f1487b;

        /* renamed from: c */
        public final Cursor f1488c;

        public c(Cursor cursor) {
            this.f1488c = cursor;
            this.f1487b = cursor.moveToFirst();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1487b;
        }

        @Override // java.util.Iterator
        public E next() {
            E e10 = null;
            try {
                e10 = (E) k.this.f1481b.newInstance();
                k.this.F(e10, this.f1488c);
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
            } catch (InstantiationException e12) {
                e12.printStackTrace();
            }
            boolean moveToNext = this.f1488c.moveToNext();
            this.f1487b = moveToNext;
            if (!moveToNext) {
                this.f1488c.close();
            }
            return e10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static class d {

        /* renamed from: a */
        public String f1490a;

        /* renamed from: b */
        public Long f1491b;

        public d() {
        }

        public d(String str, Long l10) {
            this.f1490a = str;
            this.f1491b = l10;
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface e {
        String columns();

        String name();
    }

    @Target({ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface f {
        boolean ascend() default true;

        int index() default 0;
    }

    @Target({ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface g {
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface h {
        String name();
    }

    @Target({ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface i {
    }

    public interface j<E> {
        boolean a(E e10);
    }

    public k(Context context, String str, int i10, Class<E> cls) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
        this.f1486g = str;
        this.f1481b = cls;
        this.f1482c = y(cls);
        this.f1485f = context;
        c();
        try {
            J(i10, context);
        } catch (Exception unused) {
        }
        try {
            File databasePath = getContext().getDatabasePath(str);
            if (databasePath.exists()) {
                databasePath.setLastModified(System.currentTimeMillis());
            }
        } catch (Exception unused2) {
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                file.setLastModified(System.currentTimeMillis());
            }
        } catch (Exception unused3) {
        }
    }

    public static <T> void G(Map<String, Field> map, T t10, Cursor cursor) {
        for (Map.Entry<String, Field> entry : map.entrySet()) {
            Field value = entry.getValue();
            String key = entry.getKey();
            Class<?> type = value.getType();
            if (type == Integer.TYPE || type == Long.TYPE || type == Boolean.TYPE) {
                throw new UnknownError("Field type can not be int or long.");
            }
            String string = cursor.getString(cursor.getColumnIndex(key));
            if (string != null && !TextUtils.isEmpty(string)) {
                if (type == Integer.class) {
                    try {
                        value.set(t10, Integer.valueOf(Integer.parseInt(string)));
                    } catch (IllegalAccessException e10) {
                        e10.printStackTrace();
                    }
                } else if (type == Boolean.class) {
                    value.set(t10, Boolean.valueOf(Integer.parseInt(string) > 0));
                } else if (type == Long.class) {
                    value.set(t10, Long.valueOf(Long.parseLong(string)));
                } else if (type == String.class) {
                    value.set(t10, string);
                } else {
                    if (type != Date.class) {
                        throw new RuntimeException("Unprocessed field type: " + type.getName());
                    }
                    value.set(t10, new Date(Long.parseLong(string)));
                }
                e10.printStackTrace();
            }
        }
    }

    public static Map<String, Field> b(Class<?> cls) {
        Hashtable hashtable = new Hashtable();
        Iterator<Field> it = ba.i.a(cls).iterator();
        while (it.hasNext()) {
            Field next = it.next();
            next.setAccessible(true);
            b bVar = (b) next.getAnnotation(b.class);
            if (bVar != null) {
                String name = bVar.name();
                if (l.q(name)) {
                    name = next.getName();
                }
                hashtable.put(name, next);
            }
        }
        return hashtable;
    }

    public static <T> T h(Class<T> cls, Cursor cursor) {
        Map<String, Field> b10 = b(cls);
        try {
            T newInstance = cls.newInstance();
            G(b10, newInstance, cursor);
            return newInstance;
        } catch (IllegalAccessException unused) {
            throw new IllegalStateException("Missing default constructor.");
        } catch (InstantiationException unused2) {
            throw new IllegalStateException("Missing default constructor.");
        }
    }

    private Cursor query(SQLiteDatabase sQLiteDatabase, Collection<String> collection, String str, ArrayList<String> arrayList) {
        return sQLiteDatabase.query(this.f1482c, (String[]) collection.toArray(new String[collection.size()]), str, arrayList == null ? null : (String[]) arrayList.toArray(new String[arrayList.size()]), null, null, null);
    }

    public boolean A(Collection<E> collection, int i10, int i11) {
        return C(collection, i10, i11, null, null);
    }

    public boolean B(Collection<E> collection, int i10, int i11, String str, ArrayList<String> arrayList) {
        return C(collection, i10, i11, str, (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public synchronized boolean C(Collection<E> collection, int i10, int i11, String str, String[] strArr) {
        String str2;
        try {
            TreeMap treeMap = new TreeMap();
            for (Map.Entry<String, Field> entry : this.f1484e.entrySet()) {
                Field value = entry.getValue();
                String key = entry.getKey();
                f fVar = (f) value.getAnnotation(f.class);
                if (fVar != null) {
                    Integer valueOf = Integer.valueOf(fVar.index());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(key);
                    sb2.append(fVar.ascend() ? " ASC" : " DESC");
                    treeMap.put(valueOf, sb2.toString());
                }
            }
            if (treeMap.size() != 0) {
                StringBuilder sb3 = new StringBuilder();
                Iterator<E> it = treeMap.entrySet().iterator();
                while (it.hasNext()) {
                    sb3.append((String) ((Map.Entry) it.next()).getValue());
                    sb3.append(",");
                }
                str2 = sb3.substring(0, sb3.length() - 1);
            } else {
                str2 = null;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return D(collection, i10, i11, str, strArr, str2);
    }

    public synchronized boolean D(Collection<E> collection, int i10, int i11, String str, String[] strArr, String str2) {
        String str3;
        if (i11 > 0) {
            try {
                str3 = i10 + "," + i11;
            } catch (Throwable th2) {
                throw th2;
            }
        } else {
            str3 = null;
        }
        String str4 = str3;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor query = query(readableDatabase, this.f1484e.keySet(), str, strArr, str2, str4);
        if (query.moveToFirst()) {
            do {
                try {
                    E newInstance = this.f1481b.newInstance();
                    F(newInstance, query);
                    collection.add(newInstance);
                } catch (IllegalAccessException e10) {
                    e = e10;
                    e.printStackTrace();
                    query.close();
                    readableDatabase.close();
                    return false;
                } catch (InstantiationException e11) {
                    e = e11;
                    e.printStackTrace();
                    query.close();
                    readableDatabase.close();
                    return false;
                }
            } while (query.moveToNext());
        }
        query.close();
        readableDatabase.close();
        return true;
    }

    public boolean E(Collection<E> collection, Cursor cursor) {
        if (!cursor.moveToFirst()) {
            return true;
        }
        do {
            try {
                E newInstance = this.f1481b.newInstance();
                F(newInstance, cursor);
                collection.add(newInstance);
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
                return false;
            } catch (InstantiationException e11) {
                e11.printStackTrace();
                return false;
            }
        } while (cursor.moveToNext());
        return true;
    }

    public void F(E e10, Cursor cursor) {
        for (Map.Entry<String, Field> entry : this.f1484e.entrySet()) {
            Field value = entry.getValue();
            String key = entry.getKey();
            Class<?> type = value.getType();
            if (type == Integer.TYPE || type == Long.TYPE || type == Boolean.TYPE) {
                throw new UnknownError("Field type can not be int or long.");
            }
            String string = cursor.getString(cursor.getColumnIndex(key));
            if (string != null && !TextUtils.isEmpty(string)) {
                if (type == Integer.class) {
                    try {
                        value.set(e10, Integer.valueOf(Integer.parseInt(string)));
                    } catch (IllegalAccessException e11) {
                        e11.printStackTrace();
                    }
                } else if (type == Boolean.class) {
                    value.set(e10, Boolean.valueOf(Integer.parseInt(string) > 0));
                } else if (type == Long.class) {
                    value.set(e10, Long.valueOf(Long.parseLong(string)));
                } else if (type == String.class) {
                    value.set(e10, string);
                } else {
                    if (type != Date.class) {
                        throw new RuntimeException("Unprocessed field type: " + type.getName());
                    }
                    value.set(e10, new Date(Long.parseLong(string)));
                }
                e11.printStackTrace();
            }
        }
    }

    public final void H(Context context, int i10) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(this.f1482c + "_version", i10);
        edit.commit();
    }

    public synchronized long I(String str, String str2, ArrayList<String> arrayList) {
        long j10;
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor rawQuery = readableDatabase.rawQuery("SELECT SUM(" + str + ") FROM " + this.f1482c + " WHERE " + str2, (String[]) arrayList.toArray(new String[arrayList.size()]));
            j10 = rawQuery.moveToFirst() ? rawQuery.getLong(0) : 0L;
            rawQuery.close();
            readableDatabase.close();
        } catch (Throwable th2) {
            throw th2;
        }
        return j10;
    }

    public final void J(int i10, Context context) {
        int o10 = o(context);
        if (i10 == 0) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            onCreate(writableDatabase);
            writableDatabase.close();
        } else if (i10 > o10) {
            SQLiteDatabase writableDatabase2 = getWritableDatabase();
            onUpgrade(writableDatabase2, o10, i10);
            writableDatabase2.close();
        }
        if (o10 != i10) {
            H(context, i10);
        }
    }

    public final void c() {
        this.f1484e = new Hashtable();
        Iterator<Field> it = ba.i.a(this.f1481b).iterator();
        while (it.hasNext()) {
            Field next = it.next();
            next.setAccessible(true);
            b bVar = (b) next.getAnnotation(b.class);
            if (bVar != null) {
                String name = bVar.name();
                if (l.q(name)) {
                    name = next.getName();
                }
                this.f1484e.put(name, next);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0039 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.content.ContentValues d(E r7) {
        /*
            r6 = this;
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.util.Map<java.lang.String, java.lang.reflect.Field> r1 = r6.f1484e
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        Lf:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L99
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            java.lang.reflect.Field r3 = (java.lang.reflect.Field) r3
            java.lang.Object r2 = r2.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r3.get(r7)     // Catch: java.lang.IllegalAccessException -> L2c java.lang.IllegalArgumentException -> L31
            goto L36
        L2c:
            r4 = move-exception
            r4.printStackTrace()
            goto L35
        L31:
            r4 = move-exception
            r4.printStackTrace()
        L35:
            r4 = 0
        L36:
            if (r4 != 0) goto L39
            goto Lf
        L39:
            java.lang.Class r3 = r3.getType()
            java.lang.Class r5 = java.lang.Integer.TYPE
            if (r3 == r5) goto L91
            java.lang.Class r5 = java.lang.Long.TYPE
            if (r3 == r5) goto L91
            java.lang.Class r5 = java.lang.Boolean.TYPE
            if (r3 == r5) goto L91
            java.lang.Class<java.lang.Integer> r5 = java.lang.Integer.class
            if (r3 != r5) goto L53
            java.lang.Integer r4 = (java.lang.Integer) r4
            r0.put(r2, r4)
            goto Lf
        L53:
            java.lang.Class<java.lang.Boolean> r5 = java.lang.Boolean.class
            if (r3 != r5) goto L65
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r3 = r4.booleanValue()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.put(r2, r3)
            goto Lf
        L65:
            java.lang.Class<java.lang.Long> r5 = java.lang.Long.class
            if (r3 != r5) goto L6f
            java.lang.Long r4 = (java.lang.Long) r4
            r0.put(r2, r4)
            goto Lf
        L6f:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            if (r3 != r5) goto L79
            java.lang.String r4 = (java.lang.String) r4
            r0.put(r2, r4)
            goto Lf
        L79:
            java.lang.Class<java.util.Date> r5 = java.util.Date.class
            if (r3 != r5) goto L8b
            java.util.Date r4 = (java.util.Date) r4
            long r3 = r4.getTime()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r0.put(r2, r3)
            goto Lf
        L8b:
            java.lang.UnknownError r7 = new java.lang.UnknownError
            r7.<init>()
            throw r7
        L91:
            java.lang.UnknownError r7 = new java.lang.UnknownError
            java.lang.String r0 = "Field type can not be int or long."
            r7.<init>(r0)
            throw r7
        L99:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ba.k.d(java.lang.Object):android.content.ContentValues");
    }

    public synchronized boolean delete(String str, String[] strArr) {
        int delete;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        delete = writableDatabase.delete(this.f1482c, str, strArr);
        writableDatabase.close();
        return delete > 0;
    }

    public final List<String> e() {
        LinkedList linkedList = new LinkedList();
        e eVar = (e) this.f1481b.getAnnotation(e.class);
        if (eVar != null) {
            linkedList.add("CREATE INDEX " + eVar.name() + " ON " + this.f1482c + "(" + eVar.columns() + ")");
        }
        Iterator<Field> it = ba.i.a(this.f1481b).iterator();
        while (it.hasNext()) {
            Field next = it.next();
            e eVar2 = (e) next.getAnnotation(e.class);
            if (eVar2 != null) {
                String name = eVar2.name();
                if (l.q(name)) {
                    name = next.getName();
                }
                String columns = eVar2.columns();
                if (l.q(columns)) {
                    columns = next.getName();
                }
                linkedList.add("CREATE INDEX " + name + " ON " + this.f1482c + "(" + columns + ")");
            }
        }
        return linkedList;
    }

    public final String f() {
        StringBuilder sb2 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb2.append(this.f1482c);
        sb2.append(" (");
        Iterator<Field> it = ba.i.a(this.f1481b).iterator();
        while (it.hasNext()) {
            Field next = it.next();
            b bVar = (b) next.getAnnotation(b.class);
            if (bVar != null) {
                String name = bVar.name();
                if (l.q(name)) {
                    name = next.getName();
                }
                Class<?> type = next.getType();
                if (type == Integer.TYPE || type == Long.TYPE || type == Boolean.TYPE) {
                    throw new UnknownError("Field type can not be int or long.");
                }
                if (type == Integer.class) {
                    sb2.append(name);
                    sb2.append(" Integer ");
                } else if (type == Boolean.class) {
                    sb2.append(name);
                    sb2.append(" Integer ");
                } else if (type == Long.class) {
                    sb2.append(name);
                    sb2.append(" Integer ");
                } else if (type == String.class) {
                    sb2.append(name);
                    sb2.append(" Text ");
                } else {
                    if (type != Date.class) {
                        throw new RuntimeException("Unprocessed field type: " + type.getName());
                    }
                    sb2.append(name);
                    sb2.append(" Integer ");
                }
                if (((a) next.getAnnotation(a.class)) != null) {
                    sb2.append(" primary key autoincrement ");
                } else if (((g) next.getAnnotation(g.class)) != null) {
                    sb2.append(" primary key ");
                } else if (((i) next.getAnnotation(i.class)) != null) {
                    sb2.append(" UNIQUE ");
                }
                sb2.append(",");
            }
        }
        sb2.setCharAt(sb2.length() - 1, ')');
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x000f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String[] g(E r7, java.lang.StringBuffer r8) {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Class<E> r1 = r6.f1481b
            java.util.ArrayList r1 = ba.i.a(r1)
            java.util.Iterator r1 = r1.iterator()
        Lf:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto Lce
            java.lang.Object r2 = r1.next()
            java.lang.reflect.Field r2 = (java.lang.reflect.Field) r2
            r3 = 1
            r2.setAccessible(r3)
            java.lang.Class<ba.k$b> r3 = ba.k.b.class
            java.lang.annotation.Annotation r3 = r2.getAnnotation(r3)
            ba.k$b r3 = (ba.k.b) r3
            if (r3 != 0) goto L2a
            goto Lf
        L2a:
            java.lang.Class<ba.k$g> r4 = ba.k.g.class
            java.lang.annotation.Annotation r4 = r2.getAnnotation(r4)
            ba.k$g r4 = (ba.k.g) r4
            java.lang.Class<ba.k$i> r5 = ba.k.i.class
            java.lang.annotation.Annotation r5 = r2.getAnnotation(r5)
            ba.k$i r5 = (ba.k.i) r5
            if (r4 != 0) goto L3f
            if (r5 != 0) goto L3f
            goto Lf
        L3f:
            java.lang.String r3 = r3.name()
            boolean r4 = ba.l.q(r3)
            if (r4 == 0) goto L4d
            java.lang.String r3 = r2.getName()
        L4d:
            java.lang.Object r4 = r2.get(r7)     // Catch: java.lang.IllegalAccessException -> L52 java.lang.IllegalArgumentException -> L57
            goto L5c
        L52:
            r4 = move-exception
            r4.printStackTrace()
            goto L5b
        L57:
            r4 = move-exception
            r4.printStackTrace()
        L5b:
            r4 = 0
        L5c:
            if (r4 != 0) goto L5f
            goto Lf
        L5f:
            java.lang.Class r2 = r2.getType()
            java.lang.Class r5 = java.lang.Integer.TYPE
            if (r2 == r5) goto Lc6
            java.lang.Class r5 = java.lang.Long.TYPE
            if (r2 == r5) goto Lc6
            java.lang.Class<java.lang.Integer> r5 = java.lang.Integer.class
            if (r2 != r5) goto L77
            java.lang.String r2 = java.lang.String.valueOf(r4)
            r0.add(r2)
            goto Lb6
        L77:
            java.lang.Class<java.lang.Boolean> r5 = java.lang.Boolean.class
            if (r2 != r5) goto L89
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r2 = r4.booleanValue()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r0.add(r2)
            goto Lb6
        L89:
            java.lang.Class<java.lang.Long> r5 = java.lang.Long.class
            if (r2 != r5) goto L95
            java.lang.String r2 = java.lang.String.valueOf(r4)
            r0.add(r2)
            goto Lb6
        L95:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            if (r2 != r5) goto La5
            java.lang.String r4 = (java.lang.String) r4
            boolean r2 = ba.l.q(r4)
            if (r2 != 0) goto Lb6
            r0.add(r4)
            goto Lb6
        La5:
            java.lang.Class<java.util.Date> r5 = java.util.Date.class
            if (r2 != r5) goto Lc0
            java.util.Date r4 = (java.util.Date) r4
            long r4 = r4.getTime()
            java.lang.String r2 = java.lang.String.valueOf(r4)
            r0.add(r2)
        Lb6:
            r8.append(r3)
            java.lang.String r2 = "=? AND "
            r8.append(r2)
            goto Lf
        Lc0:
            java.lang.UnknownError r7 = new java.lang.UnknownError
            r7.<init>()
            throw r7
        Lc6:
            java.lang.UnknownError r7 = new java.lang.UnknownError
            java.lang.String r8 = "Field type can not be int or long."
            r7.<init>(r8)
            throw r7
        Lce:
            int r7 = r8.length()
            if (r7 <= 0) goto Le1
            int r7 = r8.length()
            int r7 = r7 + (-5)
            int r1 = r8.length()
            r8.delete(r7, r1)
        Le1:
            int r7 = r0.size()
            java.lang.String[] r7 = new java.lang.String[r7]
            java.lang.Object[] r7 = r0.toArray(r7)
            java.lang.String[] r7 = (java.lang.String[]) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ba.k.g(java.lang.Object, java.lang.StringBuffer):java.lang.String[]");
    }

    public Context getContext() {
        return this.f1485f;
    }

    public void i() {
        this.f1485f.deleteDatabase(k());
    }

    public synchronized long insert(E e10) {
        ContentValues d10 = d(e10);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                try {
                    long insertWithOnConflict = writableDatabase.insertWithOnConflict(this.f1482c, null, d10, 1);
                    writableDatabase.close();
                    return insertWithOnConflict;
                } catch (Exception e11) {
                    e = e11;
                    sQLiteDatabase = writableDatabase;
                    Log.w("SqliteDao", "Insert failed: " + e.getMessage());
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return -1L;
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = writableDatabase;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e12) {
            e = e12;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
    
        r2 = r6.name();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        if (ba.l.q(r2) == false) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        r2 = r3.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
    
        r4 = r3.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0051, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0052, code lost:
    
        r9.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x004c, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x004d, code lost:
    
        r9.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e5 A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:5:0x000e, B:7:0x0016, B:10:0x002a, B:16:0x0035, B:18:0x003f, B:20:0x0047, B:25:0x0059, B:27:0x0061, B:31:0x0069, B:32:0x00ad, B:36:0x00d3, B:38:0x00e5, B:41:0x00ed, B:48:0x0074, B:51:0x0085, B:54:0x0090, B:56:0x0098, B:61:0x00a1, B:62:0x00bf, B:63:0x00c4, B:64:0x00c5, B:65:0x00cc, B:70:0x004d, B:68:0x0052), top: B:3:0x0002, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ed A[Catch: all -> 0x0044, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:5:0x000e, B:7:0x0016, B:10:0x002a, B:16:0x0035, B:18:0x003f, B:20:0x0047, B:25:0x0059, B:27:0x0061, B:31:0x0069, B:32:0x00ad, B:36:0x00d3, B:38:0x00e5, B:41:0x00ed, B:48:0x0074, B:51:0x0085, B:54:0x0090, B:56:0x0098, B:61:0x00a1, B:62:0x00bf, B:63:0x00c4, B:64:0x00c5, B:65:0x00cc, B:70:0x004d, B:68:0x0052), top: B:3:0x0002, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean j(E r9) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ba.k.j(java.lang.Object):boolean");
    }

    public String k() {
        return this.f1486g;
    }

    public String l() {
        for (Map.Entry<String, Field> entry : this.f1484e.entrySet()) {
            Field value = entry.getValue();
            value.setAccessible(true);
            if (((b) value.getAnnotation(b.class)) != null && value.getAnnotation(g.class) != null) {
                return entry.getKey();
            }
        }
        return null;
    }

    public synchronized long m() {
        long queryNumEntries;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        try {
            queryNumEntries = DatabaseUtils.queryNumEntries(readableDatabase, this.f1482c);
            if (readableDatabase != null) {
                readableDatabase.close();
            }
        } finally {
        }
        return queryNumEntries;
    }

    public String n() {
        return this.f1482c;
    }

    public final int o(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(this.f1482c + "_version", 0);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f());
        Iterator<String> it = e().iterator();
        while (it.hasNext()) {
            try {
                sQLiteDatabase.execSQL(it.next());
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.f1482c);
        onCreate(sQLiteDatabase);
    }

    public synchronized List<d> p(String str, boolean z10, String str2, ArrayList<String> arrayList) {
        String str3;
        ArrayList arrayList2;
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SELECT ");
            sb2.append(str);
            sb2.append(", COUNT(*) AS gsum FROM ");
            sb2.append(this.f1482c);
            sb2.append(" GROUP BY ");
            sb2.append(str);
            sb2.append(" ORDER BY gsum ");
            sb2.append(z10 ? " ASC" : " DESC");
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = " WHERE " + str2;
            }
            sb2.append(str3);
            arrayList2 = null;
            Cursor rawQuery = readableDatabase.rawQuery(sb2.toString(), arrayList == null ? null : (String[]) arrayList.toArray(new String[arrayList.size()]));
            if (rawQuery.moveToFirst()) {
                arrayList2 = new ArrayList(rawQuery.getCount());
                do {
                    d dVar = new d();
                    dVar.f1490a = rawQuery.getString(0);
                    dVar.f1491b = Long.valueOf(rawQuery.getLong(1));
                    arrayList2.add(dVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            readableDatabase.close();
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return arrayList2;
    }

    public synchronized long q(E e10) {
        ContentValues d10 = d(e10);
        long j10 = -1;
        if (d10.size() == 0) {
            return -1L;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                try {
                    long insertWithOnConflict = writableDatabase.insertWithOnConflict(this.f1482c, null, d10, 5);
                    writableDatabase.close();
                    return insertWithOnConflict;
                } catch (SQLException unused) {
                    sQLiteDatabase = writableDatabase;
                    StringBuffer stringBuffer = new StringBuffer();
                    String[] g10 = g(e10, stringBuffer);
                    if (sQLiteDatabase != null) {
                        try {
                            if (sQLiteDatabase.update(this.f1482c, d10, stringBuffer.toString(), g10) > 0) {
                                j10 = 2;
                            }
                        } catch (Exception unused2) {
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return j10;
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = writableDatabase;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (SQLException unused3) {
        }
    }

    public synchronized long r(Collection<E> collection) {
        long j10 = 0;
        if (collection != null) {
            if (collection.size() != 0) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (E e10 : collection) {
                        ContentValues d10 = d(e10);
                        try {
                        } catch (SQLException unused) {
                            StringBuffer stringBuffer = new StringBuffer();
                            if (writableDatabase.update(this.f1482c, d10, stringBuffer.toString(), g(e10, stringBuffer)) > 0) {
                            }
                        }
                        if (writableDatabase.insertWithOnConflict(this.f1482c, null, d10, 5) != -1) {
                            j10++;
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    return j10;
                } finally {
                    writableDatabase.endTransaction();
                    writableDatabase.close();
                }
            }
        }
        return 0L;
    }

    public synchronized long s(Collection<E> collection, j<E> jVar) {
        long j10 = 0;
        if (collection != null) {
            if (collection.size() != 0) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    Iterator<E> it = collection.iterator();
                    while (it.hasNext()) {
                        E next = it.next();
                        if (jVar.a(next)) {
                            ContentValues d10 = d(next);
                            try {
                                return writableDatabase.insertWithOnConflict(this.f1482c, null, d10, 5);
                            } catch (SQLException unused) {
                                StringBuffer stringBuffer = new StringBuffer();
                                if (writableDatabase.update(this.f1482c, d10, stringBuffer.toString(), g(next, stringBuffer)) > 0) {
                                    j10++;
                                }
                            }
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    return j10;
                } finally {
                    writableDatabase.endTransaction();
                    writableDatabase.close();
                }
            }
        }
        return 0L;
    }

    @Override // java.lang.Iterable
    /* renamed from: t */
    public k<E>.c iterator() {
        return u(null, null);
    }

    public k<E>.c u(String str, String[] strArr) {
        return new c(query(str, strArr));
    }

    public synchronized boolean update(E e10) {
        boolean z10;
        ContentValues d10 = d(e10);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        z10 = writableDatabase.update(this.f1482c, d10, stringBuffer.toString(), g(e10, stringBuffer)) > 0;
        writableDatabase.close();
        return z10;
    }

    public List<E> v(String str, List<?> list) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        ArrayList arrayList = new ArrayList(list.size());
        int i10 = 0;
        while (i10 < list.size()) {
            StringBuilder sb2 = new StringBuilder();
            ArrayList arrayList2 = new ArrayList();
            int i11 = i10 + 100;
            for (Object obj : list.subList(i10, Math.min(i11, list.size()))) {
                sb2.append(str);
                sb2.append(" = ? OR ");
                if (obj != null) {
                    Class<?> cls = obj.getClass();
                    if (cls == Integer.class) {
                        arrayList2.add(String.valueOf(obj));
                    } else if (cls == Boolean.class) {
                        arrayList2.add(String.valueOf(((Boolean) obj).booleanValue() ? 1 : 0));
                    } else if (cls == Long.class) {
                        arrayList2.add(String.valueOf(obj));
                    } else if (cls == String.class) {
                        String str2 = (String) obj;
                        if (!l.q(str2)) {
                            arrayList2.add(str2);
                        }
                    } else {
                        if (cls != Date.class) {
                            throw new UnknownError();
                        }
                        arrayList2.add(String.valueOf(((Date) obj).getTime()));
                    }
                }
            }
            if (sb2.length() > 0) {
                sb2.delete(sb2.length() - 4, sb2.length());
            }
            Cursor query = query(readableDatabase, this.f1484e.keySet(), sb2.toString(), (ArrayList<String>) arrayList2);
            if (query.moveToFirst()) {
                do {
                    try {
                        E newInstance = this.f1481b.newInstance();
                        F(newInstance, query);
                        arrayList.add(newInstance);
                    } catch (IllegalAccessException | InstantiationException e10) {
                        e10.printStackTrace();
                        query.close();
                        readableDatabase.close();
                        return arrayList;
                    }
                } while (query.moveToNext());
            }
            query.close();
            i10 = i11;
        }
        readableDatabase.close();
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0043 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean w(E r8) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ba.k.w(java.lang.Object):boolean");
    }

    public synchronized void x() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        onUpgrade(writableDatabase, 0, 0);
        writableDatabase.close();
    }

    public final String y(Class<E> cls) {
        h hVar = (h) cls.getAnnotation(h.class);
        String name = hVar != null ? hVar.name() : null;
        return l.q(name) ? cls.getSimpleName() : name;
    }

    public boolean z(Collection<E> collection) {
        return A(collection, 0, 0);
    }

    private Cursor query(SQLiteDatabase sQLiteDatabase, Collection<String> collection, String str, String[] strArr) {
        return sQLiteDatabase.query(this.f1482c, (String[]) collection.toArray(new String[collection.size()]), str, strArr, null, null, null);
    }

    private Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2) {
        return sQLiteDatabase.query(this.f1482c, strArr, str, strArr2, null, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b6, code lost:
    
        throw new java.lang.UnknownError("Field type can not be int, long or boolean class.");
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0043 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean delete(E r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L34
            r0.<init>()     // Catch: java.lang.Throwable -> L34
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L34
            r1.<init>()     // Catch: java.lang.Throwable -> L34
            java.util.Map<java.lang.String, java.lang.reflect.Field> r2 = r7.f1484e     // Catch: java.lang.Throwable -> L34
            java.util.Set r2 = r2.entrySet()     // Catch: java.lang.Throwable -> L34
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L34
        L15:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L34
            r4 = 1
            r5 = 0
            if (r3 == 0) goto Lb7
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L34
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> L34
            java.lang.Object r4 = r3.getValue()     // Catch: java.lang.Throwable -> L34
            java.lang.reflect.Field r4 = (java.lang.reflect.Field) r4     // Catch: java.lang.Throwable -> L34
            java.lang.Object r3 = r3.getKey()     // Catch: java.lang.Throwable -> L34
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L34
            java.lang.Object r5 = r4.get(r8)     // Catch: java.lang.Throwable -> L34 java.lang.IllegalAccessException -> L37 java.lang.IllegalArgumentException -> L3c
            goto L41
        L34:
            r8 = move-exception
            goto Le9
        L37:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L34
            goto L40
        L3c:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L34
        L40:
            r5 = 0
        L41:
            if (r5 != 0) goto L44
            goto L15
        L44:
            java.lang.Class r4 = r4.getType()     // Catch: java.lang.Throwable -> L34
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L34
            if (r4 == r6) goto Laf
            java.lang.Class r6 = java.lang.Long.TYPE     // Catch: java.lang.Throwable -> L34
            if (r4 == r6) goto Laf
            java.lang.Class r6 = java.lang.Boolean.TYPE     // Catch: java.lang.Throwable -> L34
            if (r4 == r6) goto Laf
            java.lang.Class<java.lang.Integer> r6 = java.lang.Integer.class
            if (r4 != r6) goto L60
            java.lang.String r4 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L34
            r1.add(r4)     // Catch: java.lang.Throwable -> L34
            goto L9f
        L60:
            java.lang.Class<java.lang.Boolean> r6 = java.lang.Boolean.class
            if (r4 != r6) goto L72
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch: java.lang.Throwable -> L34
            boolean r4 = r5.booleanValue()     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L34
            r1.add(r4)     // Catch: java.lang.Throwable -> L34
            goto L9f
        L72:
            java.lang.Class<java.lang.Long> r6 = java.lang.Long.class
            if (r4 != r6) goto L7e
            java.lang.String r4 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L34
            r1.add(r4)     // Catch: java.lang.Throwable -> L34
            goto L9f
        L7e:
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            if (r4 != r6) goto L8e
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L34
            boolean r4 = ba.l.q(r5)     // Catch: java.lang.Throwable -> L34
            if (r4 != 0) goto L9f
            r1.add(r5)     // Catch: java.lang.Throwable -> L34
            goto L9f
        L8e:
            java.lang.Class<java.util.Date> r6 = java.util.Date.class
            if (r4 != r6) goto La9
            java.util.Date r5 = (java.util.Date) r5     // Catch: java.lang.Throwable -> L34
            long r4 = r5.getTime()     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L34
            r1.add(r4)     // Catch: java.lang.Throwable -> L34
        L9f:
            r0.append(r3)     // Catch: java.lang.Throwable -> L34
            java.lang.String r3 = "=? AND "
            r0.append(r3)     // Catch: java.lang.Throwable -> L34
            goto L15
        La9:
            java.lang.UnknownError r8 = new java.lang.UnknownError     // Catch: java.lang.Throwable -> L34
            r8.<init>()     // Catch: java.lang.Throwable -> L34
            throw r8     // Catch: java.lang.Throwable -> L34
        Laf:
            java.lang.UnknownError r8 = new java.lang.UnknownError     // Catch: java.lang.Throwable -> L34
            java.lang.String r0 = "Field type can not be int, long or boolean class."
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L34
            throw r8     // Catch: java.lang.Throwable -> L34
        Lb7:
            int r8 = r0.length()     // Catch: java.lang.Throwable -> L34
            if (r8 <= 0) goto Lca
            int r8 = r0.length()     // Catch: java.lang.Throwable -> L34
            int r8 = r8 + (-5)
            int r2 = r0.length()     // Catch: java.lang.Throwable -> L34
            r0.delete(r8, r2)     // Catch: java.lang.Throwable -> L34
        Lca:
            android.database.sqlite.SQLiteDatabase r8 = r7.getWritableDatabase()     // Catch: java.lang.Throwable -> L34
            java.lang.String r2 = r7.f1482c     // Catch: java.lang.Throwable -> L34
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L34
            java.lang.String[] r3 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L34
            java.lang.Object[] r1 = r1.toArray(r3)     // Catch: java.lang.Throwable -> L34
            java.lang.String[] r1 = (java.lang.String[]) r1     // Catch: java.lang.Throwable -> L34
            int r0 = r8.delete(r2, r0, r1)     // Catch: java.lang.Throwable -> L34
            r8.close()     // Catch: java.lang.Throwable -> L34
            if (r0 <= 0) goto Le6
            goto Le7
        Le6:
            r4 = 0
        Le7:
            monitor-exit(r7)
            return r4
        Le9:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L34
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ba.k.delete(java.lang.Object):boolean");
    }

    private Cursor query(SQLiteDatabase sQLiteDatabase, Collection<String> collection, String str, String[] strArr, String str2, String str3) {
        return sQLiteDatabase.query(this.f1482c, (String[]) collection.toArray(new String[collection.size()]), str, strArr, null, null, str2, str3);
    }

    public Cursor query() {
        return query(null, null);
    }

    public Cursor query(int i10, int i11, String str) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        return new ba.e(readableDatabase, query(readableDatabase, this.f1484e.keySet(), null, null, str, i10 + ", " + i11));
    }

    public Cursor query(String str, String[] strArr) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        return new ba.e(readableDatabase, query(readableDatabase, this.f1484e.keySet(), str, strArr));
    }

    public synchronized long insert(Collection<E> collection) {
        if (collection != null) {
            if (collection.size() != 0) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    Iterator<E> it = collection.iterator();
                    while (it.hasNext()) {
                        try {
                            writableDatabase.insertWithOnConflict(this.f1482c, null, d(it.next()), 1);
                        } catch (SQLException unused) {
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    return 0L;
                } finally {
                    writableDatabase.endTransaction();
                    writableDatabase.close();
                }
            }
        }
        return 0L;
    }

    public Cursor query(String str, String[] strArr, String str2) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        return new ba.e(readableDatabase, query(readableDatabase, this.f1484e.keySet(), str, strArr, str2, null));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
