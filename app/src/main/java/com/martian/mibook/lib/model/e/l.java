package com.martian.mibook.lib.model.e;

import android.database.sqlite.SQLiteDatabase;
import com.martian.mibook.lib.model.data.MiReadingRecord;

/* loaded from: classes3.dex */
public class l extends com.martian.libsupport.j<MiReadingRecord> {

    /* renamed from: a */
    private static l f13978a;

    public l() {
        super(com.martian.libmars.d.h.F().getApplicationContext(), "reading_records.db", 9, MiReadingRecord.class);
    }

    public static l a() {
        if (f13978a == null) {
            f13978a = new l();
        }
        return f13978a;
    }

    @Override // com.martian.libsupport.j, android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int currVersion) {
        onCreate(db);
        if (oldVersion < currVersion) {
            try {
                db.execSQL("ALTER TABLE " + getTableName() + " ADD COLUMN lastReadingTime BIGINT DEFAULT 0");
            } catch (Exception unused) {
            }
            try {
                db.execSQL("ALTER TABLE " + getTableName() + " ADD COLUMN recordRead INT DEFAULT 0");
            } catch (Exception unused2) {
            }
        }
    }
}
