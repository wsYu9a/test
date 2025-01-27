package fc;

import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.lib.original.request.CPORBooksListParams;
import jb.d;

/* loaded from: classes3.dex */
public abstract class a extends d<CPORBooksListParams, TYSearchBookList> {
    public a() {
        super(CPORBooksListParams.class, TYSearchBookList.class);
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
