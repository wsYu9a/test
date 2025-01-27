package p8;

import android.database.sqlite.SQLiteDatabase;
import com.martian.free.response.TFBook;

/* loaded from: classes3.dex */
public class b extends a<TFBook> {
    public b() {
        super("tfbooks.db", 4, TFBook.class);
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
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + e() + " ADD COLUMN cpName VARCHAR(32)");
            } catch (Exception unused3) {
            }
        }
    }
}
