package kotlin.contracts;

import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import f.b.a.e;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.ContractsDsl;

@SinceKotlin(version = "1.3")
@ContractsDsl
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b\u0003\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0010\u001a\u00020\u000f\"\u0004\b\u0000\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlin/contracts/ContractBuilder;", "", "Lkotlin/contracts/Returns;", "returns", "()Lkotlin/contracts/Returns;", Downloads.RequestHeaders.COLUMN_VALUE, "(Ljava/lang/Object;)Lkotlin/contracts/Returns;", "Lkotlin/contracts/ReturnsNotNull;", "returnsNotNull", "()Lkotlin/contracts/ReturnsNotNull;", "R", "Lkotlin/Function;", "lambda", "Lkotlin/contracts/InvocationKind;", "kind", "Lkotlin/contracts/CallsInPlace;", "callsInPlace", "(Lkotlin/Function;Lkotlin/contracts/InvocationKind;)Lkotlin/contracts/CallsInPlace;", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
@ExperimentalContracts
/* loaded from: classes5.dex */
public interface ContractBuilder {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static /* synthetic */ CallsInPlace callsInPlace$default(ContractBuilder contractBuilder, Function function, InvocationKind invocationKind, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
            }
            if ((i2 & 2) != 0) {
                invocationKind = InvocationKind.UNKNOWN;
            }
            return contractBuilder.callsInPlace(function, invocationKind);
        }
    }

    @d
    @ContractsDsl
    <R> CallsInPlace callsInPlace(@d Function<? extends R> lambda, @d InvocationKind kind);

    @d
    @ContractsDsl
    Returns returns();

    @d
    @ContractsDsl
    Returns returns(@e Object r1);

    @d
    @ContractsDsl
    ReturnsNotNull returnsNotNull();
}
