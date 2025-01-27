package com.martian.mibook.activity.account;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import b.d.b.c;
import com.maritan.libweixin.c;
import com.martian.libmars.activity.j1;
import com.martian.mibook.activity.RechargeOrderDetailActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.z;
import com.martian.mibook.j.v2;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.e.c;
import com.martian.mibook.lib.account.request.auth.CreatAliPrepayParams;
import com.martian.mibook.lib.account.request.auth.CreateWxPrepayParams;
import com.martian.mibook.lib.account.response.AliRechargeOrder;
import com.martian.mibook.lib.account.response.RechargeItem;
import com.martian.mibook.lib.account.response.WXRechargeOrder;
import com.martian.mibook.ui.o.m4;
import com.martian.rpauth.response.MartianRPAccount;
import com.martian.ttbookhd.R;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.vivo.ic.dm.Constants;

/* loaded from: classes3.dex */
public class TXSRechargeActivity extends com.martian.mibook.lib.model.b.a {
    public static final int F = 100;
    private final String G = "充值处理中哦，客官稍等*^ο^*";
    private int H = MiConfigSingleton.V3().p4();
    private Integer I;
    private int J;
    private m4 K;
    private z L;

    class a implements c.e {
        a() {
        }

        @Override // com.martian.mibook.lib.account.e.c.e
        public void a(b.d.c.b.c errorResult) {
            TXSRechargeActivity.this.L.f13000b.setText("--");
        }

        @Override // com.martian.mibook.lib.account.e.c.e
        public void b(MartianRPAccount rpAccount) {
            String str;
            TextView textView = TXSRechargeActivity.this.L.f13000b;
            if (rpAccount != null) {
                str = rpAccount.getBookCoins() + "";
            } else {
                str = "--";
            }
            textView.setText(str);
        }
    }

    class b extends com.martian.mibook.lib.account.d.q.i {

        /* renamed from: j */
        final /* synthetic */ int f10861j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(j1 x0, final int val$fee_value) {
            super(x0);
            this.f10861j = val$fee_value;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            TXSRechargeActivity.this.k1("充值请求失败" + errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(AliRechargeOrder aliRechargeOrder) {
            TXSRechargeActivity.this.K2(MiUserManager.q(aliRechargeOrder, com.martian.rpauth.d.i.m(Integer.valueOf(this.f10861j))));
            if (aliRechargeOrder == null || aliRechargeOrder.getRechargeOrder() == null) {
                return;
            }
            TXSRechargeActivity.this.I = aliRechargeOrder.getRechargeOrder().getRoid();
        }
    }

    class c implements c.InterfaceC0013c {
        c() {
        }

        @Override // b.d.b.c.InterfaceC0013c
        public void a(String out_trade_no, String fee_value) {
        }

        @Override // b.d.b.c.InterfaceC0013c
        public void b(String rawResult) {
        }

        @Override // b.d.b.c.InterfaceC0013c
        public void c(String message) {
            TXSRechargeActivity.this.k1("充值处理中哦，客官稍等*^ο^*");
        }

        @Override // b.d.b.c.InterfaceC0013c
        public void d(String message) {
            TXSRechargeActivity.this.H2(message, "alipay_fail：" + TXSRechargeActivity.this.J + "," + message);
        }

        @Override // b.d.b.c.InterfaceC0013c
        public void e(String message) {
            TXSRechargeActivity.this.G2("alipay_cancel：" + TXSRechargeActivity.this.J);
        }

        @Override // b.d.b.c.InterfaceC0013c
        public void onSuccess() {
            TXSRechargeActivity.this.I2("alipay_success");
        }
    }

    class d extends com.martian.mibook.lib.account.d.q.j {
        d(j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            TXSRechargeActivity.this.k1("充值请求失败" + errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(WXRechargeOrder tyRechargeWeixinOrder) {
            TXSRechargeActivity.this.M2(MiUserManager.r(tyRechargeWeixinOrder));
            if (tyRechargeWeixinOrder == null || tyRechargeWeixinOrder.getRechargeOrder() == null) {
                return;
            }
            TXSRechargeActivity.this.I = tyRechargeWeixinOrder.getRechargeOrder().getRoid();
        }
    }

    class e implements c.d {
        e() {
        }

        @Override // com.maritan.libweixin.c.d
        public void a(String errStr) {
            TXSRechargeActivity.this.H2(errStr, "wechat_fail：" + TXSRechargeActivity.this.J + "," + errStr);
        }

        @Override // com.maritan.libweixin.c.d
        public void b(String out_trade_no, String fee_value) {
            TXSRechargeActivity.this.k1("充值处理中哦，客官稍等*^ο^*");
        }

        @Override // com.maritan.libweixin.c.d
        public void c() {
            TXSRechargeActivity.this.I2("wechat_success");
        }

        @Override // com.maritan.libweixin.c.d
        public void d() {
            TXSRechargeActivity.this.G2("wechat_cancel：" + TXSRechargeActivity.this.J);
        }
    }

    /* renamed from: A2 */
    public /* synthetic */ void B2(int position, int money) {
        this.K.f(position);
        this.J = money;
        this.L.f13002d.setText("¥" + com.martian.rpauth.d.i.n(Integer.valueOf(this.J)));
    }

    /* renamed from: C2 */
    public /* synthetic */ void D2(int position) {
        J2(position == 0 ? 0 : 1);
        O2();
    }

    /* renamed from: E2 */
    public /* synthetic */ void F2() {
        N2();
        RechargeOrderDetailActivity.R2(this, this.I, 100);
    }

    public void G2(String umengName) {
        com.martian.mibook.lib.model.g.b.x(this, umengName);
        k1("啊! 充值取消了, 撒油娜拉~~>_<~~");
    }

    public void H2(String errStr, String umengName) {
        com.martian.mibook.lib.model.g.b.x(this, umengName);
        k1("哎妈呀, 充值出错了 >_<¦¦¦, 客官再试一次呗~ - " + errStr);
    }

    public void I2(String umengName) {
        com.martian.mibook.lib.model.g.b.x(this, umengName);
        k1("淘书币充值成功, 开心萌萌哒~@^_^@~");
        if (this.I != null) {
            this.L.f13004f.postDelayed(new Runnable() { // from class: com.martian.mibook.activity.account.l
                @Override // java.lang.Runnable
                public final void run() {
                    TXSRechargeActivity.this.F2();
                }
            }, 500L);
        }
    }

    private void L2(int money) {
        this.J = money;
        if (this.H == 1) {
            x2(money);
        } else {
            y2(money);
        }
    }

    public void J2(int type) {
        this.H = type;
        MiConfigSingleton.V3().a8(type);
    }

    public void K2(final b.d.b.b product) {
        if (product == null) {
            return;
        }
        b.d.b.c.b(this, product, new c());
    }

    public void M2(final PayReq req) {
        if (req == null) {
            k1("请求失败");
        } else {
            com.maritan.libweixin.c.g().E(MiConfigSingleton.V3().W3().getRechargeWxAppid(), req, new e());
        }
    }

    public void N2() {
        com.martian.mibook.lib.account.e.c.k(this, new a());
    }

    public void O2() {
        if (MiConfigSingleton.V3().p4() == 1) {
            this.L.f13004f.setText(getString(R.string.txs_recharge_alihb));
            this.L.f13003e.setText(getString(R.string.txs_recharge_hint_first));
        } else {
            this.L.f13004f.setText(getString(R.string.txs_recharge_weixin));
            this.L.f13003e.setText(getString(R.string.txs_recharge_hint_weixin));
        }
    }

    @Override // com.martian.libmars.activity.j1
    protected void U1(boolean nightMode) {
        super.U1(nightMode);
        m4 m4Var = this.K;
        if (m4Var != null) {
            m4Var.notifyDataSetChanged();
        }
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 10001 || requestCode == 100) && resultCode == -1) {
            setResult(-1);
            N2();
        }
    }

    public void onCoinsDetailClick(View view) {
        startActivity(TXSRechargeRecordActivity.class);
        com.martian.mibook.lib.model.g.b.x(this, "充值记录");
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txs_recharge);
        z a2 = z.a(g2());
        this.L = a2;
        a2.f13001c.setNumColumns(3);
        N2();
        z2();
        O2();
    }

