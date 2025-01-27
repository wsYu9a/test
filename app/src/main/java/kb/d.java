package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.BindPhoneParams;
import com.martian.mibook.lib.account.response.TYBonus;

/* loaded from: classes3.dex */
public abstract class d extends jb.k<BindPhoneParams, TYBonus> {
    public d(Activity activity) {
        super(activity, BindPhoneParams.class, TYBonus.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(TYBonus tYBonus) {
        if (tYBonus == null) {
            return false;
        }
        return super.onPreDataReceived(tYBonus);
    }
}
