package com.scanlibrary;

import android.net.Uri;

/**
 * Created by Naman
 */
public interface IScanner {

    void onBitmapSelect(Uri uri);

    void onScanFinish(Uri uri);
}