    public void onPaymentClick(View view) {
        if (MiConfigSingleton.V3().k2(this)) {
            L2(this.J);
        }
    }

    public void onRechargeTypeClick(View view) {
        v2.c1(this, getString(R.string.txs_choose) + getString(R.string.txs_recharge_method), this.H, new v2.d0() { // from class: com.martian.mibook.activity.account.j
            @Override // com.martian.mibook.j.v2.d0
            public final void a(int i2) {
                TXSRechargeActivity.this.D2(i2);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void x2(final int fee_value) {
        b bVar = new b(this, fee_value);
        ((CreatAliPrepayParams) bVar.k()).setMoney(Integer.valueOf(fee_value));
        bVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void y2(final int fee_value) {
        d dVar = new d(this);
        ((CreateWxPrepayParams) dVar.k()).setMoney(Integer.valueOf(fee_value));
        dVar.j();
    }

    @SuppressLint({"SetTextI18n"})
    public void z2() {
        if (this.K == null) {
            RechargeItem[] rechargeItemArr = com.martian.libmars.d.h.F().Q0() ? new RechargeItem[]{new RechargeItem(1, 1), new RechargeItem(5, 5), new RechargeItem(500, 500), new RechargeItem(1000, 1000), new RechargeItem(2000, 2000), new RechargeItem(3000, 3000), new RechargeItem(5000, 5000), new RechargeItem(10000, 10000), new RechargeItem(20000, 20000)} : new RechargeItem[]{new RechargeItem(500, 500), new RechargeItem(1000, 1000), new RechargeItem(2000, 2000), new RechargeItem(3000, 3000), new RechargeItem(5000, 5000), new RechargeItem(10000, 10000), new RechargeItem(20000, 20000), new RechargeItem(Constants.NOTI_ID_DOWNLOAD_ACTIVE_MULTI, Constants.NOTI_ID_DOWNLOAD_ACTIVE_MULTI)};
            m4 m4Var = new m4(this, new m4.a() { // from class: com.martian.mibook.activity.account.k
                @Override // com.martian.mibook.ui.o.m4.a
                public final void a(int i2, int i3) {
                    TXSRechargeActivity.this.B2(i2, i3);
                }
            });
            this.K = m4Var;
            m4Var.a(rechargeItemArr);
            this.L.f13001c.setAdapter((ListAdapter) this.K);
            this.J = rechargeItemArr[0].getMoney();
            this.L.f13002d.setText("¥" + com.martian.rpauth.d.i.n(Integer.valueOf(this.J)));
        }
        this.K.notifyDataSetChanged();
    }
}
