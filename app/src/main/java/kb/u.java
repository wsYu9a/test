package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.MartianGetWithdrawOrdersParams;
import com.martian.mibook.lib.account.response.MartianWithdrawOrderList;

/* loaded from: classes3.dex */
public abstract class u extends jb.k<MartianGetWithdrawOrdersParams, MartianWithdrawOrderList> {
    public u(Activity activity) {
        super(activity, MartianGetWithdrawOrdersParams.class, MartianWithdrawOrderList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(MartianWithdrawOrderList martianWithdrawOrderList) {
        if (martianWithdrawOrderList == null || martianWithdrawOrderList.getWithdrawOrders() == null) {
            return false;
        }
        return super.onPreDataReceived(martianWithdrawOrderList);
    }
}
