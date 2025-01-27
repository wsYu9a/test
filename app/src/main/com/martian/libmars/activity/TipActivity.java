package com.martian.libmars.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.martian.libmars.R;
import com.martian.libmars.activity.TipActivity;

/* loaded from: classes3.dex */
public class TipActivity extends Activity {
    public final /* synthetic */ boolean b(View view, MotionEvent motionEvent) {
        finish();
        return false;
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tip);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.tip_parent_view);
        ((TextView) findViewById(R.id.open_hint)).setText("找到[" + getString(R.string.app_name) + "]，并开启权限");
        relativeLayout.setOnTouchListener(new View.OnTouchListener() { // from class: d9.l
            public /* synthetic */ l() {
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean b10;
                b10 = TipActivity.this.b(view, motionEvent);
                return b10;
            }
        });
    }
}
