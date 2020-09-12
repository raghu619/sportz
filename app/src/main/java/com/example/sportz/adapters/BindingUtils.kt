package com.example.sportz.adapters


import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.sportz.domain.EachPlayer


@BindingAdapter("formattedPlayer")
fun TextView.setSleepDurationFormatted(item: EachPlayer?) {
    item?.let {

        when {

            (item.isCaptain && item.isKeeper) -> text =
                item.fullName + " " + "(keeper" + " + " + "captain)"
            item.isKeeper -> text = item.fullName + " " + "(keeper)"
            item.isCaptain -> text = item.fullName + " " + "(captain)"
            else -> text = item.fullName

        }


    }


}
