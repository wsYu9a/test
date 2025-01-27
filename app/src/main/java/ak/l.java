package ak;

/* loaded from: classes5.dex */
public class l implements qj.h {

    /* renamed from: b */
    public final qj.h f278b;

    public l(qj.h hVar) {
        this.f278b = hVar;
    }

    @Override // qj.h
    public synchronized boolean isUnsubscribed() {
        return this.f278b.isUnsubscribed();
    }

    @Override // qj.h
    public synchronized void unsubscribe() {
        this.f278b.unsubscribe();
    }
}
