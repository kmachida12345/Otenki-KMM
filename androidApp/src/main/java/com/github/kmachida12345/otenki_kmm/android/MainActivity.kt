package com.github.kmachida12345.otenki_kmm.android

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.github.kmachida12345.otenki_kmm.*
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

fun storePost(context: Context) {
    val driver = DatabaseDriverFactory(context).createDriver()
    val database = MyAppDatabase(driver)
    database.myAppDatabaseQueries.insertPost(System.currentTimeMillis())

    val allPosts = database.myAppDatabaseQueries.getAllPosts().executeAsList()

    Log.d("hoge", "storePost: $allPosts")
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
        storePost(this)

    }
}
