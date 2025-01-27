package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.MartianGetHistoryDurationParams;
import com.martian.mibook.lib.account.response.HistoryDurationList;

/* loaded from: classes3.dex */
public abstract class s extends jb.k<MartianGetHistoryDurationParams, HistoryDurationList> {
    public s(Activity activity) {
        super(activity, MartianGetHistoryDurationParams.class, HistoryDurationList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(HistoryDurationList historyDurationList) {
        if (historyDurationList == null || historyDurationList.getDurationList() == null) {
            return false;
        }
        return super.onPreDataReceived(historyDurationList);
    }
}
