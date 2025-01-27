package x8;

/* loaded from: classes3.dex */
public abstract class j {
    public abstract k a(String str);

    public k b(w8.a aVar) {
        if (aVar.e()) {
            return new c(aVar.c(), aVar.a(), aVar.b(), aVar.d());
        }
        k a10 = a(aVar.b());
        a10.b(aVar.c());
        return a10;
    }
}
