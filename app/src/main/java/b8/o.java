package b8;

import com.martian.apptask.data.ViewWrapper;
import com.qq.e.ads.nativ.NativeExpressADView;

/* loaded from: classes3.dex */
public class o extends ViewWrapper {
    public o(NativeExpressADView nativeExpressADView) {
        super(nativeExpressADView);
    }

    @Override // com.martian.apptask.data.ViewWrapper
    public void onDestroy() {
        NativeExpressADView nativeExpressADView = (NativeExpressADView) getView();
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
        }
    }

    @Override // com.martian.apptask.data.ViewWrapper
    public void onInit() {
        NativeExpressADView nativeExpressADView = (NativeExpressADView) getView();
        if (nativeExpressADView != null) {
            nativeExpressADView.render();
        }
    }
}
