package com.bytedance.pangle.wrapper;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
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
import com.bytedance.pangle.PluginContext;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.Consumer;

@Keep
/* loaded from: classes.dex */
public abstract class GenerateActivityWrapper extends Activity implements a {
    public Activity mOriginActivity;
    public PluginContext pluginContext;

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mOriginActivity.addContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        this.mOriginActivity.closeContextMenu();
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        this.mOriginActivity.closeOptionsMenu();
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int i2, Intent intent, int i3) {
        return this.mOriginActivity.createPendingResult(i2, intent, i3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.mOriginActivity.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mOriginActivity.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.mOriginActivity.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.mOriginActivity.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.mOriginActivity.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.mOriginActivity.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mOriginActivity.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.app.Activity
    public void enterPictureInPictureMode() {
        this.mOriginActivity.enterPictureInPictureMode();
    }

    @Override // android.app.Activity
    public View findViewById(int i2) {
        return this.mOriginActivity.findViewById(i2);
    }

    @Override // android.app.Activity
    public void finish() {
        this.mOriginActivity.finish();
    }

    @Override // android.app.Activity
    public void finishActivity(int i2) {
        this.mOriginActivity.finishActivity(i2);
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity activity, int i2) {
        this.mOriginActivity.finishActivityFromChild(activity, i2);
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        this.mOriginActivity.finishAffinity();
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        this.mOriginActivity.finishAfterTransition();
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        this.mOriginActivity.finishAndRemoveTask();
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        this.mOriginActivity.finishFromChild(activity);
    }

    @Override // android.app.Activity
    public ActionBar getActionBar() {
        return this.mOriginActivity.getActionBar();
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        return this.mOriginActivity.getCallingActivity();
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        return this.mOriginActivity.getCallingPackage();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        return this.mOriginActivity.getChangingConfigurations();
    }

    @Override // android.app.Activity
    public ComponentName getComponentName() {
        return this.mOriginActivity.getComponentName();
    }

    @Override // android.app.Activity
    public Scene getContentScene() {
        return this.mOriginActivity.getContentScene();
    }

    @Override // android.app.Activity
    public TransitionManager getContentTransitionManager() {
        return this.mOriginActivity.getContentTransitionManager();
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        return this.mOriginActivity.getCurrentFocus();
    }

    @Override // android.app.Activity
    public FragmentManager getFragmentManager() {
        return this.mOriginActivity.getFragmentManager();
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        return this.mOriginActivity.getIntent();
    }

    @Override // android.app.Activity
    public Object getLastNonConfigurationInstance() {
        return this.mOriginActivity.getLastNonConfigurationInstance();
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        return this.mOriginActivity.getLayoutInflater();
    }

    @Override // android.app.Activity
    public LoaderManager getLoaderManager() {
        return this.mOriginActivity.getLoaderManager();
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        return this.mOriginActivity.getLocalClassName();
    }

    @Override // android.app.Activity
    public int getMaxNumPictureInPictureActions() {
        return this.mOriginActivity.getMaxNumPictureInPictureActions();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return this.mOriginActivity.getMenuInflater();
    }

    @Override // android.app.Activity
    public Intent getParentActivityIntent() {
        return this.mOriginActivity.getParentActivityIntent();
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i2) {
        return this.mOriginActivity.getPreferences(i2);
    }

    @Override // android.app.Activity
    public Uri getReferrer() {
        return this.mOriginActivity.getReferrer();
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        return this.mOriginActivity.getRequestedOrientation();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        return this.pluginContext.getSystemService(str);
    }

    @Override // android.app.Activity
    public int getTaskId() {
        return this.mOriginActivity.getTaskId();
    }

    @Override // android.app.Activity
    public VoiceInteractor getVoiceInteractor() {
        return this.mOriginActivity.getVoiceInteractor();
    }

    @Override // android.app.Activity
    public Window getWindow() {
        return this.mOriginActivity.getWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        return this.mOriginActivity.getWindowManager();
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        return this.mOriginActivity.hasWindowFocus();
    }

    public int hashCode() {
        return this.mOriginActivity.hashCode();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        this.mOriginActivity.invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public boolean isActivityTransitionRunning() {
        return this.mOriginActivity.isActivityTransitionRunning();
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        return this.mOriginActivity.isChangingConfigurations();
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        return this.mOriginActivity.isDestroyed();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        return this.mOriginActivity.isFinishing();
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        return this.mOriginActivity.isImmersive();
    }

    @Override // android.app.Activity
    public boolean isInMultiWindowMode() {
        return this.mOriginActivity.isInMultiWindowMode();
    }

    @Override // android.app.Activity
    public boolean isInPictureInPictureMode() {
        return this.mOriginActivity.isInPictureInPictureMode();
    }

    @Override // android.app.Activity
    public boolean isLocalVoiceInteractionSupported() {
        return this.mOriginActivity.isLocalVoiceInteractionSupported();
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        return this.mOriginActivity.isTaskRoot();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteraction() {
        return this.mOriginActivity.isVoiceInteraction();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteractionRoot() {
        return this.mOriginActivity.isVoiceInteractionRoot();
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        return this.mOriginActivity.moveTaskToBack(z);
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(Intent intent) {
        return this.mOriginActivity.navigateUpTo(intent);
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(Activity activity, Intent intent) {
        return this.mOriginActivity.navigateUpToFromChild(activity, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.mOriginActivity.onActionModeFinished(actionMode);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.mOriginActivity.onActionModeStarted(actionMode);
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i2, Intent intent) {
        this.mOriginActivity.onActivityReenter(i2, intent);
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment fragment) {
        this.mOriginActivity.onAttachFragment(fragment);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.mOriginActivity.onAttachedToWindow();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mOriginActivity.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mOriginActivity.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        this.mOriginActivity.onContentChanged();
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        return this.mOriginActivity.onContextItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        this.mOriginActivity.onContextMenuClosed(menu);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        this.mOriginActivity.onCreate(bundle, persistableBundle);
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mOriginActivity.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        return this.mOriginActivity.onCreateDescription();
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        this.mOriginActivity.onCreateNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return this.mOriginActivity.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        return this.mOriginActivity.onCreatePanelMenu(i2, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i2) {
        return this.mOriginActivity.onCreatePanelView(i2);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return this.mOriginActivity.onCreateThumbnail(bitmap, canvas);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.mOriginActivity.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.mOriginActivity.onDetachedFromWindow();
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        this.mOriginActivity.onEnterAnimationComplete();
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return this.mOriginActivity.onGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onGetDirectActions(CancellationSignal cancellationSignal, Consumer consumer) {
        this.mOriginActivity.onGetDirectActions(cancellationSignal, consumer);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return this.mOriginActivity.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        return this.mOriginActivity.onKeyLongPress(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        return this.mOriginActivity.onKeyMultiple(i2, i3, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i2, KeyEvent keyEvent) {
        return this.mOriginActivity.onKeyShortcut(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return this.mOriginActivity.onKeyUp(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStarted() {
        this.mOriginActivity.onLocalVoiceInteractionStarted();
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStopped() {
        this.mOriginActivity.onLocalVoiceInteractionStopped();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mOriginActivity.onLowMemory();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        return this.mOriginActivity.onMenuItemSelected(i2, menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        return this.mOriginActivity.onMenuOpened(i2, menu);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        this.mOriginActivity.onMultiWindowModeChanged(z, configuration);
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        return this.mOriginActivity.onNavigateUp();
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(Activity activity) {
        return this.mOriginActivity.onNavigateUpFromChild(activity);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mOriginActivity.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        this.mOriginActivity.onOptionsMenuClosed(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        this.mOriginActivity.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    public void onPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer consumer) {
        this.mOriginActivity.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        this.mOriginActivity.onPictureInPictureModeChanged(z, configuration);
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        return this.mOriginActivity.onPictureInPictureRequested();
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        this.mOriginActivity.onPostCreate(bundle, persistableBundle);
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        this.mOriginActivity.onPrepareNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        return this.mOriginActivity.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return this.mOriginActivity.onPreparePanel(i2, view, menu);
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent assistContent) {
        this.mOriginActivity.onProvideAssistContent(assistContent);
    }

    @Override // android.app.Activity
    public void onProvideAssistData(Bundle bundle) {
        this.mOriginActivity.onProvideAssistData(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List list, Menu menu, int i2) {
        this.mOriginActivity.onProvideKeyboardShortcuts(list, menu, i2);
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        return this.mOriginActivity.onProvideReferrer();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.mOriginActivity.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        this.mOriginActivity.onRestoreInstanceState(bundle, persistableBundle);
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        return this.mOriginActivity.onRetainNonConfigurationInstance();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        this.mOriginActivity.onSaveInstanceState(bundle, persistableBundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.mOriginActivity.onSearchRequested(searchEvent);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mOriginActivity.onStateNotSaved();
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z) {
        this.mOriginActivity.onTopResumedActivityChanged(z);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mOriginActivity.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return this.mOriginActivity.onTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        this.mOriginActivity.onTrimMemory(i2);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        this.mOriginActivity.onUserInteraction();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.mOriginActivity.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        this.mOriginActivity.onWindowFocusChanged(z);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.mOriginActivity.onWindowStartingActionMode(callback);
    }

    @Override // android.app.Activity
    public void openContextMenu(View view) {
        this.mOriginActivity.openContextMenu(view);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        this.mOriginActivity.openOptionsMenu();
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        this.mOriginActivity.overridePendingTransition(i2, i3);
    }

    @Override // android.app.Activity
    public void postponeEnterTransition() {
        this.mOriginActivity.postponeEnterTransition();
    }

    @Override // android.app.Activity
    public void recreate() {
        this.mOriginActivity.recreate();
    }

    @Override // android.app.Activity
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mOriginActivity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View view) {
        this.mOriginActivity.registerForContextMenu(view);
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        return this.mOriginActivity.releaseInstance();
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        this.mOriginActivity.reportFullyDrawn();
    }

    @Override // android.app.Activity
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent dragEvent) {
        return this.mOriginActivity.requestDragAndDropPermissions(dragEvent);
    }

    @Override // android.app.Activity
    public boolean requestVisibleBehind(boolean z) {
        return this.mOriginActivity.requestVisibleBehind(z);
    }

    @Override // android.app.Activity
    public void setActionBar(Toolbar toolbar) {
        this.mOriginActivity.setActionBar(toolbar);
    }

    @Override // android.app.Activity
    public void setContentTransitionManager(TransitionManager transitionManager) {
        this.mOriginActivity.setContentTransitionManager(transitionManager);
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        this.mOriginActivity.setContentView(i2);
    }

    @Override // android.app.Activity
    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.mOriginActivity.setEnterSharedElementCallback(sharedElementCallback);
    }

    @Override // android.app.Activity
    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.mOriginActivity.setExitSharedElementCallback(sharedElementCallback);
    }

    @Override // android.app.Activity
    public void setFinishOnTouchOutside(boolean z) {
        this.mOriginActivity.setFinishOnTouchOutside(z);
    }

    @Override // android.app.Activity
    public void setImmersive(boolean z) {
        this.mOriginActivity.setImmersive(z);
    }

    @Override // android.app.Activity
    public void setInheritShowWhenLocked(boolean z) {
        this.mOriginActivity.setInheritShowWhenLocked(z);
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        this.mOriginActivity.setIntent(intent);
    }

    @Override // android.app.Activity
    public void setLocusContext(LocusId locusId, Bundle bundle) {
        this.mOriginActivity.setLocusContext(locusId, bundle);
    }

    @Override // android.app.Activity
    public void setPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        this.mOriginActivity.setPictureInPictureParams(pictureInPictureParams);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        this.mOriginActivity.setRequestedOrientation(i2);
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean z) {
        this.mOriginActivity.setShowWhenLocked(z);
    }

    @Override // android.app.Activity
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        this.mOriginActivity.setTaskDescription(taskDescription);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        this.mOriginActivity.setTheme(i2);
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        this.mOriginActivity.setTitle(charSequence);
    }

    @Override // android.app.Activity
    public void setTitleColor(int i2) {
        this.mOriginActivity.setTitleColor(i2);
    }

    @Override // android.app.Activity
    public boolean setTranslucent(boolean z) {
        return this.mOriginActivity.setTranslucent(z);
    }

    @Override // android.app.Activity
    public void setTurnScreenOn(boolean z) {
        this.mOriginActivity.setTurnScreenOn(z);
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        this.mOriginActivity.setVisible(z);
    }

    @Override // android.app.Activity
    public void setVrModeEnabled(boolean z, ComponentName componentName) {
        this.mOriginActivity.setVrModeEnabled(z, componentName);
    }

    @Override // com.bytedance.pangle.wrapper.a
    public void setWrapperActivityTheme(int i2) {
        try {
            super.setTheme(i2);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(String str) {
        return this.mOriginActivity.shouldShowRequestPermissionRationale(str);
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(Intent intent) {
        return this.mOriginActivity.shouldUpRecreateTask(intent);
    }

    @Override // android.app.Activity
    public boolean showAssist(Bundle bundle) {
        return this.mOriginActivity.showAssist(bundle);
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        this.mOriginActivity.showLockTaskEscapeMessage();
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return this.mOriginActivity.startActionMode(callback);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        this.mOriginActivity.startActivities(intentArr);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        this.mOriginActivity.startActivity(intent);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        this.mOriginActivity.startActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i2) {
        this.mOriginActivity.startActivityFromChild(activity, intent, i2);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2) {
        this.mOriginActivity.startActivityFromFragment(fragment, intent, i2);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i2) {
        return this.mOriginActivity.startActivityIfNeeded(intent, i2);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) {
        this.mOriginActivity.startIntentSender(intentSender, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        this.mOriginActivity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        this.mOriginActivity.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5);
    }

    @Override // android.app.Activity
    public void startLocalVoiceInteraction(Bundle bundle) {
        this.mOriginActivity.startLocalVoiceInteraction(bundle);
    }

    @Override // android.app.Activity
    public void startLockTask() {
        this.mOriginActivity.startLockTask();
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor cursor) {
        this.mOriginActivity.startManagingCursor(cursor);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent) {
        return this.mOriginActivity.startNextMatchingActivity(intent);
    }

    @Override // android.app.Activity
    public void startPostponedEnterTransition() {
        this.mOriginActivity.startPostponedEnterTransition();
    }

    @Override // android.app.Activity
    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        this.mOriginActivity.startSearch(str, z, bundle, z2);
    }

    @Override // android.app.Activity
    public void stopLocalVoiceInteraction() {
        this.mOriginActivity.stopLocalVoiceInteraction();
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        this.mOriginActivity.stopLockTask();
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor cursor) {
        this.mOriginActivity.stopManagingCursor(cursor);
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        this.mOriginActivity.takeKeyEvents(z);
    }

    @Override // android.app.Activity
    public void triggerSearch(String str, Bundle bundle) {
        this.mOriginActivity.triggerSearch(str, bundle);
    }

    @Override // android.app.Activity
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mOriginActivity.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View view) {
        this.mOriginActivity.unregisterForContextMenu(view);
    }

    @Override // android.app.Activity
    public boolean enterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        return this.mOriginActivity.enterPictureInPictureMode(pictureInPictureParams);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mOriginActivity.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.mOriginActivity.onMultiWindowModeChanged(z);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.mOriginActivity.onPictureInPictureModeChanged(z);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.mOriginActivity.onSearchRequested();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        return this.mOriginActivity.onWindowStartingActionMode(callback, i2);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        this.mOriginActivity.setContentView(view);
    }

    @Override // android.app.Activity
    public void setTitle(int i2) {
        this.mOriginActivity.setTitle(i2);
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback, int i2) {
        return this.mOriginActivity.startActionMode(callback, i2);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        this.mOriginActivity.startActivities(intentArr, bundle);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        this.mOriginActivity.startActivity(intent, bundle);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        this.mOriginActivity.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i2, Bundle bundle) {
        this.mOriginActivity.startActivityFromChild(activity, intent, i2, bundle);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        this.mOriginActivity.startActivityFromFragment(fragment, intent, i2, bundle);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i2, Bundle bundle) {
        return this.mOriginActivity.startActivityIfNeeded(intent, i2, bundle);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        this.mOriginActivity.startIntentSender(intentSender, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        this.mOriginActivity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        this.mOriginActivity.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent, Bundle bundle) {
        return this.mOriginActivity.startNextMatchingActivity(intent, bundle);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mOriginActivity.setContentView(view, layoutParams);
    }
}
