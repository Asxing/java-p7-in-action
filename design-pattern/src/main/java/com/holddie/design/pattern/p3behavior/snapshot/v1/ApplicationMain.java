package com.holddie.design.pattern.p3behavior.snapshot.v1;

import java.util.Scanner;

public class ApplicationMain {
  public static void main(String[] args) {
    InputText inputText = new InputText();
    SnapshotHolder snapshotsHolder = new SnapshotHolder();
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String input = scanner.next();
      if (input.equals(":list")) {
        System.out.println(inputText.getText());
      } else if (input.equals(":undo")) {
        InputText snapshot = snapshotsHolder.popSnapshot();
        inputText.setText(snapshot.getText());
      } else if (input.equals(":quit")) {
        break;
      } else {
        snapshotsHolder.pushSnapshot(inputText);
        inputText.append(input);
      }
    }
  }
}
