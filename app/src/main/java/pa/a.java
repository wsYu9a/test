package pa;

import com.martian.mibook.account.request.book.MiBookGetCommentByScoreParams;
import com.martian.mibook.data.book.MiBookGetCommentByScoreItemList;

/* loaded from: classes3.dex */
public abstract class a extends jb.d<MiBookGetCommentByScoreParams, MiBookGetCommentByScoreItemList> {
    public a() {
        super(MiBookGetCommentByScoreParams.class, MiBookGetCommentByScoreItemList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(MiBookGetCommentByScoreItemList miBookGetCommentByScoreItemList) {
        if (miBookGetCommentByScoreItemList == null || miBookGetCommentByScoreItemList.getCommentList() == null) {
            return false;
        }
        return super.onPreDataReceived(miBookGetCommentByScoreItemList);
    }
}
