package com.kwad.components.core.r;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.umeng.analytics.pro.am;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class l {
    private static volatile l Qb;
    private SensorManager Qc;
    private final Map<String, a> Qd = new HashMap();
    private final Map<String, Set<SensorEventListener>> Qe = new ConcurrentHashMap();

    public static class a implements SensorEventListener {
        private final WeakReference<l> Qf;
        private final String key;

        public a(String str, l lVar) {
            this.key = str;
            this.Qf = new WeakReference<>(lVar);
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            l lVar = this.Qf.get();
            if (lVar != null) {
                lVar.a(this.key, sensorEvent);
            }
        }
    }

    public interface b {
        void onFailed();
    }

    private l() {
    }

    private void a(String str, int i2, Sensor sensor) {
        getSensorManager().registerListener(aF(str), sensor, aK(i2));
    }

    public void a(String str, SensorEvent sensorEvent) {
        Set<SensorEventListener> set = this.Qe.get(str);
        if (set != null) {
            Iterator<SensorEventListener> it = set.iterator();
            while (it.hasNext()) {
                it.next().onSensorChanged(sensorEvent);
            }
        }
    }

    private void aE(String str) {
        a aVar = this.Qd.get(str);
        if (aVar != null) {
            this.Qd.remove(str);
            getSensorManager().unregisterListener(aVar);
        }
    }

    private a aF(String str) {
        a aVar = this.Qd.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(str, this);
        this.Qd.put(str, aVar2);
        return aVar2;
    }

    @Nullable
    private Sensor aJ(int i2) {
        SensorManager sensorManager;
        int i3;
        if (getSensorManager() == null) {
            return null;
        }
        if (i2 == 1) {
            sensorManager = getSensorManager();
            i3 = 10;
        } else {
            if (i2 != 2) {
                return null;
            }
            sensorManager = getSensorManager();
            i3 = 4;
        }
        return sensorManager.getDefaultSensor(i3);
    }

    private static int aK(int i2) {
        if (i2 == -3) {
            return 2;
        }
        if (i2 != -2) {
            return i2 != -1 ? 3 : 0;
        }
        return 1;
    }

    private SensorManager getSensorManager() {
        if (this.Qc == null) {
            this.Qc = (SensorManager) ServiceProvider.getContext().getSystemService(am.ac);
        }
        return this.Qc;
    }

    private static String l(int i2, int i3) {
        return i2 + "_" + i3;
    }

    @NonNull
    public static l pS() {
        if (Qb == null) {
            synchronized (l.class) {
                if (Qb == null) {
                    Qb = new l();
                }
            }
        }
        return Qb;
    }

    public final void a(int i2, int i3, SensorEventListener sensorEventListener, b bVar) {
        Sensor aJ = aJ(i2);
        if (aJ == null) {
            bVar.onFailed();
            return;
        }
        String l = l(i2, i3);
        Set<SensorEventListener> set = this.Qe.get(l);
        if (set != null) {
            set.add(sensorEventListener);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(sensorEventListener);
        this.Qe.put(l, hashSet);
        a(l, i3, aJ);
    }

    public final void a(SensorEventListener sensorEventListener) {
        for (Map.Entry<String, Set<SensorEventListener>> entry : this.Qe.entrySet()) {
            Iterator<SensorEventListener> it = entry.getValue().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().equals(sensorEventListener)) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
            if (entry.getValue().size() == 0) {
                aE(entry.getKey());
            }
        }
    }
}
