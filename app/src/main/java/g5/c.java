package g5;

import androidx.core.app.NotificationCompat;
import b5.u;

@e
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a */
    public final Object f26122a;

    /* renamed from: b */
    public final Object f26123b;

    public c(Object obj, Object obj2) {
        this.f26122a = u.E(obj);
        this.f26123b = u.E(obj2);
    }

    public Object a() {
        return this.f26123b;
    }

    public Object b() {
        return this.f26122a;
    }

    public String toString() {
        return com.google.common.base.a.c(this).f("source", this.f26122a).f(NotificationCompat.CATEGORY_EVENT, this.f26123b).toString();
    }
}
