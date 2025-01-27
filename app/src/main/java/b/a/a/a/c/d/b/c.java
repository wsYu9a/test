package b.a.a.a.c.d.b;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.vivo.mobilead.util.k0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class c extends a<TTAdNative.DrawFeedAdListener> implements TTAdNative.DrawFeedAdListener {
    public c(TTAdNative.DrawFeedAdListener drawFeedAdListener, String str, int i2) {
        super(drawFeedAdListener, str, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
    public void onDrawFeedAdLoad(List<TTDrawFeedAd> list) {
        k0.d(this.f4185b, this.f4186c);
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<TTDrawFeedAd> it = list.iterator();
            while (it.hasNext()) {
                TTDrawFeedAd next = it.next();
                arrayList.add(next == null ? null : new b.a.a.a.c.d.a.d(next, this.f4185b, this.f4186c));
            }
        }
        T t = this.f4184a;
        if (t != 0) {
            ((TTAdNative.DrawFeedAdListener) t).onDrawFeedAdLoad(arrayList);
        }
    }
}
