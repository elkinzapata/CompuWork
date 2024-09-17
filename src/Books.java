public class Books {
    // Atributos
    private String title;
    private String author;
    private String isbn;



    // Constructor
    public Books(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Métodos
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
