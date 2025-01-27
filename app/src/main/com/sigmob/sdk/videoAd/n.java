package com.sigmob.sdk.videoAd;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.common.utils.ViewUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.ImageLoader;
import com.czhj.volley.toolbox.StringUtil;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.common.y;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.ClickAreaSetting;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.views.c0;
import com.sigmob.sdk.base.views.d;
import com.sigmob.sdk.base.views.k0;
import com.sigmob.sdk.base.views.n0;
import com.sigmob.sdk.base.views.o;
import com.sigmob.sdk.base.views.p0;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.base.views.q0;
import com.sigmob.sdk.base.views.u0;
import com.sigmob.sdk.base.views.z;
import com.sigmob.sdk.videoAd.i;
import com.sigmob.windad.natives.WindNativeAdData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class n extends com.sigmob.sdk.videoAd.c implements h.e, com.sigmob.sdk.base.common.z, com.sigmob.sdk.videocache.d {

    /* renamed from: i */
    public static final String f20492i = "video_config";

    /* renamed from: j */
    public static final String f20493j = "current_position";

    /* renamed from: k */
    public static final String f20494k = "video_finished";

    /* renamed from: l */
    public static final String f20495l = "companionAd_visable";

    /* renamed from: m */
    public static final long f20496m = 50;

    /* renamed from: n */
    public static final int f20497n = -1;

    /* renamed from: o */
    public static final int f20498o = 0;

    /* renamed from: p */
    public static int f20499p;
    public List<String> A;
    public boolean A0;
    public long B;
    public String B0;
    public String C;
    public View.OnClickListener C0;
    public boolean D;
    public boolean D0;
    public Handler E;
    public boolean F;
    public com.sigmob.sdk.base.views.d G;
    public String H;
    public int I;
    public boolean J;
    public com.sigmob.sdk.videoAd.a K;
    public int L;
    public com.sigmob.sdk.videoplayer.a M;
    public BaseAdUnit N;
    public View O;
    public com.sigmob.sdk.base.common.t P;
    public MediaMetadataRetriever Q;
    public q0 R;
    public p0 S;
    public com.sigmob.sdk.base.views.w T;
    public com.sigmob.sdk.videoAd.i U;
    public int V;
    public int W;
    public boolean X;
    public boolean Y;
    public int Z;

    /* renamed from: a0 */
    public boolean f20500a0;

    /* renamed from: b0 */
    public RelativeLayout f20501b0;

    /* renamed from: c0 */
    public boolean f20502c0;

    /* renamed from: d0 */
    public p0 f20503d0;

    /* renamed from: e0 */
    public boolean f20504e0;

    /* renamed from: f0 */
    public boolean f20505f0;

    /* renamed from: g0 */
    public ImageLoader.ImageContainer f20506g0;

    /* renamed from: h0 */
    public com.sigmob.sdk.base.views.m f20507h0;

    /* renamed from: i0 */
    public boolean f20508i0;

    /* renamed from: j0 */
    public boolean f20509j0;

    /* renamed from: k0 */
    public boolean f20510k0;

    /* renamed from: l0 */
    public int f20511l0;

    /* renamed from: m0 */
    public com.sigmob.sdk.base.views.z f20512m0;

    /* renamed from: n0 */
    public boolean f20513n0;

    /* renamed from: o0 */
    public com.sigmob.sdk.base.views.q f20514o0;

    /* renamed from: p0 */
    public boolean f20515p0;

    /* renamed from: q */
    public final int f20516q;

    /* renamed from: q0 */
    public com.sigmob.sdk.base.views.w f20517q0;

    /* renamed from: r */
    public String f20518r;

    /* renamed from: r0 */
    public com.sigmob.sdk.base.views.w f20519r0;

    /* renamed from: s */
    public com.sigmob.sdk.base.views.b f20520s;

    /* renamed from: s0 */
    public y.b f20521s0;

    /* renamed from: t */
    public ImageView f20522t;

    /* renamed from: t0 */
    public View f20523t0;

    /* renamed from: u */
    public RelativeLayout f20524u;

    /* renamed from: u0 */
    public boolean f20525u0;

    /* renamed from: v */
    public int f20526v;

    /* renamed from: v0 */
    public com.sigmob.sdk.nativead.a f20527v0;

    /* renamed from: w */
    public boolean f20528w;

    /* renamed from: w0 */
    public com.sigmob.sdk.base.views.w f20529w0;

    /* renamed from: x */
    public int f20530x;

    /* renamed from: x0 */
    public boolean f20531x0;

    /* renamed from: y */
    public String f20532y;

    /* renamed from: y0 */
    public boolean f20533y0;

    /* renamed from: z */
    public List<String> f20534z;

    /* renamed from: z0 */
    public boolean f20535z0;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (new File(n.this.N.getVideoPath()).exists()) {
                n.this.Q.setDataSource(n.this.N.getVideoPath());
            } else {
                n.this.Q.setDataSource(n.this.N.getVideo_url(), new HashMap());
            }
        }
    }

    public class a0 implements com.sigmob.sdk.videoplayer.l {

        /* renamed from: a */
        public final /* synthetic */ com.sigmob.sdk.videoplayer.a f20537a;

        public a0(com.sigmob.sdk.videoplayer.a aVar) {
            this.f20537a = aVar;
        }

        @Override // com.sigmob.sdk.videoplayer.l
        public void a(long j10, long j11) {
            int A = n.this.A();
            n.this.S();
            if (n.this.R()) {
                n.this.c(false);
            }
            if (n.this.G()) {
                n.this.b(false);
            }
            int E = n.this.E();
            if (n.this.G != null) {
                n.this.G.setduration(E);
            }
            if (n.this.f20508i0) {
                n.this.R.a((int) n.this.M.getCurrentPositionWhenPlaying());
            }
            long j12 = A;
            if (1000 + j10 < j12) {
                if (n.this.O()) {
                    n.this.J();
                } else if (!n.this.f20533y0) {
                    n.this.T.setText(String.valueOf((int) ((j12 - n.this.M.getCurrentPositionWhenPlaying()) / 1000.0f)));
                }
            }
            if (n.this.N()) {
                n.this.P();
            }
            for (com.sigmob.sdk.videoAd.f fVar : n.this.K.a(j10, j12)) {
                n.this.b(fVar.getEvent());
                fVar.setTracked();
            }
            if (j10 > j12) {
                n.this.d(true);
            }
        }

        @Override // com.sigmob.sdk.videoplayer.l
        public void a(com.sigmob.sdk.videoplayer.e eVar) {
            SigmobLog.i("video player state change " + eVar);
            int i10 = s.f20563a[eVar.ordinal()];
            if (i10 != 1) {
                if (i10 == 3) {
                    n.this.C = "none";
                    n.this.d(true);
                    return;
                }
                if (i10 == 8) {
                    com.sigmob.sdk.base.common.b0.a("video", this.f20537a.getErrorCode(), this.f20537a.getErrorMessage(), n.this.N);
                    n.this.d(false);
                    return;
                } else if (i10 == 5) {
                    n.this.Q();
                    this.f20537a.g();
                    return;
                } else {
                    if (i10 != 6) {
                        return;
                    }
                    n.this.y();
                    this.f20537a.h();
                    return;
                }
            }
            n.this.Z = (int) this.f20537a.getDuration();
            if (n.this.Z == 0) {
                n nVar = n.this;
                nVar.Z = nVar.N.getDuration();
            }
            if (!n.this.f20533y0) {
                n.this.T.setText(String.valueOf((int) (n.this.A() / 1000.0f)));
                n.this.T.setVisibility(0);
            }
            n nVar2 = n.this;
            nVar2.g(nVar2.h(), 0);
            this.f20537a.getVideoWidth();
            this.f20537a.getVideoHeight();
            if (n.this.U != null) {
                n.this.U.a(n.this.A());
            }
            if (n.this.f20504e0) {
                n.this.f20503d0.b(ResourceUtil.getDrawableId(n.this.h(), "sig_image_video_mute"));
                n.this.M.setMute(true);
            }
            n.this.B().a(n.this.Z, n.this.K.n());
            if (!n.this.X && (n.this.W == 0 || n.this.W == -1)) {
                SigMacroCommon macroCommon = n.this.N.getMacroCommon();
                if (macroCommon instanceof SigMacroCommon) {
                    macroCommon.addMarcoKey(SigMacroCommon._COMPLETED_, "0");
                    macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(n.this.A() / 1000));
                }
            }
            if (n.this.f20508i0) {
                n.this.R.a(n.this.A(), 0);
            }
        }
    }

    public class b implements b0.g {
        public b() {
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                HashMap hashMap = new HashMap();
                n nVar = n.this;
                hashMap.put("duration_seq", nVar.a((List<String>) nVar.f20534z));
                n nVar2 = n.this;
                hashMap.put("video_time_seq", nVar2.a((List<String>) nVar2.A));
                hashMap.put("skip_state", n.this.C);
                hashMap.put("video_duration", String.format("%.2f", Float.valueOf(n.this.A() / 1000.0f)));
                hashMap.put("endcard_loading_state", n.this.f20532y);
                ((PointEntitySigmob) obj).setOptions(hashMap);
            }
        }
    }

    public static class b0 {
        @JavascriptInterface
        public int getInteractionType() {
            return n.f20499p;
        }

        @JavascriptInterface
        public String getSdkVersion() {
            return com.sigmob.sdk.base.k.f18179k;
        }
    }

    public class c implements d.c {
        public c() {
        }

        @Override // com.sigmob.sdk.base.views.d.c
        public void a() {
            n.this.M.h();
            n.this.G.setVisibility(8);
            if (n.this.f20507h0 == null || n.this.f20507h0.getFourElementsLayout() == null) {
                return;
            }
            n.this.f20507h0.getFourElementsLayout().setClickable(true);
        }

        @Override // com.sigmob.sdk.base.views.d.c
        public void onCancel() {
            if (!n.this.X) {
                n.this.B().a("skip", (int) n.this.M.getCurrentPositionWhenPlaying());
                n.this.K.c(n.this.f17899b, (int) n.this.M.getCurrentPositionWhenPlaying(), n.this.A(), n.this.N);
            }
            n.this.G.setVisibility(8);
            if (n.this.f20507h0 != null && n.this.f20507h0.getFourElementsLayout() != null) {
                n.this.f20507h0.getFourElementsLayout().setClickable(true);
            }
            if (n.this.K.t()) {
                n.this.g().a();
                return;
            }
            if (!n.this.F) {
                n nVar = n.this;
                nVar.b((int) nVar.M.getCurrentPositionWhenPlaying());
            }
            n.this.M.s();
            n.this.I();
            n.this.X = true;
            if (n.this.P != null) {
                n.this.P.a("show", 0);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n.this.a(1);
        }
    }

    public class e implements View.OnTouchListener {

        /* renamed from: a */
        public MotionEvent f20542a;

        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            SigmobLog.d("mCompanionAdsWidget click" + motionEvent.toString());
            if (motionEvent.getAction() == 1) {
                com.sigmob.sdk.base.common.b0.a(n.this.N, motionEvent, com.sigmob.sdk.base.common.a.f17670w, true);
                if (this.f20542a == null) {
                    this.f20542a = motionEvent;
                }
                SigMacroCommon macroCommon = n.this.N.getMacroCommon();
                if (macroCommon instanceof SigMacroCommon) {
                    macroCommon.addMarcoKey(SigMacroCommon._PROGRESS_, String.valueOf(((int) n.this.D()) * 100));
                    macroCommon.updateClickMarco(this.f20542a, motionEvent, true);
                }
                n.this.f20518r = SigMacroCommon.getCoordinate(this.f20542a, motionEvent, true);
                if (n.this.U == null) {
                    n.this.H();
                }
                n.this.N.getClickCommon().click_area = "companion";
                n.this.N.getClickCommon().click_scene = "ad";
                n.this.K.a(com.sigmob.sdk.base.a.COMPANION, n.this.f20518r, true);
            } else if (motionEvent.getAction() == 0) {
                this.f20542a = MotionEvent.obtain(motionEvent);
            }
            return true;
        }
    }

    public class f implements z.d {
        public f() {
        }

        @Override // com.sigmob.sdk.base.views.z.d
        public void a() {
            if (n.this.f20512m0 != null) {
                n.this.f20512m0.dismiss();
                n.this.f20512m0.a();
                n.this.f20512m0 = null;
            }
            n.this.f20502c0 = true;
            n.this.K.a(n.this.h(), n.this.A(), n.this.N);
            n.this.g().a();
        }
    }

    public class g implements View.OnTouchListener {
        public g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (n.this.D0 || n.this.f20512m0 == null || n.this.f20512m0.c() || n.this.f20513n0) {
                    n.this.f20502c0 = true;
                    n.this.K.a(n.this.h(), n.this.A(), n.this.N);
                    n.this.g().a();
                } else {
                    n.this.f20512m0.show();
                    n.this.f20513n0 = true;
                }
            }
            return true;
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n.this.B().a(com.sigmob.sdk.base.common.a.f17669v, (int) n.this.M.getCurrentPositionWhenPlaying());
            if (n.this.R()) {
                n.this.c(false);
            }
            if (n.this.f20505f0 || n.this.N.getConfirmDialog() == 2 || n.this.N.getAd_type() == 4) {
                n.this.B().a("skip", (int) n.this.M.getCurrentPositionWhenPlaying());
                n.this.K.c(n.this.f17899b, (int) n.this.M.getCurrentPositionWhenPlaying(), n.this.A(), n.this.N);
                n.this.d(false);
                return;
            }
            n.this.M.g();
            SigmobLog.i("videoView.pause()");
            n.this.G.setduration(n.this.E());
            n.this.G.setVisibility(0);
            if (n.this.f20507h0 == null || n.this.f20507h0.getFourElementsLayout() == null) {
                return;
            }
            n.this.f20507h0.getFourElementsLayout().setClickable(false);
        }
    }

    public class i implements ValueAnimator.AnimatorUpdateListener {
        public i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) n.this.T.getLayoutParams();
            layoutParams.width = intValue;
            n.this.T.setLayoutParams(layoutParams);
            n.this.T.invalidate();
        }
    }

    public class j implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f20548a;

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Bitmap f20550a;

            public a(Bitmap bitmap) {
                this.f20550a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                n.this.f20522t.setScaleType(ImageView.ScaleType.FIT_XY);
                n.this.f20522t.setImageBitmap(this.f20550a);
            }
        }

        public j(int i10) {
            this.f20548a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap frameAtTime = n.this.Q.getFrameAtTime(this.f20548a * 1000, 2);
            if (frameAtTime != null) {
                new Handler(Looper.getMainLooper()).post(new a(frameAtTime));
            }
        }
    }

    public class k implements q.g {
        public k() {
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void a(String str, String str2) {
            n.this.N.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
            n.this.N.getClickCommon().click_scene = "appinfo";
            n.this.N.getClickCommon().is_final_click = true;
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void b() {
            n.this.f20515p0 = true;
            n.this.f20525u0 = true;
            n.this.U();
            if (n.this.f20521s0 != null) {
                n.this.f20521s0.b();
            }
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void a() {
            n.this.f20515p0 = false;
            n.this.f20525u0 = false;
            n.this.V();
            if (n.this.f20521s0 != null) {
                n.this.f20521s0.c();
            }
        }
    }

    public class l implements View.OnTouchListener {
        public l() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (n.this.f20504e0) {
                    n.this.B().a(com.sigmob.sdk.base.common.a.E, (int) n.this.M.getCurrentPositionWhenPlaying());
                    n.this.f20503d0.b(ResourceUtil.getDrawableId(n.this.h(), "sig_image_video_unmute"));
                    n.this.M.setMute(false);
                } else {
                    n.this.B().a(com.sigmob.sdk.base.common.a.D, (int) n.this.M.getCurrentPositionWhenPlaying());
                    n.this.f20503d0.b(ResourceUtil.getDrawableId(n.this.h(), "sig_image_video_mute"));
                    n.this.M.setMute(true);
                }
                n.this.f20504e0 = !r3.f20504e0;
            }
            return true;
        }
    }

    public class m implements q.g {

        /* renamed from: a */
        public final /* synthetic */ int f20554a;

        public m(int i10) {
            this.f20554a = i10;
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void a(String str, String str2) {
            if (n.this.U == null) {
                n.this.H();
            }
            n.this.N.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
            n.this.N.getClickCommon().click_scene = "appinfo";
            n.this.K.b(com.sigmob.sdk.base.a.ENDCARD, str, str2, true);
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void b() {
            if (n.this.M != null && this.f20554a == 1) {
                n.this.M.g();
            }
            if (n.this.f20521s0 != null) {
                n.this.f20521s0.b();
            }
            n.this.B().a(com.sigmob.sdk.base.common.a.f17653f, (int) n.this.M.getCurrentPositionWhenPlaying());
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void a() {
            if (n.this.f20514o0 != null) {
                n.this.f20514o0.dismiss();
                n.this.f20514o0.b();
                n.this.f20514o0 = null;
                n.this.f20515p0 = false;
            }
            if (n.this.M != null && this.f20554a == 1) {
                n.this.M.h();
            }
            if (n.this.f20521s0 != null) {
                n.this.f20521s0.c();
            }
            n.this.B().a(com.sigmob.sdk.base.common.a.f17654g, (int) n.this.M.getCurrentPositionWhenPlaying());
        }
    }

    /* renamed from: com.sigmob.sdk.videoAd.n$n */
    public class C0623n implements o.a {
        public C0623n() {
        }

        @Override // com.sigmob.sdk.base.views.o.a
        public void a(MotionEvent motionEvent, MotionEvent motionEvent2) {
            if (n.this.S.getVisibility() != 0 || n.this.f20502c0) {
                SigmobLog.w("ignore invalid click");
                return;
            }
            com.sigmob.sdk.base.common.b0.a(n.this.N, motionEvent2, PointCategory.ENDCARDCLICK, true);
            SigMacroCommon macroCommon = n.this.N.getMacroCommon();
            if (macroCommon instanceof SigMacroCommon) {
                macroCommon.updateClickMarco(motionEvent, motionEvent2, true);
                n.this.f20518r = macroCommon.getCoordinate();
            }
            n.this.D = true;
            if (n.this.N.getMaterial().click_type.intValue() != com.sigmob.sdk.base.common.l.FullScreen.b() || TextUtils.isEmpty(n.this.N.getMaterial().landing_page) || n.this.N.getMaterial().creative_type.intValue() == com.sigmob.sdk.base.common.m.CreativeTypeVideo_EndCardURL.b()) {
                return;
            }
            n.this.N.getClickCommon().click_area = ClickCommon.CLICK_AREA_MATERIAL;
            n.this.N.getClickCommon().click_scene = "endcard";
            n.this.K.a(com.sigmob.sdk.base.a.ENDCARD, n.this.f20518r, true);
        }
    }

    public class o implements DownloadListener {
        public o() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            if (n.this.D) {
                if (TextUtils.isEmpty(n.this.N.getMaterial().landing_page) || n.this.N.getInteractionType() == 2) {
                    n.this.N.setCustomLandPageUrl(str);
                }
                n.this.N.getClickCommon().click_area = "companion";
                n.this.N.getClickCommon().click_scene = "endcard";
                n.this.K.a(com.sigmob.sdk.base.a.ENDCARD, n.this.f20518r, true);
                SigmobLog.d("onDownloadStart() called with: url = [" + str + "], userAgent = [" + str2 + "], contentDisposition = [" + str3 + "], mimetype = [" + str4 + "], contentLength = [" + j10 + "]");
            }
        }
    }

    public class p extends com.sigmob.sdk.base.h {

        public class a implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ String f20559a;

            public a(String str) {
                this.f20559a = str;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).setUrl(this.f20559a);
                }
            }
        }

        public p() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SigmobLog.d("onPageFinished: ");
            n.this.f20532y = "done";
        }

        @Override // com.sigmob.sdk.base.h, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            SigmobLog.d("onPageStarted: ");
        }

        @Override // com.sigmob.sdk.base.h, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            if (str2.startsWith("http://")) {
                return;
            }
            n.this.f20532y = "error";
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            int i10;
            try {
                SigmobLog.d("load url " + str);
                parse = Uri.parse(str);
                if (parse.getScheme().equalsIgnoreCase(parse.getScheme())) {
                    String host = parse.getHost();
                    if (!TextUtils.isEmpty(host)) {
                        if (!"track".equals(host) && !"active".equals(host)) {
                            if ("openFourElements".equals(host)) {
                                n.this.a(2);
                                return true;
                            }
                        }
                        String queryParameter = parse.getQueryParameter(h3.e.f26408m);
                        String queryParameter2 = parse.getQueryParameter(NotificationCompat.CATEGORY_EVENT);
                        if (!TextUtils.isEmpty(queryParameter2) && !TextUtils.isEmpty(queryParameter)) {
                            com.sigmob.sdk.base.common.b0.a(host, queryParameter2, n.this.N, new a(new String(Base64.decode(queryParameter, 0), "utf-8")));
                        }
                        return true;
                    }
                }
            } catch (Throwable unused) {
                SigmobLog.e("webview");
            }
            if (n.this.f20502c0) {
                return true;
            }
            if (n.this.N.getMaterial().disable_auto_deeplink.booleanValue() && !n.this.D) {
                return TextUtils.isEmpty(str) || !str.startsWith("http");
            }
            if (n.this.N.getMaterial().click_type.intValue() != com.sigmob.sdk.base.common.l.Button.b() && !TextUtils.isEmpty(n.this.N.getMaterial().landing_page) && n.this.N.getMaterial().creative_type.intValue() != com.sigmob.sdk.base.common.m.CreativeTypeVideo_EndCardURL.b()) {
                if (n.this.N.getMaterial().click_type.intValue() == com.sigmob.sdk.base.common.l.FullScreen.b()) {
                    TextUtils.isEmpty(n.this.N.getMaterial().landing_page);
                    return true;
                }
                return true;
            }
            n.this.N.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
            n.this.N.getClickCommon().click_scene = "endcard";
            if (n.this.S.getVisibility() != 0 || TextUtils.isEmpty(parse.getScheme()) || parse.getScheme().equals("http") || parse.getScheme().equals("https")) {
                if (!TextUtils.isEmpty(parse.getScheme()) && (parse.getScheme().equals("http") || parse.getScheme().equals("https"))) {
                    if (n.this.f20509j0) {
                        n.this.L();
                        n.this.f20509j0 = false;
                    }
                    webView.loadUrl(str);
                }
            } else if (!StringUtil.scheme().equalsIgnoreCase(parse.getScheme()) || TextUtils.isEmpty(parse.getHost()) || !parse.getHost().equalsIgnoreCase("download") || TextUtils.isEmpty(n.this.N.getMaterial().landing_page)) {
                try {
                    List<String> list = n.this.N.getAdSetting() != null ? n.this.N.getAdSetting().scheme_white_list : null;
                    if (list != null && list.size() > 0) {
                        while (i10 < list.size()) {
                            String str2 = list.get(i10);
                            i10 = (str.startsWith(str2) || str2.equals(m5.h.f28447r)) ? 0 : i10 + 1;
                            n.this.N.setCustomDeeplink(str);
                            n.this.K.a(com.sigmob.sdk.base.a.ENDCARD, n.this.f20518r, true);
                            return true;
                        }
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } else {
                n.this.K.a(com.sigmob.sdk.base.a.ENDCARD, n.this.f20518r, true);
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            String host = webResourceRequest.getUrl().getHost();
            if (TextUtils.isEmpty(host) || !host.equals("localhost")) {
                return;
            }
            n.this.f20532y = "error";
        }
    }

    public class q implements Runnable {
        public q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.a(IntentActions.ACTION_INTERSTITIAL_CLICK);
        }
    }

    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.H();
        }
    }

    public static /* synthetic */ class s {

        /* renamed from: a */
        public static final /* synthetic */ int[] f20563a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f20564b;

        static {
            int[] iArr = new int[com.sigmob.sdk.base.a.values().length];
            f20564b = iArr;
            try {
                iArr[com.sigmob.sdk.base.a.COMPANION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20564b[com.sigmob.sdk.base.a.VIDEO_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20564b[com.sigmob.sdk.base.a.MOTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[com.sigmob.sdk.videoplayer.e.values().length];
            f20563a = iArr2;
            try {
                iArr2[com.sigmob.sdk.videoplayer.e.STATE_PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20563a[com.sigmob.sdk.videoplayer.e.STATE_PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20563a[com.sigmob.sdk.videoplayer.e.STATE_AUTO_COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f20563a[com.sigmob.sdk.videoplayer.e.STATE_STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f20563a[com.sigmob.sdk.videoplayer.e.STATE_BUFFERING_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f20563a[com.sigmob.sdk.videoplayer.e.STATE_BUFFERING_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f20563a[com.sigmob.sdk.videoplayer.e.STATE_PAUSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f20563a[com.sigmob.sdk.videoplayer.e.STATE_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public class t implements View.OnTouchListener {

        /* renamed from: a */
        public MotionEvent f20565a = null;

        public t() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
        
            if (r5.getAction() == 0) goto L100;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x009a, code lost:
        
            r3.f20565a = android.view.MotionEvent.obtain(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0098, code lost:
        
            if (r5.getAction() == 0) goto L100;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
            /*
                r3 = this;
                com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                com.sigmob.sdk.base.models.BaseAdUnit r4 = com.sigmob.sdk.videoAd.n.D(r4)
                boolean r4 = r4.getFullClickOnVideo()
                r0 = 1
                if (r4 == 0) goto L3c
                com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                com.sigmob.sdk.base.views.d r4 = com.sigmob.sdk.videoAd.n.X(r4)
                if (r4 == 0) goto L21
                com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                com.sigmob.sdk.base.views.d r4 = com.sigmob.sdk.videoAd.n.X(r4)
                int r4 = r4.getVisibility()
                if (r4 == 0) goto La0
            L21:
                int r4 = r5.getAction()
                if (r4 != r0) goto L35
                android.view.MotionEvent r4 = r3.f20565a
                if (r4 != 0) goto L2d
                r3.f20565a = r5
            L2d:
                com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                android.view.MotionEvent r1 = r3.f20565a
                com.sigmob.sdk.videoAd.n.a(r4, r1, r5)
                goto La0
            L35:
                int r4 = r5.getAction()
                if (r4 != 0) goto La0
                goto L9a
            L3c:
                int r4 = r5.getAction()
                if (r4 != r0) goto L94
                com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                com.sigmob.sdk.base.models.BaseAdUnit r4 = com.sigmob.sdk.videoAd.n.D(r4)
                com.sigmob.sdk.base.models.rtb.MaterialMeta r4 = r4.getMaterial()
                java.lang.Boolean r4 = r4.enable_collapse_tool_bar
                boolean r4 = r4.booleanValue()
                r1 = 0
                if (r4 == 0) goto L89
                com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.n.e0(r4)
                if (r4 == 0) goto L89
                com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.n.e0(r4)
                boolean r4 = r4.c()
                if (r4 == 0) goto L89
                com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.n.e0(r4)
                boolean r4 = r4.b()
                if (r4 == 0) goto L7f
                com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.n.e0(r4)
                r4.setVisibility(r1)
                goto L89
            L7f:
                com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.n.e0(r4)
                r2 = 4
                r4.setVisibility(r2)
            L89:
                com.sigmob.sdk.videoAd.n r4 = com.sigmob.sdk.videoAd.n.this
                com.sigmob.sdk.base.models.BaseAdUnit r4 = com.sigmob.sdk.videoAd.n.D(r4)
                java.lang.String r2 = "useless_video_click"
                com.sigmob.sdk.base.common.b0.a(r4, r5, r2, r1)
            L94:
                int r4 = r5.getAction()
                if (r4 != 0) goto La0
            L9a:
                android.view.MotionEvent r4 = android.view.MotionEvent.obtain(r5)
                r3.f20565a = r4
            La0:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoAd.n.t.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public class u implements Runnable {
        public u() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.E.removeCallbacksAndMessages(null);
            n nVar = n.this;
            nVar.a((int) nVar.M.getCurrentPositionWhenPlaying(), true);
        }
    }

    public class v implements View.OnClickListener {

        public class a implements WindNativeAdData.DislikeInteractionCallback {
            public a() {
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onCancel() {
                n.this.V();
                if (n.this.f20527v0 != null) {
                    n.this.f20527v0.dismiss();
                    n.this.f20527v0.b();
                    n.this.f20527v0 = null;
                }
                if (n.this.f20521s0 != null) {
                    n.this.f20521s0.c();
                }
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onSelected(int i10, String str, boolean z10) {
                n.this.V();
                if (n.this.f20527v0 != null) {
                    n.this.f20527v0.dismiss();
                    n.this.f20527v0.b();
                    n.this.f20527v0 = null;
                }
                if (n.this.f20521s0 != null) {
                    n.this.f20521s0.c();
                }
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onShow() {
                n.this.U();
                if (n.this.f20521s0 != null) {
                    n.this.f20521s0.b();
                }
            }
        }

        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity f10 = n.this.f();
            if (f10 == null || n.this.N == null) {
                return;
            }
            n.this.f20527v0 = new com.sigmob.sdk.nativead.a(f10, n.this.N);
            if (n.this.f20527v0 != null) {
                n.this.f20527v0.a();
            }
            n.this.f20527v0.a(new a());
        }
    }

    public class w implements y.c {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (n.this.f20525u0) {
                    return;
                }
                n.this.N.getClickCommon().sld = "2";
                n.this.F();
            }
        }

        public w() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(float f10) {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(Map<String, Number> map) {
            if (map != null) {
                Number number = map.get("x_max_acc");
                Number number2 = map.get("y_max_acc");
                Number number3 = map.get("z_max_acc");
                if (number != null) {
                    n.this.N.getClickCommon().x_max_acc = String.valueOf(number.intValue());
                }
                if (number2 != null) {
                    n.this.N.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
                }
                if (number3 != null) {
                    n.this.N.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
                }
                n.this.f20523t0.postDelayed(new a(), 400L);
            }
        }
    }

    public class x implements y.c {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                n.this.N.getClickCommon().sld = "5";
                n.this.F();
            }
        }

        public x() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(float f10) {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(Map<String, Number> map) {
            if (map == null || n.this.f20525u0) {
                return;
            }
            n.this.f20525u0 = true;
            Number number = map.get("turn_x");
            Number number2 = map.get("turn_y");
            Number number3 = map.get("turn_z");
            Number number4 = map.get("turn_time");
            if (number != null) {
                n.this.N.getClickCommon().turn_x = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                n.this.N.getClickCommon().turn_y = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                n.this.N.getClickCommon().turn_z = String.valueOf(number3.intValue());
            }
            n.this.N.getClickCommon().turn_time = String.valueOf(number4);
            n.this.f20523t0.postDelayed(new a(), 400L);
        }
    }

    public class y implements y.c {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                n.this.N.getClickCommon().sld = "2";
                n.this.F();
            }
        }

        public y() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(Map<String, Number> map) {
            if (map == null || n.this.f20525u0) {
                return;
            }
            n.this.f20525u0 = true;
            Number number = map.get("x_max_acc");
            Number number2 = map.get("y_max_acc");
            Number number3 = map.get("z_max_acc");
            if (number != null) {
                n.this.N.getClickCommon().x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                n.this.N.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                n.this.N.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
            }
            n.this.f20523t0.postDelayed(new a(), 400L);
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(float f10) {
            if (n.this.f20523t0 instanceof n0) {
                ((n0) n.this.f20523t0).a(f10);
            }
        }
    }

    public class z implements y.c {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (n.this.f20525u0) {
                    return;
                }
                n.this.N.getClickCommon().sld = "2";
                n.this.F();
            }
        }

        public z() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(Map<String, Number> map) {
            if (map != null) {
                Number number = map.get("x_max_acc");
                Number number2 = map.get("y_max_acc");
                Number number3 = map.get("z_max_acc");
                if (number != null) {
                    n.this.N.getClickCommon().x_max_acc = String.valueOf(number.intValue());
                }
                if (number2 != null) {
                    n.this.N.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
                }
                if (number3 != null) {
                    n.this.N.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
                }
                n.this.f20523t0.postDelayed(new a(), 400L);
            }
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(float f10) {
            if (n.this.f20523t0 instanceof k0) {
                ((k0) n.this.f20523t0).a(f10);
            }
        }
    }

    public n(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, com.sigmob.sdk.base.common.k kVar) throws IllegalStateException {
        super(activity, str, kVar);
        this.f20526v = 0;
        this.f20528w = false;
        this.f20530x = 0;
        this.f20532y = "undone";
        this.f20534z = new ArrayList();
        this.A = new ArrayList();
        this.C = "none";
        this.E = new Handler();
        this.F = true;
        this.N = null;
        this.Q = new MediaMetadataRetriever();
        this.V = 0;
        this.f20500a0 = false;
        this.f20502c0 = false;
        this.f20504e0 = false;
        this.f20505f0 = false;
        this.f20508i0 = false;
        this.f20513n0 = false;
        this.f20515p0 = false;
        this.C0 = new v();
        this.N = baseAdUnit;
        this.K = (com.sigmob.sdk.videoAd.a) baseAdUnit.getAdConfig();
        this.f20516q = Dips.dipsToIntPixels(10.0f, this.f17899b);
        this.K.a(f(), this.N, new k());
        this.K.a(this);
        this.H = this.N.getAdslot_id();
        f20499p = this.N.getInteractionType();
        f().requestWindowFeature(1);
        f().getWindow().addFlags(1024);
        b(activity, this.L, bundle);
        this.N.getMacroCommon().addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, "1");
        this.F = this.N.getMaterial().creative_type.intValue() != com.sigmob.sdk.base.common.m.CreativeTypeVideo_transparent_html.b();
        if (bundle2 != null) {
            this.W = bundle2.getInt(f20493j, -1);
            this.X = bundle2.getBoolean(f20494k, false);
            this.f20500a0 = bundle2.getBoolean(f20495l, false);
        }
        if (this.f17904g == null) {
            int h10 = com.sigmob.sdk.base.g.h();
            if (h10 != 0) {
                f().setTheme(h10);
            }
            i().setBackgroundColor(-16777216);
        } else {
            i().setBackgroundColor(0);
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f17899b);
        this.f20524u = relativeLayout;
        relativeLayout.setBackgroundColor(-16777216);
        this.M = j(this.f17899b, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.f20524u.addView(this.M, layoutParams);
        i().addView(this.f20524u, new RelativeLayout.LayoutParams(-1, -1));
        if (this.f20528w) {
            a(this.f17899b);
            Q();
        }
        r();
        this.f20524u.setClickable(true);
        this.f20524u.setOnTouchListener(new t());
    }

    public static int z() {
        return 0;
    }

    @Override // com.sigmob.sdk.videocache.d
    public void a(File file, String str, int i10) {
    }

    @Override // com.sigmob.sdk.base.common.h.e
    public void b(BaseAdUnit baseAdUnit) {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void j() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void o() {
    }

    public int A() {
        com.sigmob.sdk.videoplayer.a aVar = this.M;
        if (aVar == null) {
            return 0;
        }
        int i10 = this.Z;
        return i10 > 0 ? this.K.b(i10) : this.K.b((int) aVar.getDuration());
    }

    public com.sigmob.sdk.base.common.t B() {
        if (this.P == null) {
            com.sigmob.sdk.base.common.t tVar = new com.sigmob.sdk.base.common.t();
            this.P = tVar;
            tVar.a(a());
        }
        return this.P;
    }

    public String C() {
        return this.H;
    }

    public final float D() {
        if (A() > 0) {
            return ((int) this.M.getCurrentPositionWhenPlaying()) / A();
        }
        return 0.0f;
    }

    public int E() {
        try {
            int rewardSeconds = this.N.getRewardSeconds();
            if (rewardSeconds > -1) {
                if (A() > 0 && rewardSeconds * 1000 > A()) {
                    rewardSeconds = (int) (A() / 1000.0f);
                }
                return (int) (rewardSeconds - (this.M.getCurrentPositionWhenPlaying() / 1000.0f));
            }
            if (A() <= 0) {
                return -1;
            }
            return (int) (((A() / 1000.0f) * (this.N.getRewardPercent() * 0.01d)) - (this.M.getCurrentPositionWhenPlaying() / 1000.0f));
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final void F() {
        this.f20525u0 = true;
        this.N.getClickCommon().click_area = ClickCommon.CLICK_AREA_COMPONENT;
        this.N.getClickCommon().click_scene = "ad";
        this.N.getClickCommon().is_final_click = true;
        this.K.a(com.sigmob.sdk.base.a.MOTION, (String) null, true);
    }

    public boolean G() {
        try {
            if (this.N.getAd_type() == 1) {
                long currentPositionWhenPlaying = (int) this.M.getCurrentPositionWhenPlaying();
                if (this.N.getChargeSeconds() > -1) {
                    if ((currentPositionWhenPlaying / 1000.0f) + 0.3f >= this.N.getChargeSeconds()) {
                        return true;
                    }
                } else if (A() > 0 && (currentPositionWhenPlaying * 100) / A() >= this.N.getChargePercent()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            return true;
        }
    }

    public void H() {
        if (this.O == null && this.N.isEndCardIndexExist()) {
            try {
                com.sigmob.sdk.videoAd.i g10 = com.sigmob.sdk.videoAd.a.g(this.N);
                this.U = g10;
                g10.a(this.K);
                this.O = a(f(), this.U, 4);
                this.U.a(A());
                b(h(), 4);
            } catch (Throwable th2) {
                this.U = null;
                SigmobLog.e(th2.getMessage());
                HashMap hashMap = new HashMap();
                hashMap.put("error", th2.getMessage());
                a(IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL, hashMap);
                this.f17902e.a();
            }
        }
    }

    public final void I() {
        ImageView imageView;
        com.sigmob.sdk.base.views.w wVar = this.f20529w0;
        if (wVar != null) {
            ViewUtil.removeFromParent(wVar);
        }
        com.sigmob.sdk.base.views.w wVar2 = this.f20519r0;
        if (wVar2 != null) {
            ViewUtil.removeFromParent(wVar2);
        }
        View view = this.f20523t0;
        if (view != null) {
            ViewUtil.removeFromParent(view);
        }
        H();
        y.b bVar = this.f20521s0;
        if (bVar != null) {
            bVar.a();
            this.f20521s0 = null;
        }
        if (!this.F && (imageView = this.f20522t) != null) {
            ViewParent parent = imageView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.f20522t);
            }
            i().addView(this.f20522t, 0);
        }
        com.sigmob.sdk.base.common.h.s().b(this);
        b(h(), 0);
        com.sigmob.sdk.base.views.b bVar2 = this.f20520s;
        if (bVar2 != null) {
            bVar2.setVisibility(8);
        }
        M();
        y();
        if (this.O == null) {
            SigmobLog.e("endcard can't show " + this.N.getEndCardIndexPath());
            HashMap hashMap = new HashMap();
            hashMap.put("error", "endcard can't show");
            a(IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL, hashMap);
            this.f17902e.a();
        }
        View view2 = this.O;
        if (view2 != null) {
            view2.setVisibility(0);
            this.O.bringToFront();
        }
        RelativeLayout relativeLayout = this.f20524u;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
            a(IntentActions.ACTION_REWARDED_VIDEO_CLOSE);
        }
        com.sigmob.sdk.base.views.w wVar3 = this.T;
        if (wVar3 != null) {
            ViewUtil.removeFromParent(wVar3);
        }
        p0 p0Var = this.f20503d0;
        if (p0Var != null) {
            ViewUtil.removeFromParent(p0Var);
        }
        if (this.f20508i0) {
            ViewUtil.removeFromParent(this.R);
        }
        com.sigmob.sdk.base.views.m mVar = this.f20507h0;
        if (mVar != null) {
            ViewUtil.removeFromParent(mVar);
        }
        this.f20500a0 = true;
    }

    public void J() {
        if (this.N.getMaterial().disable_auto_deeplink.booleanValue()) {
            H();
        }
        a((int) this.M.getCurrentPositionWhenPlaying(), false);
        int E = E();
        com.sigmob.sdk.base.views.d dVar = this.G;
        if (dVar != null) {
            dVar.setduration(E);
        }
    }

    public void K() {
        if (this.f20535z0) {
            return;
        }
        this.f20535z0 = true;
        this.N.getMacroCommon().addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, "1");
        if (this.Y) {
            return;
        }
        B().a("complete", (int) this.M.getCurrentPositionWhenPlaying());
    }

    public final void L() {
        new Handler(Looper.getMainLooper()).post(new q());
    }

    public final void M() {
        com.sigmob.sdk.base.common.b0.a(PointCategory.PLAY_LOADING, (String) null, this.N, new b());
    }

    public boolean N() {
        com.sigmob.sdk.base.views.m mVar = this.f20507h0;
        if (mVar != null && mVar.c()) {
            return true;
        }
        try {
            boolean z10 = ((long) ((int) this.M.getCurrentPositionWhenPlaying())) / 1000 >= ((long) this.I);
            if (z10) {
                SigmobLog.d("showAble CompanionAds");
            }
            return z10;
        } catch (Throwable th2) {
            SigmobLog.e("shouldBeShowCompanionAds", th2);
            return true;
        }
    }

    public boolean O() {
        long currentPositionWhenPlaying;
        try {
            currentPositionWhenPlaying = (int) this.M.getCurrentPositionWhenPlaying();
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
        if (this.N.getSkipSeconds() > -1) {
            return (((float) currentPositionWhenPlaying) / 1000.0f) + 0.3f >= ((float) this.N.getSkipSeconds());
        }
        if (A() > 0) {
            return ((((float) A()) / 1000.0f) * ((float) this.N.getSkipPercent())) * 0.01f < ((float) currentPositionWhenPlaying) / 1000.0f;
        }
        return true;
    }

    public void P() {
        com.sigmob.sdk.base.views.m mVar;
        if (this.J || (mVar = this.f20507h0) == null) {
            return;
        }
        mVar.setVisibility(0);
        this.J = true;
    }

    public final void Q() {
        RelativeLayout relativeLayout = this.f20501b0;
        if (relativeLayout == null || relativeLayout.getVisibility() == 0) {
            return;
        }
        this.B = System.currentTimeMillis();
        this.f20501b0.setVisibility(0);
        this.C = "loading";
        int i10 = this.f20530x + 1;
        this.f20530x = i10;
        if (i10 > 2) {
            a((int) this.M.getCurrentPositionWhenPlaying(), true);
        } else {
            this.E.postDelayed(new u(), 5000L);
        }
    }

    public boolean R() {
        return E() <= 0;
    }

    public final void S() {
        if (this.N.getAd_type() == 4 || this.f20529w0 == null) {
            return;
        }
        int E = E();
        if (E <= 0) {
            this.f20529w0.setText("已获得奖励");
            return;
        }
        this.f20529w0.setText(E + "s后获取奖励");
    }

    public final void T() {
        int p10 = this.K.p();
        int A = A() - 2;
        if (p10 == 99999999) {
            p10 = 0;
        } else if (p10 == -99999999) {
            b(A);
            return;
        } else if (p10 <= 0) {
            p10 += A;
        }
        b(p10);
    }

    public final void U() {
        try {
            if (this.X) {
                return;
            }
            this.M.g();
            SigmobLog.i("videoView.pause()");
            this.W = (int) this.M.getCurrentPositionWhenPlaying();
            B().a("pause", (int) this.M.getCurrentPositionWhenPlaying());
            this.K.a(h(), this.W);
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    public final void V() {
        try {
            if (this.X) {
                return;
            }
            int currentPositionWhenPlaying = (int) this.M.getCurrentPositionWhenPlaying();
            if (this.W > 0 && currentPositionWhenPlaying == 0) {
                SigmobLog.d("video seek to " + this.W);
                this.M.a(this.W);
            }
            com.sigmob.sdk.base.views.d dVar = this.G;
            if ((dVar == null || dVar.getVisibility() != 0) && !this.f20515p0) {
                this.M.h();
            }
            if (this.W != -1) {
                this.K.b(h(), this.W);
            }
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    public final String a(List<String> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        int i10 = 0;
        do {
            if (i10 != 0) {
                sb2.append(',');
            }
            sb2.append(list.get(i10));
            i10++;
        } while (i10 < list.size());
        sb2.append(']');
        return sb2.toString();
    }

    @Override // com.sigmob.sdk.base.common.j
    public boolean b() {
        return false;
    }

    @Override // com.sigmob.sdk.videoAd.c, com.sigmob.sdk.base.common.j
    public void k() {
        super.k();
        MaterialMeta material = this.N.getMaterial();
        this.f20526v = ClientMetadata.getInstance().getInsetBottom();
        if (this.f20500a0) {
            I();
        } else {
            if (this.K == null) {
                throw new IllegalStateException("BaseVideoConfig does not have a video disk path");
            }
            if (this.f20508i0) {
                f(h(), 4);
            }
            Boolean bool = material.has_companion_endcard;
            if (bool != null && bool.booleanValue() && material.companion != null) {
                c(h(), 4);
                this.I = material.companion.show_delay_secs.intValue();
            }
            e(h(), 0);
            i(h(), 0);
            h(h(), 4);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.sigmob.sdk.videoAd.f("start", 0.0f));
            arrayList.add(new com.sigmob.sdk.videoAd.f("play_quarter", 0.25f));
            arrayList.add(new com.sigmob.sdk.videoAd.f("play_two_quarters", 0.5f));
            arrayList.add(new com.sigmob.sdk.videoAd.f("play_three_quarters", 0.75f));
            this.K.a(arrayList);
            a(IntentActions.ACTION_INTERSTITIAL_VOPEN);
        }
        a(h(), 4);
        s();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void l() {
        try {
            SigmobLog.d("VideoViewController onDestroy() called");
            com.sigmob.sdk.base.common.h.s().b(this);
            if (!this.f20502c0) {
                a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
            }
            if (this.B0 != null) {
                com.sigmob.sdk.base.common.h.n().b(this, this.B0);
            }
            com.sigmob.sdk.base.views.w wVar = this.f20519r0;
            if (wVar != null) {
                wVar.setOnClickListener(null);
                ViewUtil.removeFromParent(this.f20519r0);
            }
            com.sigmob.sdk.base.views.w wVar2 = this.f20517q0;
            if (wVar2 != null) {
                wVar2.setOnClickListener(null);
                ViewUtil.removeFromParent(this.f20517q0);
            }
            com.sigmob.sdk.nativead.a aVar = this.f20527v0;
            if (aVar != null) {
                aVar.a((WindNativeAdData.DislikeInteractionCallback) null);
                this.f20527v0.dismiss();
                this.f20527v0.b();
            }
            this.K.a();
            ImageLoader.ImageContainer imageContainer = this.f20506g0;
            if (imageContainer != null) {
                imageContainer.cancelRequest();
                this.f20506g0 = null;
            }
            com.sigmob.sdk.base.common.t tVar = this.P;
            if (tVar != null) {
                tVar.a();
                this.P = null;
            }
            com.sigmob.sdk.videoAd.i iVar = this.U;
            if (iVar != null) {
                iVar.a((i.a) null);
            }
            MediaMetadataRetriever mediaMetadataRetriever = this.Q;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            p0 p0Var = this.S;
            if (p0Var != null) {
                p0Var.setOnTouchListener(null);
            }
            com.sigmob.sdk.base.views.w wVar3 = this.T;
            if (wVar3 != null) {
                wVar3.setOnTouchListener(null);
            }
            p0 p0Var2 = this.f20503d0;
            if (p0Var2 != null) {
                p0Var2.setOnTouchListener(null);
            }
            com.sigmob.sdk.videoplayer.a aVar2 = this.M;
            if (aVar2 != null) {
                aVar2.f();
            }
            View view = this.O;
            if (view != null && (view instanceof com.sigmob.sdk.base.views.o)) {
                ((com.sigmob.sdk.base.views.o) view).setWebViewClickListener(null);
                ((com.sigmob.sdk.base.views.o) this.O).setLogoClickListener(null);
            }
            com.sigmob.sdk.base.views.z zVar = this.f20512m0;
            if (zVar != null) {
                zVar.dismiss();
                this.f20512m0.a();
                this.f20512m0 = null;
            }
            y.b bVar = this.f20521s0;
            if (bVar != null) {
                bVar.a();
                this.f20521s0 = null;
            }
            BaseAdUnit baseAdUnit = this.N;
            if (baseAdUnit != null) {
                baseAdUnit.destroy();
            }
            this.O = null;
            this.R = null;
            super.l();
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void m() {
        if (this.f20502c0) {
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
            return;
        }
        y.b bVar = this.f20521s0;
        if (bVar != null) {
            bVar.b();
        }
        if (this.f20500a0) {
            return;
        }
        U();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void n() {
        y.b bVar;
        if (!this.f20500a0 && this.f20527v0 == null) {
            V();
        }
        View view = this.O;
        if (view != null && (view instanceof com.sigmob.sdk.base.views.o)) {
            ((com.sigmob.sdk.base.views.o) view).resumeTimers();
        }
        this.f20525u0 = false;
        if (this.f20527v0 != null || (bVar = this.f20521s0) == null) {
            return;
        }
        bVar.c();
    }

    public void r() {
        com.sigmob.sdk.base.views.b bVar = new com.sigmob.sdk.base.views.b(h().getApplicationContext(), 0);
        this.f20520s = bVar;
        bVar.setId(ClientMetadata.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, Dips.dipsToIntPixels(16.0f, h()));
        com.sigmob.sdk.base.views.m mVar = this.f20507h0;
        if (mVar != null) {
            layoutParams.addRule(8, mVar.getId());
        } else {
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, 0, this.f20516q);
        }
        try {
            this.f20520s.a(this.N.getAd_source_logo());
            if (!this.N.getInvisibleAdLabel()) {
                this.f20520s.b(com.sigmob.sdk.base.g.e());
            }
        } catch (Throwable unused) {
        }
        i().addView(this.f20520s, layoutParams);
    }

    public final void s() {
        int widgetId = (int) this.N.getWidgetId(0);
        if (widgetId == 138731) {
            v();
            return;
        }
        if (widgetId == 138733) {
            u();
        } else if (widgetId == 138757) {
            t();
        } else {
            if (widgetId != 138758) {
                return;
            }
            w();
        }
    }

    public final void t() {
        this.f20523t0 = new c0(h());
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, h());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, h());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        y.f fVar = new y.f(h(), new w());
        this.f20521s0 = fVar;
        fVar.a(this.N.getSensitivity());
        this.f20521s0.c();
        i().addView(this.f20523t0, layoutParams);
    }

    public final void u() {
        this.f20523t0 = new k0(h());
        int dipsToIntPixels = Dips.dipsToIntPixels(92.0f, h());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, h());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        y.d dVar = new y.d(h(), new z(), y.e.SLOPE);
        this.f20521s0 = dVar;
        dVar.a(this.N.getSensitivity());
        this.f20521s0.c();
        i().addView(this.f20523t0, layoutParams);
    }

    public final void v() {
        this.f20523t0 = new n0(h());
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, h());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, h());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        y.d dVar = new y.d(h(), new y(), y.e.SWING);
        this.f20521s0 = dVar;
        dVar.a(this.N.getSensitivity());
        this.f20521s0.c();
        i().addView(this.f20523t0, layoutParams);
    }

    public final void w() {
        this.f20523t0 = new u0(h());
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, h());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, h());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        y.d dVar = new y.d(h(), new x(), y.e.WRING);
        this.f20521s0 = dVar;
        dVar.a(this.N.getSensitivity());
        this.f20521s0.c();
        i().addView(this.f20523t0, layoutParams);
    }

    public final void x() {
        try {
            this.V = this.K.c(A());
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    @SuppressLint({"DefaultLocale"})
    public final void y() {
        RelativeLayout relativeLayout = this.f20501b0;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        this.f20534z.add(String.format("%d", Long.valueOf(System.currentTimeMillis() - this.B)));
        this.A.add(String.format("%.2f", Float.valueOf(((int) this.M.getCurrentPositionWhenPlaying()) / 1000.0f)));
        this.C = "play";
        this.E.removeCallbacksAndMessages(null);
        this.f20501b0.setVisibility(4);
    }

    public final void d(Context context, int i10) {
        if (this.f20517q0 == null) {
            com.sigmob.sdk.base.views.w wVar = new com.sigmob.sdk.base.views.w(context);
            this.f20517q0 = wVar;
            wVar.setText("反馈");
            this.f20517q0.setOnClickListener(this.C0);
            this.f20517q0.setId(ClientMetadata.generateViewId());
            int dipsToIntPixels = Dips.dipsToIntPixels(3.0f, this.f17899b);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            layoutParams.addRule(0, this.S.getId());
            layoutParams.addRule(6, this.S.getId());
            layoutParams.setMargins(0, -dipsToIntPixels, 0, 0);
            i().addView(this.f20517q0, layoutParams);
        }
        com.sigmob.sdk.base.views.w wVar2 = this.f20517q0;
        if (wVar2 != null) {
            wVar2.setVisibility(i10);
        }
    }

    public final void e(Context context, int i10) {
        if (this.f20519r0 == null) {
            com.sigmob.sdk.base.views.w wVar = new com.sigmob.sdk.base.views.w(context);
            this.f20519r0 = wVar;
            wVar.setText("反馈");
            this.f20519r0.setId(ClientMetadata.generateViewId());
            this.f20519r0.setOnClickListener(this.C0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(22.0f, context));
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            int i11 = this.f20516q;
            layoutParams.setMargins(i11, i11 * 2, 0, 0);
            i().addView(this.f20519r0, layoutParams);
        }
        com.sigmob.sdk.base.views.w wVar2 = this.f20519r0;
        if (wVar2 != null) {
            wVar2.setVisibility(i10);
        }
    }

    public final void f(Context context, int i10) {
        q0 q0Var = new q0(context);
        this.R = q0Var;
        q0Var.setAnchorId(this.M.getId());
        this.R.setVisibility(i10);
        i().addView(this.R);
    }

    public final void g(Context context, int i10) {
        if (this.N.getRewardStyle() == 1) {
            this.f20529w0 = new com.sigmob.sdk.base.views.w(context);
            int E = E();
            if (E > 0) {
                this.f20529w0.setText(E + "s后获取奖励");
            } else {
                this.f20529w0.setText("已获得奖励");
                c(false);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(97.0f, context), Dips.dipsToIntPixels(22.0f, context));
            layoutParams.addRule(1, this.f20519r0.getId());
            int i11 = this.f20516q;
            layoutParams.setMargins(i11, i11 * 2, 0, 0);
            i().addView(this.f20529w0, layoutParams);
        }
    }

    public final void h(Context context, int i10) {
        com.sigmob.sdk.base.views.w wVar = new com.sigmob.sdk.base.views.w(context);
        this.T = wVar;
        wVar.setId(ClientMetadata.generateViewId());
        this.T.setVisibility(i10);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
        layoutParams.addRule(10);
        p0 p0Var = this.f20503d0;
        if (p0Var != null) {
            layoutParams.addRule(0, p0Var.getId());
            layoutParams.setMargins(0, this.f20516q * 2, 0, 0);
        }
        i().addView(this.T, layoutParams);
        this.T.setEnabled(false);
        this.T.setOnClickListener(new h());
        if ((this.N.getSkipPercent() != 0 || this.N.getSkipSeconds() >= 0) && this.N.getSkipSeconds() != 0) {
            return;
        }
        a(0, false);
    }

    public final void i(Context context, int i10) {
        p0 p0Var = new p0(context);
        this.f20503d0 = p0Var;
        p0Var.setId(ClientMetadata.generateViewId());
        this.f20503d0.setVisibility(i10);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
        layoutParams.addRule(4, this.f20519r0.getId());
        layoutParams.addRule(11);
        int i11 = this.f20516q;
        layoutParams.setMargins(i11, i11 * 2, i11, 0);
        i().addView(this.f20503d0, layoutParams);
        this.f20503d0.setOnTouchListener(new l());
        if (this.N.getIsMute() == 0) {
            this.f20503d0.b(ResourceUtil.getDrawableId(h(), "sig_image_video_unmute"));
        } else {
            this.f20503d0.b(ResourceUtil.getDrawableId(h(), "sig_image_video_mute"));
            this.M.setMute(true);
            this.f20504e0 = true;
        }
    }

    public final com.sigmob.sdk.videoplayer.a j(Context context, int i10) {
        if (this.N.getProxyVideoUrl() == null) {
            throw new IllegalStateException("BaseVideoConfig does not have a video disk path");
        }
        com.sigmob.sdk.videoplayer.a aVar = new com.sigmob.sdk.videoplayer.a(context);
        aVar.setVideoPlayerStatusListener(new a0(aVar));
        String proxyVideoUrl = this.N.getProxyVideoUrl();
        try {
            if (!this.F) {
                new Thread(new a()).start();
                this.f20522t = b(context);
            }
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
        aVar.setUp(proxyVideoUrl);
        c(proxyVideoUrl);
        aVar.setVisibility(i10);
        return aVar;
    }

    public void d(boolean z10) {
        if (this.A0) {
            return;
        }
        this.A0 = true;
        y();
        if (z10) {
            c(z10);
            b(z10);
            K();
        } else if (this.K.t()) {
            g().a();
            return;
        }
        if (!this.F) {
            if (z10) {
                T();
            } else {
                b((int) this.M.getCurrentPositionWhenPlaying());
            }
        }
        this.M.s();
        I();
        this.X = true;
        com.sigmob.sdk.base.common.t tVar = this.P;
        if (tVar != null) {
            tVar.a("show", 0);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:11|(4:12|13|(2:18|19)|22)|(3:24|25|(21:27|28|29|30|(1:65)(2:34|35)|36|37|38|(11:40|41|42|(2:57|(1:59)(1:60))|46|47|(1:49)|50|(1:52)(1:56)|53|54)|62|42|(1:44)|57|(0)(0)|46|47|(0)|50|(0)(0)|53|54))|71|29|30|(1:32)|65|36|37|38|(0)|62|42|(0)|57|(0)(0)|46|47|(0)|50|(0)(0)|53|54) */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f1, code lost:
    
        r11 = r2;
        r16 = r4;
        r12 = r5;
        r14 = -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fb A[Catch: all -> 0x0102, TRY_LEAVE, TryCatch #2 {all -> 0x0102, blocks: (B:38:0x00f7, B:40:0x00fb), top: B:37:0x00f7 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(android.content.Context r23, int r24) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoAd.n.c(android.content.Context, int):void");
    }

    public final void c(String str) {
        Uri parse = Uri.parse(str);
        if (parse == null || !parse.getHost().equalsIgnoreCase(com.sigmob.sdk.videocache.h.f20606j)) {
            return;
        }
        Matcher matcher = Pattern.compile("/(.*)").matcher(parse.getPath());
        if (matcher.find()) {
            this.B0 = matcher.group(1);
            com.sigmob.sdk.base.common.h.n().a(this, this.B0);
        }
    }

    public final void b(Context context, int i10) {
        if (this.S == null) {
            p0 p0Var = new p0(context);
            this.S = p0Var;
            p0Var.setId(ClientMetadata.generateViewId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            int i11 = this.f20516q;
            layoutParams.setMargins(i11, i11 * 2, i11, i11);
            i().addView(this.S, layoutParams);
            BaseAdUnit baseAdUnit = this.N;
            if (baseAdUnit != null && !TextUtils.isEmpty(baseAdUnit.getCloseCardHtmlData()) && !this.D0) {
                com.sigmob.sdk.base.views.z zVar = new com.sigmob.sdk.base.views.z(f(), this.N, this.K);
                this.f20512m0 = zVar;
                zVar.a(new f());
            }
            this.S.setOnTouchListener(new g());
            this.S.a(this.N);
            String d10 = this.K.d();
            if (d10 != null) {
                this.S.a(d10);
            }
        }
        p0 p0Var2 = this.S;
        if (p0Var2 != null) {
            p0Var2.setVisibility(i10);
        }
        d(h(), i10);
    }

    public void c(boolean z10) {
        if (this.N.getAd_type() == 4 || this.f20505f0) {
            return;
        }
        this.f20505f0 = true;
        int A = z10 ? A() : (int) this.M.getCurrentPositionWhenPlaying();
        a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
        B().a("reward", A);
        this.K.b(h().getApplicationContext(), A, A(), a());
    }

    public final ImageView b(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        return imageView;
    }

    public void b(String str) {
        if ("start".equals(str)) {
            a(IntentActions.ACTION_INTERSTITIAL_SHOW);
            a(IntentActions.ACTION_REWARDED_VIDEO_PLAY);
        }
        if (B() != null) {
            B().a(str, (int) this.M.getCurrentPositionWhenPlaying());
        }
    }

    public final void b(boolean z10) {
        if (this.f20531x0 || this.N.getAd_type() == 4) {
            return;
        }
        this.f20531x0 = true;
        int A = z10 ? A() : (int) this.M.getCurrentPositionWhenPlaying();
        B().a("finish", A);
        this.K.b(h().getApplicationContext(), A, A(), a());
    }

    public final void b(int i10) {
        try {
            new Thread(new j(i10)).start();
        } catch (RuntimeException e10) {
            SigmobLog.e(e10.getMessage());
        }
    }

    public final void a(Context context, int i10) {
        if (this.G != null) {
            return;
        }
        com.sigmob.sdk.base.views.d dVar = new com.sigmob.sdk.base.views.d(context, this.K.m());
        this.G = dVar;
        dVar.setVisibility(i10);
        i().addView(this.G);
        this.G.setDialogListener(new c());
    }

    public void a(Context context) {
        this.f20501b0 = new RelativeLayout(context);
        ImageView imageView = new ImageView(context);
        imageView.setImageBitmap(com.sigmob.sdk.base.views.s.LOADING.b());
        imageView.setId(ClientMetadata.generateViewId());
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 3600000, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(8000000);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        imageView.setAnimation(rotateAnimation);
        this.f20501b0.addView(imageView, layoutParams);
        this.f20501b0.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        i().addView(this.f20501b0, layoutParams2);
    }

    @Override // com.sigmob.sdk.base.common.h.e
    public void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit.getUuid().equals(this.N.getUuid()) && baseAdUnit.isEndCardIndexExist()) {
            new Handler(Looper.getMainLooper()).post(new r());
        }
    }

    public final View a(Context context, com.sigmob.sdk.videoAd.i iVar, int i10) {
        Preconditions.NoThrow.checkNotNull(context);
        if (iVar == null) {
            View view = new View(context);
            view.setVisibility(4);
            return view;
        }
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setGravity(17);
        i().addView(relativeLayout, 0, new RelativeLayout.LayoutParams(-1, -1));
        com.sigmob.sdk.base.views.o a10 = a(context, iVar);
        a10.setVisibility(i10);
        relativeLayout.addView(a10, new LinearLayout.LayoutParams(-1, -1));
        return a10;
    }

    public final com.sigmob.sdk.base.views.o a(Context context, com.sigmob.sdk.videoAd.i iVar) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(iVar);
        Preconditions.NoThrow.checkNotNull(iVar.a());
        com.sigmob.sdk.base.views.o a10 = com.sigmob.sdk.base.views.o.a(context, this.N.getAd_source_logo(), false, this.N.getInvisibleAdLabel());
        a10.addJavascriptInterface(new b0(), "sigVersion");
        a10.setWebViewClickListener(new C0623n());
        a10.setDownloadListener(new o());
        a10.setAdUnit(this.N);
        a10.setWebViewClient(new p());
        iVar.a().a(a10);
        a10.a((o.a) null);
        return a10;
    }

    @Override // com.sigmob.sdk.base.common.h.e
    public BaseAdUnit a() {
        return this.N;
    }

    public final void a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        boolean z10;
        this.N.getClickCommon().click_area = ClickCommon.CLICK_AREA_MATERIAL;
        this.N.getClickCommon().click_scene = "ad";
        ClickAreaSetting clickAreaSetting = this.N.getClickAreaSetting();
        float floatValue = clickAreaSetting.left.floatValue() * ClientMetadata.getInstance().getDisplayMetrics().widthPixels;
        float floatValue2 = (1.0f - clickAreaSetting.right.floatValue()) * ClientMetadata.getInstance().getDisplayMetrics().widthPixels;
        float floatValue3 = clickAreaSetting.top.floatValue() * ClientMetadata.getInstance().getDisplayMetrics().heightPixels;
        float floatValue4 = (1.0f - clickAreaSetting.bottom.floatValue()) * ClientMetadata.getInstance().getDisplayMetrics().heightPixels;
        if (floatValue >= motionEvent2.getRawX() || motionEvent2.getRawX() >= floatValue2 || floatValue3 >= motionEvent2.getRawY() || motionEvent2.getRawY() >= floatValue4) {
            z10 = false;
        } else {
            SigMacroCommon macroCommon = this.N.getMacroCommon();
            z10 = true;
            if (macroCommon instanceof SigMacroCommon) {
                macroCommon.addMarcoKey(SigMacroCommon._PROGRESS_, String.valueOf(((int) D()) * 100));
                macroCommon.updateClickMarco(motionEvent, motionEvent2, true);
                this.f20518r = macroCommon.getCoordinate();
            }
            if (this.U == null) {
                H();
            }
            this.K.a(com.sigmob.sdk.base.a.VIDEO_CLICK, this.f20518r, true);
        }
        com.sigmob.sdk.base.common.b0.a(this.N, motionEvent2, "useless_video_click", z10);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(int i10, int i11, Intent intent) {
        if (i11 == -1) {
            g().a();
        }
    }

    @Override // com.sigmob.sdk.base.common.z
    public void a(boolean z10, com.sigmob.sdk.base.a aVar) {
        com.sigmob.sdk.base.common.t B;
        int currentPositionWhenPlaying;
        String str;
        this.D0 = true;
        L();
        if (z10) {
            int i10 = s.f20564b[aVar.ordinal()];
            if (i10 == 1) {
                ClickCommon clickCommon = this.N.getClickCommon();
                com.sigmob.sdk.base.common.b0.a(com.sigmob.sdk.base.a.COMPANION, "click", this.N, clickCommon.isDeeplink, clickCommon.clickUrl, clickCommon.clickCoordinate, A());
                B = B();
                currentPositionWhenPlaying = (int) this.M.getCurrentPositionWhenPlaying();
                str = com.sigmob.sdk.base.common.a.f17670w;
            } else if (i10 == 2) {
                ClickCommon clickCommon2 = this.N.getClickCommon();
                com.sigmob.sdk.base.common.b0.a(com.sigmob.sdk.base.a.VIDEO_CLICK, "click", this.N, clickCommon2.isDeeplink, clickCommon2.clickUrl, clickCommon2.clickCoordinate, A());
                B = B();
                currentPositionWhenPlaying = (int) this.M.getCurrentPositionWhenPlaying();
                str = "full_video_click";
            } else if (i10 != 3) {
                ClickCommon clickCommon3 = this.N.getClickCommon();
                com.sigmob.sdk.base.common.b0.a(com.sigmob.sdk.base.a.ENDCARD, "click", this.N, clickCommon3.isDeeplink, clickCommon3.clickUrl, clickCommon3.clickCoordinate, A());
                B = B();
                currentPositionWhenPlaying = (int) this.M.getCurrentPositionWhenPlaying();
                str = "click";
            } else {
                B = B();
                currentPositionWhenPlaying = (int) this.M.getCurrentPositionWhenPlaying();
                str = com.sigmob.sdk.base.common.a.f17658k;
            }
            B.a(str, currentPositionWhenPlaying);
        }
    }

    @Override // com.sigmob.sdk.videocache.d
    public void a(String str, Throwable th2) {
        SigmobLog.e("url", th2);
        com.sigmob.sdk.base.common.b0.a("video", 0, th2.getMessage(), this.N);
        d(false);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
        if (this.K != null && this.U == null) {
            com.sigmob.sdk.videoAd.i g10 = com.sigmob.sdk.videoAd.a.g(this.N);
            this.U = g10;
            g10.a(this.K);
        }
        if (B() != null) {
            B().a("rotation", (int) this.M.getCurrentPositionWhenPlaying());
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
        try {
            bundle.putBoolean(f20494k, this.X);
            bundle.putInt(f20493j, this.W);
            bundle.putBoolean(f20495l, this.f20500a0);
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    public final void a(int i10) {
        if (this.f20514o0 == null) {
            com.sigmob.sdk.base.views.q qVar = new com.sigmob.sdk.base.views.q(f(), this.N);
            this.f20514o0 = qVar;
            qVar.a(new m(i10));
        }
        com.sigmob.sdk.base.views.q qVar2 = this.f20514o0;
        if (qVar2 == null || !qVar2.e() || this.f20515p0) {
            return;
        }
        this.f20514o0.show();
        this.f20515p0 = true;
    }

    public final void a(int i10, boolean z10) {
        com.sigmob.sdk.base.views.w wVar = this.T;
        if (wVar == null || this.f20533y0) {
            return;
        }
        this.f20533y0 = true;
        wVar.setText("跳过");
        this.T.setEnabled(true);
        ValueAnimator duration = ValueAnimator.ofInt(Dips.dipsToIntPixels(22.0f, h()), Dips.dipsToIntPixels(45.0f, h())).setDuration(300L);
        duration.addUpdateListener(new i());
        duration.start();
        this.T.setVisibility(0);
        B().a(z10, i10);
        B().a("show_skip", i10);
    }
}
