package ir.radindev.Wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import ir.radindev.Wikipedia.data.ItemPost
import ir.radindev.Wikipedia.databinding.ItemTrendBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class TrendAdapter( val data: List <ItemPost>,val itemEvents: ItemEvents) :
    RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {
    lateinit var binding: ItemTrendBinding

    inner class TrendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bidViews(itemPost: ItemPost) {


            binding.txtTrendTitle.text=itemPost.txtTitle
            binding.txtTrendSubtitle.text=itemPost.txtSubTitle
            binding.txtTrendInsight.text=itemPost.insight
            binding.txtTrendNumber.text=(adapterPosition+1).toString()


            Glide.with(itemView.context)
                .load(itemPost.imgUrl)
                .transform(RoundedCornersTransformation(32,8))
                .into(binding.imgTrendMain)

            itemView.setOnClickListener {
                itemEvents.onItemClicked(itemPost)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {
        binding = ItemTrendBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TrendViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
        holder.bidViews(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


}