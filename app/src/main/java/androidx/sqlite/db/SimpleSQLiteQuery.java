package androidx.sqlite.db;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {

    /* renamed from: a */
    private final String f3591a;

    /* renamed from: b */
    @Nullable
    private final Object[] f3592b;

    public SimpleSQLiteQuery(String str, @Nullable Object[] objArr) {
        this.f3591a = str;
        this.f3592b = objArr;
    }

    private static void a(SupportSQLiteProgram supportSQLiteProgram, int i2, Object obj) {
        if (obj == null) {
            supportSQLiteProgram.bindNull(i2);
            return;
        }
        if (obj instanceof byte[]) {
            supportSQLiteProgram.bindBlob(i2, (byte[]) obj);
            return;
        }
        if (obj instanceof Float) {
            supportSQLiteProgram.bindDouble(i2, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            supportSQLiteProgram.bindDouble(i2, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Long) {
            supportSQLiteProgram.bindLong(i2, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Integer) {
            supportSQLiteProgram.bindLong(i2, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            supportSQLiteProgram.bindLong(i2, ((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Byte) {
            supportSQLiteProgram.bindLong(i2, ((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof String) {
            supportSQLiteProgram.bindString(i2, (String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            supportSQLiteProgram.bindLong(i2, ((Boolean) obj).booleanValue() ? 1L : 0L);
            return;
        }
        throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i2 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
    }

    public static void bind(SupportSQLiteProgram supportSQLiteProgram, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i2 = 0;
        while (i2 < length) {
            Object obj = objArr[i2];
            i2++;
            a(supportSQLiteProgram, i2, obj);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        bind(supportSQLiteProgram, this.f3592b);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        Object[] objArr = this.f3592b;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.f3591a;
    }

    public SimpleSQLiteQuery(String str) {
        this(str, null);
    }
}
