package b9;

import com.martian.libfeedback.request.FeedbackMailParams;

/* loaded from: classes3.dex */
public abstract class c extends a<FeedbackMailParams, Integer> {
    public c() {
        super(FeedbackMailParams.class, Integer.class);
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
