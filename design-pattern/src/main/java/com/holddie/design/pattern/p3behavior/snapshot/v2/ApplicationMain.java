package com.holddie.design.pattern.p3behavior.snapshot.v2;

import java.util.Scanner;

public class ApplicationMain {
	public static void main(String[] args) {
		InputText inputText = new InputText();
		SnapshotHolder snapshotsHolder = new SnapshotHolder();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String input = scanner.next();
			if (input.equals(":list")) {
				System.out.println(inputText.toString());
			} else if (input.equals(":undo")) {
				Snapshot snapshot = snapshotsHolder.popSnapshot();
				inputText.restoreSnapshot(snapshot);
			} else {
				

				snapshotsHolder.pushSnapshot(inputText.createSnapshot());
				inputText.append(input);
			}
		}
	}
}
