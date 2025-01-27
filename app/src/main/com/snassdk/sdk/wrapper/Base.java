package com.snassdk.sdk.wrapper;

import ag.b;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.content.pm.ProviderInfo;
import android.provider.DocumentsProvider;
import androidx.annotation.RequiresApi;

/* loaded from: classes4.dex */
public class Base {

    @b
    public static class AccountAuthenticatorActivity extends android.accounts.AccountAuthenticatorActivity {
        @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            super.attachBaseContext(Wrapper.wrap(context));
        }
    }

    @b
    public static class Activity extends android.app.Activity {
        @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            super.attachBaseContext(Wrapper.wrap(context));
        }
    }

    @b
    public static class ActivityGroup extends android.app.ActivityGroup {
        @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            super.attachBaseContext(Wrapper.wrap(context));
        }
    }

    @b
    public static class AliasActivity extends android.app.AliasActivity {
        @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            super.attachBaseContext(Wrapper.wrap(context));
        }
    }

    @b
    public static class Application extends android.app.Application {

        /* renamed from: b */
        public Context f20910b;

        @Override // android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            this.f20910b = context;
            super.attachBaseContext(Wrapper.wrap(context));
        }

        @Override // android.content.ContextWrapper
        public Context getBaseContext() {
            return this.f20910b;
        }
    }

    public static abstract class BDocumentsProvider extends DocumentsProvider {
        @Override // android.provider.DocumentsProvider, android.content.ContentProvider
        public void attachInfo(Context context, ProviderInfo providerInfo) {
            super.attachInfo(Wrapper.wrap(context), providerInfo);
        }
    }

    public static abstract class BSearchRecentSuggestionsProvider extends SearchRecentSuggestionsProvider {
        @Override // android.content.ContentProvider
        public void attachInfo(Context context, ProviderInfo providerInfo) {
            super.attachInfo(Wrapper.wrap(context), providerInfo);
        }
    }

    @b
    public static abstract class ContentProvider extends android.content.ContentProvider {
        @Override // android.content.ContentProvider
        public void attachInfo(Context context, ProviderInfo providerInfo) {
            super.attachInfo(Wrapper.wrap(context), providerInfo);
        }
    }

    @b
    public static class ExpandableListActivity extends android.app.ExpandableListActivity {
        @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            super.attachBaseContext(Wrapper.wrap(context));
        }
    }

    @b
    public static abstract class IntentService extends android.app.IntentService {
        public IntentService(String str) {
            super(str);
        }

        @Override // android.app.Service, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            super.attachBaseContext(Wrapper.wrap(context));
        }
    }

    @b
    @RequiresApi(api = 21)
    public static abstract class JobService extends android.app.job.JobService {
        @Override // android.app.Service, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            super.attachBaseContext(Wrapper.wrap(context));
        }
    }

    @b
    public static class LauncherActivity extends android.app.LauncherActivity {
        @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            super.attachBaseContext(Wrapper.wrap(context));
        }
    }

    @b
    public static class ListActivity extends android.app.ListActivity {
        @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            super.attachBaseContext(Wrapper.wrap(context));
        }
    }

    @b
    public static class NativeActivity extends android.app.NativeActivity {
        @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            super.attachBaseContext(Wrapper.wrap(context));
        }
    }

    @b
    public static class PreferenceActivity extends android.preference.PreferenceActivity {
        @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            super.attachBaseContext(Wrapper.wrap(context));
        }
    }

    @b
    public static abstract class Service extends android.app.Service {
        @Override // android.app.Service, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            super.attachBaseContext(Wrapper.wrap(context));
        }
    }

    @RequiresApi(api = 28)
    public static abstract class SliceProvider extends android.app.slice.SliceProvider {
        @Override // android.app.slice.SliceProvider, android.content.ContentProvider
        public void attachInfo(Context context, ProviderInfo providerInfo) {
            super.attachInfo(Wrapper.wrap(context), providerInfo);
        }
    }

    @b
    public static class TabActivity extends android.app.TabActivity {
        @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            super.attachBaseContext(Wrapper.wrap(context));
        }
    }
}
