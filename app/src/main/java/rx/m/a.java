package rx.m;

/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a */
    protected static final String f36913a = ".errorRendering";

    public void a(Throwable th) {
    }

    @rx.j.b
    public final String b(Object obj) {
        try {
            return c(obj);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + f36913a;
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            return obj.getClass().getName() + f36913a;
        }
    }

    @rx.j.b
    protected String c(Object obj) throws InterruptedException {
        return null;
    }
}
