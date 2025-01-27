package com.martian.mibook.f;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.martian.libmars.utils.j0;
import com.martian.mibook.activity.GenderGuideActivity;
import com.martian.mibook.activity.ReadingRecordActivity;
import com.martian.mibook.activity.SettingActivity;
import com.martian.mibook.activity.account.AccountDetailActivity;
import com.martian.mibook.activity.account.IncomeActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.account.e.c;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.lib.account.response.TYActivity;
import com.martian.mibook.ui.o.f3;
import com.martian.ttbookhd.R;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;
import com.wbl.ad.yzz.config.RewardCallback;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class l3 extends com.martian.libmars.f.e implements View.OnClickListener {

    /* renamed from: e */
    public com.martian.libmars.b.d f13194e;

    /* renamed from: f */
    private String f13195f;

    /* renamed from: g */
    private com.martian.mibook.e.u2 f13196g;

    /* renamed from: h */
    private com.martian.mibook.ui.o.f3 f13197h;

    /* renamed from: i */
    private List<TYActivity> f13198i;

    /* renamed from: j */
    private boolean f13199j;
    private boolean k = false;
    private boolean l = false;

    class a implements RewardCallback {
        a() {
        }

        @Override // com.wbl.ad.yzz.config.RewardCallback
        public void onRewardResult(long l) {
            com.martian.mibook.lib.model.g.b.l0(((com.martian.libmars.f.e) l3.this).f10082a, "我的-免广告-" + l + "分钟");
            MiConfigSingleton.V3().T6((int) l);
        }

        @Override // com.wbl.ad.yzz.config.RewardCallback
        public void openPageFail(int i2, String s) {
            com.martian.mibook.lib.model.g.b.l0(((com.martian.libmars.f.e) l3.this).f10082a, "我的-启动失败");
        }

        @Override // com.wbl.ad.yzz.config.RewardCallback
        public void openPageSuccess() {
            com.martian.mibook.lib.model.g.b.l0(((com.martian.libmars.f.e) l3.this).f10082a, "我的-启动成功");
        }

        @Override // com.wbl.ad.yzz.config.RewardCallback
        public void pageExit() {
            com.martian.mibook.lib.model.g.b.l0(((com.martian.libmars.f.e) l3.this).f10082a, "我的-退出");
        }
    }

    class b implements c.d {
        b() {
        }

        @Override // com.martian.mibook.lib.account.e.c.d
        public void a(b.d.c.b.c errorResult) {
            l3.this.A();
        }

        @Override // com.martian.mibook.lib.account.e.c.d
        public void b(MiTaskAccount miTaskAccount) {
            l3.this.A();
        }
    }

    public l3() {
        x("我的");
    }

    private void C() {
        if (MiConfigSingleton.V3().N2()) {
            return;
        }
        UpgradeInfo upgradeInfo = Beta.getUpgradeInfo();
        if (upgradeInfo == null || upgradeInfo.versionCode <= com.martian.libmars.d.h.F().w0()) {
            this.f13196g.A.setVisibility(8);
        } else {
            this.f13196g.A.setVisibility(0);
        }
    }

    private void D() {
        boolean h6 = MiConfigSingleton.V3().h6();
        boolean i6 = MiConfigSingleton.V3().i6();
        if (!h6 || i6) {
            this.f13196g.R.setVisibility(8);
            if (com.martian.libmars.d.h.F().I0()) {
                this.f13196g.n.setImageResource(R.drawable.icon_account_bg_night);
            } else {
                this.f13196g.n.setImageResource(R.drawable.icon_account_bg);
            }
            this.f13196g.C.setImageResource(R.drawable.icon_account_vip);
            this.f13196g.E.setTextColor(ContextCompat.getColor(this.f10082a, R.color.vip_un_open_text));
            this.f13196g.D.setTextColor(ContextCompat.getColor(this.f10082a, R.color.vip_un_open_text));
            this.f13196g.D.setBackgroundResource(R.drawable.border_background_bonus_white);
            this.f13196g.u.setEnableFilter(true);
            this.f13196g.u.g();
            this.f13196g.z.setEnableFilter(true);
            this.f13196g.z.g();
            this.f13196g.Q.setTextColorType(0);
            this.f13196g.Q.g();
            this.f13196g.N.setTextColorType(2);
            this.f13196g.N.g();
            if (this.f10082a != null && b()) {
                this.f10082a.A1(true ^ com.martian.libmars.d.h.F().I0());
            }
            this.f13196g.f12778j.setText(getString(R.string.feedback));
            this.f13196g.k.setImageResource(R.drawable.icon_account_feedback);
        } else {
            this.f13196g.n.setImageResource(R.drawable.icon_account_bg_vip);
            this.f13196g.C.setImageResource(R.drawable.icon_account_vip_actived);
            this.f13196g.R.setVisibility(0);
            this.f13196g.E.setTextColor(ContextCompat.getColor(this.f10082a, R.color.vip_open_text));
            this.f13196g.D.setTextColor(ContextCompat.getColor(this.f10082a, R.color.day_item_color_primary));
            this.f13196g.D.setBackgroundResource(R.drawable.border_background_vip);
            this.f13196g.u.setEnableFilter(false);
            this.f13196g.u.setColorFilter(ContextCompat.getColor(this.f10082a, R.color.night_item_color_primary));
            this.f13196g.z.setEnableFilter(false);
            this.f13196g.z.setColorFilter(ContextCompat.getColor(this.f10082a, R.color.night_item_color_primary));
            this.f13196g.Q.setTextColorType(-1);
            this.f13196g.Q.setTextColor(ContextCompat.getColor(this.f10082a, R.color.night_item_color_primary));
            this.f13196g.N.setTextColorType(-1);
            this.f13196g.N.setTextColor(ContextCompat.getColor(this.f10082a, R.color.night_text_color_thirdly));
            if (this.f10082a != null && b()) {
                this.f10082a.A1(false);
            }
            this.f13196g.f12778j.setText(getString(R.string.vip_feedback));
            this.f13196g.k.setImageResource(R.drawable.icon_account_feedback_vip);
        }
        if (MiConfigSingleton.V3().i6()) {
            this.f13196g.E.setText(getString(R.string.vip_expired));
            this.f13196g.D.setText(getString(R.string.renewal_vip));
        } else if (MiConfigSingleton.V3().h6()) {
            this.f13196g.E.setText(getString(R.string.vip_open));
            this.f13196g.D.setText(getString(R.string.renewal_vip));
        } else {
            this.f13196g.E.setText(getString(R.string.vip_free_ads));
            this.f13196g.D.setText(getString(R.string.active_vip));
        }
    }

    private boolean m() {
        return MiConfigSingleton.V3().j5();
    }

    /* renamed from: n */
    public /* synthetic */ void o(Integer position) {
        if (position == null || position.intValue() != com.martian.mibook.application.v0.z) {
            return;
        }
        B();
        k();
    }

    /* renamed from: p */
    public /* synthetic */ void q(List activities) {
        this.f13198i = activities;
    }

    /* renamed from: r */
    public /* synthetic */ void s(final long cacheSize) {
        d("共清理" + com.martian.libmars.utils.j0.e(cacheSize) + "缓存");
        this.l = false;
    }

    /* renamed from: t */
    public /* synthetic */ void u(TYActivity tyActivity) {
        MiConfigSingleton.V3().L4.W(this.f10082a, tyActivity, this.f13194e, "我的-福利活动");
    }

    private void w() {
        if (m()) {
            return;
        }
        List<TYActivity> list = this.f13198i;
        if (list == null || list.isEmpty()) {
            this.f13196g.f12771c.setVisibility(8);
            return;
        }
        Iterator<TYActivity> it = this.f13198i.iterator();
        while (it.hasNext()) {
            TYActivity next = it.next();
            if (next.isInterAdActivity() || com.martian.libsupport.k.p(next.getIcon())) {
                it.remove();
            } else {
                com.martian.mibook.lib.model.g.b.m(this.f10082a, "我的-福利活动-" + next.getTitle() + "-曝光");
            }
        }
        if (this.f13198i.isEmpty()) {
            this.f13196g.f12771c.setVisibility(8);
            return;
        }
        this.f13196g.f12771c.setVisibility(0);
        if (this.f13197h == null) {
            this.f13197h = new com.martian.mibook.ui.o.f3(this.f10082a, new f3.a() { // from class: com.martian.mibook.f.b
                @Override // com.martian.mibook.ui.o.f3.a
                public final void a(TYActivity tYActivity) {
                    l3.this.u(tYActivity);
                }
            });
            this.f13196g.f12770b.setNumColumns((this.f13198i.size() <= 2 || this.f13198i.size() % 3 == 1) ? 2 : 3);
            this.f13196g.f12770b.setAdapter((ListAdapter) this.f13197h);
            this.f13196g.f12770b.setFocusable(false);
        }
        this.f13197h.d(this.f13198i);
    }

    private void y() {
        this.f13196g.Q.setText(getString(R.string.login_click));
        this.f13196g.N.setVisibility(0);
        this.f13196g.N.setText(getString(R.string.login_click_hint));
        this.f13196g.L.setText("--");
        this.f13196g.O.setText("--");
        this.f13196g.J.setText("--");
        this.f13196g.H.setImageResource(R.drawable.day_img_heads);
        this.f13196g.K.setVisibility(0);
    }

    @SuppressLint({"SetTextI18n"})
    private void z() {
        MiUser C4 = MiConfigSingleton.V3().C4();
        if (com.martian.libsupport.k.p(C4.getNickname())) {
            this.f13196g.Q.setText(getString(R.string.nickname));
        } else {
            this.f13196g.Q.setText(C4.getNickname());
        }
        if ("11".equalsIgnoreCase(MiConfigSingleton.V3().D4())) {
            this.f13196g.N.setVisibility(8);
        } else {
            if (MiConfigSingleton.V3().l6()) {
                this.f13196g.N.setText(getString(R.string.my_invite_code) + ExifInterface.GPS_MEASUREMENT_IN_PROGRESS + MiConfigSingleton.V3().D4());
            } else {
                this.f13196g.N.setText(getString(R.string.login_click_guide));
            }
            this.f13196g.N.setVisibility(0);
        }
        com.martian.libmars.utils.n0.l(this.f10082a, C4.getHeader(), this.f13196g.H, R.drawable.day_img_heads);
        MiTaskAccount x4 = MiConfigSingleton.V3().x4();
        if (x4 == null) {
            this.f13196g.L.setNumberText(0);
            this.f13196g.O.l(0.0f, 2);
            this.f13196g.J.l(0.0f, 2);
            this.f13196g.K.setVisibility(0);
            return;
        }
        this.f13196g.L.setNumberText(x4.getCoins());
        if (!x4.getShowCommission()) {
            this.f13196g.O.l(com.martian.rpauth.d.i.l(Integer.valueOf(x4.getMoney() + x4.getCommission())), 2);
            this.f13196g.K.setVisibility(8);
        } else {
            this.f13196g.O.l(com.martian.rpauth.d.i.l(Integer.valueOf(x4.getMoney())), 2);
            this.f13196g.J.l(com.martian.rpauth.d.i.l(Integer.valueOf(x4.getCommission())), 2);
            this.f13196g.K.setVisibility(0);
        }
    }

    public void A() {
        if (com.martian.libmars.utils.n0.C(this.f10082a)) {
            if (MiConfigSingleton.V3().x5()) {
                z();
            } else {
                y();
            }
        }
    }

    public void B() {
        com.martian.mibook.e.u2 u2Var = this.f13196g;
        if (u2Var != null) {
            u2Var.u.setImageResource(MiConfigSingleton.V3().P0() ? R.drawable.icon_account_day_mode : R.drawable.icon_account_night_mode);
        }
        D();
    }

    @Override // com.martian.libmars.f.e
    protected void c() {
        w();
    }

    public void j() {
        com.martian.libmars.b.d dVar = new com.martian.libmars.b.d();
        this.f13194e = dVar;
        dVar.c(com.martian.mibook.application.v0.l, new rx.k.b() { // from class: com.martian.mibook.f.d
            @Override // rx.k.b
            public final void call(Object obj) {
                l3.this.o((Integer) obj);
            }
        });
        this.f13194e.c(com.martian.mibook.application.v0.f11600d, new rx.k.b() { // from class: com.martian.mibook.f.a
            @Override // rx.k.b
            public final void call(Object obj) {
                l3.this.q((List) obj);
            }
        });
    }

    public void k() {
        if (this.k || !MiConfigSingleton.V3().x5() || m()) {
            A();
        } else {
            this.k = true;
            com.martian.mibook.lib.account.e.c.l(this.f10082a, new b());
        }
    }

    public String l() {
        return this.f13195f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.account_night_mode) {
            MiConfigSingleton.V3().t1(true ^ com.martian.libmars.d.h.F().P0());
            com.martian.mibook.lib.model.g.b.l(this.f10082a, MiConfigSingleton.V3().P0() ? "切换夜间" : "切换日间");
            com.martian.libmars.activity.j1 j1Var = this.f10082a;
            if (j1Var != null) {
                j1Var.j0();
            }
            B();
            return;
        }
        if (id == R.id.account_setting) {
            com.martian.mibook.lib.model.g.b.l(this.f10082a, "设置中心");
            this.f10082a.startActivityForResult(SettingActivity.class, 10002);
            return;
        }
        if (id == R.id.mc_duration_view) {
            if (MiConfigSingleton.V3().k2(this.f10082a)) {
                com.martian.mibook.lib.model.g.b.l(this.f10082a, "金币收入");
                IncomeActivity.w2(this.f10082a, 0, "我的-金币收入");
                return;
            }
            return;
        }
        if (id == R.id.mc_money_view) {
            if (MiConfigSingleton.V3().k2(this.f10082a)) {
                com.martian.mibook.lib.model.g.b.l(this.f10082a, "零钱收入");
                IncomeActivity.w2(this.f10082a, 0, "我的-零钱收入");
                return;
            }
            return;
        }
        if (id == R.id.account_income_view) {
            if (MiConfigSingleton.V3().k2(this.f10082a)) {
                com.martian.mibook.lib.model.g.b.l(this.f10082a, "现金收入");
                IncomeActivity.w2(this.f10082a, 0, "我的-现金收入");
                return;
            }
            return;
        }
        if (id == R.id.mc_commission_view) {
            if (MiConfigSingleton.V3().k2(this.f10082a)) {
                com.martian.mibook.lib.model.g.b.l(this.f10082a, "佣金收入");
                IncomeActivity.w2(this.f10082a, 1, "我的-佣金收入");
                return;
            }
            return;
        }
        if (id == R.id.account_reading_record) {
            if (!com.martian.libmars.d.h.F().J0() && !MiConfigSingleton.V3().U5()) {
                com.martian.mibook.lib.model.g.b.l(this.f10082a, "阅读记录");
                startActivity(ReadingRecordActivity.class);
                return;
            } else {
                if (com.martian.libmars.d.h.F().V() != null) {
                    com.martian.libmars.utils.q0.e(com.martian.libmars.d.h.F().V());
                }
                MiConfigSingleton.V3().N4.s(this.f10082a, b.d.a.j.b.f4372e, null);
                return;
            }
        }
        if (id == R.id.account_qplay_game) {
            if (m()) {
                com.martian.mibook.j.s2.d0(this.f10082a);
                return;
            } else {
                com.martian.mibook.lib.model.g.b.l(this.f10082a, "我的-Q玩");
                MiConfigSingleton.V3().L4.X(this.f10082a, 201);
                return;
            }
        }
        if (id == R.id.account_gender_guide) {
            com.martian.mibook.lib.model.g.b.l(this.f10082a, "性别偏好");
            GenderGuideActivity.S2(this.f10082a);
            return;
        }
        if (id == R.id.account_feedback) {
            com.martian.mibook.lib.model.g.b.l(this.f10082a, "意见反馈");
            com.martian.mibook.j.s2.Y(this.f10082a);
            return;
        }
        if (id == R.id.account_message_center) {
            com.martian.mibook.lib.model.g.b.l(this.f10082a, "消息中心");
            com.martian.mibook.j.s2.d0(this.f10082a);
            return;
        }
        if (id == R.id.account_clear_cache) {
            com.martian.mibook.lib.model.g.b.l(this.f10082a, "我的-清理缓存");
            v();
            return;
        }
        if (id == R.id.account_user_info) {
            com.martian.mibook.lib.model.g.b.l(this.f10082a, "账户管理");
            if (MiConfigSingleton.V3().o2(this.f10082a, 1022)) {
                this.f10082a.startActivity(AccountDetailActivity.class);
                return;
            }
            return;
        }
        if (id == R.id.account_vip_button || id == R.id.account_vip_view) {
            if (MiConfigSingleton.V3().k2(this.f10082a)) {
                com.martian.mibook.j.s2.p0(this.f10082a, "我的");
                return;
            }
            return;
        }
        if (id == R.id.account_check_update) {
            if (m()) {
                d("您已经是最新版本");
                return;
            }
            if (MiConfigSingleton.V3().N2()) {
                com.martian.mibook.lib.model.g.b.l(this.f10082a, "我的-检查更新-原生");
                MiConfigSingleton.V3().m2(this.f10082a, true);
                return;
            } else {
                com.martian.mibook.lib.model.g.b.l(this.f10082a, "我的-检查更新");
                Beta.checkUpgrade(true, false);
                C();
                return;
            }
        }
        if (id == R.id.account_my_comment) {
            com.martian.mibook.lib.model.g.b.l(this.f10082a, "我的-我的评论");
            com.martian.mibook.j.s2.o0(this.f10082a, 0, com.martian.mibook.application.k0.f11474b + "_" + MiConfigSingleton.V3().D4());
            return;
        }
        if (id == R.id.account_invite_friends) {
            com.martian.mibook.lib.model.g.b.l(this.f10082a, "我的-邀请好友");
            com.martian.mibook.j.s2.o(this.f10082a);
        } else if (id == R.id.account_wbl) {
            com.martian.mibook.lib.model.g.b.l(this.f10082a, "我的-免广告");
            MiConfigSingleton.V3().H4().b(this.f10082a, "1", 1, 1, "我的", new a());
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        com.martian.mibook.e.u2 d2 = com.martian.mibook.e.u2.d(inflater, null, false);
        this.f13196g = d2;
        d2.u.setOnClickListener(this);
        this.f13196g.z.setOnClickListener(this);
        this.f13196g.p.setOnClickListener(this);
        this.f13196g.M.setOnClickListener(this);
        this.f13196g.P.setOnClickListener(this);
        this.f13196g.K.setOnClickListener(this);
        this.f13196g.y.setOnClickListener(this);
        this.f13196g.v.setOnClickListener(this);
        this.f13196g.m.setOnClickListener(this);
        this.f13196g.f12777i.setOnClickListener(this);
        this.f13196g.r.setOnClickListener(this);
        this.f13196g.f12773e.setOnClickListener(this);
        this.f13196g.B.setOnClickListener(this);
        this.f13196g.f12772d.setOnClickListener(this);
        this.f13196g.D.setOnClickListener(this);
        this.f13196g.F.setOnClickListener(this);
        this.f13196g.t.setOnClickListener(this);
        this.f13196g.G.setOnClickListener(this);
        this.f13196g.q.setOnClickListener(this);
        if (m()) {
            if (MiConfigSingleton.V3().g0() > 1) {
                this.f13199j = true;
            }
            this.f13196g.w.setImageResource(R.drawable.icon_account_message);
            this.f13196g.x.setText(getString(R.string.message_center));
            this.f13196g.r.setVisibility(4);
            this.f13196g.s.setVisibility(8);
        } else {
            this.f13199j = false;
            C();
        }
        ((RelativeLayout.LayoutParams) this.f13196g.f12776h.getLayoutParams()).topMargin = this.f10082a.F0();
        this.f13196g.G.setVisibility(MiConfigSingleton.V3().Q2() ? 0 : 4);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f13196g.o.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f13196g.p.getLayoutParams();
        if (MiConfigSingleton.V3().u5()) {
            this.f13196g.F.setVisibility(8);
            this.f13196g.p.setVisibility(8);
            ((LinearLayout.LayoutParams) this.f13196g.l.getLayoutParams()).topMargin = com.martian.libmars.d.h.b(30.0f);
        } else {
            this.f13196g.F.setVisibility(0);
            layoutParams.height = com.martian.libmars.d.h.b(174.0f) + this.f10082a.F0();
            layoutParams2.topMargin = com.martian.libmars.d.h.b(80.0f);
        }
        if (MiConfigSingleton.V3().m6()) {
            this.f13196g.p.setVisibility(8);
            ((LinearLayout.LayoutParams) this.f13196g.l.getLayoutParams()).topMargin = com.martian.libmars.d.h.b(80.0f);
        }
        j();
        return this.f13196g.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.martian.libmars.b.d dVar = this.f13194e;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        A();
        D();
    }

    @Override // com.martian.libmars.f.e, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            A();
            D();
            if (this.f13199j) {
                this.f13199j = false;
                com.martian.mibook.j.v2.f1(this.f10082a);
            }
        }
    }

    public void v() {
        final long f2 = com.martian.libmars.utils.j0.f(this.f10082a);
        boolean z = f2 <= 0;
        d(this.l ? "正在清除中" : z ? "已经很干净啦" : "清除中...");
        if (this.l || z) {
            return;
        }
        this.l = true;
        com.martian.libmars.utils.j0.b(this.f10082a, new j0.b() { // from class: com.martian.mibook.f.c
            @Override // com.martian.libmars.utils.j0.b
            public final void clear() {
                l3.this.s(f2);
            }
        });
    }

    public void x(String title) {
        this.f13195f = title;
    }
}
