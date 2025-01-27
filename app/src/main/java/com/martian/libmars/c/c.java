package com.martian.libmars.c;

import android.content.Context;
import b.d.c.c.i;
import com.baidu.mobads.sdk.internal.am;
import com.martian.libmars.comm.request.MTJsonPostParams;

/* loaded from: classes2.dex */
public abstract class c<Data> extends i<MTJsonPostParams, Data> {
    public c(Class<Data> dataType, Context context) {
        super(MTJsonPostParams.class, dataType, context);
        g("Content-Type", am.f5520d);
    }
}
