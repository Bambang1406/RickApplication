package com.example.rickapplication

import android.location.Geocoder.GeocodeListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import javax.microedition.khronos.opengles.GL

class RickAdapter(val dataRick: List<ResultsItem>): RecyclerView.Adapter<RickAdapter.MyviewHolder>(){
    class MyviewHolder (view: View): RecyclerView.ViewHolder(view){
        val imgRick = view.findViewById<ImageView>(R.id.item_image_Rick)
        val nameRick = view.findViewById<TextView>(R.id.item_name_rick)
        val statusRick = view.findViewById<TextView>(R.id.item_status_rick)
        val speciesRick = view.findViewById<TextView>(R.id.item_species_rick)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return MyviewHolder(view)

    }

    override fun getItemCount(): Int {
        if (dataRick != null){
            return dataRick.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.nameRick.text = dataRick?.get(position)?.name
        holder.statusRick.text = dataRick?.get(position)?.status
        holder.speciesRick.text = dataRick?.get(position)?.species

        Glide.with(holder.imgRick)
            .load(dataRick?.get(position)?.image)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgRick)

        holder.itemView.setOnClickListener{
            val name = dataRick?.get(position)?.name
            Toast.makeText(holder.itemView.context, "${name}", Toast.LENGTH_SHORT).show()
        }
    }

}