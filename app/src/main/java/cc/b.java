package cc;

import com.martian.mibook.lib.original.data.ORBook;
import com.martian.mibook.lib.original.http.request.ORBookParams;

/* loaded from: classes3.dex */
public abstract class b extends jb.d<ORBookParams, ORBook> {
    public b() {
        super(ORBookParams.class, ORBook.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(ORBook oRBook) {
        if (oRBook == null) {
            return false;
        }
        return super.onPreDataReceived(oRBook);
    }
}
