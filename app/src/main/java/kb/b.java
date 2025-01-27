package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.BParams;

/* loaded from: classes3.dex */
public abstract class b extends jb.k<BParams, Boolean> {
    public b(Activity activity) {
        super(activity, BParams.class, Boolean.class);
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
