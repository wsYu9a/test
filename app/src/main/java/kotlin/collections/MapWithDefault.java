package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import f.b.a.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\bb\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003J\u0017\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lkotlin/collections/MapWithDefault;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "key", "getOrImplicitDefault", "(Ljava/lang/Object;)Ljava/lang/Object;", "getMap", "()Ljava/util/Map;", "map", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
interface MapWithDefault<K, V> extends Map<K, V>, KMappedMarker {
    @d
    Map<K, V> getMap();

    V getOrImplicitDefault(K key);
}
