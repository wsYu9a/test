package q8;

import android.app.Activity;
import com.martian.free.request.TFBuyChapterParams;
import com.martian.mibook.lib.account.response.ChapterPrice;
import jb.k;

/* loaded from: classes3.dex */
public abstract class b extends k<TFBuyChapterParams, ChapterPrice> {
    public b(Activity activity) {
        super(activity, TFBuyChapterParams.class, ChapterPrice.class);
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
