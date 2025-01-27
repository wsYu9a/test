package com.martian.mibook.activity.reader;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.utils.v0;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.f.s3;
import com.martian.mibook.f.t3;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class TypefaceScanActivity extends com.martian.mibook.lib.model.b.a {
    private final Fragment[] F = {r2(), s2()};

    private List<v0.a> t2() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.F.length; i2++) {
            arrayList.add(new v0.a().d(u2(i2)).c(this.F[i2]));
        }
        return arrayList;
    }

    @Override // com.martian.libmars.activity.g1
    public void onBackClick(View view) {
        finish();
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_viewpager);
        a2(true);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_content);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new com.martian.libmars.utils.v0(getSupportFragmentManager(), t2()));
        ViewStub viewStub = (ViewStub) findViewById(R.id.actionbar_container);
        viewStub.setLayoutResource(R.layout.layout_xttab);
        viewStub.setVisibility(0);
        ((MagicIndicator) findViewById(R.id.magic_indicator)).setNavigator(viewPager);
    }

    protected Fragment r2() {
        return s3.t(new String[]{"ttf"}, "TYPEFACE");
    }

    protected Fragment s2() {
        return t3.r(MiConfigSingleton.V3().y3(), new String[]{"ttf"}, "TYPEFACE");
    }

    public String u2(int position) {
        if (position == 0) {
            return getResources().getString(R.string.ttf_scan);
        }
        if (position == 1) {
            return getResources().getString(R.string.book_directory);
        }
        throw new IllegalStateException("Unspecified fragment title.");
    }
}
