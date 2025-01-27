package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import com.kwad.sdk.utils.z;

/* loaded from: classes2.dex */
public final class o extends e {
    private com.kwad.sdk.core.download.a.a Fy;

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.o$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.download.a.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
        }

        @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadStarted() {
            String str;
            super.onDownloadStarted();
            Context context = o.this.getContext();
            if (context != null) {
                String ci2 = com.kwad.sdk.utils.l.ci(context);
                if (ci2 != null) {
                    str = ci2 + ":已开始下载";
                } else {
                    str = "已开始下载";
                }
                z.P(context, str);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        AnonymousClass1 anonymousClass1 = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.o.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
            }

            @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                String str;
                super.onDownloadStarted();
                Context context = o.this.getContext();
                if (context != null) {
                    String ci2 = com.kwad.sdk.utils.l.ci(context);
                    if (ci2 != null) {
                        str = ci2 + ":已开始下载";
                    } else {
                        str = "已开始下载";
                    }
                    z.P(context, str);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i10) {
            }
        };
        this.Fy = anonymousClass1;
        this.EJ.mApkDownloadHelper.b(anonymousClass1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.sdk.core.download.a.a aVar = this.Fy;
        if (aVar != null) {
            this.EJ.mApkDownloadHelper.c(aVar);
        }
    }
}
