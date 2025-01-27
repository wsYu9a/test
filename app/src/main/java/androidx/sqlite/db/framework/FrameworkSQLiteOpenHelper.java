package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* loaded from: classes.dex */
class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {

    /* renamed from: a */
    private final OpenHelper f3614a;

    static class OpenHelper extends SQLiteOpenHelper {

        /* renamed from: a */
        final FrameworkSQLiteDatabase[] f3615a;

        /* renamed from: b */
        final SupportSQLiteOpenHelper.Callback f3616b;

        /* renamed from: c */
        private boolean f3617c;

        /* renamed from: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$1 */
        class AnonymousClass1 implements DatabaseErrorHandler {

            /* renamed from: a */
            final /* synthetic */ FrameworkSQLiteDatabase[] f3618a;

            /* renamed from: b */
            final /* synthetic */ SupportSQLiteOpenHelper.Callback f3619b;

            AnonymousClass1(FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, SupportSQLiteOpenHelper.Callback callback) {
                frameworkSQLiteDatabaseArr = frameworkSQLiteDatabaseArr;
                callback = callback;
            }

            @Override // android.database.DatabaseErrorHandler
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = frameworkSQLiteDatabaseArr[0];
                if (frameworkSQLiteDatabase != null) {
                    callback.onCorruption(frameworkSQLiteDatabase);
                }
            }
        }

        OpenHelper(Context context, String str, FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, SupportSQLiteOpenHelper.Callback callback) {
            super(context, str, null, callback.version, new DatabaseErrorHandler() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.1

                /* renamed from: a */
                final /* synthetic */ FrameworkSQLiteDatabase[] f3618a;

                /* renamed from: b */
                final /* synthetic */ SupportSQLiteOpenHelper.Callback f3619b;

                AnonymousClass1(FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr2, SupportSQLiteOpenHelper.Callback callback2) {
                    frameworkSQLiteDatabaseArr = frameworkSQLiteDatabaseArr2;
                    callback = callback2;
                }

                @Override // android.database.DatabaseErrorHandler
                public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    FrameworkSQLiteDatabase frameworkSQLiteDatabase = frameworkSQLiteDatabaseArr[0];
                    if (frameworkSQLiteDatabase != null) {
                        callback.onCorruption(frameworkSQLiteDatabase);
                    }
                }
            });
            this.f3616b = callback2;
            this.f3615a = frameworkSQLiteDatabaseArr2;
        }

        synchronized SupportSQLiteDatabase a() {
            this.f3617c = false;
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            if (!this.f3617c) {
                return b(readableDatabase);
            }
            close();
            return a();
        }

        FrameworkSQLiteDatabase b(SQLiteDatabase sQLiteDatabase) {
            if (this.f3615a[0] == null) {
                this.f3615a[0] = new FrameworkSQLiteDatabase(sQLiteDatabase);
            }
            return this.f3615a[0];
        }

        synchronized SupportSQLiteDatabase c() {
            this.f3617c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (!this.f3617c) {
                return b(writableDatabase);
            }
            close();
            return c();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.f3615a[0] = null;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f3616b.onConfigure(b(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f3616b.onCreate(b(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.f3617c = true;
            this.f3616b.onDowngrade(b(sQLiteDatabase), i2, i3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.f3617c) {
                return;
            }
            this.f3616b.onOpen(b(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.f3617c = true;
            this.f3616b.onUpgrade(b(sQLiteDatabase), i2, i3);
        }
    }

    FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback) {
        this.f3614a = a(context, str, callback);
    }

    private OpenHelper a(Context context, String str, SupportSQLiteOpenHelper.Callback callback) {
        return new OpenHelper(context, str, new FrameworkSQLiteDatabase[1], callback);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void close() {
        this.f3614a.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.f3614a.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return this.f3614a.a();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return this.f3614a.c();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.f3614a.setWriteAheadLoggingEnabled(z);
    }
}
