package com.martian.mibook.lib.yuewen.e;

import com.martian.mibook.lib.yuewen.request.YWChapterListParams;
import com.martian.mibook.lib.yuewen.response.YWChapterList;

/* loaded from: classes4.dex */
public abstract class j extends com.martian.mibook.lib.account.d.f<YWChapterListParams, YWChapterList> {
    public j() {
        super(YWChapterListParams.class, YWChapterList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(YWChapterList ywChapterList) {
        if (ywChapterList == null || ywChapterList.getChapters() == null) {
            return false;
        }
        return super.onPreDataReceived(ywChapterList);
    }
}
