package com.martian.mibook.mvvm.base;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LifecycleService;
import com.martian.mibook.mvvm.utils.coroutine.Coroutine;
import com.sigmob.sdk.downloader.core.breakpoint.e;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import xi.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jj\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00072'\u0010\u0010\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f¢\u0006\u0002\b\u000f¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/martian/mibook/mvvm/base/BaseService;", "Landroidx/lifecycle/LifecycleService;", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", Constants.PARAM_SCOPE, "Lkotlin/coroutines/CoroutineContext;", f.X, "Lkotlinx/coroutines/CoroutineStart;", "start", "executeContext", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", e.f19025e, "Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine;", "a", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public class BaseService extends LifecycleService {
    public static /* synthetic */ Coroutine b(BaseService baseService, CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, CoroutineContext coroutineContext2, Function2 function2, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        if ((i10 & 1) != 0) {
            coroutineScope = LifecycleOwnerKt.getLifecycleScope(baseService);
        }
        CoroutineScope coroutineScope2 = coroutineScope;
        if ((i10 & 2) != 0) {
            coroutineContext = Dispatchers.getIO();
        }
        CoroutineContext coroutineContext3 = coroutineContext;
        if ((i10 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i10 & 8) != 0) {
            coroutineContext2 = Dispatchers.getMain();
        }
        return baseService.a(coroutineScope2, coroutineContext3, coroutineStart2, coroutineContext2, function2);
    }

    @k
    public final <T> Coroutine<T> a(@k CoroutineScope r82, @k CoroutineContext r92, @k CoroutineStart start, @k CoroutineContext executeContext, @k Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r82, "scope");
        Intrinsics.checkNotNullParameter(r92, "context");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(executeContext, "executeContext");
        Intrinsics.checkNotNullParameter(r12, "block");
        return Coroutine.INSTANCE.async(r82, r92, start, executeContext, r12);
    }
}
