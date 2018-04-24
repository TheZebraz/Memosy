package by.mastihin.memosy

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_mem.view.*

class MemAdapter(var mems: List<Mem>, var onClickListener: OnMemClickListener) : RecyclerView.Adapter<MemAdapter.ViewHolder>(){

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView!!.imageview_mem_image
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mem, parent, false)
        return MemAdapter.ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mems.size
    }

    override fun onBindViewHolder(holder: MemAdapter.ViewHolder, position: Int) {
        val mem: Mem = mems.get(position)
        Glide
                .with(holder.itemView.context)
                .load(mem.image)
                .into(holder.image)
        holder.image.setOnClickListener { onClickListener.onItemClick(mem) }
    }

    public interface OnMemClickListener{
        fun onItemClick(item : Mem)
    }

}