package yb;

import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.lib.model.data.MiBookStoreItemLegency;

/* loaded from: classes3.dex */
public class g extends ba.k<MiBookStoreItemLegency> {

    /* renamed from: m */
    public static g f33445m;

    public g() {
        super(ConfigSingleton.D().getApplicationContext(), "tfbookstore.db", 1, MiBookStoreItemLegency.class);
    }

    public static g K() {
        if (f33445m == null) {
            f33445m = new g();
        }
        return f33445m;
    }
}
