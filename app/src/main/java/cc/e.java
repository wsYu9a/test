package cc;

import com.martian.mibook.lib.original.http.request.ORSearchBookParams;
import com.martian.mibook.lib.original.response.CPORBooksList;
import kb.c0;

/* loaded from: classes3.dex */
public abstract class e extends c0<ORSearchBookParams, CPORBooksList> {
    public e() {
        super(ORSearchBookParams.class, CPORBooksList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(CPORBooksList cPORBooksList) {
        if (cPORBooksList == null || cPORBooksList.getBookList() == null) {
            return false;
        }
        return super.onPreDataReceived(cPORBooksList);
    }
}
