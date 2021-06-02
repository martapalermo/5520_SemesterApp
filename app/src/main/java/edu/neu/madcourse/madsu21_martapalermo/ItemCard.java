package edu.neu.madcourse.madsu21_martapalermo;

public class ItemCard implements ItemClickListener {

    private final int imageSrc;
    private final String itemName;
    private final String itemDescription;
    private boolean checkedStatus;

    // constructor for item card --> what every added link item will look like
    public ItemCard(int imageSrc, String itemName, String itemDescription, boolean checkedStatus) {
        this.imageSrc = imageSrc;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.checkedStatus = checkedStatus;
    }

    public int getImageSource() {
        return imageSrc;
    }

    public String getItemName() {
        return itemName + (checkedStatus ? "(checked)" : "");
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public boolean isChecked() {
        return checkedStatus;
    }


    @Override
    public void onItemClick(int position) {
        checkedStatus = !checkedStatus;
    }

    @Override
    public void onCheckBoxClick(int position) {
        checkedStatus = !checkedStatus;
    }
}
