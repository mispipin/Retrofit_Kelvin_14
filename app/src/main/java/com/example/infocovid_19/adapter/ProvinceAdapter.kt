package com.example.infocovid_19.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.infocovid_19.R
import com.example.infocovid_19.adapter.ProvinceAdapter.ProvinceViewHolder
import com.example.infocovid_19.model.ProvinceResponse
import kotlinx.android.synthetic.main.item_province.view.*

class ProvinceAdapter(private var list: ArrayList<ProvinceResponse>): RecyclerView.Adapter<ProvinceViewHolder>(){
    inner class ProvinceViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(province:ProvinceResponse){
            with(itemView){

                tvName.text= province.atributes.Province
                tvPositive.text=province.atributes.positive.toString()
                tvRecover.text=province.atributes.recover.toString()
                tvDeath.text=province.atributes.death.toString()
            }
        }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_province, parent, false)
        return ProvinceViewHolder(view)    }

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}