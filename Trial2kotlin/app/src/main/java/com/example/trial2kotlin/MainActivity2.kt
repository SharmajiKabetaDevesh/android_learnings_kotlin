package com.example.trial2kotlin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main2.webView


import com.example.trial2kotlin.R.layout.activity_main2 as activity_main21

class MainActivity2 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(/* layoutResID = */ activity_main21)

//        val arrContact=ArrayList<ContactModel>()
//
//        arrContact.add(ContactModel(R.drawable.i1,"A","7738874661"))
//        arrContact.add(ContactModel(R.drawable.i2,"b","7738874661"))
//        arrContact.add(ContactModel(R.drawable.i3,"c","7738874661"))
//        arrContact.add(ContactModel(R.drawable.i4,"d","7738874661"))
//        arrContact.add(ContactModel(R.drawable.i5,"e","7738874661"))
//        arrContact.add(ContactModel(R.drawable.i6,"f","7738874661"))
//        arrContact.add(ContactModel(R.drawable.i7,"g","7738874661"))
//        arrContact.add(ContactModel(R.drawable.i8,"h","7738874661"))
//        arrContact.add(ContactModel(R.drawable.i9,"i","7738874661"))
//        arrContact.add(ContactModel(R.drawable.i10,"j","7738874661"))
//
//        recyclerView.LayoutManager=GridLayoutManager(this,2);



        webViewSetup(webView)




    }

    private fun webViewSetup(webView: WebView) {
        webView.webViewClient = WebViewClient()

        webView.apply {
            settings.javaScriptEnabled = true

            // Check if the current Android version is Oreo or higher
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // Check if the method is available before calling it
                if (settings.safeBrowsingEnabled) {
                    settings.safeBrowsingEnabled = true
                }
            }

            loadUrl("https://github.com/SharmajiKabetaDevesh/android_learnings_kotlin")
        }
    }

}