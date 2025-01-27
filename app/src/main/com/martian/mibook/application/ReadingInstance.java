package com.martian.mibook.application;

import aa.e;
import aa.f;
import aa.g;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import ba.j;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTaskList;
import com.martian.libfeedback.request.FeedbackInfoParams;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libsliding.slider.SimSlider;
import com.martian.mibook.R;
import com.martian.rpauth.MartianRPUserManager;
import ge.b;
import l9.t0;

/* loaded from: classes3.dex */
public class ReadingInstance {
    public static final String A = "pref_auto_slide_timeout";
    public static final String B = "PREF_SLIDER_CACHE_ENABLE";
    public static final String C = "PREF_SLIDER_CLICK_SCROLL_ENABLE";
    public static final String D = "pref_reading_slider_mode";
    public static final String E = "pref_reading_click_rule";
    public static final String F = "pref_fontsize";
    public static final String G = "PREF_AUDO_SLIDE_SPEED";
    public static final String H = "PREF_TTS_SPEED";
    public static final String I = "pref_line_spacing_multiplier";
    public static final String J = "pref_screen_orientation";

    /* renamed from: v */
    public static ReadingInstance f13372v = null;

    /* renamed from: w */
    public static final String f13373w = "pref_reading_screen_timeout";

    /* renamed from: x */
    public static final String f13374x = "pref_ads_hide_timeout";

    /* renamed from: y */
    public static final String f13375y = "pref_ads_dialog_last_time";

    /* renamed from: z */
    public static final String f13376z = "pref_auto_read_ads_timeout";

    /* renamed from: b */
    public boolean f13378b;

    /* renamed from: i */
    public long f13385i;

    /* renamed from: j */
    public int f13386j;

    /* renamed from: k */
    public Boolean f13387k;

    /* renamed from: q */
    public Integer f13393q;

    /* renamed from: r */
    public boolean f13394r;

    /* renamed from: s */
    public int f13395s;

    /* renamed from: a */
    public int f13377a = ScreenOffTime.Init.getTime();

    /* renamed from: c */
    public int f13379c = 127;

    /* renamed from: d */
    public int f13380d = 127;

    /* renamed from: e */
    public boolean f13381e = true;

    /* renamed from: f */
    public boolean f13382f = true;

    /* renamed from: g */
    public long f13383g = -1;

    /* renamed from: h */
    public long f13384h = -1;

    /* renamed from: l */
    public int f13388l = -1;

    /* renamed from: m */
    public int f13389m = -1;

    /* renamed from: n */
    public int f13390n = -1;

    /* renamed from: o */
    public int f13391o = -1;

    /* renamed from: p */
    public int f13392p = -1;

    /* renamed from: t */
    public final int[] f13396t = {14, 16, 18, 20, 21, 22, 23, 24, 25, 26, 28, 32, 36, 40};

    /* renamed from: u */
    public final int[] f13397u = {52, 54, 54, 56, 56, 56, 58, 58, 58, 58, 60, 60, 62, 62};

    public enum ClickRule {
        RULE_1(0),
        RULE_2(1),
        RULE_3(2),
        RULE_4(3),
        RULE_5(4),
        RULE_6(5);

        private final int clickRuleValue;

        ClickRule(int i10) {
            this.clickRuleValue = i10;
        }

        public int getClickRuleValue() {
            return this.clickRuleValue;
        }
    }

    public enum ConfigType {
        FontSize(0),
        Typeface(1),
        LineSpace(2);

        private final int type;

        ConfigType(int i10) {
            this.type = i10;
        }

        public int getType() {
            return this.type;
        }
    }

    public enum LinkAd {
        Ad("ad"),
        Video("video"),
        Vip("vip");

        private final String type;

        LinkAd(String str) {
            this.type = str;
        }

        public String getType() {
            return this.type;
        }
    }

    public enum ScreenOffTime {
        Init(-1),
        System(0),
        TwoMinutes(120000),
        FiveMinutes(m2.a.f28273a),
        TenMinutes(600000),
        AlwaysLight(6000000);

        private final int mValue;

        ScreenOffTime(int i10) {
            this.mValue = i10;
        }

        public int getTime() {
            return this.mValue;
        }
    }

    public enum SlideMode {
        PAGER_SLIDER(0),
        OVERLAPPED_SLIDER(1),
        SCROLL_SLIDER(2),
        STATIC_SLIDER(3),
        SIM_SLIDER(4);

        private final int slideMode;

        SlideMode(int i10) {
            this.slideMode = i10;
        }

        public int getSlideMode() {
            return this.slideMode;
        }
    }

