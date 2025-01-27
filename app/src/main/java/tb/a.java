package tb;

import com.martian.mibook.lib.local.txt.data.TXTBook;
import yb.n;

/* loaded from: classes3.dex */
public class a extends n<TXTBook> {

    /* renamed from: h */
    public static a f30791h;

    public a() {
        super("txtbooks.db", 1, TXTBook.class);
    }

    public static a p() {
        if (f30791h == null) {
            f30791h = new a();
        }
        return f30791h;
    }
}
