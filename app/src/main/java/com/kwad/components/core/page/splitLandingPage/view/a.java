package com.kwad.components.core.page.splitLandingPage.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.r.m;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.j.k;

/* loaded from: classes2.dex */
public final class a {
    private ImageView HA;

    @Nullable
    private WindowManager Nc;
    private com.kwad.components.core.page.splitLandingPage.kwai.a Nd;
    private FrameLayout Ne;
    private FrameLayout Nf;
    private e Ng;
    private final WindowManager.LayoutParams Nh = new WindowManager.LayoutParams();
    private InterfaceC0184a Ni;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private Context mContext;
    private ViewGroup ye;

    /* renamed from: com.kwad.components.core.page.splitLandingPage.view.a$1 */
    final class AnonymousClass1 implements View.OnTouchListener {
        float Nj = 0.0f;
        float Nk = 0.0f;
        float top = 0.0f;
        float left = 0.0f;
        long Nl = 0;

        AnonymousClass1() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (a.this.Nh == null) {
                return false;
            }
            if (motionEvent.getActionMasked() == 0) {
                this.Nj = motionEvent.getRawX();
                this.Nk = motionEvent.getRawY();
                this.left = a.this.Nh.x;
                this.top = a.this.Nh.y;
                this.Nl = SystemClock.elapsedRealtime();
                System.out.println(" actionDownX " + this.Nj + " actionDownX " + this.Nj);
            } else {
                if (motionEvent.getActionMasked() == 2) {
                    float rawX = motionEvent.getRawX() - this.Nj;
                    float rawY = motionEvent.getRawY() - this.Nk;
                    if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                        a.this.Nh.x = (int) (this.left + rawX);
                        a.this.Nh.y = (int) (this.top + rawY);
                        if (a.this.Nc != null) {
                            try {
                                a.this.Nc.updateViewLayout(a.this.ye, a.this.Nh);
                            } catch (Exception e2) {
                                com.kwad.components.core.c.a.b(e2);
                                b.printStackTraceOnly(e2);
                            }
                        }
                    }
                    return true;
                }
                if (motionEvent.getActionMasked() == 1) {
                    float rawX2 = motionEvent.getRawX() - this.Nj;
                    float rawY2 = motionEvent.getRawY() - this.Nk;
                    float elapsedRealtime = SystemClock.elapsedRealtime() - this.Nl;
                    if (Math.sqrt((rawX2 * rawX2) + (rawY2 * rawY2)) < 15.0d && elapsedRealtime > 30.0f && elapsedRealtime < 300.0f && a.this.Ni != null && a.this.Nd != null && com.kwad.sdk.core.response.a.a.ax(d.cb(a.this.Nd.getAdTemplate()))) {
                        a.this.Ni.oQ();
                    }
                }
            }
            return true;
        }
    }

    /* renamed from: com.kwad.components.core.page.splitLandingPage.view.a$2 */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.this.oP();
            a.this.aE(false).start();
        }
    }

    /* renamed from: com.kwad.components.core.page.splitLandingPage.view.a$3 */
    final class AnonymousClass3 implements a.c {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.a.c
        public final void bt() {
            a.this.oP();
            a.this.aE(false).start();
        }

        @Override // com.kwad.components.core.video.a.c
        public final void d(long j2) {
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlayStart() {
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlaying() {
        }
    }

    /* renamed from: com.kwad.components.core.page.splitLandingPage.view.a$a */
    public interface InterfaceC0184a {
        boolean oQ();
    }

    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    public a(Context context, com.kwad.components.core.page.splitLandingPage.kwai.a aVar) {
        if (context == null) {
            return;
        }
        Context wrapContextIfNeed = k.wrapContextIfNeed(context);
        this.mContext = wrapContextIfNeed;
        this.Nd = aVar;
        WindowManager windowManager = (WindowManager) wrapContextIfNeed.getSystemService("window");
        this.Nc = windowManager;
        if (windowManager == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ksad_split_mini_video, (ViewGroup) null);
        this.ye = viewGroup;
        this.Ne = (FrameLayout) viewGroup.findViewById(R.id.ksad_split_texture);
        this.Nf = (FrameLayout) this.ye.findViewById(R.id.ksad_video_container);
        this.eM = (ImageView) this.ye.findViewById(R.id.ksad_video_first_frame_container);
        this.HA = (ImageView) this.ye.findViewById(R.id.ksad_split_mini_close_btn);
        this.Ne.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.1
            float Nj = 0.0f;
            float Nk = 0.0f;
            float top = 0.0f;
            float left = 0.0f;
            long Nl = 0;

            AnonymousClass1() {
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.Nh == null) {
                    return false;
                }
                if (motionEvent.getActionMasked() == 0) {
                    this.Nj = motionEvent.getRawX();
                    this.Nk = motionEvent.getRawY();
                    this.left = a.this.Nh.x;
                    this.top = a.this.Nh.y;
                    this.Nl = SystemClock.elapsedRealtime();
                    System.out.println(" actionDownX " + this.Nj + " actionDownX " + this.Nj);
                } else {
                    if (motionEvent.getActionMasked() == 2) {
                        float rawX = motionEvent.getRawX() - this.Nj;
                        float rawY = motionEvent.getRawY() - this.Nk;
                        if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                            a.this.Nh.x = (int) (this.left + rawX);
                            a.this.Nh.y = (int) (this.top + rawY);
                            if (a.this.Nc != null) {
                                try {
                                    a.this.Nc.updateViewLayout(a.this.ye, a.this.Nh);
                                } catch (Exception e2) {
                                    com.kwad.components.core.c.a.b(e2);
                                    b.printStackTraceOnly(e2);
                                }
                            }
                        }
                        return true;
                    }
                    if (motionEvent.getActionMasked() == 1) {
                        float rawX2 = motionEvent.getRawX() - this.Nj;
                        float rawY2 = motionEvent.getRawY() - this.Nk;
                        float elapsedRealtime = SystemClock.elapsedRealtime() - this.Nl;
                        if (Math.sqrt((rawX2 * rawX2) + (rawY2 * rawY2)) < 15.0d && elapsedRealtime > 30.0f && elapsedRealtime < 300.0f && a.this.Ni != null && a.this.Nd != null && com.kwad.sdk.core.response.a.a.ax(d.cb(a.this.Nd.getAdTemplate()))) {
                            a.this.Ni.oQ();
                        }
                    }
                }
                return true;
            }
        });
    }

    private void b(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate = this.Nd.getAdTemplate();
        AdInfo cb = d.cb(adTemplate);
        String url = com.kwad.sdk.core.response.a.a.bi(cb).getUrl();
        if (TextUtils.isEmpty(url)) {
            this.eM.setVisibility(8);
        } else {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, adTemplate);
            this.eM.setVisibility(0);
        }
        String E = com.kwad.sdk.core.response.a.a.E(cb);
        if (TextUtils.isEmpty(E)) {
            return;
        }
        com.kwad.sdk.core.video.videoview.a cO = AdVideoPlayerViewCache.getInstance().cO(E);
        this.eN = cO;
        if (cO == null) {
            this.eN = new com.kwad.sdk.core.video.videoview.a(this.mContext);
            com.kwad.sdk.core.response.a.a.S(cb);
            this.eN.a(new b.a(adTemplate).a(adTemplate.mVideoPlayerStatus).bs(d.cd(adTemplate)).bt(f.b(d.cc(adTemplate))).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(adTemplate, System.currentTimeMillis())).tR(), null);
            this.eN.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            e eVar = new e(this.mContext, adTemplate, this.eN, ksAdVideoPlayConfig);
            this.Ng = eVar;
            eVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.eN.setController(this.Ng);
            this.Ng.setAutoRelease(false);
        } else {
            e eVar2 = (e) cO.getController();
            this.Ng = eVar2;
            eVar2.setAutoRelease(false);
            this.Ng.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.eN.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.eN.getParent() != null) {
            ((ViewGroup) this.eN.getParent()).removeView(this.eN);
        }
        if (this.Nf.getTag() != null) {
            FrameLayout frameLayout = this.Nf;
            frameLayout.removeView((View) frameLayout.getTag());
            this.Nf.setTag(null);
        }
        this.Nf.addView(this.eN);
        this.Nf.setTag(this.eN);
        this.Ng.setAlpha(0.01f);
        this.Ng.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.3
            AnonymousClass3() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bt() {
                a.this.oP();
                a.this.aE(false).start();
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j2) {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlaying() {
            }
        });
    }

    public final void a(InterfaceC0184a interfaceC0184a) {
        this.Ni = interfaceC0184a;
    }

    public final Animator aE(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(m.h(this.ye, z), m.h(this.eM, z));
        return animatorSet;
    }

    public final boolean isVisible() {
        return this.ye.getAlpha() > 0.0f;
    }

    public final void oP() {
        this.Ng.onViewDetached();
    }

    public final boolean oS() {
        int a2;
        int a3;
        if (this.Nd == null || this.Nc == null) {
            return false;
        }
        b(new KsAdVideoPlayConfig.Builder().videoSoundEnable(this.Nd.getAdTemplate().mIsAudioEnable).build());
        AdInfo cb = d.cb(this.Nd.getAdTemplate());
        int K = com.kwad.sdk.core.response.a.a.K(cb);
        int J = com.kwad.sdk.core.response.a.a.J(cb);
        Rect rect = new Rect();
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (K > J) {
            int i2 = displayMetrics.widthPixels;
            rect.right = i2;
            rect.left = i2 - com.kwad.sdk.c.kwai.a.a(this.mContext, 86.0f);
            a2 = displayMetrics.heightPixels - com.kwad.sdk.c.kwai.a.a(this.mContext, 252.0f);
            rect.bottom = a2;
            a3 = com.kwad.sdk.c.kwai.a.a(this.mContext, 154.0f);
        } else {
            int i3 = displayMetrics.widthPixels;
            rect.right = i3;
            rect.left = i3 - com.kwad.sdk.c.kwai.a.a(this.mContext, 154.0f);
            a2 = displayMetrics.heightPixels - com.kwad.sdk.c.kwai.a.a(this.mContext, 252.0f);
            rect.bottom = a2;
            a3 = com.kwad.sdk.c.kwai.a.a(this.mContext, 86.0f);
        }
        rect.top = a2 - a3;
        rect.left -= com.kwad.sdk.c.kwai.a.a(this.mContext, 12.0f);
        int a4 = rect.right - com.kwad.sdk.c.kwai.a.a(this.mContext, 12.0f);
        rect.right = a4;
        WindowManager.LayoutParams layoutParams = this.Nh;
        layoutParams.type = 1003;
        layoutParams.flags = 8;
        layoutParams.gravity = 51;
        layoutParams.format = 1;
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = displayMetrics.heightPixels;
        int i4 = rect.left;
        layoutParams.x = i4;
        layoutParams.y = rect.top;
        layoutParams.width = (a4 - i4) + com.kwad.sdk.c.kwai.a.a(this.mContext, 12.0f);
        this.Nh.height = (rect.bottom - rect.top) + com.kwad.sdk.c.kwai.a.a(this.mContext, 12.0f);
        float f2 = (rect.left * displayMetrics.widthPixels) / ((r0 + r4) - rect.right);
        float f3 = (rect.top * displayMetrics.heightPixels) / ((r0 + r3) - rect.bottom);
        this.ye.setPivotX(f2);
        this.ye.setPivotY(f3);
        this.ye.setAlpha(0.0f);
        WindowManager windowManager = this.Nc;
        if (windowManager != null) {
            try {
                windowManager.addView(this.ye, this.Nh);
            } catch (Exception e2) {
                com.kwad.components.core.c.a.b(e2);
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }
        this.HA.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.oP();
                a.this.aE(false).start();
            }
        });
        return true;
    }

    public final void oT() {
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar == null || aVar.isPlaying()) {
            return;
        }
        this.Ng.qw();
    }
}
