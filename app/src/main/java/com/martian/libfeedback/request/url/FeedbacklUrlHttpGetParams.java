package com.martian.libfeedback.request.url;

import com.martian.libmars.comm.request.MTHttpGetParams;

/* loaded from: classes2.dex */
public abstract class FeedbacklUrlHttpGetParams extends MTHttpGetParams {
    public FeedbacklUrlHttpGetParams() {
        super(new FeedbackUrlProvider());
    }
}
