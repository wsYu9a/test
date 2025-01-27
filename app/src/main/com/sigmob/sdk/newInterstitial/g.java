package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.sigmob.sdk.base.views.s;
import com.sigmob.sdk.base.views.w;

/* loaded from: classes4.dex */
public class g extends RelativeLayout {

    /* renamed from: a */
    public ImageView f20205a;

    /* renamed from: b */
    public ImageView f20206b;

    /* renamed from: c */
    public TextView f20207c;

    /* renamed from: d */
    public TextView f20208d;

    /* renamed from: e */
    public Button f20209e;

    /* renamed from: f */
    public ImageView f20210f;

    /* renamed from: g */
    public SigAdPrivacyInfoView f20211g;

    /* renamed from: h */
    public w f20212h;

    /* renamed from: i */
    public View f20213i;

    public class a implements ImageManager.BitmapLoadedListener {
        public a() {
        }

        @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
        public void onBitmapLoadFailed() {
        }

        @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
        public void onBitmapLoaded(Bitmap bitmap) {
            if (bitmap != null) {
                com.sigmob.sdk.base.blurkit.a.a(g.this.getContext());
                Bitmap a10 = com.sigmob.sdk.base.blurkit.a.a().a(bitmap.copy(bitmap.getConfig(), true), 25);
                if (a10 != null) {
                    g.this.f20210f.setImageBitmap(a10);
                }
            }
        }
    }

    public g(Context context) {
        super(context);
        a(context);
    }

    public SigAdPrivacyInfoView getAdPrivacyInfo() {
        return this.f20211g;
    }

    public Button getCTAButton() {
        return this.f20209e;
    }

    public View getCloseButton() {
        return this.f20205a;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a(Context context) {
        View inflate = View.inflate(context, ResourceUtil.getLayoutId(context, "sig_new_interstitial_endcard_layout"), this);
        this.f20213i = inflate.findViewById(ResourceUtil.getId(context, "sig_ad_rl_close"));
        ImageView imageView = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_close"));
        this.f20205a = imageView;
        if (imageView != null) {
            imageView.setImageBitmap(s.CLOSE_OLD.b());
        }
        this.f20206b = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_app_icon"));
        this.f20207c = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_title"));
        this.f20208d = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_desc"));
        this.f20209e = (Button) inflate.findViewById(ResourceUtil.getId(context, "sig_cta_button"));
        this.f20210f = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_endCard_image"));
        this.f20211g = (SigAdPrivacyInfoView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_info"));
    }

    public g(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context);
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        if (!TextUtils.isEmpty(str)) {
            com.sigmob.sdk.base.common.h.o().load(str).into(this.f20206b);
        }
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            com.sigmob.sdk.base.common.h.o().getBitmap(str, new a());
        }
        if (!TextUtils.isEmpty(str3)) {
            this.f20207c.setText(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            this.f20208d.setText(str4);
        }
        if (TextUtils.isEmpty(str5)) {
            return;
        }
        this.f20209e.setText(str5);
    }

    public void a(View.OnClickListener onClickListener) {
        if (this.f20212h == null) {
            Context context = getContext();
            w wVar = new w(context);
            this.f20212h = wVar;
            wVar.setText("反馈");
            this.f20212h.setOnClickListener(onClickListener);
            this.f20212h.setId(ClientMetadata.generateViewId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            layoutParams.addRule(0, this.f20213i.getId());
            layoutParams.addRule(8, this.f20213i.getId());
            ViewParent parent = this.f20213i.getParent();
            if (parent != null) {
                ((ViewGroup) parent).addView(this.f20212h, layoutParams);
            }
        }
    }
}
