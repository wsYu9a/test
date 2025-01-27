package b.d.c.b;

/* loaded from: classes2.dex */
public abstract class j {
    public k a(b.d.c.a.c.a resp) {
        if (resp.e()) {
            return new c(resp.c(), resp.a(), resp.b(), resp.d());
        }
        k b2 = b(resp.b());
        b2.b(resp.c());
        return b2;
    }

    protected abstract k b(String input);
}
