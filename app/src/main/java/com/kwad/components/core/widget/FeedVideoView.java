package com.kwad.components.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.r.n;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.j.k;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FeedVideoView extends b<AdTemplate> implements NestedScrollingChild {
    private NestedScrollingChildHelper MO;
    private com.kwad.components.core.video.e Ng;
    private int WA;
    private boolean WB;
    private boolean WC;
    private long WD;
    private boolean WE;
    private KsAdVideoPlayConfig WF;
    private a WG;
    private View WH;
    private boolean WI;
    private Runnable WJ;
    private n WK;
    private RatioFrameLayout Wk;
    private TextView Wl;
    private TextView Wm;
    private TextView Wn;
    private View Wo;
    private KSCornerImageView Wp;
    private TextView Wq;
    private ScaleAnimSeekBar Wr;
    private ImageView Ws;
    private ImageView Wt;
    private ImageView Wu;
    private ViewGroup Wv;
    private ViewGroup Ww;
    private TextView Wx;
    private ViewGroup Wy;
    private ViewGroup Wz;
    private KsAppDownloadListener cE;
    private List<Integer> cI;
    private View.OnClickListener cb;
    private TextView eA;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$1 */
    final class AnonymousClass1 extends com.kwad.sdk.core.download.kwai.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            FeedVideoView.this.Wn.setText(com.kwad.sdk.core.response.a.a.aw(FeedVideoView.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            FeedVideoView.this.Wn.setText(com.kwad.sdk.core.response.a.a.aH(FeedVideoView.this.mAdTemplate));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            FeedVideoView.this.Wn.setText(com.kwad.sdk.core.response.a.a.aw(FeedVideoView.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            FeedVideoView.this.Wn.setText(com.kwad.sdk.core.response.a.a.T(FeedVideoView.this.mAdInfo));
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i2) {
            FeedVideoView.this.Wn.setText(com.kwad.sdk.core.response.a.a.bz(i2));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
            FeedVideoView.this.Wn.setText(com.kwad.sdk.core.response.a.a.by(i2));
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$10 */
    final class AnonymousClass10 implements View.OnClickListener {
        final /* synthetic */ com.kwad.sdk.core.video.videoview.a WM;

        AnonymousClass10(com.kwad.sdk.core.video.videoview.a aVar) {
            aVar2 = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onClick(android.view.View r4) {
            /*
                r3 = this;
                com.kwad.sdk.core.video.videoview.a r4 = r2
                boolean r4 = r4.isPaused()
                if (r4 != 0) goto L58
                com.kwad.sdk.core.video.videoview.a r4 = r2
                boolean r4 = r4.isIdle()
                if (r4 == 0) goto L11
                goto L58
            L11:
                com.kwad.sdk.core.video.videoview.a r4 = r2
                boolean r4 = r4.isPlaying()
                if (r4 == 0) goto L8b
                com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                com.kwad.components.core.video.e r4 = com.kwad.components.core.widget.FeedVideoView.e(r4)
                r4.qv()
                com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                android.widget.ImageView r4 = com.kwad.components.core.widget.FeedVideoView.d(r4)
                r0 = 0
                r4.setVisibility(r0)
                com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                android.widget.ImageView r4 = com.kwad.components.core.widget.FeedVideoView.d(r4)
                com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                android.content.Context r0 = r0.getContext()
                android.content.res.Resources r0 = r0.getResources()
                int r1 = com.kwad.sdk.R.drawable.ksad_video_play_176
                android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
                r4.setImageDrawable(r0)
                com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                android.widget.ImageView r4 = com.kwad.components.core.widget.FeedVideoView.p(r4)
                com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                android.content.Context r0 = r0.getContext()
                android.content.res.Resources r0 = r0.getResources()
                int r1 = com.kwad.sdk.R.drawable.ksad_video_player_play_btn
                goto L84
            L58:
                com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                com.kwad.components.core.video.e r4 = com.kwad.components.core.widget.FeedVideoView.e(r4)
                r4.qw()
                com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                android.widget.ImageView r4 = com.kwad.components.core.widget.FeedVideoView.p(r4)
                com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                android.content.res.Resources r0 = r0.getResources()
                int r1 = com.kwad.sdk.R.drawable.ksad_video_player_pause_btn
                android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
                r4.setImageDrawable(r0)
                com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                android.widget.ImageView r4 = com.kwad.components.core.widget.FeedVideoView.d(r4)
                com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                android.content.res.Resources r0 = r0.getResources()
                int r1 = com.kwad.sdk.R.drawable.ksad_video_player_pause_center
            L84:
                android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
                r4.setImageDrawable(r0)
            L8b:
                com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                android.os.Handler r4 = r4.getHandler()
                if (r4 == 0) goto Lb3
                com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                android.os.Handler r4 = r4.getHandler()
                com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                com.kwad.components.core.r.n r0 = com.kwad.components.core.widget.FeedVideoView.h(r0)
                r4.removeCallbacks(r0)
                com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                android.os.Handler r4 = r4.getHandler()
                com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                com.kwad.components.core.r.n r0 = com.kwad.components.core.widget.FeedVideoView.h(r0)
                r1 = 5000(0x1388, double:2.4703E-320)
                r4.postDelayed(r0, r1)
            Lb3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.widget.FeedVideoView.AnonymousClass10.onClick(android.view.View):void");
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$11 */
    final class AnonymousClass11 implements View.OnClickListener {
        AnonymousClass11() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (FeedVideoView.this.eN.isPaused() || FeedVideoView.this.eN.isIdle()) {
                FeedVideoView.this.oT();
            } else if (FeedVideoView.this.eN.isPlaying()) {
                FeedVideoView.this.qb();
            }
            if (FeedVideoView.this.getHandler() != null) {
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WK);
                FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.WK, 5000L);
            }
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$2 */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FeedVideoView.this.rx();
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$3 */
    final class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (FeedVideoView.this.WA == 100) {
                FeedVideoView.this.rw();
            } else if (FeedVideoView.this.WA == 101) {
                FeedVideoView.this.rx();
            }
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$4 */
    final class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (FeedVideoView.this.cb != null) {
                FeedVideoView.this.cb.onClick(view);
            }
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$5 */
    final class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            FeedVideoView.this.Wv.setVisibility(8);
            FeedVideoView.this.Wu.setVisibility(8);
            if (FeedVideoView.this.Ng != null) {
                FeedVideoView.this.Ng.aM(true);
            }
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$6 */
    final class AnonymousClass6 implements View.OnClickListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (FeedVideoView.this.Wv.getVisibility() != 8) {
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WJ);
                    if (FeedVideoView.this.WE) {
                        return;
                    }
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.WK, 1000L);
                    return;
                }
                return;
            }
            if (!FeedVideoView.this.eN.isCompleted()) {
                FeedVideoView.this.Wv.setVisibility(0);
                FeedVideoView.this.Wu.setVisibility(0);
                if (FeedVideoView.this.Ng != null) {
                    FeedVideoView.this.Ng.aM(false);
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WJ);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.WK, 5000L);
                    return;
                }
                return;
            }
            if (FeedVideoView.this.WA != 101) {
                if (FeedVideoView.this.cb != null) {
                    FeedVideoView.this.cb.onClick(view);
                    return;
                }
                return;
            }
            FeedVideoView.this.Wv.setVisibility(0);
            FeedVideoView.this.Wu.setVisibility(8);
            if (FeedVideoView.this.Ng != null) {
                FeedVideoView.this.Ng.aM(false);
            }
            if (FeedVideoView.this.getHandler() != null) {
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WJ);
                FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.WK, 5000L);
            }
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$7 */
    final class AnonymousClass7 implements a.c {
        final /* synthetic */ com.kwad.sdk.core.video.videoview.a WM;
        private boolean cJ = false;

        AnonymousClass7(com.kwad.sdk.core.video.videoview.a aVar) {
            aVar2 = aVar;
        }

        @Override // com.kwad.components.core.video.a.c
        public final void bt() {
            com.kwad.sdk.core.report.a.av(FeedVideoView.this.mAdTemplate);
            FeedVideoView.this.Wv.setVisibility(8);
            FeedVideoView.this.Wu.setVisibility(8);
            FeedVideoView.this.Wr.setProgress(100);
            FeedVideoView.this.Wm.setText(bg.I(aVar2.getDuration()));
        }

        @Override // com.kwad.components.core.video.a.c
        public final void d(long j2) {
            FeedVideoView.this.c(j2);
            float duration = (j2 * 100.0f) / aVar2.getDuration();
            if (!FeedVideoView.this.WE) {
                FeedVideoView.this.Wr.setProgress((int) duration);
                FeedVideoView.this.Wm.setText(bg.I(j2));
            }
            FeedVideoView.this.Wl.setText(bg.I(aVar2.getDuration()));
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlayStart() {
            if (!FeedVideoView.this.WI) {
                FeedVideoView.a(FeedVideoView.this, true);
                if (com.kwad.sdk.core.response.a.a.ae(FeedVideoView.this.mAdInfo) != 0) {
                    FeedVideoView.this.eN.setVideoSoundEnable(true ^ com.kwad.sdk.core.response.a.a.ag(FeedVideoView.this.mAdInfo));
                }
                if (com.kwad.sdk.core.response.a.a.ae(FeedVideoView.this.mAdInfo) != 0) {
                    FeedVideoView.this.eN.setLooping(com.kwad.sdk.core.response.a.a.af(FeedVideoView.this.mAdInfo));
                }
            }
            com.kwad.sdk.core.report.a.h(FeedVideoView.this.mAdTemplate);
            FeedVideoView.this.Wl.setText(bg.I(aVar2.getDuration()));
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlaying() {
            if (!FeedVideoView.this.WI) {
                FeedVideoView.a(FeedVideoView.this, true);
                if (com.kwad.sdk.core.response.a.a.ae(FeedVideoView.this.mAdInfo) != 0) {
                    FeedVideoView.this.eN.setVideoSoundEnable(!com.kwad.sdk.core.response.a.a.ag(FeedVideoView.this.mAdInfo));
                }
                if (com.kwad.sdk.core.response.a.a.ae(FeedVideoView.this.mAdInfo) != 0) {
                    FeedVideoView.this.eN.setLooping(com.kwad.sdk.core.response.a.a.af(FeedVideoView.this.mAdInfo));
                }
            }
            if (this.cJ) {
                return;
            }
            this.cJ = true;
            com.kwad.components.core.m.a.pb().a(FeedVideoView.this.mAdTemplate, System.currentTimeMillis(), 1);
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$8 */
    final class AnonymousClass8 implements a.InterfaceC0187a {

        /* renamed from: com.kwad.components.core.widget.FeedVideoView$8$1 */
        final class AnonymousClass1 implements a.b {
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                FeedVideoView.this.eh();
            }
        }

        AnonymousClass8() {
        }

        @Override // com.kwad.components.core.video.a.InterfaceC0187a
        public final void a(int i2, ac.a aVar) {
            int i3 = 171;
            int i4 = 2;
            boolean z = false;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        i3 = com.kwad.sdk.core.response.a.a.ae(FeedVideoView.this.mAdInfo) != 0 ? 50 : 83;
                        i4 = 1;
                        z = true;
                    } else if (com.kwad.sdk.core.response.a.a.ae(FeedVideoView.this.mAdInfo) == 0) {
                        i3 = 108;
                    }
                } else if (com.kwad.sdk.core.response.a.a.ae(FeedVideoView.this.mAdInfo) == 0) {
                    i3 = 82;
                }
            } else if (com.kwad.sdk.core.response.a.a.ae(FeedVideoView.this.mAdInfo) == 0) {
                i3 = 13;
            }
            y.b bVar = new y.b();
            bVar.jW = aVar;
            bVar.jU = i3;
            com.kwad.components.core.d.b.a.a(new a.C0172a(FeedVideoView.this.getContext()).I(FeedVideoView.this.mAdTemplate).at(true).b(FeedVideoView.this.mApkDownloadHelper).ap(i4).ao(z).aq(true).a(bVar).a(new a.b() { // from class: com.kwad.components.core.widget.FeedVideoView.8.1
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    FeedVideoView.this.eh();
                }
            }));
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$9 */
    final class AnonymousClass9 implements ScaleAnimSeekBar.a {
        final /* synthetic */ com.kwad.sdk.core.video.videoview.a WM;

        AnonymousClass9(com.kwad.sdk.core.video.videoview.a aVar) {
            aVar2 = aVar;
        }

        @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
        public final void a(ScaleAnimSeekBar scaleAnimSeekBar) {
            FeedVideoView.this.Wr.aY(false);
            aVar2.seekTo((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
            if (FeedVideoView.this.getHandler() != null) {
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WK);
                FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.WK, 5000L);
            }
            FeedVideoView.this.WE = false;
        }

        @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
        public final void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z) {
            if (z) {
                FeedVideoView.this.Wr.aY(true);
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WK);
                FeedVideoView.this.WE = true;
                FeedVideoView.this.Wm.setText(bg.I((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
            }
        }

        @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
        public final void rz() {
            FeedVideoView.this.Wr.aY(true);
            FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WK);
            FeedVideoView.this.WE = true;
        }
    }

    public interface a {
        void oh();

        void oi();
    }

    public FeedVideoView(@NonNull Context context) {
        super(context);
        this.WA = 100;
        AnonymousClass5 anonymousClass5 = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.Wv.setVisibility(8);
                FeedVideoView.this.Wu.setVisibility(8);
                if (FeedVideoView.this.Ng != null) {
                    FeedVideoView.this.Ng.aM(true);
                }
            }
        };
        this.WJ = anonymousClass5;
        this.WK = new n(anonymousClass5);
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.WA = 100;
        AnonymousClass5 anonymousClass5 = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.Wv.setVisibility(8);
                FeedVideoView.this.Wu.setVisibility(8);
                if (FeedVideoView.this.Ng != null) {
                    FeedVideoView.this.Ng.aM(true);
                }
            }
        };
        this.WJ = anonymousClass5;
        this.WK = new n(anonymousClass5);
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.WA = 100;
        AnonymousClass5 anonymousClass5 = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.Wv.setVisibility(8);
                FeedVideoView.this.Wu.setVisibility(8);
                if (FeedVideoView.this.Ng != null) {
                    FeedVideoView.this.Ng.aM(true);
                }
            }
        };
        this.WJ = anonymousClass5;
        this.WK = new n(anonymousClass5);
    }

    private void a(com.kwad.components.core.video.a aVar, com.kwad.sdk.core.video.videoview.a aVar2) {
        this.Wy.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.6
            AnonymousClass6() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.Wv.getVisibility() != 8) {
                    if (FeedVideoView.this.getHandler() != null) {
                        FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WJ);
                        if (FeedVideoView.this.WE) {
                            return;
                        }
                        FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.WK, 1000L);
                        return;
                    }
                    return;
                }
                if (!FeedVideoView.this.eN.isCompleted()) {
                    FeedVideoView.this.Wv.setVisibility(0);
                    FeedVideoView.this.Wu.setVisibility(0);
                    if (FeedVideoView.this.Ng != null) {
                        FeedVideoView.this.Ng.aM(false);
                    }
                    if (FeedVideoView.this.getHandler() != null) {
                        FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WJ);
                        FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.WK, 5000L);
                        return;
                    }
                    return;
                }
                if (FeedVideoView.this.WA != 101) {
                    if (FeedVideoView.this.cb != null) {
                        FeedVideoView.this.cb.onClick(view);
                        return;
                    }
                    return;
                }
                FeedVideoView.this.Wv.setVisibility(0);
                FeedVideoView.this.Wu.setVisibility(8);
                if (FeedVideoView.this.Ng != null) {
                    FeedVideoView.this.Ng.aM(false);
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WJ);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.WK, 5000L);
                }
            }
        });
        aVar.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            final /* synthetic */ com.kwad.sdk.core.video.videoview.a WM;
            private boolean cJ = false;

            AnonymousClass7(com.kwad.sdk.core.video.videoview.a aVar22) {
                aVar2 = aVar22;
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bt() {
                com.kwad.sdk.core.report.a.av(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.Wv.setVisibility(8);
                FeedVideoView.this.Wu.setVisibility(8);
                FeedVideoView.this.Wr.setProgress(100);
                FeedVideoView.this.Wm.setText(bg.I(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j2) {
                FeedVideoView.this.c(j2);
                float duration = (j2 * 100.0f) / aVar2.getDuration();
                if (!FeedVideoView.this.WE) {
                    FeedVideoView.this.Wr.setProgress((int) duration);
                    FeedVideoView.this.Wm.setText(bg.I(j2));
                }
                FeedVideoView.this.Wl.setText(bg.I(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                if (!FeedVideoView.this.WI) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.a.a.ae(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eN.setVideoSoundEnable(true ^ com.kwad.sdk.core.response.a.a.ag(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.a.a.ae(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eN.setLooping(com.kwad.sdk.core.response.a.a.af(FeedVideoView.this.mAdInfo));
                    }
                }
                com.kwad.sdk.core.report.a.h(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.Wl.setText(bg.I(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlaying() {
                if (!FeedVideoView.this.WI) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.a.a.ae(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eN.setVideoSoundEnable(!com.kwad.sdk.core.response.a.a.ag(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.a.a.ae(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eN.setLooping(com.kwad.sdk.core.response.a.a.af(FeedVideoView.this.mAdInfo));
                    }
                }
                if (this.cJ) {
                    return;
                }
                this.cJ = true;
                com.kwad.components.core.m.a.pb().a(FeedVideoView.this.mAdTemplate, System.currentTimeMillis(), 1);
            }
        });
        this.Ng.setAdClickListener(new a.InterfaceC0187a() { // from class: com.kwad.components.core.widget.FeedVideoView.8

            /* renamed from: com.kwad.components.core.widget.FeedVideoView$8$1 */
            final class AnonymousClass1 implements a.b {
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    FeedVideoView.this.eh();
                }
            }

            AnonymousClass8() {
            }

            @Override // com.kwad.components.core.video.a.InterfaceC0187a
            public final void a(int i2, ac.a aVar3) {
                int i3 = 171;
                int i4 = 2;
                boolean z = false;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            i3 = com.kwad.sdk.core.response.a.a.ae(FeedVideoView.this.mAdInfo) != 0 ? 50 : 83;
                            i4 = 1;
                            z = true;
                        } else if (com.kwad.sdk.core.response.a.a.ae(FeedVideoView.this.mAdInfo) == 0) {
                            i3 = 108;
                        }
                    } else if (com.kwad.sdk.core.response.a.a.ae(FeedVideoView.this.mAdInfo) == 0) {
                        i3 = 82;
                    }
                } else if (com.kwad.sdk.core.response.a.a.ae(FeedVideoView.this.mAdInfo) == 0) {
                    i3 = 13;
                }
                y.b bVar = new y.b();
                bVar.jW = aVar3;
                bVar.jU = i3;
                com.kwad.components.core.d.b.a.a(new a.C0172a(FeedVideoView.this.getContext()).I(FeedVideoView.this.mAdTemplate).at(true).b(FeedVideoView.this.mApkDownloadHelper).ap(i4).ao(z).aq(true).a(bVar).a(new a.b() { // from class: com.kwad.components.core.widget.FeedVideoView.8.1
                    AnonymousClass1() {
                    }

                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        FeedVideoView.this.eh();
                    }
                }));
            }
        });
        this.Wr.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a() { // from class: com.kwad.components.core.widget.FeedVideoView.9
            final /* synthetic */ com.kwad.sdk.core.video.videoview.a WM;

            AnonymousClass9(com.kwad.sdk.core.video.videoview.a aVar22) {
                aVar2 = aVar22;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                FeedVideoView.this.Wr.aY(false);
                aVar2.seekTo((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WK);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.WK, 5000L);
                }
                FeedVideoView.this.WE = false;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z) {
                if (z) {
                    FeedVideoView.this.Wr.aY(true);
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WK);
                    FeedVideoView.this.WE = true;
                    FeedVideoView.this.Wm.setText(bg.I((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void rz() {
                FeedVideoView.this.Wr.aY(true);
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WK);
                FeedVideoView.this.WE = true;
            }
        });
        this.Ws.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.10
            final /* synthetic */ com.kwad.sdk.core.video.videoview.a WM;

            AnonymousClass10(com.kwad.sdk.core.video.videoview.a aVar22) {
                aVar2 = aVar22;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                /*
                    this = this;
                    com.kwad.sdk.core.video.videoview.a r4 = r2
                    boolean r4 = r4.isPaused()
                    if (r4 != 0) goto L58
                    com.kwad.sdk.core.video.videoview.a r4 = r2
                    boolean r4 = r4.isIdle()
                    if (r4 == 0) goto L11
                    goto L58
                L11:
                    com.kwad.sdk.core.video.videoview.a r4 = r2
                    boolean r4 = r4.isPlaying()
                    if (r4 == 0) goto L8b
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    com.kwad.components.core.video.e r4 = com.kwad.components.core.widget.FeedVideoView.e(r4)
                    r4.qv()
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    android.widget.ImageView r4 = com.kwad.components.core.widget.FeedVideoView.d(r4)
                    r0 = 0
                    r4.setVisibility(r0)
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    android.widget.ImageView r4 = com.kwad.components.core.widget.FeedVideoView.d(r4)
                    com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                    android.content.Context r0 = r0.getContext()
                    android.content.res.Resources r0 = r0.getResources()
                    int r1 = com.kwad.sdk.R.drawable.ksad_video_play_176
                    android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
                    r4.setImageDrawable(r0)
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    android.widget.ImageView r4 = com.kwad.components.core.widget.FeedVideoView.p(r4)
                    com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                    android.content.Context r0 = r0.getContext()
                    android.content.res.Resources r0 = r0.getResources()
                    int r1 = com.kwad.sdk.R.drawable.ksad_video_player_play_btn
                    goto L84
                L58:
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    com.kwad.components.core.video.e r4 = com.kwad.components.core.widget.FeedVideoView.e(r4)
                    r4.qw()
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    android.widget.ImageView r4 = com.kwad.components.core.widget.FeedVideoView.p(r4)
                    com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                    android.content.res.Resources r0 = r0.getResources()
                    int r1 = com.kwad.sdk.R.drawable.ksad_video_player_pause_btn
                    android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
                    r4.setImageDrawable(r0)
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    android.widget.ImageView r4 = com.kwad.components.core.widget.FeedVideoView.d(r4)
                    com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                    android.content.res.Resources r0 = r0.getResources()
                    int r1 = com.kwad.sdk.R.drawable.ksad_video_player_pause_center
                L84:
                    android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
                    r4.setImageDrawable(r0)
                L8b:
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    android.os.Handler r4 = r4.getHandler()
                    if (r4 == 0) goto Lb3
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    android.os.Handler r4 = r4.getHandler()
                    com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                    com.kwad.components.core.r.n r0 = com.kwad.components.core.widget.FeedVideoView.h(r0)
                    r4.removeCallbacks(r0)
                    com.kwad.components.core.widget.FeedVideoView r4 = com.kwad.components.core.widget.FeedVideoView.this
                    android.os.Handler r4 = r4.getHandler()
                    com.kwad.components.core.widget.FeedVideoView r0 = com.kwad.components.core.widget.FeedVideoView.this
                    com.kwad.components.core.r.n r0 = com.kwad.components.core.widget.FeedVideoView.h(r0)
                    r1 = 5000(0x1388, double:2.4703E-320)
                    r4.postDelayed(r0, r1)
                Lb3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.widget.FeedVideoView.AnonymousClass10.onClick(android.view.View):void");
            }
        });
        this.Wu.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.11
            AnonymousClass11() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.eN.isPaused() || FeedVideoView.this.eN.isIdle()) {
                    FeedVideoView.this.oT();
                } else if (FeedVideoView.this.eN.isPlaying()) {
                    FeedVideoView.this.qb();
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.WK);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.WK, 5000L);
                }
            }
        });
        this.Ww.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVideoView.this.rx();
            }
        });
        this.Wt.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.3
            AnonymousClass3() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.WA == 100) {
                    FeedVideoView.this.rw();
                } else if (FeedVideoView.this.WA == 101) {
                    FeedVideoView.this.rx();
                }
            }
        });
    }

    static /* synthetic */ boolean a(FeedVideoView feedVideoView, boolean z) {
        feedVideoView.WI = true;
        return true;
    }

    public void c(long j2) {
        int ceil = (int) Math.ceil(j2 / 1000.0f);
        List<Integer> list = this.cI;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cI.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.a((AdTemplate) this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.cE == null) {
            this.cE = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.widget.FeedVideoView.1
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    FeedVideoView.this.Wn.setText(com.kwad.sdk.core.response.a.a.aw(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    FeedVideoView.this.Wn.setText(com.kwad.sdk.core.response.a.a.aH(FeedVideoView.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    FeedVideoView.this.Wn.setText(com.kwad.sdk.core.response.a.a.aw(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    FeedVideoView.this.Wn.setText(com.kwad.sdk.core.response.a.a.T(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.core.download.kwai.a
                public final void onPaused(int i2) {
                    FeedVideoView.this.Wn.setText(com.kwad.sdk.core.response.a.a.bz(i2));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i2) {
                    FeedVideoView.this.Wn.setText(com.kwad.sdk.core.response.a.a.by(i2));
                }
            };
        }
        return this.cE;
    }

    private boolean rv() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = elapsedRealtime - this.WD;
        if (j2 > 888) {
            this.WD = elapsedRealtime;
        }
        return j2 > 888;
    }

    public void rw() {
        a aVar = this.WG;
        if (aVar != null) {
            aVar.oh();
        }
        if ((this.WA == 100) && rv()) {
            this.Ww.setVisibility(0);
            this.Wx.setText(this.mAdInfo.adBaseInfo.adDescription);
            boolean z = com.kwad.sdk.core.response.a.a.K(this.mAdInfo) > com.kwad.sdk.core.response.a.a.J(this.mAdInfo);
            this.WB = ai.cb(getContext());
            getContext();
            this.WC = ai.DL();
            Context context = getContext();
            if (z) {
                ai.ce(context);
            } else {
                ai.cd(context);
            }
            ViewGroup viewGroup = (ViewGroup) this.Wy.getParent();
            this.Wz = viewGroup;
            if (viewGroup != null) {
                viewGroup.removeView(this.Wy);
                View view = new View(this.Wy.getContext());
                this.WH = view;
                view.setLayoutParams(new ViewGroup.LayoutParams(this.Wy.getWidth(), this.Wy.getHeight()));
                viewGroup.addView(this.WH);
            }
            ai.b(getContext(), false);
            Activity dj = k.dj(getContext());
            if (dj != null) {
                ViewGroup viewGroup2 = (ViewGroup) dj.getWindow().getDecorView();
                this.Wy.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                if (z && viewGroup2.getWidth() != 0) {
                    this.Wk.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                }
                viewGroup2.addView(this.Wy, new FrameLayout.LayoutParams(-1, -1));
                setUIWithStateAndMode(101);
            }
        }
    }

    public void rx() {
        if ((this.WA == 101) & rv()) {
            this.Ww.setVisibility(8);
            if (this.WB) {
                ai.cb(getContext());
            } else {
                ai.cc(getContext());
            }
            if (this.WC) {
                ai.ce(getContext());
            } else {
                ai.cd(getContext());
            }
            ai.b(getContext(), true);
            ViewGroup viewGroup = (ViewGroup) this.Wy.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.Wy);
            }
            this.Wy.setLayoutParams(new ViewGroup.LayoutParams(this.Wz.getWidth(), this.Wz.getHeight()));
            this.Wk.setRatio(0.5600000023841858d);
            View view = this.WH;
            if (view != null) {
                this.Wz.removeView(view);
                this.WH = null;
            }
            this.Wz.addView(this.Wy, new FrameLayout.LayoutParams(-1, -2));
            this.Wy.requestLayout();
            setUIWithStateAndMode(100);
        }
        a aVar = this.WG;
        if (aVar != null) {
            aVar.oi();
        }
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, com.kwad.components.core.d.b.c cVar) {
        this.mApkDownloadHelper = cVar;
        this.WI = false;
        com.kwad.sdk.core.response.model.b bi = com.kwad.sdk.core.response.a.a.bi(this.mAdInfo);
        this.WF = ksAdVideoPlayConfig;
        String url = bi.getUrl();
        if (TextUtils.isEmpty(url)) {
            this.eM.setVisibility(8);
        } else {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate);
            this.eM.setVisibility(0);
        }
        this.cI = com.kwad.sdk.core.response.a.a.bd(this.mAdInfo);
        String E = com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
        if (TextUtils.isEmpty(E)) {
            return;
        }
        this.eN = AdVideoPlayerViewCache.getInstance().cO(E);
        if (com.kwad.sdk.core.response.a.a.ah(this.mAdInfo)) {
            this.eA.setVisibility(8);
            View view = this.Wo;
            if (view != null) {
                view.setVisibility(0);
                this.Wn.setText(com.kwad.sdk.core.response.a.a.aw(this.mAdInfo));
                this.Wq.setText(com.kwad.sdk.core.response.a.a.bK(this.mAdInfo));
                KSImageLoader.loadAppIcon(this.Wp, com.kwad.sdk.core.response.a.a.bM(this.mAdInfo), this.mAdTemplate, 4);
                com.kwad.components.core.d.b.c cVar2 = this.mApkDownloadHelper;
                if (cVar2 != null) {
                    cVar2.b(getAppDownloadListener());
                }
                this.Wn.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.4
                    AnonymousClass4() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        if (FeedVideoView.this.cb != null) {
                            FeedVideoView.this.cb.onClick(view2);
                        }
                    }
                });
            }
        } else {
            View view2 = this.Wo;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.eA.setVisibility(0);
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar == null) {
            this.eN = new com.kwad.sdk.core.video.videoview.a(getContext());
            com.kwad.sdk.core.response.a.a.S(this.mAdInfo);
            this.eN.a(new b.a(this.mAdTemplate).a(this.mAdTemplate.mVideoPlayerStatus).bs(com.kwad.sdk.core.response.a.d.cd(this.mAdTemplate)).bt(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.cc(this.mAdTemplate))).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, System.currentTimeMillis())).tR(), null);
            com.kwad.components.core.video.e eVar = new com.kwad.components.core.video.e(this.mContext, this.mAdTemplate, this.eN, ksAdVideoPlayConfig);
            this.Ng = eVar;
            eVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.eN.setController(this.Ng);
            this.Ng.setAutoRelease(false);
            if (com.kwad.sdk.core.config.d.tW() == 2) {
                AdVideoPlayerViewCache.getInstance().a(E, this.eN);
            }
        } else {
            if (aVar.getTag() != null) {
                try {
                    this.cI = (List) this.eN.getTag();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            com.kwad.components.core.video.e eVar2 = (com.kwad.components.core.video.e) this.eN.getController();
            this.Ng = eVar2;
            eVar2.setAutoRelease(false);
            this.Ng.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.eN.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.eN.getParent() != null) {
            ((ViewGroup) this.eN.getParent()).removeView(this.eN);
            this.Ng.qt();
        }
        if (this.Wk.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.Wk;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.Wk.setTag(null);
        }
        this.Wk.addView(this.eN);
        this.Wk.setTag(this.eN);
        this.Wv.setVisibility(8);
        this.Wu.setVisibility(8);
        if (this.mAdInfo.adConversionInfo.h5Type == 1) {
            this.eA.setVisibility(8);
        } else {
            this.eA.setVisibility(0);
            this.eA.setText(this.mAdInfo.adBaseInfo.adDescription);
        }
        a(this.Ng, this.eN);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bindView(@NonNull AdTemplate adTemplate) {
        super.bindView(adTemplate);
    }

    @Override // com.kwad.components.core.widget.b
    protected final void bk() {
        this.MO = new NestedScrollingChildHelper(this);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.Wk = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.eM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.eA = (TextView) findViewById(R.id.ksad_video_text_below);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.ksad_web_video_seek_bar);
        this.Wr = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(100);
        this.Wr.setMinProgress(0);
        this.Wn = (TextView) findViewById(R.id.ksad_video_text_below_action_bar);
        this.Wo = findViewById(R.id.ksad_video_text_below_action_icon_layout);
        this.Wq = (TextView) findViewById(R.id.ksad_video_text_below_action_title);
        this.Wp = (KSCornerImageView) findViewById(R.id.ksad_video_text_below_action_icon);
        this.Wl = (TextView) findViewById(R.id.ksad_video_control_play_total);
        this.Wm = (TextView) findViewById(R.id.ksad_video_control_play_duration);
        this.Ws = (ImageView) findViewById(R.id.ksad_video_control_play_button);
        this.Wu = (ImageView) findViewById(R.id.ksad_video_control_play_status);
        this.Wt = (ImageView) findViewById(R.id.ksad_video_control_fullscreen);
        this.Wv = (ViewGroup) findViewById(R.id.ksad_video_control_container);
        this.Wy = (ViewGroup) findViewById(R.id.ksad_feed_video_container);
        this.Ww = (ViewGroup) findViewById(R.id.ksad_video_control_fullscreen_container);
        this.Wx = (TextView) findViewById(R.id.ksad_video_control_fullscreen_title);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.MO.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.MO.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.MO.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.MO.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    @Override // com.kwad.components.core.widget.b
    protected int getLayoutId() {
        return R.layout.ksad_feed_video;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.MO.hasNestedScrollingParent();
    }

    public final boolean isComplete() {
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null) {
            return aVar.isCompleted();
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.MO.isNestedScrollingEnabled();
    }

    public final void oP() {
        this.Ng.qt();
    }

    public final void oT() {
        this.Ng.qw();
        this.Ng.setVisibility(0);
        this.Ng.setAlpha(1.0f);
        this.Ws.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
        this.Wu.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public void onFirstVisible(View view) {
        super.onFirstVisible(view);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.g.c
    public void onPageInvisible() {
        super.onPageInvisible();
        if (this.eN != null) {
            qb();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.WK);
                getHandler().postDelayed(this.WK, 5000L);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.g.c
    public void onPageVisible() {
        super.onPageVisible();
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar == null || aVar.isPlaying()) {
            return;
        }
        oT();
        if (getHandler() != null) {
            getHandler().removeCallbacks(this.WK);
            getHandler().postDelayed(this.WK, 5000L);
        }
    }

    public final void qb() {
        this.Ng.qv();
        this.Wu.setVisibility(0);
        this.Wu.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
        this.Ws.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
    }

    public final void release() {
        com.kwad.components.core.video.e eVar = this.Ng;
        if (eVar != null) {
            eVar.release();
        }
    }

    public final boolean ry() {
        if (this.WA != 101) {
            return false;
        }
        rx();
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.MO.setNestedScrollingEnabled(z);
    }

    public void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        this.cb = onClickListener;
    }

    protected void setUIWithStateAndMode(int i2) {
        ImageView imageView;
        Resources resources;
        int i3;
        if (i2 == 101) {
            imageView = this.Wt;
            resources = getContext().getResources();
            i3 = R.drawable.ksad_video_player_exit_fullscreen_btn;
        } else {
            imageView = this.Wt;
            resources = getContext().getResources();
            i3 = R.drawable.ksad_video_player_fullscreen_btn;
        }
        imageView.setImageDrawable(resources.getDrawable(i3));
        this.WA = i2;
    }

    public void setWindowFullScreenListener(a aVar) {
        this.WG = aVar;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.MO.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.MO.stopNestedScroll();
    }
}
