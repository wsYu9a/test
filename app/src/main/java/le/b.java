package le;

import com.martian.mipush.request.SendPushTokenParams;

/* loaded from: classes3.dex */
public abstract class b extends a<SendPushTokenParams, Boolean> {
    public b() {
        super(SendPushTokenParams.class, Boolean.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return super.onPreDataReceived(bool);
    }
}
