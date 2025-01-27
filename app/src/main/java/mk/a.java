package mk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes5.dex */
public interface a extends IInterface {

    /* renamed from: mk.a$a */
    public static abstract class AbstractBinderC0743a extends Binder implements a {

        /* renamed from: b */
        public static final /* synthetic */ int f28716b = 0;

        /* renamed from: mk.a$a$a */
        public static class C0744a implements a {

            /* renamed from: b */
            public IBinder f28717b;

            public C0744a(IBinder iBinder) {
                this.f28717b = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f28717b;
            }
        }
    }
}
