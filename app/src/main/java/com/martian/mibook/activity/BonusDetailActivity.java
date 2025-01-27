package com.martian.mibook.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.appwall.request.MartianLuckyDrawParams;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.activity.j1;
import com.martian.libmars.activity.k1;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.activity.account.IncomeActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.o0;
import com.martian.mibook.data.XianWanGame;
import com.martian.mibook.e.l7;
import com.martian.mibook.e.m7;
import com.martian.mibook.j.s2;
import com.martian.mibook.lib.account.request.auth.FinishExtraBonusParams;
import com.martian.mibook.lib.account.request.auth.StartExtraBonusParams;
import com.martian.mibook.lib.account.response.ExtraBonus;
import com.martian.mibook.lib.account.response.MissionItem;
import com.martian.mibook.lib.account.response.UrlMission;
import com.martian.mibook.lib.account.response.UrlMissionResult;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbookhd.R;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class BonusDetailActivity extends com.martian.mibook.activity.base.n {
    private static final String Q = "BONUS_POLL_DATA";
    private com.martian.mibook.b.b R;
    private com.martian.mibook.e.g S;
    private h T;
    private AppTask V;
    private MissionItem Y;
    private boolean U = true;
    private boolean W = true;
    private long X = -1;
    private EXTRA_VIDEO_STATUS Z = EXTRA_VIDEO_STATUS.IDLE;
    private boolean a0 = false;
    private int b0 = 0;
    private Long c0 = 0L;

    public enum EXTRA_VIDEO_STATUS {
        IDLE,
        START,
        LOADING,
        PLAYING,
        SUCCESS,
        FAIL
    }

    class a extends b.d.a.k.b {
        a() {
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void b(AdConfig config) {
            BonusDetailActivity.this.S.f11977b.setVisibility(8);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            if (appTaskList == null || appTaskList.getApps() == null || appTaskList.getApps().size() <= 0) {
                return;
            }
            BonusDetailActivity.this.V = appTaskList.getApps().get(0);
            BonusDetailActivity bonusDetailActivity = BonusDetailActivity.this;
            bonusDetailActivity.H3(bonusDetailActivity.V);
        }
    }

    class b extends b.d.a.k.b {
        b() {
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void e(AdConfig config, boolean verify) {
            BonusDetailActivity.this.z3();
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            BonusDetailActivity.this.k1("领取失败");
        }
    }

    class c extends com.martian.mibook.lib.account.d.q.l0 {
        c(j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            BonusDetailActivity.this.k1(errorResult.d());
            BonusDetailActivity.this.A3();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(Boolean success) {
            if (success == null || !success.booleanValue()) {
                BonusDetailActivity.this.A3();
            } else {
                BonusDetailActivity.this.G3();
            }
        }
    }

    class d extends b.d.a.k.b {
        d() {
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void e(AdConfig config, boolean verify) {
            BonusDetailActivity.this.f3();
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            BonusDetailActivity.this.A3();
        }
    }

    class e extends com.martian.mibook.lib.account.d.q.l {
        e(j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            BonusDetailActivity.this.k1(errorResult.d());
            BonusDetailActivity.this.A3();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(ExtraBonus extraBonus) {
            if (extraBonus == null || extraBonus.getCoins().intValue() <= 0) {
                BonusDetailActivity.this.k1("获取奖励失败");
                BonusDetailActivity.this.A3();
                return;
            }
            BonusDetailActivity.this.Z = EXTRA_VIDEO_STATUS.SUCCESS;
            MiConfigSingleton.V3().V8(0, extraBonus.getCoins().intValue());
            BonusDetailActivity.this.T.l(Integer.valueOf(BonusDetailActivity.this.T.d().intValue() + extraBonus.getCoins().intValue()));
            BonusDetailActivity.this.I3(false);
            BonusDetailActivity.this.i3();
        }
    }

    class f extends com.martian.mibook.lib.account.d.q.k0 {
        f(j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(Integer seconds) {
            if (seconds == null) {
                return;
            }
            BonusDetailActivity.this.b0 = seconds.intValue() + 3000;
        }
    }

    class g extends com.martian.mibook.lib.account.d.q.n0 {
        g(j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            BonusDetailActivity.this.k1(errorResult.d());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(UrlMissionResult urlMissionResult) {
            BonusDetailActivity.this.h3(urlMissionResult);
        }
    }

    public static class h {

        /* renamed from: b */
        private Integer f10812b;

        /* renamed from: c */
        private Integer f10813c;

        /* renamed from: d */
        private Integer f10814d;

        /* renamed from: e */
        private Long f10815e;

        /* renamed from: f */
        private Integer f10816f;

        /* renamed from: g */
        private Integer f10817g;

        /* renamed from: i */
        private Boolean f10819i;

        /* renamed from: a */
        private String f10811a = "";

        /* renamed from: h */
        private String f10818h = "";

        public boolean a() {
            return this.f10812b.intValue() <= 0 && this.f10813c.intValue() <= 0 && this.f10814d.intValue() <= 0 && this.f10817g.intValue() <= 0;
        }

        public boolean b() {
            Boolean bool = this.f10819i;
            return bool != null && bool.booleanValue();
        }

        public Integer c() {
            Integer num = this.f10817g;
            return Integer.valueOf(num == null ? 0 : num.intValue());
        }

        public Integer d() {
            Integer num = this.f10813c;
            return Integer.valueOf(num == null ? 0 : num.intValue());
        }

        public Integer e() {
            Integer num = this.f10814d;
            return Integer.valueOf(num == null ? 0 : num.intValue());
        }

        public String f() {
            return com.martian.libsupport.k.p(this.f10818h) ? "奖励好像被吃了~" : this.f10818h;
        }

        public Integer g() {
            Integer num = this.f10816f;
            return Integer.valueOf(num == null ? 0 : num.intValue());
        }

        public String getType() {
            return this.f10811a;
        }

        public long h() {
            Long l = this.f10815e;
            if (l == null) {
                return 0L;
            }
            return l.longValue();
        }

        public Integer i() {
            Integer num = this.f10812b;
            return Integer.valueOf(num == null ? 0 : num.intValue());
        }

        public void j(Boolean bonusGrabbed) {
            this.f10819i = bonusGrabbed;
        }

        public h k(Integer bookCoins) {
            this.f10817g = bookCoins;
            return this;
        }

        public h l(Integer coins) {
            this.f10813c = coins;
            return this;
        }

        public h m(Integer commission) {
            this.f10814d = commission;
            return this;
        }

        public h n(String errMsg) {
            this.f10818h = errMsg;
            return this;
        }

        public h o(Integer extraCoins) {
            this.f10816f = extraCoins;
            return this;
        }

        public h p(Long extraId) {
            this.f10815e = extraId;
            return this;
        }

        public h q(Integer money) {
            this.f10812b = money;
            return this;
        }

        public h r(String type) {
            this.f10811a = type;
            return this;
        }
    }

    public void A3() {
        this.Z = EXTRA_VIDEO_STATUS.FAIL;
        K3();
    }

    private void D3(boolean show) {
        UrlMission O = MiConfigSingleton.V3().L4.O();
        if (!show || O == null || com.martian.libsupport.k.p(O.getUrl())) {
            this.S.k.setVisibility(8);
            return;
        }
        this.S.k.setVisibility(0);
        this.S.f11985j.setText(O.getTitle());
        this.S.k.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BonusDetailActivity.this.u3(view);
            }
        });
        this.S.f11984i.setText(!com.martian.libsupport.k.p(O.getButtonText()) ? O.getButtonText() : getString(R.string.mission_fresh_redpaper_grab));
        this.S.f11984i.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BonusDetailActivity.this.w3(view);
            }
        });
    }

    public static void E3(j1 activity, String type, int money, int coins, int commission, long extraId, int extraCoins) {
        MiConfigSingleton.V3().M4.G(activity, type, money, coins);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void F3() {
        this.Z = EXTRA_VIDEO_STATUS.START;
        c cVar = new c(this);
        ((StartExtraBonusParams) cVar.k()).setExtraId(Long.valueOf(this.T.h()));
        cVar.j();
    }

    public void G3() {
        this.Z = EXTRA_VIDEO_STATUS.LOADING;
        MiConfigSingleton.V3().N4.t(this, b.d.a.j.b.f4373f, new d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.view.ViewGroup] */
    public void H3(AppTask appTask) {
        View view;
        if (appTask == null) {
            return;
        }
        LinearLayout linearLayout = this.S.f11977b;
        if (appTask.customView == null) {
            linearLayout.removeAllViews();
            if (AdConfig.UnionType.GAME.equalsIgnoreCase(appTask.source)) {
                this.S.f11977b.setPadding(com.martian.libmars.d.h.b(20.0f), 0, com.martian.libmars.d.h.b(20.0f), 0);
                view = Z2();
            } else {
                this.S.f11977b.setPadding(0, 0, 0, 0);
                View a3 = a3(appTask);
                view = a3;
                linearLayout = (ViewGroup) a3;
            }
        } else {
            view = linearLayout;
        }
        this.R.f(this, appTask, linearLayout, view);
    }

    public void I3(boolean isInit) {
        this.S.f11980e.setTextSize(16.0f);
        this.S.f11981f.setVisibility(8);
        if (this.T.c().intValue() > 0) {
            this.S.f11980e.setText(com.martian.rpauth.d.i.v(0, 0, this.T.c().intValue()));
            return;
        }
        if (this.T.e().intValue() > 0) {
            this.S.f11980e.setText(com.martian.rpauth.d.i.v(this.T.e().intValue(), this.T.d().intValue(), this.T.c().intValue()));
            return;
        }
        if (this.T.i().intValue() > 0) {
            this.S.f11980e.setText(com.martian.rpauth.d.i.v(this.T.i().intValue(), this.T.d().intValue(), this.T.c().intValue()));
            return;
        }
        this.S.f11980e.setTextSize(53.0f);
        this.S.f11981f.setVisibility(0);
        if (isInit) {
            this.S.f11980e.setNumber(this.T.d().intValue());
        } else {
            Z1(getString(R.string.txs_bonus_detail));
        }
        this.S.f11980e.setNumberText(this.T.d().intValue());
    }

    private void J3() {
        this.S.f11985j.setVisibility(0);
        if (!com.martian.libsupport.k.p(this.Y.getTitle())) {
            this.S.f11985j.setText(Html.fromHtml(this.Y.getTitle()));
        } else if (com.martian.libsupport.k.p(this.Y.getDesc())) {
            this.S.f11985j.setVisibility(4);
        } else {
            this.S.f11985j.setText(Html.fromHtml(this.Y.getDesc()));
        }
    }

    private void K3() {
        runOnUiThread(new Runnable() { // from class: com.martian.mibook.activity.e
            @Override // java.lang.Runnable
            public final void run() {
                BonusDetailActivity.this.y3();
            }
        });
    }

    private void L3(String draw) {
        this.S.f11979d.setVisibility(0);
        this.S.f11979d.setText(draw);
    }

    @SuppressLint({"SetTextI18n"})
    private View b3(final XianWanGame xianWanGame) {
        View inflate = View.inflate(this, R.layout.xianwan_game_ads_item, null);
        m7 a2 = m7.a(inflate);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMargins(com.martian.libmars.d.h.b(10.0f), 0, com.martian.libmars.d.h.b(10.0f), 0);
        a2.f12387e.setLayoutParams(layoutParams);
        a2.f12386d.setText(xianWanGame.getGameName());
        com.martian.libmars.utils.n0.z(this, xianWanGame.getIcon(), a2.f12385c, 11, com.martian.libmars.d.h.F().C());
        if (xianWanGame.getMoney().intValue() > 0) {
            a2.f12384b.setText("+" + (xianWanGame.getMoney().intValue() / 100) + "元");
        }
        a2.f12387e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BonusDetailActivity.this.o3(xianWanGame, view);
            }
        });
        return inflate;
    }

    private void c3() {
        MissionItem A = MiConfigSingleton.V3().L4.A(false);
        this.Y = A;
        if (A == null && MiConfigSingleton.V3().R2()) {
            this.Y = new MissionItem(101, getString(R.string.mission_play_xian) + "，0.3元可提现", 2, 10, false, 1000, "立即前往");
        }
        this.S.k.setVisibility(8);
        if (this.Y != null) {
            this.S.k.setVisibility(0);
            J3();
        }
    }

    private boolean e3() {
        EXTRA_VIDEO_STATUS extra_video_status;
        return (this.T.h() == 0 || this.T.g().intValue() <= 0 || (extra_video_status = this.Z) == EXTRA_VIDEO_STATUS.SUCCESS || extra_video_status == EXTRA_VIDEO_STATUS.FAIL) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void f3() {
        e eVar = new e(this);
        ((FinishExtraBonusParams) eVar.k()).setExtraId(Long.valueOf(this.T.h()));
        eVar.j();
    }

    public void h3(UrlMissionResult urlMissionResult) {
        if (urlMissionResult == null || urlMissionResult.getCoins() <= 0) {
            k1("获取奖励失败");
            A3();
            return;
        }
        MiConfigSingleton.V3().V8(0, urlMissionResult.getCoins());
        h hVar = this.T;
        hVar.l(Integer.valueOf(hVar.d().intValue() + urlMissionResult.getCoins()));
        MiConfigSingleton.V3().L4.x0(urlMissionResult);
        K3();
        I3(false);
    }

    private void j3() {
        com.martian.mibook.b.b b0 = com.martian.mibook.b.b.b0(this);
        this.R = b0;
        b0.T0(new a());
    }

    private void k3(String bonusPollDataJson) {
        if (!com.martian.libsupport.k.p(bonusPollDataJson)) {
            this.T = (h) GsonUtils.b().fromJson(bonusPollDataJson, h.class);
        }
        h hVar = this.T;
        if (hVar == null || hVar.a()) {
            k1("获取奖励信息失败");
            finish();
        }
    }

    /* renamed from: l3 */
    public /* synthetic */ void m3(final AppTask appTask, View v) {
        this.R.d(appTask);
    }

    /* renamed from: n3 */
    public /* synthetic */ void o3(final XianWanGame xianWanGame, View view) {
        com.martian.mibook.lib.model.g.b.n0(this, "奖励详情页-游戏-点击");
        if (MiConfigSingleton.V3().l2(this, 1015)) {
            if (com.martian.libsupport.k.p(xianWanGame.getUrl())) {
                k1("无效的游戏信息");
            } else {
                MiWebViewActivity.f5(this, xianWanGame.getUrl());
            }
        }
    }

    /* renamed from: p3 */
    public /* synthetic */ void q3(UrlMission urlMission) {
        K3();
    }

    /* renamed from: r3 */
    public /* synthetic */ void s3(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        boolean z = scrollY <= com.martian.libmars.d.h.b(55.0f);
        if (this.U != z) {
            this.U = z;
            A1((z || MiConfigSingleton.V3().I0()) ? false : true);
            int color = z ? ContextCompat.getColor(this, R.color.white) : com.martian.libmars.d.h.F().p0();
            int color2 = z ? ContextCompat.getColor(this, R.color.theme_default) : com.martian.libmars.d.h.F().g();
            q2(color);
            p2(color2);
        }
    }

    /* renamed from: t3 */
    public /* synthetic */ void u3(View view) {
        B3();
    }

    /* renamed from: v3 */
    public /* synthetic */ void w3(View view) {
        B3();
    }

    /* renamed from: x3 */
    public /* synthetic */ void y3() {
        String str;
        if (this.T.e().intValue() > 0) {
            L3(getString(R.string.withdraw_right_now));
            return;
        }
        if (this.T.i().intValue() > 0) {
            L3(getString(R.string.video_ads_look_get));
            D3(true);
            return;
        }
        if (e3()) {
            int intValue = this.T.g().intValue() / this.T.d().intValue();
            if (intValue > 1) {
                L3("点我赚" + (intValue + 1) + "倍奖励");
            } else {
                L3("点我奖励翻倍");
            }
            D3(true);
            return;
        }
        D3(false);
        UrlMission O = MiConfigSingleton.V3().L4.O();
        if (O == null || com.martian.libsupport.k.p(O.getUrl()) || O.getLeftCount() <= 0) {
            this.S.f11979d.setVisibility(8);
            return;
        }
        this.S.f11979d.setVisibility(0);
        if (!com.martian.libsupport.k.p(O.getTitle())) {
            com.martian.mibook.lib.model.g.b.h0(this, "展示-详情页-" + O.getTitle());
        }
        ThemeTextView themeTextView = this.S.f11979d;
        if (com.martian.libsupport.k.p(O.getButtonText())) {
            str = "领取" + MiConfigSingleton.V3().L4.u(5) + "金币";
        } else {
            str = O.getButtonText();
        }
        themeTextView.setText(str);
    }

    public void z3() {
        k1("领取成功");
        this.T.j(Boolean.TRUE);
        L3("查看明细");
    }

    public void B3() {
        UrlMission O = MiConfigSingleton.V3().L4.O();
        if (O == null) {
            return;
        }
        com.martian.mibook.lib.model.g.b.h0(this, "点击-详情页-" + O.getTitle());
        if (com.martian.libsupport.k.p(O.getUrl())) {
            k1("获取信息失败");
        } else {
            d3();
            MiWebViewActivity.d4(this, O.getUrl(), false, 300);
        }
    }

    public void C3() {
        if (this.a0) {
            k1("视频加载中,请稍候");
            return;
        }
        k1("视频加载中");
        this.a0 = true;
        MiConfigSingleton.V3().N4.t(this, b.d.a.j.b.f4373f, new b());
    }

    public View Z2() {
        com.martian.mibook.lib.model.g.b.n0(this, "奖励详情页-展示");
        l7 a2 = l7.a(View.inflate(this, R.layout.xianwan_game_ads, null));
        List<XianWanGame> S = MiConfigSingleton.V3().L4.S();
        this.S.f11977b.setVisibility(0);
        this.S.f11977b.addView(a2.getRoot());
        Collections.shuffle(S);
        Iterator<XianWanGame> it = S.iterator();
        while (it.hasNext()) {
            a2.f12318b.addView(b3(it.next()));
            if (a2.f12318b.getChildCount() > 2) {
                break;
            }
        }
        return a2.getRoot();
    }

    public View a3(final AppTask appTask) {
        com.martian.mibook.e.l0 d2 = com.martian.mibook.e.l0.d(getLayoutInflater(), null, false);
        ThemeLinearLayout root = d2.getRoot();
        d2.f12281g.setText(appTask.getTitle());
        d2.f12277c.setText(appTask.getDesc());
        d2.f12276b.setText(appTask.buttonText);
        if (!appTask.isVideoAd || appTask.videoView == null) {
            d2.f12282h.setVisibility(8);
            com.martian.libmars.utils.n0.l(this, appTask.getPosterUrl(), d2.f12280f, R.drawable.image_loading_default_horizontal);
        } else {
            d2.f12282h.setVisibility(0);
            appTask.videoView.init();
            if (appTask.videoView.getView().getParent() == null) {
                d2.f12282h.removeAllViews();
                d2.f12282h.addView(appTask.videoView.getView());
            }
        }
        d2.f12283i.setImageResource(appTask.adsIconRes());
        root.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BonusDetailActivity.this.m3(appTask, view);
            }
        });
        this.S.f11977b.setVisibility(0);
        this.S.f11977b.addView(root);
        return root;
    }

    public void d3() {
        this.c0 = Long.valueOf(MartianRPUserManager.t());
        if (MiConfigSingleton.V3().x5()) {
            new f(this).j();
        }
    }

    public void g3() {
        long t = MartianRPUserManager.t() - this.c0.longValue();
        int i2 = this.b0;
        if (i2 <= 0 || t <= i2) {
            k1("任务未完成，您可以继续完成");
        } else {
            new g(this).j();
        }
    }

    public void i3() {
        MiConfigSingleton.V3().L4.P(this, 1, new o0.u() { // from class: com.martian.mibook.activity.i
            @Override // com.martian.mibook.application.o0.u
            public final void a(UrlMission urlMission) {
                BonusDetailActivity.this.q3(urlMission);
            }
        });
    }

    @Override // com.martian.libmars.activity.k1
    public void n2() {
    }

    public void onActionMenuClick(View view) {
        com.martian.mibook.lib.model.g.b.v(this, "抽金币（大转盘）");
        MiWebViewActivity.f5(this, new MartianLuckyDrawParams().toHttpUrl("UTF8"));
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 300) {
            g3();
            return;
        }
        if (requestCode == 10006) {
            if (resultCode != -1) {
                A3();
            } else {
                com.martian.mibook.lib.model.g.b.r(this, "视频解锁 : api_complete");
                f3();
            }
        }
    }

    public void onBonusDrawClick(View view) {
        if (this.T.e().intValue() > 0) {
            com.martian.mibook.lib.model.g.b.v(this, "佣金提现");
            s2.X(this);
            return;
        }
        if (this.T.i().intValue() > 0) {
            if (this.T.b()) {
                IncomeActivity.w2(this, 0, com.martian.mibook.b.b.v);
                return;
            } else {
                C3();
                return;
            }
        }
        if (!e3()) {
            B3();
        } else if (this.Z == EXTRA_VIDEO_STATUS.IDLE) {
            F3();
        } else {
            k1("奖励领取中，请勿重复点击");
        }
    }

    @Override // com.martian.mibook.activity.base.n, com.martian.libmars.activity.k1, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        String string;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_detail);
        w2(k1.E);
        A1(false);
        C2(false);
        this.S = com.martian.mibook.e.g.a(h2());
        if (savedInstanceState != null) {
            string = savedInstanceState.getString(Q);
        } else {
            Bundle extras = getIntent().getExtras();
            string = extras != null ? extras.getString(Q) : "";
        }
        k3(string);
        if (!com.martian.libsupport.k.p(this.T.getType())) {
            Z1(this.T.getType() + getString(R.string.bonus_hint));
        }
        ((LinearLayout.LayoutParams) this.S.f11978c.getLayoutParams()).setMargins(0, i2(), 0, 0);
        p2(ContextCompat.getColor(this, R.color.theme_default));
        this.S.f11983h.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.martian.mibook.activity.d
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                BonusDetailActivity.this.s3(nestedScrollView, i2, i3, i4, i5);
            }
        });
        i3();
        c3();
        j3();
        com.martian.mibook.lib.model.g.b.v(this, this.T.getType() + "-展示");
    }

    public void onOpenXianWanGameClick(View view) {
        com.martian.mibook.lib.model.g.b.n0(this, "奖励详情页-主页-点击");
        MiConfigSingleton.V3().L4.q0(this);
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        I3(this.W);
        this.W = false;
        if (System.currentTimeMillis() - this.X < 10000) {
            return;
        }
        this.X = System.currentTimeMillis();
        this.R.F();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(Q, GsonUtils.b().toJson(this.T));
        super.onSaveInstanceState(outState);
    }

    public void onUrlMissionClick(View view) {
        MiConfigSingleton.V3().L4.Y(this, this.Y);
    }
}
