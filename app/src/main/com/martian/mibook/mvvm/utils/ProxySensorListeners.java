package com.martian.mibook.mvvm.utils;

import android.hardware.SensorEventListener;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.martian.libmars.activity.PermissionActivity;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004:\u0001)B)\u0012\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0003H\u0016J\u0013\u0010 \u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001d\u001a\u00020\u0002H\u0096\u0002J\b\u0010!\u001a\u00020\u001cH\u0016J\u001a\u0010\"\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0003H\u0016J\u001e\u0010#\u001a\u00020\u001a2\u0014\u0010$\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030%H\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u000e\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b0\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Lcom/martian/mibook/mvvm/utils/ProxySensorListeners;", "Ljava/util/HashMap;", "Landroid/hardware/SensorEventListener;", "", "Lkotlin/collections/HashMap;", "original", "(Ljava/util/HashMap;)V", "dataChangeListener", "Lcom/martian/mibook/mvvm/utils/ProxySensorListeners$OnDataChangeListener;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "proxyMap", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "clear", "", "containsKey", "", PermissionActivity.f12046p, "containsValue", "value", MonitorConstants.CONNECT_TYPE_GET, "isEmpty", "put", "putAll", TypedValues.TransitionType.S_FROM, "", "remove", "setOnDataChangeListener", "listener", "OnDataChangeListener", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nProxySensorListeners.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProxySensorListeners.kt\ncom/martian/mibook/mvvm/utils/ProxySensorListeners\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,89:1\n215#2,2:90\n1855#3,2:92\n*S KotlinDebug\n*F\n+ 1 ProxySensorListeners.kt\ncom/martian/mibook/mvvm/utils/ProxySensorListeners\n*L\n59#1:90,2\n77#1:92,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ProxySensorListeners extends HashMap<SensorEventListener, Object> {

    @l
    private OnDataChangeListener dataChangeListener;

    @k
    private final HashMap<SensorEventListener, Object> original;

    @k
    private final HashMap<SensorEventListener, Object> proxyMap;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/martian/mibook/mvvm/utils/ProxySensorListeners$OnDataChangeListener;", "", "onDataChanged", "", PermissionActivity.f12046p, "Landroid/hardware/SensorEventListener;", "value", "size", "", "onDataRemoved", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnDataChangeListener {
        void onDataChanged(@k SensorEventListener r12, @k Object value, int size);

        void onDataRemoved(@k SensorEventListener r12, int size);
    }

    public ProxySensorListeners(@k HashMap<SensorEventListener, Object> original) {
        Intrinsics.checkNotNullParameter(original, "original");
        this.original = original;
        HashMap<SensorEventListener, Object> hashMap = new HashMap<>();
        synchronized (original) {
            hashMap.putAll(original);
            Unit unit = Unit.INSTANCE;
        }
        this.proxyMap = hashMap;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public synchronized void clear() {
        Set<SensorEventListener> keySet = this.proxyMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
        List<SensorEventListener> list = CollectionsKt.toList(keySet);
        this.proxyMap.clear();
        for (SensorEventListener sensorEventListener : list) {
            OnDataChangeListener onDataChangeListener = this.dataChangeListener;
            if (onDataChangeListener != null) {
                Intrinsics.checkNotNull(sensorEventListener);
                onDataChangeListener.onDataRemoved(sensorEventListener, 0);
            }
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof SensorEventListener) {
            return containsKey((SensorEventListener) obj);
        }
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public synchronized boolean containsValue(@l Object value) {
        if (value == null) {
            return false;
        }
        return this.proxyMap.containsValue(value);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<SensorEventListener, Object>> entrySet() {
        return getEntries();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof SensorEventListener) {
            return get((SensorEventListener) obj);
        }
        return null;
    }

    @k
    public synchronized Set<Map.Entry<SensorEventListener, Object>> getEntries() {
        Set<Map.Entry<SensorEventListener, Object>> entrySet;
        entrySet = this.proxyMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
        return entrySet;
    }

    @k
    public synchronized Set<SensorEventListener> getKeys() {
        Set<SensorEventListener> keySet;
        keySet = this.proxyMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
        return keySet;
    }

    public /* bridge */ Object getOrDefault(SensorEventListener sensorEventListener, Object obj) {
        return super.getOrDefault((Object) sensorEventListener, (SensorEventListener) obj);
    }

    public synchronized int getSize() {
        return this.proxyMap.size();
    }

    @k
    public synchronized Collection<Object> getValues() {
        Collection<Object> values;
        values = this.proxyMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        return values;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public synchronized boolean isEmpty() {
        return this.proxyMap.isEmpty();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<SensorEventListener> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public synchronized void putAll(@k Map<? extends SensorEventListener, ? extends Object> r52) {
        Intrinsics.checkNotNullParameter(r52, "from");
        this.proxyMap.putAll(r52);
        for (Map.Entry<? extends SensorEventListener, ? extends Object> entry : r52.entrySet()) {
            SensorEventListener key = entry.getKey();
            Object value = entry.getValue();
            OnDataChangeListener onDataChangeListener = this.dataChangeListener;
            if (onDataChangeListener != null) {
                onDataChangeListener.onDataChanged(key, value, this.proxyMap.size());
            }
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        if (obj instanceof SensorEventListener) {
            return remove((SensorEventListener) obj);
        }
        return null;
    }

    public final void setOnDataChangeListener(@k OnDataChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dataChangeListener = listener;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Object> values() {
        return getValues();
    }

    public synchronized boolean containsKey(@k SensorEventListener r22) {
        Intrinsics.checkNotNullParameter(r22, "key");
        return this.proxyMap.containsKey(r22);
    }

    @l
    public synchronized Object get(@k SensorEventListener key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.proxyMap.get(key);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof SensorEventListener) ? obj2 : getOrDefault((SensorEventListener) obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    @l
    public synchronized Object put(@k SensorEventListener r42, @k Object value) {
        Object put;
        Intrinsics.checkNotNullParameter(r42, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        put = this.proxyMap.put(r42, value);
        OnDataChangeListener onDataChangeListener = this.dataChangeListener;
        if (onDataChangeListener != null) {
            onDataChangeListener.onDataChanged(r42, value, this.proxyMap.size());
        }
        return put;
    }

    public /* bridge */ boolean remove(SensorEventListener sensorEventListener, Object obj) {
        return super.remove((Object) sensorEventListener, obj);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof SensorEventListener) && obj2 != null) {
            return remove((SensorEventListener) obj, obj2);
        }
        return false;
    }

    @l
    public synchronized Object remove(@k SensorEventListener r42) {
        Object remove;
        OnDataChangeListener onDataChangeListener;
        Intrinsics.checkNotNullParameter(r42, "key");
        remove = this.proxyMap.remove(r42);
        if (remove != null && (onDataChangeListener = this.dataChangeListener) != null) {
            onDataChangeListener.onDataRemoved(r42, this.proxyMap.size());
        }
        return remove;
    }
}
