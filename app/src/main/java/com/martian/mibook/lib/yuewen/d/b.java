package com.martian.mibook.lib.yuewen.d;

import android.database.sqlite.SQLiteDatabase;
import com.martian.mibook.lib.yuewen.response.YWBook;

/* loaded from: classes4.dex */
public class b extends a<YWBook> {
    public b() {
        super("ywbooks.db", 6, YWBook.class);
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
        }
    }
}
