package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.cdo.oaps.ad.OapsKey;
import f.b.a.d;
import f.b.a.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.BuilderInference;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000H\u0087\b¢\u0006\u0004\b\t\u0010\u0007\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000H\u0087\b¢\u0006\u0004\b\f\u0010\u0007\u001a&\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000e\"\u0004\b\u0000\u0010\u0000H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\f\u0010\n\u001a7\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000e\"\u0004\b\u0000\u0010\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0011\u001a'\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0000*\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a5\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0000*\u00020\u00122\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0001\"\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0014\u0010\n\u001aG\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0017\u001a\u00020\u00162!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00028\u00000\u0018H\u0087\b¢\u0006\u0004\b\u001d\u0010\u001e\u001aG\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0017\u001a\u00020\u00162!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00028\u00000\u0018H\u0087\b¢\u0006\u0004\b\u001f\u0010\u001e\u001aJ\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010 2\u001f\b\u0001\u0010#\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020!0\u0018¢\u0006\u0002\b\"H\u0087\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b$\u0010%\u001aR\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010 2\u0006\u0010&\u001a\u00020\u00162\u001f\b\u0001\u0010#\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020!0\u0018¢\u0006\u0002\b\"H\u0087\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b$\u0010\u001e\u001a \u0010(\u001a\u00020'\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\b¢\u0006\u0004\b(\u0010)\u001a3\u0010*\u001a\u00020'\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\b*\u0010)\u001a(\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002H\u0087\b¢\u0006\u0004\b+\u0010,\u001a(\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005H\u0087\b¢\u0006\u0004\b+\u0010-\u001a:\u00102\u001a\u00028\u0001\"\u0010\b\u0000\u0010.*\u0006\u0012\u0002\b\u00030\u0002*\u00028\u0001\"\u0004\b\u0001\u0010/*\u00028\u00002\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000100H\u0087\b¢\u0006\u0004\b2\u00103\u001a3\u00105\u001a\u00020'\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b4*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\b¢\u0006\u0004\b5\u00106\u001a%\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0000¢\u0006\u0004\b7\u0010-\u001aG\u0010;\u001a\u00020\u0016\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u000008*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00052\b\u0010\u0013\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u00109\u001a\u00020\u00162\b\b\u0002\u0010:\u001a\u00020\u0016¢\u0006\u0004\b;\u0010<\u001aU\u0010;\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0013\u001a\u00028\u00002\u001a\u0010?\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000=j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`>2\b\b\u0002\u00109\u001a\u00020\u00162\b\b\u0002\u0010:\u001a\u00020\u0016¢\u0006\u0004\b;\u0010@\u001af\u0010D\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010A*\b\u0012\u0004\u0012\u00028\u000108*\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0010B\u001a\u0004\u0018\u00018\u00012\b\b\u0002\u00109\u001a\u00020\u00162\b\b\u0002\u0010:\u001a\u00020\u00162\u0016\b\u0004\u0010C\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0018H\u0086\b¢\u0006\u0004\bD\u0010E\u001aE\u0010;\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\b\b\u0002\u00109\u001a\u00020\u00162\b\b\u0002\u0010:\u001a\u00020\u00162\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160\u0018¢\u0006\u0004\b;\u0010G\u001a'\u0010J\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u0016H\u0002¢\u0006\u0004\bH\u0010I\u001a\u000f\u0010K\u001a\u00020!H\u0001¢\u0006\u0004\bK\u0010L\u001a\u000f\u0010M\u001a\u00020!H\u0001¢\u0006\u0004\bM\u0010L\"\u001b\u0010Q\u001a\u00020N*\u0006\u0012\u0002\b\u00030\u00028F@\u0006¢\u0006\u0006\u001a\u0004\bO\u0010P\"#\u0010T\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00058F@\u0006¢\u0006\u0006\u001a\u0004\bR\u0010S¨\u0006U"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "", "emptyList", "()Ljava/util/List;", "elements", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "", "mutableListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "arrayListOf", "()Ljava/util/ArrayList;", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "", "element", "listOfNotNull", "(Ljava/lang/Object;)Ljava/util/List;", "", OapsKey.KEY_SIZE, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "init", "List", "(ILkotlin/jvm/functions/Function1;)Ljava/util/List;", "MutableList", ExifInterface.LONGITUDE_EAST, "", "Lkotlin/ExtensionFunctionType;", "builderAction", "buildList", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "capacity", "", "isNotEmpty", "(Ljava/util/Collection;)Z", "isNullOrEmpty", "orEmpty", "(Ljava/util/Collection;)Ljava/util/Collection;", "(Ljava/util/List;)Ljava/util/List;", "C", "R", "Lkotlin/Function0;", "defaultValue", "ifEmpty", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/internal/OnlyInputTypes;", "containsAll", "(Ljava/util/Collection;Ljava/util/Collection;)Z", "optimizeReadOnlyList", "", "fromIndex", "toIndex", "binarySearch", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "K", "key", "selector", "binarySearchBy", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "comparison", "(Ljava/util/List;IILkotlin/jvm/functions/Function1;)I", "rangeCheck$CollectionsKt__CollectionsKt", "(III)V", "rangeCheck", "throwIndexOverflow", "()V", "throwCountOverflow", "Lkotlin/ranges/IntRange;", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "indices", "getLastIndex", "(Ljava/util/List;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes.dex */
public class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> List(int i2, Function1<? super Integer, ? extends T> function1) {
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(function1.invoke(Integer.valueOf(i3)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> MutableList(int i2, Function1<? super Integer, ? extends T> function1) {
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(function1.invoke(Integer.valueOf(i3)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> ArrayList<T> arrayListOf() {
        return new ArrayList<>();
    }

    @d
    public static final <T> Collection<T> asCollection(@d T[] asCollection) {
        Intrinsics.checkParameterIsNotNull(asCollection, "$this$asCollection");
        return new ArrayAsCollection(asCollection, false);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(@d List<? extends T> binarySearch, @e T t, int i2, int i3) {
        int compareValues;
        Intrinsics.checkParameterIsNotNull(binarySearch, "$this$binarySearch");
        rangeCheck$CollectionsKt__CollectionsKt(binarySearch.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(binarySearch.get(i5), t);
            if (compareValues < 0) {
                i2 = i5 + 1;
            } else {
                if (compareValues <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static /* synthetic */ int binarySearch$default(List list, Comparable comparable, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = list.size();
        }
        return binarySearch((List<? extends Comparable>) list, comparable, i2, i3);
    }

    public static final <T, K extends Comparable<? super K>> int binarySearchBy(@d List<? extends T> binarySearchBy, @e K k, int i2, int i3, @d Function1<? super T, ? extends K> selector) {
        Intrinsics.checkParameterIsNotNull(binarySearchBy, "$this$binarySearchBy");
        Intrinsics.checkParameterIsNotNull(selector, "selector");
        return binarySearch(binarySearchBy, i2, i3, new CollectionsKt__CollectionsKt$binarySearchBy$1(selector, k));
    }

    public static /* synthetic */ int binarySearchBy$default(List binarySearchBy, Comparable comparable, int i2, int i3, Function1 selector, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = binarySearchBy.size();
        }
        Intrinsics.checkParameterIsNotNull(binarySearchBy, "$this$binarySearchBy");
        Intrinsics.checkParameterIsNotNull(selector, "selector");
        return binarySearch(binarySearchBy, i2, i3, new CollectionsKt__CollectionsKt$binarySearchBy$1(selector, comparable));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final <E> List<E> buildList(@BuilderInference Function1<? super List<E>, Unit> function1) {
        ArrayList arrayList = new ArrayList();
        function1.invoke(arrayList);
        return arrayList;
    }

    @InlineOnly
    private static final <T> boolean containsAll(@d Collection<? extends T> collection, Collection<? extends T> collection2) {
        return collection.containsAll(collection2);
    }

    @d
    public static <T> List<T> emptyList() {
        return EmptyList.INSTANCE;
    }

    @d
    public static IntRange getIndices(@d Collection<?> indices) {
        Intrinsics.checkParameterIsNotNull(indices, "$this$indices");
        return new IntRange(0, indices.size() - 1);
    }

    public static <T> int getLastIndex(@d List<? extends T> lastIndex) {
        Intrinsics.checkParameterIsNotNull(lastIndex, "$this$lastIndex");
        return lastIndex.size() - 1;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final Object ifEmpty(Collection collection, Function0 function0) {
        return collection.isEmpty() ? function0.invoke() : collection;
    }

    @InlineOnly
    private static final <T> boolean isNotEmpty(@d Collection<? extends T> collection) {
        return !collection.isEmpty();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> boolean isNullOrEmpty(@e Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    @d
    public static <T> List<T> listOf(@d T... elements) {
        List<T> asList;
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        if (elements.length <= 0) {
            return emptyList();
        }
        asList = ArraysKt___ArraysJvmKt.asList(elements);
        return asList;
    }

    @d
    public static final <T> List<T> listOfNotNull(@e T t) {
        return t != null ? CollectionsKt__CollectionsJVMKt.listOf(t) : emptyList();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> mutableListOf() {
        return new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @d
    public static <T> List<T> optimizeReadOnlyList(@d List<? extends T> optimizeReadOnlyList) {
        Intrinsics.checkParameterIsNotNull(optimizeReadOnlyList, "$this$optimizeReadOnlyList");
        int size = optimizeReadOnlyList.size();
        return size != 0 ? size != 1 ? optimizeReadOnlyList : CollectionsKt__CollectionsJVMKt.listOf(optimizeReadOnlyList.get(0)) : emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> Collection<T> orEmpty(@e Collection<? extends T> collection) {
        return collection != 0 ? collection : emptyList();
    }

    private static final void rangeCheck$CollectionsKt__CollectionsKt(int i2, int i3, int i4) {
        if (i3 > i4) {
            throw new IllegalArgumentException("fromIndex (" + i3 + ") is greater than toIndex (" + i4 + ").");
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i3 + ") is less than zero.");
        }
        if (i4 <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i4 + ") is greater than size (" + i2 + ").");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    @d
    public static final <T> ArrayList<T> arrayListOf(@d T... elements) {
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new ArrayAsCollection(elements, true));
    }

    public static /* synthetic */ int binarySearch$default(List list, Object obj, Comparator comparator, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = list.size();
        }
        return binarySearch(list, obj, comparator, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final <E> List<E> buildList(int i2, @BuilderInference Function1<? super List<E>, Unit> function1) {
        ArrayList arrayList = new ArrayList(i2);
        function1.invoke(arrayList);
        return arrayList;
    }

    @InlineOnly
    private static final <T> List<T> listOf() {
        return emptyList();
    }

    @d
    public static final <T> List<T> listOfNotNull(@d T... elements) {
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        return ArraysKt___ArraysKt.filterNotNull(elements);
    }

    @d
    public static <T> List<T> mutableListOf(@d T... elements) {
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> List<T> orEmpty(@e List<? extends T> list) {
        return list != 0 ? list : emptyList();
    }

    public static /* synthetic */ int binarySearch$default(List list, int i2, int i3, Function1 function1, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = list.size();
        }
        return binarySearch(list, i2, i3, function1);
    }

    public static final <T> int binarySearch(@d List<? extends T> binarySearch, T t, @d Comparator<? super T> comparator, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(binarySearch, "$this$binarySearch");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        rangeCheck$CollectionsKt__CollectionsKt(binarySearch.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int compare = comparator.compare(binarySearch.get(i5), t);
            if (compare < 0) {
                i2 = i5 + 1;
            } else {
                if (compare <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final <T> int binarySearch(@d List<? extends T> binarySearch, int i2, int i3, @d Function1<? super T, Integer> comparison) {
        Intrinsics.checkParameterIsNotNull(binarySearch, "$this$binarySearch");
        Intrinsics.checkParameterIsNotNull(comparison, "comparison");
        rangeCheck$CollectionsKt__CollectionsKt(binarySearch.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int intValue = comparison.invoke(binarySearch.get(i5)).intValue();
            if (intValue < 0) {
                i2 = i5 + 1;
            } else {
                if (intValue <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }
}
