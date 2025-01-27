package com.martian.free.c;

import android.database.sqlite.SQLiteDatabase;
import com.martian.free.response.TFBook;

/* loaded from: classes2.dex */
public class b extends a<TFBook> {
    public b() {
        super("tfbooks.db", 4, TFBook.class);
    }

    @Override // com.martian.mibook.lib.model.e.o
    public void l(SQLiteDatabase db, int oldVersion, int currVersion) {
        k(db);
        if (oldVersion < currVersion) {
            try {
                db.execSQL("ALTER TABLE " + d() + " ADD COLUMN distType TINYINT DEFAULT 0");
            } catch (Exception unused) {
            }
            try {
                db.execSQL("ALTER TABLE " + d() + " ADD COLUMN keyword TEXT");
            } catch (Exception unused2) {
            }
            try {
                db.execSQL("ALTER TABLE " + d() + " ADD COLUMN cpName VARCHAR(32)");
            } catch (Exception unused3) {
            }
        }
    }
}
