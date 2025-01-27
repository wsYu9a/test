package com.martian.mibook.activity;

import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.martian.libmars.activity.j1;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class RechargeOrderDetailDialogActivity extends RechargeOrderDetailActivity {
    private boolean T;
    private int U;

    public static void T2(j1 activity, Integer roid, int requestCode, boolean nightMode, int height) {
        if (roid == null || activity == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("RECHARGE_ORDER_ID", roid.intValue());
        bundle.putBoolean(ReadingRechargeActivity.u0, nightMode);
        bundle.putInt(ReadingRechargeActivity.v0, height);
        activity.startActivityForResult(RechargeOrderDetailDialogActivity.class, bundle, requestCode);
    }

    @Override // com.martian.mibook.activity.RechargeOrderDetailActivity, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1
    protected void Q0() {
        super.Q0();
        overridePendingTransition(0, R.anim.activity_pop_out);
    }

    @Override // com.martian.mibook.activity.RechargeOrderDetailActivity, com.martian.mibook.activity.base.n, com.martian.libmars.activity.k1, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.activity_pop_in, R.anim.activity_fade_out);
        setTheme(R.style.MiTheme_Dialog);
        d(false);
        if (savedInstanceState != null) {
            this.T = savedInstanceState.getBoolean(ReadingRechargeActivity.u0, false);
            this.U = savedInstanceState.getInt(ReadingRechargeActivity.v0, ReadingRechargeActivity.w0);
        } else {
            this.T = r0(ReadingRechargeActivity.u0, true);
            this.U = v0(ReadingRechargeActivity.v0, ReadingRechargeActivity.w0);
        }
        if (this.U > 0) {
            findViewById(R.id.libmars_str_refresh_layout).getLayoutParams().height = com.martian.libmars.d.h.b(this.U);
        }
        findViewById(R.id.actionbar_top_view).setVisibility(8);
        ((LinearLayout) super.findViewById(R.id.libmars_container_view_layout)).setPadding(0, i2(), 0, 0);
        this.J.setImageResource(R.drawable.icon_more);
        if (this.T) {
            this.L.setTextColor(ContextCompat.getColor(this, R.color.white));
            this.L.setBackgroundColor(ContextCompat.getColor(this, R.color.night_background));
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.actionbar_root_view);
            if (linearLayout != null) {
                linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.night_background));
            }
        }
    }

    @Override // com.martian.mibook.activity.RechargeOrderDetailActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(ReadingRechargeActivity.u0, this.T);
        outState.putInt(ReadingRechargeActivity.v0, this.U);
    }
}
