package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.CreateWxPrepayParams;
import com.martian.mibook.lib.account.response.WXRechargeOrder;

/* loaded from: classes3.dex */
public abstract class h extends jb.k<CreateWxPrepayParams, WXRechargeOrder> {
    public h(Activity activity) {
        super(activity, CreateWxPrepayParams.class, WXRechargeOrder.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(WXRechargeOrder wXRechargeOrder) {
        if (wXRechargeOrder == null) {
            return false;
        }
        return super.onPreDataReceived(wXRechargeOrder);
    }
}
