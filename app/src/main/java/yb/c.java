package yb;

import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.lib.model.data.MiArchiveBookItem;

/* loaded from: classes3.dex */
public class c extends ba.k<MiArchiveBookItem> {

    /* renamed from: m */
    public static c f33441m;

    public c() {
        super(ConfigSingleton.D().getApplicationContext(), "tfarchive_books.db", 1, MiArchiveBookItem.class);
    }

    public static c K() {
        if (f33441m == null) {
            f33441m = new c();
        }
        return f33441m;
    }
}
