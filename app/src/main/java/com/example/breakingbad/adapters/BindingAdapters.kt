package com.example.breakingbad.adapters

import com.example.breakingbad.Character
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbad.R
import com.squareup.picasso.Picasso

@BindingAdapter("image")
fun bindImage(imageView: ImageView, url: String?) {
    url?.let {
        Picasso.get().load(url).placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .into(imageView)
    }
}

@BindingAdapter("data")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Character>?) {
    val adapter = recyclerView.adapter as CharactersAdapter
    adapter.submitList(data)
}