package com.martian.mibook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.martian.mibook.e.h7;
import com.martian.mibook.j.s2;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes3.dex */
public class TtsOptimizeActivity extends com.martian.mibook.lib.model.b.a {
    private com.martian.mibook.e.y F;

    /* renamed from: r2 */
    public /* synthetic */ void s2(final com.martian.mibook.tts.c intentWrapper, View view) {
        intentWrapper.i(this);
    }

    private void t2(List<com.martian.mibook.tts.c> intentWrapperList) {
        if (intentWrapperList.isEmpty()) {
            return;
        }
        for (final com.martian.mibook.tts.c cVar : intentWrapperList) {
            h7 a2 = h7.a(getLayoutInflater().inflate(R.layout.tts_setting_item, (ViewGroup) null));
            a2.f12095e.setText(cVar.c());
            a2.f12092b.setText(cVar.a());
            a2.f12096f.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.z0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TtsOptimizeActivity.this.s2(cVar, view);
                }
            });
            a2.f12093c.setText(getString(cVar.d() ? R.string.already_set : R.string.go_to_setting));
            this.F.f12951b.addView(a2.getRoot());
        }
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1025) {
            this.F.f12951b.removeAllViews();
            t2(s2.l(this));
        }
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts_optimize);
        this.F = com.martian.mibook.e.y.a(g2());
        t2(s2.l(this));
    }
}
