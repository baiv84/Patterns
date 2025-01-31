package com.apollo84.patterns;

import lombok.Getter;

class Note {
    public static final int R100 = 100;
    public static final int R500 = 500;
    public static final int R1000 = 1000;
    public static final int R5000 = 5000;
}

@Getter
class Money {
    private Integer amount;
    public Money(Integer amount) { setAmount(amount); }

    public void setAmount(Integer amount) {
        if (amount > 0 && amount <= 200_000 && amount % Note.R100 == 0) { this.amount = amount; }
        else { throw new RuntimeException("Сумма должна быть МЕНЕЕ 200_000 рублей и КРАТНО 100 рублей"); }
    }

}

abstract class NoteModule {
    protected NoteModule next;
    protected Integer noteNominal;

    public void takeMoney(Money money) {
        int noteCount = money.getAmount() / noteNominal;
        int remindNoteCount = money.getAmount() % noteNominal;

        if (noteCount > 0) {
            System.out.println("Выдано " + noteCount + " купюр номиналом " + noteNominal + " рублей.");
        }
        if (remindNoteCount > 0 && next != null) { next.takeMoney(new Money(remindNoteCount)); }
    }

    public void setNextModule(NoteModule module) { next = module;}
}

class Note5000Module extends NoteModule { Note5000Module() { noteNominal = Note.R5000;} }
class Note1000Module extends NoteModule { Note1000Module() { noteNominal = Note.R1000; } }
class Note500Module extends NoteModule { Note500Module() { noteNominal = Note.R500;} }
class Note100Module extends NoteModule { Note100Module() { noteNominal = Note.R100; } }

public final class ChainResponsibility {
    private static final NoteModule note5000 = new Note5000Module();
    private static final NoteModule note1000 = new Note1000Module();
    private static final NoteModule note500 = new Note500Module();
    private static final NoteModule note100 = new Note100Module();

    public static void demonstrate() {
        System.out.println("\n***********************\nПАТТЕРН - ЦЕПОЧКА ОТВЕТСТВЕННОСТИ\n***********************\n");
        note5000.setNextModule(note1000);
        note1000.setNextModule(note500);
        note500.setNextModule(note100);

        note5000.takeMoney(new Money(23_300));
    }
}
