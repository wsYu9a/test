package r3;

import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    public Stack<e> f30305a = new Stack<>();

    public void a() {
        if (c()) {
            return;
        }
        Iterator<e> it = this.f30305a.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        this.f30305a.clear();
    }

    public void b(e eVar) {
        this.f30305a.push(eVar);
    }

    public boolean c() {
        return this.f30305a.isEmpty();
    }

    public e d() {
        return this.f30305a.pop();
    }
}
