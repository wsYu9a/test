package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.internal.a;
import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.api.model.AdnName;
import f.b.a.d;
import f.b.a.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SlidingWindowKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000â\u0001\n\u0002\u0010\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\u001a0\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\b\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\f\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0087\b¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u000e\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0087\b¢\u0006\u0004\b\u000e\u0010\r\u001a\u0011\u0010\u000f\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a(\u0010\u000f\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0011\u001a\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0004*\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a*\u0010\u0012\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b\u0012\u0010\r\u001a0\u0010\u0014\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\b¢\u0006\u0004\b\u0014\u0010\u0007\u001a\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0015\u0010\t\u001a(\u0010\u0016\u001a\u00020\u0001*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a(\u0010\u0018\u001a\u00020\u0001*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b\u0018\u0010\u0017\u001a\u0011\u0010\u0019\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u0010\u001a(\u0010\u0019\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b\u0019\u0010\u0011\u001a\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0004*\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u0013\u001a*\u0010\u001a\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b\u001a\u0010\r\u001a\u0014\u0010\u001b\u001a\u00020\u0004*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u001b\u0010\u0010\u001a\u001b\u0010\u001b\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001b\u0010\u001d\u001a\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u001e\u0010\u0013\u001a\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0011\u0010 \u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b \u0010\u0010\u001a(\u0010 \u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b \u0010\u0011\u001a\u0013\u0010!\u001a\u0004\u0018\u00010\u0004*\u00020\u0000¢\u0006\u0004\b!\u0010\u0013\u001a*\u0010!\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b!\u0010\r\u001a\u0019\u0010#\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\"\u001a\u00020\u0001¢\u0006\u0004\b#\u0010$\u001a\u0019\u0010#\u001a\u00020%*\u00020%2\u0006\u0010\"\u001a\u00020\u0001¢\u0006\u0004\b#\u0010&\u001a\u0019\u0010'\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\"\u001a\u00020\u0001¢\u0006\u0004\b'\u0010$\u001a\u0019\u0010'\u001a\u00020%*\u00020%2\u0006\u0010\"\u001a\u00020\u0001¢\u0006\u0004\b'\u0010&\u001a(\u0010(\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b(\u0010)\u001a(\u0010(\u001a\u00020%*\u00020%2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b(\u0010*\u001a(\u0010+\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b+\u0010)\u001a(\u0010+\u001a\u00020%*\u00020%2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b+\u0010*\u001a(\u0010,\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b,\u0010)\u001a(\u0010,\u001a\u00020%*\u00020%2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b,\u0010*\u001a=\u00100\u001a\u00020\u0000*\u00020\u00002'\u0010\u000b\u001a#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0-H\u0086\b¢\u0006\u0004\b0\u00101\u001a=\u00100\u001a\u00020%*\u00020%2'\u0010\u000b\u001a#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0-H\u0086\b¢\u0006\u0004\b0\u00102\u001aS\u00107\u001a\u00028\u0000\"\f\b\u0000\u00105*\u000603j\u0002`4*\u00020\u00002\u0006\u00106\u001a\u00028\u00002'\u0010\u000b\u001a#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0-H\u0086\b¢\u0006\u0004\b7\u00108\u001a(\u00109\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b9\u0010)\u001a(\u00109\u001a\u00020%*\u00020%2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b9\u0010*\u001a>\u0010:\u001a\u00028\u0000\"\f\b\u0000\u00105*\u000603j\u0002`4*\u00020\u00002\u0006\u00106\u001a\u00028\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b:\u0010;\u001a>\u0010<\u001a\u00028\u0000\"\f\b\u0000\u00105*\u000603j\u0002`4*\u00020\u00002\u0006\u00106\u001a\u00028\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\b<\u0010;\u001a\u0019\u0010?\u001a\u00020\u0000*\u00020\u00002\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010@\u001a\u0019\u0010?\u001a\u00020%*\u00020%2\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010A\u001a\u001f\u0010?\u001a\u00020\u0000*\u00020\u00002\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00010B¢\u0006\u0004\b?\u0010C\u001a\"\u0010?\u001a\u00020%*\u00020%2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00010BH\u0087\b¢\u0006\u0004\b?\u0010D\u001a\u0019\u0010E\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\"\u001a\u00020\u0001¢\u0006\u0004\bE\u0010$\u001a\u0019\u0010E\u001a\u00020%*\u00020%2\u0006\u0010\"\u001a\u00020\u0001¢\u0006\u0004\bE\u0010&\u001a\u0019\u0010F\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\"\u001a\u00020\u0001¢\u0006\u0004\bF\u0010$\u001a\u0019\u0010F\u001a\u00020%*\u00020%2\u0006\u0010\"\u001a\u00020\u0001¢\u0006\u0004\bF\u0010&\u001a(\u0010G\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\bG\u0010)\u001a(\u0010G\u001a\u00020%*\u00020%2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\bG\u0010*\u001a(\u0010H\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\bH\u0010)\u001a(\u0010H\u001a\u00020%*\u00020%2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0004\bH\u0010*\u001a\u0011\u0010I\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\bI\u0010J\u001a\u0014\u0010I\u001a\u00020%*\u00020%H\u0087\b¢\u0006\u0004\bI\u0010K\u001aL\u0010Q\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010P\"\u0004\b\u0000\u0010L\"\u0004\b\u0001\u0010M*\u00020\u00002\u001e\u0010O\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010N0\u0003H\u0086\b¢\u0006\u0004\bQ\u0010R\u001a:\u0010T\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040P\"\u0004\b\u0000\u0010L*\u00020\u00002\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\b¢\u0006\u0004\bT\u0010R\u001aT\u0010T\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010P\"\u0004\b\u0000\u0010L\"\u0004\b\u0001\u0010M*\u00020\u00002\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u0003H\u0086\b¢\u0006\u0004\bT\u0010V\u001aP\u0010Y\u001a\u00028\u0001\"\u0004\b\u0000\u0010L\"\u0018\b\u0001\u0010X*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00020\u00040W*\u00020\u00002\u0006\u00106\u001a\u00028\u00012\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\b¢\u0006\u0004\bY\u0010Z\u001aj\u0010Y\u001a\u00028\u0002\"\u0004\b\u0000\u0010L\"\u0004\b\u0001\u0010M\"\u0018\b\u0002\u0010X*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010W*\u00020\u00002\u0006\u00106\u001a\u00028\u00022\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u0003H\u0086\b¢\u0006\u0004\bY\u0010[\u001ab\u0010\\\u001a\u00028\u0002\"\u0004\b\u0000\u0010L\"\u0004\b\u0001\u0010M\"\u0018\b\u0002\u0010X*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010W*\u00020\u00002\u0006\u00106\u001a\u00028\u00022\u001e\u0010O\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010N0\u0003H\u0086\b¢\u0006\u0004\b\\\u0010Z\u001a:\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000P\"\u0004\b\u0000\u0010M*\u00020\u00002\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\b¢\u0006\u0004\b^\u0010R\u001aP\u0010_\u001a\u00028\u0001\"\u0004\b\u0000\u0010M\"\u0018\b\u0001\u0010X*\u0012\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\u0006\b\u0000\u0012\u00028\u00000W*\u00020\u00002\u0006\u00106\u001a\u00028\u00012\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\b¢\u0006\u0004\b_\u0010Z\u001a+\u0010a\u001a\u00028\u0000\"\u0010\b\u0000\u00105*\n\u0012\u0006\b\u0000\u0012\u00020\u00040`*\u00020\u00002\u0006\u00106\u001a\u00028\u0000¢\u0006\u0004\ba\u0010b\u001a!\u0010e\u001a\u0012\u0012\u0004\u0012\u00020\u00040cj\b\u0012\u0004\u0012\u00020\u0004`d*\u00020\u0000¢\u0006\u0004\be\u0010f\u001a\u0017\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00040g*\u00020\u0000¢\u0006\u0004\bh\u0010i\u001a\u0017\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00040j*\u00020\u0000¢\u0006\u0004\bk\u0010i\u001a\u0017\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00040l*\u00020\u0000¢\u0006\u0004\bm\u0010n\u001a:\u0010p\u001a\b\u0012\u0004\u0012\u00028\u00000g\"\u0004\b\u0000\u0010o*\u00020\u00002\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000B0\u0003H\u0086\b¢\u0006\u0004\bp\u0010q\u001aN\u0010r\u001a\u00028\u0001\"\u0004\b\u0000\u0010o\"\u0010\b\u0001\u00105*\n\u0012\u0006\b\u0000\u0012\u00028\u00000`*\u00020\u00002\u0006\u00106\u001a\u00028\u00012\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000B0\u0003H\u0086\b¢\u0006\u0004\br\u0010s\u001a@\u0010t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040g0P\"\u0004\b\u0000\u0010L*\u00020\u00002\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\b¢\u0006\u0004\bt\u0010R\u001aZ\u0010t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010g0P\"\u0004\b\u0000\u0010L\"\u0004\b\u0001\u0010M*\u00020\u00002\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u0003H\u0086\b¢\u0006\u0004\bt\u0010V\u001aT\u0010u\u001a\u00028\u0001\"\u0004\b\u0000\u0010L\"\u001c\b\u0001\u0010X*\u0016\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040j0W*\u00020\u00002\u0006\u00106\u001a\u00028\u00012\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\b¢\u0006\u0004\bu\u0010Z\u001an\u0010u\u001a\u00028\u0002\"\u0004\b\u0000\u0010L\"\u0004\b\u0001\u0010M\"\u001c\b\u0002\u0010X*\u0016\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010j0W*\u00020\u00002\u0006\u00106\u001a\u00028\u00022\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u0003H\u0086\b¢\u0006\u0004\bu\u0010[\u001a<\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000v\"\u0004\b\u0000\u0010L*\u00020\u00002\u0014\b\u0004\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\b¢\u0006\u0004\bw\u0010x\u001a4\u0010y\u001a\b\u0012\u0004\u0012\u00028\u00000g\"\u0004\b\u0000\u0010o*\u00020\u00002\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\b¢\u0006\u0004\by\u0010q\u001aI\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000g\"\u0004\b\u0000\u0010o*\u00020\u00002'\u0010O\u001a#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000-H\u0086\b¢\u0006\u0004\bz\u0010{\u001aO\u0010}\u001a\b\u0012\u0004\u0012\u00028\u00000g\"\b\b\u0000\u0010o*\u00020|*\u00020\u00002)\u0010O\u001a%\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00018\u00000-H\u0086\b¢\u0006\u0004\b}\u0010{\u001ac\u0010~\u001a\u00028\u0001\"\b\b\u0000\u0010o*\u00020|\"\u0010\b\u0001\u00105*\n\u0012\u0006\b\u0000\u0012\u00028\u00000`*\u00020\u00002\u0006\u00106\u001a\u00028\u00012)\u0010O\u001a%\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00018\u00000-H\u0086\b¢\u0006\u0004\b~\u0010\u007f\u001a_\u0010\u0080\u0001\u001a\u00028\u0001\"\u0004\b\u0000\u0010o\"\u0010\b\u0001\u00105*\n\u0012\u0006\b\u0000\u0012\u00028\u00000`*\u00020\u00002\u0006\u00106\u001a\u00028\u00012'\u0010O\u001a#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000-H\u0086\b¢\u0006\u0005\b\u0080\u0001\u0010\u007f\u001a<\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000g\"\b\b\u0000\u0010o*\u00020|*\u00020\u00002\u0014\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0003H\u0086\b¢\u0006\u0005\b\u0081\u0001\u0010q\u001aP\u0010\u0082\u0001\u001a\u00028\u0001\"\b\b\u0000\u0010o*\u00020|\"\u0010\b\u0001\u00105*\n\u0012\u0006\b\u0000\u0012\u00028\u00000`*\u00020\u00002\u0006\u00106\u001a\u00028\u00012\u0014\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0003H\u0086\b¢\u0006\u0005\b\u0082\u0001\u0010s\u001aJ\u0010\u0083\u0001\u001a\u00028\u0001\"\u0004\b\u0000\u0010o\"\u0010\b\u0001\u00105*\n\u0012\u0006\b\u0000\u0012\u00028\u00000`*\u00020\u00002\u0006\u00106\u001a\u00028\u00012\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\b¢\u0006\u0005\b\u0083\u0001\u0010s\u001a!\u0010\u0085\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00040\u0084\u00010B*\u00020\u0000¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a+\u0010\u0087\u0001\u001a\u00020\n*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0014\u0010\u0089\u0001\u001a\u00020\n*\u00020\u0000¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a+\u0010\u0089\u0001\u001a\u00020\n*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0006\b\u0089\u0001\u0010\u0088\u0001\u001a\u0017\u0010\u008b\u0001\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a*\u0010\u008b\u0001\u001a\u00020\u0001*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0005\b\u008b\u0001\u0010\u0017\u001aQ\u0010\u0090\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010o*\u00020\u00002\u0007\u0010\u008d\u0001\u001a\u00028\u00002)\u0010\u008f\u0001\u001a$\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000-H\u0086\b¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001\u001ag\u0010\u0093\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010o*\u00020\u00002\u0007\u0010\u008d\u0001\u001a\u00028\u00002?\u0010\u008f\u0001\u001a:\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0002\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0092\u0001H\u0086\b¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001\u001aQ\u0010\u0095\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010o*\u00020\u00002\u0007\u0010\u008d\u0001\u001a\u00028\u00002)\u0010\u008f\u0001\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u00028\u00000-H\u0086\b¢\u0006\u0006\b\u0095\u0001\u0010\u0091\u0001\u001ag\u0010\u0096\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010o*\u00020\u00002\u0007\u0010\u008d\u0001\u001a\u00028\u00002?\u0010\u008f\u0001\u001a:\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u00028\u00000\u0092\u0001H\u0086\b¢\u0006\u0006\b\u0096\u0001\u0010\u0094\u0001\u001a.\u0010\u0099\u0001\u001a\u00030\u0097\u0001*\u00020\u00002\u0014\u0010\u0098\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u0097\u00010\u0003H\u0086\b¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001\u001aC\u0010\u009b\u0001\u001a\u00030\u0097\u0001*\u00020\u00002)\u0010\u0098\u0001\u001a$\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u0097\u00010-H\u0086\b¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0015\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0004*\u00020\u0000¢\u0006\u0005\b\u009d\u0001\u0010\u0013\u001a>\u0010 \u0001\u001a\u0004\u0018\u00010\u0004\"\u000f\b\u0000\u0010o*\t\u0012\u0004\u0012\u00028\u00000\u009e\u0001*\u00020\u00002\u0013\u0010\u009f\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\b¢\u0006\u0005\b \u0001\u0010\r\u001a5\u0010¤\u0001\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u001d\u0010£\u0001\u001a\u0018\u0012\u0006\b\u0000\u0012\u00020\u00040¡\u0001j\u000b\u0012\u0006\b\u0000\u0012\u00020\u0004`¢\u0001¢\u0006\u0006\b¤\u0001\u0010¥\u0001\u001a\u0015\u0010¦\u0001\u001a\u0004\u0018\u00010\u0004*\u00020\u0000¢\u0006\u0005\b¦\u0001\u0010\u0013\u001a>\u0010§\u0001\u001a\u0004\u0018\u00010\u0004\"\u000f\b\u0000\u0010o*\t\u0012\u0004\u0012\u00028\u00000\u009e\u0001*\u00020\u00002\u0013\u0010\u009f\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\b¢\u0006\u0005\b§\u0001\u0010\r\u001a5\u0010¨\u0001\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u001d\u0010£\u0001\u001a\u0018\u0012\u0006\b\u0000\u0012\u00020\u00040¡\u0001j\u000b\u0012\u0006\b\u0000\u0012\u00020\u0004`¢\u0001¢\u0006\u0006\b¨\u0001\u0010¥\u0001\u001a\u0014\u0010©\u0001\u001a\u00020\n*\u00020\u0000¢\u0006\u0006\b©\u0001\u0010\u008a\u0001\u001a+\u0010©\u0001\u001a\u00020\n*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0006\b©\u0001\u0010\u0088\u0001\u001a7\u0010«\u0001\u001a\u00028\u0000\"\t\b\u0000\u0010ª\u0001*\u00020\u0000*\u00028\u00002\u0014\u0010\u0098\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u0097\u00010\u0003H\u0087\b¢\u0006\u0005\b«\u0001\u0010)\u001aB\u0010¬\u0001\u001a\u00020\u0004*\u00020\u00002)\u0010\u008f\u0001\u001a$\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040-H\u0086\b¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001\u001aX\u0010®\u0001\u001a\u00020\u0004*\u00020\u00002?\u0010\u008f\u0001\u001a:\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0002\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0092\u0001H\u0086\b¢\u0006\u0006\b®\u0001\u0010¯\u0001\u001aD\u0010°\u0001\u001a\u0004\u0018\u00010\u0004*\u00020\u00002)\u0010\u008f\u0001\u001a$\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040-H\u0087\b¢\u0006\u0006\b°\u0001\u0010±\u0001\u001aB\u0010²\u0001\u001a\u00020\u0004*\u00020\u00002)\u0010\u008f\u0001\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u00020\u00040-H\u0086\b¢\u0006\u0006\b²\u0001\u0010\u00ad\u0001\u001aX\u0010³\u0001\u001a\u00020\u0004*\u00020\u00002?\u0010\u008f\u0001\u001a:\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u00020\u00040\u0092\u0001H\u0086\b¢\u0006\u0006\b³\u0001\u0010¯\u0001\u001aD\u0010´\u0001\u001a\u0004\u0018\u00010\u0004*\u00020\u00002)\u0010\u008f\u0001\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u00020\u00040-H\u0087\b¢\u0006\u0006\b´\u0001\u0010±\u0001\u001aW\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000g\"\u0004\b\u0000\u0010o*\u00020\u00002\u0007\u0010\u008d\u0001\u001a\u00028\u00002)\u0010\u008f\u0001\u001a$\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000-H\u0087\b¢\u0006\u0006\bµ\u0001\u0010¶\u0001\u001am\u0010·\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000g\"\u0004\b\u0000\u0010o*\u00020\u00002\u0007\u0010\u008d\u0001\u001a\u00028\u00002?\u0010\u008f\u0001\u001a:\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0002\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0092\u0001H\u0087\b¢\u0006\u0006\b·\u0001\u0010¸\u0001\u001aG\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040g*\u00020\u00002)\u0010\u008f\u0001\u001a$\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040-H\u0087\b¢\u0006\u0005\b¹\u0001\u0010{\u001a^\u0010º\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040g*\u00020\u00002?\u0010\u008f\u0001\u001a:\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0002\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0092\u0001H\u0087\b¢\u0006\u0006\bº\u0001\u0010»\u0001\u001a+\u0010¼\u0001\u001a\u00020\u0001*\u00020\u00002\u0013\u0010\u009f\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0086\b¢\u0006\u0005\b¼\u0001\u0010\u0017\u001a.\u0010¾\u0001\u001a\u00030½\u0001*\u00020\u00002\u0014\u0010\u009f\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030½\u00010\u0003H\u0086\b¢\u0006\u0006\b¾\u0001\u0010¿\u0001\u001a%\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020%0g*\u00020\u00002\u0007\u0010À\u0001\u001a\u00020\u0001H\u0007¢\u0006\u0006\bÁ\u0001\u0010Â\u0001\u001a?\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000g\"\u0004\b\u0000\u0010o*\u00020\u00002\u0007\u0010À\u0001\u001a\u00020\u00012\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0003H\u0007¢\u0006\u0006\bÁ\u0001\u0010Ã\u0001\u001a&\u0010Å\u0001\u001a\t\u0012\u0004\u0012\u00020%0Ä\u0001*\u00020\u00002\u0007\u0010À\u0001\u001a\u00020\u0001H\u0007¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001\u001a@\u0010Å\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000Ä\u0001\"\u0004\b\u0000\u0010o*\u00020\u00002\u0007\u0010À\u0001\u001a\u00020\u00012\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0003H\u0007¢\u0006\u0006\bÅ\u0001\u0010Ç\u0001\u001a7\u0010È\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000N*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0006\bÈ\u0001\u0010É\u0001\u001a7\u0010È\u0001\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0N*\u00020%2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H\u0086\b¢\u0006\u0006\bÈ\u0001\u0010Ê\u0001\u001a;\u0010Í\u0001\u001a\b\u0012\u0004\u0012\u00020%0g*\u00020\u00002\u0007\u0010À\u0001\u001a\u00020\u00012\t\b\u0002\u0010Ë\u0001\u001a\u00020\u00012\t\b\u0002\u0010Ì\u0001\u001a\u00020\nH\u0007¢\u0006\u0006\bÍ\u0001\u0010Î\u0001\u001aU\u0010Í\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000g\"\u0004\b\u0000\u0010o*\u00020\u00002\u0007\u0010À\u0001\u001a\u00020\u00012\t\b\u0002\u0010Ë\u0001\u001a\u00020\u00012\t\b\u0002\u0010Ì\u0001\u001a\u00020\n2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0003H\u0007¢\u0006\u0006\bÍ\u0001\u0010Ï\u0001\u001a<\u0010Ð\u0001\u001a\t\u0012\u0004\u0012\u00020%0Ä\u0001*\u00020\u00002\u0007\u0010À\u0001\u001a\u00020\u00012\t\b\u0002\u0010Ë\u0001\u001a\u00020\u00012\t\b\u0002\u0010Ì\u0001\u001a\u00020\nH\u0007¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001\u001aV\u0010Ð\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000Ä\u0001\"\u0004\b\u0000\u0010o*\u00020\u00002\u0007\u0010À\u0001\u001a\u00020\u00012\t\b\u0002\u0010Ë\u0001\u001a\u00020\u00012\t\b\u0002\u0010Ì\u0001\u001a\u00020\n2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0003H\u0007¢\u0006\u0006\bÐ\u0001\u0010Ò\u0001\u001a2\u0010Ô\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040N0g*\u00020\u00002\u0007\u0010Ó\u0001\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001\u001af\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000g\"\u0004\b\u0000\u0010M*\u00020\u00002\u0007\u0010Ó\u0001\u001a\u00020\u000028\u0010O\u001a4\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(Ö\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(×\u0001\u0012\u0004\u0012\u00028\u00000-H\u0086\b¢\u0006\u0006\bÔ\u0001\u0010Ø\u0001\u001a'\u0010Ù\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040N0g*\u00020\u0000H\u0007¢\u0006\u0005\bÙ\u0001\u0010i\u001a\\\u0010Ù\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000g\"\u0004\b\u0000\u0010o*\u00020\u000028\u0010O\u001a4\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(Ö\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b.\u0012\t\b/\u0012\u0005\b\b(×\u0001\u0012\u0004\u0012\u00028\u00000-H\u0087\b¢\u0006\u0005\bÙ\u0001\u0010{\u001a\u001a\u0010Ú\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040B*\u00020\u0000¢\u0006\u0006\bÚ\u0001\u0010\u0086\u0001\u001a\u001b\u0010Û\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040Ä\u0001*\u00020\u0000¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001¨\u0006Ý\u0001"}, d2 = {"", "", "index", "Lkotlin/Function1;", "", "defaultValue", "elementAtOrElse", "(Ljava/lang/CharSequence;ILkotlin/jvm/functions/Function1;)C", "elementAtOrNull", "(Ljava/lang/CharSequence;I)Ljava/lang/Character;", "", "predicate", "find", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "findLast", "first", "(Ljava/lang/CharSequence;)C", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)C", "firstOrNull", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "getOrElse", "getOrNull", "indexOfFirst", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)I", "indexOfLast", "last", "lastOrNull", "random", "Lkotlin/random/Random;", "(Ljava/lang/CharSequence;Lkotlin/random/Random;)C", "randomOrNull", "(Ljava/lang/CharSequence;Lkotlin/random/Random;)Ljava/lang/Character;", "single", "singleOrNull", "n", "drop", "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "", "(Ljava/lang/String;I)Ljava/lang/String;", "dropLast", "dropLastWhile", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/CharSequence;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "dropWhile", "filter", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexed", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;)Ljava/lang/CharSequence;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Ljava/lang/String;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "C", "destination", "filterIndexedTo", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function2;)Ljava/lang/Appendable;", "filterNot", "filterNotTo", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "filterTo", "Lkotlin/ranges/IntRange;", "indices", "slice", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)Ljava/lang/CharSequence;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)Ljava/lang/String;", "", "(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/CharSequence;", "(Ljava/lang/String;Ljava/lang/Iterable;)Ljava/lang/String;", "take", "takeLast", "takeLastWhile", "takeWhile", "reversed", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "(Ljava/lang/String;)Ljava/lang/String;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Pair;", "transform", "", "associate", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "keySelector", "associateBy", "valueTransform", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "", "M", "associateByTo", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "valueSelector", "associateWith", "associateWithTo", "", "toCollection", "(Ljava/lang/CharSequence;Ljava/util/Collection;)Ljava/util/Collection;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toHashSet", "(Ljava/lang/CharSequence;)Ljava/util/HashSet;", "", "toList", "(Ljava/lang/CharSequence;)Ljava/util/List;", "", "toMutableList", "", "toSet", "(Ljava/lang/CharSequence;)Ljava/util/Set;", "R", "flatMap", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "flatMapTo", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "groupBy", "groupByTo", "Lkotlin/collections/Grouping;", "groupingBy", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Lkotlin/collections/Grouping;", "map", "mapIndexed", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "", "mapIndexedNotNull", "mapIndexedNotNullTo", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "Lkotlin/collections/IndexedValue;", "withIndex", "(Ljava/lang/CharSequence;)Ljava/lang/Iterable;", "all", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Z", "any", "(Ljava/lang/CharSequence;)Z", "count", "(Ljava/lang/CharSequence;)I", "initial", "acc", "operation", "fold", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lkotlin/Function3;", "foldIndexed", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "", "action", "forEach", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)V", "forEachIndexed", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;)V", "max", "", "selector", "maxBy", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "maxWith", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "min", "minBy", "minWith", a.f5472a, ExifInterface.LATITUDE_SOUTH, "onEach", "reduce", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;)C", "reduceIndexed", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function3;)C", "reduceOrNull", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;)Ljava/lang/Character;", "reduceRight", "reduceRightIndexed", "reduceRightOrNull", "scan", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "scanIndexed", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "scanReduce", "scanReduceIndexed", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "sumBy", "", "sumByDouble", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)D", OapsKey.KEY_SIZE, "chunked", "(Ljava/lang/CharSequence;I)Ljava/util/List;", "(Ljava/lang/CharSequence;ILkotlin/jvm/functions/Function1;)Ljava/util/List;", "Lkotlin/sequences/Sequence;", "chunkedSequence", "(Ljava/lang/CharSequence;I)Lkotlin/sequences/Sequence;", "(Ljava/lang/CharSequence;ILkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "partition", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Lkotlin/Pair;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lkotlin/Pair;", "step", "partialWindows", "windowed", "(Ljava/lang/CharSequence;IIZ)Ljava/util/List;", "(Ljava/lang/CharSequence;IIZLkotlin/jvm/functions/Function1;)Ljava/util/List;", "windowedSequence", "(Ljava/lang/CharSequence;IIZ)Lkotlin/sequences/Sequence;", "(Ljava/lang/CharSequence;IIZLkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", AdnName.OTHER, "zip", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/util/List;", "a", "b", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "zipWithNext", "asIterable", "asSequence", "(Ljava/lang/CharSequence;)Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/text/StringsKt")
/* loaded from: classes5.dex */
class StringsKt___StringsKt extends StringsKt___StringsJvmKt {
    public static final boolean all(@d CharSequence all, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(all, "$this$all");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        for (int i2 = 0; i2 < all.length(); i2++) {
            if (!predicate.invoke(Character.valueOf(all.charAt(i2))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@d CharSequence any) {
        Intrinsics.checkParameterIsNotNull(any, "$this$any");
        return !(any.length() == 0);
    }

    @d
    public static final Iterable<Character> asIterable(@d CharSequence asIterable) {
        Intrinsics.checkParameterIsNotNull(asIterable, "$this$asIterable");
        if (asIterable instanceof String) {
            if (asIterable.length() == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
        }
        return new StringsKt___StringsKt$asIterable$$inlined$Iterable$1(asIterable);
    }

    @d
    public static final Sequence<Character> asSequence(@d final CharSequence asSequence) {
        Intrinsics.checkParameterIsNotNull(asSequence, "$this$asSequence");
        if (asSequence instanceof String) {
            if (asSequence.length() == 0) {
                return SequencesKt__SequencesKt.emptySequence();
            }
        }
        return new Sequence<Character>() { // from class: kotlin.text.StringsKt___StringsKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            @d
            public Iterator<Character> iterator() {
                return StringsKt__StringsKt.iterator(asSequence);
            }
        };
    }

    @d
    public static final <K, V> Map<K, V> associate(@d CharSequence associate, @d Function1<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkParameterIsNotNull(associate, "$this$associate");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(associate.length());
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (int i2 = 0; i2 < associate.length(); i2++) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Character.valueOf(associate.charAt(i2)));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @d
    public static final <K> Map<K, Character> associateBy(@d CharSequence associateBy, @d Function1<? super Character, ? extends K> keySelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkParameterIsNotNull(associateBy, "$this$associateBy");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(associateBy.length());
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (int i2 = 0; i2 < associateBy.length(); i2++) {
            char charAt = associateBy.charAt(i2);
            linkedHashMap.put(keySelector.invoke(Character.valueOf(charAt)), Character.valueOf(charAt));
        }
        return linkedHashMap;
    }

    @d
    public static final <K, M extends Map<? super K, ? super Character>> M associateByTo(@d CharSequence associateByTo, @d M destination, @d Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkParameterIsNotNull(associateByTo, "$this$associateByTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        for (int i2 = 0; i2 < associateByTo.length(); i2++) {
            char charAt = associateByTo.charAt(i2);
            destination.put(keySelector.invoke(Character.valueOf(charAt)), Character.valueOf(charAt));
        }
        return destination;
    }

    @d
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@d CharSequence associateTo, @d M destination, @d Function1<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkParameterIsNotNull(associateTo, "$this$associateTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        for (int i2 = 0; i2 < associateTo.length(); i2++) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Character.valueOf(associateTo.charAt(i2)));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final <V> Map<Character, V> associateWith(@d CharSequence associateWith, @d Function1<? super Character, ? extends V> valueSelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkParameterIsNotNull(associateWith, "$this$associateWith");
        Intrinsics.checkParameterIsNotNull(valueSelector, "valueSelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(associateWith.length());
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (int i2 = 0; i2 < associateWith.length(); i2++) {
            char charAt = associateWith.charAt(i2);
            linkedHashMap.put(Character.valueOf(charAt), valueSelector.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final <V, M extends Map<? super Character, ? super V>> M associateWithTo(@d CharSequence associateWithTo, @d M destination, @d Function1<? super Character, ? extends V> valueSelector) {
        Intrinsics.checkParameterIsNotNull(associateWithTo, "$this$associateWithTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(valueSelector, "valueSelector");
        for (int i2 = 0; i2 < associateWithTo.length(); i2++) {
            char charAt = associateWithTo.charAt(i2);
            destination.put(Character.valueOf(charAt), valueSelector.invoke(Character.valueOf(charAt)));
        }
        return destination;
    }

    @d
    @SinceKotlin(version = "1.2")
    public static final List<String> chunked(@d CharSequence chunked, int i2) {
        Intrinsics.checkParameterIsNotNull(chunked, "$this$chunked");
        return windowed(chunked, i2, i2, true);
    }

    @d
    @SinceKotlin(version = "1.2")
    public static final Sequence<String> chunkedSequence(@d CharSequence chunkedSequence, int i2) {
        Intrinsics.checkParameterIsNotNull(chunkedSequence, "$this$chunkedSequence");
        return chunkedSequence(chunkedSequence, i2, new Function1<CharSequence, String>() { // from class: kotlin.text.StringsKt___StringsKt$chunkedSequence$1
            @Override // kotlin.jvm.functions.Function1
            @d
            public final String invoke(@d CharSequence it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return it.toString();
            }
        });
    }

    @InlineOnly
    private static final int count(@d CharSequence charSequence) {
        return charSequence.length();
    }

    @d
    public static final CharSequence drop(@d CharSequence drop, int i2) {
        int coerceAtMost;
        Intrinsics.checkParameterIsNotNull(drop, "$this$drop");
        if (i2 >= 0) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i2, drop.length());
            return drop.subSequence(coerceAtMost, drop.length());
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    @d
    public static final CharSequence dropLast(@d CharSequence dropLast, int i2) {
        int coerceAtLeast;
        Intrinsics.checkParameterIsNotNull(dropLast, "$this$dropLast");
        if (i2 >= 0) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(dropLast.length() - i2, 0);
            return take(dropLast, coerceAtLeast);
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    @d
    public static final CharSequence dropLastWhile(@d CharSequence dropLastWhile, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(dropLastWhile, "$this$dropLastWhile");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(dropLastWhile); lastIndex >= 0; lastIndex--) {
            if (!predicate.invoke(Character.valueOf(dropLastWhile.charAt(lastIndex))).booleanValue()) {
                return dropLastWhile.subSequence(0, lastIndex + 1);
            }
        }
        return "";
    }

    @d
    public static final CharSequence dropWhile(@d CharSequence dropWhile, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(dropWhile, "$this$dropWhile");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = dropWhile.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!predicate.invoke(Character.valueOf(dropWhile.charAt(i2))).booleanValue()) {
                return dropWhile.subSequence(i2, dropWhile.length());
            }
        }
        return "";
    }

    @InlineOnly
    private static final char elementAtOrElse(@d CharSequence charSequence, int i2, Function1<? super Integer, Character> function1) {
        return (i2 < 0 || i2 > StringsKt__StringsKt.getLastIndex(charSequence)) ? function1.invoke(Integer.valueOf(i2)).charValue() : charSequence.charAt(i2);
    }

    @InlineOnly
    private static final Character elementAtOrNull(@d CharSequence charSequence, int i2) {
        return getOrNull(charSequence, i2);
    }

    @d
    public static final CharSequence filter(@d CharSequence filter, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(filter, "$this$filter");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int length = filter.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = filter.charAt(i2);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    @d
    public static final CharSequence filterIndexed(@d CharSequence filterIndexed, @d Function2<? super Integer, ? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(filterIndexed, "$this$filterIndexed");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        while (i2 < filterIndexed.length()) {
            char charAt = filterIndexed.charAt(i2);
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
            i2++;
            i3 = i4;
        }
        return sb;
    }

    @d
    public static final <C extends Appendable> C filterIndexedTo(@d CharSequence filterIndexedTo, @d C destination, @d Function2<? super Integer, ? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(filterIndexedTo, "$this$filterIndexedTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int i2 = 0;
        int i3 = 0;
        while (i2 < filterIndexedTo.length()) {
            char charAt = filterIndexedTo.charAt(i2);
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Character.valueOf(charAt)).booleanValue()) {
                destination.append(charAt);
            }
            i2++;
            i3 = i4;
        }
        return destination;
    }

    @d
    public static final CharSequence filterNot(@d CharSequence filterNot, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(filterNot, "$this$filterNot");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < filterNot.length(); i2++) {
            char charAt = filterNot.charAt(i2);
            if (!predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    @d
    public static final <C extends Appendable> C filterNotTo(@d CharSequence filterNotTo, @d C destination, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(filterNotTo, "$this$filterNotTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        for (int i2 = 0; i2 < filterNotTo.length(); i2++) {
            char charAt = filterNotTo.charAt(i2);
            if (!predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                destination.append(charAt);
            }
        }
        return destination;
    }

    @d
    public static final <C extends Appendable> C filterTo(@d CharSequence filterTo, @d C destination, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(filterTo, "$this$filterTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = filterTo.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = filterTo.charAt(i2);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                destination.append(charAt);
            }
        }
        return destination;
    }

    @InlineOnly
    private static final Character find(@d CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                return Character.valueOf(charAt);
            }
        }
        return null;
    }

    @InlineOnly
    private static final Character findLast(@d CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        char charAt;
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return null;
            }
            charAt = charSequence.charAt(length);
        } while (!function1.invoke(Character.valueOf(charAt)).booleanValue());
        return Character.valueOf(charAt);
    }

    public static final char first(@d CharSequence first) {
        Intrinsics.checkParameterIsNotNull(first, "$this$first");
        if (first.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return first.charAt(0);
    }

    @e
    public static final Character firstOrNull(@d CharSequence firstOrNull) {
        Intrinsics.checkParameterIsNotNull(firstOrNull, "$this$firstOrNull");
        if (firstOrNull.length() == 0) {
            return null;
        }
        return Character.valueOf(firstOrNull.charAt(0));
    }

    @d
    public static final <R> List<R> flatMap(@d CharSequence flatMap, @d Function1<? super Character, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkParameterIsNotNull(flatMap, "$this$flatMap");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < flatMap.length(); i2++) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Character.valueOf(flatMap.charAt(i2))));
        }
        return arrayList;
    }

    @d
    public static final <R, C extends Collection<? super R>> C flatMapTo(@d CharSequence flatMapTo, @d C destination, @d Function1<? super Character, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkParameterIsNotNull(flatMapTo, "$this$flatMapTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        for (int i2 = 0; i2 < flatMapTo.length(); i2++) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Character.valueOf(flatMapTo.charAt(i2))));
        }
        return destination;
    }

    public static final <R> R fold(@d CharSequence fold, R r, @d Function2<? super R, ? super Character, ? extends R> operation) {
        Intrinsics.checkParameterIsNotNull(fold, "$this$fold");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        for (int i2 = 0; i2 < fold.length(); i2++) {
            r = operation.invoke(r, Character.valueOf(fold.charAt(i2)));
        }
        return r;
    }

    public static final <R> R foldIndexed(@d CharSequence foldIndexed, R r, @d Function3<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        Intrinsics.checkParameterIsNotNull(foldIndexed, "$this$foldIndexed");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        int i2 = 0;
        for (int i3 = 0; i3 < foldIndexed.length(); i3++) {
            char charAt = foldIndexed.charAt(i3);
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            r = operation.invoke(valueOf, r, Character.valueOf(charAt));
        }
        return r;
    }

    public static final <R> R foldRight(@d CharSequence foldRight, R r, @d Function2<? super Character, ? super R, ? extends R> operation) {
        Intrinsics.checkParameterIsNotNull(foldRight, "$this$foldRight");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(foldRight); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Character.valueOf(foldRight.charAt(lastIndex)), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@d CharSequence foldRightIndexed, R r, @d Function3<? super Integer, ? super Character, ? super R, ? extends R> operation) {
        Intrinsics.checkParameterIsNotNull(foldRightIndexed, "$this$foldRightIndexed");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(foldRightIndexed); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(Integer.valueOf(lastIndex), Character.valueOf(foldRightIndexed.charAt(lastIndex)), r);
        }
        return r;
    }

    public static final void forEach(@d CharSequence forEach, @d Function1<? super Character, Unit> action) {
        Intrinsics.checkParameterIsNotNull(forEach, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(action, "action");
        for (int i2 = 0; i2 < forEach.length(); i2++) {
            action.invoke(Character.valueOf(forEach.charAt(i2)));
        }
    }

    public static final void forEachIndexed(@d CharSequence forEachIndexed, @d Function2<? super Integer, ? super Character, Unit> action) {
        Intrinsics.checkParameterIsNotNull(forEachIndexed, "$this$forEachIndexed");
        Intrinsics.checkParameterIsNotNull(action, "action");
        int i2 = 0;
        for (int i3 = 0; i3 < forEachIndexed.length(); i3++) {
            char charAt = forEachIndexed.charAt(i3);
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            action.invoke(valueOf, Character.valueOf(charAt));
        }
    }

    @InlineOnly
    private static final char getOrElse(@d CharSequence charSequence, int i2, Function1<? super Integer, Character> function1) {
        return (i2 < 0 || i2 > StringsKt__StringsKt.getLastIndex(charSequence)) ? function1.invoke(Integer.valueOf(i2)).charValue() : charSequence.charAt(i2);
    }

    @e
    public static final Character getOrNull(@d CharSequence getOrNull, int i2) {
        Intrinsics.checkParameterIsNotNull(getOrNull, "$this$getOrNull");
        if (i2 < 0 || i2 > StringsKt__StringsKt.getLastIndex(getOrNull)) {
            return null;
        }
        return Character.valueOf(getOrNull.charAt(i2));
    }

    @d
    public static final <K> Map<K, List<Character>> groupBy(@d CharSequence groupBy, @d Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkParameterIsNotNull(groupBy, "$this$groupBy");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 = 0; i2 < groupBy.length(); i2++) {
            char charAt = groupBy.charAt(i2);
            K invoke = keySelector.invoke(Character.valueOf(charAt));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Character.valueOf(charAt));
        }
        return linkedHashMap;
    }

    @d
    public static final <K, M extends Map<? super K, List<Character>>> M groupByTo(@d CharSequence groupByTo, @d M destination, @d Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkParameterIsNotNull(groupByTo, "$this$groupByTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        for (int i2 = 0; i2 < groupByTo.length(); i2++) {
            char charAt = groupByTo.charAt(i2);
            K invoke = keySelector.invoke(Character.valueOf(charAt));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Character.valueOf(charAt));
        }
        return destination;
    }

    @d
    @SinceKotlin(version = "1.1")
    public static final <K> Grouping<Character, K> groupingBy(@d final CharSequence groupingBy, @d final Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkParameterIsNotNull(groupingBy, "$this$groupingBy");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        return new Grouping<Character, K>() { // from class: kotlin.text.StringsKt___StringsKt$groupingBy$1
            @Override // kotlin.collections.Grouping
            public /* bridge */ /* synthetic */ Object keyOf(Character ch) {
                return keyOf(ch.charValue());
            }

            @Override // kotlin.collections.Grouping
            @d
            public Iterator<Character> sourceIterator() {
                return StringsKt__StringsKt.iterator(groupingBy);
            }

            public K keyOf(char element) {
                return (K) keySelector.invoke(Character.valueOf(element));
            }
        };
    }

    public static final int indexOfFirst(@d CharSequence indexOfFirst, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(indexOfFirst, "$this$indexOfFirst");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = indexOfFirst.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (predicate.invoke(Character.valueOf(indexOfFirst.charAt(i2))).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@d CharSequence indexOfLast, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(indexOfLast, "$this$indexOfLast");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        for (int length = indexOfLast.length() - 1; length >= 0; length--) {
            if (predicate.invoke(Character.valueOf(indexOfLast.charAt(length))).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    public static final char last(@d CharSequence last) {
        Intrinsics.checkParameterIsNotNull(last, "$this$last");
        if (last.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return last.charAt(StringsKt__StringsKt.getLastIndex(last));
    }

    @e
    public static final Character lastOrNull(@d CharSequence lastOrNull) {
        Intrinsics.checkParameterIsNotNull(lastOrNull, "$this$lastOrNull");
        if (lastOrNull.length() == 0) {
            return null;
        }
        return Character.valueOf(lastOrNull.charAt(lastOrNull.length() - 1));
    }

    @d
    public static final <R> List<R> map(@d CharSequence map, @d Function1<? super Character, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(map, "$this$map");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        ArrayList arrayList = new ArrayList(map.length());
        for (int i2 = 0; i2 < map.length(); i2++) {
            arrayList.add(transform.invoke(Character.valueOf(map.charAt(i2))));
        }
        return arrayList;
    }

    @d
    public static final <R> List<R> mapIndexed(@d CharSequence mapIndexed, @d Function2<? super Integer, ? super Character, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(mapIndexed, "$this$mapIndexed");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        ArrayList arrayList = new ArrayList(mapIndexed.length());
        int i2 = 0;
        for (int i3 = 0; i3 < mapIndexed.length(); i3++) {
            char charAt = mapIndexed.charAt(i3);
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(transform.invoke(valueOf, Character.valueOf(charAt)));
        }
        return arrayList;
    }

    @d
    public static final <R> List<R> mapIndexedNotNull(@d CharSequence mapIndexedNotNull, @d Function2<? super Integer, ? super Character, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(mapIndexedNotNull, "$this$mapIndexedNotNull");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (i2 < mapIndexedNotNull.length()) {
            int i4 = i3 + 1;
            R invoke = transform.invoke(Integer.valueOf(i3), Character.valueOf(mapIndexedNotNull.charAt(i2)));
            if (invoke != null) {
                arrayList.add(invoke);
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    @d
    public static final <R, C extends Collection<? super R>> C mapIndexedNotNullTo(@d CharSequence mapIndexedNotNullTo, @d C destination, @d Function2<? super Integer, ? super Character, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(mapIndexedNotNullTo, "$this$mapIndexedNotNullTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        int i2 = 0;
        int i3 = 0;
        while (i2 < mapIndexedNotNullTo.length()) {
            int i4 = i3 + 1;
            R invoke = transform.invoke(Integer.valueOf(i3), Character.valueOf(mapIndexedNotNullTo.charAt(i2)));
            if (invoke != null) {
                destination.add(invoke);
            }
            i2++;
            i3 = i4;
        }
        return destination;
    }

    @d
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@d CharSequence mapIndexedTo, @d C destination, @d Function2<? super Integer, ? super Character, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(mapIndexedTo, "$this$mapIndexedTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        int i2 = 0;
        for (int i3 = 0; i3 < mapIndexedTo.length(); i3++) {
            char charAt = mapIndexedTo.charAt(i3);
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            destination.add(transform.invoke(valueOf, Character.valueOf(charAt)));
        }
        return destination;
    }

    @d
    public static final <R> List<R> mapNotNull(@d CharSequence mapNotNull, @d Function1<? super Character, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(mapNotNull, "$this$mapNotNull");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < mapNotNull.length(); i2++) {
            R invoke = transform.invoke(Character.valueOf(mapNotNull.charAt(i2)));
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @d
    public static final <R, C extends Collection<? super R>> C mapNotNullTo(@d CharSequence mapNotNullTo, @d C destination, @d Function1<? super Character, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(mapNotNullTo, "$this$mapNotNullTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        for (int i2 = 0; i2 < mapNotNullTo.length(); i2++) {
            R invoke = transform.invoke(Character.valueOf(mapNotNullTo.charAt(i2)));
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    @d
    public static final <R, C extends Collection<? super R>> C mapTo(@d CharSequence mapTo, @d C destination, @d Function1<? super Character, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(mapTo, "$this$mapTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        for (int i2 = 0; i2 < mapTo.length(); i2++) {
            destination.add(transform.invoke(Character.valueOf(mapTo.charAt(i2))));
        }
        return destination;
    }

    @e
    public static final Character max(@d CharSequence max) {
        Intrinsics.checkParameterIsNotNull(max, "$this$max");
        int i2 = 1;
        if (max.length() == 0) {
            return null;
        }
        char charAt = max.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(max);
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = max.charAt(i2);
                if (charAt < charAt2) {
                    charAt = charAt2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(charAt);
    }

    @e
    public static final <R extends Comparable<? super R>> Character maxBy(@d CharSequence maxBy, @d Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkParameterIsNotNull(maxBy, "$this$maxBy");
        Intrinsics.checkParameterIsNotNull(selector, "selector");
        int i2 = 1;
        if (maxBy.length() == 0) {
            return null;
        }
        char charAt = maxBy.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(maxBy);
        if (lastIndex == 0) {
            return Character.valueOf(charAt);
        }
        R invoke = selector.invoke(Character.valueOf(charAt));
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = maxBy.charAt(i2);
                R invoke2 = selector.invoke(Character.valueOf(charAt2));
                if (invoke.compareTo(invoke2) < 0) {
                    charAt = charAt2;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(charAt);
    }

    @e
    public static final Character maxWith(@d CharSequence maxWith, @d Comparator<? super Character> comparator) {
        Intrinsics.checkParameterIsNotNull(maxWith, "$this$maxWith");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i2 = 1;
        if (maxWith.length() == 0) {
            return null;
        }
        char charAt = maxWith.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(maxWith);
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = maxWith.charAt(i2);
                if (comparator.compare(Character.valueOf(charAt), Character.valueOf(charAt2)) < 0) {
                    charAt = charAt2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(charAt);
    }

    @e
    public static final Character min(@d CharSequence min) {
        Intrinsics.checkParameterIsNotNull(min, "$this$min");
        int i2 = 1;
        if (min.length() == 0) {
            return null;
        }
        char charAt = min.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(min);
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = min.charAt(i2);
                if (charAt > charAt2) {
                    charAt = charAt2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(charAt);
    }

    @e
    public static final <R extends Comparable<? super R>> Character minBy(@d CharSequence minBy, @d Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkParameterIsNotNull(minBy, "$this$minBy");
        Intrinsics.checkParameterIsNotNull(selector, "selector");
        int i2 = 1;
        if (minBy.length() == 0) {
            return null;
        }
        char charAt = minBy.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(minBy);
        if (lastIndex == 0) {
            return Character.valueOf(charAt);
        }
        R invoke = selector.invoke(Character.valueOf(charAt));
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = minBy.charAt(i2);
                R invoke2 = selector.invoke(Character.valueOf(charAt2));
                if (invoke.compareTo(invoke2) > 0) {
                    charAt = charAt2;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(charAt);
    }

    @e
    public static final Character minWith(@d CharSequence minWith, @d Comparator<? super Character> comparator) {
        Intrinsics.checkParameterIsNotNull(minWith, "$this$minWith");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i2 = 1;
        if (minWith.length() == 0) {
            return null;
        }
        char charAt = minWith.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(minWith);
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = minWith.charAt(i2);
                if (comparator.compare(Character.valueOf(charAt), Character.valueOf(charAt2)) > 0) {
                    charAt = charAt2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(charAt);
    }

    public static final boolean none(@d CharSequence none) {
        Intrinsics.checkParameterIsNotNull(none, "$this$none");
        return none.length() == 0;
    }

    @d
    @SinceKotlin(version = "1.1")
    public static final <S extends CharSequence> S onEach(@d S onEach, @d Function1<? super Character, Unit> action) {
        Intrinsics.checkParameterIsNotNull(onEach, "$this$onEach");
        Intrinsics.checkParameterIsNotNull(action, "action");
        for (int i2 = 0; i2 < onEach.length(); i2++) {
            action.invoke(Character.valueOf(onEach.charAt(i2)));
        }
        return onEach;
    }

    @d
    public static final Pair<CharSequence, CharSequence> partition(@d CharSequence partition, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(partition, "$this$partition");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i2 = 0; i2 < partition.length(); i2++) {
            char charAt = partition.charAt(i2);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            } else {
                sb2.append(charAt);
            }
        }
        return new Pair<>(sb, sb2);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final char random(@d CharSequence charSequence) {
        return random(charSequence, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final Character randomOrNull(@d CharSequence charSequence) {
        return randomOrNull(charSequence, Random.INSTANCE);
    }

    public static final char reduce(@d CharSequence reduce, @d Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkParameterIsNotNull(reduce, "$this$reduce");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        int i2 = 1;
        if (reduce.length() == 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char charAt = reduce.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(reduce);
        if (1 <= lastIndex) {
            while (true) {
                charAt = operation.invoke(Character.valueOf(charAt), Character.valueOf(reduce.charAt(i2))).charValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return charAt;
    }

    public static final char reduceIndexed(@d CharSequence reduceIndexed, @d Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        Intrinsics.checkParameterIsNotNull(reduceIndexed, "$this$reduceIndexed");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        int i2 = 1;
        if (reduceIndexed.length() == 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char charAt = reduceIndexed.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(reduceIndexed);
        if (1 <= lastIndex) {
            while (true) {
                charAt = operation.invoke(Integer.valueOf(i2), Character.valueOf(charAt), Character.valueOf(reduceIndexed.charAt(i2))).charValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return charAt;
    }

    @e
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final Character reduceOrNull(@d CharSequence reduceOrNull, @d Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkParameterIsNotNull(reduceOrNull, "$this$reduceOrNull");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        int i2 = 1;
        if (reduceOrNull.length() == 0) {
            return null;
        }
        char charAt = reduceOrNull.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(reduceOrNull);
        if (1 <= lastIndex) {
            while (true) {
                charAt = operation.invoke(Character.valueOf(charAt), Character.valueOf(reduceOrNull.charAt(i2))).charValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(charAt);
    }

    public static final char reduceRight(@d CharSequence reduceRight, @d Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkParameterIsNotNull(reduceRight, "$this$reduceRight");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        int lastIndex = StringsKt__StringsKt.getLastIndex(reduceRight);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char charAt = reduceRight.charAt(lastIndex);
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            charAt = operation.invoke(Character.valueOf(reduceRight.charAt(i2)), Character.valueOf(charAt)).charValue();
        }
        return charAt;
    }

    public static final char reduceRightIndexed(@d CharSequence reduceRightIndexed, @d Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        Intrinsics.checkParameterIsNotNull(reduceRightIndexed, "$this$reduceRightIndexed");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        int lastIndex = StringsKt__StringsKt.getLastIndex(reduceRightIndexed);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char charAt = reduceRightIndexed.charAt(lastIndex);
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            charAt = operation.invoke(Integer.valueOf(i2), Character.valueOf(reduceRightIndexed.charAt(i2)), Character.valueOf(charAt)).charValue();
        }
        return charAt;
    }

    @e
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final Character reduceRightOrNull(@d CharSequence reduceRightOrNull, @d Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkParameterIsNotNull(reduceRightOrNull, "$this$reduceRightOrNull");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        int lastIndex = StringsKt__StringsKt.getLastIndex(reduceRightOrNull);
        if (lastIndex < 0) {
            return null;
        }
        char charAt = reduceRightOrNull.charAt(lastIndex);
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            charAt = operation.invoke(Character.valueOf(reduceRightOrNull.charAt(i2)), Character.valueOf(charAt)).charValue();
        }
        return Character.valueOf(charAt);
    }

    @d
    public static final CharSequence reversed(@d CharSequence reversed) {
        Intrinsics.checkParameterIsNotNull(reversed, "$this$reversed");
        StringBuilder reverse = new StringBuilder(reversed).reverse();
        Intrinsics.checkExpressionValueIsNotNull(reverse, "StringBuilder(this).reverse()");
        return reverse;
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final <R> List<R> scan(@d CharSequence scan, R r, @d Function2<? super R, ? super Character, ? extends R> operation) {
        Intrinsics.checkParameterIsNotNull(scan, "$this$scan");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        if (scan.length() == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(scan.length() + 1);
        arrayList.add(r);
        for (int i2 = 0; i2 < scan.length(); i2++) {
            r = operation.invoke(r, Character.valueOf(scan.charAt(i2)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final <R> List<R> scanIndexed(@d CharSequence scanIndexed, R r, @d Function3<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        Intrinsics.checkParameterIsNotNull(scanIndexed, "$this$scanIndexed");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        if (scanIndexed.length() == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        ArrayList arrayList = new ArrayList(scanIndexed.length() + 1);
        arrayList.add(r);
        int length = scanIndexed.length();
        for (int i2 = 0; i2 < length; i2++) {
            r = operation.invoke(Integer.valueOf(i2), r, Character.valueOf(scanIndexed.charAt(i2)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final List<Character> scanReduce(@d CharSequence scanReduce, @d Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkParameterIsNotNull(scanReduce, "$this$scanReduce");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        if (scanReduce.length() == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        char charAt = scanReduce.charAt(0);
        ArrayList arrayList = new ArrayList(scanReduce.length());
        arrayList.add(Character.valueOf(charAt));
        int length = scanReduce.length();
        for (int i2 = 1; i2 < length; i2++) {
            charAt = operation.invoke(Character.valueOf(charAt), Character.valueOf(scanReduce.charAt(i2))).charValue();
            arrayList.add(Character.valueOf(charAt));
        }
        return arrayList;
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final List<Character> scanReduceIndexed(@d CharSequence scanReduceIndexed, @d Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        Intrinsics.checkParameterIsNotNull(scanReduceIndexed, "$this$scanReduceIndexed");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        if (scanReduceIndexed.length() == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        char charAt = scanReduceIndexed.charAt(0);
        ArrayList arrayList = new ArrayList(scanReduceIndexed.length());
        arrayList.add(Character.valueOf(charAt));
        int length = scanReduceIndexed.length();
        for (int i2 = 1; i2 < length; i2++) {
            charAt = operation.invoke(Integer.valueOf(i2), Character.valueOf(charAt), Character.valueOf(scanReduceIndexed.charAt(i2))).charValue();
            arrayList.add(Character.valueOf(charAt));
        }
        return arrayList;
    }

    public static final char single(@d CharSequence single) {
        Intrinsics.checkParameterIsNotNull(single, "$this$single");
        int length = single.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return single.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    @e
    public static final Character singleOrNull(@d CharSequence singleOrNull) {
        Intrinsics.checkParameterIsNotNull(singleOrNull, "$this$singleOrNull");
        if (singleOrNull.length() == 1) {
            return Character.valueOf(singleOrNull.charAt(0));
        }
        return null;
    }

    @d
    public static final CharSequence slice(@d CharSequence slice, @d IntRange indices) {
        Intrinsics.checkParameterIsNotNull(slice, "$this$slice");
        Intrinsics.checkParameterIsNotNull(indices, "indices");
        return indices.isEmpty() ? "" : StringsKt__StringsKt.subSequence(slice, indices);
    }

    public static final int sumBy(@d CharSequence sumBy, @d Function1<? super Character, Integer> selector) {
        Intrinsics.checkParameterIsNotNull(sumBy, "$this$sumBy");
        Intrinsics.checkParameterIsNotNull(selector, "selector");
        int i2 = 0;
        for (int i3 = 0; i3 < sumBy.length(); i3++) {
            i2 += selector.invoke(Character.valueOf(sumBy.charAt(i3))).intValue();
        }
        return i2;
    }

    public static final double sumByDouble(@d CharSequence sumByDouble, @d Function1<? super Character, Double> selector) {
        Intrinsics.checkParameterIsNotNull(sumByDouble, "$this$sumByDouble");
        Intrinsics.checkParameterIsNotNull(selector, "selector");
        double d2 = 0.0d;
        for (int i2 = 0; i2 < sumByDouble.length(); i2++) {
            d2 += selector.invoke(Character.valueOf(sumByDouble.charAt(i2))).doubleValue();
        }
        return d2;
    }

    @d
    public static final CharSequence take(@d CharSequence take, int i2) {
        int coerceAtMost;
        Intrinsics.checkParameterIsNotNull(take, "$this$take");
        if (i2 >= 0) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i2, take.length());
            return take.subSequence(0, coerceAtMost);
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    @d
    public static final CharSequence takeLast(@d CharSequence takeLast, int i2) {
        int coerceAtMost;
        Intrinsics.checkParameterIsNotNull(takeLast, "$this$takeLast");
        if (i2 >= 0) {
            int length = takeLast.length();
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i2, length);
            return takeLast.subSequence(length - coerceAtMost, length);
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    @d
    public static final CharSequence takeLastWhile(@d CharSequence takeLastWhile, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(takeLastWhile, "$this$takeLastWhile");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(takeLastWhile); lastIndex >= 0; lastIndex--) {
            if (!predicate.invoke(Character.valueOf(takeLastWhile.charAt(lastIndex))).booleanValue()) {
                return takeLastWhile.subSequence(lastIndex + 1, takeLastWhile.length());
            }
        }
        return takeLastWhile.subSequence(0, takeLastWhile.length());
    }

    @d
    public static final CharSequence takeWhile(@d CharSequence takeWhile, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(takeWhile, "$this$takeWhile");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = takeWhile.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!predicate.invoke(Character.valueOf(takeWhile.charAt(i2))).booleanValue()) {
                return takeWhile.subSequence(0, i2);
            }
        }
        return takeWhile.subSequence(0, takeWhile.length());
    }

    @d
    public static final <C extends Collection<? super Character>> C toCollection(@d CharSequence toCollection, @d C destination) {
        Intrinsics.checkParameterIsNotNull(toCollection, "$this$toCollection");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        for (int i2 = 0; i2 < toCollection.length(); i2++) {
            destination.add(Character.valueOf(toCollection.charAt(i2)));
        }
        return destination;
    }

    @d
    public static final HashSet<Character> toHashSet(@d CharSequence toHashSet) {
        int mapCapacity;
        Intrinsics.checkParameterIsNotNull(toHashSet, "$this$toHashSet");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(toHashSet.length());
        return (HashSet) toCollection(toHashSet, new HashSet(mapCapacity));
    }

    @d
    public static final List<Character> toList(@d CharSequence toList) {
        Intrinsics.checkParameterIsNotNull(toList, "$this$toList");
        int length = toList.length();
        return length != 0 ? length != 1 ? toMutableList(toList) : CollectionsKt__CollectionsJVMKt.listOf(Character.valueOf(toList.charAt(0))) : CollectionsKt__CollectionsKt.emptyList();
    }

    @d
    public static final List<Character> toMutableList(@d CharSequence toMutableList) {
        Intrinsics.checkParameterIsNotNull(toMutableList, "$this$toMutableList");
        return (List) toCollection(toMutableList, new ArrayList(toMutableList.length()));
    }

    @d
    public static final Set<Character> toSet(@d CharSequence toSet) {
        Set<Character> emptySet;
        Set<Character> of;
        int mapCapacity;
        Intrinsics.checkParameterIsNotNull(toSet, "$this$toSet");
        int length = toSet.length();
        if (length == 0) {
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }
        if (length != 1) {
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(toSet.length());
            return (Set) toCollection(toSet, new LinkedHashSet(mapCapacity));
        }
        of = SetsKt__SetsJVMKt.setOf(Character.valueOf(toSet.charAt(0)));
        return of;
    }

    @d
    @SinceKotlin(version = "1.2")
    public static final List<String> windowed(@d CharSequence windowed, int i2, int i3, boolean z) {
        Intrinsics.checkParameterIsNotNull(windowed, "$this$windowed");
        return windowed(windowed, i2, i3, z, new Function1<CharSequence, String>() { // from class: kotlin.text.StringsKt___StringsKt$windowed$1
            @Override // kotlin.jvm.functions.Function1
            @d
            public final String invoke(@d CharSequence it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return it.toString();
            }
        });
    }

    public static /* synthetic */ List windowed$default(CharSequence charSequence, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return windowed(charSequence, i2, i3, z);
    }

    @d
    @SinceKotlin(version = "1.2")
    public static final Sequence<String> windowedSequence(@d CharSequence windowedSequence, int i2, int i3, boolean z) {
        Intrinsics.checkParameterIsNotNull(windowedSequence, "$this$windowedSequence");
        return windowedSequence(windowedSequence, i2, i3, z, new Function1<CharSequence, String>() { // from class: kotlin.text.StringsKt___StringsKt$windowedSequence$1
            @Override // kotlin.jvm.functions.Function1
            @d
            public final String invoke(@d CharSequence it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return it.toString();
            }
        });
    }

    public static /* synthetic */ Sequence windowedSequence$default(CharSequence charSequence, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return windowedSequence(charSequence, i2, i3, z);
    }

    @d
    public static final Iterable<IndexedValue<Character>> withIndex(@d final CharSequence withIndex) {
        Intrinsics.checkParameterIsNotNull(withIndex, "$this$withIndex");
        return new IndexingIterable(new Function0<CharIterator>() { // from class: kotlin.text.StringsKt___StringsKt$withIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @d
            public final CharIterator invoke() {
                return StringsKt__StringsKt.iterator(withIndex);
            }
        });
    }

    @d
    public static final <V> List<V> zip(@d CharSequence zip, @d CharSequence other, @d Function2<? super Character, ? super Character, ? extends V> transform) {
        Intrinsics.checkParameterIsNotNull(zip, "$this$zip");
        Intrinsics.checkParameterIsNotNull(other, "other");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        int min = Math.min(zip.length(), other.length());
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(Character.valueOf(zip.charAt(i2)), Character.valueOf(other.charAt(i2))));
        }
        return arrayList;
    }

    @d
    @SinceKotlin(version = "1.2")
    public static final <R> List<R> zipWithNext(@d CharSequence zipWithNext, @d Function2<? super Character, ? super Character, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(zipWithNext, "$this$zipWithNext");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        int length = zipWithNext.length() - 1;
        if (length < 1) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(length);
        int i2 = 0;
        while (i2 < length) {
            Character valueOf = Character.valueOf(zipWithNext.charAt(i2));
            i2++;
            arrayList.add(transform.invoke(valueOf, Character.valueOf(zipWithNext.charAt(i2))));
        }
        return arrayList;
    }

    public static final boolean any(@d CharSequence any, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(any, "$this$any");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        for (int i2 = 0; i2 < any.length(); i2++) {
            if (predicate.invoke(Character.valueOf(any.charAt(i2))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @d
    @SinceKotlin(version = "1.2")
    public static final <R> List<R> chunked(@d CharSequence chunked, int i2, @d Function1<? super CharSequence, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(chunked, "$this$chunked");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        return windowed(chunked, i2, i2, true, transform);
    }

    @d
    @SinceKotlin(version = "1.2")
    public static final <R> Sequence<R> chunkedSequence(@d CharSequence chunkedSequence, int i2, @d Function1<? super CharSequence, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(chunkedSequence, "$this$chunkedSequence");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        return windowedSequence(chunkedSequence, i2, i2, true, transform);
    }

    public static final int count(@d CharSequence count, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(count, "$this$count");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int i2 = 0;
        for (int i3 = 0; i3 < count.length(); i3++) {
            if (predicate.invoke(Character.valueOf(count.charAt(i3))).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    @e
    public static final Character firstOrNull(@d CharSequence firstOrNull, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(firstOrNull, "$this$firstOrNull");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        for (int i2 = 0; i2 < firstOrNull.length(); i2++) {
            char charAt = firstOrNull.charAt(i2);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                return Character.valueOf(charAt);
            }
        }
        return null;
    }

    @e
    public static final Character lastOrNull(@d CharSequence lastOrNull, @d Function1<? super Character, Boolean> predicate) {
        char charAt;
        Intrinsics.checkParameterIsNotNull(lastOrNull, "$this$lastOrNull");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = lastOrNull.length();
        do {
            length--;
            if (length < 0) {
                return null;
            }
            charAt = lastOrNull.charAt(length);
        } while (!predicate.invoke(Character.valueOf(charAt)).booleanValue());
        return Character.valueOf(charAt);
    }

    public static final boolean none(@d CharSequence none, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(none, "$this$none");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        for (int i2 = 0; i2 < none.length(); i2++) {
            if (predicate.invoke(Character.valueOf(none.charAt(i2))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    public static final char random(@d CharSequence random, @d Random random2) {
        Intrinsics.checkParameterIsNotNull(random, "$this$random");
        Intrinsics.checkParameterIsNotNull(random2, "random");
        if (random.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return random.charAt(random2.nextInt(random.length()));
    }

    @e
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final Character randomOrNull(@d CharSequence randomOrNull, @d Random random) {
        Intrinsics.checkParameterIsNotNull(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (randomOrNull.length() == 0) {
            return null;
        }
        return Character.valueOf(randomOrNull.charAt(random.nextInt(randomOrNull.length())));
    }

    @InlineOnly
    private static final String reversed(@d String str) {
        if (str != null) {
            return reversed((CharSequence) str).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @e
    public static final Character singleOrNull(@d CharSequence singleOrNull, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(singleOrNull, "$this$singleOrNull");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        Character ch = null;
        boolean z = false;
        for (int i2 = 0; i2 < singleOrNull.length(); i2++) {
            char charAt = singleOrNull.charAt(i2);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                if (z) {
                    return null;
                }
                ch = Character.valueOf(charAt);
                z = true;
            }
        }
        if (z) {
            return ch;
        }
        return null;
    }

    @d
    @SinceKotlin(version = "1.2")
    public static final <R> List<R> windowed(@d CharSequence windowed, int i2, int i3, boolean z, @d Function1<? super CharSequence, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(windowed, "$this$windowed");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        SlidingWindowKt.checkWindowSizeStep(i2, i3);
        int length = windowed.length();
        int i4 = 0;
        ArrayList arrayList = new ArrayList((length / i3) + (length % i3 == 0 ? 0 : 1));
        while (i4 >= 0 && length > i4) {
            int i5 = i4 + i2;
            if (i5 < 0 || i5 > length) {
                if (!z) {
                    break;
                }
                i5 = length;
            }
            arrayList.add(transform.invoke(windowed.subSequence(i4, i5)));
            i4 += i3;
        }
        return arrayList;
    }

    public static /* synthetic */ List windowed$default(CharSequence charSequence, int i2, int i3, boolean z, Function1 function1, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return windowed(charSequence, i2, i3, z, function1);
    }

    @d
    @SinceKotlin(version = "1.2")
    public static final <R> Sequence<R> windowedSequence(@d final CharSequence windowedSequence, final int i2, int i3, boolean z, @d final Function1<? super CharSequence, ? extends R> transform) {
        IntProgression step;
        Intrinsics.checkParameterIsNotNull(windowedSequence, "$this$windowedSequence");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        SlidingWindowKt.checkWindowSizeStep(i2, i3);
        step = RangesKt___RangesKt.step(z ? StringsKt__StringsKt.getIndices(windowedSequence) : RangesKt___RangesKt.until(0, (windowedSequence.length() - i2) + 1), i3);
        return SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(step), new Function1<Integer, R>() { // from class: kotlin.text.StringsKt___StringsKt$windowedSequence$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final R invoke(int i4) {
                int i5 = i2 + i4;
                if (i5 < 0 || i5 > windowedSequence.length()) {
                    i5 = windowedSequence.length();
                }
                return (R) transform.invoke(windowedSequence.subSequence(i4, i5));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }
        });
    }

    public static /* synthetic */ Sequence windowedSequence$default(CharSequence charSequence, int i2, int i3, boolean z, Function1 function1, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return windowedSequence(charSequence, i2, i3, z, function1);
    }

    @d
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@d CharSequence associateByTo, @d M destination, @d Function1<? super Character, ? extends K> keySelector, @d Function1<? super Character, ? extends V> valueTransform) {
        Intrinsics.checkParameterIsNotNull(associateByTo, "$this$associateByTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        Intrinsics.checkParameterIsNotNull(valueTransform, "valueTransform");
        for (int i2 = 0; i2 < associateByTo.length(); i2++) {
            char charAt = associateByTo.charAt(i2);
            destination.put(keySelector.invoke(Character.valueOf(charAt)), valueTransform.invoke(Character.valueOf(charAt)));
        }
        return destination;
    }

    @d
    public static final String drop(@d String drop, int i2) {
        int coerceAtMost;
        Intrinsics.checkParameterIsNotNull(drop, "$this$drop");
        if (i2 >= 0) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i2, drop.length());
            String substring = drop.substring(coerceAtMost);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    @d
    public static final String dropLast(@d String dropLast, int i2) {
        int coerceAtLeast;
        Intrinsics.checkParameterIsNotNull(dropLast, "$this$dropLast");
        if (i2 >= 0) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(dropLast.length() - i2, 0);
            return take(dropLast, coerceAtLeast);
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    @d
    public static final String filterNot(@d String filterNot, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(filterNot, "$this$filterNot");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < filterNot.length(); i2++) {
            char charAt = filterNot.charAt(i2);
            if (!predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "filterNotTo(StringBuilder(), predicate).toString()");
        return sb2;
    }

    @d
    public static final String slice(@d String slice, @d IntRange indices) {
        Intrinsics.checkParameterIsNotNull(slice, "$this$slice");
        Intrinsics.checkParameterIsNotNull(indices, "indices");
        return indices.isEmpty() ? "" : StringsKt__StringsKt.substring(slice, indices);
    }

    @d
    public static final String take(@d String take, int i2) {
        int coerceAtMost;
        Intrinsics.checkParameterIsNotNull(take, "$this$take");
        if (i2 >= 0) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i2, take.length());
            String substring = take.substring(0, coerceAtMost);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    @d
    public static final String dropLastWhile(@d String dropLastWhile, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(dropLastWhile, "$this$dropLastWhile");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(dropLastWhile); lastIndex >= 0; lastIndex--) {
            if (!predicate.invoke(Character.valueOf(dropLastWhile.charAt(lastIndex))).booleanValue()) {
                String substring = dropLastWhile.substring(0, lastIndex + 1);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return "";
    }

    @d
    public static final String dropWhile(@d String dropWhile, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(dropWhile, "$this$dropWhile");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = dropWhile.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!predicate.invoke(Character.valueOf(dropWhile.charAt(i2))).booleanValue()) {
                String substring = dropWhile.substring(i2);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
        }
        return "";
    }

    @d
    public static final String filterIndexed(@d String filterIndexed, @d Function2<? super Integer, ? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(filterIndexed, "$this$filterIndexed");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        while (i2 < filterIndexed.length()) {
            char charAt = filterIndexed.charAt(i2);
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
            i2++;
            i3 = i4;
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "filterIndexedTo(StringBu…(), predicate).toString()");
        return sb2;
    }

    public static final char first(@d CharSequence first, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(first, "$this$first");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        for (int i2 = 0; i2 < first.length(); i2++) {
            char charAt = first.charAt(i2);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                return charAt;
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    public static final char last(@d CharSequence last, @d Function1<? super Character, Boolean> predicate) {
        char charAt;
        Intrinsics.checkParameterIsNotNull(last, "$this$last");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = last.length();
        do {
            length--;
            if (length >= 0) {
                charAt = last.charAt(length);
            } else {
                throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
            }
        } while (!predicate.invoke(Character.valueOf(charAt)).booleanValue());
        return charAt;
    }

    @d
    public static final String takeLast(@d String takeLast, int i2) {
        int coerceAtMost;
        Intrinsics.checkParameterIsNotNull(takeLast, "$this$takeLast");
        if (i2 >= 0) {
            int length = takeLast.length();
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i2, length);
            String substring = takeLast.substring(length - coerceAtMost);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    @d
    public static final List<Pair<Character, Character>> zip(@d CharSequence zip, @d CharSequence other) {
        Intrinsics.checkParameterIsNotNull(zip, "$this$zip");
        Intrinsics.checkParameterIsNotNull(other, "other");
        int min = Math.min(zip.length(), other.length());
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(Character.valueOf(zip.charAt(i2)), Character.valueOf(other.charAt(i2))));
        }
        return arrayList;
    }

    @d
    public static final <K, V> Map<K, V> associateBy(@d CharSequence associateBy, @d Function1<? super Character, ? extends K> keySelector, @d Function1<? super Character, ? extends V> valueTransform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkParameterIsNotNull(associateBy, "$this$associateBy");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        Intrinsics.checkParameterIsNotNull(valueTransform, "valueTransform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(associateBy.length());
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (int i2 = 0; i2 < associateBy.length(); i2++) {
            char charAt = associateBy.charAt(i2);
            linkedHashMap.put(keySelector.invoke(Character.valueOf(charAt)), valueTransform.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    @d
    public static final String filter(@d String filter, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(filter, "$this$filter");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int length = filter.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = filter.charAt(i2);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "filterTo(StringBuilder(), predicate).toString()");
        return sb2;
    }

    public static final char single(@d CharSequence single, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(single, "$this$single");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        Character ch = null;
        boolean z = false;
        for (int i2 = 0; i2 < single.length(); i2++) {
            char charAt = single.charAt(i2);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                if (!z) {
                    ch = Character.valueOf(charAt);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Char sequence contains more than one matching element.");
                }
            }
        }
        if (!z) {
            throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
        }
        if (ch != null) {
            return ch.charValue();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Char");
    }

    @d
    public static final CharSequence slice(@d CharSequence slice, @d Iterable<Integer> indices) {
        Intrinsics.checkParameterIsNotNull(slice, "$this$slice");
        Intrinsics.checkParameterIsNotNull(indices, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(collectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            sb.append(slice.charAt(it.next().intValue()));
        }
        return sb;
    }

    @d
    public static final String takeLastWhile(@d String takeLastWhile, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(takeLastWhile, "$this$takeLastWhile");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(takeLastWhile); lastIndex >= 0; lastIndex--) {
            if (!predicate.invoke(Character.valueOf(takeLastWhile.charAt(lastIndex))).booleanValue()) {
                String substring = takeLastWhile.substring(lastIndex + 1);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
        }
        return takeLastWhile;
    }

    @d
    public static final String takeWhile(@d String takeWhile, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(takeWhile, "$this$takeWhile");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = takeWhile.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!predicate.invoke(Character.valueOf(takeWhile.charAt(i2))).booleanValue()) {
                String substring = takeWhile.substring(0, i2);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return takeWhile;
    }

    @d
    @SinceKotlin(version = "1.2")
    public static final List<Pair<Character, Character>> zipWithNext(@d CharSequence zipWithNext) {
        Intrinsics.checkParameterIsNotNull(zipWithNext, "$this$zipWithNext");
        int length = zipWithNext.length() - 1;
        if (length < 1) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(length);
        int i2 = 0;
        while (i2 < length) {
            char charAt = zipWithNext.charAt(i2);
            i2++;
            arrayList.add(TuplesKt.to(Character.valueOf(charAt), Character.valueOf(zipWithNext.charAt(i2))));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @d
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@d CharSequence groupByTo, @d M destination, @d Function1<? super Character, ? extends K> keySelector, @d Function1<? super Character, ? extends V> valueTransform) {
        Intrinsics.checkParameterIsNotNull(groupByTo, "$this$groupByTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        Intrinsics.checkParameterIsNotNull(valueTransform, "valueTransform");
        for (int i2 = 0; i2 < groupByTo.length(); i2++) {
            char charAt = groupByTo.charAt(i2);
            K invoke = keySelector.invoke(Character.valueOf(charAt));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Character.valueOf(charAt)));
        }
        return destination;
    }

    @d
    public static final Pair<String, String> partition(@d String partition, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(partition, "$this$partition");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int length = partition.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = partition.charAt(i2);
            if (predicate.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            } else {
                sb2.append(charAt);
            }
        }
        return new Pair<>(sb.toString(), sb2.toString());
    }

    @d
    public static final <K, V> Map<K, List<V>> groupBy(@d CharSequence groupBy, @d Function1<? super Character, ? extends K> keySelector, @d Function1<? super Character, ? extends V> valueTransform) {
        Intrinsics.checkParameterIsNotNull(groupBy, "$this$groupBy");
        Intrinsics.checkParameterIsNotNull(keySelector, "keySelector");
        Intrinsics.checkParameterIsNotNull(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 = 0; i2 < groupBy.length(); i2++) {
            char charAt = groupBy.charAt(i2);
            K invoke = keySelector.invoke(Character.valueOf(charAt));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    @InlineOnly
    private static final String slice(@d String str, Iterable<Integer> iterable) {
        if (str != null) {
            return slice((CharSequence) str, iterable).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
}
