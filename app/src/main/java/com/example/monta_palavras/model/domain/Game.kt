package com.example.monta_palavras.model.domain

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.example.monta_palavras.delegates.bindable

class Game(
    name: String,
    val launchYear: Int,
    val imageUrl: String = "URL_IMAGEM_DEFAULT"
) : BaseObservable() {

    @get:Bindable
    var name by bindable(name, BR.name)
}