package com.martian.mibook.lib.yuewen.e;

import com.martian.mibook.lib.yuewen.request.YWBookParams;
import com.martian.mibook.lib.yuewen.response.YWBook;

/* loaded from: classes4.dex */
public abstract class d extends com.martian.mibook.lib.account.d.f<YWBookParams, YWBook> {
    public d() {
        super(YWBookParams.class, YWBook.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(YWBook ywBook) {
        if (ywBook == null) {
            return false;
        }
        return super.onPreDataReceived(ywBook);
    }
}
