package com.martian.libmars.activity;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.gyf.immersionbar.d;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.utils.tablayout.MagicIndicator;

/* loaded from: classes3.dex */
public class BackableActivity extends MartianActivity {

    /* renamed from: w */
    public ViewStub f12014w;

    /* renamed from: x */
    public View f12015x;

    /* renamed from: y */
    public TextView f12016y;

    /* renamed from: z */
    public View f12017z;

    public ThemeImageView A2() {
        return (ThemeImageView) findViewById(R.id.actionbar_back);
    }

    public ViewStub B2() {
        return (ViewStub) findViewById(R.id.actionbar_container);
    }

    public ThemeTextView C2() {
        return (ThemeTextView) findViewById(R.id.actionbar_title);
    }

    public View D2() {
        ViewStub viewStub;
        if (this.f12015x == null && (viewStub = this.f12014w) != null) {
            this.f12015x = viewStub.inflate();
        }
        return this.f12015x;
    }

    public MagicIndicator E2() {
        return (MagicIndicator) findViewById(R.id.magic_indicator);
    }

    public ThemeLinearLayout F2() {
        return (ThemeLinearLayout) findViewById(R.id.ll_tab);
    }

    public void G2(String str) {
        TextView textView = (TextView) findViewById(R.id.actionbar_action);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(str);
        }
    }

    public void H2(String str, boolean z10, int i10) {
        ThemeTextView themeTextView = (ThemeTextView) findViewById(R.id.actionbar_action);
        if (themeTextView != null) {
            themeTextView.setTextColorType(-1);
            themeTextView.setVisibility(0);
            themeTextView.setText(str);
            if (z10) {
                themeTextView.setTypeface(Typeface.DEFAULT_BOLD);
            }
            themeTextView.setTextColor(ContextCompat.getColor(this, i10));
        }
    }

    public void I2(boolean z10) {
        View findViewById = findViewById(R.id.actionbar_top_view);
        if (findViewById != null) {
            findViewById.setVisibility(z10 ? 8 : 0);
        }
    }

    public void J2(boolean z10) {
        View view = this.f12017z;
        if (view == null) {
            return;
        }
        if (z10) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void K2(boolean z10) {
        ThemeImageView themeImageView = (ThemeImageView) findViewById(R.id.actionbar_back);
        if (themeImageView != null) {
            themeImageView.setVisibility(z10 ? 0 : 8);
        }
    }

    @Override // me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public View findViewById(int i10) {
        View findViewById = super.findViewById(i10);
        return (findViewById != null || D2() == null) ? findViewById : D2().findViewById(i10);
    }

    public void onBackClick(View view) {
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        super.setContentView(R.layout.libmars_activity_backable);
        u2(true);
        ViewStub viewStub = (ViewStub) super.findViewById(R.id.libmars_main_container);
        this.f12014w = viewStub;
        viewStub.setLayoutResource(i10);
        this.f12016y = (TextView) super.findViewById(R.id.actionbar_title);
        this.f12017z = super.findViewById(R.id.libmars_action_bar);
        this.f12016y.setText(getTitle());
        d.q3(this).V2(R.id.actionbar_top_view).a1();
    }

    @Override // com.martian.libmars.activity.MartianActivity
    public void t2(String str) {
        TextView textView = this.f12016y;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.martian.libmars.activity.MartianActivity
    public void v2(boolean z10) {
        ThemeImageView themeImageView = (ThemeImageView) findViewById(R.id.actionbar_divider);
        if (themeImageView != null) {
            themeImageView.setVisibility(z10 ? 0 : 8);
        }
    }

    public ThemeLinearLayout y2() {
        return (ThemeLinearLayout) findViewById(R.id.actionbar_root_view);
    }

    public ThemeImageView z2() {
        return (ThemeImageView) findViewById(R.id.actionbar_action_icon);
    }
}
