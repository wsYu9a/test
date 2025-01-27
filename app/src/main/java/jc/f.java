package jc;

import android.app.Activity;
import com.martian.mibook.lib.account.response.ChapterPrice;
import com.martian.mibook.lib.yuewen.request.YWBuyChapterParams;

/* loaded from: classes3.dex */
public abstract class f extends jb.k<YWBuyChapterParams, ChapterPrice> {
    public f(Activity activity) {
        super(activity, YWBuyChapterParams.class, ChapterPrice.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(ChapterPrice chapterPrice) {
        if (chapterPrice == null) {
            return false;
        }
        return super.onPreDataReceived(chapterPrice);
    }
}
