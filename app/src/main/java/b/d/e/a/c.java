package b.d.e.a;

import android.app.Activity;
import com.martian.ttbook.b.c.a.a.b.a.c;
import com.martian.ttbook.sdk.client.AdDownloadConfirmListener;
import com.martian.ttbook.sdk.client.AdError;
import com.martian.ttbook.sdk.client.AdExtras;
import com.martian.ttbook.sdk.client.data.AdAppInfoData;

/* loaded from: classes4.dex */
public class c implements com.martian.ttbook.b.c.a.a.b.a.c {

    /* renamed from: a */
    private AdDownloadConfirmListener f4491a;

    class a implements AdDownloadConfirmListener.Controller {

        /* renamed from: a */
        final /* synthetic */ c.b f4492a;

        /* renamed from: b.d.e.a.c$a$a */
        class C0015a implements c.a {

            /* renamed from: a */
            final /* synthetic */ AdDownloadConfirmListener.ApkInfoLoadListener f4493a;

            C0015a(a aVar, AdDownloadConfirmListener.ApkInfoLoadListener apkInfoLoadListener) {
                this.f4493a = apkInfoLoadListener;
            }

            @Override // com.martian.ttbook.b.c.a.a.b.a.c.a
            public void a(com.martian.ttbook.b.c.a.a.c.d dVar) {
                this.f4493a.onApkInfoLoadFailed(new AdError(dVar.a(), dVar.b()));
            }

            @Override // com.martian.ttbook.b.c.a.a.b.a.c.a
            public void b(com.martian.ttbook.b.c.a.a.b.a.b bVar) {
                if (bVar != null) {
                    this.f4493a.onApkInfo(new AdAppInfoData(bVar.a(), bVar.b(), bVar.h(), bVar.c(), bVar.g(), bVar.f(), bVar.e(), bVar.d()), AdExtras.EMPTY);
                }
            }
        }

        a(c cVar, c.b bVar) {
            this.f4492a = bVar;
        }

        @Override // com.martian.ttbook.sdk.client.AdDownloadConfirmListener.Controller
        public void loadAppInfo(AdDownloadConfirmListener.ApkInfoLoadListener apkInfoLoadListener) {
            this.f4492a.a(new C0015a(this, apkInfoLoadListener));
        }

        @Override // com.martian.ttbook.sdk.client.AdDownloadConfirmListener.Controller
        public void onCancel() {
            this.f4492a.onCancel();
        }

        @Override // com.martian.ttbook.sdk.client.AdDownloadConfirmListener.Controller
        public void onConfirm() {
            this.f4492a.onConfirm();
        }
    }

    public c(AdDownloadConfirmListener adDownloadConfirmListener) {
        this.f4491a = adDownloadConfirmListener;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.c
    public void a(Activity activity, int i2, c.b bVar) {
        this.f4491a.onDownloadConfirm(activity, i2, new a(this, bVar));
    }
}
