package kotlin.jvm.internal;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import f.b.a.d;
import f.b.a.e;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.reflect.KDeclarationContainer;

@SinceKotlin(version = "1.1")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlin/jvm/internal/LocalVariableReference;", "Lkotlin/jvm/internal/PropertyReference0;", "Lkotlin/reflect/KDeclarationContainer;", "getOwner", "()Lkotlin/reflect/KDeclarationContainer;", "", MonitorConstants.CONNECT_TYPE_GET, "()Ljava/lang/Object;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public class LocalVariableReference extends PropertyReference0 {
    @Override // kotlin.reflect.KProperty0
    @e
    public Object get() {
        LocalVariableReferencesKt.notSupportedError();
        throw null;
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public KDeclarationContainer getOwner() {
        LocalVariableReferencesKt.notSupportedError();
        throw null;
    }
}
