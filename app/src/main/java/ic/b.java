package ic;

import android.database.sqlite.SQLiteDatabase;
import com.martian.mibook.lib.yuewen.response.YWBook;

/* loaded from: classes3.dex */
public class b extends a<YWBook> {
    public b() {
        super("ywbooks.db", 6, YWBook.class);
    }

    @Override // yb.n
    public void k(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        j(sQLiteDatabase);
        if (i10 < i11) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + e() + " ADD COLUMN distType TINYINT DEFAULT 0");
            } catch (Exception unused) {
            }
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + e() + " ADD COLUMN keyword TEXT");
            } catch (Exception unused2) {
            }
        }
    }
}
