package com.github.kmachida12345.otenki_kmm

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore

class MyFirebaseFirestoreClient {

    suspend fun putValue(post: Post) {
        val firestore = Firebase.firestore

        firestore.collection("hoge").add(post, true)

    }
}