package com.martian.mibook.lib.yuewen.e;

import com.martian.mibook.lib.yuewen.request.YWRankBooksParams;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;

/* loaded from: classes4.dex */
public abstract class m extends com.martian.mibook.lib.account.d.f<YWRankBooksParams, YWChannelBookList> {
    public m() {
        super(YWRankBooksParams.class, YWChannelBookList.class);
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
