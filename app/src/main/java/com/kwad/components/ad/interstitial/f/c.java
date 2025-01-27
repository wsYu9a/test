package com.kwad.components.ad.interstitial.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.kwad.components.core.e.d.a;
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
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c extends com.kwad.sdk.mvp.a {

    @NonNull
    public KsAdVideoPlayConfig bS;
    public com.kwad.sdk.core.video.videoview.a co;

    /* renamed from: jp */
    public com.kwad.components.ad.interstitial.g.b f11587jp;
    public KsInterstitialAd.AdInteractionListener jr;
    public com.kwad.components.ad.interstitial.d jz;
    public com.kwad.components.ad.interstitial.h.d kZ;

    /* renamed from: la */
    public boolean f11588la;

    /* renamed from: lb */
    public boolean f11589lb;

    /* renamed from: lc */
    public boolean f11590lc;

    /* renamed from: ld */
    public a f11591ld;

    /* renamed from: lf */
    public com.kwad.components.core.webview.tachikoma.e.f f11593lf;

    /* renamed from: lg */
    @NonNull
    public KSFrameLayout f11594lg;

    /* renamed from: lh */
    public d f11595lh;
    public boolean ll;
    public boolean lm;
    public AdResultData mAdResultData;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* renamed from: le */
    public List<a> f11592le = new CopyOnWriteArrayList();

    /* renamed from: hf */
    private Handler f11586hf = new Handler(Looper.getMainLooper());

    /* renamed from: lk */
    public volatile boolean f11598lk = false;
    public int ln = -1;

    /* renamed from: lj */
    public List<a.c> f11597lj = new CopyOnWriteArrayList();

    /* renamed from: li */
    public List<InterfaceC0383c> f11596li = new ArrayList();

    /* renamed from: com.kwad.components.ad.interstitial.f.c$1 */
    public class AnonymousClass1 implements a.b {
        final /* synthetic */ b lo;

        /* renamed from: com.kwad.components.ad.interstitial.f.c$1$1 */
        public class C03811 extends bd {
            public C03811() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                c.this.jz.dismiss();
                c.this.X();
            }
        }

        public AnonymousClass1(b bVar) {
            bVar = bVar;
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            c.this.b(bVar);
            c cVar = c.this;
            if (cVar.jz == null || !com.kwad.components.ad.interstitial.d.b.o(cVar.mAdTemplate)) {
                return;
            }
            c cVar2 = c.this;
            cVar2.a(false, -1, cVar2.co);
            c.this.f11586hf.postDelayed(new bd() { // from class: com.kwad.components.ad.interstitial.f.c.1.1
                public C03811() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    c.this.jz.dismiss();
                    c.this.X();
                }
            }, 500L);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.c$2 */
    public class AnonymousClass2 implements a.b {
        final /* synthetic */ Context hB;
        final /* synthetic */ int lr;
        final /* synthetic */ int ls;

        public AnonymousClass2(int i10, int i11, Context context) {
            i13 = i10;
            i10 = i11;
            context = context;
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            c cVar = c.this;
            int i10 = i13;
            int i11 = i10;
            cVar.a(i10, i11, context, 6L, i11);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.c$3 */
    public class AnonymousClass3 implements ImageLoadingListener {
        final /* synthetic */ View gE;
        final /* synthetic */ Context hB;

        /* renamed from: com.kwad.components.ad.interstitial.f.c$3$1 */
        public class AnonymousClass1 extends bd {
            final /* synthetic */ DecodedResult lt;

            /* renamed from: com.kwad.components.ad.interstitial.f.c$3$1$1 */
            public class C03821 extends bd {
                final /* synthetic */ RoundedBitmapDrawable lv;

                public C03821(RoundedBitmapDrawable roundedBitmapDrawable) {
                    create = roundedBitmapDrawable;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    AnonymousClass3.this.gE.setBackground(create);
                }
            }

            public AnonymousClass1(DecodedResult decodedResult) {
                decodedResult = decodedResult;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                Bitmap bitmap = decodedResult.mBitmap;
                com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "onLoadingComplete before blur");
                Bitmap stackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "onLoadingComplete after blur");
                float dimension = AnonymousClass3.this.hB.getResources().getDimension(R.dimen.ksad_interstitial_icon_radius);
                RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(AnonymousClass3.this.hB.getResources(), stackBlur);
                create.setCornerRadius(dimension);
                AnonymousClass3.this.gE.post(new bd() { // from class: com.kwad.components.ad.interstitial.f.c.3.1.1
                    final /* synthetic */ RoundedBitmapDrawable lv;

                    public C03821(RoundedBitmapDrawable create2) {
                        create = create2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        AnonymousClass3.this.gE.setBackground(create);
                    }
                });
            }
        }

        public AnonymousClass3(Context context, View view) {
            this.hB = context;
            this.gE = view;
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
            h.execute(new bd() { // from class: com.kwad.components.ad.interstitial.f.c.3.1
                final /* synthetic */ DecodedResult lt;

                /* renamed from: com.kwad.components.ad.interstitial.f.c$3$1$1 */
                public class C03821 extends bd {
                    final /* synthetic */ RoundedBitmapDrawable lv;

                    public C03821(RoundedBitmapDrawable create2) {
                        create = create2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        AnonymousClass3.this.gE.setBackground(create);
                    }
                }

                public AnonymousClass1(DecodedResult decodedResult2) {
                    decodedResult = decodedResult2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    Bitmap bitmap = decodedResult.mBitmap;
                    com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "onLoadingComplete before blur");
                    Bitmap stackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                    com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "onLoadingComplete after blur");
                    float dimension = AnonymousClass3.this.hB.getResources().getDimension(R.dimen.ksad_interstitial_icon_radius);
                    RoundedBitmapDrawable create2 = RoundedBitmapDrawableFactory.create(AnonymousClass3.this.hB.getResources(), stackBlur);
                    create2.setCornerRadius(dimension);
                    AnonymousClass3.this.gE.post(new bd() { // from class: com.kwad.components.ad.interstitial.f.c.3.1.1
                        final /* synthetic */ RoundedBitmapDrawable lv;

                        public C03821(RoundedBitmapDrawable create22) {
                            create = create22;
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            AnonymousClass3.this.gE.setBackground(create);
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
        void b(long j10, long j11);
    }

    public static class b {
        private final Context context;
        private boolean lA;
        private ag.a lB;
        public double lC;
        public boolean lD;
        private int lx;
        private boolean ly;
        private int lz;

        public b(Context context) {
            this.context = context;
        }

        public final b A(int i10) {
            this.lz = i10;
            return this;
        }

        public final b a(ag.a aVar) {
            this.lB = aVar;
            return this;
        }

        public final int dq() {
            return this.lx;
        }

        public final boolean dr() {
            return this.ly;
        }

        public final boolean ds() {
            return this.lA;
        }

        public final int dt() {
            return this.lz;
        }

        public final double du() {
            return this.lC;
        }

        public final Context getContext() {
            return this.context;
        }

        public final ag.a getTouchCoords() {
            return this.lB;
        }

        public final b l(boolean z10) {
            this.ly = z10;
            return this;
        }

        public final b m(boolean z10) {
            this.lA = true;
            return this;
        }

        public final b n(boolean z10) {
            this.lD = true;
            return this;
        }

        public final b z(int i10) {
            this.lx = i10;
            return this;
        }

        public final b c(double d10) {
            this.lC = d10;
            return this;
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.c$c */
    public interface InterfaceC0383c {
        void dv();
    }

    public interface d {
        void dw();
    }

    public final boolean L(Context context) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null && context != null) {
            return com.kwad.sdk.core.response.b.a.bJ(com.kwad.sdk.core.response.b.e.eb(adTemplate));
        }
        com.kwad.sdk.core.d.c.w("InterstitialCallerContext", "isPlayable illegal params: " + this.mAdTemplate + ", context: " + context);
        return false;
    }

    public final void X() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        if (this.f11590lc || (adInteractionListener = this.jr) == null) {
            return;
        }
        adInteractionListener.onAdClosed();
    }

    public final void b(a.c cVar) {
        this.f11597lj.remove(cVar);
    }

    public final void dn() {
        d dVar = this.f11595lh;
        if (dVar != null) {
            dVar.dw();
        }
    }

    /* renamed from: do */
    public final void m33do() {
        Iterator<InterfaceC0383c> it = this.f11596li.iterator();
        while (it.hasNext()) {
            it.next().dv();
        }
    }

    public final boolean dp() {
        com.kwad.components.ad.interstitial.h.d dVar = this.kZ;
        boolean z10 = dVar == null || dVar.getParent() == null;
        com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "isH5Interstitial :" + z10);
        return z10;
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.f11586hf.removeCallbacksAndMessages(null);
        this.f11597lj.clear();
        this.f11596li.clear();
        com.kwad.components.ad.interstitial.g.b bVar = this.f11587jp;
        if (bVar != null) {
            bVar.uF();
        }
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.o(adResultData);
    }

    public final void b(b bVar) {
        com.kwad.sdk.core.adlog.c.b bVar2 = new com.kwad.sdk.core.adlog.c.b();
        bVar2.f(bVar.getTouchCoords());
        if (!bVar.dr() && !bVar.lA) {
            bVar.A(153);
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cL(bVar.dt()).f(bVar.getTouchCoords()).cZ(an.NS() ? 2 : 1).l(bVar.du()), (JSONObject) null);
        com.kwad.sdk.core.video.videoview.a aVar = this.co;
        if (aVar != null) {
            long a10 = a(aVar);
            int b10 = b(this.co);
            bVar2.aq(a10);
            bVar2.cT(b10);
        }
        this.f11588la = true;
        if (this.f11590lc) {
            return;
        }
        b(1L, bVar.lz);
    }

    public final void c(Context context, AdTemplate adTemplate) {
        if (this.f11598lk) {
            return;
        }
        com.kwad.components.core.page.a.launch(context, adTemplate);
        this.f11598lk = true;
    }

    public final void a(a.c cVar) {
        if (this.f11597lj.contains(cVar)) {
            return;
        }
        this.f11597lj.add(cVar);
    }

    public final void a(b bVar) {
        com.kwad.components.ad.interstitial.report.a.ei().a(this.mAdTemplate, 1L, bVar.lz);
        boolean z10 = bVar.dq() == 1;
        if (com.kwad.components.ad.interstitial.b.b.dd() || z10 || bVar.ds() || bVar.lD) {
            com.kwad.components.core.e.d.a.a(new a.C0427a(bVar.getContext()).au(this.mAdTemplate).b(this.mApkDownloadHelper).ap(z10).am(1).an(bVar.lz).v(this.co.getCurrentPosition()).ao(bVar.dq()).a(new a.b() { // from class: com.kwad.components.ad.interstitial.f.c.1
                final /* synthetic */ b lo;

                /* renamed from: com.kwad.components.ad.interstitial.f.c$1$1 */
                public class C03811 extends bd {
                    public C03811() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        c.this.jz.dismiss();
                        c.this.X();
                    }
                }

                public AnonymousClass1(b bVar2) {
                    bVar = bVar2;
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.b(bVar);
                    c cVar = c.this;
                    if (cVar.jz == null || !com.kwad.components.ad.interstitial.d.b.o(cVar.mAdTemplate)) {
                        return;
                    }
                    c cVar2 = c.this;
                    cVar2.a(false, -1, cVar2.co);
                    c.this.f11586hf.postDelayed(new bd() { // from class: com.kwad.components.ad.interstitial.f.c.1.1
                        public C03811() {
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            c.this.jz.dismiss();
                            c.this.X();
                        }
                    }, 500L);
                }
            }));
        }
    }

    public final void b(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f11592le.remove(aVar);
    }

    public final void a(Context context, int i10, int i11, int i12) {
        com.kwad.components.ad.interstitial.report.a.ei().a(this.mAdTemplate, 6L, i10);
        com.kwad.components.core.e.d.a.a(new a.C0427a(context).au(this.mAdTemplate).b(this.mApkDownloadHelper).ap(false).ao(2).am(6).an(i10).a(new a.b() { // from class: com.kwad.components.ad.interstitial.f.c.2
            final /* synthetic */ Context hB;
            final /* synthetic */ int lr;
            final /* synthetic */ int ls;

            public AnonymousClass2(int i102, int i103, Context context2) {
                i13 = i102;
                i10 = i103;
                context = context2;
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                c cVar = c.this;
                int i102 = i13;
                int i112 = i10;
                cVar.a(i102, i112, context, 6L, i112);
            }
        }));
    }

    public final void b(long j10, long j11) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Iterator<a> it = this.f11592le.iterator();
        while (it.hasNext()) {
            it.next().b(j10, j11);
        }
        a aVar = this.f11591ld;
        if (aVar != null) {
            aVar.b(j10, j11);
        }
        if (this.f11590lc || (adInteractionListener = this.jr) == null) {
            return;
        }
        adInteractionListener.onAdClicked();
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

    public void a(int i10, int i11, Context context, long j10, long j11) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cS(i10).cL(i11).cZ(an.NS() ? 2 : 1).CQ(), (JSONObject) null);
        this.f11588la = true;
        if (this.f11590lc) {
            return;
        }
        b(j10, j11);
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f11592le.add(aVar);
    }

    public static boolean a(Context context, AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.a.aW(adInfo) && !an.NS();
    }

    public final void a(Context context, AdInfo adInfo, AdTemplate adTemplate, @Nullable View view) {
        if (view == null) {
            return;
        }
        String url = com.kwad.sdk.core.response.b.a.bt(adInfo).getUrl();
        if (bm.isNullString(url)) {
            return;
        }
        KSImageLoader.loadImage(url, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new AnonymousClass3(context, view));
    }

    public final void a(boolean z10, int i10, @Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        long j10;
        int a10;
        com.kwad.components.ad.interstitial.report.a.ei().a(this.mAdTemplate, bw.k(this.f11594lg, true));
        if (aVar != null) {
            j10 = a(aVar);
            a10 = b(aVar);
        } else {
            j10 = i10;
            a10 = a(j10, this.mAdTemplate);
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, z10 ? 14 : 1, j10, a10, this.jz.getTimerHelper().getTime(), null);
    }

    private static long a(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        return aVar.getCurrentPosition();
    }

    private static int a(long j10, @NonNull AdTemplate adTemplate) {
        if (j10 == -1) {
            return -1;
        }
        float M = com.kwad.sdk.core.response.b.a.M(com.kwad.sdk.core.response.b.e.eb(adTemplate)) / 1000.0f;
        if (M != 0.0f) {
            return Math.round((j10 / M) * 100.0f);
        }
        return -1;
    }
}
