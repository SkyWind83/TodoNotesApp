package tr.com.cherrysunshinysky.todonotesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tr.com.cherrysunshinysky.todonotesapp.R
import tr.com.cherrysunshinysky.todonotesapp.clicklistener.ItemClickListener
import tr.com.cherrysunshinysky.todonotesapp.model.Notes

/**
 * Created by Emir U. Özen on 3/13/2021
 * emir.ozen@outlook.com
 */
class NotesAdapter(private var listNotes: List<Notes>,private var itemClickListener: ItemClickListener) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewTitle: TextView = view.findViewById(R.id.tv_title)
        var textViewDescription: TextView = view.findViewById(R.id.tv_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notes_adapter_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notes = listNotes[position]
        val title = notes.title
        val description = notes.description
        holder.textViewTitle.text = title
        holder.textViewDescription.text = description
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(notes)
        }
    }

    override fun getItemCount() = listNotes.size
}