package com.martian.mibook.f;

import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import com.martian.dialog.g;
import com.martian.libmars.utils.k0;
import com.martian.mibook.activity.account.IncomeActivity;
import com.martian.mibook.activity.account.IncomeHistoryActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.o0;
import com.martian.mibook.e.r4;
import com.martian.mibook.lib.account.e.c;
import com.martian.mibook.lib.account.request.auth.ExchangeDurationParams;
import com.martian.mibook.lib.account.response.ExchangeMoney;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MissionItem;
import com.martian.mibook.lib.account.response.MissionSection;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class y3 extends com.martian.libmars.f.e implements View.OnClickListener {

    /* renamed from: e */
    private com.martian.mibook.e.i3 f13357e;

    /* renamed from: f */
    private MiTaskAccount f13358f;

    /* renamed from: g */
    private String f13359g = "";

    /* renamed from: h */
    private com.martian.libmars.b.d f13360h;

    class a implements c.d {
        a() {
        }

        @Override // com.martian.mibook.lib.account.e.c.d
        public void a(b.d.c.b.c errorResult) {
        }

        @Override // com.martian.mibook.lib.account.e.c.d
        public void b(MiTaskAccount taskAccount) {
            y3.this.f13358f = taskAccount;
            y3.this.P(false);
        }
    }

    class b extends com.martian.mibook.lib.account.d.q.k {
        b(com.martian.libmars.activity.j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            if (com.martian.libmars.utils.n0.c(((com.martian.libmars.f.e) y3.this).f10082a)) {
                return;
            }
            MiConfigSingleton.V3().M4.i(((com.martian.libmars.f.e) y3.this).f10082a, errorResult, "金币兑换");
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(ExchangeMoney exchangeMoney) {
            if (com.martian.libmars.utils.n0.c(((com.martian.libmars.f.e) y3.this).f10082a)) {
                return;
            }
            y3.this.N();
            MiConfigSingleton.V3().M4.G(((com.martian.libmars.f.e) y3.this).f10082a, "成功兑换零钱", exchangeMoney.getMoney(), 0);
            com.martian.mibook.lib.model.g.b.M(((com.martian.libmars.f.e) y3.this).f10082a, "金币兑换-成功");
        }
    }

    static /* synthetic */ void B(final DialogFragment freshFragment, View v) {
        if (freshFragment != null) {
            freshFragment.dismiss();
        }
    }

    static /* synthetic */ void C(final DialogFragment freshFragment, View v) {
        if (freshFragment != null) {
            freshFragment.dismiss();
        }
    }

    /* renamed from: D */
    public /* synthetic */ void E(final MissionItem item) {
        MiConfigSingleton.V3().L4.K(this.f10082a, item, this.f13357e.f12113b, true, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: F */
    public /* synthetic */ void G() {
        r4 d2 = r4.d(getLayoutInflater(), null, false);
        d2.f12617g.setText("限 时 福 利");
        d2.f12613c.setText(q(this.f13358f.getMRate()));
        d2.f12616f.setText("新人专属连续7天兑换福利");
        d2.f12615e.setImageResource(R.drawable.button_known);
        final com.martian.dialog.e k = ((g.a) ((g.a) com.martian.dialog.g.i(this.f10082a).R(d2.getRoot()).f(false)).j(true)).k();
        d2.f12614d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.k2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y3.B(DialogFragment.this, view);
            }
        });
        d2.f12615e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.i2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y3.C(DialogFragment.this, view);
            }
        });
    }

    /* renamed from: H */
    public /* synthetic */ void I() {
        P(false);
    }

    public static y3 J(String path) {
        y3 y3Var = new y3();
        Bundle bundle = new Bundle();
        bundle.putString(IncomeActivity.G, path);
        y3Var.setArguments(bundle);
        return y3Var;
    }

    private void M() {
        MiConfigSingleton.V3().L4.V(this.f10082a, null, false, new o0.r() { // from class: com.martian.mibook.f.o2
            @Override // com.martian.mibook.application.o0.r
            public final void a() {
                y3.this.I();
            }
        });
    }

    private void O(int tag) {
        View findViewWithTag = this.f13357e.f12113b.findViewWithTag(Integer.valueOf(tag));
        MissionItem v = v(tag);
        if (findViewWithTag == null || v == null) {
            return;
        }
        MiConfigSingleton.V3().L4.K(this.f10082a, v, this.f13357e.f12113b, true, null);
    }

    private void l(List<MissionItem> missionItems) {
        if (MiConfigSingleton.V3().L4.f0()) {
            return;
        }
        missionItems.add(v(8));
    }

    private void n(List<MissionItem> missionItems) {
        if (MiConfigSingleton.V3().O2()) {
            missionItems.add(v(106));
        }
        if (!MiConfigSingleton.V3().j5()) {
            missionItems.add(v(202));
        }
        if (MiConfigSingleton.V3().M2()) {
            missionItems.add(v(201));
        }
    }

    private void o() {
        com.martian.libmars.b.d dVar = new com.martian.libmars.b.d();
        this.f13360h = dVar;
        dVar.c(com.martian.mibook.application.v0.r, new rx.k.b() { // from class: com.martian.mibook.f.l2
            @Override // rx.k.b
            public final void call(Object obj) {
                y3.this.A((Integer) obj);
            }
        });
    }

    private MissionItem v(int tag) {
        return MiConfigSingleton.V3().L4.H(this.f10082a, tag);
    }

    private void w() {
        this.f13357e.f12114c.f9972c.setOnClickListener(this);
        this.f13357e.f12114c.f9975f.setOnClickListener(this);
        this.f13357e.f12114c.l.setOnClickListener(this);
        this.f13357e.f12114c.f9979j.setOnClickListener(this);
        com.martian.libmars.utils.n0.w(this.f10082a, R.drawable.bg_income, this.f13357e.f12114c.f9971b, 8);
    }

    /* renamed from: x */
    public /* synthetic */ void y(final MissionItem item) {
        com.martian.mibook.lib.model.g.b.M(this.f10082a, item.getTitle() + "-点击");
        if (item.getType() != 106) {
            MiConfigSingleton.V3().L4.Y(this.f10082a, item);
        } else {
            MiConfigSingleton.V3().L4.Z(item);
            MiConfigSingleton.V3().L4.E0(this.f10082a, new o0.t() { // from class: com.martian.mibook.f.n2
                @Override // com.martian.mibook.application.o0.t
                public final void a() {
                    y3.this.E(item);
                }
            });
        }
    }

    /* renamed from: z */
    public /* synthetic */ void A(Integer type) {
        if (type != null) {
            if (type.intValue() == 888) {
                P(false);
            } else if (type.intValue() == 2) {
                MiConfigSingleton.V3().L4.K(this.f10082a, MiConfigSingleton.V3().L4.H(this.f10082a, 2), this.f13357e.f12113b, true, null);
            }
        }
    }

    public void K() {
        MiTaskAccount miTaskAccount = this.f13358f;
        if (miTaskAccount != null && miTaskAccount.getFresh() && MiConfigSingleton.V3().L0("TTBOOK_FRESH_BONUS")) {
            new Handler().post(new Runnable() { // from class: com.martian.mibook.f.m2
                @Override // java.lang.Runnable
                public final void run() {
                    y3.this.G();
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void L() {
        b bVar = new b(this.f10082a);
        int s = s();
        ((ExchangeDurationParams) bVar.k()).setCoins(Integer.valueOf(s));
        ((ExchangeDurationParams) bVar.k()).setMoney(Integer.valueOf(u(s)));
        bVar.j();
    }

    public void N() {
        com.martian.mibook.lib.account.e.c.l(this.f10082a, new a());
    }

    public void P(boolean init) {
        if (com.martian.libmars.utils.n0.c(this.f10082a)) {
            return;
        }
        MiTaskAccount x4 = MiConfigSingleton.V3().x4();
        this.f13358f = x4;
        if (x4 == null) {
            this.f13357e.f12115d.setVisibility(8);
            return;
        }
        if (init) {
            this.f13357e.f12114c.f9977h.setNumber(com.martian.rpauth.d.i.l(Integer.valueOf(x4.getMoney() + (this.f13358f.getShowCommission() ? 0 : this.f13358f.getCommission()))));
            this.f13357e.f12114c.f9973d.setNumber(this.f13358f.getCoins());
        } else {
            this.f13357e.f12114c.f9977h.l(com.martian.rpauth.d.i.l(Integer.valueOf(x4.getMoney() + (this.f13358f.getShowCommission() ? 0 : this.f13358f.getCommission()))), 2);
            this.f13357e.f12114c.f9973d.setNumberText(this.f13358f.getCoins());
        }
        this.f13357e.f12114c.f9976g.setText(r(this.f13358f.getCoinsRate()));
        if (!com.martian.libsupport.k.p(this.f13358f.getRateNotice())) {
            this.f13357e.f12115d.setVisibility(0);
            this.f13357e.f12115d.setText(this.f13358f.getRateNotice());
        } else if (!MiConfigSingleton.V3().o5()) {
            this.f13357e.f12115d.setVisibility(8);
        } else {
            this.f13357e.f12115d.setVisibility(0);
            this.f13357e.f12115d.setText(this.f10082a.getString(R.string.money_exchange_hint));
        }
    }

    @Override // com.martian.libmars.f.e
    protected void c() {
        com.martian.mibook.lib.model.g.b.M(this.f10082a, "零钱收入-展示");
    }

    public void m() {
        if (MiConfigSingleton.V3().A5()) {
            return;
        }
        List<MissionItem> p = p();
        if (p.isEmpty()) {
            return;
        }
        MissionSection missionSection = new MissionSection();
        missionSection.setTitle(getString(R.string.money_mission));
        missionSection.setMissionItems(p);
        MiConfigSingleton.V3().L4.k(this.f10082a, missionSection, this.f13357e.f12113b, new o0.s() { // from class: com.martian.mibook.f.j2
            @Override // com.martian.mibook.application.o0.s
            public final void a(MissionItem missionItem) {
                y3.this.y(missionItem);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.income_coins_more) {
            com.martian.mibook.lib.model.g.b.M(this.f10082a, "收益明细");
            IncomeHistoryActivity.s2(this.f10082a, this.f13359g.contains("零钱") ? 1 : 0);
            return;
        }
        if (id == R.id.income_exchange) {
            if (s() > 0) {
                com.martian.mibook.lib.model.g.b.M(this.f10082a, "金币兑换弹窗-展示");
                com.martian.libmars.utils.k0.N(this.f10082a, getString(R.string.confirm_message), t(), new k0.l() { // from class: com.martian.mibook.f.p2
                    @Override // com.martian.libmars.utils.k0.l
                    public final void a() {
                        y3.this.L();
                    }
                });
                return;
            } else {
                d("金币不够，再去看会小说吧");
                com.martian.mibook.lib.model.g.b.M(this.f10082a, "金币兑换-不足");
                return;
            }
        }
        if (id == R.id.income_rate_hint) {
            com.martian.mibook.lib.model.g.b.M(this.f10082a, "汇率说明");
            com.martian.mibook.j.v2.T0(this.f10082a);
        } else if (id == R.id.income_money_withdraw) {
            com.martian.mibook.lib.model.g.b.M(this.f10082a, "提现");
            com.martian.mibook.j.s2.e0(this.f10082a, this.f13359g, MartianRPUserManager.f14923j);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_money_income, (ViewGroup) null);
        this.f13357e = com.martian.mibook.e.i3.a(inflate);
        w();
        if (savedInstanceState != null) {
            this.f13359g = savedInstanceState.getString(IncomeActivity.G);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f13359g = arguments.getString(IncomeActivity.G);
            }
        }
        o();
        P(true);
        K();
        com.martian.mibook.j.u2.a(this.f10082a, false);
        m();
        M();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.martian.libmars.b.d dVar = this.f13360h;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        O(106);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(IncomeActivity.G, this.f13359g);
    }

    public List<MissionItem> p() {
        ArrayList arrayList = new ArrayList();
        if (MiConfigSingleton.V3().g0() <= 5) {
            l(arrayList);
            n(arrayList);
        } else {
            n(arrayList);
            l(arrayList);
        }
        if (!MiConfigSingleton.V3().P5()) {
            arrayList.add(v(2));
        }
        return arrayList;
    }

    public String q(int rate) {
        return rate + "金币 = 1元";
    }

    public String r(int rate) {
        return rate + getString(R.string.exchange_rate_desc);
    }

    public int s() {
        MiTaskAccount miTaskAccount = this.f13358f;
        if (miTaskAccount == null || miTaskAccount.getCoins() <= 0) {
            return 0;
        }
        return this.f13358f.getCoins() - (this.f13358f.getCoins() % (this.f13358f.getCoinsRate() / 100));
    }

    public Spanned t() {
        int s = s();
        return Html.fromHtml("是否将<font color='red'>" + s + "金币</font>兑换成<font color='red'>" + com.martian.rpauth.d.i.p(Integer.valueOf(u(s))) + "元</font>？");
    }

    public int u(int coins) {
        if (coins <= 0) {
            return 0;
        }
        return (coins * 100) / this.f13358f.getCoinsRate();
    }
}
