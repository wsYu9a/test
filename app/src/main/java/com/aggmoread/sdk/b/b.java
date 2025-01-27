package com.aggmoread.sdk.b;

import android.app.Activity;
import com.aggmoread.sdk.client.AMAdApkInfo;
import com.aggmoread.sdk.client.AMAdDownloadConfirmListener;
import com.aggmoread.sdk.client.AMError;
import com.aggmoread.sdk.z.d.a.a.d.a.c;

/* loaded from: classes.dex */
public class b implements com.aggmoread.sdk.z.d.a.a.d.a.c {

    /* renamed from: a */
    private AMAdDownloadConfirmListener f4076a;

    public class a implements AMAdDownloadConfirmListener.Controller {

        /* renamed from: a */
        final /* synthetic */ c.b f4077a;

        /* renamed from: com.aggmoread.sdk.b.b$a$a */
        public class C0048a implements c.a {

            /* renamed from: a */
            final /* synthetic */ AMAdDownloadConfirmListener.ApkInfoLoadListener f4078a;

            public C0048a(a aVar, AMAdDownloadConfirmListener.ApkInfoLoadListener apkInfoLoadListener) {
                this.f4078a = apkInfoLoadListener;
            }

            @Override // com.aggmoread.sdk.z.d.a.a.d.a.c.a
            public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
                this.f4078a.onApkInfoLoadFailed(new AMError(dVar.a(), dVar.b()));
            }

            @Override // com.aggmoread.sdk.z.d.a.a.d.a.c.a
            public void a(com.aggmoread.sdk.z.d.a.a.d.a.b bVar) {
                this.f4078a.onApkInfo(new AMAdApkInfo(bVar.a(), bVar.b(), bVar.h(), bVar.c(), bVar.g(), bVar.f(), bVar.e(), bVar.d()));
            }
        }

        public a(b bVar, c.b bVar2) {
            this.f4077a = bVar2;
        }

        @Override // com.aggmoread.sdk.client.AMAdDownloadConfirmListener.Controller
        public void loadAppInfo(AMAdDownloadConfirmListener.ApkInfoLoadListener apkInfoLoadListener) {
            this.f4077a.a(new C0048a(this, apkInfoLoadListener));
        }

        @Override // com.aggmoread.sdk.client.AMAdDownloadConfirmListener.Controller
        public void onCancel() {
            this.f4077a.onCancel();
        }

        @Override // com.aggmoread.sdk.client.AMAdDownloadConfirmListener.Controller
        public void onConfirm() {
            this.f4077a.onConfirm();
        }
    }

    public b(AMAdDownloadConfirmListener aMAdDownloadConfirmListener) {
        this.f4076a = aMAdDownloadConfirmListener;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.c
    public void a(Activity activity, int i10, c.b bVar) {
        this.f4076a.onDownloadConfirm(activity, i10, new a(this, bVar));
    }
}
