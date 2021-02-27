package tr.com.cherrysunshinysky.todonotesapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tr.com.cherrysunshinysky.todonotesapp.R;
import tr.com.cherrysunshinysky.todonotesapp.model.Notes;

/**
 * Created by Emir U. Özen on 2/27/2021.
 * emir.ozen@outlook.com
 */
public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    List<Notes> listNotes;

    public NotesAdapter(List<Notes> list) {
        this.listNotes = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_adapter_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.ViewHolder holder, int position) {
        Notes notes = listNotes.get(position);
        String description = notes.getDescription();
        String title = notes.getTitle();

        holder.textViewTitle.setText(title);
        holder.textViewDescription.setText(description);
    }

    @Override
    public int getItemCount() {
        return listNotes.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.tv_title);
            textViewDescription = itemView.findViewById(R.id.tv_description);
        }
    }
}
