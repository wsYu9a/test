package com.vivo.mobilead.unified.base.view.s;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.tencent.connect.share.QzonePublish;
import com.vivo.ad.model.a0;
import com.vivo.ad.view.p;
import com.vivo.advv.TextUtils;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.event.IEventProcessor;
import com.vivo.advv.vaf.virtualview.view.image.NativeImage;
import com.vivo.advv.vaf.virtualview.view.text.NativeText;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.unified.base.view.s.a;
import com.vivo.mobilead.util.c0;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.q;
import com.vivo.mobilead.util.r;
import com.vivo.mobilead.util.y0;

/* loaded from: classes4.dex */
public class b extends com.vivo.mobilead.unified.base.view.s.a implements IEventProcessor {
    private com.vivo.mobilead.model.b H;
    private com.vivo.ad.model.b I;
    private AdParams J;
    private boolean K;
    protected int L;
    private com.vivo.mobilead.unified.base.g.b.a M;
    private com.vivo.mobilead.unified.base.g.b.c N;
    private com.vivo.mobilead.unified.base.g.b.e O;
    private com.vivo.mobilead.unified.base.g.b.e P;
    private com.vivo.mobilead.unified.base.g.b.e Q;
    private ViewBase R;
    private NativeText S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private com.vivo.ad.model.b a0;
    private String b0;
    private String c0;
    private float d0;
    private float e0;
    private View.OnClickListener f0;
    private Handler g0;
    private Handler h0;
    private MediaListener i0;
    private ViewTreeObserver.OnGlobalLayoutListener j0;
    private com.vivo.mobilead.d.a k0;
    private p.h l0;
    private DialogInterface.OnShowListener m0;
    private DialogInterface.OnDismissListener n0;

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (b.this.M != null) {
                    if (b.this.M.a() != 0) {
                        b.this.d0 = r5.M.a();
                    }
                    if (b.this.M.b() != 0) {
                        b.this.e0 = r5.M.b();
                    }
                }
                if (b.this.N != null && b.this.d0 != 0.0f && b.this.e0 != 0.0f) {
                    b.this.N.a(b.this.d0 / b.this.e0);
                }
                if (!b.this.U && b.this.d0 >= 100.0f) {
                    b.this.U = true;
                    k0.c(b.this.a0, b.this.b0, b.this.c0, c.a.f28912a + "");
                }
            } catch (Exception unused) {
            }
            b.this.g0.sendEmptyMessageDelayed(0, 1000L);
            return false;
        }
    }

    /* renamed from: com.vivo.mobilead.unified.base.view.s.b$b */
    class C0628b implements MediaListener {
        C0628b() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.MediaListener
        public void onVideoCached() {
            MediaListener mediaListener = b.this.n;
            if (mediaListener != null) {
                mediaListener.onVideoCached();
            }
        }

        @Override // com.vivo.mobilead.unified.base.callback.MediaListener
        public void onVideoCompletion() {
            MediaListener mediaListener = b.this.n;
            if (mediaListener != null) {
                mediaListener.onVideoCompletion();
            }
        }

        @Override // com.vivo.mobilead.unified.base.callback.MediaListener
        public void onVideoError(VivoAdError vivoAdError) {
            MediaListener mediaListener = b.this.n;
            if (mediaListener != null) {
                mediaListener.onVideoError(vivoAdError);
            }
        }

        @Override // com.vivo.mobilead.unified.base.callback.MediaListener
        public void onVideoPause() {
            MediaListener mediaListener = b.this.n;
            if (mediaListener != null) {
                mediaListener.onVideoPause();
            }
        }

        @Override // com.vivo.mobilead.unified.base.callback.MediaListener
        public void onVideoPlay() {
            MediaListener mediaListener = b.this.n;
            if (mediaListener != null) {
                mediaListener.onVideoPlay();
            }
        }

        @Override // com.vivo.mobilead.unified.base.callback.MediaListener
        public void onVideoStart() {
            b.this.K = true;
            MediaListener mediaListener = b.this.n;
            if (mediaListener != null) {
                mediaListener.onVideoStart();
            }
        }
    }

    class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (b.this.M != null && b.this.n() && !b.this.W) {
                b.this.M.i();
            }
            if (Build.VERSION.SDK_INT >= 16) {
                b.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                b.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    class d implements com.vivo.mobilead.d.a {

        class a extends com.vivo.mobilead.util.f1.b {
            a() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                if (b.this.W) {
                    return;
                }
                if (b.this.O != null) {
                    b.this.O.setVisibility(2);
                }
                if (b.this.P != null) {
                    b.this.P.setVisibility(1);
                }
                if (b.this.Q != null) {
                    b.this.Q.setVisibility(1);
                }
            }
        }

        /* renamed from: com.vivo.mobilead.unified.base.view.s.b$d$b */
        class C0629b extends com.vivo.mobilead.util.f1.b {
            C0629b() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                if (b.this.W) {
                    return;
                }
                if (b.this.O != null) {
                    b.this.O.setVisibility(2);
                }
                if (b.this.P != null) {
                    b.this.P.setVisibility(1);
                }
                if (b.this.Q != null) {
                    b.this.Q.setVisibility(1);
                }
            }
        }

        d() {
        }

        @Override // com.vivo.mobilead.d.a
        public void a() {
        }

        @Override // com.vivo.mobilead.d.a
        public void a(int i2) {
        }

        @Override // com.vivo.mobilead.d.a
        public void a(int i2, int i3, String str) {
            b.this.h0.removeCallbacksAndMessages(null);
            k0.b(b.this.a0, (int) b.this.d0, (int) b.this.e0, 1, b.this.b0, b.this.c0);
            k0.a(b.this.a0, i2, b.this.b0, b.this.c0);
            b.this.q();
            b.this.r();
            if (b.this.i0 != null) {
                b.this.i0.onVideoError(new VivoAdError(i2, str));
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void a(long j2, long j3) {
        }

        @Override // com.vivo.mobilead.d.a
        public void b() {
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoCompletion() {
            b.this.h0.removeCallbacksAndMessages(null);
            k0.b(b.this.a0, (int) b.this.e0, (int) b.this.e0, 1, b.this.b0, b.this.c0);
            b.this.q();
            b.this.r();
            if (b.this.i0 != null) {
                b.this.i0.onVideoCompletion();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoPause() {
            b.this.h0.removeCallbacksAndMessages(null);
            if (b.this.O != null) {
                b.this.O.c();
                b.this.O.setVisibility(1);
            }
            if (b.this.P != null) {
                b.this.P.setVisibility(2);
            }
            if (b.this.Q != null) {
                b.this.Q.setVisibility(2);
            }
            if (b.this.i0 != null) {
                b.this.i0.onVideoPause();
            }
            if (b.this.N != null) {
                b.this.N.setVisibility(1);
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoResume() {
            b.this.h0.removeCallbacksAndMessages(null);
            if (b.this.O != null) {
                b.this.O.d();
                b.this.O.setVisibility(1);
            }
            b.this.h0.postDelayed(new C0629b(), 1000L);
            if (b.this.N != null) {
                b.this.N.setVisibility(1);
            }
            b.this.g0.removeCallbacksAndMessages(null);
            b.this.g0.sendEmptyMessageDelayed(0, 1000L);
            if (b.this.i0 != null) {
                b.this.i0.onVideoPlay();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoStart() {
            b.this.h0.removeCallbacksAndMessages(null);
            if (b.this.O != null) {
                b.this.O.d();
                b.this.O.setVisibility(1);
            }
            b.this.h0.postDelayed(new a(), 1000L);
            b.this.l();
            if (b.this.S != null) {
                b.this.S.setVisibility(2);
            }
            if (b.this.N != null) {
                b.this.N.setVisibility(1);
            }
            b.this.g0.removeCallbacksAndMessages(null);
            b.this.g0.sendEmptyMessageDelayed(0, 1000L);
            if (b.this.i0 != null) {
                if (!b.this.V) {
                    b.this.V = true;
                    b.this.i0.onVideoStart();
                }
                b.this.i0.onVideoPlay();
            }
        }
    }

    class e implements p.h {
        e() {
        }

        @Override // com.vivo.ad.view.p.h
        public void dismiss() {
            b.this.n0.onDismiss(null);
        }

        @Override // com.vivo.ad.view.p.h
        public void onShow() {
            b.this.m0.onShow(null);
        }
    }

    class f implements DialogInterface.OnShowListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            b.this.setIsFeedbackShow(true);
            b.this.j();
        }
    }

    class g implements DialogInterface.OnDismissListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.setIsFeedbackShow(false);
            b.this.j();
        }
    }

    public b(com.vivo.mobilead.model.b bVar, @NonNull Context context, com.vivo.ad.model.b bVar2, AdParams adParams) {
        super(bVar, context, bVar2, adParams, true);
        this.K = false;
        this.L = 0;
        this.T = true;
        this.U = false;
        this.V = false;
        this.W = false;
        this.g0 = new Handler(Looper.getMainLooper(), new a());
        this.h0 = new Handler(Looper.getMainLooper());
        this.i0 = new C0628b();
        this.j0 = new c();
        this.k0 = new d();
        this.l0 = new e();
        this.m0 = new f();
        this.n0 = new g();
        this.H = bVar;
        this.I = bVar2;
        this.J = adParams;
    }

    private String getReportAdType() {
        return "4";
    }

    @Override // com.vivo.mobilead.unified.base.callback.c
    public void a(String str, Bitmap bitmap) {
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    protected int getMaterialContainerHeight() {
        return 0;
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    protected int getMaterialContainerWidth() {
        return 0;
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    protected int[] getMinSize() {
        int[] iArr = {org.mozilla.universalchardet.prober.g.n, 100};
        com.vivo.ad.model.b bVar = this.I;
        if (bVar == null) {
            return iArr;
        }
        switch (bVar.F()) {
            case 1:
                return new int[]{org.mozilla.universalchardet.prober.g.n, 173};
            case 2:
                return new int[]{org.mozilla.universalchardet.prober.g.n, 125};
            case 3:
                return new int[]{org.mozilla.universalchardet.prober.g.n, 100};
            case 4:
                return new int[]{org.mozilla.universalchardet.prober.g.n, 100};
            case 5:
                return new int[]{org.mozilla.universalchardet.prober.g.n, 210};
            case 6:
                return new int[]{org.mozilla.universalchardet.prober.g.n, 210};
            case 7:
                return new int[]{TTAdConstant.IMAGE_MODE_SPLASH, 292};
            default:
                return iArr;
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.j0);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01f4  */
    @Override // com.vivo.advv.vaf.virtualview.event.IEventProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean process(com.vivo.advv.vaf.virtualview.event.EventData r34) {
        /*
            Method dump skipped, instructions count: 739
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.unified.base.view.s.b.process(com.vivo.advv.vaf.virtualview.event.EventData):boolean");
    }

    public boolean n() {
        int i2 = this.L;
        return i2 != 2 && (i2 != 0 || c0.a(getContext()) == 100) && y0.a(this, 70);
    }

    private void o() {
        com.vivo.mobilead.unified.base.g.b.a aVar = this.M;
        if (aVar != null) {
            aVar.d();
        }
    }

    private void p() {
        q();
        com.vivo.mobilead.unified.base.g.b.a aVar = this.M;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void q() {
        this.d0 = 0.0f;
        this.V = false;
        this.U = false;
        this.h0.removeCallbacksAndMessages(null);
        this.g0.removeCallbacksAndMessages(null);
        com.vivo.mobilead.unified.base.g.b.c cVar = this.N;
        if (cVar != null) {
            cVar.a(0.0f);
        }
        com.vivo.mobilead.unified.base.g.b.e eVar = this.O;
        if (eVar != null) {
            eVar.setVisibility(2);
        }
        com.vivo.mobilead.unified.base.g.b.e eVar2 = this.P;
        if (eVar2 != null) {
            eVar2.setVisibility(2);
        }
        com.vivo.mobilead.unified.base.g.b.e eVar3 = this.Q;
        if (eVar3 != null) {
            eVar3.setVisibility(2);
        }
        m();
        NativeText nativeText = this.S;
        if (nativeText != null) {
            nativeText.setVisibility(2);
        }
    }

    public void r() {
        this.W = true;
        ViewBase viewBase = this.R;
        if (viewBase != null) {
            viewBase.setVisibility(1);
        }
        com.vivo.mobilead.unified.base.g.b.c cVar = this.N;
        if (cVar != null) {
            cVar.setVisibility(0);
        }
    }

    private void s() {
        com.vivo.mobilead.unified.base.g.b.a aVar;
        if (this.W || (aVar = this.M) == null) {
            return;
        }
        aVar.e();
        this.M.g();
        this.M.a(this.T);
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    public void e() {
        super.e();
        p();
        com.vivo.mobilead.model.b bVar = this.H;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    public void h() {
        o();
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    public void i() {
        s();
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    public void j() {
        if (this.M == null || !this.K) {
            return;
        }
        if (g()) {
            s();
        } else {
            o();
        }
    }

    public void k() {
        this.W = false;
        ViewBase viewBase = this.R;
        if (viewBase != null) {
            viewBase.setVisibility(2);
        }
    }

    public void l() {
        com.vivo.mobilead.unified.base.g.b.a aVar = this.M;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void m() {
        com.vivo.mobilead.unified.base.g.b.a aVar = this.M;
        if (aVar != null) {
            aVar.h();
        }
        com.vivo.mobilead.unified.base.g.b.c cVar = this.N;
        if (cVar != null) {
            cVar.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vivo.mobilead.unified.base.view.s.a
    protected void c(com.vivo.ad.model.b bVar, AdParams adParams) {
        VafContext c2;
        ViewBase virtualView;
        a0 Q;
        this.a0 = bVar;
        if (adParams != null) {
            this.b0 = adParams.getSourceAppend();
        }
        this.L = adParams == null ? 0 : adParams.getVideoPolicy();
        this.c0 = "4";
        View b2 = this.H.b();
        if ((b2 instanceof IContainer) && (virtualView = ((IContainer) b2).getVirtualView()) != null) {
            ViewBase findViewBaseByName = virtualView.findViewBaseByName("mediaArea");
            if (findViewBaseByName instanceof com.vivo.mobilead.unified.base.g.b.a) {
                this.M = (com.vivo.mobilead.unified.base.g.b.a) findViewBaseByName;
                a0 Q2 = bVar.Q();
                if (Q2 != null) {
                    this.M.b(Q2.h());
                    this.M.a(Q2.c());
                }
                this.M.a(bVar.C());
                this.M.b(bVar.G());
                this.M.a(this.T);
                this.M.a(this.k0);
            }
            boolean z = com.vivo.mobilead.util.d.e(bVar) == 4;
            ViewBase findViewBaseByName2 = virtualView.findViewBaseByName("videoPlay");
            String str = "vivo_module_video_start.png";
            if (findViewBaseByName2 instanceof com.vivo.mobilead.unified.base.g.b.e) {
                com.vivo.mobilead.unified.base.g.b.e eVar = (com.vivo.mobilead.unified.base.g.b.e) findViewBaseByName2;
                this.O = eVar;
                if (z) {
                    String a2 = eVar.a();
                    String b3 = this.O.b();
                    if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(b3)) {
                        a2 = "vivo_module_video_pause.png";
                        b3 = "vivo_module_video_start.png";
                    }
                    Bitmap a3 = com.vivo.mobilead.util.g.a(this.f30039i, a2);
                    Bitmap a4 = com.vivo.mobilead.util.g.a(this.f30039i, b3);
                    if (a3 != null && a4 != null) {
                        this.O.a(new Bitmap[]{a3, a4});
                    }
                    this.O.c();
                    findViewBaseByName2.setVisibility(1);
                } else {
                    findViewBaseByName2.setVisibility(2);
                }
            }
            ViewBase findViewBaseByName3 = virtualView.findViewBaseByName("videoPlay2");
            if (findViewBaseByName3 instanceof com.vivo.mobilead.unified.base.g.b.e) {
                com.vivo.mobilead.unified.base.g.b.e eVar2 = (com.vivo.mobilead.unified.base.g.b.e) findViewBaseByName3;
                this.P = eVar2;
                if (z) {
                    String a5 = eVar2.a();
                    String b4 = this.P.b();
                    if (TextUtils.isEmpty(a5) || TextUtils.isEmpty(b4)) {
                        b4 = "vivo_module_video_start.png";
                    } else {
                        str = a5;
                    }
                    Bitmap a6 = com.vivo.mobilead.util.g.a(this.f30039i, str);
                    Bitmap a7 = com.vivo.mobilead.util.g.a(this.f30039i, b4);
                    if (a6 != null && a7 != null) {
                        this.P.a(new Bitmap[]{a6, a7});
                    }
                    this.P.c();
                }
                this.P.setVisibility(2);
            }
            ViewBase findViewBaseByName4 = virtualView.findViewBaseByName("videoProgress");
            if (findViewBaseByName4 instanceof com.vivo.mobilead.unified.base.g.b.c) {
                this.N = (com.vivo.mobilead.unified.base.g.b.c) findViewBaseByName4;
                findViewBaseByName4.setVisibility(0);
            }
            ViewBase findViewBaseByName5 = virtualView.findViewBaseByName("mute");
            if (findViewBaseByName5 instanceof com.vivo.mobilead.unified.base.g.b.e) {
                com.vivo.mobilead.unified.base.g.b.e eVar3 = (com.vivo.mobilead.unified.base.g.b.e) findViewBaseByName5;
                this.Q = eVar3;
                if (z) {
                    String a8 = eVar3.a();
                    String b5 = this.Q.b();
                    if (TextUtils.isEmpty(a8) || TextUtils.isEmpty(b5)) {
                        a8 = "vivo_module_afk_ctrl_mute.png";
                        b5 = "vivo_module_afk_ctrl_vol_resume.png";
                    }
                    Bitmap a9 = com.vivo.mobilead.util.g.a(this.f30039i, a8);
                    Bitmap a10 = com.vivo.mobilead.util.g.a(this.f30039i, b5);
                    if (a9 != null && a10 != null) {
                        this.Q.a(new Bitmap[]{a9, a10});
                    }
                    this.Q.c();
                }
                findViewBaseByName5.setVisibility(2);
            }
            ViewBase findViewBaseByName6 = virtualView.findViewBaseByName("replay");
            if (findViewBaseByName6 instanceof NativeImage) {
                NativeImage nativeImage = (NativeImage) findViewBaseByName6;
                if (TextUtils.isEmpty(nativeImage.getSrc())) {
                    nativeImage.setImageDrawable(com.vivo.mobilead.util.g.b(this.f30039i, "vivo_module_express_replay.png"), true);
                }
            }
            ViewBase findViewBaseByName7 = virtualView.findViewBaseByName("endCard");
            if (findViewBaseByName7 != null) {
                this.R = findViewBaseByName7;
                findViewBaseByName7.setVisibility(2);
            }
            ViewBase findViewBaseByName8 = virtualView.findViewBaseByName(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
            if (findViewBaseByName8 instanceof NativeText) {
                NativeText nativeText = (NativeText) findViewBaseByName8;
                this.S = nativeText;
                if (z) {
                    if (TextUtils.isEmpty(nativeText.getText()) && bVar != null && (Q = bVar.Q()) != null) {
                        this.S.setText(r.a(Q.b()));
                    }
                    findViewBaseByName8.setVisibility(1);
                } else {
                    findViewBaseByName8.setVisibility(2);
                }
            }
            if (!q.a(this.I)) {
                ViewBase findViewBaseByName9 = virtualView.findViewBaseByName("appName");
                if (findViewBaseByName9 != null) {
                    findViewBaseByName9.setVisibility(2);
                }
                ViewBase findViewBaseByName10 = virtualView.findViewBaseByName("versionInfo");
                if (findViewBaseByName10 != null) {
                    findViewBaseByName10.setVisibility(2);
                }
                ViewBase findViewBaseByName11 = virtualView.findViewBaseByName("privacy");
                if (findViewBaseByName11 != null) {
                    findViewBaseByName11.setVisibility(2);
                }
                ViewBase findViewBaseByName12 = virtualView.findViewBaseByName("permission");
                if (findViewBaseByName12 != null) {
                    findViewBaseByName12.setVisibility(2);
                }
                ViewBase findViewBaseByName13 = virtualView.findViewBaseByName("devInfo");
                if (findViewBaseByName13 != null) {
                    findViewBaseByName13.setVisibility(2);
                }
            } else {
                com.vivo.ad.model.q y = bVar.y();
                ViewBase findViewBaseByName14 = virtualView.findViewBaseByName("appName");
                if (findViewBaseByName14 instanceof NativeText) {
                    NativeText nativeText2 = (NativeText) findViewBaseByName14;
                    if (TextUtils.isEmpty(nativeText2.getText())) {
                        nativeText2.setText(y.d());
                    }
                }
                ViewBase findViewBaseByName15 = virtualView.findViewBaseByName("versionInfo");
                if (findViewBaseByName15 instanceof NativeText) {
                    NativeText nativeText3 = (NativeText) findViewBaseByName15;
                    if (TextUtils.isEmpty(nativeText3.getText())) {
                        nativeText3.setText(" V" + y.s() + " " + (y.q() / 1024) + "MB");
                    }
                }
                ViewBase findViewBaseByName16 = virtualView.findViewBaseByName("privacy");
                if (findViewBaseByName16 instanceof NativeText) {
                    NativeText nativeText4 = (NativeText) findViewBaseByName16;
                    if (TextUtils.isEmpty(nativeText4.getText())) {
                        nativeText4.setText("隐私");
                    }
                }
                ViewBase findViewBaseByName17 = virtualView.findViewBaseByName("permission");
                if (findViewBaseByName17 instanceof NativeText) {
                    NativeText nativeText5 = (NativeText) findViewBaseByName17;
                    if (TextUtils.isEmpty(nativeText5.getText())) {
                        nativeText5.setText("权限");
                    }
                }
                ViewBase findViewBaseByName18 = virtualView.findViewBaseByName("devInfo");
                if (findViewBaseByName18 instanceof NativeText) {
                    NativeText nativeText6 = (NativeText) findViewBaseByName18;
                    if (TextUtils.isEmpty(nativeText6.getText())) {
                        nativeText6.setText(y.g());
                    }
                }
            }
            com.vivo.ad.model.q y2 = bVar.y();
            ViewBase findViewBaseByName19 = virtualView.findViewBaseByName("rating");
            ViewBase findViewBaseByName20 = virtualView.findViewBaseByName("ratingNum");
            ViewBase findViewBaseByName21 = virtualView.findViewBaseByName("rating2");
            ViewBase findViewBaseByName22 = virtualView.findViewBaseByName("ratingNum2");
            ViewBase findViewBaseByName23 = virtualView.findViewBaseByName("ratingDivider");
            ViewBase findViewBaseByName24 = virtualView.findViewBaseByName("downloadNum");
            ViewBase findViewBaseByName25 = virtualView.findViewBaseByName("downloadIcon");
            String str2 = "";
            if (y2 != null) {
                float p = y2.p();
                if (p < 4.0f) {
                    p = 4.0f;
                }
                if (p > 5.0f) {
                    p = 5.0f;
                }
                if (findViewBaseByName19 instanceof com.vivo.mobilead.unified.base.g.b.d) {
                    ((com.vivo.mobilead.unified.base.g.b.d) findViewBaseByName19).a(p);
                }
                if (findViewBaseByName20 instanceof NativeText) {
                    NativeText nativeText7 = (NativeText) findViewBaseByName20;
                    if (TextUtils.isEmpty(nativeText7.getText())) {
                        nativeText7.setText("" + p);
                    }
                }
                if (findViewBaseByName21 instanceof com.vivo.mobilead.unified.base.g.b.d) {
                    ((com.vivo.mobilead.unified.base.g.b.d) findViewBaseByName21).a(p);
                }
                if (findViewBaseByName22 instanceof NativeText) {
                    NativeText nativeText8 = (NativeText) findViewBaseByName22;
                    if (TextUtils.isEmpty(nativeText8.getText())) {
                        nativeText8.setText("" + p);
                    }
                }
                if (findViewBaseByName24 instanceof NativeText) {
                    NativeText nativeText9 = (NativeText) findViewBaseByName24;
                    if (TextUtils.isEmpty(nativeText9.getText())) {
                        String j2 = y2.j();
                        if (!TextUtils.isEmpty(j2)) {
                            nativeText9.setText(j2 + "人");
                        }
                    }
                }
                if (findViewBaseByName25 instanceof NativeImage) {
                    NativeImage nativeImage2 = (NativeImage) findViewBaseByName25;
                    if (TextUtils.isEmpty(nativeImage2.getSrc())) {
                        nativeImage2.setImageDrawable(com.vivo.mobilead.util.g.b(this.f30039i, "vivo_module_biz_ui_download_gray.png"), true);
                    }
                }
            } else {
                if (findViewBaseByName19 != null) {
                    findViewBaseByName19.setVisibility(2);
                }
                if (findViewBaseByName20 != null) {
                    findViewBaseByName20.setVisibility(2);
                }
                if (findViewBaseByName23 != null) {
                    findViewBaseByName23.setVisibility(2);
                }
                if (findViewBaseByName24 != null) {
                    findViewBaseByName24.setVisibility(2);
                }
                if (findViewBaseByName25 != null) {
                    findViewBaseByName25.setVisibility(2);
                }
            }
            String a11 = com.vivo.mobilead.util.f.a(this.f30039i, this.I);
            ViewBase findViewBaseByName26 = virtualView.findViewBaseByName("ad_btn");
            if (findViewBaseByName26 instanceof NativeText) {
                ((NativeText) findViewBaseByName26).setText(a11);
            }
            ViewBase findViewBaseByName27 = virtualView.findViewBaseByName("ad_btn2");
            if (findViewBaseByName27 instanceof NativeText) {
                ((NativeText) findViewBaseByName27).setText(a11);
            }
            ViewBase findViewBaseByName28 = virtualView.findViewBaseByName("tagText");
            NativeText nativeText10 = findViewBaseByName28 instanceof NativeText ? (NativeText) findViewBaseByName28 : null;
            String k = bVar.k();
            String O = bVar.O();
            if (O == null) {
                O = "";
            }
            ViewBase findViewBaseByName29 = virtualView.findViewBaseByName("tagImage");
            if (findViewBaseByName29 instanceof NativeImage) {
                NativeImage nativeImage3 = (NativeImage) findViewBaseByName29;
                Bitmap a12 = com.vivo.mobilead.h.b.a().a(bVar.e());
                if (a12 != null) {
                    nativeImage3.setBitmap(a12);
                    str2 = O;
                } else {
                    if (android.text.TextUtils.isEmpty(k)) {
                        str2 = O;
                    } else {
                        str2 = k + O;
                    }
                    if (nativeImage3 != null) {
                        nativeImage3.setVisibility(2);
                    }
                }
            }
            if (nativeText10 != null) {
                nativeText10.setText(str2);
            }
            ViewBase findViewBaseByName30 = virtualView.findViewBaseByName("indicator");
            if (findViewBaseByName30 instanceof NativeImage) {
                NativeImage nativeImage4 = (NativeImage) findViewBaseByName30;
                if (TextUtils.isEmpty(nativeImage4.getSrc())) {
                    nativeImage4.setImageDrawable(com.vivo.mobilead.util.g.b(this.f30039i, "vivo_module_feedback_arrow_down_white.png"), true);
                }
            }
            ViewBase findViewBaseByName31 = virtualView.findViewBaseByName("close");
            if (findViewBaseByName31 instanceof NativeImage) {
                NativeImage nativeImage5 = (NativeImage) findViewBaseByName31;
                if (TextUtils.isEmpty(nativeImage5.getSrc())) {
                    nativeImage5.setImageDrawable(com.vivo.mobilead.util.g.b(this.f30039i, "vivo_module_express_close.png"), true);
                }
            }
        }
        com.vivo.mobilead.model.b bVar2 = this.H;
        if (bVar2 != null && (c2 = bVar2.c()) != null) {
            c2.getEventManager().register(0, this);
            addView(b2);
            a(true);
            return;
        }
        a(false);
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    public void a(View.OnClickListener onClickListener, com.vivo.ad.view.l lVar, com.vivo.mobilead.unified.base.callback.d dVar, com.vivo.mobilead.unified.base.view.u.b bVar, a.f fVar) {
        super.a(onClickListener, lVar, dVar, bVar, fVar);
        this.f0 = onClickListener;
    }

    private void a(Context context, com.vivo.ad.model.b bVar, String str, boolean z) {
        if (context == null || bVar == null) {
            return;
        }
        p pVar = new p(context, bVar, str);
        p.h hVar = this.l0;
        if (hVar != null) {
            pVar.a(hVar);
        }
        if (pVar.isShowing()) {
            return;
        }
        pVar.a(z);
    }
}
