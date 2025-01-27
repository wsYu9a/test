package bd;

import android.content.Context;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import kotlin.jvm.internal.Intrinsics;
import l9.i0;

@Interceptor(name = "阅读拦截器", priority = 1)
/* loaded from: classes3.dex */
public final class e implements IInterceptor {
    public static final void b(Postcard postcard) {
        Intrinsics.checkNotNullParameter(postcard, "$postcard");
        je.i.h(postcard.getContext(), false);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(@xi.k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.alibaba.android.arouter.facade.template.IInterceptor
    public void process(@xi.k Postcard postcard, @xi.k InterceptorCallback callback) {
        Intrinsics.checkNotNullParameter(postcard, "postcard");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!Intrinsics.areEqual(postcard.getPath(), kc.a.f27754j) || !ConfigSingleton.D().y0()) {
            callback.onContinue(postcard);
        } else {
            l9.i0.z0(postcard.getContext(), postcard.getContext().getString(R.string.confirm_message), postcard.getContext().getString(R.string.base_function_to_normal_guide), new i0.l() { // from class: bd.d
                public /* synthetic */ d() {
                }

                @Override // l9.i0.l
                public final void a() {
                    e.b(Postcard.this);
                }
            });
            callback.onInterrupt(null);
        }
    }
}
