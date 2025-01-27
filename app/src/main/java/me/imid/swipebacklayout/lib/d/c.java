package me.imid.swipebacklayout.lib.d;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import me.imid.swipebacklayout.lib.R;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: a */
    private Activity f35353a;

    /* renamed from: b */
    private SwipeBackLayout f35354b;

    class a implements SwipeBackLayout.b {
        a() {
        }

        @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.b
        public void a(int i2, float f2) {
        }

        @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.b
        public void b() {
        }

        @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.b
        public void c(int i2) {
            me.imid.swipebacklayout.lib.b.b(c.this.f35353a);
        }
    }

    public c(Activity activity) {
        this.f35353a = activity;
    }

    public View b(int i2) {
        SwipeBackLayout swipeBackLayout = this.f35354b;
        if (swipeBackLayout != null) {
            return swipeBackLayout.findViewById(i2);
        }
        return null;
    }

    public SwipeBackLayout c() {
        return this.f35354b;
    }

    public void d() {
        this.f35353a.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f35353a.getWindow().getDecorView().setBackgroundDrawable(null);
        SwipeBackLayout swipeBackLayout = (SwipeBackLayout) LayoutInflater.from(this.f35353a).inflate(R.layout.swipeback_layout, (ViewGroup) null);
        this.f35354b = swipeBackLayout;
        swipeBackLayout.p(new a());
    }

    public void e() {
        this.f35354b.q(this.f35353a);
    }
}
