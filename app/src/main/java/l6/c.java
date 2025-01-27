package l6;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a */
    public final List<b> f27934a;

    /* renamed from: b */
    public final int f27935b;

    /* renamed from: c */
    public final boolean f27936c;

    public c(List<b> list, int i10, boolean z10) {
        this.f27934a = new ArrayList(list);
        this.f27935b = i10;
        this.f27936c = z10;
    }

    public List<b> a() {
        return this.f27934a;
    }

    public int b() {
        return this.f27935b;
    }

    public boolean c(List<b> list) {
        return this.f27934a.equals(list);
    }

    public boolean d() {
        return this.f27936c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f27934a.equals(cVar.a()) && this.f27936c == cVar.f27936c;
    }

    public int hashCode() {
        return this.f27934a.hashCode() ^ Boolean.valueOf(this.f27936c).hashCode();
    }

    public String toString() {
        return "{ " + this.f27934a + " }";
    }
}
