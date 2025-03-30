public class Image {
    int imageID;
    int productID;
    String imageData;
    String imageUrl;

    public Image(int imgID, int prodID, String imgData, String imgURL){
        this.productID=prodID;
        this.imageData=imgData;
        this.imageID=imgID;
        this.imageUrl=imgURL;
    }

    public int getImageID(){
        return this.imageID;
    }
    public int getProductID(){
        return this.productID;
    }
    public String getImageData(){
        return this.imageData;
    }
    public String getImageURL(){
        return this.imageUrl;
    }
}
