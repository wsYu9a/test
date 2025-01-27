package kotlinx.coroutines.channels;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.sigmob.sdk.base.k;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.f;
import h3.e;
import id.c;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.Segment;
import p5.x0;
import xi.l;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ)\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u0019J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\tH\u0000¢\u0006\u0002\b\u001cJ!\u0010\u001d\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u001fJ\u0017\u0010 \u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\tH\u0000¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\tH\u0000¢\u0006\u0002\b$J\"\u0010%\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0016J\u0016\u0010*\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0015J\u0017\u0010,\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\tH\u0000¢\u0006\u0004\b-\u0010\"J\u001a\u0010.\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u0010H\u0002J\u001f\u00100\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b1J\u001f\u00102\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u00103\u001a\u00028\u0000H\u0000¢\u0006\u0004\b4\u00105R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004R\u0014\u0010\u0011\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u00066"}, d2 = {"Lkotlinx/coroutines/channels/ChannelSegment;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/Segment;", "id", "", c.f26969f, "channel", "Lkotlinx/coroutines/channels/BufferedChannel;", "pointers", "", "(JLkotlinx/coroutines/channels/ChannelSegment;Lkotlinx/coroutines/channels/BufferedChannel;I)V", "_channel", "getChannel", "()Lkotlinx/coroutines/channels/BufferedChannel;", e.f26408m, "Lkotlinx/atomicfu/AtomicArray;", "", "numberOfSlots", "getNumberOfSlots", "()I", "casState", "", "index", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "casState$kotlinx_coroutines_core", "cleanElement", "", "cleanElement$kotlinx_coroutines_core", "getAndSetState", k.f18185q, "getAndSetState$kotlinx_coroutines_core", "getElement", "getElement$kotlinx_coroutines_core", "(I)Ljava/lang/Object;", "getState", "getState$kotlinx_coroutines_core", "onCancellation", "cause", "", f.X, "Lkotlin/coroutines/CoroutineContext;", "onCancelledRequest", SocialConstants.PARAM_RECEIVER, "retrieveElement", "retrieveElement$kotlinx_coroutines_core", "setElementLazy", "value", "setState", "setState$kotlinx_coroutines_core", "storeElement", "element", "storeElement$kotlinx_coroutines_core", "(ILjava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/ChannelSegment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3055:1\n1#2:3056\n*E\n"})
/* loaded from: classes4.dex */
public final class ChannelSegment<E> extends Segment<ChannelSegment<E>> {

    @l
    private final BufferedChannel<E> _channel;

    @xi.k
    private final AtomicReferenceArray data;

    public ChannelSegment(long j10, @l ChannelSegment<E> channelSegment, @l BufferedChannel<E> bufferedChannel, int i10) {
        super(j10, channelSegment, i10);
        this._channel = bufferedChannel;
        this.data = new AtomicReferenceArray(BufferedChannelKt.SEGMENT_SIZE * 2);
    }

    private final void setElementLazy(int index, Object value) {
        this.data.lazySet(index * 2, value);
    }

    public final boolean casState$kotlinx_coroutines_core(int index, @l Object r32, @l Object r42) {
        return x0.a(this.data, (index * 2) + 1, r32, r42);
    }

    public final void cleanElement$kotlinx_coroutines_core(int index) {
        setElementLazy(index, null);
    }

    @l
    public final Object getAndSetState$kotlinx_coroutines_core(int index, @l Object r32) {
        return this.data.getAndSet((index * 2) + 1, r32);
    }

    @xi.k
    public final BufferedChannel<E> getChannel() {
        BufferedChannel<E> bufferedChannel = this._channel;
        Intrinsics.checkNotNull(bufferedChannel);
        return bufferedChannel;
    }

    public final E getElement$kotlinx_coroutines_core(int index) {
        return (E) this.data.get(index * 2);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public int getNumberOfSlots() {
        return BufferedChannelKt.SEGMENT_SIZE;
    }

    @l
    public final Object getState$kotlinx_coroutines_core(int index) {
        return this.data.get((index * 2) + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0063, code lost:
    
        cleanElement$kotlinx_coroutines_core(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0066, code lost:
    
        if (r0 == false) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0068, code lost:
    
        r4 = getChannel().onUndeliveredElement;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x006e, code lost:
    
        if (r4 == null) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0070, code lost:
    
        kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElement(r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0073, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
    
        return;
     */
    @Override // kotlinx.coroutines.internal.Segment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCancellation(int r4, @xi.l java.lang.Throwable r5, @xi.k kotlin.coroutines.CoroutineContext r6) {
        /*
            r3 = this;
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.getElement$kotlinx_coroutines_core(r4)
        Le:
            java.lang.Object r1 = r3.getState$kotlinx_coroutines_core(r4)
            boolean r2 = r1 instanceof kotlinx.coroutines.Waiter
            if (r2 != 0) goto L74
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r2 == 0) goto L1b
            goto L74
        L1b:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getINTERRUPTED_SEND$p()
            if (r1 == r2) goto L63
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getINTERRUPTED_RCV$p()
            if (r1 != r2) goto L28
            goto L63
        L28:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getRESUMING_BY_EB$p()
            if (r1 == r2) goto Le
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getRESUMING_BY_RCV$p()
            if (r1 != r2) goto L35
            goto Le
        L35:
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.channels.BufferedChannelKt.access$getDONE_RCV$p()
            if (r1 == r4) goto L62
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED
            if (r1 != r4) goto L40
            goto L62
        L40:
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            if (r1 != r4) goto L47
            return
        L47:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "unexpected state: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L62:
            return
        L63:
            r3.cleanElement$kotlinx_coroutines_core(r4)
            if (r0 == 0) goto L73
            kotlinx.coroutines.channels.BufferedChannel r4 = r3.getChannel()
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r4 = r4.onUndeliveredElement
            if (r4 == 0) goto L73
            kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElement(r4, r5, r6)
        L73:
            return
        L74:
            if (r0 == 0) goto L7b
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getINTERRUPTED_SEND$p()
            goto L7f
        L7b:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getINTERRUPTED_RCV$p()
        L7f:
            boolean r1 = r3.casState$kotlinx_coroutines_core(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.cleanElement$kotlinx_coroutines_core(r4)
            r1 = r0 ^ 1
            r3.onCancelledRequest(r4, r1)
            if (r0 == 0) goto L9a
            kotlinx.coroutines.channels.BufferedChannel r4 = r3.getChannel()
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r4 = r4.onUndeliveredElement
            if (r4 == 0) goto L9a
            kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElement(r4, r5, r6)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelSegment.onCancellation(int, java.lang.Throwable, kotlin.coroutines.CoroutineContext):void");
    }

    public final void onCancelledRequest(int index, boolean r62) {
        if (r62) {
            getChannel().waitExpandBufferCompletion$kotlinx_coroutines_core((this.id * BufferedChannelKt.SEGMENT_SIZE) + index);
        }
        onSlotCleaned();
    }

    public final E retrieveElement$kotlinx_coroutines_core(int index) {
        E element$kotlinx_coroutines_core = getElement$kotlinx_coroutines_core(index);
        cleanElement$kotlinx_coroutines_core(index);
        return element$kotlinx_coroutines_core;
    }

    public final void setState$kotlinx_coroutines_core(int index, @l Object value) {
        this.data.set((index * 2) + 1, value);
    }

    public final void storeElement$kotlinx_coroutines_core(int index, E element) {
        setElementLazy(index, element);
    }
}
