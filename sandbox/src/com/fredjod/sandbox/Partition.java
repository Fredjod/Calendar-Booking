package com.fredjod.sandbox;
import java.util.*;

public class Partition implements Iterable<Note> {

	private final String nom;
	private final List<Note> notes = new ArrayList<Note>();

	public Partition(String nom, List<Note> notes) {
		this.nom = nom;
		if (notes != null) {
			this.notes.addAll(notes);
		}
	}

	public String getNom() {
		return nom;
	}
	public Iterator<Note> iterator() {
		return notes.iterator();
	}

	public static void main(String[] args) {
		Partition partition = new Partition("Au clair de la lune", Arrays.asList(new Note('C'), new Note('D'), new Note('E'), new Note('C')));
			for(Note note : partition) {
				System.out.println(note.toString());
			}
	}
	
}
