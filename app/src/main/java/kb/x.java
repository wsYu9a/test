package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.RechargeOrderParams;
import com.martian.mibook.lib.account.response.MiRechargeOrder;

/* loaded from: classes3.dex */
public abstract class x extends jb.k<RechargeOrderParams, MiRechargeOrder> {
    public x(Activity activity) {
        super(activity, RechargeOrderParams.class, MiRechargeOrder.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(MiRechargeOrder miRechargeOrder) {
        if (miRechargeOrder == null) {
            return false;
        }
        return super.onPreDataReceived(miRechargeOrder);
    }
}
