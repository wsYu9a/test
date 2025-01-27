package b.b.a.g;

/* loaded from: classes.dex */
final class c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ a f4284a;

    c(a aVar) {
        this.f4284a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a aVar = this.f4284a;
            if (aVar.f4279b != null && aVar.d()) {
                this.f4284a.f4279b.dismiss();
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f4284a.f4279b = null;
            throw th;
        }
        this.f4284a.f4279b = null;
    }
}
