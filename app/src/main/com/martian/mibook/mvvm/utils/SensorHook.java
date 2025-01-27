package com.martian.mibook.mvvm.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.libmars.activity.PermissionActivity;
import com.martian.mibook.mvvm.utils.ProxySensorListeners;
import com.martian.mibook.mvvm.utils.SensorHook;
import com.sigmob.sdk.base.mta.PointCategory;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import l9.p0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0001H\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0016\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/martian/mibook/mvvm/utils/SensorHook;", "", "()V", "inited", "", "intervalSeconds", "", "isCleanAdChannel", "listenerField", "Ljava/lang/reflect/Field;", "nextSensorEnableTime", "", "sensorListenersField", TTDownloadField.TT_TAG, "", "kotlin.jvm.PlatformType", "disableSensor", "", "enableSensor", PointCategory.INIT, "onRegisterSensorEventListener", PermissionActivity.f12046p, "Landroid/hardware/SensorEventListener;", "value", "onUnRegisterSensorEventListener", "setParams", "simulateSensor", f.X, "Landroid/content/Context;", "unableSensor", "unhook", "Companion", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SuppressLint({"BlockedPrivateApi", "PrivateApi", "SoonBlockedPrivateApi"})
@SourceDebugExtension({"SMAP\nSensorHook.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SensorHook.kt\ncom/martian/mibook/mvvm/utils/SensorHook\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,246:1\n18#2:247\n26#3:248\n*S KotlinDebug\n*F\n+ 1 SensorHook.kt\ncom/martian/mibook/mvvm/utils/SensorHook\n*L\n188#1:247\n188#1:248\n*E\n"})
/* loaded from: classes3.dex */
public final class SensorHook {

    /* renamed from: Companion, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    @l
    private static volatile SensorHook instance;
    private boolean inited;
    private int intervalSeconds;
    private boolean isCleanAdChannel;

    @l
    private Field listenerField;
    private long nextSensorEnableTime;

    @l
    private Field sensorListenersField;
    private final String tag;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/martian/mibook/mvvm/utils/SensorHook$Companion;", "", "()V", "instance", "Lcom/martian/mibook/mvvm/utils/SensorHook;", "getInstance", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nSensorHook.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SensorHook.kt\ncom/martian/mibook/mvvm/utils/SensorHook$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,246:1\n1#2:247\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @k
        public final SensorHook getInstance() {
            SensorHook sensorHook = SensorHook.instance;
            if (sensorHook == null) {
                synchronized (this) {
                    sensorHook = SensorHook.instance;
                    if (sensorHook == null) {
                        sensorHook = new SensorHook(null);
                        Companion companion = SensorHook.INSTANCE;
                        SensorHook.instance = sensorHook;
                    }
                }
            }
            return sensorHook;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SensorHook(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void init() {
        Object obj;
        if (this.inited) {
            return;
        }
        this.inited = true;
        try {
            p0.c(this.tag, "Start initializing SensorHook");
            Field declaredField = Class.forName("android.app.SystemServiceRegistry").getDeclaredField("SYSTEM_SERVICE_FETCHERS");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(null);
            Map map = TypeIntrinsics.isMutableMap(obj2) ? (Map) obj2 : null;
            if (map == null) {
                p0.c(this.tag, "SYSTEM_SERVICE_FETCHERS is not a Map");
            }
            if (map == null || (obj = map.get(bt.f23586ac)) == null) {
                p0.c(this.tag, "SENSOR_SERVICE not found in SYSTEM_SERVICE_FETCHERS");
                obj = Unit.INSTANCE;
            }
            Class<?> cls = Class.forName("android.app.SystemServiceRegistry$CachedServiceFetcher");
            Class<?> cls2 = Class.forName("android.hardware.SystemSensorManager");
            Class<?> cls3 = Class.forName("android.hardware.SystemSensorManager$SensorEventQueue");
            Field declaredField2 = cls2.getDeclaredField("mSensorListeners");
            declaredField2.setAccessible(true);
            this.sensorListenersField = declaredField2;
            Field declaredField3 = cls3.getDeclaredField("mListener");
            declaredField3.setAccessible(true);
            this.listenerField = declaredField3;
            Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), new InvocationHandler() { // from class: qd.c

                /* renamed from: b */
                public final /* synthetic */ Object f30004b;

