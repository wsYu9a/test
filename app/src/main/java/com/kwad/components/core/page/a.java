package com.kwad.components.core.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.a.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a extends com.kwad.components.core.l.a implements a.InterfaceC0162a, ai.b {
    private boolean Lb = true;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private AdBaseFrameLayout mRootContainer;
    private com.kwad.components.core.a.a mTitleBarHelper;
    private com.kwad.components.core.playable.a oP;

    private void d(Intent intent) {
        String stringExtra = intent.getStringExtra("key_template_json");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        try {
            this.mAdTemplate = new AdTemplate();
            this.mAdTemplate.parseJson(new JSONObject(stringExtra));
            this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        com.kwad.sdk.service.a.a(BaseFragmentActivity.FragmentActivity8.class, a.class);
        Intent intent = new Intent(context, (Class<?>) BaseFragmentActivity.FragmentActivity8.class);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        context.startActivity(intent);
    }

    private void nW() {
        com.kwad.components.core.a.a aVar = new com.kwad.components.core.a.a(this.mRootContainer);
        this.mTitleBarHelper = aVar;
        aVar.a(this);
        this.mTitleBarHelper.a(new com.kwad.components.core.a.b(""));
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.a.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.a.a(BaseFragmentActivity.FragmentActivity8.class, a.class);
    }

    @Override // com.kwad.components.core.webview.jshandler.ai.b
    public final void a(ai.a aVar) {
        com.kwad.components.core.playable.a aVar2;
        com.kwad.sdk.core.d.b.d("AdPlayableActivityProxy", "updatePageStatus status: " + aVar);
        if (aVar.status != 1 || (aVar2 = this.oP) == null) {
            return;
        }
        aVar2.e(PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE);
    }

    @Override // com.kwad.components.core.l.a
    public String getPageName() {
        return "AdPlayableActivityProxy";
    }

    @Override // com.kwad.components.core.l.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getActivity().setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        setContentView(R.layout.ksad_activity_playable);
        d(getIntent());
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_playable_activity_root);
        KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.ksad_playable_webview);
        nW();
        com.kwad.components.core.playable.a aVar = new com.kwad.components.core.playable.a(ksAdWebView);
        this.oP = aVar;
        aVar.a(this.mAdTemplate, this.mRootContainer, this.mApkDownloadHelper);
        this.oP.a(this);
        this.oP.oX();
    }

    @Override // com.kwad.components.core.l.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        this.oP.b(this);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onRestart() {
        super.onRestart();
    }

    @Override // com.kwad.components.core.l.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    @Override // com.kwad.components.core.a.a.InterfaceC0162a
    public final void t(View view) {
        onBackPressed();
    }

    @Override // com.kwad.components.core.a.a.InterfaceC0162a
    public final void u(View view) {
        com.kwad.sdk.core.report.a.b(this.mAdTemplate, new i().bk(6), (JSONObject) null);
        finish();
    }
}
