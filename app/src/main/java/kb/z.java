package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.ResetParams;

/* loaded from: classes3.dex */
public abstract class z extends jb.k<ResetParams, Boolean> {
    public z(Activity activity) {
        super(activity, ResetParams.class, Boolean.class);
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
