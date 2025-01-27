package b.a.a.a.c.d.b;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.vivo.mobilead.util.k0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class g extends a<TTAdNative.NativeAdListener> implements TTAdNative.NativeAdListener {
    public g(TTAdNative.NativeAdListener nativeAdListener, String str, int i2) {
        super(nativeAdListener, str, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
    public void onNativeAdLoad(List<TTNativeAd> list) {
        k0.d(this.f4185b, this.f4186c);
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<TTNativeAd> it = list.iterator();
            while (it.hasNext()) {
                TTNativeAd next = it.next();
                arrayList.add(next == null ? null : new b.a.a.a.c.d.a.h(next, this.f4185b, this.f4186c));
            }
        }
        T t = this.f4184a;
        if (t != 0) {
            ((TTAdNative.NativeAdListener) t).onNativeAdLoad(arrayList);
        }
    }
}
