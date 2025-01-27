package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {

    /* renamed from: a */
    private static final String f651a = "ActivityChooserView";

    /* renamed from: b */
    final ActivityChooserViewAdapter f652b;

    /* renamed from: c */
    private final Callbacks f653c;

    /* renamed from: d */
    private final View f654d;

    /* renamed from: e */
    private final Drawable f655e;

    /* renamed from: f */
    final FrameLayout f656f;

    /* renamed from: g */
    private final ImageView f657g;

    /* renamed from: h */
    final FrameLayout f658h;

    /* renamed from: i */
    private final ImageView f659i;

    /* renamed from: j */
    private final int f660j;
    ActionProvider k;
    final DataSetObserver l;
    private final ViewTreeObserver.OnGlobalLayoutListener m;
    private ListPopupWindow n;
    PopupWindow.OnDismissListener o;
    boolean p;
    int q;
    private boolean r;
    private int s;

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$1 */
    class AnonymousClass1 extends DataSetObserver {
        AnonymousClass1() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f652b.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f652b.notifyDataSetInvalidated();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$2 */
    class AnonymousClass2 implements ViewTreeObserver.OnGlobalLayoutListener {
        AnonymousClass2() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ActivityChooserView.this.isShowingPopup()) {
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().show();
                ActionProvider actionProvider = ActivityChooserView.this.k;
                if (actionProvider != null) {
                    actionProvider.subUiVisibilityChanged(true);
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$3 */
    class AnonymousClass3 extends View.AccessibilityDelegate {
        AnonymousClass3() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCanOpenPopup(true);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$4 */
    class AnonymousClass4 extends ForwardingListener {
        AnonymousClass4(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public ShowableListMenu getPopup() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        protected boolean onForwardingStarted() {
            ActivityChooserView.this.showPopup();
            return true;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        protected boolean onForwardingStopped() {
            ActivityChooserView.this.dismissPopup();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$5 */
    class AnonymousClass5 extends DataSetObserver {
        AnonymousClass5() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.b();
        }
    }

    private class ActivityChooserViewAdapter extends BaseAdapter {
        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;

        /* renamed from: a */
        private static final int f666a = 0;

        /* renamed from: b */
        private static final int f667b = 1;

        /* renamed from: c */
        private static final int f668c = 3;

        /* renamed from: d */
        private ActivityChooserModel f669d;

        /* renamed from: e */
        private int f670e = 4;

        /* renamed from: f */
        private boolean f671f;

        /* renamed from: g */
        private boolean f672g;

        /* renamed from: h */
        private boolean f673h;

        ActivityChooserViewAdapter() {
        }

        public int getActivityCount() {
            return this.f669d.getActivityCount();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int activityCount = this.f669d.getActivityCount();
            if (!this.f671f && this.f669d.getDefaultActivity() != null) {
                activityCount--;
            }
            int min = Math.min(activityCount, this.f670e);
            return this.f673h ? min + 1 : min;
        }

        public ActivityChooserModel getDataModel() {
            return this.f669d;
        }

        public ResolveInfo getDefaultActivity() {
            return this.f669d.getDefaultActivity();
        }

        public int getHistorySize() {
            return this.f669d.getHistorySize();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (!this.f671f && this.f669d.getDefaultActivity() != null) {
                i2++;
            }
            return this.f669d.getActivity(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i2) {
            return (this.f673h && i2 == getCount() - 1) ? 1 : 0;
        }

        public boolean getShowDefaultActivity() {
            return this.f671f;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                if (view != null && view.getId() == 1) {
                    return view;
                }
                View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(R.id.title)).setText(ActivityChooserView.this.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                return inflate;
            }
            if (view == null || view.getId() != R.id.list_item) {
                view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(R.id.icon);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i2);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(R.id.title)).setText(resolveInfo.loadLabel(packageManager));
            if (this.f671f && i2 == 0 && this.f672g) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        public int measureContentWidth() {
            int i2 = this.f670e;
            this.f670e = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            for (int i4 = 0; i4 < count; i4++) {
                view = getView(i4, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
            }
            this.f670e = i2;
            return i3;
        }

        public void setDataModel(ActivityChooserModel activityChooserModel) {
            ActivityChooserModel dataModel = ActivityChooserView.this.f652b.getDataModel();
            if (dataModel != null && ActivityChooserView.this.isShown()) {
                dataModel.unregisterObserver(ActivityChooserView.this.l);
            }
            this.f669d = activityChooserModel;
            if (activityChooserModel != null && ActivityChooserView.this.isShown()) {
                activityChooserModel.registerObserver(ActivityChooserView.this.l);
            }
            notifyDataSetChanged();
        }

        public void setMaxActivityCount(int i2) {
            if (this.f670e != i2) {
                this.f670e = i2;
                notifyDataSetChanged();
            }
        }

        public void setShowDefaultActivity(boolean z, boolean z2) {
            if (this.f671f == z && this.f672g == z2) {
                return;
            }
            this.f671f = z;
            this.f672g = z2;
            notifyDataSetChanged();
        }

        public void setShowFooterView(boolean z) {
            if (this.f673h != z) {
                this.f673h = z;
                notifyDataSetChanged();
            }
        }
    }

    private class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        Callbacks() {
        }

        private void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.o;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f658h) {
                if (view != activityChooserView.f656f) {
                    throw new IllegalArgumentException();
                }
                activityChooserView.p = false;
                activityChooserView.a(activityChooserView.q);
                return;
            }
            activityChooserView.dismissPopup();
            Intent chooseActivity = ActivityChooserView.this.f652b.getDataModel().chooseActivity(ActivityChooserView.this.f652b.getDataModel().getActivityIndex(ActivityChooserView.this.f652b.getDefaultActivity()));
            if (chooseActivity != null) {
                chooseActivity.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(chooseActivity);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            ActionProvider actionProvider = ActivityChooserView.this.k;
            if (actionProvider != null) {
                actionProvider.subUiVisibilityChanged(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            int itemViewType = ((ActivityChooserViewAdapter) adapterView.getAdapter()).getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                ActivityChooserView.this.a(Integer.MAX_VALUE);
                return;
            }
            ActivityChooserView.this.dismissPopup();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (activityChooserView.p) {
                if (i2 > 0) {
                    activityChooserView.f652b.getDataModel().setDefaultActivity(i2);
                    return;
                }
                return;
            }
            if (!activityChooserView.f652b.getShowDefaultActivity()) {
                i2++;
            }
            Intent chooseActivity = ActivityChooserView.this.f652b.getDataModel().chooseActivity(i2);
            if (chooseActivity != null) {
                chooseActivity.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(chooseActivity);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f658h) {
                throw new IllegalArgumentException();
            }
            if (activityChooserView.f652b.getCount() > 0) {
                ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                activityChooserView2.p = true;
                activityChooserView2.a(activityChooserView2.q);
            }
            return true;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class InnerLayout extends LinearLayout {

        /* renamed from: a */
        private static final int[] f676a = {android.R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, f676a);
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
        }
    }

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    void a(int i2) {
        if (this.f652b.getDataModel() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.m);
        ?? r0 = this.f658h.getVisibility() == 0 ? 1 : 0;
        int activityCount = this.f652b.getActivityCount();
        if (i2 == Integer.MAX_VALUE || activityCount <= i2 + r0) {
            this.f652b.setShowFooterView(false);
            this.f652b.setMaxActivityCount(i2);
        } else {
            this.f652b.setShowFooterView(true);
            this.f652b.setMaxActivityCount(i2 - 1);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (listPopupWindow.isShowing()) {
            return;
        }
        if (this.p || r0 == 0) {
            this.f652b.setShowDefaultActivity(true, r0);
        } else {
            this.f652b.setShowDefaultActivity(false, false);
        }
        listPopupWindow.setContentWidth(Math.min(this.f652b.measureContentWidth(), this.f660j));
        listPopupWindow.show();
        ActionProvider actionProvider = this.k;
        if (actionProvider != null) {
            actionProvider.subUiVisibilityChanged(true);
        }
        listPopupWindow.getListView().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
        listPopupWindow.getListView().setSelector(new ColorDrawable(0));
    }

    void b() {
        if (this.f652b.getCount() > 0) {
            this.f656f.setEnabled(true);
        } else {
            this.f656f.setEnabled(false);
        }
        int activityCount = this.f652b.getActivityCount();
        int historySize = this.f652b.getHistorySize();
        if (activityCount == 1 || (activityCount > 1 && historySize > 0)) {
            this.f658h.setVisibility(0);
            ResolveInfo defaultActivity = this.f652b.getDefaultActivity();
            PackageManager packageManager = getContext().getPackageManager();
            this.f659i.setImageDrawable(defaultActivity.loadIcon(packageManager));
            if (this.s != 0) {
                this.f658h.setContentDescription(getContext().getString(this.s, defaultActivity.loadLabel(packageManager)));
            }
        } else {
            this.f658h.setVisibility(8);
        }
        if (this.f658h.getVisibility() == 0) {
            this.f654d.setBackgroundDrawable(this.f655e);
        } else {
            this.f654d.setBackgroundDrawable(null);
        }
    }

    public boolean dismissPopup() {
        if (!isShowingPopup()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.m);
        return true;
    }

    public ActivityChooserModel getDataModel() {
        return this.f652b.getDataModel();
    }

    ListPopupWindow getListPopupWindow() {
        if (this.n == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.n = listPopupWindow;
            listPopupWindow.setAdapter(this.f652b);
            this.n.setAnchorView(this);
            this.n.setModal(true);
            this.n.setOnItemClickListener(this.f653c);
            this.n.setOnDismissListener(this.f653c);
        }
        return this.n;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel dataModel = this.f652b.getDataModel();
        if (dataModel != null) {
            dataModel.registerObserver(this.l);
        }
        this.r = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel dataModel = this.f652b.getDataModel();
        if (dataModel != null) {
            dataModel.unregisterObserver(this.l);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.m);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.r = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.f654d.layout(0, 0, i4 - i2, i5 - i3);
        if (isShowingPopup()) {
            return;
        }
        dismissPopup();
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        View view = this.f654d;
        if (this.f658h.getVisibility() != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 1073741824);
        }
        measureChild(view, i2, i3);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // androidx.appcompat.widget.ActivityChooserModel.ActivityChooserModelClient
    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        this.f652b.setDataModel(activityChooserModel);
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setDefaultActionButtonContentDescription(int i2) {
        this.s = i2;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i2) {
        this.f657g.setContentDescription(getContext().getString(i2));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f657g.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i2) {
        this.q = i2;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.o = onDismissListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setProvider(ActionProvider actionProvider) {
        this.k = actionProvider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.r) {
            return false;
        }
        this.p = false;
        a(this.q);
        return true;
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = new DataSetObserver() { // from class: androidx.appcompat.widget.ActivityChooserView.1
            AnonymousClass1() {
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.f652b.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.f652b.notifyDataSetInvalidated();
            }
        };
        this.m = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.ActivityChooserView.2
            AnonymousClass2() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (ActivityChooserView.this.isShowingPopup()) {
                    if (!ActivityChooserView.this.isShown()) {
                        ActivityChooserView.this.getListPopupWindow().dismiss();
                        return;
                    }
                    ActivityChooserView.this.getListPopupWindow().show();
                    ActionProvider actionProvider = ActivityChooserView.this.k;
                    if (actionProvider != null) {
                        actionProvider.subUiVisibilityChanged(true);
                    }
                }
            }
        };
        this.q = 4;
        int[] iArr = R.styleable.ActivityChooserView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, i2, 0);
        }
        this.q = obtainStyledAttributes.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        Callbacks callbacks = new Callbacks();
        this.f653c = callbacks;
        View findViewById = findViewById(R.id.activity_chooser_view_content);
        this.f654d = findViewById;
        this.f655e = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.default_activity_button);
        this.f658h = frameLayout;
        frameLayout.setOnClickListener(callbacks);
        frameLayout.setOnLongClickListener(callbacks);
        int i3 = R.id.image;
        this.f659i = (ImageView) frameLayout.findViewById(i3);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.expand_activities_button);
        frameLayout2.setOnClickListener(callbacks);
        frameLayout2.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: androidx.appcompat.widget.ActivityChooserView.3
            AnonymousClass3() {
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCanOpenPopup(true);
            }
        });
        frameLayout2.setOnTouchListener(new ForwardingListener(frameLayout2) { // from class: androidx.appcompat.widget.ActivityChooserView.4
            AnonymousClass4(View frameLayout22) {
                super(frameLayout22);
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public ShowableListMenu getPopup() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            protected boolean onForwardingStarted() {
                ActivityChooserView.this.showPopup();
                return true;
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            protected boolean onForwardingStopped() {
                ActivityChooserView.this.dismissPopup();
                return true;
            }
        });
        this.f656f = frameLayout22;
        ImageView imageView = (ImageView) frameLayout22.findViewById(i3);
        this.f657g = imageView;
        imageView.setImageDrawable(drawable);
        ActivityChooserViewAdapter activityChooserViewAdapter = new ActivityChooserViewAdapter();
        this.f652b = activityChooserViewAdapter;
        activityChooserViewAdapter.registerDataSetObserver(new DataSetObserver() { // from class: androidx.appcompat.widget.ActivityChooserView.5
            AnonymousClass5() {
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.b();
            }
        });
        Resources resources = context.getResources();
        this.f660j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }
}
