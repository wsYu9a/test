package com.sigmob.sdk.base.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: classes4.dex */
public class x extends LinearLayout {

    /* renamed from: a */
    public ImageView f18938a;

    /* renamed from: b */
    public View f18939b;

    /* renamed from: c */
    public View f18940c;

    /* renamed from: d */
    public LinearLayout f18941d;

    /* renamed from: e */
    public TextView f18942e;

    public x(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        View inflate = View.inflate(context, ResourceUtil.getLayoutId(context, "sig_ad_privacy_new_layout"), this);
        this.f18938a = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_ad_logo"));
        this.f18939b = inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_view"));
        this.f18940c = inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_ll"));
        this.f18942e = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_ad_text"));
    }

    public TextView getPrivacyAdText() {
        return this.f18942e;
    }

    public View getPrivacyLl() {
        return this.f18940c;
    }

    public x(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void a(String str, boolean z10) {
        if (!TextUtils.isEmpty(str)) {
            com.sigmob.sdk.base.common.h.o().load(str).into(this.f18938a);
        }
        this.f18939b.setVisibility(z10 ? 0 : 8);
    }

    public x(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context);
    }
}
