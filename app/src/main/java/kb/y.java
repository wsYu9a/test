package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.RequestUnBlackParams;

/* loaded from: classes3.dex */
public abstract class y extends jb.k<RequestUnBlackParams, Boolean> {
    public y(Activity activity) {
        super(activity, RequestUnBlackParams.class, Boolean.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return super.onPreDataReceived(bool);
    }
}
