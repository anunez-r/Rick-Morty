package es.anr.rickmorty.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import es.anr.rickmorty.R
import es.anr.rickmorty.model.Character

class CharacterAdapter(context: Context, resource: Int, objects: List<Character>) :
    ArrayAdapter<Character>(context, resource, objects) {

        var resource:Int
        var objects:ArrayList<Character>
        var inflater:LayoutInflater

        init {
            this.resource = resource
            this.objects = ArrayList(objects)
            this.inflater = LayoutInflater.from(context)
        }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder:ViewHolder
        var view: View? = convertView
        val character = objects.get(position)

        if(convertView == null) {
            view = inflater.inflate(resource, null)

            viewHolder = ViewHolder()

            viewHolder.name = view.findViewById(R.id.lblName) as TextView
            viewHolder.status = view.findViewById(R.id.lblStatus) as TextView
            viewHolder.image = view.findViewById(R.id.imgPicture) as ImageView


            view.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
            view = convertView
        }

        viewHolder.name!!.text=character.name
        viewHolder.status!!.text=character.status

        Picasso.get().load(character.image).into(viewHolder.image)


        return view!!
    }

    class ViewHolder {
        var name: TextView? = null
        var status: TextView? = null
        var image: ImageView? = null
    }
}