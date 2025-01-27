package me.imid.swipebacklayout.lib.app;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import mi.a;
import mi.b;

/* loaded from: classes4.dex */
public class SwipeBackActivity extends AppCompatActivity implements a {

    /* renamed from: b */
    public b f28689b;

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public View findViewById(int i10) {
        b bVar;
        View findViewById = super.findViewById(i10);
        return (findViewById != null || (bVar = this.f28689b) == null) ? findViewById : bVar.a(i10);
    }

    @Override // mi.a
    public void g(boolean z10) {
        p().setEnableGesture(z10);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b bVar = new b(this);
        this.f28689b = bVar;
        bVar.c();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f28689b.d();
    }

    @Override // mi.a
    public SwipeBackLayout p() {
        return this.f28689b.b();
    }

    @Override // mi.a
    public void w0() {
        li.b.b(this);
        p().t();
    }
}
