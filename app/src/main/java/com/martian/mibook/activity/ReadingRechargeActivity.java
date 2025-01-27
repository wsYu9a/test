package com.martian.mibook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.martian.libmars.activity.WebViewActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class ReadingRechargeActivity extends MiWebViewActivity {
    public static final String u0 = "INTENT_NIGHT_MODE";
    public static final String v0 = "INTENT_WINDOW_HEIGHT";
    public static final int w0 = 486;
    public static final int x0 = 425;
    private boolean y0;
    private int z0;

    /* renamed from: l5 */
    public /* synthetic */ void m5(View v) {
        finish();
    }

    public static void n5(Activity activity, String url, boolean nightMode, int height, int requestCode) {
        MiWebViewActivity.t4(activity, url);
        Bundle bundle = new Bundle();
        bundle.putString(WebViewActivity.Q, url);
        bundle.putBoolean(u0, nightMode);
        bundle.putInt(v0, height);
        Intent intent = new Intent(activity, (Class<?>) ReadingRechargeActivity.class);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, requestCode);
    }

    private void o5() {
        if (this.y0) {
            this.h0.setColorFilter(ContextCompat.getColor(this, R.color.white));
            this.g0.setTextColor(ContextCompat.getColor(this, R.color.white));
            this.g0.setBackgroundColor(ContextCompat.getColor(this, R.color.night_background));
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.actionbar_root_view);
            if (linearLayout != null) {
                linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.night_background));
            }
            if (this.d0 != null) {
                this.e0.setColorFilter(ContextCompat.getColor(this, R.color.white));
                this.f0.setTextColor(ContextCompat.getColor(this, R.color.white));
                this.f0.setBackgroundColor(ContextCompat.getColor(this, R.color.night_background));
            }
        }
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1
    protected void Q0() {
        super.Q0();
        overridePendingTransition(0, R.anim.activity_pop_out);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void e4() {
        if (this.d0 != null) {
            if (a3() || !this.X.canGoBack()) {
                this.d0.setVisibility(8);
                this.h0.setImageResource(R.drawable.icon_more);
            } else {
                this.d0.setVisibility(0);
                this.h0.setImageResource(R.drawable.icon_activity_back);
            }
        }
        o5();
    }

    @Override // com.martian.mibook.activity.base.MiWebViewActivity
    public void e5(Integer roid) {
        RechargeOrderDetailDialogActivity.T2(this, roid, 100, this.y0, this.z0);
    }

    @Override // com.martian.libmars.activity.WebViewActivity
    public void onCloseClick(View view) {
        finish();
    }

    @Override // com.martian.mibook.activity.base.MiWebViewActivity, com.martian.mibook.lib.account.activity.MiWebViewBaseActivity, com.martian.libmars.activity.WebViewActivity, com.martian.libmars.activity.k1, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.activity_pop_in, R.anim.activity_fade_out);
        setTheme(R.style.MiTheme_Dialog);
        d(false);
        if (savedInstanceState != null) {
            this.y0 = savedInstanceState.getBoolean(u0, false);
            this.z0 = savedInstanceState.getInt(v0, w0);
        } else {
            this.y0 = r0(u0, true);
            this.z0 = v0(v0, w0);
        }
        if (this.z0 > 0) {
            findViewById(R.id.libmars_str_refresh_layout).getLayoutParams().height = com.martian.libmars.d.h.b(this.z0);
        }
        if (425 != this.z0) {
            findViewById(R.id.actionbar_top_view).setVisibility(8);
            ((LinearLayout) super.findViewById(R.id.libmars_container_view_layout)).setPadding(0, i2(), 0, 0);
            this.h0.setImageResource(R.drawable.icon_more);
        }
        ((RelativeLayout) super.findViewById(R.id.libmars_str_root_view)).setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingRechargeActivity.this.m5(view);
            }
        });
        this.X.setBackgroundColor(ContextCompat.getColor(this, this.y0 ? R.color.night_background : R.color.white));
    }
}
