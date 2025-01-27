package com.martian.libfeedback.response;

import java.util.List;

/* loaded from: classes2.dex */
public class MessageList {
    private List<PushMessage> msgs;

    public List<PushMessage> getMessages() {
        return this.msgs;
    }

    public void setMessages(List<PushMessage> messages) {
        this.msgs = messages;
    }
}
