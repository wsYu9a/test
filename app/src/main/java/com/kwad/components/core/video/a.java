package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.components.core.video.f;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.widget.KSRelativeLayout;

@SuppressLint({"ViewConstructor"})
@Deprecated
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.video.videoview.b implements View.OnClickListener {
    private ImageView Bw;
    private TextView Bx;
    protected boolean Wd;
    private boolean We;
    protected boolean Wf;
    private int Wg;
    private int Wh;
    private boolean Wi;
    private KSRelativeLayout Wj;
    private RelativeLayout Wk;
    private boolean Wl;
    private boolean Wm;
    private LinearLayout Wn;
    private LinearLayout Wo;
    private ImageView Wp;
    private ViewGroup Wq;
    private TextView Wr;
    private c Ws;
    private InterfaceC0446a Wt;
    protected com.kwad.components.core.video.a.a Wu;
    private final com.kwad.sdk.core.download.a.a Wv;
    protected AdInfo mAdInfo;

    @NonNull
    protected AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    protected Context mContext;
    private ProgressBar oG;
    private boolean oJ;
    protected ImageView ol;
    protected TextView om;

    /* renamed from: com.kwad.components.core.video.a$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.download.a.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            a.this.Wr.setText(com.kwad.sdk.core.response.b.a.aE(a.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            a.this.Wr.setText(com.kwad.sdk.core.response.b.a.cg(a.this.mAdTemplate));
        }

        @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadStarted() {
            a.this.Wr.setText(com.kwad.sdk.core.response.b.a.m36do(0));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            a aVar = a.this;
            aVar.aG(com.kwad.sdk.core.response.b.a.aE(aVar.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            a.this.Wr.setText(com.kwad.sdk.core.response.b.a.ac(a.this.mAdInfo));
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            a.this.Wr.setText(com.kwad.sdk.core.response.b.a.GN());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            a.this.Wr.setText(com.kwad.sdk.core.response.b.a.m36do(i10));
        }
    }

    /* renamed from: com.kwad.components.core.video.a$a */
    public interface InterfaceC0446a {
        void a(int i10, ag.a aVar);
    }

    public interface b extends c {
        void onVideoPlayError(int i10, int i11);
    }

    public interface c {
        void ap();

        void aq();

        void d(long j10);

        void onVideoPlayStart();
    }

    public a(Context context, @NonNull AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, cVar);
        this.We = true;
        this.Wf = false;
        this.Wm = false;
        this.Wv = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.video.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.Wr.setText(com.kwad.sdk.core.response.b.a.aE(a.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.Wr.setText(com.kwad.sdk.core.response.b.a.cg(a.this.mAdTemplate));
            }

            @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                a.this.Wr.setText(com.kwad.sdk.core.response.b.a.m36do(0));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a aVar = a.this;
                aVar.aG(com.kwad.sdk.core.response.b.a.aE(aVar.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.Wr.setText(com.kwad.sdk.core.response.b.a.ac(a.this.mAdInfo));
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i10) {
                a.this.Wr.setText(com.kwad.sdk.core.response.b.a.GN());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i10) {
                a.this.Wr.setText(com.kwad.sdk.core.response.b.a.m36do(i10));
            }
        };
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        init();
    }

    private void aM(int i10) {
        try {
            InterfaceC0446a interfaceC0446a = this.Wt;
            if (interfaceC0446a != null) {
                interfaceC0446a.a(i10, this.Wj.getTouchCoords());
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private void init() {
        m.inflate(this.mContext, R.layout.ksad_feed_video_palyer_controller, this);
        this.Wj = (KSRelativeLayout) findViewById(R.id.ksad_video_root_container);
        this.Wk = (RelativeLayout) findViewById(R.id.ksad_data_flow_container);
        this.om = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.ol = imageView;
        imageView.setOnClickListener(this);
        this.Wn = (LinearLayout) findViewById(R.id.ksad_video_network_unavailable);
        this.Wo = (LinearLayout) findViewById(R.id.ksad_video_error_container);
        this.oG = (ProgressBar) findViewById(R.id.ksad_video_progress);
        this.Wp = (ImageView) findViewById(R.id.ksad_video_thumb_image);
        String url = com.kwad.sdk.core.response.b.a.bt(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            this.Wp.setVisibility(8);
        } else {
            this.Wp.setImageDrawable(null);
            KSImageLoader.loadImage(this.Wp, url, this.mAdTemplate);
            this.Wp.setVisibility(0);
        }
        this.om.setText(br.ak(com.kwad.sdk.core.response.b.a.L(this.mAdInfo) * 1000));
        this.Wu = com.kwad.components.core.video.a.d.aF(this.mAdTemplate);
        sl();
    }

    private void setTopBottomVisible(boolean z10) {
        if (this.Wm) {
            return;
        }
        this.oG.setVisibility(z10 ? 0 : 8);
        this.Wl = z10;
    }

    private void sm() {
        ViewGroup viewGroup = this.Wq;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private void sq() {
        this.Wk.setVisibility(8);
    }

    public final void aG(String str) {
        ((TextView) findViewById(R.id.ksad_app_download)).setText(str);
    }

    public final void aP(boolean z10) {
        if (this.Wm) {
            return;
        }
        if (!z10) {
            this.oG.setVisibility(8);
        } else if (this.Wl) {
            this.oG.setVisibility(0);
        }
    }

    public void ab() {
        if (!this.aFX.isIdle()) {
            if (this.aFX.isPaused() || this.aFX.HY()) {
                sr();
                this.aFX.restart();
                return;
            }
            return;
        }
        com.kwad.components.core.video.a.a aVar = this.Wu;
        if (aVar != null) {
            aVar.onStart();
        }
        if (!al.isNetworkConnected(this.mContext)) {
            sn();
            return;
        }
        so();
        if (this.Wf) {
            sr();
            this.aFX.start();
            return;
        }
        if (this.We && al.isWifiConnected(this.mContext)) {
            sr();
            this.aFX.start();
        } else if (!this.We || (!this.oJ && !this.Wd)) {
            sp();
        } else {
            sr();
            this.aFX.start();
        }
    }

    public void eR() {
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ksad_video_complete_app_container);
            this.Bw = (ImageView) findViewById(R.id.ksad_video_complete_app_icon);
            this.Bx = (TextView) findViewById(R.id.ksad_app_name);
            this.Wr = (TextView) findViewById(R.id.ksad_app_download);
            KSImageLoader.loadAppIcon(this.Bw, com.kwad.sdk.core.response.b.e.eg(this.mAdTemplate), this.mAdTemplate, 12);
            this.Bx.setText(com.kwad.sdk.core.response.b.a.cj(this.mAdInfo));
            this.Wr.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
            this.Wq = linearLayout;
            this.Bw.setOnClickListener(this);
            this.Bx.setOnClickListener(this);
            this.Wr.setOnClickListener(this);
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            this.mApkDownloadHelper = cVar;
            cVar.b(this.Wv);
        } else {
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.ksad_video_complete_h5_container);
            TextView textView = (TextView) findViewById(R.id.ksad_h5_open);
            this.Wr = textView;
            textView.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
            this.Wr.setOnClickListener(this);
            this.Wq = linearLayout2;
        }
        this.Wq.setOnClickListener(this);
        this.Wq.setVisibility(0);
    }

    public AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void n(int i10, int i11) {
        this.Wh = i11;
        this.Wg = i10;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ol) {
            this.Wd = true;
            this.We = true;
            ab();
        } else {
            if (view == this.Bw) {
                aM(1);
                return;
            }
            if (view == this.Bx) {
                aM(2);
            } else if (view == this.Wr) {
                aM(3);
            } else {
                aM(4);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void onPlayStateChanged(int i10) {
        com.kwad.components.core.video.a.a aVar;
        com.kwad.sdk.core.d.c.d("AdVideoPlayerController", "onPlayStateChanged playState=" + i10);
        if (i10 == -1) {
            sA();
            setTopBottomVisible(false);
            this.Wn.setVisibility(8);
            this.Wo.setVisibility(0);
            c cVar = this.Ws;
            if (cVar instanceof f.a) {
                ((f.a) cVar).onVideoPlayError(this.Wg, this.Wh);
            }
            c cVar2 = this.Ws;
            if (cVar2 instanceof b) {
                ((b) cVar2).onVideoPlayError(this.Wg, this.Wh);
            }
            com.kwad.components.core.o.a.ri().d(this.mAdTemplate, this.Wg, this.Wh);
            com.kwad.components.core.video.a.a aVar2 = this.Wu;
            if (aVar2 != null) {
                aVar2.onMediaPlayError(this.Wg, this.Wh);
                return;
            }
            return;
        }
        if (i10 == 9) {
            c cVar3 = this.Ws;
            if (cVar3 != null) {
                cVar3.aq();
            }
            sA();
            this.mAdTemplate.setmCurPlayTime(-1L);
            setTopBottomVisible(false);
            if (!this.Wi) {
                KSImageLoader.loadImage(this.Wp, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
                this.Wp.setVisibility(0);
                eR();
            }
            com.kwad.components.core.video.a.a aVar3 = this.Wu;
            if (aVar3 != null) {
                aVar3.onMediaPlayCompleted();
                return;
            }
            return;
        }
        if (i10 == 1) {
            sq();
            this.Wn.setVisibility(8);
            this.Wo.setVisibility(8);
            this.oG.setVisibility(8);
            sm();
            return;
        }
        if (i10 == 2) {
            c cVar4 = this.Ws;
            if (cVar4 != null) {
                cVar4.onVideoPlayStart();
            }
            com.kwad.components.core.video.a.a aVar4 = this.Wu;
            if (aVar4 != null) {
                aVar4.onMediaPlayStart();
            }
            setTopBottomVisible(true);
            sz();
            return;
        }
        if (i10 == 4) {
            c cVar5 = this.Ws;
            if (cVar5 != null) {
                cVar5.ap();
            }
            this.Wp.setVisibility(8);
            com.kwad.components.core.video.a.a aVar5 = this.Wu;
            if (aVar5 != null) {
                aVar5.ps();
                this.Wu.onMediaPlaying();
                return;
            }
            return;
        }
        if (i10 == 5) {
            com.kwad.components.core.video.a.a aVar6 = this.Wu;
            if (aVar6 != null) {
                aVar6.onMediaPlayPaused();
                return;
            }
            return;
        }
        if (i10 != 6) {
            if (i10 == 7 && (aVar = this.Wu) != null) {
                aVar.onVideoPlayBufferingPaused();
                return;
            }
            return;
        }
        com.kwad.components.core.video.a.a aVar7 = this.Wu;
        if (aVar7 != null) {
            aVar7.onVideoPlayBufferingPlaying();
        }
    }

    public void release() {
        this.aFX.release();
        com.kwad.components.core.video.a.a aVar = this.Wu;
        if (aVar != null) {
            aVar.onRelease();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    @UiThread
    public final void reset() {
        sA();
        this.oG.setProgress(0);
        this.oG.setSecondaryProgress(0);
        sq();
        this.Wn.setVisibility(8);
        this.Wo.setVisibility(8);
        this.oG.setVisibility(8);
        this.Wp.setVisibility(8);
        this.Wk.setVisibility(8);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        sm();
    }

    public void setAdClickListener(InterfaceC0446a interfaceC0446a) {
        this.Wt = interfaceC0446a;
    }

    public void setCanControlPlay(boolean z10) {
        this.Wf = z10;
    }

    public void setDataAutoStart(boolean z10) {
        this.We = z10;
    }

    public void setDataFlowAutoStart(boolean z10) {
        this.oJ = z10;
    }

    public void setHideEnd(boolean z10) {
        this.Wi = z10;
    }

    public void setVideoPlayCallback(c cVar) {
        this.Ws = cVar;
    }

    public void sl() {
    }

    public final void sn() {
        this.Wn.setVisibility(0);
    }

    public final void so() {
        this.Wn.setVisibility(8);
    }

    public final void sp() {
        this.Wk.setVisibility(0);
        this.Wp.setVisibility(0);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    public final void sr() {
        this.aFX.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.bL(this.mAdTemplate));
    }

    public void ss() {
        this.aFX.pause();
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void st() {
        long currentPosition = this.aFX.getCurrentPosition();
        long duration = this.aFX.getDuration();
        this.oG.setSecondaryProgress(this.aFX.getBufferPercentage());
        this.mAdTemplate.setmCurPlayTime(currentPosition);
        this.oG.setProgress((int) ((currentPosition * 100.0f) / duration));
        c cVar = this.Ws;
        if (cVar != null) {
            cVar.d(currentPosition);
        }
    }

    public final void su() {
        this.Wm = true;
        this.oG.setVisibility(8);
    }
}
