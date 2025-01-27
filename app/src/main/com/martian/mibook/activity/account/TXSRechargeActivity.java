package com.martian.mibook.activity.account;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.media3.session.SessionCommand;
import ce.q;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.activity.RechargeOrderDetailActivity;
import com.martian.mibook.activity.account.TXSRechargeActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityTxsRechargeBinding;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.request.auth.CreatAliPrepayParams;
import com.martian.mibook.lib.account.request.auth.CreateWxPrepayParams;
import com.martian.mibook.lib.account.response.AliRechargeOrder;
import com.martian.mibook.lib.account.response.RechargeItem;
import com.martian.mibook.lib.account.response.WXRechargeOrder;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import com.martian.rpauth.response.MartianRPAccount;
import com.tencent.mm.opensdk.modelpay.PayReq;
import e8.b;
import je.v0;
import kb.g;
import kb.h;
import lb.c;
import oe.f;
import z7.b;

/* loaded from: classes3.dex */
public class TXSRechargeActivity extends MiBackableActivity {
    public static final int J = 100;
    public final String A = ConfigSingleton.D().s("充值成功");
    public final String B = ConfigSingleton.D().s("充值取消了~~>_<~~");
    public final String C = ConfigSingleton.D().s("哎妈呀, 充值出错了 >_<¦¦¦, 客官再试一次呗~");
    public final String D = ConfigSingleton.D().s("充值处理中");
    public int E = MiConfigSingleton.b2().j2();
    public Integer F;
    public int G;
    public q H;
    public ActivityTxsRechargeBinding I;

    public class a implements c.i {
        public a() {
        }

        @Override // lb.c.i
        public void a(x8.c cVar) {
            TXSRechargeActivity.this.I.txsCoinsAmount.setText("--");
        }

        @Override // lb.c.i
        public void b(MartianRPAccount martianRPAccount) {
            String str;
            TextView textView = TXSRechargeActivity.this.I.txsCoinsAmount;
            if (martianRPAccount != null) {
                str = martianRPAccount.getBookCoins() + "";
            } else {
                str = "--";
            }
            textView.setText(str);
        }
    }

    public class b extends g {

