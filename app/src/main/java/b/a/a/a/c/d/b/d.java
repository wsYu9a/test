package b.a.a.a.c.d.b;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.vivo.mobilead.util.k0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class d extends a<TTAdNative.FeedAdListener> implements TTAdNative.FeedAdListener {
    public d(TTAdNative.FeedAdListener feedAdListener, String str, int i2) {
        super(feedAdListener, str, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
    public void onFeedAdLoad(List<TTFeedAd> list) {
        k0.d(this.f4185b, this.f4186c);
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<TTFeedAd> it = list.iterator();
            while (it.hasNext()) {
                TTFeedAd next = it.next();
                arrayList.add(next == null ? null : new b.a.a.a.c.d.a.e(next, this.f4185b, this.f4186c));
            }
        }
        T t = this.f4184a;
        if (t != 0) {
            ((TTAdNative.FeedAdListener) t).onFeedAdLoad(arrayList);
        }
    }
}
