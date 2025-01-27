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
import com.kwad.components.core.s.n;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.n.m;

/* loaded from: classes3.dex */
public final class a {
    private ViewGroup Aj;
    private ImageView KL;

    @Nullable
    private WindowManager Sn;
    private com.kwad.components.core.page.splitLandingPage.a.a So;
    private FrameLayout Sp;
    private FrameLayout Sq;
    private e Sr;
    private final WindowManager.LayoutParams Ss = new WindowManager.LayoutParams();
    private InterfaceC0441a St;
    private com.kwad.sdk.core.video.videoview.a co;

    /* renamed from: gh */
    private ImageView f11937gh;
    private Context mContext;

    /* renamed from: com.kwad.components.core.page.splitLandingPage.view.a$1 */
    public class AnonymousClass1 implements View.OnTouchListener {
        float Su = 0.0f;
        float Sv = 0.0f;
        float top = 0.0f;
        float left = 0.0f;
        long Sw = 0;

        public AnonymousClass1() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (a.this.Ss == null) {
                return false;
            }
            if (motionEvent.getActionMasked() == 0) {
                this.Su = motionEvent.getRawX();
                this.Sv = motionEvent.getRawY();
                this.left = a.this.Ss.x;
                this.top = a.this.Ss.y;
                this.Sw = SystemClock.elapsedRealtime();
                System.out.println(" actionDownX " + this.Su + " actionDownX " + this.Su);
            } else {
                if (motionEvent.getActionMasked() == 2) {
                    float rawX = motionEvent.getRawX() - this.Su;
                    float rawY = motionEvent.getRawY() - this.Sv;
                    if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                        a.this.Ss.x = (int) (this.left + rawX);
                        a.this.Ss.y = (int) (this.top + rawY);
                        if (a.this.Sn != null) {
                            try {
                                a.this.Sn.updateViewLayout(a.this.Aj, a.this.Ss);
                            } catch (Exception e10) {
                                com.kwad.components.core.d.a.reportSdkCaughtException(e10);
                                c.printStackTraceOnly(e10);
                            }
                        }
                    }
                    return true;
                }
                if (motionEvent.getActionMasked() == 1) {
                    float rawX2 = motionEvent.getRawX() - this.Su;
                    float rawY2 = motionEvent.getRawY() - this.Sv;
                    float elapsedRealtime = SystemClock.elapsedRealtime() - this.Sw;
                    if (Math.sqrt((rawX2 * rawX2) + (rawY2 * rawY2)) < 15.0d && elapsedRealtime > 30.0f && elapsedRealtime < 300.0f && a.this.St != null && a.this.So != null && com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.eb(a.this.So.getAdTemplate()))) {
                        a.this.St.qO();
                    }
                }
            }
            return true;
        }
    }

    /* renamed from: com.kwad.components.core.page.splitLandingPage.view.a$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.this.qN();
            a.this.aI(false).start();
        }
    }

    /* renamed from: com.kwad.components.core.page.splitLandingPage.view.a$3 */
    public class AnonymousClass3 implements a.c {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.a.c
        public final void ap() {
        }

        @Override // com.kwad.components.core.video.a.c
        public final void aq() {
            a.this.qN();
            a.this.aI(false).start();
        }

        @Override // com.kwad.components.core.video.a.c
        public final void d(long j10) {
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlayStart() {
        }
    }

    /* renamed from: com.kwad.components.core.page.splitLandingPage.view.a$a */
    public interface InterfaceC0441a {
        boolean qO();
    }

    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    public a(Context context, com.kwad.components.core.page.splitLandingPage.a.a aVar) {
        if (context == null) {
            return;
        }
        Context wrapContextIfNeed = m.wrapContextIfNeed(context);
        this.mContext = wrapContextIfNeed;
        this.So = aVar;
        WindowManager windowManager = (WindowManager) wrapContextIfNeed.getSystemService("window");
        this.Sn = windowManager;
        if (windowManager == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ksad_split_mini_video, (ViewGroup) null);
        this.Aj = viewGroup;
        this.Sp = (FrameLayout) viewGroup.findViewById(R.id.ksad_split_texture);
        this.Sq = (FrameLayout) this.Aj.findViewById(R.id.ksad_video_container);
        this.f11937gh = (ImageView) this.Aj.findViewById(R.id.ksad_video_first_frame_container);
        this.KL = (ImageView) this.Aj.findViewById(R.id.ksad_split_mini_close_btn);
        this.Sp.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.1
            float Su = 0.0f;
            float Sv = 0.0f;
            float top = 0.0f;
            float left = 0.0f;
            long Sw = 0;

            public AnonymousClass1() {
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.Ss == null) {
                    return false;
                }
                if (motionEvent.getActionMasked() == 0) {
                    this.Su = motionEvent.getRawX();
                    this.Sv = motionEvent.getRawY();
                    this.left = a.this.Ss.x;
                    this.top = a.this.Ss.y;
                    this.Sw = SystemClock.elapsedRealtime();
                    System.out.println(" actionDownX " + this.Su + " actionDownX " + this.Su);
                } else {
                    if (motionEvent.getActionMasked() == 2) {
                        float rawX = motionEvent.getRawX() - this.Su;
                        float rawY = motionEvent.getRawY() - this.Sv;
                        if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                            a.this.Ss.x = (int) (this.left + rawX);
                            a.this.Ss.y = (int) (this.top + rawY);
                            if (a.this.Sn != null) {
                                try {
                                    a.this.Sn.updateViewLayout(a.this.Aj, a.this.Ss);
                                } catch (Exception e10) {
                                    com.kwad.components.core.d.a.reportSdkCaughtException(e10);
                                    c.printStackTraceOnly(e10);
                                }
                            }
                        }
                        return true;
                    }
                    if (motionEvent.getActionMasked() == 1) {
                        float rawX2 = motionEvent.getRawX() - this.Su;
                        float rawY2 = motionEvent.getRawY() - this.Sv;
                        float elapsedRealtime = SystemClock.elapsedRealtime() - this.Sw;
                        if (Math.sqrt((rawX2 * rawX2) + (rawY2 * rawY2)) < 15.0d && elapsedRealtime > 30.0f && elapsedRealtime < 300.0f && a.this.St != null && a.this.So != null && com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.eb(a.this.So.getAdTemplate()))) {
                            a.this.St.qO();
                        }
                    }
                }
                return true;
            }
        });
    }

    public final Animator aI(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(n.h(this.Aj, z10), n.h(this.f11937gh, z10));
        return animatorSet;
    }

    public final boolean isVisible() {
        return this.Aj.getAlpha() > 0.0f;
    }

    public final void qN() {
        this.Sr.aa();
    }

    public final boolean qQ() {
        if (this.So == null || this.Sn == null) {
            return false;
        }
        c(new KsAdVideoPlayConfig.Builder().videoSoundEnable(this.So.getAdTemplate().mIsAudioEnable).build());
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.So.getAdTemplate());
        int R = com.kwad.sdk.core.response.b.a.R(eb2);
        int Q = com.kwad.sdk.core.response.b.a.Q(eb2);
        Rect rect = new Rect();
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (R > Q) {
            int i10 = displayMetrics.widthPixels;
            rect.right = i10;
            rect.left = i10 - com.kwad.sdk.c.a.a.a(this.mContext, 86.0f);
            int a10 = displayMetrics.heightPixels - com.kwad.sdk.c.a.a.a(this.mContext, 252.0f);
            rect.bottom = a10;
            rect.top = a10 - com.kwad.sdk.c.a.a.a(this.mContext, 154.0f);
        } else {
            int i11 = displayMetrics.widthPixels;
            rect.right = i11;
            rect.left = i11 - com.kwad.sdk.c.a.a.a(this.mContext, 154.0f);
            int a11 = displayMetrics.heightPixels - com.kwad.sdk.c.a.a.a(this.mContext, 252.0f);
            rect.bottom = a11;
            rect.top = a11 - com.kwad.sdk.c.a.a.a(this.mContext, 86.0f);
        }
        rect.left -= com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        int a12 = rect.right - com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        rect.right = a12;
        WindowManager.LayoutParams layoutParams = this.Ss;
        layoutParams.type = 1003;
        layoutParams.flags = 8;
        layoutParams.gravity = 51;
        layoutParams.format = 1;
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = displayMetrics.heightPixels;
        int i12 = rect.left;
        layoutParams.x = i12;
        layoutParams.y = rect.top;
        layoutParams.width = (a12 - i12) + com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        this.Ss.height = (rect.bottom - rect.top) + com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        float f10 = (rect.left * displayMetrics.widthPixels) / ((r0 + r4) - rect.right);
        float f11 = (rect.top * displayMetrics.heightPixels) / ((r0 + r3) - rect.bottom);
        this.Aj.setPivotX(f10);
        this.Aj.setPivotY(f11);
        this.Aj.setAlpha(0.0f);
        if (this.Sn != null) {
            try {
                if (this.Aj.getWindowToken() == null) {
                    this.Sn.addView(this.Aj, this.Ss);
                }
            } catch (Exception e10) {
                com.kwad.components.core.d.a.reportSdkCaughtException(e10);
                c.printStackTraceOnly(e10);
            }
        }
        this.KL.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.2
            public AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.qN();
                a.this.aI(false).start();
            }
        });
        return true;
    }

    public final void qR() {
        com.kwad.sdk.core.video.videoview.a aVar = this.co;
        if (aVar == null || aVar.isPlaying()) {
            return;
        }
        this.Sr.sN();
    }

    private void c(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate = this.So.getAdTemplate();
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        String url = com.kwad.sdk.core.response.b.a.bt(eb2).getUrl();
        if (TextUtils.isEmpty(url)) {
            this.f11937gh.setVisibility(8);
        } else {
            this.f11937gh.setImageDrawable(null);
            KSImageLoader.loadImage(this.f11937gh, url, adTemplate);
            this.f11937gh.setVisibility(0);
        }
        String K = com.kwad.sdk.core.response.b.a.K(eb2);
        if (TextUtils.isEmpty(K)) {
            return;
        }
        com.kwad.sdk.core.video.videoview.a eI = AdVideoPlayerViewCache.getInstance().eI(K);
        this.co = eI;
        if (eI == null) {
            this.co = new com.kwad.sdk.core.video.videoview.a(this.mContext);
            com.kwad.sdk.core.response.b.a.ab(eb2);
            this.co.a(new b.a(adTemplate).a(adTemplate.mVideoPlayerStatus).dc(com.kwad.sdk.core.response.b.e.ed(adTemplate)).dd(h.b(com.kwad.sdk.core.response.b.e.ec(adTemplate))).b(new com.kwad.sdk.contentalliance.a.a.a(adTemplate, System.currentTimeMillis())).Cz(), null);
            this.co.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            e eVar = new e(this.mContext, adTemplate, this.co, ksAdVideoPlayConfig);
            this.Sr = eVar;
            eVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.co.setController(this.Sr);
            this.Sr.setAutoRelease(false);
        } else {
            e eVar2 = (e) eI.getController();
            this.Sr = eVar2;
            eVar2.setAutoRelease(false);
            this.Sr.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.co.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.co.getParent() != null) {
            ((ViewGroup) this.co.getParent()).removeView(this.co);
        }
        if (this.Sq.getTag() != null) {
            FrameLayout frameLayout = this.Sq;
            frameLayout.removeView((View) frameLayout.getTag());
            this.Sq.setTag(null);
        }
        this.Sq.addView(this.co);
        this.Sq.setTag(this.co);
        this.Sr.setAlpha(0.01f);
        this.Sr.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void ap() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
                a.this.qN();
                a.this.aI(false).start();
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j10) {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
            }
        });
    }

    public final void a(InterfaceC0441a interfaceC0441a) {
        this.St = interfaceC0441a;
    }
}
