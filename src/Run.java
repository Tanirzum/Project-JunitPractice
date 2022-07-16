public class Run {
    public String name;
    public Run(String name) {
        this.name = name;
    }

    private String name() {
        return "Tanirbergen";
    }

    private String name(String name) {
        return name;
    }

    public int number(int num) {
        return num + 4;
    }

    public void setName(String name) {
        this.name = name;
    }
}
