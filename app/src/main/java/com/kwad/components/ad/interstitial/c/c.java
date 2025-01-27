package com.kwad.components.ad.interstitial.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.widget.KSFrameLayout;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c extends com.kwad.sdk.mvp.a {

    @NonNull
    public KsAdVideoPlayConfig dZ;
    public com.kwad.sdk.core.video.videoview.a eN;
    public com.kwad.components.core.webview.a.d.e gG;
    public com.kwad.components.ad.interstitial.d.b hL;
    public KsInterstitialAd.AdInteractionListener hN;
    public com.kwad.components.ad.interstitial.d hU;

    @NonNull
    public KSFrameLayout jC;
    public d jD;
    public boolean jH;
    public com.kwad.components.ad.interstitial.e.f ju;
    public boolean jw;
    public boolean jx;
    public boolean jy;
    public a jz;
    public com.kwad.components.core.d.b.c mApkDownloadHelper;
    public List<a> jA = new CopyOnWriteArrayList();
    public List<h> jB = new CopyOnWriteArrayList();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    public volatile boolean jG = false;
    public int jI = -1;
    public List<a.c> jF = new CopyOnWriteArrayList();
    private List<e> jv = new CopyOnWriteArrayList();
    public List<InterfaceC0137c> jE = new ArrayList();

    /* renamed from: com.kwad.components.ad.interstitial.c.c$1 */
    final class AnonymousClass1 implements a.b {
        final /* synthetic */ b jJ;

        AnonymousClass1(b bVar) {
            bVar = bVar;
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            c.this.b(bVar);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.c$2 */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.hU.dismiss();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.c$3 */
    final class AnonymousClass3 implements a.b {
        final /* synthetic */ int jL;
        final /* synthetic */ int jM;
        final /* synthetic */ Context jN;

        AnonymousClass3(int i2, int i3, Context context) {
            i5 = i2;
            i2 = i3;
            context = context;
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            c.this.a(i5, i2, context);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.c$4 */
    final class AnonymousClass4 implements ImageLoadingListener {
        final /* synthetic */ View fn;
        final /* synthetic */ Context jN;

        /* renamed from: com.kwad.components.ad.interstitial.c.c$4$1 */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ DecodedResult jO;

            /* renamed from: com.kwad.components.ad.interstitial.c.c$4$1$1 */
            final class RunnableC01361 implements Runnable {
                final /* synthetic */ RoundedBitmapDrawable jQ;

                RunnableC01361(RoundedBitmapDrawable roundedBitmapDrawable) {
                    create = roundedBitmapDrawable;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass4.this.fn.setBackground(create);
                }
            }

            AnonymousClass1(DecodedResult decodedResult) {
                decodedResult = decodedResult;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Bitmap bitmap = decodedResult.mBitmap;
                com.kwad.sdk.core.d.b.d("InterstitialCallerContext", "onLoadingComplete before blur");
                Bitmap stackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                com.kwad.sdk.core.d.b.d("InterstitialCallerContext", "onLoadingComplete after blur");
                float dimension = AnonymousClass4.this.jN.getResources().getDimension(R.dimen.ksad_interstitial_icon_radius);
                RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(AnonymousClass4.this.jN.getResources(), stackBlur);
                create.setCornerRadius(dimension);
                AnonymousClass4.this.fn.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.c.4.1.1
                    final /* synthetic */ RoundedBitmapDrawable jQ;

                    RunnableC01361(RoundedBitmapDrawable create2) {
                        create = create2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass4.this.fn.setBackground(create);
                    }
                });
            }
        }

        AnonymousClass4(Context context, View view) {
            this.jN = context;
            this.fn = view;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
            com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.c.4.1
                final /* synthetic */ DecodedResult jO;

                /* renamed from: com.kwad.components.ad.interstitial.c.c$4$1$1 */
                final class RunnableC01361 implements Runnable {
                    final /* synthetic */ RoundedBitmapDrawable jQ;

                    RunnableC01361(RoundedBitmapDrawable create2) {
                        create = create2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass4.this.fn.setBackground(create);
                    }
                }

                AnonymousClass1(DecodedResult decodedResult2) {
                    decodedResult = decodedResult2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Bitmap bitmap = decodedResult.mBitmap;
                    com.kwad.sdk.core.d.b.d("InterstitialCallerContext", "onLoadingComplete before blur");
                    Bitmap stackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                    com.kwad.sdk.core.d.b.d("InterstitialCallerContext", "onLoadingComplete after blur");
                    float dimension = AnonymousClass4.this.jN.getResources().getDimension(R.dimen.ksad_interstitial_icon_radius);
                    RoundedBitmapDrawable create2 = RoundedBitmapDrawableFactory.create(AnonymousClass4.this.jN.getResources(), stackBlur);
                    create2.setCornerRadius(dimension);
                    AnonymousClass4.this.fn.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.c.4.1.1
                        final /* synthetic */ RoundedBitmapDrawable jQ;

                        RunnableC01361(RoundedBitmapDrawable create22) {
                            create = create22;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass4.this.fn.setBackground(create);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }
    }

    public interface a {
        void cr();
    }

    public static class b {
        private final Context context;
        private int jS;
        private boolean jT;
        private int jU;
        private boolean jV;
        private ac.a jW;
        public double jX;
        public boolean jY;

        public b(Context context) {
            this.context = context;
        }

        public final b C(int i2) {
            this.jS = i2;
            return this;
        }

        public final b D(int i2) {
            this.jU = i2;
            return this;
        }

        public final b a(ac.a aVar) {
            this.jW = aVar;
            return this;
        }

        public final b c(double d2) {
            this.jX = d2;
            return this;
        }

        public final int db() {
            return this.jS;
        }

        public final boolean dc() {
            return this.jT;
        }

        public final boolean dd() {
            return this.jV;
        }

        public final int de() {
            return this.jU;
        }

        public final double df() {
            return this.jX;
        }

        public final Context getContext() {
            return this.context;
        }

        public final ac.a getTouchCoords() {
            return this.jW;
        }

        public final b k(boolean z) {
            this.jT = z;
            return this;
        }

        public final b l(boolean z) {
            this.jV = true;
            return this;
        }

        public final b m(boolean z) {
            this.jY = true;
            return this;
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.c$c */
    public interface InterfaceC0137c {
        void dg();
    }

    public interface d {
        void dh();
    }

    interface e {
        void onError();
    }

    private static int a(long j2, @NonNull AdTemplate adTemplate) {
        if (j2 == -1) {
            return -1;
        }
        float G = com.kwad.sdk.core.response.a.a.G(com.kwad.sdk.core.response.a.d.cb(adTemplate)) / 1000.0f;
        if (G != 0.0f) {
            return Math.round((j2 / G) * 100.0f);
        }
        return -1;
    }

    private static long a(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        return aVar.getCurrentPosition();
    }

    public void a(int i2, int i3, Context context) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, new com.kwad.sdk.core.report.i().bn(i2).bj(i3).bu(ai.DL() ? 2 : 1).wY(), (JSONObject) null);
        if (!this.jy && (adInteractionListener = this.hN) != null) {
            adInteractionListener.onAdClicked();
        }
        this.jw = true;
        if (this.jy) {
            return;
        }
        cr();
    }

    public static boolean a(Context context, AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.a.aO(adInfo) && !ai.DL();
    }

    private static int b(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1;
        }
        long duration = aVar.getDuration();
        long currentPosition = aVar.getCurrentPosition();
        if (duration != 0) {
            return Math.round((currentPosition / duration) * 100.0f);
        }
        return -1;
    }

    public final boolean M(Context context) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null && context != null) {
            return com.kwad.sdk.core.response.a.a.bv(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        }
        com.kwad.sdk.core.d.b.w("InterstitialCallerContext", "isPlayable illegal params: " + this.mAdTemplate + ", context: " + context);
        return false;
    }

    public final void a(Context context, int i2, int i3, int i4) {
        com.kwad.components.core.d.b.a.a(new a.C0172a(context).I(this.mAdTemplate).b(this.mApkDownloadHelper).ao(false).ap(2).an(6).ao(i2).a(new a.b() { // from class: com.kwad.components.ad.interstitial.c.c.3
            final /* synthetic */ int jL;
            final /* synthetic */ int jM;
            final /* synthetic */ Context jN;

            AnonymousClass3(int i22, int i23, Context context2) {
                i5 = i22;
                i2 = i23;
                context = context2;
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                c.this.a(i5, i2, context);
            }
        }));
    }

    public final void a(Context context, AdInfo adInfo, AdTemplate adTemplate, @Nullable View view) {
        if (view == null) {
            return;
        }
        String url = com.kwad.sdk.core.response.a.a.bi(adInfo).getUrl();
        if (bb.isNullString(url)) {
            return;
        }
        KSImageLoader.loadImage(url, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new AnonymousClass4(context, view));
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.jA.add(aVar);
    }

    public final void a(b bVar) {
        boolean z = bVar.db() == 1;
        if ((com.kwad.components.ad.interstitial.kwai.b.cK() || z || bVar.dd() || bVar.jY) && com.kwad.components.core.d.b.a.a(new a.C0172a(bVar.getContext()).I(this.mAdTemplate).b(this.mApkDownloadHelper).ao(z).an(1).ao(bVar.jU).ap(bVar.db()).a(new a.b() { // from class: com.kwad.components.ad.interstitial.c.c.1
            final /* synthetic */ b jJ;

            AnonymousClass1(b bVar2) {
                bVar = bVar2;
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                c.this.b(bVar);
            }
        })) == 0 && this.hU != null && com.kwad.components.ad.interstitial.kwai.b.cN()) {
            a(false, -1, this.eN);
            this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.c.2
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    c.this.hU.dismiss();
                }
            }, 500L);
        }
    }

    public final void a(e eVar) {
        this.jv.add(eVar);
    }

    public final void a(h hVar) {
        if (hVar == null) {
            return;
        }
        this.jB.add(hVar);
    }

    public final void a(a.c cVar) {
        if (this.jF.contains(cVar)) {
            return;
        }
        this.jF.add(cVar);
    }

    public final void a(boolean z, int i2, @Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        long j2;
        int a2;
        if (aVar != null) {
            j2 = a(aVar);
            a2 = b(aVar);
        } else {
            j2 = i2;
            a2 = a(j2, this.mAdTemplate);
        }
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, z ? 14 : 1, j2, a2, this.hU.getTimerHelper().getTime(), null);
    }

    public final void b(Context context, AdTemplate adTemplate) {
        if (this.jG) {
            return;
        }
        com.kwad.components.core.page.a.launch(context, adTemplate);
        this.jG = true;
    }

    public final void b(a aVar) {
        if (aVar == null) {
            return;
        }
        this.jA.remove(aVar);
    }

    public final void b(b bVar) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
        iVar.c(bVar.getTouchCoords());
        if (!bVar.dc() && !bVar.jV) {
            bVar.D(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND);
        }
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, new com.kwad.sdk.core.report.i().bj(bVar.de()).c(bVar.getTouchCoords()).bu(ai.DL() ? 2 : 1).i(bVar.df()), (JSONObject) null);
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null) {
            long a2 = a(aVar);
            int b2 = b(this.eN);
            iVar.S(a2);
            iVar.bo(b2);
        }
        if (!this.jy && (adInteractionListener = this.hN) != null) {
            adInteractionListener.onAdClicked();
        }
        this.jw = true;
        if (this.jy) {
            return;
        }
        cr();
    }

    public final void b(h hVar) {
        if (hVar == null) {
            return;
        }
        this.jB.remove(hVar);
    }

    public final void b(a.c cVar) {
        this.jF.remove(cVar);
    }

    public final void cV() {
        List<e> list = this.jv;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (e eVar : this.jv) {
            if (eVar != null) {
                eVar.onError();
            }
        }
    }

    public final void cW() {
        d dVar = this.jD;
        if (dVar != null) {
            dVar.dh();
        }
    }

    public final void cX() {
        Iterator<InterfaceC0137c> it = this.jE.iterator();
        while (it.hasNext()) {
            it.next().dg();
        }
    }

    public final void cY() {
        Iterator<h> it = this.jB.iterator();
        while (it.hasNext()) {
            it.next().dA();
        }
    }

    public final void cZ() {
        Iterator<h> it = this.jB.iterator();
        while (it.hasNext()) {
            it.next().dB();
        }
    }

    public final void cr() {
        Iterator<a> it = this.jA.iterator();
        while (it.hasNext()) {
            it.next().cr();
        }
        a aVar = this.jz;
        if (aVar != null) {
            aVar.cr();
        }
    }

    public final boolean da() {
        com.kwad.components.ad.interstitial.e.f fVar = this.ju;
        boolean z = fVar == null || fVar.getParent() == null;
        com.kwad.sdk.core.d.b.d("InterstitialCallerContext", "isH5Interstitial :" + z);
        return z;
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.jF.clear();
        this.jv.clear();
        this.jE.clear();
        this.jB.clear();
        com.kwad.components.ad.interstitial.d.b bVar = this.hL;
        if (bVar != null) {
            bVar.rE();
        }
    }
}
