package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.HasInviterParams;

/* loaded from: classes3.dex */
public abstract class q extends jb.k<HasInviterParams, Boolean> {
    public q(Activity activity) {
        super(activity, HasInviterParams.class, Boolean.class);
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
