package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: classes4.dex */
public class SigAdPrivacyInfoView extends LinearLayout {

    /* renamed from: a */
    public ImageView f20158a;

    /* renamed from: b */
    public View f20159b;

    /* renamed from: c */
    public View f20160c;

    /* renamed from: d */
    public LinearLayout f20161d;

    /* renamed from: e */
    public TextView f20162e;

    public SigAdPrivacyInfoView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        View inflate = View.inflate(context, ResourceUtil.getLayoutId(context, "sig_ad_privacy_layout"), this);
        this.f20158a = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_ad_logo"));
        this.f20159b = inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_view"));
        this.f20160c = inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_ll"));
        this.f20162e = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_ad_text"));
    }

    public TextView getPrivacyAdText() {
        return this.f20162e;
    }

    public View getPrivacyLl() {
        return this.f20160c;
    }

    public SigAdPrivacyInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void a(String str, boolean z10) {
        if (!TextUtils.isEmpty(str)) {
            com.sigmob.sdk.base.common.h.o().load(str).into(this.f20158a);
        }
        this.f20159b.setVisibility(z10 ? 0 : 8);
    }

    public SigAdPrivacyInfoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context);
    }
}
