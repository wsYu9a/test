package fk;

/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a */
    public static final String f26055a = ".errorRendering";

    @uj.b
    public final String b(Object obj) {
        try {
            return c(obj);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + f26055a;
        } catch (Throwable th2) {
            vj.a.e(th2);
            return obj.getClass().getName() + f26055a;
        }
    }

    @uj.b
    public String c(Object obj) throws InterruptedException {
        return null;
    }

    public void a(Throwable th2) {
    }
}
