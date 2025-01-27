package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ah;

/* loaded from: classes2.dex */
public class SplashPlayDefaultInfoView extends FrameLayout {
    private KSCornerImageView GS;
    private ImageView GT;
    private TextView GU;
    private TextView iO;
    private TextView mK;

    public SplashPlayDefaultInfoView(@NonNull Context context) {
        super(context);
        mr();
    }

    private void mr() {
        View.inflate(getContext(), R.layout.ksad_play_card_default_info, this);
        this.GS = (KSCornerImageView) findViewById(R.id.ksad_splash_default_icon);
        this.iO = (TextView) findViewById(R.id.ksad_splash_default_title);
        this.GT = (ImageView) findViewById(R.id.ksad_splash_default_img);
        this.mK = (TextView) findViewById(R.id.ksad_splash_default_desc);
        this.GU = (TextView) findViewById(R.id.ksad_splash_default_tips);
    }

    public final void a(AdTemplate adTemplate, float f10) {
        AdInfo eb2 = e.eb(adTemplate);
        a(com.kwad.sdk.core.response.b.a.m37do(eb2) ? c.c(f10) : c.mp());
        this.GS.setRadius(com.kwad.sdk.c.a.a.a(getContext(), r5.mq()));
        KSImageLoader.loadImage(this.GS, com.kwad.sdk.core.response.b.a.cm(eb2), adTemplate);
        this.iO.setText(com.kwad.sdk.core.response.b.a.cj(eb2));
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.au(eb2))) {
            this.mK.setVisibility(8);
        } else {
            this.mK.setText(com.kwad.sdk.core.response.b.a.au(eb2));
        }
    }

    public SplashPlayDefaultInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        mr();
    }

    public SplashPlayDefaultInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        mr();
    }

    @RequiresApi(api = 21)
    public SplashPlayDefaultInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        mr();
    }

    private void a(c cVar) {
        ah.a(this, cVar.U(getContext()));
        ah.a(this.GS, cVar.V(getContext()));
        ah.a(this.iO, cVar.W(getContext()));
        ah.a(this.GT, cVar.X(getContext()));
        ah.a(this.mK, cVar.Y(getContext()));
        ah.a(this.GU, cVar.Z(getContext()));
        this.iO.setTextSize(0, cVar.aa(getContext()));
        this.mK.setTextSize(0, cVar.ab(getContext()));
        this.GU.setTextSize(0, cVar.ac(getContext()));
    }
}
