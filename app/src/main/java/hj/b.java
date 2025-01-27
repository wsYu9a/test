package hj;

import ij.e;
import ij.i;

/* loaded from: classes4.dex */
public abstract class b extends c implements ij.a {
    public ij.a minus(e eVar) {
        return eVar.subtractFrom(this);
    }

    public ij.a plus(e eVar) {
        return eVar.addTo(this);
    }

    public ij.a with(ij.c cVar) {
        return cVar.adjustInto(this);
    }

    public ij.a minus(long j10, i iVar) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, iVar).plus(1L, iVar) : plus(-j10, iVar);
    }
}
