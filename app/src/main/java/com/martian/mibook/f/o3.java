package com.martian.mibook.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.martian.mibook.activity.account.TXSCoinsRecordActivity;
import com.martian.mibook.activity.account.TXSRechargeActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.e.c;
import com.martian.mibook.lib.account.request.RechargeParams;
import com.martian.rpauth.response.MartianRPAccount;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class o3 extends com.martian.libmars.f.f implements View.OnClickListener {

    /* renamed from: b */
    private com.martian.libmars.activity.j1 f13222b;

    /* renamed from: c */
    private com.martian.mibook.e.v2 f13223c;

    /* renamed from: d */
    private com.martian.libmars.e.h0 f13224d;

    class a implements c.e {
        a() {
        }

        @Override // com.martian.mibook.lib.account.e.c.e
        public void a(b.d.c.b.c errorResult) {
            if (com.martian.libmars.utils.n0.c(o3.this.f13222b)) {
                return;
            }
            o3.this.f13224d.f9993g.setText("获取失败");
        }

        @Override // com.martian.mibook.lib.account.e.c.e
        @SuppressLint({"SetTextI18n"})
        public void b(MartianRPAccount rpAccount) {
            if (com.martian.libmars.utils.n0.c(o3.this.f13222b) || rpAccount == null) {
                return;
            }
            o3.this.f13224d.f9993g.setText(rpAccount.getBookCoins() + "");
        }
    }

    private void e() {
        boolean z = !MiUserManager.s().A();
        MiUserManager.s().C(z);
        this.f13223c.f12823d.setChecked(z);
        com.martian.mibook.lib.model.g.b.x(a(), "自动购买:" + z);
    }

    private void f() {
        if (!MiConfigSingleton.V3().W3().getUseWebviewRecharge().booleanValue()) {
            startActivity(TXSRechargeActivity.class);
            com.martian.mibook.lib.model.g.b.x(this.f13222b, "充值-原生");
            return;
        }
        RechargeParams rechargeParams = new RechargeParams();
        rechargeParams.setNight_mode(Boolean.valueOf(MiConfigSingleton.V3().I0()));
        rechargeParams.setMethod(Integer.valueOf(MiConfigSingleton.V3().p4()));
        MiWebViewActivity.f5(this.f13222b, rechargeParams.toHttpUrl("UTF8"));
        com.martian.mibook.lib.model.g.b.x(this.f13222b, "充值-网页");
    }

    public void g() {
        if (MiConfigSingleton.V3().k2(this.f13222b)) {
            com.martian.mibook.lib.account.e.c.k(this.f13222b, new a());
        }
    }

    @Override // com.martian.libmars.f.f, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f13222b = (com.martian.libmars.activity.j1) context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.txs_msb_auto_buying_switcher) {
            e();
            return;
        }
        if (id == R.id.martian_more) {
            startActivity(TXSCoinsRecordActivity.class);
            com.martian.mibook.lib.model.g.b.x(this.f13222b, "书币明细");
        } else if (id == R.id.martian_text) {
            f();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_account_coins_txs, (ViewGroup) null);
        this.f13223c = com.martian.mibook.e.v2.a(inflate);
        com.martian.libmars.e.h0 a2 = com.martian.libmars.e.h0.a(inflate.findViewById(R.id.coins_txs_view));
        this.f13224d = a2;
        a2.l.setBackgroundResource(R.drawable.border_background_dark_blue);
        this.f13224d.f9996j.setText(getString(R.string.txs_coins));
        this.f13224d.f9995i.setImageResource(R.drawable.icon_coins_recharge_blue_button);
        this.f13224d.f9988b.setVisibility(0);
        this.f13224d.f9988b.setText(getString(R.string.txs_coins_hint));
        this.f13224d.f9991e.setColorFilter(ContextCompat.getColor(this.f13222b, R.color.white));
        this.f13223c.f12823d.setChecked(MiUserManager.s().A());
        this.f13223c.f12823d.setOnClickListener(this);
        this.f13224d.f9990d.setOnClickListener(this);
        this.f13224d.f9995i.setOnClickListener(this);
        com.martian.mibook.lib.model.g.b.x(this.f13222b, "书币账号-展示");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        g();
    }
}
