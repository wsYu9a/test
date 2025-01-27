package com.martian.mibook.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.martian.libmars.databinding.MartianMoneyWithdrawViewBinding;
import com.martian.libmars.fragment.MartianFragment;
import com.martian.mibook.R;
import com.martian.mibook.activity.account.TXSCoinsRecordActivity;
import com.martian.mibook.activity.account.TXSRechargeActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.FragmentAccountCoinsTxsBinding;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.request.RechargeParams;
import com.martian.rpauth.response.MartianRPAccount;
import l9.m0;
import lb.c;
import z5.k;

/* loaded from: classes3.dex */
public class BookCoinsTxsFragment extends MartianFragment implements View.OnClickListener {

    /* renamed from: d */
    public FragmentAccountCoinsTxsBinding f13615d;

    /* renamed from: e */
    public MartianMoneyWithdrawViewBinding f13616e;

    public class a implements c.i {
        public a() {
        }

        @Override // lb.c.i
        public void a(x8.c cVar) {
            if (m0.c(BookCoinsTxsFragment.this.f12352c)) {
                return;
            }
            BookCoinsTxsFragment.this.f13616e.f12321g.setText("获取失败");
        }

        @Override // lb.c.i
        public void b(MartianRPAccount martianRPAccount) {
            if (m0.c(BookCoinsTxsFragment.this.f12352c) || martianRPAccount == null) {
                return;
            }
            BookCoinsTxsFragment.this.f13616e.f12321g.setText(String.valueOf(martianRPAccount.getBookCoins()));
        }
    }

    public final void n() {
        boolean z10 = !MiUserManager.q().v();
        MiUserManager.q().y(z10);
        this.f13615d.txsMsbAutoBuyingSwitcher.setChecked(z10);
        ac.a.t(getContext(), "自动购买:" + z10);
    }

    public final void o() {
        if (!MiConfigSingleton.b2().c2().getUseWebviewRecharge().booleanValue()) {
            startActivity(TXSRechargeActivity.class);
            ac.a.t(this.f12352c, "充值-原生");
            return;
        }
        RechargeParams rechargeParams = new RechargeParams();
        rechargeParams.setNight_mode(Boolean.valueOf(MiConfigSingleton.b2().A0()));
        rechargeParams.setMethod(Integer.valueOf(MiConfigSingleton.b2().j2()));
        MiWebViewActivity.startWebViewActivity(this.f12352c, rechargeParams.toHttpUrl(k.f33694e));
        ac.a.t(this.f12352c, "充值-网页");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.txs_msb_auto_buying_switcher) {
            n();
            return;
        }
        if (id2 == com.martian.libmars.R.id.martian_more) {
            startActivity(TXSCoinsRecordActivity.class);
            ac.a.t(this.f12352c, "书币明细");
        } else if (id2 == com.martian.libmars.R.id.martian_text) {
            o();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_account_coins_txs, (ViewGroup) null);
        this.f13615d = FragmentAccountCoinsTxsBinding.bind(inflate);
        MartianMoneyWithdrawViewBinding a10 = MartianMoneyWithdrawViewBinding.a(inflate.findViewById(R.id.coins_txs_view));
        this.f13616e = a10;
        a10.f12326l.setBackgroundResource(com.martian.libmars.R.drawable.border_background_dark_blue);
        this.f13616e.f12324j.setText(getString(R.string.txs_coins));
        this.f13616e.f12323i.setImageResource(R.drawable.icon_coins_recharge_blue_button);
        this.f13616e.f12316b.setVisibility(0);
        this.f13616e.f12316b.setText(getString(R.string.txs_coins_hint));
        this.f13616e.f12319e.setColorFilter(ContextCompat.getColor(this.f12352c, com.martian.libmars.R.color.white));
        this.f13615d.txsMsbAutoBuyingSwitcher.setChecked(MiUserManager.q().v());
        this.f13615d.txsMsbAutoBuyingSwitcher.setOnClickListener(this);
        this.f13616e.f12318d.setOnClickListener(this);
        this.f13616e.f12323i.setOnClickListener(this);
        ac.a.t(this.f12352c, "书币账号-展示");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        p();
    }

    public void p() {
        if (MiConfigSingleton.b2().G1().f(this.f12352c)) {
            MiConfigSingleton.b2().G1().C(this.f12352c, true, new a());
        }
    }
}
