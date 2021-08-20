package io.github.emvnuel.explanaapp.model;

public enum JobLevel {

    INTERN("Intern/Trainee"),
    JUNIOR("Junior"),
    MIDDLE("Mid-level"),
    SENIOR("Senior"),
    LEAD("Lead/Architect");

    private final String description;

    JobLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
