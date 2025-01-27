package com.sigmob.sdk.nativead;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.sigmob.sdk.base.models.BaseAdUnit;

/* loaded from: classes4.dex */
public class t extends com.sigmob.sdk.base.common.j {

    /* renamed from: i */
    public RelativeLayout f20035i;

    /* renamed from: j */
    public LinearLayout f20036j;

    /* renamed from: k */
    public TextView f20037k;

    /* renamed from: l */
    public BaseAdUnit f20038l;

    /* renamed from: m */
    public String f20039m;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (t.this.f17902e != null) {
                t.this.f17902e.a();
            }
        }
    }

    public t(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, com.sigmob.sdk.base.common.k kVar) {
        super(activity, str, kVar);
        this.f20039m = "此广告由SigMob提供，为了在应用程序上向您推荐展示出更加个性和实用的广告，对您可能会接收到的一部分广告进行更具相关性的定制，从而使您在应用程序上有更好的用户体验。SigMob非常重视数据安全，将努力采取合理的安全措施（包括技术方面和管理方面）来保护数据安全，防止数据信息被不正当使用或未经授权的情况下被访问。";
        this.f20038l = baseAdUnit;
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void j() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void k() {
        this.f17901d.removeAllViews();
        this.f17901d.setBackgroundColor(-1);
        this.f17902e.onSetContentView(this.f17901d);
        LinearLayout linearLayout = new LinearLayout(h());
        linearLayout.setOrientation(1);
        this.f17901d.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout relativeLayout = new RelativeLayout(h());
        this.f20035i = relativeLayout;
        linearLayout.addView(relativeLayout, new RelativeLayout.LayoutParams(-1, Dips.dipsToIntPixels(50.0f, h())));
        View view = new View(h());
        view.setBackgroundColor(Color.parseColor("#E0E6EC"));
        linearLayout.addView(view, new RelativeLayout.LayoutParams(-1, Dips.dipsToIntPixels(1.0f, h())));
        int dipsToIntPixels = Dips.dipsToIntPixels(10.0f, h());
        ImageView imageView = new ImageView(h());
        imageView.setOnClickListener(new a());
        imageView.setImageResource(ResourceUtil.getDrawableId(h(), "sig_image_video_back_left_black"));
        int i10 = dipsToIntPixels * 2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i10, i10);
        layoutParams.setMargins(dipsToIntPixels, 0, dipsToIntPixels, 0);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        this.f20035i.addView(imageView, layoutParams);
        TextView textView = new TextView(h());
        textView.setText("为什么看到此广告");
        textView.setTextColor(-16777216);
        textView.setTextSize(1, 20.0f);
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.f20035i.addView(textView, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(h());
        this.f20036j = linearLayout2;
        linearLayout.addView(linearLayout2, new RelativeLayout.LayoutParams(-1, -1));
        TextView textView2 = new TextView(h());
        this.f20037k = textView2;
        textView2.setText(this.f20039m);
        this.f20037k.setTextColor(-16777216);
        this.f20037k.setTextSize(1, 15.0f);
        this.f20037k.setLineSpacing(2.0f, 1.2f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(13);
        int i11 = dipsToIntPixels / 2;
        layoutParams3.setMargins(i11, i11, i11, i11);
        this.f20036j.addView(this.f20037k, layoutParams3);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void l() {
        super.l();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void m() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void n() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void o() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
    }

    @Override // com.sigmob.sdk.base.common.j
    public boolean b() {
        com.sigmob.sdk.base.common.k kVar = this.f17902e;
        if (kVar == null) {
            return false;
        }
        kVar.a();
        return false;
    }
}
