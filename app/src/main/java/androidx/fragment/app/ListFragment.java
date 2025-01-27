package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class ListFragment extends Fragment {

    /* renamed from: a */
    static final int f2518a = 16711681;

    /* renamed from: b */
    static final int f2519b = 16711682;

    /* renamed from: c */
    static final int f2520c = 16711683;

    /* renamed from: d */
    private final Handler f2521d = new Handler();

    /* renamed from: e */
    private final Runnable f2522e = new Runnable() { // from class: androidx.fragment.app.ListFragment.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListView listView = ListFragment.this.f2525h;
            listView.focusableViewAvailable(listView);
        }
    };

    /* renamed from: f */
    private final AdapterView.OnItemClickListener f2523f = new AdapterView.OnItemClickListener() { // from class: androidx.fragment.app.ListFragment.2
        AnonymousClass2() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            ListFragment.this.onListItemClick((ListView) adapterView, view, i2, j2);
        }
    };

    /* renamed from: g */
    ListAdapter f2524g;

    /* renamed from: h */
    ListView f2525h;

    /* renamed from: i */
    View f2526i;

    /* renamed from: j */
    TextView f2527j;
    View k;
    View l;
    CharSequence m;
    boolean n;

    /* renamed from: androidx.fragment.app.ListFragment$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListView listView = ListFragment.this.f2525h;
            listView.focusableViewAvailable(listView);
        }
    }

    /* renamed from: androidx.fragment.app.ListFragment$2 */
    class AnonymousClass2 implements AdapterView.OnItemClickListener {
        AnonymousClass2() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            ListFragment.this.onListItemClick((ListView) adapterView, view, i2, j2);
        }
    }

    private void a() {
        if (this.f2525h != null) {
            return;
        }
        View view = getView();
        if (view == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        if (view instanceof ListView) {
            this.f2525h = (ListView) view;
        } else {
            TextView textView = (TextView) view.findViewById(f2518a);
            this.f2527j = textView;
            if (textView == null) {
                this.f2526i = view.findViewById(R.id.empty);
            } else {
                textView.setVisibility(8);
            }
            this.k = view.findViewById(f2519b);
            this.l = view.findViewById(f2520c);
            View findViewById = view.findViewById(R.id.list);
            if (!(findViewById instanceof ListView)) {
                if (findViewById != null) {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
            }
            ListView listView = (ListView) findViewById;
            this.f2525h = listView;
            View view2 = this.f2526i;
            if (view2 != null) {
                listView.setEmptyView(view2);
            } else {
                CharSequence charSequence = this.m;
                if (charSequence != null) {
                    this.f2527j.setText(charSequence);
                    this.f2525h.setEmptyView(this.f2527j);
                }
            }
        }
        this.n = true;
        this.f2525h.setOnItemClickListener(this.f2523f);
        ListAdapter listAdapter = this.f2524g;
        if (listAdapter != null) {
            this.f2524g = null;
            setListAdapter(listAdapter);
        } else if (this.k != null) {
            b(false, false);
        }
        this.f2521d.post(this.f2522e);
    }

    private void b(boolean z, boolean z2) {
        a();
        View view = this.k;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.n == z) {
            return;
        }
        this.n = z;
        if (z) {
            if (z2) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
                this.l.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
            } else {
                view.clearAnimation();
                this.l.clearAnimation();
            }
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            return;
        }
        if (z2) {
            view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
            this.l.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
        } else {
            view.clearAnimation();
            this.l.clearAnimation();
        }
        this.k.setVisibility(0);
        this.l.setVisibility(8);
    }

    @Nullable
    public ListAdapter getListAdapter() {
        return this.f2524g;
    }

    @NonNull
    public ListView getListView() {
        a();
        return this.f2525h;
    }

    public long getSelectedItemId() {
        a();
        return this.f2525h.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        a();
        return this.f2525h.getSelectedItemPosition();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Context requireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(requireContext);
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setId(f2519b);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(requireContext, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(requireContext);
        frameLayout2.setId(f2520c);
        TextView textView = new TextView(requireContext);
        textView.setId(f2518a);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(requireContext);
        listView.setId(R.id.list);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f2521d.removeCallbacks(this.f2522e);
        this.f2525h = null;
        this.n = false;
        this.l = null;
        this.k = null;
        this.f2526i = null;
        this.f2527j = null;
        super.onDestroyView();
    }

    public void onListItemClick(@NonNull ListView listView, @NonNull View view, int i2, long j2) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        a();
    }

    @NonNull
    public final ListAdapter requireListAdapter() {
        ListAdapter listAdapter = getListAdapter();
        if (listAdapter != null) {
            return listAdapter;
        }
        throw new IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
    }

    public void setEmptyText(@Nullable CharSequence charSequence) {
        a();
        TextView textView = this.f2527j;
        if (textView == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        textView.setText(charSequence);
        if (this.m == null) {
            this.f2525h.setEmptyView(this.f2527j);
        }
        this.m = charSequence;
    }

    public void setListAdapter(@Nullable ListAdapter listAdapter) {
        boolean z = this.f2524g != null;
        this.f2524g = listAdapter;
        ListView listView = this.f2525h;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (this.n || z) {
                return;
            }
            b(true, requireView().getWindowToken() != null);
        }
    }

    public void setListShown(boolean z) {
        b(z, true);
    }

    public void setListShownNoAnimation(boolean z) {
        b(z, false);
    }

    public void setSelection(int i2) {
        a();
        this.f2525h.setSelection(i2);
    }
}
