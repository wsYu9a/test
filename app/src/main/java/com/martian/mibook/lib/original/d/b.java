package com.martian.mibook.lib.original.d;

import android.database.sqlite.SQLiteDatabase;
import com.martian.mibook.lib.original.data.ORBook;

/* loaded from: classes2.dex */
public class b extends a<ORBook> {

    /* renamed from: h */
    private static b f14076h;

    public b() {
        super("orbooks_uniq.db", 5, ORBook.class);
    }

    public static b o() {
        if (f14076h == null) {
            f14076h = new b();
        }
        return f14076h;
    }

    @Override // com.martian.mibook.lib.model.e.o
    public void l(SQLiteDatabase db, int oldVersion, int currVersion) {
        k(db);
        if (oldVersion < currVersion) {
            try {
                db.execSQL("ALTER TABLE " + d() + " ADD COLUMN keyword TEXT");
            } catch (Exception unused) {
            }
        }
    }
}
