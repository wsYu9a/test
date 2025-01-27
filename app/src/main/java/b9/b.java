package b9;

import com.martian.libfeedback.request.FeedbackInfoParams;

/* loaded from: classes3.dex */
public abstract class b extends a<FeedbackInfoParams, Integer> {
    public b() {
        super(FeedbackInfoParams.class, Integer.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(Integer num) {
        if (num == null) {
            return false;
        }
        return super.onPreDataReceived(num);
    }
}
