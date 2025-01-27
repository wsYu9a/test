package uk.co.senab.actionbarpulltorefresh.extras.actionbarcompat;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarActivity;
import uk.co.senab.actionbarpulltorefresh.library.d;
import uk.co.senab.actionbarpulltorefresh.library.e;
import uk.co.senab.actionbarpulltorefresh.library.g;
import uk.co.senab.actionbarpulltorefresh.library.h;

/* loaded from: classes5.dex */
class b extends h {
    private FrameLayout B;

    public static class a implements d {
        @Override // uk.co.senab.actionbarpulltorefresh.library.d
        public Context a(Activity activity) {
            ActionBar supportActionBar = ((ActionBarActivity) activity).getSupportActionBar();
            Context themedContext = supportActionBar != null ? supportActionBar.getThemedContext() : null;
            return themedContext == null ? activity : themedContext;
        }
    }

    protected b(Activity activity, g gVar) {
        super(activity, gVar);
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.h
    protected void J(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.J(view);
            return;
        }
        FrameLayout frameLayout = this.B;
        if (frameLayout != null) {
            super.J(frameLayout);
        }
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.h
    protected void c(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.c(view);
            return;
        }
        FrameLayout frameLayout = new FrameLayout(k());
        this.B = frameLayout;
        frameLayout.addView(view);
        super.c(this.B);
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.h
    protected d h() {
        return new a();
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.h
    protected e i() {
        return new uk.co.senab.actionbarpulltorefresh.extras.actionbarcompat.a();
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.h
    protected void z(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.z(view);
            return;
        }
        FrameLayout frameLayout = this.B;
        if (frameLayout != null) {
            super.z(frameLayout);
            this.B = null;
        }
    }
}
