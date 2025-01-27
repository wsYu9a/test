package jc;

import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.lib.yuewen.request.YWSearchBookParams;
import kb.c0;

/* loaded from: classes3.dex */
public abstract class n extends c0<YWSearchBookParams, TYSearchBookList> {
    public n() {
        super(YWSearchBookParams.class, TYSearchBookList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(TYSearchBookList tYSearchBookList) {
        if (tYSearchBookList == null || tYSearchBookList.getBookItemList() == null) {
            return false;
        }
        return super.onPreDataReceived(tYSearchBookList);
    }
}
