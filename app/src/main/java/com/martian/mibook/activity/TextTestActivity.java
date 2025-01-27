package com.martian.mibook.activity;

import android.os.Bundle;
import android.view.View;
import com.martian.mibook.R;
import com.martian.mibook.activity.TextTestActivity;
import com.martian.mibook.databinding.ActivityTextTestBinding;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import l9.i0;
import l9.p0;

/* loaded from: classes3.dex */
public class TextTestActivity extends MiBackableActivity {
    public ActivityTextTestBinding A;

    public final /* synthetic */ void M2(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt <= 0) {
                parseInt = 1;
            }
            this.A.textSize.setText(String.valueOf(parseInt));
            float f10 = parseInt;
            this.A.textId1.setTextSize(f10);
            this.A.textId2.setTextSize(f10);
            this.A.textId3.setTextSize(f10);
            this.A.textId4.setTextSize(f10);
            this.A.textId5.setTextSize(f10);
            this.A.textId6.setTextSize(f10);
            this.A.textId7.setTextSize(f10);
            this.A.textId8.setTextSize(f10);
            this.A.textId9.setTextSize(f10);
            this.A.textId10.setTextSize(f10);
            this.A.textId11.setTextSize(f10);
        } catch (Exception e10) {
            p0.b(e10.getMessage());
        }
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_text_test);
        this.A = ActivityTextTestBinding.bind(D2());
    }

    public void onTextSizeClick(View view) {
        i0.D0(this, "字号", this.A.textSize.getText().toString(), false, false, new i0.j() { // from class: qa.c0
            public /* synthetic */ c0() {
            }

            @Override // l9.i0.j
            public final void a(String str) {
                TextTestActivity.this.M2(str);
            }
        });
    }
}
