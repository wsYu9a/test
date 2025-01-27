package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.BindWeixinParams;

/* loaded from: classes3.dex */
public abstract class e extends jb.k<BindWeixinParams, Boolean> {
    public e(Activity activity) {
        super(activity, BindWeixinParams.class, Boolean.class);
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
