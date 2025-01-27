package com.martian.libfeedback.b;

import com.martian.libfeedback.request.FeedbackMailParams;

/* loaded from: classes2.dex */
public abstract class c extends a<FeedbackMailParams, Integer> {
    public c() {
        super(FeedbackMailParams.class, Integer.class);
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
