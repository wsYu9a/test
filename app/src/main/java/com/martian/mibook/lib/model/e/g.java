package com.martian.mibook.lib.model.e;

import com.martian.mibook.lib.model.data.MiBookStoreItem;

/* loaded from: classes3.dex */
public class g extends o<MiBookStoreItem> {

    /* renamed from: h */
    private static g f13975h;

    public g() {
        super("tfbookstore.db", 1, MiBookStoreItem.class);
    }

    public static g o() {
        if (f13975h == null) {
            f13975h = new g();
        }
        return f13975h;
    }

    @Override // com.martian.mibook.lib.model.e.o
    public synchronized boolean delete(MiBookStoreItem item) {
        MiBookStoreItem miBookStoreItem;
        miBookStoreItem = new MiBookStoreItem();
        miBookStoreItem.setBookId(item.getBookId());
        return super.delete((g) miBookStoreItem);
    }
}
