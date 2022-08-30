package com.android.articles

import android.widget.TextView
import androidx.databinding.BindingAdapter


@BindingAdapter("updated")
fun setDate(v: TextView, date: String){
    v.text = date.split(" ")[0]
}
@BindingAdapter("byLine")
fun setAuthor(v: TextView, line: String){
    if(line.length<10)
        v.text = line.substring(0,20)
    else
        v.text = line
}