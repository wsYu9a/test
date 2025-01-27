package jc;

import com.martian.mibook.lib.yuewen.request.YWFinishedBooksParams;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;

/* loaded from: classes3.dex */
public abstract class k extends jb.d<YWFinishedBooksParams, YWChannelBookList> {
    public k() {
        super(YWFinishedBooksParams.class, YWChannelBookList.class);
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
