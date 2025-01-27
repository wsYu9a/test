package com.martian.mibook.lib.model.e;

import com.martian.mibook.lib.model.data.MiArchiveBookItem;

/* loaded from: classes3.dex */
public class c extends com.martian.libsupport.j<MiArchiveBookItem> {

    /* renamed from: a */
    private static c f13971a;

    public c() {
        super(com.martian.libmars.d.h.F().getApplicationContext(), "tfarchive_books.db", 1, MiArchiveBookItem.class);
    }

    public static c a() {
        if (f13971a == null) {
            f13971a = new c();
        }
        return f13971a;
    }
}
