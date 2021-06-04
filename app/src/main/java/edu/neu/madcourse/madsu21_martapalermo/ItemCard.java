package edu.neu.madcourse.madsu21_martapalermo;

import android.content.Intent;
import android.net.Uri;

public class ItemCard implements ItemClickListener {

    private int imageSrc;
    private String itemName;
    private String itemDescription;
    private boolean checkedStatus;

    // constructor for item card --> what every added link item will look like
    public ItemCard(String itemName, String itemDescription, boolean checkedStatus) {
        //this.imageSrc = imageSrc;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.checkedStatus = checkedStatus;
    }

    public int getImageSource() {
        return imageSrc;
    }

    public String getItemName() {
        return itemName;  //);
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public boolean isChecked() {
        return checkedStatus;
    }

    public void openURL(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
    }

    @Override
    public void onItemClick(int position) {
        checkedStatus = !checkedStatus;
        //openURL(url);

    }

    @Override
    public void onCheckBoxClick(int position) {
        checkedStatus = !checkedStatus;
    }
}
