package kotlin.ranges;

import androidx.exifinterface.media.ExifInterface;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import f.b.a.e;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.CharProgression;
import kotlin.ranges.IntProgression;
import kotlin.ranges.LongProgression;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u000f\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0005*\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u0014\u0010\u0002\u001a\u00020\b*\u00020\u0007H\u0087\b¢\u0006\u0004\b\u0002\u0010\t\u001a\u001b\u0010\u0002\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0002\u0010\u000b\u001a\u001b\u0010\u0002\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0002\u0010\f\u001a\u001b\u0010\u0002\u001a\u00020\b*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0002\u0010\r\u001a\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u0005*\u00020\u0004H\u0087\b¢\u0006\u0004\b\u000e\u0010\u0010\u001a\u0016\u0010\u000e\u001a\u0004\u0018\u00010\b*\u00020\u0007H\u0087\b¢\u0006\u0004\b\u000e\u0010\u0011\u001a\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000e\u0010\u0012\u001a\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u0005*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000e\u0010\u0013\u001a\u001d\u0010\u000e\u001a\u0004\u0018\u00010\b*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000e\u0010\u0014\u001a\u001e\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0087\n¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001e\u0010\u0017\u001a\u00020\u0016*\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0087\n¢\u0006\u0004\b\u0017\u0010\u0019\u001a\u001e\u0010\u0017\u001a\u00020\u0016*\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0087\n¢\u0006\u0004\b\u0017\u0010\u001a\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0087\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00050\u001b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0087\u0002¢\u0006\u0004\b \u0010\u001f\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020!0\u001b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0087\u0002¢\u0006\u0004\b\"\u0010\u001f\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020#0\u001b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0087\u0002¢\u0006\u0004\b$\u0010\u001f\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020%0\u001b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0087\u0002¢\u0006\u0004\b&\u0010\u001f\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00010\u001b2\u0006\u0010\u001d\u001a\u00020#H\u0087\u0002¢\u0006\u0004\b\u001e\u0010'\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00050\u001b2\u0006\u0010\u001d\u001a\u00020#H\u0087\u0002¢\u0006\u0004\b \u0010'\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020#H\u0087\u0002¢\u0006\u0004\b(\u0010'\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020!0\u001b2\u0006\u0010\u001d\u001a\u00020#H\u0087\u0002¢\u0006\u0004\b\"\u0010'\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020%0\u001b2\u0006\u0010\u001d\u001a\u00020#H\u0087\u0002¢\u0006\u0004\b&\u0010'\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00010\u001b2\u0006\u0010\u001d\u001a\u00020%H\u0087\u0002¢\u0006\u0004\b\u001e\u0010)\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00050\u001b2\u0006\u0010\u001d\u001a\u00020%H\u0087\u0002¢\u0006\u0004\b \u0010)\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020%H\u0087\u0002¢\u0006\u0004\b(\u0010)\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020!0\u001b2\u0006\u0010\u001d\u001a\u00020%H\u0087\u0002¢\u0006\u0004\b\"\u0010)\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020#0\u001b2\u0006\u0010\u001d\u001a\u00020%H\u0087\u0002¢\u0006\u0004\b$\u0010)\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00050\u001b2\u0006\u0010\u001d\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b \u0010*\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b(\u0010*\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020!0\u001b2\u0006\u0010\u001d\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b\"\u0010*\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020#0\u001b2\u0006\u0010\u001d\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b$\u0010*\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020%0\u001b2\u0006\u0010\u001d\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b&\u0010*\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0004\b\u001e\u0010+\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0004\b(\u0010+\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020!0\u001b2\u0006\u0010\u001d\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0004\b\"\u0010+\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020#0\u001b2\u0006\u0010\u001d\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0004\b$\u0010+\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020%0\u001b2\u0006\u0010\u001d\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0004\b&\u0010+\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00010\u001b2\u0006\u0010\u001d\u001a\u00020!H\u0087\u0002¢\u0006\u0004\b\u001e\u0010,\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00050\u001b2\u0006\u0010\u001d\u001a\u00020!H\u0087\u0002¢\u0006\u0004\b \u0010,\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020!H\u0087\u0002¢\u0006\u0004\b(\u0010,\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020#0\u001b2\u0006\u0010\u001d\u001a\u00020!H\u0087\u0002¢\u0006\u0004\b$\u0010,\u001a\"\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020%0\u001b2\u0006\u0010\u001d\u001a\u00020!H\u0087\u0002¢\u0006\u0004\b&\u0010,\u001a\u001c\u0010/\u001a\u00020.*\u00020\u00012\u0006\u0010-\u001a\u00020\u001cH\u0086\u0004¢\u0006\u0004\b/\u00100\u001a\u001c\u0010/\u001a\u000201*\u00020\u00052\u0006\u0010-\u001a\u00020\u001cH\u0086\u0004¢\u0006\u0004\b/\u00102\u001a\u001c\u0010/\u001a\u00020.*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001cH\u0086\u0004¢\u0006\u0004\b/\u00103\u001a\u001c\u0010/\u001a\u00020.*\u00020!2\u0006\u0010-\u001a\u00020\u001cH\u0086\u0004¢\u0006\u0004\b/\u00104\u001a\u001c\u0010/\u001a\u000205*\u00020\b2\u0006\u0010-\u001a\u00020\bH\u0086\u0004¢\u0006\u0004\b/\u00106\u001a\u001c\u0010/\u001a\u00020.*\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004¢\u0006\u0004\b/\u00107\u001a\u001c\u0010/\u001a\u000201*\u00020\u00052\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004¢\u0006\u0004\b/\u00108\u001a\u001c\u0010/\u001a\u00020.*\u00020\u001c2\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004¢\u0006\u0004\b/\u00109\u001a\u001c\u0010/\u001a\u00020.*\u00020!2\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004¢\u0006\u0004\b/\u0010:\u001a\u001c\u0010/\u001a\u000201*\u00020\u00012\u0006\u0010-\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\b/\u0010;\u001a\u001c\u0010/\u001a\u000201*\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\b/\u0010<\u001a\u001c\u0010/\u001a\u000201*\u00020\u001c2\u0006\u0010-\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\b/\u0010=\u001a\u001c\u0010/\u001a\u000201*\u00020!2\u0006\u0010-\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\b/\u0010>\u001a\u001c\u0010/\u001a\u00020.*\u00020\u00012\u0006\u0010-\u001a\u00020!H\u0086\u0004¢\u0006\u0004\b/\u0010?\u001a\u001c\u0010/\u001a\u000201*\u00020\u00052\u0006\u0010-\u001a\u00020!H\u0086\u0004¢\u0006\u0004\b/\u0010@\u001a\u001c\u0010/\u001a\u00020.*\u00020\u001c2\u0006\u0010-\u001a\u00020!H\u0086\u0004¢\u0006\u0004\b/\u0010A\u001a\u001c\u0010/\u001a\u00020.*\u00020!2\u0006\u0010-\u001a\u00020!H\u0086\u0004¢\u0006\u0004\b/\u0010B\u001a\u0011\u0010C\u001a\u00020.*\u00020.¢\u0006\u0004\bC\u0010D\u001a\u0011\u0010C\u001a\u000201*\u000201¢\u0006\u0004\bC\u0010E\u001a\u0011\u0010C\u001a\u000205*\u000205¢\u0006\u0004\bC\u0010F\u001a\u001c\u0010G\u001a\u00020.*\u00020.2\u0006\u0010G\u001a\u00020\u0001H\u0086\u0004¢\u0006\u0004\bG\u0010H\u001a\u001c\u0010G\u001a\u000201*\u0002012\u0006\u0010G\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\bG\u0010I\u001a\u001c\u0010G\u001a\u000205*\u0002052\u0006\u0010G\u001a\u00020\u0001H\u0086\u0004¢\u0006\u0004\bG\u0010J\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u001c*\u00020\u0001H\u0000¢\u0006\u0004\bK\u0010L\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u001c*\u00020\u0005H\u0000¢\u0006\u0004\bK\u0010M\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u001c*\u00020!H\u0000¢\u0006\u0004\bK\u0010N\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u001c*\u00020#H\u0000¢\u0006\u0004\bK\u0010O\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u001c*\u00020%H\u0000¢\u0006\u0004\bK\u0010P\u001a\u0015\u0010Q\u001a\u0004\u0018\u00010\u0001*\u00020\u0005H\u0000¢\u0006\u0004\bQ\u0010R\u001a\u0015\u0010Q\u001a\u0004\u0018\u00010\u0001*\u00020#H\u0000¢\u0006\u0004\bQ\u0010S\u001a\u0015\u0010Q\u001a\u0004\u0018\u00010\u0001*\u00020%H\u0000¢\u0006\u0004\bQ\u0010T\u001a\u0015\u0010U\u001a\u0004\u0018\u00010\u0005*\u00020#H\u0000¢\u0006\u0004\bU\u0010V\u001a\u0015\u0010U\u001a\u0004\u0018\u00010\u0005*\u00020%H\u0000¢\u0006\u0004\bU\u0010W\u001a\u0015\u0010X\u001a\u0004\u0018\u00010!*\u00020\u0001H\u0000¢\u0006\u0004\bX\u0010Y\u001a\u0015\u0010X\u001a\u0004\u0018\u00010!*\u00020\u0005H\u0000¢\u0006\u0004\bX\u0010Z\u001a\u0015\u0010X\u001a\u0004\u0018\u00010!*\u00020#H\u0000¢\u0006\u0004\bX\u0010[\u001a\u0015\u0010X\u001a\u0004\u0018\u00010!*\u00020%H\u0000¢\u0006\u0004\bX\u0010\\\u001a\u001c\u0010]\u001a\u00020\u0000*\u00020\u00012\u0006\u0010-\u001a\u00020\u001cH\u0086\u0004¢\u0006\u0004\b]\u0010^\u001a\u001c\u0010]\u001a\u00020\u0004*\u00020\u00052\u0006\u0010-\u001a\u00020\u001cH\u0086\u0004¢\u0006\u0004\b]\u0010_\u001a\u001c\u0010]\u001a\u00020\u0000*\u00020\u001c2\u0006\u0010-\u001a\u00020\u001cH\u0086\u0004¢\u0006\u0004\b]\u0010`\u001a\u001c\u0010]\u001a\u00020\u0000*\u00020!2\u0006\u0010-\u001a\u00020\u001cH\u0086\u0004¢\u0006\u0004\b]\u0010a\u001a\u001c\u0010]\u001a\u00020\u0007*\u00020\b2\u0006\u0010-\u001a\u00020\bH\u0086\u0004¢\u0006\u0004\b]\u0010b\u001a\u001c\u0010]\u001a\u00020\u0000*\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004¢\u0006\u0004\b]\u0010c\u001a\u001c\u0010]\u001a\u00020\u0004*\u00020\u00052\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004¢\u0006\u0004\b]\u0010d\u001a\u001c\u0010]\u001a\u00020\u0000*\u00020\u001c2\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004¢\u0006\u0004\b]\u0010e\u001a\u001c\u0010]\u001a\u00020\u0000*\u00020!2\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004¢\u0006\u0004\b]\u0010f\u001a\u001c\u0010]\u001a\u00020\u0004*\u00020\u00012\u0006\u0010-\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\b]\u0010g\u001a\u001c\u0010]\u001a\u00020\u0004*\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\b]\u0010h\u001a\u001c\u0010]\u001a\u00020\u0004*\u00020\u001c2\u0006\u0010-\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\b]\u0010i\u001a\u001c\u0010]\u001a\u00020\u0004*\u00020!2\u0006\u0010-\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\b]\u0010j\u001a\u001c\u0010]\u001a\u00020\u0000*\u00020\u00012\u0006\u0010-\u001a\u00020!H\u0086\u0004¢\u0006\u0004\b]\u0010k\u001a\u001c\u0010]\u001a\u00020\u0004*\u00020\u00052\u0006\u0010-\u001a\u00020!H\u0086\u0004¢\u0006\u0004\b]\u0010l\u001a\u001c\u0010]\u001a\u00020\u0000*\u00020\u001c2\u0006\u0010-\u001a\u00020!H\u0086\u0004¢\u0006\u0004\b]\u0010m\u001a\u001c\u0010]\u001a\u00020\u0000*\u00020!2\u0006\u0010-\u001a\u00020!H\u0086\u0004¢\u0006\u0004\b]\u0010n\u001a)\u0010r\u001a\u00028\u0000\"\u000e\b\u0000\u0010p*\b\u0012\u0004\u0012\u00028\u00000o*\u00028\u00002\u0006\u0010q\u001a\u00028\u0000¢\u0006\u0004\br\u0010s\u001a\u0019\u0010r\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010q\u001a\u00020\u001c¢\u0006\u0004\br\u0010t\u001a\u0019\u0010r\u001a\u00020!*\u00020!2\u0006\u0010q\u001a\u00020!¢\u0006\u0004\br\u0010u\u001a\u0019\u0010r\u001a\u00020\u0001*\u00020\u00012\u0006\u0010q\u001a\u00020\u0001¢\u0006\u0004\br\u0010v\u001a\u0019\u0010r\u001a\u00020\u0005*\u00020\u00052\u0006\u0010q\u001a\u00020\u0005¢\u0006\u0004\br\u0010w\u001a\u0019\u0010r\u001a\u00020%*\u00020%2\u0006\u0010q\u001a\u00020%¢\u0006\u0004\br\u0010x\u001a\u0019\u0010r\u001a\u00020#*\u00020#2\u0006\u0010q\u001a\u00020#¢\u0006\u0004\br\u0010y\u001a)\u0010{\u001a\u00028\u0000\"\u000e\b\u0000\u0010p*\b\u0012\u0004\u0012\u00028\u00000o*\u00028\u00002\u0006\u0010z\u001a\u00028\u0000¢\u0006\u0004\b{\u0010s\u001a\u0019\u0010{\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010z\u001a\u00020\u001c¢\u0006\u0004\b{\u0010t\u001a\u0019\u0010{\u001a\u00020!*\u00020!2\u0006\u0010z\u001a\u00020!¢\u0006\u0004\b{\u0010u\u001a\u0019\u0010{\u001a\u00020\u0001*\u00020\u00012\u0006\u0010z\u001a\u00020\u0001¢\u0006\u0004\b{\u0010v\u001a\u0019\u0010{\u001a\u00020\u0005*\u00020\u00052\u0006\u0010z\u001a\u00020\u0005¢\u0006\u0004\b{\u0010w\u001a\u0019\u0010{\u001a\u00020%*\u00020%2\u0006\u0010z\u001a\u00020%¢\u0006\u0004\b{\u0010x\u001a\u0019\u0010{\u001a\u00020#*\u00020#2\u0006\u0010z\u001a\u00020#¢\u0006\u0004\b{\u0010y\u001a5\u0010|\u001a\u00028\u0000\"\u000e\b\u0000\u0010p*\b\u0012\u0004\u0012\u00028\u00000o*\u00028\u00002\b\u0010q\u001a\u0004\u0018\u00018\u00002\b\u0010z\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b|\u0010}\u001a!\u0010|\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010q\u001a\u00020\u001c2\u0006\u0010z\u001a\u00020\u001c¢\u0006\u0004\b|\u0010~\u001a!\u0010|\u001a\u00020!*\u00020!2\u0006\u0010q\u001a\u00020!2\u0006\u0010z\u001a\u00020!¢\u0006\u0004\b|\u0010\u007f\u001a\"\u0010|\u001a\u00020\u0001*\u00020\u00012\u0006\u0010q\u001a\u00020\u00012\u0006\u0010z\u001a\u00020\u0001¢\u0006\u0005\b|\u0010\u0080\u0001\u001a\"\u0010|\u001a\u00020\u0005*\u00020\u00052\u0006\u0010q\u001a\u00020\u00052\u0006\u0010z\u001a\u00020\u0005¢\u0006\u0005\b|\u0010\u0081\u0001\u001a\"\u0010|\u001a\u00020%*\u00020%2\u0006\u0010q\u001a\u00020%2\u0006\u0010z\u001a\u00020%¢\u0006\u0005\b|\u0010\u0082\u0001\u001a\"\u0010|\u001a\u00020#*\u00020#2\u0006\u0010q\u001a\u00020#2\u0006\u0010z\u001a\u00020#¢\u0006\u0005\b|\u0010\u0083\u0001\u001a4\u0010|\u001a\u00028\u0000\"\u000e\b\u0000\u0010p*\b\u0012\u0004\u0012\u00028\u00000o*\u00028\u00002\u000e\u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0084\u0001H\u0007¢\u0006\u0005\b|\u0010\u0086\u0001\u001a1\u0010|\u001a\u00028\u0000\"\u000e\b\u0000\u0010p*\b\u0012\u0004\u0012\u00028\u00000o*\u00028\u00002\r\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0005\b|\u0010\u0087\u0001\u001a!\u0010|\u001a\u00020\u0001*\u00020\u00012\r\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\u001b¢\u0006\u0005\b|\u0010\u0088\u0001\u001a!\u0010|\u001a\u00020\u0005*\u00020\u00052\r\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0005\b|\u0010\u0089\u0001¨\u0006\u008a\u0001"}, d2 = {"Lkotlin/ranges/IntRange;", "", "random", "(Lkotlin/ranges/IntRange;)I", "Lkotlin/ranges/LongRange;", "", "(Lkotlin/ranges/LongRange;)J", "Lkotlin/ranges/CharRange;", "", "(Lkotlin/ranges/CharRange;)C", "Lkotlin/random/Random;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)J", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)C", "randomOrNull", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "element", "", "contains", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "Lkotlin/ranges/ClosedRange;", "", Downloads.RequestHeaders.COLUMN_VALUE, "intRangeContains", "(Lkotlin/ranges/ClosedRange;B)Z", "longRangeContains", "", "shortRangeContains", "", "doubleRangeContains", "", "floatRangeContains", "(Lkotlin/ranges/ClosedRange;D)Z", "byteRangeContains", "(Lkotlin/ranges/ClosedRange;F)Z", "(Lkotlin/ranges/ClosedRange;I)Z", "(Lkotlin/ranges/ClosedRange;J)Z", "(Lkotlin/ranges/ClosedRange;S)Z", "to", "Lkotlin/ranges/IntProgression;", "downTo", "(IB)Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/LongProgression;", "(JB)Lkotlin/ranges/LongProgression;", "(BB)Lkotlin/ranges/IntProgression;", "(SB)Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/CharProgression;", "(CC)Lkotlin/ranges/CharProgression;", "(II)Lkotlin/ranges/IntProgression;", "(JI)Lkotlin/ranges/LongProgression;", "(BI)Lkotlin/ranges/IntProgression;", "(SI)Lkotlin/ranges/IntProgression;", "(IJ)Lkotlin/ranges/LongProgression;", "(JJ)Lkotlin/ranges/LongProgression;", "(BJ)Lkotlin/ranges/LongProgression;", "(SJ)Lkotlin/ranges/LongProgression;", "(IS)Lkotlin/ranges/IntProgression;", "(JS)Lkotlin/ranges/LongProgression;", "(BS)Lkotlin/ranges/IntProgression;", "(SS)Lkotlin/ranges/IntProgression;", "reversed", "(Lkotlin/ranges/IntProgression;)Lkotlin/ranges/IntProgression;", "(Lkotlin/ranges/LongProgression;)Lkotlin/ranges/LongProgression;", "(Lkotlin/ranges/CharProgression;)Lkotlin/ranges/CharProgression;", "step", "(Lkotlin/ranges/IntProgression;I)Lkotlin/ranges/IntProgression;", "(Lkotlin/ranges/LongProgression;J)Lkotlin/ranges/LongProgression;", "(Lkotlin/ranges/CharProgression;I)Lkotlin/ranges/CharProgression;", "toByteExactOrNull", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "toIntExactOrNull", "(J)Ljava/lang/Integer;", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "until", "(IB)Lkotlin/ranges/IntRange;", "(JB)Lkotlin/ranges/LongRange;", "(BB)Lkotlin/ranges/IntRange;", "(SB)Lkotlin/ranges/IntRange;", "(CC)Lkotlin/ranges/CharRange;", "(II)Lkotlin/ranges/IntRange;", "(JI)Lkotlin/ranges/LongRange;", "(BI)Lkotlin/ranges/IntRange;", "(SI)Lkotlin/ranges/IntRange;", "(IJ)Lkotlin/ranges/LongRange;", "(JJ)Lkotlin/ranges/LongRange;", "(BJ)Lkotlin/ranges/LongRange;", "(SJ)Lkotlin/ranges/LongRange;", "(IS)Lkotlin/ranges/IntRange;", "(JS)Lkotlin/ranges/LongRange;", "(BS)Lkotlin/ranges/IntRange;", "(SS)Lkotlin/ranges/IntRange;", "", ExifInterface.GPS_DIRECTION_TRUE, "minimumValue", "coerceAtLeast", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "(BB)B", "(SS)S", "(II)I", "(JJ)J", "(FF)F", "(DD)D", "maximumValue", "coerceAtMost", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "(BBB)B", "(SSS)S", "(III)I", "(JJJ)J", "(FFF)F", "(DDD)D", "Lkotlin/ranges/ClosedFloatingPointRange;", "range", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "(ILkotlin/ranges/ClosedRange;)I", "(JLkotlin/ranges/ClosedRange;)J", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/ranges/RangesKt")
/* loaded from: classes.dex */
public class RangesKt___RangesKt extends RangesKt__RangesKt {
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@d ClosedRange<Byte> contains, double d2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Byte byteExactOrNull = toByteExactOrNull(d2);
        if (byteExactOrNull != null) {
            return contains.contains(byteExactOrNull);
        }
        return false;
    }

    public static final byte coerceAtLeast(byte b2, byte b3) {
        return b2 < b3 ? b3 : b2;
    }

    public static final double coerceAtLeast(double d2, double d3) {
        return d2 < d3 ? d3 : d2;
    }

    public static final float coerceAtLeast(float f2, float f3) {
        return f2 < f3 ? f3 : f2;
    }

    public static int coerceAtLeast(int i2, int i3) {
        return i2 < i3 ? i3 : i2;
    }

    public static final long coerceAtLeast(long j2, long j3) {
        return j2 < j3 ? j3 : j2;
    }

    @d
    public static final <T extends Comparable<? super T>> T coerceAtLeast(@d T coerceAtLeast, @d T minimumValue) {
        Intrinsics.checkParameterIsNotNull(coerceAtLeast, "$this$coerceAtLeast");
        Intrinsics.checkParameterIsNotNull(minimumValue, "minimumValue");
        return coerceAtLeast.compareTo(minimumValue) < 0 ? minimumValue : coerceAtLeast;
    }

    public static final short coerceAtLeast(short s, short s2) {
        return s < s2 ? s2 : s;
    }

    public static final byte coerceAtMost(byte b2, byte b3) {
        return b2 > b3 ? b3 : b2;
    }

    public static final double coerceAtMost(double d2, double d3) {
        return d2 > d3 ? d3 : d2;
    }

    public static final float coerceAtMost(float f2, float f3) {
        return f2 > f3 ? f3 : f2;
    }

    public static int coerceAtMost(int i2, int i3) {
        return i2 > i3 ? i3 : i2;
    }

    public static final long coerceAtMost(long j2, long j3) {
        return j2 > j3 ? j3 : j2;
    }

    @d
    public static final <T extends Comparable<? super T>> T coerceAtMost(@d T coerceAtMost, @d T maximumValue) {
        Intrinsics.checkParameterIsNotNull(coerceAtMost, "$this$coerceAtMost");
        Intrinsics.checkParameterIsNotNull(maximumValue, "maximumValue");
        return coerceAtMost.compareTo(maximumValue) > 0 ? maximumValue : coerceAtMost;
    }

    public static final short coerceAtMost(short s, short s2) {
        return s > s2 ? s2 : s;
    }

    @d
    public static final <T extends Comparable<? super T>> T coerceIn(@d T coerceIn, @e T t, @e T t2) {
        Intrinsics.checkParameterIsNotNull(coerceIn, "$this$coerceIn");
        if (t == null || t2 == null) {
            if (t != null && coerceIn.compareTo(t) < 0) {
                return t;
            }
            if (t2 != null && coerceIn.compareTo(t2) > 0) {
                return t2;
            }
        } else {
            if (t.compareTo(t2) > 0) {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t2 + " is less than minimum " + t + '.');
            }
            if (coerceIn.compareTo(t) < 0) {
                return t;
            }
            if (coerceIn.compareTo(t2) > 0) {
                return t2;
            }
        }
        return coerceIn;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(@d IntRange contains, Integer num) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return num != null && contains.contains(num.intValue());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(@d ClosedRange<Double> contains, byte b2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.contains(Double.valueOf(b2));
    }

    @d
    public static final IntProgression downTo(int i2, byte b2) {
        return IntProgression.INSTANCE.fromClosedRange(i2, b2, -1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "floatRangeContains")
    public static final boolean floatRangeContains(@d ClosedRange<Float> contains, byte b2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.contains(Float.valueOf(b2));
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@d ClosedRange<Integer> contains, byte b2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.contains(Integer.valueOf(b2));
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@d ClosedRange<Long> contains, byte b2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.contains(Long.valueOf(b2));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int random(@d IntRange intRange) {
        return random(intRange, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final Integer randomOrNull(@d IntRange intRange) {
        return randomOrNull(intRange, Random.INSTANCE);
    }

    @d
    public static final IntProgression reversed(@d IntProgression reversed) {
        Intrinsics.checkParameterIsNotNull(reversed, "$this$reversed");
        return IntProgression.INSTANCE.fromClosedRange(reversed.getLast(), reversed.getFirst(), -reversed.getStep());
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@d ClosedRange<Short> contains, byte b2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.contains(Short.valueOf(b2));
    }

    @d
    public static IntProgression step(@d IntProgression step, int i2) {
        Intrinsics.checkParameterIsNotNull(step, "$this$step");
        RangesKt__RangesKt.checkStepIsPositive(i2 > 0, Integer.valueOf(i2));
        IntProgression.Companion companion = IntProgression.INSTANCE;
        int first = step.getFirst();
        int last = step.getLast();
        if (step.getStep() <= 0) {
            i2 = -i2;
        }
        return companion.fromClosedRange(first, last, i2);
    }

    @e
    public static final Byte toByteExactOrNull(int i2) {
        if (-128 <= i2 && 127 >= i2) {
            return Byte.valueOf((byte) i2);
        }
        return null;
    }

    @e
    public static final Integer toIntExactOrNull(long j2) {
        long j3 = Integer.MAX_VALUE;
        if (Integer.MIN_VALUE <= j2 && j3 >= j2) {
            return Integer.valueOf((int) j2);
        }
        return null;
    }

    @e
    public static final Long toLongExactOrNull(double d2) {
        double d3 = Long.MAX_VALUE;
        if (d2 < Long.MIN_VALUE || d2 > d3) {
            return null;
        }
        return Long.valueOf((long) d2);
    }

    @e
    public static final Short toShortExactOrNull(int i2) {
        if (-32768 <= i2 && 32767 >= i2) {
            return Short.valueOf((short) i2);
        }
        return null;
    }

    @d
    public static final IntRange until(int i2, byte b2) {
        return new IntRange(i2, b2 - 1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@d ClosedRange<Byte> contains, float f2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Byte byteExactOrNull = toByteExactOrNull(f2);
        if (byteExactOrNull != null) {
            return contains.contains(byteExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(@d LongRange contains, Long l) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return l != null && contains.contains(l.longValue());
    }

    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(@d ClosedRange<Double> contains, float f2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.contains(Double.valueOf(f2));
    }

    @d
    public static final LongProgression downTo(long j2, byte b2) {
        return LongProgression.INSTANCE.fromClosedRange(j2, b2, -1L);
    }

    @JvmName(name = "floatRangeContains")
    public static final boolean floatRangeContains(@d ClosedRange<Float> contains, double d2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.contains(Float.valueOf((float) d2));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@d ClosedRange<Integer> contains, double d2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Integer intExactOrNull = toIntExactOrNull(d2);
        if (intExactOrNull != null) {
            return contains.contains(intExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@d ClosedRange<Long> contains, double d2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Long longExactOrNull = toLongExactOrNull(d2);
        if (longExactOrNull != null) {
            return contains.contains(longExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final long random(@d LongRange longRange) {
        return random(longRange, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final Long randomOrNull(@d LongRange longRange) {
        return randomOrNull(longRange, Random.INSTANCE);
    }

    @d
    public static final LongProgression reversed(@d LongProgression reversed) {
        Intrinsics.checkParameterIsNotNull(reversed, "$this$reversed");
        return LongProgression.INSTANCE.fromClosedRange(reversed.getLast(), reversed.getFirst(), -reversed.getStep());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@d ClosedRange<Short> contains, double d2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Short shortExactOrNull = toShortExactOrNull(d2);
        if (shortExactOrNull != null) {
            return contains.contains(shortExactOrNull);
        }
        return false;
    }

    @e
    public static final Byte toByteExactOrNull(long j2) {
        long j3 = 127;
        if (-128 <= j2 && j3 >= j2) {
            return Byte.valueOf((byte) j2);
        }
        return null;
    }

    @e
    public static final Integer toIntExactOrNull(double d2) {
        double d3 = Integer.MAX_VALUE;
        if (d2 < Integer.MIN_VALUE || d2 > d3) {
            return null;
        }
        return Integer.valueOf((int) d2);
    }

    @e
    public static final Long toLongExactOrNull(float f2) {
        float f3 = Long.MAX_VALUE;
        if (f2 < Long.MIN_VALUE || f2 > f3) {
            return null;
        }
        return Long.valueOf((long) f2);
    }

    @e
    public static final Short toShortExactOrNull(long j2) {
        long j3 = 32767;
        if (-32768 <= j2 && j3 >= j2) {
            return Short.valueOf((short) j2);
        }
        return null;
    }

    @d
    public static final LongRange until(long j2, byte b2) {
        return new LongRange(j2, b2 - 1);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@d ClosedRange<Byte> contains, int i2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Byte byteExactOrNull = toByteExactOrNull(i2);
        if (byteExactOrNull != null) {
            return contains.contains(byteExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(@d CharRange contains, Character ch) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return ch != null && contains.contains(ch.charValue());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(@d ClosedRange<Double> contains, int i2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.contains(Double.valueOf(i2));
    }

    @d
    public static final IntProgression downTo(byte b2, byte b3) {
        return IntProgression.INSTANCE.fromClosedRange(b2, b3, -1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "floatRangeContains")
    public static final boolean floatRangeContains(@d ClosedRange<Float> contains, int i2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.contains(Float.valueOf(i2));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@d ClosedRange<Integer> contains, float f2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Integer intExactOrNull = toIntExactOrNull(f2);
        if (intExactOrNull != null) {
            return contains.contains(intExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@d ClosedRange<Long> contains, float f2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Long longExactOrNull = toLongExactOrNull(f2);
        if (longExactOrNull != null) {
            return contains.contains(longExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final char random(@d CharRange charRange) {
        return random(charRange, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final Character randomOrNull(@d CharRange charRange) {
        return randomOrNull(charRange, Random.INSTANCE);
    }

    @d
    public static final CharProgression reversed(@d CharProgression reversed) {
        Intrinsics.checkParameterIsNotNull(reversed, "$this$reversed");
        return CharProgression.INSTANCE.fromClosedRange(reversed.getLast(), reversed.getFirst(), -reversed.getStep());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@d ClosedRange<Short> contains, float f2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Short shortExactOrNull = toShortExactOrNull(f2);
        if (shortExactOrNull != null) {
            return contains.contains(shortExactOrNull);
        }
        return false;
    }

    @d
    public static final LongProgression step(@d LongProgression step, long j2) {
        Intrinsics.checkParameterIsNotNull(step, "$this$step");
        RangesKt__RangesKt.checkStepIsPositive(j2 > 0, Long.valueOf(j2));
        LongProgression.Companion companion = LongProgression.INSTANCE;
        long first = step.getFirst();
        long last = step.getLast();
        if (step.getStep() <= 0) {
            j2 = -j2;
        }
        return companion.fromClosedRange(first, last, j2);
    }

    @e
    public static final Byte toByteExactOrNull(short s) {
        short s2 = (short) 127;
        if (((short) (-128)) <= s && s2 >= s) {
            return Byte.valueOf((byte) s);
        }
        return null;
    }

    @e
    public static final Integer toIntExactOrNull(float f2) {
        float f3 = Integer.MAX_VALUE;
        if (f2 < Integer.MIN_VALUE || f2 > f3) {
            return null;
        }
        return Integer.valueOf((int) f2);
    }

    @e
    public static final Short toShortExactOrNull(double d2) {
        double d3 = 32767;
        if (d2 < -32768 || d2 > d3) {
            return null;
        }
        return Short.valueOf((short) d2);
    }

    @d
    public static final IntRange until(byte b2, byte b3) {
        return new IntRange(b2, b3 - 1);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@d ClosedRange<Byte> contains, long j2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Byte byteExactOrNull = toByteExactOrNull(j2);
        if (byteExactOrNull != null) {
            return contains.contains(byteExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(@d ClosedRange<Double> contains, long j2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.contains(Double.valueOf(j2));
    }

    @d
    public static final IntProgression downTo(short s, byte b2) {
        return IntProgression.INSTANCE.fromClosedRange(s, b2, -1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "floatRangeContains")
    public static final boolean floatRangeContains(@d ClosedRange<Float> contains, long j2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.contains(Float.valueOf(j2));
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@d ClosedRange<Integer> contains, long j2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Integer intExactOrNull = toIntExactOrNull(j2);
        if (intExactOrNull != null) {
            return contains.contains(intExactOrNull);
        }
        return false;
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@d ClosedRange<Long> contains, int i2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.contains(Long.valueOf(i2));
    }

    @SinceKotlin(version = "1.3")
    public static final int random(@d IntRange random, @d Random random2) {
        Intrinsics.checkParameterIsNotNull(random, "$this$random");
        Intrinsics.checkParameterIsNotNull(random2, "random");
        try {
            return RandomKt.nextInt(random2, random);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @e
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final Integer randomOrNull(@d IntRange randomOrNull, @d Random random) {
        Intrinsics.checkParameterIsNotNull(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (randomOrNull.isEmpty()) {
            return null;
        }
        return Integer.valueOf(RandomKt.nextInt(random, randomOrNull));
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@d ClosedRange<Short> contains, int i2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Short shortExactOrNull = toShortExactOrNull(i2);
        if (shortExactOrNull != null) {
            return contains.contains(shortExactOrNull);
        }
        return false;
    }

    @e
    public static final Byte toByteExactOrNull(double d2) {
        double d3 = 127;
        if (d2 < -128 || d2 > d3) {
            return null;
        }
        return Byte.valueOf((byte) d2);
    }

    @e
    public static final Short toShortExactOrNull(float f2) {
        float f3 = 32767;
        if (f2 < -32768 || f2 > f3) {
            return null;
        }
        return Short.valueOf((short) f2);
    }

    @d
    public static final IntRange until(short s, byte b2) {
        return new IntRange(s, b2 - 1);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@d ClosedRange<Byte> contains, short s) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Byte byteExactOrNull = toByteExactOrNull(s);
        if (byteExactOrNull != null) {
            return contains.contains(byteExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(@d ClosedRange<Double> contains, short s) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.contains(Double.valueOf(s));
    }

    @d
    public static final CharProgression downTo(char c2, char c3) {
        return CharProgression.INSTANCE.fromClosedRange(c2, c3, -1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "floatRangeContains")
    public static final boolean floatRangeContains(@d ClosedRange<Float> contains, short s) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.contains(Float.valueOf(s));
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@d ClosedRange<Integer> contains, short s) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.contains(Integer.valueOf(s));
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@d ClosedRange<Long> contains, short s) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.contains(Long.valueOf(s));
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@d ClosedRange<Short> contains, long j2) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Short shortExactOrNull = toShortExactOrNull(j2);
        if (shortExactOrNull != null) {
            return contains.contains(shortExactOrNull);
        }
        return false;
    }

    @d
    public static final CharProgression step(@d CharProgression step, int i2) {
        Intrinsics.checkParameterIsNotNull(step, "$this$step");
        RangesKt__RangesKt.checkStepIsPositive(i2 > 0, Integer.valueOf(i2));
        CharProgression.Companion companion = CharProgression.INSTANCE;
        char first = step.getFirst();
        char last = step.getLast();
        if (step.getStep() <= 0) {
            i2 = -i2;
        }
        return companion.fromClosedRange(first, last, i2);
    }

    @e
    public static final Byte toByteExactOrNull(float f2) {
        float f3 = 127;
        if (f2 < -128 || f2 > f3) {
            return null;
        }
        return Byte.valueOf((byte) f2);
    }

    @d
    public static final CharRange until(char c2, char c3) {
        if (c3 <= 0) {
            return CharRange.INSTANCE.getEMPTY();
        }
        return new CharRange(c2, (char) (c3 - 1));
    }

    @d
    public static IntProgression downTo(int i2, int i3) {
        return IntProgression.INSTANCE.fromClosedRange(i2, i3, -1);
    }

    @SinceKotlin(version = "1.3")
    public static final long random(@d LongRange random, @d Random random2) {
        Intrinsics.checkParameterIsNotNull(random, "$this$random");
        Intrinsics.checkParameterIsNotNull(random2, "random");
        try {
            return RandomKt.nextLong(random2, random);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @e
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final Long randomOrNull(@d LongRange randomOrNull, @d Random random) {
        Intrinsics.checkParameterIsNotNull(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (randomOrNull.isEmpty()) {
            return null;
        }
        return Long.valueOf(RandomKt.nextLong(random, randomOrNull));
    }

    public static final byte coerceIn(byte b2, byte b3, byte b4) {
        if (b3 <= b4) {
            return b2 < b3 ? b3 : b2 > b4 ? b4 : b2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) b4) + " is less than minimum " + ((int) b3) + '.');
    }

    @d
    public static final LongProgression downTo(long j2, int i2) {
        return LongProgression.INSTANCE.fromClosedRange(j2, i2, -1L);
    }

    @d
    public static IntRange until(int i2, int i3) {
        if (i3 <= Integer.MIN_VALUE) {
            return IntRange.INSTANCE.getEMPTY();
        }
        return new IntRange(i2, i3 - 1);
    }

    public static final short coerceIn(short s, short s2, short s3) {
        if (s2 <= s3) {
            return s < s2 ? s2 : s > s3 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) s3) + " is less than minimum " + ((int) s2) + '.');
    }

    @d
    public static final IntProgression downTo(byte b2, int i2) {
        return IntProgression.INSTANCE.fromClosedRange(b2, i2, -1);
    }

    @SinceKotlin(version = "1.3")
    public static final char random(@d CharRange random, @d Random random2) {
        Intrinsics.checkParameterIsNotNull(random, "$this$random");
        Intrinsics.checkParameterIsNotNull(random2, "random");
        try {
            return (char) random2.nextInt(random.getFirst(), random.getLast() + 1);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @e
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final Character randomOrNull(@d CharRange randomOrNull, @d Random random) {
        Intrinsics.checkParameterIsNotNull(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (randomOrNull.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.nextInt(randomOrNull.getFirst(), randomOrNull.getLast() + 1));
    }

    public static int coerceIn(int i2, int i3, int i4) {
        if (i3 <= i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + '.');
    }

    @d
    public static final IntProgression downTo(short s, int i2) {
        return IntProgression.INSTANCE.fromClosedRange(s, i2, -1);
    }

    @d
    public static final LongRange until(long j2, int i2) {
        return new LongRange(j2, i2 - 1);
    }

    public static final long coerceIn(long j2, long j3, long j4) {
        if (j3 <= j4) {
            return j2 < j3 ? j3 : j2 > j4 ? j4 : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j4 + " is less than minimum " + j3 + '.');
    }

    @d
    public static final LongProgression downTo(int i2, long j2) {
        return LongProgression.INSTANCE.fromClosedRange(i2, j2, -1L);
    }

    @d
    public static final IntRange until(byte b2, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return IntRange.INSTANCE.getEMPTY();
        }
        return new IntRange(b2, i2 - 1);
    }

    public static final float coerceIn(float f2, float f3, float f4) {
        if (f3 <= f4) {
            return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f4 + " is less than minimum " + f3 + '.');
    }

    @d
    public static final LongProgression downTo(long j2, long j3) {
        return LongProgression.INSTANCE.fromClosedRange(j2, j3, -1L);
    }

    public static final double coerceIn(double d2, double d3, double d4) {
        if (d3 <= d4) {
            return d2 < d3 ? d3 : d2 > d4 ? d4 : d2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d4 + " is less than minimum " + d3 + '.');
    }

    @d
    public static final LongProgression downTo(byte b2, long j2) {
        return LongProgression.INSTANCE.fromClosedRange(b2, j2, -1L);
    }

    @d
    public static final IntRange until(short s, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return IntRange.INSTANCE.getEMPTY();
        }
        return new IntRange(s, i2 - 1);
    }

    @d
    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T coerceIn(@d T coerceIn, @d ClosedFloatingPointRange<T> range) {
        Intrinsics.checkParameterIsNotNull(coerceIn, "$this$coerceIn");
        Intrinsics.checkParameterIsNotNull(range, "range");
        if (!range.isEmpty()) {
            return (!range.lessThanOrEquals(coerceIn, range.getStart()) || range.lessThanOrEquals(range.getStart(), coerceIn)) ? (!range.lessThanOrEquals(range.getEndInclusive(), coerceIn) || range.lessThanOrEquals(coerceIn, range.getEndInclusive())) ? coerceIn : range.getEndInclusive() : range.getStart();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @d
    public static final LongProgression downTo(short s, long j2) {
        return LongProgression.INSTANCE.fromClosedRange(s, j2, -1L);
    }

    @d
    public static final IntProgression downTo(int i2, short s) {
        return IntProgression.INSTANCE.fromClosedRange(i2, s, -1);
    }

    @d
    public static final LongRange until(int i2, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(i2, j2 - 1);
    }

    @d
    public static final LongProgression downTo(long j2, short s) {
        return LongProgression.INSTANCE.fromClosedRange(j2, s, -1L);
    }

    @d
    public static final IntProgression downTo(byte b2, short s) {
        return IntProgression.INSTANCE.fromClosedRange(b2, s, -1);
    }

    @d
    public static final LongRange until(long j2, long j3) {
        if (j3 <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(j2, j3 - 1);
    }

    @d
    public static final <T extends Comparable<? super T>> T coerceIn(@d T coerceIn, @d ClosedRange<T> range) {
        Intrinsics.checkParameterIsNotNull(coerceIn, "$this$coerceIn");
        Intrinsics.checkParameterIsNotNull(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return (T) coerceIn((Comparable) coerceIn, (ClosedFloatingPointRange) range);
        }
        if (!range.isEmpty()) {
            return coerceIn.compareTo(range.getStart()) < 0 ? range.getStart() : coerceIn.compareTo(range.getEndInclusive()) > 0 ? range.getEndInclusive() : coerceIn;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @d
    public static final IntProgression downTo(short s, short s2) {
        return IntProgression.INSTANCE.fromClosedRange(s, s2, -1);
    }

    @d
    public static final LongRange until(byte b2, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(b2, j2 - 1);
    }

    @d
    public static final LongRange until(short s, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(s, j2 - 1);
    }

    @d
    public static final IntRange until(int i2, short s) {
        return new IntRange(i2, s - 1);
    }

    public static final int coerceIn(int i2, @d ClosedRange<Integer> range) {
        Intrinsics.checkParameterIsNotNull(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((Number) coerceIn(Integer.valueOf(i2), (ClosedFloatingPointRange<Integer>) range)).intValue();
        }
        if (!range.isEmpty()) {
            return i2 < range.getStart().intValue() ? range.getStart().intValue() : i2 > range.getEndInclusive().intValue() ? range.getEndInclusive().intValue() : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @d
    public static final LongRange until(long j2, short s) {
        return new LongRange(j2, s - 1);
    }

    @d
    public static final IntRange until(byte b2, short s) {
        return new IntRange(b2, s - 1);
    }

    @d
    public static final IntRange until(short s, short s2) {
        return new IntRange(s, s2 - 1);
    }

    public static final long coerceIn(long j2, @d ClosedRange<Long> range) {
        Intrinsics.checkParameterIsNotNull(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((Number) coerceIn(Long.valueOf(j2), (ClosedFloatingPointRange<Long>) range)).longValue();
        }
        if (!range.isEmpty()) {
            return j2 < range.getStart().longValue() ? range.getStart().longValue() : j2 > range.getEndInclusive().longValue() ? range.getEndInclusive().longValue() : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }
}
