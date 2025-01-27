package com.martian.mibook.lib.local.c.d;

import com.martian.mibook.lib.local.txt.data.TXTBook;
import com.martian.mibook.lib.model.e.o;

/* loaded from: classes3.dex */
public class a extends o<TXTBook> {

    /* renamed from: h */
    private static a f13960h;

    public a() {
        super("txtbooks.db", 1, TXTBook.class);
    }

    public static a o() {
        if (f13960h == null) {
            f13960h = new a();
        }
        return f13960h;
    }
}
