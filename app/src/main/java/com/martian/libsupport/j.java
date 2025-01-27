package com.martian.libsupport;

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
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class j<E> extends SQLiteOpenHelper implements Iterable<E> {
    public static final int INSERT_SUCCESS = 1;
    public static final int OPERATION_FAILURE = -1;
    public static final int STORAGE_INSUFFICIENT = -2;
    private static final String TAG = j.class.getSimpleName();
    public static final int UPDATE_SUCCESS = 2;
    private Map<String, Field> columnFields;
    private final Context context;
    private String createTableSql;
    private final String dbname;
    private final Class<E> elemType;
    private final String tableName;

    @Target({ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface a {
    }

    @Target({ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface b {
        String name() default "";
    }

    public class c implements Iterator<E> {

        /* renamed from: a */
        private boolean f10605a;

        /* renamed from: b */
        private final Cursor f10606b;

        public c(Cursor cursor) {
            this.f10606b = cursor;
            this.f10605a = cursor.moveToFirst();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10605a;
        }

        @Override // java.util.Iterator
        public E next() {
            E e2 = null;
            try {
                e2 = (E) j.this.elemType.newInstance();
                j.this.setValueWithCursor(e2, this.f10606b);
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InstantiationException e4) {
                e4.printStackTrace();
            }
            boolean moveToNext = this.f10606b.moveToNext();
            this.f10605a = moveToNext;
            if (!moveToNext) {
                this.f10606b.close();
            }
            return e2;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static class d {

        /* renamed from: a */
        public String f10608a;

        /* renamed from: b */
        public Long f10609b;

        public d() {
        }

        public d(String name, Long itemCount) {
            this.f10608a = name;
            this.f10609b = itemCount;
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface e {
        boolean ascend() default true;

        int index() default 0;
    }

    @Target({ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface f {
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface g {
        String name();
    }

    @Target({ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface h {
    }

    public interface i<E> {
        boolean a(E e2);
    }

    public j(Context context, String dbname, int version, Class<E> elemType) {
        super(context, dbname, (SQLiteDatabase.CursorFactory) null, version);
        this.dbname = dbname;
        this.elemType = elemType;
        this.tableName = retrieveTableName(elemType);
        this.context = context;
        buildColumnNamesAndFields();
        try {
            updateVersion(version, context);
        } catch (Exception unused) {
        }
        try {
            File databasePath = getContext().getDatabasePath(dbname);
            if (databasePath.exists()) {
                databasePath.setLastModified(System.currentTimeMillis());
            }
        } catch (Exception unused2) {
        }
        try {
            File file = new File(dbname);
            if (file.exists()) {
                file.setLastModified(System.currentTimeMillis());
            }
        } catch (Exception unused3) {
        }
    }

    public static Map<String, Field> buildColumnNamesAndFields(Class<?> elemType) {
        Hashtable hashtable = new Hashtable();
        Iterator<Field> it = com.martian.libsupport.g.a(elemType).iterator();
        while (it.hasNext()) {
            Field next = it.next();
            next.setAccessible(true);
            b bVar = (b) next.getAnnotation(b.class);
            if (bVar != null) {
                String name = bVar.name();
                if (k.p(name)) {
                    name = next.getName();
                }
                hashtable.put(name, next);
            }
        }
        return hashtable;
    }

    private ContentValues buildContentValues(E e2) {
        ContentValues contentValues = new ContentValues();
        for (Map.Entry<String, Field> entry : this.columnFields.entrySet()) {
            Field value = entry.getValue();
            String key = entry.getKey();
            Object obj = null;
            try {
                obj = value.get(e2);
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
            }
            if (obj != null) {
                Class<?> type = value.getType();
                if (type == Integer.TYPE || type == Long.TYPE || type == Boolean.TYPE) {
                    throw new UnknownError("Field type can not be int or long.");
                }
                if (type == Integer.class) {
                    contentValues.put(key, (Integer) obj);
                } else if (type == Boolean.class) {
                    contentValues.put(key, Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0));
                } else if (type == Long.class) {
                    contentValues.put(key, (Long) obj);
                } else if (type == String.class) {
                    contentValues.put(key, (String) obj);
                } else {
                    if (type != Date.class) {
                        throw new UnknownError();
                    }
                    contentValues.put(key, Long.valueOf(((Date) obj).getTime()));
                }
            }
        }
        return contentValues;
    }

    private String buildCreateTableSql() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(this.tableName);
        sb.append(" (");
        Iterator<Field> it = com.martian.libsupport.g.a(this.elemType).iterator();
        while (it.hasNext()) {
            Field next = it.next();
            b bVar = (b) next.getAnnotation(b.class);
            if (bVar != null) {
                String name = bVar.name();
                if (k.p(name)) {
                    name = next.getName();
                }
                Class<?> type = next.getType();
                if (type == Integer.TYPE || type == Long.TYPE || type == Boolean.TYPE) {
                    throw new UnknownError("Field type can not be int or long.");
                }
                if (type == Integer.class) {
                    sb.append(name);
                    sb.append(" Integer ");
                } else if (type == Boolean.class) {
                    sb.append(name);
                    sb.append(" Integer ");
                } else if (type == Long.class) {
                    sb.append(name);
                    sb.append(" Integer ");
                } else if (type == String.class) {
                    sb.append(name);
                    sb.append(" Text ");
                } else {
                    if (type != Date.class) {
                        throw new RuntimeException("Unprocessed field type: " + type.getName());
                    }
                    sb.append(name);
                    sb.append(" Integer ");
                }
                if (((a) next.getAnnotation(a.class)) != null) {
                    sb.append(" primary key autoincrement ");
                } else if (((f) next.getAnnotation(f.class)) != null) {
                    sb.append(" primary key ");
                } else if (((h) next.getAnnotation(h.class)) != null) {
                    sb.append(" UNIQUE ");
                }
                sb.append(",");
            }
        }
        sb.setCharAt(sb.length() - 1, ')');
        return sb.toString();
    }

    private String[] buildPrimaryWhereClause(E e2, StringBuffer stringBuffer) {
        ArrayList arrayList = new ArrayList();
        Iterator<Field> it = com.martian.libsupport.g.a(this.elemType).iterator();
        while (it.hasNext()) {
            Field next = it.next();
            next.setAccessible(true);
            b bVar = (b) next.getAnnotation(b.class);
            if (bVar != null) {
                f fVar = (f) next.getAnnotation(f.class);
                h hVar = (h) next.getAnnotation(h.class);
                if (fVar != null || hVar != null) {
                    String name = bVar.name();
                    if (k.p(name)) {
                        name = next.getName();
                    }
                    Object obj = null;
                    try {
                        obj = next.get(e2);
                    } catch (IllegalAccessException e3) {
                        e3.printStackTrace();
                    } catch (IllegalArgumentException e4) {
                        e4.printStackTrace();
                    }
                    if (obj != null) {
                        Class<?> type = next.getType();
                        if (type == Integer.TYPE || type == Long.TYPE) {
                            throw new UnknownError("Field type can not be int or long.");
                        }
                        if (type == Integer.class) {
                            arrayList.add(String.valueOf(obj));
                        } else if (type == Boolean.class) {
                            arrayList.add(String.valueOf(((Boolean) obj).booleanValue() ? 1 : 0));
                        } else if (type == Long.class) {
                            arrayList.add(String.valueOf(obj));
                        } else if (type == String.class) {
                            String str = (String) obj;
                            if (!k.p(str)) {
                                arrayList.add(str);
                            }
                        } else {
                            if (type != Date.class) {
                                throw new UnknownError();
                            }
                            arrayList.add(String.valueOf(((Date) obj).getTime()));
                        }
                        stringBuffer.append(name);
                        stringBuffer.append("=? AND ");
                    } else {
                        continue;
                    }
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.delete(stringBuffer.length() - 5, stringBuffer.length());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static <T> T createInstanceFromCursor(Class<T> elemType, Cursor cursor) {
        Map<String, Field> buildColumnNamesAndFields = buildColumnNamesAndFields(elemType);
        try {
            T newInstance = elemType.newInstance();
            setValueWithCursor(buildColumnNamesAndFields, newInstance, cursor);
            return newInstance;
        } catch (IllegalAccessException unused) {
            throw new IllegalStateException("Missing default constructor.");
        } catch (InstantiationException unused2) {
            throw new IllegalStateException("Missing default constructor.");
        }
    }

    private int getVersion(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getInt(this.tableName + "_version", 0);
    }

    private Cursor query(SQLiteDatabase db, Collection<String> columns, String selection, ArrayList<String> selectArgs) {
        return db.query(this.tableName, (String[]) columns.toArray(new String[columns.size()]), selection, selectArgs == null ? null : (String[]) selectArgs.toArray(new String[selectArgs.size()]), null, null, null);
    }

    private String retrieveTableName(Class<E> etype) {
        g gVar = (g) etype.getAnnotation(g.class);
        String name = gVar != null ? gVar.name() : null;
        return k.p(name) ? etype.getSimpleName() : name;
    }

    public static <T> void setValueWithCursor(Map<String, Field> columnFields, T data, Cursor cursor) {
        for (Map.Entry<String, Field> entry : columnFields.entrySet()) {
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
                        value.set(data, Integer.valueOf(Integer.parseInt(string)));
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    }
                } else if (type == Boolean.class) {
                    value.set(data, Boolean.valueOf(Integer.parseInt(string) > 0));
                } else if (type == Long.class) {
                    value.set(data, Long.valueOf(Long.parseLong(string)));
                } else if (type == String.class) {
                    value.set(data, string);
                } else {
                    if (type != Date.class) {
                        throw new RuntimeException("Unprocessed field type: " + type.getName());
                    }
                    value.set(data, new Date(Long.parseLong(string)));
                }
                e2.printStackTrace();
            }
        }
    }

    private void setVersion(Context ctx, int version) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(ctx).edit();
        edit.putInt(this.tableName + "_version", version);
        edit.commit();
    }

    private void updateVersion(int version, Context context) {
        int version2 = getVersion(context);
        if (version == 0) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            onCreate(writableDatabase);
            writableDatabase.close();
        } else if (version > version2) {
            SQLiteDatabase writableDatabase2 = getWritableDatabase();
            onUpgrade(writableDatabase2, version2, version);
            writableDatabase2.close();
        }
        setVersion(context, version);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b7, code lost:
    
        throw new java.lang.UnknownError("Field type can not be int, long or boolean class.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean delete(E r10) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libsupport.j.delete(java.lang.Object):boolean");
    }

    public void deleteDatabase() {
        this.context.deleteDatabase(getDBName());
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
    
        r2 = r6.name();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        if (com.martian.libsupport.k.p(r2) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        r2 = r3.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        r4 = r3.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x004d, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x004e, code lost:
    
        r9.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0048, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0049, code lost:
    
        r9.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e6 A[Catch: all -> 0x00f8, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:5:0x000e, B:7:0x0016, B:10:0x002a, B:16:0x0035, B:18:0x003f, B:20:0x0043, B:25:0x0055, B:27:0x005d, B:31:0x0065, B:32:0x00ae, B:36:0x00d4, B:38:0x00e6, B:41:0x00ee, B:48:0x0070, B:51:0x007b, B:55:0x0086, B:58:0x0091, B:60:0x0099, B:65:0x00a2, B:66:0x00c0, B:67:0x00c5, B:68:0x00c6, B:69:0x00cd, B:74:0x0049, B:72:0x004e), top: B:3:0x0002, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ee A[Catch: all -> 0x00f8, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:5:0x000e, B:7:0x0016, B:10:0x002a, B:16:0x0035, B:18:0x003f, B:20:0x0043, B:25:0x0055, B:27:0x005d, B:31:0x0065, B:32:0x00ae, B:36:0x00d4, B:38:0x00e6, B:41:0x00ee, B:48:0x0070, B:51:0x007b, B:55:0x0086, B:58:0x0091, B:60:0x0099, B:65:0x00a2, B:66:0x00c0, B:67:0x00c5, B:68:0x00c6, B:69:0x00cd, B:74:0x0049, B:72:0x004e), top: B:3:0x0002, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean exists(E r9) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libsupport.j.exists(java.lang.Object):boolean");
    }

    public Context getContext() {
        return this.context;
    }

    public String getDBName() {
        return this.dbname;
    }

    public synchronized long getRowCount() {
        long queryNumEntries;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        try {
            queryNumEntries = DatabaseUtils.queryNumEntries(readableDatabase, this.tableName);
            if (readableDatabase != null) {
                readableDatabase.close();
            }
        } finally {
        }
        return queryNumEntries;
    }

    public String getTableName() {
        return this.tableName;
    }

    public synchronized List<d> groupCount(String colname, boolean asc, String whereClause, ArrayList<String> whereArgs) {
        String str;
        ArrayList arrayList;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(colname);
        sb.append(", COUNT(*) AS gsum FROM ");
        sb.append(this.tableName);
        sb.append(" GROUP BY ");
        sb.append(colname);
        sb.append(" ORDER BY gsum ");
        sb.append(asc ? " ASC" : " DESC");
        if (whereClause == null) {
            str = "";
        } else {
            str = " WHERE " + whereClause;
        }
        sb.append(str);
        arrayList = null;
        Cursor rawQuery = readableDatabase.rawQuery(sb.toString(), whereArgs == null ? null : (String[]) whereArgs.toArray(new String[whereArgs.size()]));
        if (rawQuery.moveToFirst()) {
            arrayList = new ArrayList(rawQuery.getCount());
            do {
                d dVar = new d();
                dVar.f10608a = rawQuery.getString(0);
                dVar.f10609b = Long.valueOf(rawQuery.getLong(1));
                arrayList.add(dVar);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        readableDatabase.close();
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    public synchronized boolean insert(E data) {
        ContentValues buildContentValues = buildContentValues(data);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            writableDatabase.insertWithOnConflict(this.tableName, null, buildContentValues, 4);
            writableDatabase.close();
        } catch (SQLException e2) {
            writableDatabase.close();
            throw e2;
        }
        return true;
    }

    public synchronized int insertOrUpdate(E data) {
        ContentValues buildContentValues = buildContentValues(data);
        int i2 = -1;
        if (buildContentValues.size() == 0) {
            return -1;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            writableDatabase.insertWithOnConflict(this.tableName, null, buildContentValues, 0);
            i2 = 1;
        } catch (SQLException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                if (writableDatabase.update(this.tableName, buildContentValues, stringBuffer.toString(), buildPrimaryWhereClause(data, stringBuffer)) > 0) {
                    i2 = 2;
                }
            } catch (Exception unused2) {
            }
        }
        writableDatabase.close();
        return i2;
    }

    public synchronized boolean load(E data) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, Field>> it = this.columnFields.entrySet().iterator();
        while (true) {
            int i2 = 1;
            if (!it.hasNext()) {
                if (sb.length() > 0) {
                    sb.delete(sb.length() - 5, sb.length());
                }
                SQLiteDatabase readableDatabase = getReadableDatabase();
                Cursor query = query(readableDatabase, this.columnFields.keySet(), sb.toString(), arrayList);
                if (!query.moveToFirst()) {
                    query.close();
                    readableDatabase.close();
                    return false;
                }
                setValueWithCursor(data, query);
                if (query.moveToNext()) {
                    Log.w(TAG, "Multiple " + data.getClass().getSimpleName() + " objects exist.");
                }
                query.close();
                readableDatabase.close();
                return true;
            }
            Map.Entry<String, Field> next = it.next();
            Field value = next.getValue();
            String key = next.getKey();
            Object obj = null;
            try {
                obj = value.get(data);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            }
            if (obj != null) {
                Class<?> type = value.getType();
                if (type == Integer.TYPE || type == Long.TYPE || type == Boolean.TYPE) {
                    break;
                }
                if (type == Integer.class) {
                    arrayList.add(String.valueOf(obj));
                } else if (type == Boolean.class) {
                    if (!((Boolean) obj).booleanValue()) {
                        i2 = 0;
                    }
                    arrayList.add(String.valueOf(i2));
                } else if (type == Long.class) {
                    arrayList.add(String.valueOf(obj));
                } else if (type == String.class) {
                    String str = (String) obj;
                    if (!k.p(str)) {
                        arrayList.add(str);
                    }
                } else {
                    if (type != Date.class) {
                        throw new UnknownError();
                    }
                    arrayList.add(String.valueOf(((Date) obj).getTime()));
                }
                sb.append(key);
                sb.append("=? AND ");
            }
        }
        throw new UnknownError("Field type can not be int or long.");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(buildCreateTableSql());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + this.tableName);
        onCreate(db);
    }

    public synchronized void reset() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        onUpgrade(writableDatabase, 0, 0);
        writableDatabase.close();
    }

    public synchronized long sum(String colname, String whereClause, ArrayList<String> whereArgs) {
        long j2;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT SUM(" + colname + ") FROM " + this.tableName + " WHERE " + whereClause, (String[]) whereArgs.toArray(new String[whereArgs.size()]));
        j2 = rawQuery.moveToFirst() ? rawQuery.getLong(0) : 0L;
        rawQuery.close();
        readableDatabase.close();
        return j2;
    }

    public synchronized boolean update(E data) {
        boolean z;
        ContentValues buildContentValues = buildContentValues(data);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        z = writableDatabase.update(this.tableName, buildContentValues, stringBuffer.toString(), buildPrimaryWhereClause(data, stringBuffer)) > 0;
        writableDatabase.close();
        return z;
    }

    @Override // java.lang.Iterable
    public j<E>.c iterator() {
        return iterator(null, null);
    }

    public j<E>.c iterator(String selection, String[] selectionArgs) {
        return new c(query(selection, selectionArgs));
    }

    private Cursor query(SQLiteDatabase db, Collection<String> columns, String selection, String[] selectArgs) {
        return db.query(this.tableName, (String[]) columns.toArray(new String[columns.size()]), selection, selectArgs, null, null, null);
    }

    private Cursor query(SQLiteDatabase db, String[] columns, String selection, String[] selectArgs) {
        return db.query(this.tableName, columns, selection, selectArgs, null, null, null);
    }

    private Cursor query(SQLiteDatabase db, Collection<String> columns, String selection, String[] selectArgs, String orderby, String limit) {
        return db.query(this.tableName, (String[]) columns.toArray(new String[columns.size()]), selection, selectArgs, null, null, orderby, limit);
    }

    public Cursor query() {
        return query(null, null);
    }

    public synchronized long insert(Collection<E> ces) {
        if (ces != null) {
            if (ces.size() != 0) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    Iterator<E> it = ces.iterator();
                    while (it.hasNext()) {
                        try {
                            writableDatabase.insertWithOnConflict(this.tableName, null, buildContentValues(it.next()), 0);
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

    public Cursor query(int offset, int size, String orderBys) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        return new com.martian.libsupport.c(readableDatabase, query(readableDatabase, this.columnFields.keySet(), null, null, orderBys, offset + ", " + size));
    }

    private void buildColumnNamesAndFields() {
        this.columnFields = new Hashtable();
        Iterator<Field> it = com.martian.libsupport.g.a(this.elemType).iterator();
        while (it.hasNext()) {
            Field next = it.next();
            next.setAccessible(true);
            b bVar = (b) next.getAnnotation(b.class);
            if (bVar != null) {
                String name = bVar.name();
                if (k.p(name)) {
                    name = next.getName();
                }
                this.columnFields.put(name, next);
            }
        }
    }

    public Cursor query(String selection, String[] selectionArgs) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        return new com.martian.libsupport.c(readableDatabase, query(readableDatabase, this.columnFields.keySet(), selection, selectionArgs));
    }

    public synchronized long insertOrUpdate(Collection<E> ces, i<E> validator) {
        long j2;
        long j3 = 0;
        if (ces != null) {
            if (ces.size() != 0) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (E e2 : ces) {
                        if (validator.a(e2)) {
                            ContentValues buildContentValues = buildContentValues(e2);
                            try {
                                j2 = writableDatabase.insertWithOnConflict(this.tableName, null, buildContentValues, 5);
                            } catch (SQLException unused) {
                                StringBuffer stringBuffer = new StringBuffer();
                                if (writableDatabase.update(this.tableName, buildContentValues, stringBuffer.toString(), buildPrimaryWhereClause(e2, stringBuffer)) > 0) {
                                    j2 = 1;
                                }
                            }
                            j3 += j2;
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    return j3;
                } finally {
                    writableDatabase.endTransaction();
                    writableDatabase.close();
                }
            }
        }
        return 0L;
    }

    public Cursor query(String selection, String[] selectionArgs, String orderbys) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        return new com.martian.libsupport.c(readableDatabase, query(readableDatabase, this.columnFields.keySet(), selection, selectionArgs, orderbys, null));
    }

    public void setValueWithCursor(E data, Cursor cursor) {
        for (Map.Entry<String, Field> entry : this.columnFields.entrySet()) {
            Field value = entry.getValue();
            String key = entry.getKey();
            Class<?> type = value.getType();
            if (type != Integer.TYPE && type != Long.TYPE && type != Boolean.TYPE) {
                String string = cursor.getString(cursor.getColumnIndex(key));
                if (string != null && !TextUtils.isEmpty(string)) {
                    if (type == Integer.class) {
                        try {
                            value.set(data, Integer.valueOf(Integer.parseInt(string)));
                        } catch (IllegalAccessException e2) {
                            e2.printStackTrace();
                        }
                    } else if (type == Boolean.class) {
                        value.set(data, Boolean.valueOf(Integer.parseInt(string) > 0));
                    } else if (type == Long.class) {
                        value.set(data, Long.valueOf(Long.parseLong(string)));
                    } else if (type == String.class) {
                        value.set(data, string);
                    } else if (type == Date.class) {
                        value.set(data, new Date(Long.parseLong(string)));
                    } else {
                        throw new RuntimeException("Unprocessed field type: " + type.getName());
                    }
                    e2.printStackTrace();
                }
            } else {
                throw new UnknownError("Field type can not be int or long.");
            }
        }
    }

    public synchronized long insertOrUpdate(Collection<E> ces) {
        long j2;
        long j3 = 0;
        if (ces != null) {
            if (ces.size() != 0) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (E e2 : ces) {
                        ContentValues buildContentValues = buildContentValues(e2);
                        try {
                            j2 = writableDatabase.insertWithOnConflict(this.tableName, null, buildContentValues, 5);
                        } catch (SQLException unused) {
                            StringBuffer stringBuffer = new StringBuffer();
                            if (writableDatabase.update(this.tableName, buildContentValues, stringBuffer.toString(), buildPrimaryWhereClause(e2, stringBuffer)) > 0) {
                                j2 = 1;
                            }
                        }
                        j3 += j2;
                    }
                    writableDatabase.setTransactionSuccessful();
                    return j3;
                } finally {
                    writableDatabase.endTransaction();
                    writableDatabase.close();
                }
            }
        }
        return 0L;
    }

    public boolean load(Collection<E> ces) {
        return load(ces, 0, 0);
    }

    public boolean load(Collection<E> ces, int offset, int size) {
        return load(ces, offset, size, (String) null, (String[]) null);
    }

    public boolean load(Collection<E> ces, int offset, int size, String selection, ArrayList<String> selectionArgs) {
        return load(ces, offset, size, selection, (String[]) selectionArgs.toArray(new String[selectionArgs.size()]));
    }

    public synchronized boolean load(Collection<E> ces, int offset, int size, String selection, String[] selectionArgs) {
        String str;
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<String, Field> entry : this.columnFields.entrySet()) {
            Field value = entry.getValue();
            String key = entry.getKey();
            e eVar = (e) value.getAnnotation(e.class);
            if (eVar != null) {
                Integer valueOf = Integer.valueOf(eVar.index());
                StringBuilder sb = new StringBuilder();
                sb.append(key);
                sb.append(eVar.ascend() ? " ASC" : " DESC");
                treeMap.put(valueOf, sb.toString());
            }
        }
        str = null;
        if (treeMap.size() != 0) {
            StringBuilder sb2 = new StringBuilder();
            Iterator<E> it = treeMap.entrySet().iterator();
            while (it.hasNext()) {
                sb2.append((String) ((Map.Entry) it.next()).getValue());
                sb2.append(",");
            }
            str = sb2.substring(0, sb2.length() - 1);
        }
        return load(ces, offset, size, selection, selectionArgs, str);
    }

    public boolean load(Collection<E> ces, Cursor cursor) {
        if (!cursor.moveToFirst()) {
            return true;
        }
        do {
            try {
                E newInstance = this.elemType.newInstance();
                setValueWithCursor(newInstance, cursor);
                ces.add(newInstance);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return false;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return false;
            }
        } while (cursor.moveToNext());
        return true;
    }

    public synchronized boolean load(Collection<E> ces, int offset, int size, String selection, String[] selectionArgs, String orderBy) {
        String str = null;
        if (size > 0) {
            str = offset + "," + size;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor query = query(readableDatabase, this.columnFields.keySet(), selection, selectionArgs, orderBy, str);
        if (query.moveToFirst()) {
            do {
                try {
                    E newInstance = this.elemType.newInstance();
                    setValueWithCursor(newInstance, query);
                    ces.add(newInstance);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                    query.close();
                    readableDatabase.close();
                    return false;
                } catch (InstantiationException e3) {
                    e3.printStackTrace();
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
}
