package com.kwad.components.ad.interstitial.h;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.core.proxy.j;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b extends j implements View.OnClickListener {
    private static boolean mO;
    private TextView iO;
    private com.kwad.components.ad.interstitial.f.c kY;
    private AdTemplate mAdTemplate;
    private KSCornerImageView mJ;
    private TextView mK;
    private TextView mL;
    private TextView mM;
    private TextView mN;

    public static void e(com.kwad.components.ad.interstitial.f.c cVar) {
        if (mO) {
            return;
        }
        mO = true;
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_TEMPLATE", cVar.mAdTemplate.toJson().toString());
        bVar.setArguments(bundle);
        bVar.f(cVar);
        bVar.show(cVar.jz.getOwnerActivity().getFragmentManager(), "interstitialCloseDialog");
    }

    private void f(com.kwad.components.ad.interstitial.f.c cVar) {
        this.kY = cVar;
    }

    private void initData() {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
        KSImageLoader.loadAppIcon(this.mJ, com.kwad.sdk.core.response.b.a.cm(eb2), this.mAdTemplate, 12);
        this.iO.setText(com.kwad.sdk.core.response.b.a.cj(eb2));
        this.mK.setText(com.kwad.sdk.core.response.b.a.au(eb2));
        if (com.kwad.sdk.core.response.b.a.cj(this.mAdTemplate)) {
            this.mL.setText(com.kwad.sdk.core.response.b.a.aE(eb2));
        }
    }

    private void j(View view) {
        this.mJ = (KSCornerImageView) view.findViewById(R.id.ksad_interstitial_intercept_app_icon);
        this.iO = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_app_title);
        this.mK = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_desc);
        this.mL = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_detail);
        this.mM = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_btn_continue);
        TextView textView = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_btn_deny);
        this.mN = textView;
        com.kwad.sdk.c.a.a.a(this, this.mJ, this.iO, this.mK, this.mL, this.mM, textView);
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        String string = getArguments().getString("KEY_TEMPLATE");
        try {
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        View inflate = layoutInflater.inflate(R.layout.ksad_interstitial_exit_intercept_dialog, viewGroup);
        j(inflate);
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
        com.kwad.components.ad.interstitial.f.c cVar = this.kY;
        if (cVar != null) {
            com.kwad.sdk.core.adlog.c.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.adlog.c.b().cN(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE).cS(9));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.kY != null) {
            if (view.equals(this.mJ)) {
                com.kwad.components.ad.interstitial.f.c cVar = this.kY;
                cVar.a(cVar.jz.getContext(), 127, 2, 9);
            } else if (view.equals(this.iO)) {
                com.kwad.components.ad.interstitial.f.c cVar2 = this.kY;
                cVar2.a(cVar2.jz.getContext(), 128, 2, 9);
            } else if (view.equals(this.mK)) {
                com.kwad.components.ad.interstitial.f.c cVar3 = this.kY;
                cVar3.a(cVar3.jz.getContext(), 129, 2, 9);
            } else if (view.equals(this.mL)) {
                com.kwad.components.ad.interstitial.f.c cVar4 = this.kY;
                cVar4.a(cVar4.jz.getContext(), 131, 2, 9);
            } else if (view.equals(this.mM)) {
                com.kwad.sdk.core.adlog.c.c(this.kY.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cS(9));
            } else if (view.equals(this.mN)) {
                com.kwad.components.ad.interstitial.f.c cVar5 = this.kY;
                cVar5.a(false, -1, cVar5.co);
                this.kY.jz.dismiss();
                com.kwad.sdk.core.adlog.c.e(this.kY.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cN(151).cS(9));
            }
        }
        dismiss();
        mO = false;
    }
}
