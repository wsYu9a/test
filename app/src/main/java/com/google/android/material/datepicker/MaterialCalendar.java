package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class MaterialCalendar<S> extends r<S> {

    /* renamed from: b */
    private static final String f6972b = "THEME_RES_ID_KEY";

    /* renamed from: c */
    private static final String f6973c = "GRID_SELECTOR_KEY";

    /* renamed from: d */
    private static final String f6974d = "CALENDAR_CONSTRAINTS_KEY";

    /* renamed from: e */
    private static final String f6975e = "CURRENT_MONTH_KEY";

    /* renamed from: f */
    private static final int f6976f = 3;

    /* renamed from: g */
    @VisibleForTesting
    static final Object f6977g = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: h */
    @VisibleForTesting
    static final Object f6978h = "NAVIGATION_PREV_TAG";

    /* renamed from: i */
    @VisibleForTesting
    static final Object f6979i = "NAVIGATION_NEXT_TAG";

    /* renamed from: j */
    @VisibleForTesting
    static final Object f6980j = "SELECTOR_TOGGLE_TAG";
    private int k;

    @Nullable
    private com.google.android.material.datepicker.f<S> l;

    @Nullable
    private com.google.android.material.datepicker.a m;

    @Nullable
    private n n;
    private CalendarSelector o;
    private com.google.android.material.datepicker.c p;
    private RecyclerView q;
    private RecyclerView r;
    private View s;
    private View t;

    enum CalendarSelector {
        DAY,
        YEAR
    }

    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f6981a;

        a(int i2) {
            this.f6981a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialCalendar.this.r.smoothScrollToPosition(this.f6981a);
        }
    }

    class b extends AccessibilityDelegateCompat {
        b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    class c extends u {

        /* renamed from: b */
        final /* synthetic */ int f6984b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, int i2, boolean z, int i3) {
            super(context, i2, z);
            this.f6984b = i3;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
            if (this.f6984b == 0) {
                iArr[0] = MaterialCalendar.this.r.getWidth();
                iArr[1] = MaterialCalendar.this.r.getWidth();
            } else {
                iArr[0] = MaterialCalendar.this.r.getHeight();
                iArr[1] = MaterialCalendar.this.r.getHeight();
            }
        }
    }

    class d implements k {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.MaterialCalendar.k
        public void a(long j2) {
            if (MaterialCalendar.this.m.g().c(j2)) {
                MaterialCalendar.this.l.j0(j2);
                Iterator<q<S>> it = MaterialCalendar.this.f7091a.iterator();
                while (it.hasNext()) {
                    it.next().b(MaterialCalendar.this.l.i0());
                }
                MaterialCalendar.this.r.getAdapter().notifyDataSetChanged();
                if (MaterialCalendar.this.q != null) {
                    MaterialCalendar.this.q.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    class e extends RecyclerView.ItemDecoration {

        /* renamed from: a */
        private final Calendar f6987a = w.v();

        /* renamed from: b */
        private final Calendar f6988b = w.v();

        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            if ((recyclerView.getAdapter() instanceof x) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                x xVar = (x) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (Pair<Long, Long> pair : MaterialCalendar.this.l.d0()) {
                    Long l = pair.first;
                    if (l != null && pair.second != null) {
                        this.f6987a.setTimeInMillis(l.longValue());
                        this.f6988b.setTimeInMillis(pair.second.longValue());
                        int o = xVar.o(this.f6987a.get(1));
                        int o2 = xVar.o(this.f6988b.get(1));
                        View findViewByPosition = gridLayoutManager.findViewByPosition(o);
                        View findViewByPosition2 = gridLayoutManager.findViewByPosition(o2);
                        int spanCount = o / gridLayoutManager.getSpanCount();
                        int spanCount2 = o2 / gridLayoutManager.getSpanCount();
                        int i2 = spanCount;
                        while (i2 <= spanCount2) {
                            if (gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i2) != null) {
                                canvas.drawRect(i2 == spanCount ? findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2) : 0, r9.getTop() + MaterialCalendar.this.p.f7027d.e(), i2 == spanCount2 ? findViewByPosition2.getLeft() + (findViewByPosition2.getWidth() / 2) : recyclerView.getWidth(), r9.getBottom() - MaterialCalendar.this.p.f7027d.b(), MaterialCalendar.this.p.f7031h);
                            }
                            i2++;
                        }
                    }
                }
            }
        }
    }

    class f extends AccessibilityDelegateCompat {
        f() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setHintText(MaterialCalendar.this.t.getVisibility() == 0 ? MaterialCalendar.this.getString(R.string.mtrl_picker_toggle_to_year_selection) : MaterialCalendar.this.getString(R.string.mtrl_picker_toggle_to_day_selection));
        }
    }

    class g extends RecyclerView.OnScrollListener {

        /* renamed from: a */
        final /* synthetic */ p f6991a;

        /* renamed from: b */
        final /* synthetic */ MaterialButton f6992b;

        g(p pVar, MaterialButton materialButton) {
            this.f6991a = pVar;
            this.f6992b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                CharSequence text = this.f6992b.getText();
                if (Build.VERSION.SDK_INT >= 16) {
                    recyclerView.announceForAccessibility(text);
                } else {
                    recyclerView.sendAccessibilityEvent(2048);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
            int findFirstVisibleItemPosition = i2 < 0 ? MaterialCalendar.this.r().findFirstVisibleItemPosition() : MaterialCalendar.this.r().findLastVisibleItemPosition();
            MaterialCalendar.this.n = this.f6991a.n(findFirstVisibleItemPosition);
            this.f6992b.setText(this.f6991a.o(findFirstVisibleItemPosition));
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialCalendar.this.w();
        }
    }

    class i implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ p f6995a;

        i(p pVar) {
            this.f6995a = pVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int findFirstVisibleItemPosition = MaterialCalendar.this.r().findFirstVisibleItemPosition() + 1;
            if (findFirstVisibleItemPosition < MaterialCalendar.this.r.getAdapter().getItemCount()) {
                MaterialCalendar.this.u(this.f6995a.n(findFirstVisibleItemPosition));
            }
        }
    }

    class j implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ p f6997a;

        j(p pVar) {
            this.f6997a = pVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int findLastVisibleItemPosition = MaterialCalendar.this.r().findLastVisibleItemPosition() - 1;
            if (findLastVisibleItemPosition >= 0) {
                MaterialCalendar.this.u(this.f6997a.n(findLastVisibleItemPosition));
            }
        }
    }

    interface k {
        void a(long j2);
    }

    private void l(@NonNull View view, @NonNull p pVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.month_navigation_fragment_toggle);
        materialButton.setTag(f6980j);
        ViewCompat.setAccessibilityDelegate(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.month_navigation_previous);
        materialButton2.setTag(f6978h);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.month_navigation_next);
        materialButton3.setTag(f6979i);
        this.s = view.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.t = view.findViewById(R.id.mtrl_calendar_day_selector_frame);
        v(CalendarSelector.DAY);
        materialButton.setText(this.n.h());
        this.r.addOnScrollListener(new g(pVar, materialButton));
        materialButton.setOnClickListener(new h());
        materialButton3.setOnClickListener(new i(pVar));
        materialButton2.setOnClickListener(new j(pVar));
    }

    @NonNull
    private RecyclerView.ItemDecoration m() {
        return new e();
    }

    @Px
    static int q(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    }

    @NonNull
    static <T> MaterialCalendar<T> s(com.google.android.material.datepicker.f<T> fVar, int i2, @NonNull com.google.android.material.datepicker.a aVar) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt(f6972b, i2);
        bundle.putParcelable(f6973c, fVar);
        bundle.putParcelable(f6974d, aVar);
        bundle.putParcelable(f6975e, aVar.j());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    private void t(int i2) {
        this.r.post(new a(i2));
    }

    @Override // com.google.android.material.datepicker.r
    @Nullable
    public com.google.android.material.datepicker.f<S> c() {
        return this.l;
    }

    @Nullable
    com.google.android.material.datepicker.a n() {
        return this.m;
    }

    com.google.android.material.datepicker.c o() {
        return this.p;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.k = bundle.getInt(f6972b);
        this.l = (com.google.android.material.datepicker.f) bundle.getParcelable(f6973c);
        this.m = (com.google.android.material.datepicker.a) bundle.getParcelable(f6974d);
        this.n = (n) bundle.getParcelable(f6975e);
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.k);
        this.p = new com.google.android.material.datepicker.c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        n k2 = this.m.k();
        if (com.google.android.material.datepicker.k.x(contextThemeWrapper)) {
            i2 = R.layout.mtrl_calendar_vertical;
            i3 = 1;
        } else {
            i2 = R.layout.mtrl_calendar_horizontal;
            i3 = 0;
        }
        View inflate = cloneInContext.inflate(i2, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(R.id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new b());
        gridView.setAdapter((ListAdapter) new com.google.android.material.datepicker.j());
        gridView.setNumColumns(k2.f7075e);
        gridView.setEnabled(false);
        this.r = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_months);
        this.r.setLayoutManager(new c(getContext(), i3, false, i3));
        this.r.setTag(f6977g);
        p pVar = new p(contextThemeWrapper, this.l, this.m, new d());
        this.r.setAdapter(pVar);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.q = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.q.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.q.setAdapter(new x(this));
            this.q.addItemDecoration(m());
        }
        if (inflate.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            l(inflate, pVar);
        }
        if (!com.google.android.material.datepicker.k.x(contextThemeWrapper)) {
            new LinearSnapHelper().attachToRecyclerView(this.r);
        }
        this.r.scrollToPosition(pVar.p(this.n));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(f6972b, this.k);
        bundle.putParcelable(f6973c, this.l);
        bundle.putParcelable(f6974d, this.m);
        bundle.putParcelable(f6975e, this.n);
    }

    @Nullable
    n p() {
        return this.n;
    }

    @NonNull
    LinearLayoutManager r() {
        return (LinearLayoutManager) this.r.getLayoutManager();
    }

    void u(n nVar) {
        p pVar = (p) this.r.getAdapter();
        int p = pVar.p(nVar);
        int p2 = p - pVar.p(this.n);
        boolean z = Math.abs(p2) > 3;
        boolean z2 = p2 > 0;
        this.n = nVar;
        if (z && z2) {
            this.r.scrollToPosition(p - 3);
            t(p);
        } else if (!z) {
            t(p);
        } else {
            this.r.scrollToPosition(p + 3);
            t(p);
        }
    }

    void v(CalendarSelector calendarSelector) {
        this.o = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.q.getLayoutManager().scrollToPosition(((x) this.q.getAdapter()).o(this.n.f7074d));
            this.s.setVisibility(0);
            this.t.setVisibility(8);
        } else if (calendarSelector == CalendarSelector.DAY) {
            this.s.setVisibility(8);
            this.t.setVisibility(0);
            u(this.n);
        }
    }

    void w() {
        CalendarSelector calendarSelector = this.o;
        CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
        if (calendarSelector == calendarSelector2) {
            v(CalendarSelector.DAY);
        } else if (calendarSelector == CalendarSelector.DAY) {
            v(calendarSelector2);
        }
    }
}
