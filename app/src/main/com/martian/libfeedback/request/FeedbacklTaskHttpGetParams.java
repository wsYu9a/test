package com.martian.libfeedback.request;

import com.martian.libmars.comm.request.MTHttpGetParams;

/* loaded from: classes3.dex */
public abstract class FeedbacklTaskHttpGetParams extends MTHttpGetParams {
    public FeedbacklTaskHttpGetParams() {
        super(new FeedbackTaskUrlProvider());
    }
}
