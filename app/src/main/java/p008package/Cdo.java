package p008package;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shu.priory.config.AdKeys;
import java.util.ArrayList;
import kj.a;
import kj.b;

/* renamed from: package.do */
/* loaded from: classes4.dex */
public final class Cdo extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        if (intExtra != 1 && intExtra == 2) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
            if (stringArrayListExtra != null) {
                stringArrayListExtra.contains(context.getPackageName());
                return;
            }
            return;
        }
        b b10 = b.b();
        String stringExtra = intent.getStringExtra("openIdType");
        b10.getClass();
        a aVar = AdKeys.OAID.equals(stringExtra) ? b10.f27851b : "vaid".equals(stringExtra) ? b10.f27853d : "aaid".equals(stringExtra) ? b10.f27852c : "udid".equals(stringExtra) ? b10.f27850a : null;
        if (aVar != null) {
            aVar.f27846a = 0L;
        }
    }
}
