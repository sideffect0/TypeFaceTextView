TypeFaceTextView
================

Custom TextView For Android

Setup Instructions
------------------

1.From `TypeFaceTextView` Folder copy the `TextView` and Copy `tftv_attrs.xml` to your project's res/values/ folder
2.Add 
   (i) xmlns:app="http://schemas.android.com/apk/res/com.nubicz.typefacetextview" to root layout 
   (ii) add path to font fron assets folder to typeface attribute

    Example :
  <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res/com.nubicz.typefacetextview">
 
      <com.nubicz.customviews.TypeFaceTextView 
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello"
        android:textSize="40sp"
        android:layout_centerInParent="true"
        app:typeface="fonts/myfont.ttf"/>

   </RelativeLayout>

   an Example Project Also Included You Can Check it Out ... :)
