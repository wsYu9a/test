package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.MartianGetHistoryMoneyParams;
import com.martian.mibook.lib.account.response.HistoryMoneyList;

/* loaded from: classes3.dex */
public abstract class t extends jb.k<MartianGetHistoryMoneyParams, HistoryMoneyList> {
    public t(Activity activity) {
        super(activity, MartianGetHistoryMoneyParams.class, HistoryMoneyList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(HistoryMoneyList historyMoneyList) {
        if (historyMoneyList == null || historyMoneyList.getHistoryMoneyList() == null) {
            return false;
        }
        return super.onPreDataReceived(historyMoneyList);
    }
}
