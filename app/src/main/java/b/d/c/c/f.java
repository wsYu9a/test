package b.d.c.c;

import android.content.Context;
import b.d.c.b.j;
import com.martian.libcomm.http.requests.b;
import java.util.Hashtable;
import java.util.List;

/* loaded from: classes.dex */
public abstract class f<Params extends com.martian.libcomm.http.requests.b, Data, Parser extends j> extends d<Params, Data, Parser> {
    public f(Class<Params> paramsClass, Context ctx, Parser parser, Hashtable<String, String> properties, String charset) {
        super(paramsClass, ctx, parser, properties, charset);
    }

    @Override // b.d.c.c.c
    public void onUDDataReceived(List<Data> data) {
    }

    public f(Class<Params> paramsClass, Context ctx, Parser parser, Hashtable<String, String> properties) {
        super(paramsClass, ctx, parser, properties);
    }

    public f(Class<Params> paramsClass, Context ctx, Parser parser, String charset) {
        super(paramsClass, ctx, parser, charset);
    }

    public f(Class<Params> paramsClass, Context ctx, Parser parser) {
        super(paramsClass, ctx, parser);
    }
}
