package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.zx;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.lg.k;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.downloadlib.lg.t;
import com.ss.android.downloadlib.q.zx;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class zx implements com.ss.android.downloadad.api.zx {

    /* renamed from: j */
    private static String f24373j = "zx";
    private static volatile zx zx;

    /* renamed from: i */
    private y f24374i = y.j(pa.getContext());

    /* renamed from: com.ss.android.downloadlib.zx$1 */
    class AnonymousClass1 implements zx.j<Dialog> {

        /* renamed from: g */
        final /* synthetic */ DownloadModel f24375g;
        final /* synthetic */ DownloadController gv;

        /* renamed from: i */
        final /* synthetic */ boolean f24376i;

        /* renamed from: j */
        final /* synthetic */ Context f24377j;
        final /* synthetic */ boolean k;
        final /* synthetic */ DownloadStatusChangeListener lg;
        final /* synthetic */ IDownloadButtonClickListener pa;
        final /* synthetic */ DownloadEventConfig q;
        final /* synthetic */ int y;
        final /* synthetic */ String zx;

        AnonymousClass1(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2, boolean z2, IDownloadButtonClickListener iDownloadButtonClickListener) {
            context = context;
            str = str;
            z = z;
            downloadModel = downloadModel;
            downloadEventConfig = downloadEventConfig;
            downloadController = downloadController;
            downloadStatusChangeListener = downloadStatusChangeListener;
            i2 = i2;
            z2 = z2;
            iDownloadButtonClickListener = iDownloadButtonClickListener;
        }

        @Override // com.ss.android.downloadlib.q.zx.j
        /* renamed from: j */
        public Dialog zx() {
            return zx.this.zx(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i2, z2, iDownloadButtonClickListener);
        }
    }

    /* renamed from: com.ss.android.downloadlib.zx$2 */
    class AnonymousClass2 implements zx.InterfaceC0493zx {

        /* renamed from: i */
        final /* synthetic */ DownloadController f24379i;

        /* renamed from: j */
        final /* synthetic */ DownloadModel f24380j;
        final /* synthetic */ DownloadEventConfig zx;

        AnonymousClass2(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
            downloadModel = downloadModel;
            downloadEventConfig2 = downloadEventConfig;
            downloadController2 = downloadController;
        }

        @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
        public void i(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.g.j.j().j("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
        }

        @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
        public void j(DialogInterface dialogInterface) {
            zx.this.f24374i.j(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
            com.ss.android.downloadlib.g.j.j().j("landing_download_dialog_confirm", downloadModel, downloadEventConfig2, downloadController2);
            dialogInterface.dismiss();
        }

        @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
        public void zx(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.g.j.j().j("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.ss.android.downloadlib.zx$3 */
    class AnonymousClass3 implements zx.j<Boolean> {

        /* renamed from: g */
        final /* synthetic */ DownloadEventConfig f24381g;
        final /* synthetic */ IDownloadButtonClickListener gv;

        /* renamed from: i */
        final /* synthetic */ DownloadModel f24382i;

        /* renamed from: j */
        final /* synthetic */ Context f24383j;
        final /* synthetic */ DownloadController q;
        final /* synthetic */ Uri zx;

        AnonymousClass3(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
            context = context;
            uri = uri;
            downloadModel = downloadModel;
            downloadEventConfig = downloadEventConfig;
            downloadController = downloadController;
            iDownloadButtonClickListener = iDownloadButtonClickListener;
        }

        @Override // com.ss.android.downloadlib.q.zx.j
        /* renamed from: j */
        public Boolean zx() {
            return Boolean.valueOf(zx.this.zx(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener));
        }
    }

    private zx() {
    }

    public static DownloadEventConfig i() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag("landing_h5_download_ad_button").setClickItemTag("landing_h5_download_ad_button").setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }

    public Dialog zx(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2, boolean z2, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (j(downloadModel.getId())) {
            if (z2) {
                j(downloadModel.getId(), downloadEventConfig, downloadController);
            } else {
                zx(downloadModel.getId());
            }
            return null;
        }
        if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        }
        this.f24374i.j(context, i2, downloadStatusChangeListener, downloadModel);
        DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) nt.j(downloadEventConfig, i());
        DownloadController downloadController2 = (DownloadController) nt.j(downloadController, zx());
        downloadEventConfig2.setDownloadScene(1);
        if ((downloadController2.enableShowComplianceDialog() && com.ss.android.downloadlib.addownload.compliance.zx.j().j(downloadModel)) ? true : (pa.k().optInt("disable_lp_dialog", 0) == 1) | z) {
            this.f24374i.j(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2, iDownloadButtonClickListener);
            return null;
        }
        t.j(f24373j, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
        Dialog zx2 = pa.i().zx(new zx.j(context).j(downloadModel.getName()).zx("确认要下载此应用吗？").i("确认").g("取消").j(new zx.InterfaceC0493zx() { // from class: com.ss.android.downloadlib.zx.2

            /* renamed from: i */
            final /* synthetic */ DownloadController f24379i;

            /* renamed from: j */
            final /* synthetic */ DownloadModel f24380j;
            final /* synthetic */ DownloadEventConfig zx;

            AnonymousClass2(DownloadModel downloadModel2, DownloadEventConfig downloadEventConfig22, DownloadController downloadController22) {
                downloadModel = downloadModel2;
                downloadEventConfig2 = downloadEventConfig22;
                downloadController2 = downloadController22;
            }

            @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
            public void i(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.g.j.j().j("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
            }

            @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
            public void j(DialogInterface dialogInterface) {
                zx.this.f24374i.j(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                com.ss.android.downloadlib.g.j.j().j("landing_download_dialog_confirm", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
            public void zx(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.g.j.j().j("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }
        }).j(0).j());
        com.ss.android.downloadlib.g.j.j().j("landing_download_dialog_show", downloadModel2, downloadEventConfig22, downloadController22);
        return zx2;
    }

    public static zx j() {
        if (zx == null) {
            synchronized (zx.class) {
                if (zx == null) {
                    zx = new zx();
                }
            }
        }
        return zx;
    }

    @Override // com.ss.android.downloadad.api.zx
    public Dialog j(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2) {
        return j(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i2, false);
    }

    @Override // com.ss.android.downloadad.api.zx
    public Dialog j(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return j(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i2, false, iDownloadButtonClickListener);
    }

    public Dialog j(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2, boolean z2) {
        return j(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i2, z2, null);
    }

    public Dialog j(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2, boolean z2, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return (Dialog) com.ss.android.downloadlib.q.zx.j(new zx.j<Dialog>() { // from class: com.ss.android.downloadlib.zx.1

            /* renamed from: g */
            final /* synthetic */ DownloadModel f24375g;
            final /* synthetic */ DownloadController gv;

            /* renamed from: i */
            final /* synthetic */ boolean f24376i;

            /* renamed from: j */
            final /* synthetic */ Context f24377j;
            final /* synthetic */ boolean k;
            final /* synthetic */ DownloadStatusChangeListener lg;
            final /* synthetic */ IDownloadButtonClickListener pa;
            final /* synthetic */ DownloadEventConfig q;
            final /* synthetic */ int y;
            final /* synthetic */ String zx;

            AnonymousClass1(Context context2, String str2, boolean z3, DownloadModel downloadModel2, DownloadEventConfig downloadEventConfig2, DownloadController downloadController2, DownloadStatusChangeListener downloadStatusChangeListener2, int i22, boolean z22, IDownloadButtonClickListener iDownloadButtonClickListener2) {
                context = context2;
                str = str2;
                z = z3;
                downloadModel = downloadModel2;
                downloadEventConfig = downloadEventConfig2;
                downloadController = downloadController2;
                downloadStatusChangeListener = downloadStatusChangeListener2;
                i2 = i22;
                z2 = z22;
                iDownloadButtonClickListener = iDownloadButtonClickListener2;
            }

            @Override // com.ss.android.downloadlib.q.zx.j
            /* renamed from: j */
            public Dialog zx() {
                return zx.this.zx(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i2, z2, iDownloadButtonClickListener);
            }
        });
    }

    @Override // com.ss.android.downloadad.api.zx
    public boolean j(Context context, long j2, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i2) {
        com.ss.android.downloadad.api.j.zx g2 = com.ss.android.downloadlib.addownload.zx.gv.j().g(j2);
        if (g2 != null) {
            this.f24374i.j(context, i2, downloadStatusChangeListener, g2.il());
            return true;
        }
        DownloadModel j3 = com.ss.android.downloadlib.addownload.zx.gv.j().j(j2);
        if (j3 == null) {
            return false;
        }
        this.f24374i.j(context, i2, downloadStatusChangeListener, j3);
        return true;
    }

    @Override // com.ss.android.downloadad.api.zx
    public boolean j(long j2, int i2) {
        DownloadModel j3 = com.ss.android.downloadlib.addownload.zx.gv.j().j(j2);
        if (j3 == null) {
            return false;
        }
        this.f24374i.j(j3.getDownloadUrl(), i2);
        return true;
    }

    public void j(long j2, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadModel j3 = com.ss.android.downloadlib.addownload.zx.gv.j().j(j2);
        com.ss.android.downloadad.api.j.zx g2 = com.ss.android.downloadlib.addownload.zx.gv.j().g(j2);
        if (j3 == null && g2 != null) {
            j3 = g2.il();
        }
        if (j3 == null) {
            return;
        }
        if (downloadEventConfig != null && downloadController != null && !(downloadEventConfig instanceof com.ss.android.download.api.download.i) && !(downloadController instanceof com.ss.android.download.api.download.zx)) {
            downloadEventConfig.setDownloadScene(1);
            this.f24374i.j(j3.getDownloadUrl(), j2, 2, downloadEventConfig, downloadController);
        } else {
            zx(j2);
        }
    }

    public void zx(long j2) {
        DownloadModel j3 = com.ss.android.downloadlib.addownload.zx.gv.j().j(j2);
        com.ss.android.downloadad.api.j.zx g2 = com.ss.android.downloadlib.addownload.zx.gv.j().g(j2);
        if (j3 == null && g2 != null) {
            j3 = g2.il();
        }
        if (j3 == null) {
            return;
        }
        DownloadEventConfig zx2 = com.ss.android.downloadlib.addownload.zx.gv.j().zx(j2);
        DownloadController i2 = com.ss.android.downloadlib.addownload.zx.gv.j().i(j2);
        if (zx2 instanceof com.ss.android.download.api.download.i) {
            zx2 = null;
        }
        if (i2 instanceof com.ss.android.download.api.download.zx) {
            i2 = null;
        }
        if (g2 == null) {
            if (zx2 == null) {
                zx2 = i();
            }
            if (i2 == null) {
                i2 = zx();
            }
        } else {
            if (zx2 == null) {
                zx2 = new AdDownloadEventConfig.Builder().setClickButtonTag(g2.pa()).setRefer(g2.k()).setIsEnableV3Event(g2.p()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            if (i2 == null) {
                i2 = g2.h();
            }
        }
        DownloadEventConfig downloadEventConfig = zx2;
        downloadEventConfig.setDownloadScene(1);
        this.f24374i.j(j3.getDownloadUrl(), j2, 2, downloadEventConfig, i2);
    }

    @Override // com.ss.android.downloadad.api.zx
    public boolean j(long j2) {
        return (com.ss.android.downloadlib.addownload.zx.gv.j().j(j2) == null && com.ss.android.downloadlib.addownload.zx.gv.j().g(j2) == null) ? false : true;
    }

    @Override // com.ss.android.downloadad.api.zx
    public boolean j(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return j(context, uri, downloadModel, downloadEventConfig, downloadController, null);
    }

    @Override // com.ss.android.downloadad.api.zx
    public boolean j(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ((Boolean) com.ss.android.downloadlib.q.zx.j(new zx.j<Boolean>() { // from class: com.ss.android.downloadlib.zx.3

            /* renamed from: g */
            final /* synthetic */ DownloadEventConfig f24381g;
            final /* synthetic */ IDownloadButtonClickListener gv;

            /* renamed from: i */
            final /* synthetic */ DownloadModel f24382i;

            /* renamed from: j */
            final /* synthetic */ Context f24383j;
            final /* synthetic */ DownloadController q;
            final /* synthetic */ Uri zx;

            AnonymousClass3(Context context2, Uri uri2, DownloadModel downloadModel2, DownloadEventConfig downloadEventConfig2, DownloadController downloadController2, IDownloadButtonClickListener iDownloadButtonClickListener2) {
                context = context2;
                uri = uri2;
                downloadModel = downloadModel2;
                downloadEventConfig = downloadEventConfig2;
                downloadController = downloadController2;
                iDownloadButtonClickListener = iDownloadButtonClickListener2;
            }

            @Override // com.ss.android.downloadlib.q.zx.j
            /* renamed from: j */
            public Boolean zx() {
                return Boolean.valueOf(zx.this.zx(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener));
            }
        })).booleanValue();
    }

    public static DownloadController j(boolean z) {
        AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    public boolean zx(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        DownloadController downloadController2 = downloadController;
        if (!com.ss.android.download.api.i.j.j(uri) || pa.k().optInt("disable_market") == 1) {
            return false;
        }
        Context context2 = context == null ? pa.getContext() : context;
        String zx2 = com.ss.android.download.api.i.j.zx(uri);
        if (downloadModel == null) {
            return k.j(context2, zx2).getType() == 5;
        }
        if (!TextUtils.isEmpty(zx2) && (downloadModel instanceof AdDownloadModel)) {
            ((AdDownloadModel) downloadModel).setPackageName(zx2);
        }
        if (downloadController2 != null) {
            downloadController2.setDownloadMode(2);
        } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
            downloadController2 = j(true);
        } else if (downloadModel.getDownloadUrl().startsWith(BaseConstants.SCHEME_MARKET)) {
            downloadController2 = j(true);
        } else {
            downloadController2 = zx();
        }
        com.ss.android.downloadlib.addownload.zx.q qVar = new com.ss.android.downloadlib.addownload.zx.q(downloadModel.getId(), downloadModel, (DownloadEventConfig) nt.j(downloadEventConfig, i()), downloadController2);
        com.ss.android.downloadlib.addownload.zx.gv.j().j(qVar.zx);
        com.ss.android.downloadlib.addownload.zx.gv.j().j(qVar.f24240j, qVar.f24239i);
        com.ss.android.downloadlib.addownload.zx.gv.j().j(qVar.f24240j, qVar.f24238g);
        if (nt.j(downloadModel) && DownloadSetting.obtainGlobal().optInt("app_link_opt") == 1 && com.ss.android.downloadlib.zx.j.j(qVar)) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        nt.j(jSONObject, "market_url", uri.toString());
        nt.j(jSONObject, "download_scene", (Object) 1);
        com.ss.android.downloadlib.g.j.j().zx("market_click_open", jSONObject, qVar);
        com.ss.android.downloadlib.addownload.zx.lg j2 = k.j(context2, qVar, zx2);
        String j3 = nt.j(j2.zx(), "open_market");
        if (j2.getType() == 5) {
            com.ss.android.downloadlib.zx.j.j(j3, jSONObject, qVar, true);
            return true;
        }
        if (j2.getType() != 6) {
            return true;
        }
        nt.j(jSONObject, "error_code", Integer.valueOf(j2.j()));
        com.ss.android.downloadlib.g.j.j().zx("market_open_failed", jSONObject, qVar);
        if (com.ss.android.downloadlib.addownload.y.j(downloadModel, iDownloadButtonClickListener)) {
            iDownloadButtonClickListener.handleMarketFailedComplianceDialog();
        }
        return false;
    }

    public static DownloadController zx() {
        return j(false);
    }
}
