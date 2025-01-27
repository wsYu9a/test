package kb;

import com.martian.mibook.lib.account.request.auth.ActiveParams;

/* loaded from: classes3.dex */
public abstract class a extends c0<ActiveParams, Boolean> {
    public a() {
        super(ActiveParams.class, Boolean.class);
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