    public class a extends d8.b {

        /* renamed from: a */
        public final /* synthetic */ d f13398a;

        public a(d dVar) {
            this.f13398a = dVar;
        }

        @Override // d8.b, d8.a
        public void a() {
            if (ReadingInstance.this.f13393q == null) {
                ReadingInstance.this.f13393q = Integer.valueOf(MiConfigSingleton.b2().c2().getInterstitialAdMinInterval());
            } else {
                ReadingInstance.this.D0(0);
            }
            ReadingInstance.this.f13394r = false;
            d dVar = this.f13398a;
            if (dVar != null) {
                dVar.a();
            }
        }

        @Override // d8.b, d8.a
        public void b(AdConfig adConfig) {
            d dVar = this.f13398a;
            if (dVar != null) {
                dVar.onAdExposed();
            }
        }

        @Override // d8.b, d8.a
        public void i(AdConfig adConfig, AppTaskList appTaskList) {
            ReadingInstance.this.D0(appTaskList.getApps().get(0).getEcpm());
            ReadingInstance.this.f13394r = false;
        }

        @Override // d8.b, d8.a
        public void l(AdConfig adConfig) {
            ReadingInstance readingInstance = ReadingInstance.this;
            readingInstance.f13393q = Integer.valueOf(Math.min(readingInstance.f13393q.intValue(), MiConfigSingleton.b2().c2().getInterstitialAdMinInterval()));
        }
    }

    public class b extends b9.b {

        /* renamed from: i */
        public final /* synthetic */ c f13400i;

        /* renamed from: j */
        public final /* synthetic */ boolean f13401j;

        /* renamed from: k */
        public final /* synthetic */ Activity f13402k;

