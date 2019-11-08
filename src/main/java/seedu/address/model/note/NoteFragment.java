package seedu.address.model.note;

import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a NoteFragment in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class NoteFragment extends Note {
    /**
     * Every field must be present and not null, except for tags.
     */
    public NoteFragment(Title title, Content content, Set<Tag> tags) {
        super(title, content, tags);
    }

    /**
     * Returns true if both note fragments have the same identity and data fields.
     * This defines a stronger notion of equality between two note fragments.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof NoteFragment)) {
            return false;
        }

        NoteFragment otherNote = (NoteFragment) other;
        return otherNote.getTitle().equals(getTitle())
                && otherNote.getContent().equals(getContent())
                && otherNote.getTags().equals(getTags());
    }
}
