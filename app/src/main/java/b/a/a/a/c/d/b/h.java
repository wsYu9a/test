package b.a.a.a.c.d.b;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.vivo.mobilead.util.k0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class h extends a<TTAdNative.NativeExpressAdListener> implements TTAdNative.NativeExpressAdListener {
    public h(TTAdNative.NativeExpressAdListener nativeExpressAdListener, String str, int i2) {
        super(nativeExpressAdListener, str, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        k0.d(this.f4185b, this.f4186c);
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<TTNativeExpressAd> it = list.iterator();
            while (it.hasNext()) {
                TTNativeExpressAd next = it.next();
                arrayList.add(next == null ? null : new b.a.a.a.c.d.a.i(next, this.f4185b, this.f4186c));
            }
        }
        T t = this.f4184a;
        if (t != 0) {
            ((TTAdNative.NativeExpressAdListener) t).onNativeExpressAdLoad(arrayList);
        }
    }
}
