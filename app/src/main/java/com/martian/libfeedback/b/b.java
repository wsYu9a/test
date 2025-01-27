package com.martian.libfeedback.b;

import com.martian.libfeedback.request.FeedbackInfoParams;

/* loaded from: classes2.dex */
public abstract class b extends a<FeedbackInfoParams, Integer> {
    public b() {
        super(FeedbackInfoParams.class, Integer.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(Integer id) {
        if (id == null) {
            return false;
        }
        return super.onPreDataReceived(id);
    }
}
