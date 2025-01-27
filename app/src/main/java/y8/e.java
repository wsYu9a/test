package y8;

import android.content.Context;
import java.util.Hashtable;
import java.util.List;
import u8.b;
import x8.j;

/* loaded from: classes3.dex */
public abstract class e<Params extends u8.b, Data, Parser extends j> extends d<Params, Data, Parser> {
    public e(Class<Params> cls, Context context, Parser parser, Hashtable<String, String> hashtable, String str) {
        super(cls, context, parser, hashtable, str);
    }

    public e(Class<Params> cls, Context context, Parser parser, Hashtable<String, String> hashtable) {
        super(cls, context, parser, hashtable);
    }

    public e(Class<Params> cls, Context context, Parser parser, String str) {
        super(cls, context, parser, str);
    }

    public e(Class<Params> cls, Context context, Parser parser) {
        super(cls, context, parser);
    }

    @Override // y8.b
    public void onUDDataReceived(List<Data> list) {
    }
}
