package com.ss.android.socialbase.downloader.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.utils.SqlUtils;

/* loaded from: classes4.dex */
public class TableStatements {
    private final String[] allColumns;
    private final SQLiteDatabase database;
    private SQLiteStatement deleteStatement;
    private SQLiteStatement insertOrReplaceStatement;
    private SQLiteStatement insertStatement;
    private final String[] pkColumns;
    private final String tableName;
    private SQLiteStatement updateStatement;

    public TableStatements(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.database = sQLiteDatabase;
        this.tableName = str;
        this.allColumns = strArr;
        this.pkColumns = strArr2;
    }

    public SQLiteStatement getDeleteStatement() {
        if (this.deleteStatement == null) {
            SQLiteStatement compileStatement = this.database.compileStatement(SqlUtils.createSqlDelete(this.tableName, this.pkColumns));
            synchronized (this) {
                try {
                    if (this.deleteStatement == null) {
                        this.deleteStatement = compileStatement;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (this.deleteStatement != compileStatement) {
                compileStatement.close();
            }
        }
        return this.deleteStatement;
    }

    public SQLiteStatement getInsertOrReplaceStatement() {
        if (this.insertOrReplaceStatement == null) {
            SQLiteStatement compileStatement = this.database.compileStatement(SqlUtils.createSqlInsertOrReplace(this.tableName, this.allColumns, this.pkColumns));
            synchronized (this) {
                try {
                    if (this.insertOrReplaceStatement == null) {
                        this.insertOrReplaceStatement = compileStatement;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (this.insertOrReplaceStatement != compileStatement) {
                compileStatement.close();
            }
        }
        return this.insertOrReplaceStatement;
    }

    public SQLiteStatement getInsertStatement() {
        if (this.insertStatement == null) {
            SQLiteStatement compileStatement = this.database.compileStatement(SqlUtils.createSqlInsert("INSERT INTO ", this.tableName, this.allColumns));
            synchronized (this) {
                try {
                    if (this.insertStatement == null) {
                        this.insertStatement = compileStatement;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (this.insertStatement != compileStatement) {
                compileStatement.close();
            }
        }
        return this.insertStatement;
    }

    public SQLiteStatement getUpdateStatement() {
        if (this.updateStatement == null) {
            SQLiteStatement compileStatement = this.database.compileStatement(SqlUtils.createSqlUpdate(this.tableName, this.allColumns, this.pkColumns));
            synchronized (this) {
                try {
                    if (this.updateStatement == null) {
                        this.updateStatement = compileStatement;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (this.updateStatement != compileStatement) {
                compileStatement.close();
            }
        }
        return this.updateStatement;
    }
}
