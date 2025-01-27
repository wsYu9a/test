package com.martian.mibook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.activity.ReadingRechargeActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;

/* loaded from: classes3.dex */
public class ReadingRechargeActivity extends MiWebViewActivity {

    /* renamed from: n0 */
    public static final String f13115n0 = "INTENT_NIGHT_MODE";

    /* renamed from: o0 */
    public static final String f13116o0 = "INTENT_WINDOW_HEIGHT";

    /* renamed from: p0 */
    public static final int f13117p0 = 486;

    /* renamed from: q0 */
    public static final int f13118q0 = 425;

    /* renamed from: l0 */
    public boolean f13119l0;

    /* renamed from: m0 */
    public int f13120m0;

    public /* synthetic */ void O5(View view) {
        finish();
    }

    public static void P5(Activity activity, String str, boolean z10, int i10, int i11) {
        MiWebViewActivity.d5(activity, str);
        Bundle bundle = new Bundle();
        bundle.putString("LIBMARS_INTENT_WEBVIEW_URL", str);
        bundle.putBoolean(f13115n0, z10);
        bundle.putInt(f13116o0, i10);
        Intent intent = new Intent(activity, (Class<?>) ReadingRechargeActivity.class);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, i11);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void B4() {
        if (A2() != null) {
            if (D3() || !this.L.canGoBack()) {
                A2().setVisibility(8);
                z2().setImageResource(R.drawable.icon_more);
            } else {
                A2().setVisibility(0);
                z2().setImageResource(R.drawable.icon_activity_back);
            }
        }
        Q5();
    }

    @Override // com.martian.mibook.activity.base.MiWebViewActivity
    public void G5(Integer num) {
        RechargeOrderDetailDialogActivity.o3(this, num, 100, this.f13119l0, this.f13120m0);
    }

    public final void Q5() {
        if (this.f13119l0) {
            z2().setColorFilter(ContextCompat.getColor(this, R.color.white));
            B2().setTextColor(ContextCompat.getColor(this, R.color.white));
            B2().setBackgroundColor(ContextCompat.getColor(this, R.color.night_background));
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.actionbar_root_view);
            if (linearLayout != null) {
                linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.night_background));
            }
            w4(R.color.white);
            y4(R.color.white);
            x4(R.color.night_background);
        }
    }

    @Override // com.martian.mibook.activity.base.MiWebViewActivity, com.martian.mibook.lib.account.activity.MiWebViewBaseActivity, com.martian.libmars.activity.WebViewActivity, com.martian.libmars.activity.RetryLoadingActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(R.anim.activity_pop_in, R.anim.activity_fade_out);
        setTheme(R.style.MiTheme_Dialog);
        g(false);
        if (bundle != null) {
            this.f13119l0 = bundle.getBoolean(f13115n0, false);
            this.f13120m0 = bundle.getInt(f13116o0, f13117p0);
        } else {
            this.f13119l0 = d1(f13115n0, true);
            this.f13120m0 = g1(f13116o0, f13117p0);
        }
        if (this.f13120m0 > 0) {
            findViewById(R.id.libmars_str_refresh_layout).getLayoutParams().height = ConfigSingleton.i(this.f13120m0);
        }
        if (425 != this.f13120m0) {
            findViewById(R.id.actionbar_top_view).setVisibility(8);
            ((LinearLayout) super.findViewById(R.id.libmars_container_view_layout)).setPadding(0, E2(), 0, 0);
            z2().setImageResource(R.drawable.icon_more);
        }
        ((RelativeLayout) super.findViewById(R.id.libmars_str_root_view)).setOnClickListener(new View.OnClickListener() { // from class: qa.o
            public /* synthetic */ o() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingRechargeActivity.this.O5(view);
            }
        });
        this.L.setBackgroundColor(ContextCompat.getColor(this, this.f13119l0 ? R.color.night_background : R.color.white));
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity
    public void v1() {
        super.v1();
        overridePendingTransition(0, R.anim.activity_pop_out);
    }
}
