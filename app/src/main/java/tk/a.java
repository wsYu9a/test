package tk;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarActivity;
import uk.c;
import uk.d;
import uk.f;

/* loaded from: classes5.dex */
public class a extends f {
    public FrameLayout B;

    /* renamed from: tk.a$a */
    public static class C0790a implements c {
        @Override // uk.c
        public Context a(Activity activity) {
            ActionBar supportActionBar = ((ActionBarActivity) activity).getSupportActionBar();
            Context themedContext = supportActionBar != null ? supportActionBar.getThemedContext() : null;
            return themedContext == null ? activity : themedContext;
        }
    }

    public a(Activity activity, uk.co.senab.actionbarpulltorefresh.library.b bVar) {
        super(activity, bVar);
    }

    @Override // uk.f
    public void J(View view) {
        super.J(view);
    }

    @Override // uk.f
    public void c(View view) {
        super.c(view);
    }

    @Override // uk.f
    public c h() {
        return new C0790a();
    }

    @Override // uk.f
    public d i() {
        return new uk.co.senab.actionbarpulltorefresh.extras.actionbarcompat.a();
    }

    @Override // uk.f
    public void z(View view) {
        super.z(view);
    }
}
