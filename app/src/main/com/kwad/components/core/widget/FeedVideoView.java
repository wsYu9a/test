package com.kwad.components.core.widget;

import android.app.Activity;
import android.content.Context;
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
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.s.o;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.n.m;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class FeedVideoView extends b<AdResultData, AdTemplate> implements NestedScrollingChild {
    private NestedScrollingChildHelper RZ;
    private com.kwad.components.core.video.e Sr;
    private RatioFrameLayout aeG;
    private TextView aeH;
    private TextView aeI;
    private TextView aeJ;
    private View aeK;
    private KSCornerImageView aeL;
    private TextView aeM;
    private ScaleAnimSeekBar aeN;
    private ImageView aeO;
    private ImageView aeP;
    private ImageView aeQ;
    private ViewGroup aeR;
    private ViewGroup aeS;
    private TextView aeT;
    private ViewGroup aeU;
    private ViewGroup aeV;
    private int aeW;
    private boolean aeX;
    private boolean aeY;
    private long aeZ;
    private boolean afa;
    private KsAdVideoPlayConfig afb;
    private a afc;
    private View afd;
    private boolean afe;
    private Runnable aff;
    private o afg;

    /* renamed from: ci */
    private List<Integer> f11960ci;
    private com.kwad.sdk.core.video.videoview.a co;
    private KsAppDownloadListener dL;
    private View.OnClickListener dl;
    private TextView fX;

    /* renamed from: gh */
    private ImageView f11961gh;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.download.a.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            FeedVideoView.this.aeJ.setText(com.kwad.sdk.core.response.b.a.aE(FeedVideoView.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            FeedVideoView.this.aeJ.setText(com.kwad.sdk.core.response.b.a.cg(FeedVideoView.this.mAdTemplate));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            FeedVideoView.this.aeJ.setText(com.kwad.sdk.core.response.b.a.aE(FeedVideoView.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            FeedVideoView.this.aeJ.setText(com.kwad.sdk.core.response.b.a.ac(FeedVideoView.this.mAdInfo));
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            FeedVideoView.this.aeJ.setText(com.kwad.sdk.core.response.b.a.dp(i10));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            FeedVideoView.this.aeJ.setText(com.kwad.sdk.core.response.b.a.m36do(i10));
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$10 */
    public class AnonymousClass10 implements View.OnClickListener {
        final /* synthetic */ com.kwad.sdk.core.video.videoview.a afi;

        public AnonymousClass10(com.kwad.sdk.core.video.videoview.a aVar) {
            aVar2 = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (aVar2.isPaused() || aVar2.isIdle()) {
                FeedVideoView.this.Sr.sN();
                FeedVideoView.this.aeO.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                FeedVideoView.this.aeQ.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
            } else if (aVar2.isPlaying()) {
                FeedVideoView.this.Sr.sM();
                FeedVideoView.this.aeQ.setVisibility(0);
                FeedVideoView.this.aeQ.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
                FeedVideoView.this.aeO.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
            }
            if (FeedVideoView.this.getHandler() != null) {
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.afg);
                FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.afg, 5000L);
            }
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$11 */
    public class AnonymousClass11 implements View.OnClickListener {
        public AnonymousClass11() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (FeedVideoView.this.co.isPaused() || FeedVideoView.this.co.isIdle()) {
                FeedVideoView.this.qR();
            } else if (FeedVideoView.this.co.isPlaying()) {
                FeedVideoView.this.ss();
            }
            if (FeedVideoView.this.getHandler() != null) {
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.afg);
                FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.afg, 5000L);
            }
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FeedVideoView.this.ux();
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$3 */
    public class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (FeedVideoView.this.aeW == 100) {
                FeedVideoView.this.uw();
            } else if (FeedVideoView.this.aeW == 101) {
                FeedVideoView.this.ux();
            }
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$4 */
    public class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (FeedVideoView.this.dl != null) {
                FeedVideoView.this.dl.onClick(view);
            }
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$5 */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            FeedVideoView.this.aeR.setVisibility(8);
            FeedVideoView.this.aeQ.setVisibility(8);
            if (FeedVideoView.this.Sr != null) {
                FeedVideoView.this.Sr.aP(true);
            }
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$6 */
    public class AnonymousClass6 implements View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (FeedVideoView.this.aeR.getVisibility() != 8) {
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aff);
                    if (FeedVideoView.this.afa) {
                        return;
                    }
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.afg, 1000L);
                    return;
                }
                return;
            }
            if (!FeedVideoView.this.co.isCompleted()) {
                FeedVideoView.this.aeR.setVisibility(0);
                FeedVideoView.this.aeQ.setVisibility(0);
                if (FeedVideoView.this.Sr != null) {
                    FeedVideoView.this.Sr.aP(false);
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aff);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.afg, 5000L);
                    return;
                }
                return;
            }
            if (FeedVideoView.this.aeW != 101) {
                if (FeedVideoView.this.dl != null) {
                    FeedVideoView.this.dl.onClick(view);
                    return;
                }
                return;
            }
            FeedVideoView.this.aeR.setVisibility(0);
            FeedVideoView.this.aeQ.setVisibility(8);
            if (FeedVideoView.this.Sr != null) {
                FeedVideoView.this.Sr.aP(false);
            }
            if (FeedVideoView.this.getHandler() != null) {
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aff);
                FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.afg, 5000L);
            }
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$7 */
    public class AnonymousClass7 implements a.c {
        final /* synthetic */ com.kwad.sdk.core.video.videoview.a afi;
        private boolean dP = false;

        public AnonymousClass7(com.kwad.sdk.core.video.videoview.a aVar) {
            aVar2 = aVar;
        }

        @Override // com.kwad.components.core.video.a.c
        public final void ap() {
            if (!FeedVideoView.this.afe) {
                FeedVideoView.a(FeedVideoView.this, true);
                if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                    FeedVideoView.this.co.setVideoSoundEnable(!com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo));
                }
                if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                    FeedVideoView.this.co.setLooping(com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo));
                }
            }
            if (this.dP) {
                return;
            }
            this.dP = true;
            com.kwad.components.core.o.a.ri().b(FeedVideoView.this.mAdTemplate, System.currentTimeMillis(), 1);
        }

        @Override // com.kwad.components.core.video.a.c
        public final void aq() {
            com.kwad.sdk.core.adlog.c.bT(FeedVideoView.this.mAdTemplate);
            FeedVideoView.this.aeR.setVisibility(8);
            FeedVideoView.this.aeQ.setVisibility(8);
            FeedVideoView.this.aeN.setProgress(100);
            FeedVideoView.this.aeI.setText(br.ak(aVar2.getDuration()));
        }

        @Override // com.kwad.components.core.video.a.c
        public final void d(long j10) {
            FeedVideoView.this.c(j10);
            float duration = (j10 * 100.0f) / aVar2.getDuration();
            if (!FeedVideoView.this.afa) {
                FeedVideoView.this.aeN.setProgress((int) duration);
                FeedVideoView.this.aeI.setText(br.ak(j10));
            }
            FeedVideoView.this.aeH.setText(br.ak(aVar2.getDuration()));
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlayStart() {
            if (!FeedVideoView.this.afe) {
                FeedVideoView.a(FeedVideoView.this, true);
                if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                    FeedVideoView.this.co.setVideoSoundEnable(true ^ com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo));
                }
                if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                    FeedVideoView.this.co.setLooping(com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo));
                }
            }
            com.kwad.sdk.core.adlog.c.bS(FeedVideoView.this.mAdTemplate);
            FeedVideoView.this.aeH.setText(br.ak(aVar2.getDuration()));
        }
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$8 */
    public class AnonymousClass8 implements a.InterfaceC0446a {

        /* renamed from: com.kwad.components.core.widget.FeedVideoView$8$1 */
        public class AnonymousClass1 implements a.b {
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                FeedVideoView.this.ur();
            }
        }

        public AnonymousClass8() {
        }

        @Override // com.kwad.components.core.video.a.InterfaceC0446a
        public final void a(int i10, ag.a aVar) {
            int i11 = 171;
            int i12 = 2;
            boolean z10 = false;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        i11 = com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0 ? 50 : 83;
                        i12 = 1;
                        z10 = true;
                    } else if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                        i11 = 108;
                    }
                } else if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                    i11 = 82;
                }
            } else if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                i11 = 13;
            }
            com.kwad.components.core.e.d.a.a(new a.C0427a(FeedVideoView.this.getContext()).au(FeedVideoView.this.mAdTemplate).au(true).b(FeedVideoView.this.mApkDownloadHelper).ao(i12).ap(z10).ar(true).an(i11).d(aVar).a(new a.b() { // from class: com.kwad.components.core.widget.FeedVideoView.8.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    FeedVideoView.this.ur();
                }
            }));
        }
    }

    public interface a {
        void qf();

        void qg();
    }

    public FeedVideoView(@NonNull Context context) {
        super(context);
        this.aeW = 100;
        AnonymousClass5 anonymousClass5 = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            public AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.aeR.setVisibility(8);
                FeedVideoView.this.aeQ.setVisibility(8);
                if (FeedVideoView.this.Sr != null) {
                    FeedVideoView.this.Sr.aP(true);
                }
            }
        };
        this.aff = anonymousClass5;
        this.afg = new o(anonymousClass5);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.dL == null) {
            this.dL = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.widget.FeedVideoView.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    FeedVideoView.this.aeJ.setText(com.kwad.sdk.core.response.b.a.aE(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    FeedVideoView.this.aeJ.setText(com.kwad.sdk.core.response.b.a.cg(FeedVideoView.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    FeedVideoView.this.aeJ.setText(com.kwad.sdk.core.response.b.a.aE(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    FeedVideoView.this.aeJ.setText(com.kwad.sdk.core.response.b.a.ac(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i10) {
                    FeedVideoView.this.aeJ.setText(com.kwad.sdk.core.response.b.a.dp(i10));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i10) {
                    FeedVideoView.this.aeJ.setText(com.kwad.sdk.core.response.b.a.m36do(i10));
                }
            };
        }
        return this.dL;
    }

    private boolean uv() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = elapsedRealtime - this.aeZ;
        if (j10 > 888) {
            this.aeZ = elapsedRealtime;
        }
        return j10 > 888;
    }

    public void uw() {
        a aVar = this.afc;
        if (aVar != null) {
            aVar.qf();
        }
        if ((this.aeW == 100) && uv()) {
            this.aeS.setVisibility(0);
            this.aeT.setText(this.mAdInfo.adBaseInfo.adDescription);
            boolean z10 = com.kwad.sdk.core.response.b.a.R(this.mAdInfo) > com.kwad.sdk.core.response.b.a.Q(this.mAdInfo);
            this.aeX = an.cD(getContext());
            getContext();
            this.aeY = an.NS();
            if (z10) {
                an.cG(getContext());
            } else {
                an.cF(getContext());
            }
            ViewGroup viewGroup = (ViewGroup) this.aeU.getParent();
            this.aeV = viewGroup;
            if (viewGroup != null) {
                viewGroup.removeView(this.aeU);
                View view = new View(this.aeU.getContext());
                this.afd = view;
                view.setLayoutParams(new ViewGroup.LayoutParams(this.aeU.getWidth(), this.aeU.getHeight()));
                viewGroup.addView(this.afd);
            }
            an.b(getContext(), false);
            Activity dH = m.dH(getContext());
            if (dH != null) {
                ViewGroup viewGroup2 = (ViewGroup) dH.getWindow().getDecorView();
                this.aeU.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                if (z10 && viewGroup2.getWidth() != 0) {
                    this.aeG.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                }
                viewGroup2.addView(this.aeU, new FrameLayout.LayoutParams(-1, -1));
                setUIWithStateAndMode(101);
            }
        }
    }

    public void ux() {
        if ((this.aeW == 101) & uv()) {
            this.aeS.setVisibility(8);
            if (this.aeX) {
                an.cD(getContext());
            } else {
                an.cE(getContext());
            }
            if (this.aeY) {
                an.cG(getContext());
            } else {
                an.cF(getContext());
            }
            an.b(getContext(), true);
            ViewGroup viewGroup = (ViewGroup) this.aeU.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.aeU);
            }
            this.aeU.setLayoutParams(new ViewGroup.LayoutParams(this.aeV.getWidth(), this.aeV.getHeight()));
            this.aeG.setRatio(0.5600000023841858d);
            View view = this.afd;
            if (view != null) {
                this.aeV.removeView(view);
                this.afd = null;
            }
            this.aeV.addView(this.aeU, new FrameLayout.LayoutParams(-1, -2));
            this.aeU.requestLayout();
            setUIWithStateAndMode(100);
        }
        a aVar = this.afc;
        if (aVar != null) {
            aVar.qg();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void C(View view) {
        super.C(view);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bE() {
        this.RZ = new NestedScrollingChildHelper(this);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.aeG = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.f11961gh = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.fX = (TextView) findViewById(R.id.ksad_video_text_below);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.ksad_web_video_seek_bar);
        this.aeN = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(100);
        this.aeN.setMinProgress(0);
        this.aeJ = (TextView) findViewById(R.id.ksad_video_text_below_action_bar);
        this.aeK = findViewById(R.id.ksad_video_text_below_action_icon_layout);
        this.aeM = (TextView) findViewById(R.id.ksad_video_text_below_action_title);
        this.aeL = (KSCornerImageView) findViewById(R.id.ksad_video_text_below_action_icon);
        this.aeH = (TextView) findViewById(R.id.ksad_video_control_play_total);
        this.aeI = (TextView) findViewById(R.id.ksad_video_control_play_duration);
        this.aeO = (ImageView) findViewById(R.id.ksad_video_control_play_button);
        this.aeQ = (ImageView) findViewById(R.id.ksad_video_control_play_status);
        this.aeP = (ImageView) findViewById(R.id.ksad_video_control_fullscreen);
        this.aeR = (ViewGroup) findViewById(R.id.ksad_video_control_container);
        this.aeU = (ViewGroup) findViewById(R.id.ksad_feed_video_container);
        this.aeS = (ViewGroup) findViewById(R.id.ksad_video_control_fullscreen_container);
        this.aeT = (TextView) findViewById(R.id.ksad_video_control_fullscreen_title);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void bl() {
        super.bl();
        com.kwad.sdk.core.video.videoview.a aVar = this.co;
        if (aVar == null || aVar.isPlaying()) {
            return;
        }
        qR();
        if (getHandler() != null) {
            getHandler().removeCallbacks(this.afg);
            getHandler().postDelayed(this.afg, 5000L);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void bm() {
        super.bm();
        if (this.co != null) {
            ss();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.afg);
                getHandler().postDelayed(this.afg, 5000L);
            }
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.RZ.dispatchNestedFling(f10, f11, z10);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.RZ.dispatchNestedPreFling(f10, f11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return this.RZ.dispatchNestedPreScroll(i10, i11, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.RZ.dispatchNestedScroll(i10, i11, i12, i13, iArr);
    }

    @Override // com.kwad.components.core.widget.b
    public int getLayoutId() {
        return R.layout.ksad_feed_video;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.RZ.hasNestedScrollingParent();
    }

    public final boolean isComplete() {
        com.kwad.sdk.core.video.videoview.a aVar = this.co;
        if (aVar != null) {
            return aVar.isCompleted();
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.RZ.isNestedScrollingEnabled();
    }

    public final void qN() {
        this.Sr.sL();
    }

    public final void qR() {
        this.Sr.sN();
        this.Sr.setVisibility(0);
        this.Sr.setAlpha(1.0f);
        this.aeO.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
        this.aeQ.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
    }

    public final void release() {
        com.kwad.components.core.video.e eVar = this.Sr;
        if (eVar != null) {
            eVar.release();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z10) {
        this.RZ.setNestedScrollingEnabled(z10);
    }

    public void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        this.dl = onClickListener;
    }

    public void setUIWithStateAndMode(int i10) {
        if (i10 == 101) {
            this.aeP.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_exit_fullscreen_btn));
        } else {
            this.aeP.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_fullscreen_btn));
        }
        this.aeW = i10;
    }

    public void setWindowFullScreenListener(a aVar) {
        this.afc = aVar;
    }

    public final void ss() {
        this.Sr.sM();
        this.aeQ.setVisibility(0);
        this.aeQ.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
        this.aeO.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i10) {
        return this.RZ.startNestedScroll(i10);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.RZ.stopNestedScroll();
    }

    public final boolean uy() {
        if (this.aeW != 101) {
            return false;
        }
        ux();
        return true;
    }

    @Override // com.kwad.components.core.widget.b
    public final void c(@NonNull AdResultData adResultData) {
        super.c((FeedVideoView) adResultData);
    }

    public static /* synthetic */ boolean a(FeedVideoView feedVideoView, boolean z10) {
        feedVideoView.afe = true;
        return true;
    }

    public void c(long j10) {
        int ceil = (int) Math.ceil(j10 / 1000.0f);
        List<Integer> list = this.f11960ci;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f11960ci.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a((AdTemplate) this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
        this.afe = false;
        com.kwad.sdk.core.response.model.b bt = com.kwad.sdk.core.response.b.a.bt(this.mAdInfo);
        this.afb = ksAdVideoPlayConfig;
        String url = bt.getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.f11961gh.setImageDrawable(null);
            KSImageLoader.loadImage(this.f11961gh, url, this.mAdTemplate);
            this.f11961gh.setVisibility(0);
        } else {
            this.f11961gh.setVisibility(8);
        }
        this.f11960ci = com.kwad.sdk.core.response.b.a.bo(this.mAdInfo);
        String K = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
        if (TextUtils.isEmpty(K)) {
            return;
        }
        this.co = AdVideoPlayerViewCache.getInstance().eI(K);
        if (com.kwad.sdk.core.response.b.a.aq(this.mAdInfo)) {
            this.fX.setVisibility(8);
            View view = this.aeK;
            if (view != null) {
                view.setVisibility(0);
                this.aeJ.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
                this.aeM.setText(com.kwad.sdk.core.response.b.a.cj(this.mAdInfo));
                KSImageLoader.loadAppIcon(this.aeL, com.kwad.sdk.core.response.b.a.cm(this.mAdInfo), this.mAdTemplate, 4);
                com.kwad.components.core.e.d.c cVar2 = this.mApkDownloadHelper;
                if (cVar2 != null) {
                    cVar2.b(getAppDownloadListener());
                }
                this.aeJ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.4
                    public AnonymousClass4() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        if (FeedVideoView.this.dl != null) {
                            FeedVideoView.this.dl.onClick(view2);
                        }
                    }
                });
            }
        } else {
            View view2 = this.aeK;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.fX.setVisibility(0);
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.co;
        if (aVar == null) {
            this.co = new com.kwad.sdk.core.video.videoview.a(getContext());
            com.kwad.sdk.core.response.b.a.ab(this.mAdInfo);
            this.co.a(new b.a(this.mAdTemplate).a(this.mAdTemplate.mVideoPlayerStatus).dc(com.kwad.sdk.core.response.b.e.ed(this.mAdTemplate)).dd(com.kwad.sdk.core.response.b.h.b(com.kwad.sdk.core.response.b.e.ec(this.mAdTemplate))).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).Cz(), null);
            com.kwad.components.core.video.e eVar = new com.kwad.components.core.video.e(this.mContext, this.mAdTemplate, this.co, ksAdVideoPlayConfig);
            this.Sr = eVar;
            eVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.co.setController(this.Sr);
            this.Sr.setAutoRelease(false);
            if (com.kwad.sdk.core.config.d.CT() == 2) {
                AdVideoPlayerViewCache.getInstance().a(K, this.co);
            }
        } else {
            if (aVar.getTag() != null) {
                try {
                    this.f11960ci = (List) this.co.getTag();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            com.kwad.components.core.video.e eVar2 = (com.kwad.components.core.video.e) this.co.getController();
            this.Sr = eVar2;
            eVar2.setAutoRelease(false);
            this.Sr.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.co.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.co.getParent() != null) {
            ((ViewGroup) this.co.getParent()).removeView(this.co);
            this.Sr.sL();
        }
        if (this.aeG.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.aeG;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.aeG.setTag(null);
        }
        this.aeG.addView(this.co);
        this.aeG.setTag(this.co);
        this.aeR.setVisibility(8);
        this.aeQ.setVisibility(8);
        if (this.mAdInfo.adConversionInfo.h5Type == 1) {
            this.fX.setVisibility(8);
        } else {
            this.fX.setVisibility(0);
            this.fX.setText(this.mAdInfo.adBaseInfo.adDescription);
        }
        a(this.Sr, this.co);
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeW = 100;
        AnonymousClass5 anonymousClass5 = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            public AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.aeR.setVisibility(8);
                FeedVideoView.this.aeQ.setVisibility(8);
                if (FeedVideoView.this.Sr != null) {
                    FeedVideoView.this.Sr.aP(true);
                }
            }
        };
        this.aff = anonymousClass5;
        this.afg = new o(anonymousClass5);
    }

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$9 */
    public class AnonymousClass9 implements ScaleAnimSeekBar.a {
        final /* synthetic */ com.kwad.sdk.core.video.videoview.a afi;

        public AnonymousClass9(com.kwad.sdk.core.video.videoview.a aVar) {
            aVar2 = aVar;
        }

        @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
        public final void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z10) {
            if (z10) {
                FeedVideoView.this.aeN.br(true);
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.afg);
                FeedVideoView.this.afa = true;
                FeedVideoView.this.aeI.setText(br.ak((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
            }
        }

        @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
        public final void uz() {
            FeedVideoView.this.aeN.br(true);
            FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.afg);
            FeedVideoView.this.afa = true;
        }

        @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
        public final void a(ScaleAnimSeekBar scaleAnimSeekBar) {
            FeedVideoView.this.aeN.br(false);
            aVar2.seekTo((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
            if (FeedVideoView.this.getHandler() != null) {
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.afg);
                FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.afg, 5000L);
            }
            FeedVideoView.this.afa = false;
        }
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.aeW = 100;
        AnonymousClass5 anonymousClass5 = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            public AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.aeR.setVisibility(8);
                FeedVideoView.this.aeQ.setVisibility(8);
                if (FeedVideoView.this.Sr != null) {
                    FeedVideoView.this.Sr.aP(true);
                }
            }
        };
        this.aff = anonymousClass5;
        this.afg = new o(anonymousClass5);
    }

    private void a(com.kwad.components.core.video.a aVar, com.kwad.sdk.core.video.videoview.a aVar2) {
        this.aeU.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.6
            public AnonymousClass6() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.aeR.getVisibility() != 8) {
                    if (FeedVideoView.this.getHandler() != null) {
                        FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aff);
                        if (FeedVideoView.this.afa) {
                            return;
                        }
                        FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.afg, 1000L);
                        return;
                    }
                    return;
                }
                if (!FeedVideoView.this.co.isCompleted()) {
                    FeedVideoView.this.aeR.setVisibility(0);
                    FeedVideoView.this.aeQ.setVisibility(0);
                    if (FeedVideoView.this.Sr != null) {
                        FeedVideoView.this.Sr.aP(false);
                    }
                    if (FeedVideoView.this.getHandler() != null) {
                        FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aff);
                        FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.afg, 5000L);
                        return;
                    }
                    return;
                }
                if (FeedVideoView.this.aeW != 101) {
                    if (FeedVideoView.this.dl != null) {
                        FeedVideoView.this.dl.onClick(view);
                        return;
                    }
                    return;
                }
                FeedVideoView.this.aeR.setVisibility(0);
                FeedVideoView.this.aeQ.setVisibility(8);
                if (FeedVideoView.this.Sr != null) {
                    FeedVideoView.this.Sr.aP(false);
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aff);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.afg, 5000L);
                }
            }
        });
        aVar.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            final /* synthetic */ com.kwad.sdk.core.video.videoview.a afi;
            private boolean dP = false;

            public AnonymousClass7(com.kwad.sdk.core.video.videoview.a aVar22) {
                aVar2 = aVar22;
            }

            @Override // com.kwad.components.core.video.a.c
            public final void ap() {
                if (!FeedVideoView.this.afe) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.co.setVideoSoundEnable(!com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.co.setLooping(com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo));
                    }
                }
                if (this.dP) {
                    return;
                }
                this.dP = true;
                com.kwad.components.core.o.a.ri().b(FeedVideoView.this.mAdTemplate, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
                com.kwad.sdk.core.adlog.c.bT(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.aeR.setVisibility(8);
                FeedVideoView.this.aeQ.setVisibility(8);
                FeedVideoView.this.aeN.setProgress(100);
                FeedVideoView.this.aeI.setText(br.ak(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j10) {
                FeedVideoView.this.c(j10);
                float duration = (j10 * 100.0f) / aVar2.getDuration();
                if (!FeedVideoView.this.afa) {
                    FeedVideoView.this.aeN.setProgress((int) duration);
                    FeedVideoView.this.aeI.setText(br.ak(j10));
                }
                FeedVideoView.this.aeH.setText(br.ak(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                if (!FeedVideoView.this.afe) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.co.setVideoSoundEnable(true ^ com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.co.setLooping(com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo));
                    }
                }
                com.kwad.sdk.core.adlog.c.bS(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.aeH.setText(br.ak(aVar2.getDuration()));
            }
        });
        this.Sr.setAdClickListener(new a.InterfaceC0446a() { // from class: com.kwad.components.core.widget.FeedVideoView.8

            /* renamed from: com.kwad.components.core.widget.FeedVideoView$8$1 */
            public class AnonymousClass1 implements a.b {
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    FeedVideoView.this.ur();
                }
            }

            public AnonymousClass8() {
            }

            @Override // com.kwad.components.core.video.a.InterfaceC0446a
            public final void a(int i10, ag.a aVar3) {
                int i11 = 171;
                int i12 = 2;
                boolean z10 = false;
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 == 3) {
                            i11 = com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0 ? 50 : 83;
                            i12 = 1;
                            z10 = true;
                        } else if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                            i11 = 108;
                        }
                    } else if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                        i11 = 82;
                    }
                } else if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                    i11 = 13;
                }
                com.kwad.components.core.e.d.a.a(new a.C0427a(FeedVideoView.this.getContext()).au(FeedVideoView.this.mAdTemplate).au(true).b(FeedVideoView.this.mApkDownloadHelper).ao(i12).ap(z10).ar(true).an(i11).d(aVar3).a(new a.b() { // from class: com.kwad.components.core.widget.FeedVideoView.8.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        FeedVideoView.this.ur();
                    }
                }));
            }
        });
        this.aeN.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a() { // from class: com.kwad.components.core.widget.FeedVideoView.9
            final /* synthetic */ com.kwad.sdk.core.video.videoview.a afi;

            public AnonymousClass9(com.kwad.sdk.core.video.videoview.a aVar22) {
                aVar2 = aVar22;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z10) {
                if (z10) {
                    FeedVideoView.this.aeN.br(true);
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.afg);
                    FeedVideoView.this.afa = true;
                    FeedVideoView.this.aeI.setText(br.ak((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void uz() {
                FeedVideoView.this.aeN.br(true);
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.afg);
                FeedVideoView.this.afa = true;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                FeedVideoView.this.aeN.br(false);
                aVar2.seekTo((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.afg);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.afg, 5000L);
                }
                FeedVideoView.this.afa = false;
            }
        });
        this.aeO.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.10
            final /* synthetic */ com.kwad.sdk.core.video.videoview.a afi;

            public AnonymousClass10(com.kwad.sdk.core.video.videoview.a aVar22) {
                aVar2 = aVar22;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (aVar2.isPaused() || aVar2.isIdle()) {
                    FeedVideoView.this.Sr.sN();
                    FeedVideoView.this.aeO.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                    FeedVideoView.this.aeQ.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
                } else if (aVar2.isPlaying()) {
                    FeedVideoView.this.Sr.sM();
                    FeedVideoView.this.aeQ.setVisibility(0);
                    FeedVideoView.this.aeQ.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
                    FeedVideoView.this.aeO.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.afg);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.afg, 5000L);
                }
            }
        });
        this.aeQ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.11
            public AnonymousClass11() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.co.isPaused() || FeedVideoView.this.co.isIdle()) {
                    FeedVideoView.this.qR();
                } else if (FeedVideoView.this.co.isPlaying()) {
                    FeedVideoView.this.ss();
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.afg);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.afg, 5000L);
                }
            }
        });
        this.aeS.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.2
            public AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVideoView.this.ux();
            }
        });
        this.aeP.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.3
            public AnonymousClass3() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.aeW == 100) {
                    FeedVideoView.this.uw();
                } else if (FeedVideoView.this.aeW == 101) {
                    FeedVideoView.this.ux();
                }
            }
        });
    }
}
