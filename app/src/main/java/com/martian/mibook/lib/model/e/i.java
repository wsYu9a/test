package com.martian.mibook.lib.model.e;

import android.database.sqlite.SQLiteCantOpenDatabaseException;
import com.martian.mibook.lib.model.data.MiCacheItem;

/* loaded from: classes3.dex */
public class i extends com.martian.libsupport.j<MiCacheItem> {

    /* renamed from: a */
    private static i f13977a;

    public i() {
        super(com.martian.libmars.d.h.F().getApplicationContext(), "micaches.db", 2, MiCacheItem.class);
    }

    public static i d() {
        if (f13977a == null) {
            f13977a = new i();
        }
        return f13977a;
    }

    public boolean a(com.martian.mibook.lib.model.c.g sourceProvider) {
        return b(sourceProvider.getSourceName(), sourceProvider.getSourceId());
    }

    public boolean b(String sourceName, String sourceId) {
        MiCacheItem miCacheItem = new MiCacheItem();
        miCacheItem.setSourceStr(com.martian.mibook.lib.model.manager.d.j(sourceName, sourceId));
        return delete(miCacheItem);
    }

    public MiCacheItem c(String sourceName, String sourceId) {
        MiCacheItem miCacheItem = new MiCacheItem();
        miCacheItem.setSourceStr(com.martian.mibook.lib.model.manager.d.j(sourceName, sourceId));
        try {
            if (load((i) miCacheItem)) {
                return miCacheItem;
            }
            return null;
        } catch (SQLiteCantOpenDatabaseException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
