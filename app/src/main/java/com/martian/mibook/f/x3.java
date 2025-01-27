package com.martian.mibook.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import com.martian.appwall.request.MartianLuckyDrawParams;
import com.martian.mibook.activity.BonusDetailActivity;
import com.martian.mibook.activity.account.IncomeActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.o0;
import com.martian.mibook.data.XianWanGame;
import com.martian.mibook.f.x3;
import com.martian.mibook.lib.account.request.auth.AcquireBubbleCoinsParams;
import com.martian.mibook.lib.account.response.BonusPool;
import com.martian.mibook.lib.account.response.ExtraBonus;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MissionItem;
import com.martian.mibook.lib.account.response.MissionSection;
import com.martian.mibook.lib.account.response.MissionSectionList;
import com.martian.mibook.lib.account.response.TYActivity;
import com.martian.mibook.lib.account.response.TYBonus;
import com.martian.mibook.lib.account.response.UrlMission;
import com.martian.mibook.lib.account.response.UrlMissionResult;
import com.martian.mibook.ui.o.j3;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class x3 extends com.martian.libmars.f.e implements View.OnClickListener {

    /* renamed from: e */
    private String f13340e;

    /* renamed from: f */
    private com.martian.mibook.e.h3 f13341f;

    /* renamed from: g */
    private com.martian.mibook.ui.o.j3 f13342g;

    /* renamed from: h */
    private BonusPool f13343h;

    /* renamed from: i */
    private TYActivity f13344i;

    /* renamed from: j */
    private MissionItem f13345j;
    private MissionItem k;
    private MissionItem l;
    private MissionItem m;
    private com.martian.libmars.b.d n;
    List<MissionItem> q;
    private boolean o = false;
    private long p = MartianRPUserManager.t();
    private int r = 0;
    private Long s = 0L;

    class a extends com.martian.mibook.lib.account.d.q.d0<AcquireBubbleCoinsParams, ExtraBonus> {

        /* renamed from: i */
        final /* synthetic */ MissionItem f13346i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Class x0, Class x1, Activity x2, final MissionItem val$bubbleMission) {
            super(x0, x1, x2);
            this.f13346i = val$bubbleMission;
        }

        /* renamed from: t */
        public /* synthetic */ void u(final MissionItem bubbleMission) {
            x3.this.G(bubbleMission);
            x3.this.Z();
        }

        @Override // com.martian.mibook.lib.account.d.q.d0, b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            x3.this.G(this.f13346i);
            x3.this.Z();
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<ExtraBonus> results) {
            ExtraBonus extraBonus;
            if (com.martian.libmars.utils.n0.c(((com.martian.libmars.f.e) x3.this).f10082a)) {
                return;
            }
            if (results != null && !results.isEmpty() && (extraBonus = results.get(0)) != null) {
                MiConfigSingleton.V3().V8(0, extraBonus.getCoins().intValue());
                x3.this.d0();
            }
            com.martian.libmars.utils.w0.b(((com.martian.libmars.f.e) x3.this).f10082a, "金币奖励", "+" + this.f13346i.getBubbleCoins(), null);
            Handler handler = new Handler();
            final MissionItem missionItem = this.f13346i;
            handler.postDelayed(new Runnable() { // from class: com.martian.mibook.f.z1
                @Override // java.lang.Runnable
                public final void run() {
                    x3.a.this.u(missionItem);
                }
            }, 500L);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class b extends com.martian.mibook.lib.account.d.b {
        b() {
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(BonusPool bonus) {
            if (bonus == null || com.martian.libmars.utils.n0.c(((com.martian.libmars.f.e) x3.this).f10082a)) {
                return;
            }
            x3.this.f13343h = bonus;
            x3.this.a0();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class c extends com.martian.mibook.lib.account.d.q.m {
        c(com.martian.libmars.activity.j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            x3.this.o = false;
            x3.this.d(errorResult.d());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(TYBonus tyBonus) {
            x3.this.o = false;
            com.martian.libmars.utils.w0.b(((com.martian.libmars.f.e) x3.this).f10082a, "    好评奖励    ", "+" + tyBonus.getCoins(), null);
            MiTaskAccount x4 = MiConfigSingleton.V3().x4();
            if (x4 != null) {
                x4.setFiveStar(Boolean.TRUE);
                MiConfigSingleton.V3().M4.f10762b.l(x4);
            }
            if (com.martian.libmars.utils.n0.c(((com.martian.libmars.f.e) x3.this).f10082a)) {
                return;
            }
            x3.this.f0(10);
        }
    }

    class d extends com.martian.mibook.lib.account.d.q.k0 {
        d(com.martian.libmars.activity.j1 x0) {
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
            x3.this.r = seconds.intValue() + 3000;
        }
    }

    class e extends com.martian.mibook.lib.account.d.q.n0 {
        e(com.martian.libmars.activity.j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            x3.this.d(errorResult.d());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(UrlMissionResult urlMissionResult) {
            if (com.martian.libmars.utils.n0.c(((com.martian.libmars.f.e) x3.this).f10082a)) {
                return;
            }
            x3.this.x(urlMissionResult);
        }
    }

    public x3() {
        Y("更多");
    }

    private MissionItem C(int tag) {
        return MiConfigSingleton.V3().L4.H(this.f10082a, tag);
    }

    /* renamed from: H */
    public /* synthetic */ void I(String missionType) {
        if (com.martian.mibook.application.v0.t.equalsIgnoreCase(missionType)) {
            w();
        } else if (com.martian.mibook.application.v0.u.equalsIgnoreCase(missionType)) {
            F();
        }
    }

    /* renamed from: J */
    public /* synthetic */ void K(Integer tag) {
        if (tag != null) {
            f0(tag);
            return;
        }
        e0();
        com.martian.mibook.ui.o.j3 j3Var = this.f13342g;
        if (j3Var != null) {
            j3Var.notifyDataSetChanged();
        }
    }

    /* renamed from: L */
    public /* synthetic */ void M(BonusPool mBonusPool) {
        if (mBonusPool != null) {
            this.f13343h = mBonusPool;
            a0();
        }
    }

    /* renamed from: N */
    public /* synthetic */ void O(Integer position) {
        if (position == null || position.intValue() != com.martian.mibook.application.v0.y) {
            return;
        }
        h0();
    }

    /* renamed from: P */
    public /* synthetic */ void Q(UrlMission urlMission) {
        if (urlMission != null) {
            com.martian.mibook.lib.model.g.b.h0(this.f10082a, "展示-任务中心-" + urlMission.getTitle());
        }
        e0();
    }

    /* renamed from: R */
    public /* synthetic */ void S() {
        f0(106);
    }

    /* renamed from: T */
    public /* synthetic */ void U() {
        f0(111);
    }

    /* renamed from: V */
    public /* synthetic */ void W() {
        G(new MissionItem(13, "签到领奖励，签满7天领奖金池分红", 0, 1, false, 13, "立即签到"));
    }

    public void Z() {
        b0();
        g0();
        i0();
        c0();
    }

    @SuppressLint({"SetTextI18n"})
    private void b0() {
        if (this.f13345j == null || MiConfigSingleton.V3().q2(MiConfigSingleton.V3().L4.I(this.f13345j.getType()))) {
            this.f13345j = MiConfigSingleton.V3().L4.t();
        }
        if (this.f13345j == null) {
            this.f13345j = C(111);
        }
        this.f13341f.f12061d.setVisibility(0);
        this.f13341f.q.setText(this.f13345j.getBubbleTitle());
        if (this.f13345j.getBubbleCoins() != null && this.f13345j.getBubbleCoins().intValue() > 0) {
            this.f13341f.f12066i.setImageResource(R.drawable.bg_mission_coins_empty);
            this.f13341f.m.setText("" + this.f13345j.getBubbleCoins());
            this.f13341f.m.setVisibility(0);
            return;
        }
        if (this.f13345j.getMoney() > 0) {
            this.f13341f.f12066i.setImageResource(R.drawable.bg_mission_money);
            this.f13341f.m.setVisibility(8);
        } else if (this.f13345j.getCoins() <= 0) {
            this.f13341f.f12061d.setVisibility(8);
        } else {
            this.f13341f.f12066i.setImageResource(R.drawable.bg_mission_coins_default);
            this.f13341f.m.setVisibility(8);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void c0() {
        if (this.m == null || MiConfigSingleton.V3().q2(MiConfigSingleton.V3().L4.I(this.m.getType()))) {
            this.m = MiConfigSingleton.V3().L4.t();
        }
        if (this.m == null) {
            if (MiConfigSingleton.V3().j5()) {
                this.m = C(0);
            } else if (MiConfigSingleton.V3().R2()) {
                this.m = C(101);
            } else {
                this.m = C(1);
            }
        }
        this.f13341f.f12064g.setVisibility(0);
        this.f13341f.t.setText(this.m.getBubbleTitle());
        if (this.m.getBubbleCoins() != null && this.m.getBubbleCoins().intValue() > 0) {
            this.f13341f.l.setImageResource(R.drawable.bg_mission_coins_empty);
            this.f13341f.p.setText("" + this.m.getBubbleCoins());
            this.f13341f.p.setVisibility(0);
            return;
        }
        if (this.m.getMoney() > 0) {
            this.f13341f.l.setImageResource(R.drawable.bg_mission_money);
            this.f13341f.p.setVisibility(8);
        } else if (this.m.getCoins() <= 0) {
            this.f13341f.f12064g.setVisibility(8);
        } else {
            this.f13341f.l.setImageResource(R.drawable.bg_mission_coins_default);
            this.f13341f.p.setVisibility(8);
        }
    }

    public void d0() {
        MiTaskAccount x4 = MiConfigSingleton.V3().x4();
        if (x4 != null) {
            this.f13341f.w.setNumberText(x4.getCoins());
            this.f13341f.z.l(com.martian.rpauth.d.i.l(Integer.valueOf(x4.getMoney())), 2);
            this.f13341f.x.l(com.martian.rpauth.d.i.l(Integer.valueOf(x4.getCommission())), 2);
        } else {
            this.f13341f.w.setNumberText(0);
            this.f13341f.z.l(0.0f, 2);
            this.f13341f.x.l(0.0f, 2);
        }
    }

    public void f0(final Integer tag) {
        if (tag == null) {
            return;
        }
        View findViewWithTag = this.f13341f.D.findViewWithTag(tag);
        MissionItem C = C(tag.intValue());
        if (findViewWithTag == null || C == null) {
            return;
        }
        MiConfigSingleton.V3().L4.K(this.f10082a, C, this.f13341f.D, true, null);
    }

    @SuppressLint({"SetTextI18n"})
    private void g0() {
        if (this.k == null || MiConfigSingleton.V3().q2(MiConfigSingleton.V3().L4.I(this.k.getType()))) {
            this.k = MiConfigSingleton.V3().L4.t();
        }
        if (this.k == null) {
            this.k = C(2);
        }
        this.f13341f.f12062e.setVisibility(0);
        this.f13341f.r.setText(this.k.getBubbleTitle());
        if (this.k.getBubbleCoins() != null && this.k.getBubbleCoins().intValue() > 0) {
            this.f13341f.f12067j.setImageResource(R.drawable.bg_mission_coins_empty);
            this.f13341f.n.setText("" + this.k.getBubbleCoins());
            this.f13341f.n.setVisibility(0);
            return;
        }
        if (this.k.getMoney() > 0) {
            this.f13341f.f12067j.setImageResource(R.drawable.bg_mission_money);
            this.f13341f.n.setVisibility(8);
        } else if (this.k.getCoins() <= 0) {
            this.f13341f.f12062e.setVisibility(8);
        } else {
            this.f13341f.f12067j.setImageResource(R.drawable.bg_mission_coins_default);
            this.f13341f.n.setVisibility(8);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void i0() {
        if (this.l == null || MiConfigSingleton.V3().q2(MiConfigSingleton.V3().L4.I(this.l.getType()))) {
            this.l = MiConfigSingleton.V3().L4.t();
        }
        if (this.l == null) {
            this.l = C(MiConfigSingleton.V3().j5() ? 1 : 201);
        }
        this.f13341f.f12063f.setVisibility(0);
        this.f13341f.s.setText(this.l.getBubbleTitle());
        if (this.l.getBubbleCoins() != null && this.l.getBubbleCoins().intValue() > 0) {
            this.f13341f.k.setImageResource(R.drawable.bg_mission_coins_empty);
            this.f13341f.o.setText("" + this.l.getBubbleCoins());
            this.f13341f.o.setVisibility(0);
            return;
        }
        if (this.l.getMoney() > 0) {
            this.f13341f.k.setImageResource(R.drawable.bg_mission_money);
            this.f13341f.o.setVisibility(8);
        } else if (this.l.getCoins() <= 0) {
            this.f13341f.f12063f.setVisibility(8);
        } else {
            this.f13341f.k.setImageResource(R.drawable.bg_mission_coins_default);
            this.f13341f.o.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void s(final MissionItem bubbleMission) {
        if (bubbleMission == null) {
            d("获取信息失败");
        } else {
            if (bubbleMission.getBubbleCoins().intValue() <= 0) {
                G(bubbleMission);
                return;
            }
            a aVar = new a(AcquireBubbleCoinsParams.class, ExtraBonus.class, this.f10082a, bubbleMission);
            ((AcquireBubbleCoinsParams) aVar.k()).setType(Integer.valueOf(bubbleMission.getType()));
            aVar.j();
        }
    }

    private void u() {
        com.martian.libmars.b.d dVar = new com.martian.libmars.b.d();
        this.n = dVar;
        dVar.c(com.martian.mibook.application.v0.f11599c, new rx.k.b() { // from class: com.martian.mibook.f.f2
            @Override // rx.k.b
            public final void call(Object obj) {
                x3.this.I((String) obj);
            }
        });
        this.n.c(com.martian.mibook.application.v0.f11602f, new rx.k.b() { // from class: com.martian.mibook.f.c2
            @Override // rx.k.b
            public final void call(Object obj) {
                x3.this.K((Integer) obj);
            }
        });
        this.n.c(com.martian.mibook.application.v0.f11601e, new rx.k.b() { // from class: com.martian.mibook.f.r2
            @Override // rx.k.b
            public final void call(Object obj) {
                x3.this.G((MissionItem) obj);
            }
        });
        this.n.c(com.martian.mibook.application.v0.f11606j, new rx.k.b() { // from class: com.martian.mibook.f.h2
            @Override // rx.k.b
            public final void call(Object obj) {
                x3.this.M((BonusPool) obj);
            }
        });
        this.n.c(com.martian.mibook.application.v0.l, new rx.k.b() { // from class: com.martian.mibook.f.g2
            @Override // rx.k.b
            public final void call(Object obj) {
                x3.this.O((Integer) obj);
            }
        });
    }

    public void x(UrlMissionResult urlMissionResult) {
        if (urlMissionResult == null) {
            return;
        }
        BonusDetailActivity.E3(this.f10082a, "福利", 0, urlMissionResult.getCoins(), 0, urlMissionResult.getExtraId().longValue(), urlMissionResult.getExtraCoins().intValue());
        MiConfigSingleton.V3().L4.x0(urlMissionResult);
        f0(5);
    }

    public List<MissionItem> A() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C(0));
        arrayList.add(C(2));
        arrayList.add(C(9));
        this.q = arrayList;
        return arrayList;
    }

    public List<MissionItem> B() {
        ArrayList arrayList = new ArrayList();
        if (!MiConfigSingleton.V3().L4.e0()) {
            arrayList.add(C(4));
        }
        if (!MiConfigSingleton.V3().L4.f0()) {
            arrayList.add(C(8));
        }
        if (MiConfigSingleton.V3().H2()) {
            arrayList.add(C(10));
        }
        return arrayList;
    }

    public List<MissionItem> D() {
        ArrayList arrayList = new ArrayList();
        if (MiConfigSingleton.V3().O2()) {
            arrayList.add(C(106));
        }
        if (!MiConfigSingleton.V3().j5()) {
            arrayList.add(C(202));
        }
        if (MiConfigSingleton.V3().M2()) {
            arrayList.add(C(201));
        }
        if (MiConfigSingleton.V3().L4.O() != null) {
            arrayList.add(C(5));
        }
        MiConfigSingleton.V3().L4.l(this.f10082a, arrayList);
        return arrayList;
    }

    public String E() {
        return this.f13340e;
    }

    public void F() {
        if (MiConfigSingleton.V3().x5()) {
            MiConfigSingleton.V3().L4.P(this.f10082a, 0, new o0.u() { // from class: com.martian.mibook.f.e2
                @Override // com.martian.mibook.application.o0.u
                public final void a(UrlMission urlMission) {
                    x3.this.Q(urlMission);
                }
            });
        } else {
            e0();
        }
    }

    public void G(MissionItem item) {
        if (item == null) {
            return;
        }
        this.n.d(com.martian.mibook.application.v0.k, Integer.valueOf(item.getType()));
        if (item.getType() == 4) {
            com.martian.mibook.lib.model.g.b.L(this.f10082a, "新手红包");
            MiConfigSingleton.V3().L4.Z(item);
            this.n.d(com.martian.mibook.application.v0.f11605i, 0);
            return;
        }
        if (item.getType() == 5) {
            com.martian.mibook.lib.model.g.b.L(this.f10082a, "互动红包");
            MiConfigSingleton.V3().L4.Z(item);
            if (MiConfigSingleton.V3().l2(this.f10082a, 1012)) {
                X();
                return;
            }
            return;
        }
        if (item.getType() == 0) {
            com.martian.mibook.lib.model.g.b.L(this.f10082a, "小说任务");
            MiConfigSingleton.V3().L4.Z(item);
            this.n.d(com.martian.mibook.application.v0.f11603g, 1);
            return;
        }
        if (item.getType() == 9) {
            com.martian.mibook.lib.model.g.b.L(this.f10082a, "发表评论");
            MiConfigSingleton.V3().L4.Z(item);
            this.n.d(com.martian.mibook.application.v0.f11603g, 1);
            return;
        }
        if (item.getType() == 11) {
            com.martian.mibook.lib.model.g.b.L(this.f10082a, "看广告");
            MiConfigSingleton.V3().L4.Z(item);
            this.n.d(com.martian.mibook.application.v0.f11603g, 0);
            return;
        }
        if (item.getType() == 10) {
            com.martian.mibook.lib.model.g.b.L(this.f10082a, "五星好评");
            MiConfigSingleton.V3().L4.Z(item);
            if (MiConfigSingleton.V3().V4 && MiConfigSingleton.V3().g0() < 50) {
                org.codechimp.apprater.b.m(new org.codechimp.apprater.e());
                org.codechimp.apprater.b.g(this.f10082a);
                return;
            } else {
                if (MiConfigSingleton.V3().l2(this.f10082a, 1013)) {
                    org.codechimp.apprater.b.m(new org.codechimp.apprater.e());
                    org.codechimp.apprater.b.g(this.f10082a);
                    this.o = true;
                    this.p = MartianRPUserManager.t();
                    return;
                }
                return;
            }
        }
        if (item.getType() == 106) {
            MiConfigSingleton.V3().L4.Z(item);
            MiConfigSingleton.V3().L4.E0(this.f10082a, new o0.t() { // from class: com.martian.mibook.f.a2
                @Override // com.martian.mibook.application.o0.t
                public final void a() {
                    x3.this.S();
                }
            });
            return;
        }
        if (item.getType() == 111) {
            MiConfigSingleton.V3().L4.Z(item);
            MiConfigSingleton.V3().L4.E0(this.f10082a, new o0.t() { // from class: com.martian.mibook.f.b2
                @Override // com.martian.mibook.application.o0.t
                public final void a() {
                    x3.this.U();
                }
            });
        } else {
            if (item.getType() == 13) {
                this.n.d(com.martian.mibook.application.v0.f11597a, Boolean.valueOf(item.diractForward));
                return;
            }
            if (item.getType() != 2008) {
                MiConfigSingleton.V3().L4.Y(this.f10082a, item);
                return;
            }
            com.martian.mibook.lib.model.g.b.L(this.f10082a, "0.3元提现");
            if (MiConfigSingleton.V3().l2(this.f10082a, 1023)) {
                com.martian.mibook.j.s2.e0(this.f10082a, "赚钱=新手任务", MartianRPUserManager.f14923j);
            }
        }
    }

    public void X() {
        UrlMission O = MiConfigSingleton.V3().L4.O();
        if (O == null || com.martian.libsupport.k.p(O.getUrl())) {
            d("获取信息失败");
            return;
        }
        com.martian.mibook.lib.model.g.b.h0(this.f10082a, "点击-任务中心-" + O.getTitle());
        t();
        MiWebViewActivity.d4(this.f10082a, O.getUrl(), false, 300);
    }

    public void Y(String title) {
        this.f13340e = title;
    }

    public void a0() {
        this.f13342g.f(this.f13343h);
    }

    @Override // com.martian.libmars.f.e
    protected void c() {
        F();
        if (this.f13343h == null) {
            y();
        } else {
            a0();
        }
        if (MiConfigSingleton.V3().x5() && MiConfigSingleton.V3().L0("CHECKIN_NOTIFY")) {
            MiConfigSingleton.V3().L4.N0(this.f10082a);
        }
    }

    public void e0() {
        if (com.martian.libmars.utils.n0.C(this.f10082a)) {
            MissionSectionList missionSectionList = new MissionSectionList();
            ArrayList arrayList = new ArrayList();
            MissionSection missionSection = new MissionSection();
            missionSection.setTitle(this.f10082a.getString(R.string.txs_commission_mission));
            missionSection.setMissionItems(z());
            if (!missionSection.getMissionItems().isEmpty()) {
                arrayList.add(missionSection);
            }
            MissionSection missionSection2 = new MissionSection();
            missionSection2.setTitle(this.f10082a.getString(R.string.mission_fresh));
            missionSection2.setMissionItems(B());
            MissionSection missionSection3 = new MissionSection();
            missionSection3.setTitle(this.f10082a.getString(R.string.mission_recommend));
            missionSection3.setMissionItems(D());
            if (MiConfigSingleton.V3().g0() > 2 || (MiConfigSingleton.V3().L4.e0() && MiConfigSingleton.V3().L4.f0())) {
                if (!missionSection3.getMissionItems().isEmpty()) {
                    arrayList.add(missionSection3);
                }
                if (!missionSection2.getMissionItems().isEmpty()) {
                    arrayList.add(missionSection2);
                }
            } else {
                if (!missionSection2.getMissionItems().isEmpty()) {
                    arrayList.add(missionSection2);
                }
                if (!missionSection3.getMissionItems().isEmpty()) {
                    arrayList.add(missionSection3);
                }
            }
            MissionSection missionSection4 = new MissionSection();
            missionSection4.setTitle(this.f10082a.getString(R.string.mission_daily));
            missionSection4.setMissionItems(A());
            arrayList.add(missionSection4);
            missionSectionList.setMissionSections(arrayList);
            if (missionSectionList.getMissionSections() != null) {
                this.f13341f.D.removeAllViews();
                Iterator<MissionSection> it = missionSectionList.getMissionSections().iterator();
                while (it.hasNext()) {
                    MiConfigSingleton.V3().L4.k(this.f10082a, it.next(), this.f13341f.D, new o0.s() { // from class: com.martian.mibook.f.q2
                        @Override // com.martian.mibook.application.o0.s
                        public final void a(MissionItem missionItem) {
                            x3.this.G(missionItem);
                        }
                    });
                }
            }
        }
    }

    public void h0() {
        boolean I0 = MiConfigSingleton.V3().I0();
        d0();
        if (I0) {
            this.f13341f.f12059b.setBackgroundResource(R.drawable.border_background_bonus_coin_night);
            this.f13341f.u.setVisibility(8);
        } else {
            this.f13341f.f12059b.setBackgroundResource(R.drawable.border_background_bonus_coin);
            this.f13341f.u.setVisibility(0);
        }
        this.f13341f.B.setImageResource(MiConfigSingleton.V3().D2() ? R.drawable.icon_switch_mini_selected : R.drawable.icon_switch_mini_unselected);
        TYActivity s = MiConfigSingleton.V3().L4.s();
        this.f13344i = s;
        if (s != null) {
            com.martian.mibook.lib.model.g.b.m(this.f10082a, "赚钱-福利活动-" + this.f13344i.getTitle() + "-曝光");
            com.martian.libmars.utils.n0.l(this.f10082a, this.f13344i.getBubbleImage(), this.f13341f.f12065h, R.drawable.bg_mission_lucky_draw);
        }
        Z();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.mc_income_view) {
            if (MiConfigSingleton.V3().k2(this.f10082a)) {
                com.martian.mibook.lib.model.g.b.L(this.f10082a, "现金收入");
                IncomeActivity.w2(this.f10082a, 0, "任务中心-现金收入");
                return;
            }
            return;
        }
        if (id == R.id.mc_income_commission || id == R.id.mc_income_commission_title) {
            if (MiConfigSingleton.V3().k2(this.f10082a)) {
                com.martian.mibook.lib.model.g.b.L(this.f10082a, "佣金收入");
                IncomeActivity.w2(this.f10082a, 1, "任务中心-佣金收入");
                return;
            }
            return;
        }
        if (id == R.id.mc_sign_notify_switch) {
            com.martian.mibook.lib.model.g.b.L(this.f10082a, "签到提醒");
            if (MiConfigSingleton.V3().D2()) {
                MiConfigSingleton.V3().o7(false);
            } else if (com.martian.libsupport.f.d(this.f10082a)) {
                MiConfigSingleton.V3().o7(true);
            } else {
                com.martian.libsupport.f.a(this.f10082a);
            }
            MiConfigSingleton.V3().L4.N0(this.f10082a);
            this.f13341f.B.setImageResource(MiConfigSingleton.V3().D2() ? R.drawable.icon_switch_mini_selected : R.drawable.icon_switch_mini_unselected);
            return;
        }
        if (id == R.id.mc_bonus_activity) {
            if (this.f13344i != null) {
                MiConfigSingleton.V3().L4.W(this.f10082a, this.f13344i, this.n, "赚钱-福利活动");
                return;
            } else {
                com.martian.mibook.lib.model.g.b.L(this.f10082a, "泡泡-大转盘-点击");
                MiWebViewActivity.f5(this.f10082a, new MartianLuckyDrawParams().toHttpUrl("UTF8"));
                return;
            }
        }
        if (id == R.id.mc_bonus_1) {
            s(this.f13345j);
            return;
        }
        if (id == R.id.mc_bonus_2) {
            s(this.k);
        } else if (id == R.id.mc_bonus_3) {
            s(this.l);
        } else if (id == R.id.mc_bonus_4) {
            s(this.m);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_mission_center, (ViewGroup) null);
        com.martian.mibook.e.h3 a2 = com.martian.mibook.e.h3.a(inflate);
        this.f13341f = a2;
        a2.v.setPadding(0, this.f10082a.F0(), 0, 0);
        this.f13341f.A.setOnClickListener(this);
        this.f13341f.x.setOnClickListener(this);
        this.f13341f.y.setOnClickListener(this);
        this.f13341f.B.setOnClickListener(this);
        this.f13341f.f12065h.setOnClickListener(this);
        this.f13341f.f12061d.setOnClickListener(this);
        this.f13341f.f12062e.setOnClickListener(this);
        this.f13341f.f12063f.setOnClickListener(this);
        this.f13341f.f12064g.setOnClickListener(this);
        this.f13341f.f12060c.setLayoutManager(new GridLayoutManager(this.f10082a, 7));
        com.martian.mibook.ui.o.j3 j3Var = new com.martian.mibook.ui.o.j3(this.f10082a, new j3.a() { // from class: com.martian.mibook.f.d2
            @Override // com.martian.mibook.ui.o.j3.a
            public final void a() {
                x3.this.W();
            }
        });
        this.f13342g = j3Var;
        this.f13341f.f12060c.setAdapter(j3Var);
        u();
        MiConfigSingleton.V3().L4.m();
        if (!com.martian.libsupport.l.w(this.f10082a)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, -com.martian.libmars.d.h.b(20.0f), 0, 0);
            this.f13341f.u.setLayoutParams(layoutParams);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.martian.libmars.b.d dVar = this.n;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        v();
        f0(106);
    }

    public void t() {
        this.s = Long.valueOf(MartianRPUserManager.t());
        if (MiConfigSingleton.V3().x5()) {
            new d(this.f10082a).j();
        }
    }

    public void v() {
        if (!this.o || MiConfigSingleton.V3().L4.d0()) {
            return;
        }
        if (MartianRPUserManager.t() - this.p >= 20000) {
            new c(this.f10082a).j();
        } else {
            this.o = false;
        }
    }

    public void w() {
        long t = MartianRPUserManager.t() - this.s.longValue();
        int i2 = this.r;
        if (i2 <= 0 || t <= i2) {
            d("任务未完成，您可以继续完成");
        } else {
            new e(this.f10082a).j();
        }
    }

    public void y() {
        new b().j();
    }

    public List<MissionItem> z() {
        ArrayList arrayList = new ArrayList();
        if (MiConfigSingleton.V3().R2()) {
            arrayList.add(C(101));
            com.martian.mibook.lib.model.g.b.n0(this.f10082a, "赚钱-主页-展示");
            List<XianWanGame> S = MiConfigSingleton.V3().L4.S();
            Collections.shuffle(S);
            int i2 = 0;
            Iterator<XianWanGame> it = S.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                XianWanGame next = it.next();
                if (i2 >= 2) {
                    com.martian.mibook.lib.model.g.b.n0(this.f10082a, "赚钱-游戏-展示");
                    break;
                }
                i2++;
                arrayList.add(MiConfigSingleton.V3().L4.U(next));
            }
        }
        return arrayList;
    }
}
