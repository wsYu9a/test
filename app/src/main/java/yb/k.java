package yb;

import android.database.sqlite.SQLiteDatabase;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.lib.model.data.MiReadingRecord;

/* loaded from: classes3.dex */
public class k extends ba.k<MiReadingRecord> {

    /* renamed from: m */
    public static k f33447m;

    public k() {
        super(ConfigSingleton.D().getApplicationContext(), "reading_records.db", 10, MiReadingRecord.class);
    }

    public static k K() {
        if (f33447m == null) {
            f33447m = new k();
        }
        return f33447m;
    }

    @Override // ba.k, android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        onCreate(sQLiteDatabase);
        if (i10 < i11) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + n() + " ADD COLUMN lastReadingTime BIGINT DEFAULT 0");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + n() + " ADD COLUMN recordRead INT DEFAULT 0");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + n() + " ADD COLUMN audiobook INT DEFAULT 0");
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }
}
