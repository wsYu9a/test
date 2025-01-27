package com.martian.mibook.lib.model.e;

import com.martian.mibook.lib.model.data.MiBookStoreItemLegency;

/* loaded from: classes3.dex */
public class h extends com.martian.libsupport.j<MiBookStoreItemLegency> {

    /* renamed from: a */
    private static h f13976a;

    public h() {
        super(com.martian.libmars.d.h.F().getApplicationContext(), "tfbookstore.db", 1, MiBookStoreItemLegency.class);
    }

    public static h a() {
        if (f13976a == null) {
            f13976a = new h();
        }
        return f13976a;
    }
}