        public b(c cVar, boolean z10, Activity activity) {
            this.f13400i = cVar;
            this.f13401j = z10;
            this.f13402k = activity;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            c cVar2 = this.f13400i;
            if (cVar2 != null) {
                cVar2.onResultError(cVar);
            }
            if (this.f13401j) {
                t0.b(this.f13402k, cVar.d());
            }
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(Integer num) {
            c cVar = this.f13400i;
            if (cVar != null) {
                cVar.success();
            }
            if (this.f13401j) {
                t0.b(this.f13402k, "上报成功");
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public interface c {
        void onResultError(x8.c cVar);

        void success();
    }

    public interface d {
        void a();

        void onAdExposed();
    }

    public static ReadingInstance z() {
        if (f13372v == null) {
            f13372v = new ReadingInstance();
        }
        return f13372v;
    }

    public float A(Context context) {
        if (this.f13392p == -1) {
            this.f13392p = j.f(context, I, 165);
        }
        int i10 = this.f13392p;
        if (i10 < 100) {
            this.f13392p = i10 * 10;
        }
        return this.f13392p / 100.0f;
    }

    public boolean A0(Context context) {
        return j.h(context, f13376z, -1L) < MartianRPUserManager.a();
    }

    public int B(Context context) {
        if (this.f13392p == -1) {
            this.f13392p = j.f(context, I, 165);
        }
        int i10 = this.f13392p;
        if (i10 < 100) {
            this.f13392p = i10 * 10;
        }
        return this.f13392p;
    }

    public boolean B0(Context context) {
        return j.d(context, context.getResources().getString(R.string.pref_show_chapter_comment), true);
    }

    public f C(Context context) {
        int E2 = E(context);
        return E2 == SlideMode.OVERLAPPED_SLIDER.getSlideMode() ? new aa.c() : E2 == SlideMode.SCROLL_SLIDER.getSlideMode() ? new e() : E2 == SlideMode.PAGER_SLIDER.getSlideMode() ? new aa.d() : E2 == SlideMode.STATIC_SLIDER.getSlideMode() ? new g() : E2 == SlideMode.SIM_SLIDER.getSlideMode() ? new SimSlider() : new aa.c();
    }

    public boolean C0(Context context) {
        if (!ConfigSingleton.D().E0("pref_menu_entrance")) {
            return j.d(context, context.getResources().getString(R.string.pref_show_menu), true);
        }
        boolean z10 = ConfigSingleton.D().Y() <= 1;
        t0(context, z10);
        return z10;
    }

    public int D(Context context) {
        if (this.f13377a == ScreenOffTime.Init.getTime()) {
            this.f13377a = j.f(context, f13373w, ScreenOffTime.FiveMinutes.getTime());
        }
        return this.f13377a;
    }

    public final void D0(int i10) {
        if (i10 <= 0) {
            i10 = 500;
        }
        this.f13393q = Integer.valueOf(Math.max(MiConfigSingleton.b2().c2().getInterstitialAdMinInterval(), (MiConfigSingleton.b2().c2().getInterstitialAdBaseInterval() * MiConfigSingleton.b2().c2().getInterstitialAdBaseEcpm()) / i10));
    }

    public int E(Context context) {
        if (this.f13388l < 0) {
            this.f13388l = j.f(context, D, SlideMode.OVERLAPPED_SLIDER.getSlideMode());
        }
        return this.f13388l;
    }

    public String F(Context context, int i10) {
        return i10 == SlideMode.OVERLAPPED_SLIDER.getSlideMode() ? context.getString(R.string.overlapped_slider) : i10 == SlideMode.SCROLL_SLIDER.getSlideMode() ? context.getString(R.string.scroll_slider) : i10 == SlideMode.PAGER_SLIDER.getSlideMode() ? context.getString(R.string.page_slider) : i10 == SlideMode.STATIC_SLIDER.getSlideMode() ? context.getString(R.string.static_slider) : i10 == SlideMode.SIM_SLIDER.getSlideMode() ? context.getString(R.string.sim_slider) : context.getString(R.string.overlapped_slider);
    }

    public b.C0699b G(Context context) {
        return g(x(context), B(context));
    }

    public int H(Context context) {
        return j.f(context, H, 100);
    }

    public boolean I() {
        if (!n()) {
            return false;
        }
        this.f13386j++;
        this.f13385i = System.currentTimeMillis() + (MiConfigSingleton.b2().c2().getAdIntervalExtentMinutes() * 60000);
        return true;
    }

    public boolean J(Context context) {
        int x10 = x(context);
        if (x10 >= 40) {
            return false;
        }
        h0(context, x10 + ((x10 < 20 || x10 > 25) ? x10 >= 28 ? 4 : 2 : 1));
        return true;
    }

    public boolean K(Context context) {
        return j.d(context, context.getString(R.string.auto_add_bookshelf_pref_key), true);
    }

    public boolean L(Context context) {
        return j.d(context, context.getString(R.string.global_slide_next_pref_key), false);
    }

    public boolean M(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public boolean N(Context context) {
        if (P(context)) {
            return false;
        }
        return j.d(context, context.getString(R.string.pull_down_add_bookmark_pref_key), true);
    }

    public boolean O(Context context) {
        return j.d(context, J, true);
    }

    public boolean P(Context context) {
        return E(context) == SlideMode.SCROLL_SLIDER.getSlideMode();
    }

    public boolean Q(Context context) {
        return j.d(context, context.getResources().getString(R.string.pref_show_progress_time_power_key), true);
    }

    public boolean R(Context context) {
        return j.d(context, context.getResources().getString(R.string.pref_show_bottom_text_tips_key), true);
    }

    public boolean S(Context context) {
        return E(context) == SlideMode.SIM_SLIDER.getSlideMode();
    }

    public boolean T(Context context) {
        return j.d(context, B, false);
    }

    public boolean U(Context context) {
        if (this.f13387k == null) {
            this.f13387k = Boolean.valueOf(j.d(context, C, true));
        }
        return this.f13387k.booleanValue();
    }

    public boolean V() {
        return ConfigSingleton.D().H0() ? this.f13382f : this.f13381e;
    }

    public void W(int i10) {
        Integer num = this.f13393q;
        if (num == null || num.intValue() <= 0) {
            this.f13395s = i10;
            return;
        }
        int i11 = this.f13395s;
        if (i11 > i10) {
            this.f13395s = i10;
            this.f13393q = Integer.valueOf(this.f13393q.intValue() - this.f13395s);
        } else {
            this.f13395s = i10;
            this.f13393q = Integer.valueOf(this.f13393q.intValue() - (i10 - i11));
        }
    }

    public void X(Context context) {
        j.p(context, J, !O(context));
    }

    public void Y(Context context, int i10) {
        j.m(context, H, i10);
    }

    public void Z(Context context, int i10) {
        if (ConfigSingleton.D().B0()) {
            i10 = 1;
        }
        m0(context, i10);
        long max = Math.max(this.f13383g, MartianRPUserManager.a()) + (i10 * 60 * 1000);
        this.f13383g = max;
        j.n(context, f13374x, max);
    }

    public void a0(Context context, boolean z10) {
        j.p(context, context.getResources().getString(R.string.pref_show_bonus_key), z10);
    }

    public void b0(Context context, boolean z10) {
        j.p(context, context.getResources().getString(R.string.always_show_virtual_key_pref_key), z10);
    }

    public void c0(Context context, boolean z10) {
        j.p(context, context.getString(R.string.auto_add_bookshelf_pref_key), z10);
    }

    public void d0(Context context) {
        j.n(context, A, MartianRPUserManager.a() + 86400000);
    }

    public boolean e(Context context) {
        return j.d(context, context.getResources().getString(R.string.pref_show_bonus_key), true);
    }

    public void e0(Context context, int i10) {
        this.f13391o = i10;
        j.m(context, G, i10);
    }

    public boolean f(Context context) {
        return j.d(context, context.getResources().getString(R.string.always_show_virtual_key_pref_key), false);
    }

    public void f0(int i10) {
        if (ConfigSingleton.D().H0()) {
            this.f13380d = i10;
        } else {
            this.f13379c = i10;
        }
    }

    public final b.C0699b g(int i10, int i11) {
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int[] iArr = this.f13396t;
            if (i13 >= iArr.length) {
                break;
            }
            if (iArr[i13] == i10) {
                i12 = i13;
                break;
            }
            i13++;
        }
        b.C0699b c0699b = new b.C0699b();
        c0699b.D(i10);
        c0699b.J(i10 + 4);
        c0699b.G(this.f13397u[i12]);
        c0699b.C(i11 / 100.0f);
        if (i11 == 145) {
            c0699b.F((((i11 - 100) * 1.65f) / 100.0f) + 1.0f);
            c0699b.I(1.45f);
        } else if (i11 == 165) {
            c0699b.F((((i11 - 100) * 1.75f) / 100.0f) + 1.0f);
            c0699b.I(1.65f);
        } else if (i11 != 185) {
            c0699b.F(2.1375f);
            c0699b.I(1.65f);
        } else {
            c0699b.F((((i11 - 100) * 1.85f) / 100.0f) + 1.0f);
            c0699b.I(1.8f);
        }
        return c0699b;
    }

    public void g0(Context context, int i10) {
        j.m(context, E, i10);
        this.f13389m = i10;
    }

    public boolean h(Context context) {
        long j10 = this.f13384h;
        if (j10 > 0) {
            return j10 < MartianRPUserManager.a();
        }
        if (MiConfigSingleton.b2().c2().getAdsDialogIntervalMinutes().intValue() <= 0) {
            return false;
        }
        long h10 = j.h(context, f13375y, -1L);
        this.f13384h = h10;
        if (h10 == -1) {
            long a10 = MartianRPUserManager.a() + 60000;
            this.f13384h = a10;
            j.n(context, f13375y, a10);
        }
        return this.f13384h < MartianRPUserManager.a();
    }

    public final void h0(Context context, int i10) {
        j.m(context, F, i10);
        this.f13390n = i10;
    }

    public boolean i(Context context) {
        return j.d(context, context.getString(R.string.volume_slide_page_pref_key), true);
    }

    public void i0(Context context, boolean z10) {
        j.p(context, context.getString(R.string.global_slide_next_pref_key), z10);
    }

    public boolean j(Activity activity, d dVar) {
        Integer num;
        if (this.f13394r || ((num = this.f13393q) != null && num.intValue() > 0)) {
            return false;
        }
        int interstitialAdEnquiryEcpm2 = this.f13393q == null ? MiConfigSingleton.b2().c2().getInterstitialAdEnquiryEcpm2() : 0;
        this.f13394r = true;
        MiConfigSingleton.b2().H1().E(activity, interstitialAdEnquiryEcpm2, false, new a(dVar));
        return true;
    }

    public void j0(boolean z10) {
        if (ConfigSingleton.D().H0()) {
            this.f13382f = z10;
        } else {
            this.f13381e = z10;
        }
    }

    public void k(@NonNull Activity activity, Handler handler, @NonNull Runnable runnable) {
        int D2 = D(activity);
        if (D2 == ScreenOffTime.System.getTime()) {
            return;
        }
        if (handler != null) {
            handler.removeCallbacks(runnable);
            handler.postDelayed(runnable, D2);
        }
        if (this.f13378b) {
            return;
        }
        activity.getWindow().addFlags(128);
        this.f13378b = true;
    }

    public void k0(Context context, float f10) {
        int i10 = (int) (f10 * 100.0f);
        this.f13392p = i10;
        j.m(context, I, i10);
    }

    public void l(@NonNull Activity activity, Handler handler, @NonNull Runnable runnable) {
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
        if (this.f13378b) {
            activity.getWindow().clearFlags(128);
            this.f13378b = false;
        }
    }

    public void l0(int i10) {
        this.f13393q = Integer.valueOf(i10);
    }

    public boolean m(Context context) {
        int x10 = x(context);
        if (x10 <= 14) {
            return false;
        }
        h0(context, x10 - ((x10 < 21 || x10 > 26) ? x10 > 28 ? 4 : 2 : 1));
        return true;
    }

    public void m0(Context context, int i10) {
        long j10 = i10 * 60 * 1000;
        this.f13384h = MartianRPUserManager.a() + j10;
        j.n(context, f13375y, MartianRPUserManager.a() + j10);
    }

    public boolean n() {
        return this.f13386j < MiConfigSingleton.b2().c2().getMaxAdIntervalExtra();
    }

    public void n0(Context context, boolean z10) {
        j.p(context, context.getString(R.string.pull_down_add_bookmark_pref_key), z10);
    }

    public boolean o() {
        return MiConfigSingleton.b2().c2().getInterstitialAdEnquiryEcpm2() > 0;
    }

    public void o0(Context context, int i10) {
        this.f13388l = i10;
        j.m(context, D, i10);
    }

    public void p(Activity activity, String str, String str2, int i10, int i11, boolean z10) {
        q(activity, str, str2, i10, i11, z10, null);
    }

    public void p0(Context context, ScreenOffTime screenOffTime, boolean z10) {
        this.f13377a = screenOffTime.getTime();
        if (z10) {
            j.m(context, f13373w, screenOffTime.getTime());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void q(Activity activity, String str, String str2, int i10, int i11, boolean z10, c cVar) {
        b bVar = new b(cVar, z10, activity);
        ((FeedbackInfoParams) bVar.k()).setSubject(str);
        ((FeedbackInfoParams) bVar.k()).setExt(str2);
        ((FeedbackInfoParams) bVar.k()).setCategoryId(Integer.valueOf(i10));
        ((FeedbackInfoParams) bVar.k()).setSubCategoryId(Integer.valueOf(i11));
        bVar.j();
    }

    public void q0(Context context, boolean z10) {
        j.p(context, context.getResources().getString(R.string.pref_show_progress_time_power_key), z10);
    }

    public long r() {
        return this.f13383g;
    }

    public void r0(Context context, boolean z10) {
        j.p(context, context.getResources().getString(R.string.pref_show_bottom_text_tips_key), z10);
    }

    public int s() {
        if (this.f13386j > 0 && t() < System.currentTimeMillis()) {
            this.f13386j = 0;
        }
        return this.f13386j;
    }

    public void s0(Context context, boolean z10) {
        j.p(context, context.getResources().getString(R.string.pref_show_chapter_comment), z10);
    }

    public long t() {
        return this.f13385i;
    }

    public void t0(Context context, boolean z10) {
        j.p(context, context.getResources().getString(R.string.pref_show_menu), z10);
    }

    public int u(Context context) {
        if (this.f13391o == -1) {
            this.f13391o = j.f(context, G, 60);
        }
        return this.f13391o;
    }

    public void u0(Context context, boolean z10) {
        j.p(context, B, z10);
    }

    public int v() {
        return ConfigSingleton.D().H0() ? this.f13380d : this.f13379c;
    }

    public void v0(Context context, boolean z10) {
        this.f13387k = Boolean.valueOf(z10);
        j.p(context, C, z10);
    }

    public int w(Context context) {
        if (this.f13389m < 0) {
            this.f13389m = j.f(context, E, z().L(context) ? 1 : 0);
        }
        return this.f13389m;
    }

    public void w0(Context context) {
        j.n(context, f13376z, MartianRPUserManager.a() + 21600000);
    }

    public int x(Context context) {
        if (this.f13390n == -1) {
            this.f13390n = j.f(context, F, 23);
        }
        return this.f13390n;
    }

    public void x0(Context context, boolean z10) {
        j.p(context, context.getString(R.string.volume_slide_page_pref_key), z10);
    }

    public int y(Context context) {
        int D2 = D(context);
        if (D2 == ScreenOffTime.System.getTime()) {
            return 0;
        }
        if (D2 == ScreenOffTime.FiveMinutes.getTime()) {
            return 1;
        }
        if (D2 == ScreenOffTime.TenMinutes.getTime()) {
            return 2;
        }
        return D2 == ScreenOffTime.AlwaysLight.getTime() ? 3 : 0;
    }

    public boolean y0(Context context) {
        if (this.f13383g < 0) {
            this.f13383g = j.h(context, f13374x, 0L);
        }
        long j10 = this.f13383g;
        return j10 > 0 && j10 >= MartianRPUserManager.a();
    }

    public boolean z0(Context context) {
        return j.h(context, A, -1L) < MartianRPUserManager.a();
    }
}
