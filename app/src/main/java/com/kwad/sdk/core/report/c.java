package com.kwad.sdk.core.report;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class c extends SQLiteOpenHelper {
    private String aig;

    public c(@Nullable Context context, @Nullable String str, int i2, String str2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        this.aig = str2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.aig);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 16) {
            setWriteAheadLoggingEnabled(true);
        } else if (i2 >= 11) {
            sQLiteDatabase.enableWriteAheadLogging();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
