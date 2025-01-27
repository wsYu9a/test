package com.martian.mibook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;

/* loaded from: classes3.dex */
public class RechargeOrderDetailDialogActivity extends RechargeOrderDetailActivity {
    public boolean O;
    public int P;

    public static void o3(Activity activity, Integer num, int i10, boolean z10, int i11) {
        if (num == null || activity == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(RechargeOrderDetailActivity.N, num.intValue());
        bundle.putBoolean(ReadingRechargeActivity.f13115n0, z10);
        bundle.putInt(ReadingRechargeActivity.f13116o0, i11);
        Intent intent = new Intent(activity, (Class<?>) RechargeOrderDetailDialogActivity.class);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, i10);
    }

    @Override // com.martian.mibook.activity.RechargeOrderDetailActivity, com.martian.mibook.activity.base.MiRetryLoadingActivity, com.martian.libmars.activity.RetryLoadingActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(R.anim.activity_pop_in, R.anim.activity_fade_out);
        setTheme(R.style.MiTheme_Dialog);
        g(false);
        if (bundle != null) {
            this.O = bundle.getBoolean(ReadingRechargeActivity.f13115n0, false);
            this.P = bundle.getInt(ReadingRechargeActivity.f13116o0, ReadingRechargeActivity.f13117p0);
        } else {
            this.O = d1(ReadingRechargeActivity.f13115n0, true);
            this.P = g1(ReadingRechargeActivity.f13116o0, ReadingRechargeActivity.f13117p0);
        }
        if (this.P > 0) {
            findViewById(R.id.libmars_str_refresh_layout).getLayoutParams().height = ConfigSingleton.i(this.P);
        }
        findViewById(R.id.actionbar_top_view).setVisibility(8);
        ((LinearLayout) super.findViewById(R.id.libmars_container_view_layout)).setPadding(0, E2(), 0, 0);
        z2().setImageResource(R.drawable.icon_more);
        if (this.O) {
            B2().setTextColor(ContextCompat.getColor(this, R.color.white));
            B2().setBackgroundColor(ContextCompat.getColor(this, R.color.night_background));
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.actionbar_root_view);
            if (linearLayout != null) {
                linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.night_background));
            }
        }
    }

    @Override // com.martian.mibook.activity.RechargeOrderDetailActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(ReadingRechargeActivity.f13115n0, this.O);
        bundle.putInt(ReadingRechargeActivity.f13116o0, this.P);
    }

    @Override // com.martian.mibook.activity.RechargeOrderDetailActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity
    public void v1() {
        super.v1();
        overridePendingTransition(0, R.anim.activity_pop_out);
    }
}
