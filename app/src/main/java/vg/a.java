package vg;

import com.tanx.onlyid.api.OAIDException;
import ug.c;
import ug.d;

/* loaded from: classes4.dex */
public class a implements d {
    @Override // ug.d
    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.oaidError(new OAIDException("Unsupported"));
    }

    @Override // ug.d
    public boolean b() {
        return false;
    }
}
