package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.j;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TailFrameView extends KSFrameLayout {
    private com.kwad.components.ad.reward.widget.tailframe.a Bf;
    private j qt;

    static class a extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        public a() {
            super(R.layout.ksad_video_tf_view_landscape_horizontal);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            KSImageLoader.loadImage(this.AW, com.kwad.sdk.core.response.a.a.O(this.mAdInfo), this.mAdTemplate);
        }
    }

    static class b extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        private ImageView Bg;
        private ImageView Bh;
        private ImageView Bi;

        public b() {
            super(R.layout.ksad_video_tf_view_landscape_vertical);
        }

        private void kj() {
            KSImageLoader.loadImage(this.Bg, com.kwad.sdk.core.response.a.a.O(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.Bh, com.kwad.sdk.core.response.a.a.O(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.Bi, com.kwad.sdk.core.response.a.a.O(this.mAdInfo), this.mAdTemplate);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void D(Context context) {
            super.D(context);
            this.Bg = (ImageView) this.AV.findViewById(R.id.ksad_video_thumb_left);
            this.Bh = (ImageView) this.AV.findViewById(R.id.ksad_video_thumb_mid);
            this.Bi = (ImageView) this.AV.findViewById(R.id.ksad_video_thumb_right);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            kj();
        }
    }

    static class c extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        private View Bj;

        public c() {
            super(R.layout.ksad_video_tf_view_portrait_horizontal);
        }

        private void kj() {
            AdInfo.AdMaterialInfo.MaterialFeature aN = com.kwad.sdk.core.response.a.a.aN(this.mAdInfo);
            int i2 = aN.width;
            int i3 = aN.height;
            int screenWidth = com.kwad.sdk.c.kwai.a.getScreenWidth(this.AV.getContext());
            int i4 = (int) (screenWidth * (i3 / i2));
            ViewGroup.LayoutParams layoutParams = this.AW.getLayoutParams();
            layoutParams.width = screenWidth;
            layoutParams.height = i4;
            KSImageLoader.loadImage(this.AW, aN.coverUrl, this.mAdTemplate);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void D(Context context) {
            super.D(context);
            this.Bj = this.AV.findViewById(R.id.video_cover);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (com.kwad.sdk.core.response.a.d.p(this.mAdTemplate)) {
                this.Bj.setVisibility(8);
                this.mLogoView.setVisibility(8);
                this.AV.setBackground(null);
            }
            kj();
        }
    }

    static class d extends com.kwad.components.ad.reward.widget.tailframe.a {
        public d() {
            super(R.layout.ksad_video_tf_view_portrait_vertical);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (com.kwad.sdk.core.response.a.d.p(this.mAdTemplate)) {
                this.AV.setBackground(null);
                this.AW.setVisibility(8);
                this.mLogoView.setVisibility(8);
            }
            KSImageLoader.loadImage(this.AW, com.kwad.sdk.core.response.a.a.O(this.mAdInfo), this.mAdTemplate);
        }
    }

    public TailFrameView(@NonNull Context context) {
        super(context);
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public TailFrameView(@NonNull Context context, View view) {
        super(context, view);
    }

    private void d(boolean z, boolean z2) {
        if (this.Bf != null) {
            return;
        }
        this.Bf = z ? z2 ? new d() : new c() : z2 ? new b() : new a();
    }

    public final void a(Context context, boolean z, boolean z2) {
        d(z, z2);
        this.Bf.D(context);
        this.Bf.d(z, z2);
        addView(this.Bf.kf(), -1, -1);
    }

    public final void a(com.kwad.components.ad.reward.widget.tailframe.b bVar) {
        this.Bf.setCallerContext(this.qt);
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.Bf;
        j jVar = this.qt;
        aVar.a(jVar.mAdTemplate, jVar.mReportExtData, bVar);
    }

    public final void destroy() {
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.Bf;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    public final void jJ() {
        this.Bf.jJ();
    }

    public void setCallerContext(j jVar) {
        this.qt = jVar;
    }
}
