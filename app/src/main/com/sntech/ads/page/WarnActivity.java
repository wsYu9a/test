package com.sntech.ads.page;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.sntech.ads.R;
import com.sntech.ads.page.WarnActivity;

/* loaded from: classes4.dex */
public class WarnActivity extends Activity {

    /* renamed from: do */
    public boolean f16do = false;

    /* renamed from: do */
    public static void m43do(View view) {
        Process.killProcess(Process.myPid());
    }

    @Override // android.app.Activity
    public final void finish() {
        if (this.f16do) {
            super.finish();
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_warn);
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("warn_msg");
            String stringExtra2 = intent.getStringExtra("warn_button");
            this.f16do = intent.getBooleanExtra("warn_closable", false);
            ((TextView) findViewById(R.id.warn_msg)).setText(stringExtra);
            if (TextUtils.isEmpty(stringExtra2)) {
                findViewById(R.id.warn_button).setVisibility(8);
            } else {
                ((TextView) findViewById(R.id.warn_button)).setText(stringExtra2);
            }
        }
        findViewById(R.id.warn_button).setOnClickListener(new View.OnClickListener() { // from class: eg.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WarnActivity.m43do(view);
            }
        });
    }
}
