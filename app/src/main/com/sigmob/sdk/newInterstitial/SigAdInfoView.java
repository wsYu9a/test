package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: classes4.dex */
public class SigAdInfoView extends RelativeLayout {

    /* renamed from: a */
    public ImageView f20153a;

    /* renamed from: b */
    public TextView f20154b;

    /* renamed from: c */
    public TextView f20155c;

    /* renamed from: d */
    public SigAdPrivacyInfoView f20156d;

    /* renamed from: e */
    public boolean f20157e;

    public SigAdInfoView(Context context) {
        super(context);
        this.f20157e = false;
        a(context);
    }

    public final void a(Context context) {
        View inflate = View.inflate(context, ResourceUtil.getLayoutId(context, this.f20157e ? "sig_ad_app_info_small_layout" : "sig_ad_app_info_layout"), this);
        this.f20153a = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_app_icon"));
        this.f20154b = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_title"));
        this.f20155c = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_desc"));
        this.f20156d = (SigAdPrivacyInfoView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_info"));
    }

    public SigAdPrivacyInfoView getAdPrivacyInfo() {
        return this.f20156d;
    }

    public void setAppInfoView(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            com.sigmob.sdk.base.common.h.o().load(str).into(this.f20153a);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f20154b.setText(str2);
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.f20155c.setText(str3);
    }

    public SigAdInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20157e = false;
        this.f20157e = attributeSet.getAttributeBooleanValue(null, "sig_isSmall", false);
        a(context);
    }

    public SigAdInfoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f20157e = false;
        a(context);
    }
}
