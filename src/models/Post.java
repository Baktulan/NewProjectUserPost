package models;

public class Post {
    private Long id;
    private String image;
    private String description;

    public Post() {
    }

    public Post(Long id, String image, String description) {
        this.id = id;
        this.image = image;
        this.description = description;
    }

   public Post(String image,String description){
        this.image=image;
        this.description=description;
   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Post: " +
                "id: " + id +"\n"+
                "image: " + image + "\n" +
                "description: " + description + "\n";
    }
}
