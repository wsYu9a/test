package q8;

import com.martian.free.request.TFBookParams;
import com.martian.free.response.TFBook;

/* loaded from: classes3.dex */
public abstract class a extends jb.d<TFBookParams, TFBook> {
    public a() {
        super(TFBookParams.class, TFBook.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(TFBook tFBook) {
        if (tFBook == null) {
            return false;
        }
        return super.onPreDataReceived(tFBook);
    }
}
