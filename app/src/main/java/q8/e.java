package q8;

import com.martian.free.request.TFSearchBookParams;
import com.martian.mibook.lib.model.data.TYSearchBookList;
import kb.c0;

/* loaded from: classes3.dex */
public abstract class e extends c0<TFSearchBookParams, TYSearchBookList> {
    public e() {
        super(TFSearchBookParams.class, TYSearchBookList.class);
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
