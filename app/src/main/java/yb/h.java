package yb;

import android.database.sqlite.SQLiteCantOpenDatabaseException;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.lib.model.data.MiCacheItem;

/* loaded from: classes3.dex */
public class h extends ba.k<MiCacheItem> {

    /* renamed from: m */
    public static h f33446m;

    public h() {
        super(ConfigSingleton.D().getApplicationContext(), "micaches.db", 2, MiCacheItem.class);
    }

    public static h N() {
        if (f33446m == null) {
            f33446m = new h();
        }
        return f33446m;
    }

    public boolean K(String str, String str2) {
        MiCacheItem miCacheItem = new MiCacheItem();
        miCacheItem.setSourceStr(vb.e.j(str, str2));
        return delete(miCacheItem);
    }

    public boolean L(wb.f fVar) {
        return K(fVar.getSourceName(), fVar.getSourceId());
    }

    public MiCacheItem M(String str, String str2) {
        MiCacheItem miCacheItem = new MiCacheItem();
        miCacheItem.setSourceStr(vb.e.j(str, str2));
        try {
            if (w(miCacheItem)) {
                return miCacheItem;
            }
            return null;
        } catch (SQLiteCantOpenDatabaseException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
