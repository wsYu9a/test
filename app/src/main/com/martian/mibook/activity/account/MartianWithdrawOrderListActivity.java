package com.martian.mibook.activity.account;

import android.os.Bundle;
import com.martian.mibook.R;
import com.martian.mibook.lib.account.fragment.MartianWithdrawOrderListFragment;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import com.martian.rpauth.MartianRPUserManager;

/* loaded from: classes3.dex */
public class MartianWithdrawOrderListActivity extends MiBackableActivity {
    public boolean A = false;
    public int B = 0;

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.martian_activity_withdraw_order_list);
        u2(true);
        g2();
        if (bundle != null) {
            this.B = bundle.getInt(MartianRPUserManager.f16198v);
            this.A = bundle.getBoolean(MartianRPUserManager.f16197u);
        } else {
            this.B = getIntent().getIntExtra(MartianRPUserManager.f16198v, 0);
            this.A = getIntent().getBooleanExtra(MartianRPUserManager.f16197u, false);
        }
        if (((MartianWithdrawOrderListFragment) getSupportFragmentManager().findFragmentByTag("withdraw_list_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, MartianWithdrawOrderListFragment.Q(this.B, this.A), "withdraw_list_fragment").commit();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(MartianRPUserManager.f16198v, this.B);
        bundle.putBoolean(MartianRPUserManager.f16197u, this.A);
        super.onSaveInstanceState(bundle);
    }
}
