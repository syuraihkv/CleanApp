package com.example.cleaningapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class AdapterMenu (private  val lstMenu:List<MenuModel>):RecyclerView.Adapter<AdapterMenu.ViewHolder>(){
    inner class ViewHolder(v: View):RecyclerView.ViewHolder(v){
        val imgFotoMenu: ImageView
        val txtNamaMenu: TextView
        val context : v.context;

        init {
            imgFotoMenu = v.findViewById(R.id.imageViewMenu)
            txtNamaMenu = v.findViewById(R.id.textViewNamaMenu)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = LayoutInflater.inflate(R.id.card_display_menu, parent, false)

        return MenuViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val  modelMenu = lstMenu[position]
        holder.imgFotoMenu.setImageResource(modelMenu.gambar)
        holder.txtNamaMenu.text = modelMenu.namaMenu
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }
}