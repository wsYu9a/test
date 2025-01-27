package jc;

import com.martian.mibook.lib.yuewen.request.YWChannelBooksParams;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;

/* loaded from: classes3.dex */
public abstract class h extends jb.d<YWChannelBooksParams, YWChannelBookList> {
    public h() {
        super(YWChannelBooksParams.class, YWChannelBookList.class);
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
