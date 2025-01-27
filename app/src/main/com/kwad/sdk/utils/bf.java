package com.kwad.sdk.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public class bf {
    private static volatile bf aUu;
    private final Map<String, a> aUv = new ConcurrentHashMap();
    private final Map<String, CopyOnWriteArraySet<SensorEventListener>> aUw = new ConcurrentHashMap();
    private boolean aUx = false;

    /* renamed from: com.kwad.sdk.utils.bf$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.c.d {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            com.kwad.sdk.core.d.c.d("SensorDataManager", "onBackToBackground");
            SensorManager checkAndObtainSensorManager = bh.OC().checkAndObtainSensorManager(ServiceProvider.getContext());
            for (String str : bf.this.aUv.keySet()) {
                try {
                    checkAndObtainSensorManager.unregisterListener((a) bf.this.aUv.get(str));
                    com.kwad.sdk.core.d.c.d("SensorDataManager", "unregister successfully: " + str);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            com.kwad.sdk.core.d.c.d("SensorDataManager", "onBackToForeground ");
            SensorManager checkAndObtainSensorManager = bh.OC().checkAndObtainSensorManager(ServiceProvider.getContext());
            for (String str : bf.this.aUv.keySet()) {
                a aVar = (a) bf.this.aUv.get(str);
                if (aVar != null) {
                    checkAndObtainSensorManager.registerListener(aVar, bf.a(bf.this, Integer.parseInt(str.split(hf.e.f26694a)[0])), bf.b(bf.this, Integer.parseInt(str.split(hf.e.f26694a)[1])));
                    com.kwad.sdk.core.d.c.d("SensorDataManager", "register successfully: " + str);
                }
            }
        }
    }

    public static class a implements SensorEventListener {
        private final WeakReference<bf> aaP;
        private final String key;

        public a(String str, bf bfVar) {
            this.key = str;
            this.aaP = new WeakReference<>(bfVar);
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            bf bfVar = this.aaP.get();
            if (bfVar != null) {
                bfVar.a(this.key, sensorEvent);
            }
        }
    }

    public interface b {
        void onFailed();
    }

    private bf() {
        com.kwad.sdk.core.c.b.Fi();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.bf.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                com.kwad.sdk.core.d.c.d("SensorDataManager", "onBackToBackground");
                SensorManager checkAndObtainSensorManager = bh.OC().checkAndObtainSensorManager(ServiceProvider.getContext());
                for (String str : bf.this.aUv.keySet()) {
                    try {
                        checkAndObtainSensorManager.unregisterListener((a) bf.this.aUv.get(str));
                        com.kwad.sdk.core.d.c.d("SensorDataManager", "unregister successfully: " + str);
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                com.kwad.sdk.core.d.c.d("SensorDataManager", "onBackToForeground ");
                SensorManager checkAndObtainSensorManager = bh.OC().checkAndObtainSensorManager(ServiceProvider.getContext());
                for (String str : bf.this.aUv.keySet()) {
                    a aVar = (a) bf.this.aUv.get(str);
                    if (aVar != null) {
                        checkAndObtainSensorManager.registerListener(aVar, bf.a(bf.this, Integer.parseInt(str.split(hf.e.f26694a)[0])), bf.b(bf.this, Integer.parseInt(str.split(hf.e.f26694a)[1])));
                        com.kwad.sdk.core.d.c.d("SensorDataManager", "register successfully: " + str);
                    }
                }
            }
        });
    }

    private static String A(int i10, int i11) {
        return i10 + hf.e.f26694a + i11;
    }

    @NonNull
    public static bf Ox() {
        if (aUu == null) {
            synchronized (bf.class) {
                try {
                    if (aUu == null) {
                        aUu = new bf();
                    }
                } finally {
                }
            }
        }
        return aUu;
    }

    public static /* synthetic */ Sensor a(bf bfVar, int i10) {
        return ej(i10);
    }

    public static /* synthetic */ int b(bf bfVar, int i10) {
        return ek(i10);
    }

    @Nullable
    private static Sensor ej(int i10) {
        bh OC = bh.OC();
        Context context = ServiceProvider.getContext();
        if (i10 == 1) {
            return OC.getDefaultSensor(context, 10);
        }
        if (i10 == 2) {
            return OC.getDefaultSensor(context, 4);
        }
        if (i10 == 3) {
            return OC.getDefaultSensor(context, 1);
        }
        if (i10 != 4) {
            return null;
        }
        return OC.getDefaultSensor(context, 9);
    }

    private static int ek(int i10) {
        if (i10 == -3) {
            return 2;
        }
        if (i10 != -2) {
            return i10 != -1 ? 3 : 0;
        }
        return 1;
    }

    private void ha(String str) {
        a aVar = this.aUv.get(str);
        if (aVar != null) {
            this.aUv.remove(str);
            try {
                bh.OC().unregisterListener(aVar);
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            }
        }
    }

    private a hb(String str) {
        a aVar = this.aUv.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(str, this);
        this.aUv.put(str, aVar2);
        return aVar2;
    }

    public final synchronized void a(int i10, int i11, SensorEventListener sensorEventListener, b bVar) {
        Sensor ej2 = ej(i10);
        if (ej2 == null) {
            if (bVar != null) {
                bVar.onFailed();
            }
            return;
        }
        String A = A(i10, i11);
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.aUw.get(A);
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        }
        copyOnWriteArraySet.add(sensorEventListener);
        if (copyOnWriteArraySet.size() == 1) {
            this.aUw.put(A, copyOnWriteArraySet);
            a(A, i11, ej2);
        }
    }

    public final synchronized void a(SensorEventListener sensorEventListener) {
        try {
            for (Map.Entry<String, CopyOnWriteArraySet<SensorEventListener>> entry : this.aUw.entrySet()) {
                CopyOnWriteArraySet<SensorEventListener> value = entry.getValue();
                Iterator<SensorEventListener> it = value.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SensorEventListener next = it.next();
                    if (next.equals(sensorEventListener)) {
                        value.remove(next);
                        break;
                    }
                }
                if (value.size() == 0) {
                    ha(entry.getKey());
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void a(String str, int i10, Sensor sensor) {
        boolean Oo = az.Oo();
        this.aUx = Oo;
        if (Oo) {
            return;
        }
        bh.OC().registerListener(ServiceProvider.getContext(), hb(str), sensor, ek(i10));
    }

    public void a(String str, SensorEvent sensorEvent) {
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.aUw.get(str);
        if (copyOnWriteArraySet != null) {
            Iterator<SensorEventListener> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                it.next().onSensorChanged(sensorEvent);
            }
        }
    }
}
