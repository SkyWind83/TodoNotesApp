package tr.com.cherrysunshinysky.todonotesapp.clicklistener

import tr.com.cherrysunshinysky.todonotesapp.model.Notes

/**
 * Created by Emir U. Özen on 3/12/21.
 * emir.ozen@outlook.com
 */
interface ItemClickListener {
    fun onClick(notes: Notes)
}