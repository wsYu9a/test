package g0;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Executor {

    /* renamed from: b */
    public final /* synthetic */ Handler f26117b;

    public /* synthetic */ a(Handler handler) {
        this.f26117b = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f26117b.post(runnable);
    }
}
