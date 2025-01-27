package kotlin.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import id.c;
import kotlin.Metadata;
import kotlin.ranges.IntRange;
import p3.i;
import xi.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0004H\u0004J\u001d\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0004*\u00028\u0000H$¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000bX\u0082\u0004¢\u0006\n\n\u0002\u0010\u000e\u0012\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", ExifInterface.GPS_DIRECTION_TRUE, "", "size", "", "(I)V", c.f26972i, "getPosition", "()I", "setPosition", "spreads", "", "getSpreads$annotations", "()V", "[Ljava/lang/Object;", "addSpread", "", "spreadArgument", "(Ljava/lang/Object;)V", "toArray", "values", i.f29758c, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getSize", "(Ljava/lang/Object;)I", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class PrimitiveSpreadBuilder<T> {
    private int position;
    private final int size;

    @k
    private final T[] spreads;

    public PrimitiveSpreadBuilder(int i10) {
        this.size = i10;
        this.spreads = (T[]) new Object[i10];
    }

    private static /* synthetic */ void getSpreads$annotations() {
    }

    public final void addSpread(@k T spreadArgument) {
        Intrinsics.checkNotNullParameter(spreadArgument, "spreadArgument");
        T[] tArr = this.spreads;
        int i10 = this.position;
        this.position = i10 + 1;
        tArr[i10] = spreadArgument;
    }

    public final int getPosition() {
        return this.position;
    }

    public abstract int getSize(@k T t10);

    public final void setPosition(int i10) {
        this.position = i10;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public final int size() {
        int i10 = 0;
        ?? it = new IntRange(0, this.size - 1).iterator();
        while (it.hasNext()) {
            T t10 = this.spreads[it.nextInt()];
            i10 += t10 != null ? getSize(t10) : 1;
        }
        return i10;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @k
    public final T toArray(@k T values, @k T r92) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(r92, "result");
        ?? it = new IntRange(0, this.size - 1).iterator();
        int i10 = 0;
        int i11 = 0;
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            T t10 = this.spreads[nextInt];
            if (t10 != null) {
                if (i10 < nextInt) {
                    int i12 = nextInt - i10;
                    System.arraycopy(values, i10, r92, i11, i12);
                    i11 += i12;
                }
                int size = getSize(t10);
                System.arraycopy(t10, 0, r92, i11, size);
                i11 += size;
                i10 = nextInt + 1;
            }
        }
        int i13 = this.size;
        if (i10 < i13) {
            System.arraycopy(values, i10, r92, i11, i13 - i10);
        }
        return r92;
    }
}
