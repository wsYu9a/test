package cc;

import android.app.Activity;
import com.martian.mibook.lib.original.http.request.ConsumeChapterParams;
import com.martian.mibook.lib.original.http.response.MiConsumeOrder;
import jb.k;

/* loaded from: classes3.dex */
public abstract class a extends k<ConsumeChapterParams, MiConsumeOrder> {
    public a(Activity activity) {
        super(activity, ConsumeChapterParams.class, MiConsumeOrder.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(MiConsumeOrder miConsumeOrder) {
        if (miConsumeOrder == null) {
            return false;
        }
        return super.onPreDataReceived(miConsumeOrder);
    }
}
