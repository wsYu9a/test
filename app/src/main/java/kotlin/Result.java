package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.internal.bw;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import f.b.a.e;
import java.io.Serializable;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087@\u0018\u0000  *\u0006\b\u0000\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0002 !B\u0016\b\u0001\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001c\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\u001e\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0016ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lkotlin/Result;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "getOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "exceptionOrNull", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "", TTDownloadField.TT_HASHCODE, "()I", "", AdnName.OTHER, "", "equals", "(Ljava/lang/Object;)Z", Downloads.RequestHeaders.COLUMN_VALUE, "Ljava/lang/Object;", "value$annotations", "()V", "isFailure-impl", "isFailure", "isSuccess-impl", "isSuccess", "constructor-impl", "Companion", "Failure", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class Result<T> implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @e
    private final Object value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlin/Result$Companion;", "", ExifInterface.GPS_DIRECTION_TRUE, Downloads.RequestHeaders.COLUMN_VALUE, "Lkotlin/Result;", bw.o, "(Ljava/lang/Object;)Ljava/lang/Object;", "", "exception", "failure", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @InlineOnly
        private final <T> Object failure(Throwable exception) {
            return Result.m83constructorimpl(ResultKt.createFailure(exception));
        }

        @InlineOnly
        private final <T> Object success(T t) {
            return Result.m83constructorimpl(t);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", AdnName.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "", "toString", "()Ljava/lang/String;", "", "exception", "Ljava/lang/Throwable;", "<init>", "(Ljava/lang/Throwable;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
    public static final class Failure implements Serializable {

        @d
        @JvmField
        public final Throwable exception;

        public Failure(@d Throwable exception) {
            Intrinsics.checkParameterIsNotNull(exception, "exception");
            this.exception = exception;
        }

        public boolean equals(@e Object r2) {
            return (r2 instanceof Failure) && Intrinsics.areEqual(this.exception, ((Failure) r2).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        @d
        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    @PublishedApi
    private /* synthetic */ Result(@e Object obj) {
        this.value = obj;
    }

    @d
    /* renamed from: box-impl */
    public static final /* synthetic */ Result m82boximpl(@e Object obj) {
        return new Result(obj);
    }

    @d
    @PublishedApi
    /* renamed from: constructor-impl */
    public static Object m83constructorimpl(@e Object obj) {
        return obj;
    }

    /* renamed from: equals-impl */
    public static boolean m84equalsimpl(Object obj, @e Object obj2) {
        return (obj2 instanceof Result) && Intrinsics.areEqual(obj, ((Result) obj2).getValue());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m85equalsimpl0(@e Object obj, @e Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    @e
    /* renamed from: exceptionOrNull-impl */
    public static final Throwable m86exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    /* renamed from: getOrNull-impl */
    private static final T m87getOrNullimpl(Object obj) {
        if (m89isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    /* renamed from: hashCode-impl */
    public static int m88hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: isFailure-impl */
    public static final boolean m89isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* renamed from: isSuccess-impl */
    public static final boolean m90isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    @d
    /* renamed from: toString-impl */
    public static String m91toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    @PublishedApi
    public static /* synthetic */ void value$annotations() {
    }

    public boolean equals(Object r2) {
        return m84equalsimpl(this.value, r2);
    }

    public int hashCode() {
        return m88hashCodeimpl(this.value);
    }

    @d
    public String toString() {
        return m91toStringimpl(this.value);
    }

    @e
    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ Object getValue() {
        return this.value;
    }
}
