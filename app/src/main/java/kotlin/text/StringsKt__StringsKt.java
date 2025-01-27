package kotlin.text;

import com.kwad.sdk.api.model.AdnName;
import f.b.a.d;
import f.b.a.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0012\u001a(\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a(\u0010\u0005\u001a\u00020\u0007*\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\b\u0005\u0010\b\u001a(\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\b\t\u0010\u0006\u001a(\u0010\t\u001a\u00020\u0007*\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\b\t\u0010\b\u001a(\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\b\n\u0010\u0006\u001a(\u0010\n\u001a\u00020\u0007*\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\b\n\u0010\b\u001a\u001d\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\n\u0010\f\u001a\u00020\u000b\"\u00020\u0002¢\u0006\u0004\b\u0005\u0010\r\u001a\u001d\u0010\u0005\u001a\u00020\u0007*\u00020\u00072\n\u0010\f\u001a\u00020\u000b\"\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u000e\u001a\u001d\u0010\t\u001a\u00020\u0000*\u00020\u00002\n\u0010\f\u001a\u00020\u000b\"\u00020\u0002¢\u0006\u0004\b\t\u0010\r\u001a\u001d\u0010\t\u001a\u00020\u0007*\u00020\u00072\n\u0010\f\u001a\u00020\u000b\"\u00020\u0002¢\u0006\u0004\b\t\u0010\u000e\u001a\u001d\u0010\n\u001a\u00020\u0000*\u00020\u00002\n\u0010\f\u001a\u00020\u000b\"\u00020\u0002¢\u0006\u0004\b\n\u0010\r\u001a\u001d\u0010\n\u001a\u00020\u0007*\u00020\u00072\n\u0010\f\u001a\u00020\u000b\"\u00020\u0002¢\u0006\u0004\b\n\u0010\u000e\u001a\u0011\u0010\u0005\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u000f\u001a\u0014\u0010\u0005\u001a\u00020\u0007*\u00020\u0007H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0010\u001a\u0011\u0010\t\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\t\u0010\u000f\u001a\u0014\u0010\t\u001a\u00020\u0007*\u00020\u0007H\u0087\b¢\u0006\u0004\b\t\u0010\u0010\u001a\u0011\u0010\n\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\n\u0010\u000f\u001a\u0014\u0010\n\u001a\u00020\u0007*\u00020\u0007H\u0087\b¢\u0006\u0004\b\n\u0010\u0010\u001a#\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a#\u0010\u0014\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0016\u001a#\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0015\u001a#\u0010\u0017\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0016\u001a'\u0010\u0018\u001a\u00020\u0003*\u0004\u0018\u00010\u0000H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0014\u0010\u001a\u001a\u00020\u0003*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u001a\u0010\u0019\u001a\u0014\u0010\u001b\u001a\u00020\u0003*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u001b\u0010\u0019\u001a\u0014\u0010\u001c\u001a\u00020\u0003*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u001c\u0010\u0019\u001a'\u0010\u001d\u001a\u00020\u0003*\u0004\u0018\u00010\u0000H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\b\u001d\u0010\u0019\u001a\u0014\u0010\u001f\u001a\u00020\u001e*\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001f\u0010 \u001a\u0016\u0010!\u001a\u00020\u0007*\u0004\u0018\u00010\u0007H\u0087\b¢\u0006\u0004\b!\u0010\u0010\u001a6\u0010&\u001a\u00028\u0001\"\f\b\u0000\u0010\"*\u00020\u0000*\u00028\u0001\"\u0004\b\u0001\u0010#*\u00028\u00002\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010$H\u0087\b¢\u0006\u0004\b&\u0010'\u001a6\u0010(\u001a\u00028\u0001\"\f\b\u0000\u0010\"*\u00020\u0000*\u00028\u0001\"\u0004\b\u0001\u0010#*\u00028\u00002\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010$H\u0087\b¢\u0006\u0004\b(\u0010'\u001a\u0019\u0010*\u001a\u00020\u0003*\u00020\u00002\u0006\u0010)\u001a\u00020\u0011¢\u0006\u0004\b*\u0010+\u001a\u0019\u0010.\u001a\u00020\u0007*\u00020\u00072\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/\u001a\u0019\u00100\u001a\u00020\u0000*\u00020\u00002\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b0\u00101\u001a$\u00100\u001a\u00020\u0000*\u00020\u00072\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b0\u00104\u001a&\u0010.\u001a\u00020\u0007*\u00020\u00002\u0006\u00105\u001a\u00020\u00112\b\b\u0002\u00106\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b.\u00107\u001a\u0019\u0010.\u001a\u00020\u0007*\u00020\u00002\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u00108\u001a#\u0010;\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u00022\b\b\u0002\u0010:\u001a\u00020\u0007¢\u0006\u0004\b;\u0010<\u001a#\u0010;\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u00072\b\b\u0002\u0010:\u001a\u00020\u0007¢\u0006\u0004\b;\u0010=\u001a#\u0010>\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u00022\b\b\u0002\u0010:\u001a\u00020\u0007¢\u0006\u0004\b>\u0010<\u001a#\u0010>\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u00072\b\b\u0002\u0010:\u001a\u00020\u0007¢\u0006\u0004\b>\u0010=\u001a#\u0010?\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u00022\b\b\u0002\u0010:\u001a\u00020\u0007¢\u0006\u0004\b?\u0010<\u001a#\u0010?\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u00072\b\b\u0002\u0010:\u001a\u00020\u0007¢\u0006\u0004\b?\u0010=\u001a#\u0010@\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u00022\b\b\u0002\u0010:\u001a\u00020\u0007¢\u0006\u0004\b@\u0010<\u001a#\u0010@\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u00072\b\b\u0002\u0010:\u001a\u00020\u0007¢\u0006\u0004\b@\u0010=\u001a)\u0010B\u001a\u00020\u0000*\u00020\u00002\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u0000¢\u0006\u0004\bB\u0010C\u001a,\u0010B\u001a\u00020\u0007*\u00020\u00072\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bB\u0010D\u001a!\u0010B\u001a\u00020\u0000*\u00020\u00002\u0006\u0010-\u001a\u00020,2\u0006\u0010A\u001a\u00020\u0000¢\u0006\u0004\bB\u0010E\u001a$\u0010B\u001a\u00020\u0007*\u00020\u00072\u0006\u0010-\u001a\u00020,2\u0006\u0010A\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bB\u0010F\u001a!\u0010G\u001a\u00020\u0000*\u00020\u00002\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0011¢\u0006\u0004\bG\u0010H\u001a$\u0010G\u001a\u00020\u0007*\u00020\u00072\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\bG\u0010I\u001a\u0019\u0010G\u001a\u00020\u0000*\u00020\u00002\u0006\u0010-\u001a\u00020,¢\u0006\u0004\bG\u00101\u001a\u001c\u0010G\u001a\u00020\u0007*\u00020\u00072\u0006\u0010-\u001a\u00020,H\u0087\b¢\u0006\u0004\bG\u0010/\u001a\u0019\u0010K\u001a\u00020\u0000*\u00020\u00002\u0006\u0010J\u001a\u00020\u0000¢\u0006\u0004\bK\u0010L\u001a\u0019\u0010K\u001a\u00020\u0007*\u00020\u00072\u0006\u0010J\u001a\u00020\u0000¢\u0006\u0004\bK\u0010M\u001a\u0019\u0010O\u001a\u00020\u0000*\u00020\u00002\u0006\u0010N\u001a\u00020\u0000¢\u0006\u0004\bO\u0010L\u001a\u0019\u0010O\u001a\u00020\u0007*\u00020\u00072\u0006\u0010N\u001a\u00020\u0000¢\u0006\u0004\bO\u0010M\u001a!\u0010P\u001a\u00020\u0000*\u00020\u00002\u0006\u0010J\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0000¢\u0006\u0004\bP\u0010Q\u001a!\u0010P\u001a\u00020\u0007*\u00020\u00072\u0006\u0010J\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0000¢\u0006\u0004\bP\u0010R\u001a\u0019\u0010P\u001a\u00020\u0000*\u00020\u00002\u0006\u00109\u001a\u00020\u0000¢\u0006\u0004\bP\u0010L\u001a\u0019\u0010P\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u0000¢\u0006\u0004\bP\u0010M\u001a+\u0010S\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u00072\b\b\u0002\u0010:\u001a\u00020\u0007¢\u0006\u0004\bS\u0010T\u001a+\u0010S\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\b\b\u0002\u0010:\u001a\u00020\u0007¢\u0006\u0004\bS\u0010U\u001a+\u0010V\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u00072\b\b\u0002\u0010:\u001a\u00020\u0007¢\u0006\u0004\bV\u0010T\u001a+\u0010V\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\b\b\u0002\u0010:\u001a\u00020\u0007¢\u0006\u0004\bV\u0010U\u001a+\u0010W\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\b\b\u0002\u0010:\u001a\u00020\u0007¢\u0006\u0004\bW\u0010U\u001a+\u0010W\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u00072\b\b\u0002\u0010:\u001a\u00020\u0007¢\u0006\u0004\bW\u0010T\u001a+\u0010X\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u00072\b\b\u0002\u0010:\u001a\u00020\u0007¢\u0006\u0004\bX\u0010T\u001a+\u0010X\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\b\b\u0002\u0010:\u001a\u00020\u0007¢\u0006\u0004\bX\u0010U\u001a$\u0010[\u001a\u00020\u0007*\u00020\u00002\u0006\u0010Z\u001a\u00020Y2\u0006\u0010A\u001a\u00020\u0007H\u0087\b¢\u0006\u0004\b[\u0010\\\u001a2\u0010[\u001a\u00020\u0007*\u00020\u00002\u0006\u0010Z\u001a\u00020Y2\u0014\b\b\u0010^\u001a\u000e\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020\u00000\u0001H\u0087\b¢\u0006\u0004\b[\u0010_\u001a$\u0010`\u001a\u00020\u0007*\u00020\u00002\u0006\u0010Z\u001a\u00020Y2\u0006\u0010A\u001a\u00020\u0007H\u0087\b¢\u0006\u0004\b`\u0010\\\u001a\u001c\u0010a\u001a\u00020\u0003*\u00020\u00002\u0006\u0010Z\u001a\u00020YH\u0087\f¢\u0006\u0004\ba\u0010b\u001a;\u0010g\u001a\u00020\u0003*\u00020\u00002\u0006\u0010c\u001a\u00020\u00112\u0006\u0010d\u001a\u00020\u00002\u0006\u0010e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010f\u001a\u00020\u0003H\u0000¢\u0006\u0004\bg\u0010h\u001a#\u0010j\u001a\u00020\u0003*\u00020\u00002\u0006\u0010i\u001a\u00020\u00022\b\b\u0002\u0010f\u001a\u00020\u0003¢\u0006\u0004\bj\u0010k\u001a#\u0010l\u001a\u00020\u0003*\u00020\u00002\u0006\u0010i\u001a\u00020\u00022\b\b\u0002\u0010f\u001a\u00020\u0003¢\u0006\u0004\bl\u0010k\u001a#\u0010j\u001a\u00020\u0003*\u00020\u00002\u0006\u0010J\u001a\u00020\u00002\b\b\u0002\u0010f\u001a\u00020\u0003¢\u0006\u0004\bj\u0010m\u001a+\u0010j\u001a\u00020\u0003*\u00020\u00002\u0006\u0010J\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u00112\b\b\u0002\u0010f\u001a\u00020\u0003¢\u0006\u0004\bj\u0010n\u001a#\u0010l\u001a\u00020\u0003*\u00020\u00002\u0006\u0010N\u001a\u00020\u00002\b\b\u0002\u0010f\u001a\u00020\u0003¢\u0006\u0004\bl\u0010m\u001a#\u0010o\u001a\u00020\u0007*\u00020\u00002\u0006\u0010d\u001a\u00020\u00002\b\b\u0002\u0010f\u001a\u00020\u0003¢\u0006\u0004\bo\u0010p\u001a#\u0010q\u001a\u00020\u0007*\u00020\u00002\u0006\u0010d\u001a\u00020\u00002\b\b\u0002\u0010f\u001a\u00020\u0003¢\u0006\u0004\bq\u0010p\u001a-\u0010r\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u00105\u001a\u00020\u00112\b\b\u0002\u0010f\u001a\u00020\u0003¢\u0006\u0004\br\u0010s\u001a-\u0010t\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u00105\u001a\u00020\u00112\b\b\u0002\u0010f\u001a\u00020\u0003¢\u0006\u0004\bt\u0010s\u001a=\u0010x\u001a\u00020\u0011*\u00020\u00002\u0006\u0010d\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00112\u0006\u0010f\u001a\u00020\u00032\b\b\u0002\u0010u\u001a\u00020\u0003H\u0002¢\u0006\u0004\bv\u0010w\u001aG\u0010~\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0007\u0018\u00010{*\u00020\u00002\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00070y2\u0006\u00105\u001a\u00020\u00112\u0006\u0010f\u001a\u00020\u00032\u0006\u0010u\u001a\u00020\u0003H\u0002¢\u0006\u0004\b|\u0010}\u001aA\u0010~\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0007\u0018\u00010{*\u00020\u00002\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00070y2\b\b\u0002\u00105\u001a\u00020\u00112\b\b\u0002\u0010f\u001a\u00020\u0003¢\u0006\u0004\b~\u0010\u007f\u001aC\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0007\u0018\u00010{*\u00020\u00002\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00070y2\b\b\u0002\u00105\u001a\u00020\u00112\b\b\u0002\u0010f\u001a\u00020\u0003¢\u0006\u0005\b\u0080\u0001\u0010\u007f\u001a4\u0010r\u001a\u00020\u0011*\u00020\u00002\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00070y2\b\b\u0002\u00105\u001a\u00020\u00112\b\b\u0002\u0010f\u001a\u00020\u0003¢\u0006\u0005\br\u0010\u0081\u0001\u001a4\u0010t\u001a\u00020\u0011*\u00020\u00002\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00070y2\b\b\u0002\u00105\u001a\u00020\u00112\b\b\u0002\u0010f\u001a\u00020\u0003¢\u0006\u0005\bt\u0010\u0081\u0001\u001a.\u0010x\u001a\u00020\u0011*\u00020\u00002\u0006\u0010i\u001a\u00020\u00022\b\b\u0002\u00105\u001a\u00020\u00112\b\b\u0002\u0010f\u001a\u00020\u0003¢\u0006\u0005\bx\u0010\u0082\u0001\u001a/\u0010x\u001a\u00020\u0011*\u00020\u00002\u0007\u0010\u0083\u0001\u001a\u00020\u00072\b\b\u0002\u00105\u001a\u00020\u00112\b\b\u0002\u0010f\u001a\u00020\u0003¢\u0006\u0005\bx\u0010\u0084\u0001\u001a0\u0010\u0085\u0001\u001a\u00020\u0011*\u00020\u00002\u0006\u0010i\u001a\u00020\u00022\b\b\u0002\u00105\u001a\u00020\u00112\b\b\u0002\u0010f\u001a\u00020\u0003¢\u0006\u0006\b\u0085\u0001\u0010\u0082\u0001\u001a1\u0010\u0085\u0001\u001a\u00020\u0011*\u00020\u00002\u0007\u0010\u0083\u0001\u001a\u00020\u00072\b\b\u0002\u00105\u001a\u00020\u00112\b\b\u0002\u0010f\u001a\u00020\u0003¢\u0006\u0006\b\u0085\u0001\u0010\u0084\u0001\u001a(\u0010\u0086\u0001\u001a\u00020\u0003*\u00020\u00002\u0006\u0010d\u001a\u00020\u00002\b\b\u0002\u0010f\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0005\b\u0086\u0001\u0010m\u001a(\u0010\u0086\u0001\u001a\u00020\u0003*\u00020\u00002\u0006\u0010i\u001a\u00020\u00022\b\b\u0002\u0010f\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0005\b\u0086\u0001\u0010k\u001a\u001e\u0010\u0086\u0001\u001a\u00020\u0003*\u00020\u00002\u0006\u0010Z\u001a\u00020YH\u0087\n¢\u0006\u0005\b\u0086\u0001\u0010b\u001aE\u0010\u008c\u0001\u001a\t\u0012\u0004\u0012\u00020,0\u0089\u0001*\u00020\u00002\u0007\u0010\u0087\u0001\u001a\u00020\u000b2\b\b\u0002\u00105\u001a\u00020\u00112\b\b\u0002\u0010f\u001a\u00020\u00032\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001\u001aN\u0010\u008c\u0001\u001a\t\u0012\u0004\u0012\u00020,0\u0089\u0001*\u00020\u00002\u0010\u0010\u0087\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00070\u008d\u00012\b\b\u0002\u00105\u001a\u00020\u00112\b\b\u0002\u0010f\u001a\u00020\u00032\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0006\b\u008a\u0001\u0010\u008e\u0001\u001aF\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0089\u0001*\u00020\u00002\u0014\u0010\u0087\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00070\u008d\u0001\"\u00020\u00072\b\b\u0002\u0010f\u001a\u00020\u00032\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u0011¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001\u001aF\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0091\u0001*\u00020\u00002\u0014\u0010\u0087\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00070\u008d\u0001\"\u00020\u00072\b\b\u0002\u0010f\u001a\u00020\u00032\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u0011¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a=\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0089\u0001*\u00020\u00002\u000b\u0010\u0087\u0001\u001a\u00020\u000b\"\u00020\u00022\b\b\u0002\u0010f\u001a\u00020\u00032\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u0011¢\u0006\u0006\b\u008f\u0001\u0010\u0094\u0001\u001a=\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0091\u0001*\u00020\u00002\u000b\u0010\u0087\u0001\u001a\u00020\u000b\"\u00020\u00022\b\b\u0002\u0010f\u001a\u00020\u00032\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u0011¢\u0006\u0006\b\u0092\u0001\u0010\u0095\u0001\u001a6\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0091\u0001*\u00020\u00002\u0006\u00109\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00032\u0007\u0010\u0088\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a1\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0091\u0001*\u00020\u00002\u0006\u0010Z\u001a\u00020Y2\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u0011H\u0087\b¢\u0006\u0006\b\u0092\u0001\u0010\u0098\u0001\u001a\u001b\u0010\u0099\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0089\u0001*\u00020\u0000¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u001b\u0010\u009b\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0091\u0001*\u00020\u0000¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u001a\u0010\u009f\u0001\u001a\u00020\u0011*\u00020\u00008F@\u0006¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u001a\u0010¢\u0001\u001a\u00020,*\u00020\u00008F@\u0006¢\u0006\b\u001a\u0006\b \u0001\u0010¡\u0001¨\u0006£\u0001"}, d2 = {"", "Lkotlin/Function1;", "", "", "predicate", "trim", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/CharSequence;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "trimStart", "trimEnd", "", "chars", "(Ljava/lang/CharSequence;[C)Ljava/lang/CharSequence;", "(Ljava/lang/String;[C)Ljava/lang/String;", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "(Ljava/lang/String;)Ljava/lang/String;", "", "length", "padChar", "padStart", "(Ljava/lang/CharSequence;IC)Ljava/lang/CharSequence;", "(Ljava/lang/String;IC)Ljava/lang/String;", "padEnd", "isNullOrEmpty", "(Ljava/lang/CharSequence;)Z", "isEmpty", "isNotEmpty", "isNotBlank", "isNullOrBlank", "Lkotlin/collections/CharIterator;", "iterator", "(Ljava/lang/CharSequence;)Lkotlin/collections/CharIterator;", "orEmpty", "C", "R", "Lkotlin/Function0;", "defaultValue", "ifEmpty", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifBlank", "index", "hasSurrogatePairAt", "(Ljava/lang/CharSequence;I)Z", "Lkotlin/ranges/IntRange;", "range", "substring", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)Ljava/lang/String;", "subSequence", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)Ljava/lang/CharSequence;", "start", "end", "(Ljava/lang/String;II)Ljava/lang/CharSequence;", "startIndex", "endIndex", "(Ljava/lang/CharSequence;II)Ljava/lang/String;", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)Ljava/lang/String;", "delimiter", "missingDelimiterValue", "substringBefore", "(Ljava/lang/String;CLjava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "substringAfter", "substringBeforeLast", "substringAfterLast", "replacement", "replaceRange", "(Ljava/lang/CharSequence;IILjava/lang/CharSequence;)Ljava/lang/CharSequence;", "(Ljava/lang/String;IILjava/lang/CharSequence;)Ljava/lang/String;", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;Ljava/lang/CharSequence;)Ljava/lang/String;", "removeRange", "(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;", "(Ljava/lang/String;II)Ljava/lang/String;", "prefix", "removePrefix", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "(Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;", "suffix", "removeSuffix", "removeSurrounding", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "replaceBefore", "(Ljava/lang/String;CLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replaceAfter", "replaceAfterLast", "replaceBeforeLast", "Lkotlin/text/Regex;", "regex", "replace", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/text/MatchResult;", "transform", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "replaceFirst", "matches", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;)Z", "thisOffset", AdnName.OTHER, "otherOffset", "ignoreCase", "regionMatchesImpl", "(Ljava/lang/CharSequence;ILjava/lang/CharSequence;IIZ)Z", "char", "startsWith", "(Ljava/lang/CharSequence;CZ)Z", "endsWith", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Z", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IZ)Z", "commonPrefixWith", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Ljava/lang/String;", "commonSuffixWith", "indexOfAny", "(Ljava/lang/CharSequence;[CIZ)I", "lastIndexOfAny", "last", "indexOf$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZZ)I", "indexOf", "", "strings", "Lkotlin/Pair;", "findAnyOf$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZZ)Lkotlin/Pair;", "findAnyOf", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZ)Lkotlin/Pair;", "findLastAnyOf", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZ)I", "(Ljava/lang/CharSequence;CIZ)I", "string", "(Ljava/lang/CharSequence;Ljava/lang/String;IZ)I", "lastIndexOf", "contains", "delimiters", "limit", "Lkotlin/sequences/Sequence;", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[CIZI)Lkotlin/sequences/Sequence;", "rangesDelimitedBy", "", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "(Ljava/lang/CharSequence;[CZI)Lkotlin/sequences/Sequence;", "(Ljava/lang/CharSequence;[CZI)Ljava/util/List;", "split$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/lang/String;ZI)Ljava/util/List;", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;I)Ljava/util/List;", "lineSequence", "(Ljava/lang/CharSequence;)Lkotlin/sequences/Sequence;", "lines", "(Ljava/lang/CharSequence;)Ljava/util/List;", "getLastIndex", "(Ljava/lang/CharSequence;)I", "lastIndex", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "indices", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    @d
    public static final String commonPrefixWith(@d CharSequence commonPrefixWith, @d CharSequence other, boolean z) {
        Intrinsics.checkParameterIsNotNull(commonPrefixWith, "$this$commonPrefixWith");
        Intrinsics.checkParameterIsNotNull(other, "other");
        int min = Math.min(commonPrefixWith.length(), other.length());
        int i2 = 0;
        while (i2 < min && CharsKt__CharKt.equals(commonPrefixWith.charAt(i2), other.charAt(i2), z)) {
            i2++;
        }
        int i3 = i2 - 1;
        if (hasSurrogatePairAt(commonPrefixWith, i3) || hasSurrogatePairAt(other, i3)) {
            i2--;
        }
        return commonPrefixWith.subSequence(0, i2).toString();
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return commonPrefixWith(charSequence, charSequence2, z);
    }

    @d
    public static final String commonSuffixWith(@d CharSequence commonSuffixWith, @d CharSequence other, boolean z) {
        Intrinsics.checkParameterIsNotNull(commonSuffixWith, "$this$commonSuffixWith");
        Intrinsics.checkParameterIsNotNull(other, "other");
        int length = commonSuffixWith.length();
        int min = Math.min(length, other.length());
        int i2 = 0;
        while (i2 < min && CharsKt__CharKt.equals(commonSuffixWith.charAt((length - i2) - 1), other.charAt((r1 - i2) - 1), z)) {
            i2++;
        }
        if (hasSurrogatePairAt(commonSuffixWith, (length - i2) - 1) || hasSurrogatePairAt(other, (r1 - i2) - 1)) {
            i2--;
        }
        return commonSuffixWith.subSequence(length - i2, length).toString();
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return commonSuffixWith(charSequence, charSequence2, z);
    }

    public static final boolean contains(@d CharSequence contains, @d CharSequence other, boolean z) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Intrinsics.checkParameterIsNotNull(other, "other");
        if (other instanceof String) {
            if (indexOf$default(contains, (String) other, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else if (indexOf$StringsKt__StringsKt$default(contains, other, 0, contains.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return contains(charSequence, charSequence2, z);
    }

    public static final boolean endsWith(@d CharSequence endsWith, char c2, boolean z) {
        Intrinsics.checkParameterIsNotNull(endsWith, "$this$endsWith");
        return endsWith.length() > 0 && CharsKt__CharKt.equals(endsWith.charAt(getLastIndex(endsWith)), c2, z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, c2, z);
    }

    @e
    public static final Pair<Integer, String> findAnyOf(@d CharSequence findAnyOf, @d Collection<String> strings, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(findAnyOf, "$this$findAnyOf");
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        return findAnyOf$StringsKt__StringsKt(findAnyOf, strings, i2, z, false);
    }

    public static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(@d CharSequence charSequence, Collection<String> collection, int i2, boolean z, boolean z2) {
        int coerceAtMost;
        IntProgression downTo;
        Object obj;
        Object obj2;
        int coerceAtLeast;
        if (!z && collection.size() == 1) {
            String str = (String) CollectionsKt.single(collection);
            int indexOf$default = !z2 ? indexOf$default(charSequence, str, i2, false, 4, (Object) null) : lastIndexOf$default(charSequence, str, i2, false, 4, (Object) null);
            if (indexOf$default < 0) {
                return null;
            }
            return TuplesKt.to(Integer.valueOf(indexOf$default), str);
        }
        if (z2) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i2, getLastIndex(charSequence));
            downTo = RangesKt___RangesKt.downTo(coerceAtMost, 0);
        } else {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i2, 0);
            downTo = new IntRange(coerceAtLeast, charSequence.length());
        }
        if (charSequence instanceof String) {
            int first = downTo.getFirst();
            int last = downTo.getLast();
            int step = downTo.getStep();
            if (step < 0 ? first >= last : first <= last) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        if (StringsKt__StringsJVMKt.regionMatches(str2, 0, (String) charSequence, first, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (first == last) {
                            break;
                        }
                        first += step;
                    } else {
                        return TuplesKt.to(Integer.valueOf(first), str3);
                    }
                }
            }
        } else {
            int first2 = downTo.getFirst();
            int last2 = downTo.getLast();
            int step2 = downTo.getStep();
            if (step2 < 0 ? first2 >= last2 : first2 <= last2) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (regionMatchesImpl(str4, 0, charSequence, first2, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (first2 == last2) {
                            break;
                        }
                        first2 += step2;
                    } else {
                        return TuplesKt.to(Integer.valueOf(first2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ Pair findAnyOf$default(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return findAnyOf(charSequence, collection, i2, z);
    }

    @e
    public static final Pair<Integer, String> findLastAnyOf(@d CharSequence findLastAnyOf, @d Collection<String> strings, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(findLastAnyOf, "$this$findLastAnyOf");
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        return findAnyOf$StringsKt__StringsKt(findLastAnyOf, strings, i2, z, true);
    }

    public static /* synthetic */ Pair findLastAnyOf$default(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = getLastIndex(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return findLastAnyOf(charSequence, collection, i2, z);
    }

    @d
    public static final IntRange getIndices(@d CharSequence indices) {
        Intrinsics.checkParameterIsNotNull(indices, "$this$indices");
        return new IntRange(0, indices.length() - 1);
    }

    public static final int getLastIndex(@d CharSequence lastIndex) {
        Intrinsics.checkParameterIsNotNull(lastIndex, "$this$lastIndex");
        return lastIndex.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(@d CharSequence hasSurrogatePairAt, int i2) {
        Intrinsics.checkParameterIsNotNull(hasSurrogatePairAt, "$this$hasSurrogatePairAt");
        return i2 >= 0 && hasSurrogatePairAt.length() + (-2) >= i2 && Character.isHighSurrogate(hasSurrogatePairAt.charAt(i2)) && Character.isLowSurrogate(hasSurrogatePairAt.charAt(i2 + 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <C extends CharSequence & R, R> R ifBlank(C c2, Function0<? extends R> function0) {
        return StringsKt__StringsJVMKt.isBlank(c2) ? function0.invoke() : c2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <C extends CharSequence & R, R> R ifEmpty(C c2, Function0<? extends R> function0) {
        return c2.length() == 0 ? function0.invoke() : c2;
    }

    public static final int indexOf(@d CharSequence indexOf, char c2, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(indexOf, "$this$indexOf");
        return (z || !(indexOf instanceof String)) ? indexOfAny(indexOf, new char[]{c2}, i2, z) : ((String) indexOf).indexOf(c2, i2);
    }

    private static final int indexOf$StringsKt__StringsKt(@d CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2) {
        int coerceAtMost;
        int coerceAtLeast;
        IntProgression downTo;
        int coerceAtLeast2;
        int coerceAtMost2;
        if (z2) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i2, getLastIndex(charSequence));
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, 0);
            downTo = RangesKt___RangesKt.downTo(coerceAtMost, coerceAtLeast);
        } else {
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(i2, 0);
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(i3, charSequence.length());
            downTo = new IntRange(coerceAtLeast2, coerceAtMost2);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = downTo.getFirst();
            int last = downTo.getLast();
            int step = downTo.getStep();
            if (step >= 0) {
                if (first > last) {
                    return -1;
                }
            } else if (first < last) {
                return -1;
            }
            while (!StringsKt__StringsJVMKt.regionMatches((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z)) {
                if (first == last) {
                    return -1;
                }
                first += step;
            }
            return first;
        }
        int first2 = downTo.getFirst();
        int last2 = downTo.getLast();
        int step2 = downTo.getStep();
        if (step2 >= 0) {
            if (first2 > last2) {
                return -1;
            }
        } else if (first2 < last2) {
            return -1;
        }
        while (!regionMatchesImpl(charSequence2, 0, charSequence, first2, charSequence2.length(), z)) {
            if (first2 == last2) {
                return -1;
            }
            first2 += step2;
        }
        return first2;
    }

    static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2, int i4, Object obj) {
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i2, i3, z, (i4 & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, c2, i2, z);
    }

    public static final int indexOfAny(@d CharSequence indexOfAny, @d char[] chars, int i2, boolean z) {
        int coerceAtLeast;
        boolean z2;
        char single;
        Intrinsics.checkParameterIsNotNull(indexOfAny, "$this$indexOfAny");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        if (!z && chars.length == 1 && (indexOfAny instanceof String)) {
            single = ArraysKt___ArraysKt.single(chars);
            return ((String) indexOfAny).indexOf(single, i2);
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i2, 0);
        int lastIndex = getLastIndex(indexOfAny);
        if (coerceAtLeast > lastIndex) {
            return -1;
        }
        while (true) {
            char charAt = indexOfAny.charAt(coerceAtLeast);
            int length = chars.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z2 = false;
                    break;
                }
                if (CharsKt__CharKt.equals(chars[i3], charAt, z)) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            if (z2) {
                return coerceAtLeast;
            }
            if (coerceAtLeast == lastIndex) {
                return -1;
            }
            coerceAtLeast++;
        }
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return indexOfAny(charSequence, cArr, i2, z);
    }

    @InlineOnly
    private static final boolean isEmpty(@d CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    @InlineOnly
    private static final boolean isNotBlank(@d CharSequence charSequence) {
        return !StringsKt__StringsJVMKt.isBlank(charSequence);
    }

    @InlineOnly
    private static final boolean isNotEmpty(@d CharSequence charSequence) {
        return charSequence.length() > 0;
    }

    @InlineOnly
    private static final boolean isNullOrBlank(@e CharSequence charSequence) {
        return charSequence == null || StringsKt__StringsJVMKt.isBlank(charSequence);
    }

    @InlineOnly
    private static final boolean isNullOrEmpty(@e CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    @d
    public static final CharIterator iterator(@d final CharSequence iterator) {
        Intrinsics.checkParameterIsNotNull(iterator, "$this$iterator");
        return new CharIterator() { // from class: kotlin.text.StringsKt__StringsKt$iterator$1
            private int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < iterator.length();
            }

            @Override // kotlin.collections.CharIterator
            public char nextChar() {
                CharSequence charSequence = iterator;
                int i2 = this.index;
                this.index = i2 + 1;
                return charSequence.charAt(i2);
            }
        };
    }

    public static final int lastIndexOf(@d CharSequence lastIndexOf, char c2, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(lastIndexOf, "$this$lastIndexOf");
        return (z || !(lastIndexOf instanceof String)) ? lastIndexOfAny(lastIndexOf, new char[]{c2}, i2, z) : ((String) lastIndexOf).lastIndexOf(c2, i2);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = getLastIndex(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, c2, i2, z);
    }

    public static final int lastIndexOfAny(@d CharSequence lastIndexOfAny, @d char[] chars, int i2, boolean z) {
        int coerceAtMost;
        char single;
        Intrinsics.checkParameterIsNotNull(lastIndexOfAny, "$this$lastIndexOfAny");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        if (!z && chars.length == 1 && (lastIndexOfAny instanceof String)) {
            single = ArraysKt___ArraysKt.single(chars);
            return ((String) lastIndexOfAny).lastIndexOf(single, i2);
        }
        for (coerceAtMost = RangesKt___RangesKt.coerceAtMost(i2, getLastIndex(lastIndexOfAny)); coerceAtMost >= 0; coerceAtMost--) {
            char charAt = lastIndexOfAny.charAt(coerceAtMost);
            int length = chars.length;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (CharsKt__CharKt.equals(chars[i3], charAt, z)) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            if (z2) {
                return coerceAtMost;
            }
        }
        return -1;
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = getLastIndex(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return lastIndexOfAny(charSequence, cArr, i2, z);
    }

    @d
    public static final Sequence<String> lineSequence(@d CharSequence lineSequence) {
        Intrinsics.checkParameterIsNotNull(lineSequence, "$this$lineSequence");
        return splitToSequence$default(lineSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
    }

    @d
    public static final List<String> lines(@d CharSequence lines) {
        List<String> list;
        Intrinsics.checkParameterIsNotNull(lines, "$this$lines");
        list = SequencesKt___SequencesKt.toList(lineSequence(lines));
        return list;
    }

    @InlineOnly
    private static final boolean matches(@d CharSequence charSequence, Regex regex) {
        return regex.matches(charSequence);
    }

    @InlineOnly
    private static final String orEmpty(@e String str) {
        return str != null ? str : "";
    }

    @d
    public static final CharSequence padEnd(@d CharSequence padEnd, int i2, char c2) {
        Intrinsics.checkParameterIsNotNull(padEnd, "$this$padEnd");
        if (i2 < 0) {
            throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
        }
        if (i2 <= padEnd.length()) {
            return padEnd.subSequence(0, padEnd.length());
        }
        StringBuilder sb = new StringBuilder(i2);
        sb.append(padEnd);
        int length = i2 - padEnd.length();
        int i3 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c2);
                if (i3 == length) {
                    break;
                }
                i3++;
            }
        }
        return sb;
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence charSequence, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return padEnd(charSequence, i2, c2);
    }

    @d
    public static final CharSequence padStart(@d CharSequence padStart, int i2, char c2) {
        Intrinsics.checkParameterIsNotNull(padStart, "$this$padStart");
        if (i2 < 0) {
            throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
        }
        if (i2 <= padStart.length()) {
            return padStart.subSequence(0, padStart.length());
        }
        StringBuilder sb = new StringBuilder(i2);
        int length = i2 - padStart.length();
        int i3 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c2);
                if (i3 == length) {
                    break;
                }
                i3++;
            }
        }
        sb.append(padStart);
        return sb;
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence charSequence, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return padStart(charSequence, i2, c2);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(@d CharSequence charSequence, final char[] cArr, int i2, final boolean z, int i3) {
        if (i3 >= 0) {
            return new DelimitedRangesSequence(charSequence, i2, i3, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                    return invoke(charSequence2, num.intValue());
                }

                @e
                public final Pair<Integer, Integer> invoke(@d CharSequence receiver, int i4) {
                    Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                    int indexOfAny = StringsKt__StringsKt.indexOfAny(receiver, cArr, i4, z);
                    if (indexOfAny < 0) {
                        return null;
                    }
                    return TuplesKt.to(Integer.valueOf(indexOfAny), 1);
                }
            });
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArr, i2, z, i3);
    }

    public static final boolean regionMatchesImpl(@d CharSequence regionMatchesImpl, int i2, @d CharSequence other, int i3, int i4, boolean z) {
        Intrinsics.checkParameterIsNotNull(regionMatchesImpl, "$this$regionMatchesImpl");
        Intrinsics.checkParameterIsNotNull(other, "other");
        if (i3 < 0 || i2 < 0 || i2 > regionMatchesImpl.length() - i4 || i3 > other.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!CharsKt__CharKt.equals(regionMatchesImpl.charAt(i2 + i5), other.charAt(i3 + i5), z)) {
                return false;
            }
        }
        return true;
    }

    @d
    public static final CharSequence removePrefix(@d CharSequence removePrefix, @d CharSequence prefix) {
        Intrinsics.checkParameterIsNotNull(removePrefix, "$this$removePrefix");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        return startsWith$default(removePrefix, prefix, false, 2, (Object) null) ? removePrefix.subSequence(prefix.length(), removePrefix.length()) : removePrefix.subSequence(0, removePrefix.length());
    }

    @d
    public static final CharSequence removeRange(@d CharSequence removeRange, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(removeRange, "$this$removeRange");
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("End index (" + i3 + ") is less than start index (" + i2 + ").");
        }
        if (i3 == i2) {
            return removeRange.subSequence(0, removeRange.length());
        }
        StringBuilder sb = new StringBuilder(removeRange.length() - (i3 - i2));
        sb.append(removeRange, 0, i2);
        Intrinsics.checkExpressionValueIsNotNull(sb, "this.append(value, startIndex, endIndex)");
        sb.append(removeRange, i3, removeRange.length());
        Intrinsics.checkExpressionValueIsNotNull(sb, "this.append(value, startIndex, endIndex)");
        return sb;
    }

    @d
    public static final CharSequence removeSuffix(@d CharSequence removeSuffix, @d CharSequence suffix) {
        Intrinsics.checkParameterIsNotNull(removeSuffix, "$this$removeSuffix");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        return endsWith$default(removeSuffix, suffix, false, 2, (Object) null) ? removeSuffix.subSequence(0, removeSuffix.length() - suffix.length()) : removeSuffix.subSequence(0, removeSuffix.length());
    }

    @d
    public static final CharSequence removeSurrounding(@d CharSequence removeSurrounding, @d CharSequence prefix, @d CharSequence suffix) {
        Intrinsics.checkParameterIsNotNull(removeSurrounding, "$this$removeSurrounding");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        return (removeSurrounding.length() >= prefix.length() + suffix.length() && startsWith$default(removeSurrounding, prefix, false, 2, (Object) null) && endsWith$default(removeSurrounding, suffix, false, 2, (Object) null)) ? removeSurrounding.subSequence(prefix.length(), removeSurrounding.length() - suffix.length()) : removeSurrounding.subSequence(0, removeSurrounding.length());
    }

    @InlineOnly
    private static final String replace(@d CharSequence charSequence, Regex regex, String str) {
        return regex.replace(charSequence, str);
    }

    @d
    public static final String replaceAfter(@d String replaceAfter, char c2, @d String replacement, @d String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(replaceAfter, "$this$replaceAfter");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) replaceAfter, c2, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceAfter, indexOf$default + 1, replaceAfter.length(), (CharSequence) replacement).toString();
    }

    public static /* synthetic */ String replaceAfter$default(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return replaceAfter(str, c2, str2, str3);
    }

    @d
    public static final String replaceAfterLast(@d String replaceAfterLast, @d String delimiter, @d String replacement, @d String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(replaceAfterLast, "$this$replaceAfterLast");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) replaceAfterLast, delimiter, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceAfterLast, lastIndexOf$default + delimiter.length(), replaceAfterLast.length(), (CharSequence) replacement).toString();
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return replaceAfterLast(str, str2, str3, str4);
    }

    @d
    public static final String replaceBefore(@d String replaceBefore, char c2, @d String replacement, @d String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(replaceBefore, "$this$replaceBefore");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) replaceBefore, c2, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceBefore, 0, indexOf$default, (CharSequence) replacement).toString();
    }

    public static /* synthetic */ String replaceBefore$default(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return replaceBefore(str, c2, str2, str3);
    }

    @d
    public static final String replaceBeforeLast(@d String replaceBeforeLast, char c2, @d String replacement, @d String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(replaceBeforeLast, "$this$replaceBeforeLast");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) replaceBeforeLast, c2, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceBeforeLast, 0, lastIndexOf$default, (CharSequence) replacement).toString();
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return replaceBeforeLast(str, c2, str2, str3);
    }

    @InlineOnly
    private static final String replaceFirst(@d CharSequence charSequence, Regex regex, String str) {
        return regex.replaceFirst(charSequence, str);
    }

    @d
    public static final CharSequence replaceRange(@d CharSequence replaceRange, int i2, int i3, @d CharSequence replacement) {
        Intrinsics.checkParameterIsNotNull(replaceRange, "$this$replaceRange");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        if (i3 >= i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(replaceRange, 0, i2);
            Intrinsics.checkExpressionValueIsNotNull(sb, "this.append(value, startIndex, endIndex)");
            sb.append(replacement);
            sb.append(replaceRange, i3, replaceRange.length());
            Intrinsics.checkExpressionValueIsNotNull(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i3 + ") is less than start index (" + i2 + ").");
    }

    @d
    public static final List<String> split(@d CharSequence split, @d String[] delimiters, boolean z, int i2) {
        Iterable asIterable;
        Intrinsics.checkParameterIsNotNull(split, "$this$split");
        Intrinsics.checkParameterIsNotNull(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (!(str.length() == 0)) {
                return split$StringsKt__StringsKt(split, str, z, i2);
            }
        }
        asIterable = SequencesKt___SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(split, delimiters, 0, z, i2, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(asIterable, 10));
        Iterator it = asIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(split, (IntRange) it.next()));
        }
        return arrayList;
    }

    private static final List<String> split$StringsKt__StringsKt(@d CharSequence charSequence, String str, boolean z, int i2) {
        int i3 = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
        }
        int indexOf = indexOf(charSequence, str, 0, z);
        if (indexOf == -1 || i2 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(charSequence.toString());
        }
        boolean z2 = i2 > 0;
        ArrayList arrayList = new ArrayList(z2 ? RangesKt___RangesKt.coerceAtMost(i2, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(i3, indexOf).toString());
            i3 = str.length() + indexOf;
            if (z2 && arrayList.size() == i2 - 1) {
                break;
            }
            indexOf = indexOf(charSequence, str, i3, z);
        } while (indexOf != -1);
        arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return split(charSequence, strArr, z, i2);
    }

    @d
    public static final Sequence<String> splitToSequence(@d final CharSequence splitToSequence, @d String[] delimiters, boolean z, int i2) {
        Intrinsics.checkParameterIsNotNull(splitToSequence, "$this$splitToSequence");
        Intrinsics.checkParameterIsNotNull(delimiters, "delimiters");
        return SequencesKt___SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(splitToSequence, delimiters, 0, z, i2, 2, (Object) null), new Function1<IntRange, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @d
            public final String invoke(@d IntRange it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return StringsKt__StringsKt.substring(splitToSequence, it);
            }
        });
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return splitToSequence(charSequence, strArr, z, i2);
    }

    public static final boolean startsWith(@d CharSequence startsWith, char c2, boolean z) {
        Intrinsics.checkParameterIsNotNull(startsWith, "$this$startsWith");
        return startsWith.length() > 0 && CharsKt__CharKt.equals(startsWith.charAt(0), c2, z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, c2, z);
    }

    @d
    public static final CharSequence subSequence(@d CharSequence subSequence, @d IntRange range) {
        Intrinsics.checkParameterIsNotNull(subSequence, "$this$subSequence");
        Intrinsics.checkParameterIsNotNull(range, "range");
        return subSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    @d
    public static final String substring(@d String substring, @d IntRange range) {
        Intrinsics.checkParameterIsNotNull(substring, "$this$substring");
        Intrinsics.checkParameterIsNotNull(range, "range");
        String substring2 = substring.substring(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
        Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring2;
    }

    static /* synthetic */ String substring$default(CharSequence charSequence, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = charSequence.length();
        }
        return charSequence.subSequence(i2, i3).toString();
    }

    @d
    public static final String substringAfter(@d String substringAfter, char c2, @d String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(substringAfter, "$this$substringAfter");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) substringAfter, c2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfter.substring(indexOf$default + 1, substringAfter.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringAfter$default(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return substringAfter(str, c2, str2);
    }

    @d
    public static String substringAfterLast(@d String substringAfterLast, char c2, @d String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(substringAfterLast, "$this$substringAfterLast");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) substringAfterLast, c2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfterLast.substring(lastIndexOf$default + 1, substringAfterLast.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return substringAfterLast(str, c2, str2);
    }

    @d
    public static final String substringBefore(@d String substringBefore, char c2, @d String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(substringBefore, "$this$substringBefore");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) substringBefore, c2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBefore.substring(0, indexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringBefore$default(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return substringBefore(str, c2, str2);
    }

    @d
    public static final String substringBeforeLast(@d String substringBeforeLast, char c2, @d String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(substringBeforeLast, "$this$substringBeforeLast");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) substringBeforeLast, c2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBeforeLast.substring(0, lastIndexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return substringBeforeLast(str, c2, str2);
    }

    @d
    public static final CharSequence trim(@d CharSequence trim, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(trim, "$this$trim");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = trim.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean booleanValue = predicate.invoke(Character.valueOf(trim.charAt(!z ? i2 : length))).booleanValue();
            if (z) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i2++;
            } else {
                z = true;
            }
        }
        return trim.subSequence(i2, length + 1);
    }

    @d
    public static final CharSequence trimEnd(@d CharSequence trimEnd, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(trimEnd, "$this$trimEnd");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = trimEnd.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (predicate.invoke(Character.valueOf(trimEnd.charAt(length))).booleanValue());
        return trimEnd.subSequence(0, length + 1);
    }

    @d
    public static final CharSequence trimStart(@d CharSequence trimStart, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(trimStart, "$this$trimStart");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = trimStart.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!predicate.invoke(Character.valueOf(trimStart.charAt(i2))).booleanValue()) {
                return trimStart.subSequence(i2, trimStart.length());
            }
        }
        return "";
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return contains(charSequence, c2, z);
    }

    public static final boolean endsWith(@d CharSequence endsWith, @d CharSequence suffix, boolean z) {
        Intrinsics.checkParameterIsNotNull(endsWith, "$this$endsWith");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        return (!z && (endsWith instanceof String) && (suffix instanceof String)) ? StringsKt__StringsJVMKt.endsWith$default((String) endsWith, (String) suffix, false, 2, null) : regionMatchesImpl(endsWith, endsWith.length() - suffix.length(), suffix, 0, suffix.length(), z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, charSequence2, z);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, str, i2, z);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return indexOfAny(charSequence, (Collection<String>) collection, i2, z);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = getLastIndex(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, str, i2, z);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = getLastIndex(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return lastIndexOfAny(charSequence, (Collection<String>) collection, i2, z);
    }

    public static /* synthetic */ String padEnd$default(String str, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return padEnd(str, i2, c2);
    }

    public static /* synthetic */ String padStart$default(String str, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return padStart(str, i2, c2);
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, strArr, i2, z, i3);
    }

    @InlineOnly
    private static final String replace(@d CharSequence charSequence, Regex regex, Function1<? super MatchResult, ? extends CharSequence> function1) {
        return regex.replace(charSequence, function1);
    }

    public static /* synthetic */ String replaceAfter$default(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return replaceAfter(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return replaceAfterLast(str, c2, str2, str3);
    }

    public static /* synthetic */ String replaceBefore$default(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return replaceBefore(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return replaceBeforeLast(str, str2, str3, str4);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return split(charSequence, cArr, z, i2);
    }

    @d
    public static final Sequence<String> splitToSequence(@d final CharSequence splitToSequence, @d char[] delimiters, boolean z, int i2) {
        Intrinsics.checkParameterIsNotNull(splitToSequence, "$this$splitToSequence");
        Intrinsics.checkParameterIsNotNull(delimiters, "delimiters");
        return SequencesKt___SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(splitToSequence, delimiters, 0, z, i2, 2, (Object) null), new Function1<IntRange, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @d
            public final String invoke(@d IntRange it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return StringsKt__StringsKt.substring(splitToSequence, it);
            }
        });
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, char[] cArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return splitToSequence(charSequence, cArr, z, i2);
    }

    public static final boolean startsWith(@d CharSequence startsWith, @d CharSequence prefix, boolean z) {
        Intrinsics.checkParameterIsNotNull(startsWith, "$this$startsWith");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        return (!z && (startsWith instanceof String) && (prefix instanceof String)) ? StringsKt__StringsJVMKt.startsWith$default((String) startsWith, (String) prefix, false, 2, null) : regionMatchesImpl(startsWith, 0, prefix, 0, prefix.length(), z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, z);
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    @InlineOnly
    private static final CharSequence subSequence(@d String str, int i2, int i3) {
        return str.subSequence(i2, i3);
    }

    @InlineOnly
    private static final String substring(@d CharSequence charSequence, int i2, int i3) {
        return charSequence.subSequence(i2, i3).toString();
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return substringAfter(str, str2, str3);
    }

    public static /* synthetic */ String substringAfterLast$default(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return substringAfterLast(str, str2, str3);
    }

    public static /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return substringBefore(str, str2, str3);
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return substringBeforeLast(str, str2, str3);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(@d CharSequence charSequence, String[] strArr, int i2, final boolean z, int i3) {
        final List asList;
        if (i3 >= 0) {
            asList = ArraysKt___ArraysJvmKt.asList(strArr);
            return new DelimitedRangesSequence(charSequence, i2, i3, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                    return invoke(charSequence2, num.intValue());
                }

                @e
                public final Pair<Integer, Integer> invoke(@d CharSequence receiver, int i4) {
                    Pair findAnyOf$StringsKt__StringsKt;
                    Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                    findAnyOf$StringsKt__StringsKt = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt(receiver, asList, i4, z, false);
                    if (findAnyOf$StringsKt__StringsKt != null) {
                        return TuplesKt.to(findAnyOf$StringsKt__StringsKt.getFirst(), Integer.valueOf(((String) findAnyOf$StringsKt__StringsKt.getSecond()).length()));
                    }
                    return null;
                }
            });
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    @d
    public static final String replaceAfter(@d String replaceAfter, @d String delimiter, @d String replacement, @d String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(replaceAfter, "$this$replaceAfter");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) replaceAfter, delimiter, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceAfter, indexOf$default + delimiter.length(), replaceAfter.length(), (CharSequence) replacement).toString();
    }

    @d
    public static final String replaceAfterLast(@d String replaceAfterLast, char c2, @d String replacement, @d String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(replaceAfterLast, "$this$replaceAfterLast");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) replaceAfterLast, c2, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceAfterLast, lastIndexOf$default + 1, replaceAfterLast.length(), (CharSequence) replacement).toString();
    }

    @d
    public static final String replaceBefore(@d String replaceBefore, @d String delimiter, @d String replacement, @d String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(replaceBefore, "$this$replaceBefore");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) replaceBefore, delimiter, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceBefore, 0, indexOf$default, (CharSequence) replacement).toString();
    }

    @d
    public static final String replaceBeforeLast(@d String replaceBeforeLast, @d String delimiter, @d String replacement, @d String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(replaceBeforeLast, "$this$replaceBeforeLast");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) replaceBeforeLast, delimiter, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? missingDelimiterValue : replaceRange((CharSequence) replaceBeforeLast, 0, lastIndexOf$default, (CharSequence) replacement).toString();
    }

    static /* synthetic */ List split$default(CharSequence charSequence, Regex regex, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return regex.split(charSequence, i2);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, i2, z);
    }

    @d
    public static final String substring(@d CharSequence substring, @d IntRange range) {
        Intrinsics.checkParameterIsNotNull(substring, "$this$substring");
        Intrinsics.checkParameterIsNotNull(range, "range");
        return substring.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    @d
    public static final String substringAfter(@d String substringAfter, @d String delimiter, @d String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(substringAfter, "$this$substringAfter");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) substringAfter, delimiter, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfter.substring(indexOf$default + delimiter.length(), substringAfter.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @d
    public static final String substringAfterLast(@d String substringAfterLast, @d String delimiter, @d String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(substringAfterLast, "$this$substringAfterLast");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) substringAfterLast, delimiter, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfterLast.substring(lastIndexOf$default + delimiter.length(), substringAfterLast.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @d
    public static final String substringBefore(@d String substringBefore, @d String delimiter, @d String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(substringBefore, "$this$substringBefore");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) substringBefore, delimiter, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBefore.substring(0, indexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @d
    public static final String substringBeforeLast(@d String substringBeforeLast, @d String delimiter, @d String missingDelimiterValue) {
        Intrinsics.checkParameterIsNotNull(substringBeforeLast, "$this$substringBeforeLast");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        Intrinsics.checkParameterIsNotNull(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) substringBeforeLast, delimiter, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBeforeLast.substring(0, lastIndexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean contains(@d CharSequence contains, char c2, boolean z) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return indexOf$default(contains, c2, 0, z, 2, (Object) null) >= 0;
    }

    public static final int indexOf(@d CharSequence indexOf, @d String string, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(indexOf, "$this$indexOf");
        Intrinsics.checkParameterIsNotNull(string, "string");
        if (!z && (indexOf instanceof String)) {
            return ((String) indexOf).indexOf(string, i2);
        }
        return indexOf$StringsKt__StringsKt$default(indexOf, string, i2, indexOf.length(), z, false, 16, null);
    }

    public static final int lastIndexOf(@d CharSequence lastIndexOf, @d String string, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(lastIndexOf, "$this$lastIndexOf");
        Intrinsics.checkParameterIsNotNull(string, "string");
        if (!z && (lastIndexOf instanceof String)) {
            return ((String) lastIndexOf).lastIndexOf(string, i2);
        }
        return indexOf$StringsKt__StringsKt(lastIndexOf, string, i2, 0, z, true);
    }

    @d
    public static final String removePrefix(@d String removePrefix, @d CharSequence prefix) {
        Intrinsics.checkParameterIsNotNull(removePrefix, "$this$removePrefix");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        if (!startsWith$default((CharSequence) removePrefix, prefix, false, 2, (Object) null)) {
            return removePrefix;
        }
        String substring = removePrefix.substring(prefix.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @d
    public static final String removeSuffix(@d String removeSuffix, @d CharSequence suffix) {
        Intrinsics.checkParameterIsNotNull(removeSuffix, "$this$removeSuffix");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        if (!endsWith$default((CharSequence) removeSuffix, suffix, false, 2, (Object) null)) {
            return removeSuffix;
        }
        String substring = removeSuffix.substring(0, removeSuffix.length() - suffix.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @d
    public static final String removeSurrounding(@d String removeSurrounding, @d CharSequence prefix, @d CharSequence suffix) {
        Intrinsics.checkParameterIsNotNull(removeSurrounding, "$this$removeSurrounding");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        if (removeSurrounding.length() < prefix.length() + suffix.length() || !startsWith$default((CharSequence) removeSurrounding, prefix, false, 2, (Object) null) || !endsWith$default((CharSequence) removeSurrounding, suffix, false, 2, (Object) null)) {
            return removeSurrounding;
        }
        String substring = removeSurrounding.substring(prefix.length(), removeSurrounding.length() - suffix.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @InlineOnly
    private static final String trim(@d String str) {
        if (str != null) {
            return trim((CharSequence) str).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InlineOnly
    private static final String trimEnd(@d String str) {
        if (str != null) {
            return trimEnd((CharSequence) str).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InlineOnly
    private static final String trimStart(@d String str) {
        if (str != null) {
            return trimStart((CharSequence) str).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InlineOnly
    private static final boolean contains(@d CharSequence contains, Regex regex) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return regex.containsMatchIn(contains);
    }

    public static final boolean startsWith(@d CharSequence startsWith, @d CharSequence prefix, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(startsWith, "$this$startsWith");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        if (!z && (startsWith instanceof String) && (prefix instanceof String)) {
            return StringsKt__StringsJVMKt.startsWith$default((String) startsWith, (String) prefix, i2, false, 4, null);
        }
        return regionMatchesImpl(startsWith, i2, prefix, 0, prefix.length(), z);
    }

    @d
    public static final String trim(@d String trim, @d Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(trim, "$this$trim");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = trim.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean booleanValue = predicate.invoke(Character.valueOf(trim.charAt(!z ? i2 : length))).booleanValue();
            if (z) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i2++;
            } else {
                z = true;
            }
        }
        return trim.subSequence(i2, length + 1).toString();
    }

    @d
    public static final String trimEnd(@d String trimEnd, @d Function1<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        Intrinsics.checkParameterIsNotNull(trimEnd, "$this$trimEnd");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = trimEnd.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequence = "";
                break;
            }
            if (!predicate.invoke(Character.valueOf(trimEnd.charAt(length))).booleanValue()) {
                charSequence = trimEnd.subSequence(0, length + 1);
                break;
            }
        }
        return charSequence.toString();
    }

    @d
    public static final String trimStart(@d String trimStart, @d Function1<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        Intrinsics.checkParameterIsNotNull(trimStart, "$this$trimStart");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int length = trimStart.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                charSequence = "";
                break;
            }
            if (!predicate.invoke(Character.valueOf(trimStart.charAt(i2))).booleanValue()) {
                charSequence = trimStart.subSequence(i2, trimStart.length());
                break;
            }
            i2++;
        }
        return charSequence.toString();
    }

    @InlineOnly
    private static final String removeRange(@d String str, int i2, int i3) {
        if (str != null) {
            return removeRange((CharSequence) str, i2, i3).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @d
    public static final CharSequence removeSurrounding(@d CharSequence removeSurrounding, @d CharSequence delimiter) {
        Intrinsics.checkParameterIsNotNull(removeSurrounding, "$this$removeSurrounding");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        return removeSurrounding(removeSurrounding, delimiter, delimiter);
    }

    @InlineOnly
    private static final String replaceRange(@d String str, int i2, int i3, CharSequence charSequence) {
        if (str != null) {
            return replaceRange((CharSequence) str, i2, i3, charSequence).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @d
    public static final CharSequence removeRange(@d CharSequence removeRange, @d IntRange range) {
        Intrinsics.checkParameterIsNotNull(removeRange, "$this$removeRange");
        Intrinsics.checkParameterIsNotNull(range, "range");
        return removeRange(removeRange, range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    @d
    public static final String removeSurrounding(@d String removeSurrounding, @d CharSequence delimiter) {
        Intrinsics.checkParameterIsNotNull(removeSurrounding, "$this$removeSurrounding");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        return removeSurrounding(removeSurrounding, delimiter, delimiter);
    }

    @d
    public static final CharSequence replaceRange(@d CharSequence replaceRange, @d IntRange range, @d CharSequence replacement) {
        Intrinsics.checkParameterIsNotNull(replaceRange, "$this$replaceRange");
        Intrinsics.checkParameterIsNotNull(range, "range");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        return replaceRange(replaceRange, range.getStart().intValue(), range.getEndInclusive().intValue() + 1, replacement);
    }

    public static final int indexOfAny(@d CharSequence indexOfAny, @d Collection<String> strings, int i2, boolean z) {
        Integer first;
        Intrinsics.checkParameterIsNotNull(indexOfAny, "$this$indexOfAny");
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(indexOfAny, strings, i2, z, false);
        if (findAnyOf$StringsKt__StringsKt == null || (first = findAnyOf$StringsKt__StringsKt.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    public static final int lastIndexOfAny(@d CharSequence lastIndexOfAny, @d Collection<String> strings, int i2, boolean z) {
        Integer first;
        Intrinsics.checkParameterIsNotNull(lastIndexOfAny, "$this$lastIndexOfAny");
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(lastIndexOfAny, strings, i2, z, true);
        if (findAnyOf$StringsKt__StringsKt == null || (first = findAnyOf$StringsKt__StringsKt.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    @d
    public static final String padEnd(@d String padEnd, int i2, char c2) {
        Intrinsics.checkParameterIsNotNull(padEnd, "$this$padEnd");
        return padEnd((CharSequence) padEnd, i2, c2).toString();
    }

    @d
    public static String padStart(@d String padStart, int i2, char c2) {
        Intrinsics.checkParameterIsNotNull(padStart, "$this$padStart");
        return padStart((CharSequence) padStart, i2, c2).toString();
    }

    @InlineOnly
    private static final String removeRange(@d String str, IntRange intRange) {
        if (str != null) {
            return removeRange((CharSequence) str, intRange).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InlineOnly
    private static final String replaceRange(@d String str, IntRange intRange, CharSequence charSequence) {
        if (str != null) {
            return replaceRange((CharSequence) str, intRange, charSequence).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @d
    public static final CharSequence trim(@d CharSequence trim, @d char... chars) {
        boolean contains;
        Intrinsics.checkParameterIsNotNull(trim, "$this$trim");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        int length = trim.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            contains = ArraysKt___ArraysKt.contains(chars, trim.charAt(!z ? i2 : length));
            if (z) {
                if (!contains) {
                    break;
                }
                length--;
            } else if (contains) {
                i2++;
            } else {
                z = true;
            }
        }
        return trim.subSequence(i2, length + 1);
    }

    @d
    public static final CharSequence trimEnd(@d CharSequence trimEnd, @d char... chars) {
        boolean contains;
        Intrinsics.checkParameterIsNotNull(trimEnd, "$this$trimEnd");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        int length = trimEnd.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
            contains = ArraysKt___ArraysKt.contains(chars, trimEnd.charAt(length));
        } while (contains);
        return trimEnd.subSequence(0, length + 1);
    }

    @d
    public static final CharSequence trimStart(@d CharSequence trimStart, @d char... chars) {
        boolean contains;
        Intrinsics.checkParameterIsNotNull(trimStart, "$this$trimStart");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        int length = trimStart.length();
        for (int i2 = 0; i2 < length; i2++) {
            contains = ArraysKt___ArraysKt.contains(chars, trimStart.charAt(i2));
            if (!contains) {
                return trimStart.subSequence(i2, trimStart.length());
            }
        }
        return "";
    }

    @d
    public static final List<String> split(@d CharSequence split, @d char[] delimiters, boolean z, int i2) {
        Iterable asIterable;
        Intrinsics.checkParameterIsNotNull(split, "$this$split");
        Intrinsics.checkParameterIsNotNull(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return split$StringsKt__StringsKt(split, String.valueOf(delimiters[0]), z, i2);
        }
        asIterable = SequencesKt___SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(split, delimiters, 0, z, i2, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(asIterable, 10));
        Iterator it = asIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(split, (IntRange) it.next()));
        }
        return arrayList;
    }

    @d
    public static final String trim(@d String trim, @d char... chars) {
        boolean contains;
        Intrinsics.checkParameterIsNotNull(trim, "$this$trim");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        int length = trim.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            contains = ArraysKt___ArraysKt.contains(chars, trim.charAt(!z ? i2 : length));
            if (z) {
                if (!contains) {
                    break;
                }
                length--;
            } else if (contains) {
                i2++;
            } else {
                z = true;
            }
        }
        return trim.subSequence(i2, length + 1).toString();
    }

    @d
    public static final String trimEnd(@d String trimEnd, @d char... chars) {
        CharSequence charSequence;
        boolean contains;
        Intrinsics.checkParameterIsNotNull(trimEnd, "$this$trimEnd");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        int length = trimEnd.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequence = "";
                break;
            }
            contains = ArraysKt___ArraysKt.contains(chars, trimEnd.charAt(length));
            if (!contains) {
                charSequence = trimEnd.subSequence(0, length + 1);
                break;
            }
        }
        return charSequence.toString();
    }

    @d
    public static final String trimStart(@d String trimStart, @d char... chars) {
        CharSequence charSequence;
        boolean contains;
        Intrinsics.checkParameterIsNotNull(trimStart, "$this$trimStart");
        Intrinsics.checkParameterIsNotNull(chars, "chars");
        int length = trimStart.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                charSequence = "";
                break;
            }
            contains = ArraysKt___ArraysKt.contains(chars, trimStart.charAt(i2));
            if (!contains) {
                charSequence = trimStart.subSequence(i2, trimStart.length());
                break;
            }
            i2++;
        }
        return charSequence.toString();
    }

    @InlineOnly
    private static final List<String> split(@d CharSequence charSequence, Regex regex, int i2) {
        return regex.split(charSequence, i2);
    }

    @d
    public static final CharSequence trim(@d CharSequence trim) {
        Intrinsics.checkParameterIsNotNull(trim, "$this$trim");
        int length = trim.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean isWhitespace = CharsKt__CharJVMKt.isWhitespace(trim.charAt(!z ? i2 : length));
            if (z) {
                if (!isWhitespace) {
                    break;
                }
                length--;
            } else if (isWhitespace) {
                i2++;
            } else {
                z = true;
            }
        }
        return trim.subSequence(i2, length + 1);
    }

    @d
    public static final CharSequence trimEnd(@d CharSequence trimEnd) {
        Intrinsics.checkParameterIsNotNull(trimEnd, "$this$trimEnd");
        int length = trimEnd.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (CharsKt__CharJVMKt.isWhitespace(trimEnd.charAt(length)));
        return trimEnd.subSequence(0, length + 1);
    }

    @d
    public static final CharSequence trimStart(@d CharSequence trimStart) {
        Intrinsics.checkParameterIsNotNull(trimStart, "$this$trimStart");
        int length = trimStart.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!CharsKt__CharJVMKt.isWhitespace(trimStart.charAt(i2))) {
                return trimStart.subSequence(i2, trimStart.length());
            }
        }
        return "";
    }
}
