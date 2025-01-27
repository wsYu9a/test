package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: classes4.dex */
public class f extends RelativeLayout {

    /* renamed from: a */
    public View f20204a;

    public f(Context context) {
        super(context);
    }

    public void a(int i10) {
        this.f20204a = View.inflate(getContext(), i10, this);
    }

    public SigAdInfoView getAdInfView() {
        View view = this.f20204a;
        if (view != null) {
            return (SigAdInfoView) view.findViewById(ResourceUtil.getId(getContext(), "sig_app_info"));
        }
        return null;
    }

    public Button getCTAButton() {
        View view = this.f20204a;
        if (view != null) {
            return (Button) view.findViewById(ResourceUtil.getId(getContext(), "sig_cta_button"));
        }
        return null;
    }

    public NewInterstitialHeaderView getHeaderView() {
        View view = this.f20204a;
        if (view != null) {
            return (NewInterstitialHeaderView) view.findViewById(ResourceUtil.getId(getContext(), "sig_ad_header"));
        }
        return null;
    }

    public ViewGroup getMainAdContainer() {
        View view = this.f20204a;
        if (view != null) {
            return (ViewGroup) view.findViewById(ResourceUtil.getId(getContext(), "sig_ad_container"));
        }
        return null;
    }
}
