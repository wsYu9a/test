package q8;

import com.martian.free.request.TFChapterListParams;
import com.martian.free.response.TFChapterList;

/* loaded from: classes3.dex */
public abstract class d extends jb.d<TFChapterListParams, TFChapterList> {
    public d() {
        super(TFChapterListParams.class, TFChapterList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(TFChapterList tFChapterList) {
        if (tFChapterList == null || tFChapterList.getChapters() == null) {
            return false;
        }
        return super.onPreDataReceived(tFChapterList);
    }
}
