package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;

import seedu.address.model.cheatsheet.CheatSheet;
import seedu.address.model.cheatsheet.UniqueCheatSheetList;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.UniqueFlashcardList;
import seedu.address.model.note.Note;
import seedu.address.model.note.UniqueNoteList;
import seedu.address.model.person.Person;
import seedu.address.model.person.UniquePersonList;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.UniqueTagList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSamePerson comparison)
 */
public class StudyBuddyPro implements ReadOnlyStudyBuddyPro {

    private final UniquePersonList persons;

    private final UniqueCheatSheetList cheatSheets;

    private final UniqueFlashcardList flashcards;

    private final UniqueNoteList notes;

    private final UniqueTagList tags;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        persons = new UniquePersonList();

        flashcards = new UniqueFlashcardList();

        notes = new UniqueNoteList();

        cheatSheets = new UniqueCheatSheetList();

        tags = new UniqueTagList();
    }

    public StudyBuddyPro() {}

    /**
     * Creates an AddressBook using the Persons in the {@code toBeCopied}
     */
    public StudyBuddyPro(ReadOnlyStudyBuddyPro toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyStudyBuddyPro newData) {
        requireNonNull(newData);

        setPersons(newData.getPersonList());
        setNotes(newData.getNoteList());
        setFlashcards(newData.getFlashcardList());
        setCheatSheets(newData.getCheatSheetList());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof StudyBuddyPro // instanceof handles nulls
                && persons.equals(((StudyBuddyPro) other).persons));
    }

    @Override
    public String toString() {
        return persons.asUnmodifiableObservableList().size() + " persons";
        // TODO: refine later
    }

    @Override
    public int hashCode() {
        return persons.hashCode();
    }

    //=============================Tag tools====================================================
    @Override
    public ObservableList<Tag> getTagList() {
        return tags.asUnmodifiableObservableList();
    }

    //=============================Person tools====================================================

    /**
     * Replaces the contents of the person list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setPersons(List<Person> persons) {
        this.persons.setPersons(persons);
    }


    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean hasPerson(Person person) {
        requireNonNull(person);
        return persons.contains(person);
    }

    /**
     * Adds a person to the address book.
     * The person must not already exist in the address book.
     */
    public void addPerson(Person p) {
        persons.add(p);
    }

    /**
     * Replaces the given person {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    public void setPerson(Person target, Person editedPerson) {
        requireNonNull(editedPerson);

        persons.setPerson(target, editedPerson);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removePerson(Person key) {
        persons.remove(key);
    }

    @Override
    public ObservableList<Person> getPersonList() {
        return persons.asUnmodifiableObservableList();
    }

    //=============================Flashcard tools====================================================

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removeFlashcard(Flashcard key) {
        flashcards.remove(key);
    }

    /**
     * Returns true if a flashcard with the same identity as {@code flashcard} exists in the application.
     */
    public boolean hasFlashcard(Flashcard flashcard) {
        requireNonNull(flashcard);
        return flashcards.contains(flashcard);
    }

    /**
     * Adds a flashcard to the application.
     * The flashcard must not already exist in the application.
     */
    public void addFlashcard(Flashcard f) {
        flashcards.add(f);
    }

    public ObservableList<Flashcard> getFlashcardList() {
        return flashcards.asUnmodifiableObservableList();
    }

    /**
     * Replaces the contents of the flashcards list with {@code flashcards}.
     * {@code flashcards} must not contain duplicate flashcards.
     */
    public void setFlashcards(List<Flashcard> flashcards) {
        this.flashcards.setFlashcards(flashcards);
    }

    /**
     * Replaces the given flashcard {@code target} in the list with {@code editedFlashcard}.
     * {@code target} must exist in the address book.
     * The flashcard identity of {@code editedFlashcard} must not be the same as another existing flashcard in the
     * address book.
     */
    public void setFlashcard(Flashcard target, Flashcard editedFlashcard) {
        requireNonNull(editedFlashcard);

        flashcards.setFlashcard(target, editedFlashcard);
    }

    //=============================Note tools====================================================

    /**
     * Returns true if a note with the same identity as {@code note} exists in the address book.
     */
    public boolean hasNote(Note note) {
        requireNonNull(note);
        return notes.contains(note);
    }

    /**
     * Adds a note to the address book.
     * The note must not already exist in the address book.
     */
    public void addNote(Note note) {
        notes.add(note);
    }

    /**
     * Replaces the given note {@code target} in the list with {@code editedNote}.
     * {@code target} must exist in the address book.
     * The note identity of {@code editedNote} must not be the same as another existing note in the address book.
     */
    public void setNote(Note target, Note editedNote) {
        requireNonNull(editedNote);

        notes.setNote(target, editedNote);
    }

    /**
     * Replaces the contents of the note list with {@code notes}.
     * {@code notes} must not contain duplicate notes.
     */
    public void setNotes(List<Note> notes) {
        this.notes.setNotes(notes);
    }


    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removeNote(Note key) {
        notes.remove(key);
    }
    //// util methods

    @Override
    public ObservableList<Note> getNoteList() {
        return notes.asUnmodifiableObservableList();
    }

    //=============================CheatSheet tools====================================================

    /**
     * Adds a cheatSheet to the cheatSheet book.
     * The cheatSheet must not already exist in the cheatSheet book.
     */
    public void addCheatSheet(CheatSheet cs) {
        cheatSheets.add(cs);
    }

    /**
     * Deletes a cheatSheet to the cheatSheet book.
     * The cheatSheet must already exist in the cheatSheet book.
     */
    public void deleteCheatSheet(CheatSheet cs) {
        cheatSheets.remove(cs);
    }

    /**
     * Checks if the list of cheatsheets contains this cheatsheet
     * @param cheatSheet
     * @return
     */
    public boolean hasCheatSheet(CheatSheet cheatSheet) {
        requireNonNull(cheatSheet);
        return cheatSheets.contains(cheatSheet);
    }

    /**
     * Replaces the contents of the cheatsheet list with {@code cheatsheets}.
     * {@code cheatsheets} must not contain duplicate cheatsheets.
     */
    public void setCheatSheets(List<CheatSheet> cheatsheets) {
        this.cheatSheets.setCheatSheets(cheatsheets);
    }

    /**
     * Replaces the given cheatsheet {@code target} in the list with {@code editedCheatSheet}.
     * {@code target} must exist in the StudyBuddy application.
     * The cheatsheet identity of {@code editedCheatSheet}
     * must not be the same as another existing cheatsheet in the StudyBuddy application.
     */
    public void setCheatSheet(CheatSheet target, CheatSheet editedCheatSheet) {
        requireNonNull(editedCheatSheet);

        cheatSheets.setCheatSheet(target, editedCheatSheet);
    }

    @Override
    public ObservableList<CheatSheet> getCheatSheetList() {
        return cheatSheets.asUnmodifiableObservableList();
    }
}