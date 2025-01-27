package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.CheckinParams;
import com.martian.mibook.lib.account.response.CheckinResult;

/* loaded from: classes3.dex */
public abstract class f extends jb.k<CheckinParams, CheckinResult> {
    public f(Activity activity) {
        super(activity, CheckinParams.class, CheckinResult.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(CheckinResult checkinResult) {
        if (checkinResult == null) {
            return false;
        }
        return super.onPreDataReceived(checkinResult);
    }
}
