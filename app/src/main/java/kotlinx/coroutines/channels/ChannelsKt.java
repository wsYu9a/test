package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import xi.k;
import xi.l;

@Metadata(d1 = {"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt", "kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChannelsKt {

    @k
    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    @PublishedApi
    public static final void cancelConsumed(@k ReceiveChannel<?> receiveChannel, @l Throwable th2) {
        ChannelsKt__Channels_commonKt.cancelConsumed(receiveChannel, th2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @ObsoleteCoroutinesApi
    public static final <E, R> R consume(@k BroadcastChannel<E> broadcastChannel, @k Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        return (R) ChannelsKt__Channels_commonKt.consume(broadcastChannel, function1);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @l
    public static final <E> Object consumeEach(@k BroadcastChannel<E> broadcastChannel, @k Function1<? super E, Unit> function1, @k Continuation<? super Unit> continuation) {
        return ChannelsKt__Channels_commonKt.consumeEach(broadcastChannel, function1, continuation);
    }

    @k
    @PublishedApi
    public static final Function1<Throwable, Unit> consumes(@k ReceiveChannel<?> receiveChannel) {
        return ChannelsKt__DeprecatedKt.consumes(receiveChannel);
    }

    @k
    @PublishedApi
    public static final Function1<Throwable, Unit> consumesAll(@k ReceiveChannel<?>... receiveChannelArr) {
        return ChannelsKt__DeprecatedKt.consumesAll(receiveChannelArr);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel distinct(ReceiveChannel receiveChannel) {
        ReceiveChannel distinctBy$default;
        distinctBy$default = ChannelsKt__DeprecatedKt.distinctBy$default(receiveChannel, null, new ChannelsKt__DeprecatedKt$distinct$1(null), 1, null);
        return distinctBy$default;
    }

    @k
    @PublishedApi
    public static final <E, K> ReceiveChannel<E> distinctBy(@k ReceiveChannel<? extends E> receiveChannel, @k CoroutineContext coroutineContext, @k Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        return ChannelsKt__DeprecatedKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    @k
    @PublishedApi
    public static final <E> ReceiveChannel<E> filter(@k ReceiveChannel<? extends E> receiveChannel, @k CoroutineContext coroutineContext, @k Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ChannelsKt__DeprecatedKt.filter(receiveChannel, coroutineContext, function2);
    }

    @k
    @PublishedApi
    public static final <E> ReceiveChannel<E> filterNotNull(@k ReceiveChannel<? extends E> receiveChannel) {
        return ChannelsKt__DeprecatedKt.filterNotNull(receiveChannel);
    }

    @k
    @PublishedApi
    public static final <E, R> ReceiveChannel<R> map(@k ReceiveChannel<? extends E> receiveChannel, @k CoroutineContext coroutineContext, @k Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ChannelsKt__DeprecatedKt.map(receiveChannel, coroutineContext, function2);
    }

    @k
    @PublishedApi
    public static final <E, R> ReceiveChannel<R> mapIndexed(@k ReceiveChannel<? extends E> receiveChannel, @k CoroutineContext coroutineContext, @k Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ChannelsKt__DeprecatedKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Left for binary compatibility")
    public static final /* synthetic */ ReceiveChannel requireNoNulls(ReceiveChannel receiveChannel) {
        ReceiveChannel map$default;
        map$default = ChannelsKt__DeprecatedKt.map$default(receiveChannel, null, new ChannelsKt__DeprecatedKt$requireNoNulls$1(receiveChannel, null), 1, null);
        return map$default;
    }

    @PublishedApi
    @l
    public static final <E, C extends SendChannel<? super E>> Object toChannel(@k ReceiveChannel<? extends E> receiveChannel, @k C c10, @k Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.toChannel(receiveChannel, c10, continuation);
    }

    @PublishedApi
    @l
    public static final <E, C extends Collection<? super E>> Object toCollection(@k ReceiveChannel<? extends E> receiveChannel, @k C c10, @k Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.toCollection(receiveChannel, c10, continuation);
    }

    @l
    public static final <E> Object toList(@k ReceiveChannel<? extends E> receiveChannel, @k Continuation<? super List<? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.toList(receiveChannel, continuation);
    }

    @PublishedApi
    @l
    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(@k ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, @k M m10, @k Continuation<? super M> continuation) {
        return ChannelsKt__DeprecatedKt.toMap(receiveChannel, m10, continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object toMutableList(ReceiveChannel receiveChannel, Continuation continuation) {
        Object collection;
        collection = toCollection(receiveChannel, new ArrayList(), continuation);
        return collection;
    }

    @PublishedApi
    @l
    public static final <E> Object toMutableSet(@k ReceiveChannel<? extends E> receiveChannel, @k Continuation<? super Set<E>> continuation) {
        return ChannelsKt__DeprecatedKt.toMutableSet(receiveChannel, continuation);
    }

    @k
    public static final <E> Object trySendBlocking(@k SendChannel<? super E> sendChannel, E e10) {
        return ChannelsKt__ChannelsKt.trySendBlocking(sendChannel, e10);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel zip(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2) {
        ReceiveChannel zip$default;
        zip$default = ChannelsKt__DeprecatedKt.zip$default(receiveChannel, receiveChannel2, null, ChannelsKt__DeprecatedKt$zip$1.INSTANCE, 2, null);
        return zip$default;
    }

    public static final <E, R> R consume(@k ReceiveChannel<? extends E> receiveChannel, @k Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        return (R) ChannelsKt__Channels_commonKt.consume(receiveChannel, function1);
    }

    @l
    public static final <E> Object consumeEach(@k ReceiveChannel<? extends E> receiveChannel, @k Function1<? super E, Unit> function1, @k Continuation<? super Unit> continuation) {
        return ChannelsKt__Channels_commonKt.consumeEach(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object toMap(ReceiveChannel receiveChannel, Continuation continuation) {
        Object map;
        map = toMap(receiveChannel, new LinkedHashMap(), continuation);
        return map;
    }

    @k
    @PublishedApi
    public static final <E, R, V> ReceiveChannel<V> zip(@k ReceiveChannel<? extends E> receiveChannel, @k ReceiveChannel<? extends R> receiveChannel2, @k CoroutineContext coroutineContext, @k Function2<? super E, ? super R, ? extends V> function2) {
        return ChannelsKt__DeprecatedKt.zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }
}
