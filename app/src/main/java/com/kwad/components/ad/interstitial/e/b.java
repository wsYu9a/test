package com.kwad.components.ad.interstitial.e;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.tencent.bugly.beta.tinker.TinkerReport;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b extends com.kwad.components.core.l.g implements View.OnClickListener {
    private static boolean lT;
    private TextView he;
    private com.kwad.components.ad.interstitial.c.c jt;
    private KSCornerImageView lO;
    private TextView lP;
    private TextView lQ;
    private TextView lR;
    private TextView lS;
    private AdTemplate mAdTemplate;

    public static void d(com.kwad.components.ad.interstitial.c.c cVar) {
        if (lT) {
            return;
        }
        lT = true;
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_TEMPLATE", cVar.mAdTemplate.toJson().toString());
        bVar.setArguments(bundle);
        bVar.e(cVar);
        bVar.show(cVar.hU.getOwnerActivity().getFragmentManager(), "interstitialCloseDialog");
    }

    private void e(com.kwad.components.ad.interstitial.c.c cVar) {
        this.jt = cVar;
    }

    private void i(View view) {
        this.lO = (KSCornerImageView) view.findViewById(R.id.ksad_interstitial_intercept_app_icon);
        this.he = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_app_title);
        this.lP = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_desc);
        this.lQ = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_detail);
        this.lR = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_btn_continue);
        TextView textView = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_btn_deny);
        this.lS = textView;
        com.kwad.sdk.c.kwai.a.a(this, this.lO, this.he, this.lP, this.lQ, this.lR, textView);
    }

    private void initData() {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        KSImageLoader.loadAppIcon(this.lO, com.kwad.sdk.core.response.a.a.bM(cb), this.mAdTemplate, 12);
        this.he.setText(com.kwad.sdk.core.response.a.a.bK(cb));
        this.lP.setText(com.kwad.sdk.core.response.a.a.an(cb));
        if (com.kwad.sdk.core.response.a.a.aI(this.mAdTemplate)) {
            this.lQ.setText(com.kwad.sdk.core.response.a.a.aw(cb));
        }
    }

    @Override // com.kwad.components.core.l.g
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        String string = getArguments().getString("KEY_TEMPLATE");
        try {
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        View inflate = layoutInflater.inflate(R.layout.ksad_interstitial_exit_intercept_dialog, viewGroup);
        i(inflate);
        initData();
        return inflate;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCancelable(false);
        com.kwad.components.ad.interstitial.c.c cVar = this.jt;
        if (cVar != null) {
            com.kwad.sdk.core.report.a.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.report.i().bl(149).bn(9));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ad.interstitial.c.c cVar;
        Context context;
        int i2;
        if (this.jt != null) {
            if (view.equals(this.lO)) {
                cVar = this.jt;
                context = cVar.hU.getContext();
                i2 = 127;
            } else if (view.equals(this.he)) {
                cVar = this.jt;
                context = cVar.hU.getContext();
                i2 = 128;
            } else if (view.equals(this.lP)) {
                cVar = this.jt;
                context = cVar.hU.getContext();
                i2 = 129;
            } else if (view.equals(this.lQ)) {
                cVar = this.jt;
                context = cVar.hU.getContext();
                i2 = TTAdConstant.IMAGE_MODE_SPLASH;
            } else if (view.equals(this.lR)) {
                com.kwad.sdk.core.report.a.c(this.jt.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.i().bn(9));
            } else if (view.equals(this.lS)) {
                com.kwad.components.ad.interstitial.c.c cVar2 = this.jt;
                cVar2.a(false, -1, cVar2.eN);
                this.jt.hU.dismiss();
                com.kwad.sdk.core.report.a.a(this.jt.mAdTemplate, new com.kwad.sdk.core.report.i().bl(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META).bn(9));
            }
            cVar.a(context, i2, 2, 9);
        }
        dismiss();
        lT = false;
    }
}
