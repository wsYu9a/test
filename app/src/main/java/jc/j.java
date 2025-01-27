package jc;

import com.martian.mibook.lib.yuewen.request.YWChapterListParams;
import com.martian.mibook.lib.yuewen.response.YWChapterList;

/* loaded from: classes3.dex */
public abstract class j extends jb.d<YWChapterListParams, YWChapterList> {
    public j() {
        super(YWChapterListParams.class, YWChapterList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(YWChapterList yWChapterList) {
        if (yWChapterList == null || yWChapterList.getChapters() == null) {
            return false;
        }
        return super.onPreDataReceived(yWChapterList);
    }
}
