package mi;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import me.imid.swipebacklayout.lib.R;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public Activity f28707a;

    /* renamed from: b */
    public SwipeBackLayout f28708b;

    public b(Activity activity) {
        this.f28707a = activity;
    }

    public View a(int i10) {
        SwipeBackLayout swipeBackLayout = this.f28708b;
        if (swipeBackLayout != null) {
            return swipeBackLayout.findViewById(i10);
        }
        return null;
    }

    public SwipeBackLayout b() {
        return this.f28708b;
    }

    public void c() {
        this.f28707a.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f28707a.getWindow().getDecorView().setBackgroundDrawable(null);
        this.f28708b = (SwipeBackLayout) LayoutInflater.from(this.f28707a).inflate(R.layout.swipeback_layout, (ViewGroup) null);
    }

    public void d() {
        this.f28708b.p(this.f28707a);
    }
}
