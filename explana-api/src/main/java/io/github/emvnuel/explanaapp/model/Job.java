package io.github.emvnuel.explanaapp.model;

public enum Job {

    DEVELOPER("Developer"),
    QA("Tester/QA"),
    DEVOPS("DevOps/SRE/Infra"),
    DESIGNER("UX/UI Designer"),
    DBA("Database administrator"),
    DATA_SCIENTIST("Data Scientist/Data engineer"),
    SCRUM_MASTER("Agile Coach/Scrum Master");

    private final String description;

    Job(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
