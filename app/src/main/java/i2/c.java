package i2;

/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: b */
    public final /* synthetic */ b f26837b;

    public c(b bVar) {
        this.f26837b = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f26837b.d();
        } catch (Exception e10) {
            d.c(e10);
        }
    }
}
