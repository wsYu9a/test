package ec;

import android.database.sqlite.SQLiteDatabase;
import com.martian.mibook.lib.original.data.ORBook;

/* loaded from: classes3.dex */
public class b extends a<ORBook> {

    /* renamed from: h */
    public static b f25843h;

    public b() {
        super("orbooks_uniq.db", 5, ORBook.class);
    }

    public static b p() {
        if (f25843h == null) {
            f25843h = new b();
        }
        return f25843h;
    }

    @Override // yb.n
    public void k(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        j(sQLiteDatabase);
        if (i10 < i11) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + e() + " ADD COLUMN keyword TEXT");
            } catch (Exception unused) {
            }
        }
    }
}
