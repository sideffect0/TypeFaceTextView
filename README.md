DEPRECATED: Use new android support lib which has `android:font` support   

TypeFaceTextView
================

TextView with Custom Font For Android

Keep UI Things in XML not in Code :)  

Setup Instructions
------------------

 1.From `TypeFaceTextView` Folder Copy the `TypeFaceTextView.java` and `TypeFaceCache` to `src` folder and `tftv_attrs.xml` to your project's res/values/ folder

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

Added FontCache 


Features
-------
Added Animation Effect Option to TextView
Waiting for user review to remove it or not

Please Give your suggestions

LICENSE
------
The `project` is under MIT LICENSE 

