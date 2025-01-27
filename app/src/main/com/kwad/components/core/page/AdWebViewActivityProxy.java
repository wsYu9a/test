package com.kwad.components.core.page;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.page.widget.a;
import com.kwad.components.core.proxy.f;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.bt;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes3.dex */
public class AdWebViewActivityProxy extends f {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    private static final String KEY_IS_AUTO_SHOW = "key_is_auto_show";
    private static final String KEY_LANDING_PAGE_TYPE = "key_landing_page_type";
    private static final String KEY_PAGE_TITLE = "key_page_title";
    private static final String KEY_PAGE_URL = "key_page_url";
    private static final String KEY_SHOW_PERMISSION = "key_show_permission";
    private static final String KEY_SHOW_TK_CONFIRM_DIALOG = "key_show_tk_confirm_dialog";
    public static final String KEY_TEMPLATE = "key_template_json";
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private boolean mAutoShow;
    private com.kwad.components.core.q.b mDialogFragment;
    private boolean mDisableShowConfirmDialog;
    private boolean mHasShowShowConfirmDialog;
    private Dialog mKsExitInterceptDialog;
    private Dialog mKsExitInterceptDialogV2;
    private int mLandingPageType;
    private c mLandingPageView;
    private String mPageTitle;
    private String mPageUrl;
    private boolean mShowPermission;
    private volatile boolean destroyed = false;
    private com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener = new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.b
        public final void b(WebCloseStatus webCloseStatus) {
            AdWebViewActivityProxy.this.finish();
        }
    };
    private com.kwad.components.core.page.a.a mLandPageViewListener = new com.kwad.components.core.page.a.a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.page.a.a
        public final void pS() {
            AdWebViewActivityProxy.this.onBackPressed();
        }

        @Override // com.kwad.components.core.page.a.a
        public final void pT() {
            if (AdWebViewActivityProxy.this.mLandingPageView != null && AdWebViewActivityProxy.this.mLandingPageView.getCanInterceptBackClick()) {
                AdWebViewActivityProxy.this.mLandingPageView.qc();
                return;
            }
            if (AdWebViewActivityProxy.this.mDisableShowConfirmDialog) {
                AdWebViewActivityProxy.this.finish();
                return;
            }
            if (AdWebViewActivityProxy.this.handleMiddlePageDialog()) {
                return;
            }
            if (AdWebViewActivityProxy.this.mAdTemplate.mIsForceJumpLandingPage) {
                AdWebViewActivityProxy.this.finish();
                return;
            }
            if (!com.kwad.sdk.core.response.b.a.aO(e.eb(AdWebViewActivityProxy.this.mAdTemplate)) || com.kwad.components.core.q.a.rJ().rK() != 1 || !com.kwad.components.core.q.a.rJ().rP() || com.kwad.components.core.q.a.rJ().rM()) {
                if (AdWebViewActivityProxy.this.isFormAdExitInterceptEnable()) {
                    AdWebViewActivityProxy.this.showDialog();
                    return;
                } else {
                    AdWebViewActivityProxy.this.finish();
                    return;
                }
            }
            if (com.kwad.components.core.q.a.rJ().rL() || !com.kwad.sdk.core.config.d.Du()) {
                AdWebViewActivityProxy.this.finish();
                return;
            }
            AdWebViewActivityProxy adWebViewActivityProxy = AdWebViewActivityProxy.this;
            adWebViewActivityProxy.mDialogFragment = adWebViewActivityProxy.getTkDialogFragment();
            com.kwad.components.core.q.b.a(AdWebViewActivityProxy.this.mDialogFragment, AdWebViewActivityProxy.this.getActivity(), AdWebViewActivityProxy.this.mBaseDialogListener);
        }
    };
    private com.kwad.components.core.webview.tachikoma.e.c mBaseDialogListener = new com.kwad.components.core.webview.tachikoma.e.c() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.3
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void G(boolean z10) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void gl() {
            com.kwad.components.core.q.a.rJ().aM(true);
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void gt() {
            com.kwad.components.core.q.a.rJ().aM(false);
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void gu() {
        }
    };

    /* renamed from: com.kwad.components.core.page.AdWebViewActivityProxy$1 */
    public class AnonymousClass1 implements com.kwad.sdk.core.webview.d.a.b {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.b
        public final void b(WebCloseStatus webCloseStatus) {
            AdWebViewActivityProxy.this.finish();
        }
    }

    /* renamed from: com.kwad.components.core.page.AdWebViewActivityProxy$2 */
    public class AnonymousClass2 implements com.kwad.components.core.page.a.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.page.a.a
        public final void pS() {
            AdWebViewActivityProxy.this.onBackPressed();
        }

        @Override // com.kwad.components.core.page.a.a
        public final void pT() {
            if (AdWebViewActivityProxy.this.mLandingPageView != null && AdWebViewActivityProxy.this.mLandingPageView.getCanInterceptBackClick()) {
                AdWebViewActivityProxy.this.mLandingPageView.qc();
                return;
            }
            if (AdWebViewActivityProxy.this.mDisableShowConfirmDialog) {
                AdWebViewActivityProxy.this.finish();
                return;
            }
            if (AdWebViewActivityProxy.this.handleMiddlePageDialog()) {
                return;
            }
            if (AdWebViewActivityProxy.this.mAdTemplate.mIsForceJumpLandingPage) {
                AdWebViewActivityProxy.this.finish();
                return;
            }
            if (!com.kwad.sdk.core.response.b.a.aO(e.eb(AdWebViewActivityProxy.this.mAdTemplate)) || com.kwad.components.core.q.a.rJ().rK() != 1 || !com.kwad.components.core.q.a.rJ().rP() || com.kwad.components.core.q.a.rJ().rM()) {
                if (AdWebViewActivityProxy.this.isFormAdExitInterceptEnable()) {
                    AdWebViewActivityProxy.this.showDialog();
                    return;
                } else {
                    AdWebViewActivityProxy.this.finish();
                    return;
                }
            }
            if (com.kwad.components.core.q.a.rJ().rL() || !com.kwad.sdk.core.config.d.Du()) {
                AdWebViewActivityProxy.this.finish();
                return;
            }
            AdWebViewActivityProxy adWebViewActivityProxy = AdWebViewActivityProxy.this;
            adWebViewActivityProxy.mDialogFragment = adWebViewActivityProxy.getTkDialogFragment();
            com.kwad.components.core.q.b.a(AdWebViewActivityProxy.this.mDialogFragment, AdWebViewActivityProxy.this.getActivity(), AdWebViewActivityProxy.this.mBaseDialogListener);
        }
    }

    /* renamed from: com.kwad.components.core.page.AdWebViewActivityProxy$3 */
    public class AnonymousClass3 implements com.kwad.components.core.webview.tachikoma.e.c {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void G(boolean z10) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void gl() {
            com.kwad.components.core.q.a.rJ().aM(true);
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void gt() {
            com.kwad.components.core.q.a.rJ().aM(false);
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void gu() {
        }
    }

    /* renamed from: com.kwad.components.core.page.AdWebViewActivityProxy$4 */
    public class AnonymousClass4 implements a.InterfaceC0442a {
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
        public final void a(DialogInterface dialogInterface) {
            com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 104);
            dialogInterface.dismiss();
        }

        @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
        public final void b(DialogInterface dialogInterface) {
            if (!AdWebViewActivityProxy.this.destroyed) {
                try {
                    AdWebViewActivityProxy.super.onBackPressed();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                }
            }
            com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 105);
        }

        @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
        public final void c(DialogInterface dialogInterface) {
            com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 106);
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.kwad.components.core.page.AdWebViewActivityProxy$5 */
    public class AnonymousClass5 implements a.InterfaceC0442a {
        public AnonymousClass5() {
        }

        @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
        public final void a(DialogInterface dialogInterface) {
            com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 104);
            dialogInterface.dismiss();
        }

        @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
        public final void b(DialogInterface dialogInterface) {
            try {
                AdWebViewActivityProxy.super.onBackPressed();
            } catch (Throwable unused) {
            }
            com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 105);
        }

        @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
        public final void c(DialogInterface dialogInterface) {
            com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 106);
            dialogInterface.dismiss();
        }
    }

    public static class a {
        private String Ql;
        private String Qm;
        private AdResultData Qn;
        private boolean Qo;
        private boolean Qp;
        private int Qq;
        private boolean Qr;
        private AdTemplate adTemplate;

        /* renamed from: com.kwad.components.core.page.AdWebViewActivityProxy$a$a */
        public static class C0438a {
            private String Ql;
            private String Qm;
            private AdResultData Qn;
            private boolean Qp;
            private int Qq = 0;
            private boolean Qr;
            private boolean Qs;
            private AdTemplate adTemplate;

            public final C0438a aA(int i10) {
                this.Qq = i10;
                return this;
            }

            public final C0438a aD(boolean z10) {
                this.Qs = z10;
                return this;
            }

            public final C0438a aE(boolean z10) {
                this.Qp = z10;
                return this;
            }

            public final C0438a aF(boolean z10) {
                this.Qr = z10;
                return this;
            }

            public final C0438a au(String str) {
                this.Ql = str;
                return this;
            }

            public final C0438a av(String str) {
                this.Qm = str;
                return this;
            }

            public final C0438a aw(AdTemplate adTemplate) {
                this.adTemplate = adTemplate;
                return this;
            }

            public final C0438a n(AdResultData adResultData) {
                this.Qn = adResultData;
                return this;
            }

            public final a qa() {
                AdResultData adResultData = this.Qn;
                return adResultData != null ? new a(this.Ql, this.Qm, adResultData, this.Qs, this.Qp, this.Qr, this.Qq, (byte) 0) : new a(this.Ql, this.Qm, this.adTemplate, this.Qs, this.Qp, this.Qr, this.Qq, (byte) 0);
            }
        }

        public /* synthetic */ a(String str, String str2, AdResultData adResultData, boolean z10, boolean z11, boolean z12, int i10, byte b10) {
            this(str, str2, adResultData, z10, z11, z12, i10);
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final String pU() {
            return this.Ql;
        }

        public final String pV() {
            return this.Qm;
        }

        public final int pW() {
            return this.Qq;
        }

        public final boolean pX() {
            return this.Qo;
        }

        public final boolean pY() {
            return this.Qr;
        }

        public final boolean pZ() {
            return this.Qp;
        }

        public /* synthetic */ a(String str, String str2, AdTemplate adTemplate, boolean z10, boolean z11, boolean z12, int i10, byte b10) {
            this(str, str2, adTemplate, z10, z11, z12, i10);
        }

        private a(String str, String str2, AdTemplate adTemplate, boolean z10, boolean z11, boolean z12, int i10) {
            this(str, str2, z10, z11, z12, i10);
            this.adTemplate = adTemplate;
        }

        private a(String str, String str2, AdResultData adResultData, boolean z10, boolean z11, boolean z12, int i10) {
            this(str, str2, z10, z11, z12, i10);
            this.Qn = adResultData;
            this.adTemplate = com.kwad.sdk.core.response.b.c.o(adResultData);
        }

        private a(String str, String str2, boolean z10, boolean z11, boolean z12, int i10) {
            this.Ql = str;
            this.Qm = str2;
            this.Qo = z10;
            this.Qp = z11;
            this.Qr = z12;
            this.Qq = i10;
        }
    }

    private com.kwad.components.core.page.widget.a buildDialog() {
        return new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0442a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
            public final void a(DialogInterface dialogInterface) {
                com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 104);
                dialogInterface.dismiss();
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
            public final void b(DialogInterface dialogInterface) {
                try {
                    AdWebViewActivityProxy.super.onBackPressed();
                } catch (Throwable unused) {
                }
                com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 105);
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
            public final void c(DialogInterface dialogInterface) {
                com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 106);
                dialogInterface.dismiss();
            }
        });
    }

    public com.kwad.components.core.q.b getTkDialogFragment() {
        e.b bVar = new e.b();
        bVar.a(this.mAdResultData);
        bVar.aZ(com.kwad.sdk.core.response.b.b.dH(this.mAdTemplate));
        bVar.aX(false);
        bVar.aY(true);
        return com.kwad.components.core.q.b.a(bVar);
    }

    public boolean handleMiddlePageDialog() {
        boolean z10 = false;
        if (this.mAdTemplate == null || !com.kwad.sdk.core.config.d.Du()) {
            return false;
        }
        if (!bm.isNullString(com.kwad.sdk.core.response.b.a.ci(this.mAdTemplate)) && com.kwad.sdk.core.response.b.a.ch(this.mAdTemplate)) {
            z10 = true;
            if (this.mHasShowShowConfirmDialog) {
                try {
                    super.onBackPressed();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                }
            } else {
                com.kwad.components.core.q.b tkDialogFragment = getTkDialogFragment();
                this.mDialogFragment = tkDialogFragment;
                com.kwad.components.core.q.b.a(tkDialogFragment, getActivity(), this.mBaseDialogListener);
                this.mHasShowShowConfirmDialog = true;
            }
        }
        return z10;
    }

    private void initContentView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_land_page_root);
        c a10 = c.a(this.mContext, new a.C0438a().au(this.mPageTitle).av(this.mPageUrl).aw(this.mAdTemplate).aD(this.mShowPermission).aE(this.mAutoShow).aA(this.mLandingPageType).aF(this.mDisableShowConfirmDialog).qa());
        this.mLandingPageView = a10;
        a10.setLandPageViewListener(this.mLandPageViewListener);
        this.mLandingPageView.setWebCardCloseListener(this.mWebCardCloseListener);
        viewGroup.addView(this.mLandingPageView);
    }

    public boolean isFormAdExitInterceptEnable() {
        AdTemplate adTemplate;
        if (this.mShowPermission || (adTemplate = this.mAdTemplate) == null || com.kwad.sdk.core.response.b.e.J(adTemplate)) {
            return false;
        }
        if (com.kwad.sdk.core.config.d.DC() && this.mAdTemplate.mIsFromContent) {
            return true;
        }
        return com.kwad.sdk.core.config.d.DD() && !this.mAdTemplate.mIsFromContent;
    }

    public static void launch(Context context, a aVar) {
        if (context == null || TextUtils.isEmpty(aVar.Qm)) {
            return;
        }
        try {
            com.kwad.sdk.commercial.g.a.j(aVar.getAdTemplate(), aVar.pW(), aVar.pV());
            com.kwad.sdk.service.b.a(AdWebViewActivity.class, AdWebViewActivityProxy.class);
            Intent intent = new Intent(context, (Class<?>) AdWebViewActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(KEY_PAGE_TITLE, aVar.Ql);
            intent.putExtra(KEY_LANDING_PAGE_TYPE, aVar.Qq);
            intent.putExtra(KEY_PAGE_URL, aVar.Qm);
            intent.putExtra(KEY_IS_AUTO_SHOW, aVar.Qp);
            intent.putExtra(KEY_SHOW_PERMISSION, aVar.Qo);
            intent.putExtra(KEY_SHOW_TK_CONFIRM_DIALOG, aVar.pY());
            AdResultData adResultData = aVar.Qn;
            if (adResultData == null) {
                adResultData = com.kwad.sdk.core.response.b.c.dM(aVar.adTemplate);
            }
            intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.nt().j(adResultData));
            context.startActivity(intent);
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            com.kwad.sdk.commercial.g.a.a(aVar.getAdTemplate(), aVar.pW(), aVar.pV(), bt.t(th2));
            if (!l.At().zB()) {
                throw th2;
            }
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(AdWebViewActivity.class, AdWebViewActivityProxy.class);
    }

    public void showDialog() {
        if (this.mKsExitInterceptDialog == null) {
            this.mKsExitInterceptDialog = buildDialog();
        }
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 103, (JSONObject) null);
        this.mKsExitInterceptDialog.show();
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(@Nullable Intent intent) {
        AdResultData d10 = com.kwad.components.core.c.f.nt().d(getIntent().getIntExtra("key_ad_result_cache_idx", 0), true);
        this.mAdResultData = d10;
        if (d10 == null) {
            return false;
        }
        AdTemplate o10 = com.kwad.sdk.core.response.b.c.o(d10);
        this.mAdTemplate = o10;
        return o10 != null;
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        return 0;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "AdWebViewActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.destroyed = false;
        this.mPageTitle = getIntent().getStringExtra(KEY_PAGE_TITLE);
        this.mLandingPageType = getIntent().getIntExtra(KEY_LANDING_PAGE_TYPE, 0);
        this.mPageUrl = getIntent().getStringExtra(KEY_PAGE_URL);
        this.mAutoShow = getIntent().getBooleanExtra(KEY_IS_AUTO_SHOW, false);
        this.mShowPermission = getIntent().getBooleanExtra(KEY_SHOW_PERMISSION, false);
        this.mDisableShowConfirmDialog = getIntent().getBooleanExtra(KEY_SHOW_TK_CONFIRM_DIALOG, false);
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        setContentView(R.layout.ksad_activity_landpage);
        initContentView();
    }

    @Override // com.kwad.components.core.proxy.f
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.g.a.k(this.mAdTemplate, this.mLandingPageType, this.mPageUrl);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        c cVar = this.mLandingPageView;
        if (cVar != null && cVar.getCanInterceptBackClick()) {
            this.mLandingPageView.qc();
            return;
        }
        if (this.mDisableShowConfirmDialog) {
            finish();
            return;
        }
        if (handleMiddlePageDialog()) {
            return;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null || adTemplate.mIsForceJumpLandingPage) {
            super.onBackPressed();
            return;
        }
        if (com.kwad.sdk.core.response.b.a.aO(com.kwad.sdk.core.response.b.e.eb(adTemplate)) && com.kwad.components.core.q.a.rJ().rK() == 1 && com.kwad.components.core.q.a.rJ().rP() && !com.kwad.components.core.q.a.rJ().rM()) {
            if (com.kwad.components.core.q.a.rJ().rL() || !com.kwad.sdk.core.config.d.Du()) {
                super.onBackPressed();
                return;
            }
            com.kwad.components.core.q.b tkDialogFragment = getTkDialogFragment();
            this.mDialogFragment = tkDialogFragment;
            com.kwad.components.core.q.b.a(tkDialogFragment, getActivity(), this.mBaseDialogListener);
            return;
        }
        if (isFormAdExitInterceptEnable()) {
            try {
                if (this.mKsExitInterceptDialogV2 == null) {
                    this.mKsExitInterceptDialogV2 = new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0442a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.4
                        public AnonymousClass4() {
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
                        public final void a(DialogInterface dialogInterface) {
                            com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 104);
                            dialogInterface.dismiss();
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
                        public final void b(DialogInterface dialogInterface) {
                            if (!AdWebViewActivityProxy.this.destroyed) {
                                try {
                                    AdWebViewActivityProxy.super.onBackPressed();
                                } catch (Throwable th2) {
                                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                                }
                            }
                            com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 105);
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
                        public final void c(DialogInterface dialogInterface) {
                            com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 106);
                            dialogInterface.dismiss();
                        }
                    });
                }
                com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 103, (JSONObject) null);
                this.mKsExitInterceptDialogV2.show();
                return;
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            }
        }
        super.onBackPressed();
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            this.destroyed = true;
            com.kwad.components.core.q.b bVar = this.mDialogFragment;
            if (bVar != null) {
                bVar.dismiss();
                this.mDialogFragment = null;
            }
            Dialog dialog = this.mKsExitInterceptDialog;
            if (dialog != null && dialog.isShowing()) {
                this.mKsExitInterceptDialog.dismiss();
            }
            Dialog dialog2 = this.mKsExitInterceptDialogV2;
            if (dialog2 != null && dialog2.isShowing()) {
                this.mKsExitInterceptDialogV2.dismiss();
            }
            super.onDestroy();
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null) {
                adTemplate.interactLandingPageShowing = false;
                adTemplate.mIsForceJumpLandingPage = false;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        launch(context, new a.C0438a().av(com.kwad.sdk.core.response.b.b.cJ(adTemplate)).aw(adTemplate).qa());
    }
}
