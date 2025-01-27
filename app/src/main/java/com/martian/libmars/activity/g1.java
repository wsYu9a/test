package com.martian.libmars.activity;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.gyf.barlibrary.ImmersionBar;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes2.dex */
public class g1 extends j1 {
    protected ViewStub B;
    private View C;
    protected TextView D;
    private View E;

    @Override // com.martian.libmars.activity.j1
    public void Z1(String title) {
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(title);
        }
    }

    @Override // com.martian.libmars.activity.j1
    public void d2(boolean show) {
        ThemeImageView themeImageView = (ThemeImageView) findViewById(R.id.actionbar_divider);
        if (themeImageView != null) {
            themeImageView.setVisibility(show ? 0 : 8);
        }
    }

    @Override // me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public View findViewById(int id) {
        View findViewById = super.findViewById(id);
        return findViewById == null ? g2().findViewById(id) : findViewById;
    }

    public View g2() {
        if (this.C == null) {
            this.C = this.B.inflate();
        }
        return this.C;
    }

    public void h2() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setVisibility(8);
        }
        d2(false);
    }

    public void i2(int color) {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) findViewById(R.id.actionbar_root_view);
        if (themeLinearLayout != null) {
            themeLinearLayout.setBackgroundColor(color);
        }
    }

    public void j2() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.actionbar_root_view);
        if (linearLayout != null) {
            linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        }
    }

    public void k2(String menu) {
        TextView textView = (TextView) findViewById(R.id.actionbar_action);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(menu);
        }
    }

    public void l2(String menu, boolean bold, int textColor) {
        ThemeTextView themeTextView = (ThemeTextView) findViewById(R.id.actionbar_action);
        if (themeTextView != null) {
            themeTextView.setTextColorType(-1);
            themeTextView.setVisibility(0);
            themeTextView.setText(menu);
            if (bold) {
                themeTextView.setTypeface(Typeface.DEFAULT_BOLD);
            }
            themeTextView.setTextColor(ContextCompat.getColor(this, textColor));
        }
    }

    public void m2(int resId) {
        ThemeImageView themeImageView = (ThemeImageView) findViewById(R.id.actionbar_action_icon);
        if (themeImageView != null) {
            themeImageView.setVisibility(0);
            themeImageView.setImageResource(resId);
        }
    }

    public void n2(boolean isFullScreen) {
        View findViewById = findViewById(R.id.actionbar_top_view);
        if (findViewById != null) {
            findViewById.setVisibility(isFullScreen ? 8 : 0);
        }
    }

    public void o2(boolean z) {
        TextView textView = this.D;
        if (textView instanceof ThemeTextView) {
            ((ThemeTextView) textView).setWithTypeFace(z ? 1 : 0);
        }
    }

    public void onBackClick(View view) {
        finish();
    }

    public void p2(boolean show) {
        View view = this.E;
        if (view == null) {
            return;
        }
        if (show) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void q2(boolean show) {
        ThemeImageView themeImageView = (ThemeImageView) findViewById(R.id.actionbar_back);
        if (themeImageView != null) {
            themeImageView.setVisibility(show ? 0 : 8);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.libmars_activity_backable);
        a2(true);
        ViewStub viewStub = (ViewStub) super.findViewById(R.id.libmars_main_container);
        this.B = viewStub;
        viewStub.setLayoutResource(layoutResID);
        this.D = (TextView) super.findViewById(R.id.actionbar_title);
        this.E = super.findViewById(R.id.libmars_action_bar);
        this.D.setText(getTitle());
        ImmersionBar.with(this).statusBarView(R.id.actionbar_top_view).init();
    }
}
