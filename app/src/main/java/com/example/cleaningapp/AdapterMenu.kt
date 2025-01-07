package com.example.cleaningapp


import android.graphics.Bitmap
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.RecyclerView


class AdapterMenu(private val list: ArrayList<MenuModel>) : RecyclerView.Adapter<AdapterMenu.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val imgFotoMenu: ImageView = v.findViewById(R.id.gambar)
        val txtNamaMenu: TextView = v.findViewById(R.id.namaMenu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.card_layout_beranda, parent, false)
        return ViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelMenu = list[position]
        holder.imgFotoMenu.setImageResource(modelMenu.gambar)
        holder.txtNamaMenu.text = modelMenu.namaMenu
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
