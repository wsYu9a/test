package jc;

import com.martian.mibook.lib.yuewen.request.GetInitialBooksParams;
import com.martian.mibook.lib.yuewen.response.TYInitialBookList;

/* loaded from: classes3.dex */
public abstract class a extends jb.d<GetInitialBooksParams, TYInitialBookList> {
    public a() {
        super(GetInitialBooksParams.class, TYInitialBookList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(TYInitialBookList tYInitialBookList) {
        if (tYInitialBookList == null || tYInitialBookList.getBookList() == null) {
            return false;
        }
        return super.onPreDataReceived(tYInitialBookList);
    }
}
