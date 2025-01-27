package yb;

import android.database.sqlite.SQLiteDatabase;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.lib.model.data.MiBookMark;

/* loaded from: classes3.dex */
public class e extends ba.k<MiBookMark> {

    /* renamed from: m */
    public static e f33443m;

    public e() {
        super(ConfigSingleton.D().getApplicationContext(), "tfbookmarks.db", 430, MiBookMark.class);
    }

    public static e K() {
        if (f33443m == null) {
            f33443m = new e();
        }
        return f33443m;
    }

    @Override // ba.k, android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        onCreate(sQLiteDatabase);
        if (i10 < i11) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + n() + " ADD COLUMN chapterId CHAR(64)");
            } catch (Exception unused) {
            }
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + n() + " ADD COLUMN type INT DEFAULT 0");
            } catch (Exception unused2) {
            }
        }
    }
}
