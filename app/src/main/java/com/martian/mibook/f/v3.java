package com.martian.mibook.f;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.martian.mibook.activity.account.IncomeActivity;
import com.martian.mibook.activity.account.TXSCommissionRecordActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.o0;
import com.martian.mibook.data.XianWanGame;
import com.martian.mibook.lib.account.request.MartianGetWithdrawOrdersRankParams;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MissionItem;
import com.martian.mibook.lib.account.response.MissionSection;
import com.martian.mibook.lib.account.response.WithdrawRankList;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class v3 extends com.martian.libmars.f.e {

    /* renamed from: e */
    private com.martian.mibook.e.f3 f13324e;

    /* renamed from: f */
    private MiTaskAccount f13325f;

    /* renamed from: g */
    private String f13326g = "";

    /* renamed from: h */
    private com.martian.libmars.b.d f13327h;

    class a extends com.martian.mibook.lib.account.d.e {
        a() {
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(final WithdrawRankList withdrawRankList) {
            if (!com.martian.libmars.utils.n0.C(((com.martian.libmars.f.e) v3.this).f10082a) || withdrawRankList == null || withdrawRankList.getWithdrawRanks().size() == 0) {
                return;
            }
            if (withdrawRankList.getWithdrawRanks().size() > 0 && !com.martian.libsupport.k.p(withdrawRankList.getWithdrawRanks().get(0).getHeader())) {
                v3.this.f13324e.f11944e.setVisibility(0);
                v3.this.f13324e.f11944e.setBorderColor(ContextCompat.getColor(((com.martian.libmars.f.e) v3.this).f10082a, R.color.grab_rank_golden));
                com.martian.libmars.utils.n0.l(((com.martian.libmars.f.e) v3.this).f10082a, withdrawRankList.getWithdrawRanks().get(0).getHeader(), v3.this.f13324e.f11944e, R.drawable.day_img_heads);
            }
            if (withdrawRankList.getWithdrawRanks().size() > 1 && !com.martian.libsupport.k.p(withdrawRankList.getWithdrawRanks().get(1).getHeader())) {
                v3.this.f13324e.f11946g.setVisibility(0);
                v3.this.f13324e.f11946g.setBorderColor(ContextCompat.getColor(((com.martian.libmars.f.e) v3.this).f10082a, R.color.grab_rank_silver));
                com.martian.libmars.utils.n0.l(((com.martian.libmars.f.e) v3.this).f10082a, withdrawRankList.getWithdrawRanks().get(1).getHeader(), v3.this.f13324e.f11946g, R.drawable.day_img_heads);
            }
            if (withdrawRankList.getWithdrawRanks().size() <= 2 || com.martian.libsupport.k.p(withdrawRankList.getWithdrawRanks().get(2).getHeader())) {
                return;
            }
            v3.this.f13324e.f11945f.setVisibility(0);
            v3.this.f13324e.f11945f.setBorderColor(ContextCompat.getColor(((com.martian.libmars.f.e) v3.this).f10082a, R.color.grab_rank_copper));
            com.martian.libmars.utils.n0.l(((com.martian.libmars.f.e) v3.this).f10082a, withdrawRankList.getWithdrawRanks().get(2).getHeader(), v3.this.f13324e.f11945f, R.drawable.day_img_heads);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* renamed from: B */
    public /* synthetic */ void C(View v) {
        com.martian.mibook.lib.model.g.b.F(this.f10082a, "提现榜");
        MiWebViewActivity.f5(this.f10082a, com.martian.libmars.d.h.F().Q0() ? "http://testap.taoyuewenhua.com/withdraw_rank" : "http://ap.taoyuewenhua.com/withdraw_rank");
    }

    public static v3 D(String path) {
        v3 v3Var = new v3();
        Bundle bundle = new Bundle();
        bundle.putString(IncomeActivity.G, path);
        v3Var.setArguments(bundle);
        return v3Var;
    }

    private void E(boolean isInit) {
        MiTaskAccount x4 = MiConfigSingleton.V3().x4();
        this.f13325f = x4;
        if (x4 != null) {
            if (isInit) {
                this.f13324e.f11942c.f9993g.setNumber(com.martian.rpauth.d.i.l(Integer.valueOf(x4.getCommission())));
            } else {
                this.f13324e.f11942c.f9993g.l(com.martian.rpauth.d.i.l(Integer.valueOf(x4.getCommission())), 2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void o() {
        a aVar = new a();
        ((MartianGetWithdrawOrdersRankParams) aVar.k()).setWithHeader(true);
        ((MartianGetWithdrawOrdersRankParams) aVar.k()).setPageSize(3);
        aVar.j();
    }

    private void p() {
        com.martian.libmars.b.d dVar = new com.martian.libmars.b.d();
        this.f13327h = dVar;
        dVar.c(com.martian.mibook.application.v0.r, new rx.k.b() { // from class: com.martian.mibook.f.u1
            @Override // rx.k.b
            public final void call(Object obj) {
                v3.this.w((Integer) obj);
            }
        });
    }

    private MissionItem q(int tag) {
        return MiConfigSingleton.V3().L4.H(this.f10082a, tag);
    }

    private void s() {
        this.f13324e.f11942c.l.setBackgroundResource(R.drawable.border_background_yellow);
        this.f13324e.f11942c.f9989c.setAlpha(0.25f);
        this.f13324e.f11942c.f9996j.setText(getString(R.string.txs_commission_amount));
        this.f13324e.f11942c.f9996j.setTextColor(ContextCompat.getColor(this.f10082a, R.color.day_text_color_primary));
        this.f13324e.f11942c.f9995i.setImageResource(R.drawable.icon_commission_withdraw_button);
        this.f13324e.f11942c.f9988b.setVisibility(0);
        this.f13324e.f11942c.f9988b.setText(getString(R.string.txs_commission_hint));
        this.f13324e.f11942c.f9988b.setTextColor(ContextCompat.getColor(this.f10082a, R.color.day_text_color_primary));
        this.f13324e.f11942c.f9992f.setTextColor(ContextCompat.getColor(this.f10082a, R.color.day_text_color_primary));
        this.f13324e.f11942c.f9993g.setTextColor(ContextCompat.getColor(this.f10082a, R.color.day_text_color_primary));
        this.f13324e.f11942c.f9991e.setColorFilter(ContextCompat.getColor(this.f10082a, R.color.day_text_color_primary));
        this.f13324e.f11942c.f9990d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.v1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v3.this.y(view);
            }
        });
        this.f13324e.f11942c.f9995i.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.x1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v3.this.A(view);
            }
        });
        this.f13324e.f11943d.setVisibility(MiConfigSingleton.V3().j5() ? 8 : 0);
        this.f13324e.f11943d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.w1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v3.this.C(view);
            }
        });
    }

    /* renamed from: t */
    public /* synthetic */ void u(MissionItem item) {
        com.martian.mibook.lib.model.g.b.F(this.f10082a, item.getTitle() + "-点击");
        MiConfigSingleton.V3().L4.Y(this.f10082a, item);
    }

    /* renamed from: v */
    public /* synthetic */ void w(Integer type) {
        if (type == null || type.intValue() != 888) {
            return;
        }
        this.f13325f = MiConfigSingleton.V3().x4();
        E(false);
    }

    /* renamed from: x */
    public /* synthetic */ void y(View v) {
        com.martian.mibook.lib.model.g.b.F(this.f10082a, "查看明细");
        startActivity(TXSCommissionRecordActivity.class);
    }

    /* renamed from: z */
    public /* synthetic */ void A(View v) {
        com.martian.mibook.lib.model.g.b.F(this.f10082a, "提现");
        com.martian.mibook.j.s2.X(this.f10082a);
    }

    @Override // com.martian.libmars.f.e
    protected void c() {
        com.martian.mibook.lib.model.g.b.F(this.f10082a, "佣金收入-展示");
    }

    public void n() {
        List<MissionItem> r = r();
        if (r.isEmpty()) {
            return;
        }
        MissionSection missionSection = new MissionSection();
        missionSection.setTitle(getString(R.string.txs_commission_mission));
        missionSection.setMissionItems(r);
        MiConfigSingleton.V3().L4.k(this.f10082a, missionSection, this.f13324e.f11941b, new o0.s() { // from class: com.martian.mibook.f.y1
            @Override // com.martian.mibook.application.o0.s
            public final void a(MissionItem missionItem) {
                v3.this.u(missionItem);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_commission_income, (ViewGroup) null);
        this.f13324e = com.martian.mibook.e.f3.a(inflate);
        s();
        if (savedInstanceState != null) {
            this.f13326g = savedInstanceState.getString(IncomeActivity.G);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f13326g = arguments.getString(IncomeActivity.G);
            }
        }
        p();
        o();
        n();
        E(true);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.martian.libmars.b.d dVar = this.f13327h;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(IncomeActivity.G, this.f13326g);
    }

    public List<MissionItem> r() {
        ArrayList arrayList = new ArrayList();
        if (MiConfigSingleton.V3().R2()) {
            arrayList.add(q(101));
            List<XianWanGame> S = MiConfigSingleton.V3().L4.S();
            Collections.shuffle(S);
            int i2 = 0;
            for (XianWanGame xianWanGame : S) {
                if (i2 >= 3) {
                    break;
                }
                i2++;
                arrayList.add(MiConfigSingleton.V3().L4.U(xianWanGame));
            }
        }
        return arrayList;
    }
}
