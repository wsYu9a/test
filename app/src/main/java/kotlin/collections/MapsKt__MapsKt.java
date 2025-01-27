package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import f.b.a.e;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.BuilderInference;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010&\n\u0002\b\n\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0002\b\b\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\u001a%\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001aQ\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\b\u0010\t\u001a(\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0087\b¢\u0006\u0004\b\b\u0010\u0004\u001a(\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0087\b¢\u0006\u0004\b\u000b\u0010\u0004\u001aQ\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u000b\u0010\t\u001a8\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0087\b¢\u0006\u0004\b\u000e\u0010\u000f\u001aa\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u000e\u0010\u0010\u001a8\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0012\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0087\b¢\u0006\u0004\b\u0013\u0010\u0014\u001aa\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0012\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0013\u0010\u0015\u001a\\\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012%\b\u0001\u0010\u0019\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u0018H\u0087\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001ad\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u001d\u001a\u00020\u001c2%\b\u0001\u0010\u0019\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u0018H\u0087\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u001a\u0010\u001e\u001a.\u0010 \u001a\u00020\u001f\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\b¢\u0006\u0004\b \u0010!\u001aA\u0010\"\u001a\u00020\u001f\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\b\"\u0010!\u001a:\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0002H\u0087\b¢\u0006\u0004\b#\u0010$\u001a>\u0010)\u001a\u00028\u0001\"\u0014\b\u0000\u0010%*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002*\u00028\u0001\"\u0004\b\u0001\u0010&*\u00028\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'H\u0087\b¢\u0006\u0004\b)\u0010*\u001a;\u0010-\u001a\u00020\u001f\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b+\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010,\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b-\u0010.\u001a=\u0010/\u001a\u0004\u0018\u00018\u0001\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b+\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010,\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b/\u00100\u001a<\u00102\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\u0006\u0010,\u001a\u00028\u00002\u0006\u00101\u001a\u00028\u0001H\u0087\n¢\u0006\u0004\b2\u00103\u001a3\u00104\u001a\u00020\u001f\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b+*\u000e\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0002\b\u00030\u00022\u0006\u0010,\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b4\u0010.\u001a9\u00105\u001a\u00020\u001f\"\u0004\b\u0000\u0010\u0000\"\t\b\u0001\u0010\u0001¢\u0006\u0002\b+*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u00101\u001a\u00028\u0001H\u0087\b¢\u0006\u0004\b5\u0010.\u001a=\u00106\u001a\u0004\u0018\u00018\u0001\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b+\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\u0006\u0010,\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b6\u00100\u001a,\u00108\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000107H\u0087\n¢\u0006\u0004\b8\u00109\u001a,\u0010:\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000107H\u0087\n¢\u0006\u0004\b:\u00109\u001a8\u0010;\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000107H\u0087\b¢\u0006\u0004\b;\u0010<\u001aB\u0010=\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010,\u001a\u00028\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'H\u0087\b¢\u0006\u0004\b=\u0010>\u001aB\u0010?\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010,\u001a\u00028\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'H\u0080\b¢\u0006\u0004\b?\u0010>\u001a3\u0010@\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010,\u001a\u00028\u0000H\u0007¢\u0006\u0004\b@\u00100\u001aB\u0010A\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\u0006\u0010,\u001a\u00028\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'H\u0086\b¢\u0006\u0004\bA\u0010>\u001a@\u0010C\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001070B\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\n¢\u0006\u0004\bC\u0010D\u001a>\u0010C\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010F0E\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH\u0087\n¢\u0006\u0004\bG\u0010D\u001av\u0010J\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010&\"\u0018\b\u0003\u0010%*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00020\n*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010H\u001a\u00028\u00032\u001e\u0010I\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000107\u0012\u0004\u0012\u00028\u00020\u0016H\u0086\b¢\u0006\u0004\bJ\u0010K\u001av\u0010L\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010&\"\u0018\b\u0003\u0010%*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0002\u0012\u0006\b\u0000\u0012\u00028\u00010\n*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010H\u001a\u00028\u00032\u001e\u0010I\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000107\u0012\u0004\u0012\u00028\u00020\u0016H\u0086\b¢\u0006\u0004\bL\u0010K\u001aI\u0010M\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u001a\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005¢\u0006\u0004\bM\u0010N\u001aG\u0010M\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060O¢\u0006\u0004\bM\u0010P\u001aG\u0010M\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060Q¢\u0006\u0004\bM\u0010R\u001a`\u0010S\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010&*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010I\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000107\u0012\u0004\u0012\u00028\u00020\u0016H\u0086\b¢\u0006\u0004\bS\u0010T\u001a`\u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010&*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010I\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000107\u0012\u0004\u0012\u00028\u00020\u0016H\u0086\b¢\u0006\u0004\bU\u0010T\u001aN\u0010W\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0\u0016H\u0086\b¢\u0006\u0004\bW\u0010T\u001aN\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u001f0\u0016H\u0086\b¢\u0006\u0004\bX\u0010T\u001ap\u0010Y\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010%*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010H\u001a\u00028\u00022\u001e\u0010V\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000107\u0012\u0004\u0012\u00020\u001f0\u0016H\u0086\b¢\u0006\u0004\bY\u0010K\u001aZ\u0010Z\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010V\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000107\u0012\u0004\u0012\u00020\u001f0\u0016H\u0086\b¢\u0006\u0004\bZ\u0010T\u001ap\u0010[\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010%*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010H\u001a\u00028\u00022\u001e\u0010V\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000107\u0012\u0004\u0012\u00020\u001f0\u0016H\u0086\b¢\u0006\u0004\b[\u0010K\u001aZ\u0010\\\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010V\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000107\u0012\u0004\u0012\u00020\u001f0\u0016H\u0086\b¢\u0006\u0004\b\\\u0010T\u001a;\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060O¢\u0006\u0004\b]\u0010^\u001aQ\u0010]\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010%*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060O2\u0006\u0010H\u001a\u00028\u0002¢\u0006\u0004\b]\u0010_\u001a=\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005¢\u0006\u0004\b]\u0010\t\u001aS\u0010]\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010%*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u00052\u0006\u0010H\u001a\u00028\u0002¢\u0006\u0004\b]\u0010`\u001a;\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060Q¢\u0006\u0004\b]\u0010a\u001aQ\u0010]\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010%*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060Q2\u0006\u0010H\u001a\u00028\u0002¢\u0006\u0004\b]\u0010b\u001a9\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\b]\u0010$\u001a9\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\bc\u0010$\u001aO\u0010]\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010%*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010H\u001a\u00028\u0002H\u0007¢\u0006\u0004\b]\u0010d\u001aN\u0010f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0086\u0002¢\u0006\u0004\bf\u0010g\u001aT\u0010f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060OH\u0086\u0002¢\u0006\u0004\bf\u0010h\u001aV\u0010f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005H\u0086\u0002¢\u0006\u0004\bf\u0010i\u001aT\u0010f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060QH\u0086\u0002¢\u0006\u0004\bf\u0010j\u001aP\u0010f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0014\u0010k\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\u0002¢\u0006\u0004\bf\u0010d\u001aD\u0010l\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0087\n¢\u0006\u0004\bl\u0010m\u001aJ\u0010l\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060OH\u0087\n¢\u0006\u0004\bl\u0010P\u001aL\u0010l\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u001a\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005H\u0087\n¢\u0006\u0004\bl\u0010N\u001aJ\u0010l\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060QH\u0087\n¢\u0006\u0004\bl\u0010R\u001aD\u0010l\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u0012\u0010k\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\n¢\u0006\u0004\bl\u0010n\u001aB\u0010o\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010,\u001a\u00028\u0000H\u0087\u0002¢\u0006\u0004\bo\u0010p\u001aH\u0010o\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00000OH\u0087\u0002¢\u0006\u0004\bo\u0010h\u001aJ\u0010o\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u000e\u0010q\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H\u0087\u0002¢\u0006\u0004\bo\u0010r\u001aH\u0010o\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00000QH\u0087\u0002¢\u0006\u0004\bo\u0010j\u001a4\u0010s\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\u0006\u0010,\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\bs\u0010t\u001a:\u0010s\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\f\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00000OH\u0087\n¢\u0006\u0004\bs\u0010P\u001a<\u0010s\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\u000e\u0010q\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H\u0087\n¢\u0006\u0004\bs\u0010u\u001a:\u0010s\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\f\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00000QH\u0087\n¢\u0006\u0004\bs\u0010R\u001a7\u0010v\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0000¢\u0006\u0004\bv\u0010$¨\u0006w"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "emptyMap", "()Ljava/util/Map;", "", "Lkotlin/Pair;", "pairs", "mapOf", "([Lkotlin/Pair;)Ljava/util/Map;", "", "mutableMapOf", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "hashMapOf", "()Ljava/util/HashMap;", "([Lkotlin/Pair;)Ljava/util/HashMap;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "linkedMapOf", "()Ljava/util/LinkedHashMap;", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "buildMap", "(Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "", "capacity", "(ILkotlin/jvm/functions/Function1;)Ljava/util/Map;", "", "isNotEmpty", "(Ljava/util/Map;)Z", "isNullOrEmpty", "orEmpty", "(Ljava/util/Map;)Ljava/util/Map;", "M", "R", "Lkotlin/Function0;", "defaultValue", "ifEmpty", "(Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/internal/OnlyInputTypes;", "key", "contains", "(Ljava/util/Map;Ljava/lang/Object;)Z", MonitorConstants.CONNECT_TYPE_GET, "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", Downloads.RequestHeaders.COLUMN_VALUE, "set", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "containsKey", "containsValue", "remove", "", "component1", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "toPair", "(Ljava/util/Map$Entry;)Lkotlin/Pair;", "getOrElse", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "getValue", "getOrPut", "", "iterator", "(Ljava/util/Map;)Ljava/util/Iterator;", "", "", "mutableIterator", "destination", "transform", "mapValuesTo", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "mapKeysTo", "putAll", "(Ljava/util/Map;[Lkotlin/Pair;)V", "", "(Ljava/util/Map;Ljava/lang/Iterable;)V", "Lkotlin/sequences/Sequence;", "(Ljava/util/Map;Lkotlin/sequences/Sequence;)V", "mapValues", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "mapKeys", "predicate", "filterKeys", "filterValues", "filterTo", "filter", "filterNotTo", "filterNot", "toMap", "(Ljava/lang/Iterable;)Ljava/util/Map;", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;)Ljava/util/Map;", "toMutableMap", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "pair", "plus", "(Ljava/util/Map;Lkotlin/Pair;)Ljava/util/Map;", "(Ljava/util/Map;Ljava/lang/Iterable;)Ljava/util/Map;", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", "(Ljava/util/Map;Lkotlin/sequences/Sequence;)Ljava/util/Map;", "map", "plusAssign", "(Ljava/util/Map;Lkotlin/Pair;)V", "(Ljava/util/Map;Ljava/util/Map;)V", "minus", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "minusAssign", "(Ljava/util/Map;Ljava/lang/Object;)V", "(Ljava/util/Map;[Ljava/lang/Object;)V", "optimizeReadOnlyMap", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/collections/MapsKt")
/* loaded from: classes5.dex */
public class MapsKt__MapsKt extends MapsKt__MapsJVMKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final <K, V> Map<K, V> buildMap(@BuilderInference Function1<? super Map<K, V>, Unit> function1) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        function1.invoke(linkedHashMap);
        return linkedHashMap;
    }

    @InlineOnly
    private static final <K, V> K component1(@d Map.Entry<? extends K, ? extends V> component1) {
        Intrinsics.checkParameterIsNotNull(component1, "$this$component1");
        return component1.getKey();
    }

    @InlineOnly
    private static final <K, V> V component2(@d Map.Entry<? extends K, ? extends V> component2) {
        Intrinsics.checkParameterIsNotNull(component2, "$this$component2");
        return component2.getValue();
    }

    @InlineOnly
    private static final <K, V> boolean contains(@d Map<? extends K, ? extends V> contains, K k) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.containsKey(k);
    }

    @InlineOnly
    private static final <K> boolean containsKey(@d Map<? extends K, ?> map, K k) {
        if (map != null) {
            return map.containsKey(k);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    @InlineOnly
    private static final <K, V> boolean containsValue(@d Map<K, ? extends V> map, V v) {
        return map.containsValue(v);
    }

    @d
    public static final <K, V> Map<K, V> emptyMap() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (emptyMap != null) {
            return emptyMap;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    @d
    public static final <K, V> Map<K, V> filter(@d Map<? extends K, ? extends V> filter, @d Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(filter, "$this$filter");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : filter.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @d
    public static final <K, V> Map<K, V> filterKeys(@d Map<? extends K, ? extends V> filterKeys, @d Function1<? super K, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(filterKeys, "$this$filterKeys");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : filterKeys.entrySet()) {
            if (predicate.invoke(entry.getKey()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @d
    public static final <K, V> Map<K, V> filterNot(@d Map<? extends K, ? extends V> filterNot, @d Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(filterNot, "$this$filterNot");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : filterNot.entrySet()) {
            if (!predicate.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @d
    public static final <K, V, M extends Map<? super K, ? super V>> M filterNotTo(@d Map<? extends K, ? extends V> filterNotTo, @d M destination, @d Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(filterNotTo, "$this$filterNotTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : filterNotTo.entrySet()) {
            if (!predicate.invoke(entry).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }

    @d
    public static final <K, V, M extends Map<? super K, ? super V>> M filterTo(@d Map<? extends K, ? extends V> filterTo, @d M destination, @d Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(filterTo, "$this$filterTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : filterTo.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }

    @d
    public static final <K, V> Map<K, V> filterValues(@d Map<? extends K, ? extends V> filterValues, @d Function1<? super V, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(filterValues, "$this$filterValues");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : filterValues.entrySet()) {
            if (predicate.invoke(entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @InlineOnly
    private static final <K, V> V get(@d Map<? extends K, ? extends V> get, K k) {
        Intrinsics.checkParameterIsNotNull(get, "$this$get");
        return get.get(k);
    }

    @InlineOnly
    private static final <K, V> V getOrElse(@d Map<K, ? extends V> map, K k, Function0<? extends V> function0) {
        V v = map.get(k);
        return v != null ? v : function0.invoke();
    }

    public static final <K, V> V getOrElseNullable(@d Map<K, ? extends V> getOrElseNullable, K k, @d Function0<? extends V> defaultValue) {
        Intrinsics.checkParameterIsNotNull(getOrElseNullable, "$this$getOrElseNullable");
        Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        V v = getOrElseNullable.get(k);
        return (v != null || getOrElseNullable.containsKey(k)) ? v : defaultValue.invoke();
    }

    public static final <K, V> V getOrPut(@d Map<K, V> getOrPut, K k, @d Function0<? extends V> defaultValue) {
        Intrinsics.checkParameterIsNotNull(getOrPut, "$this$getOrPut");
        Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        V v = getOrPut.get(k);
        if (v != null) {
            return v;
        }
        V invoke = defaultValue.invoke();
        getOrPut.put(k, invoke);
        return invoke;
    }

    @SinceKotlin(version = "1.1")
    public static final <K, V> V getValue(@d Map<K, ? extends V> getValue, K k) {
        Intrinsics.checkParameterIsNotNull(getValue, "$this$getValue");
        return (V) MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(getValue, k);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> HashMap<K, V> hashMapOf() {
        return new HashMap<>();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final Object ifEmpty(Map map, Function0 function0) {
        return map.isEmpty() ? function0.invoke() : map;
    }

    @InlineOnly
    private static final <K, V> boolean isNotEmpty(@d Map<? extends K, ? extends V> map) {
        return !map.isEmpty();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <K, V> boolean isNullOrEmpty(@e Map<? extends K, ? extends V> map) {
        return map == null || map.isEmpty();
    }

    @InlineOnly
    private static final <K, V> Iterator<Map.Entry<K, V>> iterator(@d Map<? extends K, ? extends V> iterator) {
        Intrinsics.checkParameterIsNotNull(iterator, "$this$iterator");
        return iterator.entrySet().iterator();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> LinkedHashMap<K, V> linkedMapOf() {
        return new LinkedHashMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @d
    public static final <K, V, R> Map<R, V> mapKeys(@d Map<? extends K, ? extends V> mapKeys, @d Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        int mapCapacity;
        Intrinsics.checkParameterIsNotNull(mapKeys, "$this$mapKeys");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(mapKeys.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it = mapKeys.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(transform.invoke(entry), entry.getValue());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @d
    public static final <K, V, R, M extends Map<? super R, ? super V>> M mapKeysTo(@d Map<? extends K, ? extends V> mapKeysTo, @d M destination, @d Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(mapKeysTo, "$this$mapKeysTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        Iterator<T> it = mapKeysTo.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            destination.put(transform.invoke(entry), entry.getValue());
        }
        return destination;
    }

    @d
    public static final <K, V> Map<K, V> mapOf(@d Pair<? extends K, ? extends V>... pairs) {
        int mapCapacity;
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        if (pairs.length <= 0) {
            return emptyMap();
        }
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(pairs.length);
        return toMap(pairs, new LinkedHashMap(mapCapacity));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @d
    public static final <K, V, R> Map<K, R> mapValues(@d Map<? extends K, ? extends V> mapValues, @d Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        int mapCapacity;
        Intrinsics.checkParameterIsNotNull(mapValues, "$this$mapValues");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(mapValues.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it = mapValues.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(entry.getKey(), transform.invoke(entry));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @d
    public static final <K, V, R, M extends Map<? super K, ? super R>> M mapValuesTo(@d Map<? extends K, ? extends V> mapValuesTo, @d M destination, @d Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(mapValuesTo, "$this$mapValuesTo");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        Iterator<T> it = mapValuesTo.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            destination.put(entry.getKey(), transform.invoke(entry));
        }
        return destination;
    }

    @d
    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> minus(@d Map<? extends K, ? extends V> minus, K k) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        Map mutableMap = toMutableMap(minus);
        mutableMap.remove(k);
        return optimizeReadOnlyMap(mutableMap);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void minusAssign(@d Map<K, V> minusAssign, K k) {
        Intrinsics.checkParameterIsNotNull(minusAssign, "$this$minusAssign");
        minusAssign.remove(k);
    }

    @InlineOnly
    @JvmName(name = "mutableIterator")
    private static final <K, V> Iterator<Map.Entry<K, V>> mutableIterator(@d Map<K, V> iterator) {
        Intrinsics.checkParameterIsNotNull(iterator, "$this$iterator");
        return iterator.entrySet().iterator();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> Map<K, V> mutableMapOf() {
        return new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @d
    public static final <K, V> Map<K, V> optimizeReadOnlyMap(@d Map<K, ? extends V> optimizeReadOnlyMap) {
        Intrinsics.checkParameterIsNotNull(optimizeReadOnlyMap, "$this$optimizeReadOnlyMap");
        int size = optimizeReadOnlyMap.size();
        return size != 0 ? size != 1 ? optimizeReadOnlyMap : MapsKt__MapsJVMKt.toSingletonMap(optimizeReadOnlyMap) : emptyMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <K, V> Map<K, V> orEmpty(@e Map<K, ? extends V> map) {
        return map != 0 ? map : emptyMap();
    }

    @d
    public static final <K, V> Map<K, V> plus(@d Map<? extends K, ? extends V> plus, @d Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(pair, "pair");
        if (plus.isEmpty()) {
            return MapsKt__MapsJVMKt.mapOf(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(plus);
        linkedHashMap.put(pair.getFirst(), pair.getSecond());
        return linkedHashMap;
    }

    @InlineOnly
    private static final <K, V> void plusAssign(@d Map<? super K, ? super V> plusAssign, Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkParameterIsNotNull(plusAssign, "$this$plusAssign");
        plusAssign.put(pair.getFirst(), pair.getSecond());
    }

    public static final <K, V> void putAll(@d Map<? super K, ? super V> putAll, @d Pair<? extends K, ? extends V>[] pairs) {
        Intrinsics.checkParameterIsNotNull(putAll, "$this$putAll");
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            putAll.put(pair.component1(), pair.component2());
        }
    }

    @InlineOnly
    private static final <K, V> V remove(@d Map<? extends K, V> map, K k) {
        if (map != null) {
            return (V) TypeIntrinsics.asMutableMap(map).remove(k);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    @InlineOnly
    private static final <K, V> void set(@d Map<K, V> set, K k, V v) {
        Intrinsics.checkParameterIsNotNull(set, "$this$set");
        set.put(k, v);
    }

    @d
    public static <K, V> Map<K, V> toMap(@d Iterable<? extends Pair<? extends K, ? extends V>> toMap) {
        int mapCapacity;
        Intrinsics.checkParameterIsNotNull(toMap, "$this$toMap");
        if (!(toMap instanceof Collection)) {
            return optimizeReadOnlyMap(toMap(toMap, new LinkedHashMap()));
        }
        Collection collection = (Collection) toMap;
        int size = collection.size();
        if (size == 0) {
            return emptyMap();
        }
        if (size == 1) {
            return MapsKt__MapsJVMKt.mapOf(toMap instanceof List ? (Pair<? extends K, ? extends V>) ((List) toMap).get(0) : toMap.iterator().next());
        }
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collection.size());
        return toMap(toMap, new LinkedHashMap(mapCapacity));
    }

    @d
    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> toMutableMap(@d Map<? extends K, ? extends V> toMutableMap) {
        Intrinsics.checkParameterIsNotNull(toMutableMap, "$this$toMutableMap");
        return new LinkedHashMap(toMutableMap);
    }

    @InlineOnly
    private static final <K, V> Pair<K, V> toPair(@d Map.Entry<? extends K, ? extends V> entry) {
        return new Pair<>(entry.getKey(), entry.getValue());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final <K, V> Map<K, V> buildMap(int i2, @BuilderInference Function1<? super Map<K, V>, Unit> function1) {
        int mapCapacity;
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(i2);
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        function1.invoke(linkedHashMap);
        return linkedHashMap;
    }

    @d
    public static final <K, V> HashMap<K, V> hashMapOf(@d Pair<? extends K, ? extends V>... pairs) {
        int mapCapacity;
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(pairs.length);
        HashMap<K, V> hashMap = new HashMap<>(mapCapacity);
        putAll(hashMap, pairs);
        return hashMap;
    }

    @d
    public static final <K, V> LinkedHashMap<K, V> linkedMapOf(@d Pair<? extends K, ? extends V>... pairs) {
        int mapCapacity;
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(pairs.length);
        return (LinkedHashMap) toMap(pairs, new LinkedHashMap(mapCapacity));
    }

    @InlineOnly
    private static final <K, V> Map<K, V> mapOf() {
        return emptyMap();
    }

    @d
    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> minus(@d Map<? extends K, ? extends V> minus, @d Iterable<? extends K> keys) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        Intrinsics.checkParameterIsNotNull(keys, "keys");
        Map mutableMap = toMutableMap(minus);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableMap.keySet(), keys);
        return optimizeReadOnlyMap(mutableMap);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void minusAssign(@d Map<K, V> minusAssign, Iterable<? extends K> iterable) {
        Intrinsics.checkParameterIsNotNull(minusAssign, "$this$minusAssign");
        CollectionsKt__MutableCollectionsKt.removeAll(minusAssign.keySet(), iterable);
    }

    @d
    public static final <K, V> Map<K, V> mutableMapOf(@d Pair<? extends K, ? extends V>... pairs) {
        int mapCapacity;
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(pairs.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        putAll(linkedHashMap, pairs);
        return linkedHashMap;
    }

    @d
    public static final <K, V> Map<K, V> plus(@d Map<? extends K, ? extends V> plus, @d Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Map<K, V> map;
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        if (plus.isEmpty()) {
            map = toMap(pairs);
            return map;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(plus);
        putAll(linkedHashMap, pairs);
        return linkedHashMap;
    }

    @InlineOnly
    private static final <K, V> void plusAssign(@d Map<? super K, ? super V> plusAssign, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.checkParameterIsNotNull(plusAssign, "$this$plusAssign");
        putAll(plusAssign, iterable);
    }

    @d
    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> minus(@d Map<? extends K, ? extends V> minus, @d K[] keys) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        Intrinsics.checkParameterIsNotNull(keys, "keys");
        Map mutableMap = toMutableMap(minus);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableMap.keySet(), keys);
        return optimizeReadOnlyMap(mutableMap);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void minusAssign(@d Map<K, V> minusAssign, K[] kArr) {
        Intrinsics.checkParameterIsNotNull(minusAssign, "$this$minusAssign");
        CollectionsKt__MutableCollectionsKt.removeAll(minusAssign.keySet(), kArr);
    }

    @d
    public static final <K, V> Map<K, V> plus(@d Map<? extends K, ? extends V> plus, @d Pair<? extends K, ? extends V>[] pairs) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        if (plus.isEmpty()) {
            return toMap(pairs);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(plus);
        putAll(linkedHashMap, pairs);
        return linkedHashMap;
    }

    @InlineOnly
    private static final <K, V> void plusAssign(@d Map<? super K, ? super V> plusAssign, Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(plusAssign, "$this$plusAssign");
        putAll(plusAssign, pairArr);
    }

    public static final <K, V> void putAll(@d Map<? super K, ? super V> putAll, @d Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkParameterIsNotNull(putAll, "$this$putAll");
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            putAll.put(pair.component1(), pair.component2());
        }
    }

    @d
    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> minus(@d Map<? extends K, ? extends V> minus, @d Sequence<? extends K> keys) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        Intrinsics.checkParameterIsNotNull(keys, "keys");
        Map mutableMap = toMutableMap(minus);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableMap.keySet(), keys);
        return optimizeReadOnlyMap(mutableMap);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void minusAssign(@d Map<K, V> minusAssign, Sequence<? extends K> sequence) {
        Intrinsics.checkParameterIsNotNull(minusAssign, "$this$minusAssign");
        CollectionsKt__MutableCollectionsKt.removeAll(minusAssign.keySet(), sequence);
    }

    @d
    public static final <K, V> Map<K, V> plus(@d Map<? extends K, ? extends V> plus, @d Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(plus);
        putAll(linkedHashMap, pairs);
        return optimizeReadOnlyMap(linkedHashMap);
    }

    @InlineOnly
    private static final <K, V> void plusAssign(@d Map<? super K, ? super V> plusAssign, Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        Intrinsics.checkParameterIsNotNull(plusAssign, "$this$plusAssign");
        putAll(plusAssign, sequence);
    }

    @d
    public static final <K, V> Map<K, V> plus(@d Map<? extends K, ? extends V> plus, @d Map<? extends K, ? extends V> map) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(map, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(plus);
        linkedHashMap.putAll(map);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <K, V> void plusAssign(@d Map<? super K, ? super V> plusAssign, Map<K, ? extends V> map) {
        Intrinsics.checkParameterIsNotNull(plusAssign, "$this$plusAssign");
        plusAssign.putAll(map);
    }

    public static final <K, V> void putAll(@d Map<? super K, ? super V> putAll, @d Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkParameterIsNotNull(putAll, "$this$putAll");
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            putAll.put(pair.component1(), pair.component2());
        }
    }

    @d
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(@d Iterable<? extends Pair<? extends K, ? extends V>> toMap, @d M destination) {
        Intrinsics.checkParameterIsNotNull(toMap, "$this$toMap");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        putAll(destination, toMap);
        return destination;
    }

    @d
    public static final <K, V> Map<K, V> toMap(@d Pair<? extends K, ? extends V>[] toMap) {
        int mapCapacity;
        Intrinsics.checkParameterIsNotNull(toMap, "$this$toMap");
        int length = toMap.length;
        if (length == 0) {
            return emptyMap();
        }
        if (length != 1) {
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(toMap.length);
            return toMap(toMap, new LinkedHashMap(mapCapacity));
        }
        return MapsKt__MapsJVMKt.mapOf(toMap[0]);
    }

    @d
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(@d Pair<? extends K, ? extends V>[] toMap, @d M destination) {
        Intrinsics.checkParameterIsNotNull(toMap, "$this$toMap");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        putAll(destination, toMap);
        return destination;
    }

    @d
    public static final <K, V> Map<K, V> toMap(@d Sequence<? extends Pair<? extends K, ? extends V>> toMap) {
        Intrinsics.checkParameterIsNotNull(toMap, "$this$toMap");
        return optimizeReadOnlyMap(toMap(toMap, new LinkedHashMap()));
    }

    @d
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(@d Sequence<? extends Pair<? extends K, ? extends V>> toMap, @d M destination) {
        Intrinsics.checkParameterIsNotNull(toMap, "$this$toMap");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        putAll(destination, toMap);
        return destination;
    }

    @d
    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> toMap(@d Map<? extends K, ? extends V> toMap) {
        Intrinsics.checkParameterIsNotNull(toMap, "$this$toMap");
        int size = toMap.size();
        if (size == 0) {
            return emptyMap();
        }
        if (size != 1) {
            return toMutableMap(toMap);
        }
        return MapsKt__MapsJVMKt.toSingletonMap(toMap);
    }

    @d
    @SinceKotlin(version = "1.1")
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(@d Map<? extends K, ? extends V> toMap, @d M destination) {
        Intrinsics.checkParameterIsNotNull(toMap, "$this$toMap");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        destination.putAll(toMap);
        return destination;
    }
}
