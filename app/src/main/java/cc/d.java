package cc;

import com.martian.mibook.lib.original.data.ORChapterList;
import com.martian.mibook.lib.original.http.request.ORChapterListParams;
import kb.c0;

/* loaded from: classes3.dex */
public abstract class d extends c0<ORChapterListParams, ORChapterList> {
    public d() {
        super(ORChapterListParams.class, ORChapterList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(ORChapterList oRChapterList) {
        if (oRChapterList == null || oRChapterList.getChapters() == null) {
            return false;
        }
        return super.onPreDataReceived(oRChapterList);
    }
}
