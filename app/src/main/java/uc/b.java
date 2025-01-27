package uc;

import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.mvvm.net.ErrorResult;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import ya.n0;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a */
    @k
    public static final b f30976a = new b();

    public static final class a implements ConfigSingleton.a {

        /* renamed from: a */
        public final /* synthetic */ MiUserManager f30977a;

        public a(MiUserManager miUserManager) {
            this.f30977a = miUserManager;
        }

        @Override // com.martian.libmars.common.ConfigSingleton.a
        public void a() {
            MiConfigSingleton.b2().P2(n0.f33313a.c(), null);
        }

        @Override // com.martian.libmars.common.ConfigSingleton.a
        public void b() {
            this.f30977a.i();
            kc.b.d();
        }
    }

    @k
    public final ErrorResult a(@k ErrorResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getErrorCode() == 205) {
            ConfigSingleton.D().n1(n0.f33313a.c(), new a(MiUserManager.q()));
        }
        return it;
    }
}
