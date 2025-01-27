package jc;

import com.martian.mibook.lib.yuewen.request.YWSearchRankParams;
import com.martian.mibook.lib.yuewen.response.TYSearchRankList;

/* loaded from: classes3.dex */
public abstract class o extends jb.d<YWSearchRankParams, TYSearchRankList> {
    public o() {
        super(YWSearchRankParams.class, TYSearchRankList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(TYSearchRankList tYSearchRankList) {
        if (tYSearchRankList == null || tYSearchRankList.getSearchRanks() == null) {
            return false;
        }
        return super.onPreDataReceived(tYSearchRankList);
    }
}
