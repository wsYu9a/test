package jc;

import com.martian.mibook.lib.yuewen.request.YWCategoryBookListParams;
import com.martian.mibook.lib.yuewen.response.YWCategoryBookList;

/* loaded from: classes3.dex */
public abstract class g extends jb.d<YWCategoryBookListParams, YWCategoryBookList> {
    public g() {
        super(YWCategoryBookListParams.class, YWCategoryBookList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(YWCategoryBookList yWCategoryBookList) {
        if (yWCategoryBookList == null || yWCategoryBookList.getBookList() == null) {
            return false;
        }
        return super.onPreDataReceived(yWCategoryBookList);
    }
}
