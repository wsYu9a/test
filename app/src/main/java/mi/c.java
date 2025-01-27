package mi;

import android.app.Activity;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

/* loaded from: classes4.dex */
public class c implements SwipeBackLayout.c {

    /* renamed from: a */
    public final WeakReference<Activity> f28709a;

    public c(@NonNull Activity activity) {
        this.f28709a = new WeakReference<>(activity);
    }

    @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.c
    public void b() {
        Activity activity = this.f28709a.get();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
        activity.overridePendingTransition(0, 0);
    }

    @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.b
    public void d(int i10) {
        Activity activity = this.f28709a.get();
        if (activity != null) {
            li.b.b(activity);
        }
    }

    @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.b
    public void c() {
    }

    @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.b
    public void a(int i10, float f10) {
    }
}
