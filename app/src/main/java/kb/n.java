package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.GetTxsCoinsRecordListParams;
import com.martian.mibook.lib.account.response.MiHistoryBookCoinsList;

/* loaded from: classes3.dex */
public abstract class n extends jb.k<GetTxsCoinsRecordListParams, MiHistoryBookCoinsList> {
    public n(Activity activity) {
        super(activity, GetTxsCoinsRecordListParams.class, MiHistoryBookCoinsList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(MiHistoryBookCoinsList miHistoryBookCoinsList) {
        if (miHistoryBookCoinsList == null) {
            return false;
        }
        return super.onPreDataReceived(miHistoryBookCoinsList);
    }
}
