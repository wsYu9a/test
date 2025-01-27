package b.d.e.a.i.d;

import android.app.Activity;
import android.view.View;
import b.d.e.a.j.h;
import com.martian.ttbook.sdk.client.AdBiddingLossReason;
import com.martian.ttbook.sdk.client.AdDownloadConfirmListener;
import com.martian.ttbook.sdk.client.AdExtras;
import com.martian.ttbook.sdk.client.feedlist.AdView;

/* loaded from: classes4.dex */
public class c implements AdView {

    /* renamed from: a */
    private com.martian.ttbook.b.c.a.a.c.l.b f4512a;

    /* renamed from: b */
    private boolean f4513b = false;

    public c(com.martian.ttbook.b.c.a.a.c.l.b bVar) {
        this.f4512a = bVar;
    }

    @Override // com.martian.ttbook.sdk.client.feedlist.AdView
    public AdExtras getAdExtras() {
        AdExtras adExtras = AdExtras.EMPTY;
        com.martian.ttbook.b.c.a.a.c.l.b bVar = this.f4512a;
        return bVar != null ? b.d.e.a.a.c(bVar.a()) : adExtras;
    }

    @Override // com.martian.ttbook.sdk.client.feedlist.AdView
    public View getView() {
        return this.f4512a.getView();
    }

    @Override // com.martian.ttbook.sdk.client.data.AdData
    public boolean isRecycled() {
        return this.f4513b;
    }

    @Override // com.martian.ttbook.sdk.client.data.AdData
    public boolean recycle() {
        com.martian.ttbook.b.c.a.a.c.l.b bVar = this.f4512a;
        if (bVar != null) {
            bVar.b();
            this.f4512a = null;
        }
        this.f4513b = true;
        return true;
    }

    @Override // com.martian.ttbook.sdk.client.feedlist.AdView
    public void render() {
        this.f4512a.render();
    }

    @Override // com.martian.ttbook.sdk.client.feedlist.AdView
    public void render(Activity activity) {
        this.f4512a.a(activity);
    }

    @Override // com.martian.ttbook.sdk.client.AdCommonFunction
    public void sendLossNotification(AdBiddingLossReason adBiddingLossReason, int i2, String str) {
        this.f4512a.a(h.a(adBiddingLossReason), i2, str);
    }

    @Override // com.martian.ttbook.sdk.client.AdCommonFunction
    public void sendWinNotification(int i2) {
        this.f4512a.sendWinNotification(i2);
    }

    @Override // com.martian.ttbook.sdk.client.AdCommonFunction
    public void setAdDownloadConfirmListener(AdDownloadConfirmListener adDownloadConfirmListener) {
        this.f4512a.c(new b.d.e.a.c(adDownloadConfirmListener));
    }
}
