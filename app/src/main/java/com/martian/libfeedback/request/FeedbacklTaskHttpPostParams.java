package com.martian.libfeedback.request;

import com.martian.libmars.comm.request.MTHttpPostParams;

/* loaded from: classes2.dex */
public abstract class FeedbacklTaskHttpPostParams extends MTHttpPostParams {
    public FeedbacklTaskHttpPostParams() {
        super(new FeedbackTaskUrlProvider());
    }
}
