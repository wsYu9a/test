package com.vivo.ic.spmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.vivo.ic.VLog;

/* loaded from: classes4.dex */
public abstract class BaseSharePreference {
    private boolean mApply = false;
    private SharedPreferences mSharePreferences;

    private void ifCommitOrApply(SharedPreferences.Editor editor) {
        VLog.d("BaseSharePreference", "ifCommitOrApply(), mApply=" + this.mApply);
        if (editor == null) {
            return;
        }
        if (this.mApply) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public boolean getBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str, z);
        }
        throw new RuntimeException("SharedPreferences is not init", new Throwable());
    }

    public float getFloat(String str, float f2) {
        SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getFloat(str, f2);
        }
        throw new RuntimeException("SharedPreferences is not init", new Throwable());
    }

    public int getInt(String str, int i2) {
        SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(str, i2);
        }
        throw new RuntimeException("SharedPreferences is not init", new Throwable());
    }

    public long getLong(String str, long j2) {
        SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(str, j2);
        }
        throw new RuntimeException("SharedPreferences is not init", new Throwable());
    }

    public SharedPreferences getSharedPreferences() {
        return this.mSharePreferences;
    }

    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(str, str2);
        }
        throw new RuntimeException("SharedPreferences is not init", new Throwable());
    }

    public void init(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("sharedFileName can't be null");
        }
        this.mSharePreferences = context.getSharedPreferences(str, 0);
    }

    public boolean isKeyExist(String str) {
        SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains(str);
    }

    public void putBoolean(String str, boolean z) {
        SharedPreferences.Editor edit = this.mSharePreferences.edit();
        edit.putBoolean(str, z);
        ifCommitOrApply(edit);
    }

    public void putFloat(String str, float f2) {
        SharedPreferences.Editor edit = this.mSharePreferences.edit();
        edit.putFloat(str, f2);
        ifCommitOrApply(edit);
    }

    public void putInt(String str, int i2) {
        SharedPreferences.Editor edit = this.mSharePreferences.edit();
        edit.putInt(str, i2);
        ifCommitOrApply(edit);
    }

    public void putLong(String str, long j2) {
        SharedPreferences.Editor edit = this.mSharePreferences.edit();
        edit.putLong(str, j2);
        ifCommitOrApply(edit);
    }

    public void putString(String str, String str2) {
        SharedPreferences.Editor edit = this.mSharePreferences.edit();
        edit.putString(str, str2);
        ifCommitOrApply(edit);
    }

    public void release() {
        this.mSharePreferences = null;
    }

    public void remove(String str) {
        SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences == null) {
            throw new RuntimeException("SharedPreferences is not init", new Throwable());
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (this.mSharePreferences.contains(str)) {
            edit.remove(str);
            ifCommitOrApply(edit);
        }
    }

    public void init(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.mApply = z;
            this.mSharePreferences = context.getSharedPreferences(str, 0);
            return;
        }
        throw new RuntimeException("sharedFileName can't be null");
    }
}
