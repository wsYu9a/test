package com.bytedance.pangle;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.view.ContextThemeWrapper;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* loaded from: classes2.dex */
public class f extends ContextThemeWrapper {
    private File mCacheDir;
    private File mCodeCacheDir;
    private File mDataDir;
    private File mExternalCacheDir;
    private File mFilesDir;
    private File mNoBackupFilesDir;
    private File mObbDir;
    private final Object mSync;

    public f() {
        this.mSync = new Object();
    }

    private static File ensurePrivateDirExists(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File makeFilename(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private String makeSubName(String str) {
        return getPluginDirName() + hf.e.f26694a + str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        if (getPluginDirName() == null) {
            return super.databaseList();
        }
        String[] databaseList = super.databaseList();
        int length = databaseList.length;
        boolean[] zArr = new boolean[length];
        int i10 = 0;
        for (int i11 = 0; i11 < databaseList.length; i11++) {
            if (databaseList[i11].startsWith(getPluginDirName())) {
                zArr[i11] = true;
                i10++;
            } else {
                zArr[i11] = false;
            }
        }
        String[] strArr = new String[i10];
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            if (zArr[i13]) {
                strArr[i12] = databaseList[i13];
                i12++;
            }
        }
        return strArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        return getPluginDirName() == null ? super.deleteDatabase(str) : super.deleteDatabase(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        return makeFilename(getFilesDir(), str).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String str) {
        return getPluginDirName() == null ? super.deleteSharedPreferences(str) : super.deleteSharedPreferences(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getCacheDir();
        }
        synchronized (this.mSync) {
            try {
                if (this.mCacheDir == null) {
                    this.mCacheDir = new File(super.getCacheDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mCacheDir);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getCodeCacheDir();
        }
        synchronized (this.mSync) {
            try {
                if (this.mCodeCacheDir == null) {
                    this.mCodeCacheDir = new File(super.getCodeCacheDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mCodeCacheDir);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getDataDir();
        }
        synchronized (this.mSync) {
            try {
                if (this.mDataDir == null) {
                    this.mDataDir = new File(getHostDataDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mDataDir);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        return getPluginDirName() == null ? super.getDatabasePath(str) : super.getDatabasePath(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i10) {
        return (i10 != 0 || getPluginDirName() == null) ? super.getDir(str, i10) : ensurePrivateDirExists(new File(super.getDir(str, i10), getPluginDirName()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getExternalCacheDir();
        }
        synchronized (this.mSync) {
            try {
                if (this.mExternalCacheDir == null) {
                    this.mExternalCacheDir = new File(super.getExternalCacheDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mExternalCacheDir);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        if (getPluginDirName() == null) {
            return super.getExternalCacheDirs();
        }
        File[] externalCacheDirs = super.getExternalCacheDirs();
        File[] fileArr = new File[externalCacheDirs.length];
        for (int i10 = 0; i10 < externalCacheDirs.length; i10++) {
            fileArr[i10] = ensurePrivateDirExists(new File(externalCacheDirs[i10], getPluginDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        return getPluginDirName() == null ? super.getExternalFilesDir(str) : ensurePrivateDirExists(new File(super.getExternalFilesDir(str), getPluginDirName()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        if (getPluginDirName() == null) {
            return super.getExternalFilesDirs(str);
        }
        File[] externalFilesDirs = super.getExternalFilesDirs(str);
        File[] fileArr = new File[externalFilesDirs.length];
        for (int i10 = 0; i10 < externalFilesDirs.length; i10++) {
            fileArr[i10] = ensurePrivateDirExists(new File(externalFilesDirs[i10], getPluginDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        if (getPluginDirName() == null) {
            return super.getExternalMediaDirs();
        }
        File[] externalMediaDirs = super.getExternalMediaDirs();
        File[] fileArr = new File[externalMediaDirs.length];
        for (int i10 = 0; i10 < externalMediaDirs.length; i10++) {
            fileArr[i10] = ensurePrivateDirExists(new File(externalMediaDirs[i10], getPluginDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getFilesDir();
        }
        synchronized (this.mSync) {
            try {
                if (this.mFilesDir == null) {
                    this.mFilesDir = new File(super.getFilesDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mFilesDir);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return ensurePrivateDirExists;
    }

    public File getHostDataDir() {
        return super.getFilesDir().getParentFile();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getNoBackupFilesDir();
        }
        synchronized (this.mSync) {
            try {
                if (this.mNoBackupFilesDir == null) {
                    this.mNoBackupFilesDir = new File(super.getNoBackupFilesDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mNoBackupFilesDir);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        File ensurePrivateDirExists;
        if (getPluginDirName() == null) {
            return super.getObbDir();
        }
        synchronized (this.mSync) {
            try {
                if (this.mObbDir == null) {
                    this.mObbDir = new File(super.getObbDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mObbDir);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        if (getPluginDirName() == null) {
            return super.getObbDirs();
        }
        File[] obbDirs = super.getObbDirs();
        File[] fileArr = new File[obbDirs.length];
        for (int i10 = 0; i10 < obbDirs.length; i10++) {
            fileArr[i10] = ensurePrivateDirExists(new File(obbDirs[i10], getPluginDirName()));
        }
        return fileArr;
    }

    public String getPluginDirName() {
        return "pangle_" + getPluginPkg();
    }

    public String getPluginPkg() {
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i10) {
        return (i10 != 0 || getPluginDirName() == null) ? super.getSharedPreferences(str, i10) : super.getSharedPreferences(makeSubName(str), i10);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        if (getPluginDirName() == null) {
            return super.moveDatabaseFrom(context, str);
        }
        throw new UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) {
        return getPluginDirName() == null ? super.openFileInput(str) : new FileInputStream(makeFilename(getFilesDir(), str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i10) {
        return (i10 != 0 || getPluginDirName() == null) ? super.openFileOutput(str, i10) : new FileOutputStream(makeFilename(getFilesDir(), str), false);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i10, SQLiteDatabase.CursorFactory cursorFactory) {
        return (i10 != 0 || getPluginDirName() == null) ? super.openOrCreateDatabase(str, i10, cursorFactory) : super.openOrCreateDatabase(makeSubName(str), i10, cursorFactory);
    }

    public f(Context context, int i10) {
        super(context, i10);
        this.mSync = new Object();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i10, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        if (i10 == 0 && getPluginDirName() != null) {
            return super.openOrCreateDatabase(makeSubName(str), i10, cursorFactory, databaseErrorHandler);
        }
        return super.openOrCreateDatabase(str, i10, cursorFactory, databaseErrorHandler);
    }

    @RequiresApi(api = 23)
    public f(Context context, Resources.Theme theme) {
        super(context, theme);
        this.mSync = new Object();
    }
}
