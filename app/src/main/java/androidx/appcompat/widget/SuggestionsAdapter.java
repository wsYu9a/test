package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
    private static final boolean m = false;
    private static final String n = "SuggestionsAdapter";
    private static final int o = 50;
    static final int p = 0;
    static final int q = 1;
    static final int r = 2;
    static final int s = -1;
    private int A;
    private ColorStateList B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private final SearchManager t;
    private final SearchView u;
    private final SearchableInfo v;
    private final Context w;
    private final WeakHashMap<String, Drawable.ConstantState> x;
    private final int y;
    private boolean z;

    private static final class ChildViewCache {
        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;
        public final TextView mText1;
        public final TextView mText2;

        public ChildViewCache(View view) {
            this.mText1 = (TextView) view.findViewById(R.id.text1);
            this.mText2 = (TextView) view.findViewById(R.id.text2);
            this.mIcon1 = (ImageView) view.findViewById(R.id.icon1);
            this.mIcon2 = (ImageView) view.findViewById(R.id.icon2);
            this.mIconRefine = (ImageView) view.findViewById(androidx.appcompat.R.id.edit_query);
        }
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.z = false;
        this.A = 1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.t = (SearchManager) this.f2227d.getSystemService("search");
        this.u = searchView;
        this.v = searchableInfo;
        this.y = searchView.getSuggestionCommitIconResId();
        this.w = context;
        this.x = weakHashMap;
    }

    private Drawable d(String str) {
        Drawable.ConstantState constantState = this.x.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence e(CharSequence charSequence) {
        if (this.B == null) {
            TypedValue typedValue = new TypedValue();
            this.f2227d.getTheme().resolveAttribute(androidx.appcompat.R.attr.textColorSearchUrl, typedValue, true);
            this.B = this.f2227d.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.B, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable f(ComponentName componentName) {
        PackageManager packageManager = this.f2227d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w(n, "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w(n, e2.toString());
            return null;
        }
    }

    private Drawable g(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (!this.x.containsKey(flattenToShortString)) {
            Drawable f2 = f(componentName);
            this.x.put(flattenToShortString, f2 != null ? f2.getConstantState() : null);
            return f2;
        }
        Drawable.ConstantState constantState = this.x.get(flattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.w.getResources());
    }

    public static String getColumnString(Cursor cursor, String str) {
        return o(cursor, cursor.getColumnIndex(str));
    }

    private Drawable h(Cursor cursor) {
        Drawable g2 = g(this.v.getSearchActivity());
        return g2 != null ? g2 : this.f2227d.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable i(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return j(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.w.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(openInputStream, null);
            } finally {
                try {
                    openInputStream.close();
                } catch (IOException e2) {
                    Log.e(n, "Error closing icon stream for " + uri, e2);
                }
            }
        } catch (FileNotFoundException e3) {
            Log.w(n, "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        }
        Log.w(n, "Icon not found: " + uri + ", " + e3.getMessage());
        return null;
    }

    private Drawable k(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.w.getPackageName() + "/" + parseInt;
            Drawable d2 = d(str2);
            if (d2 != null) {
                return d2;
            }
            Drawable drawable = ContextCompat.getDrawable(this.w, parseInt);
            r(str2, drawable);
            return drawable;
        } catch (Resources.NotFoundException unused) {
            Log.w(n, "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable d3 = d(str);
            if (d3 != null) {
                return d3;
            }
            Drawable i2 = i(Uri.parse(str));
            r(str, i2);
            return i2;
        }
    }

    private Drawable l(Cursor cursor) {
        int i2 = this.F;
        if (i2 == -1) {
            return null;
        }
        Drawable k = k(cursor.getString(i2));
        return k != null ? k : h(cursor);
    }

    private Drawable m(Cursor cursor) {
        int i2 = this.G;
        if (i2 == -1) {
            return null;
        }
        return k(cursor.getString(i2));
    }

    private static String o(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception e2) {
            Log.e(n, "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    private void p(ImageView imageView, Drawable drawable, int i2) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i2);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void q(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void r(String str, Drawable drawable) {
        if (drawable != null) {
            this.x.put(str, drawable.getConstantState());
        }
    }

    private void s(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        ChildViewCache childViewCache = (ChildViewCache) view.getTag();
        int i2 = this.H;
        int i3 = i2 != -1 ? cursor.getInt(i2) : 0;
        if (childViewCache.mText1 != null) {
            q(childViewCache.mText1, o(cursor, this.C));
        }
        if (childViewCache.mText2 != null) {
            String o2 = o(cursor, this.E);
            CharSequence e2 = o2 != null ? e(o2) : o(cursor, this.D);
            if (TextUtils.isEmpty(e2)) {
                TextView textView = childViewCache.mText1;
                if (textView != null) {
                    textView.setSingleLine(false);
                    childViewCache.mText1.setMaxLines(2);
                }
            } else {
                TextView textView2 = childViewCache.mText1;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    childViewCache.mText1.setMaxLines(1);
                }
            }
            q(childViewCache.mText2, e2);
        }
        ImageView imageView = childViewCache.mIcon1;
        if (imageView != null) {
            p(imageView, l(cursor), 4);
        }
        ImageView imageView2 = childViewCache.mIcon2;
        if (imageView2 != null) {
            p(imageView2, m(cursor), 8);
        }
        int i4 = this.A;
        if (i4 != 2 && (i4 != 1 || (i3 & 1) == 0)) {
            childViewCache.mIconRefine.setVisibility(8);
            return;
        }
        childViewCache.mIconRefine.setVisibility(0);
        childViewCache.mIconRefine.setTag(childViewCache.mText1.getText());
        childViewCache.mIconRefine.setOnClickListener(this);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor cursor) {
        if (this.z) {
            Log.w(n, "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.C = cursor.getColumnIndex("suggest_text_1");
                this.D = cursor.getColumnIndex("suggest_text_2");
                this.E = cursor.getColumnIndex("suggest_text_2_url");
                this.F = cursor.getColumnIndex("suggest_icon_1");
                this.G = cursor.getColumnIndex("suggest_icon_2");
                this.H = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e(n, "error changing cursor and caching columns", e2);
        }
    }

    public void close() {
        changeCursor(null);
        this.z = true;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        String columnString;
        String columnString2;
        if (cursor == null) {
            return null;
        }
        String columnString3 = getColumnString(cursor, "suggest_intent_query");
        if (columnString3 != null) {
            return columnString3;
        }
        if (this.v.shouldRewriteQueryFromData() && (columnString2 = getColumnString(cursor, "suggest_intent_data")) != null) {
            return columnString2;
        }
        if (!this.v.shouldRewriteQueryFromText() || (columnString = getColumnString(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return columnString;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w(n, "Search suggestions cursor threw exception.", e2);
            View newDropDownView = newDropDownView(this.f2227d, this.f2226c, viewGroup);
            if (newDropDownView != null) {
                ((ChildViewCache) newDropDownView.getTag()).mText1.setText(e2.toString());
            }
            return newDropDownView;
        }
    }

    public int getQueryRefinement() {
        return this.A;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w(n, "Search suggestions cursor threw exception.", e2);
            View newView = newView(this.f2227d, this.f2226c, viewGroup);
            if (newView != null) {
                ((ChildViewCache) newView.getTag()).mText1.setText(e2.toString());
            }
            return newView;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    Drawable j(Uri uri) throws FileNotFoundException {
        int parseInt;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f2227d.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (parseInt != 0) {
                return resourcesForApplication.getDrawable(parseInt);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor n(SearchableInfo searchableInfo, String str, int i2) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i2 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i2));
        }
        return this.f2227d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new ChildViewCache(newView));
        ((ImageView) newView.findViewById(androidx.appcompat.R.id.edit_query)).setImageResource(this.y);
        return newView;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        s(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        s(getCursor());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.u.M((CharSequence) tag);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.u.getVisibility() == 0 && this.u.getWindowVisibility() == 0) {
            try {
                Cursor n2 = n(this.v, charSequence2, 50);
                if (n2 != null) {
                    n2.getCount();
                    return n2;
                }
            } catch (RuntimeException e2) {
                Log.w(n, "Search suggestions query threw an exception.", e2);
            }
        }
        return null;
    }

    public void setQueryRefinement(int i2) {
        this.A = i2;
    }
}
