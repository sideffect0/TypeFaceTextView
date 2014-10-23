TypeFaceTextView
================

Custom TextView For Android

Setup Instructions
------------------

 1.From `TypeFaceTextView` Folder Copy the `TypeFaceTextView.java` to `src` folder and `tftv_attrs.xml` to your project's res/values/ folder

 2.Add (i) xmlns:app="http://schemas.android.com/apk/res/com.nubicz.typefacetextview" to Root layout 

       <!-- (ii) add path to font fron assets folder to typeface attribute -->

        <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
                        xmlns:app="http://schemas.android.com/apk/res/com.nubicz.typefacetextview">
 
         <com.nubicz.customviews.TypeFaceTextView 
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:text="Hello World"
          android:textSize="40sp" <!-- All Other Attributes Are Still Working :) -->
          android:layout_centerInParent="true"
          app:typeface="fonts/myfont.ttf"/>

        </RelativeLayout>

   an Example Project Also Included You Can Check it Out ... :)
