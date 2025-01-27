package com.kwad.sdk.core.report;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class c extends SQLiteOpenHelper {
    private String aBH;

    public c(@Nullable Context context, @Nullable String str, int i10, String str2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
        this.aBH = str2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.aBH);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        setWriteAheadLoggingEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
