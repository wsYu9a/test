package b.a.a.a.c.d.b;

import com.bytedance.sdk.openadsdk.common.CommonListener;

/* loaded from: classes.dex */
public abstract class a<T extends CommonListener> implements CommonListener {

    /* renamed from: a */
    protected T f4184a;

    /* renamed from: b */
    protected String f4185b;

    /* renamed from: c */
    protected int f4186c;

    public a(T t, String str, int i2) {
        this.f4184a = t;
        this.f4185b = str;
        this.f4186c = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.common.CommonListener
    public void onError(int i2, String str) {
        T t = this.f4184a;
        if (t != null) {
            t.onError(i2, str);
        }
    }
}
