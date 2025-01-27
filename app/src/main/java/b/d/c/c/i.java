package b.d.c.c;

import android.content.Context;
import b.d.c.b.l;
import com.martian.libcomm.http.requests.b;
import java.util.List;

/* loaded from: classes.dex */
public abstract class i<Params extends com.martian.libcomm.http.requests.b, Data> extends d<Params, Data, l<Data>> {
    public i(Class<Params> paramsClass, Class<Data> dataType, Context context) {
        super(paramsClass, context, new l(dataType), null, d.f4467a);
    }

    @Override // b.d.c.c.b
    public void onDataReceived(Data data) {
    }

    @Override // b.d.c.c.c
    public abstract void onUDDataReceived(List<Data> dataList);

    public i(String codeKey, String msgKey, String dataKey, int succCode, Class<Params> paramsClass, Class<Data> dataType, Context context) {
        super(paramsClass, context, new l(codeKey, msgKey, dataKey, succCode, dataType), null, d.f4467a);
    }

    public i(String codeKey, String msgKey, String dataKey, Object succRet, Class<Params> paramsClass, Class<Data> dataType, Context context) {
        super(paramsClass, context, new l(codeKey, msgKey, dataKey, succRet, dataType), null, d.f4467a);
    }

    public i(l<Data> parser, Class<Params> paramsClass, Context context) {
        super(paramsClass, context, parser, null, d.f4467a);
    }
}
