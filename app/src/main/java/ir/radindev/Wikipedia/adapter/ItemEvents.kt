package ir.radindev.Wikipedia.adapter

import ir.radindev.Wikipedia.data.ItemPost

interface ItemEvents {

    fun onItemClicked(itemPost: ItemPost)
}