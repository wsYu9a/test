package com.martian.mibook.activity.account;

import android.os.Bundle;
import com.martian.libmars.activity.j1;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class MartianWithdrawOrderListActivity extends com.martian.mibook.lib.model.b.a {
    private boolean F = false;
    private int G = 0;

    public static void r2(j1 activity, int type, boolean rate) {
        Bundle bundle = new Bundle();
        bundle.putInt(MartianRPUserManager.X0, type);
        bundle.putBoolean(MartianRPUserManager.W0, rate);
        activity.startActivity(MartianWithdrawOrderListActivity.class, bundle);
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.martian_activity_withdraw_order_list);
        a2(true);
        B1();
        if (savedInstanceState != null) {
            this.G = savedInstanceState.getInt(MartianRPUserManager.X0);
            this.F = savedInstanceState.getBoolean(MartianRPUserManager.W0);
        } else {
            this.G = getIntent().getIntExtra(MartianRPUserManager.X0, 0);
            this.F = getIntent().getBooleanExtra(MartianRPUserManager.W0, false);
        }
        if (((com.martian.mibook.lib.account.c.c) getSupportFragmentManager().findFragmentByTag("withdraw_list_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, com.martian.mibook.lib.account.c.c.w(this.G, this.F), "withdraw_list_fragment").commit();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(MartianRPUserManager.X0, this.G);
        outState.putBoolean(MartianRPUserManager.W0, this.F);
        super.onSaveInstanceState(outState);
    }
}
