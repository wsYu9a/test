package me.imid.swipebacklayout.lib.app;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import mi.a;
import mi.b;

/* loaded from: classes4.dex */
public class SwipeBackPreferenceActivity extends PreferenceActivity implements a {

    /* renamed from: b */
    public b f28690b;

    @Override // android.app.Activity
    public View findViewById(int i10) {
        b bVar;
        View findViewById = super.findViewById(i10);
        return (findViewById != null || (bVar = this.f28690b) == null) ? findViewById : bVar.a(i10);
    }

    @Override // mi.a
    public void g(boolean z10) {
        p().setEnableGesture(z10);
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b bVar = new b(this);
        this.f28690b = bVar;
        bVar.c();
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f28690b.d();
    }

    @Override // mi.a
    public SwipeBackLayout p() {
        return this.f28690b.b();
    }

    @Override // mi.a
    public void w0() {
        p().t();
    }
}
