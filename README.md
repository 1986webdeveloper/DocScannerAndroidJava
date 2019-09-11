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
    
 5. Add below code in onActivityResult method to get generated scanned file.
 
 ```java
 
            case REQUEST_CODE:

                Uri uri = null;

                if (data != null) {

                    uri = data.getExtras().getParcelable(ScanConstants.SCANNED_RESULT);

                    Bitmap bitmap = null;
                    try {
                        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                        String imageFileName = "JPEG_" + timeStamp + "_";
                        File storageDir = Environment.getExternalStoragePublicDirectory(
                                Environment.DIRECTORY_PICTURES);
                        File image = File.createTempFile(
                                imageFileName,  /* prefix */
                                ".jpg",         /* suffix */
                                storageDir      /* directory */
                        );


                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                        getContentResolver().delete(uri, null, null);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
                        byte[] bitmapdata = bos.toByteArray();


                        FileOutputStream fos = new FileOutputStream(image);
                        fos.write(bitmapdata);
                        fos.flush();
                        fos.close();

                        Log.e("file1", image.toString());

                        Intent intent = new Intent(MainActivity.this,YourDestinationActivity.class);
                        intent.putExtra("img",bitmapdata);
                        intent.putExtra("path",image.toString());
                        startActivity(intent);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


                break;
       
    ```


