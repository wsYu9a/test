package com.martian.mibook.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.RechargeOrderParams;
import com.martian.mibook.lib.account.response.MiRechargeOrder;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class RechargeOrderDetailActivity extends com.martian.mibook.activity.base.n {
    protected static final String Q = "RECHARGE_ORDER_ID";
    private Integer R;
    private com.martian.mibook.e.q S;

    class a extends com.martian.mibook.lib.account.d.q.f0 {
        a(j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            RechargeOrderDetailActivity.this.Q2(errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            RechargeOrderDetailActivity.this.K2(show);
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(MiRechargeOrder miRechargeOrder) {
            RechargeOrderDetailActivity.this.P2(miRechargeOrder);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void O2() {
        k1("刷新中");
        if (g2()) {
            a aVar = new a(this);
            ((RechargeOrderParams) aVar.k()).setRoid(this.R);
            aVar.j();
        }
    }

    public void P2(MiRechargeOrder miRechargeOrder) {
        B2();
        if (miRechargeOrder == null) {
            j2();
        } else {
            l2();
            S2(miRechargeOrder);
        }
    }

    public void Q2(b.d.c.b.c errorResult) {
        B2();
        k2(errorResult.d());
    }

    public static void R2(j1 activity, Integer roid, int requestCode) {
        if (roid == null || activity == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(Q, roid.intValue());
        activity.startActivityForResult(RechargeOrderDetailActivity.class, bundle, requestCode);
    }

    private void S2(MiRechargeOrder miRechargeOrder) {
        if (miRechargeOrder.getStatus() == null) {
            this.S.f12548f.setImageResource(R.drawable.process);
            this.S.f12547e.setText(getString(R.string.txs_recharge_status_process));
            this.S.f12544b.setText(getString(R.string.cd_refresh));
        } else if (miRechargeOrder.getStatus().intValue() == 2) {
            this.S.f12548f.setImageResource(R.drawable.success);
            this.S.f12547e.setText(getString(R.string.txs_recharge_status_success));
            this.S.f12544b.setVisibility(8);
            setResult(-1);
        } else {
            this.S.f12548f.setImageResource(R.drawable.process);
            this.S.f12547e.setText(getString(R.string.txs_recharge_status_process));
            this.S.f12544b.setText(getString(R.string.cd_refresh));
        }
        if (miRechargeOrder.getMoney() <= 0) {
            this.S.f12546d.setVisibility(8);
        } else {
            this.S.f12546d.setVisibility(0);
            this.S.f12545c.setText(com.martian.rpauth.d.i.n(Integer.valueOf(miRechargeOrder.getMoney())));
        }
    }

    @Override // com.martian.libmars.activity.k1
    public void K2(boolean show) {
        if (show) {
            m2(getString(R.string.loading));
        }
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1
    protected void Q0() {
        super.Q0();
        overridePendingTransition(0, R.anim.activity_pop_out);
    }

    public void RechargeOrderClick(View view) {
        O2();
    }

    @Override // com.martian.libmars.activity.k1
    public void n2() {
        O2();
    }

    public void onActionMenuClick(View view) {
        finish();
    }

    @Override // com.martian.mibook.activity.base.n, com.martian.libmars.activity.k1, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.activity_pop_in, R.anim.activity_fade_out);
        setContentView(R.layout.activity_recharge_order);
        this.S = com.martian.mibook.e.q.a(h2());
        if (savedInstanceState != null) {
            this.R = Integer.valueOf(savedInstanceState.getInt(Q, -1));
        } else {
            this.R = Integer.valueOf(v0(Q, -1));
        }
        if (this.R.intValue() == -1) {
            k1("获取订单信息失败");
            finish();
        }
        u2("完成", Typeface.DEFAULT_BOLD, R.color.theme_default_blue);
        J2(false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Integer num = this.R;
        if (num != null) {
            outState.putInt(Q, num.intValue());
        }
    }
}
