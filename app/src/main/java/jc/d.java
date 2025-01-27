package jc;

import com.martian.mibook.lib.yuewen.request.YWBookParams;
import com.martian.mibook.lib.yuewen.response.YWBook;

/* loaded from: classes3.dex */
public abstract class d extends jb.d<YWBookParams, YWBook> {
    public d() {
        super(YWBookParams.class, YWBook.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(YWBook yWBook) {
        if (yWBook == null) {
            return false;
        }
        return super.onPreDataReceived(yWBook);
    }
}
