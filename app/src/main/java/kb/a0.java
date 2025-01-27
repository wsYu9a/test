package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.ShowWealthParams;
import com.martian.mibook.lib.account.response.ShowWealthResult;

/* loaded from: classes3.dex */
public abstract class a0 extends jb.k<ShowWealthParams, ShowWealthResult> {
    public a0(Activity activity) {
        super(activity, ShowWealthParams.class, ShowWealthResult.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(ShowWealthResult showWealthResult) {
        if (showWealthResult == null) {
            return false;
        }
        return super.onPreDataReceived(showWealthResult);
    }
}
