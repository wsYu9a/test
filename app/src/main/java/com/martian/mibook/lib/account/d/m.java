package com.martian.mibook.lib.account.d;

import com.martian.apptask.data.AppTask;
import com.martian.mibook.lib.account.request.SearchRecommendParams;

/* loaded from: classes3.dex */
public abstract class m extends f<SearchRecommendParams, AppTask> {
    public m() {
        super(SearchRecommendParams.class, AppTask.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    public boolean onPreDataReceived(AppTask appTask) {
        if (appTask == null) {
            return false;
        }
        return super.onPreDataReceived((m) appTask);
    }
}
