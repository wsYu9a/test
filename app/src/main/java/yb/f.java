package yb;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.martian.mibook.lib.model.data.MiBookStoreItem;

/* loaded from: classes3.dex */
public class f extends n<MiBookStoreItem> {

    /* renamed from: h */
    public static f f33444h;

    public f() {
        super("tfbookstore.db", 2, MiBookStoreItem.class);
    }

    public static f p() {
        if (f33444h == null) {
            f33444h = new f();
        }
        return f33444h;
    }

    @Override // yb.n
    public void k(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        j(sQLiteDatabase);
        if (i10 < i11) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + e() + " ADD COLUMN lastReadChapterSize INT DEFAULT 0");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    @Override // yb.n
    public synchronized boolean delete(MiBookStoreItem miBookStoreItem) {
        if (TextUtils.isEmpty(miBookStoreItem.getBookId())) {
            return false;
        }
        MiBookStoreItem miBookStoreItem2 = new MiBookStoreItem();
        miBookStoreItem2.setBookId(miBookStoreItem.getBookId());
        return super.delete((f) miBookStoreItem2);
    }
}
