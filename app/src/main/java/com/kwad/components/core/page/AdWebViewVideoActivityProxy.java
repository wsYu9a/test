package com.kwad.components.core.page;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.a.a;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentTransaction;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.widget.DownloadProgressBar;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.List;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes2.dex */
public class AdWebViewVideoActivityProxy extends com.kwad.components.core.l.a {
    public static final String KEY_REPORTED = "key_reported";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static boolean showingAdWebViewVideoActivity = false;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private b mFragment;
    private Dialog mKsExitInterceptDialog;
    private DownloadProgressBar mProgressbar;
    private com.kwad.components.core.page.splitLandingPage.a mSplitLandingPage;
    private com.kwad.components.core.a.a mTitleBarHelper;
    private ViewGroup mWebDownloadContainer;

    /* renamed from: com.kwad.components.core.page.AdWebViewVideoActivityProxy$1 */
    final class AnonymousClass1 extends com.kwad.sdk.core.download.kwai.a {
        final /* synthetic */ AdInfo rX;

        AnonymousClass1(AdInfo adInfo) {
            cb = adInfo;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
            AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.aw(cb));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
            AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.aH(AdWebViewVideoActivityProxy.this.mAdTemplate));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
            AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.aw(cb));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
            AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.T(cb));
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i2) {
            AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(i2);
            AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.bz(i2));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
            AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(i2);
            AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.by(i2));
        }
    }

    /* renamed from: com.kwad.components.core.page.AdWebViewVideoActivityProxy$2 */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.kwad.sdk.core.report.a.a(AdWebViewVideoActivityProxy.this.mAdTemplate, 50, (ac.a) null);
            com.kwad.components.core.d.b.a.a(AdWebViewVideoActivityProxy.this.getAdClickConfig(true));
        }
    }

    /* renamed from: com.kwad.components.core.page.AdWebViewVideoActivityProxy$3 */
    final class AnonymousClass3 implements a.InterfaceC0162a {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.a.a.InterfaceC0162a
        public final void t(View view) {
            AdWebViewVideoActivityProxy.this.onBackPressed();
        }

        @Override // com.kwad.components.core.a.a.InterfaceC0162a
        public final void u(View view) {
            AdWebViewVideoActivityProxy.this.finish();
        }
    }

    /* renamed from: com.kwad.components.core.page.AdWebViewVideoActivityProxy$4 */
    final class AnonymousClass4 implements a.InterfaceC0185a {
        AnonymousClass4() {
        }

        @Override // com.kwad.components.core.page.widget.a.InterfaceC0185a
        public final void a(DialogInterface dialogInterface) {
            com.kwad.sdk.core.report.a.q(AdWebViewVideoActivityProxy.this.mAdTemplate, 104);
            dialogInterface.dismiss();
        }

        @Override // com.kwad.components.core.page.widget.a.InterfaceC0185a
        public final void b(DialogInterface dialogInterface) {
            AdWebViewVideoActivityProxy.super.onBackPressed();
            com.kwad.sdk.core.report.a.q(AdWebViewVideoActivityProxy.this.mAdTemplate, 105);
        }

        @Override // com.kwad.components.core.page.widget.a.InterfaceC0185a
        public final void c(DialogInterface dialogInterface) {
            com.kwad.sdk.core.report.a.q(AdWebViewVideoActivityProxy.this.mAdTemplate, 106);
            dialogInterface.dismiss();
        }
    }

    private com.kwad.components.core.page.widget.a buildDialog() {
        return new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0185a() { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.4
            AnonymousClass4() {
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0185a
            public final void a(DialogInterface dialogInterface) {
                com.kwad.sdk.core.report.a.q(AdWebViewVideoActivityProxy.this.mAdTemplate, 104);
                dialogInterface.dismiss();
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0185a
            public final void b(DialogInterface dialogInterface) {
                AdWebViewVideoActivityProxy.super.onBackPressed();
                com.kwad.sdk.core.report.a.q(AdWebViewVideoActivityProxy.this.mAdTemplate, 105);
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0185a
            public final void c(DialogInterface dialogInterface) {
                com.kwad.sdk.core.report.a.q(AdWebViewVideoActivityProxy.this.mAdTemplate, 106);
                dialogInterface.dismiss();
            }
        });
    }

    public a.C0172a getAdClickConfig(boolean z) {
        return new a.C0172a(getActivity()).ao(z).at(true).ap(false).I(this.mAdTemplate).ar(false);
    }

    private void initView() {
        KsFragmentTransaction beginTransaction;
        KsFragment ksFragment;
        this.mProgressbar = (DownloadProgressBar) findViewById(R.id.ksad_web_download_progress);
        this.mWebDownloadContainer = (ViewGroup) findViewById(R.id.ksad_web_download_container);
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        if (com.kwad.sdk.core.response.a.a.ax(cb)) {
            this.mWebDownloadContainer.setVisibility(0);
            this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate, new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.1
                final /* synthetic */ AdInfo rX;

                AnonymousClass1(AdInfo cb2) {
                    cb = cb2;
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.aw(cb));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.aH(AdWebViewVideoActivityProxy.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.aw(cb));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.T(cb));
                }

                @Override // com.kwad.sdk.core.download.kwai.a
                public final void onPaused(int i2) {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(i2);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.bz(i2));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i2) {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(i2);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.by(i2));
                }
            });
            this.mProgressbar.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.2
                AnonymousClass2() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.kwad.sdk.core.report.a.a(AdWebViewVideoActivityProxy.this.mAdTemplate, 50, (ac.a) null);
                    com.kwad.components.core.d.b.a.a(AdWebViewVideoActivityProxy.this.getAdClickConfig(true));
                }
            });
        } else {
            this.mWebDownloadContainer.setVisibility(8);
        }
        List<AdInfo> list = this.mAdTemplate.adInfoList;
        String bK = (list == null || list.size() <= 0 || this.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.a.a.bK(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
        com.kwad.components.core.a.a aVar = new com.kwad.components.core.a.a((ViewGroup) findViewById(R.id.ksad_kwad_web_title_bar));
        this.mTitleBarHelper = aVar;
        aVar.a(new a.InterfaceC0162a() { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.3
            AnonymousClass3() {
            }

            @Override // com.kwad.components.core.a.a.InterfaceC0162a
            public final void t(View view) {
                AdWebViewVideoActivityProxy.this.onBackPressed();
            }

            @Override // com.kwad.components.core.a.a.InterfaceC0162a
            public final void u(View view) {
                AdWebViewVideoActivityProxy.this.finish();
            }
        });
        this.mTitleBarHelper.a(new com.kwad.components.core.a.b(bK));
        ai.cc(getActivity());
        com.kwad.components.core.r.d.a(getActivity(), 0, true);
        int i2 = R.id.ksad_recycler_container;
        if (com.kwad.sdk.core.config.d.tW() != 0) {
            com.kwad.components.core.page.splitLandingPage.a M = com.kwad.components.core.page.splitLandingPage.a.M(this.mAdTemplate);
            this.mSplitLandingPage = M;
            M.setApkDownloadHelper(this.mApkDownloadHelper);
            beginTransaction = getSupportFragmentManager().beginTransaction();
            ksFragment = this.mSplitLandingPage;
        } else {
            b K = b.K(this.mAdTemplate);
            this.mFragment = K;
            K.setApkDownloadHelper(this.mApkDownloadHelper);
            beginTransaction = getSupportFragmentManager().beginTransaction();
            ksFragment = this.mFragment;
        }
        beginTransaction.replace(i2, ksFragment).commitAllowingStateLoss();
    }

    private boolean isFormAdExitInterceptEnable() {
        if (this.mAdTemplate == null) {
            return false;
        }
        if (com.kwad.sdk.core.config.d.uv() && this.mAdTemplate.mIsFromContent) {
            return true;
        }
        return com.kwad.sdk.core.config.d.uw() && !this.mAdTemplate.mIsFromContent;
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) BaseFragmentActivity.FragmentActivity3.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra(KEY_REPORTED, adTemplate.mPvReported);
        context.startActivity(intent);
        Activity dj = k.dj(context);
        if (dj != null) {
            dj.overridePendingTransition(0, 0);
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.a.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.a.a(BaseFragmentActivity.FragmentActivity3.class, AdWebViewVideoActivityProxy.class);
    }

    private void showDialog() {
        if (this.mKsExitInterceptDialog == null) {
            this.mKsExitInterceptDialog = buildDialog();
        }
        com.kwad.sdk.core.report.a.b(this.mAdTemplate, 103, (JSONObject) null);
        this.mKsExitInterceptDialog.show();
    }

    private void showWaitDialog() {
        if (isFormAdExitInterceptEnable()) {
            showDialog();
        } else {
            finish();
        }
    }

    @Override // com.kwad.components.core.l.a
    public String getPageName() {
        return "AdWebViewVideoActivityProxy";
    }

    @Override // com.kwad.components.core.l.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.core.page.splitLandingPage.a aVar = this.mSplitLandingPage;
        if (aVar == null || !aVar.bX()) {
            com.kwad.components.core.page.splitLandingPage.a aVar2 = this.mSplitLandingPage;
            if (aVar2 != null) {
                aVar2.oP();
            }
            b bVar = this.mFragment;
            if (bVar == null || !bVar.bX()) {
                showWaitDialog();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.kwad.components.core.l.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ksad_activity_ad_video_webview);
        showingAdWebViewVideoActivity = true;
        try {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
        AdTemplate adTemplate2 = this.mAdTemplate;
        if (adTemplate2 == null) {
            finish();
        } else {
            adTemplate2.mPvReported = getIntent().getBooleanExtra(KEY_REPORTED, false);
            initView();
        }
    }

    @Override // com.kwad.components.core.l.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Dialog dialog = this.mKsExitInterceptDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mKsExitInterceptDialog.dismiss();
        }
        super.onDestroy();
        showingAdWebViewVideoActivity = false;
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        showingAdWebViewVideoActivity = false;
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.l.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        showingAdWebViewVideoActivity = true;
    }
}
