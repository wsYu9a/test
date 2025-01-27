package com.sigmob.sdk.videoplayer;

import android.R;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.czhj.sdk.common.utils.IntentUtil;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAds;
import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes4.dex */
public class g extends RelativeLayout implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener, i {

    /* renamed from: a */
    public static final String f20741a = "VideoPlayerView";

    /* renamed from: b */
    public static final int f20742b = -1;

    /* renamed from: c */
    public static final int f20743c = 0;

    /* renamed from: d */
    public static final int f20744d = 1;

    /* renamed from: e */
    public static final int f20745e = 2;

    /* renamed from: f */
    public static final int f20746f = 3;

    /* renamed from: g */
    public static final int f20747g = 4;

    /* renamed from: h */
    public static final int f20748h = 5;

    /* renamed from: i */
    public static final int f20749i = 6;

    /* renamed from: j */
    public static final int f20750j = 7;

    /* renamed from: k */
    public static final int f20751k = 1;

    /* renamed from: l */
    public static final int f20752l = 2;

    /* renamed from: m */
    public static final int f20753m = 3;

    /* renamed from: n */
    public static final int f20754n = 0;

    /* renamed from: o */
    public static final int f20755o = 80;

    /* renamed from: p */
    public static final String f20756p = "android.media.VOLUME_CHANGED_ACTION";

    /* renamed from: q */
    public static final String f20757q = "android.media.EXTRA_VOLUME_STREAM_TYPE";

    /* renamed from: r */
    public static boolean f20758r = true;

    /* renamed from: s */
    public static int f20759s = 6;

    /* renamed from: t */
    public static int f20760t = 1;

    /* renamed from: u */
    public static boolean f20761u = false;

    /* renamed from: v */
    public static boolean f20762v = true;

    /* renamed from: w */
    public static int f20763w;
    public h A;
    public int B;
    public int C;
    public Class D;
    public boolean E;
    public j F;
    public int G;
    public int H;
    public int I;
    public long J;
    public ImageView K;
    public ImageView L;
    public ImageView M;
    public boolean N;
    public long O;
    public Timer P;
    public int Q;
    public int R;
    public AudioManager S;
    public d T;
    public boolean U;
    public m V;
    public ViewGroup W;

    /* renamed from: a0 */
    public ViewGroup f20764a0;

    /* renamed from: b0 */
    public ViewGroup f20765b0;

    /* renamed from: c0 */
    public ViewGroup f20766c0;

    /* renamed from: d0 */
    public ViewGroup f20767d0;

    /* renamed from: e0 */
    public ViewGroup f20768e0;

    /* renamed from: f0 */
    public ViewGroup f20769f0;

    /* renamed from: g0 */
    public ViewGroup f20770g0;

    /* renamed from: h0 */
    public ProgressBar f20771h0;

    /* renamed from: i0 */
    public ImageView f20772i0;

    /* renamed from: j0 */
    public AudioManager.OnAudioFocusChangeListener f20773j0;

    /* renamed from: k0 */
    public com.sigmob.sdk.nativead.i f20774k0;

    /* renamed from: l0 */
    public boolean f20775l0;

    /* renamed from: m0 */
    public com.sigmob.sdk.videoplayer.c f20776m0;

    /* renamed from: n0 */
    public ImageView f20777n0;

    /* renamed from: o0 */
    public int f20778o0;

    /* renamed from: p0 */
    public int f20779p0;

    /* renamed from: q0 */
    public f f20780q0;

    /* renamed from: r0 */
    public boolean f20781r0;

    /* renamed from: s0 */
    public View f20782s0;

    /* renamed from: t0 */
    public boolean f20783t0;

    /* renamed from: u0 */
    public View f20784u0;

    /* renamed from: x */
    public g f20785x;

    /* renamed from: y */
    public int f20786y;

    /* renamed from: z */
    public int f20787z;

