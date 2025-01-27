package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.CreatAliPrepayParams;
import com.martian.mibook.lib.account.response.AliRechargeOrder;

/* loaded from: classes3.dex */
public abstract class g extends jb.k<CreatAliPrepayParams, AliRechargeOrder> {
    public g(Activity activity) {
        super(activity, CreatAliPrepayParams.class, AliRechargeOrder.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(AliRechargeOrder aliRechargeOrder) {
        if (aliRechargeOrder == null) {
            return false;
        }
        return super.onPreDataReceived(aliRechargeOrder);
    }
}
