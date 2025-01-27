package f9;

import android.content.Context;
import com.baidu.mobads.sdk.internal.am;
import com.martian.libmars.comm.request.MTJsonPostParams;
import y8.h;

/* loaded from: classes3.dex */
public abstract class c<Data> extends h<MTJsonPostParams, Data> {
    public c(Class<Data> cls, Context context) {
        super(MTJsonPostParams.class, cls, context);
        g("Content-Type", am.f6738d);
    }
}
