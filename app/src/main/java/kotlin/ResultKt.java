package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import kotlin.Result;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001a\u0010\u0007\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u0005H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0087\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001aB\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\t*\u00028\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f¢\u0006\u0002\b\u0010H\u0087\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0011\u001a#\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a]\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\u000e*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00052!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\u000fH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0017\u0010\u0011\u001a5\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\u000e*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0018\u001a\u00028\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0086\u0001\u0010\u001d\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00010\u00052!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00028\u00000\u000f2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\u000fH\u0087\bø\u0001\u0000\u0082\u0002\u0014\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a_\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00010\u00052!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00028\u00000\u000fH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b \u0010\u0011\u001aR\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00010\u00052!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00028\u00000\u000fH\u0087\bø\u0001\u0000¢\u0006\u0004\b!\u0010\u0011\u001ac\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\u000e*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00052!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\u000fH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\"\u0010\u0011\u001aV\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\u000e*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00052!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\u000fH\u0087\bø\u0001\u0000¢\u0006\u0004\b#\u0010\u0011\u001aY\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00000\u00052!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00020\u00060\u000fH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0016\u0010\u0011\u001aY\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00000\u00052!\u0010$\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00060\u000fH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u001c\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"", "exception", "", "createFailure", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "Lkotlin/Result;", "", "throwOnFailure", "(Ljava/lang/Object;)V", "R", "Lkotlin/Function0;", "block", "runCatching", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrThrow", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/ParameterName;", "name", "onFailure", "getOrElse", "defaultValue", "getOrDefault", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", Downloads.RequestHeaders.COLUMN_VALUE, "onSuccess", "fold", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "transform", "map", "mapCatching", "recover", "recoverCatching", "action", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class ResultKt {
    @d
    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Object createFailure(@d Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        return new Result.Failure(exception);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> R fold(@d Object obj, Function1<? super T, ? extends R> function1, Function1<? super Throwable, ? extends R> function12) {
        Throwable m86exceptionOrNullimpl = Result.m86exceptionOrNullimpl(obj);
        return m86exceptionOrNullimpl == null ? function1.invoke(obj) : function12.invoke(m86exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> R getOrDefault(@d Object obj, R r) {
        return Result.m89isFailureimpl(obj) ? r : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> R getOrElse(@d Object obj, Function1<? super Throwable, ? extends R> function1) {
        Throwable m86exceptionOrNullimpl = Result.m86exceptionOrNullimpl(obj);
        return m86exceptionOrNullimpl == null ? obj : function1.invoke(m86exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> T getOrThrow(@d Object obj) {
        throwOnFailure(obj);
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> Object map(@d Object obj, Function1<? super T, ? extends R> function1) {
        if (!Result.m90isSuccessimpl(obj)) {
            return Result.m83constructorimpl(obj);
        }
        Result.Companion companion = Result.INSTANCE;
        return Result.m83constructorimpl(function1.invoke(obj));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> Object mapCatching(@d Object obj, Function1<? super T, ? extends R> function1) {
        if (!Result.m90isSuccessimpl(obj)) {
            return Result.m83constructorimpl(obj);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m83constructorimpl(function1.invoke(obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m83constructorimpl(createFailure(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object onFailure(@d Object obj, Function1<? super Throwable, Unit> function1) {
        Throwable m86exceptionOrNullimpl = Result.m86exceptionOrNullimpl(obj);
        if (m86exceptionOrNullimpl != null) {
            function1.invoke(m86exceptionOrNullimpl);
        }
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object onSuccess(@d Object obj, Function1<? super T, Unit> function1) {
        if (Result.m90isSuccessimpl(obj)) {
            function1.invoke(obj);
        }
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> Object recover(@d Object obj, Function1<? super Throwable, ? extends R> function1) {
        Throwable m86exceptionOrNullimpl = Result.m86exceptionOrNullimpl(obj);
        if (m86exceptionOrNullimpl == null) {
            return obj;
        }
        Result.Companion companion = Result.INSTANCE;
        return Result.m83constructorimpl(function1.invoke(m86exceptionOrNullimpl));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> Object recoverCatching(@d Object obj, Function1<? super Throwable, ? extends R> function1) {
        Throwable m86exceptionOrNullimpl = Result.m86exceptionOrNullimpl(obj);
        if (m86exceptionOrNullimpl == null) {
            return obj;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m83constructorimpl(function1.invoke(m86exceptionOrNullimpl));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m83constructorimpl(createFailure(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R> Object runCatching(Function0<? extends R> function0) {
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m83constructorimpl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m83constructorimpl(createFailure(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final void throwOnFailure(@d Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T, R> Object runCatching(T t, Function1<? super T, ? extends R> function1) {
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m83constructorimpl(function1.invoke(t));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m83constructorimpl(createFailure(th));
        }
    }
}
