package jc;

import com.martian.mibook.lib.yuewen.request.YWRankBooksParams;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;

/* loaded from: classes3.dex */
public abstract class m extends jb.d<YWRankBooksParams, YWChannelBookList> {
    public m() {
        super(YWRankBooksParams.class, YWChannelBookList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(YWChannelBookList yWChannelBookList) {
        if (yWChannelBookList == null || yWChannelBookList.getBookList() == null) {
            return false;
        }
        return super.onPreDataReceived(yWChannelBookList);
    }
}
