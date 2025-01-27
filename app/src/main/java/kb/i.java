package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.FinishExtraBonusParams;
import com.martian.mibook.lib.account.response.ExtraBonus;

/* loaded from: classes3.dex */
public abstract class i extends jb.k<FinishExtraBonusParams, ExtraBonus> {
    public i(Activity activity) {
        super(activity, FinishExtraBonusParams.class, ExtraBonus.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(ExtraBonus extraBonus) {
        if (extraBonus == null) {
            return false;
        }
        return super.onPreDataReceived(extraBonus);
    }
}
