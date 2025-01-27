package kotlin.reflect;

import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import f.b.a.e;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.SinceKotlin;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J'\u0010\u0006\u001a\u00028\u00002\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\"\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\u00028\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bH&¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00178&@'X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u001f\u001a\u00020\u001e8&@'X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0011\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u00020\u001e8&@'X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0011\u001a\u0004\b\"\u0010 R\u001c\u0010$\u001a\u00020\u001e8&@'X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0011\u001a\u0004\b$\u0010 R\u0016\u0010)\u001a\u00020&8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001c\u0010*\u001a\u00020\u001e8&@'X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0011\u001a\u0004\b*\u0010 ¨\u0006,"}, d2 = {"Lkotlin/reflect/KCallable;", "R", "Lkotlin/reflect/KAnnotatedElement;", "", "", ProcessBridgeProvider.KEY_ARGS, "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "", "Lkotlin/reflect/KParameter;", "callBy", "(Ljava/util/Map;)Ljava/lang/Object;", "", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "typeParameters$annotations", "()V", "typeParameters", "", "getName", "()Ljava/lang/String;", "name", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "visibility$annotations", Downloads.Column.VISIBILITY, "getParameters", "parameters", "", "isFinal", "()Z", "isFinal$annotations", "isAbstract", "isAbstract$annotations", "isOpen", "isOpen$annotations", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "returnType", "isSuspend", "isSuspend$annotations", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public interface KCallable<R> extends KAnnotatedElement {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isAbstract$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isFinal$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isOpen$annotations() {
        }

        @SinceKotlin(version = "1.3")
        public static /* synthetic */ void isSuspend$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void typeParameters$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void visibility$annotations() {
        }
    }

    R call(@d Object... r1);

    R callBy(@d Map<KParameter, ? extends Object> r1);

    @d
    String getName();

    @d
    List<KParameter> getParameters();

    @d
    KType getReturnType();

    @d
    List<KTypeParameter> getTypeParameters();

    @e
    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
