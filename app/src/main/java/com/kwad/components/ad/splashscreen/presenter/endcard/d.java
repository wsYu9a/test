package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.InputStream;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d extends com.kwad.components.ad.splashscreen.presenter.e implements com.kwad.sdk.core.h.c {
    private ViewGroup Gm;
    private ImageView Gn;
    private SplashEndLandView Go;

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.endcard.d$1 */
    public class AnonymousClass1 extends com.kwad.components.ad.splashscreen.e.a {
        public AnonymousClass1(Context context, AdTemplate adTemplate) {
            super(adTemplate);
        }

        @Override // com.kwad.components.ad.splashscreen.e.a
        public final void k(int i10, String str) {
            d.this.X(str);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.endcard.d$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.this.Gm.getWidth();
            d.this.Go.a(d.this.EJ.mAdTemplate, d.this.EJ.mApkDownloadHelper, com.kwad.sdk.c.a.a.px2dip(d.this.getContext(), d.this.Gm.getHeight()) / 414.0f);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.endcard.d$3 */
    public class AnonymousClass3 extends SimpleImageLoadingListener {
        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 20, false);
            return true;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
        }
    }

    public void X(String str) {
        SplashEndLandView splashEndLandView = this.Go;
        if (splashEndLandView == null || str == null) {
            return;
        }
        splashEndLandView.X(str);
    }

    private void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_splash_endcard_view_stub);
        if (viewStub != null) {
            this.Gm = (ViewGroup) viewStub.inflate();
        } else {
            this.Gm = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_root);
        }
        boolean m37do = com.kwad.sdk.core.response.b.a.m37do(com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate));
        if (m37do) {
            this.Gm.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.d.2
                public AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    d.this.Gm.getWidth();
                    d.this.Go.a(d.this.EJ.mAdTemplate, d.this.EJ.mApkDownloadHelper, com.kwad.sdk.c.a.a.px2dip(d.this.getContext(), d.this.Gm.getHeight()) / 414.0f);
                }
            });
        }
        this.Gn = (ImageView) findViewById(R.id.ksad_splash_end_card_native_bg);
        SplashEndLandView splashEndLandView = (SplashEndLandView) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
        this.Go = splashEndLandView;
        splashEndLandView.t(m37do);
        SplashEndLandView splashEndLandView2 = this.Go;
        com.kwad.components.ad.splashscreen.h hVar = this.EJ;
        splashEndLandView2.a(hVar.mAdTemplate, hVar.mApkDownloadHelper, 1.0f);
    }

    private void lT() {
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate))) {
            AnonymousClass1 anonymousClass1 = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.EJ.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.d.1
                public AnonymousClass1(Context context, AdTemplate adTemplate) {
                    super(adTemplate);
                }

                @Override // com.kwad.components.ad.splashscreen.e.a
                public final void k(int i10, String str) {
                    d.this.X(str);
                }
            };
            com.kwad.components.core.e.d.c cVar = this.EJ.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(anonymousClass1);
            }
        }
    }

    private void lU() {
        this.Gm.setVisibility(0);
        a(this.Gn, com.kwad.sdk.core.response.b.a.aU(com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate)).materialUrl, this.EJ.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        initView();
        this.EJ.DV.a(this);
        com.kwad.sdk.core.adlog.c.d(this.EJ.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cN(87).cU(6));
        lT();
        lU();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bl() {
        SplashEndLandView splashEndLandView = this.Go;
        if (splashEndLandView != null) {
            splashEndLandView.bl();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bm() {
        SplashEndLandView splashEndLandView = this.Go;
        if (splashEndLandView != null) {
            splashEndLandView.bm();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        SplashEndLandView splashEndLandView = this.Go;
        if (splashEndLandView != null) {
            splashEndLandView.lV();
        }
        this.EJ.DV.b(this);
    }

    private static void a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(20).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.d.3
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 20, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }
        });
    }
}
