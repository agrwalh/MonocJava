package com.assignment.library;



import java.util.*;

class LibraryManager {
	private Set<Book> set = new HashSet<>();
	private Queue<Book> q = new LinkedList<>();

	void add(Book b) {
		if (!set.add(b)) {
			System.out.println("❌ Duplicate Book ID");
		} else {
			System.out.println("✅ Book Added Successfully");
		}
	}

	void show() {
		if (set.isEmpty()) {
			System.out.println("⚠ No books available");
			return;
		}
		System.out.println("\n--- Library Books ---");
		for (Book b : set)
			System.out.println(b);
	}

	void sortTitle() {
		List<Book> list = new ArrayList<>(set);
		Collections.sort(list);
		System.out.println("\n--- Sorted by Title ---");
		for (Book b : list)
			System.out.println(b);
	}

	void sortId() {
		List<Book> list = new ArrayList<>(set);
		list.sort(new SortById());
		System.out.println("\n--- Sorted by ID ---");
		for (Book b : list)
			System.out.println(b);
	}

	void request(int id) {
		for (Book b : set) {
			if (b.getId() == id) {
				q.add(b);
				System.out.println("📌 Added to issue queue");
				return;
			}
		}
		System.out.println("❌ Book not found");
	}

	void process() {
		if (q.isEmpty()) {
			System.out.println("⚠ No pending requests");
			return;
		}
		System.out.println("✅ Issued: " + q.poll());
	}

	void remove(int id) {
		Iterator<Book> it = set.iterator();
		while (it.hasNext()) {
			if (it.next().getId() == id) {
				it.remove();
				System.out.println("🗑 Book Removed");
				return;
			}
		}
		System.out.println("❌ Book not found");
	}
}