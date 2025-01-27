package com.aggmoread.sdk.z.d.a.a.e.r;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.VoiceInteractor;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class d extends Activity {

    /* renamed from: a */
    private Activity f6134a;

    public d(Activity activity) {
        if (activity != null) {
            this.f6134a = activity;
            attachBaseContext(activity.getBaseContext());
        }
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f6134a.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.app.Activity
    public void finish() {
        this.f6134a.finish();
    }

    @Override // android.app.Activity
    public void finishActivity(int i10) {
        this.f6134a.finishActivity(i10);
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(@NonNull Activity activity, int i10) {
        this.f6134a.finishActivityFromChild(activity, i10);
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        this.f6134a.finishAffinity();
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        this.f6134a.finishAfterTransition();
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        this.f6134a.finishAndRemoveTask();
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        this.f6134a.finishFromChild(activity);
    }

    @Override // android.app.Activity
    @Nullable
    public ActionBar getActionBar() {
        return this.f6134a.getActionBar();
    }

    @Override // android.app.Activity
    @Nullable
    public ComponentName getCallingActivity() {
        return this.f6134a.getCallingActivity();
    }

    @Override // android.app.Activity
    @Nullable
    public String getCallingPackage() {
        return this.f6134a.getCallingPackage();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        return this.f6134a.getChangingConfigurations();
    }

    @Override // android.app.Activity
    public ComponentName getComponentName() {
        return this.f6134a.getComponentName();
    }

    @Override // android.app.Activity
    public Scene getContentScene() {
        return this.f6134a.getContentScene();
    }

    @Override // android.app.Activity
    public TransitionManager getContentTransitionManager() {
        return this.f6134a.getContentTransitionManager();
    }

    @Override // android.app.Activity
    @Nullable
    public View getCurrentFocus() {
        return this.f6134a.getCurrentFocus();
    }

    @Override // android.app.Activity
    public FragmentManager getFragmentManager() {
        return this.f6134a.getFragmentManager();
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        return this.f6134a.getIntent();
    }

    @Override // android.app.Activity
    @Nullable
    public Object getLastNonConfigurationInstance() {
        return this.f6134a.getLastNonConfigurationInstance();
    }

    @Override // android.app.Activity
    @NonNull
    public LayoutInflater getLayoutInflater() {
        return this.f6134a.getLayoutInflater();
    }

    @Override // android.app.Activity
    public LoaderManager getLoaderManager() {
        return this.f6134a.getLoaderManager();
    }

    @Override // android.app.Activity
    @NonNull
    public String getLocalClassName() {
        return this.f6134a.getLocalClassName();
    }

    @Override // android.app.Activity
    public int getMaxNumPictureInPictureActions() {
        int maxNumPictureInPictureActions;
        if (Build.VERSION.SDK_INT < 26) {
            return super.getMaxNumPictureInPictureActions();
        }
        maxNumPictureInPictureActions = this.f6134a.getMaxNumPictureInPictureActions();
        return maxNumPictureInPictureActions;
    }

    @Override // android.app.Activity
    @NonNull
    public MenuInflater getMenuInflater() {
        return this.f6134a.getMenuInflater();
    }

    @Override // android.app.Activity
    @Nullable
    public Intent getParentActivityIntent() {
        return this.f6134a.getParentActivityIntent();
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i10) {
        return this.f6134a.getPreferences(i10);
    }

    @Override // android.app.Activity
    @Nullable
    public Uri getReferrer() {
        Uri referrer;
        if (Build.VERSION.SDK_INT < 22) {
            return super.getReferrer();
        }
        referrer = this.f6134a.getReferrer();
        return referrer;
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        return this.f6134a.getRequestedOrientation();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(@NonNull String str) {
        return this.f6134a.getSystemService(str);
    }

    @Override // android.app.Activity
    public int getTaskId() {
        return this.f6134a.getTaskId();
    }

    @Override // android.app.Activity
    public VoiceInteractor getVoiceInteractor() {
        VoiceInteractor voiceInteractor;
        if (Build.VERSION.SDK_INT < 23) {
            return super.getVoiceInteractor();
        }
        voiceInteractor = this.f6134a.getVoiceInteractor();
        return voiceInteractor;
    }

    @Override // android.app.Activity
    public Window getWindow() {
        return this.f6134a.getWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        return this.f6134a.getWindowManager();
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        return this.f6134a.isChangingConfigurations();
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        return this.f6134a.isDestroyed();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        return this.f6134a.isFinishing();
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        return this.f6134a.isImmersive();
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        return this.f6134a.isTaskRoot();
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z10) {
        return this.f6134a.moveTaskToBack(z10);
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(Intent intent) {
        return this.f6134a.navigateUpTo(intent);
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(Activity activity, Intent intent) {
        return this.f6134a.navigateUpToFromChild(activity, intent);
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i10, Intent intent) {
        this.f6134a.onActivityReenter(i10, intent);
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        return this.f6134a.releaseInstance();
    }

    @Override // android.app.Activity
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent dragEvent) {
        DragAndDropPermissions requestDragAndDropPermissions;
        if (Build.VERSION.SDK_INT < 24) {
            return super.requestDragAndDropPermissions(dragEvent);
        }
        requestDragAndDropPermissions = this.f6134a.requestDragAndDropPermissions(dragEvent);
        return requestDragAndDropPermissions;
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean z10) {
        if (Build.VERSION.SDK_INT >= 27) {
            this.f6134a.setShowWhenLocked(z10);
        } else {
            super.setShowWhenLocked(z10);
        }
    }

    @Override // android.app.Activity
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        this.f6134a.setTaskDescription(taskDescription);
    }

    @Override // android.app.Activity
    public void setTurnScreenOn(boolean z10) {
        if (Build.VERSION.SDK_INT >= 27) {
            this.f6134a.setTurnScreenOn(z10);
        } else {
            super.setTurnScreenOn(z10);
        }
    }

    @Override // android.app.Activity
    public void setVisible(boolean z10) {
        this.f6134a.setVisible(z10);
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(Intent intent) {
        return this.f6134a.shouldUpRecreateTask(intent);
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f6134a.showLockTaskEscapeMessage();
        } else {
            super.showLockTaskEscapeMessage();
        }
    }

    @Override // android.app.Activity
    public void startLockTask() {
        this.f6134a.startLockTask();
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        this.f6134a.stopLockTask();
    }
}
