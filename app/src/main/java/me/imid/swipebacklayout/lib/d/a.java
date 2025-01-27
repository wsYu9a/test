package me.imid.swipebacklayout.lib.d;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

/* loaded from: classes.dex */
public class a extends AppCompatActivity implements b {

    /* renamed from: a */
    private c f35352a;

    @Override // me.imid.swipebacklayout.lib.d.b
    public SwipeBackLayout c0() {
        return this.f35352a.c();
    }

    @Override // me.imid.swipebacklayout.lib.d.b
    public void d(boolean z) {
        c0().setEnableGesture(z);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public View findViewById(int i2) {
        c cVar;
        View findViewById = super.findViewById(i2);
        return (findViewById != null || (cVar = this.f35352a) == null) ? findViewById : cVar.b(i2);
    }

    @Override // me.imid.swipebacklayout.lib.d.b
    public void i0() {
        me.imid.swipebacklayout.lib.b.b(this);
        c0().u();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c cVar = new c(this);
        this.f35352a = cVar;
        cVar.d();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f35352a.e();
    }
}
