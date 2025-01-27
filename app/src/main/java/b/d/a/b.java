package b.d.a;

import com.baidu.mobads.sdk.api.XNativeView;
import com.martian.apptask.data.ViewWrapper;

/* loaded from: classes2.dex */
public class b extends ViewWrapper {

    /* renamed from: a */
    private final XNativeView f4357a;

    public b(XNativeView ad2) {
        super(ad2.getRootView());
        this.f4357a = ad2;
    }

    @Override // com.martian.apptask.data.ViewWrapper
    public void onDestroy() {
        XNativeView xNativeView = this.f4357a;
        if (xNativeView != null) {
            xNativeView.stop();
        }
    }

    @Override // com.martian.apptask.data.ViewWrapper
    protected void onInit() {
        XNativeView xNativeView = this.f4357a;
        if (xNativeView != null) {
            xNativeView.render();
        }
    }
}
