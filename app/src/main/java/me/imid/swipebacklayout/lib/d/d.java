package me.imid.swipebacklayout.lib.d;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

/* loaded from: classes5.dex */
public class d extends PreferenceActivity implements b {

    /* renamed from: a */
    private c f35356a;

    @Override // me.imid.swipebacklayout.lib.d.b
    public SwipeBackLayout c0() {
        return this.f35356a.c();
    }

    @Override // me.imid.swipebacklayout.lib.d.b
    public void d(boolean z) {
        c0().setEnableGesture(z);
    }

    @Override // android.app.Activity
    public View findViewById(int i2) {
        c cVar;
        View findViewById = super.findViewById(i2);
        return (findViewById != null || (cVar = this.f35356a) == null) ? findViewById : cVar.b(i2);
    }

    @Override // me.imid.swipebacklayout.lib.d.b
    public void i0() {
        c0().u();
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c cVar = new c(this);
        this.f35356a = cVar;
        cVar.d();
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f35356a.e();
    }
}