        /* renamed from: k */
        public final /* synthetic */ int f13141k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Activity activity, int i10) {
            super(activity);
            this.f13141k = i10;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            TXSRechargeActivity.this.P1("充值请求失败" + cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(AliRechargeOrder aliRechargeOrder) {
            TXSRechargeActivity.this.f3(MiUserManager.o(aliRechargeOrder, f.n(Integer.valueOf(this.f13141k))));
            if (aliRechargeOrder == null || aliRechargeOrder.getRechargeOrder() == null) {
                return;
            }
            TXSRechargeActivity.this.F = aliRechargeOrder.getRechargeOrder().getRoid();
        }
    }

    public class c implements b.c {
        public c() {
        }

        @Override // e8.b.c
        public void a(String str) {
        }

        @Override // e8.b.c
        public void b(String str, String str2) {
        }

        @Override // e8.b.c
        public void c(String str) {
        }

        @Override // e8.b.c
        public void d(String str) {
            TXSRechargeActivity tXSRechargeActivity = TXSRechargeActivity.this;
            tXSRechargeActivity.P1(tXSRechargeActivity.D);
        }

        @Override // e8.b.c
        public void e() {
        }

        @Override // e8.b.c
        public void f(String str) {
            TXSRechargeActivity.this.b3("alipay_cancel：" + TXSRechargeActivity.this.G);
        }

        @Override // e8.b.c
        public void onFailure(String str) {
            TXSRechargeActivity.this.c3(str, "alipay_fail：" + TXSRechargeActivity.this.G + "," + str);
        }

        @Override // e8.b.c
        public void onSuccess() {
            TXSRechargeActivity.this.d3("alipay_success");
        }
    }

    public class d extends h {

        /* renamed from: k */
        public final /* synthetic */ int f13144k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Activity activity, int i10) {
            super(activity);
            this.f13144k = i10;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            TXSRechargeActivity.this.P1("充值请求失败" + cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(WXRechargeOrder wXRechargeOrder) {
            TXSRechargeActivity.this.h3(MiUserManager.p(wXRechargeOrder), String.valueOf(this.f13144k));
            if (wXRechargeOrder == null || wXRechargeOrder.getRechargeOrder() == null) {
                return;
            }
            TXSRechargeActivity.this.F = wXRechargeOrder.getRechargeOrder().getRoid();
        }
    }

    public class e implements b.c {
        public e() {
        }

        @Override // z7.b.c
        public void a(String str) {
            TXSRechargeActivity.this.c3(str, "wechat_fail：" + TXSRechargeActivity.this.G + "," + str);
        }

        @Override // z7.b.c
        public void b(String str, String str2) {
            TXSRechargeActivity tXSRechargeActivity = TXSRechargeActivity.this;
            tXSRechargeActivity.P1(tXSRechargeActivity.D);
        }

        @Override // z7.b.c
        public void c() {
            TXSRechargeActivity.this.d3("wechat_success");
        }

        @Override // z7.b.c
        public void d() {
            TXSRechargeActivity.this.b3("wechat_cancel：" + TXSRechargeActivity.this.G);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void V2(int i10) {
        b bVar = new b(this, i10);
        ((CreatAliPrepayParams) bVar.k()).setMoney(Integer.valueOf(i10));
        bVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void W2(int i10) {
        d dVar = new d(this, i10);
        ((CreateWxPrepayParams) dVar.k()).setMoney(Integer.valueOf(i10));
        dVar.j();
    }

    @SuppressLint({"SetTextI18n"})
    public void X2() {
        if (this.H == null) {
            RechargeItem[] rechargeItemArr = ConfigSingleton.D().J0() ? new RechargeItem[]{new RechargeItem(1, 1), new RechargeItem(5, 5), new RechargeItem(500, 500), new RechargeItem(1000, 1000), new RechargeItem(2000, 2000), new RechargeItem(3000, 3000), new RechargeItem(5000, 5000), new RechargeItem(10000, 10000), new RechargeItem(20000, 20000)} : new RechargeItem[]{new RechargeItem(500, 500), new RechargeItem(1000, 1000), new RechargeItem(2000, 2000), new RechargeItem(3000, 3000), new RechargeItem(5000, 5000), new RechargeItem(10000, 10000), new RechargeItem(20000, 20000), new RechargeItem(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT)};
            q qVar = new q(this, new q.a() { // from class: ra.i
                public /* synthetic */ i() {
                }

                @Override // ce.q.a
                public final void a(int i10, int i11) {
                    TXSRechargeActivity.this.Y2(i10, i11);
                }
            });
            this.H = qVar;
            qVar.b(rechargeItemArr);
            this.I.txsRechargeList.setAdapter((ListAdapter) this.H);
            this.G = rechargeItemArr[0].getMoney();
            this.I.txsRechargeMoney.setText("¥" + f.o(Integer.valueOf(this.G)));
        }
        this.H.notifyDataSetChanged();
    }

    public final /* synthetic */ void Y2(int i10, int i11) {
        this.H.f(i10);
        this.G = i11;
        this.I.txsRechargeMoney.setText("¥" + f.o(Integer.valueOf(this.G)));
    }

    public final /* synthetic */ void Z2(int i10) {
        e3(i10 == 0 ? 0 : 1);
        j3();
    }

    public final /* synthetic */ void a3() {
        i3();
        RechargeOrderDetailActivity.m3(this, this.F, 100);
    }

    public final void b3(String str) {
        ac.a.t(this, str);
        P1(this.B);
    }

    public final void c3(String str, String str2) {
        ac.a.t(this, str2);
        P1(this.C + " - " + str);
    }

    public final void d3(String str) {
        ac.a.t(this, str);
        P1(this.A);
        if (this.F != null) {
            this.I.txsRechargeType.postDelayed(new Runnable() { // from class: ra.j
                public /* synthetic */ j() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    TXSRechargeActivity.this.a3();
                }
            }, 500L);
        }
    }

    public void e3(int i10) {
        this.E = i10;
        MiConfigSingleton.b2().k3(i10);
    }

    public void f3(e8.a aVar) {
        if (aVar == null) {
            return;
        }
        e8.b.b(this, aVar, new c());
    }

    public final void g3(int i10) {
        this.G = i10;
        if (this.E == 1) {
            V2(i10);
        } else {
            W2(i10);
        }
    }

    public void h3(PayReq payReq, String str) {
        if (payReq == null) {
            P1("请求失败");
        } else {
            z7.b.d().x(this, MiConfigSingleton.b2().c2().getRechargeWxAppid(), str, payReq, new e());
        }
    }

    public void i3() {
        MiConfigSingleton.b2().G1().C(this, true, new a());
    }

    public void j3() {
        if (MiConfigSingleton.b2().j2() == 1) {
            this.I.txsRechargeType.setText(getString(R.string.txs_recharge_alihb));
            this.I.txsRechargeRule.setText(getString(R.string.txs_recharge_hint_first));
        } else {
            this.I.txsRechargeType.setText(getString(R.string.txs_recharge_weixin));
            this.I.txsRechargeRule.setText(getString(R.string.txs_recharge_hint_weixin));
        }
    }

    @Override // com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if ((i10 == 10001 || i10 == 100) && i11 == -1) {
            setResult(-1);
            i3();
        }
    }

    public void onCoinsDetailClick(View view) {
        startActivity(TXSRechargeRecordActivity.class);
        ac.a.t(this, "充值记录");
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.martian.mibook.R.layout.activity_txs_recharge);
        ActivityTxsRechargeBinding bind = ActivityTxsRechargeBinding.bind(D2());
        this.I = bind;
        bind.txsRechargeList.setNumColumns(3);
        i3();
        X2();
        j3();
    }

    public void onPaymentClick(View view) {
        if (MiConfigSingleton.b2().G1().f(this)) {
            g3(this.G);
        }
    }

    public void onRechargeTypeClick(View view) {
        v0.X0(this, getString(R.string.txs_choose) + getString(R.string.txs_recharge_method), this.E, new v0.o() { // from class: ra.k
            public /* synthetic */ k() {
            }

            @Override // je.v0.o
            public final void a(int i10) {
                TXSRechargeActivity.this.Z2(i10);
            }
        });
    }

    @Override // com.martian.libmars.activity.MartianActivity
    public void p2(boolean z10) {
        super.p2(z10);
        q qVar = this.H;
        if (qVar != null) {
            qVar.notifyDataSetChanged();
        }
    }
}
