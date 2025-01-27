package com.bytedance.pangle.activity;

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
import com.bytedance.pangle.plugin.Plugin;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Consumer;

@Keep
/* loaded from: classes.dex */
public abstract class GenerateProxyActivity extends Activity implements b {
    public Plugin mPlugin;
    public GeneratePluginActivity mTargetActivity;

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.addContentView(view, layoutParams);
        } else {
            super.addContentView(view, layoutParams);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        c.a(this, context);
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.closeContextMenu();
        } else {
            super.closeContextMenu();
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.closeOptionsMenu();
        } else {
            super.closeOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int i2, Intent intent, int i3) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.createPendingResult(i2, intent, i3) : super.createPendingResult(i2, intent, i3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.dispatchGenericMotionEvent(motionEvent) : super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.dispatchKeyEvent(keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.dispatchKeyShortcutEvent(keyEvent) : super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.dispatchPopulateAccessibilityEvent(accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.dispatchTouchEvent(motionEvent) : super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.dispatchTrackballEvent(motionEvent) : super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.dump(str, fileDescriptor, printWriter, strArr);
        } else {
            super.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Activity
    public void enterPictureInPictureMode() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.enterPictureInPictureMode();
        } else {
            super.enterPictureInPictureMode();
        }
    }

    @Override // android.app.Activity
    public View findViewById(int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.findViewById(i2) : super.findViewById(i2);
    }

    @Override // android.app.Activity, com.bytedance.pangle.activity.b
    public void finish() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.finish();
        } else {
            super.finish();
        }
    }

    @Override // android.app.Activity
    public void finishActivity(int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.finishActivity(i2);
        } else {
            super.finishActivity(i2);
        }
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity activity, int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.finishActivityFromChild(activity, i2);
        } else {
            super.finishActivityFromChild(activity, i2);
        }
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.finishAffinity();
        } else {
            super.finishAffinity();
        }
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.finishAfterTransition();
        } else {
            super.finishAfterTransition();
        }
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.finishAndRemoveTask();
        } else {
            super.finishAndRemoveTask();
        }
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.finishFromChild(activity);
        } else {
            super.finishFromChild(activity);
        }
    }

    @Override // android.app.Activity
    public ActionBar getActionBar() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getActionBar() : super.getActionBar();
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getCallingActivity() : super.getCallingActivity();
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getCallingPackage() : super.getCallingPackage();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getChangingConfigurations() : super.getChangingConfigurations();
    }

    @Override // android.app.Activity
    public ComponentName getComponentName() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getComponentName() : super.getComponentName();
    }

    @Override // android.app.Activity
    public Scene getContentScene() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getContentScene() : super.getContentScene();
    }

    @Override // android.app.Activity
    public TransitionManager getContentTransitionManager() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getContentTransitionManager() : super.getContentTransitionManager();
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getCurrentFocus() : super.getCurrentFocus();
    }

    @Override // android.app.Activity
    public FragmentManager getFragmentManager() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getFragmentManager() : super.getFragmentManager();
    }

    @Override // android.app.Activity, com.bytedance.pangle.activity.b
    public Intent getIntent() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getIntent() : super.getIntent();
    }

    @Override // android.app.Activity
    public Object getLastNonConfigurationInstance() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getLastNonConfigurationInstance() : super.getLastNonConfigurationInstance();
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getLayoutInflater() : super.getLayoutInflater();
    }

    @Override // android.app.Activity
    public LoaderManager getLoaderManager() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getLoaderManager() : super.getLoaderManager();
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getLocalClassName() : super.getLocalClassName();
    }

    @Override // android.app.Activity
    public int getMaxNumPictureInPictureActions() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getMaxNumPictureInPictureActions() : super.getMaxNumPictureInPictureActions();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getMenuInflater() : super.getMenuInflater();
    }

    @Override // android.app.Activity
    public Intent getParentActivityIntent() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getParentActivityIntent() : super.getParentActivityIntent();
    }

    @Override // com.bytedance.pangle.activity.b
    public Plugin getPlugin() {
        return this.mPlugin;
    }

    public abstract String getPluginPkgName();

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getPreferences(i2) : super.getPreferences(i2);
    }

    @Override // android.app.Activity
    public Uri getReferrer() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getReferrer() : super.getReferrer();
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getRequestedOrientation() : super.getRequestedOrientation();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getSystemService(str) : super.getSystemService(str);
    }

    @Override // android.app.Activity
    public int getTaskId() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getTaskId() : super.getTaskId();
    }

    @Override // android.app.Activity
    public VoiceInteractor getVoiceInteractor() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getVoiceInteractor() : super.getVoiceInteractor();
    }

    @Override // android.app.Activity
    public Window getWindow() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getWindow() : super.getWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getWindowManager() : super.getWindowManager();
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.hasWindowFocus() : super.hasWindowFocus();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.invalidateOptionsMenu();
        } else {
            super.invalidateOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public boolean isActivityTransitionRunning() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isActivityTransitionRunning() : super.isActivityTransitionRunning();
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isChangingConfigurations() : super.isChangingConfigurations();
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isDestroyed() : super.isDestroyed();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isFinishing() : super.isFinishing();
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isImmersive() : super.isImmersive();
    }

    @Override // android.app.Activity
    public boolean isInMultiWindowMode() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isInMultiWindowMode() : super.isInMultiWindowMode();
    }

    @Override // android.app.Activity
    public boolean isInPictureInPictureMode() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isInPictureInPictureMode() : super.isInPictureInPictureMode();
    }

    @Override // android.app.Activity
    public boolean isLocalVoiceInteractionSupported() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isLocalVoiceInteractionSupported() : super.isLocalVoiceInteractionSupported();
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isTaskRoot() : super.isTaskRoot();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteraction() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isVoiceInteraction() : super.isVoiceInteraction();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteractionRoot() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isVoiceInteractionRoot() : super.isVoiceInteractionRoot();
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.moveTaskToBack(z) : super.moveTaskToBack(z);
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(Intent intent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.navigateUpTo(intent) : super.navigateUpTo(intent);
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(Activity activity, Intent intent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.navigateUpToFromChild(activity, intent) : super.navigateUpToFromChild(activity, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onActionModeFinished(actionMode);
        } else {
            super.onActionModeFinished(actionMode);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onActionModeStarted(actionMode);
        } else {
            super.onActionModeStarted(actionMode);
        }
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i2, Intent intent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onActivityReenter(i2, intent);
        } else {
            super.onActivityReenter(i2, intent);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onActivityResult(i2, i3, intent);
        } else {
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    protected void onApplyThemeResource(Resources.Theme theme, int i2, boolean z) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onApplyThemeResource(theme, i2, z);
        } else {
            super.onApplyThemeResource(theme, i2, z);
        }
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment fragment) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onAttachFragment(fragment);
        } else {
            super.onAttachFragment(fragment);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onAttachedToWindow();
        } else {
            super.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onChildTitleChanged(activity, charSequence);
        } else {
            super.onChildTitleChanged(activity, charSequence);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onConfigurationChanged(configuration);
        } else {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onContentChanged();
        } else {
            super.onContentChanged();
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onContextItemSelected(menuItem) : super.onContextItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onContextMenuClosed(menu);
        } else {
            super.onContextMenuClosed(menu);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        c.a(this, bundle);
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        } else {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onCreateDescription() : super.onCreateDescription();
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onCreateDialog(i2) : super.onCreateDialog(i2);
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onCreateNavigateUpTaskStack(taskStackBuilder);
        } else {
            super.onCreateNavigateUpTaskStack(taskStackBuilder);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onCreateOptionsMenu(menu) : super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onCreatePanelMenu(i2, menu) : super.onCreatePanelMenu(i2, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onCreatePanelView(i2) : super.onCreatePanelView(i2);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onCreateThumbnail(bitmap, canvas) : super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onCreateView(view, str, context, attributeSet) : super.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onDestroy();
        } else {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onDetachedFromWindow();
        } else {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onEnterAnimationComplete();
        } else {
            super.onEnterAnimationComplete();
        }
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onGenericMotionEvent(motionEvent) : super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onGetDirectActions(CancellationSignal cancellationSignal, Consumer consumer) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onGetDirectActions(cancellationSignal, consumer);
        } else {
            super.onGetDirectActions(cancellationSignal, consumer);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onKeyDown(i2, keyEvent) : super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onKeyLongPress(i2, keyEvent) : super.onKeyLongPress(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onKeyMultiple(i2, i3, keyEvent) : super.onKeyMultiple(i2, i3, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i2, KeyEvent keyEvent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onKeyShortcut(i2, keyEvent) : super.onKeyShortcut(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onKeyUp(i2, keyEvent) : super.onKeyUp(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStarted() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onLocalVoiceInteractionStarted();
        } else {
            super.onLocalVoiceInteractionStarted();
        }
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStopped() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onLocalVoiceInteractionStopped();
        } else {
            super.onLocalVoiceInteractionStopped();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onLowMemory();
        } else {
            super.onLowMemory();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onMenuOpened(i2, menu) : super.onMenuOpened(i2, menu);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onMultiWindowModeChanged(z);
        } else {
            super.onMultiWindowModeChanged(z);
        }
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onNavigateUp() : super.onNavigateUp();
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(Activity activity) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onNavigateUpFromChild(activity) : super.onNavigateUpFromChild(activity);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onNewIntent(intent);
        } else {
            super.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onOptionsItemSelected(menuItem) : super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onOptionsMenuClosed(menu);
        } else {
            super.onOptionsMenuClosed(menu);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPanelClosed(i2, menu);
        } else {
            super.onPanelClosed(i2, menu);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPause();
        } else {
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer consumer) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
        } else {
            super.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPictureInPictureModeChanged(z);
        } else {
            super.onPictureInPictureModeChanged(z);
        }
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onPictureInPictureRequested() : super.onPictureInPictureRequested();
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPostCreate(bundle);
        } else {
            super.onPostCreate(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPostResume();
        } else {
            super.onPostResume();
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i2, Dialog dialog) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPrepareDialog(i2, dialog);
        } else {
            super.onPrepareDialog(i2, dialog);
        }
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPrepareNavigateUpTaskStack(taskStackBuilder);
        } else {
            super.onPrepareNavigateUpTaskStack(taskStackBuilder);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onPrepareOptionsMenu(menu) : super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onPreparePanel(i2, view, menu) : super.onPreparePanel(i2, view, menu);
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent assistContent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onProvideAssistContent(assistContent);
        } else {
            super.onProvideAssistContent(assistContent);
        }
    }

    @Override // android.app.Activity
    public void onProvideAssistData(Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onProvideAssistData(bundle);
        } else {
            super.onProvideAssistData(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List list, Menu menu, int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onProvideKeyboardShortcuts(list, menu, i2);
        } else {
            super.onProvideKeyboardShortcuts(list, menu, i2);
        }
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onProvideReferrer() : super.onProvideReferrer();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onRequestPermissionsResult(i2, strArr, iArr);
        } else {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onRestart();
        } else {
            super.onRestart();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onRestoreInstanceState(bundle);
        } else {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onResume();
        } else {
            super.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onSaveInstanceState(bundle);
        } else {
            super.onSaveInstanceState(bundle);
        }
        bundle.clear();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onSearchRequested() : super.onSearchRequested();
    }

    @Override // android.app.Activity
    protected void onStart() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onStart();
        } else {
            super.onStart();
        }
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onStateNotSaved();
        } else {
            super.onStateNotSaved();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onStop();
        } else {
            super.onStop();
        }
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onTitleChanged(charSequence, i2);
        } else {
            super.onTitleChanged(charSequence, i2);
        }
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onTopResumedActivityChanged(z);
        } else {
            super.onTopResumedActivityChanged(z);
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onTrackballEvent(motionEvent) : super.onTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onTrimMemory(i2);
        } else {
            super.onTrimMemory(i2);
        }
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onUserInteraction();
        } else {
            super.onUserInteraction();
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onUserLeaveHint();
        } else {
            super.onUserLeaveHint();
        }
    }

    @Override // android.app.Activity
    public void onVisibleBehindCanceled() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onVisibleBehindCanceled();
        } else {
            super.onVisibleBehindCanceled();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onWindowAttributesChanged(layoutParams);
        } else {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onWindowFocusChanged(z);
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onWindowStartingActionMode(callback) : super.onWindowStartingActionMode(callback);
    }

    @Override // android.app.Activity
    public void openContextMenu(View view) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.openContextMenu(view);
        } else {
            super.openContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.openOptionsMenu();
        } else {
            super.openOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.overridePendingTransition(i2, i3);
        } else {
            super.overridePendingTransition(i2, i3);
        }
    }

    @Override // android.app.Activity
    public void postponeEnterTransition() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.postponeEnterTransition();
        } else {
            super.postponeEnterTransition();
        }
    }

    @Override // android.app.Activity
    public void recreate() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.recreate();
        } else {
            super.recreate();
        }
    }

    @Override // android.app.Activity
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View view) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.registerForContextMenu(view);
        } else {
            super.registerForContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.releaseInstance() : super.releaseInstance();
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.reportFullyDrawn();
        } else {
            super.reportFullyDrawn();
        }
    }

    @Override // android.app.Activity
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent dragEvent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.requestDragAndDropPermissions(dragEvent) : super.requestDragAndDropPermissions(dragEvent);
    }

    @Override // android.app.Activity
    public boolean requestVisibleBehind(boolean z) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.requestVisibleBehind(z) : super.requestVisibleBehind(z);
    }

    @Override // android.app.Activity
    public void setActionBar(Toolbar toolbar) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setActionBar(toolbar);
        } else {
            super.setActionBar(toolbar);
        }
    }

    @Override // android.app.Activity
    public void setContentTransitionManager(TransitionManager transitionManager) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setContentTransitionManager(transitionManager);
        } else {
            super.setContentTransitionManager(transitionManager);
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setContentView(i2);
        } else {
            super.setContentView(i2);
        }
    }

    @Override // android.app.Activity
    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setEnterSharedElementCallback(sharedElementCallback);
        } else {
            super.setEnterSharedElementCallback(sharedElementCallback);
        }
    }

    @Override // android.app.Activity
    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setExitSharedElementCallback(sharedElementCallback);
        } else {
            super.setExitSharedElementCallback(sharedElementCallback);
        }
    }

    @Override // android.app.Activity
    public void setFinishOnTouchOutside(boolean z) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setFinishOnTouchOutside(z);
        } else {
            super.setFinishOnTouchOutside(z);
        }
    }

    @Override // android.app.Activity
    public void setImmersive(boolean z) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setImmersive(z);
        } else {
            super.setImmersive(z);
        }
    }

    @Override // android.app.Activity
    public void setInheritShowWhenLocked(boolean z) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setInheritShowWhenLocked(z);
        } else {
            super.setInheritShowWhenLocked(z);
        }
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setIntent(intent);
        } else {
            super.setIntent(intent);
        }
    }

    @Override // android.app.Activity
    public void setLocusContext(LocusId locusId, Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setLocusContext(locusId, bundle);
        } else {
            super.setLocusContext(locusId, bundle);
        }
    }

    @Override // android.app.Activity
    public void setPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setPictureInPictureParams(pictureInPictureParams);
        } else {
            super.setPictureInPictureParams(pictureInPictureParams);
        }
    }

    @Override // com.bytedance.pangle.activity.b
    public void setPlugin(Plugin plugin) {
        this.mPlugin = plugin;
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setRequestedOrientation(i2);
        } else {
            super.setRequestedOrientation(i2);
        }
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean z) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setShowWhenLocked(z);
        } else {
            super.setShowWhenLocked(z);
        }
    }

    @Override // com.bytedance.pangle.activity.b
    public void setTargetActivity(IPluginActivity iPluginActivity) {
        this.mTargetActivity = (GeneratePluginActivity) iPluginActivity;
    }

    @Override // android.app.Activity
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setTaskDescription(taskDescription);
        } else {
            super.setTaskDescription(taskDescription);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setTheme(i2);
        } else {
            super.setTheme(i2);
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setTitle(i2);
        } else {
            super.setTitle(i2);
        }
    }

    @Override // android.app.Activity
    public void setTitleColor(int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setTitleColor(i2);
        } else {
            super.setTitleColor(i2);
        }
    }

    @Override // android.app.Activity
    public boolean setTranslucent(boolean z) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.setTranslucent(z) : super.setTranslucent(z);
    }

    @Override // android.app.Activity
    public void setTurnScreenOn(boolean z) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setTurnScreenOn(z);
        } else {
            super.setTurnScreenOn(z);
        }
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setVisible(z);
        } else {
            super.setVisible(z);
        }
    }

    @Override // android.app.Activity
    public void setVrModeEnabled(boolean z, ComponentName componentName) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setVrModeEnabled(z, componentName);
        } else {
            super.setVrModeEnabled(z, componentName);
        }
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(String str) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.shouldShowRequestPermissionRationale(str) : super.shouldShowRequestPermissionRationale(str);
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(Intent intent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.shouldUpRecreateTask(intent) : super.shouldUpRecreateTask(intent);
    }

    @Override // android.app.Activity
    public boolean showAssist(Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.showAssist(bundle) : super.showAssist(bundle);
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.showLockTaskEscapeMessage();
        } else {
            super.showLockTaskEscapeMessage();
        }
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.startActionMode(callback) : super.startActionMode(callback);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivities(intentArr);
        } else {
            super.startActivities(intentArr);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivity(intent);
        } else {
            super.startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivityForResult(intent, i2);
        } else {
            super.startActivityForResult(intent, i2);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivityFromChild(activity, intent, i2);
        } else {
            super.startActivityFromChild(activity, intent, i2);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivityFromFragment(fragment, intent, i2);
        } else {
            super.startActivityFromFragment(fragment, intent, i2);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.startActivityIfNeeded(intent, i2) : super.startActivityIfNeeded(intent, i2);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startIntentSender(intentSender, intent, i2, i3, i4);
        } else {
            super.startIntentSender(intentSender, intent, i2, i3, i4);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
        } else {
            super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5);
        } else {
            super.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5);
        }
    }

    @Override // android.app.Activity
    public void startLocalVoiceInteraction(Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startLocalVoiceInteraction(bundle);
        } else {
            super.startLocalVoiceInteraction(bundle);
        }
    }

    @Override // android.app.Activity
    public void startLockTask() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startLockTask();
        } else {
            super.startLockTask();
        }
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor cursor) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startManagingCursor(cursor);
        } else {
            super.startManagingCursor(cursor);
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.startNextMatchingActivity(intent) : super.startNextMatchingActivity(intent);
    }

    @Override // android.app.Activity
    public void startPostponedEnterTransition() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startPostponedEnterTransition();
        } else {
            super.startPostponedEnterTransition();
        }
    }

    @Override // android.app.Activity
    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startSearch(str, z, bundle, z2);
        } else {
            super.startSearch(str, z, bundle, z2);
        }
    }

    @Override // android.app.Activity
    public void stopLocalVoiceInteraction() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.stopLocalVoiceInteraction();
        } else {
            super.stopLocalVoiceInteraction();
        }
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.stopLockTask();
        } else {
            super.stopLockTask();
        }
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor cursor) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.stopManagingCursor(cursor);
        } else {
            super.stopManagingCursor(cursor);
        }
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.takeKeyEvents(z);
        } else {
            super.takeKeyEvents(z);
        }
    }

    @Override // android.app.Activity
    public void triggerSearch(String str, Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.triggerSearch(str, bundle);
        } else {
            super.triggerSearch(str, bundle);
        }
    }

    @Override // android.app.Activity
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View view) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.unregisterForContextMenu(view);
        } else {
            super.unregisterForContextMenu(view);
        }
    }

    public void zeusSuperAddContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addContentView(view, layoutParams);
    }

    @Override // com.bytedance.pangle.activity.b
    public void zeusSuperAttachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void zeusSuperCloseContextMenu() {
        super.closeContextMenu();
    }

    public void zeusSuperCloseOptionsMenu() {
        super.closeOptionsMenu();
    }

    public boolean zeusSuperConvertToTranslucent(Activity.TranslucentConversionListener translucentConversionListener, ActivityOptions activityOptions) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", Class.forName("android.app.Activity$TranslucentConversionListener"), ActivityOptions.class);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(this, translucentConversionListener, activityOptions)).booleanValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public PendingIntent zeusSuperCreatePendingResult(int i2, Intent intent, int i3) {
        return super.createPendingResult(i2, intent, i3);
    }

    public boolean zeusSuperDispatchGenericMotionEvent(MotionEvent motionEvent) {
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean zeusSuperDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean zeusSuperDispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean zeusSuperDispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean zeusSuperDispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean zeusSuperDispatchTrackballEvent(MotionEvent motionEvent) {
        return super.dispatchTrackballEvent(motionEvent);
    }

    public void zeusSuperDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
    }

    public void zeusSuperEnterPictureInPictureMode() {
        super.enterPictureInPictureMode();
    }

    public View zeusSuperFindViewById(int i2) {
        return super.findViewById(i2);
    }

    public void zeusSuperFinish() {
        super.finish();
    }

    public void zeusSuperFinishActivity(int i2) {
        super.finishActivity(i2);
    }

    public void zeusSuperFinishActivityFromChild(Activity activity, int i2) {
        super.finishActivityFromChild(activity, i2);
    }

    public void zeusSuperFinishAffinity() {
        super.finishAffinity();
    }

    public void zeusSuperFinishAfterTransition() {
        super.finishAfterTransition();
    }

    public void zeusSuperFinishAndRemoveTask() {
        super.finishAndRemoveTask();
    }

    public void zeusSuperFinishFromChild(Activity activity) {
        super.finishFromChild(activity);
    }

    public ActionBar zeusSuperGetActionBar() {
        return super.getActionBar();
    }

    public ComponentName zeusSuperGetCallingActivity() {
        return super.getCallingActivity();
    }

    public String zeusSuperGetCallingPackage() {
        return super.getCallingPackage();
    }

    public int zeusSuperGetChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    public ComponentName zeusSuperGetComponentName() {
        return super.getComponentName();
    }

    public Scene zeusSuperGetContentScene() {
        return super.getContentScene();
    }

    public TransitionManager zeusSuperGetContentTransitionManager() {
        return super.getContentTransitionManager();
    }

    public View zeusSuperGetCurrentFocus() {
        return super.getCurrentFocus();
    }

    public FragmentManager zeusSuperGetFragmentManager() {
        return super.getFragmentManager();
    }

    public Intent zeusSuperGetIntent() {
        return super.getIntent();
    }

    public Object zeusSuperGetLastNonConfigurationInstance() {
        return super.getLastNonConfigurationInstance();
    }

    public LayoutInflater zeusSuperGetLayoutInflater() {
        return super.getLayoutInflater();
    }

    public LoaderManager zeusSuperGetLoaderManager() {
        return super.getLoaderManager();
    }

    public String zeusSuperGetLocalClassName() {
        return super.getLocalClassName();
    }

    public int zeusSuperGetMaxNumPictureInPictureActions() {
        return super.getMaxNumPictureInPictureActions();
    }

    public MenuInflater zeusSuperGetMenuInflater() {
        return super.getMenuInflater();
    }

    public Intent zeusSuperGetParentActivityIntent() {
        return super.getParentActivityIntent();
    }

    public SharedPreferences zeusSuperGetPreferences(int i2) {
        return super.getPreferences(i2);
    }

    public Uri zeusSuperGetReferrer() {
        return super.getReferrer();
    }

    public int zeusSuperGetRequestedOrientation() {
        return super.getRequestedOrientation();
    }

    public Object zeusSuperGetSystemService(String str) {
        return super.getSystemService(str);
    }

    public int zeusSuperGetTaskId() {
        return super.getTaskId();
    }

    public VoiceInteractor zeusSuperGetVoiceInteractor() {
        return super.getVoiceInteractor();
    }

    public Window zeusSuperGetWindow() {
        return super.getWindow();
    }

    public WindowManager zeusSuperGetWindowManager() {
        return super.getWindowManager();
    }

    public boolean zeusSuperHasWindowFocus() {
        return super.hasWindowFocus();
    }

    public void zeusSuperInvalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    public boolean zeusSuperIsActivityTransitionRunning() {
        return super.isActivityTransitionRunning();
    }

    public boolean zeusSuperIsChangingConfigurations() {
        return super.isChangingConfigurations();
    }

    public boolean zeusSuperIsDestroyed() {
        return super.isDestroyed();
    }

    public boolean zeusSuperIsFinishing() {
        return super.isFinishing();
    }

    public boolean zeusSuperIsImmersive() {
        return super.isImmersive();
    }

    public boolean zeusSuperIsInMultiWindowMode() {
        return super.isInMultiWindowMode();
    }

    public boolean zeusSuperIsInPictureInPictureMode() {
        return super.isInPictureInPictureMode();
    }

    public boolean zeusSuperIsLocalVoiceInteractionSupported() {
        return super.isLocalVoiceInteractionSupported();
    }

    public boolean zeusSuperIsTaskRoot() {
        return super.isTaskRoot();
    }

    public boolean zeusSuperIsVoiceInteraction() {
        return super.isVoiceInteraction();
    }

    public boolean zeusSuperIsVoiceInteractionRoot() {
        return super.isVoiceInteractionRoot();
    }

    public boolean zeusSuperMoveTaskToBack(boolean z) {
        return super.moveTaskToBack(z);
    }

    public boolean zeusSuperNavigateUpTo(Intent intent) {
        return super.navigateUpTo(intent);
    }

    public boolean zeusSuperNavigateUpToFromChild(Activity activity, Intent intent) {
        return super.navigateUpToFromChild(activity, intent);
    }

    public void zeusSuperOnActionModeFinished(ActionMode actionMode) {
        super.onActionModeFinished(actionMode);
    }

    public void zeusSuperOnActionModeStarted(ActionMode actionMode) {
        super.onActionModeStarted(actionMode);
    }

    public void zeusSuperOnActivityReenter(int i2, Intent intent) {
        super.onActivityReenter(i2, intent);
    }

    protected void zeusSuperOnActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    protected void zeusSuperOnApplyThemeResource(Resources.Theme theme, int i2, boolean z) {
        super.onApplyThemeResource(theme, i2, z);
    }

    public void zeusSuperOnAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    public void zeusSuperOnAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void zeusSuperOnBackPressed() {
        super.onBackPressed();
    }

    protected void zeusSuperOnChildTitleChanged(Activity activity, CharSequence charSequence) {
        super.onChildTitleChanged(activity, charSequence);
    }

    public void zeusSuperOnConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void zeusSuperOnContentChanged() {
        super.onContentChanged();
    }

    public boolean zeusSuperOnContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public void zeusSuperOnContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
    }

    @Override // com.bytedance.pangle.activity.b
    public void zeusSuperOnCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void zeusSuperOnCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public CharSequence zeusSuperOnCreateDescription() {
        return super.onCreateDescription();
    }

    protected Dialog zeusSuperOnCreateDialog(int i2) {
        return super.onCreateDialog(i2);
    }

    public void zeusSuperOnCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        super.onCreateNavigateUpTaskStack(taskStackBuilder);
    }

    public boolean zeusSuperOnCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean zeusSuperOnCreatePanelMenu(int i2, Menu menu) {
        return super.onCreatePanelMenu(i2, menu);
    }

    public View zeusSuperOnCreatePanelView(int i2) {
        return super.onCreatePanelView(i2);
    }

    public boolean zeusSuperOnCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return super.onCreateThumbnail(bitmap, canvas);
    }

    public View zeusSuperOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    protected void zeusSuperOnDestroy() {
        super.onDestroy();
    }

    public void zeusSuperOnDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void zeusSuperOnEnterAnimationComplete() {
        super.onEnterAnimationComplete();
    }

    public boolean zeusSuperOnGenericMotionEvent(MotionEvent motionEvent) {
        return super.onGenericMotionEvent(motionEvent);
    }

    public void zeusSuperOnGetDirectActions(CancellationSignal cancellationSignal, Consumer consumer) {
        super.onGetDirectActions(cancellationSignal, consumer);
    }

    public boolean zeusSuperOnKeyDown(int i2, KeyEvent keyEvent) {
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean zeusSuperOnKeyLongPress(int i2, KeyEvent keyEvent) {
        return super.onKeyLongPress(i2, keyEvent);
    }

    public boolean zeusSuperOnKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        return super.onKeyMultiple(i2, i3, keyEvent);
    }

    public boolean zeusSuperOnKeyShortcut(int i2, KeyEvent keyEvent) {
        return super.onKeyShortcut(i2, keyEvent);
    }

    public boolean zeusSuperOnKeyUp(int i2, KeyEvent keyEvent) {
        return super.onKeyUp(i2, keyEvent);
    }

    public void zeusSuperOnLocalVoiceInteractionStarted() {
        super.onLocalVoiceInteractionStarted();
    }

    public void zeusSuperOnLocalVoiceInteractionStopped() {
        super.onLocalVoiceInteractionStopped();
    }

    public void zeusSuperOnLowMemory() {
        super.onLowMemory();
    }

    public boolean zeusSuperOnMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    public void zeusSuperOnMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
    }

    public boolean zeusSuperOnNavigateUp() {
        return super.onNavigateUp();
    }

    public boolean zeusSuperOnNavigateUpFromChild(Activity activity) {
        return super.onNavigateUpFromChild(activity);
    }

    protected void zeusSuperOnNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public boolean zeusSuperOnOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    public void zeusSuperOnOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    public void zeusSuperOnPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    protected void zeusSuperOnPause() {
        super.onPause();
    }

    public void zeusSuperOnPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer consumer) {
        super.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
    }

    public void zeusSuperOnPictureInPictureModeChanged(boolean z) {
        super.onPictureInPictureModeChanged(z);
    }

    public boolean zeusSuperOnPictureInPictureRequested() {
        return super.onPictureInPictureRequested();
    }

    protected void zeusSuperOnPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    protected void zeusSuperOnPostResume() {
        super.onPostResume();
    }

    protected void zeusSuperOnPrepareDialog(int i2, Dialog dialog) {
        super.onPrepareDialog(i2, dialog);
    }

    public void zeusSuperOnPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        super.onPrepareNavigateUpTaskStack(taskStackBuilder);
    }

    public boolean zeusSuperOnPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean zeusSuperOnPreparePanel(int i2, View view, Menu menu) {
        return super.onPreparePanel(i2, view, menu);
    }

    public void zeusSuperOnProvideAssistContent(AssistContent assistContent) {
        super.onProvideAssistContent(assistContent);
    }

    public void zeusSuperOnProvideAssistData(Bundle bundle) {
        super.onProvideAssistData(bundle);
    }

    public void zeusSuperOnProvideKeyboardShortcuts(List list, Menu menu, int i2) {
        super.onProvideKeyboardShortcuts(list, menu, i2);
    }

    public Uri zeusSuperOnProvideReferrer() {
        return super.onProvideReferrer();
    }

    public void zeusSuperOnRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    protected void zeusSuperOnRestart() {
        super.onRestart();
    }

    protected void zeusSuperOnRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    protected void zeusSuperOnResume() {
        super.onResume();
    }

    protected void zeusSuperOnSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public boolean zeusSuperOnSearchRequested() {
        return super.onSearchRequested();
    }

    protected void zeusSuperOnStart() {
        super.onStart();
    }

    public void zeusSuperOnStateNotSaved() {
        super.onStateNotSaved();
    }

    protected void zeusSuperOnStop() {
        super.onStop();
    }

    protected void zeusSuperOnTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
    }

    public void zeusSuperOnTopResumedActivityChanged(boolean z) {
        super.onTopResumedActivityChanged(z);
    }

    public boolean zeusSuperOnTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public boolean zeusSuperOnTrackballEvent(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    public void zeusSuperOnTrimMemory(int i2) {
        super.onTrimMemory(i2);
    }

    public void zeusSuperOnUserInteraction() {
        super.onUserInteraction();
    }

    protected void zeusSuperOnUserLeaveHint() {
        super.onUserLeaveHint();
    }

    public void zeusSuperOnVisibleBehindCanceled() {
        super.onVisibleBehindCanceled();
    }

    public void zeusSuperOnWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
    }

    public void zeusSuperOnWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public ActionMode zeusSuperOnWindowStartingActionMode(ActionMode.Callback callback) {
        return super.onWindowStartingActionMode(callback);
    }

    public void zeusSuperOpenContextMenu(View view) {
        super.openContextMenu(view);
    }

    public void zeusSuperOpenOptionsMenu() {
        super.openOptionsMenu();
    }

    public void zeusSuperOverridePendingTransition(int i2, int i3) {
        super.overridePendingTransition(i2, i3);
    }

    public void zeusSuperPostponeEnterTransition() {
        super.postponeEnterTransition();
    }

    public void zeusSuperRecreate() {
        super.recreate();
    }

    public void zeusSuperRegisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void zeusSuperRegisterForContextMenu(View view) {
        super.registerForContextMenu(view);
    }

    public boolean zeusSuperReleaseInstance() {
        return super.releaseInstance();
    }

    public void zeusSuperReportFullyDrawn() {
        super.reportFullyDrawn();
    }

    public DragAndDropPermissions zeusSuperRequestDragAndDropPermissions(DragEvent dragEvent) {
        return super.requestDragAndDropPermissions(dragEvent);
    }

    public boolean zeusSuperRequestVisibleBehind(boolean z) {
        return super.requestVisibleBehind(z);
    }

    public void zeusSuperSetActionBar(Toolbar toolbar) {
        super.setActionBar(toolbar);
    }

    public void zeusSuperSetContentTransitionManager(TransitionManager transitionManager) {
        super.setContentTransitionManager(transitionManager);
    }

    public void zeusSuperSetContentView(int i2) {
        super.setContentView(i2);
    }

    public void zeusSuperSetEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        super.setEnterSharedElementCallback(sharedElementCallback);
    }

    public void zeusSuperSetExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        super.setExitSharedElementCallback(sharedElementCallback);
    }

    public void zeusSuperSetFinishOnTouchOutside(boolean z) {
        super.setFinishOnTouchOutside(z);
    }

    public void zeusSuperSetImmersive(boolean z) {
        super.setImmersive(z);
    }

    public void zeusSuperSetInheritShowWhenLocked(boolean z) {
        super.setInheritShowWhenLocked(z);
    }

    public void zeusSuperSetIntent(Intent intent) {
        super.setIntent(intent);
    }

    public void zeusSuperSetLocusContext(LocusId locusId, Bundle bundle) {
        super.setLocusContext(locusId, bundle);
    }

    public void zeusSuperSetPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        super.setPictureInPictureParams(pictureInPictureParams);
    }

    public void zeusSuperSetRequestedOrientation(int i2) {
        super.setRequestedOrientation(i2);
    }

    public void zeusSuperSetShowWhenLocked(boolean z) {
        super.setShowWhenLocked(z);
    }

    public void zeusSuperSetTaskDescription(ActivityManager.TaskDescription taskDescription) {
        super.setTaskDescription(taskDescription);
    }

    @Override // com.bytedance.pangle.activity.b
    public void zeusSuperSetTheme(int i2) {
        super.setTheme(i2);
    }

    public void zeusSuperSetTitle(int i2) {
        super.setTitle(i2);
    }

    public void zeusSuperSetTitleColor(int i2) {
        super.setTitleColor(i2);
    }

    public boolean zeusSuperSetTranslucent(boolean z) {
        return super.setTranslucent(z);
    }

    public void zeusSuperSetTurnScreenOn(boolean z) {
        super.setTurnScreenOn(z);
    }

    public void zeusSuperSetVisible(boolean z) {
        super.setVisible(z);
    }

    public void zeusSuperSetVrModeEnabled(boolean z, ComponentName componentName) {
        super.setVrModeEnabled(z, componentName);
    }

    public boolean zeusSuperShouldShowRequestPermissionRationale(String str) {
        return super.shouldShowRequestPermissionRationale(str);
    }

    public boolean zeusSuperShouldUpRecreateTask(Intent intent) {
        return super.shouldUpRecreateTask(intent);
    }

    public boolean zeusSuperShowAssist(Bundle bundle) {
        return super.showAssist(bundle);
    }

    public void zeusSuperShowLockTaskEscapeMessage() {
        super.showLockTaskEscapeMessage();
    }

    public ActionMode zeusSuperStartActionMode(ActionMode.Callback callback) {
        return super.startActionMode(callback);
    }

    public void zeusSuperStartActivities(Intent[] intentArr) {
        super.startActivities(intentArr);
    }

    public void zeusSuperStartActivity(Intent intent) {
        super.startActivity(intent);
    }

    public void zeusSuperStartActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    public void zeusSuperStartActivityFromChild(Activity activity, Intent intent, int i2) {
        super.startActivityFromChild(activity, intent, i2);
    }

    public void zeusSuperStartActivityFromFragment(Fragment fragment, Intent intent, int i2) {
        super.startActivityFromFragment(fragment, intent, i2);
    }

    public boolean zeusSuperStartActivityIfNeeded(Intent intent, int i2) {
        return super.startActivityIfNeeded(intent, i2);
    }

    public void zeusSuperStartIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) {
        super.startIntentSender(intentSender, intent, i2, i3, i4);
    }

    public void zeusSuperStartIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    public void zeusSuperStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        super.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5);
    }

    public void zeusSuperStartLocalVoiceInteraction(Bundle bundle) {
        super.startLocalVoiceInteraction(bundle);
    }

    public void zeusSuperStartLockTask() {
        super.startLockTask();
    }

    public void zeusSuperStartManagingCursor(Cursor cursor) {
        super.startManagingCursor(cursor);
    }

    public boolean zeusSuperStartNextMatchingActivity(Intent intent) {
        return super.startNextMatchingActivity(intent);
    }

    public void zeusSuperStartPostponedEnterTransition() {
        super.startPostponedEnterTransition();
    }

    public void zeusSuperStartSearch(String str, boolean z, Bundle bundle, boolean z2) {
        super.startSearch(str, z, bundle, z2);
    }

    public void zeusSuperStopLocalVoiceInteraction() {
        super.stopLocalVoiceInteraction();
    }

    public void zeusSuperStopLockTask() {
        super.stopLockTask();
    }

    public void zeusSuperStopManagingCursor(Cursor cursor) {
        super.stopManagingCursor(cursor);
    }

    public void zeusSuperTakeKeyEvents(boolean z) {
        super.takeKeyEvents(z);
    }

    public void zeusSuperTriggerSearch(String str, Bundle bundle) {
        super.triggerSearch(str, bundle);
    }

    public void zeusSuperUnregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void zeusSuperUnregisterForContextMenu(View view) {
        super.unregisterForContextMenu(view);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onCreate(bundle, persistableBundle);
        } else {
            super.onCreate(bundle, persistableBundle);
        }
    }

    public boolean zeusSuperEnterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        return super.enterPictureInPictureMode(pictureInPictureParams);
    }

    public void zeusSuperOnCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }

    protected Dialog zeusSuperOnCreateDialog(int i2, Bundle bundle) {
        return super.onCreateDialog(i2, bundle);
    }

    public View zeusSuperOnCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public void zeusSuperOnMultiWindowModeChanged(boolean z, Configuration configuration) {
        super.onMultiWindowModeChanged(z, configuration);
    }

    public void zeusSuperOnPictureInPictureModeChanged(boolean z, Configuration configuration) {
        super.onPictureInPictureModeChanged(z, configuration);
    }

    public void zeusSuperOnPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onPostCreate(bundle, persistableBundle);
    }

    protected void zeusSuperOnPrepareDialog(int i2, Dialog dialog, Bundle bundle) {
        super.onPrepareDialog(i2, dialog, bundle);
    }

    public void zeusSuperOnRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onRestoreInstanceState(bundle, persistableBundle);
    }

    public void zeusSuperOnSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    public boolean zeusSuperOnSearchRequested(SearchEvent searchEvent) {
        return super.onSearchRequested(searchEvent);
    }

    public ActionMode zeusSuperOnWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        return super.onWindowStartingActionMode(callback, i2);
    }

    public void zeusSuperSetContentView(View view) {
        super.setContentView(view);
    }

    public void zeusSuperSetTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
    }

    public ActionMode zeusSuperStartActionMode(ActionMode.Callback callback, int i2) {
        return super.startActionMode(callback, i2);
    }

    public void zeusSuperStartActivities(Intent[] intentArr, Bundle bundle) {
        super.startActivities(intentArr, bundle);
    }

    public void zeusSuperStartActivity(Intent intent, Bundle bundle) {
        super.startActivity(intent, bundle);
    }

    public void zeusSuperStartActivityForResult(Intent intent, int i2, Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
    }

    public void zeusSuperStartActivityFromChild(Activity activity, Intent intent, int i2, Bundle bundle) {
        super.startActivityFromChild(activity, intent, i2, bundle);
    }

    public void zeusSuperStartActivityFromFragment(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        super.startActivityFromFragment(fragment, intent, i2, bundle);
    }

    public boolean zeusSuperStartActivityIfNeeded(Intent intent, int i2, Bundle bundle) {
        return super.startActivityIfNeeded(intent, i2, bundle);
    }

    public void zeusSuperStartIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSender(intentSender, intent, i2, i3, i4, bundle);
    }

    public void zeusSuperStartIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public void zeusSuperStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        super.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public boolean zeusSuperStartNextMatchingActivity(Intent intent, Bundle bundle) {
        return super.startNextMatchingActivity(intent, bundle);
    }

    public void zeusSuperSetContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    public boolean enterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            return generatePluginActivity.enterPictureInPictureMode(pictureInPictureParams);
        }
        return super.enterPictureInPictureMode(pictureInPictureParams);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i2, Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            return generatePluginActivity.onCreateDialog(i2, bundle);
        }
        return super.onCreateDialog(i2, bundle);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            return generatePluginActivity.onCreateView(str, context, attributeSet);
        }
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onMultiWindowModeChanged(z, configuration);
        } else {
            super.onMultiWindowModeChanged(z, configuration);
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPictureInPictureModeChanged(z, configuration);
        } else {
            super.onPictureInPictureModeChanged(z, configuration);
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPostCreate(bundle, persistableBundle);
        } else {
            super.onPostCreate(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i2, Dialog dialog, Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPrepareDialog(i2, dialog, bundle);
        } else {
            super.onPrepareDialog(i2, dialog, bundle);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onRestoreInstanceState(bundle, persistableBundle);
        } else {
            super.onRestoreInstanceState(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            return generatePluginActivity.onSearchRequested(searchEvent);
        }
        return super.onSearchRequested(searchEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            return generatePluginActivity.onWindowStartingActionMode(callback, i2);
        }
        return super.onWindowStartingActionMode(callback, i2);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setContentView(view);
        } else {
            super.setContentView(view);
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setTitle(charSequence);
        } else {
            super.setTitle(charSequence);
        }
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback, int i2) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            return generatePluginActivity.startActionMode(callback, i2);
        }
        return super.startActionMode(callback, i2);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivities(intentArr, bundle);
        } else {
            super.startActivities(intentArr, bundle);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivity(intent, bundle);
        } else {
            super.startActivity(intent, bundle);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivityForResult(intent, i2, bundle);
        } else {
            super.startActivityForResult(intent, i2, bundle);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i2, Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivityFromChild(activity, intent, i2, bundle);
        } else {
            super.startActivityFromChild(activity, intent, i2, bundle);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivityFromFragment(fragment, intent, i2, bundle);
        } else {
            super.startActivityFromFragment(fragment, intent, i2, bundle);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i2, Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            return generatePluginActivity.startActivityIfNeeded(intent, i2, bundle);
        }
        return super.startActivityIfNeeded(intent, i2, bundle);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startIntentSender(intentSender, intent, i2, i3, i4, bundle);
        } else {
            super.startIntentSender(intentSender, intent, i2, i3, i4, bundle);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            super.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent, Bundle bundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            return generatePluginActivity.startNextMatchingActivity(intent, bundle);
        }
        return super.startNextMatchingActivity(intent, bundle);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onSaveInstanceState(bundle, persistableBundle);
        } else {
            super.onSaveInstanceState(bundle, persistableBundle);
        }
        bundle.clear();
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setContentView(view, layoutParams);
        } else {
            super.setContentView(view, layoutParams);
        }
    }
}
