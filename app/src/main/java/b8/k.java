package b8;

import com.baidu.mobads.sdk.api.ExpressResponse;
import com.martian.apptask.data.ViewWrapper;

/* loaded from: classes3.dex */
public class k extends ViewWrapper {

    /* renamed from: a */
    public final ExpressResponse f1443a;

    public k(ExpressResponse expressResponse) {
        super(expressResponse.getExpressAdView());
        this.f1443a = expressResponse;
    }

    @Override // com.martian.apptask.data.ViewWrapper
    public void onInit() {
        ExpressResponse expressResponse = this.f1443a;
        if (expressResponse != null) {
            expressResponse.render();
        }
    }

    @Override // com.martian.apptask.data.ViewWrapper
    public void onDestroy() {
    }
}
