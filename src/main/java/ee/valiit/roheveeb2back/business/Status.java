package ee.valiit.roheveeb2back.business;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("A"),
    PENDING("P"),
    DELETED("D");



    private final String letter;

    Status(String letter) { this.letter = letter;}

}
