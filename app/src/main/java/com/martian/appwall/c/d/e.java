package com.martian.appwall.c.d;

import com.martian.appwall.request.auth.MartianStartCurrentSubTaskParams;
import com.martian.appwall.response.MartianStartSubTask;
import com.martian.libmars.activity.j1;
import com.martian.rpauth.MartianIUserManager;

/* loaded from: classes2.dex */
public abstract class e extends b<MartianStartCurrentSubTaskParams, MartianStartSubTask> {
    public e(j1 activity) {
        super(activity, MartianIUserManager.b(), MartianStartCurrentSubTaskParams.class, MartianStartSubTask.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: r */
    public boolean onPreDataReceived(MartianStartSubTask martianStartSubTask) {
        if (martianStartSubTask == null) {
            return false;
        }
        return super.onPreDataReceived(martianStartSubTask);
    }
}
