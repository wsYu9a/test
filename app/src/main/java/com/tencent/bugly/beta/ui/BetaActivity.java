package com.tencent.bugly.beta.ui;

import android.R;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.global.b;
import java.util.Map;

/* loaded from: classes4.dex */
public class BetaActivity extends FragmentActivity {
    public Runnable onDestroyRunnable = null;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            if (Beta.dialogFullScreen) {
                getWindow().setFlags(1024, 1024);
            }
            View findViewById = getWindow().getDecorView().findViewById(R.id.content);
            if (findViewById != null) {
                findViewById.setOnClickListener(new b(1, this, findViewById));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int intExtra = getIntent().getIntExtra("frag", -1);
        Map<Integer, BaseFrag> map = UiManager.TEMP_FRAG;
        BaseFrag baseFrag = map.get(Integer.valueOf(intExtra));
        if (baseFrag == null) {
            finish();
        } else {
            getSupportFragmentManager().beginTransaction().add(R.id.content, baseFrag).commit();
            map.remove(Integer.valueOf(intExtra));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Runnable runnable = this.onDestroyRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // android.app.Activity, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKeyDown(int r3, android.view.KeyEvent r4) {
        /*
            r2 = this;
            androidx.fragment.app.FragmentManager r0 = r2.getSupportFragmentManager()
            r1 = 16908290(0x1020002, float:2.3877235E-38)
            androidx.fragment.app.Fragment r0 = r0.findFragmentById(r1)
            boolean r1 = r0 instanceof com.tencent.bugly.beta.ui.BaseFrag     // Catch: java.lang.Exception -> L16
            if (r1 == 0) goto L16
            com.tencent.bugly.beta.ui.BaseFrag r0 = (com.tencent.bugly.beta.ui.BaseFrag) r0     // Catch: java.lang.Exception -> L16
            boolean r0 = r0.onKeyDown(r3, r4)     // Catch: java.lang.Exception -> L16
            goto L17
        L16:
            r0 = 0
        L17:
            if (r0 != 0) goto L1e
            boolean r3 = super.onKeyDown(r3, r4)
            return r3
        L1e:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.ui.BetaActivity.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }
}
