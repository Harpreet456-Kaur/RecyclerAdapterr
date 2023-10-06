package com.example.recycleradapterr.Model

data class Article(
    var author: String = "",
    var content: String = "",
    var description: String = "",
    var publishedAt: String = "",
    var title: String = "",
    var url: String = "",
    var urlToImage: String = "",
    var source: ArrayList<Source> = ArrayList<Source>()
)