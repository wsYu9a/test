package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TailFrameView extends KSFrameLayout {
    private com.kwad.components.ad.reward.widget.tailframe.a Dp;
    private g rO;

    public static class a extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        public a() {
            super(R.layout.ksad_video_tf_view_landscape_horizontal);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            KSImageLoader.loadImage(this.Dg, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
        }
    }

    public static class b extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        private ImageView Dq;
        private ImageView Dr;
        private ImageView Ds;

        public b() {
            super(R.layout.ksad_video_tf_view_landscape_vertical);
        }

        private void kI() {
            KSImageLoader.loadImage(this.Dq, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.Dr, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.Ds, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void A(Context context) {
            super.A(context);
            this.Dq = (ImageView) this.Df.findViewById(R.id.ksad_video_thumb_left);
            this.Dr = (ImageView) this.Df.findViewById(R.id.ksad_video_thumb_mid);
            this.Ds = (ImageView) this.Df.findViewById(R.id.ksad_video_thumb_right);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            kI();
        }
    }

    public static class c extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        private View Dt;

        public c() {
            super(R.layout.ksad_video_tf_view_portrait_horizontal);
        }

        private void kI() {
            AdInfo.AdMaterialInfo.MaterialFeature aX = com.kwad.sdk.core.response.b.a.aX(this.mAdInfo);
            int i10 = aX.width;
            int i11 = aX.height;
            int screenWidth = com.kwad.sdk.c.a.a.getScreenWidth(this.Df.getContext());
            int i12 = (int) (screenWidth * (i11 / i10));
            ViewGroup.LayoutParams layoutParams = this.Dg.getLayoutParams();
            layoutParams.width = screenWidth;
            layoutParams.height = i12;
            KSImageLoader.loadImage(this.Dg, aX.coverUrl, this.mAdTemplate);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void A(Context context) {
            super.A(context);
            this.Dt = this.Df.findViewById(R.id.video_cover);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (e.J(this.mAdTemplate)) {
                this.Dt.setVisibility(8);
                this.mLogoView.setVisibility(8);
                this.Df.setBackground(null);
            }
            kI();
        }
    }

    public static class d extends com.kwad.components.ad.reward.widget.tailframe.a {
        public d() {
            super(R.layout.ksad_video_tf_view_portrait_vertical);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (e.J(this.mAdTemplate)) {
                this.Df.setBackground(null);
                this.Dg.setVisibility(8);
                this.mLogoView.setVisibility(8);
            }
            KSImageLoader.loadImage(this.Dg, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
        }
    }

    public TailFrameView(@NonNull Context context) {
        super(context);
    }

    private void g(boolean z10, boolean z11) {
        if (this.Dp != null) {
            return;
        }
        if (z10) {
            if (z11) {
                this.Dp = new d();
                return;
            } else {
                this.Dp = new c();
                return;
            }
        }
        if (z11) {
            this.Dp = new b();
        } else {
            this.Dp = new a();
        }
    }

    public final void a(com.kwad.components.ad.reward.widget.tailframe.b bVar) {
        this.Dp.setCallerContext(this.rO);
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.Dp;
        g gVar = this.rO;
        aVar.a(gVar.mAdTemplate, gVar.mReportExtData, bVar);
    }

    public final void destroy() {
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.Dp;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    public final void kl() {
        this.Dp.kl();
    }

    public void setCallerContext(g gVar) {
        this.rO = gVar;
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public final void a(Context context, boolean z10, boolean z11) {
        g(z10, z11);
        this.Dp.A(context);
        this.Dp.g(z10, z11);
        addView(this.Dp.kE(), -1, -1);
    }

    public TailFrameView(@NonNull Context context, View view) {
        super(context, view);
    }
}
