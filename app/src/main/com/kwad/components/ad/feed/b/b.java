package com.kwad.components.ad.feed.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class b extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    protected ImageView eT;
    protected TextView eU;
    protected TextView fX;
    protected ImageView fY;
    protected ImageView fZ;

    /* renamed from: fb */
    private TextView f11459fb;

    /* renamed from: ga */
    protected RatioFrameLayout f11460ga;

    /* renamed from: gb */
    protected TextView f11461gb;

    /* renamed from: gc */
    private TextView f11462gc;

    /* renamed from: gd */
    private View f11463gd;

    /* renamed from: ge */
    protected DownloadProgressView f11464ge;
    protected com.kwad.components.core.e.d.c mApkDownloadHelper;
    protected KsLogoView mLogoView;

    /* renamed from: com.kwad.components.ad.feed.b.b$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(b.this.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aU(eb2).height > com.kwad.sdk.core.response.b.a.aU(eb2).width) {
                ViewGroup.LayoutParams layoutParams = b.this.f11460ga.getLayoutParams();
                layoutParams.width = b.this.getWidth() / 2;
                b.this.f11460ga.setRatio(1.7857142686843872d);
                b.this.f11460ga.setLayoutParams(layoutParams);
            }
            List<String> ba2 = com.kwad.sdk.core.response.b.a.ba(b.this.mAdInfo);
            if (ba2.size() > 0) {
                KSImageLoader.loadFeeImage(b.this.fY, ba2.get(0), b.this.mAdTemplate, b.this.fV);
            } else {
                com.kwad.sdk.core.d.c.e("BaseFeedTextImageView", "getImageUrlList size less than one");
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.b$2 */
    public class AnonymousClass2 implements a.b {
        final /* synthetic */ int cO;

        public AnonymousClass2(int i10) {
            i10 = i10;
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            b.this.aM(i10);
        }
    }

    public b(@NonNull Context context) {
        super(context);
    }

    private void bF() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        findViewById(R.id.ksad_ad_download_container).setVisibility(8);
        this.f11462gc = (TextView) findViewById(R.id.ksad_h5_desc);
        this.f11459fb = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.f11463gd = findViewById(R.id.ksad_h5_open_cover);
        this.f11462gc.setText(com.kwad.components.ad.feed.f.g(this.mAdTemplate));
        this.f11459fb.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        this.f11463gd.setOnClickListener(this);
        this.f11462gc.setOnClickListener(this);
        this.f11459fb.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.f11463gd, this);
        new com.kwad.sdk.widget.f(getContext(), this.f11462gc, this);
        new com.kwad.sdk.widget.f(getContext(), this.f11459fb, this);
    }

    private void bG() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
        this.eT = (ImageView) findViewById(R.id.ksad_app_icon);
        this.eU = (TextView) findViewById(R.id.ksad_app_title);
        TextView textView = (TextView) findViewById(R.id.ksad_app_desc);
        this.f11461gb = textView;
        com.kwad.sdk.c.a.a.a(this, this.eT, this.eU, textView);
        new com.kwad.sdk.widget.f(getContext(), this.eT, this);
        new com.kwad.sdk.widget.f(getContext(), this.eU, this);
        new com.kwad.sdk.widget.f(getContext(), this.f11461gb, this);
        this.eU.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        this.eT.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.eT, com.kwad.sdk.core.response.b.a.cm(this.mAdInfo), this.mAdTemplate, 8);
        this.f11461gb.setText(com.kwad.components.ad.feed.f.g(this.mAdTemplate));
        bD();
        this.f11464ge.am(this.mAdTemplate);
        this.f11464ge.setOnClickListener(this);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.f11464ge.getAppDownloadListener());
        this.mApkDownloadHelper = cVar;
        cVar.d(this.f11464ge.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.f11464ge, this);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void Z() {
        DownloadProgressView downloadProgressView;
        super.Z();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (downloadProgressView = this.f11464ge) == null) {
            return;
        }
        cVar.b(downloadProgressView.getAppDownloadListener());
    }

    @Override // com.kwad.components.core.widget.b
    public final void bE() {
        this.fX = (TextView) findViewById(R.id.ksad_ad_desc);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_image_container);
        this.f11460ga = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.fY = (ImageView) findViewById(R.id.ksad_ad_image);
        this.fZ = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.f11464ge = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bH() {
        super.bH();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.f11464ge.getAppDownloadListener());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a(view, view == this.fX ? 25 : view == this.fY ? 100 : (view == this.f11464ge || view == this.f11459fb || view == this.f11463gd) ? 1 : view == this.eT ? 13 : view == this.eU ? 14 : (view == this.f11461gb || view == this.f11462gc) ? 101 : 35);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dQ(this.mAdTemplate)) {
            a(view, 153);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void c(@NonNull AdResultData adResultData) {
        super.c((b) adResultData);
        this.fX.setText(com.kwad.components.ad.feed.f.g(this.mAdTemplate));
        this.mLogoView.aK(this.mAdTemplate);
        this.fY.post(new bd() { // from class: com.kwad.components.ad.feed.b.b.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(b.this.mAdTemplate);
                if (com.kwad.sdk.core.response.b.a.aU(eb2).height > com.kwad.sdk.core.response.b.a.aU(eb2).width) {
                    ViewGroup.LayoutParams layoutParams = b.this.f11460ga.getLayoutParams();
                    layoutParams.width = b.this.getWidth() / 2;
                    b.this.f11460ga.setRatio(1.7857142686843872d);
                    b.this.f11460ga.setLayoutParams(layoutParams);
                }
                List<String> ba2 = com.kwad.sdk.core.response.b.a.ba(b.this.mAdInfo);
                if (ba2.size() > 0) {
                    KSImageLoader.loadFeeImage(b.this.fY, ba2.get(0), b.this.mAdTemplate, b.this.fV);
                } else {
                    com.kwad.sdk.core.d.c.e("BaseFeedTextImageView", "getImageUrlList size less than one");
                }
            }
        });
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            bG();
        } else {
            bF();
        }
        com.kwad.sdk.c.a.a.a(this, this.fX, this.fY, this.fZ);
        new com.kwad.sdk.widget.f(getContext(), this.fX, this);
        new com.kwad.sdk.widget.f(getContext(), this.fY, this);
        new com.kwad.sdk.widget.f(getContext(), this.fZ, this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    private void a(View view, int i10) {
        if (view == this.fZ) {
            us();
        } else {
            bC();
            com.kwad.components.core.e.d.a.a(new a.C0427a(getContext()).au(this.mAdTemplate).am(5).an(i10).b(this.mApkDownloadHelper).ao(view == this.f11464ge ? 1 : 2).ap(view == this.f11464ge).a(new a.b() { // from class: com.kwad.components.ad.feed.b.b.2
                final /* synthetic */ int cO;

                public AnonymousClass2(int i102) {
                    i10 = i102;
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    b.this.aM(i10);
                }
            }));
        }
    }
}
