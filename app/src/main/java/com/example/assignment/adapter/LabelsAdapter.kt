package com.example.assignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.databinding.ItemsListBinding
import com.example.assignment.models.LabelData

class LabelsAdapter() :
    RecyclerView.Adapter<LabelsAdapter.ItemViewHolder>(), Filterable {

    var filteredListData: MutableList<LabelData?> = emptyList<LabelData>().toMutableList()
    private var list: MutableList<LabelData?> = emptyList<LabelData>().toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemBinding =
            ItemsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val category: LabelData = filteredListData[position]!!
        holder.bind(category)
    }

    fun setData(newList: List<LabelData?>) {
        list.clear()
        list.addAll(newList)
        filteredListData.clear()
        filteredListData.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = filteredListData.size

    inner class ItemViewHolder(private val itemBinding: ItemsListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(itemData: LabelData) {
            itemBinding.textLabel.text = itemData.name
            itemBinding.imageView.setImageResource(itemData.image)
        }

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint?.toString() ?: ""
                filteredListData = if (charString.isEmpty()) list else {
                    var filteredList = emptyList<LabelData?>().toMutableList()
                    list
                        .filter {
                            (it?.name?.contains(constraint!!,true) == true)

                        }
                        .forEach { it?.let { it1 -> filteredList.add(it1) } }
                    filteredList

                }
                return FilterResults().apply { values = filteredListData }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                filteredListData = if (results?.values == null)
                    ArrayList()
                else
                    results.values as MutableList<LabelData?>
                notifyDataSetChanged()
            }
        }
    }

    fun shuffleData(){
        filteredListData.shuffle()
        notifyDataSetChanged()
    }

}