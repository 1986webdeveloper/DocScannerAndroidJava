# DocScannerAndroidJava
This example is about detecting the borders of any document and then capturing the image of the same.

<b>Features : </b>

- Scanning of documents.
- Editing scaned image with crop and filter option.
- Save scanned image to your album.
- Lightweight dependency.

<b>Requirements :</b>
- Android Studio

<b>Usage :</b>
1. Clone or download <b>scanlibrary</b> and import it to your project

2. Import below code to your build.gradle(Module: app) file

    ```implementation project(':scanlibrary')```

3. Change below code to your settings.gradle file

    ```include ':app',':scanlibrary'```

4. Add mehod in button click to start scanning any document

    ```java
    protected void startScan(int preference) {
        Intent intent = new Intent(MainActivity.this, ScanActivity.class);
        intent.putExtra(ScanConstants.OPEN_INTENT_PREFERENCE, preference);
        startActivityForResult(intent, REQUEST_CODE);
    }
    
 5. 

