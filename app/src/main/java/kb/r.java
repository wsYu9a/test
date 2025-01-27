package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.InviterDurationRankParams;
import com.martian.mibook.lib.account.response.TYInviteeList;

/* loaded from: classes3.dex */
public abstract class r extends jb.k<InviterDurationRankParams, TYInviteeList> {
    public r(Activity activity) {
        super(activity, InviterDurationRankParams.class, TYInviteeList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(TYInviteeList tYInviteeList) {
        if (tYInviteeList == null || tYInviteeList.getInvitees() == null) {
            return false;
        }
        return super.onPreDataReceived(tYInviteeList);
    }
}
