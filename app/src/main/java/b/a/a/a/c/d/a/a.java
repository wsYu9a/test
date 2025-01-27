package b.a.a.a.c.d.a;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTClientBidding;

/* loaded from: classes.dex */
public abstract class a<T extends TTClientBidding> implements TTClientBidding {

    /* renamed from: a */
    protected T f4169a;

    /* renamed from: b */
    protected String f4170b;

    /* renamed from: c */
    protected int f4171c;

    public a(@NonNull T t, String str, int i2) {
        this.f4169a = t;
        this.f4170b = str;
        this.f4171c = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d2, String str, String str2) {
        this.f4169a.loss(d2, str, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d2) {
        this.f4169a.setPrice(d2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d2) {
        this.f4169a.win(d2);
    }
}
