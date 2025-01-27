package uf;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import pf.e;

/* loaded from: classes3.dex */
public class b {
    public static void b(View view, e eVar, sf.a aVar) {
        try {
            if (view instanceof CoordinatorLayout) {
                eVar.l().P(false);
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    if (childAt instanceof AppBarLayout) {
                        ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener() { // from class: uf.a
                            public /* synthetic */ a() {
                            }

                            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                            public final void onOffsetChanged(AppBarLayout appBarLayout, int i10) {
                                b.c(sf.a.this, appBarLayout, i10);
                            }
                        });
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static /* synthetic */ void c(sf.a aVar, AppBarLayout appBarLayout, int i10) {
        aVar.j(i10 >= 0, appBarLayout.getTotalScrollRange() + i10 <= 0);
    }
}