                /* renamed from: c */
                public final /* synthetic */ SensorHook f30005c;

                public /* synthetic */ c(Object obj3, SensorHook this) {
                    obj = obj3;
                    this = this;
                }

                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj3, Method method, Object[] objArr) {
                    Object init$lambda$4;
                    init$lambda$4 = SensorHook.init$lambda$4(obj, this, obj3, method, objArr);
                    return init$lambda$4;
                }
            });
            Intrinsics.checkNotNull(newProxyInstance, "null cannot be cast to non-null type kotlin.Any");
            if (map != null) {
                map.put(bt.f23586ac, newProxyInstance);
            }
            p0.c(this.tag, "Hook传感器成功");
        } catch (Exception e10) {
            p0.c(this.tag, "Exception in init: " + e10.getMessage());
        }
    }

    public static final Object init$lambda$4(Object sensorService, SensorHook this$0, Object obj, Method method, Object[] objArr) {
        Intrinsics.checkNotNullParameter(sensorService, "$sensorService");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object invoke = method.invoke(sensorService, Arrays.copyOf(objArr, objArr.length));
        if (Intrinsics.areEqual(method.getName(), "getService")) {
            if (invoke instanceof SensorManager) {
                Field field = this$0.sensorListenersField;
                Object obj2 = field != null ? field.get(invoke) : null;
                HashMap hashMap = obj2 instanceof HashMap ? (HashMap) obj2 : null;
                if (hashMap == null) {
                    p0.c(this$0.tag, "SYSTEM_SERVICE_FETCHERS is not a Map");
                    return Boolean.FALSE;
                }
                ProxySensorListeners proxySensorListeners = new ProxySensorListeners(hashMap);
                proxySensorListeners.setOnDataChangeListener(new ProxySensorListeners.OnDataChangeListener() { // from class: com.martian.mibook.mvvm.utils.SensorHook$init$proxyFetcher$1$1
                    public SensorHook$init$proxyFetcher$1$1() {
                    }

                    @Override // com.martian.mibook.mvvm.utils.ProxySensorListeners.OnDataChangeListener
                    public void onDataChanged(@k SensorEventListener r52, @k Object value, int size) {
                        String str;
                        Intrinsics.checkNotNullParameter(r52, "key");
                        Intrinsics.checkNotNullParameter(value, "value");
                        str = SensorHook.this.tag;
                        p0.c(str, "注册SensorEventListener: " + r52.getClass().getName() + "，size = " + size);
                        SensorHook.this.onRegisterSensorEventListener(r52, value);
                    }

                    @Override // com.martian.mibook.mvvm.utils.ProxySensorListeners.OnDataChangeListener
                    public void onDataRemoved(@k SensorEventListener r52, int size) {
                        String str;
                        Intrinsics.checkNotNullParameter(r52, "key");
                        str = SensorHook.this.tag;
                        p0.c(str, "取消注册SensorEventListener: " + r52.getClass().getName() + ",size = " + size);
                        SensorHook.this.onUnRegisterSensorEventListener(r52);
                    }
                });
                Field field2 = this$0.sensorListenersField;
                if (field2 != null) {
                    field2.set(invoke, proxySensorListeners);
                }
            } else {
                p0.c(this$0.tag, "getService returned null or not a SensorManager");
            }
        }
        return invoke;
    }

    public final void onRegisterSensorEventListener(SensorEventListener r52, Object value) {
        Field field = this.listenerField;
        Object obj = field != null ? field.get(value) : null;
        if (obj == null || Proxy.isProxyClass(obj.getClass())) {
            return;
        }
        try {
            Object newProxyInstance = Proxy.newProxyInstance(r52.getClass().getClassLoader(), new Class[]{SensorEventListener.class}, new InvocationHandler() { // from class: qd.d

                /* renamed from: c */
                public final /* synthetic */ SensorEventListener f30007c;

                public /* synthetic */ d(SensorEventListener r522) {
                    key = r522;
                }

                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj2, Method method, Object[] objArr) {
                    Object onRegisterSensorEventListener$lambda$5;
                    onRegisterSensorEventListener$lambda$5 = SensorHook.onRegisterSensorEventListener$lambda$5(SensorHook.this, key, obj2, method, objArr);
                    return onRegisterSensorEventListener$lambda$5;
                }
            });
            Intrinsics.checkNotNull(newProxyInstance, "null cannot be cast to non-null type android.hardware.SensorEventListener");
            SensorEventListener sensorEventListener = (SensorEventListener) newProxyInstance;
            Field field2 = this.listenerField;
            if (field2 != null) {
                field2.set(value, sensorEventListener);
            }
        } catch (Exception unused) {
        }
    }

    public static final Object onRegisterSensorEventListener$lambda$5(SensorHook this$0, SensorEventListener key, Object obj, Method method, Object[] objArr) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(key, "$key");
        if (Intrinsics.areEqual(method != null ? method.getName() : null, "onSensorChanged")) {
            Object obj2 = objArr != null ? objArr[0] : null;
            SensorEvent sensorEvent = obj2 instanceof SensorEvent ? (SensorEvent) obj2 : null;
            if (this$0.unableSensor() && sensorEvent != null) {
                Sensor sensor = sensorEvent.sensor;
                Integer valueOf = sensor != null ? Integer.valueOf(sensor.getType()) : null;
                if ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 4)) {
                    float[] values = sensorEvent.values;
                    Intrinsics.checkNotNullExpressionValue(values, "values");
                    ArraysKt.fill$default(values, 0.0f, 0, 0, 6, (Object) null);
                }
            }
        }
        if (method == null) {
            return null;
        }
        if (objArr == null) {
            objArr = new Object[0];
        }
        return method.invoke(key, Arrays.copyOf(objArr, objArr.length));
    }

    public final void onUnRegisterSensorEventListener(SensorEventListener r12) {
    }

    private final boolean unableSensor() {
        return this.isCleanAdChannel || System.currentTimeMillis() < this.nextSensorEnableTime;
    }

    public final void disableSensor() {
        p0.c(this.tag, "disableSensor");
        this.nextSensorEnableTime = System.currentTimeMillis() + (this.intervalSeconds * 1000);
        init();
    }

    public final void enableSensor() {
        p0.c(this.tag, "enableSensor");
        this.nextSensorEnableTime = -1L;
    }

    public final void setParams(boolean isCleanAdChannel, int intervalSeconds) {
        this.isCleanAdChannel = isCleanAdChannel;
        this.intervalSeconds = intervalSeconds;
    }

    public final void simulateSensor(@k Context r42) {
        Intrinsics.checkNotNullParameter(r42, "context");
        Object systemService = r42.getSystemService(bt.f23586ac);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        SensorManager sensorManager = (SensorManager) systemService;
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        if (defaultSensor != null) {
            sensorManager.registerListener(new SensorEventListener() { // from class: com.martian.mibook.mvvm.utils.SensorHook$simulateSensor$1$1
                @Override // android.hardware.SensorEventListener
                public void onAccuracyChanged(@l Sensor r12, int accuracy) {
                }

                @Override // android.hardware.SensorEventListener
                public void onSensorChanged(@l SensorEvent r12) {
                }
            }, defaultSensor, 3);
        }
    }

    @SuppressLint({"BlockedPrivateApi", "PrivateApi"})
    public final void unhook() {
        Map map;
        if (this.inited) {
            try {
                try {
                    Field declaredField = Class.forName("android.app.SystemServiceRegistry").getDeclaredField("SYSTEM_SERVICE_FETCHERS");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(null);
                    map = TypeIntrinsics.isMutableMap(obj) ? (Map) obj : null;
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                if (map == null) {
                    return;
                }
                Object obj2 = map.get(bt.f23586ac);
                if (obj2 != null) {
                    map.put(bt.f23586ac, obj2);
                }
            } finally {
                this.inited = false;
            }
        }
    }

    private SensorHook() {
        this.tag = SensorHook.class.getName();
        this.nextSensorEnableTime = -1L;
        this.intervalSeconds = 30;
    }
}
