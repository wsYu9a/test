package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.e.b;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b implements com.ss.android.downloadad.api.b {

    /* renamed from: a */
    private static String f21501a = "b";

    /* renamed from: b */
    private static volatile b f21502b;

    /* renamed from: c */
    private i f21503c = i.a(k.a());

    /* renamed from: com.ss.android.downloadlib.b$1 */
    public class AnonymousClass1 implements b.a<Dialog> {

        /* renamed from: a */
        final /* synthetic */ Context f21504a;

        /* renamed from: b */
        final /* synthetic */ String f21505b;

        /* renamed from: c */
        final /* synthetic */ boolean f21506c;

        /* renamed from: d */
        final /* synthetic */ DownloadModel f21507d;

        /* renamed from: e */
        final /* synthetic */ DownloadEventConfig f21508e;

        /* renamed from: f */
        final /* synthetic */ DownloadController f21509f;

        /* renamed from: g */
        final /* synthetic */ DownloadStatusChangeListener f21510g;

        /* renamed from: h */
        final /* synthetic */ int f21511h;

        /* renamed from: i */
        final /* synthetic */ boolean f21512i;

        /* renamed from: j */
        final /* synthetic */ IDownloadButtonClickListener f21513j;

        public AnonymousClass1(Context context, String str, boolean z10, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i10, boolean z11, IDownloadButtonClickListener iDownloadButtonClickListener) {
            context = context;
            str = str;
            z10 = z10;
            downloadModel = downloadModel;
            downloadEventConfig = downloadEventConfig;
            downloadController = downloadController;
            downloadStatusChangeListener = downloadStatusChangeListener;
            i10 = i10;
            z11 = z11;
            iDownloadButtonClickListener = iDownloadButtonClickListener;
        }

        @Override // com.ss.android.downloadlib.e.b.a
        /* renamed from: a */
        public Dialog b() {
            return b.this.b(context, str, z10, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i10, z11, iDownloadButtonClickListener);
        }
    }

    /* renamed from: com.ss.android.downloadlib.b$2 */
    public class AnonymousClass2 implements b.InterfaceC0631b {

        /* renamed from: a */
        final /* synthetic */ DownloadModel f21515a;

        /* renamed from: b */
        final /* synthetic */ DownloadEventConfig f21516b;

        /* renamed from: c */
        final /* synthetic */ DownloadController f21517c;

        public AnonymousClass2(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
            downloadModel = downloadModel;
            downloadEventConfig2 = downloadEventConfig;
            downloadController2 = downloadController;
        }

        @Override // com.ss.android.download.api.model.b.InterfaceC0631b
        public void a(DialogInterface dialogInterface) {
            b.this.f21503c.a(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
            com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_confirm", downloadModel, downloadEventConfig2, downloadController2);
            dialogInterface.dismiss();
        }

        @Override // com.ss.android.download.api.model.b.InterfaceC0631b
        public void b(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
            dialogInterface.dismiss();
        }

        @Override // com.ss.android.download.api.model.b.InterfaceC0631b
        public void c(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
        }
    }

    /* renamed from: com.ss.android.downloadlib.b$3 */
    public class AnonymousClass3 implements b.a<Boolean> {

        /* renamed from: a */
        final /* synthetic */ Context f21519a;

        /* renamed from: b */
        final /* synthetic */ Uri f21520b;

        /* renamed from: c */
        final /* synthetic */ DownloadModel f21521c;

        /* renamed from: d */
        final /* synthetic */ DownloadEventConfig f21522d;

        /* renamed from: e */
        final /* synthetic */ DownloadController f21523e;

        /* renamed from: f */
        final /* synthetic */ IDownloadButtonClickListener f21524f;

        public AnonymousClass3(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
            context = context;
            uri = uri;
            downloadModel = downloadModel;
            downloadEventConfig = downloadEventConfig;
            downloadController = downloadController;
            iDownloadButtonClickListener = iDownloadButtonClickListener;
        }

        @Override // com.ss.android.downloadlib.e.b.a
        /* renamed from: a */
        public Boolean b() {
            return Boolean.valueOf(b.this.b(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener));
        }
    }

    private b() {
    }

    public static DownloadEventConfig c() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag("landing_h5_download_ad_button").setClickItemTag("landing_h5_download_ad_button").setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }

    public Dialog b(Context context, String str, boolean z10, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i10, boolean z11, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (a(downloadModel.getId())) {
            if (z11) {
                a(downloadModel.getId(), downloadEventConfig, downloadController);
            } else {
                b(downloadModel.getId());
            }
            return null;
        }
        if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        }
        this.f21503c.a(context, i10, downloadStatusChangeListener, downloadModel);
        DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) m.a(downloadEventConfig, c());
        DownloadController downloadController2 = (DownloadController) m.a(downloadController, b());
        downloadEventConfig2.setDownloadScene(1);
        if ((downloadController2.enableShowComplianceDialog() && com.ss.android.downloadlib.addownload.compliance.b.a().a(downloadModel)) ? true : (k.j().optInt("disable_lp_dialog", 0) == 1) | z10) {
            this.f21503c.a(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2, iDownloadButtonClickListener);
            return null;
        }
        com.ss.android.downloadlib.g.k.a(f21501a, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
        Dialog b10 = k.d().b(new b.a(context).a(downloadModel.getName()).b("确认要下载此应用吗？").c("确认").d("取消").a(new b.InterfaceC0631b() { // from class: com.ss.android.downloadlib.b.2

            /* renamed from: a */
            final /* synthetic */ DownloadModel f21515a;

            /* renamed from: b */
            final /* synthetic */ DownloadEventConfig f21516b;

            /* renamed from: c */
            final /* synthetic */ DownloadController f21517c;

            public AnonymousClass2(DownloadModel downloadModel2, DownloadEventConfig downloadEventConfig22, DownloadController downloadController22) {
                downloadModel = downloadModel2;
                downloadEventConfig2 = downloadEventConfig22;
                downloadController2 = downloadController22;
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0631b
            public void a(DialogInterface dialogInterface) {
                b.this.f21503c.a(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_confirm", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0631b
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0631b
            public void c(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
            }
        }).a(0).a());
        com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_show", downloadModel2, downloadEventConfig22, downloadController22);
        return b10;
    }

    public static b a() {
        if (f21502b == null) {
            synchronized (b.class) {
                try {
                    if (f21502b == null) {
                        f21502b = new b();
                    }
                } finally {
                }
            }
        }
        return f21502b;
    }

    @Override // com.ss.android.downloadad.api.b
    public Dialog a(Context context, String str, boolean z10, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i10) {
        return a(context, str, z10, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i10, false);
    }

    @Override // com.ss.android.downloadad.api.b
    public Dialog a(Context context, String str, boolean z10, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i10, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return a(context, str, z10, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i10, false, iDownloadButtonClickListener);
    }

    public Dialog a(Context context, String str, boolean z10, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i10, boolean z11) {
        return a(context, str, z10, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i10, z11, null);
    }

    public Dialog a(Context context, String str, boolean z10, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i10, boolean z11, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return (Dialog) com.ss.android.downloadlib.e.b.a(new b.a<Dialog>() { // from class: com.ss.android.downloadlib.b.1

            /* renamed from: a */
            final /* synthetic */ Context f21504a;

            /* renamed from: b */
            final /* synthetic */ String f21505b;

            /* renamed from: c */
            final /* synthetic */ boolean f21506c;

            /* renamed from: d */
            final /* synthetic */ DownloadModel f21507d;

            /* renamed from: e */
            final /* synthetic */ DownloadEventConfig f21508e;

            /* renamed from: f */
            final /* synthetic */ DownloadController f21509f;

            /* renamed from: g */
            final /* synthetic */ DownloadStatusChangeListener f21510g;

            /* renamed from: h */
            final /* synthetic */ int f21511h;

            /* renamed from: i */
            final /* synthetic */ boolean f21512i;

            /* renamed from: j */
            final /* synthetic */ IDownloadButtonClickListener f21513j;

            public AnonymousClass1(Context context2, String str2, boolean z102, DownloadModel downloadModel2, DownloadEventConfig downloadEventConfig2, DownloadController downloadController2, DownloadStatusChangeListener downloadStatusChangeListener2, int i102, boolean z112, IDownloadButtonClickListener iDownloadButtonClickListener2) {
                context = context2;
                str = str2;
                z10 = z102;
                downloadModel = downloadModel2;
                downloadEventConfig = downloadEventConfig2;
                downloadController = downloadController2;
                downloadStatusChangeListener = downloadStatusChangeListener2;
                i10 = i102;
                z11 = z112;
                iDownloadButtonClickListener = iDownloadButtonClickListener2;
            }

            @Override // com.ss.android.downloadlib.e.b.a
            /* renamed from: a */
            public Dialog b() {
                return b.this.b(context, str, z10, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i10, z11, iDownloadButtonClickListener);
            }
        });
    }

    @Override // com.ss.android.downloadad.api.b
    public boolean a(Context context, long j10, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i10) {
        com.ss.android.downloadad.api.a.b d10 = com.ss.android.downloadlib.addownload.b.f.a().d(j10);
        if (d10 != null) {
            this.f21503c.a(context, i10, downloadStatusChangeListener, d10.ai());
            return true;
        }
        DownloadModel a10 = com.ss.android.downloadlib.addownload.b.f.a().a(j10);
        if (a10 == null) {
            return false;
        }
        this.f21503c.a(context, i10, downloadStatusChangeListener, a10);
        return true;
    }

    @Override // com.ss.android.downloadad.api.b
    public boolean a(long j10, int i10) {
        DownloadModel a10 = com.ss.android.downloadlib.addownload.b.f.a().a(j10);
        if (a10 == null) {
            return false;
        }
        this.f21503c.a(a10.getDownloadUrl(), i10);
        return true;
    }

    public void a(long j10, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadModel a10 = com.ss.android.downloadlib.addownload.b.f.a().a(j10);
        com.ss.android.downloadad.api.a.b d10 = com.ss.android.downloadlib.addownload.b.f.a().d(j10);
        if (a10 == null && d10 != null) {
            a10 = d10.ai();
        }
        if (a10 == null) {
            return;
        }
        if (downloadEventConfig != null && downloadController != null && !(downloadEventConfig instanceof com.ss.android.download.api.download.c) && !(downloadController instanceof com.ss.android.download.api.download.b)) {
            downloadEventConfig.setDownloadScene(1);
            this.f21503c.a(a10.getDownloadUrl(), j10, 2, downloadEventConfig, downloadController);
        } else {
            b(j10);
        }
    }

    public void b(long j10) {
        DownloadModel a10 = com.ss.android.downloadlib.addownload.b.f.a().a(j10);
        com.ss.android.downloadad.api.a.b d10 = com.ss.android.downloadlib.addownload.b.f.a().d(j10);
        if (a10 == null && d10 != null) {
            a10 = d10.ai();
        }
        if (a10 == null) {
            return;
        }
        DownloadEventConfig b10 = com.ss.android.downloadlib.addownload.b.f.a().b(j10);
        DownloadController c10 = com.ss.android.downloadlib.addownload.b.f.a().c(j10);
        if (b10 instanceof com.ss.android.download.api.download.c) {
            b10 = null;
        }
        if (c10 instanceof com.ss.android.download.api.download.b) {
            c10 = null;
        }
        if (d10 == null) {
            if (b10 == null) {
                b10 = c();
            }
            if (c10 == null) {
                c10 = b();
            }
        } else {
            if (b10 == null) {
                b10 = new AdDownloadEventConfig.Builder().setClickButtonTag(d10.j()).setRefer(d10.i()).setIsEnableV3Event(d10.m()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            if (c10 == null) {
                c10 = d10.ak();
            }
        }
        DownloadEventConfig downloadEventConfig = b10;
        DownloadController downloadController = c10;
        downloadEventConfig.setDownloadScene(1);
        this.f21503c.a(a10.getDownloadUrl(), j10, 2, downloadEventConfig, downloadController);
    }

    @Override // com.ss.android.downloadad.api.b
    public boolean a(long j10) {
        return (com.ss.android.downloadlib.addownload.b.f.a().a(j10) == null && com.ss.android.downloadlib.addownload.b.f.a().d(j10) == null) ? false : true;
    }

    @Override // com.ss.android.downloadad.api.b
    public boolean a(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return a(context, uri, downloadModel, downloadEventConfig, downloadController, null);
    }

    @Override // com.ss.android.downloadad.api.b
    public boolean a(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ((Boolean) com.ss.android.downloadlib.e.b.a(new b.a<Boolean>() { // from class: com.ss.android.downloadlib.b.3

            /* renamed from: a */
            final /* synthetic */ Context f21519a;

            /* renamed from: b */
            final /* synthetic */ Uri f21520b;

            /* renamed from: c */
            final /* synthetic */ DownloadModel f21521c;

            /* renamed from: d */
            final /* synthetic */ DownloadEventConfig f21522d;

            /* renamed from: e */
            final /* synthetic */ DownloadController f21523e;

            /* renamed from: f */
            final /* synthetic */ IDownloadButtonClickListener f21524f;

            public AnonymousClass3(Context context2, Uri uri2, DownloadModel downloadModel2, DownloadEventConfig downloadEventConfig2, DownloadController downloadController2, IDownloadButtonClickListener iDownloadButtonClickListener2) {
                context = context2;
                uri = uri2;
                downloadModel = downloadModel2;
                downloadEventConfig = downloadEventConfig2;
                downloadController = downloadController2;
                iDownloadButtonClickListener = iDownloadButtonClickListener2;
            }

            @Override // com.ss.android.downloadlib.e.b.a
            /* renamed from: a */
            public Boolean b() {
                return Boolean.valueOf(b.this.b(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener));
            }
        })).booleanValue();
    }

    public static DownloadController a(boolean z10) {
        AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z10) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    public boolean b(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        DownloadController downloadController2 = downloadController;
        if (!com.ss.android.download.api.c.a.a(uri) || k.j().optInt("disable_market") == 1) {
            return false;
        }
        Context a10 = context == null ? k.a() : context;
        String b10 = com.ss.android.download.api.c.a.b(uri);
        if (downloadModel == null) {
            return com.ss.android.downloadlib.g.i.a(a10, b10).a() == 5;
        }
        if (!TextUtils.isEmpty(b10) && (downloadModel instanceof AdDownloadModel)) {
            ((AdDownloadModel) downloadModel).setPackageName(b10);
        }
        if (downloadController2 != null) {
            downloadController2.setDownloadMode(2);
        } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
            downloadController2 = a(true);
        } else if (downloadModel.getDownloadUrl().startsWith("market")) {
            downloadController2 = a(true);
        } else {
            downloadController2 = b();
        }
        com.ss.android.downloadlib.addownload.b.e eVar = new com.ss.android.downloadlib.addownload.b.e(downloadModel.getId(), downloadModel, (DownloadEventConfig) m.a(downloadEventConfig, c()), downloadController2);
        com.ss.android.downloadlib.addownload.b.f.a().a(eVar.f21217b);
        com.ss.android.downloadlib.addownload.b.f.a().a(eVar.f21216a, eVar.f21218c);
        com.ss.android.downloadlib.addownload.b.f.a().a(eVar.f21216a, eVar.f21219d);
        if (m.a(downloadModel) && DownloadSetting.obtainGlobal().optInt("app_link_opt") == 1 && com.ss.android.downloadlib.b.a.a(eVar)) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        m.a(jSONObject, "market_url", uri.toString());
        m.a(jSONObject, "download_scene", (Object) 1);
        com.ss.android.downloadlib.d.a.a().b("market_click_open", jSONObject, eVar);
        com.ss.android.downloadlib.addownload.b.g a11 = com.ss.android.downloadlib.g.i.a(a10, eVar, b10);
        String a12 = m.a(a11.c(), PointCategory.OPEN_MARKET);
        if (a11.a() == 5) {
            com.ss.android.downloadlib.b.a.a(a12, jSONObject, eVar, true);
            return true;
        }
        if (a11.a() != 6) {
            return true;
        }
        m.a(jSONObject, "error_code", Integer.valueOf(a11.b()));
        com.ss.android.downloadlib.d.a.a().b("market_open_failed", jSONObject, eVar);
        if (com.ss.android.downloadlib.addownload.i.a(downloadModel, iDownloadButtonClickListener)) {
            iDownloadButtonClickListener.handleMarketFailedComplianceDialog();
        }
        return false;
    }

    public static DownloadController b() {
        return a(false);
    }
}