    public class a implements AudioManager.OnAudioFocusChangeListener {
        public a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i10) {
            StringBuilder sb2;
            String str;
            if (i10 == -2) {
                sb2 = new StringBuilder();
                str = "AUDIOFOCUS_LOSS_TRANSIENT [";
            } else {
                if (i10 != -1) {
                    return;
                }
                g.this.v();
                sb2 = new StringBuilder();
                str = "AUDIOFOCUS_LOSS [";
            }
            sb2.append(str);
            sb2.append(hashCode());
            sb2.append("]");
            SigmobLog.i(sb2.toString());
        }
    }

    public class b implements e {
        public b() {
        }

        @Override // com.sigmob.sdk.videoplayer.g.e
        public void a(int i10) {
            ImageView imageView;
            Context context;
            String str;
            if (i10 == 0 || g.this.f20775l0) {
                g gVar = g.this;
                imageView = gVar.M;
                context = gVar.getContext();
                str = "sig_image_video_mute";
            } else {
                g gVar2 = g.this;
                imageView = gVar2.M;
                context = gVar2.getContext();
                str = "sig_image_video_unmute";
            }
            imageView.setImageResource(ResourceUtil.getDrawableId(context, str));
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a */
        public static final /* synthetic */ int[] f20790a;

        static {
            int[] iArr = new int[com.sigmob.sdk.videoplayer.f.values().length];
            f20790a = iArr;
            try {
                iArr[com.sigmob.sdk.videoplayer.f.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20790a[com.sigmob.sdk.videoplayer.f.RETRY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20790a[com.sigmob.sdk.videoplayer.f.VOLUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20790a[com.sigmob.sdk.videoplayer.f.FULLSCREEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20790a[com.sigmob.sdk.videoplayer.f.BIGRETRY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20790a[com.sigmob.sdk.videoplayer.f.BACK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public class d extends TimerTask {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                long currentPositionWhenPlaying = g.this.getCurrentPositionWhenPlaying();
                long duration = g.this.getDuration();
                g.this.a((int) ((100 * currentPositionWhenPlaying) / (duration == 0 ? 1L : duration)), currentPositionWhenPlaying, duration);
            }
        }

        public d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int i10 = g.this.f20786y;
            if (i10 == 4 || i10 == 5) {
                WindAds.sharedAds().getHandler().post(new a());
            }
        }
    }

    public interface e {
        void a(int i10);
    }

    public class f extends BroadcastReceiver {

        /* renamed from: a */
        public e f20793a;

        public f(e eVar) {
            this.f20793a = eVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int streamVolume;
            if (!g.f20756p.equals(intent.getAction()) || intent.getIntExtra(g.f20757q, -1) != 3 || this.f20793a == null || (streamVolume = ((AudioManager) g.this.getApplicationContext().getSystemService("audio")).getStreamVolume(3)) < 0) {
                return;
            }
            this.f20793a.a(streamVolume);
        }
    }

    public g(Context context) {
        super(context.getApplicationContext());
        this.f20786y = -1;
        this.f20787z = -1;
        this.B = 0;
        this.C = 0;
        this.E = true;
        this.G = -1;
        this.H = 0;
        this.I = -1;
        this.J = 0L;
        this.N = false;
        this.O = 0L;
        this.f20773j0 = new a();
        this.f20775l0 = true;
        this.f20781r0 = false;
        a(context.getApplicationContext());
    }

    public void A() {
        this.f20787z = 2;
    }

    public void B() {
    }

    public void C() {
        this.N = true;
        E();
    }

    public void D() {
        e();
        this.P = new Timer();
        d dVar = new d();
        this.T = dVar;
        this.P.schedule(dVar, 0L, 300L);
    }

    public void E() {
        SigmobLog.d("startVideo [" + hashCode() + "] ");
        setCurrentVideoAdView(this);
        try {
            o();
            a(this.f20766c0, 4);
            a(this.f20768e0, 4);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        Window b10 = com.sigmob.sdk.videoplayer.d.b(getContext());
        if (b10 != null) {
            b10.setFlags(16777216, 16777216);
            b10.addFlags(128);
        }
        d();
        u();
    }

    public void F() {
        if (this.f20786y == 3) {
            this.F.j();
        } else {
            this.N = false;
            E();
        }
    }

    public void a(float f10, int i10) {
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void b() {
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void c() {
        SigmobLog.d("onPrepared  [" + hashCode() + "] ");
        this.f20786y = 3;
        setSoundChange(this.f20775l0);
        com.sigmob.sdk.nativead.i iVar = this.f20774k0;
        if (iVar != null) {
            iVar.onVideoLoad();
        }
        if (!this.N) {
            com.sigmob.sdk.nativead.i iVar2 = this.f20774k0;
            if (iVar2 != null) {
                iVar2.onVideoStart();
            }
            SigmobLog.d("mediaInterface start");
            t();
            this.F.j();
            this.N = false;
        } else if (this.f20781r0) {
            this.f20772i0.setImageBitmap(this.V.getBitmap());
        }
        if (this.A.c().toString().toLowerCase().contains("mp3") || this.A.c().toString().toLowerCase().contains("wma") || this.A.c().toString().toLowerCase().contains("aac") || this.A.c().toString().toLowerCase().contains("m4a") || this.A.c().toString().toLowerCase().contains("wav")) {
            t();
        }
    }

    public void d() {
        m mVar = this.V;
        if (mVar != null) {
            this.W.removeView(mVar);
        }
        m mVar2 = new m(getContext().getApplicationContext());
        this.V = mVar2;
        mVar2.setSurfaceTextureListener(this.F);
        this.W.addView(this.V, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void e() {
        Timer timer = this.P;
        if (timer != null) {
            timer.cancel();
            this.P = null;
        }
        d dVar = this.T;
        if (dVar != null) {
            dVar.cancel();
            this.T = null;
        }
    }

    public void f() {
        Window b10 = com.sigmob.sdk.videoplayer.d.b(getContext());
        if (b10 != null) {
            ((ViewGroup) b10.findViewById(R.id.content)).removeView(this);
        }
    }

    public void g() {
        v();
        e();
        if (this.f20780q0 != null) {
            getContext().unregisterReceiver(this.f20780q0);
            this.f20780q0 = null;
        }
    }

    public ViewGroup getAppContainer() {
        return this.f20770g0;
    }

    public Context getApplicationContext() {
        Context applicationContext;
        Context context = getContext();
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public ImageView getBlurImageView() {
        return this.f20777n0;
    }

    public View getBottomLayoutView() {
        return this.f20784u0;
    }

    public long getCurrentPositionWhenPlaying() {
        int i10 = this.f20786y;
        if (i10 != 4 && i10 != 5) {
            return 0L;
        }
        try {
            return this.F.a();
        } catch (IllegalStateException e10) {
            e10.printStackTrace();
            return 0L;
        }
    }

    public long getDuration() {
        try {
            j jVar = this.F;
            if (jVar != null) {
                return jVar.b();
            }
            return 0L;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0L;
        }
    }

    public int getLayoutId() {
        return ResourceUtil.getLayoutId(getContext(), "sig_video_player_layout");
    }

    public ViewGroup getSigAdView() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        while (!(viewGroup instanceof com.sigmob.sdk.nativead.j) && (viewGroup = (ViewGroup) getParent()) != null) {
        }
        return viewGroup;
    }

    public Bitmap getTextureBitmap() {
        m mVar = this.V;
        if (mVar != null) {
            return mVar.getBitmap();
        }
        return null;
    }

    public ImageView getThumbView() {
        return this.f20772i0;
    }

    public View getTopLayoutView() {
        return this.f20782s0;
    }

    public int getVideoHeight() {
        return this.f20778o0;
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public h getVideoPlayerDataSource() {
        return this.A;
    }

    public int getVideoSurferViewHeight() {
        m mVar = this.V;
        if (mVar != null) {
            return mVar.getHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        return this.f20779p0;
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }

    public void k() {
        g gVar = this.f20785x;
        if (gVar != null) {
            int i10 = gVar.f20786y;
            if (i10 == 6 || i10 == 0 || i10 == 1 || i10 == 7) {
                v();
            } else if (i10 != 5) {
                gVar.s();
                this.f20785x.F.f();
            }
        }
    }

    public void l() {
        int i10;
        g gVar = this.f20785x;
        if (gVar == null || (i10 = gVar.f20786y) == 0) {
            E();
            return;
        }
        if (i10 == 5) {
            com.sigmob.sdk.nativead.i iVar = this.f20774k0;
            if (iVar != null) {
                iVar.onVideoResume();
            }
            this.f20785x.t();
            this.f20785x.F.j();
            return;
        }
        if (i10 == 3) {
            com.sigmob.sdk.nativead.i iVar2 = this.f20774k0;
            if (iVar2 != null) {
                iVar2.onVideoStart();
            }
            this.f20785x.F.j();
            this.f20785x.t();
        }
    }

    public void m() {
        com.sigmob.sdk.videoplayer.c cVar = this.f20776m0;
        if (cVar != null) {
            cVar.a();
        }
        y();
        this.L.setImageResource(ResourceUtil.getDrawableId(getContext(), "sig_image_video_small"));
    }

    public void n() {
        this.O = System.currentTimeMillis();
        com.sigmob.sdk.videoplayer.c cVar = this.f20776m0;
        if (cVar != null) {
            cVar.b();
        }
        z();
        this.L.setImageResource(ResourceUtil.getDrawableId(getContext(), "sig_image_video_fullscreen"));
    }

    public final void o() {
        try {
            j jVar = this.F;
            if (jVar != null) {
                jVar.i();
            }
            Class cls = this.D;
            this.F = cls == null ? new k(this) : (j) cls.getConstructor(g.class).newInstance(this);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        onTouch(view, null);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12 = this.f20787z;
        if (i12 == 1 || i12 == 2) {
            super.onMeasure(i10, i11);
            return;
        }
        if (this.B == 0 || this.C == 0) {
            super.onMeasure(i10, i11);
            return;
        }
        int size = View.MeasureSpec.getSize(i10);
        int i13 = (int) ((size * this.C) / this.B);
        setMeasuredDimension(size, i13);
        getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(i13, 1073741824));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        if (z10) {
            getDuration();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        e();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        SigmobLog.d("bottomProgress onStopTrackingTouch [" + hashCode() + "] ");
        D();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int i10 = this.f20786y;
        if (i10 == 4 || i10 == 5) {
            long progress = (seekBar.getProgress() * getDuration()) / 100;
            this.I = seekBar.getProgress();
            this.F.a(progress);
            SigmobLog.d("seekTo " + progress + " [" + hashCode() + "] ");
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() != 1) {
            return false;
        }
        if (view == this.f20765b0) {
            int i10 = this.f20787z;
            if (i10 == 0) {
                m();
                return false;
            }
            if (i10 != 1) {
                return false;
            }
            n();
            return false;
        }
        if (view == this.f20767d0) {
            setSoundChange(!this.f20775l0);
            return false;
        }
        if (view == this.f20766c0 || view == this.f20768e0) {
            com.sigmob.sdk.nativead.i iVar = this.f20774k0;
            if (iVar != null) {
                iVar.c();
            }
            E();
            return false;
        }
        if (view != this.f20764a0) {
            return false;
        }
        int i11 = this.f20786y;
        if (i11 != 0) {
            if (i11 == 4) {
                SigmobLog.d("pauseVideo [" + hashCode() + "] ");
                this.F.f();
                s();
            } else if (i11 == 5) {
                com.sigmob.sdk.nativead.i iVar2 = this.f20774k0;
                if (iVar2 != null) {
                    iVar2.onVideoResume();
                }
                this.F.j();
                t();
            } else if (i11 != 6) {
                if (i11 == 3) {
                    this.F.j();
                    t();
                    com.sigmob.sdk.nativead.i iVar3 = this.f20774k0;
                    if (iVar3 != null) {
                        iVar3.onVideoStart();
                    }
                }
            }
            return true;
        }
        if (!f20762v && !this.A.c().toString().startsWith(com.sigmob.sdk.base.k.f18193y) && !this.A.c().toString().startsWith("/") && !com.sigmob.sdk.videoplayer.d.f(getContext())) {
            B();
            return true;
        }
        E();
        return true;
    }

    public void p() {
        SigmobLog.i("onStateAutoComplete  [" + hashCode() + "] ");
        this.f20786y = 6;
        e();
        ProgressBar progressBar = this.f20771h0;
        if (progressBar != null) {
            progressBar.setProgress(100);
        }
    }

    public void q() {
        SigmobLog.d("onStateError  [" + hashCode() + "] ");
        this.f20786y = 7;
        e();
        a(this.f20787z == 1 ? this.f20764a0 : this.f20766c0, 0);
    }

    public void r() {
        SigmobLog.d("onStateNormal stat" + this.f20786y + " [" + hashCode() + "] ");
        this.f20786y = 0;
        a(this.f20772i0, 0);
        a(this.f20764a0, 0);
        e();
        j jVar = this.F;
        if (jVar != null) {
            jVar.i();
        }
    }

    public void s() {
        SigmobLog.i("onStatePause  [" + hashCode() + "] ");
        this.f20786y = 5;
        a(this.f20764a0, 0);
        com.sigmob.sdk.nativead.i iVar = this.f20774k0;
        if (iVar != null) {
            iVar.onVideoPause();
        }
        e();
    }

    public void setBackClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.f20769f0;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(onClickListener);
        }
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void setBufferProgress(int i10) {
    }

    public void setCurrentVideoAdView(g gVar) {
        this.f20785x = gVar;
    }

    public void setHolderImageResource(int i10) {
    }

    public void setMediaInterface(Class cls) {
        w();
        this.D = cls;
    }

    @Override // android.view.View
    public void setRotation(float f10) {
        this.V.setRotation(f10);
    }

    public void setScreen(int i10) {
        if (i10 == 0) {
            z();
        } else if (i10 == 1) {
            y();
        } else {
            if (i10 != 2) {
                return;
            }
            A();
        }
    }

    public void setSoundChange(boolean z10) {
        ImageView imageView;
        Context context;
        String str;
        this.f20775l0 = z10;
        if (z10) {
            j jVar = this.F;
            if (jVar != null) {
                jVar.b(0.0f);
            }
            imageView = this.M;
            context = getContext();
            str = "sig_image_video_mute";
        } else {
            j jVar2 = this.F;
            if (jVar2 != null) {
                jVar2.b(1.0f);
            }
            imageView = this.M;
            context = getContext();
            str = "sig_image_video_unmute";
        }
        imageView.setImageResource(ResourceUtil.getDrawableId(context, str));
    }

    public void setState(int i10) {
        a(i10, 0, 0);
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        m mVar = this.V;
        if (mVar != null) {
            mVar.setSurfaceTexture(surfaceTexture);
        }
    }

    public void setTextureViewRotation(int i10) {
        m mVar;
        g gVar = this.f20785x;
        if (gVar == null || (mVar = gVar.V) == null) {
            return;
        }
        mVar.setRotation(i10);
    }

    public void setUp(String str) {
        a(new h(str, (String) null), 0);
    }

    public void setVideoAdStatusListener(com.sigmob.sdk.nativead.i iVar) {
        this.f20774k0 = iVar;
    }

    public void setVideoAdViewListener(com.sigmob.sdk.videoplayer.c cVar) {
        this.f20776m0 = cVar;
    }

    public void setVideoImageDisplayType(int i10) {
        m mVar;
        f20763w = i10;
        g gVar = this.f20785x;
        if (gVar == null || (mVar = gVar.V) == null) {
            return;
        }
        mVar.requestLayout();
    }

    public void t() {
        SigmobLog.d("onStatePlaying  [" + hashCode() + "] ");
        a(this.f20772i0, 4);
        a(this.f20764a0, 4);
        if (this.f20786y == 3) {
            long j10 = this.J;
            if (j10 != 0) {
                this.F.a(j10);
                this.J = 0L;
            }
        }
        this.f20786y = 4;
        D();
    }

    public void u() {
        SigmobLog.d("onStatePreparing  [" + hashCode() + "] ");
        this.f20786y = 1;
        x();
    }

    public void v() {
        SigmobLog.i("releaseAllVideos");
        g gVar = this.f20785x;
        if (gVar != null) {
            gVar.w();
            this.f20785x = null;
        }
    }

    public void w() {
        SigmobLog.d("reset  [" + hashCode() + "] ");
        e();
        x();
        h();
        i();
        j();
        r();
        this.W.removeAllViews();
        Window b10 = com.sigmob.sdk.videoplayer.d.b(getContext());
        if (b10 != null) {
            b10.clearFlags(128);
        }
        j jVar = this.F;
        if (jVar != null) {
            jVar.i();
        }
    }

    public void x() {
        ProgressBar progressBar = this.f20771h0;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
    }

    public void y() {
        this.f20787z = 1;
    }

    public void z() {
        this.f20787z = 0;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20786y = -1;
        this.f20787z = -1;
        this.B = 0;
        this.C = 0;
        this.E = true;
        this.G = -1;
        this.H = 0;
        this.I = -1;
        this.J = 0L;
        this.N = false;
        this.O = 0L;
        this.f20773j0 = new a();
        this.f20775l0 = true;
        this.f20781r0 = false;
        a(context);
    }

    public void a(float f10, String str, long j10, String str2, long j11) {
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void b(int i10, int i11) {
        String str;
        SigmobLog.d("onInfo what - " + i10 + " extra - " + i11);
        if (i10 == 3) {
            int i12 = this.f20786y;
            if (i12 == 3 || i12 == 2) {
                t();
                return;
            }
            return;
        }
        if (i10 == 701) {
            if (this.f20786y == 4) {
                this.f20783t0 = true;
                this.F.f();
                s();
            }
            str = "MEDIA_INFO_BUFFERING_START";
        } else {
            if (i10 != 702) {
                return;
            }
            if (this.f20783t0) {
                this.f20783t0 = false;
                this.F.j();
                t();
            }
            str = "MEDIA_INFO_BUFFERING_END";
        }
        SigmobLog.d(str);
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void c(int i10, int i11) {
        this.f20778o0 = i11;
        this.f20779p0 = i10;
        m mVar = this.V;
        if (mVar != null) {
            int i12 = this.H;
            if (i12 != 0) {
                mVar.setRotation(i12);
            }
            this.V.a(i10, i11);
        }
    }

    public void a(int i10) {
    }

    public void b(boolean z10) {
        ViewGroup viewGroup;
        int i10;
        if (z10) {
            viewGroup = this.f20765b0;
            i10 = 0;
        } else {
            viewGroup = this.f20765b0;
            i10 = 4;
        }
        a(viewGroup, i10);
    }

    public void a(float f10) {
        int i10;
        if (this.f20785x != null) {
            int i11 = this.f20786y;
            if ((i11 != 4 && i11 != 5) || (i10 = this.f20787z) == 1 || i10 == 2) {
                return;
            }
            m();
        }
    }

    public void a(int i10, long j10) {
        this.f20786y = 2;
        this.J = j10;
        this.A.f20796a = i10;
        this.F.a((Surface) null);
        this.F.i();
        this.F.g();
    }

    public void a(h hVar, long j10) {
        this.f20786y = 2;
        this.J = j10;
        this.A = hVar;
        this.F.a((Surface) null);
        this.F.i();
        this.F.g();
    }

    public void a(String str, String str2, long j10) {
        a(new h(str, str2), j10);
    }

    public void a(ViewGroup viewGroup) {
        try {
            g gVar = (g) getClass().getConstructor(Context.class).newInstance(getContext());
            gVar.setId(getId());
            viewGroup.addView(gVar);
            gVar.a(this.A.a(), 0, this.D);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
            e10.printStackTrace();
        }
    }

    public void a(boolean z10) {
        this.f20781r0 = z10;
    }

    public void a(Context context) {
        View.inflate(context, getLayoutId(), this);
        this.f20767d0 = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_sound_rl"));
        this.f20764a0 = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_start_rl"));
        this.f20765b0 = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_fullscreen_rl"));
        this.f20766c0 = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_replay_rl"));
        this.M = (ImageView) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_sound_btn"));
        this.K = (ImageView) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_start_btn"));
        this.L = (ImageView) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_fullscreen_btn"));
        this.W = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_surface_container"));
        this.f20770g0 = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_app_container"));
        this.f20771h0 = (ProgressBar) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_bottom_progress"));
        this.f20768e0 = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_big_replay"));
        this.f20772i0 = (ImageView) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_thumb"));
        this.f20777n0 = (ImageView) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_blurImageView"));
        this.f20769f0 = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_back_rl"));
        this.f20782s0 = findViewById(ResourceUtil.getId(getContext(), "sig_native_video_layout_top"));
        this.f20784u0 = findViewById(ResourceUtil.getId(getContext(), "sig_native_video_layout_bottom"));
        this.f20766c0.setOnClickListener(this);
        this.f20767d0.setOnClickListener(this);
        this.f20764a0.setOnClickListener(this);
        this.f20765b0.setOnClickListener(this);
        this.f20768e0.setOnClickListener(this);
        this.Q = getContext().getResources().getDisplayMetrics().widthPixels;
        this.R = getContext().getResources().getDisplayMetrics().heightPixels;
        this.f20780q0 = new f(new b());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(f20756p);
        IntentUtil.registerReceiver(context, this.f20780q0, intentFilter);
        this.f20786y = -1;
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void a() {
        Runtime.getRuntime().gc();
        com.sigmob.sdk.nativead.i iVar = this.f20774k0;
        if (iVar != null) {
            iVar.onVideoCompleted();
        }
        SigmobLog.d("onAutoCompletion  [" + hashCode() + "] ");
        e();
        h();
        i();
        j();
        p();
        Window b10 = com.sigmob.sdk.videoplayer.d.b(getContext());
        if (b10 != null) {
            b10.clearFlags(128);
        }
        x();
        this.f20785x = null;
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void a(int i10, int i11) {
        SigmobLog.e("onError " + i10 + " - " + i11 + " [" + hashCode() + "] ");
        com.sigmob.sdk.nativead.i iVar = this.f20774k0;
        if (iVar != null) {
            iVar.onVideoError(WindAdError.ERROR_SIGMOB_PLAY_VIDEO);
        }
        if (i10 == 38 || i11 == -38 || i10 == -38 || i11 == 38 || i11 == -19) {
            return;
        }
        q();
        this.F.i();
    }

    public void a(int i10, long j10, long j11) {
        ProgressBar progressBar;
        if (!this.U) {
            int i11 = this.I;
            if (i11 != -1) {
                if (i11 > i10) {
                    return;
                } else {
                    this.I = -1;
                }
            } else if (i10 != 0 && (progressBar = this.f20771h0) != null) {
                progressBar.setProgress(i10);
            }
        }
        com.sigmob.sdk.nativead.i iVar = this.f20774k0;
        if (iVar != null) {
            iVar.a(j10, j11);
        }
    }

    public final void a(View view, int i10) {
        if (view != null) {
            view.setVisibility(i10);
        }
    }

    public void a(int i10, int i11, int i12) {
        if (i10 == 0) {
            r();
            return;
        }
        if (i10 == 1) {
            u();
            return;
        }
        if (i10 == 2) {
            a(i11, i12);
            return;
        }
        if (i10 == 4) {
            t();
            return;
        }
        if (i10 == 5) {
            s();
        } else if (i10 == 6) {
            p();
        } else {
            if (i10 != 7) {
                return;
            }
            q();
        }
    }

    public void a(h hVar, int i10) {
        a(hVar, i10, (Class) null);
    }

    public void a(h hVar, int i10, Class cls) {
        if (System.currentTimeMillis() - this.O < 200) {
            return;
        }
        this.A = hVar;
        this.f20787z = i10;
        r();
        this.D = cls;
    }

    public void a(String str, String str2) {
        a(new h(str, str2), 0);
    }

    public void a(String str, String str2, int i10) {
        a(new h(str, str2), i10);
    }

    public void a(String str, String str2, int i10, Class cls) {
        a(new h(str, str2), i10, cls);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r3 != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0018, code lost:
    
        if (r3 != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:
    
        if (r3 != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0022, code lost:
    
        if (r3 != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0027, code lost:
    
        if (r3 != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r3 != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002b, code lost:
    
        r3 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002c, code lost:
    
        a(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        r3 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.sigmob.sdk.videoplayer.f r2, boolean r3) {
        /*
            r1 = this;
            int[] r0 = com.sigmob.sdk.videoplayer.g.c.f20790a
            int r2 = r2.ordinal()
            r2 = r0[r2]
            switch(r2) {
                case 1: goto L25;
                case 2: goto L20;
                case 3: goto L1b;
                case 4: goto L16;
                case 5: goto L11;
                case 6: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L2f
        Lc:
            android.view.ViewGroup r2 = r1.f20769f0
            if (r3 == 0) goto L2b
            goto L29
        L11:
            android.view.ViewGroup r2 = r1.f20768e0
            if (r3 == 0) goto L2b
            goto L29
        L16:
            android.view.ViewGroup r2 = r1.f20765b0
            if (r3 == 0) goto L2b
            goto L29
        L1b:
            android.view.ViewGroup r2 = r1.f20767d0
            if (r3 == 0) goto L2b
            goto L29
        L20:
            android.view.ViewGroup r2 = r1.f20766c0
            if (r3 == 0) goto L2b
            goto L29
        L25:
            android.view.ViewGroup r2 = r1.f20764a0
            if (r3 == 0) goto L2b
        L29:
            r3 = 0
            goto L2c
        L2b:
            r3 = 4
        L2c:
            r1.a(r2, r3)
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoplayer.g.a(com.sigmob.sdk.videoplayer.f, boolean):void");
    }
}
