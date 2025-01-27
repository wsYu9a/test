package b9;

import com.martian.libfeedback.request.MessagesParams;
import com.martian.libfeedback.response.MessageList;

/* loaded from: classes3.dex */
public abstract class d extends a<MessagesParams, MessageList> {
    public d() {
        super(MessagesParams.class, MessageList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(MessageList messageList) {
        if (messageList == null || messageList.getMessages() == null) {
            return false;
        }
        return super.onPreDataReceived(messageList);
    }
}
