package b.d.a;

import com.martian.apptask.data.ViewWrapper;
import com.qq.e.ads.nativ.NativeExpressADView;

/* loaded from: classes2.dex */
public class f extends ViewWrapper {
    public f(NativeExpressADView view) {
        super(view);
    }

    @Override // com.martian.apptask.data.ViewWrapper
    public void onDestroy() {
        NativeExpressADView nativeExpressADView = (NativeExpressADView) getView();
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
        }
    }

    @Override // com.martian.apptask.data.ViewWrapper
    protected void onInit() {
        NativeExpressADView nativeExpressADView = (NativeExpressADView) getView();
        if (nativeExpressADView != null) {
            nativeExpressADView.render();
        }
    }
}
