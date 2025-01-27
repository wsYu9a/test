package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.kwad.sdk.api.model.AdnName;
import f.b.a.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0017\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\bK\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0010\u001e\n\u0002\b\u001c\n\u0002\u0010\u000f\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0004\u001a\u00020\u0007*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b\u0004\u0010\b\u001a\u001c\u0010\u0004\u001a\u00020\n*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b\u0004\u0010\u000b\u001a\u001c\u0010\u0004\u001a\u00020\u0002*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b\u0004\u0010\r\u001a\u001c\u0010\u0004\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0010\u001a\u001c\u0010\u0004\u001a\u00020\u0012*\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0013\u001a\u001c\u0010\u0004\u001a\u00020\u0015*\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0016\u001a\u001c\u0010\u0004\u001a\u00020\u0018*\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0019\u001a\u001c\u0010\u0004\u001a\u00020\u001b*\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b\u0004\u0010\u001c\u001a/\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 \"\u0004\b\u0000\u0010\u001d*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e¢\u0006\u0004\b!\u0010\"\u001aC\u0010&\u001a\u00028\u0000\"\u0010\b\u0000\u0010$*\n\u0012\u0006\b\u0000\u0012\u00028\u00010#\"\u0004\b\u0001\u0010\u001d*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010%\u001a\u00028\u00002\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u001e¢\u0006\u0004\b&\u0010'\u001a%\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000 \"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b(\u0010)\u001a\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070 *\u00020\u0006¢\u0006\u0004\b(\u0010*\u001a\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0 *\u00020\t¢\u0006\u0004\b(\u0010+\u001a\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020 *\u00020\f¢\u0006\u0004\b(\u0010,\u001a\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0 *\u00020\u000e¢\u0006\u0004\b(\u0010-\u001a\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00120 *\u00020\u0011¢\u0006\u0004\b(\u0010.\u001a\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00150 *\u00020\u0014¢\u0006\u0004\b(\u0010/\u001a\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00180 *\u00020\u0017¢\u0006\u0004\b(\u00100\u001a\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001b0 *\u00020\u001a¢\u0006\u0004\b(\u00101\u001aW\u00108\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u00102\u001a\u00028\u00002\u001a\u00105\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000003j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`42\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0004\b8\u00109\u001a;\u00108\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u00102\u001a\u00028\u00002\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0004\b8\u0010:\u001a-\u00108\u001a\u00020\u0002*\u00020\u00062\u0006\u00102\u001a\u00020\u00072\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0004\b8\u0010;\u001a-\u00108\u001a\u00020\u0002*\u00020\t2\u0006\u00102\u001a\u00020\n2\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0004\b8\u0010<\u001a-\u00108\u001a\u00020\u0002*\u00020\f2\u0006\u00102\u001a\u00020\u00022\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0004\b8\u0010=\u001a-\u00108\u001a\u00020\u0002*\u00020\u000e2\u0006\u00102\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0004\b8\u0010>\u001a-\u00108\u001a\u00020\u0002*\u00020\u00112\u0006\u00102\u001a\u00020\u00122\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0004\b8\u0010?\u001a-\u00108\u001a\u00020\u0002*\u00020\u00142\u0006\u00102\u001a\u00020\u00152\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0004\b8\u0010@\u001a-\u00108\u001a\u00020\u0002*\u00020\u001a2\u0006\u00102\u001a\u00020\u001b2\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0004\b8\u0010A\u001a2\u0010E\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u000e\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0087\f¢\u0006\u0004\bC\u0010D\u001a\"\u0010H\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0087\b¢\u0006\u0004\bF\u0010G\u001a\"\u0010L\u001a\u00020I\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0087\b¢\u0006\u0004\bJ\u0010K\u001a2\u0010M\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u000e\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0087\f¢\u0006\u0004\bM\u0010D\u001a\u001c\u0010M\u001a\u00020\u0018*\u00020\u00062\u0006\u0010B\u001a\u00020\u0006H\u0087\f¢\u0006\u0004\bM\u0010N\u001a\u001c\u0010M\u001a\u00020\u0018*\u00020\t2\u0006\u0010B\u001a\u00020\tH\u0087\f¢\u0006\u0004\bM\u0010O\u001a\u001c\u0010M\u001a\u00020\u0018*\u00020\f2\u0006\u0010B\u001a\u00020\fH\u0087\f¢\u0006\u0004\bM\u0010P\u001a\u001c\u0010M\u001a\u00020\u0018*\u00020\u000e2\u0006\u0010B\u001a\u00020\u000eH\u0087\f¢\u0006\u0004\bM\u0010Q\u001a\u001c\u0010M\u001a\u00020\u0018*\u00020\u00112\u0006\u0010B\u001a\u00020\u0011H\u0087\f¢\u0006\u0004\bM\u0010R\u001a\u001c\u0010M\u001a\u00020\u0018*\u00020\u00142\u0006\u0010B\u001a\u00020\u0014H\u0087\f¢\u0006\u0004\bM\u0010S\u001a\u001c\u0010M\u001a\u00020\u0018*\u00020\u00172\u0006\u0010B\u001a\u00020\u0017H\u0087\f¢\u0006\u0004\bM\u0010T\u001a\u001c\u0010M\u001a\u00020\u0018*\u00020\u001a2\u0006\u0010B\u001a\u00020\u001aH\u0087\f¢\u0006\u0004\bM\u0010U\u001a\"\u0010V\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0087\b¢\u0006\u0004\bV\u0010G\u001a\u0014\u0010V\u001a\u00020\u0002*\u00020\u0006H\u0087\b¢\u0006\u0004\bV\u0010W\u001a\u0014\u0010V\u001a\u00020\u0002*\u00020\tH\u0087\b¢\u0006\u0004\bV\u0010X\u001a\u0014\u0010V\u001a\u00020\u0002*\u00020\fH\u0087\b¢\u0006\u0004\bV\u0010Y\u001a\u0014\u0010V\u001a\u00020\u0002*\u00020\u000eH\u0087\b¢\u0006\u0004\bV\u0010Z\u001a\u0014\u0010V\u001a\u00020\u0002*\u00020\u0011H\u0087\b¢\u0006\u0004\bV\u0010[\u001a\u0014\u0010V\u001a\u00020\u0002*\u00020\u0014H\u0087\b¢\u0006\u0004\bV\u0010\\\u001a\u0014\u0010V\u001a\u00020\u0002*\u00020\u0017H\u0087\b¢\u0006\u0004\bV\u0010]\u001a\u0014\u0010V\u001a\u00020\u0002*\u00020\u001aH\u0087\b¢\u0006\u0004\bV\u0010^\u001a\"\u0010_\u001a\u00020I\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0087\b¢\u0006\u0004\b_\u0010K\u001a\u0014\u0010_\u001a\u00020I*\u00020\u0006H\u0087\b¢\u0006\u0004\b_\u0010`\u001a\u0014\u0010_\u001a\u00020I*\u00020\tH\u0087\b¢\u0006\u0004\b_\u0010a\u001a\u0014\u0010_\u001a\u00020I*\u00020\fH\u0087\b¢\u0006\u0004\b_\u0010b\u001a\u0014\u0010_\u001a\u00020I*\u00020\u000eH\u0087\b¢\u0006\u0004\b_\u0010c\u001a\u0014\u0010_\u001a\u00020I*\u00020\u0011H\u0087\b¢\u0006\u0004\b_\u0010d\u001a\u0014\u0010_\u001a\u00020I*\u00020\u0014H\u0087\b¢\u0006\u0004\b_\u0010e\u001a\u0014\u0010_\u001a\u00020I*\u00020\u0017H\u0087\b¢\u0006\u0004\b_\u0010f\u001a\u0014\u0010_\u001a\u00020I*\u00020\u001aH\u0087\b¢\u0006\u0004\b_\u0010g\u001aS\u0010k\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010h\u001a\u00020\u00022\b\b\u0002\u0010i\u001a\u00020\u00022\b\b\u0002\u0010j\u001a\u00020\u0002H\u0007¢\u0006\u0004\bk\u0010l\u001a9\u0010k\u001a\u00020\u0006*\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\b\b\u0002\u0010h\u001a\u00020\u00022\b\b\u0002\u0010i\u001a\u00020\u00022\b\b\u0002\u0010j\u001a\u00020\u0002H\u0007¢\u0006\u0004\bk\u0010m\u001a9\u0010k\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\t2\b\b\u0002\u0010h\u001a\u00020\u00022\b\b\u0002\u0010i\u001a\u00020\u00022\b\b\u0002\u0010j\u001a\u00020\u0002H\u0007¢\u0006\u0004\bk\u0010n\u001a9\u0010k\u001a\u00020\f*\u00020\f2\u0006\u0010%\u001a\u00020\f2\b\b\u0002\u0010h\u001a\u00020\u00022\b\b\u0002\u0010i\u001a\u00020\u00022\b\b\u0002\u0010j\u001a\u00020\u0002H\u0007¢\u0006\u0004\bk\u0010o\u001a9\u0010k\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010h\u001a\u00020\u00022\b\b\u0002\u0010i\u001a\u00020\u00022\b\b\u0002\u0010j\u001a\u00020\u0002H\u0007¢\u0006\u0004\bk\u0010p\u001a9\u0010k\u001a\u00020\u0011*\u00020\u00112\u0006\u0010%\u001a\u00020\u00112\b\b\u0002\u0010h\u001a\u00020\u00022\b\b\u0002\u0010i\u001a\u00020\u00022\b\b\u0002\u0010j\u001a\u00020\u0002H\u0007¢\u0006\u0004\bk\u0010q\u001a9\u0010k\u001a\u00020\u0014*\u00020\u00142\u0006\u0010%\u001a\u00020\u00142\b\b\u0002\u0010h\u001a\u00020\u00022\b\b\u0002\u0010i\u001a\u00020\u00022\b\b\u0002\u0010j\u001a\u00020\u0002H\u0007¢\u0006\u0004\bk\u0010r\u001a9\u0010k\u001a\u00020\u0017*\u00020\u00172\u0006\u0010%\u001a\u00020\u00172\b\b\u0002\u0010h\u001a\u00020\u00022\b\b\u0002\u0010i\u001a\u00020\u00022\b\b\u0002\u0010j\u001a\u00020\u0002H\u0007¢\u0006\u0004\bk\u0010s\u001a9\u0010k\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010%\u001a\u00020\u001a2\b\b\u0002\u0010h\u001a\u00020\u00022\b\b\u0002\u0010i\u001a\u00020\u00022\b\b\u0002\u0010j\u001a\u00020\u0002H\u0007¢\u0006\u0004\bk\u0010t\u001a&\u0010u\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\b¢\u0006\u0004\bu\u0010v\u001a\u0014\u0010u\u001a\u00020\u0006*\u00020\u0006H\u0087\b¢\u0006\u0004\bu\u0010w\u001a\u0014\u0010u\u001a\u00020\t*\u00020\tH\u0087\b¢\u0006\u0004\bu\u0010x\u001a\u0014\u0010u\u001a\u00020\f*\u00020\fH\u0087\b¢\u0006\u0004\bu\u0010y\u001a\u0014\u0010u\u001a\u00020\u000e*\u00020\u000eH\u0087\b¢\u0006\u0004\bu\u0010z\u001a\u0014\u0010u\u001a\u00020\u0011*\u00020\u0011H\u0087\b¢\u0006\u0004\bu\u0010{\u001a\u0014\u0010u\u001a\u00020\u0014*\u00020\u0014H\u0087\b¢\u0006\u0004\bu\u0010|\u001a\u0014\u0010u\u001a\u00020\u0017*\u00020\u0017H\u0087\b¢\u0006\u0004\bu\u0010}\u001a\u0014\u0010u\u001a\u00020\u001a*\u00020\u001aH\u0087\b¢\u0006\u0004\bu\u0010~\u001a\u001d\u0010u\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u007f\u001a\u00020\u0002H\u0087\b¢\u0006\u0005\bu\u0010\u0080\u0001\u001a\u001d\u0010u\u001a\u00020\t*\u00020\t2\u0006\u0010\u007f\u001a\u00020\u0002H\u0087\b¢\u0006\u0005\bu\u0010\u0081\u0001\u001a\u001d\u0010u\u001a\u00020\f*\u00020\f2\u0006\u0010\u007f\u001a\u00020\u0002H\u0087\b¢\u0006\u0005\bu\u0010\u0082\u0001\u001a\u001d\u0010u\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u007f\u001a\u00020\u0002H\u0087\b¢\u0006\u0005\bu\u0010\u0083\u0001\u001a\u001d\u0010u\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u007f\u001a\u00020\u0002H\u0087\b¢\u0006\u0005\bu\u0010\u0084\u0001\u001a\u001d\u0010u\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u007f\u001a\u00020\u0002H\u0087\b¢\u0006\u0005\bu\u0010\u0085\u0001\u001a\u001d\u0010u\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u007f\u001a\u00020\u0002H\u0087\b¢\u0006\u0005\bu\u0010\u0086\u0001\u001a\u001d\u0010u\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u007f\u001a\u00020\u0002H\u0087\b¢\u0006\u0005\bu\u0010\u0087\u0001\u001a1\u0010u\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u007f\u001a\u00020\u0002H\u0087\b¢\u0006\u0005\bu\u0010\u0088\u0001\u001a9\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0087\b¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a'\u0010\u008b\u0001\u001a\u00020\u0006*\u00020\u00062\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0087\b¢\u0006\u0006\b\u0089\u0001\u0010\u008c\u0001\u001a'\u0010\u008b\u0001\u001a\u00020\t*\u00020\t2\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0087\b¢\u0006\u0006\b\u0089\u0001\u0010\u008d\u0001\u001a'\u0010\u008b\u0001\u001a\u00020\f*\u00020\f2\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0087\b¢\u0006\u0006\b\u0089\u0001\u0010\u008e\u0001\u001a'\u0010\u008b\u0001\u001a\u00020\u000e*\u00020\u000e2\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0087\b¢\u0006\u0006\b\u0089\u0001\u0010\u008f\u0001\u001a'\u0010\u008b\u0001\u001a\u00020\u0011*\u00020\u00112\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0087\b¢\u0006\u0006\b\u0089\u0001\u0010\u0090\u0001\u001a'\u0010\u008b\u0001\u001a\u00020\u0014*\u00020\u00142\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0087\b¢\u0006\u0006\b\u0089\u0001\u0010\u0091\u0001\u001a'\u0010\u008b\u0001\u001a\u00020\u0017*\u00020\u00172\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0087\b¢\u0006\u0006\b\u0089\u0001\u0010\u0092\u0001\u001a'\u0010\u008b\u0001\u001a\u00020\u001a*\u00020\u001a2\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0087\b¢\u0006\u0006\b\u0089\u0001\u0010\u0093\u0001\u001a8\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u008a\u0001\u001a&\u0010\u0094\u0001\u001a\u00020\u0006*\u00020\u00062\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a&\u0010\u0094\u0001\u001a\u00020\t*\u00020\t2\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u008d\u0001\u001a&\u0010\u0094\u0001\u001a\u00020\f*\u00020\f2\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u008e\u0001\u001a&\u0010\u0094\u0001\u001a\u00020\u000e*\u00020\u000e2\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u008f\u0001\u001a&\u0010\u0094\u0001\u001a\u00020\u0011*\u00020\u00112\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u0090\u0001\u001a&\u0010\u0094\u0001\u001a\u00020\u0014*\u00020\u00142\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u0091\u0001\u001a&\u0010\u0094\u0001\u001a\u00020\u0017*\u00020\u00172\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u0092\u0001\u001a&\u0010\u0094\u0001\u001a\u00020\u001a*\u00020\u001a2\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u0093\u0001\u001a=\u0010\u0096\u0001\u001a\u00030\u0095\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u00102\u001a\u00028\u00002\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a1\u0010\u0096\u0001\u001a\u00030\u0095\u0001*\u00020\u00062\u0006\u00102\u001a\u00020\u00072\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0098\u0001\u001a1\u0010\u0096\u0001\u001a\u00030\u0095\u0001*\u00020\t2\u0006\u00102\u001a\u00020\n2\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0099\u0001\u001a1\u0010\u0096\u0001\u001a\u00030\u0095\u0001*\u00020\f2\u0006\u00102\u001a\u00020\u00022\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u009a\u0001\u001a1\u0010\u0096\u0001\u001a\u00030\u0095\u0001*\u00020\u000e2\u0006\u00102\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u009b\u0001\u001a1\u0010\u0096\u0001\u001a\u00030\u0095\u0001*\u00020\u00112\u0006\u00102\u001a\u00020\u00122\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u009c\u0001\u001a1\u0010\u0096\u0001\u001a\u00030\u0095\u0001*\u00020\u00142\u0006\u00102\u001a\u00020\u00152\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u009d\u0001\u001a1\u0010\u0096\u0001\u001a\u00030\u0095\u0001*\u00020\u00172\u0006\u00102\u001a\u00020\u00182\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u009e\u0001\u001a1\u0010\u0096\u0001\u001a\u00030\u0095\u0001*\u00020\u001a2\u0006\u00102\u001a\u00020\u001b2\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u009f\u0001\u001a1\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u00102\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001\u001a\u001f\u0010 \u0001\u001a\u00020\u0006*\u00020\u00062\u0006\u00102\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0006\b \u0001\u0010¢\u0001\u001a\u001f\u0010 \u0001\u001a\u00020\t*\u00020\t2\u0006\u00102\u001a\u00020\nH\u0086\u0002¢\u0006\u0006\b \u0001\u0010£\u0001\u001a\u001f\u0010 \u0001\u001a\u00020\f*\u00020\f2\u0006\u00102\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0006\b \u0001\u0010\u0082\u0001\u001a\u001f\u0010 \u0001\u001a\u00020\u000e*\u00020\u000e2\u0006\u00102\u001a\u00020\u000fH\u0086\u0002¢\u0006\u0006\b \u0001\u0010¤\u0001\u001a\u001f\u0010 \u0001\u001a\u00020\u0011*\u00020\u00112\u0006\u00102\u001a\u00020\u0012H\u0086\u0002¢\u0006\u0006\b \u0001\u0010¥\u0001\u001a\u001f\u0010 \u0001\u001a\u00020\u0014*\u00020\u00142\u0006\u00102\u001a\u00020\u0015H\u0086\u0002¢\u0006\u0006\b \u0001\u0010¦\u0001\u001a\u001f\u0010 \u0001\u001a\u00020\u0017*\u00020\u00172\u0006\u00102\u001a\u00020\u0018H\u0086\u0002¢\u0006\u0006\b \u0001\u0010§\u0001\u001a\u001f\u0010 \u0001\u001a\u00020\u001a*\u00020\u001a2\u0006\u00102\u001a\u00020\u001bH\u0086\u0002¢\u0006\u0006\b \u0001\u0010¨\u0001\u001a9\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000©\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010«\u0001\u001a'\u0010 \u0001\u001a\u00020\u0006*\u00020\u00062\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070©\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010¬\u0001\u001a'\u0010 \u0001\u001a\u00020\t*\u00020\t2\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\n0©\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010\u00ad\u0001\u001a'\u0010 \u0001\u001a\u00020\f*\u00020\f2\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020©\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010®\u0001\u001a'\u0010 \u0001\u001a\u00020\u000e*\u00020\u000e2\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0©\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010¯\u0001\u001a'\u0010 \u0001\u001a\u00020\u0011*\u00020\u00112\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120©\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010°\u0001\u001a'\u0010 \u0001\u001a\u00020\u0014*\u00020\u00142\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u00150©\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010±\u0001\u001a'\u0010 \u0001\u001a\u00020\u0017*\u00020\u00172\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u00180©\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010²\u0001\u001a'\u0010 \u0001\u001a\u00020\u001a*\u00020\u001a2\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0©\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010³\u0001\u001a:\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000f\u0010ª\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010´\u0001\u001a \u0010 \u0001\u001a\u00020\u0006*\u00020\u00062\u0007\u0010ª\u0001\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0006\b \u0001\u0010µ\u0001\u001a \u0010 \u0001\u001a\u00020\t*\u00020\t2\u0007\u0010ª\u0001\u001a\u00020\tH\u0086\u0002¢\u0006\u0006\b \u0001\u0010¶\u0001\u001a \u0010 \u0001\u001a\u00020\f*\u00020\f2\u0007\u0010ª\u0001\u001a\u00020\fH\u0086\u0002¢\u0006\u0006\b \u0001\u0010·\u0001\u001a \u0010 \u0001\u001a\u00020\u000e*\u00020\u000e2\u0007\u0010ª\u0001\u001a\u00020\u000eH\u0086\u0002¢\u0006\u0006\b \u0001\u0010¸\u0001\u001a \u0010 \u0001\u001a\u00020\u0011*\u00020\u00112\u0007\u0010ª\u0001\u001a\u00020\u0011H\u0086\u0002¢\u0006\u0006\b \u0001\u0010¹\u0001\u001a \u0010 \u0001\u001a\u00020\u0014*\u00020\u00142\u0007\u0010ª\u0001\u001a\u00020\u0014H\u0086\u0002¢\u0006\u0006\b \u0001\u0010º\u0001\u001a \u0010 \u0001\u001a\u00020\u0017*\u00020\u00172\u0007\u0010ª\u0001\u001a\u00020\u0017H\u0086\u0002¢\u0006\u0006\b \u0001\u0010»\u0001\u001a \u0010 \u0001\u001a\u00020\u001a*\u00020\u001a2\u0007\u0010ª\u0001\u001a\u00020\u001aH\u0086\u0002¢\u0006\u0006\b \u0001\u0010¼\u0001\u001a1\u0010½\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u00102\u001a\u00028\u0000H\u0087\b¢\u0006\u0006\b½\u0001\u0010¡\u0001\u001a\u0015\u0010¾\u0001\u001a\u00030\u0095\u0001*\u00020\f¢\u0006\u0006\b¾\u0001\u0010¿\u0001\u001a\u0015\u0010¾\u0001\u001a\u00030\u0095\u0001*\u00020\u000e¢\u0006\u0006\b¾\u0001\u0010À\u0001\u001a\u0015\u0010¾\u0001\u001a\u00030\u0095\u0001*\u00020\u0006¢\u0006\u0006\b¾\u0001\u0010Á\u0001\u001a\u0015\u0010¾\u0001\u001a\u00030\u0095\u0001*\u00020\t¢\u0006\u0006\b¾\u0001\u0010Â\u0001\u001a\u0015\u0010¾\u0001\u001a\u00030\u0095\u0001*\u00020\u0014¢\u0006\u0006\b¾\u0001\u0010Ã\u0001\u001a\u0015\u0010¾\u0001\u001a\u00030\u0095\u0001*\u00020\u0011¢\u0006\u0006\b¾\u0001\u0010Ä\u0001\u001a\u0015\u0010¾\u0001\u001a\u00030\u0095\u0001*\u00020\u001a¢\u0006\u0006\b¾\u0001\u0010Å\u0001\u001a1\u0010¾\u0001\u001a\u00030\u0095\u0001\"\u000f\b\u0000\u0010\u0000*\t\u0012\u0004\u0012\u00028\u00000Æ\u0001*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0087\b¢\u0006\u0006\b¾\u0001\u0010Ç\u0001\u001a#\u0010¾\u0001\u001a\u00030\u0095\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0006\b¾\u0001\u0010È\u0001\u001a7\u0010¾\u0001\u001a\u00030\u0095\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\b¾\u0001\u0010É\u0001\u001a)\u0010¾\u0001\u001a\u00030\u0095\u0001*\u00020\u00062\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\b¾\u0001\u0010Ê\u0001\u001a)\u0010¾\u0001\u001a\u00030\u0095\u0001*\u00020\t2\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\b¾\u0001\u0010Ë\u0001\u001a)\u0010¾\u0001\u001a\u00030\u0095\u0001*\u00020\f2\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\b¾\u0001\u0010Ì\u0001\u001a)\u0010¾\u0001\u001a\u00030\u0095\u0001*\u00020\u000e2\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\b¾\u0001\u0010Í\u0001\u001a)\u0010¾\u0001\u001a\u00030\u0095\u0001*\u00020\u00112\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\b¾\u0001\u0010Î\u0001\u001a)\u0010¾\u0001\u001a\u00030\u0095\u0001*\u00020\u00142\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\b¾\u0001\u0010Ï\u0001\u001a)\u0010¾\u0001\u001a\u00030\u0095\u0001*\u00020\u001a2\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\b¾\u0001\u0010Ð\u0001\u001a?\u0010Ñ\u0001\u001a\u00030\u0095\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u00105\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000003j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`4¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001\u001aS\u0010Ñ\u0001\u001a\u00030\u0095\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u00105\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000003j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`42\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0006\bÑ\u0001\u0010Ó\u0001\u001a\u001a\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\u0006¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001\u001a\u001a\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\t¢\u0006\u0006\bÔ\u0001\u0010Ö\u0001\u001a\u001a\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\f¢\u0006\u0006\bÔ\u0001\u0010×\u0001\u001a\u001a\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u000e¢\u0006\u0006\bÔ\u0001\u0010Ø\u0001\u001a\u001a\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001*\u00020\u0011¢\u0006\u0006\bÔ\u0001\u0010Ù\u0001\u001a\u001a\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001*\u00020\u0014¢\u0006\u0006\bÔ\u0001\u0010Ú\u0001\u001a\u001a\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001*\u00020\u0017¢\u0006\u0006\bÔ\u0001\u0010Û\u0001\u001a\u001a\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001*\u00020\u001a¢\u0006\u0006\bÔ\u0001\u0010Ü\u0001\u001a4\u0010Þ\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000Ý\u0001\"\u000f\b\u0000\u0010\u0000*\t\u0012\u0004\u0012\u00028\u00000Æ\u0001*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0006\bÞ\u0001\u0010ß\u0001\u001a\u001b\u0010Þ\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070Ý\u0001*\u00020\u0006¢\u0006\u0006\bÞ\u0001\u0010à\u0001\u001a\u001b\u0010Þ\u0001\u001a\t\u0012\u0004\u0012\u00020\n0Ý\u0001*\u00020\t¢\u0006\u0006\bÞ\u0001\u0010á\u0001\u001a\u001b\u0010Þ\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020Ý\u0001*\u00020\f¢\u0006\u0006\bÞ\u0001\u0010â\u0001\u001a\u001b\u0010Þ\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0Ý\u0001*\u00020\u000e¢\u0006\u0006\bÞ\u0001\u0010ã\u0001\u001a\u001b\u0010Þ\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120Ý\u0001*\u00020\u0011¢\u0006\u0006\bÞ\u0001\u0010ä\u0001\u001a\u001b\u0010Þ\u0001\u001a\t\u0012\u0004\u0012\u00020\u00150Ý\u0001*\u00020\u0014¢\u0006\u0006\bÞ\u0001\u0010å\u0001\u001a\u001b\u0010Þ\u0001\u001a\t\u0012\u0004\u0012\u00020\u00180Ý\u0001*\u00020\u0017¢\u0006\u0006\bÞ\u0001\u0010æ\u0001\u001a\u001b\u0010Þ\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0Ý\u0001*\u00020\u001a¢\u0006\u0006\bÞ\u0001\u0010ç\u0001\u001aE\u0010Þ\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000Ý\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u00105\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000003j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`4¢\u0006\u0006\bÞ\u0001\u0010è\u0001¨\u0006é\u0001"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "", "index", "elementAt", "([Ljava/lang/Object;I)Ljava/lang/Object;", "", "", "([BI)B", "", "", "([SI)S", "", "([II)I", "", "", "([JI)J", "", "", "([FI)F", "", "", "([DI)D", "", "", "([ZI)Z", "", "", "([CI)C", "R", "Ljava/lang/Class;", "klass", "", "filterIsInstance", "([Ljava/lang/Object;Ljava/lang/Class;)Ljava/util/List;", "", "C", "destination", "filterIsInstanceTo", "([Ljava/lang/Object;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "asList", "([Ljava/lang/Object;)Ljava/util/List;", "([B)Ljava/util/List;", "([S)Ljava/util/List;", "([I)Ljava/util/List;", "([J)Ljava/util/List;", "([F)Ljava/util/List;", "([D)Ljava/util/List;", "([Z)Ljava/util/List;", "([C)Ljava/util/List;", "element", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "fromIndex", "toIndex", "binarySearch", "([Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;II)I", "([Ljava/lang/Object;Ljava/lang/Object;II)I", "([BBII)I", "([SSII)I", "([IIII)I", "([JJII)I", "([FFII)I", "([DDII)I", "([CCII)I", AdnName.OTHER, "contentDeepEqualsInline", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepEquals", "contentDeepHashCodeInline", "([Ljava/lang/Object;)I", "contentDeepHashCode", "", "contentDeepToStringInline", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToString", "contentEquals", "([B[B)Z", "([S[S)Z", "([I[I)Z", "([J[J)Z", "([F[F)Z", "([D[D)Z", "([Z[Z)Z", "([C[C)Z", "contentHashCode", "([B)I", "([S)I", "([I)I", "([J)I", "([F)I", "([D)I", "([Z)I", "([C)I", "contentToString", "([B)Ljava/lang/String;", "([S)Ljava/lang/String;", "([I)Ljava/lang/String;", "([J)Ljava/lang/String;", "([F)Ljava/lang/String;", "([D)Ljava/lang/String;", "([Z)Ljava/lang/String;", "([C)Ljava/lang/String;", "destinationOffset", "startIndex", "endIndex", "copyInto", "([Ljava/lang/Object;[Ljava/lang/Object;III)[Ljava/lang/Object;", "([B[BIII)[B", "([S[SIII)[S", "([I[IIII)[I", "([J[JIII)[J", "([F[FIII)[F", "([D[DIII)[D", "([Z[ZIII)[Z", "([C[CIII)[C", "copyOf", "([Ljava/lang/Object;)[Ljava/lang/Object;", "([B)[B", "([S)[S", "([I)[I", "([J)[J", "([F)[F", "([D)[D", "([Z)[Z", "([C)[C", "newSize", "([BI)[B", "([SI)[S", "([II)[I", "([JI)[J", "([FI)[F", "([DI)[D", "([ZI)[Z", "([CI)[C", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfRangeInline", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "copyOfRange", "([BII)[B", "([SII)[S", "([III)[I", "([JII)[J", "([FII)[F", "([DII)[D", "([ZII)[Z", "([CII)[C", "copyOfRangeImpl", "", "fill", "([Ljava/lang/Object;Ljava/lang/Object;II)V", "([BBII)V", "([SSII)V", "([IIII)V", "([JJII)V", "([FFII)V", "([DDII)V", "([ZZII)V", "([CCII)V", "plus", "([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "([BB)[B", "([SS)[S", "([JJ)[J", "([FF)[F", "([DD)[D", "([ZZ)[Z", "([CC)[C", "", "elements", "([Ljava/lang/Object;Ljava/util/Collection;)[Ljava/lang/Object;", "([BLjava/util/Collection;)[B", "([SLjava/util/Collection;)[S", "([ILjava/util/Collection;)[I", "([JLjava/util/Collection;)[J", "([FLjava/util/Collection;)[F", "([DLjava/util/Collection;)[D", "([ZLjava/util/Collection;)[Z", "([CLjava/util/Collection;)[C", "([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "([B[B)[B", "([S[S)[S", "([I[I)[I", "([J[J)[J", "([F[F)[F", "([D[D)[D", "([Z[Z)[Z", "([C[C)[C", "plusElement", "sort", "([I)V", "([J)V", "([B)V", "([S)V", "([D)V", "([F)V", "([C)V", "", "([Ljava/lang/Comparable;)V", "([Ljava/lang/Object;)V", "([Ljava/lang/Object;II)V", "([BII)V", "([SII)V", "([III)V", "([JII)V", "([FII)V", "([DII)V", "([CII)V", "sortWith", "([Ljava/lang/Object;Ljava/util/Comparator;)V", "([Ljava/lang/Object;Ljava/util/Comparator;II)V", "toTypedArray", "([B)[Ljava/lang/Byte;", "([S)[Ljava/lang/Short;", "([I)[Ljava/lang/Integer;", "([J)[Ljava/lang/Long;", "([F)[Ljava/lang/Float;", "([D)[Ljava/lang/Double;", "([Z)[Ljava/lang/Boolean;", "([C)[Ljava/lang/Character;", "Ljava/util/SortedSet;", "toSortedSet", "([Ljava/lang/Comparable;)Ljava/util/SortedSet;", "([B)Ljava/util/SortedSet;", "([S)Ljava/util/SortedSet;", "([I)Ljava/util/SortedSet;", "([J)Ljava/util/SortedSet;", "([F)Ljava/util/SortedSet;", "([D)Ljava/util/SortedSet;", "([Z)Ljava/util/SortedSet;", "([C)Ljava/util/SortedSet;", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/SortedSet;", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes5.dex */
public class ArraysKt___ArraysJvmKt extends ArraysKt__ArraysKt {
    @d
    public static <T> List<T> asList(@d T[] asList) {
        Intrinsics.checkParameterIsNotNull(asList, "$this$asList");
        List<T> asList2 = ArraysUtilJVM.asList(asList);
        Intrinsics.checkExpressionValueIsNotNull(asList2, "ArraysUtilJVM.asList(this)");
        return asList2;
    }

    public static final <T> int binarySearch(@d T[] binarySearch, T t, @d Comparator<? super T> comparator, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(binarySearch, "$this$binarySearch");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return Arrays.binarySearch(binarySearch, i2, i3, t, comparator);
    }

    public static /* synthetic */ int binarySearch$default(Object[] objArr, Object obj, Comparator comparator, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return binarySearch(objArr, obj, comparator, i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    @JvmName(name = "contentDeepEqualsInline")
    private static final <T> boolean contentDeepEqualsInline(@d T[] tArr, T[] tArr2) {
        return PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) ? ArraysKt__ArraysKt.contentDeepEquals(tArr, tArr2) : Arrays.deepEquals(tArr, tArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    @JvmName(name = "contentDeepHashCodeInline")
    private static final <T> int contentDeepHashCodeInline(@d T[] tArr) {
        return PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) ? ArraysKt__ArraysJVMKt.contentDeepHashCode(tArr) : Arrays.deepHashCode(tArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    @JvmName(name = "contentDeepToStringInline")
    private static final <T> String contentDeepToStringInline(@d T[] tArr) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return ArraysKt__ArraysKt.contentDeepToString(tArr);
        }
        String deepToString = Arrays.deepToString(tArr);
        Intrinsics.checkExpressionValueIsNotNull(deepToString, "java.util.Arrays.deepToString(this)");
        return deepToString;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> boolean contentEquals(@d T[] tArr, T[] tArr2) {
        return Arrays.equals(tArr, tArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> int contentHashCode(@d T[] tArr) {
        return Arrays.hashCode(tArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> String contentToString(@d T[] tArr) {
        String arrays = Arrays.toString(tArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final <T> T[] copyInto(@d T[] copyInto, @d T[] destination, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(copyInto, "$this$copyInto");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        System.arraycopy(copyInto, i3, destination, i2, i4 - i3);
        return destination;
    }

    public static /* synthetic */ Object[] copyInto$default(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        return copyInto(objArr, objArr2, i2, i3, i4);
    }

    @InlineOnly
    private static final <T> T[] copyOf(@d T[] tArr) {
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkExpressionValueIsNotNull(tArr2, "java.util.Arrays.copyOf(this, size)");
        return tArr2;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @d
    @PublishedApi
    public static <T> T[] copyOfRange(@d T[] copyOfRangeImpl, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(copyOfRangeImpl, "$this$copyOfRangeImpl");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, copyOfRangeImpl.length);
        T[] tArr = (T[]) Arrays.copyOfRange(copyOfRangeImpl, i2, i3);
        Intrinsics.checkExpressionValueIsNotNull(tArr, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return tArr;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final <T> T[] copyOfRangeInline(@d T[] tArr, int i2, int i3) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return (T[]) ArraysKt.copyOfRange(tArr, i2, i3);
        }
        if (i3 <= tArr.length) {
            T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i2, i3);
            Intrinsics.checkExpressionValueIsNotNull(tArr2, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return tArr2;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + tArr.length);
    }

    @InlineOnly
    private static final <T> T elementAt(@d T[] tArr, int i2) {
        return tArr[i2];
    }

    public static final <T> void fill(@d T[] fill, T t, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(fill, "$this$fill");
        Arrays.fill(fill, i2, i3, t);
    }

    public static /* synthetic */ void fill$default(Object[] objArr, Object obj, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        fill(objArr, obj, i2, i3);
    }

    @d
    public static final <R> List<R> filterIsInstance(@d Object[] filterIsInstance, @d Class<R> klass) {
        Intrinsics.checkParameterIsNotNull(filterIsInstance, "$this$filterIsInstance");
        Intrinsics.checkParameterIsNotNull(klass, "klass");
        return (List) filterIsInstanceTo(filterIsInstance, new ArrayList(), klass);
    }

    @d
    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(@d Object[] filterIsInstanceTo, @d C destination, @d Class<R> klass) {
        Intrinsics.checkParameterIsNotNull(filterIsInstanceTo, "$this$filterIsInstanceTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(klass, "klass");
        for (Object obj : filterIsInstanceTo) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @d
    public static final <T> T[] plus(@d T[] plus, T t) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        int length = plus.length;
        T[] result = (T[]) Arrays.copyOf(plus, length + 1);
        result[length] = t;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @InlineOnly
    private static final <T> T[] plusElement(@d T[] tArr, T t) {
        return (T[]) plus(tArr, t);
    }

    public static final void sort(@d int[] sort) {
        Intrinsics.checkParameterIsNotNull(sort, "$this$sort");
        if (sort.length > 1) {
            Arrays.sort(sort);
        }
    }

    public static /* synthetic */ void sort$default(Object[] objArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = objArr.length;
        }
        sort(objArr, i2, i3);
    }

    public static final <T> void sortWith(@d T[] sortWith, @d Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(sortWith, "$this$sortWith");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        if (sortWith.length > 1) {
            Arrays.sort(sortWith, comparator);
        }
    }

    public static /* synthetic */ void sortWith$default(Object[] objArr, Comparator comparator, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        sortWith(objArr, comparator, i2, i3);
    }

    @d
    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(@d T[] toSortedSet) {
        Intrinsics.checkParameterIsNotNull(toSortedSet, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(toSortedSet, new TreeSet());
    }

    @d
    public static final Byte[] toTypedArray(@d byte[] toTypedArray) {
        Intrinsics.checkParameterIsNotNull(toTypedArray, "$this$toTypedArray");
        Byte[] bArr = new Byte[toTypedArray.length];
        int length = toTypedArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = Byte.valueOf(toTypedArray[i2]);
        }
        return bArr;
    }

    @d
    public static final List<Byte> asList(@d byte[] asList) {
        Intrinsics.checkParameterIsNotNull(asList, "$this$asList");
        return new ArraysKt___ArraysJvmKt$asList$1(asList);
    }

    public static final <T> int binarySearch(@d T[] binarySearch, T t, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(binarySearch, "$this$binarySearch");
        return Arrays.binarySearch(binarySearch, i2, i3, t);
    }

    public static /* synthetic */ int binarySearch$default(Object[] objArr, Object obj, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        return binarySearch(objArr, obj, i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final boolean contentEquals(@d byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int contentHashCode(@d byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String contentToString(@d byte[] bArr) {
        String arrays = Arrays.toString(bArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @d
    @SinceKotlin(version = "1.3")
    public static byte[] copyInto(@d byte[] copyInto, @d byte[] destination, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(copyInto, "$this$copyInto");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        System.arraycopy(copyInto, i3, destination, i2, i4 - i3);
        return destination;
    }

    public static /* synthetic */ byte[] copyInto$default(byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = bArr.length;
        }
        return copyInto(bArr, bArr2, i2, i3, i4);
    }

    @InlineOnly
    private static final byte[] copyOf(@d byte[] bArr) {
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @InlineOnly
    private static final byte elementAt(@d byte[] bArr, int i2) {
        return bArr[i2];
    }

    public static void fill(@d byte[] fill, byte b2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(fill, "$this$fill");
        Arrays.fill(fill, i2, i3, b2);
    }

    public static /* synthetic */ void fill$default(byte[] bArr, byte b2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = bArr.length;
        }
        fill(bArr, b2, i2, i3);
    }

    public static final void sort(@d long[] sort) {
        Intrinsics.checkParameterIsNotNull(sort, "$this$sort");
        if (sort.length > 1) {
            Arrays.sort(sort);
        }
    }

    public static /* synthetic */ void sort$default(byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        sort(bArr, i2, i3);
    }

    public static final <T> void sortWith(@d T[] sortWith, @d Comparator<? super T> comparator, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(sortWith, "$this$sortWith");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        Arrays.sort(sortWith, i2, i3, comparator);
    }

    @d
    public static final SortedSet<Byte> toSortedSet(@d byte[] toSortedSet) {
        Intrinsics.checkParameterIsNotNull(toSortedSet, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(toSortedSet, new TreeSet());
    }

    @d
    public static final List<Short> asList(@d short[] asList) {
        Intrinsics.checkParameterIsNotNull(asList, "$this$asList");
        return new ArraysKt___ArraysJvmKt$asList$2(asList);
    }

    public static final int binarySearch(@d byte[] binarySearch, byte b2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(binarySearch, "$this$binarySearch");
        return Arrays.binarySearch(binarySearch, i2, i3, b2);
    }

    public static /* synthetic */ int binarySearch$default(byte[] bArr, byte b2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = bArr.length;
        }
        return binarySearch(bArr, b2, i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final boolean contentEquals(@d short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int contentHashCode(@d short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String contentToString(@d short[] sArr) {
        String arrays = Arrays.toString(sArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @d
    @SinceKotlin(version = "1.3")
    public static short[] copyInto(@d short[] copyInto, @d short[] destination, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(copyInto, "$this$copyInto");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        System.arraycopy(copyInto, i3, destination, i2, i4 - i3);
        return destination;
    }

    public static /* synthetic */ short[] copyInto$default(short[] sArr, short[] sArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = sArr.length;
        }
        return copyInto(sArr, sArr2, i2, i3, i4);
    }

    @InlineOnly
    private static final short[] copyOf(@d short[] sArr) {
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @d
    @PublishedApi
    public static byte[] copyOfRange(@d byte[] copyOfRangeImpl, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(copyOfRangeImpl, "$this$copyOfRangeImpl");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, copyOfRangeImpl.length);
        byte[] copyOfRange = Arrays.copyOfRange(copyOfRangeImpl, i2, i3);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @InlineOnly
    private static final short elementAt(@d short[] sArr, int i2) {
        return sArr[i2];
    }

    public static void fill(@d short[] fill, short s, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(fill, "$this$fill");
        Arrays.fill(fill, i2, i3, s);
    }

    public static /* synthetic */ void fill$default(short[] sArr, short s, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = sArr.length;
        }
        fill(sArr, s, i2, i3);
    }

    public static final void sort(@d byte[] sort) {
        Intrinsics.checkParameterIsNotNull(sort, "$this$sort");
        if (sort.length > 1) {
            Arrays.sort(sort);
        }
    }

    public static /* synthetic */ void sort$default(short[] sArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = sArr.length;
        }
        sort(sArr, i2, i3);
    }

    @d
    public static final SortedSet<Short> toSortedSet(@d short[] toSortedSet) {
        Intrinsics.checkParameterIsNotNull(toSortedSet, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(toSortedSet, new TreeSet());
    }

    @d
    public static final List<Integer> asList(@d int[] asList) {
        Intrinsics.checkParameterIsNotNull(asList, "$this$asList");
        return new ArraysKt___ArraysJvmKt$asList$3(asList);
    }

    public static final int binarySearch(@d short[] binarySearch, short s, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(binarySearch, "$this$binarySearch");
        return Arrays.binarySearch(binarySearch, i2, i3, s);
    }

    public static /* synthetic */ int binarySearch$default(short[] sArr, short s, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = sArr.length;
        }
        return binarySearch(sArr, s, i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final boolean contentEquals(@d int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int contentHashCode(@d int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String contentToString(@d int[] iArr) {
        String arrays = Arrays.toString(iArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @d
    @SinceKotlin(version = "1.3")
    public static int[] copyInto(@d int[] copyInto, @d int[] destination, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(copyInto, "$this$copyInto");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        System.arraycopy(copyInto, i3, destination, i2, i4 - i3);
        return destination;
    }

    public static /* synthetic */ int[] copyInto$default(int[] iArr, int[] iArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = iArr.length;
        }
        return copyInto(iArr, iArr2, i2, i3, i4);
    }

    @InlineOnly
    private static final int[] copyOf(@d int[] iArr) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @InlineOnly
    private static final int elementAt(@d int[] iArr, int i2) {
        return iArr[i2];
    }

    public static void fill(@d int[] fill, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(fill, "$this$fill");
        Arrays.fill(fill, i3, i4, i2);
    }

    public static /* synthetic */ void fill$default(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = iArr.length;
        }
        fill(iArr, i2, i3, i4);
    }

    public static final void sort(@d short[] sort) {
        Intrinsics.checkParameterIsNotNull(sort, "$this$sort");
        if (sort.length > 1) {
            Arrays.sort(sort);
        }
    }

    public static /* synthetic */ void sort$default(int[] iArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = iArr.length;
        }
        sort(iArr, i2, i3);
    }

    @d
    public static final SortedSet<Integer> toSortedSet(@d int[] toSortedSet) {
        Intrinsics.checkParameterIsNotNull(toSortedSet, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(toSortedSet, new TreeSet());
    }

    @d
    public static final Short[] toTypedArray(@d short[] toTypedArray) {
        Intrinsics.checkParameterIsNotNull(toTypedArray, "$this$toTypedArray");
        Short[] shArr = new Short[toTypedArray.length];
        int length = toTypedArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            shArr[i2] = Short.valueOf(toTypedArray[i2]);
        }
        return shArr;
    }

    @d
    public static final List<Long> asList(@d long[] asList) {
        Intrinsics.checkParameterIsNotNull(asList, "$this$asList");
        return new ArraysKt___ArraysJvmKt$asList$4(asList);
    }

    public static final int binarySearch(@d int[] binarySearch, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(binarySearch, "$this$binarySearch");
        return Arrays.binarySearch(binarySearch, i3, i4, i2);
    }

    public static /* synthetic */ int binarySearch$default(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = iArr.length;
        }
        return binarySearch(iArr, i2, i3, i4);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final boolean contentEquals(@d long[] jArr, long[] jArr2) {
        return Arrays.equals(jArr, jArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int contentHashCode(@d long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String contentToString(@d long[] jArr) {
        String arrays = Arrays.toString(jArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @d
    @SinceKotlin(version = "1.3")
    public static long[] copyInto(@d long[] copyInto, @d long[] destination, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(copyInto, "$this$copyInto");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        System.arraycopy(copyInto, i3, destination, i2, i4 - i3);
        return destination;
    }

    public static /* synthetic */ long[] copyInto$default(long[] jArr, long[] jArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = jArr.length;
        }
        return copyInto(jArr, jArr2, i2, i3, i4);
    }

    @InlineOnly
    private static final long[] copyOf(@d long[] jArr) {
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @d
    @PublishedApi
    public static short[] copyOfRange(@d short[] copyOfRangeImpl, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(copyOfRangeImpl, "$this$copyOfRangeImpl");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, copyOfRangeImpl.length);
        short[] copyOfRange = Arrays.copyOfRange(copyOfRangeImpl, i2, i3);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @InlineOnly
    private static final long elementAt(@d long[] jArr, int i2) {
        return jArr[i2];
    }

    public static void fill(@d long[] fill, long j2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(fill, "$this$fill");
        Arrays.fill(fill, i2, i3, j2);
    }

    public static /* synthetic */ void fill$default(long[] jArr, long j2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = jArr.length;
        }
        fill(jArr, j2, i2, i3);
    }

    @d
    public static byte[] plus(@d byte[] plus, byte b2) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        int length = plus.length;
        byte[] result = Arrays.copyOf(plus, length + 1);
        result[length] = b2;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final void sort(@d double[] sort) {
        Intrinsics.checkParameterIsNotNull(sort, "$this$sort");
        if (sort.length > 1) {
            Arrays.sort(sort);
        }
    }

    public static /* synthetic */ void sort$default(long[] jArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = jArr.length;
        }
        sort(jArr, i2, i3);
    }

    @d
    public static final SortedSet<Long> toSortedSet(@d long[] toSortedSet) {
        Intrinsics.checkParameterIsNotNull(toSortedSet, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(toSortedSet, new TreeSet());
    }

    @d
    public static final List<Float> asList(@d float[] asList) {
        Intrinsics.checkParameterIsNotNull(asList, "$this$asList");
        return new ArraysKt___ArraysJvmKt$asList$5(asList);
    }

    public static final int binarySearch(@d long[] binarySearch, long j2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(binarySearch, "$this$binarySearch");
        return Arrays.binarySearch(binarySearch, i2, i3, j2);
    }

    public static /* synthetic */ int binarySearch$default(long[] jArr, long j2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = jArr.length;
        }
        return binarySearch(jArr, j2, i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final boolean contentEquals(@d float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int contentHashCode(@d float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String contentToString(@d float[] fArr) {
        String arrays = Arrays.toString(fArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final float[] copyInto(@d float[] copyInto, @d float[] destination, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(copyInto, "$this$copyInto");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        System.arraycopy(copyInto, i3, destination, i2, i4 - i3);
        return destination;
    }

    public static /* synthetic */ float[] copyInto$default(float[] fArr, float[] fArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = fArr.length;
        }
        return copyInto(fArr, fArr2, i2, i3, i4);
    }

    @InlineOnly
    private static final float[] copyOf(@d float[] fArr) {
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final byte[] copyOfRangeInline(@d byte[] bArr, int i2, int i3) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(bArr, i2, i3);
        }
        if (i3 <= bArr.length) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i2, i3);
            Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + bArr.length);
    }

    @InlineOnly
    private static final float elementAt(@d float[] fArr, int i2) {
        return fArr[i2];
    }

    public static final void fill(@d float[] fill, float f2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(fill, "$this$fill");
        Arrays.fill(fill, i2, i3, f2);
    }

    public static /* synthetic */ void fill$default(float[] fArr, float f2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = fArr.length;
        }
        fill(fArr, f2, i2, i3);
    }

    public static final void sort(@d float[] sort) {
        Intrinsics.checkParameterIsNotNull(sort, "$this$sort");
        if (sort.length > 1) {
            Arrays.sort(sort);
        }
    }

    public static /* synthetic */ void sort$default(float[] fArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = fArr.length;
        }
        sort(fArr, i2, i3);
    }

    @d
    public static final SortedSet<Float> toSortedSet(@d float[] toSortedSet) {
        Intrinsics.checkParameterIsNotNull(toSortedSet, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(toSortedSet, new TreeSet());
    }

    @d
    public static final List<Double> asList(@d double[] asList) {
        Intrinsics.checkParameterIsNotNull(asList, "$this$asList");
        return new ArraysKt___ArraysJvmKt$asList$6(asList);
    }

    public static final int binarySearch(@d float[] binarySearch, float f2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(binarySearch, "$this$binarySearch");
        return Arrays.binarySearch(binarySearch, i2, i3, f2);
    }

    public static /* synthetic */ int binarySearch$default(float[] fArr, float f2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = fArr.length;
        }
        return binarySearch(fArr, f2, i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final boolean contentEquals(@d double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int contentHashCode(@d double[] dArr) {
        return Arrays.hashCode(dArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String contentToString(@d double[] dArr) {
        String arrays = Arrays.toString(dArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final double[] copyInto(@d double[] copyInto, @d double[] destination, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(copyInto, "$this$copyInto");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        System.arraycopy(copyInto, i3, destination, i2, i4 - i3);
        return destination;
    }

    public static /* synthetic */ double[] copyInto$default(double[] dArr, double[] dArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = dArr.length;
        }
        return copyInto(dArr, dArr2, i2, i3, i4);
    }

    @InlineOnly
    private static final double[] copyOf(@d double[] dArr) {
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @d
    @PublishedApi
    public static int[] copyOfRange(@d int[] copyOfRangeImpl, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(copyOfRangeImpl, "$this$copyOfRangeImpl");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, copyOfRangeImpl.length);
        int[] copyOfRange = Arrays.copyOfRange(copyOfRangeImpl, i2, i3);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @InlineOnly
    private static final double elementAt(@d double[] dArr, int i2) {
        return dArr[i2];
    }

    public static final void fill(@d double[] fill, double d2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(fill, "$this$fill");
        Arrays.fill(fill, i2, i3, d2);
    }

    public static /* synthetic */ void fill$default(double[] dArr, double d2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = dArr.length;
        }
        fill(dArr, d2, i2, i3);
    }

    public static final void sort(@d char[] sort) {
        Intrinsics.checkParameterIsNotNull(sort, "$this$sort");
        if (sort.length > 1) {
            Arrays.sort(sort);
        }
    }

    public static /* synthetic */ void sort$default(double[] dArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = dArr.length;
        }
        sort(dArr, i2, i3);
    }

    @d
    public static final SortedSet<Double> toSortedSet(@d double[] toSortedSet) {
        Intrinsics.checkParameterIsNotNull(toSortedSet, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(toSortedSet, new TreeSet());
    }

    @d
    public static final Integer[] toTypedArray(@d int[] toTypedArray) {
        Intrinsics.checkParameterIsNotNull(toTypedArray, "$this$toTypedArray");
        Integer[] numArr = new Integer[toTypedArray.length];
        int length = toTypedArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            numArr[i2] = Integer.valueOf(toTypedArray[i2]);
        }
        return numArr;
    }

    @d
    public static final List<Boolean> asList(@d boolean[] asList) {
        Intrinsics.checkParameterIsNotNull(asList, "$this$asList");
        return new ArraysKt___ArraysJvmKt$asList$7(asList);
    }

    public static final int binarySearch(@d double[] binarySearch, double d2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(binarySearch, "$this$binarySearch");
        return Arrays.binarySearch(binarySearch, i2, i3, d2);
    }

    public static /* synthetic */ int binarySearch$default(double[] dArr, double d2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = dArr.length;
        }
        return binarySearch(dArr, d2, i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final boolean contentEquals(@d boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int contentHashCode(@d boolean[] zArr) {
        return Arrays.hashCode(zArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String contentToString(@d boolean[] zArr) {
        String arrays = Arrays.toString(zArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final boolean[] copyInto(@d boolean[] copyInto, @d boolean[] destination, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(copyInto, "$this$copyInto");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        System.arraycopy(copyInto, i3, destination, i2, i4 - i3);
        return destination;
    }

    public static /* synthetic */ boolean[] copyInto$default(boolean[] zArr, boolean[] zArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = zArr.length;
        }
        return copyInto(zArr, zArr2, i2, i3, i4);
    }

    @InlineOnly
    private static final boolean[] copyOf(@d boolean[] zArr) {
        boolean[] copyOf = Arrays.copyOf(zArr, zArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @InlineOnly
    private static final boolean elementAt(@d boolean[] zArr, int i2) {
        return zArr[i2];
    }

    public static final void fill(@d boolean[] fill, boolean z, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(fill, "$this$fill");
        Arrays.fill(fill, i2, i3, z);
    }

    public static /* synthetic */ void fill$default(boolean[] zArr, boolean z, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = zArr.length;
        }
        fill(zArr, z, i2, i3);
    }

    @InlineOnly
    private static final <T extends Comparable<? super T>> void sort(@d T[] tArr) {
        if (tArr == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        sort((Object[]) tArr);
    }

    public static /* synthetic */ void sort$default(char[] cArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = cArr.length;
        }
        sort(cArr, i2, i3);
    }

    @d
    public static final SortedSet<Boolean> toSortedSet(@d boolean[] toSortedSet) {
        Intrinsics.checkParameterIsNotNull(toSortedSet, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(toSortedSet, new TreeSet());
    }

    @d
    public static final List<Character> asList(@d char[] asList) {
        Intrinsics.checkParameterIsNotNull(asList, "$this$asList");
        return new ArraysKt___ArraysJvmKt$asList$8(asList);
    }

    public static final int binarySearch(@d char[] binarySearch, char c2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(binarySearch, "$this$binarySearch");
        return Arrays.binarySearch(binarySearch, i2, i3, c2);
    }

    public static /* synthetic */ int binarySearch$default(char[] cArr, char c2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = cArr.length;
        }
        return binarySearch(cArr, c2, i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final boolean contentEquals(@d char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int contentHashCode(@d char[] cArr) {
        return Arrays.hashCode(cArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String contentToString(@d char[] cArr) {
        String arrays = Arrays.toString(cArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final char[] copyInto(@d char[] copyInto, @d char[] destination, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(copyInto, "$this$copyInto");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        System.arraycopy(copyInto, i3, destination, i2, i4 - i3);
        return destination;
    }

    public static /* synthetic */ char[] copyInto$default(char[] cArr, char[] cArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = cArr.length;
        }
        return copyInto(cArr, cArr2, i2, i3, i4);
    }

    @InlineOnly
    private static final char[] copyOf(@d char[] cArr) {
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @d
    @PublishedApi
    public static long[] copyOfRange(@d long[] copyOfRangeImpl, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(copyOfRangeImpl, "$this$copyOfRangeImpl");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, copyOfRangeImpl.length);
        long[] copyOfRange = Arrays.copyOfRange(copyOfRangeImpl, i2, i3);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @InlineOnly
    private static final char elementAt(@d char[] cArr, int i2) {
        return cArr[i2];
    }

    public static final void fill(@d char[] fill, char c2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(fill, "$this$fill");
        Arrays.fill(fill, i2, i3, c2);
    }

    public static /* synthetic */ void fill$default(char[] cArr, char c2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = cArr.length;
        }
        fill(cArr, c2, i2, i3);
    }

    @d
    public static short[] plus(@d short[] plus, short s) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        int length = plus.length;
        short[] result = Arrays.copyOf(plus, length + 1);
        result[length] = s;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final <T> void sort(@d T[] sort) {
        Intrinsics.checkParameterIsNotNull(sort, "$this$sort");
        if (sort.length > 1) {
            Arrays.sort(sort);
        }
    }

    @d
    public static final SortedSet<Character> toSortedSet(@d char[] toSortedSet) {
        Intrinsics.checkParameterIsNotNull(toSortedSet, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(toSortedSet, new TreeSet());
    }

    @InlineOnly
    private static final byte[] copyOf(@d byte[] bArr, int i2) {
        byte[] copyOf = Arrays.copyOf(bArr, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    public static final <T> void sort(@d T[] sort, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(sort, "$this$sort");
        Arrays.sort(sort, i2, i3);
    }

    @d
    public static final <T> SortedSet<T> toSortedSet(@d T[] toSortedSet, @d Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(toSortedSet, "$this$toSortedSet");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(toSortedSet, new TreeSet(comparator));
    }

    @d
    public static final Long[] toTypedArray(@d long[] toTypedArray) {
        Intrinsics.checkParameterIsNotNull(toTypedArray, "$this$toTypedArray");
        Long[] lArr = new Long[toTypedArray.length];
        int length = toTypedArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            lArr[i2] = Long.valueOf(toTypedArray[i2]);
        }
        return lArr;
    }

    @InlineOnly
    private static final short[] copyOf(@d short[] sArr, int i2) {
        short[] copyOf = Arrays.copyOf(sArr, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @d
    @PublishedApi
    public static final float[] copyOfRange(@d float[] copyOfRangeImpl, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(copyOfRangeImpl, "$this$copyOfRangeImpl");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, copyOfRangeImpl.length);
        float[] copyOfRange = Arrays.copyOfRange(copyOfRangeImpl, i2, i3);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final short[] copyOfRangeInline(@d short[] sArr, int i2, int i3) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(sArr, i2, i3);
        }
        if (i3 <= sArr.length) {
            short[] copyOfRange = Arrays.copyOfRange(sArr, i2, i3);
            Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + sArr.length);
    }

    public static final void sort(@d byte[] sort, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(sort, "$this$sort");
        Arrays.sort(sort, i2, i3);
    }

    @InlineOnly
    private static final int[] copyOf(@d int[] iArr, int i2) {
        int[] copyOf = Arrays.copyOf(iArr, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    public static final void sort(@d short[] sort, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(sort, "$this$sort");
        Arrays.sort(sort, i2, i3);
    }

    @InlineOnly
    private static final long[] copyOf(@d long[] jArr, int i2) {
        long[] copyOf = Arrays.copyOf(jArr, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @d
    @PublishedApi
    public static final double[] copyOfRange(@d double[] copyOfRangeImpl, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(copyOfRangeImpl, "$this$copyOfRangeImpl");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, copyOfRangeImpl.length);
        double[] copyOfRange = Arrays.copyOfRange(copyOfRangeImpl, i2, i3);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @d
    public static int[] plus(@d int[] plus, int i2) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        int length = plus.length;
        int[] result = Arrays.copyOf(plus, length + 1);
        result[length] = i2;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final void sort(@d int[] sort, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(sort, "$this$sort");
        Arrays.sort(sort, i2, i3);
    }

    @d
    public static final Float[] toTypedArray(@d float[] toTypedArray) {
        Intrinsics.checkParameterIsNotNull(toTypedArray, "$this$toTypedArray");
        Float[] fArr = new Float[toTypedArray.length];
        int length = toTypedArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            fArr[i2] = Float.valueOf(toTypedArray[i2]);
        }
        return fArr;
    }

    @InlineOnly
    private static final float[] copyOf(@d float[] fArr, int i2) {
        float[] copyOf = Arrays.copyOf(fArr, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    public static final void sort(@d long[] sort, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(sort, "$this$sort");
        Arrays.sort(sort, i2, i3);
    }

    @InlineOnly
    private static final double[] copyOf(@d double[] dArr, int i2) {
        double[] copyOf = Arrays.copyOf(dArr, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @d
    @PublishedApi
    public static final boolean[] copyOfRange(@d boolean[] copyOfRangeImpl, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(copyOfRangeImpl, "$this$copyOfRangeImpl");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, copyOfRangeImpl.length);
        boolean[] copyOfRange = Arrays.copyOfRange(copyOfRangeImpl, i2, i3);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static final void sort(@d float[] sort, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(sort, "$this$sort");
        Arrays.sort(sort, i2, i3);
    }

    @InlineOnly
    private static final boolean[] copyOf(@d boolean[] zArr, int i2) {
        boolean[] copyOf = Arrays.copyOf(zArr, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final int[] copyOfRangeInline(@d int[] iArr, int i2, int i3) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(iArr, i2, i3);
        }
        if (i3 <= iArr.length) {
            int[] copyOfRange = Arrays.copyOfRange(iArr, i2, i3);
            Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + iArr.length);
    }

    public static final void sort(@d double[] sort, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(sort, "$this$sort");
        Arrays.sort(sort, i2, i3);
    }

    @d
    public static final Double[] toTypedArray(@d double[] toTypedArray) {
        Intrinsics.checkParameterIsNotNull(toTypedArray, "$this$toTypedArray");
        Double[] dArr = new Double[toTypedArray.length];
        int length = toTypedArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            dArr[i2] = Double.valueOf(toTypedArray[i2]);
        }
        return dArr;
    }

    @InlineOnly
    private static final char[] copyOf(@d char[] cArr, int i2) {
        char[] copyOf = Arrays.copyOf(cArr, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @d
    @PublishedApi
    public static final char[] copyOfRange(@d char[] copyOfRangeImpl, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(copyOfRangeImpl, "$this$copyOfRangeImpl");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, copyOfRangeImpl.length);
        char[] copyOfRange = Arrays.copyOfRange(copyOfRangeImpl, i2, i3);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @d
    public static long[] plus(@d long[] plus, long j2) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        int length = plus.length;
        long[] result = Arrays.copyOf(plus, length + 1);
        result[length] = j2;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final void sort(@d char[] sort, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(sort, "$this$sort");
        Arrays.sort(sort, i2, i3);
    }

    @InlineOnly
    private static final <T> T[] copyOf(@d T[] tArr, int i2) {
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i2);
        Intrinsics.checkExpressionValueIsNotNull(tArr2, "java.util.Arrays.copyOf(this, newSize)");
        return tArr2;
    }

    @d
    public static final Boolean[] toTypedArray(@d boolean[] toTypedArray) {
        Intrinsics.checkParameterIsNotNull(toTypedArray, "$this$toTypedArray");
        Boolean[] boolArr = new Boolean[toTypedArray.length];
        int length = toTypedArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            boolArr[i2] = Boolean.valueOf(toTypedArray[i2]);
        }
        return boolArr;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final long[] copyOfRangeInline(@d long[] jArr, int i2, int i3) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(jArr, i2, i3);
        }
        if (i3 <= jArr.length) {
            long[] copyOfRange = Arrays.copyOfRange(jArr, i2, i3);
            Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + jArr.length);
    }

    @d
    public static final float[] plus(@d float[] plus, float f2) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        int length = plus.length;
        float[] result = Arrays.copyOf(plus, length + 1);
        result[length] = f2;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @d
    public static final Character[] toTypedArray(@d char[] toTypedArray) {
        Intrinsics.checkParameterIsNotNull(toTypedArray, "$this$toTypedArray");
        Character[] chArr = new Character[toTypedArray.length];
        int length = toTypedArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            chArr[i2] = Character.valueOf(toTypedArray[i2]);
        }
        return chArr;
    }

    @d
    public static final double[] plus(@d double[] plus, double d2) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        int length = plus.length;
        double[] result = Arrays.copyOf(plus, length + 1);
        result[length] = d2;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final float[] copyOfRangeInline(@d float[] fArr, int i2, int i3) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(fArr, i2, i3);
        }
        if (i3 <= fArr.length) {
            float[] copyOfRange = Arrays.copyOfRange(fArr, i2, i3);
            Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + fArr.length);
    }

    @d
    public static final boolean[] plus(@d boolean[] plus, boolean z) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        int length = plus.length;
        boolean[] result = Arrays.copyOf(plus, length + 1);
        result[length] = z;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final double[] copyOfRangeInline(@d double[] dArr, int i2, int i3) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(dArr, i2, i3);
        }
        if (i3 <= dArr.length) {
            double[] copyOfRange = Arrays.copyOfRange(dArr, i2, i3);
            Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + dArr.length);
    }

    @d
    public static final char[] plus(@d char[] plus, char c2) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        int length = plus.length;
        char[] result = Arrays.copyOf(plus, length + 1);
        result[length] = c2;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final boolean[] copyOfRangeInline(@d boolean[] zArr, int i2, int i3) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(zArr, i2, i3);
        }
        if (i3 <= zArr.length) {
            boolean[] copyOfRange = Arrays.copyOfRange(zArr, i2, i3);
            Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + zArr.length);
    }

    @d
    public static final <T> T[] plus(@d T[] plus, @d Collection<? extends T> elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        T[] result = (T[]) Arrays.copyOf(plus, elements.size() + length);
        Iterator<? extends T> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next();
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final char[] copyOfRangeInline(@d char[] cArr, int i2, int i3) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(cArr, i2, i3);
        }
        if (i3 <= cArr.length) {
            char[] copyOfRange = Arrays.copyOfRange(cArr, i2, i3);
            Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + cArr.length);
    }

    @d
    public static final byte[] plus(@d byte[] plus, @d Collection<Byte> elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        byte[] result = Arrays.copyOf(plus, elements.size() + length);
        Iterator<Byte> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().byteValue();
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @d
    public static final short[] plus(@d short[] plus, @d Collection<Short> elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        short[] result = Arrays.copyOf(plus, elements.size() + length);
        Iterator<Short> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().shortValue();
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @d
    public static final int[] plus(@d int[] plus, @d Collection<Integer> elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        int[] result = Arrays.copyOf(plus, elements.size() + length);
        Iterator<Integer> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().intValue();
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @d
    public static final long[] plus(@d long[] plus, @d Collection<Long> elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        long[] result = Arrays.copyOf(plus, elements.size() + length);
        Iterator<Long> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().longValue();
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @d
    public static final float[] plus(@d float[] plus, @d Collection<Float> elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        float[] result = Arrays.copyOf(plus, elements.size() + length);
        Iterator<Float> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().floatValue();
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @d
    public static final double[] plus(@d double[] plus, @d Collection<Double> elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        double[] result = Arrays.copyOf(plus, elements.size() + length);
        Iterator<Double> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().doubleValue();
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @d
    public static final boolean[] plus(@d boolean[] plus, @d Collection<Boolean> elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        boolean[] result = Arrays.copyOf(plus, elements.size() + length);
        Iterator<Boolean> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().booleanValue();
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @d
    public static final char[] plus(@d char[] plus, @d Collection<Character> elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        char[] result = Arrays.copyOf(plus, elements.size() + length);
        Iterator<Character> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().charValue();
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @d
    public static final <T> T[] plus(@d T[] plus, @d T[] elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        int length2 = elements.length;
        T[] result = (T[]) Arrays.copyOf(plus, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @d
    public static byte[] plus(@d byte[] plus, @d byte[] elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        int length2 = elements.length;
        byte[] result = Arrays.copyOf(plus, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @d
    public static short[] plus(@d short[] plus, @d short[] elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        int length2 = elements.length;
        short[] result = Arrays.copyOf(plus, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @d
    public static int[] plus(@d int[] plus, @d int[] elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        int length2 = elements.length;
        int[] result = Arrays.copyOf(plus, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @d
    public static long[] plus(@d long[] plus, @d long[] elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        int length2 = elements.length;
        long[] result = Arrays.copyOf(plus, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @d
    public static final float[] plus(@d float[] plus, @d float[] elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        int length2 = elements.length;
        float[] result = Arrays.copyOf(plus, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @d
    public static final double[] plus(@d double[] plus, @d double[] elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        int length2 = elements.length;
        double[] result = Arrays.copyOf(plus, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @d
    public static final boolean[] plus(@d boolean[] plus, @d boolean[] elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        int length2 = elements.length;
        boolean[] result = Arrays.copyOf(plus, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @d
    public static final char[] plus(@d char[] plus, @d char[] elements) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        int length = plus.length;
        int length2 = elements.length;
        char[] result = Arrays.copyOf(plus, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }
}
