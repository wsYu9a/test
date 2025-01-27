package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;

/* loaded from: classes.dex */
public class ShareActionProvider extends ActionProvider {
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";

    /* renamed from: e */
    private static final int f943e = 4;

    /* renamed from: f */
    private int f944f;

    /* renamed from: g */
    private final ShareMenuItemOnMenuItemClickListener f945g;

    /* renamed from: h */
    final Context f946h;

    /* renamed from: i */
    String f947i;

    /* renamed from: j */
    OnShareTargetSelectedListener f948j;
    private ActivityChooserModel.OnChooseActivityListener k;

    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider shareActionProvider, Intent intent);
    }

    private class ShareActivityChooserModelPolicy implements ActivityChooserModel.OnChooseActivityListener {
        ShareActivityChooserModelPolicy() {
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.OnChooseActivityListener
        public boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent) {
            ShareActionProvider shareActionProvider = ShareActionProvider.this;
            OnShareTargetSelectedListener onShareTargetSelectedListener = shareActionProvider.f948j;
            if (onShareTargetSelectedListener == null) {
                return false;
            }
            onShareTargetSelectedListener.onShareTargetSelected(shareActionProvider, intent);
            return false;
        }
    }

    private class ShareMenuItemOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        ShareMenuItemOnMenuItemClickListener() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            ShareActionProvider shareActionProvider = ShareActionProvider.this;
            Intent chooseActivity = ActivityChooserModel.get(shareActionProvider.f946h, shareActionProvider.f947i).chooseActivity(menuItem.getItemId());
            if (chooseActivity == null) {
                return true;
            }
            String action = chooseActivity.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                ShareActionProvider.this.b(chooseActivity);
            }
            ShareActionProvider.this.f946h.startActivity(chooseActivity);
            return true;
        }
    }

    public ShareActionProvider(Context context) {
        super(context);
        this.f944f = 4;
        this.f945g = new ShareMenuItemOnMenuItemClickListener();
        this.f947i = DEFAULT_SHARE_HISTORY_FILE_NAME;
        this.f946h = context;
    }

    private void a() {
        if (this.f948j == null) {
            return;
        }
        if (this.k == null) {
            this.k = new ShareActivityChooserModelPolicy();
        }
        ActivityChooserModel.get(this.f946h, this.f947i).setOnChooseActivityListener(this.k);
    }

    void b(Intent intent) {
        if (Build.VERSION.SDK_INT >= 21) {
            intent.addFlags(134742016);
        } else {
            intent.addFlags(524288);
        }
    }

    @Override // androidx.core.view.ActionProvider
    public boolean hasSubMenu() {
        return true;
    }

    @Override // androidx.core.view.ActionProvider
    public View onCreateActionView() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.f946h);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(ActivityChooserModel.get(this.f946h, this.f947i));
        }
        TypedValue typedValue = new TypedValue();
        this.f946h.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable(this.f946h, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    @Override // androidx.core.view.ActionProvider
    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        ActivityChooserModel activityChooserModel = ActivityChooserModel.get(this.f946h, this.f947i);
        PackageManager packageManager = this.f946h.getPackageManager();
        int activityCount = activityChooserModel.getActivityCount();
        int min = Math.min(activityCount, this.f944f);
        for (int i2 = 0; i2 < min; i2++) {
            ResolveInfo activity = activityChooserModel.getActivity(i2);
            subMenu.add(0, i2, i2, activity.loadLabel(packageManager)).setIcon(activity.loadIcon(packageManager)).setOnMenuItemClickListener(this.f945g);
        }
        if (min < activityCount) {
            SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.f946h.getString(R.string.abc_activity_chooser_view_see_all));
            for (int i3 = 0; i3 < activityCount; i3++) {
                ResolveInfo activity2 = activityChooserModel.getActivity(i3);
                addSubMenu.add(0, i3, i3, activity2.loadLabel(packageManager)).setIcon(activity2.loadIcon(packageManager)).setOnMenuItemClickListener(this.f945g);
            }
        }
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener onShareTargetSelectedListener) {
        this.f948j = onShareTargetSelectedListener;
        a();
    }

    public void setShareHistoryFileName(String str) {
        this.f947i = str;
        a();
    }

    public void setShareIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                b(intent);
            }
        }
        ActivityChooserModel.get(this.f946h, this.f947i).setIntent(intent);
    }
}
