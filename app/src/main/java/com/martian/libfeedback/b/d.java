package com.martian.libfeedback.b;

import com.martian.libfeedback.request.MessagesParams;
import com.martian.libfeedback.response.MessageList;

/* loaded from: classes2.dex */
public abstract class d extends a<MessagesParams, MessageList> {
    public d() {
        super(MessagesParams.class, MessageList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(MessageList messageList) {
        if (messageList == null || messageList.getMessages() == null) {
            return false;
        }
        return super.onPreDataReceived(messageList);
    }
}
