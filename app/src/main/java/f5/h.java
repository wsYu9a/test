package f5;

import b5.n;
import com.google.errorprone.annotations.DoNotMock;

@a5.b
@DoNotMock("Use Escapers.nullEscaper() or another methods from the *Escapers classes")
@f
/* loaded from: classes2.dex */
public abstract class h {

    /* renamed from: a */
    public final n<String, String> f25988a = new n() { // from class: f5.g
        public /* synthetic */ g() {
        }

        @Override // b5.n
        public final Object apply(Object obj) {
            return h.this.b((String) obj);
        }
    };

    public final n<String, String> a() {
        return this.f25988a;
    }

    public abstract String b(String str);
}
