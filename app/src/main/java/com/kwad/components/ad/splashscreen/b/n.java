package com.kwad.components.ad.splashscreen.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.kwad.sdk.utils.v;

/* loaded from: classes2.dex */
public final class n extends e {
    private com.kwad.sdk.core.download.kwai.a Db;

    /* renamed from: com.kwad.components.ad.splashscreen.b.n$1 */
    final class AnonymousClass1 extends com.kwad.sdk.core.download.kwai.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
        }

        @Override // com.kwad.sdk.core.download.kwai.a, com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadStarted() {
            String str;
            super.onDownloadStarted();
            Context context = n.this.getContext();
            if (context != null) {
                String S = n.S(context);
                if (S != null) {
                    str = S + ":已开始下载";
                } else {
                    str = "已开始下载";
                }
                v.H(context, str);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
        }
    }

    public static String S(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            return context.getResources().getString(packageInfo.applicationInfo.labelRes);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AnonymousClass1 anonymousClass1 = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.splashscreen.b.n.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
            }

            @Override // com.kwad.sdk.core.download.kwai.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                String str;
                super.onDownloadStarted();
                Context context = n.this.getContext();
                if (context != null) {
                    String S = n.S(context);
                    if (S != null) {
                        str = S + ":已开始下载";
                    } else {
                        str = "已开始下载";
                    }
                    v.H(context, str);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
            }
        };
        this.Db = anonymousClass1;
        this.Cg.mApkDownloadHelper.b(anonymousClass1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.sdk.core.download.kwai.a aVar = this.Db;
        if (aVar != null) {
            this.Cg.mApkDownloadHelper.c(aVar);
        }
    }
}
