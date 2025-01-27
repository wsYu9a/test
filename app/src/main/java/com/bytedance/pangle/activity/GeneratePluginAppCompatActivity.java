package com.bytedance.pangle.activity;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.Application;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.SharedElementCallback;
import android.app.TaskStackBuilder;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.LocusId;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.PersistableBundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toolbar;
import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Consumer;

@Keep
/* loaded from: classes.dex */
public abstract class GeneratePluginAppCompatActivity extends AppCompatActivity implements IPluginActivity {
    boolean hasInit = true;
    public Plugin mPlugin;
    public GenerateProxyAppCompatActivity mProxyActivity;

    @Override // com.bytedance.pangle.activity.IPluginActivity
    public void _requestPermissions(String[] strArr, int i2) {
        this.mProxyActivity.requestPermissions(strArr, i2);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mProxyActivity.zeusSuperAddContentView(view, layoutParams);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        com.bytedance.pangle.util.a.a(this, this.mProxyActivity);
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        this.mProxyActivity.zeusSuperCloseContextMenu();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void closeOptionsMenu() {
        this.mProxyActivity.zeusSuperCloseOptionsMenu();
    }

    public boolean convertToTranslucent(Activity.TranslucentConversionListener translucentConversionListener, ActivityOptions activityOptions) {
        return this.mProxyActivity.zeusSuperConvertToTranslucent(translucentConversionListener, activityOptions);
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int i2, Intent intent, int i3) {
        return this.mProxyActivity.zeusSuperCreatePendingResult(i2, intent, i3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.mProxyActivity.zeusSuperDispatchGenericMotionEvent(motionEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mProxyActivity.zeusSuperDispatchKeyEvent(keyEvent);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.mProxyActivity.zeusSuperDispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.mProxyActivity.zeusSuperDispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.mProxyActivity.zeusSuperDispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.mProxyActivity.zeusSuperDispatchTrackballEvent(motionEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mProxyActivity.zeusSuperDump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.app.Activity
    public void enterPictureInPictureMode() {
        this.mProxyActivity.zeusSuperEnterPictureInPictureMode();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public View findViewById(int i2) {
        return this.mProxyActivity.zeusSuperFindViewById(i2);
    }

    @Override // android.app.Activity
    public void finish() {
        this.mProxyActivity.zeusSuperFinish();
    }

    @Override // android.app.Activity
    public void finishActivity(int i2) {
        this.mProxyActivity.zeusSuperFinishActivity(i2);
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity activity, int i2) {
        this.mProxyActivity.zeusSuperFinishActivityFromChild(activity, i2);
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        this.mProxyActivity.zeusSuperFinishAffinity();
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        this.mProxyActivity.zeusSuperFinishAfterTransition();
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        this.mProxyActivity.zeusSuperFinishAndRemoveTask();
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        this.mProxyActivity.zeusSuperFinishFromChild(activity);
    }

    @Override // android.app.Activity
    public ActionBar getActionBar() {
        return this.mProxyActivity.zeusSuperGetActionBar();
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        return this.mProxyActivity.zeusSuperGetCallingActivity();
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        return this.mProxyActivity.zeusSuperGetCallingPackage();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        return this.mProxyActivity.zeusSuperGetChangingConfigurations();
    }

    @Override // android.app.Activity
    public ComponentName getComponentName() {
        return this.mProxyActivity.zeusSuperGetComponentName();
    }

    @Override // android.app.Activity
    public Scene getContentScene() {
        return this.mProxyActivity.zeusSuperGetContentScene();
    }

    @Override // android.app.Activity
    public TransitionManager getContentTransitionManager() {
        return this.mProxyActivity.zeusSuperGetContentTransitionManager();
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        return this.mProxyActivity.zeusSuperGetCurrentFocus();
    }

    @Override // android.app.Activity
    public FragmentManager getFragmentManager() {
        return this.mProxyActivity.zeusSuperGetFragmentManager();
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        return this.mProxyActivity.zeusSuperGetIntent();
    }

    @Override // android.app.Activity
    public Object getLastNonConfigurationInstance() {
        return this.mProxyActivity.zeusSuperGetLastNonConfigurationInstance();
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        return this.mProxyActivity.zeusSuperGetLayoutInflater();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        if (!this.hasInit) {
            try {
                LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
                try {
                    Field declaredField = lifecycleRegistry.getClass().getDeclaredField("mEnforceMainThread");
                    declaredField.setAccessible(true);
                    declaredField.set(lifecycleRegistry, Boolean.FALSE);
                } catch (Throwable unused) {
                }
                return lifecycleRegistry;
            } catch (Throwable unused2) {
            }
        }
        return super.getLifecycle();
    }

    @Override // android.app.Activity
    public LoaderManager getLoaderManager() {
        return this.mProxyActivity.zeusSuperGetLoaderManager();
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        return this.mProxyActivity.zeusSuperGetLocalClassName();
    }

    @Override // android.app.Activity
    public int getMaxNumPictureInPictureActions() {
        return this.mProxyActivity.zeusSuperGetMaxNumPictureInPictureActions();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public MenuInflater getMenuInflater() {
        return this.mProxyActivity.zeusSuperGetMenuInflater();
    }

    @Override // android.app.Activity
    public Intent getParentActivityIntent() {
        return this.mProxyActivity.zeusSuperGetParentActivityIntent();
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i2) {
        return this.mProxyActivity.zeusSuperGetPreferences(i2);
    }

    @Override // android.app.Activity
    public Uri getReferrer() {
        return this.mProxyActivity.zeusSuperGetReferrer();
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        return this.mProxyActivity.zeusSuperGetRequestedOrientation();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public androidx.appcompat.app.ActionBar getSupportActionBar() {
        return this.mProxyActivity.zeusSuperGetSupportActionBar();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public androidx.fragment.app.FragmentManager getSupportFragmentManager() {
        return this.mProxyActivity.zeusSuperGetSupportFragmentManager();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        return this.mProxyActivity.zeusSuperGetSystemService(str);
    }

    @Override // android.app.Activity
    public int getTaskId() {
        return this.mProxyActivity.zeusSuperGetTaskId();
    }

    @Override // android.app.Activity
    public VoiceInteractor getVoiceInteractor() {
        return this.mProxyActivity.zeusSuperGetVoiceInteractor();
    }

    @Override // android.app.Activity
    public Window getWindow() {
        return this.mProxyActivity.zeusSuperGetWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        return this.mProxyActivity.zeusSuperGetWindowManager();
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        return this.mProxyActivity.zeusSuperHasWindowFocus();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void invalidateOptionsMenu() {
        this.mProxyActivity.zeusSuperInvalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public boolean isActivityTransitionRunning() {
        return this.mProxyActivity.zeusSuperIsActivityTransitionRunning();
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        return this.mProxyActivity.zeusSuperIsChangingConfigurations();
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        return this.mProxyActivity.zeusSuperIsDestroyed();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        return this.mProxyActivity.zeusSuperIsFinishing();
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        return this.mProxyActivity.zeusSuperIsImmersive();
    }

    @Override // android.app.Activity
    public boolean isInMultiWindowMode() {
        return this.mProxyActivity.zeusSuperIsInMultiWindowMode();
    }

    @Override // android.app.Activity
    public boolean isInPictureInPictureMode() {
        return this.mProxyActivity.zeusSuperIsInPictureInPictureMode();
    }

    @Override // android.app.Activity
    public boolean isLocalVoiceInteractionSupported() {
        return this.mProxyActivity.zeusSuperIsLocalVoiceInteractionSupported();
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        return this.mProxyActivity.zeusSuperIsTaskRoot();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteraction() {
        return this.mProxyActivity.zeusSuperIsVoiceInteraction();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteractionRoot() {
        return this.mProxyActivity.zeusSuperIsVoiceInteractionRoot();
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        return this.mProxyActivity.zeusSuperMoveTaskToBack(z);
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(Intent intent) {
        return this.mProxyActivity.zeusSuperNavigateUpTo(intent);
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(Activity activity, Intent intent) {
        return this.mProxyActivity.zeusSuperNavigateUpToFromChild(activity, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.mProxyActivity.zeusSuperOnActionModeFinished(actionMode);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.mProxyActivity.zeusSuperOnActionModeStarted(actionMode);
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i2, Intent intent) {
        this.mProxyActivity.zeusSuperOnActivityReenter(i2, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        this.mProxyActivity.zeusSuperOnActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    protected void onApplyThemeResource(Resources.Theme theme, int i2, boolean z) {
        this.mProxyActivity.zeusSuperOnApplyThemeResource(theme, i2, z);
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment fragment) {
        this.mProxyActivity.zeusSuperOnAttachFragment(fragment);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.mProxyActivity.zeusSuperOnAttachedToWindow();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.mProxyActivity.zeusSuperOnBackPressed();
    }

    @Override // android.app.Activity
    protected void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        this.mProxyActivity.zeusSuperOnChildTitleChanged(activity, charSequence);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mProxyActivity.zeusSuperOnConfigurationChanged(configuration);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        this.mProxyActivity.zeusSuperOnContentChanged();
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        return this.mProxyActivity.zeusSuperOnContextItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        this.mProxyActivity.zeusSuperOnContextMenuClosed(menu);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mProxyActivity.zeusSuperOnCreate(bundle);
        com.bytedance.pangle.res.b.a(getLayoutInflater());
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mProxyActivity.zeusSuperOnCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        return this.mProxyActivity.zeusSuperOnCreateDescription();
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i2) {
        return this.mProxyActivity.zeusSuperOnCreateDialog(i2);
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        this.mProxyActivity.zeusSuperOnCreateNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return this.mProxyActivity.zeusSuperOnCreateOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        return this.mProxyActivity.zeusSuperOnCreatePanelMenu(i2, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i2) {
        return this.mProxyActivity.zeusSuperOnCreatePanelView(i2);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return this.mProxyActivity.zeusSuperOnCreateThumbnail(bitmap, canvas);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mProxyActivity.zeusSuperOnCreateView(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.mProxyActivity.zeusSuperOnDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.mProxyActivity.zeusSuperOnDetachedFromWindow();
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        this.mProxyActivity.zeusSuperOnEnterAnimationComplete();
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return this.mProxyActivity.zeusSuperOnGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onGetDirectActions(CancellationSignal cancellationSignal, Consumer consumer) {
        this.mProxyActivity.zeusSuperOnGetDirectActions(cancellationSignal, consumer);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return this.mProxyActivity.zeusSuperOnKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        return this.mProxyActivity.zeusSuperOnKeyLongPress(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        return this.mProxyActivity.zeusSuperOnKeyMultiple(i2, i3, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i2, KeyEvent keyEvent) {
        return this.mProxyActivity.zeusSuperOnKeyShortcut(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return this.mProxyActivity.zeusSuperOnKeyUp(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStarted() {
        this.mProxyActivity.zeusSuperOnLocalVoiceInteractionStarted();
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStopped() {
        this.mProxyActivity.zeusSuperOnLocalVoiceInteractionStopped();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mProxyActivity.zeusSuperOnLowMemory();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        return this.mProxyActivity.zeusSuperOnMenuOpened(i2, menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.mProxyActivity.zeusSuperOnMultiWindowModeChanged(z);
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        return this.mProxyActivity.zeusSuperOnNavigateUp();
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(Activity activity) {
        return this.mProxyActivity.zeusSuperOnNavigateUpFromChild(activity);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        this.mProxyActivity.zeusSuperOnNewIntent(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mProxyActivity.zeusSuperOnOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        this.mProxyActivity.zeusSuperOnOptionsMenuClosed(menu);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        this.mProxyActivity.zeusSuperOnPanelClosed(i2, menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.mProxyActivity.zeusSuperOnPause();
    }

    @Override // android.app.Activity
    public void onPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer consumer) {
        this.mProxyActivity.zeusSuperOnPerformDirectAction(str, bundle, cancellationSignal, consumer);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.mProxyActivity.zeusSuperOnPictureInPictureModeChanged(z);
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        return this.mProxyActivity.zeusSuperOnPictureInPictureRequested();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        this.mProxyActivity.zeusSuperOnPostCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPostResume() {
        this.mProxyActivity.zeusSuperOnPostResume();
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i2, Dialog dialog) {
        this.mProxyActivity.zeusSuperOnPrepareDialog(i2, dialog);
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        this.mProxyActivity.zeusSuperOnPrepareNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        return this.mProxyActivity.zeusSuperOnPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return this.mProxyActivity.zeusSuperOnPreparePanel(i2, view, menu);
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent assistContent) {
        this.mProxyActivity.zeusSuperOnProvideAssistContent(assistContent);
    }

    @Override // android.app.Activity
    public void onProvideAssistData(Bundle bundle) {
        this.mProxyActivity.zeusSuperOnProvideAssistData(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List list, Menu menu, int i2) {
        this.mProxyActivity.zeusSuperOnProvideKeyboardShortcuts(list, menu, i2);
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        return this.mProxyActivity.zeusSuperOnProvideReferrer();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.mProxyActivity.zeusSuperOnRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        this.mProxyActivity.zeusSuperOnRestart();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        try {
            this.mProxyActivity.zeusSuperOnRestoreInstanceState(bundle);
        } catch (Throwable unused) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        this.mProxyActivity.zeusSuperOnResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.mProxyActivity.zeusSuperOnSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.mProxyActivity.zeusSuperOnSearchRequested();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        this.mProxyActivity.zeusSuperOnStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStateNotSaved() {
        this.mProxyActivity.zeusSuperOnStateNotSaved();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        this.mProxyActivity.zeusSuperOnStop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i2) {
        this.mProxyActivity.zeusSuperOnTitleChanged(charSequence, i2);
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z) {
        this.mProxyActivity.zeusSuperOnTopResumedActivityChanged(z);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mProxyActivity.zeusSuperOnTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return this.mProxyActivity.zeusSuperOnTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        this.mProxyActivity.zeusSuperOnTrimMemory(i2);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        this.mProxyActivity.zeusSuperOnUserInteraction();
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        this.mProxyActivity.zeusSuperOnUserLeaveHint();
    }

    @Override // android.app.Activity
    public void onVisibleBehindCanceled() {
        this.mProxyActivity.zeusSuperOnVisibleBehindCanceled();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.mProxyActivity.zeusSuperOnWindowAttributesChanged(layoutParams);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        this.mProxyActivity.zeusSuperOnWindowFocusChanged(z);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.mProxyActivity.zeusSuperOnWindowStartingActionMode(callback);
    }

    @Override // android.app.Activity
    public void openContextMenu(View view) {
        this.mProxyActivity.zeusSuperOpenContextMenu(view);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void openOptionsMenu() {
        this.mProxyActivity.zeusSuperOpenOptionsMenu();
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        this.mProxyActivity.zeusSuperOverridePendingTransition(i2, i3);
    }

    @Override // android.app.Activity
    public void postponeEnterTransition() {
        this.mProxyActivity.zeusSuperPostponeEnterTransition();
    }

    @Override // android.app.Activity
    public void recreate() {
        this.mProxyActivity.zeusSuperRecreate();
    }

    @Override // android.app.Activity
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mProxyActivity.zeusSuperRegisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View view) {
        this.mProxyActivity.zeusSuperRegisterForContextMenu(view);
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        return this.mProxyActivity.zeusSuperReleaseInstance();
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        this.mProxyActivity.zeusSuperReportFullyDrawn();
    }

    @Override // android.app.Activity
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent dragEvent) {
        return this.mProxyActivity.zeusSuperRequestDragAndDropPermissions(dragEvent);
    }

    @Override // android.app.Activity
    public boolean requestVisibleBehind(boolean z) {
        return this.mProxyActivity.zeusSuperRequestVisibleBehind(z);
    }

    @Override // android.app.Activity
    public void setActionBar(Toolbar toolbar) {
        this.mProxyActivity.zeusSuperSetActionBar(toolbar);
    }

    @Override // android.app.Activity
    public void setContentTransitionManager(TransitionManager transitionManager) {
        this.mProxyActivity.zeusSuperSetContentTransitionManager(transitionManager);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(int i2) {
        ZeusTransformUtils.clearConstructorCache();
        this.mProxyActivity.zeusSuperSetContentView(i2);
        ZeusTransformUtils.clearConstructorCache();
        c.a(this, findViewById(R.id.content));
    }

    @Override // android.app.Activity
    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.mProxyActivity.zeusSuperSetEnterSharedElementCallback(sharedElementCallback);
    }

    @Override // android.app.Activity
    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.mProxyActivity.zeusSuperSetExitSharedElementCallback(sharedElementCallback);
    }

    @Override // android.app.Activity
    public void setFinishOnTouchOutside(boolean z) {
        this.mProxyActivity.zeusSuperSetFinishOnTouchOutside(z);
    }

    @Override // android.app.Activity
    public void setImmersive(boolean z) {
        this.mProxyActivity.zeusSuperSetImmersive(z);
    }

    @Override // android.app.Activity
    public void setInheritShowWhenLocked(boolean z) {
        this.mProxyActivity.zeusSuperSetInheritShowWhenLocked(z);
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        this.mProxyActivity.zeusSuperSetIntent(intent);
    }

    @Override // android.app.Activity
    public void setLocusContext(LocusId locusId, Bundle bundle) {
        this.mProxyActivity.zeusSuperSetLocusContext(locusId, bundle);
    }

    @Override // android.app.Activity
    public void setPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        this.mProxyActivity.zeusSuperSetPictureInPictureParams(pictureInPictureParams);
    }

    @Override // com.bytedance.pangle.activity.IPluginActivity
    public void setPluginProxyActivity(b bVar, Plugin plugin) {
        this.mProxyActivity = (GenerateProxyAppCompatActivity) bVar;
        this.mPlugin = plugin;
    }

    @Override // com.bytedance.pangle.activity.IPluginActivity
    public void setProxyTheme2Plugin(int i2) {
        try {
            super.setTheme(i2);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        this.mProxyActivity.zeusSuperSetRequestedOrientation(i2);
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean z) {
        this.mProxyActivity.zeusSuperSetShowWhenLocked(z);
    }

    @Override // android.app.Activity
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        this.mProxyActivity.zeusSuperSetTaskDescription(taskDescription);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        this.mProxyActivity.zeusSuperSetTheme(i2);
    }

    @Override // android.app.Activity
    public void setTitle(int i2) {
        this.mProxyActivity.zeusSuperSetTitle(i2);
    }

    @Override // android.app.Activity
    public void setTitleColor(int i2) {
        this.mProxyActivity.zeusSuperSetTitleColor(i2);
    }

    @Override // android.app.Activity
    public boolean setTranslucent(boolean z) {
        return this.mProxyActivity.zeusSuperSetTranslucent(z);
    }

    @Override // android.app.Activity
    public void setTurnScreenOn(boolean z) {
        this.mProxyActivity.zeusSuperSetTurnScreenOn(z);
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        this.mProxyActivity.zeusSuperSetVisible(z);
    }

    @Override // android.app.Activity
    public void setVrModeEnabled(boolean z, ComponentName componentName) {
        this.mProxyActivity.zeusSuperSetVrModeEnabled(z, componentName);
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(String str) {
        return this.mProxyActivity.zeusSuperShouldShowRequestPermissionRationale(str);
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(Intent intent) {
        return this.mProxyActivity.zeusSuperShouldUpRecreateTask(intent);
    }

    @Override // android.app.Activity
    public boolean showAssist(Bundle bundle) {
        return this.mProxyActivity.zeusSuperShowAssist(bundle);
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        this.mProxyActivity.zeusSuperShowLockTaskEscapeMessage();
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return this.mProxyActivity.zeusSuperStartActionMode(callback);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        this.mProxyActivity.zeusSuperStartActivities(intentArr);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        this.mProxyActivity.zeusSuperStartActivity(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        this.mProxyActivity.zeusSuperStartActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i2) {
        this.mProxyActivity.zeusSuperStartActivityFromChild(activity, intent, i2);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2) {
        this.mProxyActivity.zeusSuperStartActivityFromFragment(fragment, intent, i2);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i2) {
        return this.mProxyActivity.zeusSuperStartActivityIfNeeded(intent, i2);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) {
        this.mProxyActivity.zeusSuperStartIntentSender(intentSender, intent, i2, i3, i4);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        this.mProxyActivity.zeusSuperStartIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        this.mProxyActivity.zeusSuperStartIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5);
    }

    @Override // android.app.Activity
    public void startLocalVoiceInteraction(Bundle bundle) {
        this.mProxyActivity.zeusSuperStartLocalVoiceInteraction(bundle);
    }

    @Override // android.app.Activity
    public void startLockTask() {
        this.mProxyActivity.zeusSuperStartLockTask();
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor cursor) {
        this.mProxyActivity.zeusSuperStartManagingCursor(cursor);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent) {
        return this.mProxyActivity.zeusSuperStartNextMatchingActivity(intent);
    }

    @Override // android.app.Activity
    public void startPostponedEnterTransition() {
        this.mProxyActivity.zeusSuperStartPostponedEnterTransition();
    }

    @Override // android.app.Activity
    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        this.mProxyActivity.zeusSuperStartSearch(str, z, bundle, z2);
    }

    @Override // android.app.Activity
    public void stopLocalVoiceInteraction() {
        this.mProxyActivity.zeusSuperStopLocalVoiceInteraction();
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        this.mProxyActivity.zeusSuperStopLockTask();
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor cursor) {
        this.mProxyActivity.zeusSuperStopManagingCursor(cursor);
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        this.mProxyActivity.zeusSuperTakeKeyEvents(z);
    }

    @Override // android.app.Activity
    public void triggerSearch(String str, Bundle bundle) {
        this.mProxyActivity.zeusSuperTriggerSearch(str, bundle);
    }

    @Override // android.app.Activity
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mProxyActivity.zeusSuperUnregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View view) {
        this.mProxyActivity.zeusSuperUnregisterForContextMenu(view);
    }

    @Override // android.app.Activity
    public boolean enterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        return this.mProxyActivity.zeusSuperEnterPictureInPictureMode(pictureInPictureParams);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i2, Bundle bundle) {
        return this.mProxyActivity.zeusSuperOnCreateDialog(i2, bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.mProxyActivity.zeusSuperOnCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        this.mProxyActivity.zeusSuperOnMultiWindowModeChanged(z, configuration);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        this.mProxyActivity.zeusSuperOnPictureInPictureModeChanged(z, configuration);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        this.mProxyActivity.zeusSuperOnPostCreate(bundle, persistableBundle);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i2, Dialog dialog, Bundle bundle) {
        this.mProxyActivity.zeusSuperOnPrepareDialog(i2, dialog, bundle);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        try {
            this.mProxyActivity.zeusSuperOnRestoreInstanceState(bundle, persistableBundle);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        this.mProxyActivity.zeusSuperOnSaveInstanceState(bundle, persistableBundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.mProxyActivity.zeusSuperOnSearchRequested(searchEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        return this.mProxyActivity.zeusSuperOnWindowStartingActionMode(callback, i2);
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        this.mProxyActivity.zeusSuperSetTitle(charSequence);
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback, int i2) {
        return this.mProxyActivity.zeusSuperStartActionMode(callback, i2);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        this.mProxyActivity.zeusSuperStartActivities(intentArr, bundle);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        this.mProxyActivity.zeusSuperStartActivity(intent, bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        this.mProxyActivity.zeusSuperStartActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i2, Bundle bundle) {
        this.mProxyActivity.zeusSuperStartActivityFromChild(activity, intent, i2, bundle);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        this.mProxyActivity.zeusSuperStartActivityFromFragment(fragment, intent, i2, bundle);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i2, Bundle bundle) {
        return this.mProxyActivity.zeusSuperStartActivityIfNeeded(intent, i2, bundle);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        this.mProxyActivity.zeusSuperStartIntentSender(intentSender, intent, i2, i3, i4, bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        this.mProxyActivity.zeusSuperStartIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        this.mProxyActivity.zeusSuperStartIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent, Bundle bundle) {
        return this.mProxyActivity.zeusSuperStartNextMatchingActivity(intent, bundle);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        this.mProxyActivity.zeusSuperOnCreate(bundle, persistableBundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(View view) {
        this.mProxyActivity.zeusSuperSetContentView(view);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mProxyActivity.zeusSuperSetContentView(view, layoutParams);
    }
}
