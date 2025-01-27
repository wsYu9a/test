package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.StartExtraBonusParams;

/* loaded from: classes3.dex */
public abstract class b0 extends jb.k<StartExtraBonusParams, Boolean> {
    public b0(Activity activity) {
        super(activity, StartExtraBonusParams.class, Boolean.class);
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
