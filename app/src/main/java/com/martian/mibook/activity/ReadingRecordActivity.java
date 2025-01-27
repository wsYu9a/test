package com.martian.mibook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.martian.mibook.f.a4;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class ReadingRecordActivity extends com.martian.mibook.lib.model.b.a {
    private static final String F = "READING_RECORD_FRAGMENT_TAG";
    private a4 G;

    @Override // com.martian.libmars.activity.j1
    protected void U1(boolean nightMode) {
        super.U1(nightMode);
        a4 a4Var = this.G;
        if (a4Var != null) {
            a4Var.S();
        }
    }

    public void onActionMenuClick(View view) {
        if (this.G.p() <= 0) {
            k1(getString(R.string.no_data));
        } else {
            this.G.T(!r2.t());
        }
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == -1) {
            com.martian.mibook.lib.model.g.b.K(this, "登录成功-同步阅读记录");
        }
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_fragment);
        k2(getString(R.string.batch_delete));
        a4 a4Var = (a4) getSupportFragmentManager().findFragmentByTag(F);
        this.G = a4Var;
        if (a4Var == null) {
            this.G = new a4();
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, this.G, F).commit();
        }
    }

    @Override // com.martian.libmars.activity.h1, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 || !this.G.t()) {
            return super.onKeyDown(keyCode, event);
        }
        this.G.T(false);
        return true;
    }
}
