package b.b.a.g;

import android.app.Activity;
import android.app.ProgressDialog;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    Activity f4278a;

    /* renamed from: b */
    ProgressDialog f4279b;

    public a(Activity activity) {
        this.f4278a = activity;
    }

    private void c(CharSequence charSequence) {
        g();
        this.f4278a.runOnUiThread(new b(this, charSequence));
    }

    public final boolean d() {
        ProgressDialog progressDialog = this.f4279b;
        return progressDialog != null && progressDialog.isShowing();
    }

    public final void f() {
        g();
        this.f4278a.runOnUiThread(new b(this, "正在加载"));
    }

    public final void g() {
        this.f4278a.runOnUiThread(new c(this));
    }
}
