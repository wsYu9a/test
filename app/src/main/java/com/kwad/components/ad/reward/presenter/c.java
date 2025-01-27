package com.kwad.components.ad.reward.presenter;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.an;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class c extends b {
    private ImageView tF;
    private AdInfo tG;

    /* renamed from: com.kwad.components.ad.reward.presenter.c$1 */
    public class AnonymousClass1 extends SimpleImageLoadingListener {
        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
            return true;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
        }
    }

    public c(AdInfo adInfo) {
        this.tG = adInfo;
    }

    private static void a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.reward.presenter.c.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        AdTemplate adTemplate = this.rO.mAdTemplate;
        if (hL() || adTemplate.adInfoList.size() <= 0) {
            return;
        }
        String X = com.kwad.sdk.core.response.b.a.X(adTemplate.adInfoList.get(0));
        this.tF.setVisibility(hN());
        try {
            a(this.tF, X, adTemplate);
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
        }
    }

    public int hM() {
        return R.id.ksad_blur_video_cover;
    }

    public int hN() {
        getContext();
        if (com.kwad.components.ad.reward.g.J(this.rO.mAdTemplate) && !an.NS()) {
            return 0;
        }
        if (com.kwad.components.ad.reward.g.I(this.rO.mAdTemplate) && !an.NS()) {
            return 0;
        }
        if ((!com.kwad.sdk.core.response.b.e.en(this.rO.mAdTemplate) || an.NS()) && !com.kwad.components.ad.reward.g.g(this.tG)) {
            return (com.kwad.sdk.core.response.b.a.cK(this.tG) && com.kwad.components.ad.reward.a.b.gX() && !an.NS()) ? 0 : 8;
        }
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.tF = (ImageView) findViewById(hM());
    }
}
