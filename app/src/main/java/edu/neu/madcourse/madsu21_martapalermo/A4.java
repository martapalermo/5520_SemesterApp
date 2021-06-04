package edu.neu.madcourse.madsu21_martapalermo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class A4 extends AppCompatActivity {

    private ArrayList<ItemCard> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView.LayoutManager rLayoutManager;
    private String urlInput = "";
    private String urlName = "";
    
    private static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
    private static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linkcollector);
        init(savedInstanceState);

        FloatingActionButton fab = findViewById(R.id.fabAdd);
        fab.setOnClickListener(v -> {
            // have onClick prompt dialog
            int pos = 0;
            openAlertDialog(pos);
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper
                .SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                Toast.makeText(A4.this, "Deleted a link", Toast.LENGTH_SHORT).show();
                int position = viewHolder.getLayoutPosition();
                itemList.remove(position);
                recyclerAdapter.notifyItemRemoved(position);
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void openAlertDialog(int position) {
        AlertDialog popUp = new AlertDialog.Builder(A4.this).create();
        popUp.setTitle("Enter new URL:");

        // text user input
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_URI);
        popUp.setView(input);

        // set up buttons
        popUp.setButton(AlertDialog.BUTTON_POSITIVE, "Add", (dialog, which) -> {
            urlInput = input.getText().toString();
            addItem(position);
            Toast.makeText(A4.this, "Added a link", Toast.LENGTH_SHORT).show();
        });

        popUp.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
                (dialog, which) -> dialog.cancel());
        popUp.show();
    }

    public void openURL(String url) {
        Uri link = Uri.parse(url);
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, link);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void addItem(int position) {
        itemList.add(position, new ItemCard(urlInput, urlName, false));
               // + Math.abs(new Random().nextInt(100000)), false));
        recyclerAdapter.notifyItemInserted(position);
    }

    private void init(Bundle savedInstanceState) {
        initialItemData(savedInstanceState);
        createRecyclerView();
    }

    private void createRecyclerView() {
        rLayoutManager = new LinearLayoutManager(this);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerAdapter = new RecyclerAdapter(itemList);
        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                itemList.get(position).onItemClick(position);
                recyclerAdapter.notifyItemChanged(position);
                //openURL(m_Text);
            }

            @Override
            public void onCheckBoxClick(int position) {
                //attributions bond to the item has been changed
                itemList.get(position).onCheckBoxClick(position);
                recyclerAdapter.notifyItemChanged(position);
                //openURL(m_Text);
            }
        };
        recyclerAdapter.setOnItemClickListener(itemClickListener);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(rLayoutManager);
    }

    private void initialItemData(Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.containsKey(NUMBER_OF_ITEMS)) {
            if (itemList == null || itemList.size() == 0) {

                int size = savedInstanceState.getInt(NUMBER_OF_ITEMS);
                for (int i = 0; i < size; i++) {
                    //Integer imgId = savedInstanceState.getInt(KEY_OF_INSTANCE + i + "0");
                    String itemName = savedInstanceState.getString(KEY_OF_INSTANCE + i + "0");
                    String itemDescription = savedInstanceState.getString(KEY_OF_INSTANCE + i + "1");
                    boolean isChecked = savedInstanceState.getBoolean(KEY_OF_INSTANCE + i + "2");

                    if (isChecked) {
                        itemName = itemName.substring(0, itemName.lastIndexOf("("));
                    }
                    ItemCard itemCard = new ItemCard(itemName, itemDescription, isChecked);
                    itemList.add(itemCard);
                }
            }
        }
    }


}

