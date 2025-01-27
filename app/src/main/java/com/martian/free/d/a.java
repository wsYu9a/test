package com.martian.free.d;

import com.martian.free.request.TFBookParams;
import com.martian.free.response.TFBook;
import com.martian.mibook.lib.account.d.f;

/* loaded from: classes2.dex */
public abstract class a extends f<TFBookParams, TFBook> {
    public a() {
        super(TFBookParams.class, TFBook.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(TFBook tfBook) {
        if (tfBook == null) {
            return false;
        }
        return super.onPreDataReceived(tfBook);
    }
}
