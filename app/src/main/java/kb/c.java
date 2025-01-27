package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.BindInviterParams;
import com.martian.mibook.lib.account.response.ExchangeMoney;

/* loaded from: classes3.dex */
public abstract class c extends jb.k<BindInviterParams, ExchangeMoney> {
    public c(Activity activity) {
        super(activity, BindInviterParams.class, ExchangeMoney.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(ExchangeMoney exchangeMoney) {
        if (exchangeMoney == null) {
            return false;
        }
        return super.onPreDataReceived(exchangeMoney);
    }
}
