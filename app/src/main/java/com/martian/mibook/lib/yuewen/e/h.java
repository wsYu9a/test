package com.martian.mibook.lib.yuewen.e;

import com.martian.mibook.lib.yuewen.request.YWChannelBooksParams;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;

/* loaded from: classes4.dex */
public abstract class h extends com.martian.mibook.lib.account.d.f<YWChannelBooksParams, YWChannelBookList> {
    public h() {
        super(YWChannelBooksParams.class, YWChannelBookList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(YWChannelBookList ywChannelBookList) {
        if (ywChannelBookList == null || ywChannelBookList.getBookList() == null) {
            return false;
        }
        return super.onPreDataReceived(ywChannelBookList);
    }
}
