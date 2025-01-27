package mj;

import com.sntech.net.NetCallback;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class h implements NetCallback {

    /* renamed from: a */
    public final /* synthetic */ AtomicBoolean f28712a;

    /* renamed from: b */
    public final /* synthetic */ Object f28713b;

    public h(AtomicBoolean atomicBoolean, Object obj) {
        this.f28712a = atomicBoolean;
        this.f28713b = obj;
    }

    @Override // com.sntech.net.NetCallback
    public final void onFailure(Exception exc) {
        this.f28712a.set(false);
        synchronized (this.f28713b) {
            this.f28713b.notify();
        }
    }

    @Override // com.sntech.net.NetCallback
    public final void onSuccess(String str) {
        this.f28712a.set(true);
        synchronized (this.f28713b) {
            this.f28713b.notify();
        }
    }
}
