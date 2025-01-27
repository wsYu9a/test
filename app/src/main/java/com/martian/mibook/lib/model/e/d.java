package com.martian.mibook.lib.model.e;

import android.content.Context;

/* loaded from: classes3.dex */
public class d<E> extends o<E> {

    /* renamed from: h */
    private final Context f13972h;

    public d(Class<E> elemType) {
        this("mibooks.db", elemType);
    }

    @Override // com.martian.mibook.lib.model.e.o
    public Context getContext() {
        return this.f13972h;
    }

    public d(int version, Class<E> elemType) {
        this("mibooks.db", version, elemType);
    }

    public d(String dbname, Class<E> elemType) {
        super(dbname, 8, elemType);
        this.f13972h = com.martian.libmars.d.h.F().getApplicationContext();
    }

    public d(String dbname, int version, Class<E> elemType) {
        super(dbname, version, elemType);
        this.f13972h = com.martian.libmars.d.h.F().getApplicationContext();
    }
}
