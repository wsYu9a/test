package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.GetHistoryCommissionsParams;
import com.martian.mibook.lib.account.response.TYCommissionList;

/* loaded from: classes3.dex */
public abstract class j extends jb.k<GetHistoryCommissionsParams, TYCommissionList> {
    public j(Activity activity) {
        super(activity, GetHistoryCommissionsParams.class, TYCommissionList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(TYCommissionList tYCommissionList) {
        if (tYCommissionList == null || tYCommissionList.getCommissionList() == null) {
            return false;
        }
        return super.onPreDataReceived(tYCommissionList);
    }
}
