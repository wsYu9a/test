package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.SelectInstance;
import xi.k;
import xi.l;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public /* synthetic */ class MutexImpl$onLock$1 extends FunctionReferenceImpl implements Function3<MutexImpl, SelectInstance<?>, Object, Unit> {
    public static final MutexImpl$onLock$1 INSTANCE = new MutexImpl$onLock$1();

    public MutexImpl$onLock$1() {
        super(3, MutexImpl.class, "onLockRegFunction", "onLockRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(MutexImpl mutexImpl, SelectInstance<?> selectInstance, Object obj) {
        invoke2(mutexImpl, selectInstance, obj);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke */
    public final void invoke2(@k MutexImpl mutexImpl, @k SelectInstance<?> selectInstance, @l Object obj) {
        mutexImpl.onLockRegFunction(selectInstance, obj);
    }
}
