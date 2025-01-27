package ie;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.mibook.ui.viewpagerlayoutmanager.ViewPagerLayoutManager;

/* loaded from: classes3.dex */
public class c {
    public static void a(RecyclerView recyclerView, ViewPagerLayoutManager viewPagerLayoutManager, int i10) {
        int D = viewPagerLayoutManager.D(i10);
        if (viewPagerLayoutManager.getOrientation() == 1) {
            recyclerView.smoothScrollBy(0, D);
        } else {
            recyclerView.smoothScrollBy(D, 0);
        }
    }

    public static void b(RecyclerView recyclerView, View view) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof ViewPagerLayoutManager) {
            ViewPagerLayoutManager viewPagerLayoutManager = (ViewPagerLayoutManager) layoutManager;
            a(recyclerView, viewPagerLayoutManager, viewPagerLayoutManager.v(view));
        }
    }
}
