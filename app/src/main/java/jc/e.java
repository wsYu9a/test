package jc;

import android.app.Activity;
import com.martian.mibook.lib.yuewen.request.YWBuyBookParams;
import com.martian.mibook.lib.yuewen.response.YWBookPrice;

/* loaded from: classes3.dex */
public abstract class e extends jb.k<YWBuyBookParams, YWBookPrice> {
    public e(Activity activity) {
        super(activity, YWBuyBookParams.class, YWBookPrice.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(YWBookPrice yWBookPrice) {
        if (yWBookPrice == null) {
            return false;
        }
        return super.onPreDataReceived(yWBookPrice);
    }
}
