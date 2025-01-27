package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

/* loaded from: classes.dex */
class FrameworkSQLiteProgram implements SupportSQLiteProgram {

    /* renamed from: a */
    private final SQLiteProgram f3620a;

    FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.f3620a = sQLiteProgram;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i2, byte[] bArr) {
        this.f3620a.bindBlob(i2, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i2, double d2) {
        this.f3620a.bindDouble(i2, d2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i2, long j2) {
        this.f3620a.bindLong(i2, j2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i2) {
        this.f3620a.bindNull(i2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i2, String str) {
        this.f3620a.bindString(i2, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.f3620a.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3620a.close();
    }
}
