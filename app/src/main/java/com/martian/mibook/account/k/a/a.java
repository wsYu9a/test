package com.martian.mibook.account.k.a;

import com.martian.mibook.account.request.book.MiBookGetCommentByScoreParams;
import com.martian.mibook.data.book.MiBookGetCommentByScoreItemList;

/* loaded from: classes3.dex */
public abstract class a extends com.martian.mibook.lib.account.d.f<MiBookGetCommentByScoreParams, MiBookGetCommentByScoreItemList> {
    public a() {
        super(MiBookGetCommentByScoreParams.class, MiBookGetCommentByScoreItemList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(MiBookGetCommentByScoreItemList miBookGetCommentByScoreItemList) {
        if (miBookGetCommentByScoreItemList == null || miBookGetCommentByScoreItemList.getCommentList() == null || miBookGetCommentByScoreItemList.getCommentList().size() == 0) {
            return false;
        }
        return super.onPreDataReceived(miBookGetCommentByScoreItemList);
    }
}
