package y8;

import android.content.Context;
import java.util.List;
import u8.b;
import x8.l;
import x8.m;

/* loaded from: classes3.dex */
public abstract class h<Params extends u8.b, Data> extends d<Params, Data, l<Data>> {
    public h(Class<Params> cls, Class<Data> cls2, Context context) {
        super(cls, context, new l(cls2), null, d.f33070f);
    }

    @Override // y8.d
    /* renamed from: o */
    public m<Data> i() {
        return (m) super.executeBlocking(k());
    }

    @Override // y8.b
    public abstract void onUDDataReceived(List<Data> list);

    public h(String str, String str2, String str3, int i10, Class<Params> cls, Class<Data> cls2, Context context) {
        super(cls, context, new l(str, str2, str3, i10, cls2), null, d.f33070f);
    }

    public h(String str, String str2, String str3, Object obj, Class<Params> cls, Class<Data> cls2, Context context) {
        super(cls, context, new l(str, str2, str3, obj, cls2), null, d.f33070f);
    }

    public h(l<Data> lVar, Class<Params> cls, Context context) {
        super(cls, context, lVar, null, d.f33070f);
    }

    @Override // y8.a
    public void onDataReceived(Data data) {
    }
}
