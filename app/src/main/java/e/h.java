package e;

import android.window.OnBackInvokedCallback;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements OnBackInvokedCallback {

    /* renamed from: a */
    public final /* synthetic */ Runnable f25582a;

    public /* synthetic */ h(Runnable runnable) {
        this.f25582a = runnable;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.f25582a.run();
    }
}
