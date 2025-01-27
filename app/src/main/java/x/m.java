package x;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.location.LocationListenerCompat;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class m {
    public static void b(LocationListenerCompat locationListenerCompat, @NonNull List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            locationListenerCompat.onLocationChanged((Location) list.get(i10));
        }
    }

    public static void a(LocationListenerCompat locationListenerCompat, int i10) {
    }

    public static void c(LocationListenerCompat locationListenerCompat, @NonNull String str) {
    }

    public static void d(LocationListenerCompat locationListenerCompat, @NonNull String str) {
    }

    public static void e(LocationListenerCompat locationListenerCompat, @NonNull String str, int i10, @Nullable Bundle bundle) {
    }
}
