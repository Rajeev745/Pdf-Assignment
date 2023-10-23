package com.example.pdf_assignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pdf_assignment.databinding.RecyclerViewItemBinding
import com.example.pdf_assignment.model.PdfModel

class PdfRecyclerViewAdapter :
    RecyclerView.Adapter<PdfRecyclerViewAdapter.ViewHolder>() {

    var pdfItemClickListener: PdfItemClickListener? = null

    inner class ViewHolder(private val binding: RecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pdfModel: PdfModel) {

            binding.apply {

                recyclerViewPdfImage.setImageDrawable(pdfModel.image)
                pdfStatusText.text = pdfModel.status

                if (pdfModel.price > 1000) {
                    buttonShowmore.visibility = View.VISIBLE
                    moreBooksText.visibility = View.VISIBLE
                    blurView.visibility = View.VISIBLE
                    return
                }

                recyclerViewPdfImage.setOnClickListener {
                    pdfItemClickListener?.pdfItemOnClickListener(pdfModel, adapterPosition)
                }
            }
        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<PdfModel>() {
        override fun areItemsTheSame(oldItem: PdfModel, newItem: PdfModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PdfModel, newItem: PdfModel): Boolean {
            return oldItem == newItem
        }
    }

    fun submitList(newList: List<PdfModel>) {
        differ.submitList(newList)
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecyclerViewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pdf = differ.currentList[position]
        holder.bind(pdf)

        holder.itemView.setOnClickListener {
            onClick?.invoke(pdf)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    var onClick: ((PdfModel) -> Unit)? = null

    fun setOnItemClickListener(listener: PdfItemClickListener) {
        pdfItemClickListener = listener
    }

}