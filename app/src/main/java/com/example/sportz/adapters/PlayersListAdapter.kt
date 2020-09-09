package com.example.sportz.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sportz.R
import com.example.sportz.databinding.EachPlayerViewBinding
import com.example.sportz.domain.EachPlayer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.ClassCastException


private val ITEM_VIEW_TYPE_HEADER = 0
private val ITEM_VIEW_TYPE_ITEM = 1

class PlayersListAdapter() : ListAdapter<DataItem, RecyclerView.ViewHolder>(PlayersDiffCallback()) {


    private val adapterScope = CoroutineScope(Dispatchers.Default)
    fun addHeaderAndSubmitList(list: List<EachPlayer>?) {
        adapterScope.launch {

            val items = when (list) {
                null -> listOf(DataItem.Header)
                else -> listOf(DataItem.Header) + list.map { DataItem.EachPlayerItem(it) }

            }

            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_HEADER -> TextViewHolder.from(parent)
            ITEM_VIEW_TYPE_ITEM -> PlayersViewHolder.from(parent)
            else -> throw ClassCastException("Unknowm viewType ${viewType}")

        }

        PlayersViewHolder.from(parent)

    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is DataItem.EachPlayerItem -> ITEM_VIEW_TYPE_ITEM

        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is PlayersViewHolder -> {
                val eachItem = getItem(position) as DataItem.EachPlayerItem
                holder.bind(eachItem.eachPlayer)

            }

        }

    }


}

class PlayersViewHolder(val viewDataBinding: EachPlayerViewBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {

    fun bind(item: EachPlayer) {

        viewDataBinding.property = item
        viewDataBinding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): PlayersViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = EachPlayerViewBinding.inflate(layoutInflater, parent, false)
            return PlayersViewHolder(binding)
        }
    }
}


class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    companion object {
        fun from(parent: ViewGroup): TextViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.header, parent, false)
            return TextViewHolder(view)
        }
    }
}


class PlayersDiffCallback : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem == newItem
    }

}

sealed class DataItem {
    data class EachPlayerItem(val eachPlayer: EachPlayer) : DataItem() {
        override val id: String
            get() = eachPlayer.fullName

    }

    object Header : DataItem() {
        override val id: String
            get() = "1"
    }

    abstract val id: String

}