package com.martian.appwall.c.d;

import com.martian.appwall.request.auth.MartianFinishNextSubTaskParams;
import com.martian.appwall.response.MartianFinishSubTask;
import com.martian.libmars.activity.j1;
import com.martian.rpauth.MartianIUserManager;

/* loaded from: classes2.dex */
public abstract class d extends b<MartianFinishNextSubTaskParams, MartianFinishSubTask> {
    public d(j1 activity) {
        super(activity, MartianIUserManager.b(), MartianFinishNextSubTaskParams.class, MartianFinishSubTask.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: r */
    public boolean onPreDataReceived(MartianFinishSubTask martianFinishSubTask) {
        if (martianFinishSubTask == null) {
            return false;
        }
        return super.onPreDataReceived(martianFinishSubTask);
    }
}
