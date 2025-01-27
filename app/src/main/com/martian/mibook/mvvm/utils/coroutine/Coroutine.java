package com.martian.mibook.mvvm.utils.coroutine;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.martian.ads.ad.AdConfig;
import com.sigmob.sdk.downloader.core.breakpoint.e;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.f;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 J*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0004IJKLBT\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020)J<\u0010*\u001a\u00020)\"\u0004\b\u0001\u0010+2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010,\u001a\u0002H+2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u0002H+0\u0012R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0082H¢\u0006\u0002\u0010.J(\u0010/\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020\u00042\u0010\u0010-\u001a\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0082H¢\u0006\u0002\u00100JQ\u00101\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2)\b\b\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b¢\u0006\u0002\b\rH\u0082H¢\u0006\u0002\u00102J>\u00103\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u00062'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b¢\u0006\u0002\b\rH\u0002¢\u0006\u0002\u00104J/\u00105\u001a\u0002062'\u00107\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020)08j\u0002`<JF\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b¢\u0006\u0002\b\r¢\u0006\u0002\u0010>JL\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062-\u0010\n\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020@¢\u0006\u0002\b\r¢\u0006\u0002\u0010AJ\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000CJ\u001b\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010,\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010DJF\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b¢\u0006\u0002\b\r¢\u0006\u0002\u0010>JF\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b¢\u0006\u0002\b\r¢\u0006\u0002\u0010>JL\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062-\u0010\n\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020@¢\u0006\u0002\b\r¢\u0006\u0002\u0010AJ\u0006\u0010\"\u001a\u00020)J\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0CJ\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010&\u001a\u00020'R\u001a\u0010\u000f\u001a\u000e\u0018\u00010\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u000e\u0018\u00010\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u000e\u0018\u00010\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R \u0010%\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0004\n\u0002\u0010(¨\u0006M"}, d2 = {"Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine;", ExifInterface.GPS_DIRECTION_TRUE, "", Constants.PARAM_SCOPE, "Lkotlinx/coroutines/CoroutineScope;", f.X, "Lkotlin/coroutines/CoroutineContext;", "startOption", "Lkotlinx/coroutines/CoroutineStart;", "executeContext", e.f19025e, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "cancel", "Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine$VoidCallback;", "error", "Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine$Callback;", "", "errorReturn", "Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine$Result;", "getExecuteContext", "()Lkotlin/coroutines/CoroutineContext;", "finally", "isActive", "", "()Z", "isCancelled", "isCompleted", "job", "Lkotlinx/coroutines/Job;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "start", "getStartOption", "()Lkotlinx/coroutines/CoroutineStart;", "success", "timeMillis", "", "Ljava/lang/Long;", "", "dispatchCallback", "R", "value", "callback", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/Object;Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine$Callback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchVoidCallback", "(Lkotlinx/coroutines/CoroutineScope;Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine$VoidCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeBlock", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeInternal", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "onCancel", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine;", "onError", "Lkotlin/Function3;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine;", "onErrorReturn", "Lkotlin/Function0;", "(Ljava/lang/Object;)Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine;", "onFinally", "onStart", "onSuccess", "timeout", "Callback", "Companion", "Result", "VoidCallback", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Coroutine<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    @k
    private static final CoroutineScope DEFAULT = CoroutineScopeKt.MainScope();

    @l
    private Coroutine<T>.VoidCallback cancel;

    @l
    private Coroutine<T>.Callback<Throwable> error;

    @l
    private Result<? extends T> errorReturn;

    @k
    private final CoroutineContext executeContext;

    @l
    private Coroutine<T>.VoidCallback finally;

    @k
    private final Job job;

    @k
    private final CoroutineScope scope;

    @l
    private Coroutine<T>.VoidCallback start;

    @k
    private final CoroutineStart startOption;

    @l
    private Coroutine<T>.Callback<T> success;

    @l
    private Long timeMillis;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B>\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012-\u0010\u0005\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000bR:\u0010\u0005\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\u0002\b\n¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine$Callback;", "VALUE", "", f.X, "Lkotlin/coroutines/CoroutineContext;", e.f19025e, "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)V", "getBlock", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class Callback<VALUE> {

        @k
        private final Function3<CoroutineScope, VALUE, Continuation<? super Unit>, Object> block;

        @l
        private final CoroutineContext context;
        final /* synthetic */ Coroutine<T> this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public Callback(@l Coroutine coroutine, @k CoroutineContext coroutineContext, Function3<? super CoroutineScope, ? super VALUE, ? super Continuation<? super Unit>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.this$0 = coroutine;
            this.context = coroutineContext;
            this.block = block;
        }

        @k
        public final Function3<CoroutineScope, VALUE, Continuation<? super Unit>, Object> getBlock() {
            return this.block;
        }

        @l
        public final CoroutineContext getContext() {
            return this.context;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jh\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0001\u0010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine$Companion;", "", "()V", AdConfig.UnionType.DEFAULT, "Lkotlinx/coroutines/CoroutineScope;", "async", "Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine;", ExifInterface.GPS_DIRECTION_TRUE, Constants.PARAM_SCOPE, f.X, "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "executeContext", e.f19025e, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Coroutine async$default(Companion companion, CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, CoroutineContext coroutineContext2, Function2 function2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                coroutineScope = Coroutine.DEFAULT;
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
            return companion.async(coroutineScope2, coroutineContext3, coroutineStart2, coroutineContext2, function2);
        }

        @k
        public final <T> Coroutine<T> async(@k CoroutineScope r82, @k CoroutineContext r92, @k CoroutineStart start, @k CoroutineContext executeContext, @k Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r12) {
            Intrinsics.checkNotNullParameter(r82, "scope");
            Intrinsics.checkNotNullParameter(r92, "context");
            Intrinsics.checkNotNullParameter(start, "start");
            Intrinsics.checkNotNullParameter(executeContext, "executeContext");
            Intrinsics.checkNotNullParameter(r12, "block");
            return new Coroutine<>(r82, r92, start, executeContext, r12);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00018\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine$Result;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine$Result;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "", "toString", "", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Result<T> {

        @l
        private final T value;

        public Result(@l T t10) {
            this.value = t10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Result copy$default(Result result, Object obj, int i10, Object obj2) {
            if ((i10 & 1) != 0) {
                obj = result.value;
            }
            return result.copy(obj);
        }

        @l
        public final T component1() {
            return this.value;
        }

        @k
        public final Result<T> copy(@l T value) {
            return new Result<>(value);
        }

        public boolean equals(@l Object r42) {
            if (this == r42) {
                return true;
            }
            return (r42 instanceof Result) && Intrinsics.areEqual(this.value, ((Result) r42).value);
        }

        @l
        public final T getValue() {
            return this.value;
        }

        public int hashCode() {
            T t10 = this.value;
            if (t10 == null) {
                return 0;
            }
            return t10.hashCode();
        }

        @k
        public String toString() {
            return "Result(value=" + this.value + ")";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B8\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nR4\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\b\t¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine$VoidCallback;", "", f.X, "Lkotlin/coroutines/CoroutineContext;", e.f19025e, "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "getBlock", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class VoidCallback {

        @k
        private final Function2<CoroutineScope, Continuation<? super Unit>, Object> block;

        @l
        private final CoroutineContext context;
        final /* synthetic */ Coroutine<T> this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public VoidCallback(@l Coroutine coroutine, @k CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.this$0 = coroutine;
            this.context = coroutineContext;
            this.block = block;
        }

        @k
        public final Function2<CoroutineScope, Continuation<? super Unit>, Object> getBlock() {
            return this.block;
        }

        @l
        public final CoroutineContext getContext() {
            return this.context;
        }
    }

    public Coroutine(@k CoroutineScope scope, @k CoroutineContext context, @k CoroutineStart startOption, @k CoroutineContext executeContext, @k Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(startOption, "startOption");
        Intrinsics.checkNotNullParameter(executeContext, "executeContext");
        Intrinsics.checkNotNullParameter(block, "block");
        this.scope = scope;
        this.startOption = startOption;
        this.executeContext = executeContext;
        this.job = executeInternal(context, block);
    }

    private final <R> Object dispatchCallback(CoroutineScope coroutineScope, R r10, Coroutine<T>.Callback<R> callback, Continuation<? super Unit> continuation) {
        if (!CoroutineScopeKt.isActive(coroutineScope)) {
            return Unit.INSTANCE;
        }
        if (callback.getContext() == null) {
            Function3<CoroutineScope, R, Continuation<? super Unit>, Object> block = callback.getBlock();
            InlineMarker.mark(0);
            block.invoke(coroutineScope, r10, continuation);
            InlineMarker.mark(1);
            return Unit.INSTANCE;
        }
        CoroutineContext plus = coroutineScope.getCoroutineContext().plus(callback.getContext());
        Coroutine$dispatchCallback$2 coroutine$dispatchCallback$2 = new Coroutine$dispatchCallback$2(callback, r10, null);
        InlineMarker.mark(0);
        BuildersKt.withContext(plus, coroutine$dispatchCallback$2, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    private final Object dispatchVoidCallback(CoroutineScope coroutineScope, Coroutine<T>.VoidCallback voidCallback, Continuation<? super Unit> continuation) {
        if (voidCallback.getContext() == null) {
            CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
            Coroutine$dispatchVoidCallback$2 coroutine$dispatchVoidCallback$2 = new Coroutine$dispatchVoidCallback$2(voidCallback, coroutineScope, null);
            InlineMarker.mark(0);
            BuildersKt.withContext(coroutineContext, coroutine$dispatchVoidCallback$2, continuation);
            InlineMarker.mark(1);
            return Unit.INSTANCE;
        }
        CoroutineContext plus = coroutineScope.getCoroutineContext().plus(voidCallback.getContext());
        Coroutine$dispatchVoidCallback$3 coroutine$dispatchVoidCallback$3 = new Coroutine$dispatchVoidCallback$3(voidCallback, null);
        InlineMarker.mark(0);
        BuildersKt.withContext(plus, coroutine$dispatchVoidCallback$3, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    private final Object executeBlock(CoroutineScope coroutineScope, CoroutineContext coroutineContext, long j10, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        CoroutineContext plus = coroutineScope.getCoroutineContext().plus(coroutineContext);
        Coroutine$executeBlock$2 coroutine$executeBlock$2 = new Coroutine$executeBlock$2(j10, function2, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(plus, coroutine$executeBlock$2, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    private final Job executeInternal(CoroutineContext r92, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r10) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.plus(this.scope, this.executeContext), null, this.startOption, new Coroutine$executeInternal$1(this, r92, r10, null), 1, null);
        return launch$default;
    }

    public static /* synthetic */ Coroutine onCancel$default(Coroutine coroutine, CoroutineContext coroutineContext, Function2 function2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = null;
        }
        return coroutine.onCancel(coroutineContext, function2);
    }

    public static /* synthetic */ Coroutine onError$default(Coroutine coroutine, CoroutineContext coroutineContext, Function3 function3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = null;
        }
        return coroutine.onError(coroutineContext, function3);
    }

    public static /* synthetic */ Coroutine onFinally$default(Coroutine coroutine, CoroutineContext coroutineContext, Function2 function2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = null;
        }
        return coroutine.onFinally(coroutineContext, function2);
    }

    public static /* synthetic */ Coroutine onStart$default(Coroutine coroutine, CoroutineContext coroutineContext, Function2 function2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = null;
        }
        return coroutine.onStart(coroutineContext, function2);
    }

    public static /* synthetic */ Coroutine onSuccess$default(Coroutine coroutine, CoroutineContext coroutineContext, Function3 function3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = null;
        }
        return coroutine.onSuccess(coroutineContext, function3);
    }

    public final void cancel() {
        if (!this.job.isCancelled()) {
            Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
        }
        Coroutine<T>.VoidCallback voidCallback = this.cancel;
        if (voidCallback != null) {
            BuildersKt__Builders_commonKt.launch$default(DEFAULT, this.executeContext, null, new Coroutine$cancel$1$1(voidCallback, this, null), 2, null);
        }
    }

    @k
    public final CoroutineContext getExecuteContext() {
        return this.executeContext;
    }

    @k
    public final CoroutineScope getScope() {
        return this.scope;
    }

    @k
    public final CoroutineStart getStartOption() {
        return this.startOption;
    }

    @k
    public final DisposableHandle invokeOnCompletion(@k Function1<? super Throwable, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.job.invokeOnCompletion(handler);
    }

    public final boolean isActive() {
        return this.job.isActive();
    }

    public final boolean isCancelled() {
        return this.job.isCancelled();
    }

    public final boolean isCompleted() {
        return this.job.isCompleted();
    }

    @k
    public final Coroutine<T> onCancel(@l CoroutineContext r22, @k Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r32) {
        Intrinsics.checkNotNullParameter(r32, "block");
        this.cancel = new VoidCallback(this, r22, r32);
        return this;
    }

    @k
    public final Coroutine<T> onError(@l CoroutineContext r22, @k Function3<? super CoroutineScope, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r32) {
        Intrinsics.checkNotNullParameter(r32, "block");
        this.error = new Callback<>(this, r22, r32);
        return this;
    }

    @k
    public final Coroutine<T> onErrorReturn(@k Function0<? extends T> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.errorReturn = new Result<>(value.invoke());
        return this;
    }

    @k
    public final Coroutine<T> onFinally(@l CoroutineContext r22, @k Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r32) {
        Intrinsics.checkNotNullParameter(r32, "block");
        this.finally = new VoidCallback(this, r22, r32);
        return this;
    }

    @k
    public final Coroutine<T> onStart(@l CoroutineContext r22, @k Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r32) {
        Intrinsics.checkNotNullParameter(r32, "block");
        this.start = new VoidCallback(this, r22, r32);
        return this;
    }

    @k
    public final Coroutine<T> onSuccess(@l CoroutineContext r22, @k Function3<? super CoroutineScope, ? super T, ? super Continuation<? super Unit>, ? extends Object> r32) {
        Intrinsics.checkNotNullParameter(r32, "block");
        this.success = new Callback<>(this, r22, r32);
        return this;
    }

    public final void start() {
        this.job.start();
    }

    @k
    public final Coroutine<T> timeout(@k Function0<Long> timeMillis) {
        Intrinsics.checkNotNullParameter(timeMillis, "timeMillis");
        this.timeMillis = timeMillis.invoke();
        return this;
    }

    @k
    public final Coroutine<T> onErrorReturn(@l T value) {
        this.errorReturn = new Result<>(value);
        return this;
    }

    @k
    public final Coroutine<T> timeout(long timeMillis) {
        this.timeMillis = Long.valueOf(timeMillis);
        return this;
    }

    public /* synthetic */ Coroutine(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, CoroutineContext coroutineContext2, Function2 function2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, (i10 & 2) != 0 ? Dispatchers.getIO() : coroutineContext, (i10 & 4) != 0 ? CoroutineStart.DEFAULT : coroutineStart, (i10 & 8) != 0 ? Dispatchers.getMain() : coroutineContext2, function2);
    }
}
