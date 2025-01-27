package com.ss.android.socialbase.downloader.constants;

/* loaded from: classes4.dex */
public interface DBDefinition {
    public static final String CHUNK_TABLE_NAME = "downloadChunk";
    public static final String CREATE_CHUNK_TABLE = "CREATE TABLE IF NOT EXISTS downloadChunk( _id INTEGER, chunkIndex INTEGER, startOffset INTEGER, curOffset INTEGER, endOffset INTEGER, chunkContentLen INTEGER, hostChunkIndex INTEGER )";
    public static final String CREATE_DOWNLOAD_TABLE = "CREATE TABLE IF NOT EXISTS downloader( _id INTEGER PRIMARY KEY, url TEXT, savePath TEXT, tempPath TEXT, name TEXT, chunkCount INTEGER, status INTEGER, curBytes INTEGER, totalBytes INTEGER, eTag TEXT, onlyWifi INTEGER, force INTEGER, retryCount INTEGER, extra TEXT, mimeType TEXT, title TEXT, notificationEnable INTEGER, notificationVisibility INTEGER, isFirstDownload INTEGER, isFirstSuccess INTEGER, needHttpsToHttpRetry INTEGER, downloadTime INTEGER, packageName TEXT, md5 TEXT, retryDelay INTEGER, curRetryTime INTEGER, retryDelayStatus INTEGER, defaultHttpServiceBackUp INTEGER, chunkRunnableReuse INTEGER, retryDelayTimeArray TEXT, chunkDowngradeRetry INTEGER, backUpUrlsStr TEXT, backUpUrlRetryCount INTEGER, realDownloadTime INTEGER, retryScheduleMinutes INTEGER, independentProcess INTEGER, auxiliaryJsonobjectString TEXT, iconUrl TEXT, appVersionCode INTEGER, taskId TEXT)";
    public static final String CREATE_SEGMENT_TABLE = "CREATE TABLE IF NOT EXISTS segments( _id INTEGER PRIMARY KEY,info TEXT )";
    public static final String DATABASE_NAME = "downloader.db";
    public static final int DATABASE_VERSION = 15;
    public static final String DOWNLOAD_TABLE_NAME = "downloader";
    public static final String EXTRA = "extra";
    public static final String FORCE = "force";
    public static final String ID = "_id";
    public static final String MD5 = "md5";
    public static final String NAME = "name";
    public static final String SEGMENT_TABLE_NAME = "segments";
    public static final String STATUS = "status";
    public static final String TITLE = "title";
    public static final String URL = "url";
    public static final int VERSION_DOWNLOAD_TABLE_ADD_AUXILIARY_JSONOBJECT_STRING = 12;
    public static final int VERSION_DOWNLOAD_TABLE_ADD_CHUNK_RUNNABLE_REUSE = 9;
    public static final int VERSION_DOWNLOAD_TABLE_ADD_COLUMNS = 2;
    public static final int VERSION_DOWNLOAD_TABLE_ADD_DOWNLOAD_TIME = 5;
    public static final int VERSION_DOWNLOAD_TABLE_ADD_FIRST_START = 3;
    public static final int VERSION_DOWNLOAD_TABLE_ADD_FIRST_SUCCESS = 4;
    public static final int VERSION_DOWNLOAD_TABLE_ADD_HOST_CHUNK_INDEX = 8;
    public static final int VERSION_DOWNLOAD_TABLE_ADD_ICON_AND_VERSION = 13;
    public static final int VERSION_DOWNLOAD_TABLE_ADD_RETRY_DELAY = 7;
    public static final int VERSION_DOWNLOAD_TABLE_ADD_RETRY_TIME_ARRAY = 10;
    public static final int VERSION_DOWNLOAD_TABLE_ADD_SECURITY_VERIFY = 6;
    public static final int VERSION_DOWNLOAD_TABLE_ADD_TASK_ID = 15;
    public static final int VERSION_DOWNLOAD_TABLE_ADD_TOTAL_RETRY_COUNT = 11;
    public static final int VERSION_INIT = 1;
    public static final int VERSION_SEGMENT_TABLE_ADD = 14;
    public static final String SAVE_PATH = "savePath";
    public static final String TEMP_PATH = "tempPath";
    public static final String CHUNK_COUNT = "chunkCount";
    public static final String CUR_BYTES = "curBytes";
    public static final String TOTAL_BYTES = "totalBytes";
    public static final String ETAG = "eTag";
    public static final String ONLY_WIFI = "onlyWifi";
    public static final String RETRY_COUNT = "retryCount";
    public static final String MIME_TYPE = "mimeType";
    public static final String NOTIFICATION_ENABLE = "notificationEnable";
    public static final String NOTIFICATION_VISIBILITY = "notificationVisibility";
    public static final String FIRST_DOWNLOAD = "isFirstDownload";
    public static final String FIRST_SUCCESS = "isFirstSuccess";
    public static final String NEED_HTTPS_TO_HTTP_RETRY = "needHttpsToHttpRetry";
    public static final String DOWNLOAD_TIME = "downloadTime";
    public static final String PACKAGE_NAME = "packageName";
    public static final String RETRY_DELAY = "retryDelay";
    public static final String CUR_RETRY_TIME = "curRetryTime";
    public static final String RETRY_DELAY_STATUS = "retryDelayStatus";
    public static final String DEFAULT_HTTP_SERVICE_BACKUP = "defaultHttpServiceBackUp";
    public static final String CHUNK_RUNNABLE_REUSE = "chunkRunnableReuse";
    public static final String RETRY_DELAY_TIME_ARRAY = "retryDelayTimeArray";
    public static final String CHUNK_DOWNGRADE_RETRY = "chunkDowngradeRetry";
    public static final String BACKUP_URLS_STR = "backUpUrlsStr";
    public static final String BACKUP_URL_RETRY_COUNT = "backUpUrlRetryCount";
    public static final String REAL_DOWNLOAD_TIME = "realDownloadTime";
    public static final String RETRY_SCHEDULE_MINUTES = "retryScheduleMinutes";
    public static final String INDEPENDENT_PROCESS = "independentProcess";
    public static final String AUXILIARY_JSONOBJECT_STRING = "auxiliaryJsonobjectString";
    public static final String ICON_URL = "iconUrl";
    public static final String APP_VERSION_CODE = "appVersionCode";
    public static final String TASK_ID = "taskId";
    public static final String[] DOWNLOAD_ALL_COLUMNS = {"_id", "url", SAVE_PATH, TEMP_PATH, "name", CHUNK_COUNT, "status", CUR_BYTES, TOTAL_BYTES, ETAG, ONLY_WIFI, "force", RETRY_COUNT, "extra", MIME_TYPE, "title", NOTIFICATION_ENABLE, NOTIFICATION_VISIBILITY, FIRST_DOWNLOAD, FIRST_SUCCESS, NEED_HTTPS_TO_HTTP_RETRY, DOWNLOAD_TIME, PACKAGE_NAME, "md5", RETRY_DELAY, CUR_RETRY_TIME, RETRY_DELAY_STATUS, DEFAULT_HTTP_SERVICE_BACKUP, CHUNK_RUNNABLE_REUSE, RETRY_DELAY_TIME_ARRAY, CHUNK_DOWNGRADE_RETRY, BACKUP_URLS_STR, BACKUP_URL_RETRY_COUNT, REAL_DOWNLOAD_TIME, RETRY_SCHEDULE_MINUTES, INDEPENDENT_PROCESS, AUXILIARY_JSONOBJECT_STRING, ICON_URL, APP_VERSION_CODE, TASK_ID};
    public static final String[] DOWNLOAD_PK_COLUMNS = {"_id"};
    public static final String CHUNK_INDEX = "chunkIndex";
    public static final String START_OFFSET = "startOffset";
    public static final String CUR_OFFSET = "curOffset";
    public static final String END_OFFSET = "endOffset";
    public static final String CHUNK_CONTENT_LEN = "chunkContentLen";
    public static final String HOST_CHUNK_INDEX = "hostChunkIndex";
    public static final String[] CHUNK_ALL_COLUMNS = {"_id", CHUNK_INDEX, START_OFFSET, CUR_OFFSET, END_OFFSET, CHUNK_CONTENT_LEN, HOST_CHUNK_INDEX};
    public static final String[] CHUNK_PK_COLUMNS = {"_id"};
    public static final String SEGMENT_INFO = "info";
    public static final String[] SEGMENT_ALL_COLUMNS = {"_id", SEGMENT_INFO};
    public static final String[] SEGMENT_PK_COLUMNS = {"_id"};
}
