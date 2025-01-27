package com.martian.mibook.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.martian.libmars.R;
import com.martian.mibook.activity.base.MiRetryLoadingActivity;
import com.martian.mibook.databinding.ActivityRechargeOrderBinding;
import com.martian.mibook.lib.account.request.auth.RechargeOrderParams;
import com.martian.mibook.lib.account.response.MiRechargeOrder;
import kb.x;
import oe.f;
import x8.c;

/* loaded from: classes3.dex */
public class RechargeOrderDetailActivity extends MiRetryLoadingActivity {
    public static final String N = "RECHARGE_ORDER_ID";
    public Integer L;
    public ActivityRechargeOrderBinding M;

    public class a extends x {
        public a(Activity activity) {
            super(activity);
        }

        @Override // jb.k
        public void s(c cVar) {
            RechargeOrderDetailActivity.this.l3(cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            RechargeOrderDetailActivity.this.f3(z10);
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(MiRechargeOrder miRechargeOrder) {
            RechargeOrderDetailActivity.this.k3(miRechargeOrder);
        }
    }

    public static void m3(Activity activity, Integer num, int i10) {
        if (num == null || activity == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(N, num.intValue());
        Intent intent = new Intent(activity, (Class<?>) RechargeOrderDetailActivity.class);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, i10);
    }

    @Override // com.martian.libmars.activity.RetryLoadingActivity
    public void J2() {
        j3();
    }

    public void RechargeOrderClick(View view) {
        j3();
    }

    @Override // com.martian.libmars.activity.RetryLoadingActivity
    public void f3(boolean z10) {
        if (z10) {
            I2(getString(R.string.loading));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j3() {
        P1("刷新中");
        if (y2()) {
            a aVar = new a(this);
            ((RechargeOrderParams) aVar.k()).setRoid(this.L);
            aVar.j();
        }
    }

    public final void k3(MiRechargeOrder miRechargeOrder) {
        X2();
        if (miRechargeOrder == null) {
            F2();
        } else {
            H2();
            n3(miRechargeOrder);
        }
    }

    public final void l3(c cVar) {
        X2();
        G2(cVar.d());
    }

    public final void n3(MiRechargeOrder miRechargeOrder) {
        if (miRechargeOrder.getStatus() == null) {
            this.M.orderStatusLogo.setImageResource(com.martian.mibook.R.drawable.process);
            this.M.orderStatus.setText(getString(com.martian.mibook.lib.account.R.string.txs_recharge_status_process));
            this.M.orderBack.setText(getString(com.martian.mibook.R.string.cd_refresh));
        } else if (miRechargeOrder.getStatus().intValue() == 2) {
            this.M.orderStatusLogo.setImageResource(com.martian.mibook.R.drawable.success);
            this.M.orderStatus.setText(getString(com.martian.mibook.lib.account.R.string.txs_recharge_status_success));
            this.M.orderBack.setVisibility(8);
            setResult(-1);
        } else {
            this.M.orderStatusLogo.setImageResource(com.martian.mibook.R.drawable.process);
            this.M.orderStatus.setText(getString(com.martian.mibook.lib.account.R.string.txs_recharge_status_process));
            this.M.orderBack.setText(getString(com.martian.mibook.R.string.cd_refresh));
        }
        if (miRechargeOrder.getMoney() <= 0) {
            this.M.orderMoneyView.setVisibility(8);
        } else {
            this.M.orderMoneyView.setVisibility(0);
            this.M.orderMoney.setText(f.o(Integer.valueOf(miRechargeOrder.getMoney())));
        }
    }

    public void onActionMenuClick(View view) {
        finish();
    }

    @Override // com.martian.mibook.activity.base.MiRetryLoadingActivity, com.martian.libmars.activity.RetryLoadingActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(R.anim.activity_pop_in, R.anim.activity_fade_out);
        setContentView(com.martian.mibook.R.layout.activity_recharge_order);
        this.M = ActivityRechargeOrderBinding.bind(C2());
        if (bundle != null) {
            this.L = Integer.valueOf(bundle.getInt(N, -1));
        } else {
            this.L = Integer.valueOf(g1(N, -1));
        }
        if (this.L.intValue() == -1) {
            P1("获取订单信息失败");
            finish();
        }
        Q2("完成", Typeface.DEFAULT_BOLD, R.color.theme_default);
        e3(false);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Integer num = this.L;
        if (num != null) {
            bundle.putInt(N, num.intValue());
        }
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity
    public void v1() {
        super.v1();
        overridePendingTransition(0, R.anim.activity_pop_out);
    }
}
