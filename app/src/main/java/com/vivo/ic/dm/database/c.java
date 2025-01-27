package com.vivo.ic.dm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Constants;

/* loaded from: classes4.dex */
class c extends SQLiteOpenHelper {

    /* renamed from: a */
    private static final String f28442a = Constants.PRE_TAG + "MovedDbHelper";

    /* renamed from: b */
    private static final int f28443b = 1000000;

    c(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, f28443b);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        VLog.i(f28442a, "onCreate");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        VLog.i(f28442a, "onUpgrade oldVersion:" + i2 + " newVersion:" + i3);
    }
}
