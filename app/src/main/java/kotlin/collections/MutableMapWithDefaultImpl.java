package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.api.model.AdnName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import f.b.a.e;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B>\u0012\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100\u0012!\u0010)\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00028\u00010&¢\u0006\u0004\b9\u0010:J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\bJ\u001a\u0010\u0015\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0019\u0010\u0016J%\u0010\u001d\u001a\u00020\u001c2\u0014\u0010\u001b\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b!\u0010\u0016R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010\"8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R1\u0010)\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00028\u00010&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R(\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010,0+8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R(\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001008\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0016\u00106\u001a\u00020\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u000bR\u001c\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000+8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010.¨\u0006;"}, d2 = {"Lkotlin/collections/MutableMapWithDefaultImpl;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/MutableMapWithDefault;", "", AdnName.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "", "toString", "()Ljava/lang/String;", "isEmpty", "()Z", "key", "containsKey", Downloads.RequestHeaders.COLUMN_VALUE, "containsValue", MonitorConstants.CONNECT_TYPE_GET, "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "", OapsKey.KEY_FROM, "", "putAll", "(Ljava/util/Map;)V", "clear", "()V", "getOrImplicitDefault", "", "getValues", "()Ljava/util/Collection;", "values", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", DownloadSettingKeys.BugFix.DEFAULT, "Lkotlin/jvm/functions/Function1;", "", "", "getEntries", "()Ljava/util/Set;", "entries", "", "map", "Ljava/util/Map;", "getMap", "()Ljava/util/Map;", "getSize", OapsKey.KEY_SIZE, "getKeys", "keys", "<init>", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
final class MutableMapWithDefaultImpl<K, V> implements MutableMapWithDefault<K, V> {
    private final Function1<K, V> default;

    @d
    private final Map<K, V> map;

    /* JADX WARN: Multi-variable type inference failed */
    public MutableMapWithDefaultImpl(@d Map<K, V> map, @d Function1<? super K, ? extends V> function1) {
        Intrinsics.checkParameterIsNotNull(map, "map");
        Intrinsics.checkParameterIsNotNull(function1, "default");
        this.map = map;
        this.default = function1;
    }

    @Override // java.util.Map
    public void clear() {
        getMap().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return getMap().containsKey(key);
    }

    @Override // java.util.Map
    public boolean containsValue(Object r2) {
        return getMap().containsValue(r2);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(@e Object r2) {
        return getMap().equals(r2);
    }

    @Override // java.util.Map
    @e
    public V get(Object obj) {
        return getMap().get(obj);
    }

    @d
    public Set<Map.Entry<K, V>> getEntries() {
        return getMap().entrySet();
    }

    @d
    public Set<K> getKeys() {
        return getMap().keySet();
    }

    @Override // kotlin.collections.MutableMapWithDefault, kotlin.collections.MapWithDefault
    @d
    public Map<K, V> getMap() {
        return this.map;
    }

    @Override // kotlin.collections.MapWithDefault
    public V getOrImplicitDefault(K key) {
        Map<K, V> map = getMap();
        V v = map.get(key);
        return (v != null || map.containsKey(key)) ? v : this.default.invoke(key);
    }

    public int getSize() {
        return getMap().size();
    }

    @d
    public Collection<V> getValues() {
        return getMap().values();
    }

    @Override // java.util.Map
    public int hashCode() {
        return getMap().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getMap().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    @e
    public V put(K key, V r3) {
        return getMap().put(key, r3);
    }

    @Override // java.util.Map
    public void putAll(@d Map<? extends K, ? extends V> r2) {
        Intrinsics.checkParameterIsNotNull(r2, "from");
        getMap().putAll(r2);
    }

    @Override // java.util.Map
    @e
    public V remove(Object key) {
        return getMap().remove(key);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @d
    public String toString() {
        return getMap().toString();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }
}
