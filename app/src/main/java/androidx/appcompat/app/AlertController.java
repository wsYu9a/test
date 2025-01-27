package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;

    /* renamed from: a */
    private final Context f179a;

    /* renamed from: b */
    final AppCompatDialog f180b;

    /* renamed from: c */
    private final Window f181c;

    /* renamed from: d */
    private final int f182d;

    /* renamed from: e */
    private CharSequence f183e;

    /* renamed from: f */
    private CharSequence f184f;

    /* renamed from: g */
    ListView f185g;

    /* renamed from: h */
    private View f186h;

    /* renamed from: i */
    private int f187i;

    /* renamed from: j */
    private int f188j;
    private int k;
    private int l;
    private int m;
    Button o;
    private CharSequence p;
    Message q;
    private Drawable r;
    Button s;
    private CharSequence t;
    Message u;
    private Drawable v;
    Button w;
    private CharSequence x;
    Message y;
    private Drawable z;
    private boolean n = false;
    private int B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new View.OnClickListener() { // from class: androidx.appcompat.app.AlertController.1
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            Message obtain = (view != alertController.o || (message3 = alertController.q) == null) ? (view != alertController.s || (message2 = alertController.u) == null) ? (view != alertController.w || (message = alertController.y) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f180b).sendToTarget();
        }
    };

    /* renamed from: androidx.appcompat.app.AlertController$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            Message obtain = (view != alertController.o || (message3 = alertController.q) == null) ? (view != alertController.s || (message2 = alertController.u) == null) ? (view != alertController.w || (message = alertController.y) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f180b).sendToTarget();
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$2 */
    class AnonymousClass2 implements NestedScrollView.OnScrollChangeListener {

        /* renamed from: a */
        final /* synthetic */ View f190a;

        /* renamed from: b */
        final /* synthetic */ View f191b;

        AnonymousClass2(View view, View view2) {
            findViewById = view;
            findViewById2 = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            AlertController.c(nestedScrollView, findViewById, findViewById2);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ View f193a;

        /* renamed from: b */
        final /* synthetic */ View f194b;

        AnonymousClass3(View view, View view2) {
            findViewById = view;
            findViewById2 = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.c(AlertController.this.A, findViewById, findViewById2);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$4 */
    class AnonymousClass4 implements AbsListView.OnScrollListener {

        /* renamed from: a */
        final /* synthetic */ View f196a;

        /* renamed from: b */
        final /* synthetic */ View f197b;

        AnonymousClass4(View view, View view2) {
            findViewById = view;
            findViewById2 = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            AlertController.c(absListView, findViewById, findViewById2);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$5 */
    class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ View f199a;

        /* renamed from: b */
        final /* synthetic */ View f200b;

        AnonymousClass5(View view, View view2) {
            findViewById = view;
            findViewById2 = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.c(AlertController.this.f185g, findViewById, findViewById2);
        }
    }

    public static class AlertParams {
        public ListAdapter mAdapter;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public CharSequence mMessage;
        public Drawable mNegativeButtonIcon;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public Drawable mNeutralButtonIcon;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface.OnClickListener mOnClickListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public Drawable mPositiveButtonIcon;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public CharSequence mTitle;
        public View mView;
        public int mViewLayoutResId;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public int mViewSpacingTop;
        public int mIconId = 0;
        public int mIconAttrId = 0;
        public boolean mViewSpacingSpecified = false;
        public int mCheckedItem = -1;
        public boolean mRecycleOnMeasure = true;
        public boolean mCancelable = true;

        /* renamed from: androidx.appcompat.app.AlertController$AlertParams$1 */
        class AnonymousClass1 extends ArrayAdapter<CharSequence> {

            /* renamed from: a */
            final /* synthetic */ RecycleListView f202a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Context context, int i2, int i3, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i2, i3, charSequenceArr);
                recycleListView = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i2, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i2, view, viewGroup);
                boolean[] zArr = AlertParams.this.mCheckedItems;
                if (zArr != null && zArr[i2]) {
                    recycleListView.setItemChecked(i2, true);
                }
                return view2;
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$AlertParams$2 */
        class AnonymousClass2 extends CursorAdapter {

            /* renamed from: a */
            private final int f204a;

            /* renamed from: b */
            private final int f205b;

            /* renamed from: c */
            final /* synthetic */ RecycleListView f206c;

            /* renamed from: d */
            final /* synthetic */ AlertController f207d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Context context, Cursor cursor, boolean z, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z);
                recycleListView = recycleListView;
                alertController = alertController;
                Cursor cursor2 = getCursor();
                this.f204a = cursor2.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                this.f205b = cursor2.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f204a));
                recycleListView.setItemChecked(cursor.getPosition(), cursor.getInt(this.f205b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return AlertParams.this.mInflater.inflate(alertController.M, viewGroup, false);
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$AlertParams$3 */
        class AnonymousClass3 implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            final /* synthetic */ AlertController f209a;

            AnonymousClass3(AlertController alertController) {
                alertController = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AlertParams.this.mOnClickListener.onClick(alertController.f180b, i2);
                if (AlertParams.this.mIsSingleChoice) {
                    return;
                }
                alertController.f180b.dismiss();
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$AlertParams$4 */
        class AnonymousClass4 implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            final /* synthetic */ RecycleListView f211a;

            /* renamed from: b */
            final /* synthetic */ AlertController f212b;

            AnonymousClass4(RecycleListView recycleListView, AlertController alertController) {
                recycleListView = recycleListView;
                alertController = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                boolean[] zArr = AlertParams.this.mCheckedItems;
                if (zArr != null) {
                    zArr[i2] = recycleListView.isItemChecked(i2);
                }
                AlertParams.this.mOnCheckboxClickListener.onClick(alertController.f180b, i2, recycleListView.isItemChecked(i2));
            }
        }

        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView listView);
        }

        public AlertParams(Context context) {
            this.mContext = context;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void a(AlertController alertController) {
            ListAdapter listAdapter;
            RecycleListView recycleListView = (RecycleListView) this.mInflater.inflate(alertController.L, (ViewGroup) null);
            if (this.mIsMultiChoice) {
                listAdapter = this.mCursor == null ? new ArrayAdapter<CharSequence>(this.mContext, alertController.M, R.id.text1, this.mItems) { // from class: androidx.appcompat.app.AlertController.AlertParams.1

                    /* renamed from: a */
                    final /* synthetic */ RecycleListView f202a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(Context context, int i2, int i3, CharSequence[] charSequenceArr, RecycleListView recycleListView2) {
                        super(context, i2, i3, charSequenceArr);
                        recycleListView = recycleListView2;
                    }

                    @Override // android.widget.ArrayAdapter, android.widget.Adapter
                    public View getView(int i2, View view, ViewGroup viewGroup) {
                        View view2 = super.getView(i2, view, viewGroup);
                        boolean[] zArr = AlertParams.this.mCheckedItems;
                        if (zArr != null && zArr[i2]) {
                            recycleListView.setItemChecked(i2, true);
                        }
                        return view2;
                    }
                } : new CursorAdapter(this.mContext, this.mCursor, false) { // from class: androidx.appcompat.app.AlertController.AlertParams.2

                    /* renamed from: a */
                    private final int f204a;

                    /* renamed from: b */
                    private final int f205b;

                    /* renamed from: c */
                    final /* synthetic */ RecycleListView f206c;

                    /* renamed from: d */
                    final /* synthetic */ AlertController f207d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(Context context, Cursor cursor, boolean z, RecycleListView recycleListView2, AlertController alertController2) {
                        super(context, cursor, z);
                        recycleListView = recycleListView2;
                        alertController = alertController2;
                        Cursor cursor2 = getCursor();
                        this.f204a = cursor2.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                        this.f205b = cursor2.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
                    }

                    @Override // android.widget.CursorAdapter
                    public void bindView(View view, Context context, Cursor cursor) {
                        ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f204a));
                        recycleListView.setItemChecked(cursor.getPosition(), cursor.getInt(this.f205b) == 1);
                    }

                    @Override // android.widget.CursorAdapter
                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return AlertParams.this.mInflater.inflate(alertController.M, viewGroup, false);
                    }
                };
            } else {
                int i2 = this.mIsSingleChoice ? alertController2.N : alertController2.O;
                if (this.mCursor != null) {
                    listAdapter = new SimpleCursorAdapter(this.mContext, i2, this.mCursor, new String[]{this.mLabelColumn}, new int[]{R.id.text1});
                } else {
                    listAdapter = this.mAdapter;
                    if (listAdapter == null) {
                        listAdapter = new CheckedItemAdapter(this.mContext, i2, R.id.text1, this.mItems);
                    }
                }
            }
            OnPrepareListViewListener onPrepareListViewListener = this.mOnPrepareListViewListener;
            if (onPrepareListViewListener != null) {
                onPrepareListViewListener.onPrepareListView(recycleListView2);
            }
            alertController2.H = listAdapter;
            alertController2.I = this.mCheckedItem;
            if (this.mOnClickListener != null) {
                recycleListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.3

                    /* renamed from: a */
                    final /* synthetic */ AlertController f209a;

                    AnonymousClass3(AlertController alertController2) {
                        alertController = alertController2;
                    }

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i22, long j2) {
                        AlertParams.this.mOnClickListener.onClick(alertController.f180b, i22);
                        if (AlertParams.this.mIsSingleChoice) {
                            return;
                        }
                        alertController.f180b.dismiss();
                    }
                });
            } else if (this.mOnCheckboxClickListener != null) {
                recycleListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.4

                    /* renamed from: a */
                    final /* synthetic */ RecycleListView f211a;

                    /* renamed from: b */
                    final /* synthetic */ AlertController f212b;

                    AnonymousClass4(RecycleListView recycleListView2, AlertController alertController2) {
                        recycleListView = recycleListView2;
                        alertController = alertController2;
                    }

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i22, long j2) {
                        boolean[] zArr = AlertParams.this.mCheckedItems;
                        if (zArr != null) {
                            zArr[i22] = recycleListView.isItemChecked(i22);
                        }
                        AlertParams.this.mOnCheckboxClickListener.onClick(alertController.f180b, i22, recycleListView.isItemChecked(i22));
                    }
                });
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.mOnItemSelectedListener;
            if (onItemSelectedListener != null) {
                recycleListView2.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.mIsSingleChoice) {
                recycleListView2.setChoiceMode(1);
            } else if (this.mIsMultiChoice) {
                recycleListView2.setChoiceMode(2);
            }
            alertController2.f185g = recycleListView2;
        }

        public void apply(AlertController alertController) {
            View view = this.mCustomTitleView;
            if (view != null) {
                alertController.setCustomTitle(view);
            } else {
                CharSequence charSequence = this.mTitle;
                if (charSequence != null) {
                    alertController.setTitle(charSequence);
                }
                Drawable drawable = this.mIcon;
                if (drawable != null) {
                    alertController.setIcon(drawable);
                }
                int i2 = this.mIconId;
                if (i2 != 0) {
                    alertController.setIcon(i2);
                }
                int i3 = this.mIconAttrId;
                if (i3 != 0) {
                    alertController.setIcon(alertController.getIconAttributeResId(i3));
                }
            }
            CharSequence charSequence2 = this.mMessage;
            if (charSequence2 != null) {
                alertController.setMessage(charSequence2);
            }
            CharSequence charSequence3 = this.mPositiveButtonText;
            if (charSequence3 != null || this.mPositiveButtonIcon != null) {
                alertController.setButton(-1, charSequence3, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
            }
            CharSequence charSequence4 = this.mNegativeButtonText;
            if (charSequence4 != null || this.mNegativeButtonIcon != null) {
                alertController.setButton(-2, charSequence4, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
            }
            CharSequence charSequence5 = this.mNeutralButtonText;
            if (charSequence5 != null || this.mNeutralButtonIcon != null) {
                alertController.setButton(-3, charSequence5, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
            }
            if (this.mItems != null || this.mCursor != null || this.mAdapter != null) {
                a(alertController);
            }
            View view2 = this.mView;
            if (view2 != null) {
                if (this.mViewSpacingSpecified) {
                    alertController.setView(view2, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
                    return;
                } else {
                    alertController.setView(view2);
                    return;
                }
            }
            int i4 = this.mViewLayoutResId;
            if (i4 != 0) {
                alertController.setView(i4);
            }
        }
    }

    private static final class ButtonHandler extends Handler {

        /* renamed from: a */
        private static final int f214a = 1;

        /* renamed from: b */
        private WeakReference<DialogInterface> f215b;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.f215b = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == -3 || i2 == -2 || i2 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f215b.get(), message.what);
            } else {
                if (i2 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context context, int i2, int i3, CharSequence[] charSequenceArr) {
            super(context, i2, i3, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public static class RecycleListView extends ListView {

        /* renamed from: a */
        private final int f216a;

        /* renamed from: b */
        private final int f217b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void setHasDecor(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f216a, getPaddingRight(), z2 ? getPaddingBottom() : this.f217b);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.RecycleListView);
            this.f217b = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f216a = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.f179a = context;
        this.f180b = appCompatDialog;
        this.f181c = window;
        this.R = new ButtonHandler(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, androidx.appcompat.R.styleable.AlertDialog, androidx.appcompat.R.attr.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_android_layout, 0);
        this.K = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_listLayout, 0);
        this.M = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_listItemLayout, 0);
        this.P = obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AlertDialog_showTitle, true);
        this.f182d = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void c(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    @Nullable
    private ViewGroup d(@Nullable View view, @Nullable View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int e() {
        int i2 = this.K;
        return i2 == 0 ? this.J : this.Q == 1 ? i2 : this.J;
    }

    private void f(ViewGroup viewGroup, View view, int i2, int i3) {
        View findViewById = this.f181c.findViewById(androidx.appcompat.R.id.scrollIndicatorUp);
        View findViewById2 = this.f181c.findViewById(androidx.appcompat.R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.setScrollIndicators(view, i2, i3);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i2 & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i2 & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById == null && findViewById2 == null) {
            return;
        }
        if (this.f184f != null) {
            this.A.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: androidx.appcompat.app.AlertController.2

                /* renamed from: a */
                final /* synthetic */ View f190a;

                /* renamed from: b */
                final /* synthetic */ View f191b;

                AnonymousClass2(View findViewById3, View findViewById22) {
                    findViewById = findViewById3;
                    findViewById2 = findViewById22;
                }

                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public void onScrollChange(NestedScrollView nestedScrollView, int i22, int i32, int i4, int i5) {
                    AlertController.c(nestedScrollView, findViewById, findViewById2);
                }
            });
            this.A.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.3

                /* renamed from: a */
                final /* synthetic */ View f193a;

                /* renamed from: b */
                final /* synthetic */ View f194b;

                AnonymousClass3(View findViewById3, View findViewById22) {
                    findViewById = findViewById3;
                    findViewById2 = findViewById22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AlertController.c(AlertController.this.A, findViewById, findViewById2);
                }
            });
            return;
        }
        ListView listView = this.f185g;
        if (listView != null) {
            listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: androidx.appcompat.app.AlertController.4

                /* renamed from: a */
                final /* synthetic */ View f196a;

                /* renamed from: b */
                final /* synthetic */ View f197b;

                AnonymousClass4(View findViewById3, View findViewById22) {
                    findViewById = findViewById3;
                    findViewById2 = findViewById22;
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i22, int i32, int i4) {
                    AlertController.c(absListView, findViewById, findViewById2);
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i22) {
                }
            });
            this.f185g.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.5

                /* renamed from: a */
                final /* synthetic */ View f199a;

                /* renamed from: b */
                final /* synthetic */ View f200b;

                AnonymousClass5(View findViewById3, View findViewById22) {
                    findViewById = findViewById3;
                    findViewById2 = findViewById22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AlertController.c(AlertController.this.f185g, findViewById, findViewById2);
                }
            });
            return;
        }
        if (findViewById3 != null) {
            viewGroup.removeView(findViewById3);
        }
        if (findViewById22 != null) {
            viewGroup.removeView(findViewById22);
        }
    }

    private void g(ViewGroup viewGroup) {
        int i2;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.o = button;
        button.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.p) && this.r == null) {
            this.o.setVisibility(8);
            i2 = 0;
        } else {
            this.o.setText(this.p);
            Drawable drawable = this.r;
            if (drawable != null) {
                int i3 = this.f182d;
                drawable.setBounds(0, 0, i3, i3);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.o.setVisibility(0);
            i2 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.s = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.t) && this.v == null) {
            this.s.setVisibility(8);
        } else {
            this.s.setText(this.t);
            Drawable drawable2 = this.v;
            if (drawable2 != null) {
                int i4 = this.f182d;
                drawable2.setBounds(0, 0, i4, i4);
                this.s.setCompoundDrawables(this.v, null, null, null);
            }
            this.s.setVisibility(0);
            i2 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.w = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.x) && this.z == null) {
            this.w.setVisibility(8);
        } else {
            this.w.setText(this.x);
            Drawable drawable3 = this.r;
            if (drawable3 != null) {
                int i5 = this.f182d;
                drawable3.setBounds(0, 0, i5, i5);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.w.setVisibility(0);
            i2 |= 4;
        }
        if (l(this.f179a)) {
            if (i2 == 1) {
                b(this.o);
            } else if (i2 == 2) {
                b(this.s);
            } else if (i2 == 4) {
                b(this.w);
            }
        }
        if (i2 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void h(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f181c.findViewById(androidx.appcompat.R.id.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f184f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f185g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
        int indexOfChild = viewGroup2.indexOfChild(this.A);
        viewGroup2.removeViewAt(indexOfChild);
        viewGroup2.addView(this.f185g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void i(ViewGroup viewGroup) {
        View view = this.f186h;
        if (view == null) {
            view = this.f187i != 0 ? LayoutInflater.from(this.f179a).inflate(this.f187i, viewGroup, false) : null;
        }
        boolean z = view != null;
        if (!z || !a(view)) {
            this.f181c.setFlags(131072, 131072);
        }
        if (!z) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f181c.findViewById(androidx.appcompat.R.id.custom);
        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        if (this.n) {
            frameLayout.setPadding(this.f188j, this.k, this.l, this.m);
        }
        if (this.f185g != null) {
            ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
        }
    }

    private void j(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f181c.findViewById(androidx.appcompat.R.id.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f181c.findViewById(R.id.icon);
        if (!(!TextUtils.isEmpty(this.f183e)) || !this.P) {
            this.f181c.findViewById(androidx.appcompat.R.id.title_template).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f181c.findViewById(androidx.appcompat.R.id.alertTitle);
        this.E = textView;
        textView.setText(this.f183e);
        int i2 = this.B;
        if (i2 != 0) {
            this.D.setImageResource(i2);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
        } else {
            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
            this.D.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void k() {
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3 = this.f181c.findViewById(androidx.appcompat.R.id.parentPanel);
        int i2 = androidx.appcompat.R.id.topPanel;
        View findViewById4 = findViewById3.findViewById(i2);
        int i3 = androidx.appcompat.R.id.contentPanel;
        View findViewById5 = findViewById3.findViewById(i3);
        int i4 = androidx.appcompat.R.id.buttonPanel;
        View findViewById6 = findViewById3.findViewById(i4);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(androidx.appcompat.R.id.customPanel);
        i(viewGroup);
        View findViewById7 = viewGroup.findViewById(i2);
        View findViewById8 = viewGroup.findViewById(i3);
        View findViewById9 = viewGroup.findViewById(i4);
        ViewGroup d2 = d(findViewById7, findViewById4);
        ViewGroup d3 = d(findViewById8, findViewById5);
        ViewGroup d4 = d(findViewById9, findViewById6);
        h(d3);
        g(d4);
        j(d2);
        boolean z = viewGroup.getVisibility() != 8;
        boolean z2 = (d2 == null || d2.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (d4 == null || d4.getVisibility() == 8) ? false : true;
        if (!z3 && d3 != null && (findViewById2 = d3.findViewById(androidx.appcompat.R.id.textSpacerNoButtons)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z2 != 0) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View findViewById10 = (this.f184f == null && this.f185g == null) ? null : d2.findViewById(androidx.appcompat.R.id.titleDividerNoCustom);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        } else if (d3 != null && (findViewById = d3.findViewById(androidx.appcompat.R.id.textSpacerNoTitle)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f185g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).setHasDecor(z2, z3);
        }
        if (!z) {
            View view = this.f185g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                f(d3, view, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f185g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i5 = this.I;
        if (i5 > -1) {
            listView2.setItemChecked(i5, true);
            listView2.setSelection(i5);
        }
    }

    private static boolean l(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public Button getButton(int i2) {
        if (i2 == -3) {
            return this.w;
        }
        if (i2 == -2) {
            return this.s;
        }
        if (i2 != -1) {
            return null;
        }
        return this.o;
    }

    public int getIconAttributeResId(int i2) {
        TypedValue typedValue = new TypedValue();
        this.f179a.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView getListView() {
        return this.f185g;
    }

    public void installContent() {
        this.f180b.setContentView(e());
        k();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public void setButton(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i2, onClickListener);
        }
        if (i2 == -3) {
            this.x = charSequence;
            this.y = message;
            this.z = drawable;
        } else if (i2 == -2) {
            this.t = charSequence;
            this.u = message;
            this.v = drawable;
        } else {
            if (i2 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.p = charSequence;
            this.q = message;
            this.r = drawable;
        }
    }

    public void setButtonPanelLayoutHint(int i2) {
        this.Q = i2;
    }

    public void setCustomTitle(View view) {
        this.G = view;
    }

    public void setIcon(int i2) {
        this.C = null;
        this.B = i2;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i2 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
            }
        }
    }

    public void setMessage(CharSequence charSequence) {
        this.f184f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f183e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setView(int i2) {
        this.f186h = null;
        this.f187i = i2;
        this.n = false;
    }

    public void setView(View view) {
        this.f186h = view;
        this.f187i = 0;
        this.n = false;
    }

    public void setIcon(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void setView(View view, int i2, int i3, int i4, int i5) {
        this.f186h = view;
        this.f187i = 0;
        this.n = true;
        this.f188j = i2;
        this.k = i3;
        this.l = i4;
        this.m = i5;
    }
}
