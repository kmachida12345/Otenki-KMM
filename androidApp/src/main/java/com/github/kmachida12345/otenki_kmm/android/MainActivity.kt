package com.github.kmachida12345.otenki_kmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.kmachida12345.otenki_kmm.Greeting
import android.widget.TextView
import com.github.kmachida12345.otenki_kmm.MyFirebaseFirestoreClient
import com.github.kmachida12345.otenki_kmm.MyHttpClient
import com.github.kmachida12345.otenki_kmm.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun greet(): String {
    return Greeting().greeting()
}
suspend fun get(): String {
    return MyHttpClient().get().toString()
}

suspend fun postFirebase() {
    return MyFirebaseFirestoreClient().putValue(Post(System.currentTimeMillis().toDouble()))
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()

        GlobalScope.launch(Dispatchers.IO) {
            get()
            postFirebase()
        }
    }
}
