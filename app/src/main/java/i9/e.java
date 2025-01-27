package i9;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import ba.m;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;

/* loaded from: classes3.dex */
public class e implements ConnectivityMonitorFactory {
    public static boolean a() {
        String lowerCase = Build.BRAND.toLowerCase();
        return lowerCase.contains("huawei") || lowerCase.contains("honor");
    }

    public static boolean b() {
        return a() && !m.n();
    }

    @Override // com.bumptech.glide.manager.ConnectivityMonitorFactory
    @NonNull
    public ConnectivityMonitor build(@NonNull Context context, @NonNull ConnectivityMonitor.ConnectivityListener connectivityListener) {
        return new a();
    }

    public class a implements ConnectivityMonitor {
        public a() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onDestroy() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStart() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStop() {
        }
    }
}
