package kotlin;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.api.model.AdnName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import f.b.a.e;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.UShortIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\f\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\u0014\b\u0001\u0012\u0006\u0010'\u001a\u00020&ø\u0001\u0000¢\u0006\u0004\b.\u0010/B\u0014\b\u0016\u0012\u0006\u0010-\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b.\u00100J\u001b\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\rH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0019\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001c\u0010'\u001a\u00020&8\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b'\u0010(\u0012\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lkotlin/UShortArray;", "", "Lkotlin/UShort;", "", "index", "get-impl", "([SI)S", MonitorConstants.CONNECT_TYPE_GET, Downloads.RequestHeaders.COLUMN_VALUE, "", "set-01HTLdE", "([SIS)V", "set", "Lkotlin/collections/UShortIterator;", "iterator-impl", "([S)Lkotlin/collections/UShortIterator;", "iterator", "element", "", "contains-xj2QHRw", "([SS)Z", "contains", "elements", "containsAll-impl", "([SLjava/util/Collection;)Z", "containsAll", "isEmpty-impl", "([S)Z", "isEmpty", "", "toString", "()Ljava/lang/String;", TTDownloadField.TT_HASHCODE, "()I", "", AdnName.OTHER, "equals", "(Ljava/lang/Object;)Z", "", "storage", "[S", "storage$annotations", "()V", "getSize-impl", "([S)I", OapsKey.KEY_SIZE, "constructor-impl", "([S)[S", "(I)[S", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
@ExperimentalUnsignedTypes
/* loaded from: classes5.dex */
public final class UShortArray implements Collection<UShort>, KMappedMarker {

    @d
    private final short[] storage;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lkotlin/UShortArray$Iterator;", "Lkotlin/collections/UShortIterator;", "", "hasNext", "()Z", "Lkotlin/UShort;", "nextUShort", "()S", "", "index", "I", "", "array", "[S", "<init>", "([S)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
    private static final class Iterator extends UShortIterator {
        private final short[] array;
        private int index;

        public Iterator(@d short[] array) {
            Intrinsics.checkParameterIsNotNull(array, "array");
            this.array = array;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        @Override // kotlin.collections.UShortIterator
        public short nextUShort() {
            int i2 = this.index;
            short[] sArr = this.array;
            if (i2 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            this.index = i2 + 1;
            return UShort.m334constructorimpl(sArr[i2]);
        }
    }

    @PublishedApi
    private /* synthetic */ UShortArray(@d short[] storage) {
        Intrinsics.checkParameterIsNotNull(storage, "storage");
        this.storage = storage;
    }

    @d
    /* renamed from: box-impl */
    public static final /* synthetic */ UShortArray m376boximpl(@d short[] v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        return new UShortArray(v);
    }

    @d
    /* renamed from: constructor-impl */
    public static short[] m377constructorimpl(int i2) {
        return m378constructorimpl(new short[i2]);
    }

    @d
    @PublishedApi
    /* renamed from: constructor-impl */
    public static short[] m378constructorimpl(@d short[] storage) {
        Intrinsics.checkParameterIsNotNull(storage, "storage");
        return storage;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[LOOP:0: B:6:0x0013->B:17:?, LOOP_END, SYNTHETIC] */
    /* renamed from: containsAll-impl */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m380containsAllimpl(short[] r4, @f.b.a.d java.util.Collection<kotlin.UShort> r5) {
        /*
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            boolean r0 = r5.isEmpty()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lf
        Ld:
            r1 = 1
            goto L32
        Lf:
            java.util.Iterator r5 = r5.iterator()
        L13:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto Ld
            java.lang.Object r0 = r5.next()
            boolean r3 = r0 instanceof kotlin.UShort
            if (r3 == 0) goto L2f
            kotlin.UShort r0 = (kotlin.UShort) r0
            short r0 = r0.getData()
            boolean r0 = kotlin.collections.ArraysKt.contains(r4, r0)
            if (r0 == 0) goto L2f
            r0 = 1
            goto L30
        L2f:
            r0 = 0
        L30:
            if (r0 != 0) goto L13
        L32:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.UShortArray.m380containsAllimpl(short[], java.util.Collection):boolean");
    }

    /* renamed from: equals-impl */
    public static boolean m381equalsimpl(short[] sArr, @e Object obj) {
        return (obj instanceof UShortArray) && Intrinsics.areEqual(sArr, ((UShortArray) obj).getStorage());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m382equalsimpl0(@d short[] sArr, @d short[] sArr2) {
        return Intrinsics.areEqual(sArr, sArr2);
    }

    /* renamed from: get-impl */
    public static final short m383getimpl(short[] sArr, int i2) {
        return UShort.m334constructorimpl(sArr[i2]);
    }

    /* renamed from: getSize-impl */
    public static int m384getSizeimpl(short[] sArr) {
        return sArr.length;
    }

    /* renamed from: hashCode-impl */
    public static int m385hashCodeimpl(short[] sArr) {
        if (sArr != null) {
            return Arrays.hashCode(sArr);
        }
        return 0;
    }

    /* renamed from: isEmpty-impl */
    public static boolean m386isEmptyimpl(short[] sArr) {
        return sArr.length == 0;
    }

    @d
    /* renamed from: iterator-impl */
    public static UShortIterator m387iteratorimpl(short[] sArr) {
        return new Iterator(sArr);
    }

    /* renamed from: set-01HTLdE */
    public static final void m388set01HTLdE(short[] sArr, int i2, short s) {
        sArr[i2] = s;
    }

    @PublishedApi
    public static /* synthetic */ void storage$annotations() {
    }

    @d
    /* renamed from: toString-impl */
    public static String m389toStringimpl(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ")";
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(UShort uShort) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-xj2QHRw */
    public boolean m390addxj2QHRw(short s) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UShort) {
            return m391containsxj2QHRw(((UShort) obj).getData());
        }
        return false;
    }

    /* renamed from: contains-xj2QHRw */
    public boolean m391containsxj2QHRw(short s) {
        return m379containsxj2QHRw(this.storage, s);
    }

    @Override // java.util.Collection
    public boolean containsAll(@d Collection<? extends Object> collection) {
        return m380containsAllimpl(this.storage, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object r2) {
        return m381equalsimpl(this.storage, r2);
    }

    public int getSize() {
        return m384getSizeimpl(this.storage);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m385hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m386isEmptyimpl(this.storage);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @d
    public UShortIterator iterator() {
        return m387iteratorimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    public String toString() {
        return m389toStringimpl(this.storage);
    }

    @d
    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ short[] getStorage() {
        return this.storage;
    }

    /* renamed from: contains-xj2QHRw */
    public static boolean m379containsxj2QHRw(short[] sArr, short s) {
        boolean contains;
        contains = ArraysKt___ArraysKt.contains(sArr, s);
        return contains;
    }
}
