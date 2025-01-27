package jb;

import com.martian.mibook.lib.account.request.ActivitiesParams;
import com.martian.mibook.lib.account.response.TYActivityList;

/* loaded from: classes3.dex */
public abstract class a extends d<ActivitiesParams, TYActivityList> {
    public a() {
        super(ActivitiesParams.class, TYActivityList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(TYActivityList tYActivityList) {
        if (tYActivityList == null || tYActivityList.getActivityList() == null) {
            return false;
        }
        return super.onPreDataReceived(tYActivityList);
    }
}
