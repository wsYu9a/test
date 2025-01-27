package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.vivo.ic.dm.Downloads;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
    static final boolean v = false;
    static final String w = "SearchView";
    private static final String x = "nm";
    static final AutoCompleteTextViewReflector y = new AutoCompleteTextViewReflector();
    private final View A;
    private final View B;
    private final View C;
    final ImageView D;
    final ImageView E;
    final ImageView F;
    final ImageView G;
    private final View H;
    private UpdatableTouchDelegate I;
    private Rect J;
    private Rect K;
    private int[] L;
    private int[] M;
    private final ImageView N;
    private final Drawable O;
    private final int P;
    private final int Q;
    private final Intent R;
    private final Intent S;
    private final CharSequence T;
    private OnQueryTextListener U;
    private OnCloseListener V;
    View.OnFocusChangeListener W;
    private OnSuggestionListener a0;
    private View.OnClickListener b0;
    private boolean c0;
    private boolean d0;
    CursorAdapter e0;
    private boolean f0;
    private CharSequence g0;
    private boolean h0;
    private boolean i0;
    private int j0;
    private boolean k0;
    private CharSequence l0;
    private CharSequence m0;
    private boolean n0;
    private int o0;
    SearchableInfo p0;
    private Bundle q0;
    private final Runnable r0;
    private Runnable s0;
    private final WeakHashMap<String, Drawable.ConstantState> t0;
    private final View.OnClickListener u0;
    View.OnKeyListener v0;
    private final TextView.OnEditorActionListener w0;
    private final AdapterView.OnItemClickListener x0;
    private final AdapterView.OnItemSelectedListener y0;
    final SearchAutoComplete z;
    private TextWatcher z0;

    /* renamed from: androidx.appcompat.widget.SearchView$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.W();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$10 */
    class AnonymousClass10 implements TextWatcher {
        AnonymousClass10() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            SearchView.this.Q(charSequence);
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CursorAdapter cursorAdapter = SearchView.this.e0;
            if (cursorAdapter instanceof SuggestionsAdapter) {
                cursorAdapter.changeCursor(null);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$3 */
    class AnonymousClass3 implements View.OnFocusChangeListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.W;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$4 */
    class AnonymousClass4 implements View.OnLayoutChangeListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            SearchView.this.u();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$5 */
    class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.D) {
                searchView.N();
                return;
            }
            if (view == searchView.F) {
                searchView.J();
                return;
            }
            if (view == searchView.E) {
                searchView.O();
            } else if (view == searchView.G) {
                searchView.S();
            } else if (view == searchView.z) {
                searchView.A();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$6 */
    class AnonymousClass6 implements View.OnKeyListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.p0 == null) {
                return false;
            }
            if (searchView.z.isPopupShowing() && SearchView.this.z.getListSelection() != -1) {
                return SearchView.this.P(view, i2, keyEvent);
            }
            if (SearchView.this.z.a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i2 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.H(0, null, searchView2.z.getText().toString());
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$7 */
    class AnonymousClass7 implements TextView.OnEditorActionListener {
        AnonymousClass7() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            SearchView.this.O();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$8 */
    class AnonymousClass8 implements AdapterView.OnItemClickListener {
        AnonymousClass8() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            SearchView.this.K(i2, 0, null);
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$9 */
    class AnonymousClass9 implements AdapterView.OnItemSelectedListener {
        AnonymousClass9() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            SearchView.this.L(i2);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    private static class AutoCompleteTextViewReflector {

        /* renamed from: a */
        private Method f928a;

        /* renamed from: b */
        private Method f929b;

        /* renamed from: c */
        private Method f930c;

        AutoCompleteTextViewReflector() {
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f928a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f929b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f930c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f929b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f928a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView, boolean z) {
            Method method = this.f930c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.valueOf(z));
                } catch (Exception unused) {
                }
            }
        }
    }

    public interface OnCloseListener {
        boolean onClose();
    }

    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    public interface OnSuggestionListener {
        boolean onSuggestionClick(int i2);

        boolean onSuggestionSelect(int i2);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.widget.SearchView.SavedState.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };

        /* renamed from: b */
        boolean f931b;

        /* renamed from: androidx.appcompat.widget.SearchView$SavedState$1 */
        static class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f931b + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeValue(Boolean.valueOf(this.f931b));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f931b = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: d */
        private int f932d;

        /* renamed from: e */
        private SearchView f933e;

        /* renamed from: f */
        private boolean f934f;

        /* renamed from: g */
        final Runnable f935g;

        /* renamed from: androidx.appcompat.widget.SearchView$SearchAutoComplete$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.b();
            }
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (i2 >= 960 && i3 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i2 >= 600) {
                return Downloads.Impl.STATUS_RUNNING;
            }
            if (i2 < 640 || i3 < 480) {
                return 160;
            }
            return Downloads.Impl.STATUS_RUNNING;
        }

        boolean a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        void b() {
            if (this.f934f) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f934f = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f932d <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f934f) {
                removeCallbacks(this.f935g);
                post(this.f935g);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i2, Rect rect) {
            super.onFocusChanged(z, i2, rect);
            this.f933e.R();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
            if (i2 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f933e.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i2, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f933e.hasFocus() && getVisibility() == 0) {
                this.f934f = true;
                if (SearchView.E(getContext())) {
                    SearchView.y.c(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f934f = false;
                removeCallbacks(this.f935g);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f934f = true;
                    return;
                }
                this.f934f = false;
                removeCallbacks(this.f935g);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        void setSearchView(SearchView searchView) {
            this.f933e = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i2) {
            super.setThreshold(i2);
            this.f932d = i2;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.f935g = new Runnable() { // from class: androidx.appcompat.widget.SearchView.SearchAutoComplete.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    SearchAutoComplete.this.b();
                }
            };
            this.f932d = getThreshold();
        }
    }

    private static class UpdatableTouchDelegate extends TouchDelegate {

        /* renamed from: a */
        private final View f937a;

        /* renamed from: b */
        private final Rect f938b;

        /* renamed from: c */
        private final Rect f939c;

        /* renamed from: d */
        private final Rect f940d;

        /* renamed from: e */
        private final int f941e;

        /* renamed from: f */
        private boolean f942f;

        public UpdatableTouchDelegate(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f941e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f938b = new Rect();
            this.f940d = new Rect();
            this.f939c = new Rect();
            setBounds(rect, rect2);
            this.f937a = view;
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z3 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z2 = this.f942f;
                    if (z2 && !this.f940d.contains(x, y)) {
                        z3 = z2;
                        z = false;
                    }
                } else {
                    if (action == 3) {
                        z2 = this.f942f;
                        this.f942f = false;
                    }
                    z = true;
                    z3 = false;
                }
                z3 = z2;
                z = true;
            } else {
                if (this.f938b.contains(x, y)) {
                    this.f942f = true;
                    z = true;
                }
                z = true;
                z3 = false;
            }
            if (!z3) {
                return false;
            }
            if (!z || this.f939c.contains(x, y)) {
                Rect rect = this.f939c;
                motionEvent.setLocation(x - rect.left, y - rect.top);
            } else {
                motionEvent.setLocation(this.f937a.getWidth() / 2, this.f937a.getHeight() / 2);
            }
            return this.f937a.dispatchTouchEvent(motionEvent);
        }

        public void setBounds(Rect rect, Rect rect2) {
            this.f938b.set(rect);
            this.f940d.set(rect);
            Rect rect3 = this.f940d;
            int i2 = this.f941e;
            rect3.inset(-i2, -i2);
            this.f939c.set(rect2);
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private void B(View view, Rect rect) {
        view.getLocationInWindow(this.L);
        getLocationInWindow(this.M);
        int[] iArr = this.L;
        int i2 = iArr[1];
        int[] iArr2 = this.M;
        int i3 = i2 - iArr2[1];
        int i4 = iArr[0] - iArr2[0];
        rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
    }

    private CharSequence C(CharSequence charSequence) {
        if (!this.c0 || this.O == null) {
            return charSequence;
        }
        double textSize = this.z.getTextSize();
        Double.isNaN(textSize);
        int i2 = (int) (textSize * 1.25d);
        this.O.setBounds(0, 0, i2, i2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.O), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean D() {
        SearchableInfo searchableInfo = this.p0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.p0.getVoiceSearchLaunchWebSearch()) {
            intent = this.R;
        } else if (this.p0.getVoiceSearchLaunchRecognizer()) {
            intent = this.S;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    static boolean E(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean F() {
        return (this.f0 || this.k0) && !isIconified();
    }

    private void G(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e2) {
            Log.e(w, "Failed launch activity: " + intent, e2);
        }
    }

    private boolean I(int i2, int i3, String str) {
        Cursor cursor = this.e0.getCursor();
        if (cursor == null || !cursor.moveToPosition(i2)) {
            return false;
        }
        G(w(cursor, i3, str));
        return true;
    }

    private void T() {
        post(this.r0);
    }

    private void U(int i2) {
        Editable text = this.z.getText();
        Cursor cursor = this.e0.getCursor();
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i2)) {
            setQuery(text);
            return;
        }
        CharSequence convertToString = this.e0.convertToString(cursor);
        if (convertToString != null) {
            setQuery(convertToString);
        } else {
            setQuery(text);
        }
    }

    private void V() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.z.getText());
        if (!z2 && (!this.c0 || this.n0)) {
            z = false;
        }
        this.F.setVisibility(z ? 0 : 8);
        Drawable drawable = this.F.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void X() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.z;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(C(queryHint));
    }

    private void Y() {
        this.z.setThreshold(this.p0.getSuggestThreshold());
        this.z.setImeOptions(this.p0.getImeOptions());
        int inputType = this.p0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.p0.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.z.setInputType(inputType);
        CursorAdapter cursorAdapter = this.e0;
        if (cursorAdapter != null) {
            cursorAdapter.changeCursor(null);
        }
        if (this.p0.getSuggestAuthority() != null) {
            SuggestionsAdapter suggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.p0, this.t0);
            this.e0 = suggestionsAdapter;
            this.z.setAdapter(suggestionsAdapter);
            ((SuggestionsAdapter) this.e0).setQueryRefinement(this.h0 ? 2 : 1);
        }
    }

    private void Z() {
        this.C.setVisibility((F() && (this.E.getVisibility() == 0 || this.G.getVisibility() == 0)) ? 0 : 8);
    }

    private void a0(boolean z) {
        this.E.setVisibility((this.f0 && F() && hasFocus() && (z || !this.k0)) ? 0 : 8);
    }

    private void b0(boolean z) {
        this.d0 = z;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.z.getText());
        this.D.setVisibility(i2);
        a0(z2);
        this.A.setVisibility(z ? 8 : 0);
        this.N.setVisibility((this.N.getDrawable() == null || this.c0) ? 8 : 0);
        V();
        c0(!z2);
        Z();
    }

    private void c0(boolean z) {
        int i2 = 8;
        if (this.k0 && !isIconified() && z) {
            this.E.setVisibility(8);
            i2 = 0;
        }
        this.G.setVisibility(i2);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private Intent v(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.m0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.q0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.p0.getSearchActivity());
        return intent;
    }

    private Intent w(Cursor cursor, int i2, String str) {
        int i3;
        String columnString;
        try {
            String columnString2 = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_action");
            if (columnString2 == null) {
                columnString2 = this.p0.getSuggestIntentAction();
            }
            if (columnString2 == null) {
                columnString2 = "android.intent.action.SEARCH";
            }
            String str2 = columnString2;
            String columnString3 = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_data");
            if (columnString3 == null) {
                columnString3 = this.p0.getSuggestIntentData();
            }
            if (columnString3 != null && (columnString = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_data_id")) != null) {
                columnString3 = columnString3 + "/" + Uri.encode(columnString);
            }
            return v(str2, columnString3 == null ? null : Uri.parse(columnString3), SuggestionsAdapter.getColumnString(cursor, "suggest_intent_extra_data"), SuggestionsAdapter.getColumnString(cursor, "suggest_intent_query"), i2, str);
        } catch (RuntimeException e2) {
            try {
                i3 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i3 = -1;
            }
            Log.w(w, "Search suggestions cursor at row " + i3 + " returned exception.", e2);
            return null;
        }
    }

    private Intent x(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.q0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent y(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void z() {
        this.z.dismissDropDown();
    }

    void A() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.z.refreshAutoCompleteResults();
            return;
        }
        AutoCompleteTextViewReflector autoCompleteTextViewReflector = y;
        autoCompleteTextViewReflector.b(this.z);
        autoCompleteTextViewReflector.a(this.z);
    }

    void H(int i2, String str, String str2) {
        getContext().startActivity(v("android.intent.action.SEARCH", null, null, str2, i2, str));
    }

    void J() {
        if (!TextUtils.isEmpty(this.z.getText())) {
            this.z.setText("");
            this.z.requestFocus();
            this.z.setImeVisibility(true);
        } else if (this.c0) {
            OnCloseListener onCloseListener = this.V;
            if (onCloseListener == null || !onCloseListener.onClose()) {
                clearFocus();
                b0(true);
            }
        }
    }

    boolean K(int i2, int i3, String str) {
        OnSuggestionListener onSuggestionListener = this.a0;
        if (onSuggestionListener != null && onSuggestionListener.onSuggestionClick(i2)) {
            return false;
        }
        I(i2, 0, null);
        this.z.setImeVisibility(false);
        z();
        return true;
    }

    boolean L(int i2) {
        OnSuggestionListener onSuggestionListener = this.a0;
        if (onSuggestionListener != null && onSuggestionListener.onSuggestionSelect(i2)) {
            return false;
        }
        U(i2);
        return true;
    }

    void M(CharSequence charSequence) {
        setQuery(charSequence);
    }

    void N() {
        b0(false);
        this.z.requestFocus();
        this.z.setImeVisibility(true);
        View.OnClickListener onClickListener = this.b0;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void O() {
        Editable text = this.z.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        OnQueryTextListener onQueryTextListener = this.U;
        if (onQueryTextListener == null || !onQueryTextListener.onQueryTextSubmit(text.toString())) {
            if (this.p0 != null) {
                H(0, null, text.toString());
            }
            this.z.setImeVisibility(false);
            z();
        }
    }

    boolean P(View view, int i2, KeyEvent keyEvent) {
        if (this.p0 != null && this.e0 != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return K(this.z.getListSelection(), 0, null);
            }
            if (i2 == 21 || i2 == 22) {
                this.z.setSelection(i2 == 21 ? 0 : this.z.length());
                this.z.setListSelection(0);
                this.z.clearListSelection();
                y.c(this.z, true);
                return true;
            }
            if (i2 != 19 || this.z.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    void Q(CharSequence charSequence) {
        Editable text = this.z.getText();
        this.m0 = text;
        boolean z = !TextUtils.isEmpty(text);
        a0(z);
        c0(!z);
        V();
        Z();
        if (this.U != null && !TextUtils.equals(charSequence, this.l0)) {
            this.U.onQueryTextChange(charSequence.toString());
        }
        this.l0 = charSequence.toString();
    }

    void R() {
        b0(isIconified());
        T();
        if (this.z.hasFocus()) {
            A();
        }
    }

    void S() {
        SearchableInfo searchableInfo = this.p0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(y(this.R, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(x(this.S, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w(w, "Could not find voice search activity");
        }
    }

    void W() {
        int[] iArr = this.z.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.B.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.C.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.i0 = true;
        super.clearFocus();
        this.z.clearFocus();
        this.z.setImeVisibility(false);
        this.i0 = false;
    }

    public int getImeOptions() {
        return this.z.getImeOptions();
    }

    public int getInputType() {
        return this.z.getInputType();
    }

    public int getMaxWidth() {
        return this.j0;
    }

    public CharSequence getQuery() {
        return this.z.getText();
    }

    @Nullable
    public CharSequence getQueryHint() {
        CharSequence charSequence = this.g0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.p0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.T : getContext().getText(this.p0.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.Q;
    }

    int getSuggestionRowLayout() {
        return this.P;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.e0;
    }

    public boolean isIconfiedByDefault() {
        return this.c0;
    }

    public boolean isIconified() {
        return this.d0;
    }

    public boolean isQueryRefinementEnabled() {
        return this.h0;
    }

    public boolean isSubmitButtonEnabled() {
        return this.f0;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        b0(true);
        this.z.setImeOptions(this.o0);
        this.n0 = false;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewExpanded() {
        if (this.n0) {
            return;
        }
        this.n0 = true;
        int imeOptions = this.z.getImeOptions();
        this.o0 = imeOptions;
        this.z.setImeOptions(imeOptions | 33554432);
        this.z.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.r0);
        post(this.s0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            B(this.z, this.J);
            Rect rect = this.K;
            Rect rect2 = this.J;
            rect.set(rect2.left, 0, rect2.right, i5 - i3);
            UpdatableTouchDelegate updatableTouchDelegate = this.I;
            if (updatableTouchDelegate != null) {
                updatableTouchDelegate.setBounds(this.K, this.J);
                return;
            }
            UpdatableTouchDelegate updatableTouchDelegate2 = new UpdatableTouchDelegate(this.K, this.J, this.z);
            this.I = updatableTouchDelegate2;
            setTouchDelegate(updatableTouchDelegate2);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        if (isIconified()) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            int i5 = this.j0;
            size = i5 > 0 ? Math.min(i5, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.j0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i4 = this.j0) > 0) {
            size = Math.min(i4, size);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        b0(savedState.f931b);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f931b = isIconified();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        T();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i2, Rect rect) {
        if (this.i0 || !isFocusable()) {
            return false;
        }
        if (isIconified()) {
            return super.requestFocus(i2, rect);
        }
        boolean requestFocus = this.z.requestFocus(i2, rect);
        if (requestFocus) {
            b0(false);
        }
        return requestFocus;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAppSearchData(Bundle bundle) {
        this.q0 = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            J();
        } else {
            N();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.c0 == z) {
            return;
        }
        this.c0 = z;
        b0(z);
        X();
    }

    public void setImeOptions(int i2) {
        this.z.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.z.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.j0 = i2;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.V = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.W = onFocusChangeListener;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.U = onQueryTextListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.b0 = onClickListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.a0 = onSuggestionListener;
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.z.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.z;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.m0 = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        O();
    }

    public void setQueryHint(@Nullable CharSequence charSequence) {
        this.g0 = charSequence;
        X();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.h0 = z;
        CursorAdapter cursorAdapter = this.e0;
        if (cursorAdapter instanceof SuggestionsAdapter) {
            ((SuggestionsAdapter) cursorAdapter).setQueryRefinement(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.p0 = searchableInfo;
        if (searchableInfo != null) {
            Y();
            X();
        }
        boolean D = D();
        this.k0 = D;
        if (D) {
            this.z.setPrivateImeOptions(x);
        }
        b0(isIconified());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f0 = z;
        b0(isIconified());
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.e0 = cursorAdapter;
        this.z.setAdapter(cursorAdapter);
    }

    void u() {
        if (this.H.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.B.getPaddingLeft();
            Rect rect = new Rect();
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            int dimensionPixelSize = this.c0 ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) : 0;
            this.z.getDropDownBackground().getPadding(rect);
            this.z.setDropDownHorizontalOffset(isLayoutRtl ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.z.setDropDownWidth((((this.H.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.J = new Rect();
        this.K = new Rect();
        this.L = new int[2];
        this.M = new int[2];
        this.r0 = new Runnable() { // from class: androidx.appcompat.widget.SearchView.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.W();
            }
        };
        this.s0 = new Runnable() { // from class: androidx.appcompat.widget.SearchView.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CursorAdapter cursorAdapter = SearchView.this.e0;
                if (cursorAdapter instanceof SuggestionsAdapter) {
                    cursorAdapter.changeCursor(null);
                }
            }
        };
        this.t0 = new WeakHashMap<>();
        AnonymousClass5 anonymousClass5 = new View.OnClickListener() { // from class: androidx.appcompat.widget.SearchView.5
            AnonymousClass5() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchView searchView = SearchView.this;
                if (view == searchView.D) {
                    searchView.N();
                    return;
                }
                if (view == searchView.F) {
                    searchView.J();
                    return;
                }
                if (view == searchView.E) {
                    searchView.O();
                } else if (view == searchView.G) {
                    searchView.S();
                } else if (view == searchView.z) {
                    searchView.A();
                }
            }
        };
        this.u0 = anonymousClass5;
        this.v0 = new View.OnKeyListener() { // from class: androidx.appcompat.widget.SearchView.6
            AnonymousClass6() {
            }

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i22, KeyEvent keyEvent) {
                SearchView searchView = SearchView.this;
                if (searchView.p0 == null) {
                    return false;
                }
                if (searchView.z.isPopupShowing() && SearchView.this.z.getListSelection() != -1) {
                    return SearchView.this.P(view, i22, keyEvent);
                }
                if (SearchView.this.z.a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i22 != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView searchView2 = SearchView.this;
                searchView2.H(0, null, searchView2.z.getText().toString());
                return true;
            }
        };
        AnonymousClass7 anonymousClass7 = new TextView.OnEditorActionListener() { // from class: androidx.appcompat.widget.SearchView.7
            AnonymousClass7() {
            }

            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i22, KeyEvent keyEvent) {
                SearchView.this.O();
                return true;
            }
        };
        this.w0 = anonymousClass7;
        AnonymousClass8 anonymousClass8 = new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.SearchView.8
            AnonymousClass8() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i22, long j2) {
                SearchView.this.K(i22, 0, null);
            }
        };
        this.x0 = anonymousClass8;
        AnonymousClass9 anonymousClass9 = new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.SearchView.9
            AnonymousClass9() {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i22, long j2) {
                SearchView.this.L(i22);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.y0 = anonymousClass9;
        this.z0 = new TextWatcher() { // from class: androidx.appcompat.widget.SearchView.10
            AnonymousClass10() {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i22, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i22, int i3, int i4) {
                SearchView.this.Q(charSequence);
            }
        };
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.SearchView, i2, 0);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SearchView_layout, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.z = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.A = findViewById(R.id.search_edit_frame);
        View findViewById = findViewById(R.id.search_plate);
        this.B = findViewById;
        View findViewById2 = findViewById(R.id.submit_area);
        this.C = findViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.D = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.E = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.F = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.G = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.N = imageView5;
        ViewCompat.setBackground(findViewById, obtainStyledAttributes.getDrawable(R.styleable.SearchView_queryBackground));
        ViewCompat.setBackground(findViewById2, obtainStyledAttributes.getDrawable(R.styleable.SearchView_submitBackground));
        int i3 = R.styleable.SearchView_searchIcon;
        imageView.setImageDrawable(obtainStyledAttributes.getDrawable(i3));
        imageView2.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_goIcon));
        imageView3.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(obtainStyledAttributes.getDrawable(i3));
        this.O = obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchHintIcon);
        TooltipCompat.setTooltipText(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.P = obtainStyledAttributes.getResourceId(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.Q = obtainStyledAttributes.getResourceId(R.styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(anonymousClass5);
        imageView3.setOnClickListener(anonymousClass5);
        imageView2.setOnClickListener(anonymousClass5);
        imageView4.setOnClickListener(anonymousClass5);
        searchAutoComplete.setOnClickListener(anonymousClass5);
        searchAutoComplete.addTextChangedListener(this.z0);
        searchAutoComplete.setOnEditorActionListener(anonymousClass7);
        searchAutoComplete.setOnItemClickListener(anonymousClass8);
        searchAutoComplete.setOnItemSelectedListener(anonymousClass9);
        searchAutoComplete.setOnKeyListener(this.v0);
        searchAutoComplete.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.appcompat.widget.SearchView.3
            AnonymousClass3() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                SearchView searchView = SearchView.this;
                View.OnFocusChangeListener onFocusChangeListener = searchView.W;
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(searchView, z);
                }
            }
        });
        setIconifiedByDefault(obtainStyledAttributes.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.T = obtainStyledAttributes.getText(R.styleable.SearchView_defaultQueryHint);
        this.g0 = obtainStyledAttributes.getText(R.styleable.SearchView_queryHint);
        int i4 = obtainStyledAttributes.getInt(R.styleable.SearchView_android_imeOptions, -1);
        if (i4 != -1) {
            setImeOptions(i4);
        }
        int i5 = obtainStyledAttributes.getInt(R.styleable.SearchView_android_inputType, -1);
        if (i5 != -1) {
            setInputType(i5);
        }
        setFocusable(obtainStyledAttributes.getBoolean(R.styleable.SearchView_android_focusable, true));
        obtainStyledAttributes.recycle();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.R = intent;
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.S = intent2;
        intent2.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.H = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.appcompat.widget.SearchView.4
                AnonymousClass4() {
                }

                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i22, int i32, int i42, int i52, int i6, int i7, int i8, int i9) {
                    SearchView.this.u();
                }
            });
        }
        b0(this.c0);
        X();
    }

    private void setQuery(CharSequence charSequence) {
        this.z.setText(charSequence);
        this.z.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }
}
